#!/usr/bin/env node
/**
 * protocol-probe.js — Strumento CLI per validare il protocollo Miura Tervis
 *
 * Dipendenze: solo moduli nativi Node.js (net, process)
 *
 * Uso:
 *   node protocol-probe.js --mode handshake [--enc plain|encrypted|auto]
 *   node protocol-probe.js --mode listen
 *   node protocol-probe.js --mode send --cmd status
 *
 * Opzioni:
 *   --host <ip>                default: env MIURA_HOST (obbligatorio)
 *   --port <n>                 default: 5400
 *   --code <pin>               default: env MIURA_CODE (obbligatorio se env assente)
 *   --mode handshake|listen|send
 *   --enc  plain|encrypted|auto   (default: auto; rilevante per handshake e send)
 *   --cmd  login|status|zones|arm|disarm|keepalive|sysinfo  (per --mode send)
 *   --group <n>                gruppo 0-15 per arm/disarm (default: 0)
 *   --debug                    logga raw hex sia in TX che in RX
 */

'use strict';

const net = require('net');

// ═══════════════════════════════════════════════════════════════════════════════
// SEZIONE 1 — ARGOMENTI CLI
// ═══════════════════════════════════════════════════════════════════════════════

const argv = process.argv.slice(2);

function arg(name, fallback) {
  const i = argv.indexOf(name);
  return (i !== -1 && argv[i + 1] !== undefined) ? argv[i + 1] : fallback;
}
function flag(name) { return argv.includes(name); }

const HOST  = arg('--host', process.env.MIURA_HOST || '');
const PORT  = parseInt(arg('--port', process.env.MIURA_PORT || '5400'), 10);
const CODE  = arg('--code', process.env.MIURA_PIN  || '');
const MODE  = arg('--mode', 'handshake');
const ENC   = arg('--enc',  'auto');          // plain | encrypted | auto
const CMD   = arg('--cmd',  'status');        // per --mode send
const GROUP = parseInt(arg('--group', '0'), 10);
const DEBUG = flag('--debug');

if (!HOST) {
  console.error('Errore: --host <ip> è obbligatorio (o impostare MIURA_HOST nell\'env).');
  process.exit(1);
}
if (!CODE) {
  console.error('Errore: --code <pin> è obbligatorio (o impostare MIURA_PIN nell\'env).');
  process.exit(1);
}

// ═══════════════════════════════════════════════════════════════════════════════
// SEZIONE 2 — CRC-16/MODBUS  (poly 0x8005 riflesso = 0xA001, init 0xFFFF)
//
// L'algoritmo è ricavato da j0/j.java metodo b(byte[]).
// L'ordine dei byte CRC nel frame è BIG-ENDIAN: byte alto prima, byte basso dopo.
// Questo segue fedelmente Y/b.java metodo a():
//   f581a.write((0xFF00 & crc) >>> 8)  ← byte alto
//   f581a.write(crc & 0xFF)            ← byte basso
//
// TODO-VALIDATE: verificare con traffico reale che il server accetti questo ordine.
// Se nessuna risposta arriva, provare LITTLE-ENDIAN (invertire i due byte CRC).
// ═══════════════════════════════════════════════════════════════════════════════

function crc16modbus(buf) {
  let crc = 0xFFFF;
  for (let i = 0; i < buf.length; i++) {
    crc ^= buf[i] & 0xFF;
    for (let b = 0; b < 8; b++) {
      const lsb = crc & 1;
      crc >>>= 1;
      if (lsb) crc ^= 0xA001;
    }
  }
  return crc & 0xFFFF;
}

// ═══════════════════════════════════════════════════════════════════════════════
// SEZIONE 3 — COSTRUZIONE FRAME IN USCITA
//
// Wire format:
//   [2B 2A 2B] [LEN:1] [F1:1] [ENC_KEY:1] [CMD:1] [DATA...] [CRC_HI:1] [CRC_LO:1]
//
// Per i messaggi con SUB byte (la maggioranza), DATA inizia con [SUB].
// Il messaggio h0.a (confirm login) è speciale: nessun SUB, solo [CMD].
//
// Cifratura (Y/b.java metodo j()):
//   1. Costruisci payload non cifrato: [F1][0x00][CMD][DATA...][CRC_HI][CRC_LO]
//   2. Scegli enc_key casuale (1..255)
//   3. payload[0] ^= enc_key
//   4. payload[1]  = enc_key  (NON cifrato, è la chiave stessa)
//   5. payload[i] ^= enc_key  per i >= 2
// ═══════════════════════════════════════════════════════════════════════════════

