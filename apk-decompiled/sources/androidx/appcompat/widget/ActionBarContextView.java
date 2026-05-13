package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends AbstractC0112a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CharSequence f1460i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CharSequence f1461j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f1462k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f1463l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f1464m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private LinearLayout f1465n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextView f1466o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f1467p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f1468q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f1469r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f1470s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f1471t;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.view.b f1472a;

        a(androidx.appcompat.view.b bVar) {
            this.f1472a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f1472a.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    private void i() {
        if (this.f1465n == null) {
            LayoutInflater.from(getContext()).inflate(R$layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1465n = linearLayout;
            this.f1466o = (TextView) linearLayout.findViewById(R$id.action_bar_title);
            this.f1467p = (TextView) this.f1465n.findViewById(R$id.action_bar_subtitle);
            if (this.f1468q != 0) {
                this.f1466o.setTextAppearance(getContext(), this.f1468q);
            }
            if (this.f1469r != 0) {
                this.f1467p.setTextAppearance(getContext(), this.f1469r);
            }
        }
        this.f1466o.setText(this.f1460i);
        this.f1467p.setText(this.f1461j);
        boolean z2 = !TextUtils.isEmpty(this.f1460i);
        boolean z3 = !TextUtils.isEmpty(this.f1461j);
        this.f1467p.setVisibility(z3 ? 0 : 8);
        this.f1465n.setVisibility((z2 || z3) ? 0 : 8);
        if (this.f1465n.getParent() == null) {
            addView(this.f1465n);
        }
    }

    @Override // androidx.appcompat.widget.AbstractC0112a
    public /* bridge */ /* synthetic */ androidx.core.view.U f(int i2, long j2) {
        return super.f(i2, j2);
    }

    public void g() {
        if (this.f1462k == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.AbstractC0112a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbstractC0112a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1461j;
    }

    public CharSequence getTitle() {
        return this.f1460i;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(androidx.appcompat.view.b r4) {
        /*
            r3 = this;
            android.view.View r0 = r3.f1462k
            if (r0 != 0) goto L19
            android.content.Context r0 = r3.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = r3.f1471t
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r3, r2)
            r3.f1462k = r0
        L15:
            r3.addView(r0)
            goto L22
        L19:
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L22
            android.view.View r0 = r3.f1462k
            goto L15
        L22:
            android.view.View r0 = r3.f1462k
            int r1 = androidx.appcompat.R$id.action_mode_close_button
            android.view.View r0 = r0.findViewById(r1)
            r3.f1463l = r0
            androidx.appcompat.widget.ActionBarContextView$a r1 = new androidx.appcompat.widget.ActionBarContextView$a
            r1.<init>(r4)
            r0.setOnClickListener(r1)
            android.view.Menu r4 = r4.e()
            androidx.appcompat.view.menu.e r4 = (androidx.appcompat.view.menu.e) r4
            androidx.appcompat.widget.c r0 = r3.f1776d
            if (r0 == 0) goto L41
            r0.y()
        L41:
            androidx.appcompat.widget.c r0 = new androidx.appcompat.widget.c
            android.content.Context r1 = r3.getContext()
            r0.<init>(r1)
            r3.f1776d = r0
            r1 = 1
            r0.J(r1)
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r1 = -2
            r2 = -1
            r0.<init>(r1, r2)
            androidx.appcompat.widget.c r1 = r3.f1776d
            android.content.Context r2 = r3.f1774b
            r4.c(r1, r2)
            androidx.appcompat.widget.c r4 = r3.f1776d
            androidx.appcompat.view.menu.k r4 = r4.o(r3)
            androidx.appcompat.widget.ActionMenuView r4 = (androidx.appcompat.widget.ActionMenuView) r4
            r3.f1775c = r4
            r1 = 0
            r4.setBackground(r1)
            androidx.appcompat.widget.ActionMenuView r4 = r3.f1775c
            r3.addView(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContextView.h(androidx.appcompat.view.b):void");
    }

    public boolean j() {
        return this.f1470s;
    }

    public void k() {
        removeAllViews();
        this.f1464m = null;
        this.f1775c = null;
        this.f1776d = null;
        View view = this.f1463l;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public boolean l() {
        C0114c c0114c = this.f1776d;
        if (c0114c != null) {
            return c0114c.K();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0114c c0114c = this.f1776d;
        if (c0114c != null) {
            c0114c.B();
            this.f1776d.C();
        }
    }

    @Override // androidx.appcompat.widget.AbstractC0112a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        boolean zB = p0.b(this);
        int paddingRight = zB ? (i4 - i2) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
        View view = this.f1462k;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1462k.getLayoutParams();
            int i6 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iD = AbstractC0112a.d(paddingRight, i6, zB);
            paddingRight = AbstractC0112a.d(iD + e(this.f1462k, iD, paddingTop, paddingTop2, zB), i7, zB);
        }
        int iE = paddingRight;
        LinearLayout linearLayout = this.f1465n;
        if (linearLayout != null && this.f1464m == null && linearLayout.getVisibility() != 8) {
            iE += e(this.f1465n, iE, paddingTop, paddingTop2, zB);
        }
        int i8 = iE;
        View view2 = this.f1464m;
        if (view2 != null) {
            e(view2, i8, paddingTop, paddingTop2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i4 - i2) - getPaddingRight();
        ActionMenuView actionMenuView = this.f1775c;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zB);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i3) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.f1777e;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i3);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f1462k;
        if (view != null) {
            int iC = c(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1462k.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f1775c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.f1775c, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f1465n;
        if (linearLayout != null && this.f1464m == null) {
            if (this.f1470s) {
                this.f1465n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f1465n.getMeasuredWidth();
                boolean z2 = measuredWidth <= paddingLeft;
                if (z2) {
                    paddingLeft -= measuredWidth;
                }
                this.f1465n.setVisibility(z2 ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f1464m;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i4 = layoutParams.width;
            int i5 = i4 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i4 >= 0) {
                paddingLeft = Math.min(i4, paddingLeft);
            }
            int i6 = layoutParams.height;
            int i7 = i6 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i6 >= 0) {
                iMin = Math.min(i6, iMin);
            }
            this.f1464m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i5), View.MeasureSpec.makeMeasureSpec(iMin, i7));
        }
        if (this.f1777e > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            int measuredHeight = getChildAt(i9).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i8) {
                i8 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i8);
    }

    @Override // androidx.appcompat.widget.AbstractC0112a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbstractC0112a
    public void setContentHeight(int i2) {
        this.f1777e = i2;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f1464m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f1464m = view;
        if (view != null && (linearLayout = this.f1465n) != null) {
            removeView(linearLayout);
            this.f1465n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1461j = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1460i = charSequence;
        i();
        androidx.core.view.L.W(this, charSequence);
    }

    public void setTitleOptional(boolean z2) {
        if (z2 != this.f1470s) {
            requestLayout();
        }
        this.f1470s = z2;
    }

    @Override // androidx.appcompat.widget.AbstractC0112a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        e0 e0VarU = e0.u(context, attributeSet, R$styleable.ActionMode, i2, 0);
        setBackground(e0VarU.f(R$styleable.ActionMode_background));
        this.f1468q = e0VarU.m(R$styleable.ActionMode_titleTextStyle, 0);
        this.f1469r = e0VarU.m(R$styleable.ActionMode_subtitleTextStyle, 0);
        this.f1777e = e0VarU.l(R$styleable.ActionMode_height, 0);
        this.f1471t = e0VarU.m(R$styleable.ActionMode_closeItemLayout, R$layout.abc_action_mode_close_item_material);
        e0VarU.w();
    }
}
