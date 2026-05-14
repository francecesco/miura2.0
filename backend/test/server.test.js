'use strict';

/**
 * Test per server.js
 *
 * Usa MockSession + porta casuale (port 0). Ogni test gestisce il proprio
 * ciclo di vita del server (start/stop) per evitare race condition tra suite.
 *
 * Eseguire con: node --test backend/test/server.test.js
 */

const { test, describe } = require('node:test');
const assert             = require('node:assert/strict');
const { EventEmitter }   = require('events');
const { WebSocket }      = require('ws');
const { createServer, dispatch } = require('../server');

// ─── Mock Session ─────────────────────────────────────────────────────────────

class MockSession extends EventEmitter {
  state = 'ready';

  async getGroupStatus() {
    return { active: 0x0001, partial: 0, alarmMem: 0, zoneGroups: 0x0001, zoneFail: 0 };
  }
  async getSysinfo() {
    return { name: 'Casa', firmware: '1.2', battery: 4,
             armed: true, partial: false, trouble: false, alarm: false,
             flags1: 0x01, flags2: 0x00 };
  }
  async arm(groupId)    { return { active: 1 << groupId, partial: 0, alarmMem: 0, zoneGroups: 0, zoneFail: 0 }; }
  async disarm()        { return { active: 0,            partial: 0, alarmMem: 0, zoneGroups: 0, zoneFail: 0 }; }
  async getZoneBlock()  { return { found: true, zones: [] }; }
  async getText(t, id)  { return { type: t, id, text: 'Test' }; }
}

// ─── Helpers ─────────────────────────────────────────────────────────────────

/** Avvia server su porta casuale. */
function startTestServer(session = new MockSession()) {
  return new Promise((resolve, reject) => {
    const { server, wss } = createServer(session);
    server.listen(0, '127.0.0.1', () =>
      resolve({ session, server, wss, port: server.address().port }));
    server.once('error', reject);
  });
}

/**
 * Chiude il server.
 * Termina prima tutte le connessioni WS rimaste aperte (evita che server.close() si blocchi),
 * poi chiude il WebSocketServer, infine l'HTTP server.
 */
async function stopServer(server, wss) {
  for (const client of wss.clients) client.terminate();
  await new Promise(r => wss.close(r));
  if (typeof server.closeAllConnections === 'function') server.closeAllConnections();
  return new Promise(r => server.close(r));
}

/**
 * Apre una connessione WS con buffer interno per i messaggi.
 * I messaggi che arrivano prima che nextMsg() venga chiamato vengono bufferizzati,
 * evitando race condition quando si aprono più connessioni in parallelo.
 */
function openWS(port) {
  return new Promise((resolve, reject) => {
    const ws = new WebSocket(`ws://127.0.0.1:${port}`);

    const _buf      = [];  // messaggi in attesa di essere consumati
    const _waiting  = [];  // resolver in attesa del prossimo messaggio

    ws.on('message', raw => {
      const msg = JSON.parse(raw.toString());
      if (_waiting.length) _waiting.shift()(msg);
      else _buf.push(msg);
    });

    // Attende il prossimo messaggio (o lo preleva dal buffer)
    ws.nextMsg = (timeoutMs = 800) => new Promise((res, rej) => {
      if (_buf.length) return res(_buf.shift());
      const handle = msg => { clearTimeout(t); res(msg); };
      const t = setTimeout(() => {
        const i = _waiting.indexOf(handle);
        if (i >= 0) _waiting.splice(i, 1);
        rej(new Error('WS message timeout'));
      }, timeoutMs);
      _waiting.push(handle);
    });

    ws.once('open',  () => resolve(ws));
    ws.once('error', reject);
  });
}

/**
 * Apre WS, consuma il messaggio di stato iniziale automatico,
 * e ritorna il socket pronto per i comandi.
 */
async function openReadyWS(port) {
  const ws  = await openWS(port);
  const msg = await ws.nextMsg();
  assert.strictEqual(msg.type, 'state');
  return ws;
}

/** Invia un comando WS e aspetta la risposta successiva. */
async function sendCmd(ws, cmd) {
  ws.send(JSON.stringify(cmd));
  return ws.nextMsg();
}

/** Chiude la WS connection e aspetta l'evento close. */
function closeWS(ws) {
  return new Promise(r => { ws.once('close', r); ws.close(); });
}

// ─── Suite 1 — HTTP ───────────────────────────────────────────────────────────

describe('server — HTTP', () => {
  test('GET /health → 200 con stato sessione', async () => {
    const { server, wss, port } = await startTestServer();
    try {
      const res  = await fetch(`http://127.0.0.1:${port}/health`);
      const body = await res.json();
      assert.strictEqual(res.status,   200);
      assert.strictEqual(body.status,  'ok');
      assert.strictEqual(body.session, 'ready');
    } finally {
      await stopServer(server, wss);
    }
  });

  test('GET /health riflette lo stato della sessione mock', async () => {
    const session = new MockSession();
    session.state = 'connecting';
    const { server, wss, port } = await startTestServer(session);
    try {
      const res  = await fetch(`http://127.0.0.1:${port}/health`);
      const body = await res.json();
      assert.strictEqual(body.session, 'connecting');
    } finally {
      await stopServer(server, wss);
    }
  });
});

