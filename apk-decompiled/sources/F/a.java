package F;

import T.l0;
import android.content.BroadcastReceiver;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f7a;

    public static boolean a(Context context) {
        K.e.f(context);
        Boolean bool = f7a;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zB = l0.b(context, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
        f7a = Boolean.valueOf(zB);
        return zB;
    }
}
