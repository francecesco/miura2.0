package K;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f110a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f113d;

    public static int a(Context context) {
        b(context);
        return f113d;
    }

    private static void b(Context context) {
        synchronized (f110a) {
            try {
                if (f111b) {
                    return;
                }
                f111b = true;
                try {
                    Bundle bundle = P.b.a(context).c(context.getPackageName(), 128).metaData;
                    if (bundle == null) {
                        return;
                    }
                    f112c = bundle.getString("com.google.app.id");
                    f113d = bundle.getInt("com.google.android.gms.version");
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
