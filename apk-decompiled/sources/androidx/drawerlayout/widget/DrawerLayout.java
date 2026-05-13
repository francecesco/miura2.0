package androidx.drawerlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AbstractC0154s;
import androidx.core.view.C0137a;
import androidx.core.view.L;
import it.tervis.miura.model.Peripheral;
import java.util.ArrayList;
import java.util.List;
import p.C;
import t.AbstractC0251a;
import u.C0252a;

/* JADX INFO: loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private static final int[] f2459L = {R.attr.colorPrimaryDark};

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    static final int[] f2460M = {R.attr.layout_gravity};

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    static final boolean f2461N = true;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private static final boolean f2462O = true;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private CharSequence f2463A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private CharSequence f2464B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private Object f2465C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private boolean f2466D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private Drawable f2467E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private Drawable f2468F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private Drawable f2469G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private Drawable f2470H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private final ArrayList f2471I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private Rect f2472J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private Matrix f2473K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f2474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f2475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f2478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f2479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final C0252a f2480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final C0252a f2481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final g f2482i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final g f2483j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f2484k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f2485l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f2486m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f2487n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f2488o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f2489p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f2490q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f2491r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f2492s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private d f2493t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private List f2494u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f2495v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f2496w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Drawable f2497x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Drawable f2498y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Drawable f2499z;

    class a implements View.OnApplyWindowInsetsListener {
        a() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).S(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    class b extends C0137a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Rect f2501d = new Rect();

        b() {
        }

        private void n(C c2, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (DrawerLayout.A(childAt)) {
                    c2.c(childAt);
                }
            }
        }

        private void o(C c2, C c3) {
            Rect rect = this.f2501d;
            c3.l(rect);
            c2.d0(rect);
            c3.m(rect);
            c2.e0(rect);
            c2.v0(c3.V());
            c2.n0(c3.w());
            c2.f0(c3.o());
            c2.h0(c3.r());
            c2.i0(c3.L());
            c2.g0(c3.J());
            c2.j0(c3.M());
            c2.k0(c3.N());
            c2.b0(c3.G());
            c2.s0(c3.T());
            c2.m0(c3.Q());
            c2.a(c3.j());
        }

        @Override // androidx.core.view.C0137a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.a(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View viewP = DrawerLayout.this.p();
            if (viewP == null) {
                return true;
            }
            CharSequence charSequenceS = DrawerLayout.this.s(DrawerLayout.this.t(viewP));
            if (charSequenceS == null) {
                return true;
            }
            text.add(charSequenceS);
            return true;
        }

        @Override // androidx.core.view.C0137a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        @Override // androidx.core.view.C0137a
        public void g(View view, C c2) {
            if (DrawerLayout.f2461N) {
                super.g(view, c2);
            } else {
                C cW = C.W(c2);
                super.g(view, cW);
                c2.t0(view);
                Object objY = L.y(view);
                if (objY instanceof View) {
                    c2.p0((View) objY);
                }
                o(c2, cW);
                cW.Y();
                n(c2, (ViewGroup) view);
            }
            c2.f0(DrawerLayout.class.getName());
            c2.j0(false);
            c2.k0(false);
            c2.Z(C.a.f3948d);
            c2.Z(C.a.f3949e);
        }

        @Override // androidx.core.view.C0137a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.f2461N || DrawerLayout.A(view)) {
                return super.i(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    static final class c extends C0137a {
        c() {
        }

        @Override // androidx.core.view.C0137a
        public void g(View view, C c2) {
            super.g(view, c2);
            if (DrawerLayout.A(view)) {
                return;
            }
            c2.p0(null);
        }
    }

    public interface d {
        void a(int i2);

        void b(View view);

        void c(View view, float f2);

        void d(View view);
    }

    public static class e extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f2504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f2505c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2506d;

        public e(int i2, int i3) {
            super(i2, i3);
            this.f2503a = 0;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2503a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f2460M);
            this.f2503a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2503a = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2503a = 0;
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.f2503a = 0;
            this.f2503a = eVar.f2503a;
        }
    }

    protected static class f extends AbstractC0251a {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2507c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2508d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f2509e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f2510f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f2511g;

        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new f(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i2) {
                return new f[i2];
            }
        }

        public f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2507c = 0;
            this.f2507c = parcel.readInt();
            this.f2508d = parcel.readInt();
            this.f2509e = parcel.readInt();
            this.f2510f = parcel.readInt();
            this.f2511g = parcel.readInt();
        }

        @Override // t.AbstractC0251a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f2507c);
            parcel.writeInt(this.f2508d);
            parcel.writeInt(this.f2509e);
            parcel.writeInt(this.f2510f);
            parcel.writeInt(this.f2511g);
        }

        public f(Parcelable parcelable) {
            super(parcelable);
            this.f2507c = 0;
        }
    }

    private class g extends C0252a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f2512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private C0252a f2513b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f2514c = new a();

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.o();
            }
        }

        g(int i2) {
            this.f2512a = i2;
        }

        private void n() {
            View viewN = DrawerLayout.this.n(this.f2512a == 3 ? 5 : 3);
            if (viewN != null) {
                DrawerLayout.this.f(viewN);
            }
        }

        @Override // u.C0252a.c
        public int a(View view, int i2, int i3) {
            int width;
            int width2;
            if (DrawerLayout.this.c(view, 3)) {
                width2 = -view.getWidth();
                width = 0;
            } else {
                width = DrawerLayout.this.getWidth();
                width2 = width - view.getWidth();
            }
            return Math.max(width2, Math.min(i2, width));
        }

        @Override // u.C0252a.c
        public int b(View view, int i2, int i3) {
            return view.getTop();
        }

        @Override // u.C0252a.c
        public int d(View view) {
            if (DrawerLayout.this.E(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // u.C0252a.c
        public void f(int i2, int i3) {
            DrawerLayout drawerLayout;
            int i4;
            if ((i2 & 1) == 1) {
                drawerLayout = DrawerLayout.this;
                i4 = 3;
            } else {
                drawerLayout = DrawerLayout.this;
                i4 = 5;
            }
            View viewN = drawerLayout.n(i4);
            if (viewN == null || DrawerLayout.this.r(viewN) != 0) {
                return;
            }
            this.f2513b.b(viewN, i3);
        }

        @Override // u.C0252a.c
        public boolean g(int i2) {
            return false;
        }

        @Override // u.C0252a.c
        public void h(int i2, int i3) {
            DrawerLayout.this.postDelayed(this.f2514c, 160L);
        }

        @Override // u.C0252a.c
        public void i(View view, int i2) {
            ((e) view.getLayoutParams()).f2505c = false;
            n();
        }

        @Override // u.C0252a.c
        public void j(int i2) {
            DrawerLayout.this.W(this.f2512a, i2, this.f2513b.v());
        }

        @Override // u.C0252a.c
        public void k(View view, int i2, int i3, int i4, int i5) {
            float width = (DrawerLayout.this.c(view, 3) ? i2 + r3 : DrawerLayout.this.getWidth() - i2) / view.getWidth();
            DrawerLayout.this.U(view, width);
            view.setVisibility(width == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // u.C0252a.c
        public void l(View view, float f2, float f3) {
            int i2;
            float fU = DrawerLayout.this.u(view);
            int width = view.getWidth();
            if (DrawerLayout.this.c(view, 3)) {
                i2 = (f2 > 0.0f || (f2 == 0.0f && fU > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f2 < 0.0f || (f2 == 0.0f && fU > 0.5f)) {
                    width2 -= width;
                }
                i2 = width2;
            }
            this.f2513b.M(i2, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // u.C0252a.c
        public boolean m(View view, int i2) {
            return DrawerLayout.this.E(view) && DrawerLayout.this.c(view, this.f2512a) && DrawerLayout.this.r(view) == 0;
        }

        void o() {
            View viewN;
            int width;
            int iW = this.f2513b.w();
            boolean z2 = this.f2512a == 3;
            if (z2) {
                viewN = DrawerLayout.this.n(3);
                width = (viewN != null ? -viewN.getWidth() : 0) + iW;
            } else {
                viewN = DrawerLayout.this.n(5);
                width = DrawerLayout.this.getWidth() - iW;
            }
            if (viewN != null) {
                if (((!z2 || viewN.getLeft() >= width) && (z2 || viewN.getLeft() <= width)) || DrawerLayout.this.r(viewN) != 0) {
                    return;
                }
                e eVar = (e) viewN.getLayoutParams();
                this.f2513b.O(viewN, width, viewN.getTop());
                eVar.f2505c = true;
                DrawerLayout.this.invalidate();
                n();
                DrawerLayout.this.b();
            }
        }

        public void p() {
            DrawerLayout.this.removeCallbacks(this.f2514c);
        }

        public void q(C0252a c0252a) {
            this.f2513b = c0252a;
        }
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    static boolean A(View view) {
        return (L.u(view) == 4 || L.u(view) == 2) ? false : true;
    }

    private boolean H(float f2, float f3, View view) {
        if (this.f2472J == null) {
            this.f2472J = new Rect();
        }
        view.getHitRect(this.f2472J);
        return this.f2472J.contains((int) f2, (int) f3);
    }

    private boolean I(Drawable drawable, int i2) {
        if (drawable == null || !androidx.core.graphics.drawable.a.g(drawable)) {
            return false;
        }
        androidx.core.graphics.drawable.a.l(drawable, i2);
        return true;
    }

    private Drawable P() {
        int iV = L.v(this);
        if (iV == 0) {
            Drawable drawable = this.f2467E;
            if (drawable != null) {
                I(drawable, iV);
                return this.f2467E;
            }
        } else {
            Drawable drawable2 = this.f2468F;
            if (drawable2 != null) {
                I(drawable2, iV);
                return this.f2468F;
            }
        }
        return this.f2469G;
    }

    private Drawable Q() {
        int iV = L.v(this);
        if (iV == 0) {
            Drawable drawable = this.f2468F;
            if (drawable != null) {
                I(drawable, iV);
                return this.f2468F;
            }
        } else {
            Drawable drawable2 = this.f2467E;
            if (drawable2 != null) {
                I(drawable2, iV);
                return this.f2467E;
            }
        }
        return this.f2470H;
    }

    private void R() {
        if (f2462O) {
            return;
        }
        this.f2498y = P();
        this.f2499z = Q();
    }

    private void V(View view, boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            L.a0(childAt, ((z2 || E(childAt)) && !(z2 && childAt == view)) ? 4 : 1);
        }
    }

    private boolean m(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent motionEventV = v(motionEvent, view);
            boolean zDispatchGenericMotionEvent = view.dispatchGenericMotionEvent(motionEventV);
            motionEventV.recycle();
            return zDispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean zDispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return zDispatchGenericMotionEvent2;
    }

    private MotionEvent v(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.f2473K == null) {
                this.f2473K = new Matrix();
            }
            matrix.invert(this.f2473K);
            motionEventObtain.transform(this.f2473K);
        }
        return motionEventObtain;
    }

    static String w(int i2) {
        return (i2 & 3) == 3 ? "LEFT" : (i2 & 5) == 5 ? "RIGHT" : Integer.toHexString(i2);
    }

    private static boolean x(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    private boolean y() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((e) getChildAt(i2).getLayoutParams()).f2505c) {
                return true;
            }
        }
        return false;
    }

    private boolean z() {
        return p() != null;
    }

    boolean B(View view) {
        return ((e) view.getLayoutParams()).f2503a == 0;
    }

    public boolean C(int i2) {
        View viewN = n(i2);
        if (viewN != null) {
            return D(viewN);
        }
        return false;
    }

    public boolean D(View view) {
        if (E(view)) {
            return (((e) view.getLayoutParams()).f2506d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    boolean E(View view) {
        int iA = AbstractC0154s.a(((e) view.getLayoutParams()).f2503a, L.v(view));
        return ((iA & 3) == 0 && (iA & 5) == 0) ? false : true;
    }

    public boolean F(int i2) {
        View viewN = n(i2);
        if (viewN != null) {
            return G(viewN);
        }
        return false;
    }

    public boolean G(View view) {
        if (E(view)) {
            return ((e) view.getLayoutParams()).f2504b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    void J(View view, float f2) {
        float fU = u(view);
        float width = view.getWidth();
        int i2 = ((int) (width * f2)) - ((int) (fU * width));
        if (!c(view, 3)) {
            i2 = -i2;
        }
        view.offsetLeftAndRight(i2);
        U(view, f2);
    }

    public void K(int i2) {
        L(i2, true);
    }

    public void L(int i2, boolean z2) {
        View viewN = n(i2);
        if (viewN != null) {
            N(viewN, z2);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + w(i2));
    }

    public void M(View view) {
        N(view, true);
    }

    public void N(View view, boolean z2) {
        if (!E(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        e eVar = (e) view.getLayoutParams();
        if (this.f2486m) {
            eVar.f2504b = 1.0f;
            eVar.f2506d = 1;
            V(view, true);
        } else if (z2) {
            eVar.f2506d |= 2;
            if (c(view, 3)) {
                this.f2480g.O(view, 0, view.getTop());
            } else {
                this.f2481h.O(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            J(view, 1.0f);
            W(eVar.f2503a, 0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void O(d dVar) {
        List list;
        if (dVar == null || (list = this.f2494u) == null) {
            return;
        }
        list.remove(dVar);
    }

    public void S(Object obj, boolean z2) {
        this.f2465C = obj;
        this.f2466D = z2;
        setWillNotDraw(!z2 && getBackground() == null);
        requestLayout();
    }

    public void T(int i2, int i3) {
        View viewN;
        int iA = AbstractC0154s.a(i3, L.v(this));
        if (i3 == 3) {
            this.f2487n = i2;
        } else if (i3 == 5) {
            this.f2488o = i2;
        } else if (i3 == 8388611) {
            this.f2489p = i2;
        } else if (i3 == 8388613) {
            this.f2490q = i2;
        }
        if (i2 != 0) {
            (iA == 3 ? this.f2480g : this.f2481h).a();
        }
        if (i2 != 1) {
            if (i2 == 2 && (viewN = n(iA)) != null) {
                M(viewN);
                return;
            }
            return;
        }
        View viewN2 = n(iA);
        if (viewN2 != null) {
            f(viewN2);
        }
    }

    void U(View view, float f2) {
        e eVar = (e) view.getLayoutParams();
        if (f2 == eVar.f2504b) {
            return;
        }
        eVar.f2504b = f2;
        l(view, f2);
    }

    void W(int i2, int i3, View view) {
        int i4;
        int iZ = this.f2480g.z();
        int iZ2 = this.f2481h.z();
        if (iZ == 1 || iZ2 == 1) {
            i4 = 1;
        } else {
            i4 = 2;
            if (iZ != 2 && iZ2 != 2) {
                i4 = 0;
            }
        }
        if (view != null && i3 == 0) {
            float f2 = ((e) view.getLayoutParams()).f2504b;
            if (f2 == 0.0f) {
                j(view);
            } else if (f2 == 1.0f) {
                k(view);
            }
        }
        if (i4 != this.f2484k) {
            this.f2484k = i4;
            List list = this.f2494u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((d) this.f2494u.get(size)).a(i4);
                }
            }
        }
    }

    public void a(d dVar) {
        if (dVar == null) {
            return;
        }
        if (this.f2494u == null) {
            this.f2494u = new ArrayList();
        }
        this.f2494u.add(dVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i2, int i3) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (!E(childAt)) {
                this.f2471I.add(childAt);
            } else if (D(childAt)) {
                childAt.addFocusables(arrayList, i2, i3);
                z2 = true;
            }
        }
        if (!z2) {
            int size = this.f2471I.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view = (View) this.f2471I.get(i5);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i2, i3);
                }
            }
        }
        this.f2471I.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        L.a0(view, (o() != null || E(view)) ? 4 : 1);
        if (f2461N) {
            return;
        }
        L.U(view, this.f2474a);
    }

    void b() {
        if (this.f2492s) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).dispatchTouchEvent(motionEventObtain);
        }
        motionEventObtain.recycle();
        this.f2492s = true;
    }

    boolean c(View view, int i2) {
        return (t(view) & i2) == i2;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            fMax = Math.max(fMax, ((e) getChildAt(i2).getLayoutParams()).f2504b);
        }
        this.f2478e = fMax;
        boolean zM = this.f2480g.m(true);
        boolean zM2 = this.f2481h.m(true);
        if (zM || zM2) {
            L.O(this);
        }
    }

    public void d(int i2) {
        e(i2, true);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f2478e <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            View childAt = getChildAt(i2);
            if (H(x2, y2, childAt) && !B(childAt) && m(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        Drawable drawable;
        int height = getHeight();
        boolean zB = B(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i2 = 0;
        if (zB) {
            int childCount = getChildCount();
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != view && childAt.getVisibility() == 0 && x(childAt) && E(childAt) && childAt.getHeight() >= height) {
                    if (c(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i3) {
                            i3 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i3, 0, width, getHeight());
            i2 = i3;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(iSave);
        float f2 = this.f2478e;
        if (f2 <= 0.0f || !zB) {
            if (this.f2498y != null && c(view, 3)) {
                int intrinsicWidth = this.f2498y.getIntrinsicWidth();
                int right2 = view.getRight();
                float fMax = Math.max(0.0f, Math.min(right2 / this.f2480g.w(), 1.0f));
                this.f2498y.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
                this.f2498y.setAlpha((int) (fMax * 255.0f));
                drawable = this.f2498y;
            } else if (this.f2499z != null && c(view, 5)) {
                int intrinsicWidth2 = this.f2499z.getIntrinsicWidth();
                int left2 = view.getLeft();
                float fMax2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f2481h.w(), 1.0f));
                this.f2499z.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
                this.f2499z.setAlpha((int) (fMax2 * 255.0f));
                drawable = this.f2499z;
            }
            drawable.draw(canvas);
        } else {
            this.f2479f.setColor((this.f2477d & 16777215) | (((int) ((((-16777216) & r2) >>> 24) * f2)) << 24));
            canvas.drawRect(i2, 0.0f, width, getHeight(), this.f2479f);
        }
        return zDrawChild;
    }

    public void e(int i2, boolean z2) {
        View viewN = n(i2);
        if (viewN != null) {
            g(viewN, z2);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + w(i2));
    }

    public void f(View view) {
        g(view, true);
    }

    public void g(View view, boolean z2) {
        C0252a c0252a;
        int width;
        if (!E(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        e eVar = (e) view.getLayoutParams();
        if (this.f2486m) {
            eVar.f2504b = 0.0f;
            eVar.f2506d = 0;
        } else if (z2) {
            eVar.f2506d |= 4;
            if (c(view, 3)) {
                c0252a = this.f2480g;
                width = -view.getWidth();
            } else {
                c0252a = this.f2481h;
                width = getWidth();
            }
            c0252a.O(view, width, view.getTop());
        } else {
            J(view, 0.0f);
            W(eVar.f2503a, 0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public float getDrawerElevation() {
        if (f2462O) {
            return this.f2475b;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f2497x;
    }

    public void h() {
        i(false);
    }

    void i(boolean z2) {
        int childCount = getChildCount();
        boolean zO = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            e eVar = (e) childAt.getLayoutParams();
            if (E(childAt) && (!z2 || eVar.f2505c)) {
                zO |= c(childAt, 3) ? this.f2480g.O(childAt, -childAt.getWidth(), childAt.getTop()) : this.f2481h.O(childAt, getWidth(), childAt.getTop());
                eVar.f2505c = false;
            }
        }
        this.f2482i.p();
        this.f2483j.p();
        if (zO) {
            invalidate();
        }
    }

    void j(View view) {
        View rootView;
        e eVar = (e) view.getLayoutParams();
        if ((eVar.f2506d & 1) == 1) {
            eVar.f2506d = 0;
            List list = this.f2494u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((d) this.f2494u.get(size)).d(view);
                }
            }
            V(view, false);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    void k(View view) {
        e eVar = (e) view.getLayoutParams();
        if ((eVar.f2506d & 1) == 0) {
            eVar.f2506d = 1;
            List list = this.f2494u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((d) this.f2494u.get(size)).b(view);
                }
            }
            V(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void l(View view, float f2) {
        List list = this.f2494u;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((d) this.f2494u.get(size)).c(view, f2);
            }
        }
    }

    View n(int i2) {
        int iA = AbstractC0154s.a(i2, L.v(this)) & 7;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((t(childAt) & 7) == iA) {
                return childAt;
            }
        }
        return null;
    }

    View o() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((((e) childAt.getLayoutParams()).f2506d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2486m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2486m = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f2466D || this.f2497x == null) {
            return;
        }
        Object obj = this.f2465C;
        int systemWindowInsetTop = obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.f2497x.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.f2497x.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            u.a r1 = r6.f2480g
            boolean r1 = r1.N(r7)
            u.a r2 = r6.f2481h
            boolean r2 = r2.N(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L3a
            if (r0 == r2) goto L31
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L1e
            if (r0 == r4) goto L31
            goto L38
        L1e:
            u.a r7 = r6.f2480g
            boolean r7 = r7.d(r4)
            if (r7 == 0) goto L38
            androidx.drawerlayout.widget.DrawerLayout$g r7 = r6.f2482i
            r7.p()
            androidx.drawerlayout.widget.DrawerLayout$g r7 = r6.f2483j
            r7.p()
            goto L38
        L31:
            r6.i(r2)
            r6.f2491r = r3
            r6.f2492s = r3
        L38:
            r7 = 0
            goto L64
        L3a:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f2495v = r0
            r6.f2496w = r7
            float r4 = r6.f2478e
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L5f
            u.a r4 = r6.f2480g
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.t(r0, r7)
            if (r7 == 0) goto L5f
            boolean r7 = r6.B(r7)
            if (r7 == 0) goto L5f
            r7 = 1
            goto L60
        L5f:
            r7 = 0
        L60:
            r6.f2491r = r3
            r6.f2492s = r3
        L64:
            if (r1 != 0) goto L74
            if (r7 != 0) goto L74
            boolean r7 = r6.y()
            if (r7 != 0) goto L74
            boolean r7 = r6.f2492s
            if (r7 == 0) goto L73
            goto L74
        L73:
            r2 = 0
        L74:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !z()) {
            return super.onKeyDown(i2, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        View viewP = p();
        if (viewP != null && r(viewP) == 0) {
            h();
        }
        return viewP != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        float f2;
        int i6;
        int measuredHeight;
        int i7;
        int i8;
        this.f2485l = true;
        int i9 = i4 - i2;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (B(childAt)) {
                    int i11 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
                    childAt.layout(i11, ((ViewGroup.MarginLayoutParams) eVar).topMargin, childAt.getMeasuredWidth() + i11, ((ViewGroup.MarginLayoutParams) eVar).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight2 = childAt.getMeasuredHeight();
                    if (c(childAt, 3)) {
                        float f3 = measuredWidth;
                        i6 = (-measuredWidth) + ((int) (eVar.f2504b * f3));
                        f2 = (measuredWidth + i6) / f3;
                    } else {
                        float f4 = measuredWidth;
                        f2 = (i9 - r11) / f4;
                        i6 = i9 - ((int) (eVar.f2504b * f4));
                    }
                    boolean z3 = f2 != eVar.f2504b;
                    int i12 = eVar.f2503a & 112;
                    if (i12 != 16) {
                        if (i12 != 80) {
                            measuredHeight = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                            i7 = measuredWidth + i6;
                            i8 = measuredHeight2 + measuredHeight;
                        } else {
                            int i13 = i5 - i3;
                            measuredHeight = (i13 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - childAt.getMeasuredHeight();
                            i7 = measuredWidth + i6;
                            i8 = i13 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                        }
                        childAt.layout(i6, measuredHeight, i7, i8);
                    } else {
                        int i14 = i5 - i3;
                        int i15 = (i14 - measuredHeight2) / 2;
                        int i16 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                        if (i15 < i16) {
                            i15 = i16;
                        } else {
                            int i17 = i15 + measuredHeight2;
                            int i18 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                            if (i17 > i14 - i18) {
                                i15 = (i14 - i18) - measuredHeight2;
                            }
                        }
                        childAt.layout(i6, i15, measuredWidth + i6, measuredHeight2 + i15);
                    }
                    if (z3) {
                        U(childAt, f2);
                    }
                    int i19 = eVar.f2504b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i19) {
                        childAt.setVisibility(i19);
                    }
                }
            }
        }
        this.f2485l = false;
        this.f2486m = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
            if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        boolean z2 = this.f2465C != null && L.t(this);
        int iV = L.v(this);
        int childCount = getChildCount();
        boolean z3 = false;
        boolean z4 = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (z2) {
                    int iA = AbstractC0154s.a(eVar.f2503a, iV);
                    boolean zT = L.t(childAt);
                    WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) this.f2465C;
                    if (zT) {
                        if (iA == 3) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        } else if (iA == 5) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
                    } else {
                        if (iA == 3) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        } else if (iA == 5) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) eVar).leftMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) eVar).topMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom();
                    }
                }
                if (B(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) eVar).leftMargin) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) eVar).topMargin) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin, 1073741824));
                } else {
                    if (!E(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i4 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (f2462O) {
                        float fQ = L.q(childAt);
                        float f2 = this.f2475b;
                        if (fQ != f2) {
                            L.Z(childAt, f2);
                        }
                    }
                    int iT = t(childAt) & 7;
                    boolean z5 = iT == 3;
                    if ((z5 && z3) || (!z5 && z4)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + w(iT) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z5) {
                        z3 = true;
                    } else {
                        z4 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i2, this.f2476c + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin, ((ViewGroup.MarginLayoutParams) eVar).width), ViewGroup.getChildMeasureSpec(i3, ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin, ((ViewGroup.MarginLayoutParams) eVar).height));
                }
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View viewN;
        if (!(parcelable instanceof f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.a());
        int i2 = fVar.f2507c;
        if (i2 != 0 && (viewN = n(i2)) != null) {
            M(viewN);
        }
        int i3 = fVar.f2508d;
        if (i3 != 3) {
            T(i3, 3);
        }
        int i4 = fVar.f2509e;
        if (i4 != 3) {
            T(i4, 5);
        }
        int i5 = fVar.f2510f;
        if (i5 != 3) {
            T(i5, 8388611);
        }
        int i6 = fVar.f2511g;
        if (i6 != 3) {
            T(i6, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        R();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            e eVar = (e) getChildAt(i2).getLayoutParams();
            int i3 = eVar.f2506d;
            boolean z2 = i3 == 1;
            boolean z3 = i3 == 2;
            if (z2 || z3) {
                fVar.f2507c = eVar.f2503a;
                break;
            }
        }
        fVar.f2508d = this.f2487n;
        fVar.f2509e = this.f2488o;
        fVar.f2510f = this.f2489p;
        fVar.f2511g = this.f2490q;
        return fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            u.a r0 = r6.f2480g
            r0.E(r7)
            u.a r0 = r6.f2481h
            r0.E(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L69
            if (r0 == r2) goto L22
            r7 = 3
            if (r0 == r7) goto L1a
            goto L76
        L1a:
            r6.i(r2)
        L1d:
            r6.f2491r = r1
            r6.f2492s = r1
            goto L76
        L22:
            float r0 = r7.getX()
            float r7 = r7.getY()
            u.a r3 = r6.f2480g
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.t(r4, r5)
            if (r3 == 0) goto L62
            boolean r3 = r6.B(r3)
            if (r3 == 0) goto L62
            float r3 = r6.f2495v
            float r0 = r0 - r3
            float r3 = r6.f2496w
            float r7 = r7 - r3
            u.a r3 = r6.f2480g
            int r3 = r3.y()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L62
            android.view.View r7 = r6.o()
            if (r7 == 0) goto L62
            int r7 = r6.r(r7)
            r0 = 2
            if (r7 != r0) goto L60
            goto L62
        L60:
            r7 = 0
            goto L63
        L62:
            r7 = 1
        L63:
            r6.i(r7)
            r6.f2491r = r1
            goto L76
        L69:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f2495v = r0
            r6.f2496w = r7
            goto L1d
        L76:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    View p() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (E(childAt) && G(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public int q(int i2) {
        int iV = L.v(this);
        if (i2 == 3) {
            int i3 = this.f2487n;
            if (i3 != 3) {
                return i3;
            }
            int i4 = iV == 0 ? this.f2489p : this.f2490q;
            if (i4 != 3) {
                return i4;
            }
            return 0;
        }
        if (i2 == 5) {
            int i5 = this.f2488o;
            if (i5 != 3) {
                return i5;
            }
            int i6 = iV == 0 ? this.f2490q : this.f2489p;
            if (i6 != 3) {
                return i6;
            }
            return 0;
        }
        if (i2 == 8388611) {
            int i7 = this.f2489p;
            if (i7 != 3) {
                return i7;
            }
            int i8 = iV == 0 ? this.f2487n : this.f2488o;
            if (i8 != 3) {
                return i8;
            }
            return 0;
        }
        if (i2 != 8388613) {
            return 0;
        }
        int i9 = this.f2490q;
        if (i9 != 3) {
            return i9;
        }
        int i10 = iV == 0 ? this.f2488o : this.f2487n;
        if (i10 != 3) {
            return i10;
        }
        return 0;
    }

    public int r(View view) {
        if (E(view)) {
            return q(((e) view.getLayoutParams()).f2503a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        this.f2491r = z2;
        if (z2) {
            i(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f2485l) {
            return;
        }
        super.requestLayout();
    }

    public CharSequence s(int i2) {
        int iA = AbstractC0154s.a(i2, L.v(this));
        if (iA == 3) {
            return this.f2463A;
        }
        if (iA == 5) {
            return this.f2464B;
        }
        return null;
    }

    public void setDrawerElevation(float f2) {
        this.f2475b = f2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (E(childAt)) {
                L.Z(childAt, this.f2475b);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(d dVar) {
        d dVar2 = this.f2493t;
        if (dVar2 != null) {
            O(dVar2);
        }
        if (dVar != null) {
            a(dVar);
        }
        this.f2493t = dVar;
    }

    public void setDrawerLockMode(int i2) {
        T(i2, 3);
        T(i2, 5);
    }

    public void setScrimColor(int i2) {
        this.f2477d = i2;
        invalidate();
    }

    public void setStatusBarBackground(int i2) {
        this.f2497x = i2 != 0 ? androidx.core.content.a.d(getContext(), i2) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i2) {
        this.f2497x = new ColorDrawable(i2);
        invalidate();
    }

    int t(View view) {
        return AbstractC0154s.a(((e) view.getLayoutParams()).f2503a, L.v(this));
    }

    float u(View view) {
        return ((e) view.getLayoutParams()).f2504b;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2474a = new c();
        this.f2477d = -1728053248;
        this.f2479f = new Paint();
        this.f2486m = true;
        this.f2487n = 3;
        this.f2488o = 3;
        this.f2489p = 3;
        this.f2490q = 3;
        this.f2467E = null;
        this.f2468F = null;
        this.f2469G = null;
        this.f2470H = null;
        setDescendantFocusability(Peripheral.EXPANSION_10);
        float f2 = getResources().getDisplayMetrics().density;
        this.f2476c = (int) ((64.0f * f2) + 0.5f);
        float f3 = 400.0f * f2;
        g gVar = new g(3);
        this.f2482i = gVar;
        g gVar2 = new g(5);
        this.f2483j = gVar2;
        C0252a c0252aN = C0252a.n(this, 1.0f, gVar);
        this.f2480g = c0252aN;
        c0252aN.K(1);
        c0252aN.L(f3);
        gVar.q(c0252aN);
        C0252a c0252aN2 = C0252a.n(this, 1.0f, gVar2);
        this.f2481h = c0252aN2;
        c0252aN2.K(2);
        c0252aN2.L(f3);
        gVar2.q(c0252aN2);
        setFocusableInTouchMode(true);
        L.a0(this, 1);
        L.U(this, new b());
        setMotionEventSplittingEnabled(false);
        if (L.t(this)) {
            setOnApplyWindowInsetsListener(new a());
            setSystemUiVisibility(1280);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f2459L);
            try {
                this.f2497x = typedArrayObtainStyledAttributes.getDrawable(0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.f2475b = f2 * 10.0f;
        this.f2471I = new ArrayList();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f2497x = drawable;
        invalidate();
    }
}
