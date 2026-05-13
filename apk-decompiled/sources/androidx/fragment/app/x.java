package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.f;
import androidx.core.view.InterfaceC0157v;
import androidx.core.view.InterfaceC0160y;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.G;
import androidx.lifecycle.AbstractC0183g;
import c.AbstractC0186a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import o.InterfaceC0232a;
import x.C0265c;

/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private static boolean f2957S = false;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private androidx.activity.result.c f2961D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private androidx.activity.result.c f2962E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private androidx.activity.result.c f2963F;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private boolean f2965H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private boolean f2966I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f2967J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private boolean f2968K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private boolean f2969L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private ArrayList f2970M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private ArrayList f2971N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private ArrayList f2972O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private A f2973P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private C0265c.C0075c f2974Q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2977b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ArrayList f2979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList f2980e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private OnBackPressedDispatcher f2982g;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ArrayList f2988m;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private p f2997v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private AbstractC0173l f2998w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Fragment f2999x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Fragment f3000y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f2976a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final F f2978c = new F();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final q f2981f = new q(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final androidx.activity.m f2983h = new b(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicInteger f2984i = new AtomicInteger();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f2985j = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map f2986k = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Map f2987l = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final r f2989n = new r(this);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final CopyOnWriteArrayList f2990o = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final InterfaceC0232a f2991p = new InterfaceC0232a() { // from class: androidx.fragment.app.s
        @Override // o.InterfaceC0232a
        public final void a(Object obj) {
            this.f2952a.Q0((Configuration) obj);
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final InterfaceC0232a f2992q = new InterfaceC0232a() { // from class: androidx.fragment.app.t
        @Override // o.InterfaceC0232a
        public final void a(Object obj) {
            this.f2953a.R0((Integer) obj);
        }
    };

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final InterfaceC0232a f2993r = new InterfaceC0232a() { // from class: androidx.fragment.app.u
        @Override // o.InterfaceC0232a
        public final void a(Object obj) {
            this.f2954a.S0((androidx.core.app.h) obj);
        }
    };

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final InterfaceC0232a f2994s = new InterfaceC0232a() { // from class: androidx.fragment.app.v
        @Override // o.InterfaceC0232a
        public final void a(Object obj) {
            this.f2955a.T0((androidx.core.app.q) obj);
        }
    };

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final InterfaceC0160y f2995t = new c();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f2996u = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private AbstractC0176o f3001z = null;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private AbstractC0176o f2958A = new d();

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private N f2959B = null;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private N f2960C = new e();

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    ArrayDeque f2964G = new ArrayDeque();

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private Runnable f2975R = new f();

    class a implements androidx.activity.result.b {
        a() {
        }

        @Override // androidx.activity.result.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Boolean) arrayList.get(i2)).booleanValue() ? 0 : -1;
            }
            k kVar = (k) x.this.f2964G.pollFirst();
            if (kVar == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("No permissions were requested for ");
                sb.append(this);
                return;
            }
            String str = kVar.f3012a;
            int i3 = kVar.f3013b;
            Fragment fragmentI = x.this.f2978c.i(str);
            if (fragmentI != null) {
                fragmentI.G0(i3, strArr, iArr);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Permission request result delivered for unknown Fragment ");
            sb2.append(str);
        }
    }

    class b extends androidx.activity.m {
        b(boolean z2) {
            super(z2);
        }

        @Override // androidx.activity.m
        public void b() {
            x.this.D0();
        }
    }

    class c implements InterfaceC0160y {
        c() {
        }

        @Override // androidx.core.view.InterfaceC0160y
        public void a(Menu menu, MenuInflater menuInflater) {
            x.this.C(menu, menuInflater);
        }

        @Override // androidx.core.view.InterfaceC0160y
        public void b(Menu menu) {
            x.this.O(menu);
        }

        @Override // androidx.core.view.InterfaceC0160y
        public boolean c(MenuItem menuItem) {
            return x.this.J(menuItem);
        }

        @Override // androidx.core.view.InterfaceC0160y
        public void d(Menu menu) {
            x.this.K(menu);
        }
    }

    class d extends AbstractC0176o {
        d() {
        }

        @Override // androidx.fragment.app.AbstractC0176o
        public Fragment a(ClassLoader classLoader, String str) {
            return x.this.u0().b(x.this.u0().o(), str, null);
        }
    }

    class e implements N {
        e() {
        }

        @Override // androidx.fragment.app.N
        public M a(ViewGroup viewGroup) {
            return new C0165d(viewGroup);
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x.this.a0(true);
        }
    }

    class g implements B {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f3008a;

        g(Fragment fragment) {
            this.f3008a = fragment;
        }

        @Override // androidx.fragment.app.B
        public void a(x xVar, Fragment fragment) {
            this.f3008a.k0(fragment);
        }
    }

    class h implements androidx.activity.result.b {
        h() {
        }

        @Override // androidx.activity.result.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.activity.result.a aVar) {
            k kVar = (k) x.this.f2964G.pollFirst();
            if (kVar == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("No Activities were started for result for ");
                sb.append(this);
                return;
            }
            String str = kVar.f3012a;
            int i2 = kVar.f3013b;
            Fragment fragmentI = x.this.f2978c.i(str);
            if (fragmentI != null) {
                fragmentI.h0(i2, aVar.b(), aVar.a());
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Activity result delivered for unknown Fragment ");
            sb2.append(str);
        }
    }

    class i implements androidx.activity.result.b {
        i() {
        }

        @Override // androidx.activity.result.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.activity.result.a aVar) {
            k kVar = (k) x.this.f2964G.pollFirst();
            if (kVar == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("No IntentSenders were started for ");
                sb.append(this);
                return;
            }
            String str = kVar.f3012a;
            int i2 = kVar.f3013b;
            Fragment fragmentI = x.this.f2978c.i(str);
            if (fragmentI != null) {
                fragmentI.h0(i2, aVar.b(), aVar.a());
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Intent Sender result delivered for unknown Fragment ");
            sb2.append(str);
        }
    }

    static class j extends AbstractC0186a {
        j() {
        }

        @Override // c.AbstractC0186a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, androidx.activity.result.f fVar) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intentA = fVar.a();
            if (intentA != null && (bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intentA.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    fVar = new f.a(fVar.d()).b(null).c(fVar.c(), fVar.b()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", fVar);
            if (x.H0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("CreateIntent created the following intent: ");
                sb.append(intent);
            }
            return intent;
        }

        @Override // c.AbstractC0186a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public androidx.activity.result.a c(int i2, Intent intent) {
            return new androidx.activity.result.a(i2, intent);
        }
    }

    static class k implements Parcelable {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f3012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3013b;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public k createFromParcel(Parcel parcel) {
                return new k(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public k[] newArray(int i2) {
                return new k[i2];
            }
        }

        k(Parcel parcel) {
            this.f3012a = parcel.readString();
            this.f3013b = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f3012a);
            parcel.writeInt(this.f3013b);
        }

        k(String str, int i2) {
            this.f3012a = str;
            this.f3013b = i2;
        }
    }

    interface l {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    private class m implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f3014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f3015b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f3016c;

        m(String str, int i2, int i3) {
            this.f3014a = str;
            this.f3015b = i2;
            this.f3016c = i3;
        }

        @Override // androidx.fragment.app.x.l
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            Fragment fragment = x.this.f3000y;
            if (fragment == null || this.f3015b >= 0 || this.f3014a != null || !fragment.n().a1()) {
                return x.this.d1(arrayList, arrayList2, this.f3014a, this.f3015b, this.f3016c);
            }
            return false;
        }
    }

    static Fragment B0(View view) {
        Object tag = view.getTag(R$id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public static boolean H0(int i2) {
        return f2957S || Log.isLoggable("FragmentManager", i2);
    }

    private boolean I0(Fragment fragment) {
        return (fragment.f2663E && fragment.f2664F) || fragment.f2707v.p();
    }

    private boolean J0() {
        Fragment fragment = this.f2999x;
        if (fragment == null) {
            return true;
        }
        return fragment.X() && this.f2999x.D().J0();
    }

    private void L(Fragment fragment) {
        if (fragment == null || !fragment.equals(e0(fragment.f2691f))) {
            return;
        }
        fragment.f1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(Configuration configuration) {
        if (J0()) {
            z(configuration, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(Integer num) {
        if (J0() && num.intValue() == 80) {
            F(false);
        }
    }

    private void S(int i2) {
        try {
            this.f2977b = true;
            this.f2978c.d(i2);
            V0(i2, false);
            Iterator it2 = t().iterator();
            while (it2.hasNext()) {
                ((M) it2.next()).j();
            }
            this.f2977b = false;
            a0(true);
        } catch (Throwable th) {
            this.f2977b = false;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(androidx.core.app.h hVar) {
        if (J0()) {
            G(hVar.a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(androidx.core.app.q qVar) {
        if (J0()) {
            N(qVar.a(), false);
        }
    }

    private void V() {
        if (this.f2969L) {
            this.f2969L = false;
            r1();
        }
    }

    private void X() {
        Iterator it2 = t().iterator();
        while (it2.hasNext()) {
            ((M) it2.next()).j();
        }
    }

    private void Z(boolean z2) {
        if (this.f2977b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f2997v == null) {
            if (!this.f2968K) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f2997v.p().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z2) {
            q();
        }
        if (this.f2970M == null) {
            this.f2970M = new ArrayList();
            this.f2971N = new ArrayList();
        }
    }

    private static void c0(ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        while (i2 < i3) {
            C0162a c0162a = (C0162a) arrayList.get(i2);
            if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                c0162a.r(-1);
                c0162a.w();
            } else {
                c0162a.r(1);
                c0162a.v();
            }
            i2++;
        }
    }

    private boolean c1(String str, int i2, int i3) {
        a0(false);
        Z(true);
        Fragment fragment = this.f3000y;
        if (fragment != null && i2 < 0 && str == null && fragment.n().a1()) {
            return true;
        }
        boolean zD1 = d1(this.f2970M, this.f2971N, str, i2, i3);
        if (zD1) {
            this.f2977b = true;
            try {
                f1(this.f2970M, this.f2971N);
            } finally {
                r();
            }
        }
        t1();
        V();
        this.f2978c.b();
        return zD1;
    }

    private void d0(ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        boolean z2 = ((C0162a) arrayList.get(i2)).f2760r;
        ArrayList arrayList3 = this.f2972O;
        if (arrayList3 == null) {
            this.f2972O = new ArrayList();
        } else {
            arrayList3.clear();
        }
        this.f2972O.addAll(this.f2978c.o());
        Fragment fragmentY0 = y0();
        boolean z3 = false;
        for (int i4 = i2; i4 < i3; i4++) {
            C0162a c0162a = (C0162a) arrayList.get(i4);
            fragmentY0 = !((Boolean) arrayList2.get(i4)).booleanValue() ? c0162a.x(this.f2972O, fragmentY0) : c0162a.A(this.f2972O, fragmentY0);
            z3 = z3 || c0162a.f2751i;
        }
        this.f2972O.clear();
        if (!z2 && this.f2996u >= 1) {
            for (int i5 = i2; i5 < i3; i5++) {
                Iterator it2 = ((C0162a) arrayList.get(i5)).f2745c.iterator();
                while (it2.hasNext()) {
                    Fragment fragment = ((G.a) it2.next()).f2763b;
                    if (fragment != null && fragment.f2705t != null) {
                        this.f2978c.r(v(fragment));
                    }
                }
            }
        }
        c0(arrayList, arrayList2, i2, i3);
        boolean zBooleanValue = ((Boolean) arrayList2.get(i3 - 1)).booleanValue();
        for (int i6 = i2; i6 < i3; i6++) {
            C0162a c0162a2 = (C0162a) arrayList.get(i6);
            if (zBooleanValue) {
                for (int size = c0162a2.f2745c.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = ((G.a) c0162a2.f2745c.get(size)).f2763b;
                    if (fragment2 != null) {
                        v(fragment2).m();
                    }
                }
            } else {
                Iterator it3 = c0162a2.f2745c.iterator();
                while (it3.hasNext()) {
                    Fragment fragment3 = ((G.a) it3.next()).f2763b;
                    if (fragment3 != null) {
                        v(fragment3).m();
                    }
                }
            }
        }
        V0(this.f2996u, true);
        for (M m2 : u(arrayList, i2, i3)) {
            m2.r(zBooleanValue);
            m2.p();
            m2.g();
        }
        while (i2 < i3) {
            C0162a c0162a3 = (C0162a) arrayList.get(i2);
            if (((Boolean) arrayList2.get(i2)).booleanValue() && c0162a3.f2832v >= 0) {
                c0162a3.f2832v = -1;
            }
            c0162a3.z();
            i2++;
        }
        if (z3) {
            g1();
        }
    }

    private int f0(String str, int i2, boolean z2) {
        ArrayList arrayList = this.f2979d;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str == null && i2 < 0) {
            if (z2) {
                return 0;
            }
            return this.f2979d.size() - 1;
        }
        int size = this.f2979d.size() - 1;
        while (size >= 0) {
            C0162a c0162a = (C0162a) this.f2979d.get(size);
            if ((str != null && str.equals(c0162a.y())) || (i2 >= 0 && i2 == c0162a.f2832v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z2) {
            if (size == this.f2979d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            C0162a c0162a2 = (C0162a) this.f2979d.get(size - 1);
            if ((str == null || !str.equals(c0162a2.y())) && (i2 < 0 || i2 != c0162a2.f2832v)) {
                return size;
            }
            size--;
        }
        return size;
    }

    private void f1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!((C0162a) arrayList.get(i2)).f2760r) {
                if (i3 != i2) {
                    d0(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                    while (i3 < size && ((Boolean) arrayList2.get(i3)).booleanValue() && !((C0162a) arrayList.get(i3)).f2760r) {
                        i3++;
                    }
                }
                d0(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 != size) {
            d0(arrayList, arrayList2, i3, size);
        }
    }

    private void g1() {
        ArrayList arrayList = this.f2988m;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        android.support.v4.media.session.b.a(this.f2988m.get(0));
        throw null;
    }

    static int i1(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 == 8194) {
            return 4097;
        }
        if (i2 == 8197) {
            return 4100;
        }
        if (i2 != 4099) {
            return i2 != 4100 ? 0 : 8197;
        }
        return 4099;
    }

    static x j0(View view) {
        AbstractActivityC0171j abstractActivityC0171j;
        Fragment fragmentK0 = k0(view);
        if (fragmentK0 != null) {
            if (fragmentK0.X()) {
                return fragmentK0.n();
            }
            throw new IllegalStateException("The Fragment " + fragmentK0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                abstractActivityC0171j = null;
                break;
            }
            if (context instanceof AbstractActivityC0171j) {
                abstractActivityC0171j = (AbstractActivityC0171j) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (abstractActivityC0171j != null) {
            return abstractActivityC0171j.f0();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    private static Fragment k0(View view) {
        while (view != null) {
            Fragment fragmentB0 = B0(view);
            if (fragmentB0 != null) {
                return fragmentB0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    private void l0() {
        Iterator it2 = t().iterator();
        while (it2.hasNext()) {
            ((M) it2.next()).k();
        }
    }

    private boolean m0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.f2976a) {
            if (this.f2976a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f2976a.size();
                boolean zA = false;
                for (int i2 = 0; i2 < size; i2++) {
                    zA |= ((l) this.f2976a.get(i2)).a(arrayList, arrayList2);
                }
                return zA;
            } finally {
                this.f2976a.clear();
                this.f2997v.p().removeCallbacks(this.f2975R);
            }
        }
    }

    private A o0(Fragment fragment) {
        return this.f2973P.j(fragment);
    }

    private void p1(Fragment fragment) {
        ViewGroup viewGroupR0 = r0(fragment);
        if (viewGroupR0 == null || fragment.p() + fragment.s() + fragment.F() + fragment.H() <= 0) {
            return;
        }
        if (viewGroupR0.getTag(R$id.visible_removing_fragment_view_tag) == null) {
            viewGroupR0.setTag(R$id.visible_removing_fragment_view_tag, fragment);
        }
        ((Fragment) viewGroupR0.getTag(R$id.visible_removing_fragment_view_tag)).z1(fragment.E());
    }

    private void q() {
        if (O0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void r() {
        this.f2977b = false;
        this.f2971N.clear();
        this.f2970M.clear();
    }

    private ViewGroup r0(Fragment fragment) {
        ViewGroup viewGroup = fragment.f2666H;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.f2710y > 0 && this.f2998w.j()) {
            View viewE = this.f2998w.e(fragment.f2710y);
            if (viewE instanceof ViewGroup) {
                return (ViewGroup) viewE;
            }
        }
        return null;
    }

    private void r1() {
        Iterator it2 = this.f2978c.k().iterator();
        while (it2.hasNext()) {
            Y0((D) it2.next());
        }
    }

    private void s() {
        p pVar = this.f2997v;
        if (pVar instanceof androidx.lifecycle.E ? this.f2978c.p().n() : pVar.o() instanceof Activity ? !((Activity) this.f2997v.o()).isChangingConfigurations() : true) {
            Iterator it2 = this.f2985j.values().iterator();
            while (it2.hasNext()) {
                Iterator it3 = ((C0164c) it2.next()).f2848a.iterator();
                while (it3.hasNext()) {
                    this.f2978c.p().g((String) it3.next());
                }
            }
        }
    }

    private void s1(RuntimeException runtimeException) {
        runtimeException.getMessage();
        PrintWriter printWriter = new PrintWriter(new L("FragmentManager"));
        p pVar = this.f2997v;
        try {
            if (pVar != null) {
                pVar.q("  ", null, printWriter, new String[0]);
            } else {
                W("  ", null, printWriter, new String[0]);
            }
            throw runtimeException;
        } catch (Exception unused) {
            throw runtimeException;
        }
    }

    private Set t() {
        HashSet hashSet = new HashSet();
        Iterator it2 = this.f2978c.k().iterator();
        while (it2.hasNext()) {
            ViewGroup viewGroup = ((D) it2.next()).k().f2666H;
            if (viewGroup != null) {
                hashSet.add(M.o(viewGroup, z0()));
            }
        }
        return hashSet;
    }

    private void t1() {
        synchronized (this.f2976a) {
            try {
                if (this.f2976a.isEmpty()) {
                    this.f2983h.f(n0() > 0 && M0(this.f2999x));
                } else {
                    this.f2983h.f(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private Set u(ArrayList arrayList, int i2, int i3) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i2 < i3) {
            Iterator it2 = ((C0162a) arrayList.get(i2)).f2745c.iterator();
            while (it2.hasNext()) {
                Fragment fragment = ((G.a) it2.next()).f2763b;
                if (fragment != null && (viewGroup = fragment.f2666H) != null) {
                    hashSet.add(M.n(viewGroup, this));
                }
            }
            i2++;
        }
        return hashSet;
    }

    boolean A(MenuItem menuItem) {
        if (this.f2996u < 1) {
            return false;
        }
        for (Fragment fragment : this.f2978c.o()) {
            if (fragment != null && fragment.Q0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public C0265c.C0075c A0() {
        return this.f2974Q;
    }

    void B() {
        this.f2966I = false;
        this.f2967J = false;
        this.f2973P.p(false);
        S(1);
    }

    boolean C(Menu menu, MenuInflater menuInflater) {
        if (this.f2996u < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z2 = false;
        for (Fragment fragment : this.f2978c.o()) {
            if (fragment != null && L0(fragment) && fragment.S0(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z2 = true;
            }
        }
        if (this.f2980e != null) {
            for (int i2 = 0; i2 < this.f2980e.size(); i2++) {
                Fragment fragment2 = (Fragment) this.f2980e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.s0();
                }
            }
        }
        this.f2980e = arrayList;
        return z2;
    }

    androidx.lifecycle.D C0(Fragment fragment) {
        return this.f2973P.m(fragment);
    }

    void D() {
        this.f2968K = true;
        a0(true);
        X();
        s();
        S(-1);
        Object obj = this.f2997v;
        if (obj instanceof androidx.core.content.c) {
            ((androidx.core.content.c) obj).y(this.f2992q);
        }
        Object obj2 = this.f2997v;
        if (obj2 instanceof androidx.core.content.b) {
            ((androidx.core.content.b) obj2).h(this.f2991p);
        }
        Object obj3 = this.f2997v;
        if (obj3 instanceof androidx.core.app.o) {
            ((androidx.core.app.o) obj3).m(this.f2993r);
        }
        Object obj4 = this.f2997v;
        if (obj4 instanceof androidx.core.app.p) {
            ((androidx.core.app.p) obj4).g(this.f2994s);
        }
        Object obj5 = this.f2997v;
        if (obj5 instanceof InterfaceC0157v) {
            ((InterfaceC0157v) obj5).i(this.f2995t);
        }
        this.f2997v = null;
        this.f2998w = null;
        this.f2999x = null;
        if (this.f2982g != null) {
            this.f2983h.d();
            this.f2982g = null;
        }
        androidx.activity.result.c cVar = this.f2961D;
        if (cVar != null) {
            cVar.c();
            this.f2962E.c();
            this.f2963F.c();
        }
    }

    void D0() {
        a0(true);
        if (this.f2983h.c()) {
            a1();
        } else {
            this.f2982g.e();
        }
    }

    void E() {
        S(1);
    }

    void E0(Fragment fragment) {
        if (H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("hide: ");
            sb.append(fragment);
        }
        if (fragment.f2659A) {
            return;
        }
        fragment.f2659A = true;
        fragment.f2672N = true ^ fragment.f2672N;
        p1(fragment);
    }

    void F(boolean z2) {
        if (z2 && (this.f2997v instanceof androidx.core.content.c)) {
            s1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment fragment : this.f2978c.o()) {
            if (fragment != null) {
                fragment.Y0();
                if (z2) {
                    fragment.f2707v.F(true);
                }
            }
        }
    }

    void F0(Fragment fragment) {
        if (fragment.f2697l && I0(fragment)) {
            this.f2965H = true;
        }
    }

    void G(boolean z2, boolean z3) {
        if (z3 && (this.f2997v instanceof androidx.core.app.o)) {
            s1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment fragment : this.f2978c.o()) {
            if (fragment != null) {
                fragment.Z0(z2);
                if (z3) {
                    fragment.f2707v.G(z2, true);
                }
            }
        }
    }

    public boolean G0() {
        return this.f2968K;
    }

    void H(Fragment fragment) {
        Iterator it2 = this.f2990o.iterator();
        while (it2.hasNext()) {
            ((B) it2.next()).a(this, fragment);
        }
    }

    void I() {
        for (Fragment fragment : this.f2978c.l()) {
            if (fragment != null) {
                fragment.w0(fragment.Y());
                fragment.f2707v.I();
            }
        }
    }

    boolean J(MenuItem menuItem) {
        if (this.f2996u < 1) {
            return false;
        }
        for (Fragment fragment : this.f2978c.o()) {
            if (fragment != null && fragment.a1(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void K(Menu menu) {
        if (this.f2996u < 1) {
            return;
        }
        for (Fragment fragment : this.f2978c.o()) {
            if (fragment != null) {
                fragment.b1(menu);
            }
        }
    }

    boolean K0(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.Y();
    }

    boolean L0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.a0();
    }

    void M() {
        S(5);
    }

    boolean M0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        x xVar = fragment.f2705t;
        return fragment.equals(xVar.y0()) && M0(xVar.f2999x);
    }

    void N(boolean z2, boolean z3) {
        if (z3 && (this.f2997v instanceof androidx.core.app.p)) {
            s1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment fragment : this.f2978c.o()) {
            if (fragment != null) {
                fragment.d1(z2);
                if (z3) {
                    fragment.f2707v.N(z2, true);
                }
            }
        }
    }

    boolean N0(int i2) {
        return this.f2996u >= i2;
    }

    boolean O(Menu menu) {
        boolean z2 = false;
        if (this.f2996u < 1) {
            return false;
        }
        for (Fragment fragment : this.f2978c.o()) {
            if (fragment != null && L0(fragment) && fragment.e1(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    public boolean O0() {
        return this.f2966I || this.f2967J;
    }

    void P() {
        t1();
        L(this.f3000y);
    }

    void Q() {
        this.f2966I = false;
        this.f2967J = false;
        this.f2973P.p(false);
        S(7);
    }

    void R() {
        this.f2966I = false;
        this.f2967J = false;
        this.f2973P.p(false);
        S(5);
    }

    void T() {
        this.f2967J = true;
        this.f2973P.p(true);
        S(4);
    }

    void U() {
        S(2);
    }

    void U0(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        if (this.f2961D == null) {
            this.f2997v.u(fragment, intent, i2, bundle);
            return;
        }
        this.f2964G.addLast(new k(fragment.f2691f, i2));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.f2961D.a(intent);
    }

    void V0(int i2, boolean z2) {
        p pVar;
        if (this.f2997v == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z2 || i2 != this.f2996u) {
            this.f2996u = i2;
            this.f2978c.t();
            r1();
            if (this.f2965H && (pVar = this.f2997v) != null && this.f2996u == 7) {
                pVar.v();
                this.f2965H = false;
            }
        }
    }

    public void W(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f2978c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.f2980e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                Fragment fragment = (Fragment) this.f2980e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList arrayList2 = this.f2979d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                C0162a c0162a = (C0162a) this.f2979d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(c0162a.toString());
                c0162a.t(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f2984i.get());
        synchronized (this.f2976a) {
            try {
                int size3 = this.f2976a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size3; i4++) {
                        l lVar = (l) this.f2976a.get(i4);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println(lVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f2997v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f2998w);
        if (this.f2999x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f2999x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f2996u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f2966I);
        printWriter.print(" mStopped=");
        printWriter.print(this.f2967J);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f2968K);
        if (this.f2965H) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f2965H);
        }
    }

    void W0() {
        if (this.f2997v == null) {
            return;
        }
        this.f2966I = false;
        this.f2967J = false;
        this.f2973P.p(false);
        for (Fragment fragment : this.f2978c.o()) {
            if (fragment != null) {
                fragment.f0();
            }
        }
    }

    void X0(C0174m c0174m) {
        View view;
        for (D d2 : this.f2978c.k()) {
            Fragment fragmentK = d2.k();
            if (fragmentK.f2710y == c0174m.getId() && (view = fragmentK.f2667I) != null && view.getParent() == null) {
                fragmentK.f2666H = c0174m;
                d2.b();
            }
        }
    }

    void Y(l lVar, boolean z2) {
        if (!z2) {
            if (this.f2997v == null) {
                if (!this.f2968K) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            q();
        }
        synchronized (this.f2976a) {
            try {
                if (this.f2997v == null) {
                    if (!z2) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f2976a.add(lVar);
                    l1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void Y0(D d2) {
        Fragment fragmentK = d2.k();
        if (fragmentK.f2668J) {
            if (this.f2977b) {
                this.f2969L = true;
            } else {
                fragmentK.f2668J = false;
                d2.m();
            }
        }
    }

    void Z0(int i2, int i3, boolean z2) {
        if (i2 >= 0) {
            Y(new m(null, i2, i3), z2);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    boolean a0(boolean z2) {
        Z(z2);
        boolean z3 = false;
        while (m0(this.f2970M, this.f2971N)) {
            z3 = true;
            this.f2977b = true;
            try {
                f1(this.f2970M, this.f2971N);
            } finally {
                r();
            }
        }
        t1();
        V();
        this.f2978c.b();
        return z3;
    }

    public boolean a1() {
        return c1(null, -1, 0);
    }

    void b0(l lVar, boolean z2) {
        if (z2 && (this.f2997v == null || this.f2968K)) {
            return;
        }
        Z(z2);
        if (lVar.a(this.f2970M, this.f2971N)) {
            this.f2977b = true;
            try {
                f1(this.f2970M, this.f2971N);
            } finally {
                r();
            }
        }
        t1();
        V();
        this.f2978c.b();
    }

    public boolean b1(int i2, int i3) {
        if (i2 >= 0) {
            return c1(null, i2, i3);
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    boolean d1(ArrayList arrayList, ArrayList arrayList2, String str, int i2, int i3) {
        int iF0 = f0(str, i2, (i3 & 1) != 0);
        if (iF0 < 0) {
            return false;
        }
        for (int size = this.f2979d.size() - 1; size >= iF0; size--) {
            arrayList.add((C0162a) this.f2979d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    Fragment e0(String str) {
        return this.f2978c.f(str);
    }

    void e1(Fragment fragment) {
        if (H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("remove: ");
            sb.append(fragment);
            sb.append(" nesting=");
            sb.append(fragment.f2704s);
        }
        boolean z2 = !fragment.Z();
        if (!fragment.f2660B || z2) {
            this.f2978c.u(fragment);
            if (I0(fragment)) {
                this.f2965H = true;
            }
            fragment.f2698m = true;
            p1(fragment);
        }
    }

    public Fragment g0(int i2) {
        return this.f2978c.g(i2);
    }

    public Fragment h0(String str) {
        return this.f2978c.h(str);
    }

    void h1(Parcelable parcelable) {
        D d2;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f2997v.o().getClassLoader());
                this.f2986k.put(str.substring(7), bundle2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f2997v.o().getClassLoader());
                arrayList.add((C) bundle.getParcelable("state"));
            }
        }
        this.f2978c.x(arrayList);
        z zVar = (z) bundle3.getParcelable("state");
        if (zVar == null) {
            return;
        }
        this.f2978c.v();
        Iterator it2 = zVar.f3018a.iterator();
        while (it2.hasNext()) {
            C cB = this.f2978c.B((String) it2.next(), null);
            if (cB != null) {
                Fragment fragmentI = this.f2973P.i(cB.f2627b);
                if (fragmentI != null) {
                    if (H0(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("restoreSaveState: re-attaching retained ");
                        sb.append(fragmentI);
                    }
                    d2 = new D(this.f2989n, this.f2978c, fragmentI, cB);
                } else {
                    d2 = new D(this.f2989n, this.f2978c, this.f2997v.o().getClassLoader(), s0(), cB);
                }
                Fragment fragmentK = d2.k();
                fragmentK.f2705t = this;
                if (H0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("restoreSaveState: active (");
                    sb2.append(fragmentK.f2691f);
                    sb2.append("): ");
                    sb2.append(fragmentK);
                }
                d2.o(this.f2997v.o().getClassLoader());
                this.f2978c.r(d2);
                d2.u(this.f2996u);
            }
        }
        for (Fragment fragment : this.f2973P.l()) {
            if (!this.f2978c.c(fragment.f2691f)) {
                if (H0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Discarding retained Fragment ");
                    sb3.append(fragment);
                    sb3.append(" that was not found in the set of active Fragments ");
                    sb3.append(zVar.f3018a);
                }
                this.f2973P.o(fragment);
                fragment.f2705t = this;
                D d3 = new D(this.f2989n, this.f2978c, fragment);
                d3.u(1);
                d3.m();
                fragment.f2698m = true;
                d3.m();
            }
        }
        this.f2978c.w(zVar.f3019b);
        if (zVar.f3020c != null) {
            this.f2979d = new ArrayList(zVar.f3020c.length);
            int i2 = 0;
            while (true) {
                C0163b[] c0163bArr = zVar.f3020c;
                if (i2 >= c0163bArr.length) {
                    break;
                }
                C0162a c0162aB = c0163bArr[i2].b(this);
                if (H0(2)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("restoreAllState: back stack #");
                    sb4.append(i2);
                    sb4.append(" (index ");
                    sb4.append(c0162aB.f2832v);
                    sb4.append("): ");
                    sb4.append(c0162aB);
                    PrintWriter printWriter = new PrintWriter(new L("FragmentManager"));
                    c0162aB.u("  ", printWriter, false);
                    printWriter.close();
                }
                this.f2979d.add(c0162aB);
                i2++;
            }
        } else {
            this.f2979d = null;
        }
        this.f2984i.set(zVar.f3021d);
        String str3 = zVar.f3022e;
        if (str3 != null) {
            Fragment fragmentE0 = e0(str3);
            this.f3000y = fragmentE0;
            L(fragmentE0);
        }
        ArrayList arrayList2 = zVar.f3023f;
        if (arrayList2 != null) {
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                this.f2985j.put((String) arrayList2.get(i3), (C0164c) zVar.f3024g.get(i3));
            }
        }
        this.f2964G = new ArrayDeque(zVar.f3025h);
    }

    void i(C0162a c0162a) {
        if (this.f2979d == null) {
            this.f2979d = new ArrayList();
        }
        this.f2979d.add(c0162a);
    }

    Fragment i0(String str) {
        return this.f2978c.i(str);
    }

    D j(Fragment fragment) {
        String str = fragment.f2675Q;
        if (str != null) {
            C0265c.f(fragment, str);
        }
        if (H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("add: ");
            sb.append(fragment);
        }
        D dV = v(fragment);
        fragment.f2705t = this;
        this.f2978c.r(dV);
        if (!fragment.f2660B) {
            this.f2978c.a(fragment);
            fragment.f2698m = false;
            if (fragment.f2667I == null) {
                fragment.f2672N = false;
            }
            if (I0(fragment)) {
                this.f2965H = true;
            }
        }
        return dV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: j1, reason: merged with bridge method [inline-methods] */
    public Bundle P0() {
        C0163b[] c0163bArr;
        int size;
        Bundle bundle = new Bundle();
        l0();
        X();
        a0(true);
        this.f2966I = true;
        this.f2973P.p(true);
        ArrayList arrayListY = this.f2978c.y();
        ArrayList<C> arrayListM = this.f2978c.m();
        if (arrayListM.isEmpty()) {
            H0(2);
        } else {
            ArrayList arrayListZ = this.f2978c.z();
            ArrayList arrayList = this.f2979d;
            if (arrayList == null || (size = arrayList.size()) <= 0) {
                c0163bArr = null;
            } else {
                c0163bArr = new C0163b[size];
                for (int i2 = 0; i2 < size; i2++) {
                    c0163bArr[i2] = new C0163b((C0162a) this.f2979d.get(i2));
                    if (H0(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("saveAllState: adding back stack #");
                        sb.append(i2);
                        sb.append(": ");
                        sb.append(this.f2979d.get(i2));
                    }
                }
            }
            z zVar = new z();
            zVar.f3018a = arrayListY;
            zVar.f3019b = arrayListZ;
            zVar.f3020c = c0163bArr;
            zVar.f3021d = this.f2984i.get();
            Fragment fragment = this.f3000y;
            if (fragment != null) {
                zVar.f3022e = fragment.f2691f;
            }
            zVar.f3023f.addAll(this.f2985j.keySet());
            zVar.f3024g.addAll(this.f2985j.values());
            zVar.f3025h = new ArrayList(this.f2964G);
            bundle.putParcelable("state", zVar);
            for (String str : this.f2986k.keySet()) {
                bundle.putBundle("result_" + str, (Bundle) this.f2986k.get(str));
            }
            for (C c2 : arrayListM) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", c2);
                bundle.putBundle("fragment_" + c2.f2627b, bundle2);
            }
        }
        return bundle;
    }

    public void k(B b2) {
        this.f2990o.add(b2);
    }

    public Fragment.j k1(Fragment fragment) {
        D dN = this.f2978c.n(fragment.f2691f);
        if (dN == null || !dN.k().equals(fragment)) {
            s1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return dN.r();
    }

    int l() {
        return this.f2984i.getAndIncrement();
    }

    void l1() {
        synchronized (this.f2976a) {
            try {
                if (this.f2976a.size() == 1) {
                    this.f2997v.p().removeCallbacks(this.f2975R);
                    this.f2997v.p().post(this.f2975R);
                    t1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void m(androidx.fragment.app.p r4, androidx.fragment.app.AbstractC0173l r5, androidx.fragment.app.Fragment r6) {
        /*
            Method dump skipped, instruction units count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.x.m(androidx.fragment.app.p, androidx.fragment.app.l, androidx.fragment.app.Fragment):void");
    }

    void m1(Fragment fragment, boolean z2) {
        ViewGroup viewGroupR0 = r0(fragment);
        if (viewGroupR0 == null || !(viewGroupR0 instanceof C0174m)) {
            return;
        }
        ((C0174m) viewGroupR0).setDrawDisappearingViewsLast(!z2);
    }

    void n(Fragment fragment) {
        if (H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("attach: ");
            sb.append(fragment);
        }
        if (fragment.f2660B) {
            fragment.f2660B = false;
            if (fragment.f2697l) {
                return;
            }
            this.f2978c.a(fragment);
            if (H0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("add from attach: ");
                sb2.append(fragment);
            }
            if (I0(fragment)) {
                this.f2965H = true;
            }
        }
    }

    public int n0() {
        ArrayList arrayList = this.f2979d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    void n1(Fragment fragment, AbstractC0183g.b bVar) {
        if (fragment.equals(e0(fragment.f2691f)) && (fragment.f2706u == null || fragment.f2705t == this)) {
            fragment.f2676R = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public G o() {
        return new C0162a(this);
    }

    void o1(Fragment fragment) {
        if (fragment == null || (fragment.equals(e0(fragment.f2691f)) && (fragment.f2706u == null || fragment.f2705t == this))) {
            Fragment fragment2 = this.f3000y;
            this.f3000y = fragment;
            L(fragment2);
            L(this.f3000y);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    boolean p() {
        boolean zI0 = false;
        for (Fragment fragment : this.f2978c.l()) {
            if (fragment != null) {
                zI0 = I0(fragment);
            }
            if (zI0) {
                return true;
            }
        }
        return false;
    }

    AbstractC0173l p0() {
        return this.f2998w;
    }

    public Fragment q0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragmentE0 = e0(string);
        if (fragmentE0 == null) {
            s1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return fragmentE0;
    }

    void q1(Fragment fragment) {
        if (H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("show: ");
            sb.append(fragment);
        }
        if (fragment.f2659A) {
            fragment.f2659A = false;
            fragment.f2672N = !fragment.f2672N;
        }
    }

    public AbstractC0176o s0() {
        AbstractC0176o abstractC0176o = this.f3001z;
        if (abstractC0176o != null) {
            return abstractC0176o;
        }
        Fragment fragment = this.f2999x;
        return fragment != null ? fragment.f2705t.s0() : this.f2958A;
    }

    public List t0() {
        return this.f2978c.o();
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f2999x;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            obj = this.f2999x;
        } else {
            p pVar = this.f2997v;
            if (pVar == null) {
                sb.append("null");
                sb.append("}}");
                return sb.toString();
            }
            sb.append(pVar.getClass().getSimpleName());
            sb.append("{");
            obj = this.f2997v;
        }
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        sb.append("}");
        sb.append("}}");
        return sb.toString();
    }

    public p u0() {
        return this.f2997v;
    }

    D v(Fragment fragment) {
        D dN = this.f2978c.n(fragment.f2691f);
        if (dN != null) {
            return dN;
        }
        D d2 = new D(this.f2989n, this.f2978c, fragment);
        d2.o(this.f2997v.o().getClassLoader());
        d2.u(this.f2996u);
        return d2;
    }

    LayoutInflater.Factory2 v0() {
        return this.f2981f;
    }

    void w(Fragment fragment) {
        if (H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("detach: ");
            sb.append(fragment);
        }
        if (fragment.f2660B) {
            return;
        }
        fragment.f2660B = true;
        if (fragment.f2697l) {
            if (H0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("remove from detach: ");
                sb2.append(fragment);
            }
            this.f2978c.u(fragment);
            if (I0(fragment)) {
                this.f2965H = true;
            }
            p1(fragment);
        }
    }

    r w0() {
        return this.f2989n;
    }

    void x() {
        this.f2966I = false;
        this.f2967J = false;
        this.f2973P.p(false);
        S(4);
    }

    Fragment x0() {
        return this.f2999x;
    }

    void y() {
        this.f2966I = false;
        this.f2967J = false;
        this.f2973P.p(false);
        S(0);
    }

    public Fragment y0() {
        return this.f3000y;
    }

    void z(Configuration configuration, boolean z2) {
        if (z2 && (this.f2997v instanceof androidx.core.content.b)) {
            s1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment fragment : this.f2978c.o()) {
            if (fragment != null) {
                fragment.P0(configuration);
                if (z2) {
                    fragment.f2707v.z(configuration, true);
                }
            }
        }
    }

    N z0() {
        N n2 = this.f2959B;
        if (n2 != null) {
            return n2;
        }
        Fragment fragment = this.f2999x;
        return fragment != null ? fragment.f2705t.z0() : this.f2960C;
    }
}
