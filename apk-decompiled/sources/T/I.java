package T;

import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
final class I implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ H f172a;

    I(H h2) {
        this.f172a = h2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f172a.f169a.g().a(this);
            return;
        }
        boolean zG = this.f172a.g();
        H.d(this.f172a, 0L);
        if (zG) {
            this.f172a.c();
        }
    }
}
