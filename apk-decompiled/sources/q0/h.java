package q0;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final i f3988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final s0.a[] f3989b;

    static {
        i iVar = null;
        try {
            iVar = (i) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (iVar == null) {
            iVar = new i();
        }
        f3988a = iVar;
        f3989b = new s0.a[0];
    }

    public static s0.a a(Class cls) {
        return f3988a.a(cls);
    }

    public static String b(g gVar) {
        return f3988a.c(gVar);
    }
}
