package T;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Object f265a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static U.a f266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Boolean f267c;

    public static void a(Context context, Intent intent) {
        X xD = C0085h.f(context).d();
        if (intent == null) {
            xD.B("AnalyticsReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        xD.c("Local AnalyticsReceiver got", action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean zI = f0.i(context);
            Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent2.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (f265a) {
                context.startService(intent2);
                if (zI) {
                    try {
                        if (f266b == null) {
                            U.a aVar = new U.a(context, 1, "Analytics WakeLock");
                            f266b = aVar;
                            aVar.d(false);
                        }
                        f266b.a(1000L);
                    } catch (SecurityException unused) {
                        xD.B("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                }
            }
        }
    }

    public static boolean b(Context context) {
        K.e.f(context);
        Boolean bool = f267c;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zB = l0.b(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        f267c = Boolean.valueOf(zB);
        return zB;
    }
}
