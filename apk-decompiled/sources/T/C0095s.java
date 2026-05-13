package T;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: T.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0095s extends AbstractC0083f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C0093p f338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Z f339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Y f340f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final C0088k f341g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f342h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final H f343i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final H f344j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final k0 f345k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f346l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f347m;

    protected C0095s(C0085h c0085h, C0087j c0087j) {
        super(c0085h);
        K.e.f(c0087j);
        this.f342h = Long.MIN_VALUE;
        this.f340f = new Y(c0085h);
        this.f338d = new C0093p(c0085h);
        this.f339e = new Z(c0085h);
        this.f341g = new C0088k(c0085h);
        this.f345k = new k0(k());
        this.f343i = new C0096t(this, c0085h);
        this.f344j = new C0097u(this, c0085h);
    }

    private final long N() {
        F.i.d();
        F();
        try {
            return this.f338d.U();
        } catch (SQLiteException e2) {
            x("Failed to get min/max hit times from local store", e2);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P() {
        L(new C0099w(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
        try {
            this.f338d.T();
            T();
        } catch (SQLiteException e2) {
            v("Failed to delete stale hits", e2);
        }
        this.f344j.h(86400000L);
    }

    private final void R() {
        if (this.f347m || !F.b() || this.f341g.J()) {
            return;
        }
        if (this.f345k.c(((Long) N.f191O.a()).longValue())) {
            this.f345k.b();
            y("Connecting to service");
            if (this.f341g.H()) {
                y("Connected to service");
                this.f345k.a();
                H();
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final boolean S() {
        F.i.d();
        F();
        y("Dispatching a batch of local hits");
        boolean z2 = !this.f341g.J();
        boolean z3 = !this.f339e.R();
        if (z2 && z3) {
            y("No network or service available. Will retry later");
            return false;
        }
        long jMax = Math.max(F.f(), F.g());
        ArrayList arrayList = new ArrayList();
        long jMax2 = 0;
        while (true) {
            try {
                this.f338d.H();
                arrayList.clear();
                try {
                    List listS = this.f338d.S(jMax);
                    if (listS.isEmpty()) {
                        y("Store is empty, nothing to dispatch");
                        V();
                        try {
                            this.f338d.L();
                            this.f338d.I();
                            return false;
                        } catch (SQLiteException e2) {
                            x("Failed to commit local dispatch transaction", e2);
                            V();
                            return false;
                        }
                    }
                    c("Hits loaded from store. count", Integer.valueOf(listS.size()));
                    Iterator it2 = listS.iterator();
                    while (it2.hasNext()) {
                        if (((T) it2.next()).f() == jMax2) {
                            w("Database contains successfully uploaded hit", Long.valueOf(jMax2), Integer.valueOf(listS.size()));
                            V();
                            try {
                                this.f338d.L();
                                this.f338d.I();
                                return false;
                            } catch (SQLiteException e3) {
                                x("Failed to commit local dispatch transaction", e3);
                                V();
                                return false;
                            }
                        }
                    }
                    if (this.f341g.J()) {
                        y("Service connected, sending hits to the service");
                        while (!listS.isEmpty()) {
                            T t2 = (T) listS.get(0);
                            if (!this.f341g.Q(t2)) {
                                break;
                            }
                            jMax2 = Math.max(jMax2, t2.f());
                            listS.remove(t2);
                            g("Hit sent do device AnalyticsService for delivery", t2);
                            try {
                                this.f338d.X(t2.f());
                                arrayList.add(Long.valueOf(t2.f()));
                            } catch (SQLiteException e4) {
                                x("Failed to remove hit that was send for delivery", e4);
                                V();
                                try {
                                    this.f338d.L();
                                    this.f338d.I();
                                    return false;
                                } catch (SQLiteException e5) {
                                    x("Failed to commit local dispatch transaction", e5);
                                    V();
                                    return false;
                                }
                            }
                        }
                    }
                    if (this.f339e.R()) {
                        List listP = this.f339e.P(listS);
                        Iterator it3 = listP.iterator();
                        while (it3.hasNext()) {
                            jMax2 = Math.max(jMax2, ((Long) it3.next()).longValue());
                        }
                        try {
                            this.f338d.P(listP);
                            arrayList.addAll(listP);
                        } catch (SQLiteException e6) {
                            x("Failed to remove successfully uploaded hits", e6);
                            V();
                            try {
                                this.f338d.L();
                                this.f338d.I();
                                return false;
                            } catch (SQLiteException e7) {
                                x("Failed to commit local dispatch transaction", e7);
                                V();
                                return false;
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        try {
                            this.f338d.L();
                            this.f338d.I();
                            return false;
                        } catch (SQLiteException e8) {
                            x("Failed to commit local dispatch transaction", e8);
                            V();
                            return false;
                        }
                    }
                    try {
                        this.f338d.L();
                        this.f338d.I();
                    } catch (SQLiteException e9) {
                        x("Failed to commit local dispatch transaction", e9);
                        V();
                        return false;
                    }
                } catch (SQLiteException e10) {
                    v("Failed to read hits from persisted store", e10);
                    V();
                    try {
                        this.f338d.L();
                        this.f338d.I();
                        return false;
                    } catch (SQLiteException e11) {
                        x("Failed to commit local dispatch transaction", e11);
                        V();
                        return false;
                    }
                }
            } catch (Throwable th) {
                this.f338d.L();
                this.f338d.I();
                throw th;
            }
            try {
                this.f338d.L();
                this.f338d.I();
                throw th;
            } catch (SQLiteException e12) {
                x("Failed to commit local dispatch transaction", e12);
                V();
                return false;
            }
        }
    }

    private final void U() {
        K kR = r();
        if (kR.K() && !kR.J()) {
            long jN = N();
            if (jN == 0 || Math.abs(k().a() - jN) > ((Long) N.f208n.a()).longValue()) {
                return;
            }
            c("Dispatch alarm scheduled (ms)", Long.valueOf(F.e()));
            kR.L();
        }
    }

    private final void V() {
        if (this.f343i.g()) {
            y("All hits dispatched or no network/service. Going to power save mode");
        }
        this.f343i.a();
        K kR = r();
        if (kR.J()) {
            kR.H();
        }
    }

    private final long W() {
        long j2 = this.f342h;
        if (j2 != Long.MIN_VALUE) {
            return j2;
        }
        long jLongValue = ((Long) N.f203i.a()).longValue();
        m0 m0VarS = s();
        m0VarS.F();
        if (!m0VarS.f315f) {
            return jLongValue;
        }
        m0 m0VarS2 = s();
        m0VarS2.F();
        return ((long) m0VarS2.f316g) * 1000;
    }

    private final void X() {
        F();
        F.i.d();
        this.f347m = true;
        this.f341g.I();
        T();
    }

    private final boolean Y(String str) {
        return P.b.a(a()).a(str) == 0;
    }

    @Override // T.AbstractC0083f
    protected final void E() {
        this.f338d.G();
        this.f339e.G();
        this.f341g.G();
    }

    protected final void H() {
        F.i.d();
        F.i.d();
        F();
        if (!F.b()) {
            B("Service client disabled. Can't dispatch local hits to device AnalyticsService");
        }
        if (!this.f341g.J()) {
            y("Service not connected");
            return;
        }
        if (this.f338d.K()) {
            return;
        }
        y("Dispatching local hits to device AnalyticsService");
        while (true) {
            try {
                List listS = this.f338d.S(F.f());
                if (listS.isEmpty()) {
                    T();
                    return;
                }
                while (!listS.isEmpty()) {
                    T t2 = (T) listS.get(0);
                    if (!this.f341g.Q(t2)) {
                        T();
                        return;
                    }
                    listS.remove(t2);
                    try {
                        this.f338d.X(t2.f());
                    } catch (SQLiteException e2) {
                        x("Failed to remove hit that was send for delivery", e2);
                        V();
                        return;
                    }
                }
            } catch (SQLiteException e3) {
                x("Failed to read hits from store", e3);
                V();
                return;
            }
        }
    }

    final void I() {
        F();
        K.e.i(!this.f337c, "Analytics backend already started");
        this.f337c = true;
        p().a(new RunnableC0098v(this));
    }

    public final void L(L l2) {
        long j2 = this.f346l;
        F.i.d();
        F();
        long J2 = t().J();
        g("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(J2 != 0 ? Math.abs(k().a() - J2) : -1L));
        R();
        try {
            S();
            t().K();
            T();
            if (l2 != null) {
                l2.a(null);
            }
            if (this.f346l != j2) {
                this.f340f.e();
            }
        } catch (Exception e2) {
            x("Local dispatch failed", e2);
            t().K();
            T();
            if (l2 != null) {
                l2.a(e2);
            }
        }
    }

    final void M() {
        F.i.d();
        this.f346l = k().a();
    }

    protected final void O() {
        F();
        F.i.d();
        Context contextA = j().a();
        if (!e0.b(contextA)) {
            B("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!f0.i(contextA)) {
            C("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!F.a.a(contextA)) {
            B("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        t().I();
        if (!Y("android.permission.ACCESS_NETWORK_STATE")) {
            C("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            X();
        }
        if (!Y("android.permission.INTERNET")) {
            C("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            X();
        }
        if (f0.i(a())) {
            y("AnalyticsService registered in the app manifest and enabled");
        } else {
            B("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.f347m && !this.f338d.K()) {
            R();
        }
        T();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T() {
        /*
            r8 = this;
            F.i.d()
            r8.F()
            boolean r0 = r8.f347m
            if (r0 != 0) goto La2
            long r0 = r8.W()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto La2
            T.p r0 = r8.f338d
            boolean r0 = r0.K()
            if (r0 == 0) goto L25
            T.Y r0 = r8.f340f
            r0.b()
            r8.V()
            return
        L25:
            T.O r0 = T.N.f186J
            java.lang.Object r0 = r0.a()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L3f
            T.Y r0 = r8.f340f
            r0.c()
            T.Y r0 = r8.f340f
            boolean r0 = r0.a()
            goto L40
        L3f:
            r0 = 1
        L40:
            if (r0 == 0) goto L9b
            r8.U()
            long r0 = r8.W()
            T.b0 r4 = r8.t()
            long r4 = r4.J()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L69
            O.c r6 = r8.k()
            long r6 = r6.a()
            long r6 = r6 - r4
            long r4 = java.lang.Math.abs(r6)
            long r4 = r0 - r4
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 <= 0) goto L69
            goto L71
        L69:
            long r2 = T.F.d()
            long r4 = java.lang.Math.min(r2, r0)
        L71:
            java.lang.Long r0 = java.lang.Long.valueOf(r4)
            java.lang.String r1 = "Dispatch scheduled (ms)"
            r8.c(r1, r0)
            T.H r0 = r8.f343i
            boolean r0 = r0.g()
            if (r0 == 0) goto L95
            T.H r0 = r8.f343i
            long r0 = r0.f()
            long r4 = r4 + r0
            r0 = 1
            long r0 = java.lang.Math.max(r0, r4)
            T.H r2 = r8.f343i
            r2.i(r0)
            return
        L95:
            T.H r0 = r8.f343i
            r0.h(r4)
            return
        L9b:
            r8.V()
            r8.U()
            return
        La2:
            T.Y r0 = r8.f340f
            r0.b()
            r8.V()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: T.C0095s.T():void");
    }
}
