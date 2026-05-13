package n;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: n.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0229b {
    static Handler a() {
        return Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
    }
}
