package it.tervis.miura;

import X.j;
import X.k;
import X.l;
import X.n;
import X.o;
import X.q;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AbstractC0105a;
import androidx.appcompat.app.AbstractC0106b;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.E;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.G;
import androidx.fragment.app.x;
import androidx.viewpager.widget.ViewPager;
import it.tervis.miura.MiuraService;
import it.tervis.miura.model.BootLock;
import it.tervis.miura.model.Installation;
import it.tervis.miura.model.InstallationManager;

/* JADX INFO: loaded from: classes.dex */
public class Miura extends it.tervis.miura.activity.b {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private ViewPager f3657J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private E f3658K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private DrawerLayout f3659L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private AbstractC0106b f3660M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private X.e f3661N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private k f3662O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private n f3663P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private q f3664Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private j f3665R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private boolean f3666S;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    private o f3668U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    private l f3669V;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private String f3667T = "SICUREZZA";

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    private MiuraService.n f3670W = new a();

    class a extends MiuraService.n {

        /* JADX INFO: renamed from: it.tervis.miura.Miura$a$a, reason: collision with other inner class name */
        class RunnableC0061a implements Runnable {
            RunnableC0061a() {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Miura.this.v("Autenticazione...");
            }
        }

        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Miura.this.v("Caricamento configurazione...");
                Miura.this.f0().o().m(Miura.this.f3661N).g();
                Miura.this.t1();
            }
        }

        class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f3675a;

            d(int i2) {
                this.f3675a = i2;
            }

            /* JADX WARN: Removed duplicated region for block: B:6:0x000d  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    r4 = this;
                    int r0 = r4.f3675a
                    java.lang.String r1 = "Utente non trovato"
                    r2 = 1
                    java.lang.String r3 = "Errore"
                    if (r0 == 0) goto Ld
                    switch(r0) {
                        case 250: goto L54;
                        case 251: goto L46;
                        case 252: goto L38;
                        case 253: goto L2a;
                        case 254: goto L1c;
                        case 255: goto Ld;
                        default: goto Lc;
                    }
                Lc:
                    goto L62
                Ld:
                    it.tervis.miura.Miura$a r0 = it.tervis.miura.Miura.a.this
                    it.tervis.miura.Miura r0 = it.tervis.miura.Miura.this
                    r0.D()
                    it.tervis.miura.Miura$a r0 = it.tervis.miura.Miura.a.this
                    it.tervis.miura.Miura r0 = it.tervis.miura.Miura.this
                L18:
                    it.tervis.miura.Miura.m1(r0, r3, r1, r2)
                    goto L62
                L1c:
                    it.tervis.miura.Miura$a r0 = it.tervis.miura.Miura.a.this
                    it.tervis.miura.Miura r0 = it.tervis.miura.Miura.this
                    r0.D()
                    it.tervis.miura.Miura$a r0 = it.tervis.miura.Miura.a.this
                    it.tervis.miura.Miura r0 = it.tervis.miura.Miura.this
                    java.lang.String r1 = "Sessione bloccata causa codice errato"
                    goto L18
                L2a:
                    it.tervis.miura.Miura$a r0 = it.tervis.miura.Miura.a.this
                    it.tervis.miura.Miura r0 = it.tervis.miura.Miura.this
                    r0.D()
                    it.tervis.miura.Miura$a r0 = it.tervis.miura.Miura.a.this
                    it.tervis.miura.Miura r0 = it.tervis.miura.Miura.this
                    java.lang.String r1 = "Sessione gia' aperta"
                    goto L18
                L38:
                    it.tervis.miura.Miura$a r0 = it.tervis.miura.Miura.a.this
                    it.tervis.miura.Miura r0 = it.tervis.miura.Miura.this
                    r0.D()
                    it.tervis.miura.Miura$a r0 = it.tervis.miura.Miura.a.this
                    it.tervis.miura.Miura r0 = it.tervis.miura.Miura.this
                    java.lang.String r1 = "Sessione non accessibile causa gruppo attivato"
                    goto L18
                L46:
                    it.tervis.miura.Miura$a r0 = it.tervis.miura.Miura.a.this
                    it.tervis.miura.Miura r0 = it.tervis.miura.Miura.this
                    r0.D()
                    it.tervis.miura.Miura$a r0 = it.tervis.miura.Miura.a.this
                    it.tervis.miura.Miura r0 = it.tervis.miura.Miura.this
                    java.lang.String r1 = "Sessione non accessibile in base ad impostazioni orarie"
                    goto L18
                L54:
                    it.tervis.miura.Miura$a r0 = it.tervis.miura.Miura.a.this
                    it.tervis.miura.Miura r0 = it.tervis.miura.Miura.this
                    r0.D()
                    it.tervis.miura.Miura$a r0 = it.tervis.miura.Miura.a.this
                    it.tervis.miura.Miura r0 = it.tervis.miura.Miura.this
                    java.lang.String r1 = "Utente non autorizzato ad operare da remoto"
                    goto L18
                L62:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: it.tervis.miura.Miura.a.d.run():void");
            }
        }

        class e implements Runnable {
            e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Miura.this.v("Caricamento configurazione...");
                Miura.this.G1();
                Miura.this.D();
                Miura.this.f3659L.setDrawerLockMode(0);
                Miura.this.s(new e0.b());
            }
        }

        class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MiuraService.n.a f3678a;

            f(MiuraService.n.a aVar) {
                this.f3678a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Miura.this.G0(this.f3678a);
            }
        }

        a() {
        }

        @Override // it.tervis.miura.MiuraService.n
        public void a() {
            Miura.this.q1("Errore di connessione", "Impossibile raggiungere Miura.");
            ((it.tervis.miura.activity.b) Miura.this).f3764G.u();
        }

        @Override // it.tervis.miura.MiuraService.n
        public void b() {
            Miura.this.q1("Errore di connessione", "Impossibile comunicare con la centrale Miura. Verificare la connessione.");
            ((it.tervis.miura.activity.b) Miura.this).f3764G.u();
        }

        @Override // it.tervis.miura.MiuraService.n
        public void c(Y.b bVar) {
            if (BootLock.isLocked()) {
                BootLock.unlock(bVar);
            }
        }

        @Override // it.tervis.miura.MiuraService.n
        public void d() {
            Miura.this.D();
            Miura.this.v("Caricamento configurazione...");
        }

        @Override // it.tervis.miura.MiuraService.n
        public void e() {
            Miura.this.v("Connessione in corso...");
            ((it.tervis.miura.activity.a) Miura.this).f3754C.post(new RunnableC0061a());
            Miura.this.z1();
        }

        @Override // it.tervis.miura.MiuraService.n
        public void f(MiuraService.n.a aVar) {
            ((it.tervis.miura.activity.a) Miura.this).f3754C.post(new f(aVar));
        }

        @Override // it.tervis.miura.MiuraService.n
        public void g() {
            Miura.this.v("Caricamento configurazione...");
        }

        @Override // it.tervis.miura.MiuraService.n
        public void h(int i2) {
            ((it.tervis.miura.activity.a) Miura.this).f3754C.post(new d(i2));
        }

        @Override // it.tervis.miura.MiuraService.n
        public void i() {
            j0.d.a("Miura Activity: onLoginPerformed()");
            ((it.tervis.miura.activity.a) Miura.this).f3754C.post(new c());
        }

        @Override // it.tervis.miura.MiuraService.n
        public void j() {
            ((it.tervis.miura.activity.a) Miura.this).f3754C.post(new b());
        }

        @Override // it.tervis.miura.MiuraService.n
        public void l() {
            ((it.tervis.miura.activity.a) Miura.this).f3754C.post(new e());
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    class c implements Installation.UserSessionListener {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ h0.c f3682a;

            a(h0.c cVar) {
                this.f3682a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC0105a abstractC0105aQ0;
                String host;
                View viewFindViewById;
                int i2;
                j0.d.a("UserInfoData authorized: " + this.f3682a.x());
                if (((it.tervis.miura.activity.b) Miura.this).f3764G.x() == null || ((it.tervis.miura.activity.b) Miura.this).f3764G.x().getName() == null) {
                    abstractC0105aQ0 = Miura.this.q0();
                    host = ((it.tervis.miura.activity.b) Miura.this).f3764G.x().getHost();
                } else {
                    abstractC0105aQ0 = Miura.this.q0();
                    host = "Impianto: " + ((it.tervis.miura.activity.b) Miura.this).f3764G.x().getName();
                }
                abstractC0105aQ0.A(host);
                if (this.f3682a.x()) {
                    viewFindViewById = Miura.this.findViewById(R.id.mask);
                    i2 = 8;
                } else {
                    viewFindViewById = Miura.this.findViewById(R.id.mask);
                    i2 = 0;
                }
                viewFindViewById.setVisibility(i2);
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Miura.this.H0();
            }
        }

        c() {
        }

        @Override // it.tervis.miura.model.Installation.UserSessionListener
        public void onSessionClosed() {
            j0.d.a("Session closed!");
            if (((it.tervis.miura.activity.b) Miura.this).f3762E) {
                Miura.this.f3666S = true;
            } else {
                ((it.tervis.miura.activity.a) Miura.this).f3754C.post(new b());
            }
        }

        @Override // it.tervis.miura.model.Installation.UserSessionListener
        public void onUserInfoDataChanged(h0.c cVar) {
            ((it.tervis.miura.activity.a) Miura.this).f3754C.post(new a(cVar));
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3686b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f3687c;

        d(boolean z2, String str, String str2) {
            this.f3685a = z2;
            this.f3686b = str;
            this.f3687c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3685a) {
                Miura.this.D();
            }
            Miura.this.C0(this.f3686b, this.f3687c, this.f3685a);
        }
    }

    class e extends E {
        e(x xVar) {
            super(xVar);
        }

        private Fragment q(int i2) {
            X.a aVar = new X.a();
            Bundle bundle = new Bundle();
            bundle.putInt("area", i2);
            aVar.t1(bundle);
            return aVar;
        }

        @Override // androidx.viewpager.widget.a
        public int c() {
            if (BootLock.isLocked() || Miura.this.z() == null || Miura.this.z().mNormalizedAreas == null) {
                return 0;
            }
            return Miura.this.z().mNormalizedAreas.size();
        }

        @Override // androidx.viewpager.widget.a
        public CharSequence e(int i2) {
            String name = Miura.this.z().mNormalizedAreas.get(i2).getName();
            if (name != null) {
                return name;
            }
            return "AREA " + (Miura.this.z().mNormalizedAreas.get(i2).getID() + 1);
        }

        @Override // androidx.viewpager.widget.a
        public Parcelable k() {
            return null;
        }

        @Override // androidx.fragment.app.E
        public Fragment p(int i2) {
            return q(i2);
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3691b;

        f(String str, String str2) {
            this.f3690a = str;
            this.f3691b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            W.d.Y1(this.f3690a, this.f3691b).X1(Miura.this.f0(), "");
        }
    }

    class g extends AbstractC0106b {
        g(Activity activity, DrawerLayout drawerLayout, int i2, int i3) {
            super(activity, drawerLayout, i2, i3);
        }

        @Override // androidx.appcompat.app.AbstractC0106b, androidx.drawerlayout.widget.DrawerLayout.d
        public void b(View view) {
            super.b(view);
            Miura.this.invalidateOptionsMenu();
        }

        @Override // androidx.appcompat.app.AbstractC0106b, androidx.drawerlayout.widget.DrawerLayout.d
        public void d(View view) {
            super.d(view);
            Miura.this.invalidateOptionsMenu();
        }
    }

    private void A1() {
        q0();
        this.f3657J = (ViewPager) findViewById(R.id.main_pager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1(String str, String str2, boolean z2) {
        this.f3754C.post(new d(z2, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G1() {
        e eVar = new e(f0());
        this.f3658K = eVar;
        this.f3657J.setAdapter(eVar);
    }

    private void n1() {
        InstallationManager.reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1(String str, String str2) {
        D();
        this.f3754C.post(new f(str, str2));
    }

    private void r1() {
    }

    private void s1() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.f3659L = drawerLayout;
        drawerLayout.setDrawerLockMode(1);
        this.f3662O = new k();
        f0().o().c(R.id.fragment_container, this.f3662O, "LOGIN").g();
        Toast.makeText(this, j0.j.d(this), 0).show();
        ((NotificationManager) getSystemService("notification")).cancel(12);
        if (j0.f.j()) {
            j0.f.t(false);
        }
        x1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1() {
        A1();
        y1();
        BootLock.init();
    }

    private void u1() {
        if (this.f3664Q != null) {
            f0().o().m(this.f3664Q).g();
            this.f3664Q = null;
        }
    }

    private void v1() {
        if (this.f3665R != null) {
            f0().o().m(this.f3665R).g();
            this.f3665R = null;
        }
    }

    private void w1() {
        if (this.f3663P != null) {
            f0().o().m(this.f3663P).g();
            this.f3663P = null;
        }
    }

    private void x1() {
    }

    private void y1() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.f3659L = drawerLayout;
        int i2 = R.string.app_name;
        g gVar = new g(this, drawerLayout, i2, i2);
        this.f3660M = gVar;
        gVar.j();
        this.f3659L.setDrawerListener(this.f3660M);
        q0().t(true);
        q0().w(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1() {
        z().setUserSessionListener(new c());
    }

    public void C1() {
        w1();
        v1();
        if (this.f3664Q == null) {
            this.f3664Q = new q();
            f0().o().c(R.id.fragment_container, this.f3664Q, "").g();
            this.f3667T = "TIMER";
        }
    }

    public void D1() {
        if (!z().canAccessLog()) {
            p("Utente non autorizzato");
            return;
        }
        u1();
        w1();
        if (this.f3665R == null) {
            this.f3665R = new j();
            f0().o().c(R.id.fragment_container, this.f3665R, "").g();
            this.f3667T = "STORICO";
        }
    }

    public void E1() {
        u1();
        v1();
        if (this.f3663P == null) {
            this.f3663P = new n();
            f0().o().c(R.id.fragment_container, this.f3663P, "").g();
            this.f3667T = "TELECOMANDI";
        }
    }

    public void F1() {
        w1();
        u1();
        v1();
        if (z().canUseSecuritySection()) {
            j0.d.a("USER authorized, must remove mask!");
            findViewById(R.id.mask).setVisibility(8);
        }
        this.f3667T = "SICUREZZA";
    }

    @Override // it.tervis.miura.activity.b
    protected void I0() {
        MiuraService miuraService = this.f3764G;
        if (miuraService == null || miuraService.z() != MiuraService.p.SESSION_CLOSED) {
            this.f3764G.t(this.f3670W);
        } else {
            H0();
        }
    }

    @Override // it.tervis.miura.activity.b, it.tervis.miura.a
    public void J() {
        j0.d.a("Forcing login again");
        if (this.f3662O == null) {
            this.f3662O = new k();
        }
        q0().A("Miura");
        f0().o().n(R.id.fragment_container, this.f3662O).g();
    }

    @Override // it.tervis.miura.activity.b
    protected void J0() {
    }

    @Override // it.tervis.miura.activity.b, it.tervis.miura.a
    public void e() {
        j0.f.a();
        this.f3661N = new X.e();
        G gO = f0().o();
        gO.o(R.id.fragment_container, this.f3661N, "CONNECT");
        if (this.f3669V == null) {
            l lVar = new l();
            this.f3669V = lVar;
            gO.c(R.id.layout_menu, lVar, "MenuFragment");
        }
        if (this.f3668U == null) {
            o oVar = new o();
            this.f3668U = oVar;
            gO.o(R.id.layout_standby, oVar, "StandbyInfoFragment");
        }
        gO.g();
        this.f3662O = null;
    }

    public void o1(boolean z2) {
        j0.d.a("closeConnection() on Miura");
        if (!this.f3765H || this.f3764G == null) {
            return;
        }
        j0.d.a("Francastase");
        try {
            this.f3659L.setDrawerLockMode(1);
            q0().t(false);
            q0().w(false);
            this.f3764G.u();
            this.f3657J.setAdapter(null);
            if (z2) {
                setTitle("Miura");
            } else {
                f0().o().o(R.id.fragment_container, this.f3661N, "CONNECT").g();
                z1();
                setTitle("I miei impianti");
                v1();
                u1();
                w1();
            }
            W.c.Z1();
        } catch (Exception e2) {
            j0.d.c(e2);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f3659L.C(3)) {
            this.f3659L.h();
            return;
        }
        X.e eVar = this.f3661N;
        if (eVar != null && eVar.e0()) {
            super.onBackPressed();
            return;
        }
        k kVar = this.f3662O;
        if (kVar != null && kVar.e0()) {
            super.onBackPressed();
            return;
        }
        n nVar = this.f3663P;
        if (nVar != null && nVar.e0()) {
            F1();
            return;
        }
        q qVar = this.f3664Q;
        if (qVar != null && qVar.e0()) {
            F1();
            return;
        }
        j jVar = this.f3665R;
        if (jVar != null && jVar.e0()) {
            F1();
        } else {
            try {
                W.c.a2().X1(f0(), "");
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.appcompat.app.AbstractActivityC0108d, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AbstractC0106b abstractC0106b = this.f3660M;
        if (abstractC0106b != null) {
            abstractC0106b.f(configuration);
        }
    }

    @Override // it.tervis.miura.activity.a, androidx.fragment.app.AbstractActivityC0171j, androidx.activity.ComponentActivity, androidx.core.app.g, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        startService(new Intent(this, (Class<?>) MiuraService.class));
        j0.f.r(getApplicationContext());
        n1();
        q0().r(new ColorDrawable(getResources().getColor(R.color.tervis_blues)));
        setContentView(R.layout.main);
        findViewById(R.id.mask).setOnClickListener(new b());
        getWindow().setLayout(-1, -1);
        r1();
        s1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater();
        return super.onCreateOptionsMenu(menu);
    }

    @Override // androidx.appcompat.app.AbstractActivityC0108d, androidx.fragment.app.AbstractActivityC0171j, android.app.Activity
    protected void onDestroy() {
        j0.d.a("Destroying Miura...");
        InstallationManager.reset();
        D();
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.f3659L.q(3) != 0) {
            j0.d.a("Menu locked!!! :-( ");
            return true;
        }
        j0.d.a("Unlocked!!! :-) " + this.f3659L.C(3));
        if (this.f3659L.C(3) && this.f3659L.F(3)) {
            this.f3659L.d(3);
            return true;
        }
        this.f3659L.K(3);
        return true;
    }

    @Override // androidx.fragment.app.AbstractActivityC0171j, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.appcompat.app.AbstractActivityC0108d, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        AbstractC0106b abstractC0106b = this.f3660M;
        if (abstractC0106b != null) {
            abstractC0106b.j();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (this.f3666S) {
            H0();
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0171j, android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            j0.d.a("Bound to service: " + this.f3765H);
            j0.d.a("Service: " + this.f3764G);
            j0.d.a("Service State: " + this.f3764G.z());
        } catch (Exception unused) {
        }
        if (this.f3765H) {
            return;
        }
        H0();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        try {
            W.c.Z1();
        } catch (Exception e2) {
            j0.d.c(e2);
        }
        super.onSaveInstanceState(bundle, persistableBundle);
    }

    @Override // it.tervis.miura.activity.b, androidx.appcompat.app.AbstractActivityC0108d, androidx.fragment.app.AbstractActivityC0171j, android.app.Activity
    protected void onStart() {
        j0.d.a("Starting Miura... " + hashCode());
        if (this.f3662O == null && !j0.f.o()) {
            J();
        }
        super.onStart();
    }

    @Override // it.tervis.miura.activity.b, androidx.appcompat.app.AbstractActivityC0108d, androidx.fragment.app.AbstractActivityC0171j, android.app.Activity
    protected void onStop() {
        j0.d.a("Stopping Miura...");
        MiuraService miuraService = this.f3764G;
        if (miuraService != null) {
            miuraService.Y(this.f3670W);
        }
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
    }

    public void p1() {
        this.f3659L.h();
    }
}
