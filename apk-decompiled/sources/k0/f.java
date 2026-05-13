package k0;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
final class f implements a, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p0.a f3857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Object f3858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f3859c;

    public f(p0.a aVar, Object obj) {
        q0.f.e(aVar, "initializer");
        this.f3857a = aVar;
        this.f3858b = h.f3860a;
        this.f3859c = obj == null ? this : obj;
    }

    public boolean a() {
        return this.f3858b != h.f3860a;
    }

    @Override // k0.a
    public Object getValue() {
        Object objA;
        Object obj = this.f3858b;
        h hVar = h.f3860a;
        if (obj != hVar) {
            return obj;
        }
        synchronized (this.f3859c) {
            objA = this.f3858b;
            if (objA == hVar) {
                p0.a aVar = this.f3857a;
                q0.f.b(aVar);
                objA = aVar.a();
                this.f3858b = objA;
                this.f3857a = null;
            }
        }
        return objA;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ f(p0.a aVar, Object obj, int i2, q0.d dVar) {
        this(aVar, (i2 & 2) != 0 ? null : obj);
    }
}
