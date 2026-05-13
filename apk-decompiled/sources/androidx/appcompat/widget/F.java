package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.text.m;
import e.AbstractC0190a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class F extends TextView implements androidx.core.widget.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0116e f1566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final E f1567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final D f1568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C0125n f1569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f1571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Future f1572g;

    private interface a {
        void a(int[] iArr, int i2);

        void b(TextClassifier textClassifier);

        int c();

        int[] d();

        void e(int i2);

        void f(int i2);

        TextClassifier g();

        int h();

        int i();

        void j(int i2);

        void k(int i2, int i3, int i4, int i5);

        void l(int i2, float f2);

        int m();
    }

    class b implements a {
        b() {
        }

        @Override // androidx.appcompat.widget.F.a
        public void a(int[] iArr, int i2) {
            F.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
        }

        @Override // androidx.appcompat.widget.F.a
        public void b(TextClassifier textClassifier) {
            F.super.setTextClassifier(textClassifier);
        }

        @Override // androidx.appcompat.widget.F.a
        public int c() {
            return F.super.getAutoSizeMinTextSize();
        }

        @Override // androidx.appcompat.widget.F.a
        public int[] d() {
            return F.super.getAutoSizeTextAvailableSizes();
        }

        @Override // androidx.appcompat.widget.F.a
        public void e(int i2) {
        }

        @Override // androidx.appcompat.widget.F.a
        public void f(int i2) {
        }

        @Override // androidx.appcompat.widget.F.a
        public TextClassifier g() {
            return F.super.getTextClassifier();
        }

        @Override // androidx.appcompat.widget.F.a
        public int h() {
            return F.super.getAutoSizeStepGranularity();
        }

        @Override // androidx.appcompat.widget.F.a
        public int i() {
            return F.super.getAutoSizeMaxTextSize();
        }

        @Override // androidx.appcompat.widget.F.a
        public void j(int i2) {
            F.super.setAutoSizeTextTypeWithDefaults(i2);
        }

        @Override // androidx.appcompat.widget.F.a
        public void k(int i2, int i3, int i4, int i5) {
            F.super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
        }

        @Override // androidx.appcompat.widget.F.a
        public void l(int i2, float f2) {
        }

        @Override // androidx.appcompat.widget.F.a
        public int m() {
            return F.super.getAutoSizeTextType();
        }
    }

    class c extends b {
        c() {
            super();
        }

        @Override // androidx.appcompat.widget.F.b, androidx.appcompat.widget.F.a
        public void e(int i2) {
            F.super.setLastBaselineToBottomHeight(i2);
        }

        @Override // androidx.appcompat.widget.F.b, androidx.appcompat.widget.F.a
        public void f(int i2) {
            F.super.setFirstBaselineToTopHeight(i2);
        }
    }

    class d extends c {
        d() {
            super();
        }

        @Override // androidx.appcompat.widget.F.b, androidx.appcompat.widget.F.a
        public void l(int i2, float f2) {
            F.super.setLineHeight(i2, f2);
        }
    }

    public F(Context context) {
        this(context, null);
    }

    private C0125n getEmojiTextViewHelper() {
        if (this.f1569d == null) {
            this.f1569d = new C0125n(this);
        }
        return this.f1569d;
    }

    private void r() {
        Future future = this.f1572g;
        if (future != null) {
            try {
                this.f1572g = null;
                android.support.v4.media.session.b.a(future.get());
                androidx.core.widget.i.l(this, null);
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0116e c0116e = this.f1566a;
        if (c0116e != null) {
            c0116e.b();
        }
        E e2 = this.f1567b;
        if (e2 != null) {
            e2.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (p0.f1942c) {
            return getSuperCaller().i();
        }
        E e2 = this.f1567b;
        if (e2 != null) {
            return e2.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (p0.f1942c) {
            return getSuperCaller().c();
        }
        E e2 = this.f1567b;
        if (e2 != null) {
            return e2.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (p0.f1942c) {
            return getSuperCaller().h();
        }
        E e2 = this.f1567b;
        if (e2 != null) {
            return e2.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (p0.f1942c) {
            return getSuperCaller().d();
        }
        E e2 = this.f1567b;
        return e2 != null ? e2.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (p0.f1942c) {
            return getSuperCaller().m() == 1 ? 1 : 0;
        }
        E e2 = this.f1567b;
        if (e2 != null) {
            return e2.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.i.o(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return androidx.core.widget.i.a(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return androidx.core.widget.i.b(this);
    }

    a getSuperCaller() {
        a bVar;
        if (this.f1571f == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 34) {
                bVar = new d();
            } else if (i2 >= 28) {
                bVar = new c();
            } else if (i2 >= 26) {
                bVar = new b();
            }
            this.f1571f = bVar;
        }
        return this.f1571f;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0116e c0116e = this.f1566a;
        if (c0116e != null) {
            return c0116e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0116e c0116e = this.f1566a;
        if (c0116e != null) {
            return c0116e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1567b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1567b.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        r();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        D d2;
        return (Build.VERSION.SDK_INT >= 28 || (d2 = this.f1568c) == null) ? getSuperCaller().g() : d2.a();
    }

    public m.a getTextMetricsParamsCompat() {
        return androidx.core.widget.i.e(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1567b.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        return AbstractC0126o.a(inputConnectionOnCreateInputConnection, editorInfo, this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 30 || i2 >= 33 || !onCheckIsTextEditor()) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        E e2 = this.f1567b;
        if (e2 != null) {
            e2.o(z2, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        r();
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        E e2 = this.f1567b;
        if (e2 == null || p0.f1942c || !e2.l()) {
            return;
        }
        this.f1567b.c();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().c(z2);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) {
        if (p0.f1942c) {
            getSuperCaller().k(i2, i3, i4, i5);
            return;
        }
        E e2 = this.f1567b;
        if (e2 != null) {
            e2.t(i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) {
        if (p0.f1942c) {
            getSuperCaller().a(iArr, i2);
            return;
        }
        E e2 = this.f1567b;
        if (e2 != null) {
            e2.u(iArr, i2);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (p0.f1942c) {
            getSuperCaller().j(i2);
            return;
        }
        E e2 = this.f1567b;
        if (e2 != null) {
            e2.v(i2);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0116e c0116e = this.f1566a;
        if (c0116e != null) {
            c0116e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0116e c0116e = this.f1566a;
        if (c0116e != null) {
            c0116e.g(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        E e2 = this.f1567b;
        if (e2 != null) {
            e2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        E e2 = this.f1567b;
        if (e2 != null) {
            e2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i2 != 0 ? AbstractC0190a.b(context, i2) : null, i3 != 0 ? AbstractC0190a.b(context, i3) : null, i4 != 0 ? AbstractC0190a.b(context, i4) : null, i5 != 0 ? AbstractC0190a.b(context, i5) : null);
        E e2 = this.f1567b;
        if (e2 != null) {
            e2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i2 != 0 ? AbstractC0190a.b(context, i2) : null, i3 != 0 ? AbstractC0190a.b(context, i3) : null, i4 != 0 ? AbstractC0190a.b(context, i4) : null, i5 != 0 ? AbstractC0190a.b(context, i5) : null);
        E e2 = this.f1567b;
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

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().f(i2);
        } else {
            androidx.core.widget.i.h(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().e(i2);
        } else {
            androidx.core.widget.i.i(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i2) {
        androidx.core.widget.i.j(this, i2);
    }

    public void setPrecomputedText(androidx.core.text.m mVar) {
        androidx.core.widget.i.l(this, mVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0116e c0116e = this.f1566a;
        if (c0116e != null) {
            c0116e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0116e c0116e = this.f1566a;
        if (c0116e != null) {
            c0116e.j(mode);
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1567b.w(colorStateList);
        this.f1567b.b();
    }

    @Override // androidx.core.widget.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1567b.x(mode);
        this.f1567b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        E e2 = this.f1567b;
        if (e2 != null) {
            e2.q(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        D d2;
        if (Build.VERSION.SDK_INT >= 28 || (d2 = this.f1568c) == null) {
            getSuperCaller().b(textClassifier);
        } else {
            d2.b(textClassifier);
        }
    }

    public void setTextFuture(Future<androidx.core.text.m> future) {
        this.f1572g = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(m.a aVar) {
        androidx.core.widget.i.n(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i2, float f2) {
        if (p0.f1942c) {
            super.setTextSize(i2, f2);
            return;
        }
        E e2 = this.f1567b;
        if (e2 != null) {
            e2.A(i2, f2);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i2) {
        if (this.f1570e) {
            return;
        }
        Typeface typefaceA = (typeface == null || i2 <= 0) ? null : androidx.core.graphics.i.a(getContext(), typeface, i2);
        this.f1570e = true;
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        try {
            super.setTypeface(typeface, i2);
        } finally {
            this.f1570e = false;
        }
    }

    public F(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        E e2 = this.f1567b;
        if (e2 != null) {
            e2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        E e2 = this.f1567b;
        if (e2 != null) {
            e2.p();
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i2, float f2) {
        if (Build.VERSION.SDK_INT >= 34) {
            getSuperCaller().l(i2, f2);
        } else {
            androidx.core.widget.i.k(this, i2, f2);
        }
    }

    public F(Context context, AttributeSet attributeSet, int i2) {
        super(b0.b(context), attributeSet, i2);
        this.f1570e = false;
        this.f1571f = null;
        a0.a(this, getContext());
        C0116e c0116e = new C0116e(this);
        this.f1566a = c0116e;
        c0116e.e(attributeSet, i2);
        E e2 = new E(this);
        this.f1567b = e2;
        e2.m(attributeSet, i2);
        e2.b();
        this.f1568c = new D(this);
        getEmojiTextViewHelper().b(attributeSet, i2);
    }
}
