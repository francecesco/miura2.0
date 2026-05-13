package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.appcompat.R$styleable;
import e.AbstractC0190a;

/* JADX INFO: renamed from: androidx.appcompat.widget.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0120i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CheckedTextView f1860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorStateList f1861b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f1862c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1863d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1864e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1865f;

    C0120i(CheckedTextView checkedTextView) {
        this.f1860a = checkedTextView;
    }

    void a() {
        Drawable drawableA = androidx.core.widget.b.a(this.f1860a);
        if (drawableA != null) {
            if (this.f1863d || this.f1864e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.p(drawableA).mutate();
                if (this.f1863d) {
                    androidx.core.graphics.drawable.a.n(drawableMutate, this.f1861b);
                }
                if (this.f1864e) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.f1862c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f1860a.getDrawableState());
                }
                this.f1860a.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    ColorStateList b() {
        return this.f1861b;
    }

    PorterDuff.Mode c() {
        return this.f1862c;
    }

    void d(AttributeSet attributeSet, int i2) {
        int iM;
        int iM2;
        e0 e0VarU = e0.u(this.f1860a.getContext(), attributeSet, R$styleable.CheckedTextView, i2, 0);
        CheckedTextView checkedTextView = this.f1860a;
        androidx.core.view.L.S(checkedTextView, checkedTextView.getContext(), R$styleable.CheckedTextView, attributeSet, e0VarU.q(), i2, 0);
        try {
            if (e0VarU.r(R$styleable.CheckedTextView_checkMarkCompat) && (iM2 = e0VarU.m(R$styleable.CheckedTextView_checkMarkCompat, 0)) != 0) {
                try {
                    CheckedTextView checkedTextView2 = this.f1860a;
                    checkedTextView2.setCheckMarkDrawable(AbstractC0190a.b(checkedTextView2.getContext(), iM2));
                } catch (Resources.NotFoundException unused) {
                    if (e0VarU.r(R$styleable.CheckedTextView_android_checkMark)) {
                        CheckedTextView checkedTextView3 = this.f1860a;
                        checkedTextView3.setCheckMarkDrawable(AbstractC0190a.b(checkedTextView3.getContext(), iM));
                    }
                }
            } else if (e0VarU.r(R$styleable.CheckedTextView_android_checkMark) && (iM = e0VarU.m(R$styleable.CheckedTextView_android_checkMark, 0)) != 0) {
                CheckedTextView checkedTextView32 = this.f1860a;
                checkedTextView32.setCheckMarkDrawable(AbstractC0190a.b(checkedTextView32.getContext(), iM));
            }
            if (e0VarU.r(R$styleable.CheckedTextView_checkMarkTint)) {
                androidx.core.widget.b.b(this.f1860a, e0VarU.c(R$styleable.CheckedTextView_checkMarkTint));
            }
            if (e0VarU.r(R$styleable.CheckedTextView_checkMarkTintMode)) {
                androidx.core.widget.b.c(this.f1860a, N.c(e0VarU.j(R$styleable.CheckedTextView_checkMarkTintMode, -1), null));
            }
        } finally {
            e0VarU.w();
        }
    }

    void e() {
        if (this.f1865f) {
            this.f1865f = false;
        } else {
            this.f1865f = true;
            a();
        }
    }

    void f(ColorStateList colorStateList) {
        this.f1861b = colorStateList;
        this.f1863d = true;
        a();
    }

    void g(PorterDuff.Mode mode) {
        this.f1862c = mode;
        this.f1864e = true;
        a();
    }
}
