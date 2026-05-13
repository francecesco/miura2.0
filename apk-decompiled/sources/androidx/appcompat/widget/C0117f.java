package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.appcompat.R$attr;

/* JADX INFO: renamed from: androidx.appcompat.widget.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0117f extends Button implements androidx.core.widget.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0116e f1846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final E f1847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C0125n f1848c;

    public C0117f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.buttonStyle);
    }

    private C0125n getEmojiTextViewHelper() {
        if (this.f1848c == null) {
            this.f1848c = new C0125n(this);
        }
        return this.f1848c;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0116e c0116e = this.f1846a;
        if (c0116e != null) {
            c0116e.b();
        }
        E e2 = this.f1847b;
        if (e2 != null) {
            e2.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (p0.f1942c) {
            return super.getAutoSizeMaxTextSize();
        }
        E e2 = this.f1847b;
        if (e2 != null) {
            return e2.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (p0.f1942c) {
            return super.getAutoSizeMinTextSize();
        }
        E e2 = this.f1847b;
        if (e2 != null) {
            return e2.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (p0.f1942c) {
            return super.getAutoSizeStepGranularity();
        }
        E e2 = this.f1847b;
        if (e2 != null) {
            return e2.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (p0.f1942c) {
            return super.getAutoSizeTextAvailableSizes();
        }
        E e2 = this.f1847b;
        return e2 != null ? e2.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (p0.f1942c) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        E e2 = this.f1847b;
        if (e2 != null) {
            return e2.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.i.o(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0116e c0116e = this.f1846a;
        if (c0116e != null) {
            return c0116e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0116e c0116e = this.f1846a;
        if (c0116e != null) {
            return c0116e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1847b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1847b.k();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        E e2 = this.f1847b;
        if (e2 != null) {
            e2.o(z2, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        E e2 = this.f1847b;
        if (e2 == null || p0.f1942c || !e2.l()) {
            return;
        }
        this.f1847b.c();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().c(z2);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) {
        if (p0.f1942c) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        E e2 = this.f1847b;
        if (e2 != null) {
            e2.t(i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) {
        if (p0.f1942c) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        E e2 = this.f1847b;
        if (e2 != null) {
            e2.u(iArr, i2);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (p0.f1942c) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        E e2 = this.f1847b;
        if (e2 != null) {
            e2.v(i2);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0116e c0116e = this.f1846a;
        if (c0116e != null) {
            c0116e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0116e c0116e = this.f1846a;
        if (c0116e != null) {
            c0116e.g(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().d(z2);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z2) {
        E e2 = this.f1847b;
        if (e2 != null) {
            e2.s(z2);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0116e c0116e = this.f1846a;
        if (c0116e != null) {
            c0116e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0116e c0116e = this.f1846a;
        if (c0116e != null) {
            c0116e.j(mode);
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1847b.w(colorStateList);
        this.f1847b.b();
    }

    @Override // androidx.core.widget.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1847b.x(mode);
        this.f1847b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        E e2 = this.f1847b;
        if (e2 != null) {
            e2.q(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i2, float f2) {
        if (p0.f1942c) {
            super.setTextSize(i2, f2);
            return;
        }
        E e2 = this.f1847b;
        if (e2 != null) {
            e2.A(i2, f2);
        }
    }

    public C0117f(Context context, AttributeSet attributeSet, int i2) {
        super(b0.b(context), attributeSet, i2);
        a0.a(this, getContext());
        C0116e c0116e = new C0116e(this);
        this.f1846a = c0116e;
        c0116e.e(attributeSet, i2);
        E e2 = new E(this);
        this.f1847b = e2;
        e2.m(attributeSet, i2);
        e2.b();
        getEmojiTextViewHelper().b(attributeSet, i2);
    }
}
