package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;

/* JADX INFO: renamed from: androidx.appcompat.widget.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0116e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f1837a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c0 f1840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c0 f1841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c0 f1842f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1839c = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0122k f1838b = C0122k.b();

    C0116e(View view) {
        this.f1837a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f1842f == null) {
            this.f1842f = new c0();
        }
        c0 c0Var = this.f1842f;
        c0Var.a();
        ColorStateList colorStateListO = androidx.core.view.L.o(this.f1837a);
        if (colorStateListO != null) {
            c0Var.f1831d = true;
            c0Var.f1828a = colorStateListO;
        }
        PorterDuff.Mode modeP = androidx.core.view.L.p(this.f1837a);
        if (modeP != null) {
            c0Var.f1830c = true;
            c0Var.f1829b = modeP;
        }
        if (!c0Var.f1831d && !c0Var.f1830c) {
            return false;
        }
        C0122k.i(drawable, c0Var, this.f1837a.getDrawableState());
        return true;
    }

    private boolean k() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f1840d != null : i2 == 21;
    }

    void b() {
        Drawable background = this.f1837a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            c0 c0Var = this.f1841e;
            if (c0Var != null) {
                C0122k.i(background, c0Var, this.f1837a.getDrawableState());
                return;
            }
            c0 c0Var2 = this.f1840d;
            if (c0Var2 != null) {
                C0122k.i(background, c0Var2, this.f1837a.getDrawableState());
            }
        }
    }

    ColorStateList c() {
        c0 c0Var = this.f1841e;
        if (c0Var != null) {
            return c0Var.f1828a;
        }
        return null;
    }

    PorterDuff.Mode d() {
        c0 c0Var = this.f1841e;
        if (c0Var != null) {
            return c0Var.f1829b;
        }
        return null;
    }

    void e(AttributeSet attributeSet, int i2) {
        e0 e0VarU = e0.u(this.f1837a.getContext(), attributeSet, R$styleable.ViewBackgroundHelper, i2, 0);
        View view = this.f1837a;
        androidx.core.view.L.S(view, view.getContext(), R$styleable.ViewBackgroundHelper, attributeSet, e0VarU.q(), i2, 0);
        try {
            if (e0VarU.r(R$styleable.ViewBackgroundHelper_android_background)) {
                this.f1839c = e0VarU.m(R$styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList colorStateListF = this.f1838b.f(this.f1837a.getContext(), this.f1839c);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            if (e0VarU.r(R$styleable.ViewBackgroundHelper_backgroundTint)) {
                androidx.core.view.L.X(this.f1837a, e0VarU.c(R$styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (e0VarU.r(R$styleable.ViewBackgroundHelper_backgroundTintMode)) {
                androidx.core.view.L.Y(this.f1837a, N.c(e0VarU.j(R$styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            e0VarU.w();
        } catch (Throwable th) {
            e0VarU.w();
            throw th;
        }
    }

    void f(Drawable drawable) {
        this.f1839c = -1;
        h(null);
        b();
    }

    void g(int i2) {
        this.f1839c = i2;
        C0122k c0122k = this.f1838b;
        h(c0122k != null ? c0122k.f(this.f1837a.getContext(), i2) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1840d == null) {
                this.f1840d = new c0();
            }
            c0 c0Var = this.f1840d;
            c0Var.f1828a = colorStateList;
            c0Var.f1831d = true;
        } else {
            this.f1840d = null;
        }
        b();
    }

    void i(ColorStateList colorStateList) {
        if (this.f1841e == null) {
            this.f1841e = new c0();
        }
        c0 c0Var = this.f1841e;
        c0Var.f1828a = colorStateList;
        c0Var.f1831d = true;
        b();
    }

    void j(PorterDuff.Mode mode) {
        if (this.f1841e == null) {
            this.f1841e = new c0();
        }
        c0 c0Var = this.f1841e;
        c0Var.f1829b = mode;
        c0Var.f1830c = true;
        b();
    }
}
