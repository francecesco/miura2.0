package G;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f51a = l.f54a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final j f52b = new j();

    j() {
    }

    private static String h(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f51a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(P.b.a(context).e(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sb.toString();
    }

    public Intent a(Context context, int i2, String str) {
        if (i2 == 1 || i2 == 2) {
            return (context == null || !O.e.c(context)) ? K.g.a("com.google.android.gms", h(context, str)) : K.g.c();
        }
        if (i2 != 3) {
            return null;
        }
        return K.g.b("com.google.android.gms");
    }

    public PendingIntent b(Context context, int i2, int i3) {
        return c(context, i2, i3, null);
    }

    public PendingIntent c(Context context, int i2, int i3, String str) {
        Intent intentA = a(context, i2, str);
        if (intentA == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i3, intentA, 134217728);
    }

    public String d(int i2) {
        return l.a(i2);
    }

    public int e(Context context) {
        return f(context, f51a);
    }

    public int f(Context context, int i2) {
        int iC = l.c(context, i2);
        if (l.d(context, iC)) {
            return 18;
        }
        return iC;
    }

    public boolean g(int i2) {
        return l.g(i2);
    }
}
