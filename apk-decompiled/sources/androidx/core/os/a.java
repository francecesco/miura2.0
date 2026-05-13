package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2230a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f2231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f2232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f2233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f2234e;

    /* JADX INFO: renamed from: androidx.core.os.a$a, reason: collision with other inner class name */
    private static final class C0034a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0034a f2235a = new C0034a();

        private C0034a() {
        }

        public final int a(int i2) {
            return SdkExtensions.getExtensionVersion(i2);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        f2231b = i2 >= 30 ? C0034a.f2235a.a(30) : 0;
        f2232c = i2 >= 30 ? C0034a.f2235a.a(31) : 0;
        f2233d = i2 >= 30 ? C0034a.f2235a.a(33) : 0;
        f2234e = i2 >= 30 ? C0034a.f2235a.a(1000000) : 0;
    }

    private a() {
    }

    public static final boolean a(String str, String str2) {
        q0.f.e(str, "codename");
        q0.f.e(str2, "buildCodename");
        if (q0.f.a("REL", str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = str2.toUpperCase(locale);
        q0.f.d(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = str.toUpperCase(locale);
        q0.f.d(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase.compareTo(upperCase2) >= 0;
    }

    public static final boolean b() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 33) {
            if (i2 >= 32) {
                String str = Build.VERSION.CODENAME;
                q0.f.d(str, "CODENAME");
                if (a("Tiramisu", str)) {
                }
            }
            return false;
        }
        return true;
    }
}
