'use strict';

/**
 * Test per miura/protocol.js
 *
 * Eseguire con: node --test backend/test/protocol.test.js
 * (richiede Node >= 18; nessuna dipendenza esterna)
 */

const { test, describe } = require('node:test');
const assert = require('node:assert/strict');
const {
  crc16,
  decrypt,
  buildFrame,
  parseFrame,
  makeStreamParser,
} = require('../miura/protocol');

// ─── Helper ──────────────────────────────────────────────────────────────────

/** Estrae il payload (senza magic e LEN) da un wire frame prodotto da buildFrame */
function extractPayload(wireFrame) {
  return wireFrame.slice(4); // salta [2B 2A 2B][LEN]
}

// ─── crc16 ───────────────────────────────────────────────────────────────────

describe('crc16', () => {
  test('vettore standard CRC-16/MODBUS per "123456789"', () => {
    // Vettore di check ufficiale: CRC-16/MODBUS di "123456789" = 0x4B37
    const input = Buffer.from('123456789', 'ascii');
    assert.strictEqual(crc16(input), 0x4B37);
  });

  test('buffer vuoto restituisce il valore di init 0xFFFF', () => {
    assert.strictEqual(crc16(Buffer.alloc(0)), 0xFFFF);
  });

  test('single byte 0x00', () => {
    // Calcolato a mano: init=0xFFFF, XOR con 0x00 → 0xFFFF, poi 8 iterazioni di poly
    const result = crc16(Buffer.from([0x00]));
    assert.ok(typeof result === 'number');
    assert.ok(result >= 0 && result <= 0xFFFF);
  });

  test('stesso input produce sempre lo stesso CRC (determinismo)', () => {
    const buf = Buffer.from([0xF1, 0x00, 0x01, 0x00, 0x00]);
    assert.strictEqual(crc16(buf), crc16(buf));
  });
});

// ─── decrypt ─────────────────────────────────────────────────────────────────

describe('decrypt', () => {
  test('enc_key=0 restituisce copia invariata (plain)', () => {
    const payload = Buffer.from([0xF1, 0x00, 0x01, 0x80, 0x01, 0xAB, 0xCD]);
    const result = decrypt(payload);
    assert.deepStrictEqual(result, payload);
    assert.notStrictEqual(result, payload); // deve essere una copia
  });

  test('decifratura XOR corretta con chiave nota', () => {
    // Il server costruisce il frame PRIMA di XORare: imposta body[1]=key direttamente,
    // poi XOR body[0] e body[2+]. Quindi dopo decrypt:
    //   pos 0, 2+ → ripristinati al valore originale
    //   pos 1   → rimane enc_key (non c'è modo di recuperare il valore originale 0x00,
    //             ma in parseFrame usiamo solo dec[2+], mai dec[1] come dato)
    const key = 0x42;
    const original = [0xF1, 0x00, 0x01, 0x80, 0x05]; // plaintext originale
    const cipher = [
      original[0] ^ key, // B3
      key,               // 42 — chiave (set diretto, non XOR di 0x00)
      original[2] ^ key, // 43
      original[3] ^ key, // C2
      original[4] ^ key, // 47
    ];
    const result = decrypt(Buffer.from(cipher));
    // Dopo decrypt: pos 0 e 2+ ripristinati; pos 1 = enc_key (non l'originale 0x00)
    assert.strictEqual(result[0], original[0]); // F1 ✓
    assert.strictEqual(result[1], key);          // enc_key rimane (by design)
    assert.strictEqual(result[2], original[2]);  // CMD ✓
    assert.strictEqual(result[3], original[3]);  // SUB ✓
    assert.strictEqual(result[4], original[4]);  // data ✓
  });

  test('payload[1] rimane invariato dopo decifratura', () => {
    const key = 0x7F;
    const cipher = Buffer.from([0xF1 ^ key, key, 0x01 ^ key, 0x80 ^ key]);
    const result = decrypt(cipher);
    assert.strictEqual(result[1], key);
  });

  test('round-trip: tutte le posizioni eccetto [1] vengono ripristinate', () => {
    // Il round-trip ripristina tutto tranne pos 1: quella rimane enc_key per design.
    const plain = Buffer.from([0xF1, 0x00, 0x06, 0x02, 0xAA, 0xBB]);
    const key = 0x93;
    const cipher = Buffer.from(plain);
    cipher[0] ^= key;
    cipher[1] = key;  // set diretto, non XOR
    for (let i = 2; i < cipher.length; i++) cipher[i] ^= key;

    const restored = decrypt(cipher);
    assert.strictEqual(restored[0], plain[0]);  // F1 ✓
    assert.strictEqual(restored[1], key);       // enc_key rimane (non l'originale 0x00)
    for (let i = 2; i < plain.length; i++) {
      assert.strictEqual(restored[i], plain[i], `posizione ${i} non ripristinata`);
    }
  });
});

