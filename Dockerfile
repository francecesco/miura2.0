# ── Stage 1: build frontend ──────────────────────────────────────────────────
FROM node:20-alpine AS frontend
WORKDIR /build
COPY frontend/package*.json ./
RUN npm ci
COPY frontend/ ./
RUN npm run build

# ── Stage 2: production image ────────────────────────────────────────────────
FROM node:20-alpine
WORKDIR /app

# Dipendenze backend (solo production)
COPY package*.json ./
RUN npm ci --omit=dev

# Sorgenti backend
COPY backend/ ./backend/

# Frontend già compilato dallo stage 1
COPY --from=frontend /build/dist ./frontend/dist

# Utente non-root
RUN addgroup -S miura && adduser -S miura -G miura
USER miura

ENV NODE_ENV=production
EXPOSE 3001

HEALTHCHECK --interval=30s --timeout=5s --start-period=15s --retries=3 \
  CMD wget -qO- http://localhost:${PORT:-3001}/health || exit 1

CMD ["node", "backend/server.js"]
