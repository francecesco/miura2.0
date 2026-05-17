# Protocollo TCP Miura Tervis — Reverse Engineering

Estratto dall'APK originale con `jadx`. Ogni sezione indica la fonte nel codice decompilato.

> **Nota**: le sezioni marcate con ✅ sono state validate contro la centrale reale (indirizzo configurabile via `MIURA_HOST:MIURA_PORT`) con `tools/protocol-probe.js`. Le sezioni con ⚠️ TODO richiedono ancora verifica.

---

## 1. Trasporto

La centrale espone un server TCP (default porta `5400`). Il client apre una connessione TCP persistente e la mantiene attiva finché la sessione è valida.

- **Timeout connessione**: 10 secondi (`Y/e.java`, classe interna `b`)
- **Buffer di lettura**: 512 byte per read, buffer di riassemblaggio da 1024 byte
- **Threading**: singolo thread di scrittura (executor serializzato), singolo thread di lettura (RX thread)

---

## 2. Struttura del frame (wire format)

```
┌──────────────┬──────────┬───────────────────────────────────────┐
│  MAGIC (3 B) │ LEN (1B) │           PAYLOAD (LEN bytes)         │
│  2B 2A 2B    │          │ [F1][ENC][CMD][SUB][...data...][CRC×2] │
└──────────────┴──────────┴───────────────────────────────────────┘
```

| Campo     | Posizione          | Valore / Descrizione                            |
|-----------|--------------------|-------------------------------------------------|
| MAGIC     | wire[0..2]         | `0x2B 0x2A 0x2B` (`+*+`)                       |
| LEN       | wire[3]            | Lunghezza del PAYLOAD (1 byte unsigned)         |
| PAYLOAD[0]| payload[0]         | Sempre `0xF1` (costante, tipo frame)            |
| ENC       | payload[1]         | Chiave XOR; `0x00` = non cifrato               |
| CMD       | payload[2]         | Tipo di comando (vedi §4)                       |
| SUB       | payload[3]         | Sotto-comando / direzione (vedi §4)             |
| DATA      | payload[4..n-3]    | Dati specifici del messaggio                    |
| CRC_HI    | payload[n-2]       | Byte **alto** del CRC-16 (primo, BIG-ENDIAN) ✅ |
| CRC_LO    | payload[n-1]       | Byte **basso** del CRC-16 (secondo, BIG-ENDIAN) ✅ |

Fonte: `Y/e.java` (loop di ricezione, metodo `run()` della classe interna `d`; invio nel metodo `run()` della classe interna `f`).

---

## 3. Cifratura — ASIMMETRICA ✅

La cifratura è **asimmetrica**: client e server seguono regole opposte e fisse, non sincronizzate tra loro.

| Direzione       | Regola                                       |
|-----------------|----------------------------------------------|
| Client → Server | **SEMPRE plain** — `enc_key = 0x00` fisso in ogni frame |
| Server → Client | **SEMPRE cifrato** — `enc_key ≠ 0` in ogni risposta     |

> Il codice APK (`Y/e.java`, flag `f600m`) suggerisce una logica state-synced, ma il traffico reale smentisce questa interpretazione: il server ignora completamente i frame cifrati in ingresso dal client.

**Decifratura dei frame in ingresso dal server** (`Y/b.java`, metodo statico `c(byte[])`):
1. Leggi `enc_key = payload[1]`
2. Se `enc_key == 0`: frame non cifrato (non dovrebbe accadere con il server reale)
3. `payload[0] ^= enc_key`
4. `payload[1]` rimane invariato (è la chiave stessa, non viene de-XORata)
5. Per ogni byte in `payload[2..n-1]`: `payload[i] ^= enc_key`

> Il CRC viene calcolato sul payload **dopo** la decifratura.

---

## 4. Algoritmo CRC ✅

**CRC-16 con polinomio riflesso 0xA001** (equivalente a CRC-16/ARC o CRC-16/IBM).

Calcolato su tutti i byte del PAYLOAD eccetto gli ultimi 2 (i byte CRC stessi).
Il risultato è scritto in **BIG-ENDIAN**: `CRC_HI = (crc >> 8) & 0xFF` (primo), `CRC_LO = crc & 0xFF` (secondo).

