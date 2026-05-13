package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.os.b;
import androidx.core.view.Q;
import androidx.fragment.app.AbstractC0172k;
import androidx.fragment.app.M;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k.C0207a;
import o.AbstractC0236e;

/* JADX INFO: renamed from: androidx.fragment.app.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0165d extends M {

    /* JADX INFO: renamed from: androidx.fragment.app.d$a */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2850a;

        static {
            int[] iArr = new int[M.e.c.values().length];
            f2850a = iArr;
            try {
                iArr[M.e.c.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2850a[M.e.c.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2850a[M.e.c.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2850a[M.e.c.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.d$b */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f2851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ M.e f2852b;

        b(List list, M.e eVar) {
            this.f2851a = list;
            this.f2852b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2851a.contains(this.f2852b)) {
                this.f2851a.remove(this.f2852b);
                C0165d.this.s(this.f2852b);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.d$c */
    class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f2854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f2855b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f2856c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ M.e f2857d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f2858e;

        c(ViewGroup viewGroup, View view, boolean z2, M.e eVar, k kVar) {
            this.f2854a = viewGroup;
            this.f2855b = view;
            this.f2856c = z2;
            this.f2857d = eVar;
            this.f2858e = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2854a.endViewTransition(this.f2855b);
            if (this.f2856c) {
                this.f2857d.e().a(this.f2855b);
            }
            this.f2858e.a();
            if (x.H0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Animator from operation ");
                sb.append(this.f2857d);
                sb.append(" has ended.");
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.d$d, reason: collision with other inner class name */
    class C0044d implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Animator f2860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ M.e f2861b;

        C0044d(Animator animator, M.e eVar) {
            this.f2860a = animator;
            this.f2861b = eVar;
        }

        @Override // androidx.core.os.b.a
        public void a() {
            this.f2860a.end();
            if (x.H0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Animator from operation ");
                sb.append(this.f2861b);
                sb.append(" has been canceled.");
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.d$e */
    class e implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ M.e f2863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f2864b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f2865c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ k f2866d;

        /* JADX INFO: renamed from: androidx.fragment.app.d$e$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f2864b.endViewTransition(eVar.f2865c);
                e.this.f2866d.a();
            }
        }

        e(M.e eVar, ViewGroup viewGroup, View view, k kVar) {
            this.f2863a = eVar;
            this.f2864b = viewGroup;
            this.f2865c = view;
            this.f2866d = kVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f2864b.post(new a());
            if (x.H0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Animation from operation ");
                sb.append(this.f2863a);
                sb.append(" has ended.");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (x.H0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Animation from operation ");
                sb.append(this.f2863a);
                sb.append(" has reached onAnimationStart.");
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.d$f */
    class f implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f2869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f2870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f2871c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ M.e f2872d;

        f(View view, ViewGroup viewGroup, k kVar, M.e eVar) {
            this.f2869a = view;
            this.f2870b = viewGroup;
            this.f2871c = kVar;
            this.f2872d = eVar;
        }

        @Override // androidx.core.os.b.a
        public void a() {
            this.f2869a.clearAnimation();
            this.f2870b.endViewTransition(this.f2869a);
            this.f2871c.a();
            if (x.H0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Animation from operation ");
                sb.append(this.f2872d);
                sb.append(" has been cancelled.");
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.d$g */
    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ M.e f2874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ M.e f2875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f2876c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ C0207a f2877d;

        g(M.e eVar, M.e eVar2, boolean z2, C0207a c0207a) {
            this.f2874a = eVar;
            this.f2875b = eVar2;
            this.f2876c = z2;
            this.f2877d = c0207a;
        }

        @Override // java.lang.Runnable
        public void run() {
            H.a(this.f2874a.f(), this.f2875b.f(), this.f2876c, this.f2877d, false);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.d$h */
    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ J f2879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f2880b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Rect f2881c;

        h(J j2, View view, Rect rect) {
            this.f2879a = j2;
            this.f2880b = view;
            this.f2881c = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2879a.h(this.f2880b, this.f2881c);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.d$i */
    class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f2883a;

        i(ArrayList arrayList) {
            this.f2883a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            H.d(this.f2883a, 4);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.d$j */
    class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f2885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ M.e f2886b;

        j(m mVar, M.e eVar) {
            this.f2885a = mVar;
            this.f2886b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2885a.a();
            if (x.H0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Transition for operation ");
                sb.append(this.f2886b);
                sb.append("has completed");
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.d$k */
    private static class k extends l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f2888c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2889d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private AbstractC0172k.a f2890e;

        k(M.e eVar, androidx.core.os.b bVar, boolean z2) {
            super(eVar, bVar);
            this.f2889d = false;
            this.f2888c = z2;
        }

        AbstractC0172k.a e(Context context) {
            if (this.f2889d) {
                return this.f2890e;
            }
            AbstractC0172k.a aVarB = AbstractC0172k.b(context, b().f(), b().e() == M.e.c.VISIBLE, this.f2888c);
            this.f2890e = aVarB;
            this.f2889d = true;
            return aVarB;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.d$l */
    private static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final M.e f2891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final androidx.core.os.b f2892b;

        l(M.e eVar, androidx.core.os.b bVar) {
            this.f2891a = eVar;
            this.f2892b = bVar;
        }

        void a() {
            this.f2891a.d(this.f2892b);
        }

        M.e b() {
            return this.f2891a;
        }

        androidx.core.os.b c() {
            return this.f2892b;
        }

        boolean d() {
            M.e.c cVar;
            M.e.c cVarC = M.e.c.c(this.f2891a.f().f2667I);
            M.e.c cVarE = this.f2891a.e();
            return cVarC == cVarE || !(cVarC == (cVar = M.e.c.VISIBLE) || cVarE == cVar);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.d$m */
    private static class m extends l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object f2893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f2894d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Object f2895e;

        m(M.e eVar, androidx.core.os.b bVar, boolean z2, boolean z3) {
            boolean zK;
            Object objN;
            super(eVar, bVar);
            if (eVar.e() == M.e.c.VISIBLE) {
                Fragment fragmentF = eVar.f();
                this.f2893c = z2 ? fragmentF.J() : fragmentF.q();
                Fragment fragmentF2 = eVar.f();
                zK = z2 ? fragmentF2.k() : fragmentF2.j();
            } else {
                Fragment fragmentF3 = eVar.f();
                this.f2893c = z2 ? fragmentF3.L() : fragmentF3.t();
                zK = true;
            }
            this.f2894d = zK;
            if (z3) {
                Fragment fragmentF4 = eVar.f();
                objN = z2 ? fragmentF4.N() : fragmentF4.M();
            } else {
                objN = null;
            }
            this.f2895e = objN;
        }

        private J f(Object obj) {
            if (obj == null) {
                return null;
            }
            J j2 = H.f2771a;
            if (j2 != null && j2.e(obj)) {
                return j2;
            }
            J j3 = H.f2772b;
            if (j3 != null && j3.e(obj)) {
                return j3;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        J e() {
            J jF = f(this.f2893c);
            J jF2 = f(this.f2895e);
            if (jF == null || jF2 == null || jF == jF2) {
                return jF != null ? jF : jF2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f2893c + " which uses a different Transition  type than its shared element transition " + this.f2895e);
        }

        public Object g() {
            return this.f2895e;
        }

        Object h() {
            return this.f2893c;
        }

        public boolean i() {
            return this.f2895e != null;
        }

        boolean j() {
            return this.f2894d;
        }
    }

    C0165d(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(List list, List list2, boolean z2, Map map) {
        int i2;
        StringBuilder sb;
        String str;
        boolean z3;
        AbstractC0172k.a aVarE;
        M.e eVar;
        ViewGroup viewGroupM = m();
        Context context = viewGroupM.getContext();
        ArrayList<k> arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        boolean z4 = false;
        while (true) {
            i2 = 2;
            if (!it2.hasNext()) {
                break;
            }
            k kVar = (k) it2.next();
            if (kVar.d() || (aVarE = kVar.e(context)) == null) {
                kVar.a();
            } else {
                Animator animator = aVarE.f2929b;
                if (animator == null) {
                    arrayList.add(kVar);
                } else {
                    M.e eVarB = kVar.b();
                    Fragment fragmentF = eVarB.f();
                    if (Boolean.TRUE.equals(map.get(eVarB))) {
                        if (x.H0(2)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Ignoring Animator set on ");
                            sb2.append(fragmentF);
                            sb2.append(" as this Fragment was involved in a Transition.");
                        }
                        kVar.a();
                    } else {
                        boolean z5 = eVarB.e() == M.e.c.GONE;
                        if (z5) {
                            list2.remove(eVarB);
                        }
                        View view = fragmentF.f2667I;
                        viewGroupM.startViewTransition(view);
                        animator.addListener(new c(viewGroupM, view, z5, eVarB, kVar));
                        animator.setTarget(view);
                        animator.start();
                        if (x.H0(2)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Animator from operation ");
                            eVar = eVarB;
                            sb3.append(eVar);
                            sb3.append(" has started.");
                        } else {
                            eVar = eVarB;
                        }
                        kVar.c().b(new C0044d(animator, eVar));
                        z4 = true;
                    }
                }
            }
        }
        for (k kVar2 : arrayList) {
            M.e eVarB2 = kVar2.b();
            Fragment fragmentF2 = eVarB2.f();
            if (z2) {
                if (x.H0(i2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(fragmentF2);
                    str = " as Animations cannot run alongside Transitions.";
                    sb.append(str);
                }
                kVar2.a();
            } else if (z4) {
                if (x.H0(i2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(fragmentF2);
                    str = " as Animations cannot run alongside Animators.";
                    sb.append(str);
                }
                kVar2.a();
            } else {
                View view2 = fragmentF2.f2667I;
                Animation animation = (Animation) AbstractC0236e.f(((AbstractC0172k.a) AbstractC0236e.f(kVar2.e(context))).f2928a);
                if (eVarB2.e() != M.e.c.REMOVED) {
                    view2.startAnimation(animation);
                    kVar2.a();
                    z3 = z4;
                } else {
                    viewGroupM.startViewTransition(view2);
                    AbstractC0172k.b bVar = new AbstractC0172k.b(animation, viewGroupM, view2);
                    z3 = z4;
                    bVar.setAnimationListener(new e(eVarB2, viewGroupM, view2, kVar2));
                    view2.startAnimation(bVar);
                    if (x.H0(2)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Animation from operation ");
                        sb4.append(eVarB2);
                        sb4.append(" has started.");
                    }
                }
                kVar2.c().b(new f(view2, viewGroupM, kVar2, eVarB2));
                z4 = z3;
                i2 = 2;
            }
        }
    }

    private Map x(List list, List list2, boolean z2, M.e eVar, M.e eVar2) {
        View view;
        Object obj;
        ArrayList arrayList;
        Object obj2;
        ArrayList arrayList2;
        M.e eVar3;
        M.e eVar4;
        View view2;
        Object objK;
        C0207a c0207a;
        ArrayList arrayList3;
        M.e eVar5;
        ArrayList arrayList4;
        Rect rect;
        View view3;
        J j2;
        M.e eVar6;
        View view4;
        boolean z3 = z2;
        M.e eVar7 = eVar;
        M.e eVar8 = eVar2;
        HashMap map = new HashMap();
        Iterator it2 = list.iterator();
        J j3 = null;
        while (it2.hasNext()) {
            m mVar = (m) it2.next();
            if (!mVar.d()) {
                J jE = mVar.e();
                if (j3 == null) {
                    j3 = jE;
                } else if (jE != null && j3 != jE) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.b().f() + " returned Transition " + mVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (j3 == null) {
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                m mVar2 = (m) it3.next();
                map.put(mVar2.b(), Boolean.FALSE);
                mVar2.a();
            }
            return map;
        }
        View view5 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        C0207a c0207a2 = new C0207a();
        Iterator it4 = list.iterator();
        Object obj3 = null;
        View view6 = null;
        boolean z4 = false;
        while (it4.hasNext()) {
            m mVar3 = (m) it4.next();
            if (!mVar3.i() || eVar7 == null || eVar8 == null) {
                c0207a = c0207a2;
                arrayList3 = arrayList6;
                eVar5 = eVar7;
                arrayList4 = arrayList5;
                rect = rect2;
                view3 = view5;
                j2 = j3;
                eVar6 = eVar8;
                view6 = view6;
            } else {
                Object objU = j3.u(j3.f(mVar3.g()));
                ArrayList arrayListO = eVar2.f().O();
                ArrayList arrayListO2 = eVar.f().O();
                ArrayList arrayListP = eVar.f().P();
                View view7 = view6;
                int i2 = 0;
                while (i2 < arrayListP.size()) {
                    int iIndexOf = arrayListO.indexOf(arrayListP.get(i2));
                    ArrayList arrayList7 = arrayListP;
                    if (iIndexOf != -1) {
                        arrayListO.set(iIndexOf, (String) arrayListO2.get(i2));
                    }
                    i2++;
                    arrayListP = arrayList7;
                }
                ArrayList arrayListP2 = eVar2.f().P();
                Fragment fragmentF = eVar.f();
                if (z3) {
                    fragmentF.r();
                    eVar2.f().u();
                } else {
                    fragmentF.u();
                    eVar2.f().r();
                }
                int i3 = 0;
                for (int size = arrayListO.size(); i3 < size; size = size) {
                    c0207a2.put((String) arrayListO.get(i3), (String) arrayListP2.get(i3));
                    i3++;
                }
                if (x.H0(2)) {
                    Iterator it5 = arrayListP2.iterator();
                    while (it5.hasNext()) {
                        String str = (String) it5.next();
                        Iterator it6 = it5;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Name: ");
                        sb.append(str);
                        it5 = it6;
                    }
                    Iterator it7 = arrayListO.iterator();
                    while (it7.hasNext()) {
                        String str2 = (String) it7.next();
                        Iterator it8 = it7;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Name: ");
                        sb2.append(str2);
                        it7 = it8;
                    }
                }
                C0207a c0207a3 = new C0207a();
                u(c0207a3, eVar.f().f2667I);
                c0207a3.n(arrayListO);
                c0207a2.n(c0207a3.keySet());
                C0207a c0207a4 = new C0207a();
                u(c0207a4, eVar2.f().f2667I);
                c0207a4.n(arrayListP2);
                c0207a4.n(c0207a2.values());
                H.c(c0207a2, c0207a4);
                v(c0207a3, c0207a2.keySet());
                v(c0207a4, c0207a2.values());
                if (c0207a2.isEmpty()) {
                    arrayList5.clear();
                    arrayList6.clear();
                    c0207a = c0207a2;
                    arrayList3 = arrayList6;
                    eVar5 = eVar7;
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view5;
                    j2 = j3;
                    view6 = view7;
                    obj3 = null;
                    eVar6 = eVar8;
                } else {
                    H.a(eVar2.f(), eVar.f(), z3, c0207a3, true);
                    c0207a = c0207a2;
                    ArrayList arrayList8 = arrayList6;
                    androidx.core.view.H.a(m(), new g(eVar2, eVar, z2, c0207a4));
                    arrayList5.addAll(c0207a3.values());
                    if (arrayListO.isEmpty()) {
                        view6 = view7;
                    } else {
                        view6 = (View) c0207a3.get((String) arrayListO.get(0));
                        j3.p(objU, view6);
                    }
                    arrayList3 = arrayList8;
                    arrayList3.addAll(c0207a4.values());
                    if (!arrayListP2.isEmpty() && (view4 = (View) c0207a4.get((String) arrayListP2.get(0))) != null) {
                        androidx.core.view.H.a(m(), new h(j3, view4, rect2));
                        z4 = true;
                    }
                    j3.s(objU, view5, arrayList5);
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view5;
                    j2 = j3;
                    j3.n(objU, null, null, null, null, objU, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    eVar5 = eVar;
                    map.put(eVar5, bool);
                    eVar6 = eVar2;
                    map.put(eVar6, bool);
                    obj3 = objU;
                }
            }
            eVar7 = eVar5;
            arrayList5 = arrayList4;
            rect2 = rect;
            view5 = view3;
            eVar8 = eVar6;
            c0207a2 = c0207a;
            z3 = z2;
            arrayList6 = arrayList3;
            j3 = j2;
        }
        View view8 = view6;
        C0207a c0207a5 = c0207a2;
        ArrayList arrayList9 = arrayList6;
        M.e eVar9 = eVar7;
        ArrayList arrayList10 = arrayList5;
        Rect rect3 = rect2;
        View view9 = view5;
        J j4 = j3;
        M.e eVar10 = eVar8;
        ArrayList arrayList11 = new ArrayList();
        Iterator it9 = list.iterator();
        Object obj4 = null;
        Object objK2 = null;
        while (it9.hasNext()) {
            m mVar4 = (m) it9.next();
            if (mVar4.d()) {
                map.put(mVar4.b(), Boolean.FALSE);
                mVar4.a();
            } else {
                Object objF = j4.f(mVar4.h());
                M.e eVarB = mVar4.b();
                boolean z5 = obj3 != null && (eVarB == eVar9 || eVarB == eVar10);
                if (objF == null) {
                    if (!z5) {
                        map.put(eVarB, Boolean.FALSE);
                        mVar4.a();
                    }
                    arrayList2 = arrayList9;
                    arrayList = arrayList10;
                    view = view9;
                    objK = obj4;
                    eVar3 = eVar10;
                    view2 = view8;
                } else {
                    ArrayList arrayList12 = new ArrayList();
                    Object obj5 = obj4;
                    t(arrayList12, eVarB.f().f2667I);
                    if (z5) {
                        if (eVarB == eVar9) {
                            arrayList12.removeAll(arrayList10);
                        } else {
                            arrayList12.removeAll(arrayList9);
                        }
                    }
                    if (arrayList12.isEmpty()) {
                        j4.a(objF, view9);
                        arrayList2 = arrayList9;
                        arrayList = arrayList10;
                        view = view9;
                        eVar4 = eVarB;
                        obj2 = objK2;
                        eVar3 = eVar10;
                        obj = obj5;
                    } else {
                        j4.b(objF, arrayList12);
                        view = view9;
                        obj = obj5;
                        arrayList = arrayList10;
                        obj2 = objK2;
                        arrayList2 = arrayList9;
                        eVar3 = eVar10;
                        j4.n(objF, objF, arrayList12, null, null, null, null);
                        if (eVarB.e() == M.e.c.GONE) {
                            eVar4 = eVarB;
                            list2.remove(eVar4);
                            ArrayList arrayList13 = new ArrayList(arrayList12);
                            arrayList13.remove(eVar4.f().f2667I);
                            j4.m(objF, eVar4.f().f2667I, arrayList13);
                            androidx.core.view.H.a(m(), new i(arrayList12));
                        } else {
                            eVar4 = eVarB;
                        }
                    }
                    if (eVar4.e() == M.e.c.VISIBLE) {
                        arrayList11.addAll(arrayList12);
                        if (z4) {
                            j4.o(objF, rect3);
                        }
                        view2 = view8;
                    } else {
                        view2 = view8;
                        j4.p(objF, view2);
                    }
                    map.put(eVar4, Boolean.TRUE);
                    if (mVar4.j()) {
                        objK2 = j4.k(obj2, objF, null);
                        objK = obj;
                    } else {
                        objK = j4.k(obj, objF, null);
                        objK2 = obj2;
                    }
                }
                eVar10 = eVar3;
                obj4 = objK;
                view8 = view2;
                view9 = view;
                arrayList10 = arrayList;
                arrayList9 = arrayList2;
            }
        }
        ArrayList<View> arrayList14 = arrayList9;
        ArrayList<View> arrayList15 = arrayList10;
        M.e eVar11 = eVar10;
        Object objJ = j4.j(objK2, obj4, obj3);
        if (objJ == null) {
            return map;
        }
        Iterator it10 = list.iterator();
        while (it10.hasNext()) {
            m mVar5 = (m) it10.next();
            if (!mVar5.d()) {
                Object objH = mVar5.h();
                M.e eVarB2 = mVar5.b();
                boolean z6 = obj3 != null && (eVarB2 == eVar9 || eVarB2 == eVar11);
                if (objH != null || z6) {
                    if (androidx.core.view.L.F(m())) {
                        j4.q(mVar5.b().f(), objJ, mVar5.c(), new j(mVar5, eVarB2));
                    } else {
                        if (x.H0(2)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("SpecialEffectsController: Container ");
                            sb3.append(m());
                            sb3.append(" has not been laid out. Completing operation ");
                            sb3.append(eVarB2);
                        }
                        mVar5.a();
                    }
                }
            }
        }
        if (!androidx.core.view.L.F(m())) {
            return map;
        }
        H.d(arrayList11, 4);
        ArrayList arrayListL = j4.l(arrayList14);
        if (x.H0(2)) {
            for (View view10 : arrayList15) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("View: ");
                sb4.append(view10);
                sb4.append(" Name: ");
                sb4.append(androidx.core.view.L.B(view10));
            }
            for (View view11 : arrayList14) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("View: ");
                sb5.append(view11);
                sb5.append(" Name: ");
                sb5.append(androidx.core.view.L.B(view11));
            }
        }
        j4.c(m(), objJ);
        j4.r(m(), arrayList15, arrayList14, arrayListL, c0207a5);
        H.d(arrayList11, 0);
        j4.t(obj3, arrayList15, arrayList14);
        return map;
    }

    private void y(List list) {
        Fragment fragmentF = ((M.e) list.get(list.size() - 1)).f();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            M.e eVar = (M.e) it2.next();
            eVar.f().f2670L.f2721c = fragmentF.f2670L.f2721c;
            eVar.f().f2670L.f2722d = fragmentF.f2670L.f2722d;
            eVar.f().f2670L.f2723e = fragmentF.f2670L.f2723e;
            eVar.f().f2670L.f2724f = fragmentF.f2670L.f2724f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    @Override // androidx.fragment.app.M
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void f(java.util.List r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0165d.f(java.util.List, boolean):void");
    }

    void s(M.e eVar) {
        eVar.e().a(eVar.f().f2667I);
    }

    void t(ArrayList arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (Q.a(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                t(arrayList, childAt);
            }
        }
    }

    void u(Map map, View view) {
        String strB = androidx.core.view.L.B(view);
        if (strB != null) {
            map.put(strB, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    void v(C0207a c0207a, Collection collection) {
        Iterator it2 = c0207a.entrySet().iterator();
        while (it2.hasNext()) {
            if (!collection.contains(androidx.core.view.L.B((View) ((Map.Entry) it2.next()).getValue()))) {
                it2.remove();
            }
        }
    }
}
