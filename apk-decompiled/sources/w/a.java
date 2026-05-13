package W;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import it.tervis.miura.R;
import j0.f;

/* JADX INFO: loaded from: classes.dex */
public class a extends W.b {
    private String A0;
    private EditText w0;
    private TextView x0;
    private TextView y0;
    private e z0 = e.ENTER;

    /* JADX INFO: renamed from: W.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0005a implements View.OnClickListener {
        ViewOnClickListenerC0005a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a2();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.Z1();
        }
    }

    static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f410a;

        static {
            int[] iArr = new int[e.values().length];
            f410a = iArr;
            try {
                iArr[e.ENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f410a[e.CONFIRM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private enum e {
        ENTER,
        CONFIRM
    }

    public a() {
        T1(true);
    }

    private String Y1() {
        return this.w0.getText().toString();
    }

    private void b2() {
        int i2 = d.f410a[this.z0.ordinal()];
        if (i2 == 1) {
            N1().setTitle("Benvenuto");
            this.x0.setVisibility(0);
            this.y0.setVisibility(8);
        } else if (i2 == 2) {
            N1().setTitle("Conferma");
            this.x0.setVisibility(8);
            this.y0.setVisibility(0);
        }
        this.w0.setText("");
    }

    @Override // W.b, androidx.fragment.app.DialogInterfaceOnCancelListenerC0166e, androidx.fragment.app.Fragment
    public void J0() {
        super.J0();
        b2();
    }

    protected void Z1() {
        e eVar = this.z0;
        e eVar2 = e.ENTER;
        if (eVar == eVar2) {
            i().finish();
        } else {
            this.z0 = eVar2;
            b2();
        }
    }

    protected void a2() {
        if (this.z0 == e.ENTER) {
            this.A0 = Y1();
            this.z0 = e.CONFIRM;
            b2();
            return;
        }
        String strY1 = Y1();
        if (!strY1.equals(this.A0)) {
            this.f414s0.p("I codici di accesso sono diversi. Riprovare.");
            Z1();
        } else {
            f.q(strY1);
            this.f414s0.p("Codice valido. Benvenuto su Miura.");
            L1();
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0166e, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        i().finish();
    }

    @Override // androidx.fragment.app.Fragment
    public View q0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_access_code, viewGroup, false);
        this.f415t0 = viewGroup2;
        this.w0 = (EditText) viewGroup2.findViewById(R.id.edit_access_code);
        this.x0 = (TextView) this.f415t0.findViewById(R.id.text_welcome);
        this.y0 = (TextView) this.f415t0.findViewById(R.id.text_confirm);
        Button button = (Button) this.f415t0.findViewById(R.id.button_ok);
        button.setOnClickListener(new ViewOnClickListenerC0005a());
        ((Button) this.f415t0.findViewById(R.id.button_cancel)).setOnClickListener(new b());
        this.w0.addTextChangedListener(new c(button));
        return this.f415t0;
    }

    class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Button f408a;

        c(Button button) {
            this.f408a = button;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Button button;
            boolean z2;
            if (charSequence.toString().trim().length() == 5) {
                button = this.f408a;
                z2 = true;
            } else {
                button = this.f408a;
                z2 = false;
            }
            button.setEnabled(z2);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }
}
