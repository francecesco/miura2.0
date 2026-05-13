package j0;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f3788a;

    public static void a(String str) {
        e("app", str);
    }

    public static void b(String str, String str2) {
        if (str == null) {
            str = "app";
        }
        e(str, str2);
    }

    public static void f(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (f3788a != 0) {
            str = str + " [" + (jCurrentTimeMillis - f3788a) + " ms]";
        }
        a(str);
        f3788a = jCurrentTimeMillis;
    }

    public static void g(String str) {
        f(str);
        f3788a = 0L;
    }

    public static void c(Throwable th) {
    }

    public static void d(byte[] bArr) {
    }

    private static void e(String str, String str2) {
    }
}