Confermato da `Y/b.java` metodo `a()`:
```java
f581a.write((0xFF00 & crc) >>> 8);  // byte alto prima
f581a.write(crc & 0xFF);            // byte basso dopo
```

Confermato da traffico reale: tutte le risposte della centrale passano la verifica CRC con ordine BIG-ENDIAN.

```javascript
function crc16(buf) {
  let crc = 0xFFFF;
  for (const b of buf) {
    crc ^= b & 0xFF;
    for (let i = 0; i < 8; i++) {
      const lsb = crc & 1;
      crc >>= 1;
      if (lsb) crc ^= 0xA001;
    }
  }
  // BIG-ENDIAN: scrivi (crc >> 8) & 0xFF, poi crc & 0xFF
  return crc;
}
```

Fonte: `j0/j.java`, metodo `b(byte[])`; ordine byte da `Y/b.java`, metodo `a()`.

---

## 5. Tipi di comando (CMD byte)

| CMD  | Hex  | Package | Descrizione                              |
|------|------|---------|------------------------------------------|
| 1    | 0x01 | `h0`    | Autenticazione / sessione               |
| 3    | 0x03 | `f0`    | Testi / nomi di aree, gruppi, zone      |
| 4    | 0x04 | `a0`    | Storico eventi (log) — dettagli         |
| 6    | 0x06 | `Z`     | Attivazione / disattivazione gruppi     |
| 7    | 0x07 | `i0`    | Zone (stato e configurazione)           |
| 8    | 0x08 | `d0`    | Telecomandi; SUB=0x88 = push asincrono post-login ✅ |
| 10   | 0x0A | `b0`    | Configurazione (aree, zone, gruppi)     |
| 15   | 0x0F | `e0`    | Informazioni standby / sistema          |
| 16   | 0x10 | `c0`    | Notifiche log (broadcast asincrono)     |
| 18   | 0x12 | `g0`    | Periferiche / schede espansione         |

---

## 6. Sotto-comandi (SUB byte) — pattern generale

| SUB  | Hex  | Direzione     | Descrizione                        |
|------|------|---------------|------------------------------------|
| 0    | 0x00 | C→S / S→C    | Request semplice / broadcast       |
| 1    | 0x01 | C→S           | Write / set                        |
| 2    | 0x02 | C→S           | Keep-alive / richiesta speciale    |
| 3    | 0x03 | S→C (push)    | Broadcast asincrono                |
| 128  | 0x80 | S→C           | Response OK (payload ridotto)      |
| 129  | 0x81 | S→C           | Response con dati                  |
| 130  | 0x82 | S→C           | Response con lista dati            |
| 131  | 0x83 | S→C           | Response alternativo               |
| 255  | 0xFF | S→C (push)    | Errore / sessione chiusa           |

---

## 7. Flusso di connessione e autenticazione ✅

```
Client                                  Centrale
  |                                        |
  |──── TCP connect ──────────────────────>|
  |     (nessun greeting dal server)       |
  |                                        |
  |──── LOGIN REQUEST (CMD=1, enc=0) ─────>|  ← DEVE essere in chiaro (enc_key=0x00)
  |     [F1][00][01][00][00][PIN][00][CRC] |
  |                                        |
  |<─── LOGIN RESPONSE (CMD=1, SUB=0x80) ──|  ← sempre cifrato (enc_key≠0)
  |     [F1][key][01][80][user_id][...][CRC]
  |                                        |
  |──── CONFIRM (CMD=1, solo CMD) ────────>|
  |     [F1][00][01][CRC]                  |
  |                                        |
  |<─── SESSION BROADCAST (CMD=1, SUB=3) ──|
  |     [F1][key][01][03][status][CRC]     |
  |                                        |
  |<─── LOG_NOTIF push (CMD=0x10) ─────────|  ← inviato spontaneamente subito dopo
  |                                        |
  |──── Caricamento config, zone, gruppi ─>|
  |     (vedi §8–§12)                      |
```

### 7.1 Login Request (h0.b)
```
CMD=0x01  SUB=0x00
Payload data: [0x00] [PIN_BYTES...] [0x00]
```
- `PIN_BYTES` = codice utente come ASCII (es. "123456" → `31 32 33 34 35 36`)
- La sequenza `[0x00][PIN][0x00]` wrappa il PIN

