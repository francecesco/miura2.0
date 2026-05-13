package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.R$attr;
import e.AbstractC0190a;

/* JADX INFO: renamed from: androidx.appcompat.widget.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0129s extends MultiAutoCompleteTextView implements androidx.core.widget.l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f1951d = {R.attr.popupBackground};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0116e f1952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final E f1953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C0124m f1954c;

    public C0129s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
    }

    void a(C0124m c0124m) {
        KeyListener keyListener = getKeyListener();
        if (c0124m.b(keyListener)) {
            boolean zIsFocusable = super.isFocusable();
            boolean zIsClickable = super.isClickable();
            boolean zIsLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener keyListenerA = c0124m.a(keyListener);
            if (keyListenerA == keyListener) {
                return;
            }
            super.setKeyListener(keyListenerA);
            super.setRawInputType(inputType);
            super.setFocusable(zIsFocusable);
            super.setClickable(zIsClickable);
            super.setLongClickable(zIsLongClickable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0116e c0116e = this.f1952a;
        if (c0116e != null) {
            c0116e.b();
        }
        E e2 = this.f1953b;
        if (e2 != null) {
            e2.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0116e c0116e = this.f1952a;
        if (c0116e != null) {
            return c0116e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0116e c0116e = this.f1952a;
        if (c0116e != null) {
            return c0116e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1953b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1953b.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f1954c.d(AbstractC0126o.a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0116e c0116e = this.f1952a;
        if (c0116e != null) {
            c0116e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0116e c0116e = this.f1952a;
        if (c0116e != null) {
            c0116e.g(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        E e2 = this.f1953b;
        if (e2 != null) {
            e2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        E e2 = this.f1953b;
        if (e2 != null) {
            e2.p();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(AbstractC0190a.b(getContext(), i2));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        this.f1954c.e(z2);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f1954c.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0116e c0116e = this.f1952a;
        if (c0116e != null) {
            c0116e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0116e c0116e = this.f1952a;
        if (c0116e != null) {
            c0116e.j(mode);
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1953b.w(colorStateList);
        this.f1953b.b();
    }

    @Override // androidx.core.widget.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1953b.x(mode);
        this.f1953b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        E e2 = this.f1953b;
        if (e2 != null) {
            e2.q(context, i2);
        }
    }

    public C0129s(Context context, AttributeSet attributeSet, int i2) {
        super(b0.b(context), attributeSet, i2);
        a0.a(this, getContext());
        e0 e0VarU = e0.u(getContext(), attributeSet, f1951d, i2, 0);
        if (e0VarU.r(0)) {
            setDropDownBackgroundDrawable(e0VarU.f(0));
        }
        e0VarU.w();
        C0116e c0116e = new C0116e(this);
        this.f1952a = c0116e;
        c0116e.e(attributeSet, i2);
        E e2 = new E(this);
        this.f1953b = e2;
        e2.m(attributeSet, i2);
        e2.b();
        C0124m c0124m = new C0124m(this);
        this.f1954c = c0124m;
        c0124m.c(attributeSet, i2);
        a(c0124m);
    }
}
