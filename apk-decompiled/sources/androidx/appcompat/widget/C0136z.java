package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$styleable;

/* JADX INFO: renamed from: androidx.appcompat.widget.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0136z extends C0131u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SeekBar f1966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f1967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ColorStateList f1968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f1969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1970h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1971i;

    C0136z(SeekBar seekBar) {
        super(seekBar);
        this.f1968f = null;
        this.f1969g = null;
        this.f1970h = false;
        this.f1971i = false;
        this.f1966d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f1967e;
        if (drawable != null) {
            if (this.f1970h || this.f1971i) {
                Drawable drawableP = androidx.core.graphics.drawable.a.p(drawable.mutate());
                this.f1967e = drawableP;
                if (this.f1970h) {
                    androidx.core.graphics.drawable.a.n(drawableP, this.f1968f);
                }
                if (this.f1971i) {
                    androidx.core.graphics.drawable.a.o(this.f1967e, this.f1969g);
                }
                if (this.f1967e.isStateful()) {
                    this.f1967e.setState(this.f1966d.getDrawableState());
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.C0131u
    void c(AttributeSet attributeSet, int i2) {
        super.c(attributeSet, i2);
        e0 e0VarU = e0.u(this.f1966d.getContext(), attributeSet, R$styleable.AppCompatSeekBar, i2, 0);
        SeekBar seekBar = this.f1966d;
        androidx.core.view.L.S(seekBar, seekBar.getContext(), R$styleable.AppCompatSeekBar, attributeSet, e0VarU.q(), i2, 0);
        Drawable drawableG = e0VarU.g(R$styleable.AppCompatSeekBar_android_thumb);
        if (drawableG != null) {
            this.f1966d.setThumb(drawableG);
        }
        j(e0VarU.f(R$styleable.AppCompatSeekBar_tickMark));
        if (e0VarU.r(R$styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.f1969g = N.c(e0VarU.j(R$styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.f1969g);
            this.f1971i = true;
        }
        if (e0VarU.r(R$styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f1968f = e0VarU.c(R$styleable.AppCompatSeekBar_tickMarkTint);
            this.f1970h = true;
        }
        e0VarU.w();
        f();
    }

    void g(Canvas canvas) {
        if (this.f1967e != null) {
            int max = this.f1966d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f1967e.getIntrinsicWidth();
                int intrinsicHeight = this.f1967e.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i3 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f1967e.setBounds(-i2, -i3, i2, i3);
                float width = ((this.f1966d.getWidth() - this.f1966d.getPaddingLeft()) - this.f1966d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f1966d.getPaddingLeft(), this.f1966d.getHeight() / 2);
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f1967e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    void h() {
        Drawable drawable = this.f1967e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1966d.getDrawableState())) {
            this.f1966d.invalidateDrawable(drawable);
        }
    }

    void i() {
        Drawable drawable = this.f1967e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) {
        Drawable drawable2 = this.f1967e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1967e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1966d);
            androidx.core.graphics.drawable.a.l(drawable, this.f1966d.getLayoutDirection());
            if (drawable.isStateful()) {
                drawable.setState(this.f1966d.getDrawableState());
            }
            f();
        }
        this.f1966d.invalidate();
    }
}
