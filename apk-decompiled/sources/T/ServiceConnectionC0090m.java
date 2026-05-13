package T;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: renamed from: T.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceConnectionC0090m implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile U f309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0088k f311c;

    protected ServiceConnectionC0090m(C0088k c0088k) {
        this.f311c = c0088k;
    }

    public final U a() {
        F.i.d();
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        Context contextA = this.f311c.a();
        intent.putExtra("app_package_name", contextA.getPackageName());
        N.a aVarB = N.a.b();
        synchronized (this) {
            this.f309a = null;
            this.f310b = true;
            boolean zA = aVarB.a(contextA, intent, this.f311c.f301c, 129);
            this.f311c.c("Bind to service requested", Boolean.valueOf(zA));
            if (!zA) {
                this.f310b = false;
                return null;
            }
            try {
                wait(((Long) N.f188L.a()).longValue());
            } catch (InterruptedException unused) {
                this.f311c.B("Wait for service connect was interrupted");
            }
            this.f310b = false;
            U u2 = this.f309a;
            this.f309a = null;
            if (u2 == null) {
                this.f311c.C("Successfully bound to service but never got onServiceConnected callback");
            }
            return u2;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        K.e.c("AnalyticsServiceConnection.onServiceConnected");
        synchronized (this) {
            try {
                if (iBinder == null) {
                    this.f311c.C("Service connected with null binder");
                    return;
                }
                U v2 = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(interfaceDescriptor)) {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                        v2 = iInterfaceQueryLocalInterface instanceof U ? (U) iInterfaceQueryLocalInterface : new V(iBinder);
                        this.f311c.y("Bound to IAnalyticsService interface");
                    } else {
                        this.f311c.x("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException unused) {
                    this.f311c.C("Service connect failed to get IAnalyticsService");
                }
                if (v2 == null) {
                    try {
                        N.a.b().c(this.f311c.a(), this.f311c.f301c);
                    } catch (IllegalArgumentException unused2) {
                    }
                } else if (this.f310b) {
                    this.f309a = v2;
                } else {
                    this.f311c.B("onServiceConnected received after the timeout limit");
                    this.f311c.p().a(new RunnableC0091n(this, v2));
                }
            } finally {
                notifyAll();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        K.e.c("AnalyticsServiceConnection.onServiceDisconnected");
        this.f311c.p().a(new RunnableC0092o(this, componentName));
    }
}
