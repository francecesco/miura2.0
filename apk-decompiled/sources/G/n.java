package G;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0166e;
import androidx.fragment.app.x;

/* JADX INFO: loaded from: classes.dex */
public class n extends DialogInterfaceOnCancelListenerC0166e {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private Dialog f59s0 = null;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private DialogInterface.OnCancelListener f60t0 = null;

    public static n Y1(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        n nVar = new n();
        Dialog dialog2 = (Dialog) K.e.g(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        nVar.f59s0 = dialog2;
        if (onCancelListener != null) {
            nVar.f60t0 = onCancelListener;
        }
        return nVar;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0166e
    public Dialog P1(Bundle bundle) {
        if (this.f59s0 == null) {
            U1(false);
        }
        return this.f59s0;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0166e
    public void X1(x xVar, String str) {
        super.X1(xVar, str);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0166e, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f60t0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