Fonte: `h0/b.java`, `h0/d.java`.

### 7.2 Login Response (h0.c) ✅
```
CMD=0x01  SUB=0x80
Payload data: [user_id] [user_type] [auth_lo] [auth_hi] [unk] [activ_mask_lo] [activ_mask_hi] [deactiv_mask_lo] [deactiv_mask_hi] [unk×3] [name_chars...]
```

**Interpretazione `user_id` (confermata da test live):**
- `user_id = 0` → **ERRORE** — utente non trovato / codice errato
- `user_id = 1..249` → **SUCCESSO** — questo valore IS l'ID utente (es. user_id=1 = primo utente)
- `user_id = 250..255` → **CODICI ERRORE SPECIFICI**:
  - `250` = non autorizzato da remoto
  - `251` = restrizione oraria
  - `252` = gruppo attivato
  - `253` = sessione già aperta
  - `254` = codice errato
  - `255` = utente non trovato

**Dati aggiuntivi (offset dal byte 5 del payload):**
- `[1]` = user_type
- `[2..3]` = auth_mask LE16 (permessi, es. 0x1C7F = tutti i permessi)
- `[9..]` = nome utente ASCII

Confermato con test live: user_id=1 (primo utente), auth=0x1C7F.

Fonte: `h0/c.java`.

### 7.3 Confirm Login (h0.a) ✅
Messaggio minimale senza SUB byte: `[F1][00][01]` + CRC (5 byte totali di payload).
`h0.a.i()` chiama solo `super.i()` che scrive CMD=1 — nessun SUB né dati.

### 7.4 Session Changed Broadcast (h0.e) ✅
```
CMD=0x01  SUB=0x03
Payload data: [status]
```
- `status = 0x81 (129)` → sessione aperta OK (confermato da test live)
- `status = 0xFF (255)` → sessione chiusa / scaduta → il client deve disconnettersi e riconnettersi

Fonte: `h0/e.java`, `MiuraService.java` (inner class `l`).

### 7.5 Push spontaneo post-login ✅
Immediatamente dopo il Session Broadcast, la centrale invia spontaneamente:
```
CMD=0x08  SUB=0x88
Payload data: [1+ byte]
```
SUB=0x88 non è gestito dall'APK originale per CMD=0x08 (il parser restituisce `null`): il messaggio viene smistato ai listener generici. Il backend deve accettarlo silenziosamente e non bloccarsi. Vedi §13bis per la documentazione completa.

Fonte: osservato su traffico reale (non corrisponde a nessuna classe nel parser `Y/c.java`).

---

## 8. Keep-alive

Inviato ogni 20 secondi di inattività (nessun messaggio uscente negli ultimi 20 secondi).

```
CMD=0x01  SUB=0x02
Payload data: nessuno
Frame: [F1][00][01][02][CRC_HI][CRC_LO]   ← BIG-ENDIAN, client invia plain (enc=0x00)
```

Fonte: `MiuraService.java` metodo `L()`, `h0/f.java`.

---

## 9. Stato gruppi (arm / disarm)

### 9.1 Request stato gruppi (Z.i) ✅
```
CMD=0x06  SUB=0x02
Payload data: nessuno
```

### 9.2 Response stato gruppi (Z.h) ✅
```
CMD=0x06  SUB=0x80
Payload data (10 byte):
  [active_lo]    [active_hi]      ← Maschera 16-bit gruppi ATTIVI (armati totalmente)
  [partial_lo]   [partial_hi]     ← Maschera gruppi parzialmente attivi
  [alarm_mem_lo] [alarm_mem_hi]   ← Maschera gruppi con memoria allarme
  [zone_grp_lo]  [zone_grp_hi]    ← Maschera gruppi con zone in anomalia
  [zone_fail_lo] [zone_fail_hi]   ← Maschera gruppi con guasti zone
```
Tutti i valori sono interi 16-bit little-endian. Bit N = gruppo N (gruppo 0 = bit 0, ...).

**Dati reali osservati** (impianto disarmato):
```
active=0x0000  partial=0x0000  alarmMem=0x0000  zoneGroups=0x0001  zoneFail=0x0000
```
`zoneGroups=0x0001` indica che il gruppo 0 ha zone in stato anomalo (aperte/allarme).

