package x;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.x;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import l0.A;
import l0.G;
import l0.k;

/* JADX INFO: renamed from: x.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0265c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0265c f4075a = new C0265c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static C0075c f4076b = C0075c.f4087d;

    /* JADX INFO: renamed from: x.c$a */
    public enum a {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    /* JADX INFO: renamed from: x.c$b */
    public interface b {
    }

    /* JADX INFO: renamed from: x.c$c, reason: collision with other inner class name */
    public static final class C0075c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f4086c = new a(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C0075c f4087d = new C0075c(G.a(), null, A.d());

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set f4088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f4089b;

        /* JADX INFO: renamed from: x.c$c$a */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(q0.d dVar) {
                this();
            }
        }

        public C0075c(Set set, b bVar, Map map) {
            q0.f.e(set, "flags");
            q0.f.e(map, "allowedViolations");
            this.f4088a = set;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put((String) entry.getKey(), (Set) entry.getValue());
            }
            this.f4089b = linkedHashMap;
        }

        public final Set a() {
            return this.f4088a;
        }

        public final b b() {
            return null;
        }

        public final Map c() {
            return this.f4089b;
        }
    }

    private C0265c() {
    }

    private final C0075c b(Fragment fragment) {
        while (fragment != null) {
            if (fragment.X()) {
                x xVarD = fragment.D();
                q0.f.d(xVarD, "declaringFragment.parentFragmentManager");
                if (xVarD.A0() != null) {
                    C0075c c0075cA0 = xVarD.A0();
                    q0.f.b(c0075cA0);
                    return c0075cA0;
                }
            }
            fragment = fragment.C();
        }
        return f4076b;
    }

    private final void c(C0075c c0075c, final AbstractC0270h abstractC0270h) {
        Fragment fragmentA = abstractC0270h.a();
        final String name = fragmentA.getClass().getName();
        if (c0075c.a().contains(a.PENALTY_LOG)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Policy violation in ");
            sb.append(name);
        }
        c0075c.b();
        if (c0075c.a().contains(a.PENALTY_DEATH)) {
            k(fragmentA, new Runnable() { // from class: x.b
                @Override // java.lang.Runnable
                public final void run() {
                    C0265c.d(name, abstractC0270h);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str, AbstractC0270h abstractC0270h) {
        q0.f.e(abstractC0270h, "$violation");
        StringBuilder sb = new StringBuilder();
        sb.append("Policy violation with PENALTY_DEATH in ");
        sb.append(str);
        throw abstractC0270h;
    }

    private final void e(AbstractC0270h abstractC0270h) {
        if (x.H0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("StrictMode violation in ");
            sb.append(abstractC0270h.a().getClass().getName());
        }
    }

    public static final void f(Fragment fragment, String str) {
        q0.f.e(fragment, "fragment");
        q0.f.e(str, "previousFragmentId");
        C0263a c0263a = new C0263a(fragment, str);
        C0265c c0265c = f4075a;
        c0265c.e(c0263a);
        C0075c c0075cB = c0265c.b(fragment);
        if (c0075cB.a().contains(a.DETECT_FRAGMENT_REUSE) && c0265c.l(c0075cB, fragment.getClass(), c0263a.getClass())) {
            c0265c.c(c0075cB, c0263a);
        }
    }

    public static final void g(Fragment fragment, ViewGroup viewGroup) {
        q0.f.e(fragment, "fragment");
        C0266d c0266d = new C0266d(fragment, viewGroup);
        C0265c c0265c = f4075a;
        c0265c.e(c0266d);
        C0075c c0075cB = c0265c.b(fragment);
        if (c0075cB.a().contains(a.DETECT_FRAGMENT_TAG_USAGE) && c0265c.l(c0075cB, fragment.getClass(), c0266d.getClass())) {
            c0265c.c(c0075cB, c0266d);
        }
    }

    public static final void h(Fragment fragment) {
        q0.f.e(fragment, "fragment");
        C0267e c0267e = new C0267e(fragment);
        C0265c c0265c = f4075a;
        c0265c.e(c0267e);
        C0075c c0075cB = c0265c.b(fragment);
        if (c0075cB.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && c0265c.l(c0075cB, fragment.getClass(), c0267e.getClass())) {
            c0265c.c(c0075cB, c0267e);
        }
    }

    public static final void i(Fragment fragment, boolean z2) {
        q0.f.e(fragment, "fragment");
        C0268f c0268f = new C0268f(fragment, z2);
        C0265c c0265c = f4075a;
        c0265c.e(c0268f);
        C0075c c0075cB = c0265c.b(fragment);
        if (c0075cB.a().contains(a.DETECT_SET_USER_VISIBLE_HINT) && c0265c.l(c0075cB, fragment.getClass(), c0268f.getClass())) {
            c0265c.c(c0075cB, c0268f);
        }
    }

    public static final void j(Fragment fragment, ViewGroup viewGroup) {
        q0.f.e(fragment, "fragment");
        q0.f.e(viewGroup, "container");
        C0271i c0271i = new C0271i(fragment, viewGroup);
        C0265c c0265c = f4075a;
        c0265c.e(c0271i);
        C0075c c0075cB = c0265c.b(fragment);
        if (c0075cB.a().contains(a.DETECT_WRONG_FRAGMENT_CONTAINER) && c0265c.l(c0075cB, fragment.getClass(), c0271i.getClass())) {
            c0265c.c(c0075cB, c0271i);
        }
    }

    private final void k(Fragment fragment, Runnable runnable) {
        if (fragment.X()) {
            Handler handlerP = fragment.D().u0().p();
            q0.f.d(handlerP, "fragment.parentFragmentManager.host.handler");
            if (!q0.f.a(handlerP.getLooper(), Looper.myLooper())) {
                handlerP.post(runnable);
                return;
            }
        }
        runnable.run();
    }

    private final boolean l(C0075c c0075c, Class cls, Class cls2) {
        Set set = (Set) c0075c.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (q0.f.a(cls2.getSuperclass(), AbstractC0270h.class) || !k.g(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