const MAGIC = Buffer.from([0x2B, 0x2A, 0x2B]);

/**
 * Costruisce il payload (senza magic e LEN) e applica opzionalmente la cifratura.
 * @param {number[]} body  - [0xF1, 0x00, CMD, ...] senza CRC (enc_key placeholder = 0)
 * @param {boolean}  encrypt
 * @returns {Buffer} payload completo con CRC
 */
function buildPayload(body, encrypt) {
  // CRC calcolato sul body non cifrato (prima di XOR) — cfr. k() chiama a() dopo i()
  const bodyBuf = Buffer.from(body);
  const crc     = crc16modbus(bodyBuf);

  // Aggiungi CRC big-endian: HIGH byte prima, LOW dopo (cfr. a() in Y/b.java)
  const full = Buffer.concat([bodyBuf, Buffer.from([(crc >> 8) & 0xFF, crc & 0xFF])]);

  if (!encrypt) return full;

  // Cifratura XOR in-place
  const out    = Buffer.from(full);
  const encKey = (Math.floor(Math.random() * 255) + 1) & 0xFF; // 1..255
  out[0] ^= encKey;
  out[1]  = encKey;                       // scrivi chiave (non viene XORata)
  for (let i = 2; i < out.length; i++) out[i] ^= encKey;
  return out;
}

/** Costruisce il wire frame completo: MAGIC + LEN + payload */
function buildFrame(body, encrypt) {
  const payload = buildPayload(body, encrypt);
  return Buffer.concat([MAGIC, Buffer.from([payload.length]), payload]);
}

// ─── Messaggi specifici ───────────────────────────────────────────────────────

/**
 * Login request (h0.b):  [F1][enc][01][00][00][PIN_ASCII...][00][CRC×2]
 * La struttura è: CMD=0x01, byte=0x00, PIN bytes, byte=0x00
 * (sub-command implicito 0x00 come secondo byte dati in h0.b.i() via h0.d.i())
 */
function frameLogin(pin, encrypt) {
  const pinBytes = Buffer.from(pin, 'ascii');
  return buildFrame([0xF1, 0x00, 0x01, 0x00, ...pinBytes, 0x00], encrypt);
}

/**
 * Confirm login (h0.a):  [F1][enc][01][CRC×2]
 * Messaggio minimo: solo CMD=0x01, nessun SUB né dati (cfr. h0.a.i() → super.i() solo)
 */
function frameConfirm(encrypt) {
  return buildFrame([0xF1, 0x00, 0x01], encrypt);
}

/** Keep-alive (h0.f): CMD=0x01, SUB=0x02 */
function frameKeepalive(encrypt) {
  return buildFrame([0xF1, 0x00, 0x01, 0x02], encrypt);
}

/** Group status request (Z.i): CMD=0x06, SUB=0x02 */
function frameGroupStatus(encrypt) {
  return buildFrame([0xF1, 0x00, 0x06, 0x02], encrypt);
}

/**
 * Arm/Disarm (Z.a): CMD=0x06, SUB=0x01, groupMask LE16, action
 * action: 0x00 = arm, 0x01 = disarm
 */
function frameActivation(groupId, arm, encrypt) {
  const mask = (1 << groupId) & 0xFFFF;
  const action = arm ? 0x00 : 0x01;
  return buildFrame([0xF1, 0x00, 0x06, 0x01, mask & 0xFF, (mask >> 8) & 0xFF, action], encrypt);
}

/** Zone info request (i0.c): CMD=0x07, SUB=0x01, type, zoneStart, blockSize */
function frameZoneInfo(zoneStart, blockSize, last, encrypt) {
  const type = last ? 0x01 : 0x0F;
  return buildFrame([0xF1, 0x00, 0x07, 0x01, type, zoneStart & 0xFF, blockSize & 0xFF], encrypt);
}

/** Standby/system info request (e0.b): CMD=0x0F, SUB=0x01 */
function frameSysInfo(encrypt) {
  return buildFrame([0xF1, 0x00, 0x0F, 0x01], encrypt);
}

// ═══════════════════════════════════════════════════════════════════════════════
// SEZIONE 4 — DECIFRATURA E PARSING FRAME IN INGRESSO
// ═══════════════════════════════════════════════════════════════════════════════

