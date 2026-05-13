package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R$styleable;
import e.AbstractC0190a;

/* JADX INFO: renamed from: androidx.appcompat.widget.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0121j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CompoundButton f1888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorStateList f1889b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f1890c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1891d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1892e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1893f;

    C0121j(CompoundButton compoundButton) {
        this.f1888a = compoundButton;
    }

    void a() {
        Drawable drawableA = androidx.core.widget.c.a(this.f1888a);
        if (drawableA != null) {
            if (this.f1891d || this.f1892e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.p(drawableA).mutate();
                if (this.f1891d) {
                    androidx.core.graphics.drawable.a.n(drawableMutate, this.f1889b);
                }
                if (this.f1892e) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.f1890c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f1888a.getDrawableState());
                }
                this.f1888a.setButtonDrawable(drawableMutate);
            }
        }
    }

    ColorStateList b() {
        return this.f1889b;
    }

    PorterDuff.Mode c() {
        return this.f1890c;
    }

    void d(AttributeSet attributeSet, int i2) {
        int iM;
        int iM2;
        e0 e0VarU = e0.u(this.f1888a.getContext(), attributeSet, R$styleable.CompoundButton, i2, 0);
        CompoundButton compoundButton = this.f1888a;
        androidx.core.view.L.S(compoundButton, compoundButton.getContext(), R$styleable.CompoundButton, attributeSet, e0VarU.q(), i2, 0);
        try {
            if (e0VarU.r(R$styleable.CompoundButton_buttonCompat) && (iM2 = e0VarU.m(R$styleable.CompoundButton_buttonCompat, 0)) != 0) {
                try {
                    CompoundButton compoundButton2 = this.f1888a;
                    compoundButton2.setButtonDrawable(AbstractC0190a.b(compoundButton2.getContext(), iM2));
                } catch (Resources.NotFoundException unused) {
                    if (e0VarU.r(R$styleable.CompoundButton_android_button)) {
                        CompoundButton compoundButton3 = this.f1888a;
                        compoundButton3.setButtonDrawable(AbstractC0190a.b(compoundButton3.getContext(), iM));
                    }
                }
            } else if (e0VarU.r(R$styleable.CompoundButton_android_button) && (iM = e0VarU.m(R$styleable.CompoundButton_android_button, 0)) != 0) {
                CompoundButton compoundButton32 = this.f1888a;
                compoundButton32.setButtonDrawable(AbstractC0190a.b(compoundButton32.getContext(), iM));
            }
            if (e0VarU.r(R$styleable.CompoundButton_buttonTint)) {
                androidx.core.widget.c.b(this.f1888a, e0VarU.c(R$styleable.CompoundButton_buttonTint));
            }
            if (e0VarU.r(R$styleable.CompoundButton_buttonTintMode)) {
                androidx.core.widget.c.c(this.f1888a, N.c(e0VarU.j(R$styleable.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            e0VarU.w();
        }
    }

    void e() {
        if (this.f1893f) {
            this.f1893f = false;
        } else {
            this.f1893f = true;
            a();
        }
    }

    void f(ColorStateList colorStateList) {
        this.f1889b = colorStateList;
        this.f1891d = true;
        a();
    }

    void g(PorterDuff.Mode mode) {
        this.f1890c = mode;
        this.f1892e = true;
        a();
    }
}
