package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import it.tervis.miura.model.Peripheral;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f1451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f1452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f1453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Drawable f1454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Drawable f1455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Drawable f1456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f1457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f1458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f1459j;

    private static class a {
        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new C0113b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBar);
        this.f1454e = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_background);
        this.f1455f = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundStacked);
        this.f1459j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_height, -1);
        boolean z2 = true;
        if (getId() == R$id.split_action_bar) {
            this.f1457h = true;
            this.f1456g = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f1457h ? this.f1454e != null || this.f1455f != null : this.f1456g != null) {
            z2 = false;
        }
        setWillNotDraw(z2);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1454e;
        if (drawable != null && drawable.isStateful()) {
            this.f1454e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f1455f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f1455f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1456g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f1456g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f1451b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1454e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1455f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1456g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1452c = findViewById(R$id.action_bar);
        this.f1453d = findViewById(R$id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1450a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        Drawable drawable;
        Drawable drawable2;
        int left;
        int top;
        int right;
        View view;
        super.onLayout(z2, i2, i3, i4, i5);
        View view2 = this.f1451b;
        boolean z3 = true;
        boolean z4 = false;
        boolean z5 = (view2 == null || view2.getVisibility() == 8) ? false : true;
        if (view2 != null && view2.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
            int measuredHeight2 = measuredHeight - view2.getMeasuredHeight();
            int i6 = layoutParams.bottomMargin;
            view2.layout(i2, measuredHeight2 - i6, i4, measuredHeight - i6);
        }
        if (this.f1457h) {
            Drawable drawable3 = this.f1456g;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z3 = false;
            }
        } else {
            if (this.f1454e != null) {
                if (this.f1452c.getVisibility() == 0) {
                    drawable2 = this.f1454e;
                    left = this.f1452c.getLeft();
                    top = this.f1452c.getTop();
                    right = this.f1452c.getRight();
                    view = this.f1452c;
                } else {
                    View view3 = this.f1453d;
                    if (view3 == null || view3.getVisibility() != 0) {
                        this.f1454e.setBounds(0, 0, 0, 0);
                        z4 = true;
                    } else {
                        drawable2 = this.f1454e;
                        left = this.f1453d.getLeft();
                        top = this.f1453d.getTop();
                        right = this.f1453d.getRight();
                        view = this.f1453d;
                    }
                }
                drawable2.setBounds(left, top, right, view.getBottom());
                z4 = true;
            }
            this.f1458i = z5;
            if (!z5 || (drawable = this.f1455f) == null) {
                z3 = z4;
            } else {
                drawable.setBounds(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            }
        }
        if (z3) {
            invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            android.view.View r0 = r3.f1452c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != 0) goto L1c
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            if (r0 != r1) goto L1c
            int r0 = r3.f1459j
            if (r0 < 0) goto L1c
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            int r5 = java.lang.Math.min(r0, r5)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)
        L1c:
            super.onMeasure(r4, r5)
            android.view.View r4 = r3.f1452c
            if (r4 != 0) goto L24
            return
        L24:
            int r4 = android.view.View.MeasureSpec.getMode(r5)
            android.view.View r0 = r3.f1451b
            if (r0 == 0) goto L6f
            int r0 = r0.getVisibility()
            r2 = 8
            if (r0 == r2) goto L6f
            r0 = 1073741824(0x40000000, float:2.0)
            if (r4 == r0) goto L6f
            android.view.View r0 = r3.f1452c
            boolean r0 = r3.b(r0)
            if (r0 != 0) goto L47
            android.view.View r0 = r3.f1452c
        L42:
            int r0 = r3.a(r0)
            goto L53
        L47:
            android.view.View r0 = r3.f1453d
            boolean r0 = r3.b(r0)
            if (r0 != 0) goto L52
            android.view.View r0 = r3.f1453d
            goto L42
        L52:
            r0 = 0
        L53:
            if (r4 != r1) goto L5a
            int r4 = android.view.View.MeasureSpec.getSize(r5)
            goto L5d
        L5a:
            r4 = 2147483647(0x7fffffff, float:NaN)
        L5d:
            int r5 = r3.getMeasuredWidth()
            android.view.View r1 = r3.f1451b
            int r1 = r3.a(r1)
            int r0 = r0 + r1
            int r4 = java.lang.Math.min(r0, r4)
            r3.setMeasuredDimension(r5, r4)
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f1454e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f1454e);
        }
        this.f1454e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1452c;
            if (view != null) {
                this.f1454e.setBounds(view.getLeft(), this.f1452c.getTop(), this.f1452c.getRight(), this.f1452c.getBottom());
            }
        }
        boolean z2 = false;
        if (!this.f1457h ? !(this.f1454e != null || this.f1455f != null) : this.f1456g == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        a.a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1456g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1456g);
        }
        this.f1456g = drawable;
        boolean z2 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1457h && (drawable2 = this.f1456g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f1457h ? !(this.f1454e != null || this.f1455f != null) : this.f1456g == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        a.a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1455f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1455f);
        }
        this.f1455f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1458i && (drawable2 = this.f1455f) != null) {
                drawable2.setBounds(this.f1451b.getLeft(), this.f1451b.getTop(), this.f1451b.getRight(), this.f1451b.getBottom());
            }
        }
        boolean z2 = false;
        if (!this.f1457h ? !(this.f1454e != null || this.f1455f != null) : this.f1456g == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        a.a(this);
    }

    public void setTabContainer(Z z2) {
        View view = this.f1451b;
        if (view != null) {
            removeView(view);
        }
        this.f1451b = z2;
    }

    public void setTransitioning(boolean z2) {
        this.f1450a = z2;
        setDescendantFocusability(z2 ? 393216 : Peripheral.EXPANSION_10);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.f1454e;
        if (drawable != null) {
            drawable.setVisible(z2, false);
        }
        Drawable drawable2 = this.f1455f;
        if (drawable2 != null) {
            drawable2.setVisible(z2, false);
        }
        Drawable drawable3 = this.f1456g;
        if (drawable3 != null) {
            drawable3.setVisible(z2, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1454e && !this.f1457h) || (drawable == this.f1455f && this.f1458i) || ((drawable == this.f1456g && this.f1457h) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }
}
