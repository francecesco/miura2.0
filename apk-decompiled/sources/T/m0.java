package T;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class m0 extends AbstractC0083f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f315f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f316g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f317h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f318i;

    public m0(C0085h c0085h) {
        super(c0085h);
    }

    @Override // T.AbstractC0083f
    protected final void E() {
        ApplicationInfo applicationInfo;
        int i2;
        S s2;
        Context contextA = a();
        try {
            applicationInfo = contextA.getPackageManager().getApplicationInfo(contextA.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            v("PackageManager doesn't know about the app package", e2);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            B("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle == null || (i2 = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) <= 0 || (s2 = (S) new P(j()).E(i2)) == null) {
            return;
        }
        y("Loading global XML config values");
        String str = s2.f225a;
        if (str != null) {
            this.f313d = str;
            g("XML config - app name", str);
        }
        String str2 = s2.f226b;
        if (str2 != null) {
            this.f312c = str2;
            g("XML config - app version", str2);
        }
        String str3 = s2.f227c;
        if (str3 != null) {
            String lowerCase = str3.toLowerCase(Locale.US);
            int i3 = "verbose".equals(lowerCase) ? 0 : "info".equals(lowerCase) ? 1 : "warning".equals(lowerCase) ? 2 : "error".equals(lowerCase) ? 3 : -1;
            if (i3 >= 0) {
                this.f314e = i3;
                c("XML config - log level", Integer.valueOf(i3));
            }
        }
        int i4 = s2.f228d;
        if (i4 >= 0) {
            this.f316g = i4;
            this.f315f = true;
            g("XML config - dispatch period (sec)", Integer.valueOf(i4));
        }
        int i5 = s2.f229e;
        if (i5 != -1) {
            boolean z2 = i5 == 1;
            this.f318i = z2;
            this.f317h = true;
            g("XML config - dry run", Boolean.valueOf(z2));
        }
    }

    public final String H() {
        F();
        return this.f313d;
    }

    public final String I() {
        F();
        return this.f312c;
    }

    public final boolean J() {
        F();
        return false;
    }

    public final boolean K() {
        F();
        return this.f317h;
    }

    public final boolean L() {
        F();
        return this.f318i;
    }
}
