# Miura 2.0

Replica PWA self-hosted dell'applicazione mobile **Miura Tervis** per la gestione di impianti di allarme Tervis, dismessa dall'App Store.

Deployabile via Docker su CasaOS / ZimaBoard. Nessuna dipendenza da cloud Tervis: tutto avviene tramite connessione TCP diretta alla centrale.

---

## Architettura

```
Browser (PWA)
    │  WebSocket
    ▼
Express + WS server       ← backend/server.js  (TODO)
    │
    ├── Session           ← backend/miura/session.js
    │     └── Connection  ← backend/miura/connection.js
    │           └── Protocol codec ← backend/miura/protocol.js
    │
    └── Config            ← caricata da env / .env
```

Il protocollo TCP è documentato in dettaglio in [docs/PROTOCOL.md](docs/PROTOCOL.md), ricavato per reverse engineering dall'APK originale (jadx 1.5.5).

---

## Stato del progetto

| Fase | Componente | Stato |
|------|-----------|-------|
| 1 | Reverse engineering protocollo | ✅ Completato |
| 2 | `protocol.js` — codec puro CRC + cifratura + framing | ✅ Completato (31 test) |
| 2 | `connection.js` — TCP client con reconnect esponenziale | ✅ Completato (15 test) |
| 2 | `session.js` — macchina a stati login/keep-alive/comandi | ✅ Completato (11 test) |
| 3 | `server.js` — Express + WebSocket | 🔲 TODO |
| 4 | Frontend Vue 3 + Vite + PWA | 🔲 TODO |
| 5 | Dockerfile + docker-compose | 🔲 TODO |

---

## Requisiti

- **Node.js 20+**
- Accesso di rete alla centrale Tervis (TCP, porta configurabile)

---

## Configurazione

```bash
cp .env.example .env
# Editare .env con IP, porta e PIN della propria centrale
```

Variabili d'ambiente:

| Variabile | Default | Descrizione |
|-----------|---------|-------------|
| `MIURA_HOST` | — | IP o hostname della centrale (obbligatorio) |
| `MIURA_PORT` | `5400` | Porta TCP |
| `MIURA_PIN` | — | Codice di accesso utente |
| `DEBUG_PROTOCOL` | `0` | Se `1`, logga hex TX/RX su stderr |

---

## Esecuzione test

```bash
# Tutti i test backend (nessuna connessione reale necessaria)
node --test backend/test/protocol.test.js
node --test backend/test/connection.test.js
node --test backend/test/session.test.js
```

Output atteso: **57 test, 0 fail**.

---

## Strumento di diagnostica

`tools/protocol-probe.js` consente di validare il protocollo contro una centrale reale:

```bash
# Handshake completo (login → status → gruppi)
MIURA_HOST=<ip> MIURA_PIN=<pin> node tools/protocol-probe.js --mode handshake

# Ascolto passivo frame (utile per reverse engineering)
MIURA_HOST=<ip> MIURA_PIN=<pin> node tools/protocol-probe.js --mode listen

# Invio comando singolo
MIURA_HOST=<ip> MIURA_PIN=<pin> node tools/protocol-probe.js --mode send --cmd status
MIURA_HOST=<ip> MIURA_PIN=<pin> node tools/protocol-probe.js --mode send --cmd arm --group 0
```

---

## Protocollo

Il file [docs/PROTOCOL.md](docs/PROTOCOL.md) documenta:

- Wire format completo (magic, LEN, payload, CRC-16 BIG-ENDIAN)
- Cifratura XOR asimmetrica (client → plain, server → cifrato)
- Sequenza di login (request → response → confirm → session broadcast)
- Comandi: stato gruppi, arm/disarm, zone, sysinfo, keep-alive
- Push asincroni dalla centrale (log notif, session expired)

---

## Struttura del repository

```
miura2.0/
├── backend/
│   ├── miura/
│   │   ├── protocol.js      # codec puro: CRC, cifratura, buildFrame, parseFrame
│   │   ├── connection.js    # TCP client con reconnect esponenziale
│   │   └── session.js       # macchina a stati sessione applicativa
│   └── test/
│       ├── protocol.test.js
│       ├── connection.test.js
│       └── session.test.js
├── docs/
│   └── PROTOCOL.md          # documentazione protocollo reverse-engineered
├── tools/
│   └── protocol-probe.js    # CLI diagnostica contro centrale reale
├── .env.example
└── README.md
```

---

## Note legali

Il reverse engineering è stato effettuato esclusivamente a scopo di interoperabilità personale (art. 64-quater L. 633/1941, Direttiva 2009/24/CE art. 6). L'APK originale non è incluso nel repository.
