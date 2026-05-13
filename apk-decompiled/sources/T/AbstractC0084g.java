package T;

/* JADX INFO: renamed from: T.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0084g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f273b;

    static {
        String strReplaceAll = String.valueOf(G.j.f51a / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
        f272a = strReplaceAll;
        String strValueOf = String.valueOf(strReplaceAll);
        f273b = strValueOf.length() != 0 ? "ma".concat(strValueOf) : new String("ma");
    }
}
