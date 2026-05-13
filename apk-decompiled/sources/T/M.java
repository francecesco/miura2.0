package T;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class M {
    public static int a() {
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException unused) {
            W.b("Invalid version number", Build.VERSION.SDK);
            return 0;
        }
    }
}
