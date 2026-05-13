package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R$styleable;
import w.C0258a;

/* JADX INFO: renamed from: androidx.appcompat.widget.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0124m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EditText f1912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0258a f1913b;

    C0124m(EditText editText) {
        this.f1912a = editText;
        this.f1913b = new C0258a(editText, false);
    }

    KeyListener a(KeyListener keyListener) {
        return b(keyListener) ? this.f1913b.a(keyListener) : keyListener;
    }

    boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    void c(AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = this.f1912a.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i2, 0);
        try {
            boolean z2 = typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_emojiCompatEnabled) ? typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTextView_emojiCompatEnabled, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z2);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    InputConnection d(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.f1913b.b(inputConnection, editorInfo);
    }

    void e(boolean z2) {
        this.f1913b.c(z2);
    }
}
