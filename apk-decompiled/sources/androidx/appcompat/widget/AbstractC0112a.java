package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;

/* JADX INFO: renamed from: androidx.appcompat.widget.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0112a extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final C0026a f1773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f1774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected ActionMenuView f1775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected C0114c f1776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f1777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected androidx.core.view.U f1778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1780h;

    /* JADX INFO: renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    protected class C0026a implements androidx.core.view.V {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1781a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1782b;

        protected C0026a() {
        }

        @Override // androidx.core.view.V
        public void a(View view) {
            if (this.f1781a) {
                return;
            }
            AbstractC0112a abstractC0112a = AbstractC0112a.this;
            abstractC0112a.f1778f = null;
            AbstractC0112a.super.setVisibility(this.f1782b);
        }

        @Override // androidx.core.view.V
        public void b(View view) {
            AbstractC0112a.super.setVisibility(0);
            this.f1781a = false;
        }

        @Override // androidx.core.view.V
        public void c(View view) {
            this.f1781a = true;
        }

        public C0026a d(androidx.core.view.U u2, int i2) {
            AbstractC0112a.this.f1778f = u2;
            this.f1782b = i2;
            return this;
        }
    }

    AbstractC0112a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1773a = new C0026a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1774b = context;
        } else {
            this.f1774b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int d(int i2, int i3, boolean z2) {
        return z2 ? i2 - i3 : i2 + i3;
    }

    protected int c(View view, int i2, int i3, int i4) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i3);
        return Math.max(0, (i2 - view.getMeasuredWidth()) - i4);
    }

    protected int e(View view, int i2, int i3, int i4, boolean z2) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i3 + ((i4 - measuredHeight) / 2);
        if (z2) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        return z2 ? -measuredWidth : measuredWidth;
    }

    public androidx.core.view.U f(int i2, long j2) {
        androidx.core.view.U uB;
        androidx.core.view.U u2 = this.f1778f;
        if (u2 != null) {
            u2.c();
        }
        if (i2 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            uB = androidx.core.view.L.c(this).b(1.0f);
        } else {
            uB = androidx.core.view.L.c(this).b(0.0f);
        }
        uB.f(j2);
        uB.h(this.f1773a.d(uB, i2));
        return uB;
    }

    public int getAnimatedVisibility() {
        return this.f1778f != null ? this.f1773a.f1782b : getVisibility();
    }

    public int getContentHeight() {
        return this.f1777e;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        C0114c c0114c = this.f1776d;
        if (c0114c != null) {
            c0114c.F(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1780h = false;
        }
        if (!this.f1780h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f1780h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1780h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1779g = false;
        }
        if (!this.f1779g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f1779g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1779g = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i2);

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            androidx.core.view.U u2 = this.f1778f;
            if (u2 != null) {
                u2.c();
            }
            super.setVisibility(i2);
        }
    }
}
