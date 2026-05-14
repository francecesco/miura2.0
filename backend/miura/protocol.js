'use strict';

/**
 * protocol.js — codec puro per il protocollo TCP Miura Tervis
 *
 * Nessun I/O, nessun side effect. Tutte le funzioni sono pure e testabili in isolamento.
 *
 * Wire format (da PROTOCOL.md §2):
 *   TX: [2B 2A 2B][LEN][F1][00][CMD][SUB?][DATA...][CRC_HI][CRC_LO]
 *   RX: [2B 2A 2B][LEN][F1][ENC_KEY][CMD][SUB][DATA...][CRC_HI][CRC_LO]
 *
 * Cifratura (§3): ASIMMETRICA — client invia sempre plain (enc_key=0x00),
 *   server risponde sempre cifrato (enc_key≠0).
 *
 * CRC (§4): CRC-16/MODBUS, poly=0xA001, init=0xFFFF, BIG-ENDIAN nel wire
 *   (byte alto in posizione n-2, byte basso in n-1).
 */

const MAGIC = Buffer.from([0x2B, 0x2A, 0x2B]);

// ─── CRC ─────────────────────────────────────────────────────────────────────

/**
 * CRC-16/MODBUS: poly riflesso 0xA001, init 0xFFFF.
 * Fonte: j0/j.java metodo b(); ordine byte: Y/b.java metodo a().
 * @param {Buffer} buf
 * @returns {number} valore CRC a 16 bit
 */
function crc16(buf) {
  let crc = 0xFFFF;
  for (let i = 0; i < buf.length; i++) {
    crc ^= buf[i] & 0xFF;
    for (let b = 0; b < 8; b++) {
      if (crc & 1) { crc = (crc >>> 1) ^ 0xA001; }
      else         { crc >>>= 1; }
    }
  }
  return crc & 0xFFFF;
}

// ─── Cifratura ───────────────────────────────────────────────────────────────

/**
 * Decifra un payload in ingresso dal server.
 * Se enc_key (payload[1]) == 0 restituisce copia invariata (non dovrebbe accadere
 * in produzione con il server reale, ma gestito per robustezza).
 * Fonte: Y/b.java metodo statico c(byte[]).
 * @param {Buffer} payload  payload grezzo ricevuto dal server
 * @returns {Buffer}        payload decifrato
 */
function decrypt(payload) {
  const key = payload[1];
  if (key === 0) return Buffer.from(payload);
  const out = Buffer.from(payload);
  out[0] ^= key;
  // out[1] rimane invariato: è la chiave stessa, non viene de-XORata
  for (let i = 2; i < out.length; i++) out[i] ^= key;
  return out;
}

// ─── Costruzione frame TX ────────────────────────────────────────────────────

/**
 * Costruisce il wire frame completo da inviare alla centrale.
 *
 * Il client invia SEMPRE plain: enc_key è fisso a 0x00.
 *
 * sub=null è consentito SOLO per il Confirm Login (h0.a): è l'unico messaggio
 * senza SUB byte, con payload di 5 byte: [F1][00][01][CRC_HI][CRC_LO].
 * Per tutti gli altri messaggi (incluso keep-alive con data vuoto) sub è sempre presente.
 *
 * @param {number}          cmd   CMD byte (es. 0x01 = auth, 0x06 = groups)
 * @param {number|null}     sub   SUB byte; null solo per confirm login
 * @param {Buffer|number[]} data  payload dati (può essere vuoto)
 * @returns {Buffer}  wire frame completo [MAGIC][LEN][PAYLOAD]
 */
function buildFrame(cmd, sub, data) {
  const dataBuf = Buffer.isBuffer(data) ? data : Buffer.from(data ?? []);

  // Assembla body: [F1][00][CMD][SUB?][DATA...]
  const parts = [0xF1, 0x00, cmd];
  if (sub !== null && sub !== undefined) parts.push(sub & 0xFF);
  const body = Buffer.concat([Buffer.from(parts), dataBuf]);

  // CRC BIG-ENDIAN: byte alto prima, byte basso dopo
  const crcVal = crc16(body);
  const payload = Buffer.concat([
    body,
    Buffer.from([(crcVal >> 8) & 0xFF, crcVal & 0xFF]),
  ]);

  return Buffer.concat([MAGIC, Buffer.from([payload.length]), payload]);
}

