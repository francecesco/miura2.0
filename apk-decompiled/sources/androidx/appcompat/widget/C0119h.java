package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.R$attr;
import e.AbstractC0190a;

/* JADX INFO: renamed from: androidx.appcompat.widget.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0119h extends CheckedTextView implements androidx.core.widget.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0120i f1855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0116e f1856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final E f1857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C0125n f1858d;

    public C0119h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.checkedTextViewStyle);
    }

    private C0125n getEmojiTextViewHelper() {
        if (this.f1858d == null) {
            this.f1858d = new C0125n(this);
        }
        return this.f1858d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        E e2 = this.f1857c;
        if (e2 != null) {
            e2.b();
        }
        C0116e c0116e = this.f1856b;
        if (c0116e != null) {
            c0116e.b();
        }
        C0120i c0120i = this.f1855a;
        if (c0120i != null) {
            c0120i.a();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.i.o(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0116e c0116e = this.f1856b;
        if (c0116e != null) {
            return c0116e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0116e c0116e = this.f1856b;
        if (c0116e != null) {
            return c0116e.d();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        C0120i c0120i = this.f1855a;
        if (c0120i != null) {
            return c0120i.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        C0120i c0120i = this.f1855a;
        if (c0120i != null) {
            return c0120i.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1857c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1857c.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AbstractC0126o.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().c(z2);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0116e c0116e = this.f1856b;
        if (c0116e != null) {
            c0116e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0116e c0116e = this.f1856b;
        if (c0116e != null) {
            c0116e.g(i2);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i2) {
        setCheckMarkDrawable(AbstractC0190a.b(getContext(), i2));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        E e2 = this.f1857c;
        if (e2 != null) {
            e2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        E e2 = this.f1857c;
        if (e2 != null) {
            e2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().d(z2);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0116e c0116e = this.f1856b;
        if (c0116e != null) {
            c0116e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0116e c0116e = this.f1856b;
        if (c0116e != null) {
            c0116e.j(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        C0120i c0120i = this.f1855a;
        if (c0120i != null) {
            c0120i.f(colorStateList);
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        C0120i c0120i = this.f1855a;
        if (c0120i != null) {
            c0120i.g(mode);
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1857c.w(colorStateList);
        this.f1857c.b();
    }

    @Override // androidx.core.widget.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1857c.x(mode);
        this.f1857c.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        E e2 = this.f1857c;
        if (e2 != null) {
            e2.q(context, i2);
        }
    }

    public C0119h(Context context, AttributeSet attributeSet, int i2) {
        super(b0.b(context), attributeSet, i2);
        a0.a(this, getContext());
        E e2 = new E(this);
        this.f1857c = e2;
        e2.m(attributeSet, i2);
        e2.b();
        C0116e c0116e = new C0116e(this);
        this.f1856b = c0116e;
        c0116e.e(attributeSet, i2);
        C0120i c0120i = new C0120i(this);
        this.f1855a = c0120i;
        c0120i.d(attributeSet, i2);
        getEmojiTextViewHelper().b(attributeSet, i2);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        C0120i c0120i = this.f1855a;
        if (c0120i != null) {
            c0120i.e();
        }
    }
}