/**
 * Decifra un payload in ingresso se enc_key != 0.
 * Cfr. Y/b.java metodo statico c(byte[]):
 *   payload[0] ^= key
 *   payload[1] rimane invariato (è la chiave)
 *   payload[i] ^= key per i >= 2
 */
function decryptPayload(payload) {
  const key = payload[1];
  if (key === 0) return Buffer.from(payload);
  const out = Buffer.from(payload);
  out[0] ^= key;
  for (let i = 2; i < out.length; i++) out[i] ^= key;
  return out;
}

/**
 * Valida il CRC e decodifica i campi del payload (già decifrato).
 * Ritorna { encrypted, encKey, cmd, sub, data, crcOk, crcCalc, crcRx }
 *
 * CRC atteso BIG-ENDIAN: payload[n-2] = HIGH, payload[n-1] = LOW
 * TODO-VALIDATE: se crcOk è sempre false, provare lettura LITTLE-ENDIAN
 *   (invertire: crcRx = (payload[n-1] << 8) | payload[n-2])
 */
function parsePayload(rawPayload) {
  const dec      = decryptPayload(rawPayload);
  const n        = dec.length;
  const encKey   = rawPayload[1];
  const cmd      = dec[2];
  const sub      = n > 3 ? dec[3] : null;
  const data     = n > 4 ? dec.slice(4, n - 2) : Buffer.alloc(0);

  const crcCalc  = crc16modbus(dec.slice(0, n - 2));
  const crcRxBE  = ((dec[n - 2] & 0xFF) << 8) | (dec[n - 1] & 0xFF);  // big-endian
  const crcRxLE  = (dec[n - 2] & 0xFF) | ((dec[n - 1] & 0xFF) << 8);  // little-endian (alternate)
  const crcOk    = crcCalc === crcRxBE;
  const crcOkLE  = crcCalc === crcRxLE;

  return { encrypted: encKey !== 0, encKey, cmd, sub, data, crcOk, crcOkLE, crcCalc, crcRxBE, crcRxLE };
}

// ═══════════════════════════════════════════════════════════════════════════════
// SEZIONE 5 — RIASSEMBLAGGIO STREAM TCP E LOGGING
// ═══════════════════════════════════════════════════════════════════════════════

const CMD_NAMES = {
  0x01: 'AUTH',    0x03: 'TEXTS',   0x04: 'LOG_EVENTS',
  0x06: 'GROUPS',  0x07: 'ZONES',   0x08: 'REMOTES',
  0x0A: 'CONFIG',  0x0F: 'SYSINFO', 0x10: 'LOG_NOTIF',
  0x12: 'PERIPH',
};
const SUB_NAMES = {
  0x00: 'REQ/BCast', 0x01: 'WRITE', 0x02: 'KEEPALIVE', 0x03: 'PUSH',
  0x80: 'RSP_OK',   0x81: 'RSP_DATA', 0x82: 'RSP_LIST', 0x83: 'RSP_ALT',
  0xFF: 'ERR/CLOSE',
};

function cmdStr(cmd) {
  return CMD_NAMES[cmd] || `CMD_${hex2(cmd)}`;
}
function subStr(sub) {
  if (sub === null) return 'n/a';
  return SUB_NAMES[sub] || `SUB_${hex2(sub)}`;
}
function hex2(b)  { return (b & 0xFF).toString(16).toUpperCase().padStart(2, '0'); }
function hexBuf(b){ return [...b].map(hex2).join(' '); }
function ts()     { return new Date().toISOString().replace('T', ' ').slice(0, 23); }
function hr(msg)  { console.log(`\n${'─'.repeat(60)}\n  ${msg}\n${'─'.repeat(60)}`); }

function logTx(frame, label, encrypt) {
  const payload = frame.slice(4);
  const encTag  = encrypt ? `[ENC key=${hex2(payload[1])}]` : '[plain]';
  console.log(`\n[${ts()}] ▶ TX  ${encTag}  ${label}`);
  if (DEBUG) {
    console.log(`  wire: ${hexBuf(frame)}`);
  }
}

