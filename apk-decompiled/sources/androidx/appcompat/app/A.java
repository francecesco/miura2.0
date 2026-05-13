package androidx.appcompat.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import android.os.Build;
import it.tervis.miura.model.Peripheral;

/* JADX INFO: loaded from: classes.dex */
public abstract class A extends Service {

    private static class a {
        static int a() {
            return Peripheral.EXPANSION_1;
        }
    }

    public static ServiceInfo a(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) A.class), Build.VERSION.SDK_INT >= 24 ? a.a() | 128 : 640);
    }
}