// ─── buildFrame ──────────────────────────────────────────────────────────────

describe('buildFrame', () => {
  test('magic [2B 2A 2B] è sempre presente in testa', () => {
    const frame = buildFrame(0x01, 0x00, Buffer.alloc(0));
    assert.strictEqual(frame[0], 0x2B);
    assert.strictEqual(frame[1], 0x2A);
    assert.strictEqual(frame[2], 0x2B);
  });

  test('LEN corrisponde alla lunghezza del payload', () => {
    const frame = buildFrame(0x06, 0x02, Buffer.alloc(0));
    const len = frame[3];
    assert.strictEqual(frame.length, 4 + len);
  });

  test('enc_key è sempre 0x00 (plain)', () => {
    const frame = buildFrame(0x01, 0x00, Buffer.alloc(0));
    // payload[1] = enc_key, trovato a frame[5]
    assert.strictEqual(frame[5], 0x00);
  });

  test('CMD e SUB si trovano nelle posizioni corrette', () => {
    const frame = buildFrame(0x06, 0x02, Buffer.alloc(0));
    // [2B 2A 2B][LEN][F1][00][CMD][SUB]...
    assert.strictEqual(frame[6], 0x06); // CMD
    assert.strictEqual(frame[7], 0x02); // SUB
  });

  test('confirm login (sub=null): payload di 5 byte, nessun SUB', () => {
    const frame = buildFrame(0x01, null, Buffer.alloc(0));
    // wire: [2B 2A 2B][05][F1][00][01][CRC_HI][CRC_LO]
    assert.strictEqual(frame[3], 5);   // LEN = 5
    assert.strictEqual(frame[6], 0x01); // CMD = auth, posizione dove sarebbe SUB
    // frame[6] è il CRC_HI se non c'è SUB? No: frame = [2B][2A][2B][05][F1][00][01][CH][CL]
    // indici:                                             0    1    2   3    4   5   6   7   8
    // CMD è a frame[6], poi frame[7]=CRC_HI, frame[8]=CRC_LO
    assert.strictEqual(frame.length, 9); // 4 (magic+len) + 5 (payload)
  });

  test('login request con PIN: lunghezza e struttura corretti', () => {
    // PIN di 6 cifre ASCII → 6 byte
    // body: [F1][00][01][00][00][p1][p2][p3][p4][p5][p6][00] = 12 byte
    // payload: body + CRC×2 = 14 byte
    const pin = Buffer.from('123456', 'ascii');
    const data = Buffer.concat([Buffer.from([0x00]), pin, Buffer.from([0x00])]);
    const frame = buildFrame(0x01, 0x00, data);
    assert.strictEqual(frame[3], 14); // LEN = 14
    assert.strictEqual(frame.length, 18); // 4 + 14
  });

  test('CRC è BIG-ENDIAN: (crc>>8)&FF poi crc&FF', () => {
    const frame = buildFrame(0x06, 0x02, Buffer.alloc(0));
    const payload = frame.slice(4);
    const n = payload.length;
    const body = payload.slice(0, n - 2);
    const expected = crc16(body);
    const hi = payload[n - 2];
    const lo = payload[n - 1];
    assert.strictEqual(hi, (expected >> 8) & 0xFF);
    assert.strictEqual(lo, expected & 0xFF);
  });

  test('accetta array numerico come data oltre a Buffer', () => {
    assert.doesNotThrow(() => buildFrame(0x06, 0x01, [0x01, 0x00, 0x00]));
  });

  test('accetta data=undefined (nessun dato)', () => {
    assert.doesNotThrow(() => buildFrame(0x01, 0x02, undefined));
  });
});

// ─── parseFrame ──────────────────────────────────────────────────────────────