function logRx(raw, parsed, label = '') {
  const encTag = parsed.encrypted ? `[ENC key=${hex2(parsed.encKey)}]` : '[plain]';
  const crcTag = parsed.crcOk
    ? '✓CRC'
    : (parsed.crcOkLE ? '✓CRC(LE!)' : `✗CRC calc=${hex2(parsed.crcCalc >> 8)}${hex2(parsed.crcCalc)}`);
  const subPart = parsed.sub !== null ? ` sub=${subStr(parsed.sub)}(${hex2(parsed.sub)})` : '';

  console.log(`\n[${ts()}] ◀ RX  ${encTag}  ${crcTag}  ${label}`);
  console.log(`  cmd=${cmdStr(parsed.cmd)}(${hex2(parsed.cmd)})${subPart}  datalen=${parsed.data.length}`);
  if (DEBUG) {
    console.log(`  wire: ${hexBuf(raw)}`);
  }
  if (parsed.data.length > 0) {
    console.log(`  data: ${hexBuf(parsed.data)}`);
  }

  // Se crcOkLE ma non crcOk: suggerisci di cambiare ordine byte CRC
  if (!parsed.crcOk && parsed.crcOkLE) {
    console.log('  ⚠  CRC valido solo in LITTLE-ENDIAN → aggiorna buildPayload!');
  }

  interpretRx(parsed);
}

/** Interpreta e stampa i campi significativi del messaggio ricevuto */
function interpretRx({ cmd, sub, data }) {
  try {
    if (cmd === 0x01) {
      if (sub === 0x80) {                             // login response
        const uid = data[0];
        const isErr = uid === 0 || (uid >= 250 && uid <= 255);
        if (!isErr) {
          // data layout (da h0/c.java):
          // [0] user_id  [1] user_type  [2-3] auth_mask LE16
          // [4] unk      [5-6] activ_mask LE16  [7-8] deactiv_mask LE16
          // [9..] name (ASCII, NUL-terminated)
          const auth   = data.length > 3 ? (data[2] | (data[3] << 8)) : 0;
          const name   = data.length > 9
            ? data.slice(9).toString('ascii').replace(/\0/g, '').trim()
            : '';
          console.log(`  → LOGIN OK  user_id=${uid}  auth=0x${auth.toString(16).padStart(4,'0')}${name ? '  nome="' + name + '"' : ''}`);
        } else {
          const ERR = { 0:'utente non trovato', 250:'non autorizzato da remoto',
                        251:'restrizione oraria', 252:'gruppo attivato',
                        253:'sessione già aperta', 254:'codice errato',
                        255:'utente non trovato (255)' };
          console.log(`  → LOGIN ERRORE ${uid}: ${ERR[uid] || 'sconosciuto'}`);
        }
      } else if (sub === 0x03) {                      // session broadcast
        const st = data[0];
        console.log(`  → SESSION status=${st}${st === 255 ? ' ← SESSIONE CHIUSA' : ' ← sessione OK'}`);
      }
    } else if (cmd === 0x06 && sub === 0x82) {        // group activation status
      if (data.length >= 10) {
        const active   = le16(data, 0);
        const partial  = le16(data, 2);
        const alarmMem = le16(data, 4);
        const zoneAlrm = le16(data, 6);
        const zoneFail = le16(data, 8);
        console.log(`  → GRUPPI ATTIVI:    ${binMask(active,16)}  (0x${active.toString(16).padStart(4,'0')})`);
        console.log(`  → GRUPPI PARZIALI:  ${binMask(partial,16)}`);
        console.log(`  → MEMORIA ALLARME:  ${binMask(alarmMem,16)}`);
        console.log(`  → ZONE IN ALLARME:  ${binMask(zoneAlrm,16)}`);
        console.log(`  → GUASTI ZONE:      ${binMask(zoneFail,16)}`);
        if (active === 0 && partial === 0) {
          console.log('  → Sistema DISINSERITO');
        } else {
          for (let g = 0; g < 16; g++) {
            if (active  & (1 << g)) console.log(`  → Gruppo ${g}: ARMATO`);
            if (partial & (1 << g)) console.log(`  → Gruppo ${g}: PARZIALE`);
            if (zoneAlrm& (1 << g)) console.log(`  → Gruppo ${g}: ALLARME ZONA`);
          }
        }
      }
    } else if (cmd === 0x06 && (sub === 0x80 || sub === 0x81)) { // arm/disarm response
      console.log(`  → RISPOSTA ARM/DISARM  (analisi completa: TODO-VALIDATE)`);
      if (data.length >= 10) {
        const active  = le16(data, 0);
        const partial = le16(data, 2);
        console.log(`  → attivi=0x${active.toString(16)} parziali=0x${partial.toString(16)}`);
      }
    } else if (cmd === 0x0F) {                        // sysinfo response
      if (data.length >= 6) {
        const fl  = data[0];
        const fw  = `${data[3]}.${data[4]}`;
        const bat = data[5];
        const nm  = data.length > 6
          ? data.slice(6).toString('ascii').replace(/\0/g, '').trim()
          : '';
        const stato = (fl & 0x80) ? 'ALLARME' : (fl & 0x01) ? 'ARMATO' : (fl & 0x02) ? 'PARZIALE' : 'DISINSERITO';
        console.log(`  → SISTEMA: ${stato}  flags=0x${hex2(fl)}  fw=${fw}  bat=${bat}${nm ? '  nome="'+nm+'"' : ''}`);
        if (fl & 0x40) console.log('  → ⚠ GUASTO segnalato');
      }
    } else if (cmd === 0x10 && sub === 0x00) {        // log written broadcast
      console.log(`  → NUOVO EVENTO LOG: categoria=${data.length > 0 ? data[0] : '?'}`);
    } else if (cmd === 0x07) {                        // zone response
      console.log(`  → RISPOSTA ZONE (raw, vedere PROTOCOL.md §10 per decodifica)`);
    }
  } catch (_) { /* non bloccare su errori di parsing */ }
}

