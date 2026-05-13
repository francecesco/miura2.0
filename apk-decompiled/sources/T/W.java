package T;

/* JADX INFO: loaded from: classes.dex */
public abstract class W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile F.c f237a = new G();

    private static boolean a(int i2) {
        return f237a != null && f237a.b() <= i2;
    }

    public static void b(String str, Object obj) {
        X xK = X.K();
        if (xK != null) {
            xK.x(str, obj);
        } else if (a(3)) {
            if (obj != null) {
                String strValueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + strValueOf.length());
                sb.append(str);
                sb.append(":");
                sb.append(strValueOf);
            }
        }
        F.c cVar = f237a;
        if (cVar != null) {
            cVar.a(str);
        }
    }
}
