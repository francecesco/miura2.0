package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;

/* JADX INFO: renamed from: androidx.appcompat.widget.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0125n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f1926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w.f f1927b;

    C0125n(TextView textView) {
        this.f1926a = textView;
        this.f1927b = new w.f(textView, false);
    }

    InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f1927b.a(inputFilterArr);
    }

    void b(AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = this.f1926a.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i2, 0);
        try {
            boolean z2 = typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_emojiCompatEnabled) ? typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTextView_emojiCompatEnabled, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            d(z2);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    void c(boolean z2) {
        this.f1927b.b(z2);
    }

    void d(boolean z2) {
        this.f1927b.c(z2);
    }
}
