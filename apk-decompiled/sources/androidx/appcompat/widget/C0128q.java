package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import e.AbstractC0190a;

/* JADX INFO: renamed from: androidx.appcompat.widget.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0128q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageView f1943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c0 f1944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c0 f1945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c0 f1946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1947e = 0;

    public C0128q(ImageView imageView) {
        this.f1943a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f1946d == null) {
            this.f1946d = new c0();
        }
        c0 c0Var = this.f1946d;
        c0Var.a();
        ColorStateList colorStateListA = androidx.core.widget.e.a(this.f1943a);
        if (colorStateListA != null) {
            c0Var.f1831d = true;
            c0Var.f1828a = colorStateListA;
        }
        PorterDuff.Mode modeB = androidx.core.widget.e.b(this.f1943a);
        if (modeB != null) {
            c0Var.f1830c = true;
            c0Var.f1829b = modeB;
        }
        if (!c0Var.f1831d && !c0Var.f1830c) {
            return false;
        }
        C0122k.i(drawable, c0Var, this.f1943a.getDrawableState());
        return true;
    }

    private boolean l() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f1944b != null : i2 == 21;
    }

    void b() {
        if (this.f1943a.getDrawable() != null) {
            this.f1943a.getDrawable().setLevel(this.f1947e);
        }
    }

    void c() {
        Drawable drawable = this.f1943a.getDrawable();
        if (drawable != null) {
            N.a(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            c0 c0Var = this.f1945c;
            if (c0Var != null) {
                C0122k.i(drawable, c0Var, this.f1943a.getDrawableState());
                return;
            }
            c0 c0Var2 = this.f1944b;
            if (c0Var2 != null) {
                C0122k.i(drawable, c0Var2, this.f1943a.getDrawableState());
            }
        }
    }

    ColorStateList d() {
        c0 c0Var = this.f1945c;
        if (c0Var != null) {
            return c0Var.f1828a;
        }
        return null;
    }

    PorterDuff.Mode e() {
        c0 c0Var = this.f1945c;
        if (c0Var != null) {
            return c0Var.f1829b;
        }
        return null;
    }

    boolean f() {
        return !(this.f1943a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i2) {
        int iM;
        e0 e0VarU = e0.u(this.f1943a.getContext(), attributeSet, R$styleable.AppCompatImageView, i2, 0);
        ImageView imageView = this.f1943a;
        androidx.core.view.L.S(imageView, imageView.getContext(), R$styleable.AppCompatImageView, attributeSet, e0VarU.q(), i2, 0);
        try {
            Drawable drawable = this.f1943a.getDrawable();
            if (drawable == null && (iM = e0VarU.m(R$styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = AbstractC0190a.b(this.f1943a.getContext(), iM)) != null) {
                this.f1943a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                N.a(drawable);
            }
            if (e0VarU.r(R$styleable.AppCompatImageView_tint)) {
                androidx.core.widget.e.c(this.f1943a, e0VarU.c(R$styleable.AppCompatImageView_tint));
            }
            if (e0VarU.r(R$styleable.AppCompatImageView_tintMode)) {
                androidx.core.widget.e.d(this.f1943a, N.c(e0VarU.j(R$styleable.AppCompatImageView_tintMode, -1), null));
            }
            e0VarU.w();
        } catch (Throwable th) {
            e0VarU.w();
            throw th;
        }
    }

    void h(Drawable drawable) {
        this.f1947e = drawable.getLevel();
    }

    public void i(int i2) {
        if (i2 != 0) {
            Drawable drawableB = AbstractC0190a.b(this.f1943a.getContext(), i2);
            if (drawableB != null) {
                N.a(drawableB);
            }
            this.f1943a.setImageDrawable(drawableB);
        } else {
            this.f1943a.setImageDrawable(null);
        }
        c();
    }

    void j(ColorStateList colorStateList) {
        if (this.f1945c == null) {
            this.f1945c = new c0();
        }
        c0 c0Var = this.f1945c;
        c0Var.f1828a = colorStateList;
        c0Var.f1831d = true;
        c();
    }

    void k(PorterDuff.Mode mode) {
        if (this.f1945c == null) {
            this.f1945c = new c0();
        }
        c0 c0Var = this.f1945c;
        c0Var.f1829b = mode;
        c0Var.f1830c = true;
        c();
    }
}
