'use strict';

/**
 * Test per miura/session.js
 *
 * Usa un MockConnection (EventEmitter) per controllare gli eventi di rete
 * senza aprire connessioni TCP reali.
 *
 * Eseguire con: node --test backend/test/session.test.js
 */

const { test, describe, beforeEach } = require('node:test');
const assert                         = require('node:assert/strict');
const { EventEmitter }               = require('events');
const { Session }                    = require('../miura/session');
const { parseFrame }                 = require('../miura/protocol');

// ─── Mock Connection ─────────────────────────────────────────────────────────

class MockConnection extends EventEmitter {
  connectCount    = 0;
  disconnectCount = 0;
  sent            = [];

  connect() {
    this.connectCount++;
    return new Promise(() => {}); // mai risolve: Session controlla gli stati via eventi
  }

  disconnect() {
    this.disconnectCount++;
  }

  send(frame) {
    this.sent.push(frame);
  }
}

// ─── Helpers ─────────────────────────────────────────────────────────────────

/**
 * Crea un oggetto frame parsato come lo emetterebbe Connection.
 * enc_key e crcOk sono fittizi; Session non li verifica.
 */
function serverFrame(cmd, sub, data) {
  return {
    cmd,
    sub,
    data:             Buffer.from(data ?? []),
    encKey:           0x42,
    crcOk:            true,
    decryptedPayload: Buffer.alloc(0),
  };
}

/**
 * Parsa il frame grezzo (Buffer) inviato da Session a Connection.
 * Ritorna l'oggetto { cmd, sub, data, ... } come parseFrame.
 */
function parseSent(buf) {
  return parseFrame(buf.slice(4)); // salta MAGIC (3B) + LEN (1B)
}

/** Attende un evento su un EventEmitter con timeout. */
function waitFor(emitter, event, timeoutMs = 500) {
  return new Promise((resolve, reject) => {
    const t = setTimeout(
      () => reject(new Error(`Timeout waiting for '${event}'`)),
      timeoutMs,
    );
    emitter.once(event, (...args) => {
      clearTimeout(t);
      resolve(args.length === 1 ? args[0] : args);
    });
  });
}

const TEST_PIN = '123456'; // PIN fittizio — usato solo per testare il codec

/**
 * Porta la sessione fino allo stato 'ready' emettendo gli eventi di rete
 * necessari: connecting → connected → login response → session broadcast.
 */
function doLogin(conn) {
  conn.emit('state', 'connecting');
  conn.emit('state', 'connected');
  // Login response: user_id=1 (successo)
  conn.emit('frame', serverFrame(0x01, 0x80, [0x01]));
  // Session Broadcast OK (status=0x81)
  conn.emit('frame', serverFrame(0x01, 0x03, [0x81]));
}

// ─── Suite 1 — Percorso felice ────────────────────────────────────────────────

describe('Session — percorso felice', () => {
  test('IDLE → CONNECTING → LOGGING_IN → READY', async () => {
    const conn    = new MockConnection();
    const session = new Session(conn, TEST_PIN);

    const states = [];
    session.on('state', s => states.push(s));

    const connectP = session.connect();

    // TCP in corso
    conn.emit('state', 'connecting');
    assert.strictEqual(session.state, 'connecting');

    // TCP connesso → sessione avvia il login
    conn.emit('state', 'connected');
    assert.strictEqual(session.state, 'logging_in');

    // Verifica che sia stata inviata la login request (CMD=1 SUB=0)
    assert.ok(conn.sent.length >= 1, 'deve aver inviato la login request');
    const loginReq = parseSent(conn.sent[0]);
    assert.strictEqual(loginReq.cmd, 0x01);
    assert.strictEqual(loginReq.sub, 0x00);

    // Server risponde con successo (user_id=1)
    conn.emit('frame', serverFrame(0x01, 0x80, [0x01]));

    // Verifica che sia stato inviato il Confirm Login (CMD=1, sub=null → 5 byte)
    assert.ok(conn.sent.length >= 2, 'deve aver inviato il confirm login');
    const confirm = parseSent(conn.sent[1]);
    assert.strictEqual(confirm.cmd, 0x01);
    assert.strictEqual(confirm.sub, null, 'confirm login non deve avere SUB');

    // Session Broadcast OK → sessione pronta
    conn.emit('frame', serverFrame(0x01, 0x03, [0x81]));

    await connectP;
    assert.strictEqual(session.state, 'ready');
    assert.deepStrictEqual(states, ['connecting', 'logging_in', 'ready']);
  });

  test('connect() idempotente: chiamate multiple ritornano la stessa Promise', () => {
    const conn    = new MockConnection();
    const session = new Session(conn, TEST_PIN);

    const p1 = session.connect();
    const p2 = session.connect();
    assert.strictEqual(p1, p2);
  });

  test('connect() da stato closed riparte (opzione b)', async () => {
    const conn    = new MockConnection();
    const session = new Session(conn, TEST_PIN);

    // Prima connessione → ready
    const p1 = session.connect();
    doLogin(conn);
    await p1;

    // Disconnetti → closed
    session.disconnect();
    assert.strictEqual(session.state, 'closed');

    // Seconda connect() deve essere possibile
    const p2 = session.connect();
    assert.ok(p2 instanceof Promise);
    doLogin(conn);
    await p2;
    assert.strictEqual(session.state, 'ready');
  });
});

