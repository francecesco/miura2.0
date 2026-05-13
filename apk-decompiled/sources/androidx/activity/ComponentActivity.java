package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.core.view.C0158w;
import androidx.core.view.InterfaceC0157v;
import androidx.core.view.InterfaceC0160y;
import androidx.lifecycle.A;
import androidx.lifecycle.AbstractC0183g;
import androidx.lifecycle.D;
import androidx.lifecycle.E;
import androidx.lifecycle.F;
import androidx.lifecycle.G;
import androidx.lifecycle.InterfaceC0182f;
import androidx.lifecycle.u;
import androidx.lifecycle.w;
import androidx.savedstate.a;
import b.C0184a;
import b.InterfaceC0185b;
import c.AbstractC0186a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import o.InterfaceC0232a;
import y.AbstractC0272a;
import y.C0275d;

/* JADX INFO: loaded from: classes.dex */
public abstract class ComponentActivity extends androidx.core.app.g implements androidx.lifecycle.l, E, InterfaceC0182f, A.c, o, androidx.activity.result.e, androidx.core.content.b, androidx.core.content.c, androidx.core.app.o, androidx.core.app.p, InterfaceC0157v, l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final C0184a f718c = new C0184a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C0158w f719d = new C0158w(new Runnable() { // from class: androidx.activity.b
        @Override // java.lang.Runnable
        public final void run() {
            this.f773a.V();
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final androidx.lifecycle.m f720e = new androidx.lifecycle.m(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final A.b f721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private D f722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final OnBackPressedDispatcher f723h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final f f724i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final k f725j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f726k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicInteger f727l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final androidx.activity.result.d f728m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final CopyOnWriteArrayList f729n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final CopyOnWriteArrayList f730o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final CopyOnWriteArrayList f731p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final CopyOnWriteArrayList f732q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final CopyOnWriteArrayList f733r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f734s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f735t;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e2) {
                if (!TextUtils.equals(e2.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e2;
                }
            }
        }
    }

    class b extends androidx.activity.result.d {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f741a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AbstractC0186a.C0057a f742b;

            a(int i2, AbstractC0186a.C0057a c0057a) {
                this.f741a = i2;
                this.f742b = c0057a;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.c(this.f741a, this.f742b.a());
            }
        }

        /* JADX INFO: renamed from: androidx.activity.ComponentActivity$b$b, reason: collision with other inner class name */
        class RunnableC0020b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f744a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ IntentSender.SendIntentException f745b;

            RunnableC0020b(int i2, IntentSender.SendIntentException sendIntentException) {
                this.f744a = i2;
                this.f745b = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b(this.f744a, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f745b));
            }
        }

        b() {
        }

        @Override // androidx.activity.result.d
        public void f(int i2, AbstractC0186a abstractC0186a, Object obj, androidx.core.app.c cVar) {
            Bundle bundle;
            ComponentActivity componentActivity = ComponentActivity.this;
            AbstractC0186a.C0057a c0057aB = abstractC0186a.b(componentActivity, obj);
            if (c0057aB != null) {
                new Handler(Looper.getMainLooper()).post(new a(i2, c0057aB));
                return;
            }
            Intent intentA = abstractC0186a.a(componentActivity, obj);
            if (intentA.getExtras() != null && intentA.getExtras().getClassLoader() == null) {
                intentA.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                Bundle bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                bundle = bundleExtra;
            } else {
                bundle = null;
            }
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentA.getAction())) {
                String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                androidx.core.app.b.k(componentActivity, stringArrayExtra, i2);
                return;
            }
            if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
                androidx.core.app.b.l(componentActivity, intentA, i2, bundle);
                return;
            }
            androidx.activity.result.f fVar = (androidx.activity.result.f) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                androidx.core.app.b.m(componentActivity, fVar.d(), i2, fVar.a(), fVar.b(), fVar.c(), 0, bundle);
            } catch (IntentSender.SendIntentException e2) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0020b(i2, e2));
            }
        }
    }

    static class c {
        static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    static class d {
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        D f748b;

        e() {
        }
    }

    private interface f extends Executor {
        void a(View view);
    }

    class g implements f, ViewTreeObserver.OnDrawListener, Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Runnable f750b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f749a = SystemClock.uptimeMillis() + 10000;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f751c = false;

        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            Runnable runnable = this.f750b;
            if (runnable != null) {
                runnable.run();
                this.f750b = null;
            }
        }

        @Override // androidx.activity.ComponentActivity.f
        public void a(View view) {
            if (this.f751c) {
                return;
            }
            this.f751c = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f750b = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            if (!this.f751c) {
                decorView.postOnAnimation(new Runnable() { // from class: androidx.activity.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f777a.d();
                    }
                });
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f750b;
            if (runnable != null) {
                runnable.run();
                this.f750b = null;
                if (!ComponentActivity.this.f725j.c()) {
                    return;
                }
            } else if (SystemClock.uptimeMillis() <= this.f749a) {
                return;
            }
            this.f751c = false;
            ComponentActivity.this.getWindow().getDecorView().post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public ComponentActivity() {
        A.b bVarA = A.b.a(this);
        this.f721f = bVarA;
        this.f723h = new OnBackPressedDispatcher(new a());
        f fVarS = S();
        this.f724i = fVarS;
        this.f725j = new k(fVarS, new p0.a() { // from class: androidx.activity.c
            @Override // p0.a
            public final Object a() {
                return this.f774a.W();
            }
        });
        this.f727l = new AtomicInteger();
        this.f728m = new b();
        this.f729n = new CopyOnWriteArrayList();
        this.f730o = new CopyOnWriteArrayList();
        this.f731p = new CopyOnWriteArrayList();
        this.f732q = new CopyOnWriteArrayList();
        this.f733r = new CopyOnWriteArrayList();
        this.f734s = false;
        this.f735t = false;
        if (G() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i2 = Build.VERSION.SDK_INT;
        G().a(new androidx.lifecycle.j() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.j
            public void d(androidx.lifecycle.l lVar, AbstractC0183g.a aVar) {
                if (aVar == AbstractC0183g.a.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                    if (viewPeekDecorView != null) {
                        c.a(viewPeekDecorView);
                    }
                }
            }
        });
        G().a(new androidx.lifecycle.j() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.j
            public void d(androidx.lifecycle.l lVar, AbstractC0183g.a aVar) {
                if (aVar == AbstractC0183g.a.ON_DESTROY) {
                    ComponentActivity.this.f718c.b();
                    if (ComponentActivity.this.isChangingConfigurations()) {
                        return;
                    }
                    ComponentActivity.this.x().a();
                }
            }
        });
        G().a(new androidx.lifecycle.j() { // from class: androidx.activity.ComponentActivity.5
            @Override // androidx.lifecycle.j
            public void d(androidx.lifecycle.l lVar, AbstractC0183g.a aVar) {
                ComponentActivity.this.T();
                ComponentActivity.this.G().c(this);
            }
        });
        bVarA.c();
        w.a(this);
        if (i2 <= 23) {
            G().a(new ImmLeaksCleaner(this));
        }
        d().h("android:support:activity-result", new a.c() { // from class: androidx.activity.d
            @Override // androidx.savedstate.a.c
            public final Bundle a() {
                return this.f775a.X();
            }
        });
        Q(new InterfaceC0185b() { // from class: androidx.activity.e
            @Override // b.InterfaceC0185b
            public final void a(Context context) {
                this.f776a.Y(context);
            }
        });
    }

    private f S() {
        return new g();
    }

    private void U() {
        F.a(getWindow().getDecorView(), this);
        G.a(getWindow().getDecorView(), this);
        A.d.a(getWindow().getDecorView(), this);
        q.a(getWindow().getDecorView(), this);
        p.a(getWindow().getDecorView(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ k0.i W() {
        reportFullyDrawn();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle X() {
        Bundle bundle = new Bundle();
        this.f728m.h(bundle);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(Context context) {
        Bundle bundleB = d().b("android:support:activity-result");
        if (bundleB != null) {
            this.f728m.g(bundleB);
        }
    }

    @Override // androidx.core.app.o
    public final void B(InterfaceC0232a interfaceC0232a) {
        this.f732q.add(interfaceC0232a);
    }

    @Override // androidx.lifecycle.l
    public AbstractC0183g G() {
        return this.f720e;
    }

    @Override // androidx.core.app.p
    public final void H(InterfaceC0232a interfaceC0232a) {
        this.f733r.add(interfaceC0232a);
    }

    public final void Q(InterfaceC0185b interfaceC0185b) {
        this.f718c.a(interfaceC0185b);
    }

    public final void R(InterfaceC0232a interfaceC0232a) {
        this.f731p.add(interfaceC0232a);
    }

    void T() {
        if (this.f722g == null) {
            e eVar = (e) getLastNonConfigurationInstance();
            if (eVar != null) {
                this.f722g = eVar.f748b;
            }
            if (this.f722g == null) {
                this.f722g = new D();
            }
        }
    }

    public void V() {
        invalidateOptionsMenu();
    }

    public Object Z() {
        return null;
    }

    @Override // androidx.lifecycle.InterfaceC0182f
    public AbstractC0272a a() {
        C0275d c0275d = new C0275d();
        if (getApplication() != null) {
            c0275d.b(A.a.f3030d, getApplication());
        }
        c0275d.b(w.f3115a, this);
        c0275d.b(w.f3116b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            c0275d.b(w.f3117c, getIntent().getExtras());
        }
        return c0275d;
    }

    @Override // androidx.activity.o
    public final OnBackPressedDispatcher c() {
        return this.f723h;
    }

    @Override // A.c
    public final androidx.savedstate.a d() {
        return this.f721f.b();
    }

    @Override // androidx.core.content.b
    public final void f(InterfaceC0232a interfaceC0232a) {
        this.f729n.add(interfaceC0232a);
    }

    @Override // androidx.core.app.p
    public final void g(InterfaceC0232a interfaceC0232a) {
        this.f733r.remove(interfaceC0232a);
    }

    @Override // androidx.core.content.b
    public final void h(InterfaceC0232a interfaceC0232a) {
        this.f729n.remove(interfaceC0232a);
    }

    @Override // androidx.core.view.InterfaceC0157v
    public void i(InterfaceC0160y interfaceC0160y) {
        this.f719d.f(interfaceC0160y);
    }

    @Override // androidx.core.view.InterfaceC0157v
    public void k(InterfaceC0160y interfaceC0160y) {
        this.f719d.a(interfaceC0160y);
    }

    @Override // androidx.core.app.o
    public final void m(InterfaceC0232a interfaceC0232a) {
        this.f732q.remove(interfaceC0232a);
    }

    @Override // androidx.activity.result.e
    public final androidx.activity.result.d n() {
        return this.f728m;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        if (this.f728m.b(i2, i3, intent)) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f723h.e();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator it2 = this.f729n.iterator();
        while (it2.hasNext()) {
            ((InterfaceC0232a) it2.next()).a(configuration);
        }
    }

    @Override // androidx.core.app.g, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f721f.d(bundle);
        this.f718c.c(this);
        super.onCreate(bundle);
        u.e(this);
        if (androidx.core.os.a.b()) {
            this.f723h.f(d.a(this));
        }
        int i2 = this.f726k;
        if (i2 != 0) {
            setContentView(i2);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i2, menu);
        this.f719d.b(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.f719d.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z2) {
        if (this.f734s) {
            return;
        }
        Iterator it2 = this.f732q.iterator();
        while (it2.hasNext()) {
            ((InterfaceC0232a) it2.next()).a(new androidx.core.app.h(z2));
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator it2 = this.f731p.iterator();
        while (it2.hasNext()) {
            ((InterfaceC0232a) it2.next()).a(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        this.f719d.c(menu);
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z2) {
        if (this.f735t) {
            return;
        }
        Iterator it2 = this.f733r.iterator();
        while (it2.hasNext()) {
            ((InterfaceC0232a) it2.next()).a(new androidx.core.app.q(z2));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 != 0) {
            return true;
        }
        super.onPreparePanel(i2, view, menu);
        this.f719d.e(menu);
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (this.f728m.b(i2, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        e eVar;
        Object objZ = Z();
        D d2 = this.f722g;
        if (d2 == null && (eVar = (e) getLastNonConfigurationInstance()) != null) {
            d2 = eVar.f748b;
        }
        if (d2 == null && objZ == null) {
            return null;
        }
        e eVar2 = new e();
        eVar2.f747a = objZ;
        eVar2.f748b = d2;
        return eVar2;
    }

    @Override // androidx.core.app.g, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        AbstractC0183g abstractC0183gG = G();
        if (abstractC0183gG instanceof androidx.lifecycle.m) {
            ((androidx.lifecycle.m) abstractC0183gG).m(AbstractC0183g.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f721f.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        Iterator it2 = this.f730o.iterator();
        while (it2.hasNext()) {
            ((InterfaceC0232a) it2.next()).a(Integer.valueOf(i2));
        }
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (C.b.d()) {
                C.b.a("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.f725j.b();
            C.b.b();
        } catch (Throwable th) {
            C.b.b();
            throw th;
        }
    }

    @Override // android.app.Activity
    public abstract void setContentView(int i2);

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        U();
        this.f724i.a(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    @Override // androidx.core.content.c
    public final void t(InterfaceC0232a interfaceC0232a) {
        this.f730o.add(interfaceC0232a);
    }

    @Override // androidx.lifecycle.E
    public D x() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        T();
        return this.f722g;
    }

    @Override // androidx.core.content.c
    public final void y(InterfaceC0232a interfaceC0232a) {
        this.f730o.remove(interfaceC0232a);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z2, Configuration configuration) {
        this.f734s = true;
        try {
            super.onMultiWindowModeChanged(z2, configuration);
            this.f734s = false;
            Iterator it2 = this.f732q.iterator();
            while (it2.hasNext()) {
                ((InterfaceC0232a) it2.next()).a(new androidx.core.app.h(z2, configuration));
            }
        } catch (Throwable th) {
            this.f734s = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z2, Configuration configuration) {
        this.f735t = true;
        try {
            super.onPictureInPictureModeChanged(z2, configuration);
            this.f735t = false;
            Iterator it2 = this.f733r.iterator();
            while (it2.hasNext()) {
                ((InterfaceC0232a) it2.next()).a(new androidx.core.app.q(z2, configuration));
            }
        } catch (Throwable th) {
            this.f735t = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        super.startActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }
}
