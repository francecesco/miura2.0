package w;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.f;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class g implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EditText f4064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f4065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f.AbstractC0043f f4066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4067d = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4068e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4069f = true;

    private static class a extends f.AbstractC0043f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Reference f4070a;

        a(EditText editText) {
            this.f4070a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.f.AbstractC0043f
        public void b() {
            super.b();
            g.b((EditText) this.f4070a.get(), 1);
        }
    }

    g(EditText editText, boolean z2) {
        this.f4064a = editText;
        this.f4065b = z2;
    }

    private f.AbstractC0043f a() {
        if (this.f4066c == null) {
            this.f4066c = new a(this.f4064a);
        }
        return this.f4066c;
    }

    static void b(EditText editText, int i2) {
        if (i2 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.f.c().p(editableText);
            C0261d.b(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean d() {
        return (this.f4069f && (this.f4065b || androidx.emoji2.text.f.i())) ? false : true;
    }

    public void c(boolean z2) {
        if (this.f4069f != z2) {
            if (this.f4066c != null) {
                androidx.emoji2.text.f.c().u(this.f4066c);
            }
            this.f4069f = z2;
            if (z2) {
                b(this.f4064a, androidx.emoji2.text.f.c().e());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (this.f4064a.isInEditMode() || d() || i3 > i4 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iE = androidx.emoji2.text.f.c().e();
        if (iE != 0) {
            if (iE == 1) {
                androidx.emoji2.text.f.c().s((Spannable) charSequence, i2, i2 + i4, this.f4067d, this.f4068e);
                return;
            } else if (iE != 3) {
                return;
            }
        }
        androidx.emoji2.text.f.c().t(a());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
