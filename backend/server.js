'use strict';

/**
 * server.js — HTTP + WebSocket bridge tra la sessione Miura e il browser
 *
 * Responsabilità:
 *   - Espone GET /health per health-check e monitoraggio
 *   - Serve i file statici della PWA (frontend/dist) quando presente
 *   - Mantiene connessioni WebSocket con i client (una per tab browser)
 *   - Inolta eventi di sessione (state, login-failed, push) a tutti i client
 *   - Esegue i comandi ricevuti via WS e risponde con il risultato
 *
 * Protocollo WebSocket (JSON):
 *
 *   Client → Server (comandi):
 *     { type: "getGroupStatus", id?: "..." }
 *     { type: "getSysinfo",     id?: "..." }
 *     { type: "arm",    groupId: 0, mode?: "full", id?: "..." }
 *     { type: "disarm", groupId: 0, id?: "..." }
 *     { type: "getZoneBlock", startIdx: 0, blockSize?: 7, isLast?: false, id?: "..." }
 *     { type: "getText", entityType: 2, entityId: 0, id?: "..." }
 *
 *   Server → Client (eventi e risposte):
 *     { type: "state",          state: "ready"|"connecting"|... }
 *     { type: "login-failed",   code: 254, message: "..." }
 *     { type: "session-expired" }
 *     { type: "push",           cmd: 8, sub: 136, data: "<hex>" }
 *     { type: "result",         id: "...", data: {...} }
 *     { type: "error",          id?: "...", message: "..." }
 */

const http    = require('http');
const path    = require('path');
const fs      = require('fs');
const express = require('express');
const { WebSocketServer } = require('ws');

// ─── WS command dispatcher ────────────────────────────────────────────────────

const COMMANDS = {
  getGroupStatus: (s)          => s.getGroupStatus(),
  getSysinfo:     (s)          => s.getSysinfo(),
  arm:            (s, p)       => s.arm(p.groupId, p.mode),
  disarm:         (s, p)       => s.disarm(p.groupId),
  getZoneBlock:   (s, p)       => s.getZoneBlock(p.startIdx, p.blockSize, p.isLast),
  getText:        (s, p)       => s.getText(p.entityType, p.entityId),
};

async function dispatch(session, type, params) {
  const handler = COMMANDS[type];
  if (!handler) throw new Error(`unknown command: ${type}`);
  return handler(session, params);
}

// ─── Server factory ───────────────────────────────────────────────────────────

/**
 * Crea e configura HTTP + WebSocket server.
 * Separato da main() per permettere i test con session mock.
 *
 * @param {object} session  istanza di Session (o mock compatibile)
 * @param {object} [cfg]    configurazione opzionale
 * @returns {{ app, server, wss }}
 */
function createServer(session, cfg = {}) {
  const app    = express();
  const server = http.createServer(app);
  const wss    = new WebSocketServer({ server });

  // ─── HTTP ──────────────────────────────────────────────────────────────

  app.get('/health', (_req, res) => {
    res.json({ status: 'ok', session: session.state });
  });

  // Serve la PWA se già buildata
  const staticDir = path.join(__dirname, '..', 'frontend', 'dist');
  if (fs.existsSync(staticDir)) {
    app.use(express.static(staticDir));
    // SPA fallback: tutte le route non-API servono index.html
    app.get('*', (_req, res) =>
      res.sendFile(path.join(staticDir, 'index.html')));
  }

  // ─── WebSocket ─────────────────────────────────────────────────────────

  /** Invia un messaggio JSON a tutti i client connessi. */
  function broadcast(msg) {
    const json = JSON.stringify(msg);
    for (const ws of wss.clients) {
      if (ws.readyState === ws.OPEN) ws.send(json);
    }
  }

  // Eventi di sessione → broadcast a tutti i client WS
  session.on('state', state =>
    broadcast({ type: 'state', state }));

  session.on('login-failed', ({ code, message }) =>
    broadcast({ type: 'login-failed', code, message }));

  session.on('session-expired', () =>
    broadcast({ type: 'session-expired' }));

  // Push non gestiti (CMD=8 SUB=0x88, CMD=0x10, ecc.)
  session.on('frame', frame =>
    broadcast({ type: 'push', cmd: frame.cmd, sub: frame.sub, data: frame.data.toString('hex') }));

  // Gestione connessione WS
  wss.on('connection', (ws) => {
    // Invia subito lo stato corrente al client appena connesso
    ws.send(JSON.stringify({ type: 'state', state: session.state }));

    ws.on('message', async (raw) => {
      let msg;
      try {
        msg = JSON.parse(raw.toString());
      } catch {
        ws.send(JSON.stringify({ type: 'error', message: 'invalid JSON' }));
        return;
      }

      const { type, id, ...params } = msg;

      try {
        const data = await dispatch(session, type, params);
        ws.send(JSON.stringify({ type: 'result', id, data }));
      } catch (err) {
        ws.send(JSON.stringify({ type: 'error', id, message: err.message }));
      }
    });

    ws.on('error', err => {
      if (cfg.debug?.protocol) {
        process.stderr.write(`[ws] client error: ${err.message}\n`);
      }
    });
  });

  return { app, server, wss };
}

// ─── Entry point ──────────────────────────────────────────────────────────────

if (require.main === module) {
  const { loadConfig } = require('./config');
  const { Connection } = require('./miura/connection');
  const { Session }    = require('./miura/session');

  const cfg     = loadConfig();
  const conn    = new Connection(cfg.miura.host, cfg.miura.port);
  const session = new Session(conn, cfg.miura.pin);

  const { server } = createServer(session, cfg);

  server.listen(cfg.server.port, () => {
    process.stdout.write(`Miura 2.0 listening on :${cfg.server.port}\n`);
  });

  // La sessione riprova automaticamente in caso di errore TCP
  session.connect().catch(err => {
    process.stderr.write(`[session] initial connect error: ${err.message}\n`);
  });

  // Graceful shutdown
  function shutdown(signal) {
    process.stderr.write(`\n[server] ${signal} — shutting down\n`);
    session.disconnect();
    server.close(() => process.exit(0));
    setTimeout(() => process.exit(1), 5_000).unref();
  }
  process.once('SIGINT',  () => shutdown('SIGINT'));
  process.once('SIGTERM', () => shutdown('SIGTERM'));
}

module.exports = { createServer, dispatch };