describe('parseFrame', () => {
  test('restituisce null per payload troppo corto', () => {
    assert.strictEqual(parseFrame(Buffer.from([0xF1, 0x00, 0x01])), null);
    assert.strictEqual(parseFrame(Buffer.alloc(0)), null);
    assert.strictEqual(parseFrame(null), null);
  });

  test('round-trip con frame plain buildFrame→extractPayload→parseFrame', () => {
    const pin = Buffer.from('123456', 'ascii');
    const data = Buffer.concat([Buffer.from([0x00]), pin, Buffer.from([0x00])]);
    const wire = buildFrame(0x01, 0x00, data);
    const payload = extractPayload(wire);

    const parsed = parseFrame(payload);
    assert.ok(parsed);
    assert.strictEqual(parsed.cmd, 0x01);
    assert.strictEqual(parsed.sub, 0x00);
    assert.strictEqual(parsed.encKey, 0x00);
    assert.ok(parsed.crcOk, 'CRC deve essere valido');
    assert.deepStrictEqual(parsed.data, data);
  });

  test('round-trip con keep-alive (sub=0x02, data vuoto)', () => {
    const wire = buildFrame(0x01, 0x02, Buffer.alloc(0));
    const parsed = parseFrame(extractPayload(wire));
    assert.ok(parsed);
    assert.strictEqual(parsed.cmd, 0x01);
    assert.strictEqual(parsed.sub, 0x02);
    assert.ok(parsed.crcOk);
    assert.strictEqual(parsed.data.length, 0);
  });

  test('round-trip con confirm login (sub=null)', () => {
    const wire = buildFrame(0x01, null, Buffer.alloc(0));
    const parsed = parseFrame(extractPayload(wire));
    assert.ok(parsed);
    assert.strictEqual(parsed.cmd, 0x01);
    assert.strictEqual(parsed.sub, null);
    assert.ok(parsed.crcOk);
    assert.strictEqual(parsed.data.length, 0);
  });

  test('decodifica correttamente un payload cifrato del server', () => {
    // Il server cifra così (per PROTOCOL.md §3 — confermato da traffico reale):
    //   1. body = [F1, 0x00, CMD, SUB, DATA...]
    //   2. body[1] = enc_key  (set diretto, NON XOR)     → body = [F1, K, CMD, SUB, DATA...]
    //   3. crc = crc16(body)                             ← CRC include il key in posizione 1
    //   4. body += [CRC_HI, CRC_LO]
    //   5. body[0] ^= K; body[i] ^= K per i >= 2        ← XOR di tutto tranne posizione 1
    //
    // Dopo il nostro decrypt: dec[1] = K, tutto il resto ripristinato.
    // crc16(dec[0..n-3]) == CRC_val perché il CRC fu calcolato con K già in posizione 1.
    const key = 0x55;
    const body = Buffer.from([0xF1, key, 0x01, 0x80, 0x01]); // pos 1 = key (passo 2)
    const crcVal = crc16(body);                               // passo 3
    const withCrc = Buffer.concat([body, Buffer.from([(crcVal >> 8) & 0xFF, crcVal & 0xFF])]);
    const cipher = Buffer.from(withCrc);
    cipher[0] ^= key;                                         // passo 5
    for (let i = 2; i < cipher.length; i++) cipher[i] ^= key;

    const parsed = parseFrame(cipher);
    assert.ok(parsed, 'parseFrame non deve restituire null');
    assert.strictEqual(parsed.cmd, 0x01);
    assert.strictEqual(parsed.sub, 0x80);
    assert.strictEqual(parsed.encKey, key);
    assert.ok(parsed.crcOk, 'CRC deve essere valido dopo decifratura');
    assert.deepStrictEqual(Array.from(parsed.data), [0x01]); // user_id=1
  });

  test('crcOk=false se il payload è corrotto', () => {
    const wire = buildFrame(0x06, 0x02, Buffer.alloc(0));
    const payload = Buffer.from(extractPayload(wire));
    payload[payload.length - 1] ^= 0xFF; // corrompi l'ultimo byte (CRC_LO)
    const parsed = parseFrame(payload);
    assert.ok(parsed);
    assert.strictEqual(parsed.crcOk, false);
  });

  test('decryptedPayload non include i 2 byte CRC', () => {
    const wire = buildFrame(0x06, 0x02, Buffer.alloc(0));
    const payload = extractPayload(wire);
    const parsed = parseFrame(payload);
    assert.ok(parsed);
    assert.strictEqual(parsed.decryptedPayload.length, payload.length - 2);
  });
});

