package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.appcompat.R$attr;
import e.AbstractC0190a;

/* JADX INFO: renamed from: androidx.appcompat.widget.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0118g extends CheckBox implements androidx.core.widget.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0121j f1850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0116e f1851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final E f1852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C0125n f1853d;

    public C0118g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.checkboxStyle);
    }

    private C0125n getEmojiTextViewHelper() {
        if (this.f1853d == null) {
            this.f1853d = new C0125n(this);
        }
        return this.f1853d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0116e c0116e = this.f1851b;
        if (c0116e != null) {
            c0116e.b();
        }
        E e2 = this.f1852c;
        if (e2 != null) {
            e2.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0116e c0116e = this.f1851b;
        if (c0116e != null) {
            return c0116e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0116e c0116e = this.f1851b;
        if (c0116e != null) {
            return c0116e.d();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        C0121j c0121j = this.f1850a;
        if (c0121j != null) {
            return c0121j.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C0121j c0121j = this.f1850a;
        if (c0121j != null) {
            return c0121j.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1852c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1852c.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().c(z2);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0116e c0116e = this.f1851b;
        if (c0116e != null) {
            c0116e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0116e c0116e = this.f1851b;
        if (c0116e != null) {
            c0116e.g(i2);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i2) {
        setButtonDrawable(AbstractC0190a.b(getContext(), i2));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        E e2 = this.f1852c;
        if (e2 != null) {
            e2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        E e2 = this.f1852c;
        if (e2 != null) {
            e2.p();
        }
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().d(z2);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0116e c0116e = this.f1851b;
        if (c0116e != null) {
            c0116e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0116e c0116e = this.f1851b;
        if (c0116e != null) {
            c0116e.j(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0121j c0121j = this.f1850a;
        if (c0121j != null) {
            c0121j.f(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C0121j c0121j = this.f1850a;
        if (c0121j != null) {
            c0121j.g(mode);
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1852c.w(colorStateList);
        this.f1852c.b();
    }

    @Override // androidx.core.widget.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1852c.x(mode);
        this.f1852c.b();
    }

    public C0118g(Context context, AttributeSet attributeSet, int i2) {
        super(b0.b(context), attributeSet, i2);
        a0.a(this, getContext());
        C0121j c0121j = new C0121j(this);
        this.f1850a = c0121j;
        c0121j.d(attributeSet, i2);
        C0116e c0116e = new C0116e(this);
        this.f1851b = c0116e;
        c0116e.e(attributeSet, i2);
        E e2 = new E(this);
        this.f1852c = e2;
        e2.m(attributeSet, i2);
        getEmojiTextViewHelper().b(attributeSet, i2);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0121j c0121j = this.f1850a;
        if (c0121j != null) {
            c0121j.e();
        }
    }
}
