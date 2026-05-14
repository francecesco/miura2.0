'use strict';

/**
 * connection.js — TCP client con riconnessione automatica
 *
 * Responsabilità ESCLUSIVE di questo modulo:
 *   - Aprire e mantenere la connessione TCP alla centrale
 *   - Riassemblare lo stream TCP in frame Miura (via protocol.makeStreamParser)
 *   - Riconnettersi con backoff esponenziale su errore o drop
 *   - Log hex TX/RX se DEBUG_PROTOCOL=1
 *
 * Non conosce il protocollo applicativo (login, keep-alive, sessione, ecc.).
 * Ogni frame ricevuto viene emesso come evento 'frame' senza interpretazione.
 *
 * Utilizzo:
 *   const conn = new Connection(host, port);
 *   conn.on('frame', parsed => { ... });
 *   conn.on('state', state => { ... });
 *   await conn.connect();
 *   conn.send(buildFrame(...));
 *   conn.disconnect();
 *
 * @fires Connection#frame       { cmd, sub, data, encKey, crcOk, decryptedPayload }
 * @fires Connection#state       'connecting' | 'connected' | 'reconnecting' | 'disconnected'
 * @fires Connection#reconnecting { attempt: number, delayMs: number }
 */

const net              = require('net');
const { EventEmitter } = require('events');
const { makeStreamParser } = require('./protocol');

const DEFAULTS = {
  connectTimeoutMs: 10_000,   // Y/e.java: socket.connect(..., 10000)
  reconnectBaseMs:   2_000,
  reconnectMaxMs:   30_000,
};

class Connection extends EventEmitter {
  #host;
  #port;
  #opts;
  #socket            = null;
  #parser;
  #state             = 'idle';
  #shouldReconnect   = false;
  #reconnectAttempts = 0;
  #reconnectTimer    = null;
  #connectResolve    = null;
  #connectReject     = null;
  #connectPromise    = null;

