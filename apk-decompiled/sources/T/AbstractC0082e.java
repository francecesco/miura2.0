package T;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: renamed from: T.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0082e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0085h f264a;

    protected AbstractC0082e(C0085h c0085h) {
        K.e.f(c0085h);
        this.f264a = c0085h;
    }

    private final void b(int i2, String str, Object obj, Object obj2, Object obj3) {
        C0085h c0085h = this.f264a;
        X xM = c0085h != null ? c0085h.m() : null;
        String str2 = (String) N.f197c.a();
        if (xM == null) {
            if (Log.isLoggable(str2, i2)) {
                Log.println(i2, str2, n(str, obj, obj2, obj3));
            }
        } else {
            if (Log.isLoggable(str2, i2)) {
                Log.println(i2, str2, n(str, obj, obj2, obj3));
            }
            if (i2 >= 5) {
                xM.I(i2, str, obj, obj2, obj3);
            }
        }
    }

    private static String f(Object obj) {
        return obj == null ? "" : obj instanceof String ? (String) obj : obj instanceof Boolean ? obj == Boolean.TRUE ? "true" : "false" : obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
    }

    protected static String n(String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strF = f(obj);
        String strF2 = f(obj2);
        String strF3 = f(obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strF)) {
            sb.append(str2);
            sb.append(strF);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strF2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strF2);
        }
        if (!TextUtils.isEmpty(strF3)) {
            sb.append(str3);
            sb.append(strF3);
        }
        return sb.toString();
    }

    public static boolean u() {
        return Log.isLoggable((String) N.f197c.a(), 2);
    }

    public final void A(String str) {
        b(4, str, null, null, null);
    }

    public final void B(String str) {
        b(5, str, null, null, null);
    }

    public final void C(String str) {
        b(6, str, null, null, null);
    }

    protected final Context a() {
        return this.f264a.a();
    }

    public final void c(String str, Object obj) {
        b(2, str, obj, null, null);
    }

    public final void d(String str, Object obj, Object obj2) {
        b(2, str, obj, obj2, null);
    }

    public final void e(String str, Object obj, Object obj2, Object obj3) {
        b(3, str, obj, obj2, obj3);
    }

    public final void g(String str, Object obj) {
        b(3, str, obj, null, null);
    }

    public final void h(String str, Object obj, Object obj2) {
        b(3, str, obj, obj2, null);
    }

    public final void i(String str, Object obj, Object obj2, Object obj3) {
        b(5, str, obj, obj2, obj3);
    }

    public final C0085h j() {
        return this.f264a;
    }

    protected final O.c k() {
        return this.f264a.c();
    }

    protected final X l() {
        return this.f264a.d();
    }

    protected final F m() {
        return this.f264a.e();
    }

    public final void o(String str, Object obj, Object obj2) {
        b(5, str, obj, obj2, null);
    }

    protected final F.i p() {
        return this.f264a.g();
    }

    protected final C0079b q() {
        return this.f264a.h();
    }

    protected final K r() {
        return this.f264a.i();
    }

    protected final m0 s() {
        return this.f264a.j();
    }

    protected final b0 t() {
        return this.f264a.k();
    }

    public final void v(String str, Object obj) {
        b(5, str, obj, null, null);
    }

    public final void w(String str, Object obj, Object obj2) {
        b(6, str, obj, obj2, null);
    }

    public final void x(String str, Object obj) {
        b(6, str, obj, null, null);
    }

    public final void y(String str) {
        b(2, str, null, null, null);
    }

    public final void z(String str) {
        b(3, str, null, null, null);
    }
}