> **Fonte di verità per lo stato armato/disinserito**: usare **questa maschera `active`** (§9.2), non il bit0 di sysinfo (§14.2). Il campo `sysinfo.flags1.bit0` riflette lo stato hardware del relè e può divergere dallo stato logico per gruppo.

Nota: la classe `Z.h` gestisce SUB=0x80; `Z.b` gestisce SUB=0x81; `Z.j` gestisce SUB=0x82. Tutte estendono `Z.c` con lo stesso layout dati (metodo `t()`).

Fonte: `Y/c.java` (metodo `a()`, case 128), `Z/c.java` (metodo `t()`), `Z/h.java`.

### 9.3 Arm Command (Z.a) ✅
```
CMD=0x06  SUB=0x01
Payload data (3 byte):
  [group_mask_lo] [group_mask_hi]  ← Maschera 16-bit del gruppo (1 << groupID)
  [0x00]                            ← action fisso = 0
```
- `group_mask = 1 << groupID` (es. gruppo 0 → 0x0001, gruppo 1 → 0x0002)
- **Wire esempio (arm gruppo 0):**
  ```
  2B 2A 2B 09 F1 00 06 01 01 00 00 F3 23
  ```

### 9.3b Disarm Command (Z.g) ✅
```
CMD=0x06  SUB=0x00
Payload data (2 byte):
  [group_mask_lo] [group_mask_hi]  ← Maschera 16-bit del gruppo (1 << groupID)
```
- **Nessun byte `action`** — il SUB distingue arm (0x01) da disarm (0x00)
- **Wire esempio (disarm gruppo 0):**
  ```
  2B 2A 2B 08 F1 00 06 00 01 00 22 14
  ```

> **Nota critica**: `Z.a` con action=0x01 (quello che sembrava "disarm") è un'operazione diversa (arm parziale / arm con flag). Il vero disarm usa `Z.g`, CMD=0x06 **SUB=0x00**, senza byte action. Confuso dalle sorgenti decompilate prima della validazione live.

Fonte: `Z/a.java`, `Z/g.java`, `X/a.java:459` (arm → `Y1()`), `X/a.java:699` (disarm → `K1(new Z.g(...))`).

### 9.4 Arm / Disarm Response — VALIDATO ✅

Confermato su traffico reale (2026-05-17):

**ARM response:**
```
CMD=0x06  SUB=0x81       ← risposta a SUB=0x01 (bit7 set = response)
Payload (11 byte):
  [active_lo][active_hi] ... (stessa struttura di §9.2, 10 byte)
  [result]                ← 0x00 = arm completato
```
- Wire: `cmd=0x06 sub=0x81 data=0100000000000100000000`
- Dopo arm: `active=0x0001`, `result=0x00`

**DISARM response:**
```
CMD=0x06  SUB=0x80       ← risposta a SUB=0x00 (bit7 set = response)
Payload (10 byte):
  [active_lo][active_hi] ... (stessa struttura di §9.2, 10 byte)
```
- Wire: `cmd=0x06 sub=0x80 data=00000000000001000000`
- Dopo disarm: `active=0x0000`

**State-change broadcast (unsolicited):**
Dopo ogni arm/disarm, la centrale invia un push non richiesto:
```
CMD=0x06  SUB=0x01  (dopo arm)   — active=0x0001
CMD=0x06  SUB=0x00  (dopo disarm) — active=0x0000
```

**Regola generale SUB response**: `response_sub = request_sub | 0x80`

Fonte: `Z/a.java`, `Z/b.java`, `Z/g.java`, `Z/h.java`, `X/a.java:459,699`, traffico reale catturato 2026-05-17.

---

## 10. Zone

### 10.1 Zone Info Request (i0.c)
Richiesta blocco di zone (max 7 per richiesta).
```
CMD=0x07  SUB=0x01
Payload data:
  [1 o 15]       ← 1 = normale, 15 = ultima richiesta del blocco
  [zone_start]   ← indice di partenza (0, 7, 14, ...)
  [block_size]   ← normalmente 7
```

