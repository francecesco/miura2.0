package T;

import it.tervis.miura.model.Peripheral;

/* JADX INFO: loaded from: classes.dex */
public class X extends AbstractC0083f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static X f238c;

    public X(C0085h c0085h) {
        super(c0085h);
    }

    private static String J(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (!(obj instanceof Long)) {
            return obj instanceof Boolean ? String.valueOf(obj) : obj instanceof Throwable ? obj.getClass().getCanonicalName() : "-";
        }
        Long l2 = (Long) obj;
        long jAbs = Math.abs(l2.longValue());
        String strValueOf = String.valueOf(obj);
        if (jAbs < 100) {
            return strValueOf;
        }
        String str = strValueOf.charAt(0) != '-' ? "" : "-";
        String strValueOf2 = String.valueOf(Math.abs(l2.longValue()));
        return str + Math.round(Math.pow(10.0d, strValueOf2.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, strValueOf2.length()) - 1.0d);
    }

    public static X K() {
        return f238c;
    }

    @Override // T.AbstractC0083f
    protected final void E() {
        synchronized (X.class) {
            f238c = this;
        }
    }

    public final void H(T t2, String str) {
        String string = t2 != null ? t2.toString() : "no hit data";
        String strValueOf = String.valueOf(str);
        v(strValueOf.length() != 0 ? "Discarding hit. ".concat(strValueOf) : new String("Discarding hit. "), string);
    }

    public final synchronized void I(int i2, String str, Object obj, Object obj2, Object obj3) {
        try {
            K.e.f(str);
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 >= 9) {
                i2 = 8;
            }
            char c2 = m().a() ? 'C' : 'c';
            char cCharAt = "01VDIWEA?".charAt(i2);
            String str2 = AbstractC0084g.f272a;
            String strN = AbstractC0082e.n(str, J(obj), J(obj2), J(obj3));
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(strN).length());
            sb.append("3");
            sb.append(cCharAt);
            sb.append(c2);
            sb.append(str2);
            sb.append(":");
            sb.append(strN);
            String string = sb.toString();
            if (string.length() > 1024) {
                string = string.substring(0, Peripheral.EXPANSION_2);
            }
            b0 b0VarN = j().n();
            if (b0VarN != null) {
                b0VarN.L().a(string);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
