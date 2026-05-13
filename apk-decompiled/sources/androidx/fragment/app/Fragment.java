package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.view.AbstractC0156u;
import androidx.lifecycle.A;
import androidx.lifecycle.AbstractC0183g;
import androidx.lifecycle.InterfaceC0182f;
import androidx.lifecycle.LiveData;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import x.C0265c;
import y.AbstractC0272a;
import y.C0275d;

/* JADX INFO: loaded from: classes.dex */
public abstract class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.l, androidx.lifecycle.E, InterfaceC0182f, A.c {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    static final Object f2658b0 = new Object();

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    boolean f2659A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    boolean f2660B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    boolean f2661C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    boolean f2662D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    boolean f2663E;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private boolean f2665G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    ViewGroup f2666H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    View f2667I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    boolean f2668J;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    f f2670L;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    boolean f2672N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    LayoutInflater f2673O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    boolean f2674P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public String f2675Q;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    androidx.lifecycle.m f2677S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    K f2678T;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    A.b f2680V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    A.b f2681W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    private int f2682X;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Bundle f2687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    SparseArray f2688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Bundle f2689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Boolean f2690e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Bundle f2692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Fragment f2693h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f2695j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f2697l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f2698m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f2699n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f2700o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f2701p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f2702q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f2703r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f2704s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    x f2705t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    p f2706u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    Fragment f2708w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    int f2709x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    int f2710y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    String f2711z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f2685a = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f2691f = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String f2694i = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Boolean f2696k = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    x f2707v = new y();

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    boolean f2664F = true;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    boolean f2669K = true;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    Runnable f2671M = new a();

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    AbstractC0183g.b f2676R = AbstractC0183g.b.RESUMED;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    androidx.lifecycle.p f2679U = new androidx.lifecycle.p();

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    private final AtomicInteger f2683Y = new AtomicInteger();

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    private final ArrayList f2684Z = new ArrayList();

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final i f2686a0 = new b();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.H1();
        }
    }

    class b extends i {
        b() {
            super(null);
        }

        @Override // androidx.fragment.app.Fragment.i
        void a() {
            Fragment.this.f2681W.c();
            androidx.lifecycle.w.a(Fragment.this);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.b(false);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ M f2716a;

        d(M m2) {
            this.f2716a = m2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2716a.g();
        }
    }

    class e extends AbstractC0173l {
        e() {
        }

        @Override // androidx.fragment.app.AbstractC0173l
        public View e(int i2) {
            View view = Fragment.this.f2667I;
            if (view != null) {
                return view.findViewById(i2);
            }
            throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
        }

        @Override // androidx.fragment.app.AbstractC0173l
        public boolean j() {
            return Fragment.this.f2667I != null;
        }
    }

    static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        View f2719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f2720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2721c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2722d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f2723e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f2724f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f2725g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        ArrayList f2726h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        ArrayList f2727i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f2728j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f2729k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f2730l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Object f2731m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Object f2732n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Object f2733o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Boolean f2734p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        Boolean f2735q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        float f2736r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        View f2737s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        boolean f2738t;

        f() {
            Object obj = Fragment.f2658b0;
            this.f2729k = obj;
            this.f2730l = null;
            this.f2731m = obj;
            this.f2732n = null;
            this.f2733o = obj;
            this.f2736r = 1.0f;
            this.f2737s = null;
        }
    }

    static class g {
        static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    public static class h extends RuntimeException {
        public h(String str, Exception exc) {
            super(str, exc);
        }
    }

    private static abstract class i {
        private i() {
        }

        abstract void a();

        /* synthetic */ i(a aVar) {
            this();
        }
    }

    public static class j implements Parcelable {
        public static final Parcelable.Creator<j> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Bundle f2739a;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public j createFromParcel(Parcel parcel) {
                return new j(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public j createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new j(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public j[] newArray(int i2) {
                return new j[i2];
            }
        }

        j(Bundle bundle) {
            this.f2739a = bundle;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeBundle(this.f2739a);
        }

        j(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle = parcel.readBundle();
            this.f2739a = bundle;
            if (classLoader == null || bundle == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }
    }

    public Fragment() {
        U();
    }

    private int A() {
        AbstractC0183g.b bVar = this.f2676R;
        return (bVar == AbstractC0183g.b.INITIALIZED || this.f2708w == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.f2708w.A());
    }

    private Fragment R(boolean z2) {
        String str;
        if (z2) {
            C0265c.h(this);
        }
        Fragment fragment = this.f2693h;
        if (fragment != null) {
            return fragment;
        }
        x xVar = this.f2705t;
        if (xVar == null || (str = this.f2694i) == null) {
            return null;
        }
        return xVar.e0(str);
    }

    private void U() {
        this.f2677S = new androidx.lifecycle.m(this);
        this.f2681W = A.b.a(this);
        this.f2680V = null;
        if (this.f2684Z.contains(this.f2686a0)) {
            return;
        }
        l1(this.f2686a0);
    }

    public static Fragment W(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) AbstractC0176o.d(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.t1(bundle);
            }
            return fragment;
        } catch (IllegalAccessException e2) {
            throw new h("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (InstantiationException e3) {
            throw new h("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new h("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new h("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }

    private f g() {
        if (this.f2670L == null) {
            this.f2670L = new f();
        }
        return this.f2670L;
    }

    private void l1(i iVar) {
        if (this.f2685a >= 0) {
            iVar.a();
        } else {
            this.f2684Z.add(iVar);
        }
    }

    private void q1() {
        if (x.H0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto RESTORE_VIEW_STATE: ");
            sb.append(this);
        }
        if (this.f2667I != null) {
            r1(this.f2687b);
        }
        this.f2687b = null;
    }

    public boolean A0(MenuItem menuItem) {
        return false;
    }

    void A1(float f2) {
        g().f2736r = f2;
    }

    int B() {
        f fVar = this.f2670L;
        if (fVar == null) {
            return 0;
        }
        return fVar.f2725g;
    }

    public void B0(Menu menu) {
    }

    void B1(ArrayList arrayList, ArrayList arrayList2) {
        g();
        f fVar = this.f2670L;
        fVar.f2726h = arrayList;
        fVar.f2727i = arrayList2;
    }

    public final Fragment C() {
        return this.f2708w;
    }

    public void C0() {
        this.f2665G = true;
    }

    public void C1(boolean z2) {
        C0265c.i(this, z2);
        if (!this.f2669K && z2 && this.f2685a < 5 && this.f2705t != null && X() && this.f2674P) {
            x xVar = this.f2705t;
            xVar.Y0(xVar.v(this));
        }
        this.f2669K = z2;
        this.f2668J = this.f2685a < 5 && !z2;
        if (this.f2687b != null) {
            this.f2690e = Boolean.valueOf(z2);
        }
    }

    public final x D() {
        x xVar = this.f2705t;
        if (xVar != null) {
            return xVar;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public void D0(boolean z2) {
    }

    public void D1(Intent intent) {
        E1(intent, null);
    }

    boolean E() {
        f fVar = this.f2670L;
        if (fVar == null) {
            return false;
        }
        return fVar.f2720b;
    }

    public void E0(Menu menu) {
    }

    public void E1(Intent intent, Bundle bundle) {
        p pVar = this.f2706u;
        if (pVar != null) {
            pVar.u(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    int F() {
        f fVar = this.f2670L;
        if (fVar == null) {
            return 0;
        }
        return fVar.f2723e;
    }

    public void F0(boolean z2) {
    }

    public void F1(Intent intent, int i2) {
        G1(intent, i2, null);
    }

    @Override // androidx.lifecycle.l
    public AbstractC0183g G() {
        return this.f2677S;
    }

    public void G0(int i2, String[] strArr, int[] iArr) {
    }

    public void G1(Intent intent, int i2, Bundle bundle) {
        if (this.f2706u != null) {
            D().U0(this, intent, i2, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    int H() {
        f fVar = this.f2670L;
        if (fVar == null) {
            return 0;
        }
        return fVar.f2724f;
    }

    public void H0() {
        this.f2665G = true;
    }

    public void H1() {
        if (this.f2670L == null || !g().f2738t) {
            return;
        }
        if (this.f2706u == null) {
            g().f2738t = false;
        } else if (Looper.myLooper() != this.f2706u.p().getLooper()) {
            this.f2706u.p().postAtFrontOfQueue(new c());
        } else {
            b(true);
        }
    }

    float I() {
        f fVar = this.f2670L;
        if (fVar == null) {
            return 1.0f;
        }
        return fVar.f2736r;
    }

    public void I0(Bundle bundle) {
    }

    public Object J() {
        f fVar = this.f2670L;
        if (fVar == null) {
            return null;
        }
        Object obj = fVar.f2731m;
        return obj == f2658b0 ? t() : obj;
    }

    public void J0() {
        this.f2665G = true;
    }

    public final Resources K() {
        return n1().getResources();
    }

    public void K0() {
        this.f2665G = true;
    }

    public Object L() {
        f fVar = this.f2670L;
        if (fVar == null) {
            return null;
        }
        Object obj = fVar.f2729k;
        return obj == f2658b0 ? q() : obj;
    }

    public void L0(View view, Bundle bundle) {
    }

    public Object M() {
        f fVar = this.f2670L;
        if (fVar == null) {
            return null;
        }
        return fVar.f2732n;
    }

    public void M0(Bundle bundle) {
        this.f2665G = true;
    }

    public Object N() {
        f fVar = this.f2670L;
        if (fVar == null) {
            return null;
        }
        Object obj = fVar.f2733o;
        return obj == f2658b0 ? M() : obj;
    }

    void N0(Bundle bundle) {
        this.f2707v.W0();
        this.f2685a = 3;
        this.f2665G = false;
        g0(bundle);
        if (this.f2665G) {
            q1();
            this.f2707v.x();
        } else {
            throw new O("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    ArrayList O() {
        ArrayList arrayList;
        f fVar = this.f2670L;
        return (fVar == null || (arrayList = fVar.f2726h) == null) ? new ArrayList() : arrayList;
    }

    void O0() {
        Iterator it2 = this.f2684Z.iterator();
        while (it2.hasNext()) {
            ((i) it2.next()).a();
        }
        this.f2684Z.clear();
        this.f2707v.m(this.f2706u, e(), this);
        this.f2685a = 0;
        this.f2665G = false;
        j0(this.f2706u.o());
        if (this.f2665G) {
            this.f2705t.H(this);
            this.f2707v.y();
        } else {
            throw new O("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    ArrayList P() {
        ArrayList arrayList;
        f fVar = this.f2670L;
        return (fVar == null || (arrayList = fVar.f2727i) == null) ? new ArrayList() : arrayList;
    }

    void P0(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    public final String Q(int i2) {
        return K().getString(i2);
    }

    boolean Q0(MenuItem menuItem) {
        if (this.f2659A) {
            return false;
        }
        if (l0(menuItem)) {
            return true;
        }
        return this.f2707v.A(menuItem);
    }

    void R0(Bundle bundle) {
        this.f2707v.W0();
        this.f2685a = 1;
        this.f2665G = false;
        this.f2677S.a(new androidx.lifecycle.j() { // from class: androidx.fragment.app.Fragment.6
            @Override // androidx.lifecycle.j
            public void d(androidx.lifecycle.l lVar, AbstractC0183g.a aVar) {
                View view;
                if (aVar != AbstractC0183g.a.ON_STOP || (view = Fragment.this.f2667I) == null) {
                    return;
                }
                g.a(view);
            }
        });
        this.f2681W.d(bundle);
        m0(bundle);
        this.f2674P = true;
        if (this.f2665G) {
            this.f2677S.h(AbstractC0183g.a.ON_CREATE);
            return;
        }
        throw new O("Fragment " + this + " did not call through to super.onCreate()");
    }

    public View S() {
        return this.f2667I;
    }

    boolean S0(Menu menu, MenuInflater menuInflater) {
        boolean z2 = false;
        if (this.f2659A) {
            return false;
        }
        if (this.f2663E && this.f2664F) {
            p0(menu, menuInflater);
            z2 = true;
        }
        return z2 | this.f2707v.C(menu, menuInflater);
    }

    public LiveData T() {
        return this.f2679U;
    }

    void T0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f2707v.W0();
        this.f2703r = true;
        this.f2678T = new K(this, x());
        View viewQ0 = q0(layoutInflater, viewGroup, bundle);
        this.f2667I = viewQ0;
        if (viewQ0 == null) {
            if (this.f2678T.f()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.f2678T = null;
        } else {
            this.f2678T.e();
            androidx.lifecycle.F.a(this.f2667I, this.f2678T);
            androidx.lifecycle.G.a(this.f2667I, this.f2678T);
            A.d.a(this.f2667I, this.f2678T);
            this.f2679U.i(this.f2678T);
        }
    }

    void U0() {
        this.f2707v.D();
        this.f2677S.h(AbstractC0183g.a.ON_DESTROY);
        this.f2685a = 0;
        this.f2665G = false;
        this.f2674P = false;
        r0();
        if (this.f2665G) {
            return;
        }
        throw new O("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void V() {
        U();
        this.f2675Q = this.f2691f;
        this.f2691f = UUID.randomUUID().toString();
        this.f2697l = false;
        this.f2698m = false;
        this.f2700o = false;
        this.f2701p = false;
        this.f2702q = false;
        this.f2704s = 0;
        this.f2705t = null;
        this.f2707v = new y();
        this.f2706u = null;
        this.f2709x = 0;
        this.f2710y = 0;
        this.f2711z = null;
        this.f2659A = false;
        this.f2660B = false;
    }

    void V0() {
        this.f2707v.E();
        if (this.f2667I != null && this.f2678T.G().b().b(AbstractC0183g.b.CREATED)) {
            this.f2678T.b(AbstractC0183g.a.ON_DESTROY);
        }
        this.f2685a = 1;
        this.f2665G = false;
        t0();
        if (this.f2665G) {
            androidx.loader.app.a.b(this).c();
            this.f2703r = false;
        } else {
            throw new O("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    void W0() {
        this.f2685a = -1;
        this.f2665G = false;
        u0();
        this.f2673O = null;
        if (this.f2665G) {
            if (this.f2707v.G0()) {
                return;
            }
            this.f2707v.D();
            this.f2707v = new y();
            return;
        }
        throw new O("Fragment " + this + " did not call through to super.onDetach()");
    }

    public final boolean X() {
        return this.f2706u != null && this.f2697l;
    }

    LayoutInflater X0(Bundle bundle) {
        LayoutInflater layoutInflaterV0 = v0(bundle);
        this.f2673O = layoutInflaterV0;
        return layoutInflaterV0;
    }

    public final boolean Y() {
        x xVar;
        return this.f2659A || ((xVar = this.f2705t) != null && xVar.K0(this.f2708w));
    }

    void Y0() {
        onLowMemory();
    }

    final boolean Z() {
        return this.f2704s > 0;
    }

    void Z0(boolean z2) {
        z0(z2);
    }

    @Override // androidx.lifecycle.InterfaceC0182f
    public AbstractC0272a a() {
        Application application;
        Context applicationContext = n1().getApplicationContext();
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
        if (application == null && x.H0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not find Application instance from Context ");
            sb.append(n1().getApplicationContext());
            sb.append(", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        C0275d c0275d = new C0275d();
        if (application != null) {
            c0275d.b(A.a.f3030d, application);
        }
        c0275d.b(androidx.lifecycle.w.f3115a, this);
        c0275d.b(androidx.lifecycle.w.f3116b, this);
        if (m() != null) {
            c0275d.b(androidx.lifecycle.w.f3117c, m());
        }
        return c0275d;
    }

    public final boolean a0() {
        x xVar;
        return this.f2664F && ((xVar = this.f2705t) == null || xVar.L0(this.f2708w));
    }

    boolean a1(MenuItem menuItem) {
        if (this.f2659A) {
            return false;
        }
        if (this.f2663E && this.f2664F && A0(menuItem)) {
            return true;
        }
        return this.f2707v.J(menuItem);
    }

    void b(boolean z2) {
        ViewGroup viewGroup;
        x xVar;
        f fVar = this.f2670L;
        if (fVar != null) {
            fVar.f2738t = false;
        }
        if (this.f2667I == null || (viewGroup = this.f2666H) == null || (xVar = this.f2705t) == null) {
            return;
        }
        M mN = M.n(viewGroup, xVar);
        mN.p();
        if (z2) {
            this.f2706u.p().post(new d(mN));
        } else {
            mN.g();
        }
    }

    boolean b0() {
        f fVar = this.f2670L;
        if (fVar == null) {
            return false;
        }
        return fVar.f2738t;
    }

    void b1(Menu menu) {
        if (this.f2659A) {
            return;
        }
        if (this.f2663E && this.f2664F) {
            B0(menu);
        }
        this.f2707v.K(menu);
    }

    public final boolean c0() {
        return this.f2685a >= 7;
    }

    void c1() {
        this.f2707v.M();
        if (this.f2667I != null) {
            this.f2678T.b(AbstractC0183g.a.ON_PAUSE);
        }
        this.f2677S.h(AbstractC0183g.a.ON_PAUSE);
        this.f2685a = 6;
        this.f2665G = false;
        C0();
        if (this.f2665G) {
            return;
        }
        throw new O("Fragment " + this + " did not call through to super.onPause()");
    }

    @Override // A.c
    public final androidx.savedstate.a d() {
        return this.f2681W.b();
    }

    public final boolean d0() {
        x xVar = this.f2705t;
        if (xVar == null) {
            return false;
        }
        return xVar.O0();
    }

    void d1(boolean z2) {
        D0(z2);
    }

    AbstractC0173l e() {
        return new e();
    }

    public final boolean e0() {
        View view;
        return (!X() || Y() || (view = this.f2667I) == null || view.getWindowToken() == null || this.f2667I.getVisibility() != 0) ? false : true;
    }

    boolean e1(Menu menu) {
        boolean z2 = false;
        if (this.f2659A) {
            return false;
        }
        if (this.f2663E && this.f2664F) {
            E0(menu);
            z2 = true;
        }
        return z2 | this.f2707v.O(menu);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f2709x));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f2710y));
        printWriter.print(" mTag=");
        printWriter.println(this.f2711z);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f2685a);
        printWriter.print(" mWho=");
        printWriter.print(this.f2691f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f2704s);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f2697l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f2698m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f2700o);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f2701p);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f2659A);
        printWriter.print(" mDetached=");
        printWriter.print(this.f2660B);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f2664F);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f2663E);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f2661C);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f2669K);
        if (this.f2705t != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f2705t);
        }
        if (this.f2706u != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f2706u);
        }
        if (this.f2708w != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f2708w);
        }
        if (this.f2692g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f2692g);
        }
        if (this.f2687b != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f2687b);
        }
        if (this.f2688c != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f2688c);
        }
        if (this.f2689d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f2689d);
        }
        Fragment fragmentR = R(false);
        if (fragmentR != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(fragmentR);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f2695j);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(E());
        if (p() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(p());
        }
        if (s() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(s());
        }
        if (F() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(F());
        }
        if (H() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(H());
        }
        if (this.f2666H != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f2666H);
        }
        if (this.f2667I != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f2667I);
        }
        if (l() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(l());
        }
        if (o() != null) {
            androidx.loader.app.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.f2707v + ":");
        this.f2707v.W(str + "  ", fileDescriptor, printWriter, strArr);
    }

    void f0() {
        this.f2707v.W0();
    }

    void f1() {
        boolean zM0 = this.f2705t.M0(this);
        Boolean bool = this.f2696k;
        if (bool == null || bool.booleanValue() != zM0) {
            this.f2696k = Boolean.valueOf(zM0);
            F0(zM0);
            this.f2707v.P();
        }
    }

    public void g0(Bundle bundle) {
        this.f2665G = true;
    }

    void g1() {
        this.f2707v.W0();
        this.f2707v.a0(true);
        this.f2685a = 7;
        this.f2665G = false;
        H0();
        if (!this.f2665G) {
            throw new O("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.m mVar = this.f2677S;
        AbstractC0183g.a aVar = AbstractC0183g.a.ON_RESUME;
        mVar.h(aVar);
        if (this.f2667I != null) {
            this.f2678T.b(aVar);
        }
        this.f2707v.Q();
    }

    Fragment h(String str) {
        return str.equals(this.f2691f) ? this : this.f2707v.i0(str);
    }

    public void h0(int i2, int i3, Intent intent) {
        if (x.H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(this);
            sb.append(" received the following in onActivityResult(): requestCode: ");
            sb.append(i2);
            sb.append(" resultCode: ");
            sb.append(i3);
            sb.append(" data: ");
            sb.append(intent);
        }
    }

    void h1(Bundle bundle) {
        I0(bundle);
        this.f2681W.e(bundle);
        Bundle bundleJ1 = this.f2707v.P0();
        if (bundleJ1 != null) {
            bundle.putParcelable("android:support:fragments", bundleJ1);
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final AbstractActivityC0171j i() {
        p pVar = this.f2706u;
        if (pVar == null) {
            return null;
        }
        return (AbstractActivityC0171j) pVar.l();
    }

    public void i0(Activity activity) {
        this.f2665G = true;
    }

    void i1() {
        this.f2707v.W0();
        this.f2707v.a0(true);
        this.f2685a = 5;
        this.f2665G = false;
        J0();
        if (!this.f2665G) {
            throw new O("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.m mVar = this.f2677S;
        AbstractC0183g.a aVar = AbstractC0183g.a.ON_START;
        mVar.h(aVar);
        if (this.f2667I != null) {
            this.f2678T.b(aVar);
        }
        this.f2707v.R();
    }

    public boolean j() {
        Boolean bool;
        f fVar = this.f2670L;
        if (fVar == null || (bool = fVar.f2735q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void j0(Context context) {
        this.f2665G = true;
        p pVar = this.f2706u;
        Activity activityL = pVar == null ? null : pVar.l();
        if (activityL != null) {
            this.f2665G = false;
            i0(activityL);
        }
    }

    void j1() {
        this.f2707v.T();
        if (this.f2667I != null) {
            this.f2678T.b(AbstractC0183g.a.ON_STOP);
        }
        this.f2677S.h(AbstractC0183g.a.ON_STOP);
        this.f2685a = 4;
        this.f2665G = false;
        K0();
        if (this.f2665G) {
            return;
        }
        throw new O("Fragment " + this + " did not call through to super.onStop()");
    }

    public boolean k() {
        Boolean bool;
        f fVar = this.f2670L;
        if (fVar == null || (bool = fVar.f2734p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void k0(Fragment fragment) {
    }

    void k1() {
        L0(this.f2667I, this.f2687b);
        this.f2707v.U();
    }

    View l() {
        f fVar = this.f2670L;
        if (fVar == null) {
            return null;
        }
        return fVar.f2719a;
    }

    public boolean l0(MenuItem menuItem) {
        return false;
    }

    public final Bundle m() {
        return this.f2692g;
    }

    public void m0(Bundle bundle) {
        this.f2665G = true;
        p1(bundle);
        if (this.f2707v.N0(1)) {
            return;
        }
        this.f2707v.B();
    }

    public final AbstractActivityC0171j m1() {
        AbstractActivityC0171j abstractActivityC0171jI = i();
        if (abstractActivityC0171jI != null) {
            return abstractActivityC0171jI;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final x n() {
        if (this.f2706u != null) {
            return this.f2707v;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Animation n0(int i2, boolean z2, int i3) {
        return null;
    }

    public final Context n1() {
        Context contextO = o();
        if (contextO != null) {
            return contextO;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public Context o() {
        p pVar = this.f2706u;
        if (pVar == null) {
            return null;
        }
        return pVar.o();
    }

    public Animator o0(int i2, boolean z2, int i3) {
        return null;
    }

    public final View o1() {
        View viewS = S();
        if (viewS != null) {
            return viewS;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.f2665G = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        m1().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f2665G = true;
    }

    int p() {
        f fVar = this.f2670L;
        if (fVar == null) {
            return 0;
        }
        return fVar.f2721c;
    }

    public void p0(Menu menu, MenuInflater menuInflater) {
    }

    void p1(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.f2707v.h1(parcelable);
        this.f2707v.B();
    }

    public Object q() {
        f fVar = this.f2670L;
        if (fVar == null) {
            return null;
        }
        return fVar.f2728j;
    }

    public View q0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = this.f2682X;
        if (i2 != 0) {
            return layoutInflater.inflate(i2, viewGroup, false);
        }
        return null;
    }

    androidx.core.app.s r() {
        f fVar = this.f2670L;
        if (fVar == null) {
            return null;
        }
        fVar.getClass();
        return null;
    }

    public void r0() {
        this.f2665G = true;
    }

    final void r1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f2688c;
        if (sparseArray != null) {
            this.f2667I.restoreHierarchyState(sparseArray);
            this.f2688c = null;
        }
        if (this.f2667I != null) {
            this.f2678T.g(this.f2689d);
            this.f2689d = null;
        }
        this.f2665G = false;
        M0(bundle);
        if (this.f2665G) {
            if (this.f2667I != null) {
                this.f2678T.b(AbstractC0183g.a.ON_CREATE);
            }
        } else {
            throw new O("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    int s() {
        f fVar = this.f2670L;
        if (fVar == null) {
            return 0;
        }
        return fVar.f2722d;
    }

    public void s0() {
    }

    void s1(int i2, int i3, int i4, int i5) {
        if (this.f2670L == null && i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            return;
        }
        g().f2721c = i2;
        g().f2722d = i3;
        g().f2723e = i4;
        g().f2724f = i5;
    }

    public Object t() {
        f fVar = this.f2670L;
        if (fVar == null) {
            return null;
        }
        return fVar.f2730l;
    }

    public void t0() {
        this.f2665G = true;
    }

    public void t1(Bundle bundle) {
        if (this.f2705t != null && d0()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f2692g = bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f2691f);
        if (this.f2709x != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f2709x));
        }
        if (this.f2711z != null) {
            sb.append(" tag=");
            sb.append(this.f2711z);
        }
        sb.append(")");
        return sb.toString();
    }

    androidx.core.app.s u() {
        f fVar = this.f2670L;
        if (fVar == null) {
            return null;
        }
        fVar.getClass();
        return null;
    }

    public void u0() {
        this.f2665G = true;
    }

    void u1(View view) {
        g().f2737s = view;
    }

    View v() {
        f fVar = this.f2670L;
        if (fVar == null) {
            return null;
        }
        return fVar.f2737s;
    }

    public LayoutInflater v0(Bundle bundle) {
        return z(bundle);
    }

    public void v1(boolean z2) {
        if (this.f2663E != z2) {
            this.f2663E = z2;
            if (!X() || Y()) {
                return;
            }
            this.f2706u.v();
        }
    }

    public final x w() {
        return this.f2705t;
    }

    public void w0(boolean z2) {
    }

    public void w1(j jVar) {
        Bundle bundle;
        if (this.f2705t != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (jVar == null || (bundle = jVar.f2739a) == null) {
            bundle = null;
        }
        this.f2687b = bundle;
    }

    @Override // androidx.lifecycle.E
    public androidx.lifecycle.D x() {
        if (this.f2705t == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (A() != AbstractC0183g.b.INITIALIZED.ordinal()) {
            return this.f2705t.C0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    public void x0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f2665G = true;
    }

    public void x1(boolean z2) {
        if (this.f2664F != z2) {
            this.f2664F = z2;
            if (this.f2663E && X() && !Y()) {
                this.f2706u.v();
            }
        }
    }

    public final Object y() {
        p pVar = this.f2706u;
        if (pVar == null) {
            return null;
        }
        return pVar.r();
    }

    public void y0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f2665G = true;
        p pVar = this.f2706u;
        Activity activityL = pVar == null ? null : pVar.l();
        if (activityL != null) {
            this.f2665G = false;
            x0(activityL, attributeSet, bundle);
        }
    }

    void y1(int i2) {
        if (this.f2670L == null && i2 == 0) {
            return;
        }
        g();
        this.f2670L.f2725g = i2;
    }

    public LayoutInflater z(Bundle bundle) {
        p pVar = this.f2706u;
        if (pVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterS = pVar.s();
        AbstractC0156u.a(layoutInflaterS, this.f2707v.v0());
        return layoutInflaterS;
    }

    public void z0(boolean z2) {
    }

    void z1(boolean z2) {
        if (this.f2670L == null) {
            return;
        }
        g().f2720b = z2;
    }
}
