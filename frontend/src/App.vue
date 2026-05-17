<template>
  <div class="h-dvh max-w-sm mx-auto bg-slate-900 text-white flex flex-col overflow-hidden">

    <!-- Header ──────────────────────────────────────────────────────────────── -->
    <header class="flex items-center justify-between px-4 py-3 bg-slate-800/80 backdrop-blur border-b border-slate-700/60">
      <!-- Logo + nome sistema -->
      <div class="flex items-center gap-2.5">
        <img src="/icons/icon.svg" alt="" class="w-8 h-8 rounded-lg flex-shrink-0" />
        <div class="leading-tight">
          <h1 class="font-semibold text-sm tracking-wide">
            {{ sysinfo?.name || 'Miura 2.0' }}
          </h1>
          <div v-if="sysinfo" class="text-xs text-slate-500">
            fw {{ sysinfo.firmware }}
          </div>
        </div>
      </div>

      <!-- Batteria + stato + countdown -->
      <div class="flex items-center gap-3 text-xs text-slate-400">
        <span v-if="sysinfo">🔋 {{ sysinfo.battery }}</span>
        <span v-if="isConnected && countdown > 0"
              class="tabular-nums text-slate-500">
          {{ countdownFormatted }}
        </span>
        <div class="flex items-center gap-1.5">
          <span :class="[
            'w-2 h-2 rounded-full flex-shrink-0 transition-colors',
            wsConnected
              ? (isConnected ? 'bg-emerald-400' : 'bg-amber-400 animate-pulse')
              : 'bg-red-400 animate-pulse'
          ]" />
          <span class="capitalize">{{ displayState }}</span>
        </div>
      </div>
    </header>

    <!-- Contenuto principale ─────────────────────────────────────────────── -->
    <main class="flex-1 overflow-y-auto px-4 py-5 space-y-4">

      <!-- Banner errori ────────────────────────────────────────────────────── -->
      <div v-if="loginError"
           class="flex items-start gap-3 rounded-xl bg-red-950 border border-red-700/60 px-4 py-3 text-sm text-red-200">
        <span class="text-lg leading-none">⚠️</span>
        <div><strong>Login fallito:</strong> {{ loginError }}</div>
      </div>

      <div v-if="sessionExpired"
           class="flex items-start gap-3 rounded-xl bg-amber-950 border border-amber-700/60 px-4 py-3 text-sm text-amber-200">
        <span class="text-lg leading-none">🔄</span>
        <div>Sessione scaduta — riconnessione in corso…</div>
      </div>

      <!-- Card stato globale ───────────────────────────────────────────────── -->
      <div :class="['rounded-2xl p-8 text-center transition-all duration-500', statusCardClass]">
        <template v-if="loading && !groupStatus">
          <div class="h-12 w-32 mx-auto rounded-lg bg-slate-700 animate-pulse" />
        </template>
        <template v-else>
          <div :class="['text-5xl font-black tracking-tight uppercase', !isConnected && 'opacity-40']">
            {{ statusLabel }}
          </div>
          <div v-if="hasAlarm"
               class="mt-3 inline-flex items-center gap-2 text-sm font-semibold text-red-200 animate-pulse">
            🚨 Allarme in corso
          </div>
          <div v-else-if="sysinfo?.trouble"
               class="mt-3 inline-flex items-center gap-2 text-sm font-semibold text-amber-300">
            ⚠️ Anomalia rilevata
          </div>
          <div v-else-if="groupStatus?.partial"
               class="mt-3 text-sm font-medium text-orange-300">
            Parziale
          </div>
        </template>
      </div>

      <!-- Gruppi ──────────────────────────────────────────────────────────── -->
      <template v-if="!loading || groupStatus">
        <div v-if="visibleGroups.length === 0 && sysinfo"
             class="text-center text-slate-500 text-sm py-4">
          Nessun gruppo rilevato
        </div>

        <div v-for="g in visibleGroups" :key="g.id"
             :class="['rounded-xl bg-slate-800 border border-slate-700/60 px-4 py-3.5 flex items-center justify-between gap-4 transition-all',
                      !isConnected && 'opacity-40']">
          <div>
            <div class="font-medium text-sm">Gruppo {{ g.id }}</div>
            <div :class="['text-xs mt-0.5', g.armed ? 'text-red-400' : 'text-emerald-400']">
              {{ g.armed ? 'Armato' : 'Disarmato' }}
            </div>
          </div>

          <button
            v-if="g.armed"
            @click="handleDisarm(g.id)"
            :disabled="cmdInProgress || !isConnected"
            class="px-4 py-2 rounded-lg text-sm font-semibold transition-colors
                   bg-emerald-700 hover:bg-emerald-600 active:bg-emerald-500
                   disabled:opacity-40 disabled:cursor-not-allowed"
          >Disarma</button>
          <button
            v-else
            @click="handleArm(g.id)"
            :disabled="cmdInProgress || !isConnected"
            class="px-4 py-2 rounded-lg text-sm font-semibold transition-colors
                   bg-red-700 hover:bg-red-600 active:bg-red-500
                   disabled:opacity-40 disabled:cursor-not-allowed"
          >Arma</button>
        </div>
      </template>

      <!-- Skeleton gruppi ─────────────────────────────────────────────────── -->
      <template v-if="loading && !groupStatus">
        <div v-for="i in 2" :key="i"
             class="rounded-xl bg-slate-800 h-[62px] animate-pulse" />
      </template>

    </main>

    <!-- Footer ──────────────────────────────────────────────────────────────── -->
    <footer class="px-4 pb-6 pt-2 space-y-3">

      <!-- Disconnetti + Aggiorna (quando connesso) -->
      <template v-if="isConnected">
        <div class="flex gap-2">
          <button
            @click="refresh"
            :disabled="loading"
            class="flex-1 py-3 rounded-xl text-sm font-semibold transition-colors
                   bg-slate-700 hover:bg-slate-600 active:bg-slate-500
                   disabled:opacity-40 disabled:cursor-not-allowed"
          >{{ loading ? 'Caricamento…' : 'Aggiorna' }}</button>
          <button
            @click="handleDisconnect"
            class="flex-1 py-3 rounded-xl text-sm font-semibold transition-colors
                   bg-slate-700 hover:bg-slate-600 active:bg-slate-500"
          >Disconnetti</button>
        </div>
      </template>

      <!-- Connetti (quando non connesso) -->
      <template v-else>
        <button
          @click="handleConnect"
          :disabled="isConnecting || !wsConnected"
          class="w-full py-3 rounded-xl text-sm font-semibold transition-colors
                 bg-blue-700 hover:bg-blue-600 active:bg-blue-500
                 disabled:opacity-40 disabled:cursor-not-allowed"
        >
          {{ isConnecting ? 'Connessione…' : 'Connetti' }}
        </button>
      </template>

    </footer>

  </div>
