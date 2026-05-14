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
    session.connect();
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
