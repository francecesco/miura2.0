package K;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements DialogInterface.OnClickListener {
    public static b a(Activity activity, Intent intent, int i2) {
        return new f(intent, activity, i2);
    }

    protected abstract void b();

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        try {
            b();
        } catch (ActivityNotFoundException unused) {
        } finally {
            dialogInterface.dismiss();
        }
    }
}
