package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.appcompat.R$attr;
import androidx.core.view.C0140d;

/* JADX INFO: renamed from: androidx.appcompat.widget.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0123l extends EditText implements androidx.core.view.G, androidx.core.widget.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0116e f1904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final E f1905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final D f1906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.core.widget.k f1907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final C0124m f1908e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f1909f;

    /* JADX INFO: renamed from: androidx.appcompat.widget.l$a */
    class a {
        a() {
        }

        public TextClassifier a() {
            return C0123l.super.getTextClassifier();
        }

        public void b(TextClassifier textClassifier) {
            C0123l.super.setTextClassifier(textClassifier);
        }
    }

    public C0123l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.editTextStyle);
    }

    private a getSuperCaller() {
        if (this.f1909f == null) {
            this.f1909f = new a();
        }
        return this.f1909f;
    }

    @Override // androidx.core.view.G
    public C0140d a(C0140d c0140d) {
        return this.f1907d.a(this, c0140d);
    }

    void d(C0124m c0124m) {
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
        C0116e c0116e = this.f1904a;
        if (c0116e != null) {
            c0116e.b();
        }
        E e2 = this.f1905b;
        if (e2 != null) {
            e2.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.i.o(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0116e c0116e = this.f1904a;
        if (c0116e != null) {
            return c0116e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0116e c0116e = this.f1904a;
        if (c0116e != null) {
            return c0116e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1905b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1905b.k();
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        D d2;
        return (Build.VERSION.SDK_INT >= 28 || (d2 = this.f1906c) == null) ? getSuperCaller().a() : d2.a();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] strArrX;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1905b.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        InputConnection inputConnectionA = AbstractC0126o.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        if (inputConnectionA != null && Build.VERSION.SDK_INT <= 30 && (strArrX = androidx.core.view.L.x(this)) != null) {
            s.c.d(editorInfo, strArrX);
            inputConnectionA = s.e.c(this, inputConnectionA, editorInfo);
        }
        return this.f1908e.d(inputConnectionA, editorInfo);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 30 || i2 >= 33) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        if (AbstractC0134x.a(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i2) {
        if (AbstractC0134x.b(this, i2)) {
            return true;
        }
        return super.onTextContextMenuItem(i2);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0116e c0116e = this.f1904a;
        if (c0116e != null) {
            c0116e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0116e c0116e = this.f1904a;
        if (c0116e != null) {
            c0116e.g(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        E e2 = this.f1905b;
        if (e2 != null) {
            e2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        E e2 = this.f1905b;
        if (e2 != null) {
            e2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        this.f1908e.e(z2);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f1908e.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0116e c0116e = this.f1904a;
        if (c0116e != null) {
            c0116e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0116e c0116e = this.f1904a;
        if (c0116e != null) {
            c0116e.j(mode);
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1905b.w(colorStateList);
        this.f1905b.b();
    }

    @Override // androidx.core.widget.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1905b.x(mode);
        this.f1905b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        E e2 = this.f1905b;
        if (e2 != null) {
            e2.q(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        D d2;
        if (Build.VERSION.SDK_INT >= 28 || (d2 = this.f1906c) == null) {
            getSuperCaller().b(textClassifier);
        } else {
            d2.b(textClassifier);
        }
    }

    public C0123l(Context context, AttributeSet attributeSet, int i2) {
        super(b0.b(context), attributeSet, i2);
        a0.a(this, getContext());
        C0116e c0116e = new C0116e(this);
        this.f1904a = c0116e;
        c0116e.e(attributeSet, i2);
        E e2 = new E(this);
        this.f1905b = e2;
        e2.m(attributeSet, i2);
        e2.b();
        this.f1906c = new D(this);
        this.f1907d = new androidx.core.widget.k();
        C0124m c0124m = new C0124m(this);
        this.f1908e = c0124m;
        c0124m.c(attributeSet, i2);
        d(c0124m);
    }
}
