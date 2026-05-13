package X;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import it.tervis.miura.Miura;

/* JADX INFO: loaded from: classes.dex */
public class m extends W.b {

    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            if (m.this.m().getBoolean(".finish", false)) {
                try {
                    ((Miura) m.this.i()).o1(false);
                } catch (Exception e2) {
                    j0.d.c(e2);
                }
            }
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0166e
    public Dialog P1(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(i());
        builder.setMessage(m().getString(".message")).setTitle(m().getString(".title")).setPositiveButton("Ok", new a());
        return builder.create();
    }
}
