package q0;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(Object obj) {
        if (obj == null) {
            i();
        }
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            j(str);
        }
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) g(new NullPointerException(str + " must not be null")));
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            k(str);
        }
    }

    private static String f(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = f.class.getName();
        int i2 = 0;
        while (!stackTrace[i2].getClassName().equals(name)) {
            i2++;
        }
        while (stackTrace[i2].getClassName().equals(name)) {
            i2++;
        }
        StackTraceElement stackTraceElement = stackTrace[i2];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    private static Throwable g(Throwable th) {
        return h(th, f.class.getName());
    }

    static Throwable h(Throwable th, String str) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
        return th;
    }

    public static void i() {
        throw ((NullPointerException) g(new NullPointerException()));
    }

    public static void j(String str) {
        throw ((NullPointerException) g(new NullPointerException(str)));
    }

    private static void k(String str) {
        throw ((NullPointerException) g(new NullPointerException(f(str))));
    }
}
