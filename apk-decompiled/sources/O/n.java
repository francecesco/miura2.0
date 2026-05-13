package O;

import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {
    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
