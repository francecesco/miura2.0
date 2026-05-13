package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.b;
import androidx.fragment.R$id;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroup f2801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList f2802b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ArrayList f2803c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f2804d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f2805e = false;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f2806a;

        a(d dVar) {
            this.f2806a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (M.this.f2802b.contains(this.f2806a)) {
                this.f2806a.e().a(this.f2806a.f().f2667I);
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f2808a;

        b(d dVar) {
            this.f2808a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            M.this.f2802b.remove(this.f2808a);
            M.this.f2803c.remove(this.f2808a);
        }
    }

    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f2811b;

        static {
            int[] iArr = new int[e.b.values().length];
            f2811b = iArr;
            try {
                iArr[e.b.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2811b[e.b.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2811b[e.b.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.c.values().length];
            f2810a = iArr2;
            try {
                iArr2[e.c.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2810a[e.c.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2810a[e.c.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2810a[e.c.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static class d extends e {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final D f2812h;

        d(e.c cVar, e.b bVar, D d2, androidx.core.os.b bVar2) {
            super(cVar, bVar, d2.k(), bVar2);
            this.f2812h = d2;
        }

        @Override // androidx.fragment.app.M.e
        public void c() {
            super.c();
            this.f2812h.m();
        }

        @Override // androidx.fragment.app.M.e
        void l() {
            if (g() != e.b.ADDING) {
                if (g() == e.b.REMOVING) {
                    Fragment fragmentK = this.f2812h.k();
                    View viewO1 = fragmentK.o1();
                    if (x.H0(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Clearing focus ");
                        sb.append(viewO1.findFocus());
                        sb.append(" on view ");
                        sb.append(viewO1);
                        sb.append(" for Fragment ");
                        sb.append(fragmentK);
                    }
                    viewO1.clearFocus();
                    return;
                }
                return;
            }
            Fragment fragmentK2 = this.f2812h.k();
            View viewFindFocus = fragmentK2.f2667I.findFocus();
            if (viewFindFocus != null) {
                fragmentK2.u1(viewFindFocus);
                if (x.H0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("requestFocus: Saved focused view ");
                    sb2.append(viewFindFocus);
                    sb2.append(" for Fragment ");
                    sb2.append(fragmentK2);
                }
            }
            View viewO12 = f().o1();
            if (viewO12.getParent() == null) {
                this.f2812h.b();
                viewO12.setAlpha(0.0f);
            }
            if (viewO12.getAlpha() == 0.0f && viewO12.getVisibility() == 0) {
                viewO12.setVisibility(4);
            }
            viewO12.setAlpha(fragmentK2.I());
        }
    }

    static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private c f2813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f2814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Fragment f2815c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f2816d = new ArrayList();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final HashSet f2817e = new HashSet();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f2818f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f2819g = false;

        class a implements b.a {
            a() {
            }

            @Override // androidx.core.os.b.a
            public void a() {
                e.this.b();
            }
        }

        enum b {
            NONE,
            ADDING,
            REMOVING
        }

        enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            static c b(int i2) {
                if (i2 == 0) {
                    return VISIBLE;
                }
                if (i2 == 4) {
                    return INVISIBLE;
                }
                if (i2 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i2);
            }

            static c c(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : b(view.getVisibility());
            }

            void a(View view) {
                int i2;
                int i3 = c.f2810a[ordinal()];
                if (i3 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (x.H0(2)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("SpecialEffectsController: Removing view ");
                            sb.append(view);
                            sb.append(" from container ");
                            sb.append(viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i3 == 2) {
                    if (x.H0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: Setting view ");
                        sb2.append(view);
                        sb2.append(" to VISIBLE");
                    }
                    i2 = 0;
                } else {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return;
                        }
                        if (x.H0(2)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("SpecialEffectsController: Setting view ");
                            sb3.append(view);
                            sb3.append(" to INVISIBLE");
                        }
                        view.setVisibility(4);
                        return;
                    }
                    if (x.H0(2)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("SpecialEffectsController: Setting view ");
                        sb4.append(view);
                        sb4.append(" to GONE");
                    }
                    i2 = 8;
                }
                view.setVisibility(i2);
            }
        }

        e(c cVar, b bVar, Fragment fragment, androidx.core.os.b bVar2) {
            this.f2813a = cVar;
            this.f2814b = bVar;
            this.f2815c = fragment;
            bVar2.b(new a());
        }

        final void a(Runnable runnable) {
            this.f2816d.add(runnable);
        }

        final void b() {
            if (h()) {
                return;
            }
            this.f2818f = true;
            if (this.f2817e.isEmpty()) {
                c();
                return;
            }
            Iterator it2 = new ArrayList(this.f2817e).iterator();
            while (it2.hasNext()) {
                ((androidx.core.os.b) it2.next()).a();
            }
        }

        public void c() {
            if (this.f2819g) {
                return;
            }
            if (x.H0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("SpecialEffectsController: ");
                sb.append(this);
                sb.append(" has called complete.");
            }
            this.f2819g = true;
            Iterator it2 = this.f2816d.iterator();
            while (it2.hasNext()) {
                ((Runnable) it2.next()).run();
            }
        }

        public final void d(androidx.core.os.b bVar) {
            if (this.f2817e.remove(bVar) && this.f2817e.isEmpty()) {
                c();
            }
        }

        public c e() {
            return this.f2813a;
        }

        public final Fragment f() {
            return this.f2815c;
        }

        b g() {
            return this.f2814b;
        }

        final boolean h() {
            return this.f2818f;
        }

        final boolean i() {
            return this.f2819g;
        }

        public final void j(androidx.core.os.b bVar) {
            l();
            this.f2817e.add(bVar);
        }

        final void k(c cVar, b bVar) {
            b bVar2;
            int i2 = c.f2811b[bVar.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3 && this.f2813a != c.REMOVED) {
                        if (x.H0(2)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("SpecialEffectsController: For fragment ");
                            sb.append(this.f2815c);
                            sb.append(" mFinalState = ");
                            sb.append(this.f2813a);
                            sb.append(" -> ");
                            sb.append(cVar);
                            sb.append(". ");
                        }
                        this.f2813a = cVar;
                        return;
                    }
                    return;
                }
                if (x.H0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: For fragment ");
                    sb2.append(this.f2815c);
                    sb2.append(" mFinalState = ");
                    sb2.append(this.f2813a);
                    sb2.append(" -> REMOVED. mLifecycleImpact  = ");
                    sb2.append(this.f2814b);
                    sb2.append(" to REMOVING.");
                }
                this.f2813a = c.REMOVED;
                bVar2 = b.REMOVING;
            } else {
                if (this.f2813a != c.REMOVED) {
                    return;
                }
                if (x.H0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("SpecialEffectsController: For fragment ");
                    sb3.append(this.f2815c);
                    sb3.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                    sb3.append(this.f2814b);
                    sb3.append(" to ADDING.");
                }
                this.f2813a = c.VISIBLE;
                bVar2 = b.ADDING;
            }
            this.f2814b = bVar2;
        }

        abstract void l();

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f2813a + "} {mLifecycleImpact = " + this.f2814b + "} {mFragment = " + this.f2815c + "}";
        }
    }

    M(ViewGroup viewGroup) {
        this.f2801a = viewGroup;
    }

    private void a(e.c cVar, e.b bVar, D d2) {
        synchronized (this.f2802b) {
            try {
                androidx.core.os.b bVar2 = new androidx.core.os.b();
                e eVarH = h(d2.k());
                if (eVarH != null) {
                    eVarH.k(cVar, bVar);
                    return;
                }
                d dVar = new d(cVar, bVar, d2, bVar2);
                this.f2802b.add(dVar);
                dVar.a(new a(dVar));
                dVar.a(new b(dVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private e h(Fragment fragment) {
        for (e eVar : this.f2802b) {
            if (eVar.f().equals(fragment) && !eVar.h()) {
                return eVar;
            }
        }
        return null;
    }

    private e i(Fragment fragment) {
        for (e eVar : this.f2803c) {
            if (eVar.f().equals(fragment) && !eVar.h()) {
                return eVar;
            }
        }
        return null;
    }

    static M n(ViewGroup viewGroup, x xVar) {
        return o(viewGroup, xVar.z0());
    }

    static M o(ViewGroup viewGroup, N n2) {
        Object tag = viewGroup.getTag(R$id.special_effects_controller_view_tag);
        if (tag instanceof M) {
            return (M) tag;
        }
        M mA = n2.a(viewGroup);
        viewGroup.setTag(R$id.special_effects_controller_view_tag, mA);
        return mA;
    }

    private void q() {
        for (e eVar : this.f2802b) {
            if (eVar.g() == e.b.ADDING) {
                eVar.k(e.c.b(eVar.f().o1().getVisibility()), e.b.NONE);
            }
        }
    }

    void b(e.c cVar, D d2) {
        if (x.H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing add operation for fragment ");
            sb.append(d2.k());
        }
        a(cVar, e.b.ADDING, d2);
    }

    void c(D d2) {
        if (x.H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing hide operation for fragment ");
            sb.append(d2.k());
        }
        a(e.c.GONE, e.b.NONE, d2);
    }

    void d(D d2) {
        if (x.H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing remove operation for fragment ");
            sb.append(d2.k());
        }
        a(e.c.REMOVED, e.b.REMOVING, d2);
    }

    void e(D d2) {
        if (x.H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing show operation for fragment ");
            sb.append(d2.k());
        }
        a(e.c.VISIBLE, e.b.NONE, d2);
    }

    abstract void f(List list, boolean z2);

    void g() {
        if (this.f2805e) {
            return;
        }
        if (!androidx.core.view.L.E(this.f2801a)) {
            j();
            this.f2804d = false;
            return;
        }
        synchronized (this.f2802b) {
            try {
                if (!this.f2802b.isEmpty()) {
                    ArrayList<e> arrayList = new ArrayList(this.f2803c);
                    this.f2803c.clear();
                    for (e eVar : arrayList) {
                        if (x.H0(2)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("SpecialEffectsController: Cancelling operation ");
                            sb.append(eVar);
                        }
                        eVar.b();
                        if (!eVar.i()) {
                            this.f2803c.add(eVar);
                        }
                    }
                    q();
                    ArrayList arrayList2 = new ArrayList(this.f2802b);
                    this.f2802b.clear();
                    this.f2803c.addAll(arrayList2);
                    x.H0(2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((e) it2.next()).l();
                    }
                    f(arrayList2, this.f2804d);
                    this.f2804d = false;
                    x.H0(2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void j() {
        x.H0(2);
        boolean zE = androidx.core.view.L.E(this.f2801a);
        synchronized (this.f2802b) {
            try {
                q();
                Iterator it2 = this.f2802b.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).l();
                }
                for (e eVar : new ArrayList(this.f2803c)) {
                    if (x.H0(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        sb.append(zE ? "" : "Container " + this.f2801a + " is not attached to window. ");
                        sb.append("Cancelling running operation ");
                        sb.append(eVar);
                    }
                    eVar.b();
                }
                for (e eVar2 : new ArrayList(this.f2802b)) {
                    if (x.H0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        sb2.append(zE ? "" : "Container " + this.f2801a + " is not attached to window. ");
                        sb2.append("Cancelling pending operation ");
                        sb2.append(eVar2);
                    }
                    eVar2.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void k() {
        if (this.f2805e) {
            x.H0(2);
            this.f2805e = false;
            g();
        }
    }

    e.b l(D d2) {
        e eVarH = h(d2.k());
        e.b bVarG = eVarH != null ? eVarH.g() : null;
        e eVarI = i(d2.k());
        return (eVarI == null || !(bVarG == null || bVarG == e.b.NONE)) ? bVarG : eVarI.g();
    }

    public ViewGroup m() {
        return this.f2801a;
    }

    void p() {
        synchronized (this.f2802b) {
            try {
                q();
                this.f2805e = false;
                int size = this.f2802b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    e eVar = (e) this.f2802b.get(size);
                    e.c cVarC = e.c.c(eVar.f().f2667I);
                    e.c cVarE = eVar.e();
                    e.c cVar = e.c.VISIBLE;
                    if (cVarE == cVar && cVarC != cVar) {
                        this.f2805e = eVar.f().b0();
                        break;
                    }
                    size--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void r(boolean z2) {
        this.f2804d = z2;
    }
}
