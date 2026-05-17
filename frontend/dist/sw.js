const CACHE = 'miura-v1'

const PRECACHE = [
  '/',
  '/manifest.json',
  '/icons/icon.svg',
  '/icons/icon-192.png',
  '/icons/icon-512.png',
  '/icons/apple-touch-icon.png',
]

self.addEventListener('install', event => {
  self.skipWaiting()
  event.waitUntil(
    caches.open(CACHE).then(c => c.addAll(PRECACHE))
  )
})

self.addEventListener('activate', event => {
  event.waitUntil(
    caches.keys()
      .then(keys => Promise.all(keys.filter(k => k !== CACHE).map(k => caches.delete(k))))
      .then(() => self.clients.claim())
  )
})

self.addEventListener('fetch', event => {
  const { request } = event
  const url = new URL(request.url)

  // Websocket e health: mai intercettare
  if (url.pathname === '/health') return
  if (request.headers.get('upgrade') === 'websocket') return

  // Asset con hash (JS/CSS): cache-first — cambiano solo quando cambia il bundle
  if (url.pathname.startsWith('/assets/')) {
    event.respondWith(
      caches.match(request).then(cached => {
        if (cached) return cached
        return fetch(request).then(res => {
          if (res.ok) caches.open(CACHE).then(c => c.put(request, res.clone()))
          return res
        })
      })
    )
    return
  }

  // Tutto il resto (HTML, icone, manifest): network-first con fallback cache
  event.respondWith(
    fetch(request)
      .then(res => {
        if (res.ok) caches.open(CACHE).then(c => c.put(request, res.clone()))
        return res
      })
      .catch(() => caches.match(request).then(r => r ?? Response.error()))
  )
})
