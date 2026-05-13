package T;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: renamed from: T.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0079b extends AbstractC0083f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C0095s f252c;

    public C0079b(C0085h c0085h, C0087j c0087j) {
        super(c0085h);
        K.e.f(c0087j);
        this.f252c = new C0095s(c0085h, c0087j);
    }

    @Override // T.AbstractC0083f
    protected final void E() {
        this.f252c.G();
    }

    final void H() {
        F.i.d();
        this.f252c.H();
    }

    public final void I() {
        this.f252c.I();
    }

    public final void K(L l2) {
        F();
        p().a(new RunnableC0081d(this, l2));
    }

    public final void L() {
        F();
        Context contextA = a();
        if (!e0.b(contextA) || !f0.i(contextA)) {
            K(null);
            return;
        }
        Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent.setComponent(new ComponentName(contextA, "com.google.android.gms.analytics.AnalyticsService"));
        contextA.startService(intent);
    }

    public final void M() {
        F();
        F.i.d();
        C0095s c0095s = this.f252c;
        F.i.d();
        c0095s.F();
        c0095s.y("Service disconnected");
    }

    final void N() {
        F.i.d();
        this.f252c.M();
    }
}
