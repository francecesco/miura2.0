package w;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.f;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: w.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0261d implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f4053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f.AbstractC0043f f4054b;

    /* JADX INFO: renamed from: w.d$a */
    private static class a extends f.AbstractC0043f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Reference f4055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Reference f4056b;

        a(TextView textView, C0261d c0261d) {
            this.f4055a = new WeakReference(textView);
            this.f4056b = new WeakReference(c0261d);
        }

        private boolean c(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.emoji2.text.f.AbstractC0043f
        public void b() {
            CharSequence text;
            CharSequence charSequenceP;
            super.b();
            TextView textView = (TextView) this.f4055a.get();
            if (c(textView, (InputFilter) this.f4056b.get()) && textView.isAttachedToWindow() && text != (charSequenceP = androidx.emoji2.text.f.c().p((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(charSequenceP);
                int selectionEnd = Selection.getSelectionEnd(charSequenceP);
                textView.setText(charSequenceP);
                if (charSequenceP instanceof Spannable) {
                    C0261d.b((Spannable) charSequenceP, selectionStart, selectionEnd);
                }
            }
        }
    }

    C0261d(TextView textView) {
        this.f4053a = textView;
    }

    private f.AbstractC0043f a() {
        if (this.f4054b == null) {
            this.f4054b = new a(this.f4053a, this);
        }
        return this.f4054b;
    }

    static void b(Spannable spannable, int i2, int i3) {
        if (i2 >= 0 && i3 >= 0) {
            Selection.setSelection(spannable, i2, i3);
        } else if (i2 >= 0) {
            Selection.setSelection(spannable, i2);
        } else if (i3 >= 0) {
            Selection.setSelection(spannable, i3);
        }
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        if (this.f4053a.isInEditMode()) {
            return charSequence;
        }
        int iE = androidx.emoji2.text.f.c().e();
        if (iE != 0) {
            if (iE == 1) {
                if ((i5 == 0 && i4 == 0 && spanned.length() == 0 && charSequence == this.f4053a.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i2 != 0 || i3 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i2, i3);
                }
                return androidx.emoji2.text.f.c().q(charSequence, 0, charSequence.length());
            }
            if (iE != 3) {
                return charSequence;
            }
        }
        androidx.emoji2.text.f.c().t(a());
        return charSequence;
    }
}
