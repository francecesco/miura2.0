package N;

import O.l;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f131b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f130a = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f132c = false;

    public static d a() {
        return f130a;
    }

    public void b(Context context, String str, int i2, String str2, String str3, String str4, int i3, List list) {
        c(context, str, i2, str2, str3, str4, i3, list, 0L);
    }

    public void c(Context context, String str, int i2, String str2, String str3, String str4, int i3, List list, long j2) {
        List list2 = list;
        if (f131b == null) {
            f131b = Boolean.FALSE;
        }
        if (f131b.booleanValue()) {
            if (TextUtils.isEmpty(str)) {
                String strValueOf = String.valueOf(str);
                if (strValueOf.length() != 0) {
                    "missing wakeLock key. ".concat(strValueOf);
                    return;
                }
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (7 == i2 || 8 == i2 || 10 == i2 || 11 == i2) {
                if (list2 != null && list.size() == 1 && "com.google.android.gms".equals(list2.get(0))) {
                    list2 = null;
                }
                List list3 = list2;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                int iA = l.a(context);
                String packageName = context.getPackageName();
                try {
                    context.startService(new Intent().setComponent(b.f121a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(jCurrentTimeMillis, i2, str2, i3, list3, str, jElapsedRealtime, iA, str3, "com.google.android.gms".equals(packageName) ? null : packageName, l.b(context), j2, str4)));
                } catch (Exception e2) {
                    Log.wtf("WakeLockTracker", e2);
                }
            }
        }
    }
}
