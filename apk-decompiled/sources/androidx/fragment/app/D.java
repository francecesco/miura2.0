package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.M;
import androidx.lifecycle.AbstractC0183g;
import it.tervis.miura.model.Console;
import x.C0265c;

/* JADX INFO: loaded from: classes.dex */
class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r f2639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final F f2640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Fragment f2641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2642d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2643e = -1;

    class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f2644a;

        a(View view) {
            this.f2644a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f2644a.removeOnAttachStateChangeListener(this);
            androidx.core.view.L.R(this.f2644a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2646a;

        static {
            int[] iArr = new int[AbstractC0183g.b.values().length];
            f2646a = iArr;
            try {
                iArr[AbstractC0183g.b.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2646a[AbstractC0183g.b.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2646a[AbstractC0183g.b.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2646a[AbstractC0183g.b.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    D(r rVar, F f2, Fragment fragment) {
        this.f2639a = rVar;
        this.f2640b = f2;
        this.f2641c = fragment;
    }

    private boolean l(View view) {
        if (view == this.f2641c.f2667I) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f2641c.f2667I) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.f2641c.h1(bundle);
        this.f2639a.j(this.f2641c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f2641c.f2667I != null) {
            t();
        }
        if (this.f2641c.f2688c != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f2641c.f2688c);
        }
        if (this.f2641c.f2689d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f2641c.f2689d);
        }
        if (!this.f2641c.f2669K) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f2641c.f2669K);
        }
        return bundle;
    }

    void a() {
        if (x.H0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto ACTIVITY_CREATED: ");
            sb.append(this.f2641c);
        }
        Fragment fragment = this.f2641c;
        fragment.N0(fragment.f2687b);
        r rVar = this.f2639a;
        Fragment fragment2 = this.f2641c;
        rVar.a(fragment2, fragment2.f2687b, false);
    }

    void b() {
        int iJ = this.f2640b.j(this.f2641c);
        Fragment fragment = this.f2641c;
        fragment.f2666H.addView(fragment.f2667I, iJ);
    }

    void c() {
        if (x.H0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto ATTACHED: ");
            sb.append(this.f2641c);
        }
        Fragment fragment = this.f2641c;
        Fragment fragment2 = fragment.f2693h;
        D dN = null;
        if (fragment2 != null) {
            D dN2 = this.f2640b.n(fragment2.f2691f);
            if (dN2 == null) {
                throw new IllegalStateException("Fragment " + this.f2641c + " declared target fragment " + this.f2641c.f2693h + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.f2641c;
            fragment3.f2694i = fragment3.f2693h.f2691f;
            fragment3.f2693h = null;
            dN = dN2;
        } else {
            String str = fragment.f2694i;
            if (str != null && (dN = this.f2640b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f2641c + " declared target fragment " + this.f2641c.f2694i + " that does not belong to this FragmentManager!");
            }
        }
        if (dN != null) {
            dN.m();
        }
        Fragment fragment4 = this.f2641c;
        fragment4.f2706u = fragment4.f2705t.u0();
        Fragment fragment5 = this.f2641c;
        fragment5.f2708w = fragment5.f2705t.x0();
        this.f2639a.g(this.f2641c, false);
        this.f2641c.O0();
        this.f2639a.b(this.f2641c, false);
    }

    int d() {
        Fragment fragment = this.f2641c;
        if (fragment.f2705t == null) {
            return fragment.f2685a;
        }
        int iMin = this.f2643e;
        int i2 = b.f2646a[fragment.f2676R.ordinal()];
        if (i2 != 1) {
            iMin = i2 != 2 ? i2 != 3 ? i2 != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0) : Math.min(iMin, 1) : Math.min(iMin, 5);
        }
        Fragment fragment2 = this.f2641c;
        if (fragment2.f2700o) {
            if (fragment2.f2701p) {
                iMin = Math.max(this.f2643e, 2);
                View view = this.f2641c.f2667I;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f2643e < 4 ? Math.min(iMin, fragment2.f2685a) : Math.min(iMin, 1);
            }
        }
        if (!this.f2641c.f2697l) {
            iMin = Math.min(iMin, 1);
        }
        Fragment fragment3 = this.f2641c;
        ViewGroup viewGroup = fragment3.f2666H;
        M.e.b bVarL = viewGroup != null ? M.n(viewGroup, fragment3.D()).l(this) : null;
        if (bVarL == M.e.b.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (bVarL == M.e.b.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            Fragment fragment4 = this.f2641c;
            if (fragment4.f2698m) {
                iMin = fragment4.Z() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        Fragment fragment5 = this.f2641c;
        if (fragment5.f2668J && fragment5.f2685a < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (x.H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("computeExpectedState() of ");
            sb.append(iMin);
            sb.append(" for ");
            sb.append(this.f2641c);
        }
        return iMin;
    }

    void e() {
        if (x.H0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto CREATED: ");
            sb.append(this.f2641c);
        }
        Fragment fragment = this.f2641c;
        if (fragment.f2674P) {
            fragment.p1(fragment.f2687b);
            this.f2641c.f2685a = 1;
            return;
        }
        this.f2639a.h(fragment, fragment.f2687b, false);
        Fragment fragment2 = this.f2641c;
        fragment2.R0(fragment2.f2687b);
        r rVar = this.f2639a;
        Fragment fragment3 = this.f2641c;
        rVar.c(fragment3, fragment3.f2687b, false);
    }

    void f() {
        String resourceName;
        if (this.f2641c.f2700o) {
            return;
        }
        if (x.H0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto CREATE_VIEW: ");
            sb.append(this.f2641c);
        }
        Fragment fragment = this.f2641c;
        LayoutInflater layoutInflaterX0 = fragment.X0(fragment.f2687b);
        Fragment fragment2 = this.f2641c;
        ViewGroup viewGroup = fragment2.f2666H;
        if (viewGroup == null) {
            int i2 = fragment2.f2710y;
            if (i2 == 0) {
                viewGroup = null;
            } else {
                if (i2 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f2641c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment2.f2705t.p0().e(this.f2641c.f2710y);
                if (viewGroup == null) {
                    Fragment fragment3 = this.f2641c;
                    if (!fragment3.f2702q) {
                        try {
                            resourceName = fragment3.K().getResourceName(this.f2641c.f2710y);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f2641c.f2710y) + " (" + resourceName + ") for fragment " + this.f2641c);
                    }
                } else if (!(viewGroup instanceof C0174m)) {
                    C0265c.j(this.f2641c, viewGroup);
                }
            }
        }
        Fragment fragment4 = this.f2641c;
        fragment4.f2666H = viewGroup;
        fragment4.T0(layoutInflaterX0, viewGroup, fragment4.f2687b);
        View view = this.f2641c.f2667I;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.f2641c;
            fragment5.f2667I.setTag(R$id.fragment_container_view_tag, fragment5);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment6 = this.f2641c;
            if (fragment6.f2659A) {
                fragment6.f2667I.setVisibility(8);
            }
            if (androidx.core.view.L.E(this.f2641c.f2667I)) {
                androidx.core.view.L.R(this.f2641c.f2667I);
            } else {
                View view2 = this.f2641c.f2667I;
                view2.addOnAttachStateChangeListener(new a(view2));
            }
            this.f2641c.k1();
            r rVar = this.f2639a;
            Fragment fragment7 = this.f2641c;
            rVar.m(fragment7, fragment7.f2667I, fragment7.f2687b, false);
            int visibility = this.f2641c.f2667I.getVisibility();
            this.f2641c.A1(this.f2641c.f2667I.getAlpha());
            Fragment fragment8 = this.f2641c;
            if (fragment8.f2666H != null && visibility == 0) {
                View viewFindFocus = fragment8.f2667I.findFocus();
                if (viewFindFocus != null) {
                    this.f2641c.u1(viewFindFocus);
                    if (x.H0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("requestFocus: Saved focused view ");
                        sb2.append(viewFindFocus);
                        sb2.append(" for Fragment ");
                        sb2.append(this.f2641c);
                    }
                }
                this.f2641c.f2667I.setAlpha(0.0f);
            }
        }
        this.f2641c.f2685a = 2;
    }

    void g() {
        Fragment fragmentF;
        if (x.H0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom CREATED: ");
            sb.append(this.f2641c);
        }
        Fragment fragment = this.f2641c;
        boolean zIsChangingConfigurations = true;
        boolean z2 = fragment.f2698m && !fragment.Z();
        if (z2) {
            Fragment fragment2 = this.f2641c;
            if (!fragment2.f2699n) {
                this.f2640b.B(fragment2.f2691f, null);
            }
        }
        if (!z2 && !this.f2640b.p().q(this.f2641c)) {
            String str = this.f2641c.f2694i;
            if (str != null && (fragmentF = this.f2640b.f(str)) != null && fragmentF.f2661C) {
                this.f2641c.f2693h = fragmentF;
            }
            this.f2641c.f2685a = 0;
            return;
        }
        p pVar = this.f2641c.f2706u;
        if (pVar instanceof androidx.lifecycle.E) {
            zIsChangingConfigurations = this.f2640b.p().n();
        } else if (pVar.o() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) pVar.o()).isChangingConfigurations();
        }
        if ((z2 && !this.f2641c.f2699n) || zIsChangingConfigurations) {
            this.f2640b.p().f(this.f2641c);
        }
        this.f2641c.U0();
        this.f2639a.d(this.f2641c, false);
        for (D d2 : this.f2640b.k()) {
            if (d2 != null) {
                Fragment fragmentK = d2.k();
                if (this.f2641c.f2691f.equals(fragmentK.f2694i)) {
                    fragmentK.f2693h = this.f2641c;
                    fragmentK.f2694i = null;
                }
            }
        }
        Fragment fragment3 = this.f2641c;
        String str2 = fragment3.f2694i;
        if (str2 != null) {
            fragment3.f2693h = this.f2640b.f(str2);
        }
        this.f2640b.s(this);
    }

    void h() {
        View view;
        if (x.H0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom CREATE_VIEW: ");
            sb.append(this.f2641c);
        }
        Fragment fragment = this.f2641c;
        ViewGroup viewGroup = fragment.f2666H;
        if (viewGroup != null && (view = fragment.f2667I) != null) {
            viewGroup.removeView(view);
        }
        this.f2641c.V0();
        this.f2639a.n(this.f2641c, false);
        Fragment fragment2 = this.f2641c;
        fragment2.f2666H = null;
        fragment2.f2667I = null;
        fragment2.f2678T = null;
        fragment2.f2679U.i(null);
        this.f2641c.f2701p = false;
    }

    void i() {
        if (x.H0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom ATTACHED: ");
            sb.append(this.f2641c);
        }
        this.f2641c.W0();
        this.f2639a.e(this.f2641c, false);
        Fragment fragment = this.f2641c;
        fragment.f2685a = -1;
        fragment.f2706u = null;
        fragment.f2708w = null;
        fragment.f2705t = null;
        if ((!fragment.f2698m || fragment.Z()) && !this.f2640b.p().q(this.f2641c)) {
            return;
        }
        if (x.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("initState called for fragment: ");
            sb2.append(this.f2641c);
        }
        this.f2641c.V();
    }

    void j() {
        Fragment fragment = this.f2641c;
        if (fragment.f2700o && fragment.f2701p && !fragment.f2703r) {
            if (x.H0(3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("moveto CREATE_VIEW: ");
                sb.append(this.f2641c);
            }
            Fragment fragment2 = this.f2641c;
            fragment2.T0(fragment2.X0(fragment2.f2687b), null, this.f2641c.f2687b);
            View view = this.f2641c.f2667I;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f2641c;
                fragment3.f2667I.setTag(R$id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f2641c;
                if (fragment4.f2659A) {
                    fragment4.f2667I.setVisibility(8);
                }
                this.f2641c.k1();
                r rVar = this.f2639a;
                Fragment fragment5 = this.f2641c;
                rVar.m(fragment5, fragment5.f2667I, fragment5.f2687b, false);
                this.f2641c.f2685a = 2;
            }
        }
    }

    Fragment k() {
        return this.f2641c;
    }

    void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f2642d) {
            if (x.H0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Ignoring re-entrant call to moveToExpectedState() for ");
                sb.append(k());
                return;
            }
            return;
        }
        try {
            this.f2642d = true;
            boolean z2 = false;
            while (true) {
                int iD = d();
                Fragment fragment = this.f2641c;
                int i2 = fragment.f2685a;
                if (iD == i2) {
                    if (!z2 && i2 == -1 && fragment.f2698m && !fragment.Z() && !this.f2641c.f2699n) {
                        if (x.H0(3)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Cleaning up state of never attached fragment: ");
                            sb2.append(this.f2641c);
                        }
                        this.f2640b.p().f(this.f2641c);
                        this.f2640b.s(this);
                        if (x.H0(3)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("initState called for fragment: ");
                            sb3.append(this.f2641c);
                        }
                        this.f2641c.V();
                    }
                    Fragment fragment2 = this.f2641c;
                    if (fragment2.f2672N) {
                        if (fragment2.f2667I != null && (viewGroup = fragment2.f2666H) != null) {
                            M mN = M.n(viewGroup, fragment2.D());
                            if (this.f2641c.f2659A) {
                                mN.c(this);
                            } else {
                                mN.e(this);
                            }
                        }
                        Fragment fragment3 = this.f2641c;
                        x xVar = fragment3.f2705t;
                        if (xVar != null) {
                            xVar.F0(fragment3);
                        }
                        Fragment fragment4 = this.f2641c;
                        fragment4.f2672N = false;
                        fragment4.w0(fragment4.f2659A);
                        this.f2641c.f2707v.I();
                    }
                    this.f2642d = false;
                    return;
                }
                if (iD <= i2) {
                    switch (i2 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            if (fragment.f2699n && this.f2640b.q(fragment.f2691f) == null) {
                                s();
                            }
                            g();
                            break;
                        case 1:
                            h();
                            this.f2641c.f2685a = 1;
                            break;
                        case 2:
                            fragment.f2701p = false;
                            fragment.f2685a = 2;
                            break;
                        case 3:
                            if (x.H0(3)) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("movefrom ACTIVITY_CREATED: ");
                                sb4.append(this.f2641c);
                            }
                            Fragment fragment5 = this.f2641c;
                            if (fragment5.f2699n) {
                                s();
                            } else if (fragment5.f2667I != null && fragment5.f2688c == null) {
                                t();
                            }
                            Fragment fragment6 = this.f2641c;
                            if (fragment6.f2667I != null && (viewGroup2 = fragment6.f2666H) != null) {
                                M.n(viewGroup2, fragment6.D()).d(this);
                            }
                            this.f2641c.f2685a = 3;
                            break;
                        case 4:
                            w();
                            break;
                        case 5:
                            fragment.f2685a = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i2 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.f2667I != null && (viewGroup3 = fragment.f2666H) != null) {
                                M.n(viewGroup3, fragment.D()).b(M.e.c.b(this.f2641c.f2667I.getVisibility()), this);
                            }
                            this.f2641c.f2685a = 4;
                            break;
                        case 5:
                            v();
                            break;
                        case 6:
                            fragment.f2685a = 6;
                            break;
                        case Console.MAX_CONSOLE /* 7 */:
                            p();
                            break;
                    }
                }
                z2 = true;
            }
        } catch (Throwable th) {
            this.f2642d = false;
            throw th;
        }
    }

    void n() {
        if (x.H0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom RESUMED: ");
            sb.append(this.f2641c);
        }
        this.f2641c.c1();
        this.f2639a.f(this.f2641c, false);
    }

    void o(ClassLoader classLoader) {
        Bundle bundle = this.f2641c.f2687b;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f2641c;
        fragment.f2688c = fragment.f2687b.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f2641c;
        fragment2.f2689d = fragment2.f2687b.getBundle("android:view_registry_state");
        Fragment fragment3 = this.f2641c;
        fragment3.f2694i = fragment3.f2687b.getString("android:target_state");
        Fragment fragment4 = this.f2641c;
        if (fragment4.f2694i != null) {
            fragment4.f2695j = fragment4.f2687b.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.f2641c;
        Boolean bool = fragment5.f2690e;
        if (bool != null) {
            fragment5.f2669K = bool.booleanValue();
            this.f2641c.f2690e = null;
        } else {
            fragment5.f2669K = fragment5.f2687b.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.f2641c;
        if (fragment6.f2669K) {
            return;
        }
        fragment6.f2668J = true;
    }

    void p() {
        if (x.H0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto RESUMED: ");
            sb.append(this.f2641c);
        }
        View viewV = this.f2641c.v();
        if (viewV != null && l(viewV)) {
            boolean zRequestFocus = viewV.requestFocus();
            if (x.H0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("requestFocus: Restoring focused view ");
                sb2.append(viewV);
                sb2.append(" ");
                sb2.append(zRequestFocus ? "succeeded" : "failed");
                sb2.append(" on Fragment ");
                sb2.append(this.f2641c);
                sb2.append(" resulting in focused view ");
                sb2.append(this.f2641c.f2667I.findFocus());
            }
        }
        this.f2641c.u1(null);
        this.f2641c.g1();
        this.f2639a.i(this.f2641c, false);
        Fragment fragment = this.f2641c;
        fragment.f2687b = null;
        fragment.f2688c = null;
        fragment.f2689d = null;
    }

    Fragment.j r() {
        Bundle bundleQ;
        if (this.f2641c.f2685a <= -1 || (bundleQ = q()) == null) {
            return null;
        }
        return new Fragment.j(bundleQ);
    }

    void s() {
        C c2 = new C(this.f2641c);
        Fragment fragment = this.f2641c;
        if (fragment.f2685a <= -1 || c2.f2638m != null) {
            c2.f2638m = fragment.f2687b;
        } else {
            Bundle bundleQ = q();
            c2.f2638m = bundleQ;
            if (this.f2641c.f2694i != null) {
                if (bundleQ == null) {
                    c2.f2638m = new Bundle();
                }
                c2.f2638m.putString("android:target_state", this.f2641c.f2694i);
                int i2 = this.f2641c.f2695j;
                if (i2 != 0) {
                    c2.f2638m.putInt("android:target_req_state", i2);
                }
            }
        }
        this.f2640b.B(this.f2641c.f2691f, c2);
    }

    void t() {
        if (this.f2641c.f2667I == null) {
            return;
        }
        if (x.H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Saving view state for fragment ");
            sb.append(this.f2641c);
            sb.append(" with view ");
            sb.append(this.f2641c.f2667I);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f2641c.f2667I.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f2641c.f2688c = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f2641c.f2678T.h(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f2641c.f2689d = bundle;
    }

    void u(int i2) {
        this.f2643e = i2;
    }

    void v() {
        if (x.H0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto STARTED: ");
            sb.append(this.f2641c);
        }
        this.f2641c.i1();
        this.f2639a.k(this.f2641c, false);
    }

    void w() {
        if (x.H0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom STARTED: ");
            sb.append(this.f2641c);
        }
        this.f2641c.j1();
        this.f2639a.l(this.f2641c, false);
    }

    D(r rVar, F f2, Fragment fragment, C c2) {
        this.f2639a = rVar;
        this.f2640b = f2;
        this.f2641c = fragment;
        fragment.f2688c = null;
        fragment.f2689d = null;
        fragment.f2704s = 0;
        fragment.f2701p = false;
        fragment.f2697l = false;
        Fragment fragment2 = fragment.f2693h;
        fragment.f2694i = fragment2 != null ? fragment2.f2691f : null;
        fragment.f2693h = null;
        Bundle bundle = c2.f2638m;
        fragment.f2687b = bundle == null ? new Bundle() : bundle;
    }

    D(r rVar, F f2, ClassLoader classLoader, AbstractC0176o abstractC0176o, C c2) {
        this.f2639a = rVar;
        this.f2640b = f2;
        Fragment fragmentA = c2.a(abstractC0176o, classLoader);
        this.f2641c = fragmentA;
        if (x.H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Instantiated fragment ");
            sb.append(fragmentA);
        }
    }
}
