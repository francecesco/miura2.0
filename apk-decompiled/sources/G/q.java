package G;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f61a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f62b;

    static synchronized void a(Context context) {
        if (f62b != null || context == null) {
            return;
        }
        f62b = context.getApplicationContext();
    }
}
