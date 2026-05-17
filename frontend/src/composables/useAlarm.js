import { ref, readonly } from 'vue'

const WS_URL = import.meta.env.DEV
  ? 'ws://localhost:3001'
  : `${location.protocol === 'https:' ? 'wss' : 'ws'}://${location.host}`

const RECONNECT_DELAY_MS  = 3_000
const CMD_TIMEOUT_MS      = 10_000
const AUTO_DISCONNECT_SEC = 120

// ─── Stato reattivo (singleton) ───────────────────────────────────────────────

const wsConnected    = ref(false)
const sessionState   = ref('idle')
const sysinfo        = ref(null)
const groupStatus    = ref(null)
const loginError     = ref(null)
const sessionExpired = ref(false)
const loading        = ref(false)
const cmdInProgress  = ref(false)
const countdown      = ref(0)   // secondi rimanenti alla disconnessione automatica

// ─── WebSocket internals ──────────────────────────────────────────────────────

let ws        = null
let pending   = {}
let reqCount  = 0
let cdTimer   = null   // setInterval countdown

function nextId() { return `r${++reqCount}` }

function sendCmd(type, params = {}) {
  return new Promise((resolve, reject) => {
    if (!ws || ws.readyState !== WebSocket.OPEN)
      return reject(new Error('non connesso'))
    const id    = nextId()
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

// ─── Countdown ────────────────────────────────────────────────────────────────

function startCountdown() {
  stopCountdown()
  countdown.value = AUTO_DISCONNECT_SEC
  cdTimer = setInterval(() => {
    countdown.value--
    if (countdown.value <= 0) stopCountdown()
  }, 1_000)
}

function stopCountdown() {
  if (cdTimer) { clearInterval(cdTimer); cdTimer = null }
  countdown.value = 0
}

// ─── fetchStatus ──────────────────────────────────────────────────────────────

async function fetchStatus() {
  if (!wsConnected.value) return
  loading.value = true
  try {
    const [si, gs] = await Promise.all([
      sendCmd('getSysinfo'),
      sendCmd('getGroupStatus'),
    ])
    sysinfo.value        = si
    groupStatus.value    = gs
    sessionExpired.value = false
    loginError.value     = null
  } catch {
    // errori transitori ignorati
  } finally {
    loading.value = false
  }
}

// ─── WebSocket connection (verso il server Express) ───────────────────────────

function connect() {
  ws = new WebSocket(WS_URL)

  ws.onopen = () => { wsConnected.value = true }

  ws.onclose = () => {
    wsConnected.value  = false
    sessionState.value = 'disconnected'
    stopCountdown()
    rejectAll('connessione chiusa')
    setTimeout(connect, RECONNECT_DELAY_MS)
  }

  ws.onerror = () => ws.close()

  ws.onmessage = ({ data }) => {
    let msg
    try { msg = JSON.parse(data) } catch { return }

    if (msg.id && pending[msg.id]) {
      const { resolve, reject, timer } = pending[msg.id]
      clearTimeout(timer)
      delete pending[msg.id]
      if (msg.type === 'result') resolve(msg.data)
      else reject(new Error(msg.message ?? 'errore sconosciuto'))
      return
    }

    switch (msg.type) {
      case 'state':
        sessionState.value = msg.state
        if (msg.state === 'ready') {
          fetchStatus()
          startCountdown()
        } else if (msg.state === 'idle' || msg.state === 'closed') {
          stopCountdown()
          sysinfo.value     = null
          groupStatus.value = null
        }
        break
      case 'login-failed':
        loginError.value = msg.message
        stopCountdown()
        break
      case 'session-expired':
        sessionExpired.value = true
        break
      case 'push':
        fetchStatus()
        break
    }
  }
}

connect()

// ─── API pubblica ─────────────────────────────────────────────────────────────

async function arm(groupId) {
  cmdInProgress.value = true
  try { groupStatus.value = await sendCmd('arm', { groupId }) }
  finally { cmdInProgress.value = false }
}

async function disarm(groupId) {
  cmdInProgress.value = true
  try { groupStatus.value = await sendCmd('disarm', { groupId }) }
  finally { cmdInProgress.value = false }
}

function connectSession()    { return sendCmd('connect') }
function disconnectSession() { stopCountdown(); return sendCmd('disconnect') }

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
    countdown:      readonly(countdown),
    arm,
    disarm,
    refresh: fetchStatus,
    connectSession,
    disconnectSession,
  }
}
