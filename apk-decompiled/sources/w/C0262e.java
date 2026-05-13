package w;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: renamed from: w.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0262e implements KeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KeyListener f4057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f4058b;

    /* JADX INFO: renamed from: w.e$a */
    public static class a {
        public boolean a(Editable editable, int i2, KeyEvent keyEvent) {
            return androidx.emoji2.text.f.g(editable, i2, keyEvent);
        }
    }

    C0262e(KeyListener keyListener) {
        this(keyListener, new a());
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View view, Editable editable, int i2) {
        this.f4057a.clearMetaKeyState(view, editable, i2);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f4057a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i2, KeyEvent keyEvent) {
        return this.f4058b.a(editable, i2, keyEvent) || this.f4057a.onKeyDown(view, editable, i2, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f4057a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i2, KeyEvent keyEvent) {
        return this.f4057a.onKeyUp(view, editable, i2, keyEvent);
    }

    C0262e(KeyListener keyListener, a aVar) {
        this.f4057a = keyListener;
        this.f4058b = aVar;
    }
}