function le16(buf, offset) {
  return (buf[offset] & 0xFF) | ((buf[offset + 1] & 0xFF) << 8);
}
function binMask(v, bits) {
  return v.toString(2).padStart(bits, '0');
}

/**
 * Fabbrica di parser stream TCP.
 * Gestisce lo smontaggio di frame incompleti e il resync sul magic.
 * @param {function} onFrame - callback(rawPayload, parsed)
 */
function makeStreamParser(onFrame) {
  let buf = Buffer.alloc(0);

  return (chunk) => {
    buf = Buffer.concat([buf, chunk]);

    while (buf.length >= 4) {
      // resync sul magic se necessario
      if (buf[0] !== 0x2B || buf[1] !== 0x2A || buf[2] !== 0x2B) {
        const idx = buf.indexOf(MAGIC, 1);
        if (idx === -1) {
          console.log(`[${ts()}]  ⚠ resync: scartati ${buf.length} byte (nessun magic trovato)`);
          buf = Buffer.alloc(0);
          break;
        }
        console.log(`[${ts()}]  ⚠ resync: scartati ${idx} byte`);
        buf = buf.slice(idx);
        continue;
      }

      const len = buf[3];
      if (buf.length < 4 + len) break;     // frame incompleto, aspetta più dati

      const rawPayload = buf.slice(4, 4 + len);
      buf = buf.slice(4 + len);

      const parsed = parsePayload(rawPayload);
      onFrame(rawPayload, parsed);
    }
  };
}

// ═══════════════════════════════════════════════════════════════════════════════
// SEZIONE 6 — PRIMITIVE DI CONNESSIONE
// ═══════════════════════════════════════════════════════════════════════════════

/**
 * Apre una connessione TCP e restituisce una Promise che risolve con il socket
 * non appena la connessione è stabilita.
 */
function tcpConnect(host, port, timeoutMs = 10000) {
  return new Promise((resolve, reject) => {
    const sock = net.createConnection({ host, port });
    sock.setTimeout(timeoutMs);
    sock.once('connect', () => { sock.setTimeout(0); resolve(sock); });
    sock.once('error',   reject);
    sock.once('timeout', () => reject(new Error(`Timeout connessione a ${host}:${port}`)));
  });
}

/**
 * Esegue il login completo: LOGIN_REQUEST → LOGIN_RESPONSE → CONFIRM → SESSION_BROADCAST.
 * Ritorna una Promise che risolve con { sock, encrypt, encKeyRx }
 * dove encrypt indica se le risposte del server erano cifrate.
 *
 * @param {string} host
 * @param {number} port
 * @param {string} pin
 * @param {boolean} sendEncrypted  - se true, invia i messaggi cifrati
 * @param {function} onMessage     - callback opzionale per tutti i messaggi ricevuti
 * @param {number} loginTimeoutMs  - timeout per la risposta al login
 */