  /**
   * @param {string} host
   * @param {number} port
   * @param {object} [opts]
   * @param {number} [opts.connectTimeoutMs=10000]
   * @param {number} [opts.reconnectBaseMs=2000]
   * @param {number} [opts.reconnectMaxMs=30000]
   */
  constructor(host, port, opts = {}) {
    super();
    this.#host = host;
    this.#port = port;
    this.#opts = { ...DEFAULTS, ...opts };
    this.#parser = makeStreamParser(frame => {
      this.#logRx(frame);
      this.emit('frame', frame);
    });
  }

  /** Stato corrente della connessione */
  get state() { return this.#state; }

  /**
   * Avvia la connessione TCP.
   *
   * Ritorna una Promise che si risolve al **primo** TCP connect riuscito,
   * anche se sono necessari più tentativi. Fino a quel momento la Promise
   * è in pending e i tentativi avvengono in background.
   *
   * Chiamate successive restituiscono la stessa Promise (idempotente).
   * Dopo disconnect(), è possibile chiamare connect() di nuovo.
   *
   * @returns {Promise<void>}
   */
  connect() {
    if (this.#connectPromise) return this.#connectPromise;
    this.#shouldReconnect = true;
    this.#connectPromise  = new Promise((resolve, reject) => {
      this.#connectResolve = resolve;
      this.#connectReject  = reject;
    });
    this.#doConnect();
    return this.#connectPromise;
  }

  /**
   * Chiude la connessione e interrompe qualsiasi tentativo di riconnessione.
   * Se connect() è ancora in pending, la relativa Promise viene rigettata.
   * Dopo questa chiamata è possibile richiamare connect() per ripartire.
   */
  disconnect() {
    this.#shouldReconnect = false;
    clearTimeout(this.#reconnectTimer);
    this.#reconnectTimer = null;

    this.#destroySocket();
    this.#parser.reset();

    if (this.#connectReject) {
      this.#connectReject(new Error('disconnected'));
    }
    this.#connectResolve = null;
    this.#connectReject  = null;
    this.#connectPromise = null;

    this.#setState('disconnected');
  }

  /**
   * Invia un wire frame grezzo alla centrale.
   * Lancia un errore sincrono se la connessione non è attiva.
   *
   * @param {Buffer} wireFrame  prodotto da protocol.buildFrame()
   */
  send(wireFrame) {
    if (this.#state !== 'connected' || !this.#socket || this.#socket.destroyed) {
      throw new Error(`Cannot send: connection state is '${this.#state}'`);
    }
    this.#logTx(wireFrame);
    this.#socket.write(wireFrame);
  }

  // ─── Private ───────────────────────────────────────────────────────────────

  #setState(newState) {
    if (this.#state === newState) return;
    this.#state = newState;
    this.emit('state', newState);
  }

  #doConnect() {
    this.#setState('connecting');
    this.#parser.reset();

    const socket = new net.Socket();
    this.#socket = socket;

    socket.setTimeout(this.#opts.connectTimeoutMs);

    socket.once('connect', () => {
      socket.setTimeout(0); // annulla il timeout di connessione
      this.#reconnectAttempts = 0;
      this.#setState('connected');
      // Risolvi la Promise del primo connect, se ancora pending
      const res = this.#connectResolve;
      if (res) {
        this.#connectResolve = null;
        this.#connectReject  = null;
        res();
      }
    });

    socket.on('data', chunk => {
      this.#parser.push(chunk);
    });

    // Il timeout scade se il server non risponde entro connectTimeoutMs
    socket.once('timeout', () => {
      socket.destroy(new Error('connect timeout'));
    });

    // L'errore viene loggato ma non riemesso: 'close' seguirà e gestirà il reconnect.
    // Se chi usa questa classe vuole sapere degli errori socket, può ascoltare 'state'.
    socket.once('error', err => {
      if (process.env.DEBUG_PROTOCOL) {
        process.stderr.write(`[connection] socket error: ${err.message}\n`);
      }
    });

    // 'close' è l'evento canonico di fine vita del socket (fire after 'error' too)
    socket.once('close', () => {
      // Ignora eventi da socket precedenti (già rimpiazzati da #destroySocket)
      if (this.#socket !== socket) return;
      this.#socket = null;
      this.#handleDisconnect();
    });

    socket.connect(this.#port, this.#host);
  }

  #destroySocket() {
    if (!this.#socket) return;
    const s = this.#socket;
    this.#socket = null;
    s.removeAllListeners(); // previene callback stale, incluso il 'close' handler
    s.destroy();
  }

  #handleDisconnect() {
    if (!this.#shouldReconnect) {
      this.#setState('disconnected');
      return;
    }
    this.#scheduleReconnect();
  }

  #scheduleReconnect() {
    const delay = Math.min(
      this.#opts.reconnectBaseMs * (2 ** this.#reconnectAttempts),
      this.#opts.reconnectMaxMs,
    );
    this.#reconnectAttempts++;
    this.#setState('reconnecting');
    this.emit('reconnecting', { attempt: this.#reconnectAttempts, delayMs: delay });

    this.#reconnectTimer = setTimeout(() => {
      if (this.#shouldReconnect) this.#doConnect();
    }, delay);
  }

  #logTx(wireFrame) {
    if (!process.env.DEBUG_PROTOCOL) return;
    process.stderr.write(`[TX] ${wireFrame.toString('hex')}\n`);
  }

  #logRx(frame) {
    if (!process.env.DEBUG_PROTOCOL) return;
    const sub  = frame.sub !== null
      ? `0x${frame.sub.toString(16).padStart(2, '0')}`
      : 'null';
    const data = frame.data.length ? frame.data.toString('hex') : '(empty)';
    process.stderr.write(
      `[RX] cmd=0x${frame.cmd.toString(16).padStart(2, '0')}` +
      ` sub=${sub}` +
      ` enc=0x${frame.encKey.toString(16).padStart(2, '0')}` +
      ` crc=${frame.crcOk ? '✓' : '✗'}` +
      ` data=${data}\n`,
    );
  }
}

module.exports = { Connection };
