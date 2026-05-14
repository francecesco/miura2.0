'use strict';

/**
 * commands.js — decodificatori puri per le risposte di comando Miura
 *
 * Nessun I/O, nessun side effect. Tutte le funzioni accettano un Buffer `data`
 * (il campo `frame.data` già decifrato da parseFrame) e restituiscono un oggetto
 * strutturato, oppure null se il payload è troppo corto o non riconoscibile.
 *
 * Riferimenti PROTOCOL.md:
 *   §9.2  decodeGroupStatus  CMD=0x06 SUB=0x80/0x81/0x82
 *   §10.2 decodeZoneBlock    CMD=0x07 SUB=0x81
 *   §12.2 decodeText         CMD=0x03
 *   §14.2 decodeSysinfo      CMD=0x0F SUB=0x80
 */

// ─── §9.2 Stato gruppi ───────────────────────────────────────────────────────

/**
 * Decodifica la risposta di stato gruppi (CMD=0x06, SUB=0x80/0x81/0x82).
 *
 * @param {Buffer} data  frame.data (10 byte)
 * @returns {{ active, partial, alarmMem, zoneGroups, zoneFail } | null}
 */
function decodeGroupStatus(data) {
  if (!data || data.length < 10) return null;
  return {
    active:     data.readUInt16LE(0),
    partial:    data.readUInt16LE(2),
    alarmMem:   data.readUInt16LE(4),
    zoneGroups: data.readUInt16LE(6),
    zoneFail:   data.readUInt16LE(8),
  };
}

// ─── §14.2 Sysinfo ───────────────────────────────────────────────────────────

/**
 * Decodifica la risposta sysinfo (CMD=0x0F, SUB=0x80).
 *
 * @param {Buffer} data  frame.data (minimo 6 byte)
 * @returns {{ armed, partial, trouble, alarm, flags1, flags2, firmware, battery, name } | null}
 */
function decodeSysinfo(data) {
  if (!data || data.length < 6) return null;
  const flags1 = data[0];
  return {
    armed:    !!(flags1 & 0x01),
    partial:  !!(flags1 & 0x02),
    trouble:  !!(flags1 & 0x40),
    alarm:    !!(flags1 & 0x80),
    flags1,
    flags2:   data[1],
    firmware: `${data[3]}.${data[4]}`,
    battery:  data[5],
    name:     data.length > 6
      ? data.slice(6).toString('ascii').replace(/\0.*$/, '').trim()
      : '',
  };
}

// ─── §10.2 Blocco zone ───────────────────────────────────────────────────────

/**
 * Status zone (§10.2):
 *   0 = standby, 1 = allarme, 2 = manomissione, 3 = guasto
 */
const ZONE_STATUS = Object.freeze({ 0: 'standby', 1: 'alarm', 2: 'tamper', 3: 'fault' });

/**
 * Decodifica un blocco di zone (CMD=0x07, SUB=0x81).
 *
 * @param {Buffer} data  frame.data
 * @returns {{ found: boolean, zones: Array<{id, active, status}> } | null}
 */
function decodeZoneBlock(data) {
  if (!data || data.length < 3) return null;
  if (data[0] !== 0x01) return { found: false, zones: [] };

  const count = data[2];
  const zones = [];
  for (let i = 0; i < count; i++) {
    const base = 3 + i * 4;
    if (base + 3 >= data.length) break; // payload troncato
    zones.push({
      id:     data[base],
      active: data[base + 1] === 1,
      status: data.readUInt16LE(base + 2),
    });
  }
  return { found: true, zones };
}

// ─── §12.2 Testi / Nomi ──────────────────────────────────────────────────────

/**
 * Tipi di entità per getText (§12.1):
 *   1=area, 2=gruppo, 3=zona, 4=telecomando, 8=timer
 */
const TEXT_TYPE = Object.freeze({ AREA: 1, GROUP: 2, ZONE: 3, REMOTE: 4, TIMER: 8 });

/**
 * Decodifica la risposta di testo/nome (CMD=0x03).
 *
 * @param {Buffer} data  frame.data (minimo 4 byte)
 * @returns {{ type, id, text } | null}
 */
function decodeText(data) {
  if (!data || data.length < 4) return null;
  return {
    type: data[0],
    id:   data.readUInt16LE(1),
    text: data.slice(3).toString('ascii').replace(/\0.*$/, '').trim(),
  };
}

// ─── Exports ─────────────────────────────────────────────────────────────────

module.exports = {
  decodeGroupStatus,
  decodeSysinfo,
  decodeZoneBlock,
  decodeText,
  ZONE_STATUS,
  TEXT_TYPE,
};
