package P;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f154a;

    public a(Context context) {
        this.f154a = context;
    }

    public int a(String str) {
        return this.f154a.checkCallingOrSelfPermission(str);
    }

    public int b(String str, String str2) {
        return this.f154a.getPackageManager().checkPermission(str, str2);
    }

    public ApplicationInfo c(String str, int i2) {
        return this.f154a.getPackageManager().getApplicationInfo(str, i2);
    }

    public CharSequence d(String str) {
        return this.f154a.getPackageManager().getApplicationLabel(this.f154a.getPackageManager().getApplicationInfo(str, 0));
    }

    public PackageInfo e(String str, int i2) {
        return this.f154a.getPackageManager().getPackageInfo(str, i2);
    }
}
