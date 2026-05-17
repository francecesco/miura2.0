<p align="center">
  <img src="frontend/public/icons/icon.svg" alt="Miura" width="96" />
</p>

# Miura 2.0

Replica PWA self-hosted dell'applicazione mobile **Miura Tervis** per la gestione di impianti di allarme Tervis, dismessa dall'App Store.

Deployabile via Docker su CasaOS / ZimaBoard. Nessuna dipendenza da cloud Tervis: tutto avviene tramite connessione TCP diretta alla centrale.

---

## Architettura

```
Browser (PWA)
    │  WebSocket  (JSON: comandi + eventi)
    ▼
Express + WS server       ← backend/server.js
    │  GET /health · static PWA · broadcast eventi
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
| 2 | `session.js` — macchina a stati login/keep-alive/comandi | ✅ Completato (18 test) |
| 2 | `commands.js` — decoder payload + costanti | ✅ Completato (22 test) |
| 2 | `config.js` — caricamento env con validazione | ✅ Completato (9 test) |
| 3 | `server.js` — Express + WebSocket bridge | ✅ Completato (21 test) |
| 4 | Frontend Vue 3 + Vite + PWA | ✅ Completato |
| 5 | Dockerfile + docker-compose | ✅ Completato |

---

## Requisiti

- **Docker** (deploy raccomandato) oppure **Node.js 20+** per sviluppo locale
- Accesso di rete alla centrale Tervis (TCP, porta configurabile)

---

## Deploy con Docker (CasaOS / ZimaBoard)

```bash
# 1. Clona il repository
git clone <repo-url> miura2.0 && cd miura2.0

# 2. Crea il file di configurazione
cp .env.example .env
nano .env   # inserisci MIURA_HOST, MIURA_PORT, MIURA_PIN, PORT

# 3. Avvia
docker compose up -d --build
```

La PWA sarà disponibile su `http://<ip-casaos>:3001`.

### Nota: network_mode host (raccomandato)

La centrale Tervis accetta **una sola connessione TCP alla volta**. Se il container Docker usa il bridge di default, alcuni router/firewall possono bloccare la connessione in uscita dall'IP NAT del container.

Per evitare problemi, usa `network_mode: host` nel `docker-compose.yml` (il container condivide la rete dell'host direttamente):

```yaml
services:
  miura:
    build: .
    image: miura2:latest
    container_name: miura
    network_mode: host        # consigliato su CasaOS/ZimaBoard
    env_file:
      - .env
    restart: unless-stopped
    healthcheck:
      test: ["CMD", "wget", "-qO-", "http://localhost:3001/health"]
      interval: 30s
      timeout: 5s
      start_period: 15s
      retries: 3
```

> Con `network_mode: host` la sezione `ports:` non è necessaria — la porta è esposta direttamente sull'host.

### Sessione unica

La centrale Tervis supporta **una sola sessione TCP attiva**. Se l'app non riesce a connettersi (stato `logging_in` bloccato, nessun `[RX]` nei log), verifica che non ci siano altre istanze del server in esecuzione sullo stesso host o su altri dispositivi.

### Aggiornamento

```bash
cd miura2.0
git pull
docker compose up -d --build
```

### Log e stato

```bash
docker compose logs -f          # log in tempo reale
docker compose ps               # stato container e healthcheck
curl http://localhost:3001/health
```

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
| `PORT` | `3001` | Porta HTTP del server |
| `DEBUG_PROTOCOL` | `0` | Se `1`, logga hex TX/RX su stderr |

---

## Sviluppo locale

```bash
npm install
cd frontend && npm install && cd ..

# Backend (porta 3001) + frontend dev server (porta 5173, con proxy)
npm start &
cd frontend && npm run dev
```

---

## Esecuzione test

```bash
# Tutti i test backend (nessuna connessione reale necessaria)
npm test
```

Output atteso: **116 test, 0 fail** in circa 1–2 secondi.

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

## Avvio server (senza Docker)

```bash
# Copia e compila il file di configurazione, poi:
npm start
# → Miura 2.0 listening on :3001
```

Il server espone:
- `GET /health` — `{ status: "ok", session: "<stato>" }`
- `ws://host:3001` — WebSocket JSON per la PWA

**Comandi WebSocket** (client → server):

```jsonc
{ "type": "getGroupStatus", "id": "r1" }
{ "type": "getSysinfo",     "id": "r2" }
{ "type": "arm",    "groupId": 0, "id": "r3" }
{ "type": "disarm", "groupId": 0, "id": "r4" }
{ "type": "getZoneBlock", "startIdx": 0, "id": "r5" }
{ "type": "getText", "entityType": 2, "entityId": 0, "id": "r6" }
```

**Risposte e push** (server → client):

```jsonc
{ "type": "state",          "state": "ready" }
{ "type": "result",         "id": "r1", "data": { ... } }
{ "type": "error",          "id": "r1", "message": "..." }
{ "type": "login-failed",   "code": 254, "message": "..." }
{ "type": "session-expired" }
{ "type": "push",           "cmd": 8, "sub": 136, "data": "<hex>" }
```

---

## Protocollo TCP

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
│   │   ├── session.js       # macchina a stati sessione applicativa
│   │   └── commands.js      # decoder payload (sysinfo, zone, testo) + costanti
│   ├── config.js            # loadConfig(env) — validazione e default
│   ├── server.js            # Express HTTP + WebSocket bridge
│   └── test/
│       ├── protocol.test.js
│       ├── connection.test.js
│       ├── session.test.js
│       ├── commands.test.js
│       ├── config.test.js
│       └── server.test.js
├── frontend/
│   ├── src/
│   │   ├── App.vue          # UI principale: stato, arm/disarm, zone
│   │   ├── composables/
│   │   │   └── useWs.js     # WebSocket singleton con reconnect
│   │   └── main.js
│   ├── index.html
│   └── vite.config.js
├── docs/
│   └── PROTOCOL.md          # documentazione protocollo reverse-engineered
├── tools/
│   └── protocol-probe.js    # CLI diagnostica contro centrale reale
├── Dockerfile               # multi-stage build (Node 20 alpine, utente non-root)
├── docker-compose.yml       # deploy CasaOS/ZimaBoard
├── .dockerignore
├── .env.example
└── README.md
```

---

## Note legali

Il reverse engineering è stato effettuato esclusivamente a scopo di interoperabilità personale (art. 64-quater L. 633/1941, Direttiva 2009/24/CE art. 6). L'APK originale non è incluso nel repository.
