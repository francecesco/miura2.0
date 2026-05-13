package X;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import it.tervis.miura.R;
import it.tervis.miura.model.Configuration;

/* JADX INFO: loaded from: classes.dex */
public class f extends b {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private EditText f484i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private EditText f485j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private EditText f486k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private EditText f487l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private EditText f488m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private CheckBox f489n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private Button f490o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f491p0 = -1;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j0.f.f().getConfigurations().remove(f.this.f491p0);
            j0.f.p();
            f.this.i().setResult(-1);
            f.this.i().finish();
        }
    }

    private boolean N1() {
        if (P1(this.f485j0.getText().toString(), 4, 8)) {
            return true;
        }
        this.f464d0.E("Errore", "Il codice non è valido: deve essere un numero di almeno 4 cifre e massimo 8 cifre.");
        return false;
    }

    private boolean O1() {
        if (this.f486k0.getText().toString().trim().length() != 0) {
            return true;
        }
        this.f464d0.E("Errore", "Il campo Host non può essere vuoto.");
        return false;
    }

    private boolean P1(String str, int i2, int i3) {
        String strTrim = str.trim();
        if (strTrim.length() < i2 || strTrim.length() > i3) {
            return false;
        }
        try {
            Integer.parseInt(strTrim);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean Q1(String str, int i2, int i3) {
        try {
            int i4 = Integer.parseInt(str.trim());
            return i4 >= i2 && i4 <= i3;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean R1() {
        if (Q1(this.f487l0.getText().toString(), 10, 65535)) {
            return true;
        }
        this.f464d0.E("Errore", "Il numero di porta deve essere compreso tra 10 e 65535.");
        return false;
    }

    private boolean S1() {
        return N1() && R1() && O1();
    }

    private String T1() {
        String string = this.f488m0.getText().toString();
        if (string == null || string.length() <= 0) {
            return "";
        }
        if (string.startsWith("+")) {
            return string;
        }
        if (string.startsWith("00")) {
            return "+" + string.substring(2, string.length());
        }
        return "+39" + string;
    }

    @Override // X.b, androidx.fragment.app.Fragment
    public void J0() {
        if (this.f491p0 > -1) {
            Configuration configuration = j0.f.f().getConfigurations().get(this.f491p0);
            this.f484i0.setText(configuration.getName());
            this.f485j0.setText(configuration.getPin());
            this.f486k0.setText(configuration.getHost());
            this.f487l0.setText(Integer.toString(configuration.getPort()));
            this.f488m0.setText(configuration.getBoardCallerID());
        }
        super.J0();
    }

    public boolean U1() {
        Configuration configuration;
        boolean zS1 = S1();
        if (zS1) {
            String strTrim = this.f486k0.getText().toString().trim();
            int i2 = Integer.parseInt(this.f487l0.getText().toString());
            j0.f.u(false);
            if (this.f491p0 == -1) {
                configuration = new Configuration();
                j0.f.f().getConfigurations().add(configuration);
            } else {
                configuration = j0.f.f().getConfigurations().get(this.f491p0);
            }
            configuration.setName(this.f484i0.getText().toString());
            configuration.setHost(strTrim);
            configuration.setPort(i2);
            configuration.setPin(this.f485j0.getText().toString());
            configuration.setBoardCallerID(T1());
            configuration.setTextCacheDump("");
            ((InputMethodManager) i().getSystemService("input_method")).hideSoftInputFromWindow(this.f486k0.getWindowToken(), 0);
            j0.f.p();
        }
        ((it.tervis.miura.activity.b) i()).D0();
        return zS1;
    }

    public void V1(boolean z2) {
        this.f484i0.setEnabled(z2);
        this.f485j0.setEnabled(z2);
        this.f486k0.setEnabled(z2);
        this.f487l0.setEnabled(z2);
        this.f489n0.setEnabled(z2);
        this.f488m0.setEnabled(z2);
        this.f490o0.setEnabled(z2);
        this.f490o0.setBackgroundColor(-65536);
    }

    @Override // androidx.fragment.app.Fragment
    public View q0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_settings, viewGroup, false);
        this.f465e0 = viewGroup2;
        this.f484i0 = (EditText) viewGroup2.findViewById(R.id.edit_configuration_name);
        this.f485j0 = (EditText) this.f465e0.findViewById(R.id.edit_code);
        this.f486k0 = (EditText) this.f465e0.findViewById(R.id.edit_host);
        this.f487l0 = (EditText) this.f465e0.findViewById(R.id.edit_port);
        this.f488m0 = (EditText) this.f465e0.findViewById(R.id.edit_callerid);
        this.f489n0 = (CheckBox) this.f465e0.findViewById(R.id.check_load_texts);
        this.f490o0 = (Button) this.f465e0.findViewById(R.id.button_delete);
        int i2 = m().getInt(".index", -1);
        this.f491p0 = i2;
        if (i2 >= 0) {
            this.f490o0.setEnabled(false);
            this.f490o0.setOnClickListener(new a());
        } else {
            this.f490o0.setVisibility(8);
        }
        return this.f465e0;
    }
}
