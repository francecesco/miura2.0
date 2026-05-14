'use strict';

/**
 * session.js — stato applicativo della sessione Miura
 *
 * Gestisce il ciclo di vita completo: login, keep-alive, comandi, riconnessione.
 * Non conosce TCP/socket: delega tutto a un'istanza di Connection.
 *
 * Macchina a stati:
 *   idle → connecting → logging_in → ready → reconnecting → logging_in → ...
 *                                  ↓
 *                                closed  (login fallito o disconnect manuale)
 *
 * @fires Session#state          'connecting'|'logging_in'|'ready'|'reconnecting'|'closed'
 * @fires Session#login-failed   { code: number, message: string }
 * @fires Session#session-expired
 * @fires Session#frame          frame grezzo non gestito (push asincroni, ecc.)
 */

const { EventEmitter } = require('events');
const { buildFrame }   = require('./protocol');
const {
  decodeGroupStatus,
  decodeSysinfo,
  decodeZoneBlock,
  decodeText,
} = require('./commands');

const KEEPALIVE_MS  = 20_000;  // §8: inattività TX
const CMD_TIMEOUT_MS = 25_000; // §16: timeout risposta

const LOGIN_ERROR_MSG = {
  0:   'user not found',
  250: 'not authorized remotely',
  251: 'time restriction',
  252: 'group activated',
  253: 'session already open',
  254: 'wrong code',
  255: 'user not found',
};

class Session extends EventEmitter {
  #conn;
  #pin;
  #state = 'idle';

  // Promise di connect() — si risolve al primo READY
  #connectPromise  = null;
  #connectResolve  = null;
  #connectReject   = null;

  // Comando in volo: { expectCmd, expectSubs, resolve, reject, decode, timerId }
  #pending = null;
  // Coda comandi in attesa di #pending libero
  #queue   = [];

  #keepAliveTimer = null;

  // Fase corrente del login
  #loginStep = 'none'; // 'none' | 'awaiting-response' | 'awaiting-broadcast'

  /**
   * @param {import('./connection').Connection} conn
   * @param {string|number} pin  codice di accesso (letto da env MIURA_PIN)
   */
  constructor(conn, pin) {
    super();
    this.#conn = conn;
    this.#pin  = String(pin);
    this.#conn.on('state', s => this.#onConnState(s));
    this.#conn.on('frame', f => this.#onFrame(f));
  }

  get state() { return this.#state; }

  /**
   * Avvia la sessione. Risolve quando lo stato diventa 'ready'.
   * Idempotente se già in corso. Consentito anche dallo stato 'closed' (opzione b):
   * resetta la connessione e riparte da zero.
   *
   * @returns {Promise<void>}
   */
  connect() {
    if (this.#state === 'closed') {
      this.#conn.disconnect();
      this.#state          = 'idle';
      this.#connectPromise = null;
      this.#connectResolve = null;
      this.#connectReject  = null;
      this.#loginStep      = 'none';
    }

    if (this.#state === 'ready') return Promise.resolve();
    if (this.#connectPromise)    return this.#connectPromise;

    this.#connectPromise = new Promise((resolve, reject) => {
      this.#connectResolve = resolve;
      this.#connectReject  = reject;
    });

    this.#conn.connect().catch(() => {}); // riconnessione gestita da Connection

    return this.#connectPromise;
  }

  /**
   * Chiude la sessione. La Promise di connect() (se pending) viene rigettata.
   * I comandi in coda vengono rigettati con Error('disconnected').
   * Dopo questa chiamata è possibile richiamare connect() (opzione b).
   */
  disconnect() {
    this.#stopKeepAlive();
    const err = new Error('disconnected');
    this.#cancelPending(err);
    this.#drainQueue(err);

    this.#conn.disconnect();

    const rej         = this.#connectReject;
    this.#connectPromise = null;
    this.#connectResolve = null;
    this.#connectReject  = null;
    this.#loginStep      = 'none';

    this.#setState('closed');
    if (rej) rej(err);
  }

  /**
   * Richiede lo stato dei gruppi.
   * @returns {Promise<{active,partial,alarmMem,zoneGroups,zoneFail}|null>}
   */
  async getGroupStatus() {
    await this.#waitReady();
    return this.#enqueueCommand(
      buildFrame(0x06, 0x02, Buffer.alloc(0)),
      0x06, [0x80],
      f => decodeGroupStatus(f.data),
    );
  }

