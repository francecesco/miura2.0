package O;

import android.content.Context;
import it.tervis.miura.model.Peripheral;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static boolean a(Context context, String str) {
        "com.google.android.gms".equals(str);
        return (P.b.a(context).c(str, 0).flags & Peripheral.EXPANSION_13) != 0;
    }
}
