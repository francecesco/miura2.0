package o;

import java.util.Objects;

/* JADX INFO: renamed from: o.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0234c {
    public static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static int b(Object... objArr) {
        return Objects.hash(objArr);
    }

    public static Object c(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object d(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }
}
