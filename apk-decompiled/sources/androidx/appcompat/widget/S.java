package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public abstract class S extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f1634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f1636i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f1637j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Drawable f1638k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1639l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f1640m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f1641n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f1642o;

    public static class a extends LinearLayout.LayoutParams {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public S(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void i(int i2, int i3) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View viewQ = q(i4);
            if (viewQ.getVisibility() != 8) {
                a aVar = (a) viewQ.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).height == -1) {
                    int i5 = ((LinearLayout.LayoutParams) aVar).width;
                    ((LinearLayout.LayoutParams) aVar).width = viewQ.getMeasuredWidth();
                    measureChildWithMargins(viewQ, i3, 0, iMakeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) aVar).width = i5;
                }
            }
        }
    }

    private void j(int i2, int i3) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View viewQ = q(i4);
            if (viewQ.getVisibility() != 8) {
                a aVar = (a) viewQ.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).width == -1) {
                    int i5 = ((LinearLayout.LayoutParams) aVar).height;
                    ((LinearLayout.LayoutParams) aVar).height = viewQ.getMeasuredHeight();
                    measureChildWithMargins(viewQ, iMakeMeasureSpec, 0, i3, 0);
                    ((LinearLayout.LayoutParams) aVar).height = i5;
                }
            }
        }
    }

    private void y(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4 + i2, i5 + i3);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    void e(Canvas canvas) {
        int right;
        int left;
        int paddingRight;
        int virtualChildCount = getVirtualChildCount();
        boolean zB = p0.b(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View viewQ = q(i2);
            if (viewQ != null && viewQ.getVisibility() != 8 && r(i2)) {
                a aVar = (a) viewQ.getLayoutParams();
                h(canvas, zB ? viewQ.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin : (viewQ.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.f1639l);
            }
        }
        if (r(virtualChildCount)) {
            View viewQ2 = q(virtualChildCount - 1);
            if (viewQ2 != null) {
                a aVar2 = (a) viewQ2.getLayoutParams();
                if (zB) {
                    left = viewQ2.getLeft();
                    paddingRight = ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    right = (left - paddingRight) - this.f1639l;
                } else {
                    right = viewQ2.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                }
            } else if (zB) {
                right = getPaddingLeft();
            } else {
                left = getWidth();
                paddingRight = getPaddingRight();
                right = (left - paddingRight) - this.f1639l;
            }
            h(canvas, right);
        }
    }

    void f(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View viewQ = q(i2);
            if (viewQ != null && viewQ.getVisibility() != 8 && r(i2)) {
                g(canvas, (viewQ.getTop() - ((LinearLayout.LayoutParams) ((a) viewQ.getLayoutParams())).topMargin) - this.f1640m);
            }
        }
        if (r(virtualChildCount)) {
            View viewQ2 = q(virtualChildCount - 1);
            g(canvas, viewQ2 == null ? (getHeight() - getPaddingBottom()) - this.f1640m : viewQ2.getBottom() + ((LinearLayout.LayoutParams) ((a) viewQ2.getLayoutParams())).bottomMargin);
        }
    }

    void g(Canvas canvas, int i2) {
        this.f1638k.setBounds(getPaddingLeft() + this.f1642o, i2, (getWidth() - getPaddingRight()) - this.f1642o, this.f1640m + i2);
        this.f1638k.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i2;
        if (this.f1629b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i3 = this.f1629b;
        if (childCount <= i3) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i3);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f1629b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f1630c;
        if (this.f1631d == 1 && (i2 = this.f1632e & 112) != 48) {
            if (i2 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1633f) / 2;
            } else if (i2 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1633f;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1629b;
    }

    public Drawable getDividerDrawable() {
        return this.f1638k;
    }

    public int getDividerPadding() {
        return this.f1642o;
    }

    public int getDividerWidth() {
        return this.f1639l;
    }

    public int getGravity() {
        return this.f1632e;
    }

    public int getOrientation() {
        return this.f1631d;
    }

    public int getShowDividers() {
        return this.f1641n;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1634g;
    }

    void h(Canvas canvas, int i2) {
        this.f1638k.setBounds(i2, getPaddingTop() + this.f1642o, this.f1639l + i2, (getHeight() - getPaddingBottom()) - this.f1642o);
        this.f1638k.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i2 = this.f1631d;
        if (i2 == 0) {
            return new a(-2, -2);
        }
        if (i2 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a ? new a((ViewGroup.MarginLayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new a((ViewGroup.MarginLayoutParams) layoutParams) : new a(layoutParams);
    }

    int n(View view, int i2) {
        return 0;
    }

    int o(View view) {
        return 0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f1638k == null) {
            return;
        }
        if (this.f1631d == 1) {
            f(canvas);
        } else {
            e(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        if (this.f1631d == 1) {
            t(i2, i3, i4, i5);
        } else {
            s(i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.f1631d == 1) {
            x(i2, i3);
        } else {
            v(i2, i3);
        }
    }

    int p(View view) {
        return 0;
    }

    View q(int i2) {
        return getChildAt(i2);
    }

    protected boolean r(int i2) {
        if (i2 == 0) {
            return (this.f1641n & 1) != 0;
        }
        if (i2 == getChildCount()) {
            return (this.f1641n & 4) != 0;
        }
        if ((this.f1641n & 2) == 0) {
            return false;
        }
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (getChildAt(i3).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void s(int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.S.s(int, int, int, int):void");
    }

    public void setBaselineAligned(boolean z2) {
        this.f1628a = z2;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 >= 0 && i2 < getChildCount()) {
            this.f1629b = i2;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f1638k) {
            return;
        }
        this.f1638k = drawable;
        if (drawable != null) {
            this.f1639l = drawable.getIntrinsicWidth();
            this.f1640m = drawable.getIntrinsicHeight();
        } else {
            this.f1639l = 0;
            this.f1640m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i2) {
        this.f1642o = i2;
    }

    public void setGravity(int i2) {
        if (this.f1632e != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f1632e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & 8388615;
        int i4 = this.f1632e;
        if ((8388615 & i4) != i3) {
            this.f1632e = i3 | ((-8388616) & i4);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z2) {
        this.f1635h = z2;
    }

    public void setOrientation(int i2) {
        if (this.f1631d != i2) {
            this.f1631d = i2;
            requestLayout();
        }
    }

    public void setShowDividers(int i2) {
        if (i2 != this.f1641n) {
            requestLayout();
        }
        this.f1641n = i2;
    }

    public void setVerticalGravity(int i2) {
        int i3 = i2 & 112;
        int i4 = this.f1632e;
        if ((i4 & 112) != i3) {
            this.f1632e = i3 | (i4 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.f1634g = Math.max(0.0f, f2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void t(int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.S.t(int, int, int, int):void");
    }

    void u(View view, int i2, int i3, int i4, int i5, int i6) {
        measureChildWithMargins(view, i3, i4, i5, i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x03ad A[PHI: r3
      0x03ad: PHI (r3v31 int) = (r3v27 int), (r3v32 int) binds: [B:173:0x03be, B:167:0x03aa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void v(int r39, int r40) {
        /*
            Method dump skipped, instruction units count: 1272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.S.v(int, int):void");
    }

    int w(int i2) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x02d3 A[PHI: r10
      0x02d3: PHI (r10v21 int) = (r10v19 int), (r10v22 int) binds: [B:136:0x02e4, B:130:0x02d0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0325  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void x(int r34, int r35) {
        /*
            Method dump skipped, instruction units count: 900
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.S.x(int, int):void");
    }

    public S(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1628a = true;
        this.f1629b = -1;
        this.f1630c = 0;
        this.f1632e = 8388659;
        e0 e0VarU = e0.u(context, attributeSet, R$styleable.LinearLayoutCompat, i2, 0);
        androidx.core.view.L.S(this, context, R$styleable.LinearLayoutCompat, attributeSet, e0VarU.q(), i2, 0);
        int iJ = e0VarU.j(R$styleable.LinearLayoutCompat_android_orientation, -1);
        if (iJ >= 0) {
            setOrientation(iJ);
        }
        int iJ2 = e0VarU.j(R$styleable.LinearLayoutCompat_android_gravity, -1);
        if (iJ2 >= 0) {
            setGravity(iJ2);
        }
        boolean zA = e0VarU.a(R$styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.f1634g = e0VarU.h(R$styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f1629b = e0VarU.j(R$styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f1635h = e0VarU.a(R$styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(e0VarU.f(R$styleable.LinearLayoutCompat_divider));
        this.f1641n = e0VarU.j(R$styleable.LinearLayoutCompat_showDividers, 0);
        this.f1642o = e0VarU.e(R$styleable.LinearLayoutCompat_dividerPadding, 0);
        e0VarU.w();
    }
}
