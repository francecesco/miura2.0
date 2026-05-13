package it.tervis.miura;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import androidx.core.app.k;
import it.tervis.miura.model.Area;
import it.tervis.miura.model.BootLock;
import it.tervis.miura.model.Configuration;
import it.tervis.miura.model.Group;
import it.tervis.miura.model.Installation;
import it.tervis.miura.model.InstallationManager;
import it.tervis.miura.model.RemoteController;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import z.C0277a;

/* JADX INFO: loaded from: classes.dex */
public class MiuraService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m f3694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private l f3695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Y.e f3696c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3698e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f3700g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Configuration f3703j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Installation f3704k;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList f3697d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private p f3699f = p.STARTED;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f3701h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f3702i = 0;

    class a extends Y.f {
        a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // Y.f
        public void d() {
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(d0.f fVar) {
            if (fVar.s()) {
                j0.d.a("# Telecomandi caricati!");
                MiuraService.this.Q();
                return true;
            }
            j0.d.a("Sending a new request for remote controllers");
            MiuraService.this.b0(new d0.e(fVar.q() + 6), this);
            return true;
        }
    }

    class b extends Y.f {
        b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // Y.f
        public void d() {
            MiuraService.this.A(n.a.GENERIC);
            j0.d.a("Timeout!");
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(h0.g gVar) {
            return true;
        }
    }

    class c extends Thread {
        c() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                j0.d.a("texts.cache deleted: " + new File(MiuraService.this.getFilesDir(), "texts.cache").delete());
            } catch (Exception e2) {
                j0.d.c(e2);
            }
        }
    }

    static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3708a;

        static {
            int[] iArr = new int[o.values().length];
            f3708a = iArr;
            try {
                iArr[o.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3708a[o.STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3708a[o.SESSION_CLOSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    class e extends Y.f {
        e(int i2, int i3) {
            super(i2, i3);
        }

        @Override // Y.f
        public void d() {
            MiuraService.this.A(n.a.LOGIN);
            j0.d.a("- Querying user: timeout");
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(h0.c cVar) {
            j0.d.a("- Querying user: " + cVar);
            int iQ = cVar.q();
            if (iQ != 0) {
                switch (iQ) {
                    case 250:
                    case 251:
                    case 252:
                    case 253:
                    case 254:
                    case 255:
                        break;
                    default:
                        MiuraService.this.v();
                        break;
                }
                return true;
            }
            MiuraService.this.E(cVar.q());
            return true;
        }
    }

    class f extends Y.f {
        f(int i2, int i3) {
            super(i2, i3);
        }

        @Override // Y.f
        public void d() {
            MiuraService.this.A(n.a.LOGIN);
            j0.d.a("Confirming user: timeout");
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(h0.e eVar) {
            j0.d.g("User confirmed");
            MiuraService.this.D();
            MiuraService.this.Z();
            MiuraService.this.M();
            return true;
        }
    }

    class g extends Y.f {
        g(int i2, int i3) {
            super(i2, i3);
        }

        @Override // Y.f
        public void d() {
            MiuraService.this.A(n.a.CONFIG);
            j0.d.a("Timeout!");
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(b0.d dVar) {
            if (dVar.q() != 15) {
                return false;
            }
            j0.d.g("Configuration loaded");
            MiuraService.this.U();
            return true;
        }
    }

    class h extends Y.f {
        h(int i2, int i3) {
            super(i2, i3);
        }

        @Override // Y.f
        public void d() {
            MiuraService.this.A(n.a.ACTIVATION_STATUS);
            j0.d.a("timeout for GroupsActivationStatusMessageRequest");
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(Z.j jVar) {
            j0.d.a("*********************** STATO GRUPPI AGGIORNATO!");
            j0.d.g("GroupsActivationStatus loaded");
            MiuraService.this.V();
            return true;
        }
    }

    class i extends Y.f {
        i(int i2, int i3) {
            super(i2, i3);
        }

        @Override // Y.f
        public void d() {
            MiuraService.this.A(n.a.ZONES);
            j0.d.a("Timeout on loadBlockZoneInfoForCurrentUser!");
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(i0.d dVar) {
            j0.d.a("Offset: " + dVar.q() + " ms]");
            j0.d.a("Stato delle zone caricato correttamente");
            j0.d.a("Carichiamo i telecomandi (1.6.0)");
            MiuraService.this.O();
            j0.d.g("Zone Info loaded");
            return true;
        }
    }

    class j extends Thread {
        j() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                j0.i.b(MiuraService.this.f3703j.getTextCacheDump());
            } catch (Exception e2) {
                j0.d.c(e2);
            }
            MiuraService.this.P();
        }
    }

    class k extends Y.f {
        k(int i2, int i3) {
            super(i2, i3);
        }

        @Override // Y.f
        public void d() {
            MiuraService.this.A(n.a.TEXTS);
            j0.d.a("Timeout!");
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(h0.g gVar) {
            try {
                j0.d.a("Writing texts on cache");
                MiuraService.this.f3703j.setTextCacheDump(j0.i.n());
                j0.f.p();
            } catch (Exception e2) {
                j0.d.c(e2);
            }
            j0.d.g("Texts loaded");
            MiuraService.this.H();
            return true;
        }
    }

    private final class l extends Y.a {
        private l() {
        }

        @Override // Y.a
        public void a() {
            for (n nVar : MiuraService.this.f3697d) {
                if (nVar != null) {
                    nVar.a();
                }
            }
        }

        @Override // Y.a
        public void b() {
            MiuraService.this.B();
        }

        @Override // Y.a
        public void c(Y.b bVar) {
            MiuraService.this.f3704k.handleMessage(bVar);
            if ((bVar instanceof h0.e) && ((h0.e) bVar).q() == 255) {
                MiuraService.this.G();
            }
            for (n nVar : MiuraService.this.f3697d) {
                if (nVar != null) {
                    nVar.c(bVar);
                }
            }
        }

        @Override // Y.a
        public void d() {
            MiuraService.this.f3699f = p.CONNECTED;
            j0.d.g("notifyOpen");
            MiuraService.this.S();
            try {
                for (n nVar : MiuraService.this.f3697d) {
                    if (nVar != null) {
                        nVar.d();
                    }
                }
            } catch (Exception unused) {
            }
        }

        @Override // Y.a
        public void e() {
            j0.d.f("notifyOpening");
            MiuraService.this.f3699f = p.INITIALIZING;
            for (n nVar : MiuraService.this.f3697d) {
                if (nVar != null) {
                    nVar.e();
                }
            }
        }

        /* synthetic */ l(MiuraService miuraService, e eVar) {
            this();
        }
    }

    public class m extends Binder {
        public m() {
        }

        public MiuraService a() {
            return MiuraService.this;
        }
    }

    private enum o {
        START,
        STOP,
        SESSION_CLOSED
    }

    public enum p {
        STARTED,
        CONNECTING,
        CONNECTED,
        LOGGED,
        INITIALIZING,
        TEXTS_LOADED,
        SESSION_CLOSED
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(n.a aVar) {
        this.f3699f = p.SESSION_CLOSED;
        if (this.f3698e) {
            c0(o.SESSION_CLOSED);
            return;
        }
        for (n nVar : this.f3697d) {
            if (nVar != null) {
                try {
                    nVar.f(aVar);
                } catch (Exception e2) {
                    j0.d.c(e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        this.f3699f = p.SESSION_CLOSED;
        if (this.f3698e) {
            c0(o.SESSION_CLOSED);
            return;
        }
        for (n nVar : this.f3697d) {
            if (nVar != null) {
                try {
                    nVar.b();
                } catch (Exception e2) {
                    j0.d.c(e2);
                }
            }
        }
    }

    private void C() {
        for (n nVar : this.f3697d) {
            if (nVar != null) {
                try {
                    nVar.g();
                } catch (Exception e2) {
                    j0.d.c(e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        this.f3699f = p.LOGGED;
        for (n nVar : this.f3697d) {
            if (nVar != null) {
                try {
                    nVar.i();
                } catch (Exception e2) {
                    j0.d.c(e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i2) {
        for (n nVar : this.f3697d) {
            if (nVar != null) {
                try {
                    nVar.h(i2);
                } catch (Exception e2) {
                    j0.d.c(e2);
                }
            }
        }
    }

    private void F() {
        for (n nVar : this.f3697d) {
            if (nVar != null) {
                try {
                    nVar.j();
                } catch (Exception e2) {
                    j0.d.c(e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        this.f3699f = p.SESSION_CLOSED;
        this.f3696c.w();
        if (this.f3698e) {
            c0(o.SESSION_CLOSED);
        } else {
            for (n nVar : this.f3697d) {
                if (nVar != null) {
                    try {
                        nVar.k();
                    } catch (Exception e2) {
                        j0.d.c(e2);
                    }
                }
            }
        }
        C0277a.b(this).d(new Intent("SESSION_CLOSED"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.f3702i = System.currentTimeMillis() - this.f3701h;
        j0.f.u(true);
        this.f3699f = p.TEXTS_LOADED;
        try {
            for (n nVar : this.f3697d) {
                if (nVar != null) {
                    try {
                        nVar.l();
                    } catch (Exception e2) {
                        j0.d.c(e2);
                    }
                }
            }
        } catch (Exception e3) {
            j0.d.c(e3);
        }
    }

    private void I() {
        C0277a.b(this).d(new Intent("SESSION_CLOSED"));
        stopSelf();
    }

    private void J() {
        this.f3696c = new Y.e();
        this.f3695b = new l(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        X();
    }

    private void N() {
        j0.d.f("Loading GroupsActivationStatus");
        this.f3696c.D(new Z.i(), new h(6, 130));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        j0.d.a("# Caricamento telecomandi");
        a0(new d0.c());
        b0(new d0.e(), new a(8, 134));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        j0.d.f("Loading texts");
        HashSet hashSet = new HashSet();
        boolean z2 = false;
        for (int i2 = 0; i2 < this.f3704k.mAreas.size(); i2++) {
            Area area = this.f3704k.mAreas.get(i2);
            if (area != null && area.hasActiveGroups()) {
                if (j0.i.c(i2) == null) {
                    j0.d.a("################ querying name of area " + i2);
                    this.f3696c.C(new f0.b(1, i2));
                    z2 = true;
                } else {
                    this.f3704k.mAreas.get(i2).setName(j0.i.c(area.getID()));
                }
                for (int i3 = 0; i3 < area.mNormalizedGroups.size(); i3++) {
                    Group group = area.mNormalizedGroups.get(i3);
                    if (j0.i.d(i3) == null) {
                        this.f3696c.C(new f0.b(2, group.getID()));
                        z2 = true;
                    } else {
                        group.setName(j0.i.d(group.getID()));
                    }
                    hashSet.addAll(group.getZonesList());
                }
            }
        }
        j0.d.a("Found " + hashSet.size() + " zones in all groups");
        if (z2) {
            W();
            z2 = false;
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            int iIntValue = ((Integer) it2.next()).intValue();
            if (j0.i.g(iIntValue) == null) {
                j0.d.a("Requesting name for zone " + iIntValue);
                this.f3696c.C(new f0.b(3, iIntValue));
                z2 = true;
            } else {
                this.f3704k.mZones.get(iIntValue).setName(j0.i.g(iIntValue));
            }
        }
        for (RemoteController remoteController : this.f3704k.getRemoteControllers()) {
            if (j0.i.e(remoteController.getID()) == null) {
                j0.d.a("Requesting name for remote controller " + remoteController.getID());
                this.f3696c.C(new f0.b(4, remoteController.getID()));
                z2 = true;
            } else {
                remoteController.setName(j0.i.e(remoteController.getID()));
            }
        }
        for (int i4 = 0; i4 < 8; i4++) {
            if (j0.i.f(i4) == null) {
                j0.d.a("Requesting name for timer " + i4);
                this.f3696c.C(new f0.b(8, i4));
                z2 = true;
            }
        }
        if (!z2) {
            j0.d.g("Texts loaded");
            H();
        } else {
            this.f3696c.D(new h0.f(), new k(1, 130));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        new j().start();
    }

    private void R() {
        int normalizedZonesCount = InstallationManager.getInstance().getCurrentInstallation().getNormalizedZonesCount();
        int i2 = normalizedZonesCount / 7;
        if (normalizedZonesCount % 7 != 0) {
            i2++;
        }
        j0.d.a("There are " + normalizedZonesCount + " zones.");
        j0.d.a("There are " + i2 + " blocks.");
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i3 >= i4) {
                b0(new i0.c(i4 * 7), new i(7, 129));
                return;
            } else {
                this.f3696c.C(new i0.c(i3 * 7));
                i3++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        j0.d.f("Querying user...");
        F();
        this.f3696c.B(new h0.b(this.f3703j.getPin().getBytes()), new e(1, 128));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        this.f3704k.normalize();
        N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        BootLock.setUnlocked();
        R();
    }

    private void W() {
        this.f3696c.D(new h0.f(), new b(1, 130));
    }

    private void X() {
        j0.d.f("Loading configuration");
        C();
        for (int i2 = 0; i2 < 15; i2++) {
            this.f3696c.C(new b0.c(i2, 255));
        }
        this.f3696c.D(new b0.c(15, 255), new g(10, 129));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        j0.f.s(System.currentTimeMillis());
    }

    private void c0(o oVar) {
        String str;
        k.d dVar = new k.d(this);
        dVar.m(R.drawable.ic_notify);
        dVar.i("Miura").e(true);
        int i2 = d.f3708a[oVar.ordinal()];
        if (i2 == 1) {
            str = "Service started";
        } else {
            if (i2 != 2) {
                if (i2 == 3) {
                    str = "Sessione scaduta";
                }
                dVar.g(PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) Miura.class), 134217728));
                ((NotificationManager) getSystemService("notification")).notify(12, dVar.b());
            }
            str = "Service stopped";
        }
        dVar.h(str);
        dVar.g(PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) Miura.class), 134217728));
        ((NotificationManager) getSystemService("notification")).notify(12, dVar.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        j0.d.a("Confirming user...");
        this.f3696c.B(new h0.a(), new f(1, 3));
    }

    public boolean K() {
        p pVar = this.f3699f;
        return pVar == p.CONNECTING || pVar == p.CONNECTED || pVar == p.INITIALIZING;
    }

    public void L() {
        if (this.f3699f != p.TEXTS_LOADED || System.currentTimeMillis() <= this.f3700g + 20000) {
            return;
        }
        a0(new h0.f());
        j0.d.a("Staying alive! ##################################");
    }

    public void T(Configuration configuration) {
        w();
        this.f3701h = System.currentTimeMillis();
        this.f3703j = configuration;
        this.f3704k = new Installation();
        this.f3696c.E(configuration.getHost(), configuration.getPort());
        this.f3696c.v(this.f3695b);
        this.f3696c.z();
        this.f3699f = p.CONNECTING;
    }

    public void Y(n nVar) {
        this.f3697d.remove(nVar);
    }

    public void a0(Y.b bVar) {
        this.f3700g = System.currentTimeMillis();
        Y.e eVar = this.f3696c;
        if (eVar != null) {
            try {
                eVar.C(bVar);
            } catch (Exception e2) {
                j0.d.c(e2);
            }
        }
    }

    public void b0(Y.b bVar, Y.f fVar) {
        this.f3700g = System.currentTimeMillis();
        Y.e eVar = this.f3696c;
        if (eVar != null) {
            eVar.D(bVar, fVar);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.f3698e = false;
        return this.f3694a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (this.f3694a == null) {
            this.f3694a = new m();
        }
        J();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f3694a = null;
        try {
            this.f3696c.w();
            this.f3696c = null;
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        this.f3698e = false;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        j0.d.b("service", "started");
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        this.f3698e = true;
        if (K()) {
            I();
        }
        return true;
    }

    public void t(n nVar) {
        this.f3697d.add(nVar);
    }

    public void u() {
        this.f3696c.A(this.f3695b);
        this.f3696c.w();
        this.f3699f = p.STARTED;
        this.f3703j = null;
        this.f3704k = null;
        InstallationManager.reset();
    }

    public void w() {
        new c().start();
        j0.i.a();
    }

    public Configuration x() {
        return this.f3703j;
    }

    public Installation y() {
        return this.f3704k;
    }

    public p z() {
        return this.f3699f;
    }

    public static abstract class n {

        public enum a {
            LOGIN,
            CONFIG,
            ACTIVATION_STATUS,
            ZONES,
            TEXTS,
            GENERIC
        }

        public void a() {
        }

        public void b() {
        }

        public void d() {
        }

        public void e() {
        }

        public void f(a aVar) {
        }

        public void g() {
        }

        public void h(int i2) {
        }

        public void i() {
        }

        public void j() {
        }

        public void k() {
        }

        public void l() {
        }

        public void c(Y.b bVar) {
        }
    }
}