### 10.2 Zone Info Response (i0.d) ✅
```
CMD=0x07  SUB=0x81
Payload data:
  [flag]     ← 0x01 = found
  [offset]   ← offset zona nel blocco
  [count]    ← numero zone in questa risposta
  Per ogni zona (4 byte):
    [zone_id] [active:1=attiva] [status_lo] [status_hi]
    status: 0=standby, 1=allarme, 2=manomissione, 3=guasto
```

**Dati reali osservati** (6 zone, impianto con ingressi aperti):
```
zona 0: active=1, status=1 (ALARM)
zona 1: active=1, status=1 (ALARM)
zona 2: active=1, status=1 (ALARM)
zona 3: active=0, status=0 (STANDBY)
zona 4: active=0, status=0 (STANDBY)
zona 5: active=0, status=0 (STANDBY)
```
Le zone 0-2 erano fisicamente aperte (finestre/porte), coerente con lo stato ALARM.

### 10.3 Zone Status Request (i0.f)
```
CMD=0x07  SUB=0x04
Payload data:
  [zone_id]
```

### 10.4 Zone Exclusion Request (i0.a)
```
CMD=0x07  SUB=0x03
Payload data:
  [zone_id] [type=1] [action] [0]
  action: 1 = escludi, 0 = includi
```

Fonte: `i0/c.java`, `i0/d.java`, `i0/f.java`, `i0/a.java`, `it/tervis/miura/model/Zone.java`.

---

## 11. Configurazione

### 11.1 Config Request (b0.c)
Scarica 15 blocchi di configurazione (da indice 0 a 14), più un blocco speciale tipo 255.
```
CMD=0x0A  SUB=0x01
Payload data:
  [area_index]  ← 0..15
  [type]        ← normalmente 0xFF (255) per config completa
```

### 11.2 Config Response (b0.d)
```
CMD=0x0A  SUB=0x81
Payload data:
  [area_index] [type=255]
  [bitmask bytes...] ← bitmask delle zone assegnate, 1 bit per zona
```
Bit set = zona assegnata all'area. Zone ID validi: 0..95, 100..195, 200..253.

### 11.3 Config Zone Response (b0.b)
```
CMD=0x0A  SUB=0x80
Payload data:
  [area_index] [unk1] [unk2]
  Per ogni zona (3 byte):
    [zone_id] [active:1=attiva] [status]
    status: 0=standby, 1=allarme, 2=manomissione, 3=guasto
```

Fonte: `b0/a.java`, `b0/c.java`, `b0/d.java`, `b0/b.java`.

---

## 12. Testi / Nomi

### 12.1 Text Request (f0.b)
```
CMD=0x03  SUB=0x00
Payload data:
  [type]      ← 1=area, 2=gruppo, 3=zona, 4=telecomando, 8=timer
  [id_lo] [id_hi]  ← ID dell'elemento (LE16)
```

### 12.2 Text Response (f0.c)
```
CMD=0x03
Payload data:
  [type] [id_lo] [id_hi] [text_chars...][null terminator]
```

Fonte: `f0/a.java`, `f0/b.java`, `f0/c.java`.

---

## 13. Storico eventi / Log

### 13.1 Log Written Broadcast (c0.g) — push asincrono
Inviato dalla centrale ogni volta che viene scritto un nuovo evento nel log.
```
CMD=0x10  SUB=0x00
Payload data:
  [category]  ← categoria dell'evento
```

### 13.2 Log Response — lista eventi (c0.c)
```
CMD=0x10  SUB=0x81 (con bArr[5]==0)
Payload data:
  [category] [details] [start_lo][start_hi] [count_lo][count_hi]
  Per ogni evento (7 byte, da offset 10):
    [category] [day] [month] [year] [hour] [minute] [read:1=letto]
    year = anno - 2000
```

### 13.3 Log Response — evento dettagliato (c0.b)
```
CMD=0x10  SUB=0x81 (con bArr[5]!=0)
Payload identico a §13.2, poi a offset 42:
  [text_chars...]  ← descrizione testuale dell'evento
```

### 13.4 Struttura evento (LogEvent)
| Byte | Campo   | Note                              |
|------|---------|-----------------------------------|
| 0    | category| Tipo evento (vedi §13.5)          |
| 1    | day     | Giorno (1-31)                     |
| 2    | month   | Mese (1-12)                       |
| 3    | year    | Anno - 2000                       |
| 4    | hour    | Ora (0-23)                        |
| 5    | minute  | Minuto (0-59)                     |
| 6    | read    | 1 = già letto, 0 = non letto      |

