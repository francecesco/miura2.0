package O;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Boolean f136c;

    public static boolean a(Context context) {
        if (f135b == null) {
            f135b = Boolean.valueOf(h.e() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f135b.booleanValue();
    }

    public static boolean b(Context context) {
        if (f134a == null) {
            f134a = Boolean.valueOf(h.d() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f134a.booleanValue();
    }

    public static boolean c(Context context) {
        if (!b(context)) {
            return false;
        }
        if (h.f()) {
            return a(context) && !h.g();
        }
        return true;
    }

    public static boolean d(Context context) {
        if (f136c == null) {
            f136c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f136c.booleanValue();
    }
}
