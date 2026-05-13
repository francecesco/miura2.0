package T;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0085h f163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Boolean f164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set f166d;

    protected F(C0085h c0085h) {
        K.e.f(c0085h);
        this.f163a = c0085h;
    }

    public static boolean b() {
        return ((Boolean) N.f196b.a()).booleanValue();
    }

    public static int c() {
        return ((Integer) N.f219y.a()).intValue();
    }

    public static long d() {
        return ((Long) N.f204j.a()).longValue();
    }

    public static long e() {
        return ((Long) N.f207m.a()).longValue();
    }

    public static int f() {
        return ((Integer) N.f209o.a()).intValue();
    }

    public static int g() {
        return ((Integer) N.f210p.a()).intValue();
    }

    public static String h() {
        return (String) N.f212r.a();
    }

    public static String i() {
        return (String) N.f211q.a();
    }

    public static String j() {
        return (String) N.f213s.a();
    }

    public final boolean a() {
        if (this.f164b == null) {
            synchronized (this) {
                try {
                    if (this.f164b == null) {
                        ApplicationInfo applicationInfo = this.f163a.a().getApplicationInfo();
                        String strA = O.i.a();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            this.f164b = Boolean.valueOf(str != null && str.equals(strA));
                        }
                        if ((this.f164b == null || !this.f164b.booleanValue()) && "com.google.android.gms.analytics".equals(strA)) {
                            this.f164b = Boolean.TRUE;
                        }
                        if (this.f164b == null) {
                            this.f164b = Boolean.TRUE;
                            this.f163a.d().C("My process not in the list of running processes");
                        }
                    }
                } finally {
                }
            }
        }
        return this.f164b.booleanValue();
    }

    public final Set k() {
        String str;
        String str2 = (String) N.f178B.a();
        if (this.f166d == null || (str = this.f165c) == null || !str.equals(str2)) {
            String[] strArrSplit = TextUtils.split(str2, ",");
            HashSet hashSet = new HashSet();
            for (String str3 : strArrSplit) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(str3)));
                } catch (NumberFormatException unused) {
                }
            }
            this.f165c = str2;
            this.f166d = hashSet;
        }
        return this.f166d;
    }
}
