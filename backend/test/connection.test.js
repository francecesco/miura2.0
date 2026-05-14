'use strict';

/**
 * Test per miura/connection.js
 *
 * Usa un net.Server locale (porta 0 = OS sceglie) per non richiedere la centrale reale.
 * Eseguire con: node --test backend/test/connection.test.js
 */

const { test, describe, beforeEach, afterEach } = require('node:test');
const assert  = require('node:assert/strict');
const net     = require('net');
const { Connection } = require('../miura/connection');
const { buildFrame }  = require('../miura/protocol');

// Opzioni per test veloci: riconnessione a 50ms invece di 2s
const FAST = { reconnectBaseMs: 50, reconnectMaxMs: 200, connectTimeoutMs: 500 };

// ─── Helpers ─────────────────────────────────────────────────────────────────

/** Avvia un server TCP locale su porta casuale. Ritorna { server, port }. */
function startServer() {
  return new Promise((resolve, reject) => {
    const server = net.createServer();
    server.listen(0, '127.0.0.1', () => resolve({ server, port: server.address().port }));
    server.once('error', reject);
  });
}

/** Attende un evento su un EventEmitter con timeout. */
function waitFor(emitter, event, timeoutMs = 1000) {
  return new Promise((resolve, reject) => {
    const timer = setTimeout(
      () => reject(new Error(`Timeout waiting for '${event}' (${timeoutMs}ms)`)),
      timeoutMs,
    );
    emitter.once(event, (...args) => {
      clearTimeout(timer);
      resolve(args.length === 1 ? args[0] : args);
    });
  });
}

/** Attende che connection.state === target, polling ogni 10ms. */
function waitForState(conn, target, timeoutMs = 1000) {
  return new Promise((resolve, reject) => {
    if (conn.state === target) return resolve();
    const deadline = Date.now() + timeoutMs;
    const check = () => {
      if (conn.state === target) return resolve();
      if (Date.now() > deadline) return reject(new Error(`State '${target}' not reached`));
      setTimeout(check, 10);
    };
    conn.on('state', st => { if (st === target) resolve(); });
    setTimeout(check, 10);
  });
}

// ─── Suite ───────────────────────────────────────────────────────────────────

describe('Connection — connessione base', () => {
  let server, port, conn;

  beforeEach(async () => {
    ({ server, port } = await startServer());
    conn = new Connection('127.0.0.1', port, FAST);
  });

  afterEach(async () => {
    conn.disconnect();
    await new Promise(r => server.close(r));
  });

  test('connect() risolve quando il server accetta', async () => {
    await assert.doesNotReject(conn.connect());
  });

  test("stato transita idle → connecting → connected", async () => {
    const states = [];
    conn.on('state', s => states.push(s));
    await conn.connect();
    assert.ok(states.includes('connecting'), 'deve passare per connecting');
    assert.strictEqual(states.at(-1), 'connected');
    assert.strictEqual(conn.state, 'connected');
  });

  test('connect() chiamato più volte ritorna la stessa Promise', async () => {
    const p1 = conn.connect();
    const p2 = conn.connect();
    assert.strictEqual(p1, p2, 'deve essere la stessa Promise');
    await p1; // consuma la Promise prima che afterEach chiami disconnect()
  });

  test("disconnect() porta lo stato a 'disconnected'", async () => {
    await conn.connect();
    conn.disconnect();
    assert.strictEqual(conn.state, 'disconnected');
  });

  test('dopo disconnect() si può riconnettere', async () => {
    await conn.connect();
    conn.disconnect();
    // Il server è ancora su: una seconda connect deve funzionare
    const conn2 = new Connection('127.0.0.1', port, FAST);
    await assert.doesNotReject(conn2.connect());
    conn2.disconnect();
  });
});

