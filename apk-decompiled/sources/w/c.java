package W;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import it.tervis.miura.Miura;

/* JADX INFO: loaded from: classes.dex */
public class c extends W.b {
    private static c w0;

    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            c unused = c.w0 = null;
            c.this.L1();
        }
    }

    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            c unused = c.w0 = null;
            c.this.L1();
            ((Miura) c.this.i()).o1(false);
        }
    }

    public static void Z1() {
        j0.d.a("Closing last dialog!");
        c cVar = w0;
        if (cVar != null) {
            cVar.L1();
            w0 = null;
        }
    }

    public static c a2() {
        c cVar = new c();
        w0 = cVar;
        return cVar;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0166e
    public Dialog P1(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(i());
        builder.setMessage("Chiudere la connessione con l'impianto corrente?").setTitle("Attenzione").setPositiveButton("Disconnetti", new b()).setNegativeButton("Annulla", new a()).setCancelable(false);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        return alertDialogCreate;
    }
}
