package T;

/* JADX INFO: renamed from: T.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0100x {
    NONE,
    BATCH_BY_SESSION,
    BATCH_BY_TIME,
    BATCH_BY_BRUTE_FORCE,
    BATCH_BY_COUNT,
    BATCH_BY_SIZE;

    public static EnumC0100x a(String str) {
        return "BATCH_BY_SESSION".equalsIgnoreCase(str) ? BATCH_BY_SESSION : "BATCH_BY_TIME".equalsIgnoreCase(str) ? BATCH_BY_TIME : "BATCH_BY_BRUTE_FORCE".equalsIgnoreCase(str) ? BATCH_BY_BRUTE_FORCE : "BATCH_BY_COUNT".equalsIgnoreCase(str) ? BATCH_BY_COUNT : "BATCH_BY_SIZE".equalsIgnoreCase(str) ? BATCH_BY_SIZE : NONE;
    }
}
