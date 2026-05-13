package C;

import android.os.Trace;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f5a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f6b;

    public static void a(String str) {
        c.a(str);
    }

    public static void b() {
        c.b();
    }

    private static void c(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to call ");
        sb.append(str);
        sb.append(" via reflection");
    }

    public static boolean d() {
        try {
            if (f6b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return e();
    }

    private static boolean e() {
        try {
            if (f6b == null) {
                f5a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f6b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f6b.invoke(null, Long.valueOf(f5a))).booleanValue();
        } catch (Exception e2) {
            c("isTagEnabled", e2);
            return false;
        }
    }
}
