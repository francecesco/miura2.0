package T;

import android.content.ComponentName;
import android.os.RemoteException;
import java.util.Collections;

/* JADX INFO: renamed from: T.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0088k extends AbstractC0083f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ServiceConnectionC0090m f301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private U f302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final H f303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final k0 f304f;

    protected C0088k(C0085h c0085h) {
        super(c0085h);
        this.f304f = new k0(c0085h.c());
        this.f301c = new ServiceConnectionC0090m(this);
        this.f303e = new C0089l(this, c0085h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(ComponentName componentName) {
        F.i.d();
        if (this.f302d != null) {
            this.f302d = null;
            c("Disconnected from device AnalyticsService", componentName);
            q().M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(U u2) {
        F.i.d();
        this.f302d = u2;
        R();
        q().H();
    }

    private final void R() {
        this.f304f.b();
        this.f303e.h(((Long) N.f187K.a()).longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S() {
        F.i.d();
        if (J()) {
            y("Inactivity, disconnecting from device AnalyticsService");
            I();
        }
    }

    public final boolean H() {
        F.i.d();
        F();
        if (this.f302d != null) {
            return true;
        }
        U uA = this.f301c.a();
        if (uA == null) {
            return false;
        }
        this.f302d = uA;
        R();
        return true;
    }

    public final void I() {
        F.i.d();
        F();
        try {
            N.a.b().c(a(), this.f301c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        if (this.f302d != null) {
            this.f302d = null;
            q().M();
        }
    }

    public final boolean J() {
        F.i.d();
        F();
        return this.f302d != null;
    }

    public final boolean Q(T t2) {
        K.e.f(t2);
        F.i.d();
        F();
        U u2 = this.f302d;
        if (u2 == null) {
            return false;
        }
        try {
            u2.b(t2.d(), t2.g(), t2.h() ? F.h() : F.i(), Collections.emptyList());
            R();
            return true;
        } catch (RemoteException unused) {
            y("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    @Override // T.AbstractC0083f
    protected final void E() {
    }
}
