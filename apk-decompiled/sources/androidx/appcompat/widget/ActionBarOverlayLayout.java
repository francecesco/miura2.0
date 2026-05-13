package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.view.menu.j;
import androidx.core.view.Y;
import it.tervis.miura.model.Peripheral;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements L, androidx.core.view.B, androidx.core.view.C {

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    static final int[] f1474G = {R$attr.actionBarSize, R.attr.windowContentOverlay};

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private static final androidx.core.view.Y f1475H = new Y.b().c(androidx.core.graphics.f.b(0, 1, 0, 1)).a();

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private static final Rect f1476I = new Rect();

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    ViewPropertyAnimator f1477A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    final AnimatorListenerAdapter f1478B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private final Runnable f1479C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private final Runnable f1480D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private final androidx.core.view.D f1481E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private final f f1482F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ContentFrameLayout f1485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ActionBarContainer f1486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private M f1487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f1488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1491i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f1492j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1493k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1494l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Rect f1495m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Rect f1496n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Rect f1497o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Rect f1498p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Rect f1499q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Rect f1500r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Rect f1501s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Rect f1502t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private androidx.core.view.Y f1503u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private androidx.core.view.Y f1504v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private androidx.core.view.Y f1505w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private androidx.core.view.Y f1506x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private d f1507y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private OverScroller f1508z;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1477A = null;
            actionBarOverlayLayout.f1492j = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1477A = null;
            actionBarOverlayLayout.f1492j = false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.v();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1477A = actionBarOverlayLayout.f1486d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f1478B);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.v();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1477A = actionBarOverlayLayout.f1486d.animate().translationY(-ActionBarOverlayLayout.this.f1486d.getHeight()).setListener(ActionBarOverlayLayout.this.f1478B);
        }
    }

    public interface d {
        void a(boolean z2);

        void b();

        void c();

        void d(int i2);

        void e();

        void f();
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(int i2, int i3) {
            super(i2, i3);
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private static final class f extends View {
        f(Context context) {
            super(context);
            setWillNotDraw(true);
        }

        @Override // android.view.View
        public int getWindowSystemUiVisibility() {
            return 0;
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1484b = 0;
        this.f1495m = new Rect();
        this.f1496n = new Rect();
        this.f1497o = new Rect();
        this.f1498p = new Rect();
        this.f1499q = new Rect();
        this.f1500r = new Rect();
        this.f1501s = new Rect();
        this.f1502t = new Rect();
        androidx.core.view.Y y2 = androidx.core.view.Y.f2310b;
        this.f1503u = y2;
        this.f1504v = y2;
        this.f1505w = y2;
        this.f1506x = y2;
        this.f1478B = new a();
        this.f1479C = new b();
        this.f1480D = new c();
        w(context);
        this.f1481E = new androidx.core.view.D(this);
        f fVar = new f(context);
        this.f1482F = fVar;
        addView(fVar);
    }

    private void B() {
        v();
        this.f1479C.run();
    }

    private boolean C(float f2) {
        this.f1508z.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f1508z.getFinalY() > this.f1486d.getHeight();
    }

    private void p() {
        v();
        this.f1480D.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean q(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$e r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.e) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = 1
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = 1
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = 1
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            goto L36
        L35:
            r0 = r5
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.q(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    private boolean r() {
        androidx.core.view.L.f(this.f1482F, f1475H, this.f1498p);
        return !this.f1498p.equals(f1476I);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private M u(View view) {
        if (view instanceof M) {
            return (M) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void w(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1474G);
        this.f1483a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f1488f = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f1508z = new OverScroller(context);
    }

    private void y() {
        v();
        postDelayed(this.f1480D, 600L);
    }

    private void z() {
        v();
        postDelayed(this.f1479C, 600L);
    }

    void A() {
        if (this.f1485c == null) {
            this.f1485c = (ContentFrameLayout) findViewById(R$id.action_bar_activity_content);
            this.f1486d = (ActionBarContainer) findViewById(R$id.action_bar_container);
            this.f1487e = u(findViewById(R$id.action_bar));
        }
    }

    @Override // androidx.appcompat.widget.L
    public void a(Menu menu, j.a aVar) {
        A();
        this.f1487e.a(menu, aVar);
    }

    @Override // androidx.appcompat.widget.L
    public boolean b() {
        A();
        return this.f1487e.b();
    }

    @Override // androidx.appcompat.widget.L
    public boolean c() {
        A();
        return this.f1487e.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.L
    public boolean d() {
        A();
        return this.f1487e.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1488f != null) {
            int bottom = this.f1486d.getVisibility() == 0 ? (int) (this.f1486d.getBottom() + this.f1486d.getTranslationY() + 0.5f) : 0;
            this.f1488f.setBounds(0, bottom, getWidth(), this.f1488f.getIntrinsicHeight() + bottom);
            this.f1488f.draw(canvas);
        }
    }

    @Override // androidx.appcompat.widget.L
    public boolean e() {
        A();
        return this.f1487e.e();
    }

    @Override // androidx.appcompat.widget.L
    public void f() {
        A();
        this.f1487e.f();
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.L
    public boolean g() {
        A();
        return this.f1487e.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1486d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f1481E.a();
    }

    public CharSequence getTitle() {
        A();
        return this.f1487e.getTitle();
    }

    @Override // androidx.core.view.B
    public void h(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    @Override // androidx.core.view.B
    public void i(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.view.B
    public void j(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    @Override // androidx.appcompat.widget.L
    public void k(int i2) {
        A();
        if (i2 == 2) {
            this.f1487e.s();
        } else if (i2 == 5) {
            this.f1487e.u();
        } else {
            if (i2 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.L
    public void l() {
        A();
        this.f1487e.h();
    }

    @Override // androidx.core.view.C
    public void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        n(view, i2, i3, i4, i5, i6);
    }

    @Override // androidx.core.view.B
    public void n(View view, int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    @Override // androidx.core.view.B
    public boolean o(View view, View view2, int i2, int i3) {
        return i3 == 0 && onStartNestedScroll(view, view2, i2);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        A();
        androidx.core.view.Y yV = androidx.core.view.Y.v(windowInsets, this);
        boolean zQ = q(this.f1486d, new Rect(yV.i(), yV.k(), yV.j(), yV.h()), true, true, false, true);
        androidx.core.view.L.f(this, yV, this.f1495m);
        Rect rect = this.f1495m;
        androidx.core.view.Y yL = yV.l(rect.left, rect.top, rect.right, rect.bottom);
        this.f1503u = yL;
        boolean z2 = true;
        if (!this.f1504v.equals(yL)) {
            this.f1504v = this.f1503u;
            zQ = true;
        }
        if (this.f1496n.equals(this.f1495m)) {
            z2 = zQ;
        } else {
            this.f1496n.set(this.f1495m);
        }
        if (z2) {
            requestLayout();
        }
        return yV.a().c().b().t();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        w(getContext());
        androidx.core.view.L.R(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i8 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int measuredHeight;
        androidx.core.view.Y yA;
        A();
        measureChildWithMargins(this.f1486d, i2, 0, i3, 0);
        e eVar = (e) this.f1486d.getLayoutParams();
        int iMax = Math.max(0, this.f1486d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int iMax2 = Math.max(0, this.f1486d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f1486d.getMeasuredState());
        boolean z2 = (androidx.core.view.L.C(this) & Peripheral.CONSOLE_8) != 0;
        if (z2) {
            measuredHeight = this.f1483a;
            if (this.f1490h && this.f1486d.getTabContainer() != null) {
                measuredHeight += this.f1483a;
            }
        } else {
            measuredHeight = this.f1486d.getVisibility() != 8 ? this.f1486d.getMeasuredHeight() : 0;
        }
        this.f1497o.set(this.f1495m);
        this.f1505w = this.f1503u;
        if (this.f1489g || z2 || !r()) {
            yA = new Y.b(this.f1505w).c(androidx.core.graphics.f.b(this.f1505w.i(), this.f1505w.k() + measuredHeight, this.f1505w.j(), this.f1505w.h())).a();
        } else {
            Rect rect = this.f1497o;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            yA = this.f1505w.l(0, measuredHeight, 0, 0);
        }
        this.f1505w = yA;
        q(this.f1485c, this.f1497o, true, true, true, true);
        if (!this.f1506x.equals(this.f1505w)) {
            androidx.core.view.Y y2 = this.f1505w;
            this.f1506x = y2;
            androidx.core.view.L.g(this.f1485c, y2);
        }
        measureChildWithMargins(this.f1485c, i2, 0, i3, 0);
        e eVar2 = (e) this.f1485c.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f1485c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f1485c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f1485c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (!this.f1491i || !z2) {
            return false;
        }
        if (C(f3)) {
            p();
        } else {
            B();
        }
        this.f1492j = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int i6 = this.f1493k + i3;
        this.f1493k = i6;
        setActionBarHideOffset(i6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.f1481E.b(view, view2, i2);
        this.f1493k = getActionBarHideOffset();
        v();
        d dVar = this.f1507y;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.f1486d.getVisibility() != 0) {
            return false;
        }
        return this.f1491i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.f1491i && !this.f1492j) {
            if (this.f1493k <= this.f1486d.getHeight()) {
                z();
            } else {
                y();
            }
        }
        d dVar = this.f1507y;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i2) {
        super.onWindowSystemUiVisibilityChanged(i2);
        A();
        int i3 = this.f1494l ^ i2;
        this.f1494l = i2;
        boolean z2 = (i2 & 4) == 0;
        boolean z3 = (i2 & Peripheral.CONSOLE_8) != 0;
        d dVar = this.f1507y;
        if (dVar != null) {
            dVar.a(!z3);
            if (z2 || !z3) {
                this.f1507y.b();
            } else {
                this.f1507y.e();
            }
        }
        if ((i3 & Peripheral.CONSOLE_8) == 0 || this.f1507y == null) {
            return;
        }
        androidx.core.view.L.R(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f1484b = i2;
        d dVar = this.f1507y;
        if (dVar != null) {
            dVar.d(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    public void setActionBarHideOffset(int i2) {
        v();
        this.f1486d.setTranslationY(-Math.max(0, Math.min(i2, this.f1486d.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f1507y = dVar;
        if (getWindowToken() != null) {
            this.f1507y.d(this.f1484b);
            int i2 = this.f1494l;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                androidx.core.view.L.R(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z2) {
        this.f1490h = z2;
    }

    public void setHideOnContentScrollEnabled(boolean z2) {
        if (z2 != this.f1491i) {
            this.f1491i = z2;
            if (z2) {
                return;
            }
            v();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i2) {
        A();
        this.f1487e.setIcon(i2);
    }

    public void setLogo(int i2) {
        A();
        this.f1487e.l(i2);
    }

    public void setOverlayMode(boolean z2) {
        this.f1489g = z2;
    }

    public void setShowingForActionMode(boolean z2) {
    }

    public void setUiOptions(int i2) {
    }

    @Override // androidx.appcompat.widget.L
    public void setWindowCallback(Window.Callback callback) {
        A();
        this.f1487e.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.L
    public void setWindowTitle(CharSequence charSequence) {
        A();
        this.f1487e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    void v() {
        removeCallbacks(this.f1479C);
        removeCallbacks(this.f1480D);
        ViewPropertyAnimator viewPropertyAnimator = this.f1477A;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean x() {
        return this.f1489g;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        A();
        this.f1487e.setIcon(drawable);
    }
}