// ─── Suite 2 — Login fallito ──────────────────────────────────────────────────

describe('Session — login fallito', () => {
  test('user_id=254 → CLOSED, emette login-failed, nessuna riconnessione', async () => {
    const conn    = new MockConnection();
    const session = new Session(conn, TEST_PIN);

    const failedP  = waitFor(session, 'login-failed');
    const connectP = session.connect();

    conn.emit('state', 'connected');
    // Server risponde con codice errore 254 (wrong code)
    conn.emit('frame', serverFrame(0x01, 0x80, [0xFE]));

    const info = await failedP;
    assert.strictEqual(info.code, 254);
    assert.ok(typeof info.message === 'string' && info.message.length > 0);

    await assert.rejects(connectP, /login failed/);
    assert.strictEqual(session.state, 'closed');
    assert.strictEqual(conn.disconnectCount, 1, 'deve chiamare disconnect una sola volta (no retry)');
  });

  test('user_id=0 → CLOSED, emette login-failed', async () => {
    const conn    = new MockConnection();
    const session = new Session(conn, TEST_PIN);

    const failedP  = waitFor(session, 'login-failed');
    session.connect().catch(() => {}); // rejection attesa via assert.rejects non necessaria qui
    conn.emit('state', 'connected');
    conn.emit('frame', serverFrame(0x01, 0x80, [0x00]));

    const info = await failedP;
    assert.strictEqual(info.code, 0);
    assert.strictEqual(session.state, 'closed');
  });
});

// ─── Suite 3 — Sessione scaduta / reconnect spontaneo ────────────────────────

describe('Session — sessione scaduta e reconnect', () => {
  test('session broadcast status=0xFF → emette session-expired e va in RECONNECTING', async () => {
    const conn    = new MockConnection();
    const session = new Session(conn, TEST_PIN);

    const p = session.connect();
    doLogin(conn);
    await p;

    const expiredP = waitFor(session, 'session-expired');
    // Centrale invia CMD=1 SUB=3 status=0xFF
    conn.emit('frame', serverFrame(0x01, 0x03, [0xFF]));

    await expiredP;
    assert.strictEqual(session.state, 'reconnecting');
  });

  test('drop TCP da READY → RECONNECTING → ri-login → READY', async () => {
    const conn    = new MockConnection();
    const session = new Session(conn, TEST_PIN);

    const p = session.connect();
    doLogin(conn);
    await p;

    const sentBefore = conn.sent.length;

    // Drop TCP
    conn.emit('state', 'reconnecting');
    assert.strictEqual(session.state, 'reconnecting');

    // Riconnessione TCP → ri-login automatico
    conn.emit('state', 'connected');
    assert.strictEqual(session.state, 'logging_in');

    // Verifica che sia stata inviata una nuova login request
    assert.ok(conn.sent.length > sentBefore, 'deve inviare login request al riconnetti');

    conn.emit('frame', serverFrame(0x01, 0x80, [0x01])); // login OK
    conn.emit('frame', serverFrame(0x01, 0x03, [0x81])); // session broadcast

    assert.strictEqual(session.state, 'ready');
  });
});

// ─── Suite 4 — Disconnect manuale ────────────────────────────────────────────

