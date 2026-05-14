'use strict';

/**
 * config.js — caricamento e validazione della configurazione
 *
 * Utilizzo nel server:
 *   const { loadConfig } = require('./config');
 *   const config = loadConfig();          // legge process.env
 *
 * Utilizzo nei test (senza .env):
 *   const { loadConfig } = require('./config');
 *   const cfg = loadConfig({ MIURA_HOST: '...', MIURA_PIN: '...' });
 *
 * Avvio con .env:
 *   node --env-file=.env backend/server.js
 */

function loadConfig(env = process.env) {
  function required(name) {
    const val = (env[name] || '').trim();
    if (!val) throw new Error(`${name} è richiesto (vedi .env.example)`);
    return val;
  }
  function optional(name, fallback) {
    return (env[name] || '').trim() || String(fallback);
  }

  return {
    miura: {
      host: required('MIURA_HOST'),
      port: parseInt(optional('MIURA_PORT', '5400'), 10),
      pin:  required('MIURA_PIN'),
    },
    server: {
      port: parseInt(optional('PORT', '3000'), 10),
    },
    debug: {
      protocol: optional('DEBUG_PROTOCOL', '0') === '1',
    },
  };
}

module.exports = { loadConfig };