  /**
   * Arma un gruppo.
   * @param {number} groupId  indice del gruppo (0-based)
   * @param {'full'|'partial'} [mode='full']
   */
  async arm(groupId, mode = 'full') {
    if (mode === 'partial') throw new Error('partial arm not yet implemented');
    await this.#waitReady();
    const mask = 1 << groupId;
    const data = Buffer.from([(mask & 0xFF), (mask >> 8) & 0xFF, 0x00]);
    return this.#enqueueCommand(
      buildFrame(0x06, 0x01, data),
      0x06, [0x80, 0x81],
      f => decodeGroupStatus(f.data),
    );
  }

  /**
   * Disarma un gruppo.
   * @param {number} groupId  indice del gruppo (0-based)
   */
  async disarm(groupId) {
    await this.#waitReady();
    const mask = 1 << groupId;
    const data = Buffer.from([(mask & 0xFF), (mask >> 8) & 0xFF, 0x01]);
    return this.#enqueueCommand(
      buildFrame(0x06, 0x01, data),
      0x06, [0x80, 0x81],
      f => decodeGroupStatus(f.data),
    );
  }

  /**
   * Richiede le informazioni di sistema (firmware, batteria, nome impianto, stato).
   * @returns {Promise<{armed,partial,trouble,alarm,firmware,battery,name}|null>}
   */
  async getSysinfo() {
    await this.#waitReady();
    return this.#enqueueCommand(
      buildFrame(0x0F, 0x01, Buffer.alloc(0)),
      0x0F, [0x80],
      f => decodeSysinfo(f.data),
    );
  }

  /**
   * Richiede un blocco di zone (max 7 per blocco).
   * Inviare più chiamate consecutive con startIdx crescente per caricare tutte le zone.
   *
   * @param {number} startIdx   indice di partenza (0, 7, 14, …)
   * @param {number} [blockSize=7]
   * @param {boolean} [isLast=false]  true sull'ultima richiesta del batch
   * @returns {Promise<{found: boolean, zones: Array<{id,active,status}>}|null>}
   */
  async getZoneBlock(startIdx, blockSize = 7, isLast = false) {
    await this.#waitReady();
    const flag = isLast ? 0x0F : 0x01;
    const data = Buffer.from([flag, startIdx & 0xFF, blockSize & 0xFF]);
    return this.#enqueueCommand(
      buildFrame(0x07, 0x01, data),
      0x07, [0x81],
      f => decodeZoneBlock(f.data),
    );
  }

  /**
   * Richiede il nome testuale di un'entità (area, gruppo, zona, ecc.).
   *
   * @param {number} entityType  1=area, 2=gruppo, 3=zona, 4=telecomando, 8=timer
   * @param {number} entityId    ID dell'elemento (0-based)
   * @returns {Promise<{type, id, text}|null>}
   */
  async getText(entityType, entityId) {
    await this.#waitReady();
    const data = Buffer.from([
      entityType & 0xFF,
      entityId & 0xFF,
      (entityId >> 8) & 0xFF,
    ]);
    return this.#enqueueCommand(
      buildFrame(0x03, 0x00, data),
      0x03, [0x80, 0x81],
      f => decodeText(f.data),
    );
  }

  // ─── Privato ──────────────────────────────────────────────────────────────

  #setState(newState) {
    if (this.#state === newState) return;
    this.#state = newState;
    this.emit('state', newState);
  }

  /** Attende che la sessione sia in 'ready'; rigetta se va in 'closed'. */
  #waitReady() {
    if (this.#state === 'ready')  return Promise.resolve();
    if (this.#state === 'closed') return Promise.reject(new Error('session closed'));
    return new Promise((resolve, reject) => {
      const onState = (s) => {
        if (s === 'ready')  { this.off('state', onState); resolve(); }
        if (s === 'closed') { this.off('state', onState); reject(new Error('session closed')); }
      };
      this.on('state', onState);
    });
  }

  #enqueueCommand(frame, expectCmd, expectSubs, decode) {
    return new Promise((resolve, reject) => {
      const entry = { frame, expectCmd, expectSubs, resolve, reject, decode };
      if (!this.#pending) {
        this.#dispatchCommand(entry);
      } else {
        this.#queue.push(entry);
      }
    });
  }

  #dispatchCommand({ frame, expectCmd, expectSubs, resolve, reject, decode }) {
    const timerId = setTimeout(() => {
      this.#pending = null;
      reject(new Error('command timeout'));
      this.#pumpQueue();
    }, CMD_TIMEOUT_MS).unref();

    this.#pending = { expectCmd, expectSubs, resolve, reject, decode, timerId };
    this.#sendFrame(frame);
  }

  #pumpQueue() {
    if (this.#queue.length > 0 && this.#state === 'ready' && !this.#pending) {
      this.#dispatchCommand(this.#queue.shift());
    }
  }

  #cancelPending(err) {
    if (!this.#pending) return;
    clearTimeout(this.#pending.timerId);
    this.#pending.reject(err);
    this.#pending = null;
  }

  #drainQueue(err) {
    for (const entry of this.#queue) entry.reject(err);
    this.#queue = [];
  }

  #sendFrame(frame) {
    this.#resetKeepAlive();
    this.#conn.send(frame);
  }

  // ─── Stato Connection → stato Session ────────────────────────────────────

  #onConnState(connState) {
    if (connState === 'connecting') {
      // Solo dalla prima connessione (idle); in riconnessione si resta in 'reconnecting'
      if (this.#state === 'idle') this.#setState('connecting');

    } else if (connState === 'connected') {
      if (this.#state !== 'closed') {
        this.#setState('logging_in');
        this.#loginStep = 'awaiting-response';
        this.#sendLoginRequest();
      }

    } else if (connState === 'reconnecting') {
      if (['connecting', 'logging_in', 'ready'].includes(this.#state)) {
        this.#stopKeepAlive();
        const err = new Error('reconnecting');
        this.#cancelPending(err);
        this.#drainQueue(err);
        this.#loginStep = 'none';
        this.#setState('reconnecting');
      }
    }
    // 'disconnected': gestito esplicitamente da disconnect()
  }

  // ─── Sequenza di login ────────────────────────────────────────────────────

  #sendLoginRequest() {
    const pinBytes = Buffer.from(this.#pin, 'ascii');
    const data = Buffer.concat([Buffer.from([0x00]), pinBytes, Buffer.from([0x00])]);
    this.#conn.send(buildFrame(0x01, 0x00, data));
  }

  #onFrame(frame) {
    if (this.#state === 'logging_in') {
      if (this.#onLoginFrame(frame)) return;
    }

    // Session broadcast asincrono (CMD=1 SUB=3 status=0xFF) anche in READY
    if (frame.cmd === 0x01 && frame.sub === 0x03 && frame.data[0] === 0xFF) {
      this.#handleSessionExpired();
      return;
    }

    // Risposta a comando in volo
    if (this.#pending) {
      const { expectCmd, expectSubs } = this.#pending;
      if (frame.cmd === expectCmd && expectSubs.includes(frame.sub)) {
        const p = this.#pending;
        this.#pending = null;
        clearTimeout(p.timerId);
        p.resolve(p.decode ? p.decode(frame) : frame);
        this.#pumpQueue();
        return;
      }
    }

    // Push non gestiti (CMD=8 SUB=0x88, CMD=0x10, ecc.) → inoltro al layer superiore
    this.emit('frame', frame);
  }

  #onLoginFrame(frame) {
    // Login response: CMD=1 SUB=0x80
    if (frame.cmd === 0x01 && frame.sub === 0x80 && this.#loginStep === 'awaiting-response') {
      const userId  = frame.data[0];
      const isError = userId === 0 || userId >= 250;

      if (isError) {
        const message = LOGIN_ERROR_MSG[userId] ?? `error code ${userId}`;
        this.emit('login-failed', { code: userId, message });

        // Login fallito → nessuna riconnessione automatica
        this.#conn.disconnect();
        const rej            = this.#connectReject;
        this.#connectPromise = null;
        this.#connectResolve = null;
        this.#connectReject  = null;
        this.#loginStep      = 'none';
        this.#setState('closed');
        if (rej) rej(new Error(`login failed: ${message}`));
        return true;
      }

      // Successo: invia Confirm Login (CMD=1, sub=null → 5 byte, §7.3)
      this.#loginStep = 'awaiting-broadcast';
      this.#conn.send(buildFrame(0x01, null, Buffer.alloc(0)));
      return true;
    }

    // Session Broadcast: CMD=1 SUB=0x03
    if (frame.cmd === 0x01 && frame.sub === 0x03 && this.#loginStep === 'awaiting-broadcast') {
      const status = frame.data[0];
      if (status === 0x81) {
        this.#loginStep = 'done';
        this.#setState('ready');
        this.#startKeepAlive();
        const res = this.#connectResolve;
        this.#connectResolve = null;
        this.#connectReject  = null;
        if (res) res();
        this.#pumpQueue();
        return true;
      }
      if (status === 0xFF) {
        this.#handleSessionExpired();
        return true;
      }
      return true;
    }

    return false;
  }

  #handleSessionExpired() {
    this.emit('session-expired');
    this.#stopKeepAlive();
    this.#cancelPending(new Error('session expired'));
    this.#drainQueue(new Error('session expired'));
    this.#loginStep = 'none';
    this.#setState('reconnecting');
    // Il server chiuderà il TCP; Connection gestirà la riconnessione automaticamente.
  }

  // ─── Keep-alive ───────────────────────────────────────────────────────────

  #startKeepAlive() {
    this.#resetKeepAlive();
  }

  #stopKeepAlive() {
    clearTimeout(this.#keepAliveTimer);
    this.#keepAliveTimer = null;
  }

  #resetKeepAlive() {
    this.#stopKeepAlive();
    if (this.#state !== 'ready') return;
    this.#keepAliveTimer = setTimeout(() => {
      if (this.#state === 'ready') {
        this.#conn.send(buildFrame(0x01, 0x02, Buffer.alloc(0)));
        this.#resetKeepAlive();
      }
    }, KEEPALIVE_MS).unref();
  }
}

module.exports = { Session };