describe('Session — disconnect manuale', () => {
  test('disconnect() da READY → CLOSED, comando in-flight rigettato', async () => {
    const conn    = new MockConnection();
    const session = new Session(conn, TEST_PIN);

    const p = session.connect();
    doLogin(conn);
    await p;

    // Avvia un comando (va in pending, nessuna risposta dal server)
    const statusP = session.getGroupStatus();
    // Attende che il microtask dell'async function abbia fatto il dispatch
    await Promise.resolve();

    session.disconnect();

    await assert.rejects(statusP, /disconnected/);
    assert.strictEqual(session.state, 'closed');
    // L'ultimo disconnect() è quello esplicito (più eventuali precedenti)
    assert.ok(conn.disconnectCount >= 1);
  });

  test('disconnect() rigetta la Promise di connect() se ancora in pending', async () => {
    const conn    = new MockConnection();
    const session = new Session(conn, TEST_PIN);

    const p = session.connect(); // in attesa di login
    conn.emit('state', 'connected'); // parte il login

    // Disconnect prima che arrivi la risposta
    session.disconnect();

    await assert.rejects(p, /disconnected/);
    assert.strictEqual(session.state, 'closed');
  });
});

// ─── Suite 5 — Coda comandi ───────────────────────────────────────────────────

describe('Session — coda comandi e reconnect', () => {
  test('comandi pending e in coda vengono rigettati durante reconnect', async () => {
    const conn    = new MockConnection();
    const session = new Session(conn, TEST_PIN);

    const p = session.connect();
    doLogin(conn);
    await p;

    // cmd1 → va in pending (nessuna risposta)
    const cmd1 = session.getGroupStatus();
    // cmd2 → va in coda (c'è già cmd1 pending)
    const cmd2 = session.getGroupStatus();

    // Aspetta che i microtask abbiano fatto il dispatch di cmd1 e accodato cmd2
    await Promise.resolve();

    // Drop TCP
    conn.emit('state', 'reconnecting');

    await assert.rejects(cmd1, /reconnecting/);
    await assert.rejects(cmd2, /reconnecting/);
    assert.strictEqual(session.state, 'reconnecting');
  });

  test('getGroupStatus() risolve con il payload decodificato', async () => {
    const conn    = new MockConnection();
    const session = new Session(conn, TEST_PIN);

    const p = session.connect();
    doLogin(conn);
    await p;

    // Prepara la risposta del server (10 byte: active=0x0003, tutto il resto 0)
    const responseData = Buffer.alloc(10);
    responseData.writeUInt16LE(0x0003, 0); // active: gruppi 0 e 1 armati

    const statusP = session.getGroupStatus();
    await Promise.resolve(); // flush dispatch

    conn.emit('frame', serverFrame(0x06, 0x80, responseData));

    const result = await statusP;
    assert.strictEqual(result.active,     0x0003);
    assert.strictEqual(result.partial,    0x0000);
    assert.strictEqual(result.alarmMem,   0x0000);
    assert.strictEqual(result.zoneGroups, 0x0000);
    assert.strictEqual(result.zoneFail,   0x0000);
  });

  test("arm('partial') lancia Error senza inviare frame", async () => {
    const conn    = new MockConnection();
    const session = new Session(conn, TEST_PIN);

    const p = session.connect();
    doLogin(conn);
    await p;

    const sentBefore = conn.sent.length;

    await assert.rejects(
      () => session.arm(0, 'partial'),
      /partial arm not yet implemented/,
    );
    assert.strictEqual(conn.sent.length, sentBefore, 'non deve inviare alcun frame');
  });

  test('push non gestito (CMD=8 SUB=0x88) viene inoltrato come evento frame', async () => {
    const conn    = new MockConnection();
    const session = new Session(conn, TEST_PIN);

    const p = session.connect();
    doLogin(conn);
    await p;

    const pushP = waitFor(session, 'frame');
    conn.emit('frame', serverFrame(0x08, 0x88, [0x01, 0x02]));
    const forwarded = await pushP;

    assert.strictEqual(forwarded.cmd, 0x08);
    assert.strictEqual(forwarded.sub, 0x88);
  });
});

// ─── Suite 6 — Nuovi comandi ──────────────────────────────────────────────────

