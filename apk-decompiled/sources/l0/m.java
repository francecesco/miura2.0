package l0;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class m extends l {
    public static List b() {
        return w.f3869a;
    }

    public static final int c(List list) {
        q0.f.e(list, "<this>");
        return list.size() - 1;
    }

    public static List d(Object... objArr) {
        q0.f.e(objArr, "elements");
        return objArr.length > 0 ? AbstractC0224h.b(objArr) : k.b();
    }

    public static void e() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
