package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AbstractC0106b;
import androidx.appcompat.view.b;
import androidx.appcompat.widget.o0;
import androidx.core.app.t;
import androidx.fragment.app.AbstractActivityC0171j;
import androidx.savedstate.a;
import b.InterfaceC0185b;

/* JADX INFO: renamed from: androidx.appcompat.app.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractActivityC0108d extends AbstractActivityC0171j implements InterfaceC0109e, t.a, AbstractC0106b.c {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private Resources f1015A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private AbstractC0111g f1016z;

    /* JADX INFO: renamed from: androidx.appcompat.app.d$a */
    class a implements a.c {
        a() {
        }

        @Override // androidx.savedstate.a.c
        public Bundle a() {
            Bundle bundle = new Bundle();
            AbstractActivityC0108d.this.p0().C(bundle);
            return bundle;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.d$b */
    class b implements InterfaceC0185b {
        b() {
        }

        @Override // b.InterfaceC0185b
        public void a(Context context) {
            AbstractC0111g abstractC0111gP0 = AbstractActivityC0108d.this.p0();
            abstractC0111gP0.t();
            abstractC0111gP0.y(AbstractActivityC0108d.this.d().b("androidx:appcompat"));
        }
    }

    public AbstractActivityC0108d() {
        r0();
    }

    private void U() {
        androidx.lifecycle.F.a(getWindow().getDecorView(), this);
        androidx.lifecycle.G.a(getWindow().getDecorView(), this);
        A.d.a(getWindow().getDecorView(), this);
        androidx.activity.q.a(getWindow().getDecorView(), this);
    }

    private void r0() {
        d().h("androidx:appcompat", new a());
        Q(new b());
    }

    private boolean y0(KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    public boolean A0(Intent intent) {
        return androidx.core.app.i.f(this, intent);
    }

    @Override // androidx.appcompat.app.InterfaceC0109e
    public void C(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.appcompat.app.InterfaceC0109e
    public androidx.appcompat.view.b I(b.a aVar) {
        return null;
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        U();
        p0().e(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(p0().g(context));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        AbstractC0105a abstractC0105aQ0 = q0();
        if (getWindow().hasFeature(0)) {
            if (abstractC0105aQ0 == null || !abstractC0105aQ0.g()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.core.app.g, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        AbstractC0105a abstractC0105aQ0 = q0();
        if (keyCode == 82 && abstractC0105aQ0 != null && abstractC0105aQ0.p(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public View findViewById(int i2) {
        return p0().j(i2);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return p0().q();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f1015A == null && o0.c()) {
            this.f1015A = new o0(this, super.getResources());
        }
        Resources resources = this.f1015A;
        return resources == null ? super.getResources() : resources;
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        p0().u();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        p0().x(configuration);
        if (this.f1015A != null) {
            this.f1015A.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        w0();
    }

    @Override // androidx.fragment.app.AbstractActivityC0171j, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        p0().z();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (y0(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.AbstractActivityC0171j, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        AbstractC0105a abstractC0105aQ0 = q0();
        if (menuItem.getItemId() != 16908332 || abstractC0105aQ0 == null || (abstractC0105aQ0.j() & 4) == 0) {
            return false;
        }
        return x0();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        p0().A(bundle);
    }

    @Override // androidx.fragment.app.AbstractActivityC0171j, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        p0().B();
    }

    @Override // androidx.fragment.app.AbstractActivityC0171j, android.app.Activity
    protected void onStart() {
        super.onStart();
        p0().D();
    }

    @Override // androidx.fragment.app.AbstractActivityC0171j, android.app.Activity
    protected void onStop() {
        super.onStop();
        p0().E();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        p0().N(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        AbstractC0105a abstractC0105aQ0 = q0();
        if (getWindow().hasFeature(0)) {
            if (abstractC0105aQ0 == null || !abstractC0105aQ0.q()) {
                super.openOptionsMenu();
            }
        }
    }

    public AbstractC0111g p0() {
        if (this.f1016z == null) {
            this.f1016z = AbstractC0111g.h(this, this);
        }
        return this.f1016z;
    }

    public AbstractC0105a q0() {
        return p0().s();
    }

    @Override // androidx.core.app.t.a
    public Intent r() {
        return androidx.core.app.i.a(this);
    }

    public void s0(androidx.core.app.t tVar) {
        tVar.b(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i2) {
        U();
        p0().I(i2);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        super.setTheme(i2);
        p0().M(i2);
    }

    protected void t0(androidx.core.os.c cVar) {
    }

    @Override // androidx.appcompat.app.InterfaceC0109e
    public void u(androidx.appcompat.view.b bVar) {
    }

    protected void u0(int i2) {
    }

    public void v0(androidx.core.app.t tVar) {
    }

    @Override // androidx.appcompat.app.AbstractC0106b.c
    public AbstractC0106b.InterfaceC0023b w() {
        return p0().n();
    }

    public void w0() {
    }

    public boolean x0() {
        Intent intentR = r();
        if (intentR == null) {
            return false;
        }
        if (!A0(intentR)) {
            z0(intentR);
            return true;
        }
        androidx.core.app.t tVarD = androidx.core.app.t.d(this);
        s0(tVarD);
        v0(tVarD);
        tVarD.e();
        try {
            androidx.core.app.b.h(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    public void z0(Intent intent) {
        androidx.core.app.i.e(this, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        U();
        p0().J(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        U();
        p0().K(view, layoutParams);
    }
}
