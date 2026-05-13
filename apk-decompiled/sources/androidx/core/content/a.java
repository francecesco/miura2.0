package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.n;
import androidx.core.content.res.h;
import java.io.File;
import o.AbstractC0234c;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f2114a = new Object();

    /* JADX INFO: renamed from: androidx.core.content.a$a, reason: collision with other inner class name */
    static class C0031a {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }

        static Drawable b(Context context, int i2) {
            return context.getDrawable(i2);
        }

        static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    static class b {
        static int a(Context context, int i2) {
            return context.getColor(i2);
        }

        static <T> T b(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        static String c(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    public static int a(Context context, String str) {
        AbstractC0234c.d(str, "permission must be non-null");
        return (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) ? context.checkPermission(str, Process.myPid(), Process.myUid()) : n.b(context).a() ? 0 : -1;
    }

    public static int b(Context context, int i2) {
        return Build.VERSION.SDK_INT >= 23 ? b.a(context, i2) : context.getResources().getColor(i2);
    }

    public static ColorStateList c(Context context, int i2) {
        return h.c(context.getResources(), i2, context.getTheme());
    }

    public static Drawable d(Context context, int i2) {
        return C0031a.b(context, i2);
    }

    public static boolean e(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
        return true;
    }

    public static void f(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }
}
