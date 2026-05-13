package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import o.AbstractC0236e;

/* JADX INFO: renamed from: androidx.fragment.app.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0175n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f2940a;

    private C0175n(p pVar) {
        this.f2940a = pVar;
    }

    public static C0175n b(p pVar) {
        return new C0175n((p) AbstractC0236e.g(pVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        p pVar = this.f2940a;
        pVar.f2946e.m(pVar, pVar, fragment);
    }

    public void c() {
        this.f2940a.f2946e.x();
    }

    public boolean d(MenuItem menuItem) {
        return this.f2940a.f2946e.A(menuItem);
    }

    public void e() {
        this.f2940a.f2946e.B();
    }

    public void f() {
        this.f2940a.f2946e.D();
    }

    public void g() {
        this.f2940a.f2946e.M();
    }

    public void h() {
        this.f2940a.f2946e.Q();
    }

    public void i() {
        this.f2940a.f2946e.R();
    }

    public void j() {
        this.f2940a.f2946e.T();
    }

    public boolean k() {
        return this.f2940a.f2946e.a0(true);
    }

    public x l() {
        return this.f2940a.f2946e;
    }

    public void m() {
        this.f2940a.f2946e.W0();
    }

    public View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f2940a.f2946e.v0().onCreateView(view, str, context, attributeSet);
    }
}