// ─── makeStreamParser ────────────────────────────────────────────────────────

describe('makeStreamParser', () => {
  test('un frame completo in un unico chunk', () => {
    const frames = [];
    const parser = makeStreamParser(f => frames.push(f));
    const wire = buildFrame(0x06, 0x02, Buffer.alloc(0));
    parser.push(wire);
    assert.strictEqual(frames.length, 1);
    assert.strictEqual(frames[0].cmd, 0x06);
    assert.ok(frames[0].crcOk);
  });

  test('frame distribuito su più chunk (input frammentato)', () => {
    const frames = [];
    const parser = makeStreamParser(f => frames.push(f));
    const wire = buildFrame(0x01, 0x02, Buffer.alloc(0)); // keep-alive
    // Invia byte per byte
    for (let i = 0; i < wire.length; i++) {
      parser.push(wire.slice(i, i + 1));
    }
    assert.strictEqual(frames.length, 1);
    assert.strictEqual(frames[0].cmd, 0x01);
    assert.strictEqual(frames[0].sub, 0x02);
    assert.ok(frames[0].crcOk);
  });

  test('due frame nello stesso chunk', () => {
    const frames = [];
    const parser = makeStreamParser(f => frames.push(f));
    const wire1 = buildFrame(0x06, 0x02, Buffer.alloc(0));
    const wire2 = buildFrame(0x0F, 0x01, Buffer.alloc(0));
    parser.push(Buffer.concat([wire1, wire2]));
    assert.strictEqual(frames.length, 2);
    assert.strictEqual(frames[0].cmd, 0x06);
    assert.strictEqual(frames[1].cmd, 0x0F);
  });

  test('resync: scarta byte spuri prima della magic', () => {
    const frames = [];
    const parser = makeStreamParser(f => frames.push(f));
    const garbage = Buffer.from([0xDE, 0xAD, 0xBE, 0xEF]);
    const wire = buildFrame(0x06, 0x02, Buffer.alloc(0));
    parser.push(Buffer.concat([garbage, wire]));
    assert.strictEqual(frames.length, 1);
    assert.strictEqual(frames[0].cmd, 0x06);
  });

  test('reset svuota il buffer interno', () => {
    const frames = [];
    const parser = makeStreamParser(f => frames.push(f));
    const wire = buildFrame(0x06, 0x02, Buffer.alloc(0));
    // Invia solo metà del frame
    parser.push(wire.slice(0, Math.floor(wire.length / 2)));
    parser.reset();
    // Dopo reset invia il frame completo: deve essere parsato correttamente
    parser.push(wire);
    assert.strictEqual(frames.length, 1);
    assert.strictEqual(frames[0].cmd, 0x06);
  });

  test('frame incompleto non emette eventi fino al completamento', () => {
    const frames = [];
    const parser = makeStreamParser(f => frames.push(f));
    const wire = buildFrame(0x01, 0x00, Buffer.from([0x00, 0x30, 0x38, 0x30, 0x38, 0x39, 0x33, 0x00]));
    // Invia tutto tranne l'ultimo byte
    parser.push(wire.slice(0, wire.length - 1));
    assert.strictEqual(frames.length, 0, 'nessun frame deve essere emesso se incompleto');
    // Ora invia l'ultimo byte
    parser.push(wire.slice(wire.length - 1));
    assert.strictEqual(frames.length, 1);
    assert.ok(frames[0].crcOk);
  });

  test('magic distribuita su due chunk', () => {
    // La magic [2B 2A 2B] arriva spezzata: prima [2B 2A] poi [2B ...payload...]
    const frames = [];
    const parser = makeStreamParser(f => frames.push(f));
    const wire = buildFrame(0x06, 0x02, Buffer.alloc(0));
    parser.push(wire.slice(0, 2));   // [2B 2A]
    assert.strictEqual(frames.length, 0);
    parser.push(wire.slice(2));      // [2B][LEN][PAYLOAD...]
    assert.strictEqual(frames.length, 1);
    assert.ok(frames[0].crcOk);
  });
});
