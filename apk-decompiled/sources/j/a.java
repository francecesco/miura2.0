package J;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f96d = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f97a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Object f98b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f99c = null;

    protected a(String str, Object obj) {
        this.f97a = str;
        this.f98b = obj;
    }

    public static a a(String str, Float f2) {
        return new e(str, f2);
    }

    public static a b(String str, Integer num) {
        return new d(str, num);
    }

    public static a c(String str, Long l2) {
        return new c(str, l2);
    }

    public static a d(String str, String str2) {
        return new f(str, str2);
    }

    public static a e(String str, boolean z2) {
        return new b(str, Boolean.valueOf(z2));
    }
}
