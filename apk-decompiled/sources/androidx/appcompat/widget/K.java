package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* JADX INFO: loaded from: classes.dex */
public class K extends ToggleButton implements androidx.core.widget.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0116e f1591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final E f1592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C0125n f1593c;

    public K(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    private C0125n getEmojiTextViewHelper() {
        if (this.f1593c == null) {
            this.f1593c = new C0125n(this);
        }
        return this.f1593c;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0116e c0116e = this.f1591a;
        if (c0116e != null) {
            c0116e.b();
        }
        E e2 = this.f1592b;
        if (e2 != null) {
            e2.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0116e c0116e = this.f1591a;
        if (c0116e != null) {
            return c0116e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0116e c0116e = this.f1591a;
        if (c0116e != null) {
            return c0116e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1592b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1592b.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().c(z2);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0116e c0116e = this.f1591a;
        if (c0116e != null) {
            c0116e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0116e c0116e = this.f1591a;
        if (c0116e != null) {
            c0116e.g(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        E e2 = this.f1592b;
        if (e2 != null) {
            e2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        E e2 = this.f1592b;
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
        C0116e c0116e = this.f1591a;
        if (c0116e != null) {
            c0116e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0116e c0116e = this.f1591a;
        if (c0116e != null) {
            c0116e.j(mode);
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1592b.w(colorStateList);
        this.f1592b.b();
    }

    @Override // androidx.core.widget.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1592b.x(mode);
        this.f1592b.b();
    }

    public K(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a0.a(this, getContext());
        C0116e c0116e = new C0116e(this);
        this.f1591a = c0116e;
        c0116e.e(attributeSet, i2);
        E e2 = new E(this);
        this.f1592b = e2;
        e2.m(attributeSet, i2);
        getEmojiTextViewHelper().b(attributeSet, i2);
    }
}