> ⚠️ **TODO — validare con cattura traffico reale**: i valori della categoria evento (armamento, disinserimento, allarme, guasto...) non sono enumerati nel codice decompilato e devono essere rilevati sperimentalmente con `protocol-probe.js --mode listen`.

Fonte: `c0/c.java`, `c0/b.java`, `c0/f.java`, `c0/g.java`, `it/tervis/miura/model/LogEvent.java`.

---

## 13bis. Push asincrono CMD=0x08 SUB=0x88 ✅

Messaggio inviato spontaneamente dalla centrale subito dopo il login (post Session Broadcast). Rappresenta una notifica push legata ai telecomandi o all'espansione periferica.

```
CMD=0x08  SUB=0x88
Direzione: S→C (push, non sollecitato)
Payload data: struttura non completamente determinata (1+ byte osservati)
```

**Comportamento richiesto al backend:**
- Ricevere il frame senza bloccarsi
- Loggare come `DEBUG [CMD=0x08 SUB=0x88] unsolicited push`
- Inoltrare al WebSocket frontend come evento generico `{ type: 'push', cmd: 8, sub: 0x88, data: <hex> }`
- Non bloccare il flusso di inizializzazione

Il parser APK (`Y/c.java`, metodo `f()` per CMD=8) non ha un case per SUB=0x88 e restituisce `null`. Il messaggio viene smistato ai listener generici senza parsing.

> ⚠️ **TODO**: struttura esatta del payload e significato semantico ancora da determinare con cattura traffico estesa.

Fonte: osservato su traffico reale post-login.

---

## 14. Informazioni sistema (standby)

### 14.1 Standby Info Request (e0.b) ✅
```
CMD=0x0F  SUB=0x01
Payload data: nessuno
```

### 14.2 Standby Info Response (e0.c) ✅
```
CMD=0x0F  SUB=0x80
Payload data:
  [flags1]            ← bit0=armato, bit1=parziale, bit6=guasto, bit7=allarme
  [flags2]
  [unk]
  [fw_major] [fw_minor]  ← versione firmware (es. 0x01 0x02 = "1.2")
  [battery]              ← livello batteria (es. 4)
  [text_chars...]        ← nome impianto ASCII (es. "TIM")
```

Metodi di accesso nel codice:
- `t()` = flags1 bit 0 (armed)
- `v()` = flags1 bit 1 (partially armed)
- `w()` = flags1 bit 7 (alarm active)
- `x()` = flags1 bit 6 (trouble/guasto)
- `u()` = flags2 bit 1 negato (segnale RF OK?)
- `q()` = firmware version come stringa "X.Y"
- `r()` = nome impianto
- `s()` = batteria

**Dati reali osservati:**
```
nome="TIM"  fw=1.2  battery=4
flags1=0x51 → bit0=1 (ARMATO), bit4=1 (?), bit6=1 (TROUBLE)
```

> **Attenzione — non usare questo campo come fonte di verità per lo stato armato.** La maschera `active` in §9.2 (CMD=6 response) è la fonte autorevole. Il campo `flags1.bit0` riflette lo stato hardware del relè e può divergere dallo stato logico per gruppo (confermato da test live: `flags1.bit0=1` ma `active=0`). Usare sysinfo solo per informazioni di sistema (firmware, batteria, nome impianto).

> ⚠️ **TODO**: verificare se `flags1.bit0` si allinea a `active` durante un ciclo armo/disarmo reale, o se rimane sempre discrepante.

> ⚠️ **TODO**: significato di `flags2` e di `bit4` in `flags1` non ancora determinati.

Fonte: `e0/c.java`, `e0/d.java`, `e0/b.java`.

---

## 15. Telecomandi

### 15.1 Remote Controllers Request (d0.e, d0.c)
```
CMD=0x08  SUB=0x06 (lista tutti)
            SUB=0x00 (carica blocco)
Payload data (per lista): [block_offset] (LE16)
```

### 15.2 Remote Controller Command (d0.a)
```
CMD=0x08  SUB=0x05
Payload data:
  [rc_id] [state: 0=ON, 1=OFF] [unk]
```

