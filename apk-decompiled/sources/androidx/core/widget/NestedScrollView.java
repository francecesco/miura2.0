package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.R$attr;
import androidx.core.view.A;
import androidx.core.view.AbstractC0161z;
import androidx.core.view.C;
import androidx.core.view.C0137a;
import androidx.core.view.C0151o;
import androidx.core.view.D;
import androidx.core.view.InterfaceC0152p;
import androidx.core.view.L;
import it.tervis.miura.model.Peripheral;
import p.C;
import p.E;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements C {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final float f2382D = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final a f2383E = new a();

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private static final int[] f2384F = {R.attr.fillViewport};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private d f2385A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    final c f2386B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    C0151o f2387C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f2388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f2389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f2390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OverScroller f2391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EdgeEffect f2392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EdgeEffect f2393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f2396i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f2397j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f2398k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private VelocityTracker f2399l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f2400m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f2401n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f2402o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f2403p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f2404q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f2405r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int[] f2406s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int[] f2407t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f2408u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f2409v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private e f2410w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final D f2411x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final A f2412y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f2413z;

    static class a extends C0137a {
        a() {
        }

        @Override // androidx.core.view.C0137a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            E.a(accessibilityEvent, nestedScrollView.getScrollX());
            E.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.C0137a
        public void g(View view, p.C c2) {
            int scrollRange;
            super.g(view, c2);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            c2.f0(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            c2.r0(true);
            if (nestedScrollView.getScrollY() > 0) {
                c2.b(C.a.f3961q);
                c2.b(C.a.f3928B);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                c2.b(C.a.f3960p);
                c2.b(C.a.f3930D);
            }
        }

        @Override // androidx.core.view.C0137a
        public boolean j(View view, int i2, Bundle bundle) {
            if (super.j(view, i2, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i2 != 4096) {
                if (i2 == 8192 || i2 == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.W(0, iMax, true);
                    return true;
                }
                if (i2 != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.W(0, iMin, true);
            return true;
        }
    }

    static class b {
        static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    class c implements InterfaceC0152p {
        c() {
        }

        @Override // androidx.core.view.InterfaceC0152p
        public boolean a(float f2) {
            if (f2 == 0.0f) {
                return false;
            }
            c();
            NestedScrollView.this.v((int) f2);
            return true;
        }

        @Override // androidx.core.view.InterfaceC0152p
        public float b() {
            return -NestedScrollView.this.getVerticalScrollFactorCompat();
        }

        @Override // androidx.core.view.InterfaceC0152p
        public void c() {
            NestedScrollView.this.f2391d.abortAnimation();
        }
    }

    public interface d {
        void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5);
    }

    static class e extends View.BaseSavedState {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2415a;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i2) {
                return new e[i2];
            }
        }

        e(Parcel parcel) {
            super(parcel);
            this.f2415a = parcel.readInt();
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f2415a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f2415a);
        }

        e(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.nestedScrollViewStyle);
    }

    private void A() {
        VelocityTracker velocityTracker = this.f2399l;
        if (velocityTracker == null) {
            this.f2399l = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void B() {
        this.f2391d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(Peripheral.EXPANSION_10);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f2402o = viewConfiguration.getScaledTouchSlop();
        this.f2403p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2404q = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void C() {
        if (this.f2399l == null) {
            this.f2399l = VelocityTracker.obtain();
        }
    }

    private void D(int i2, int i3) {
        this.f2394g = i2;
        this.f2405r = i3;
        X(2, 0);
    }

    private boolean E(View view) {
        return !G(view, 0, getHeight());
    }

    private static boolean F(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && F((View) parent, view2);
    }

    private boolean G(View view, int i2, int i3) {
        view.getDrawingRect(this.f2390c);
        offsetDescendantRectToMyCoords(view, this.f2390c);
        return this.f2390c.bottom + i2 >= getScrollY() && this.f2390c.top - i2 <= getScrollY() + i3;
    }

    private void H(int i2, int i3, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i2);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f2412y.d(0, scrollY2, 0, i2 - scrollY2, null, i3, iArr);
    }

    private void I(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f2405r) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.f2394g = (int) motionEvent.getY(i2);
            this.f2405r = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.f2399l;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void L() {
        VelocityTracker velocityTracker = this.f2399l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2399l = null;
        }
    }

    private int M(int i2, float f2) {
        float fD;
        EdgeEffect edgeEffect;
        float width = f2 / getWidth();
        float height = i2 / getHeight();
        float f3 = 0.0f;
        if (androidx.core.widget.d.b(this.f2392e) != 0.0f) {
            fD = -androidx.core.widget.d.d(this.f2392e, -height, width);
            if (androidx.core.widget.d.b(this.f2392e) == 0.0f) {
                edgeEffect = this.f2392e;
                edgeEffect.onRelease();
            }
            f3 = fD;
        } else if (androidx.core.widget.d.b(this.f2393f) != 0.0f) {
            fD = androidx.core.widget.d.d(this.f2393f, height, 1.0f - width);
            if (androidx.core.widget.d.b(this.f2393f) == 0.0f) {
                edgeEffect = this.f2393f;
                edgeEffect.onRelease();
            }
            f3 = fD;
        }
        int iRound = Math.round(f3 * getHeight());
        if (iRound != 0) {
            invalidate();
        }
        return iRound;
    }

    private void N(boolean z2) {
        if (z2) {
            X(2, 1);
        } else {
            Z(1);
        }
        this.f2409v = getScrollY();
        postInvalidateOnAnimation();
    }

    private boolean O(int i2, int i3, int i4) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = height + scrollY;
        boolean z2 = false;
        boolean z3 = i2 == 33;
        View viewU = u(z3, i3, i4);
        if (viewU == null) {
            viewU = this;
        }
        if (i3 < scrollY || i4 > i5) {
            P(z3 ? i3 - scrollY : i4 - i5, 0, 1, true);
            z2 = true;
        }
        if (viewU != findFocus()) {
            viewU.requestFocus(i2);
        }
        return z2;
    }

    private int P(int i2, int i3, int i4, boolean z2) {
        int i5;
        int i6;
        EdgeEffect edgeEffect;
        VelocityTracker velocityTracker;
        if (i4 == 1) {
            X(2, i4);
        }
        boolean z3 = false;
        if (l(0, i2, this.f2407t, this.f2406s, i4)) {
            i5 = i2 - this.f2407t[1];
            i6 = this.f2406s[1];
        } else {
            i5 = i2;
            i6 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        boolean z4 = d() && !z2;
        boolean z5 = J(0, i5, 0, scrollY, 0, scrollRange, 0, 0, true) && !y(i4);
        int scrollY2 = getScrollY() - scrollY;
        int[] iArr = this.f2407t;
        iArr[1] = 0;
        p(0, scrollY2, 0, i5 - scrollY2, this.f2406s, i4, iArr);
        int i7 = i6 + this.f2406s[1];
        int i8 = i5 - this.f2407t[1];
        int i9 = scrollY + i8;
        if (i9 < 0) {
            if (z4) {
                androidx.core.widget.d.d(this.f2392e, (-i8) / getHeight(), i3 / getWidth());
                if (!this.f2393f.isFinished()) {
                    edgeEffect = this.f2393f;
                    edgeEffect.onRelease();
                }
            }
        } else if (i9 > scrollRange && z4) {
            androidx.core.widget.d.d(this.f2393f, i8 / getHeight(), 1.0f - (i3 / getWidth()));
            if (!this.f2392e.isFinished()) {
                edgeEffect = this.f2392e;
                edgeEffect.onRelease();
            }
        }
        if (this.f2392e.isFinished() && this.f2393f.isFinished()) {
            z3 = z5;
        } else {
            postInvalidateOnAnimation();
        }
        if (z3 && i4 == 0 && (velocityTracker = this.f2399l) != null) {
            velocityTracker.clear();
        }
        if (i4 == 1) {
            Z(i4);
            this.f2392e.onRelease();
            this.f2393f.onRelease();
        }
        return i7;
    }

    private void Q(View view) {
        view.getDrawingRect(this.f2390c);
        offsetDescendantRectToMyCoords(view, this.f2390c);
        int iG = g(this.f2390c);
        if (iG != 0) {
            scrollBy(0, iG);
        }
    }

    private boolean R(Rect rect, boolean z2) {
        int iG = g(rect);
        boolean z3 = iG != 0;
        if (z3) {
            if (z2) {
                scrollBy(0, iG);
            } else {
                T(0, iG);
            }
        }
        return z3;
    }

    private boolean S(EdgeEffect edgeEffect, int i2) {
        if (i2 > 0) {
            return true;
        }
        return x(-i2) < androidx.core.widget.d.b(edgeEffect) * ((float) getHeight());
    }

    private void U(int i2, int i3, int i4, boolean z2) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f2389b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f2391d.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i3 + scrollY, Math.max(0, height - height2))) - scrollY, i4);
            N(z2);
        } else {
            if (!this.f2391d.isFinished()) {
                a();
            }
            scrollBy(i2, i3);
        }
        this.f2389b = AnimationUtils.currentAnimationTimeMillis();
    }

    private boolean Y(MotionEvent motionEvent) {
        boolean z2;
        if (androidx.core.widget.d.b(this.f2392e) != 0.0f) {
            androidx.core.widget.d.d(this.f2392e, 0.0f, motionEvent.getX() / getWidth());
            z2 = true;
        } else {
            z2 = false;
        }
        if (androidx.core.widget.d.b(this.f2393f) == 0.0f) {
            return z2;
        }
        androidx.core.widget.d.d(this.f2393f, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    private void a() {
        this.f2391d.abortAnimation();
        Z(1);
    }

    private boolean d() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0) {
            return overScrollMode == 1 && getScrollRange() > 0;
        }
        return true;
    }

    private boolean e() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private static int f(int i2, int i3, int i4) {
        if (i3 >= i4 || i2 < 0) {
            return 0;
        }
        return i3 + i2 > i4 ? i4 - i3 : i2;
    }

    private void q(int i2) {
        if (i2 != 0) {
            if (this.f2401n) {
                T(0, i2);
            } else {
                scrollBy(0, i2);
            }
        }
    }

    private boolean r(int i2) {
        EdgeEffect edgeEffect;
        if (androidx.core.widget.d.b(this.f2392e) != 0.0f) {
            if (S(this.f2392e, i2)) {
                edgeEffect = this.f2392e;
                edgeEffect.onAbsorb(i2);
            } else {
                i2 = -i2;
                v(i2);
            }
        } else {
            if (androidx.core.widget.d.b(this.f2393f) == 0.0f) {
                return false;
            }
            i2 = -i2;
            if (S(this.f2393f, i2)) {
                edgeEffect = this.f2393f;
                edgeEffect.onAbsorb(i2);
            }
            v(i2);
        }
        return true;
    }

    private void s() {
        this.f2405r = -1;
        this.f2398k = false;
        L();
        Z(0);
        this.f2392e.onRelease();
        this.f2393f.onRelease();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.view.View u(boolean r13, int r14, int r15) {
        /*
            r12 = this;
            r0 = 2
            java.util.ArrayList r0 = r12.getFocusables(r0)
            int r1 = r0.size()
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
        Ld:
            if (r4 >= r1) goto L53
            java.lang.Object r6 = r0.get(r4)
            android.view.View r6 = (android.view.View) r6
            int r7 = r6.getTop()
            int r8 = r6.getBottom()
            if (r14 >= r8) goto L50
            if (r7 >= r15) goto L50
            r9 = 1
            if (r14 >= r7) goto L28
            if (r8 >= r15) goto L28
            r10 = 1
            goto L29
        L28:
            r10 = 0
        L29:
            if (r2 != 0) goto L2e
            r2 = r6
            r5 = r10
            goto L50
        L2e:
            if (r13 == 0) goto L36
            int r11 = r2.getTop()
            if (r7 < r11) goto L3e
        L36:
            if (r13 != 0) goto L40
            int r7 = r2.getBottom()
            if (r8 <= r7) goto L40
        L3e:
            r7 = 1
            goto L41
        L40:
            r7 = 0
        L41:
            if (r5 == 0) goto L48
            if (r10 == 0) goto L50
            if (r7 == 0) goto L50
            goto L4f
        L48:
            if (r10 == 0) goto L4d
            r2 = r6
            r5 = 1
            goto L50
        L4d:
            if (r7 == 0) goto L50
        L4f:
            r2 = r6
        L50:
            int r4 = r4 + 1
            goto Ld
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.u(boolean, int, int):android.view.View");
    }

    private float x(int i2) {
        double dLog = Math.log((Math.abs(i2) * 0.35f) / (this.f2388a * 0.015f));
        float f2 = f2382D;
        return (float) (((double) (this.f2388a * 0.015f)) * Math.exp((((double) f2) / (((double) f2) - 1.0d)) * dLog));
    }

    private boolean z(int i2, int i3) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i3 >= childAt.getTop() - scrollY && i3 < childAt.getBottom() - scrollY && i2 >= childAt.getLeft() && i2 < childAt.getRight();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean J(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L13
            r2 = 1
            goto L14
        L13:
            r2 = 0
        L14:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            if (r3 <= r6) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = 0
        L21:
            if (r1 == 0) goto L2a
            if (r1 != r5) goto L28
            if (r2 == 0) goto L28
            goto L2a
        L28:
            r2 = 0
            goto L2b
        L2a:
            r2 = 1
        L2b:
            if (r1 == 0) goto L34
            if (r1 != r5) goto L32
            if (r3 == 0) goto L32
            goto L34
        L32:
            r1 = 0
            goto L35
        L34:
            r1 = 1
        L35:
            int r3 = r15 + r13
            if (r2 != 0) goto L3b
            r2 = 0
            goto L3d
        L3b:
            r2 = r19
        L3d:
            int r6 = r16 + r14
            if (r1 != 0) goto L43
            r1 = 0
            goto L45
        L43:
            r1 = r20
        L45:
            int r7 = -r2
            int r2 = r2 + r17
            int r8 = -r1
            int r1 = r1 + r18
            if (r3 <= r2) goto L50
            r3 = r2
        L4e:
            r2 = 1
            goto L55
        L50:
            if (r3 >= r7) goto L54
            r3 = r7
            goto L4e
        L54:
            r2 = 0
        L55:
            if (r6 <= r1) goto L5a
            r6 = r1
        L58:
            r1 = 1
            goto L5f
        L5a:
            if (r6 >= r8) goto L5e
            r6 = r8
            goto L58
        L5e:
            r1 = 0
        L5f:
            if (r1 == 0) goto L7e
            boolean r7 = r12.y(r5)
            if (r7 != 0) goto L7e
            android.widget.OverScroller r7 = r0.f2391d
            r8 = 0
            int r9 = r12.getScrollRange()
            r10 = 0
            r11 = 0
            r13 = r7
            r14 = r3
            r15 = r6
            r16 = r10
            r17 = r11
            r18 = r8
            r19 = r9
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L7e:
            r12.onOverScrolled(r3, r6, r2, r1)
            if (r2 != 0) goto L85
            if (r1 == 0) goto L86
        L85:
            r4 = 1
        L86:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.J(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    public boolean K(int i2) {
        boolean z2 = i2 == 130;
        int height = getHeight();
        if (z2) {
            this.f2390c.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f2390c;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f2390c.top = getScrollY() - height;
            Rect rect2 = this.f2390c;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f2390c;
        int i3 = rect3.top;
        int i4 = height + i3;
        rect3.bottom = i4;
        return O(i2, i3, i4);
    }

    public final void T(int i2, int i3) {
        U(i2, i3, 250, false);
    }

    void V(int i2, int i3, int i4, boolean z2) {
        U(i2 - getScrollX(), i3 - getScrollY(), i4, z2);
    }

    void W(int i2, int i3, boolean z2) {
        V(i2, i3, 250, z2);
    }

    public boolean X(int i2, int i3) {
        return this.f2412y.m(i2, i3);
    }

    public void Z(int i2) {
        this.f2412y.n(i2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public boolean c(int i2) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i2);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !G(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i2 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i2 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i2 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            P(maxScrollAmount, 0, 1, true);
        } else {
            viewFindNextFocus.getDrawingRect(this.f2390c);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f2390c);
            P(g(this.f2390c), 0, 1, true);
            viewFindNextFocus.requestFocus(i2);
        }
        if (viewFindFocus != null && viewFindFocus.isFocused() && E(viewFindFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(Peripheral.EXPANSION_9);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        EdgeEffect edgeEffect;
        if (this.f2391d.isFinished()) {
            return;
        }
        this.f2391d.computeScrollOffset();
        int currY = this.f2391d.getCurrY();
        int iK = k(currY - this.f2409v);
        this.f2409v = currY;
        int[] iArr = this.f2407t;
        iArr[1] = 0;
        l(0, iK, iArr, null, 1);
        int i2 = iK - this.f2407t[1];
        int scrollRange = getScrollRange();
        if (i2 != 0) {
            int scrollY = getScrollY();
            J(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i3 = i2 - scrollY2;
            int[] iArr2 = this.f2407t;
            iArr2[1] = 0;
            p(0, scrollY2, 0, i3, this.f2406s, 1, iArr2);
            i2 = i3 - this.f2407t[1];
        }
        if (i2 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                if (i2 < 0) {
                    if (this.f2392e.isFinished()) {
                        edgeEffect = this.f2392e;
                        edgeEffect.onAbsorb((int) this.f2391d.getCurrVelocity());
                    }
                } else if (this.f2393f.isFinished()) {
                    edgeEffect = this.f2393f;
                    edgeEffect.onAbsorb((int) this.f2391d.getCurrVelocity());
                }
            }
            a();
        }
        if (this.f2391d.isFinished()) {
            Z(1);
        } else {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || t(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.f2412y.a(f2, f3, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f2412y.b(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return l(i2, i3, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.f2412y.e(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        int paddingLeft2 = 0;
        if (!this.f2392e.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (b.a(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = 0;
            }
            if (b.a(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                iMin += getPaddingTop();
            }
            canvas.translate(paddingLeft, iMin);
            this.f2392e.setSize(width, height);
            if (this.f2392e.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(iSave);
        }
        if (this.f2393f.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (b.a(this)) {
            width2 -= getPaddingLeft() + getPaddingRight();
            paddingLeft2 = getPaddingLeft();
        }
        if (b.a(this)) {
            height2 -= getPaddingTop() + getPaddingBottom();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, 0.0f);
        this.f2393f.setSize(width2, height2);
        if (this.f2393f.draw(canvas)) {
            postInvalidateOnAnimation();
        }
        canvas.restoreToCount(iSave2);
    }

    protected int g(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i2 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i3 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i2 - verticalFadingEdgeLength : i2;
        int i4 = rect.bottom;
        if (i4 > i3 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i3, (childAt.getBottom() + layoutParams.bottomMargin) - i2);
        }
        if (rect.top >= scrollY || i4 >= i3) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i3 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f2411x.a();
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    float getVerticalScrollFactorCompat() {
        if (this.f2413z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f2413z = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f2413z;
    }

    @Override // androidx.core.view.B
    public void h(View view, View view2, int i2, int i3) {
        this.f2411x.c(view, view2, i2, i3);
        X(2, i3);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return y(0);
    }

    @Override // androidx.core.view.B
    public void i(View view, int i2) {
        this.f2411x.d(view, i2);
        Z(i2);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f2412y.j();
    }

    @Override // androidx.core.view.B
    public void j(View view, int i2, int i3, int[] iArr, int i4) {
        l(i2, i3, iArr, null, i4);
    }

    int k(int i2) {
        int height = getHeight();
        if (i2 > 0 && androidx.core.widget.d.b(this.f2392e) != 0.0f) {
            int iRound = Math.round(((-height) / 4.0f) * androidx.core.widget.d.d(this.f2392e, ((-i2) * 4.0f) / height, 0.5f));
            if (iRound != i2) {
                this.f2392e.finish();
            }
            return i2 - iRound;
        }
        if (i2 >= 0 || androidx.core.widget.d.b(this.f2393f) == 0.0f) {
            return i2;
        }
        float f2 = height;
        int iRound2 = Math.round((f2 / 4.0f) * androidx.core.widget.d.d(this.f2393f, (i2 * 4.0f) / f2, 0.5f));
        if (iRound2 != i2) {
            this.f2393f.finish();
        }
        return i2 - iRound2;
    }

    public boolean l(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return this.f2412y.c(i2, i3, iArr, iArr2, i4);
    }

    @Override // androidx.core.view.C
    public void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        H(i5, i6, iArr);
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i2, int i3) {
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // androidx.core.view.B
    public void n(View view, int i2, int i3, int i4, int i5, int i6) {
        H(i5, i6, null);
    }

    @Override // androidx.core.view.B
    public boolean o(View view, View view2, int i2, int i3) {
        return (i2 & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2396i = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int i2;
        float axisValue;
        int width;
        if (motionEvent.getAction() == 8 && !this.f2398k) {
            if (AbstractC0161z.a(motionEvent, 2)) {
                i2 = 9;
                axisValue = motionEvent.getAxisValue(9);
                width = (int) motionEvent.getX();
            } else if (AbstractC0161z.a(motionEvent, Peripheral.EXPANSION_14)) {
                axisValue = motionEvent.getAxisValue(26);
                width = getWidth() / 2;
                i2 = 26;
            } else {
                i2 = 0;
                axisValue = 0.0f;
                width = 0;
            }
            if (axisValue != 0.0f) {
                P(-((int) (axisValue * getVerticalScrollFactorCompat())), width, 1, AbstractC0161z.a(motionEvent, 8194));
                if (i2 != 0) {
                    this.f2387C.g(motionEvent, i2);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0075  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        int measuredHeight = 0;
        this.f2395h = false;
        View view = this.f2397j;
        if (view != null && F(view, this)) {
            Q(this.f2397j);
        }
        this.f2397j = null;
        if (!this.f2396i) {
            if (this.f2410w != null) {
                scrollTo(getScrollX(), this.f2410w.f2415a);
                this.f2410w = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iF = f(scrollY, paddingTop, measuredHeight);
            if (iF != scrollY) {
                scrollTo(getScrollX(), iF);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f2396i = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f2400m && View.MeasureSpec.getMode(i3) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (z2) {
            return false;
        }
        dispatchNestedFling(0.0f, f3, true);
        v((int) f3);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        j(view, i2, i3, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        H(i5, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        h(view, view2, i2, 0);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i2, int i3, boolean z2, boolean z3) {
        super.scrollTo(i2, i3);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (i2 == 2) {
            i2 = 130;
        } else if (i2 == 1) {
            i2 = 33;
        }
        FocusFinder focusFinder = FocusFinder.getInstance();
        View viewFindNextFocus = rect == null ? focusFinder.findNextFocus(this, null, i2) : focusFinder.findNextFocusFromRect(this, rect, i2);
        if (viewFindNextFocus == null || E(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i2, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        this.f2410w = eVar;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.f2415a = getScrollY();
        return eVar;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        d dVar = this.f2385A;
        if (dVar != null) {
            dVar.a(this, i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !G(viewFindFocus, 0, i5)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f2390c);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f2390c);
        q(g(this.f2390c));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return o(view, view2, i2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        i(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instruction units count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void p(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        this.f2412y.d(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f2395h) {
            this.f2397j = view2;
        } else {
            Q(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return R(rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (z2) {
            L();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f2395h = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iF = f(i2, width, width2);
            int iF2 = f(i3, height, height2);
            if (iF == getScrollX() && iF2 == getScrollY()) {
                return;
            }
            super.scrollTo(iF, iF2);
        }
    }

    public void setFillViewport(boolean z2) {
        if (z2 != this.f2400m) {
            this.f2400m = z2;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        this.f2412y.k(z2);
    }

    public void setOnScrollChangeListener(d dVar) {
        this.f2385A = dVar;
    }

    public void setSmoothScrollingEnabled(boolean z2) {
        this.f2401n = z2;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return X(i2, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        Z(0);
    }

    public boolean t(KeyEvent keyEvent) {
        this.f2390c.setEmpty();
        int i2 = 130;
        if (!e()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
            return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 19) {
            if (keyCode != 20) {
                if (keyCode != 62) {
                    if (keyCode != 92) {
                        if (keyCode != 93) {
                            if (keyCode == 122) {
                                K(33);
                                return false;
                            }
                            if (keyCode != 123) {
                                return false;
                            }
                        }
                    }
                } else if (keyEvent.isShiftPressed()) {
                    i2 = 33;
                }
                K(i2);
                return false;
            }
            if (!keyEvent.isAltPressed()) {
                return c(130);
            }
            return w(130);
        }
        if (!keyEvent.isAltPressed()) {
            return c(33);
        }
        return w(33);
    }

    public void v(int i2) {
        if (getChildCount() > 0) {
            this.f2391d.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            N(true);
        }
    }

    public boolean w(int i2) {
        int childCount;
        boolean z2 = i2 == 130;
        int height = getHeight();
        Rect rect = this.f2390c;
        rect.top = 0;
        rect.bottom = height;
        if (z2 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f2390c.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f2390c;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f2390c;
        return O(i2, rect3.top, rect3.bottom);
    }

    public boolean y(int i2) {
        return this.f2412y.i(i2);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2390c = new Rect();
        this.f2395h = true;
        this.f2396i = false;
        this.f2397j = null;
        this.f2398k = false;
        this.f2401n = true;
        this.f2405r = -1;
        this.f2406s = new int[2];
        this.f2407t = new int[2];
        c cVar = new c();
        this.f2386B = cVar;
        this.f2387C = new C0151o(getContext(), cVar);
        this.f2392e = androidx.core.widget.d.a(context, attributeSet);
        this.f2393f = androidx.core.widget.d.a(context, attributeSet);
        this.f2388a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        B();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2384F, i2, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f2411x = new D(this);
        this.f2412y = new A(this);
        setNestedScrollingEnabled(true);
        L.U(this, f2383E);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i2, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }
}
