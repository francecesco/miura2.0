package w;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import o.AbstractC0236e;

/* JADX INFO: renamed from: w.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0258a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f4043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4044b = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4045c = 0;

    /* JADX INFO: renamed from: w.a$a, reason: collision with other inner class name */
    private static class C0074a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EditText f4046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g f4047b;

        C0074a(EditText editText, boolean z2) {
            this.f4046a = editText;
            g gVar = new g(editText, z2);
            this.f4047b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(C0259b.getInstance());
        }

        @Override // w.C0258a.b
        KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof C0262e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new C0262e(keyListener);
        }

        @Override // w.C0258a.b
        InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof C0260c ? inputConnection : new C0260c(this.f4046a, inputConnection, editorInfo);
        }

        @Override // w.C0258a.b
        void c(boolean z2) {
            this.f4047b.c(z2);
        }
    }

    /* JADX INFO: renamed from: w.a$b */
    static class b {
        b() {
        }

        abstract KeyListener a(KeyListener keyListener);

        abstract InputConnection b(InputConnection inputConnection, EditorInfo editorInfo);

        abstract void c(boolean z2);
    }

    public C0258a(EditText editText, boolean z2) {
        AbstractC0236e.g(editText, "editText cannot be null");
        this.f4043a = new C0074a(editText, z2);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f4043a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f4043a.b(inputConnection, editorInfo);
    }

    public void c(boolean z2) {
        this.f4043a.c(z2);
    }
}