function doLogin(host, port, pin, sendEncrypted, onMessage = null, loginTimeoutMs = 5000) {
  return new Promise(async (resolve, reject) => {
    let sock;
    try {
      sock = await tcpConnect(host, port);
    } catch (e) {
      return reject(e);
    }

    let state     = 'await_login_response';
    let encKeyRx  = 0;
    let timer     = null;

    const fail = (msg) => {
      clearTimeout(timer);
      sock.destroy();
      reject(new Error(msg));
    };

    const succeed = () => {
      clearTimeout(timer);
      resolve({ sock, encrypt: sendEncrypted, serverEncrypted: encKeyRx !== 0 });
    };

    const parser = makeStreamParser((raw, parsed) => {
      encKeyRx = parsed.encKey;
      logRx(raw, parsed);
      if (onMessage) onMessage(parsed);

      if (state === 'await_login_response') {
        if (parsed.cmd === 0x01 && parsed.sub === 0x80) {
          clearTimeout(timer);
          const uid = parsed.data[0];
          // user_id=0 → utente non trovato; 250-255 → codici di errore.
          // Qualsiasi altro valore (es. 1, 2, ...) → successo (è l'ID utente).
          // Ref: MiuraService.java, classe interna e.c(), condizione "if (iQ != 0)"
          const isError = uid === 0 || (uid >= 250 && uid <= 255);
          if (isError) {
            const ERR = { 0:'utente non trovato', 250:'non autorizzato da remoto',
                          251:'restrizione oraria', 252:'gruppo attivato',
                          253:'sessione già aperta', 254:'codice errato',
                          255:'utente non trovato (255)' };
            return fail(`Login fallito: user_id=${uid} (${ERR[uid] || 'errore sconosciuto'})`);
          }
          // Invia confirm
          state = 'await_session_broadcast';
          const cf = frameConfirm(sendEncrypted);
          logTx(cf, 'CONFIRM LOGIN', sendEncrypted);
          sock.write(cf);
          timer = setTimeout(() => fail('Timeout: nessun SESSION_BROADCAST'), loginTimeoutMs);
        }
        return;
      }

      if (state === 'await_session_broadcast') {
        if (parsed.cmd === 0x01 && parsed.sub === 0x03) {
          clearTimeout(timer);
          const st = parsed.data[0];
          if (st === 255) return fail('Sessione chiusa dalla centrale (status=255)');
          state = 'logged';
          succeed();
        }
      }
    });

    sock.on('data', parser);
    sock.on('error', (e) => fail(`Errore socket: ${e.message}`));
    sock.on('close', () => {
      if (state !== 'logged') reject(new Error('Socket chiuso prima del completamento login'));
    });

    // Invia il login
    const lf = frameLogin(pin, sendEncrypted);
    logTx(lf, 'LOGIN REQUEST', sendEncrypted);
    sock.write(lf);
    timer = setTimeout(() => fail('Timeout: nessuna risposta al login'), loginTimeoutMs);
  });
}

// ═══════════════════════════════════════════════════════════════════════════════
// SEZIONE 7 — MODALITÀ OPERATIVE
// ═══════════════════════════════════════════════════════════════════════════════

// ─── 7a. HANDSHAKE ─────────────────────────────────────────────────────────────
//
// Testa i tre punti incerti documentati in PROTOCOL.md §18:
//   1. La centrale invia qualcosa prima del login? (server greeting)
//   2. Il login PLAIN (enc=0) funziona?
//   3. Il login ENCRYPTED (enc=random) funziona?
//   4. L'ordine byte del CRC è corretto? (crcOk vs crcOkLE nelle risposte)

