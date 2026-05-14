'use strict';

/**
 * Test per miura/commands.js
 *
 * Funzioni pure — nessun mock, nessuna rete.
 * Eseguire con: node --test backend/test/commands.test.js
 */

const { test, describe } = require('node:test');
const assert             = require('node:assert/strict');
const {
  decodeGroupStatus,
  decodeSysinfo,
  decodeZoneBlock,
  decodeText,
  ZONE_STATUS,
  TEXT_TYPE,
} = require('../miura/commands');

// ─── decodeGroupStatus ───────────────────────────────────────────────────────

describe('decodeGroupStatus', () => {
  test('decodifica 10 byte little-endian correttamente', () => {
    // active=0x0001, partial=0x0002, alarmMem=0x0003, zoneGroups=0x0004, zoneFail=0x0005
    const data = Buffer.from([
      0x01, 0x00,  // active    LE16
      0x02, 0x00,  // partial   LE16
      0x03, 0x00,  // alarmMem  LE16
      0x04, 0x00,  // zoneGroups LE16
      0x05, 0x00,  // zoneFail  LE16
    ]);
    const r = decodeGroupStatus(data);
    assert.strictEqual(r.active,     0x0001);
    assert.strictEqual(r.partial,    0x0002);
    assert.strictEqual(r.alarmMem,   0x0003);
    assert.strictEqual(r.zoneGroups, 0x0004);
    assert.strictEqual(r.zoneFail,   0x0005);
  });

  test('tutti i valori a zero (impianto disarmato senza anomalie)', () => {
    const r = decodeGroupStatus(Buffer.alloc(10));
    assert.strictEqual(r.active, 0);
    assert.strictEqual(r.zoneFail, 0);
  });

  test('dati reali osservati: zoneGroups=0x0001 (gruppo 0 con zone aperte)', () => {
    const data = Buffer.alloc(10);
    data.writeUInt16LE(0x0001, 6); // zoneGroups
    const r = decodeGroupStatus(data);
    assert.strictEqual(r.active,     0x0000);
    assert.strictEqual(r.zoneGroups, 0x0001);
  });

  test('restituisce null per dati troppo corti', () => {
    assert.strictEqual(decodeGroupStatus(Buffer.alloc(9)), null);
    assert.strictEqual(decodeGroupStatus(Buffer.alloc(0)), null);
    assert.strictEqual(decodeGroupStatus(null), null);
  });
});

// ─── decodeSysinfo ───────────────────────────────────────────────────────────

describe('decodeSysinfo', () => {
  test('decodifica flags, firmware, batteria e nome', () => {
    // Dati reali osservati: flags1=0x51 (ARMATO + bit4 + TROUBLE), fw=1.2, battery=4, name="TIM"
    const name = Buffer.from('TIM', 'ascii');
    const data = Buffer.concat([
      Buffer.from([0x51, 0x00, 0x00, 0x01, 0x02, 0x04]),
      name,
      Buffer.from([0x00]), // null terminator
    ]);
    const r = decodeSysinfo(data);
    assert.ok(r !== null);
    assert.strictEqual(r.armed,    true);   // bit0
    assert.strictEqual(r.partial,  false);  // bit1
    assert.strictEqual(r.trouble,  true);   // bit6
    assert.strictEqual(r.alarm,    false);  // bit7
    assert.strictEqual(r.flags1,   0x51);
    assert.strictEqual(r.firmware, '1.2');
    assert.strictEqual(r.battery,  4);
    assert.strictEqual(r.name,     'TIM');
  });

  test('flags1=0x00 → tutto disarmato e senza allarme', () => {
    const data = Buffer.from([0x00, 0x00, 0x00, 0x02, 0x00, 0x05]);
    const r = decodeSysinfo(data);
    assert.strictEqual(r.armed,   false);
    assert.strictEqual(r.alarm,   false);
    assert.strictEqual(r.battery, 5);
  });

  test('flags1=0x80 → allarme attivo', () => {
    const data = Buffer.from([0x80, 0x00, 0x00, 0x01, 0x00, 0x04]);
    assert.strictEqual(decodeSysinfo(data).alarm, true);
  });

  test('nome con null terminator in mezzo viene troncato', () => {
    const data = Buffer.concat([
      Buffer.from([0x00, 0x00, 0x00, 0x01, 0x00, 0x03]),
      Buffer.from('ABC\0XYZ', 'ascii'),
    ]);
    assert.strictEqual(decodeSysinfo(data).name, 'ABC');
  });

  test('nessun nome (solo 6 byte) → name=""', () => {
    const r = decodeSysinfo(Buffer.from([0x00, 0x00, 0x00, 0x01, 0x00, 0x03]));
    assert.strictEqual(r.name, '');
  });

  test('restituisce null per dati troppo corti', () => {
    assert.strictEqual(decodeSysinfo(Buffer.alloc(5)), null);
    assert.strictEqual(decodeSysinfo(null), null);
  });
});

// ─── decodeZoneBlock ─────────────────────────────────────────────────────────

