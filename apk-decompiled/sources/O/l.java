package O;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f152b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final IntentFilter f151a = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static float f153c = Float.NaN;

    /* JADX WARN: Multi-variable type inference failed */
    public static int a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent intentRegisterReceiver = context.getApplicationContext().registerReceiver(null, f151a);
        int i2 = ((intentRegisterReceiver == null ? 0 : intentRegisterReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        return ((h.d() ? powerManager.isInteractive() : powerManager.isScreenOn()) << 1) | i2;
    }

    public static synchronized float b(Context context) {
        if (SystemClock.elapsedRealtime() - f152b < 60000 && !Float.isNaN(f153c)) {
            return f153c;
        }
        if (context.getApplicationContext().registerReceiver(null, f151a) != null) {
            f153c = r6.getIntExtra("level", -1) / r6.getIntExtra("scale", -1);
        }
        f152b = SystemClock.elapsedRealtime();
        return f153c;
    }
}