async function modeHandshake() {
  hr('HANDSHAKE — Test 1: server greeting (ascolto 2s senza inviare nulla)');

  let greetingFrames = [];

  await new Promise((resolve) => {
    let sock;
    tcpConnect(HOST, PORT).then((s) => {
      sock = s;
      console.log(`[${ts()}] Connesso a ${HOST}:${PORT} — ascolto per 2 secondi...`);
      const parser = makeStreamParser((raw, parsed) => {
        greetingFrames.push({ raw, parsed });
        logRx(raw, parsed, '← GREETING?');
      });
      sock.on('data', parser);
      sock.on('error', (e) => {
        console.log(`[${ts()}] Errore: ${e.message}`);
        resolve();
      });
    }).catch((e) => {
      console.log(`[${ts()}] Connessione fallita: ${e.message}`);
    });

    setTimeout(() => {
      if (sock) sock.destroy();
      resolve();
    }, 2000);
  });

  if (greetingFrames.length === 0) {
    console.log(`\n  ✓ RISULTATO 1: Il server NON invia nulla prima del login.`);
    console.log('    Questo conferma PROTOCOL.md §7: il client parla per primo.\n');
  } else {
    console.log(`\n  ⚠ RISULTATO 1: Il server ha inviato ${greetingFrames.length} frame prima del login!`);
    console.log('    Aggiornare PROTOCOL.md §7 con la struttura del greeting.\n');
  }

  // ─── Test 2: login PLAIN ────────────────────────────────────────────────────
  hr('HANDSHAKE — Test 2: Login PLAIN (enc_key=0x00)');

  let plainResult = null;
  try {
    const { sock } = await doLogin(HOST, PORT, CODE, false, null, 5000);
    plainResult = { ok: true };
    console.log(`\n  ✓ RISULTATO 2: Login PLAIN accettato.`);
    sock.destroy();
  } catch (e) {
    plainResult = { ok: false, err: e.message };
    console.log(`\n  ✗ RISULTATO 2: Login PLAIN fallito: ${e.message}`);
  }

  // piccola pausa tra i tentativi
  await sleep(1500);

  // ─── Test 3: login ENCRYPTED ───────────────────────────────────────────────
  hr('HANDSHAKE — Test 3: Login ENCRYPTED (enc_key=random)');

  let encResult = null;
  try {
    const { sock, serverEncrypted } = await doLogin(HOST, PORT, CODE, true, null, 5000);
    encResult = { ok: true, serverEncrypted };
    console.log(`\n  ✓ RISULTATO 3: Login ENCRYPTED accettato.`);
    console.log(`    Il server ha risposto ${serverEncrypted ? 'CIFRATO' : 'PLAIN'}.`);
    sock.destroy();
  } catch (e) {
    encResult = { ok: false, err: e.message };
    console.log(`\n  ✗ RISULTATO 3: Login ENCRYPTED fallito: ${e.message}`);
  }

  // ─── Riepilogo ─────────────────────────────────────────────────────────────
  hr('RIEPILOGO HANDSHAKE');
  console.log(`  Greeting server prima del login : ${greetingFrames.length > 0 ? '⚠ SÌ (' + greetingFrames.length + ' frame)' : '✓ No'}`);
  console.log(`  Login PLAIN (enc=0x00)          : ${plainResult?.ok ? '✓ OK' : '✗ FALLITO — ' + plainResult?.err}`);
  console.log(`  Login ENCRYPTED (enc=random)    : ${encResult?.ok   ? '✓ OK' : '✗ FALLITO — ' + encResult?.err}`);
  if (encResult?.ok) {
    console.log(`  Il server risponde cifrato       : ${encResult.serverEncrypted ? '✓ Sì (→ usa encrypted)' : '⚠ No (risponde plain anche se TX è cifrato)'}`);
  }
  console.log('');
  console.log('  Per PROTOCOL.md §18 TODO:');
  console.log('    1. Server greeting → ' + (greetingFrames.length === 0 ? 'CONFERMATO: nessuno' : 'RIVEDI §7'));
  console.log('    2/3. Cifratura login → usa --mode send per testare comandi con --enc plain/encrypted');
  console.log('');
  console.log('  Nota: se crcOkLE appariva nei log invece di crcOk, aggiornare buildPayload');
  console.log('  per scrivere CRC in little-endian: Buffer.from([crc & 0xFF, (crc >> 8) & 0xFF])');
}

// ─── 7b. LISTEN ────────────────────────────────────────────────────────────────
//
// Fa login col metodo indicato da --enc (default: auto = preferisce plain),
// poi rimane in ascolto loggando tutto ciò che la centrale invia spontaneamente.

async function modeListen() {
  hr(`LISTEN — Login + ascolto passivo (Ctrl+C per uscire)`);

  const useEnc = resolveEnc(ENC);
  console.log(`[${ts()}] Metodo cifratura: ${useEnc ? 'ENCRYPTED' : 'PLAIN'}`);

  let { sock } = await doLogin(HOST, PORT, CODE, useEnc);
  console.log(`\n[${ts()}] ✓ Sessione stabilita. In ascolto...\n`);

  // Il parser è già attivo dal doLogin; restiamo in ascolto senza inviare nulla.
  // Inviamo un keepalive ogni 15s per mantenere la sessione.
  const kaInterval = setInterval(() => {
    const kf = frameKeepalive(useEnc);
    logTx(kf, 'KEEPALIVE', useEnc);
    sock.write(kf);
  }, 15000);

  sock.on('close', () => {
    clearInterval(kaInterval);
    console.log(`\n[${ts()}] Connessione chiusa.`);
    process.exit(0);
  });
  sock.on('error', (e) => {
    clearInterval(kaInterval);
    console.error(`\n[${ts()}] Errore: ${e.message}`);
    process.exit(1);
  });

  // Ignora SIGINT per permettere Ctrl+C pulito
  process.on('SIGINT', () => {
    clearInterval(kaInterval);
    sock.destroy();
    process.exit(0);
  });
}

