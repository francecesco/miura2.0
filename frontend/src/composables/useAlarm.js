import { ref, readonly } from 'vue'

// In sviluppo punta direttamente al backend; in produzione usa l'origine corrente.
const WS_URL = import.meta.env.DEV
  ? 'ws://localhost:3000'
  : `${location.protocol === 'https:' ? 'wss' : 'ws'}://${location.host}`

const RECONNECT_DELAY_MS = 3_000
const CMD_TIMEOUT_MS     = 10_000

// ─── Stato reattivo (singleton: condiviso tra tutti i componenti) ─────────────

const wsConnected   = ref(false)
const sessionState  = ref('idle')
const sysinfo       = ref(null)   // { name, firmware, battery, armed, partial, trouble, alarm }
const groupStatus   = ref(null)   // { active, partial, alarmMem, zoneGroups, zoneFail }
const loginError    = ref(null)
const sessionExpired = ref(false)
const loading       = ref(false)
const cmdInProgress  = ref(false)

// ─── WebSocket internals ──────────────────────────────────────────────────────

let ws       = null
let pending  = {}   // id → { resolve, reject, timer }
let reqCount = 0

function nextId() { return `r${++reqCount}` }

function sendCmd(type, params = {}) {
  return new Promise((resolve, reject) => {
    if (!ws || ws.readyState !== WebSocket.OPEN) {
      return reject(new Error('non connesso'))
    }
    const id = nextId()
    const timer = setTimeout(() => {
      delete pending[id]
      reject(new Error('timeout'))
    }, CMD_TIMEOUT_MS)
    pending[id] = { resolve, reject, timer }
    ws.send(JSON.stringify({ type, id, ...params }))
  })
}

function rejectAll(reason) {
  for (const { reject, timer } of Object.values(pending)) {
    clearTimeout(timer)
    reject(new Error(reason))
  }
  pending = {}
}

async function fetchStatus() {
  if (!wsConnected.value) return
  loading.value = true
  try {
    const [si, gs] = await Promise.all([
      sendCmd('getSysinfo'),
      sendCmd('getGroupStatus'),
    ])
    sysinfo.value       = si
    groupStatus.value   = gs
    sessionExpired.value = false
    loginError.value    = null
  } catch (e) {
    // ignora errori di rete transitori durante il caricamento
  } finally {
    loading.value = false
  }
}

function connect() {
  ws = new WebSocket(WS_URL)

  ws.onopen = () => {
    wsConnected.value = true
  }

  ws.onclose = () => {
    wsConnected.value  = false
    sessionState.value = 'disconnected'
    rejectAll('connessione chiusa')
    setTimeout(connect, RECONNECT_DELAY_MS)
  }

  ws.onerror = () => ws.close()

  ws.onmessage = ({ data }) => {
    let msg
    try { msg = JSON.parse(data) } catch { return }

    // Risposte a comandi in attesa
    if (msg.id && pending[msg.id]) {
      const { resolve, reject, timer } = pending[msg.id]
      clearTimeout(timer)
      delete pending[msg.id]
      if (msg.type === 'result') resolve(msg.data)
      else reject(new Error(msg.message ?? 'errore sconosciuto'))
      return
    }

    // Eventi di sessione
    switch (msg.type) {
      case 'state':
        sessionState.value = msg.state
        if (msg.state === 'ready') fetchStatus()
        break
      case 'login-failed':
        loginError.value = msg.message
        break
      case 'session-expired':
        sessionExpired.value = true
        break
      case 'push':
        // Push asincrono dalla centrale → aggiorna stato
        fetchStatus()
        break
    }
  }
}

// Avvio automatico alla prima importazione
connect()

// ─── API pubblica ─────────────────────────────────────────────────────────────

async function arm(groupId) {
  cmdInProgress.value = true
  try {
    groupStatus.value = await sendCmd('arm', { groupId })
  } finally {
    cmdInProgress.value = false
  }
}

async function disarm(groupId) {
  cmdInProgress.value = true
  try {
    groupStatus.value = await sendCmd('disarm', { groupId })
  } finally {
    cmdInProgress.value = false
  }
}

export function useAlarm() {
  return {
    wsConnected:    readonly(wsConnected),
    sessionState:   readonly(sessionState),
    sysinfo:        readonly(sysinfo),
    groupStatus:    readonly(groupStatus),
    loginError:     readonly(loginError),
    sessionExpired: readonly(sessionExpired),
    loading:        readonly(loading),
    cmdInProgress:  readonly(cmdInProgress),
    arm,
    disarm,
    refresh: fetchStatus,
  }
}
