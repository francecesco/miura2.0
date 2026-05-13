package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import o.AbstractC0234c;
import o.AbstractC0236e;

/* JADX INFO: loaded from: classes.dex */
public class Y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Y f2310b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f2311a;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Field f2312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Field f2313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static Field f2314c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static boolean f2315d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f2312a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f2313b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f2314c = declaredField3;
                declaredField3.setAccessible(true);
                f2315d = true;
            } catch (ReflectiveOperationException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to get visible insets from AttachInfo ");
                sb.append(e2.getMessage());
            }
        }

        public static Y a(View view) {
            if (f2315d && view.isAttachedToWindow()) {
                try {
                    Object obj = f2312a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f2313b.get(obj);
                        Rect rect2 = (Rect) f2314c.get(obj);
                        if (rect != null && rect2 != null) {
                            Y yA = new b().b(androidx.core.graphics.f.c(rect)).c(androidx.core.graphics.f.c(rect2)).a();
                            yA.r(yA);
                            yA.d(view.getRootView());
                            return yA;
                        }
                    }
                } catch (IllegalAccessException e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to get insets from AttachInfo. ");
                    sb.append(e2.getMessage());
                }
            }
            return null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f2316a;

        public b() {
            int i2 = Build.VERSION.SDK_INT;
            this.f2316a = i2 >= 30 ? new e() : i2 >= 29 ? new d() : new c();
        }

        public Y a() {
            return this.f2316a.b();
        }

        public b b(androidx.core.graphics.f fVar) {
            this.f2316a.d(fVar);
            return this;
        }

        public b c(androidx.core.graphics.f fVar) {
            this.f2316a.f(fVar);
            return this;
        }

        public b(Y y2) {
            int i2 = Build.VERSION.SDK_INT;
            this.f2316a = i2 >= 30 ? new e(y2) : i2 >= 29 ? new d(y2) : new c(y2);
        }
    }

    private static class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static Field f2317e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static boolean f2318f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static Constructor f2319g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static boolean f2320h = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private WindowInsets f2321c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private androidx.core.graphics.f f2322d;

        c() {
            this.f2321c = h();
        }

        private static WindowInsets h() {
            if (!f2318f) {
                try {
                    f2317e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                f2318f = true;
            }
            Field field = f2317e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException unused2) {
                }
            }
            if (!f2320h) {
                try {
                    f2319g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException unused3) {
                }
                f2320h = true;
            }
            Constructor constructor = f2319g;
            if (constructor != null) {
                try {
                    return (WindowInsets) constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException unused4) {
                }
            }
            return null;
        }

        @Override // androidx.core.view.Y.f
        Y b() {
            a();
            Y yU = Y.u(this.f2321c);
            yU.p(this.f2325b);
            yU.s(this.f2322d);
            return yU;
        }

        @Override // androidx.core.view.Y.f
        void d(androidx.core.graphics.f fVar) {
            this.f2322d = fVar;
        }

        @Override // androidx.core.view.Y.f
        void f(androidx.core.graphics.f fVar) {
            WindowInsets windowInsets = this.f2321c;
            if (windowInsets != null) {
                this.f2321c = windowInsets.replaceSystemWindowInsets(fVar.f2200a, fVar.f2201b, fVar.f2202c, fVar.f2203d);
            }
        }

        c(Y y2) {
            super(y2);
            this.f2321c = y2.t();
        }
    }

    private static class d extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final WindowInsets.Builder f2323c;

        d() {
            this.f2323c = g0.a();
        }

        @Override // androidx.core.view.Y.f
        Y b() {
            a();
            Y yU = Y.u(this.f2323c.build());
            yU.p(this.f2325b);
            return yU;
        }

        @Override // androidx.core.view.Y.f
        void c(androidx.core.graphics.f fVar) {
            this.f2323c.setMandatorySystemGestureInsets(fVar.e());
        }

        @Override // androidx.core.view.Y.f
        void d(androidx.core.graphics.f fVar) {
            this.f2323c.setStableInsets(fVar.e());
        }

        @Override // androidx.core.view.Y.f
        void e(androidx.core.graphics.f fVar) {
            this.f2323c.setSystemGestureInsets(fVar.e());
        }

        @Override // androidx.core.view.Y.f
        void f(androidx.core.graphics.f fVar) {
            this.f2323c.setSystemWindowInsets(fVar.e());
        }

        @Override // androidx.core.view.Y.f
        void g(androidx.core.graphics.f fVar) {
            this.f2323c.setTappableElementInsets(fVar.e());
        }

        d(Y y2) {
            super(y2);
            WindowInsets windowInsetsT = y2.t();
            this.f2323c = windowInsetsT != null ? f0.a(windowInsetsT) : g0.a();
        }
    }

    private static class e extends d {
        e() {
        }

        e(Y y2) {
            super(y2);
        }
    }

    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Y f2324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        androidx.core.graphics.f[] f2325b;

        f() {
            this(new Y((Y) null));
        }

        protected final void a() {
            androidx.core.graphics.f[] fVarArr = this.f2325b;
            if (fVarArr != null) {
                androidx.core.graphics.f fVarF = fVarArr[m.a(1)];
                androidx.core.graphics.f fVarF2 = this.f2325b[m.a(2)];
                if (fVarF2 == null) {
                    fVarF2 = this.f2324a.f(2);
                }
                if (fVarF == null) {
                    fVarF = this.f2324a.f(1);
                }
                f(androidx.core.graphics.f.a(fVarF, fVarF2));
                androidx.core.graphics.f fVar = this.f2325b[m.a(16)];
                if (fVar != null) {
                    e(fVar);
                }
                androidx.core.graphics.f fVar2 = this.f2325b[m.a(32)];
                if (fVar2 != null) {
                    c(fVar2);
                }
                androidx.core.graphics.f fVar3 = this.f2325b[m.a(64)];
                if (fVar3 != null) {
                    g(fVar3);
                }
            }
        }

        abstract Y b();

        void c(androidx.core.graphics.f fVar) {
        }

        abstract void d(androidx.core.graphics.f fVar);

        void e(androidx.core.graphics.f fVar) {
        }

        abstract void f(androidx.core.graphics.f fVar);

        void g(androidx.core.graphics.f fVar) {
        }

        f(Y y2) {
            this.f2324a = y2;
        }
    }

    private static class g extends l {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static boolean f2326h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static Method f2327i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static Class f2328j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static Field f2329k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static Field f2330l;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final WindowInsets f2331c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private androidx.core.graphics.f[] f2332d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private androidx.core.graphics.f f2333e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Y f2334f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        androidx.core.graphics.f f2335g;

        g(Y y2, WindowInsets windowInsets) {
            super(y2);
            this.f2333e = null;
            this.f2331c = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        private androidx.core.graphics.f t(int i2, boolean z2) {
            androidx.core.graphics.f fVarA = androidx.core.graphics.f.f2199e;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    fVarA = androidx.core.graphics.f.a(fVarA, u(i3, z2));
                }
            }
            return fVarA;
        }

        private androidx.core.graphics.f v() {
            Y y2 = this.f2334f;
            return y2 != null ? y2.g() : androidx.core.graphics.f.f2199e;
        }

        private androidx.core.graphics.f w(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f2326h) {
                x();
            }
            Method method = f2327i;
            if (method != null && f2328j != null && f2329k != null) {
                try {
                    Object objInvoke = method.invoke(view, null);
                    if (objInvoke == null) {
                        return null;
                    }
                    Rect rect = (Rect) f2329k.get(f2330l.get(objInvoke));
                    if (rect != null) {
                        return androidx.core.graphics.f.c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to get visible insets. (Reflection error). ");
                    sb.append(e2.getMessage());
                }
            }
            return null;
        }

        @SuppressLint({"PrivateApi"})
        private static void x() {
            try {
                f2327i = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f2328j = cls;
                f2329k = cls.getDeclaredField("mVisibleInsets");
                f2330l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f2329k.setAccessible(true);
                f2330l.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to get visible insets. (Reflection error). ");
                sb.append(e2.getMessage());
            }
            f2326h = true;
        }

        @Override // androidx.core.view.Y.l
        void d(View view) {
            androidx.core.graphics.f fVarW = w(view);
            if (fVarW == null) {
                fVarW = androidx.core.graphics.f.f2199e;
            }
            q(fVarW);
        }

        @Override // androidx.core.view.Y.l
        void e(Y y2) {
            y2.r(this.f2334f);
            y2.q(this.f2335g);
        }

        @Override // androidx.core.view.Y.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f2335g, ((g) obj).f2335g);
            }
            return false;
        }

        @Override // androidx.core.view.Y.l
        public androidx.core.graphics.f g(int i2) {
            return t(i2, false);
        }

        @Override // androidx.core.view.Y.l
        final androidx.core.graphics.f k() {
            if (this.f2333e == null) {
                this.f2333e = androidx.core.graphics.f.b(this.f2331c.getSystemWindowInsetLeft(), this.f2331c.getSystemWindowInsetTop(), this.f2331c.getSystemWindowInsetRight(), this.f2331c.getSystemWindowInsetBottom());
            }
            return this.f2333e;
        }

        @Override // androidx.core.view.Y.l
        Y m(int i2, int i3, int i4, int i5) {
            b bVar = new b(Y.u(this.f2331c));
            bVar.c(Y.m(k(), i2, i3, i4, i5));
            bVar.b(Y.m(i(), i2, i3, i4, i5));
            return bVar.a();
        }

        @Override // androidx.core.view.Y.l
        boolean o() {
            return this.f2331c.isRound();
        }

        @Override // androidx.core.view.Y.l
        public void p(androidx.core.graphics.f[] fVarArr) {
            this.f2332d = fVarArr;
        }

        @Override // androidx.core.view.Y.l
        void q(androidx.core.graphics.f fVar) {
            this.f2335g = fVar;
        }

        @Override // androidx.core.view.Y.l
        void r(Y y2) {
            this.f2334f = y2;
        }

        protected androidx.core.graphics.f u(int i2, boolean z2) {
            androidx.core.graphics.f fVarG;
            int i3;
            if (i2 == 1) {
                return z2 ? androidx.core.graphics.f.b(0, Math.max(v().f2201b, k().f2201b), 0, 0) : androidx.core.graphics.f.b(0, k().f2201b, 0, 0);
            }
            if (i2 == 2) {
                if (z2) {
                    androidx.core.graphics.f fVarV = v();
                    androidx.core.graphics.f fVarI = i();
                    return androidx.core.graphics.f.b(Math.max(fVarV.f2200a, fVarI.f2200a), 0, Math.max(fVarV.f2202c, fVarI.f2202c), Math.max(fVarV.f2203d, fVarI.f2203d));
                }
                androidx.core.graphics.f fVarK = k();
                Y y2 = this.f2334f;
                fVarG = y2 != null ? y2.g() : null;
                int iMin = fVarK.f2203d;
                if (fVarG != null) {
                    iMin = Math.min(iMin, fVarG.f2203d);
                }
                return androidx.core.graphics.f.b(fVarK.f2200a, 0, fVarK.f2202c, iMin);
            }
            if (i2 != 8) {
                if (i2 == 16) {
                    return j();
                }
                if (i2 == 32) {
                    return h();
                }
                if (i2 == 64) {
                    return l();
                }
                if (i2 != 128) {
                    return androidx.core.graphics.f.f2199e;
                }
                Y y3 = this.f2334f;
                r rVarE = y3 != null ? y3.e() : f();
                return rVarE != null ? androidx.core.graphics.f.b(rVarE.b(), rVarE.d(), rVarE.c(), rVarE.a()) : androidx.core.graphics.f.f2199e;
            }
            androidx.core.graphics.f[] fVarArr = this.f2332d;
            fVarG = fVarArr != null ? fVarArr[m.a(8)] : null;
            if (fVarG != null) {
                return fVarG;
            }
            androidx.core.graphics.f fVarK2 = k();
            androidx.core.graphics.f fVarV2 = v();
            int i4 = fVarK2.f2203d;
            if (i4 > fVarV2.f2203d) {
                return androidx.core.graphics.f.b(0, 0, 0, i4);
            }
            androidx.core.graphics.f fVar = this.f2335g;
            return (fVar == null || fVar.equals(androidx.core.graphics.f.f2199e) || (i3 = this.f2335g.f2203d) <= fVarV2.f2203d) ? androidx.core.graphics.f.f2199e : androidx.core.graphics.f.b(0, 0, 0, i3);
        }

        g(Y y2, g gVar) {
            this(y2, new WindowInsets(gVar.f2331c));
        }
    }

    private static class h extends g {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private androidx.core.graphics.f f2336m;

        h(Y y2, WindowInsets windowInsets) {
            super(y2, windowInsets);
            this.f2336m = null;
        }

        @Override // androidx.core.view.Y.l
        Y b() {
            return Y.u(this.f2331c.consumeStableInsets());
        }

        @Override // androidx.core.view.Y.l
        Y c() {
            return Y.u(this.f2331c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.Y.l
        final androidx.core.graphics.f i() {
            if (this.f2336m == null) {
                this.f2336m = androidx.core.graphics.f.b(this.f2331c.getStableInsetLeft(), this.f2331c.getStableInsetTop(), this.f2331c.getStableInsetRight(), this.f2331c.getStableInsetBottom());
            }
            return this.f2336m;
        }

        @Override // androidx.core.view.Y.l
        boolean n() {
            return this.f2331c.isConsumed();
        }

        @Override // androidx.core.view.Y.l
        public void s(androidx.core.graphics.f fVar) {
            this.f2336m = fVar;
        }

        h(Y y2, h hVar) {
            super(y2, hVar);
            this.f2336m = null;
            this.f2336m = hVar.f2336m;
        }
    }

    private static class i extends h {
        i(Y y2, WindowInsets windowInsets) {
            super(y2, windowInsets);
        }

        @Override // androidx.core.view.Y.l
        Y a() {
            return Y.u(this.f2331c.consumeDisplayCutout());
        }

        @Override // androidx.core.view.Y.g, androidx.core.view.Y.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f2331c, iVar.f2331c) && Objects.equals(this.f2335g, iVar.f2335g);
        }

        @Override // androidx.core.view.Y.l
        r f() {
            return r.e(this.f2331c.getDisplayCutout());
        }

        @Override // androidx.core.view.Y.l
        public int hashCode() {
            return this.f2331c.hashCode();
        }

        i(Y y2, i iVar) {
            super(y2, iVar);
        }
    }

    private static class j extends i {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private androidx.core.graphics.f f2337n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private androidx.core.graphics.f f2338o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private androidx.core.graphics.f f2339p;

        j(Y y2, WindowInsets windowInsets) {
            super(y2, windowInsets);
            this.f2337n = null;
            this.f2338o = null;
            this.f2339p = null;
        }

        @Override // androidx.core.view.Y.l
        androidx.core.graphics.f h() {
            if (this.f2338o == null) {
                this.f2338o = androidx.core.graphics.f.d(this.f2331c.getMandatorySystemGestureInsets());
            }
            return this.f2338o;
        }

        @Override // androidx.core.view.Y.l
        androidx.core.graphics.f j() {
            if (this.f2337n == null) {
                this.f2337n = androidx.core.graphics.f.d(this.f2331c.getSystemGestureInsets());
            }
            return this.f2337n;
        }

        @Override // androidx.core.view.Y.l
        androidx.core.graphics.f l() {
            if (this.f2339p == null) {
                this.f2339p = androidx.core.graphics.f.d(this.f2331c.getTappableElementInsets());
            }
            return this.f2339p;
        }

        @Override // androidx.core.view.Y.g, androidx.core.view.Y.l
        Y m(int i2, int i3, int i4, int i5) {
            return Y.u(this.f2331c.inset(i2, i3, i4, i5));
        }

        @Override // androidx.core.view.Y.h, androidx.core.view.Y.l
        public void s(androidx.core.graphics.f fVar) {
        }

        j(Y y2, j jVar) {
            super(y2, jVar);
            this.f2337n = null;
            this.f2338o = null;
            this.f2339p = null;
        }
    }

    private static class k extends j {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        static final Y f2340q = Y.u(WindowInsets.CONSUMED);

        k(Y y2, WindowInsets windowInsets) {
            super(y2, windowInsets);
        }

        @Override // androidx.core.view.Y.g, androidx.core.view.Y.l
        final void d(View view) {
        }

        @Override // androidx.core.view.Y.g, androidx.core.view.Y.l
        public androidx.core.graphics.f g(int i2) {
            return androidx.core.graphics.f.d(this.f2331c.getInsets(n.a(i2)));
        }

        k(Y y2, k kVar) {
            super(y2, kVar);
        }
    }

    private static class l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Y f2341b = new b().a().a().b().c();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Y f2342a;

        l(Y y2) {
            this.f2342a = y2;
        }

        Y a() {
            return this.f2342a;
        }

        Y b() {
            return this.f2342a;
        }

        Y c() {
            return this.f2342a;
        }

        void d(View view) {
        }

        void e(Y y2) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return o() == lVar.o() && n() == lVar.n() && AbstractC0234c.a(k(), lVar.k()) && AbstractC0234c.a(i(), lVar.i()) && AbstractC0234c.a(f(), lVar.f());
        }

        r f() {
            return null;
        }

        androidx.core.graphics.f g(int i2) {
            return androidx.core.graphics.f.f2199e;
        }

        androidx.core.graphics.f h() {
            return k();
        }

        public int hashCode() {
            return AbstractC0234c.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        androidx.core.graphics.f i() {
            return androidx.core.graphics.f.f2199e;
        }

        androidx.core.graphics.f j() {
            return k();
        }

        androidx.core.graphics.f k() {
            return androidx.core.graphics.f.f2199e;
        }

        androidx.core.graphics.f l() {
            return k();
        }

        Y m(int i2, int i3, int i4, int i5) {
            return f2341b;
        }

        boolean n() {
            return false;
        }

        boolean o() {
            return false;
        }

        public void p(androidx.core.graphics.f[] fVarArr) {
        }

        void q(androidx.core.graphics.f fVar) {
        }

        void r(Y y2) {
        }

        public void s(androidx.core.graphics.f fVar) {
        }
    }

    public static final class m {
        static int a(int i2) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 4) {
                return 2;
            }
            if (i2 == 8) {
                return 3;
            }
            if (i2 == 16) {
                return 4;
            }
            if (i2 == 32) {
                return 5;
            }
            if (i2 == 64) {
                return 6;
            }
            if (i2 == 128) {
                return 7;
            }
            if (i2 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i2);
        }
    }

    private static final class n {
        static int a(int i2) {
            int iStatusBars;
            int i3 = 0;
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i2 & i4) != 0) {
                    if (i4 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i4 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i4 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i4 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i4 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i4 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i4 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i4 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i3 |= iStatusBars;
                }
            }
            return i3;
        }
    }

    static {
        f2310b = Build.VERSION.SDK_INT >= 30 ? k.f2340q : l.f2341b;
    }

    private Y(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        this.f2311a = i2 >= 30 ? new k(this, windowInsets) : i2 >= 29 ? new j(this, windowInsets) : i2 >= 28 ? new i(this, windowInsets) : new h(this, windowInsets);
    }

    static androidx.core.graphics.f m(androidx.core.graphics.f fVar, int i2, int i3, int i4, int i5) {
        int iMax = Math.max(0, fVar.f2200a - i2);
        int iMax2 = Math.max(0, fVar.f2201b - i3);
        int iMax3 = Math.max(0, fVar.f2202c - i4);
        int iMax4 = Math.max(0, fVar.f2203d - i5);
        return (iMax == i2 && iMax2 == i3 && iMax3 == i4 && iMax4 == i5) ? fVar : androidx.core.graphics.f.b(iMax, iMax2, iMax3, iMax4);
    }

    public static Y u(WindowInsets windowInsets) {
        return v(windowInsets, null);
    }

    public static Y v(WindowInsets windowInsets, View view) {
        Y y2 = new Y((WindowInsets) AbstractC0236e.f(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            y2.r(L.z(view));
            y2.d(view.getRootView());
        }
        return y2;
    }

    public Y a() {
        return this.f2311a.a();
    }

    public Y b() {
        return this.f2311a.b();
    }

    public Y c() {
        return this.f2311a.c();
    }

    void d(View view) {
        this.f2311a.d(view);
    }

    public r e() {
        return this.f2311a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Y) {
            return AbstractC0234c.a(this.f2311a, ((Y) obj).f2311a);
        }
        return false;
    }

    public androidx.core.graphics.f f(int i2) {
        return this.f2311a.g(i2);
    }

    public androidx.core.graphics.f g() {
        return this.f2311a.i();
    }

    public int h() {
        return this.f2311a.k().f2203d;
    }

    public int hashCode() {
        l lVar = this.f2311a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public int i() {
        return this.f2311a.k().f2200a;
    }

    public int j() {
        return this.f2311a.k().f2202c;
    }

    public int k() {
        return this.f2311a.k().f2201b;
    }

    public Y l(int i2, int i3, int i4, int i5) {
        return this.f2311a.m(i2, i3, i4, i5);
    }

    public boolean n() {
        return this.f2311a.n();
    }

    public Y o(int i2, int i3, int i4, int i5) {
        return new b(this).c(androidx.core.graphics.f.b(i2, i3, i4, i5)).a();
    }

    void p(androidx.core.graphics.f[] fVarArr) {
        this.f2311a.p(fVarArr);
    }

    void q(androidx.core.graphics.f fVar) {
        this.f2311a.q(fVar);
    }

    void r(Y y2) {
        this.f2311a.r(y2);
    }

    void s(androidx.core.graphics.f fVar) {
        this.f2311a.s(fVar);
    }

    public WindowInsets t() {
        l lVar = this.f2311a;
        if (lVar instanceof g) {
            return ((g) lVar).f2331c;
        }
        return null;
    }

    public Y(Y y2) {
        if (y2 == null) {
            this.f2311a = new l(this);
            return;
        }
        l lVar = y2.f2311a;
        int i2 = Build.VERSION.SDK_INT;
        this.f2311a = (i2 < 30 || !(lVar instanceof k)) ? (i2 < 29 || !(lVar instanceof j)) ? (i2 < 28 || !(lVar instanceof i)) ? lVar instanceof h ? new h(this, (h) lVar) : lVar instanceof g ? new g(this, (g) lVar) : new l(this) : new i(this, (i) lVar) : new j(this, (j) lVar) : new k(this, (k) lVar);
        lVar.e(this);
    }
}
