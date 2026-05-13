package w;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;

/* JADX INFO: renamed from: w.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0260c extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f4051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f4052b;

    /* JADX INFO: renamed from: w.c$a */
    public static class a {
        public boolean a(InputConnection inputConnection, Editable editable, int i2, int i3, boolean z2) {
            return androidx.emoji2.text.f.f(inputConnection, editable, i2, i3, z2);
        }

        public void b(EditorInfo editorInfo) {
            if (androidx.emoji2.text.f.i()) {
                androidx.emoji2.text.f.c().v(editorInfo);
            }
        }
    }

    C0260c(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new a());
    }

    private Editable a() {
        return this.f4051a.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i2, int i3) {
        return this.f4052b.a(this, a(), i2, i3, false) || super.deleteSurroundingText(i2, i3);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i2, int i3) {
        return this.f4052b.a(this, a(), i2, i3, true) || super.deleteSurroundingTextInCodePoints(i2, i3);
    }

    C0260c(TextView textView, InputConnection inputConnection, EditorInfo editorInfo, a aVar) {
        super(inputConnection, false);
        this.f4051a = textView;
        this.f4052b = aVar;
        aVar.b(editorInfo);
    }
}
