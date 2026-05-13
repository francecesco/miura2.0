package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f2250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f2251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f2252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f2253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f2254e;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f2250a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f2251b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f2252c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f2253d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f2254e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