// ─── Suite 2 — WebSocket connessione ─────────────────────────────────────────

describe('server — WebSocket connessione', () => {
  test('connessione WS → riceve stato corrente immediatamente', async () => {
    const { server, wss, port } = await startTestServer();
    try {
      const ws  = await openWS(port);
      const msg = await ws.nextMsg();
      await closeWS(ws);

      assert.strictEqual(msg.type,  'state');
      assert.strictEqual(msg.state, 'ready');
    } finally {
      await stopServer(server, wss);
    }
  });

  test('due client ricevono entrambi il messaggio di stato iniziale', async () => {
    const { server, wss, port } = await startTestServer();
    try {
      // Apriamo in parallelo: il buffer interno garantisce che il messaggio
      // iniziale non venga perso anche se arriva prima di nextMsg()
      const [ws1, ws2]   = await Promise.all([openWS(port), openWS(port)]);
      const [msg1, msg2] = await Promise.all([ws1.nextMsg(), ws2.nextMsg()]);
      await Promise.all([closeWS(ws1), closeWS(ws2)]);

      assert.strictEqual(msg1.type, 'state');
      assert.strictEqual(msg2.type, 'state');
    } finally {
      await stopServer(server, wss);
    }
  });
});

// ─── Suite 3 — Comandi ────────────────────────────────────────────────────────

describe('server — comandi WS', () => {
  test('getGroupStatus → result con dati corretti', async () => {
    const { server, wss, port } = await startTestServer();
    try {
      const ws  = await openReadyWS(port);
      const res = await sendCmd(ws, { type: 'getGroupStatus', id: 'req-1' });
      await closeWS(ws);

      assert.strictEqual(res.type,        'result');
      assert.strictEqual(res.id,          'req-1');
      assert.strictEqual(res.data.active, 0x0001);
    } finally {
      await stopServer(server, wss);
    }
  });

  test('getSysinfo → result con dati corretti', async () => {
    const { server, wss, port } = await startTestServer();
    try {
      const ws  = await openReadyWS(port);
      const res = await sendCmd(ws, { type: 'getSysinfo', id: 'req-2' });
      await closeWS(ws);

      assert.strictEqual(res.type,       'result');
      assert.strictEqual(res.data.name,  'Casa');
      assert.strictEqual(res.data.armed, true);
    } finally {
      await stopServer(server, wss);
    }
  });

  test('arm → result con maschera aggiornata', async () => {
    const { server, wss, port } = await startTestServer();
    try {
      const ws  = await openReadyWS(port);
      const res = await sendCmd(ws, { type: 'arm', groupId: 0, id: 'req-3' });
      await closeWS(ws);

      assert.strictEqual(res.type,        'result');
      assert.strictEqual(res.data.active, 0x0001); // bit 0
    } finally {
      await stopServer(server, wss);
    }
  });

  test('disarm → result con active=0', async () => {
    const { server, wss, port } = await startTestServer();
    try {
      const ws  = await openReadyWS(port);
      const res = await sendCmd(ws, { type: 'disarm', groupId: 0, id: 'req-4' });
      await closeWS(ws);

      assert.strictEqual(res.data.active, 0);
    } finally {
      await stopServer(server, wss);
    }
  });

  test('getZoneBlock → result con found=true', async () => {
    const { server, wss, port } = await startTestServer();
    try {
      const ws  = await openReadyWS(port);
      const res = await sendCmd(ws, { type: 'getZoneBlock', startIdx: 0, id: 'req-5' });
      await closeWS(ws);

      assert.strictEqual(res.data.found, true);
    } finally {
      await stopServer(server, wss);
    }
  });

  test('getText → result con testo', async () => {
    const { server, wss, port } = await startTestServer();
    try {
      const ws  = await openReadyWS(port);
      const res = await sendCmd(ws, { type: 'getText', entityType: 2, entityId: 0, id: 'req-6' });
      await closeWS(ws);

      assert.strictEqual(res.data.text, 'Test');
    } finally {
      await stopServer(server, wss);
    }
  });

  test('id assente → result con id=undefined', async () => {
    const { server, wss, port } = await startTestServer();
    try {
      const ws  = await openReadyWS(port);
      const res = await sendCmd(ws, { type: 'getGroupStatus' });
      await closeWS(ws);

      assert.strictEqual(res.type, 'result');
      assert.strictEqual(res.id,   undefined);
    } finally {
      await stopServer(server, wss);
    }
  });
});

// ─── Suite 4 — Gestione errori ────────────────────────────────────────────────

