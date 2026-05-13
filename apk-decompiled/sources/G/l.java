package G;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.R$string;
import it.tervis.miura.model.Peripheral;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f54a = 12451000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final AtomicBoolean f55b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f56c = new AtomicBoolean();

    public static String a(int i2) {
        return a.e(i2);
    }

    public static Resources b(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static int c(Context context, int i2) {
        try {
            context.getResources().getString(R$string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !f56c.get()) {
            int iA = K.j.a(context);
            if (iA == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
            int i3 = f54a;
            if (iA != i3) {
                StringBuilder sb = new StringBuilder(320);
                sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                sb.append(i3);
                sb.append(" but found ");
                sb.append(iA);
                sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                throw new IllegalStateException(sb.toString());
            }
        }
        return h(context, (O.e.c(context) || O.e.d(context)) ? false : true, i2);
    }

    public static boolean d(Context context, int i2) {
        if (i2 == 18) {
            return true;
        }
        if (i2 == 1) {
            return f(context, "com.google.android.gms");
        }
        return false;
    }

    public static boolean e(Context context) {
        Bundle applicationRestrictions;
        return O.h.c() && (applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName())) != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    static boolean f(Context context, String str) {
        ApplicationInfo applicationInfo;
        boolean zEquals = str.equals("com.google.android.gms");
        if (O.h.e()) {
            try {
                Iterator<PackageInstaller.SessionInfo> it2 = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                while (it2.hasNext()) {
                    if (str.equals(it2.next().getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, Peripheral.EXPANSION_5);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        return zEquals ? applicationInfo.enabled : applicationInfo.enabled && !e(context);
    }

    public static boolean g(int i2) {
        return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 9;
    }

    private static int h(Context context, boolean z2, int i2) {
        PackageInfo packageInfo;
        K.e.a(i2 >= 0);
        PackageManager packageManager = context.getPackageManager();
        if (z2) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused) {
                return 9;
            }
        } else {
            packageInfo = null;
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            m.a(context);
            if (!m.c(packageInfo2, true)) {
                return 9;
            }
            if (z2 && (!m.c(packageInfo, true) || !packageInfo.signatures[0].equals(packageInfo2.signatures[0]))) {
                return 9;
            }
            if (O.m.a(packageInfo2.versionCode) < O.m.a(i2)) {
                int i3 = packageInfo2.versionCode;
                StringBuilder sb = new StringBuilder(77);
                sb.append("Google Play services out of date.  Requires ");
                sb.append(i2);
                sb.append(" but found ");
                sb.append(i3);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (PackageManager.NameNotFoundException unused2) {
            return 1;
        }
    }
}