describe('Session — getSysinfo / getZoneBlock / getText', () => {
  // Helper: porta la sessione a READY e restituisce { conn, session }
  async function readySession() {
    const conn    = new MockConnection();
    const session = new Session(conn, TEST_PIN);
    const p = session.connect();
    doLogin(conn);
    await p;
    return { conn, session };
  }

  test('getSysinfo() invia CMD=0x0F SUB=0x01 e decodifica la risposta', async () => {
    const { conn, session } = await readySession();

    const sysinfoP = session.getSysinfo();
    await Promise.resolve();

    // Verifica il frame inviato
    const sent = parseSent(conn.sent.at(-1));
    assert.strictEqual(sent.cmd, 0x0F);
    assert.strictEqual(sent.sub, 0x01);

    // Risposta: flags1=0x01 (armato), fw=1.2, battery=4, name="TIM"
    const respData = Buffer.concat([
      Buffer.from([0x01, 0x00, 0x00, 0x01, 0x02, 0x04]),
      Buffer.from('TIM\0', 'ascii'),
    ]);
    conn.emit('frame', serverFrame(0x0F, 0x80, respData));

    const result = await sysinfoP;
    assert.strictEqual(result.armed,    true);
    assert.strictEqual(result.firmware, '1.2');
    assert.strictEqual(result.battery,  4);
    assert.strictEqual(result.name,     'TIM');
  });

  test('getZoneBlock(0) invia CMD=0x07 SUB=0x01 con flag=0x01 e decodifica', async () => {
    const { conn, session } = await readySession();

    const zonesP = session.getZoneBlock(0);
    await Promise.resolve();

    const sent = parseSent(conn.sent.at(-1));
    assert.strictEqual(sent.cmd, 0x07);
    assert.strictEqual(sent.sub, 0x01);
    assert.strictEqual(sent.data[0], 0x01); // flag = normal block
    assert.strictEqual(sent.data[1], 0x00); // startIdx = 0
    assert.strictEqual(sent.data[2], 7);    // blockSize default

    // Risposta con 2 zone
    const respData = Buffer.from([
      0x01, 0x00, 0x02,           // found, offset=0, count=2
      0x00, 0x01, 0x01, 0x00,     // zona 0: attiva, alarm
      0x01, 0x00, 0x00, 0x00,     // zona 1: non attiva, standby
    ]);
    conn.emit('frame', serverFrame(0x07, 0x81, respData));

    const result = await zonesP;
    assert.strictEqual(result.found, true);
    assert.strictEqual(result.zones.length, 2);
    assert.strictEqual(result.zones[0].id, 0);
    assert.strictEqual(result.zones[0].active, true);
    assert.strictEqual(result.zones[0].status, 1);
    assert.strictEqual(result.zones[1].active, false);
  });

  test('getZoneBlock con isLast=true → flag=0x0F nel frame', async () => {
    const { conn, session } = await readySession();

    session.getZoneBlock(7, 7, true).catch(() => {}); // risposta non emessa in questo test
    await Promise.resolve();

    const sent = parseSent(conn.sent.at(-1));
    assert.strictEqual(sent.data[0], 0x0F); // last block flag
    assert.strictEqual(sent.data[1], 7);    // startIdx
  });

  test('getText(GROUP, 0) invia CMD=0x03 SUB=0x00 con tipo e ID', async () => {
    const { conn, session } = await readySession();

    const textP = session.getText(2, 0); // GROUP (type=2), id=0
    await Promise.resolve();

    const sent = parseSent(conn.sent.at(-1));
    assert.strictEqual(sent.cmd, 0x03);
    assert.strictEqual(sent.sub, 0x00);
    assert.strictEqual(sent.data[0], 2); // type = GROUP
    assert.strictEqual(sent.data.readUInt16LE(1), 0); // id = 0

    // Risposta con nome "Casa"
    const respData = Buffer.concat([
      Buffer.from([0x02, 0x00, 0x00]),    // type=GROUP, id=0 LE16
      Buffer.from('Casa\0', 'ascii'),
    ]);
    conn.emit('frame', serverFrame(0x03, 0x80, respData));

    const result = await textP;
    assert.strictEqual(result.type, 2);
    assert.strictEqual(result.id,   0);
    assert.strictEqual(result.text, 'Casa');
  });

  test('getText con ID > 255 viene codificato correttamente in LE16', async () => {
    const { conn, session } = await readySession();

    session.getText(3, 0x0102).catch(() => {}); // risposta non emessa in questo test
    await Promise.resolve();

    const sent = parseSent(conn.sent.at(-1));
    assert.strictEqual(sent.data.readUInt16LE(1), 0x0102);
  });
});
