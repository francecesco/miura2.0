package org.simpleframework.xml.core;

/* JADX INFO: loaded from: classes.dex */
class SessionManager {
    private ThreadLocal<Reference> local = new ThreadLocal<>();

    private static class Reference {
        private int count;
        private Session session;

        public Reference(boolean z2) {
            this.session = new Session(z2);
        }

        public int clear() {
            int i2 = this.count - 1;
            this.count = i2;
            return i2;
        }

        public Session get() {
            int i2 = this.count;
            if (i2 >= 0) {
                this.count = i2 + 1;
            }
            return this.session;
        }
    }

    private Session create(boolean z2) {
        Reference reference = new Reference(z2);
        this.local.set(reference);
        return reference.get();
    }

    public void close() throws PersistenceException {
        Reference reference = this.local.get();
        if (reference == null) {
            throw new PersistenceException("Session does not exist", new Object[0]);
        }
        if (reference.clear() == 0) {
            this.local.remove();
        }
    }

    public Session open() {
        return open(true);
    }

    public Session open(boolean z2) {
        Reference reference = this.local.get();
        return reference != null ? reference.get() : create(z2);
    }
}