// ─── Parsing frame RX ────────────────────────────────────────────────────────

/**
 * Parsa un payload grezzo ricevuto dalla centrale (magic e LEN già consumati
 * dallo stream parser — vedi makeStreamParser).
 *
 * @param {Buffer} rawPayload  payload grezzo ancora cifrato
 * @returns {{
 *   cmd:               number,
 *   sub:               number|null,  null solo per payload a 5 byte (confirm login TX, rarissimo in RX)
 *   data:              Buffer,       bytes DATA senza header e senza CRC
 *   encKey:            number,       chiave XOR usata dal server (0 = non cifrato)
 *   crcOk:             boolean,
 *   decryptedPayload:  Buffer,       payload decifrato completo esclusi i 2 byte CRC
 * } | null}  null se payload troppo corto
 */
function parseFrame(rawPayload) {
  if (!rawPayload || rawPayload.length < 5) return null;

  const dec = decrypt(rawPayload);
  const n   = dec.length;

  const encKey = rawPayload[1];  // chiave dal payload grezzo
  const cmd    = dec[2];

  // SUB presente se il payload ha almeno 6 byte (altrimenti è il caso 5-byte senza SUB)
  const sub    = n >= 6 ? dec[3] : null;
  const data   = n >= 6 ? dec.slice(4, n - 2) : Buffer.alloc(0);

  // Verifica CRC BIG-ENDIAN: dec[n-2] = HIGH, dec[n-1] = LOW
  const crcCalc = crc16(dec.slice(0, n - 2));
  const crcRx   = ((dec[n - 2] & 0xFF) << 8) | (dec[n - 1] & 0xFF);

  return {
    cmd,
    sub,
    data,
    encKey,
    crcOk:            crcCalc === crcRx,
    decryptedPayload: dec.slice(0, n - 2),
  };
}

// ─── Stream parser (TCP reassembly) ──────────────────────────────────────────

/**
 * Crea un parser con stato interno per il riassemblaggio dello stream TCP.
 *
 * Responsabilità:
 *   - Accumula chunk TCP in un buffer interno
 *   - Cerca la magic sequence [2B 2A 2B]
 *   - Legge LEN, attende che il buffer contenga LEN byte di payload
 *   - Estrae il payload grezzo e chiama onFrame(parseFrame(payload))
 *   - Gestisce resync: scarta byte prima della magic loggando in debug
 *   - Gestisce frame multipli in un singolo chunk
 *
 * @param {function} onFrame  callback invocata per ogni frame completo parsato
 * @returns {{ push(chunk: Buffer): void, reset(): void }}
 */
function makeStreamParser(onFrame) {
  let buf = Buffer.alloc(0);

  function push(chunk) {
    buf = Buffer.concat([buf, chunk]);

    while (buf.length >= 4) {
      // Cerca la magic sequence
      const magicIdx = buf.indexOf(MAGIC);

      if (magicIdx === -1) {
        // Magic non trovata: conserva gli ultimi 2 byte per il caso in cui
        // la magic cada sul confine tra due chunk consecutivi
        buf = buf.length > 2 ? buf.slice(buf.length - 2) : buf;
        break;
      }

      if (magicIdx > 0) {
        if (process.env.DEBUG_PROTOCOL) {
          process.stderr.write(
            `[protocol] stream resync: discarding ${magicIdx} spurious bytes\n`
          );
        }
        buf = buf.slice(magicIdx);
      }

      // buf[0..2] = magic, buf[3] = LEN
      if (buf.length < 4) break;
      const len = buf[3];

      // Aspetta che ci siano LEN byte di payload dopo magic+LEN
      if (buf.length < 4 + len) break;

      const rawPayload = buf.slice(4, 4 + len);
      buf = buf.slice(4 + len);

      const parsed = parseFrame(rawPayload);
      if (parsed) {
        onFrame(parsed);
      } else if (process.env.DEBUG_PROTOCOL) {
        process.stderr.write(
          `[protocol] parseFrame skipped: payload too short (len=${len})\n`
        );
      }
    }
  }

  function reset() {
    buf = Buffer.alloc(0);
  }

  return { push, reset };
}

// ─── Exports ─────────────────────────────────────────────────────────────────

module.exports = { crc16, decrypt, buildFrame, parseFrame, makeStreamParser };
