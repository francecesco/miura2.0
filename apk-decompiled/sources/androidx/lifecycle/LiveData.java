package androidx.lifecycle;

import androidx.lifecycle.AbstractC0183g;
import i.C0202c;
import j.C0206b;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final Object f3044k = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f3045a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C0206b f3046b = new C0206b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f3047c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile Object f3049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile Object f3050f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3051g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f3052h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3053i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Runnable f3054j;

    class LifecycleBoundObserver extends androidx.lifecycle.LiveData.c implements j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final l f3055e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ LiveData f3056f;

        @Override // androidx.lifecycle.j
        public void d(l lVar, AbstractC0183g.a aVar) {
            AbstractC0183g.b bVarB = this.f3055e.G().b();
            if (bVarB == AbstractC0183g.b.DESTROYED) {
                this.f3056f.h(this.f3059a);
                return;
            }
            AbstractC0183g.b bVar = null;
            while (bVar != bVarB) {
                h(j());
                bVar = bVarB;
                bVarB = this.f3055e.G().b();
            }
        }

        void i() {
            this.f3055e.G().c(this);
        }

        boolean j() {
            return this.f3055e.G().b().b(AbstractC0183g.b.STARTED);
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f3045a) {
                obj = LiveData.this.f3050f;
                LiveData.this.f3050f = LiveData.f3044k;
            }
            LiveData.this.i(obj);
        }
    }

    private class b extends c {
        b(q qVar) {
            super(qVar);
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean j() {
            return true;
        }
    }

    private abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final q f3059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f3060b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f3061c = -1;

        c(q qVar) {
            this.f3059a = qVar;
        }

        void h(boolean z2) {
            if (z2 == this.f3060b) {
                return;
            }
            this.f3060b = z2;
            LiveData.this.b(z2 ? 1 : -1);
            if (this.f3060b) {
                LiveData.this.d(this);
            }
        }

        void i() {
        }

        abstract boolean j();
    }

    public LiveData() {
        Object obj = f3044k;
        this.f3050f = obj;
        this.f3054j = new a();
        this.f3049e = obj;
        this.f3051g = -1;
    }

    static void a(String str) {
        if (C0202c.f().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void c(c cVar) {
        if (cVar.f3060b) {
            if (!cVar.j()) {
                cVar.h(false);
                return;
            }
            int i2 = cVar.f3061c;
            int i3 = this.f3051g;
            if (i2 >= i3) {
                return;
            }
            cVar.f3061c = i3;
            cVar.f3059a.a(this.f3049e);
        }
    }

    void b(int i2) {
        int i3 = this.f3047c;
        this.f3047c = i2 + i3;
        if (this.f3048d) {
            return;
        }
        this.f3048d = true;
        while (true) {
            try {
                int i4 = this.f3047c;
                if (i3 == i4) {
                    this.f3048d = false;
                    return;
                }
                boolean z2 = i3 == 0 && i4 > 0;
                boolean z3 = i3 > 0 && i4 == 0;
                if (z2) {
                    f();
                } else if (z3) {
                    g();
                }
                i3 = i4;
            } catch (Throwable th) {
                this.f3048d = false;
                throw th;
            }
        }
    }

    void d(c cVar) {
        if (this.f3052h) {
            this.f3053i = true;
            return;
        }
        this.f3052h = true;
        do {
            this.f3053i = false;
            if (cVar != null) {
                c(cVar);
                cVar = null;
            } else {
                C0206b.d dVarC = this.f3046b.c();
                while (dVarC.hasNext()) {
                    c((c) ((Map.Entry) dVarC.next()).getValue());
                    if (this.f3053i) {
                        break;
                    }
                }
            }
        } while (this.f3053i);
        this.f3052h = false;
    }

    public void e(q qVar) {
        a("observeForever");
        b bVar = new b(qVar);
        c cVar = (c) this.f3046b.f(qVar, bVar);
        if (cVar instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVar != null) {
            return;
        }
        bVar.h(true);
    }

    protected void f() {
    }

    protected void g() {
    }

    public void h(q qVar) {
        a("removeObserver");
        c cVar = (c) this.f3046b.g(qVar);
        if (cVar == null) {
            return;
        }
        cVar.i();
        cVar.h(false);
    }

    protected void i(Object obj) {
        a("setValue");
        this.f3051g++;
        this.f3049e = obj;
        d(null);
    }
}