// ─── 7c. SEND ──────────────────────────────────────────────────────────────────
//
// Fa login, invia il comando specificato con --cmd,
// poi logga TUTTO il traffico in ingresso per 10 secondi.

async function modeSend() {
  hr(`SEND — cmd=${CMD}  enc=${ENC}`);

  const useEnc = resolveEnc(ENC);
  console.log(`[${ts()}] Metodo cifratura: ${useEnc ? 'ENCRYPTED' : 'PLAIN'}\n`);

  let { sock } = await doLogin(HOST, PORT, CODE, useEnc);
  console.log(`\n[${ts()}] ✓ Sessione stabilita.\n`);

  // Costruisci il frame per il comando richiesto
  const frame = buildCommandFrame(CMD, useEnc);
  if (!frame) {
    console.error(`Comando sconosciuto: "${CMD}"`);
    console.error('Comandi disponibili: login | status | zones | arm | disarm | keepalive | sysinfo');
    sock.destroy();
    process.exit(1);
  }

  logTx(frame, `SEND CMD=${CMD.toUpperCase()}`, useEnc);
  sock.write(frame);

  console.log(`\n[${ts()}] In ascolto per 10 secondi...`);

  await sleep(10000);
  sock.destroy();
}

function buildCommandFrame(cmd, encrypt) {
  switch (cmd.toLowerCase()) {
    case 'login':     return null;              // login già fatto
    case 'status':    return frameGroupStatus(encrypt);
    case 'zones':     return frameZoneInfo(0, 7, true, encrypt);
    case 'arm':       return frameActivation(GROUP, true,  encrypt);
    case 'disarm':    return frameActivation(GROUP, false, encrypt);
    case 'keepalive': return frameKeepalive(encrypt);
    case 'sysinfo':   return frameSysInfo(encrypt);
    default:          return null;
  }
}

// ═══════════════════════════════════════════════════════════════════════════════
// SEZIONE 8 — HELPERS E ENTRY POINT
// ═══════════════════════════════════════════════════════════════════════════════

function resolveEnc(encArg) {
  if (encArg === 'encrypted') return true;
  if (encArg === 'plain')     return false;
  return false;  // auto → inizia plain (TODO: rilevamento automatico da server)
}

function sleep(ms) { return new Promise(r => setTimeout(r, ms)); }

// ─── Banner ───────────────────────────────────────────────────────────────────

console.log('');
console.log('╔══════════════════════════════════════════════╗');
console.log('║         Miura Tervis — Protocol Probe        ║');
console.log('╠══════════════════════════════════════════════╣');
console.log(`║  Host  : ${HOST.padEnd(35)}║`);
console.log(`║  Port  : ${String(PORT).padEnd(35)}║`);
console.log(`║  Code  : ${'*'.repeat(CODE.length).padEnd(35)}║`);
console.log(`║  Mode  : ${MODE.padEnd(35)}║`);
console.log(`║  Enc   : ${ENC.padEnd(35)}║`);
console.log(`║  Debug : ${String(DEBUG).padEnd(35)}║`);
console.log('╚══════════════════════════════════════════════╝');
console.log('');

// ─── Dispatch ─────────────────────────────────────────────────────────────────

(async () => {
  try {
    switch (MODE) {
      case 'handshake': await modeHandshake(); break;
      case 'listen':    await modeListen();    break;
      case 'send':      await modeSend();      break;
      default:
        console.error(`Modalità sconosciuta: "${MODE}"`);
        console.error('Modalità disponibili: handshake | listen | send');
        process.exit(1);
    }
  } catch (e) {
    console.error(`\n[${ts()}] Errore fatale: ${e.message}`);
    if (DEBUG) console.error(e.stack);
    process.exit(1);
  }
})();
