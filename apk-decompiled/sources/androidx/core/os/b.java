package androidx.core.os;

import android.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f2237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f2238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2239d;

    public interface a {
        void a();
    }

    private void c() {
        while (this.f2239d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f2236a) {
                    return;
                }
                this.f2236a = true;
                this.f2239d = true;
                a aVar = this.f2237b;
                Object obj = this.f2238c;
                if (aVar != null) {
                    try {
                        aVar.a();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f2239d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f2239d = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    public void b(a aVar) {
        synchronized (this) {
            try {
                c();
                if (this.f2237b == aVar) {
                    return;
                }
                this.f2237b = aVar;
                if (this.f2236a && aVar != null) {
                    aVar.a();
                }
            } finally {
            }
        }
    }
}
