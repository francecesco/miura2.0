package G;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static m f57b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f58a;

    private m(Context context) {
        this.f58a = context.getApplicationContext();
    }

    public static m a(Context context) {
        K.e.f(context);
        synchronized (m.class) {
            try {
                if (f57b == null) {
                    q.a(context);
                    f57b = new m(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f57b;
    }

    private static r b(PackageInfo packageInfo, r... rVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1) {
            return null;
        }
        s sVar = new s(packageInfo.signatures[0].toByteArray());
        for (int i2 = 0; i2 < rVarArr.length; i2++) {
            if (rVarArr[i2].equals(sVar)) {
                return rVarArr[i2];
            }
        }
        return null;
    }

    public static boolean c(PackageInfo packageInfo, boolean z2) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z2 ? b(packageInfo, u.f67a) : b(packageInfo, u.f67a[0])) != null) {
                return true;
            }
        }
        return false;
    }
}