</template>

<script setup>
import { computed } from 'vue'
import { useAlarm } from './composables/useAlarm.js'

const {
  wsConnected, sessionState,
  sysinfo, groupStatus,
  loginError, sessionExpired,
  loading, cmdInProgress,
  countdown,
  arm, disarm, refresh,
  connectSession, disconnectSession,
} = useAlarm()

// ─── Stato sessione ────────────────────────────────────────────────────────────

const isConnected  = computed(() => sessionState.value === 'ready')
const isConnecting = computed(() =>
  ['connecting', 'logging_in', 'reconnecting'].includes(sessionState.value))

const displayState = computed(() => {
  if (!wsConnected.value) return 'offline'
  const map = {
    idle:        'non connesso',
    closed:      'non connesso',
    connecting:  'connessione…',
    logging_in:  'login…',
    reconnecting:'riconnessione…',
    ready:       'pronto',
  }
  return map[sessionState.value] ?? sessionState.value
})

const countdownFormatted = computed(() => {
  const m = Math.floor(countdown.value / 60)
  const s = String(countdown.value % 60).padStart(2, '0')
  return `${m}:${s}`
})

// ─── Stato allarme ─────────────────────────────────────────────────────────────

const isArmed  = computed(() => !!(groupStatus.value?.active))
const hasAlarm = computed(() => !!(sysinfo.value?.alarm))

const statusLabel = computed(() => {
  if (!groupStatus.value) return isConnected.value ? '…' : '––'
  if (hasAlarm.value) return 'Allarme'
  if (isArmed.value)  return 'Armato'
  return 'Disarmato'
})

const statusCardClass = computed(() => {
  if (!groupStatus.value || !isConnected.value)
    return 'bg-slate-800 border border-slate-700'
  if (hasAlarm.value) return 'bg-red-950 border-2 border-red-500'
  if (isArmed.value)  return 'bg-red-950/60 border border-red-800/60'
  return 'bg-emerald-950/60 border border-emerald-800/60'
})

const visibleGroups = computed(() => {
  if (!groupStatus.value) return []
  const { active = 0, zoneGroups = 0 } = groupStatus.value
  const mask = active | zoneGroups
  if (!mask) return []
  return Array.from({ length: 8 }, (_, i) => i)
    .filter(i => mask & (1 << i))
    .map(i => ({ id: i, armed: !!(active & (1 << i)) }))
})

// ─── Handlers ─────────────────────────────────────────────────────────────────

async function handleConnect()    { try { await connectSession() }    catch { /* ignorato */ } }
async function handleDisconnect() { try { await disconnectSession() } catch { /* ignorato */ } }
async function handleArm(id)      { try { await arm(id) }             catch { /* ignorato */ } }
async function handleDisarm(id)   { try { await disarm(id) }          catch { /* ignorato */ } }
</script>
