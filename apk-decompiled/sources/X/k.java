package X;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import it.tervis.miura.R;

/* JADX INFO: loaded from: classes.dex */
public class k extends b {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private EditText f521i0;

    @Override // X.b, androidx.fragment.app.Fragment
    public void J0() {
        j0.d.a("Starting Fragment " + getClass().getName());
        super.J0();
        this.f521i0.setText("");
        this.f521i0.requestFocus();
        if (j0.f.o()) {
            return;
        }
        new W.a().X1(i().f0(), "");
    }

    @Override // androidx.fragment.app.Fragment
    public View q0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_access, viewGroup, false);
        this.f465e0 = viewGroup2;
        EditText editText = (EditText) viewGroup2.findViewById(R.id.edit_pin);
        this.f521i0 = editText;
        editText.addTextChangedListener(new a());
        return this.f465e0;
    }

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (k.this.c0()) {
                String strTrim = charSequence.toString().trim();
                if (strTrim.length() == 5 && j0.f.n(strTrim)) {
                    ((InputMethodManager) k.this.i().getSystemService("input_method")).hideSoftInputFromWindow(k.this.f521i0.getWindowToken(), 0);
                    ((it.tervis.miura.a) k.this.i()).e();
                }
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }
}
