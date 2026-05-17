<template>
  <div class="min-h-screen bg-slate-900 text-white flex flex-col max-w-md mx-auto">

    <!-- Header ──────────────────────────────────────────────────────────────── -->
    <header class="flex items-center justify-between px-5 py-4 bg-slate-800/80 backdrop-blur border-b border-slate-700/60">
      <!-- Indicatore connessione -->
      <div class="flex items-center gap-2 min-w-[80px]">
        <span :class="[
          'w-2 h-2 rounded-full flex-shrink-0 transition-colors',
          wsConnected ? 'bg-emerald-400' : 'bg-red-400 animate-pulse'
        ]" />
        <span class="text-xs text-slate-400 capitalize">
          {{ wsConnected ? sessionState : 'offline' }}
        </span>
      </div>

      <!-- Nome sistema -->
      <h1 class="font-semibold text-base tracking-wide">
        {{ sysinfo?.name || 'Miura 2.0' }}
      </h1>

      <!-- Batteria + firmware -->
      <div class="text-xs text-slate-400 text-right min-w-[80px]">
        <span v-if="sysinfo">
          <span class="mr-1">🔋</span>{{ sysinfo.battery }}
          <span class="block text-slate-600">fw {{ sysinfo.firmware }}</span>
        </span>
        <span v-else>–</span>
      </div>
    </header>

    <!-- Contenuto principale ─────────────────────────────────────────────── -->
    <main class="flex-1 px-4 py-5 space-y-4">

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
        <!-- Skeleton -->
        <template v-if="loading && !sysinfo">
          <div class="h-12 w-32 mx-auto rounded-lg bg-slate-700 animate-pulse" />
        </template>

        <template v-else>
          <div class="text-5xl font-black tracking-tight uppercase">
            {{ statusLabel }}
          </div>
          <div v-if="sysinfo?.alarm"
               class="mt-3 inline-flex items-center gap-2 text-sm font-semibold text-red-200 animate-pulse">
            🚨 Allarme in corso
          </div>
          <div v-else-if="sysinfo?.trouble"
               class="mt-3 inline-flex items-center gap-2 text-sm font-semibold text-amber-300">
            ⚠️ Anomalia rilevata
          </div>
          <div v-else-if="sysinfo?.partial"
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
             class="rounded-xl bg-slate-800 border border-slate-700/60 px-4 py-3.5 flex items-center justify-between gap-4 transition-colors">
          <div>
            <div class="font-medium text-sm">Gruppo {{ g.id }}</div>
            <div :class="['text-xs mt-0.5', g.armed ? 'text-red-400' : 'text-emerald-400']">
              {{ g.armed ? 'Armato' : 'Disarmato' }}
            </div>
          </div>

          <button
            v-if="g.armed"
            @click="handleDisarm(g.id)"
            :disabled="cmdInProgress"
            class="px-4 py-2 rounded-lg text-sm font-semibold transition-colors
                   bg-emerald-700 hover:bg-emerald-600 active:bg-emerald-500
                   disabled:opacity-40 disabled:cursor-not-allowed"
          >
            Disarma
          </button>
          <button
            v-else
            @click="handleArm(g.id)"
            :disabled="cmdInProgress"
            class="px-4 py-2 rounded-lg text-sm font-semibold transition-colors
                   bg-red-700 hover:bg-red-600 active:bg-red-500
                   disabled:opacity-40 disabled:cursor-not-allowed"
          >
            Arma
          </button>
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
      <button
        @click="refresh"
        :disabled="loading || !wsConnected"
        class="w-full py-3 rounded-xl text-sm font-semibold transition-colors
               bg-slate-700 hover:bg-slate-600 active:bg-slate-500
               disabled:opacity-40 disabled:cursor-not-allowed"
      >
        {{ loading ? 'Caricamento…' : 'Aggiorna' }}
      </button>
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
  arm, disarm, refresh,
} = useAlarm()

// ─── Computed ─────────────────────────────────────────────────────────────────

const statusLabel = computed(() => {
  if (!sysinfo.value) return wsConnected.value ? '…' : 'Offline'
  if (sysinfo.value.alarm)   return 'Allarme'
  if (sysinfo.value.armed)   return 'Armato'
  return 'Disarmato'
})

const statusCardClass = computed(() => {
  if (!sysinfo.value) return 'bg-slate-800 border border-slate-700'
  if (sysinfo.value.alarm)
    return 'bg-red-950 border-2 border-red-500'
  if (sysinfo.value.armed)
    return 'bg-red-950/60 border border-red-800/60'
  return 'bg-emerald-950/60 border border-emerald-800/60'
})

// Mostra i gruppi presenti nella maschera active | zoneGroups
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

async function handleArm(groupId) {
  try { await arm(groupId) } catch { /* errori gestiti dal composable */ }
}

async function handleDisarm(groupId) {
  try { await disarm(groupId) } catch { /* errori gestiti dal composable */ }
}
</script>
