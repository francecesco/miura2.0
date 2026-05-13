package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.b;
import androidx.core.view.InterfaceC0157v;
import androidx.core.view.InterfaceC0160y;
import androidx.lifecycle.AbstractC0183g;
import androidx.savedstate.a;
import b.InterfaceC0185b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import o.InterfaceC0232a;

/* JADX INFO: renamed from: androidx.fragment.app.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractActivityC0171j extends ComponentActivity implements b.c, b.d {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f2924w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f2925x;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final C0175n f2922u = C0175n.b(new a());

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final androidx.lifecycle.m f2923v = new androidx.lifecycle.m(this);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    boolean f2926y = true;

    /* JADX INFO: renamed from: androidx.fragment.app.j$a */
    class a extends p implements androidx.core.content.b, androidx.core.content.c, androidx.core.app.o, androidx.core.app.p, androidx.lifecycle.E, androidx.activity.o, androidx.activity.result.e, A.c, B, InterfaceC0157v {
        public a() {
            super(AbstractActivityC0171j.this);
        }

        @Override // androidx.core.app.o
        public void B(InterfaceC0232a interfaceC0232a) {
            AbstractActivityC0171j.this.B(interfaceC0232a);
        }

        @Override // androidx.lifecycle.l
        public AbstractC0183g G() {
            return AbstractActivityC0171j.this.f2923v;
        }

        @Override // androidx.core.app.p
        public void H(InterfaceC0232a interfaceC0232a) {
            AbstractActivityC0171j.this.H(interfaceC0232a);
        }

        @Override // androidx.fragment.app.B
        public void a(x xVar, Fragment fragment) {
            AbstractActivityC0171j.this.n0(fragment);
        }

        @Override // androidx.activity.o
        public OnBackPressedDispatcher c() {
            return AbstractActivityC0171j.this.c();
        }

        @Override // A.c
        public androidx.savedstate.a d() {
            return AbstractActivityC0171j.this.d();
        }

        @Override // androidx.fragment.app.AbstractC0173l
        public View e(int i2) {
            return AbstractActivityC0171j.this.findViewById(i2);
        }

        @Override // androidx.core.content.b
        public void f(InterfaceC0232a interfaceC0232a) {
            AbstractActivityC0171j.this.f(interfaceC0232a);
        }

        @Override // androidx.core.app.p
        public void g(InterfaceC0232a interfaceC0232a) {
            AbstractActivityC0171j.this.g(interfaceC0232a);
        }

        @Override // androidx.core.content.b
        public void h(InterfaceC0232a interfaceC0232a) {
            AbstractActivityC0171j.this.h(interfaceC0232a);
        }

        @Override // androidx.core.view.InterfaceC0157v
        public void i(InterfaceC0160y interfaceC0160y) {
            AbstractActivityC0171j.this.i(interfaceC0160y);
        }

        @Override // androidx.fragment.app.AbstractC0173l
        public boolean j() {
            Window window = AbstractActivityC0171j.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.core.view.InterfaceC0157v
        public void k(InterfaceC0160y interfaceC0160y) {
            AbstractActivityC0171j.this.k(interfaceC0160y);
        }

        @Override // androidx.core.app.o
        public void m(InterfaceC0232a interfaceC0232a) {
            AbstractActivityC0171j.this.m(interfaceC0232a);
        }

        @Override // androidx.activity.result.e
        public androidx.activity.result.d n() {
            return AbstractActivityC0171j.this.n();
        }

        @Override // androidx.fragment.app.p
        public void q(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            AbstractActivityC0171j.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.p
        public LayoutInflater s() {
            return AbstractActivityC0171j.this.getLayoutInflater().cloneInContext(AbstractActivityC0171j.this);
        }

        @Override // androidx.core.content.c
        public void t(InterfaceC0232a interfaceC0232a) {
            AbstractActivityC0171j.this.t(interfaceC0232a);
        }

        @Override // androidx.fragment.app.p
        public void v() {
            w();
        }

        public void w() {
            AbstractActivityC0171j.this.invalidateOptionsMenu();
        }

        @Override // androidx.lifecycle.E
        public androidx.lifecycle.D x() {
            return AbstractActivityC0171j.this.x();
        }

        @Override // androidx.core.content.c
        public void y(InterfaceC0232a interfaceC0232a) {
            AbstractActivityC0171j.this.y(interfaceC0232a);
        }

        @Override // androidx.fragment.app.p
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public AbstractActivityC0171j r() {
            return AbstractActivityC0171j.this;
        }
    }

    public AbstractActivityC0171j() {
        g0();
    }

    private void g0() {
        d().h("android:support:lifecycle", new a.c() { // from class: androidx.fragment.app.f
            @Override // androidx.savedstate.a.c
            public final Bundle a() {
                return this.f2918a.h0();
            }
        });
        f(new InterfaceC0232a() { // from class: androidx.fragment.app.g
            @Override // o.InterfaceC0232a
            public final void a(Object obj) {
                this.f2919a.i0((Configuration) obj);
            }
        });
        R(new InterfaceC0232a() { // from class: androidx.fragment.app.h
            @Override // o.InterfaceC0232a
            public final void a(Object obj) {
                this.f2920a.j0((Intent) obj);
            }
        });
        Q(new InterfaceC0185b() { // from class: androidx.fragment.app.i
            @Override // b.InterfaceC0185b
            public final void a(Context context) {
                this.f2921a.k0(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle h0() {
        l0();
        this.f2923v.h(AbstractC0183g.a.ON_STOP);
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(Configuration configuration) {
        this.f2922u.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(Intent intent) {
        this.f2922u.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(Context context) {
        this.f2922u.a(null);
    }

    private static boolean m0(x xVar, AbstractC0183g.b bVar) {
        boolean zM0 = false;
        for (Fragment fragment : xVar.t0()) {
            if (fragment != null) {
                if (fragment.y() != null) {
                    zM0 |= m0(fragment.n(), bVar);
                }
                K k2 = fragment.f2678T;
                if (k2 != null && k2.G().b().b(AbstractC0183g.b.STARTED)) {
                    fragment.f2678T.i(bVar);
                    zM0 = true;
                }
                if (fragment.f2677S.b().b(AbstractC0183g.b.STARTED)) {
                    fragment.f2677S.m(bVar);
                    zM0 = true;
                }
            }
        }
        return zM0;
    }

    @Override // androidx.core.app.b.d
    public final void b(int i2) {
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (K(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f2924w);
            printWriter.print(" mResumed=");
            printWriter.print(this.f2925x);
            printWriter.print(" mStopped=");
            printWriter.print(this.f2926y);
            if (getApplication() != null) {
                androidx.loader.app.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
            }
            this.f2922u.l().W(str, fileDescriptor, printWriter, strArr);
        }
    }

    final View e0(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f2922u.n(view, str, context, attributeSet);
    }

    public x f0() {
        return this.f2922u.l();
    }

    void l0() {
        while (m0(f0(), AbstractC0183g.b.CREATED)) {
        }
    }

    public void n0(Fragment fragment) {
    }

    protected void o0() {
        this.f2923v.h(AbstractC0183g.a.ON_RESUME);
        this.f2922u.h();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        this.f2922u.m();
        super.onActivityResult(i2, i3, intent);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.g, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2923v.h(AbstractC0183g.a.ON_CREATE);
        this.f2922u.e();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewE0 = e0(view, str, context, attributeSet);
        return viewE0 == null ? super.onCreateView(view, str, context, attributeSet) : viewE0;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f2922u.f();
        this.f2923v.h(AbstractC0183g.a.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 6) {
            return this.f2922u.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f2925x = false;
        this.f2922u.g();
        this.f2923v.h(AbstractC0183g.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        o0();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.f2922u.m();
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.f2922u.m();
        super.onResume();
        this.f2925x = true;
        this.f2922u.k();
    }

    @Override // android.app.Activity
    protected void onStart() {
        this.f2922u.m();
        super.onStart();
        this.f2926y = false;
        if (!this.f2924w) {
            this.f2924w = true;
            this.f2922u.c();
        }
        this.f2922u.k();
        this.f2923v.h(AbstractC0183g.a.ON_START);
        this.f2922u.i();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f2922u.m();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.f2926y = true;
        l0();
        this.f2922u.j();
        this.f2923v.h(AbstractC0183g.a.ON_STOP);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewE0 = e0(null, str, context, attributeSet);
        return viewE0 == null ? super.onCreateView(str, context, attributeSet) : viewE0;
    }
}
