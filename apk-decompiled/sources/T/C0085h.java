package T;

import android.content.Context;

/* JADX INFO: renamed from: T.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0085h {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static volatile C0085h f277p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final O.c f280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final F f281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final X f282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final F.i f283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final C0079b f284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final K f285h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final m0 f286i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final b0 f287j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final F.b f288k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final C0101y f289l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final C0078a f290m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final r f291n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final J f292o;

    private C0085h(C0087j c0087j) {
        Context contextA = c0087j.a();
        K.e.g(contextA, "Application context can't be null");
        Context contextB = c0087j.b();
        K.e.f(contextB);
        this.f278a = contextA;
        this.f279b = contextB;
        this.f280c = O.d.c();
        this.f281d = new F(this);
        X x2 = new X(this);
        x2.G();
        this.f282e = x2;
        X xD = d();
        String str = AbstractC0084g.f272a;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 134);
        sb.append("Google Analytics ");
        sb.append(str);
        sb.append(" is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
        xD.A(sb.toString());
        b0 b0Var = new b0(this);
        b0Var.G();
        this.f287j = b0Var;
        m0 m0Var = new m0(this);
        m0Var.G();
        this.f286i = m0Var;
        C0079b c0079b = new C0079b(this, c0087j);
        C0101y c0101y = new C0101y(this);
        C0078a c0078a = new C0078a(this);
        r rVar = new r(this);
        J j2 = new J(this);
        F.i iVarE = F.i.e(contextA);
        iVarE.b(new C0086i(this));
        this.f283f = iVarE;
        F.b bVar = new F.b(this);
        c0101y.G();
        this.f289l = c0101y;
        c0078a.G();
        this.f290m = c0078a;
        rVar.G();
        this.f291n = rVar;
        j2.G();
        this.f292o = j2;
        K k2 = new K(this);
        k2.G();
        this.f285h = k2;
        c0079b.G();
        this.f284g = c0079b;
        bVar.c();
        this.f288k = bVar;
        c0079b.I();
    }

    private static void b(AbstractC0083f abstractC0083f) {
        K.e.g(abstractC0083f, "Analytics service not created/initialized");
        K.e.b(abstractC0083f.D(), "Analytics service not initialized");
    }

    public static C0085h f(Context context) {
        K.e.f(context);
        if (f277p == null) {
            synchronized (C0085h.class) {
                try {
                    if (f277p == null) {
                        O.c cVarC = O.d.c();
                        long jB = cVarC.b();
                        C0085h c0085h = new C0085h(new C0087j(context));
                        f277p = c0085h;
                        F.b.d();
                        long jB2 = cVarC.b() - jB;
                        Long l2 = (Long) N.f193Q.a();
                        if (jB2 > l2.longValue()) {
                            c0085h.d().o("Slow initialization (ms)", Long.valueOf(jB2), l2);
                        }
                    }
                } finally {
                }
            }
        }
        return f277p;
    }

    public final Context a() {
        return this.f278a;
    }

    public final O.c c() {
        return this.f280c;
    }

    public final X d() {
        b(this.f282e);
        return this.f282e;
    }

    public final F e() {
        return this.f281d;
    }

    public final F.i g() {
        K.e.f(this.f283f);
        return this.f283f;
    }

    public final C0079b h() {
        b(this.f284g);
        return this.f284g;
    }

    public final K i() {
        b(this.f285h);
        return this.f285h;
    }

    public final m0 j() {
        b(this.f286i);
        return this.f286i;
    }

    public final b0 k() {
        b(this.f287j);
        return this.f287j;
    }

    public final Context l() {
        return this.f279b;
    }

    public final X m() {
        return this.f282e;
    }

    public final b0 n() {
        b0 b0Var = this.f287j;
        if (b0Var == null || !b0Var.D()) {
            return null;
        }
        return this.f287j;
    }
}
