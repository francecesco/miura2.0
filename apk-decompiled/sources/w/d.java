package W;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import it.tervis.miura.Miura;
import it.tervis.miura.R;

/* JADX INFO: loaded from: classes.dex */
public class d extends b {

    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            d.this.L1();
            ((Miura) d.this.i()).o1(false);
        }
    }

    public static d Y1(String str, String str2) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putString(".title", str);
        bundle.putString(".message", str2);
        dVar.t1(bundle);
        return dVar;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0166e
    public Dialog P1(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(i());
        builder.setMessage(m().getString(".message")).setTitle(m().getString(".title")).setNegativeButton(R.string.label_OK, new a()).setCancelable(false);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        return alertDialogCreate;
    }
}
