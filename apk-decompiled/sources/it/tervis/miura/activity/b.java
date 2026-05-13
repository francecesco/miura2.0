package it.tervis.miura.activity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import it.tervis.miura.MiuraService;
import it.tervis.miura.model.Configuration;
import it.tervis.miura.model.Installation;
import j0.d;
import j0.f;
import z.C0277a;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends it.tervis.miura.activity.a implements it.tervis.miura.a {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private c f3761D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    protected boolean f3762E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    protected ServiceConnection f3763F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    protected MiuraService f3764G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    protected boolean f3765H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private BroadcastReceiver f3766I = new a();

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            b.this.finish();
        }
    }

    /* JADX INFO: renamed from: it.tervis.miura.activity.b$b, reason: collision with other inner class name */
    class ServiceConnectionC0064b implements ServiceConnection {
        ServiceConnectionC0064b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.a(b.this.toString() + " Service connected!");
            b.this.f3764G = ((MiuraService.m) iBinder).a();
            b.this.I0();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.a(b.this.toString() + " Service disconnected!");
            b.this.J0();
            b bVar = b.this;
            bVar.f3764G = null;
            bVar.f3765H = false;
        }
    }

    private class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
        }

        /* synthetic */ c(b bVar, a aVar) {
            this();
        }
    }

    private void E0() {
        Intent intent = new Intent(this, (Class<?>) MiuraService.class);
        ServiceConnectionC0064b serviceConnectionC0064b = new ServiceConnectionC0064b();
        this.f3763F = serviceConnectionC0064b;
        this.f3765H = bindService(intent, serviceConnectionC0064b, 64);
    }

    private void F0() {
        unbindService(this.f3763F);
    }

    private void K0() {
        C0277a.b(this).c(this.f3766I, new IntentFilter("SESSION_CLOSED"));
    }

    private void L0() {
        if (this.f3761D == null) {
            this.f3761D = new c(this, null);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.f3761D, intentFilter);
    }

    private void M0() {
        C0277a.b(this).e(this.f3766I);
    }

    private void N0() {
        unregisterReceiver(this.f3761D);
    }

    @Override // it.tervis.miura.a
    public void A(MiuraService.n nVar) {
        MiuraService miuraService = this.f3764G;
        if (miuraService != null) {
            miuraService.Y(nVar);
        }
    }

    public void D0() {
        try {
            f.j();
            deleteFile("texts.cache");
        } catch (Exception e2) {
            d.c(e2);
        }
    }

    @Override // it.tervis.miura.a
    public void F(Configuration configuration) {
        this.f3764G.T(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G0(MiuraService.n.a aVar) {
        W.c.Z1();
        D();
        C0("Errore", "Impossibile raggiungere la centrale, connessione non stabile. Riprovare più tardi.", true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H0() {
        W.c.Z1();
        D();
        C0("Errore", "Sessione utente chiusa. Riprovare più tardi.", true);
    }

    protected abstract void I0();

    public void J() {
    }

    protected abstract void J0();

    public void e() {
    }

    @Override // it.tervis.miura.a
    public void l(Y.b bVar, Y.f fVar) {
        MiuraService miuraService = this.f3764G;
        if (miuraService != null) {
            miuraService.b0(bVar, fVar);
        }
    }

    @Override // it.tervis.miura.a
    public void o(MiuraService.n nVar) {
        MiuraService miuraService = this.f3764G;
        if (miuraService != null) {
            miuraService.t(nVar);
        }
    }

    @Override // androidx.appcompat.app.AbstractActivityC0108d, androidx.fragment.app.AbstractActivityC0171j, android.app.Activity
    protected void onStart() {
        L0();
        M0();
        this.f3762E = false;
        E0();
        super.onStart();
    }

    @Override // androidx.appcompat.app.AbstractActivityC0108d, androidx.fragment.app.AbstractActivityC0171j, android.app.Activity
    protected void onStop() {
        N0();
        this.f3762E = true;
        F0();
        K0();
        super.onStop();
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        MiuraService miuraService = this.f3764G;
        if (miuraService != null) {
            miuraService.L();
        }
    }

    @Override // it.tervis.miura.a
    public void s(Y.b bVar) {
        MiuraService miuraService = this.f3764G;
        if (miuraService != null) {
            miuraService.a0(bVar);
        }
    }

    @Override // it.tervis.miura.a
    public Installation z() {
        MiuraService miuraService = this.f3764G;
        if (miuraService != null) {
            return miuraService.y();
        }
        d.a("Installation null?????");
        return null;
    }
}
