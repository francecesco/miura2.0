package T;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes.dex */
class Y extends BroadcastReceiver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f239d = "T.Y";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0085h f240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f242c;

    Y(C0085h c0085h) {
        K.e.f(c0085h);
        this.f240a = c0085h;
    }

    private final void d() {
        this.f240a.d();
        this.f240a.h();
    }

    private final boolean f() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f240a.a().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (SecurityException unused) {
        }
        return false;
    }

    public final boolean a() {
        if (!this.f241b) {
            this.f240a.d().B("Connectivity unknown. Receiver not registered");
        }
        return this.f242c;
    }

    public final void b() {
        if (this.f241b) {
            this.f240a.d().y("Unregistering connectivity change receiver");
            this.f241b = false;
            this.f242c = false;
            try {
                this.f240a.a().unregisterReceiver(this);
            } catch (IllegalArgumentException e2) {
                this.f240a.d().x("Failed to unregister the network broadcast receiver", e2);
            }
        }
    }

    public final void c() {
        d();
        if (this.f241b) {
            return;
        }
        Context contextA = this.f240a.a();
        contextA.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
        intentFilter.addCategory(contextA.getPackageName());
        contextA.registerReceiver(this, intentFilter);
        this.f242c = f();
        this.f240a.d().c("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f242c));
        this.f241b = true;
    }

    public final void e() {
        Context contextA = this.f240a.a();
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(contextA.getPackageName());
        intent.putExtra(f239d, true);
        contextA.sendOrderedBroadcast(intent, null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        d();
        String action = intent.getAction();
        this.f240a.d().c("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zF = f();
            if (this.f242c != zF) {
                this.f242c = zF;
                C0079b c0079bH = this.f240a.h();
                c0079bH.c("Network connectivity status changed", Boolean.valueOf(zF));
                c0079bH.p().a(new RunnableC0080c(c0079bH, zF));
                return;
            }
            return;
        }
        if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.f240a.d().v("NetworkBroadcastReceiver received unknown action", action);
        } else {
            if (intent.hasExtra(f239d)) {
                return;
            }
            C0079b c0079bH2 = this.f240a.h();
            c0079bH2.y("Radio powered up");
            c0079bH2.L();
        }
    }
}