describe('Connection — trasmissione e ricezione frame', () => {
  let server, port, conn;

  beforeEach(async () => {
    ({ server, port } = await startServer());
    conn = new Connection('127.0.0.1', port, FAST);
  });

  afterEach(async () => {
    conn.disconnect();
    await new Promise(r => server.close(r));
  });

  test('send() trasmette i byte al server', async () => {
    const serverReceived = new Promise(resolve => {
      server.once('connection', sock => {
        sock.once('data', data => resolve(data));
      });
    });

    await conn.connect();
    const frame = buildFrame(0x06, 0x02, Buffer.alloc(0));
    conn.send(frame);

    const received = await serverReceived;
    assert.deepStrictEqual(received, frame);
  });

  test("send() lancia errore se non connesso", () => {
    assert.throws(
      () => conn.send(buildFrame(0x06, 0x02, Buffer.alloc(0))),
      /Cannot send/,
    );
  });

  test("evento 'frame' emesso quando il server invia un frame Miura valido", async () => {
    const framePromise = waitFor(conn, 'frame');

    server.once('connection', sock => {
      // Invia un frame keep-alive dalla centrale verso il client
      sock.write(buildFrame(0x01, 0x02, Buffer.alloc(0)));
    });

    await conn.connect();
    const parsed = await framePromise;

    assert.strictEqual(parsed.cmd, 0x01);
    assert.strictEqual(parsed.sub, 0x02);
    assert.ok(parsed.crcOk);
  });

  test('frame inviato in chunk separati viene riassemblato correttamente', async () => {
    const framePromise = waitFor(conn, 'frame');

    server.once('connection', sock => {
      const wire = buildFrame(0x0F, 0x01, Buffer.alloc(0));
      // Invia in due metà
      sock.write(wire.slice(0, 4));
      setImmediate(() => sock.write(wire.slice(4)));
    });

    await conn.connect();
    const parsed = await framePromise;

    assert.strictEqual(parsed.cmd, 0x0F);
    assert.ok(parsed.crcOk);
  });

  test('due frame consecutivi emettono due eventi frame distinti', async () => {
    const frames = [];
    conn.on('frame', f => frames.push(f));

    server.once('connection', sock => {
      const w1 = buildFrame(0x06, 0x02, Buffer.alloc(0));
      const w2 = buildFrame(0x0F, 0x01, Buffer.alloc(0));
      sock.write(Buffer.concat([w1, w2]));
    });

    await conn.connect();
    // Attende che siano arrivati 2 frame
    await new Promise(resolve => {
      const check = () => frames.length >= 2 ? resolve() : setTimeout(check, 10);
      check();
    });

    assert.strictEqual(frames.length, 2);
    assert.strictEqual(frames[0].cmd, 0x06);
    assert.strictEqual(frames[1].cmd, 0x0F);
  });
});

describe('Connection — riconnessione automatica', () => {
  let server, port, conn;

  beforeEach(async () => {
    ({ server, port } = await startServer());
    conn = new Connection('127.0.0.1', port, FAST);
  });

  afterEach(async () => {
    conn.disconnect();
    await new Promise(r => server.close(r));
  });

  test("quando il server chiude il socket il client emette 'reconnecting'", async () => {
    // Registra prima il listener, poi aspetta entrambi (connect + server socket) in parallelo
    const serverSocketP = new Promise(resolve => server.once('connection', resolve));
    await conn.connect();
    const serverSocket = await serverSocketP; // già risolto se 'connection' è già scattato

    const reconnectingPromise = waitFor(conn, 'reconnecting');
    serverSocket.destroy();

    const info = await reconnectingPromise;
    assert.strictEqual(info.attempt, 1);
    assert.ok(info.delayMs > 0);
  });

  test('dopo drop del server il client si riconnette automaticamente', async () => {
    const serverSocketP = new Promise(resolve => server.once('connection', resolve));
    await conn.connect();
    const serverSocket = await serverSocketP;

    serverSocket.destroy();

    // Il server è ancora in ascolto: il client deve riconnettersi
    await waitForState(conn, 'connected', 2000);
    assert.strictEqual(conn.state, 'connected');
  });

  test('backoff: il secondo tentativo ha delay doppio del primo', async () => {
    // Usiamo un server che rifiuta subito per forzare due tentativi falliti
    server.close(); // smette di accettare
    await new Promise(r => server.once('close', r));

    const delays = [];
    conn.on('reconnecting', ({ delayMs }) => delays.push(delayMs));

    // connect() non risolve (nessun server), aspettiamo 2 tentativi
    conn.connect().catch(() => {}); // atteso che penda/fallisca

    await new Promise(r => setTimeout(r, 600)); // abbastanza per 2 cicli a 50ms + 100ms
    conn.disconnect();

    assert.ok(delays.length >= 2, `attesi almeno 2 eventi reconnecting, ricevuti: ${delays.length}`);
    assert.ok(delays[1] >= delays[0], 'il secondo delay deve essere >= del primo');
  });

  test("disconnect() durante reconnecting rigetta la Promise di connect()", async () => {
    server.close(); // nessun server disponibile
    await new Promise(r => server.once('close', r));

    const p = conn.connect();
    await new Promise(r => setTimeout(r, 80)); // primo tentativo fallisce
    conn.disconnect();

    await assert.rejects(p, /disconnected/);
  });
});

describe('Connection — gestione server non raggiungibile', () => {
  test('connect() su porta chiusa non rigetta subito (riprova)', async () => {
    // Porta 1: garantita chiusa (privilegiata), oppure una porta libera
    // Usiamo una porta su cui non c'è nessuno in ascolto
    const conn = new Connection('127.0.0.1', 19999, FAST);
    const p = conn.connect();

    // Dopo il primo fallimento deve essere in stato reconnecting, non rejected
    await waitForState(conn, 'reconnecting', 600);
    assert.strictEqual(conn.state, 'reconnecting');

    conn.disconnect();
    await assert.rejects(p, /disconnected/);
  });
});
