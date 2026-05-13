package androidx.core.content;

import android.content.Context;
import android.os.Process;
import androidx.core.app.f;
import o.AbstractC0234c;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static int a(Context context, String str, int i2, int i3, String str2) {
        if (context.checkPermission(str, i2, i3) == -1) {
            return -1;
        }
        String strC = f.c(str);
        if (strC == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i3);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return ((Process.myUid() != i3 || !AbstractC0234c.a(context.getPackageName(), str2)) ? f.b(context, strC, str2) : f.a(context, i3, strC, str2)) == 0 ? 0 : -2;
    }

    public static int b(Context context, String str) {
        return a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
