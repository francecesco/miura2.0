package N;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f115e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile a f116f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f120d;

    private a() {
        List list = Collections.EMPTY_LIST;
        this.f117a = list;
        this.f118b = list;
        this.f119c = list;
        this.f120d = list;
    }

    public static a b() {
        if (f116f == null) {
            synchronized (f115e) {
                try {
                    if (f116f == null) {
                        f116f = new a();
                    }
                } finally {
                }
            }
        }
        return f116f;
    }

    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i2) {
        return d(context, context.getClass().getName(), intent, serviceConnection, i2);
    }

    public void c(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }

    public final boolean d(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2) {
        ComponentName component = intent.getComponent();
        if (component == null ? false : O.b.a(context, component.getPackageName())) {
            return false;
        }
        return context.bindService(intent, serviceConnection, i2);
    }
}
