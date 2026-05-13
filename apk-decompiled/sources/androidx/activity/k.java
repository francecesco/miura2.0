package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p0.a f784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Runnable f790h;

    public k(Executor executor, p0.a aVar) {
        q0.f.e(executor, "executor");
        q0.f.e(aVar, "reportFullyDrawn");
        this.f783a = executor;
        this.f784b = aVar;
        this.f785c = new Object();
        this.f789g = new ArrayList();
        this.f790h = new Runnable() { // from class: androidx.activity.j
            @Override // java.lang.Runnable
            public final void run() {
                k.d(this.f782a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(k kVar) {
        q0.f.e(kVar, "this$0");
        synchronized (kVar.f785c) {
            try {
                kVar.f787e = false;
                if (kVar.f786d == 0 && !kVar.f788f) {
                    kVar.f784b.a();
                    kVar.b();
                }
                k0.i iVar = k0.i.f3861a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f785c) {
            try {
                this.f788f = true;
                Iterator it2 = this.f789g.iterator();
                while (it2.hasNext()) {
                    ((p0.a) it2.next()).a();
                }
                this.f789g.clear();
                k0.i iVar = k0.i.f3861a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        boolean z2;
        synchronized (this.f785c) {
            z2 = this.f788f;
        }
        return z2;
    }
}
