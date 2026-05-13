package T;

/* JADX INFO: loaded from: classes.dex */
public enum B {
    NONE,
    GZIP;

    public static B a(String str) {
        return "GZIP".equalsIgnoreCase(str) ? GZIP : NONE;
    }
}