Fonte: `d0/a.java`, `d0/c.java`, `d0/e.java`.

---

## 16. Timeout e riconnessione

- **Timeout risposta**: 25 secondi (`Y/e.java`, `wait(25000L)`)
- **Keep-alive**: ogni 20 secondi di inattività (§8)
- **Session timeout**: La centrale invia `h0.e` con status=255 per terminare la sessione
- **Riconnessione**: non implementata nel codice originale — il backend replacement deve gestirla con backoff esponenziale

---

## 17. Esempio completo: Login + Arm

Tutti i valori in hex, senza cifratura (ENC=0x00).

### Wire frame del Login Request (esempio con PIN a 6 cifre) ✅
```
2B 2A 2B    ← magic +*+
0D          ← payload length = 13
F1          ← tipo frame
00          ← enc_key=0 (PLAIN — obbligatorio per il primo login)
01          ← CMD = auth
00          ← SUB = login request (inserito da buildFrame, non è un dato)
XX XX XX XX XX XX  ← PIN in ASCII (6 byte per PIN a 6 cifre)
00          ← null terminator dopo il PIN
XX XX       ← CRC-16 BIG-ENDIAN: (crc>>8)&0xFF poi crc&0xFF
```
Wire reale catturato (PIN=080893): `2B 2A 2B 0D F1 00 01 00 30 38 30 38 39 33 00 A9 B1`
```
```

### Wire frame della Group Status Request ✅
```
2B 2A 2B         ← magic
06               ← payload length = 6
F1               ← tipo frame
00               ← enc_key = 0 (plain)
06               ← CMD = groups
02               ← SUB = status request
XX XX            ← CRC-16 BIG-ENDIAN: HIGH byte, LOW byte
```

### Wire frame Arm / Disarm (gruppo 0) ✅
```
ARM:
2B 2A 2B         ← magic
09               ← payload length = 9
F1 00            ← tipo frame, enc_key = 0 (plain)
06 01            ← CMD=groups, SUB=arm
01 00            ← group_mask = 1 (gruppo 0), LE16
00               ← action fisso = 0
F3 23            ← CRC-16 BIG-ENDIAN

DISARM:
2B 2A 2B         ← magic
08               ← payload length = 8
F1 00            ← tipo frame, enc_key = 0 (plain)
06 00            ← CMD=groups, SUB=disarm (nessun action byte)
01 00            ← group_mask = 1 (gruppo 0), LE16
22 14            ← CRC-16 BIG-ENDIAN
```

---

## 18. TODO — Aspetti ancora da validare

I seguenti punti non sono stati ancora chiariti dai test eseguiti.

1. ~~**Cifratura iniziale**~~: ✅ Risolto — client invia PLAIN, server risponde sempre cifrato
2. ~~**Esito arm/disarm**~~: ✅ Risolto — ARM usa CMD=06 SUB=01 → response SUB=0x81 (result=0x00=ok); DISARM usa CMD=06 **SUB=0x00** (Z.g, no action byte) → response SUB=0x80. Validato live 2026-05-17.
3. **Categoria eventi log**: valori numerici per tipo evento (armamento, disinserimento, allarme zona, guasto...). Testare con `--mode listen` mentre si generano eventi reali.
4. **Broadcast zone change (CMD=0x10)**: verificare se il push LOG_NOTIF include informazioni sulla zona scatenante o solo la categoria generica.
5. ~~**Struttura `e0.c` (sysinfo)**~~: ✅ Confermato parzialmente — rimangono: significato di `flags2` e di `flags1.bit4`.
6. ~~**Discrepanza sysinfo vs group_status**~~: ✅ Confermato — `flags1.bit0` rimane `1` anche con `group_status.active=0`. Il frontend usa `groupStatus.active` come fonte di verità (§9.2).
7. ~~**Sequenza iniziale (greeting)**~~: ✅ Confermato — la centrale non invia nessun messaggio prima del login del client.
8. **Config response (CMD=0x0A)**: confermare che i 15 blocchi coprono tutte le aree/zone dell'impianto (non testato).
9. **g0 peripherals (CMD=0x12)**: struttura completa dei messaggi non documentata; non necessaria per le funzioni base dell'app.
