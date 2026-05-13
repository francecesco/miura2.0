package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.A;
import androidx.lifecycle.AbstractC0183g;
import androidx.lifecycle.InterfaceC0182f;
import y.AbstractC0272a;
import y.C0275d;

/* JADX INFO: loaded from: classes.dex */
class K implements InterfaceC0182f, A.c, androidx.lifecycle.E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Fragment f2795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.lifecycle.D f2796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.lifecycle.m f2797c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private A.b f2798d = null;

    K(Fragment fragment, androidx.lifecycle.D d2) {
        this.f2795a = fragment;
        this.f2796b = d2;
    }

    @Override // androidx.lifecycle.l
    public AbstractC0183g G() {
        e();
        return this.f2797c;
    }

    @Override // androidx.lifecycle.InterfaceC0182f
    public AbstractC0272a a() {
        Application application;
        Context applicationContext = this.f2795a.n1().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        C0275d c0275d = new C0275d();
        if (application != null) {
            c0275d.b(A.a.f3030d, application);
        }
        c0275d.b(androidx.lifecycle.w.f3115a, this);
        c0275d.b(androidx.lifecycle.w.f3116b, this);
        if (this.f2795a.m() != null) {
            c0275d.b(androidx.lifecycle.w.f3117c, this.f2795a.m());
        }
        return c0275d;
    }

    void b(AbstractC0183g.a aVar) {
        this.f2797c.h(aVar);
    }

    @Override // A.c
    public androidx.savedstate.a d() {
        e();
        return this.f2798d.b();
    }

    void e() {
        if (this.f2797c == null) {
            this.f2797c = new androidx.lifecycle.m(this);
            A.b bVarA = A.b.a(this);
            this.f2798d = bVarA;
            bVarA.c();
            androidx.lifecycle.w.a(this);
        }
    }

    boolean f() {
        return this.f2797c != null;
    }

    void g(Bundle bundle) {
        this.f2798d.d(bundle);
    }

    void h(Bundle bundle) {
        this.f2798d.e(bundle);
    }

    void i(AbstractC0183g.b bVar) {
        this.f2797c.m(bVar);
    }

    @Override // androidx.lifecycle.E
    public androidx.lifecycle.D x() {
        e();
        return this.f2796b;
    }
}