describe('server — errori WS', () => {
  test('JSON non valido → error senza id', async () => {
    const { server, wss, port } = await startTestServer();
    try {
      const ws = await openReadyWS(port);
      ws.send('{ non json }');
      const res = await ws.nextMsg();
      await closeWS(ws);

      assert.strictEqual(res.type, 'error');
      assert.match(res.message, /invalid JSON/i);
    } finally {
      await stopServer(server, wss);
    }
  });

  test('comando sconosciuto → error con messaggio', async () => {
    const { server, wss, port } = await startTestServer();
    try {
      const ws  = await openReadyWS(port);
      const res = await sendCmd(ws, { type: 'doSomethingRandom', id: 'e-1' });
      await closeWS(ws);

      assert.strictEqual(res.type, 'error');
      assert.strictEqual(res.id,   'e-1');
      assert.match(res.message, /unknown command/);
    } finally {
      await stopServer(server, wss);
    }
  });

  test('sessione lancia errore → error inoltrato al client con id', async () => {
    const session = new MockSession();
    session.getGroupStatus = async () => { throw new Error('session not ready'); };

    const { server, wss, port } = await startTestServer(session);
    try {
      const ws  = await openReadyWS(port);
      const res = await sendCmd(ws, { type: 'getGroupStatus', id: 'e-2' });
      await closeWS(ws);

      assert.strictEqual(res.type, 'error');
      assert.strictEqual(res.id,   'e-2');
      assert.match(res.message, /session not ready/);
    } finally {
      await stopServer(server, wss);
    }
  });
});

// ─── Suite 5 — Broadcast eventi ──────────────────────────────────────────────

describe('server — broadcast eventi di sessione', () => {
  test("evento 'state' viene inviato a tutti i client connessi", async () => {
    const session = new MockSession();
    const { server, wss, port } = await startTestServer(session);
    try {
      const [ws1, ws2] = await Promise.all([openWS(port), openWS(port)]);
      // Consuma i messaggi di stato iniziali
      await Promise.all([ws1.nextMsg(), ws2.nextMsg()]);

      // Raccoglie il prossimo messaggio da entrambi i client
      const pending = Promise.all([ws1.nextMsg(800), ws2.nextMsg(800)]);
      session.emit('state', 'reconnecting');
      const [msg1, msg2] = await pending;

      await Promise.all([closeWS(ws1), closeWS(ws2)]);

      assert.strictEqual(msg1.type,  'state');
      assert.strictEqual(msg1.state, 'reconnecting');
      assert.strictEqual(msg2.state, 'reconnecting');
    } finally {
      await stopServer(server, wss);
    }
  });

  test("evento 'login-failed' viene trasmesso con code e message", async () => {
    const session = new MockSession();
    const { server, wss, port } = await startTestServer(session);
    try {
      const ws      = await openReadyWS(port);
      const pending = ws.nextMsg(800);
      session.emit('login-failed', { code: 254, message: 'wrong code' });
      const msg = await pending;
      await closeWS(ws);

      assert.strictEqual(msg.type,    'login-failed');
      assert.strictEqual(msg.code,    254);
      assert.strictEqual(msg.message, 'wrong code');
    } finally {
      await stopServer(server, wss);
    }
  });

  test("push frame (CMD=8 SUB=0x88) viene inoltrato ai client", async () => {
    const session = new MockSession();
    const { server, wss, port } = await startTestServer(session);
    try {
      const ws      = await openReadyWS(port);
      const pending = ws.nextMsg(800);
      session.emit('frame', { cmd: 0x08, sub: 0x88, data: Buffer.from([0x01]) });
      const msg = await pending;
      await closeWS(ws);

      assert.strictEqual(msg.type, 'push');
      assert.strictEqual(msg.cmd,  0x08);
      assert.strictEqual(msg.sub,  0x88);
      assert.strictEqual(msg.data, '01');
    } finally {
      await stopServer(server, wss);
    }
  });
});

// ─── Suite 6 — dispatch() unit ───────────────────────────────────────────────

describe('dispatch — unit test senza server', () => {
  test('getGroupStatus → chiama session.getGroupStatus()', async () => {
    const session = new MockSession();
    const r = await dispatch(session, 'getGroupStatus', {});
    assert.strictEqual(r.active, 0x0001);
  });

  test('arm → chiama session.arm(groupId)', async () => {
    const session = new MockSession();
    const r = await dispatch(session, 'arm', { groupId: 1 });
    assert.strictEqual(r.active, 0x0002); // bit 1
  });

  test('getSysinfo → chiama session.getSysinfo()', async () => {
    const session = new MockSession();
    const r = await dispatch(session, 'getSysinfo', {});
    assert.strictEqual(r.name, 'Casa');
  });

  test('tipo sconosciuto → lancia Error', async () => {
    const session = new MockSession();
    await assert.rejects(
      () => dispatch(session, 'unknownCmd', {}),
      /unknown command/,
    );
  });
});