describe('decodeZoneBlock', () => {
  test('found=false se flag != 0x01', () => {
    const r = decodeZoneBlock(Buffer.from([0x00, 0x00, 0x00]));
    assert.strictEqual(r.found, false);
    assert.deepStrictEqual(r.zones, []);
  });

  test('blocco vuoto (count=0) → found=true, zones=[]', () => {
    const r = decodeZoneBlock(Buffer.from([0x01, 0x00, 0x00]));
    assert.strictEqual(r.found, true);
    assert.deepStrictEqual(r.zones, []);
  });

  test('decodifica 3 zone correttamente', () => {
    // flag=0x01, offset=0x00, count=3
    // zona0: id=0, active=1, status=1 (ALARM)
    // zona1: id=1, active=1, status=1
    // zona2: id=2, active=0, status=0
    const data = Buffer.from([
      0x01, 0x00, 0x03,  // header
      0x00, 0x01, 0x01, 0x00,  // zona 0
      0x01, 0x01, 0x01, 0x00,  // zona 1
      0x02, 0x00, 0x00, 0x00,  // zona 2
    ]);
    const r = decodeZoneBlock(data);
    assert.strictEqual(r.found, true);
    assert.strictEqual(r.zones.length, 3);
    assert.strictEqual(r.zones[0].id,     0);
    assert.strictEqual(r.zones[0].active, true);
    assert.strictEqual(r.zones[0].status, 1); // alarm
    assert.strictEqual(r.zones[2].active, false);
    assert.strictEqual(r.zones[2].status, 0); // standby
  });

  test('dati reali: zone 0-2 allarme, zone 3-5 standby', () => {
    const data = Buffer.from([
      0x01, 0x00, 0x06,
      0x00, 0x01, 0x01, 0x00,
      0x01, 0x01, 0x01, 0x00,
      0x02, 0x01, 0x01, 0x00,
      0x03, 0x00, 0x00, 0x00,
      0x04, 0x00, 0x00, 0x00,
      0x05, 0x00, 0x00, 0x00,
    ]);
    const r = decodeZoneBlock(data);
    assert.strictEqual(r.zones.length, 6);
    assert.ok(r.zones.slice(0, 3).every(z => z.active && z.status === 1));
    assert.ok(r.zones.slice(3, 6).every(z => !z.active && z.status === 0));
  });

  test('payload troncato: interrompe senza crash', () => {
    // Dichiara 3 zone ma i dati si interrompono dopo 1
    const data = Buffer.from([
      0x01, 0x00, 0x03,
      0x00, 0x01, 0x01, 0x00, // solo zona 0 completa
    ]);
    const r = decodeZoneBlock(data);
    assert.strictEqual(r.found, true);
    assert.strictEqual(r.zones.length, 1); // solo quella che entra
  });

  test('restituisce null per dati troppo corti', () => {
    assert.strictEqual(decodeZoneBlock(Buffer.alloc(2)), null);
    assert.strictEqual(decodeZoneBlock(null), null);
  });
});

// ─── decodeText ──────────────────────────────────────────────────────────────

describe('decodeText', () => {
  test('decodifica tipo, ID e testo', () => {
    // type=2 (GROUP), id=0 (LE16), text="Zona notte"
    const text = Buffer.from('Zona notte\0', 'ascii');
    const data = Buffer.concat([Buffer.from([0x02, 0x00, 0x00]), text]);
    const r = decodeText(data);
    assert.strictEqual(r.type, 2);
    assert.strictEqual(r.id,   0);
    assert.strictEqual(r.text, 'Zona notte');
  });

  test('id multi-byte (LE16)', () => {
    const data = Buffer.concat([
      Buffer.from([0x03, 0x07, 0x00]),  // type=ZONE, id=7
      Buffer.from('Finestra\0', 'ascii'),
    ]);
    const r = decodeText(data);
    assert.strictEqual(r.id,   7);
    assert.strictEqual(r.text, 'Finestra');
  });

  test('testo senza null terminator → tutto il buffer dopo offset 3', () => {
    const data = Buffer.from([0x01, 0x00, 0x00, 65, 66, 67]); // type=1, id=0, "ABC"
    assert.strictEqual(decodeText(data).text, 'ABC');
  });

  test('restituisce null per dati troppo corti', () => {
    assert.strictEqual(decodeText(Buffer.alloc(3)), null);
    assert.strictEqual(decodeText(null), null);
  });
});

// ─── Costanti esportate ───────────────────────────────────────────────────────

describe('costanti esportate', () => {
  test('ZONE_STATUS ha i valori corretti', () => {
    assert.strictEqual(ZONE_STATUS[0], 'standby');
    assert.strictEqual(ZONE_STATUS[1], 'alarm');
    assert.strictEqual(ZONE_STATUS[2], 'tamper');
    assert.strictEqual(ZONE_STATUS[3], 'fault');
  });

  test('TEXT_TYPE ha i valori corretti', () => {
    assert.strictEqual(TEXT_TYPE.AREA,   1);
    assert.strictEqual(TEXT_TYPE.GROUP,  2);
    assert.strictEqual(TEXT_TYPE.ZONE,   3);
    assert.strictEqual(TEXT_TYPE.REMOTE, 4);
    assert.strictEqual(TEXT_TYPE.TIMER,  8);
  });
});
