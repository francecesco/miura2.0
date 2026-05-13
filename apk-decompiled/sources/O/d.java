package O;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d f133a = new d();

    private d() {
    }

    public static c c() {
        return f133a;
    }

    @Override // O.c
    public long a() {
        return System.currentTimeMillis();
    }

    @Override // O.c
    public long b() {
        return SystemClock.elapsedRealtime();
    }
}
