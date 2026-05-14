'use strict';

/**
 * Test per config.js
 *
 * loadConfig accetta un oggetto env opzionale → nessuna variabile reale necessaria.
 * Eseguire con: node --test backend/test/config.test.js
 */

const { test, describe } = require('node:test');
const assert             = require('node:assert/strict');
const { loadConfig }     = require('../config');

const VALID = { MIURA_HOST: '192.168.1.100', MIURA_PIN: '123456' };

describe('config — loadConfig', () => {
  test('configurazione valida → oggetto con valori corretti', () => {
    const cfg = loadConfig(VALID);
    assert.strictEqual(cfg.miura.host, '192.168.1.100');
    assert.strictEqual(cfg.miura.pin,  '123456');
    assert.strictEqual(cfg.miura.port, 5400);    // default
    assert.strictEqual(cfg.server.port, 3000);   // default
    assert.strictEqual(cfg.debug.protocol, false); // default
  });

  test('MIURA_PORT e PORT personalizzati sovrascrivono i default', () => {
    const cfg = loadConfig({ ...VALID, MIURA_PORT: '9000', PORT: '8080' });
    assert.strictEqual(cfg.miura.port,  9000);
    assert.strictEqual(cfg.server.port, 8080);
  });

  test('DEBUG_PROTOCOL=1 → debug.protocol=true', () => {
    const cfg = loadConfig({ ...VALID, DEBUG_PROTOCOL: '1' });
    assert.strictEqual(cfg.debug.protocol, true);
  });

  test('DEBUG_PROTOCOL=0 → debug.protocol=false', () => {
    const cfg = loadConfig({ ...VALID, DEBUG_PROTOCOL: '0' });
    assert.strictEqual(cfg.debug.protocol, false);
  });

  test('MIURA_HOST mancante → lancia Error con nome della variabile', () => {
    assert.throws(
      () => loadConfig({ MIURA_PIN: '123456' }),
      /MIURA_HOST/,
    );
  });

  test('MIURA_PIN mancante → lancia Error con nome della variabile', () => {
    assert.throws(
      () => loadConfig({ MIURA_HOST: '192.168.1.1' }),
      /MIURA_PIN/,
    );
  });

  test('MIURA_HOST stringa vuota → lancia Error (trattata come assente)', () => {
    assert.throws(
      () => loadConfig({ MIURA_HOST: '  ', MIURA_PIN: '123456' }),
      /MIURA_HOST/,
    );
  });

  test('env vuoto → lancia Error su MIURA_HOST', () => {
    assert.throws(() => loadConfig({}), /MIURA_HOST/);
  });

  test('valori con spazi vengono trimmati', () => {
    const cfg = loadConfig({ MIURA_HOST: '  192.168.1.1  ', MIURA_PIN: ' 123456 ' });
    assert.strictEqual(cfg.miura.host, '192.168.1.1');
    assert.strictEqual(cfg.miura.pin,  '123456');
  });
});
