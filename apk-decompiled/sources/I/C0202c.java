package i;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: i.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0202c extends AbstractC0204e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile C0202c f3633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Executor f3634d = new Executor() { // from class: i.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            C0202c.g(runnable);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Executor f3635e = new Executor() { // from class: i.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            C0202c.h(runnable);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AbstractC0204e f3636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AbstractC0204e f3637b;

    private C0202c() {
        C0203d c0203d = new C0203d();
        this.f3637b = c0203d;
        this.f3636a = c0203d;
    }

    public static C0202c f() {
        if (f3633c != null) {
            return f3633c;
        }
        synchronized (C0202c.class) {
            try {
                if (f3633c == null) {
                    f3633c = new C0202c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f3633c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(Runnable runnable) {
        f().c(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Runnable runnable) {
        f().a(runnable);
    }

    @Override // i.AbstractC0204e
    public void a(Runnable runnable) {
        this.f3636a.a(runnable);
    }

    @Override // i.AbstractC0204e
    public boolean b() {
        return this.f3636a.b();
    }

    @Override // i.AbstractC0204e
    public void c(Runnable runnable) {
        this.f3636a.c(runnable);
    }
}
