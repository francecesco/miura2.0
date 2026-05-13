package T;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
abstract class H {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile Handler f168d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0085h f169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Runnable f170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f171c;

    H(C0085h c0085h) {
        K.e.f(c0085h);
        this.f169a = c0085h;
        this.f170b = new I(this);
    }

    private final Handler b() {
        Handler handler;
        if (f168d != null) {
            return f168d;
        }
        synchronized (H.class) {
            try {
                if (f168d == null) {
                    f168d = new q0(this.f169a.a().getMainLooper());
                }
                handler = f168d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    static /* synthetic */ long d(H h2, long j2) {
        h2.f171c = 0L;
        return 0L;
    }

    public final void a() {
        this.f171c = 0L;
        b().removeCallbacks(this.f170b);
    }

    public abstract void c();

    public final long f() {
        if (this.f171c == 0) {
            return 0L;
        }
        return Math.abs(this.f169a.c().a() - this.f171c);
    }

    public final boolean g() {
        return this.f171c != 0;
    }

    public final void h(long j2) {
        a();
        if (j2 >= 0) {
            this.f171c = this.f169a.c().a();
            if (b().postDelayed(this.f170b, j2)) {
                return;
            }
            this.f169a.d().x("Failed to schedule delayed post. time", Long.valueOf(j2));
        }
    }

    public final void i(long j2) {
        if (g()) {
            if (j2 < 0) {
                a();
                return;
            }
            long jAbs = j2 - Math.abs(this.f169a.c().a() - this.f171c);
            long j3 = jAbs >= 0 ? jAbs : 0L;
            b().removeCallbacks(this.f170b);
            if (b().postDelayed(this.f170b, j3)) {
                return;
            }
            this.f169a.d().x("Failed to adjust delayed post. time", Long.valueOf(j3));
        }
    }
}
