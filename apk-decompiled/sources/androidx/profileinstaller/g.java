package androidx.profileinstaller;

/* JADX INFO: loaded from: classes.dex */
enum g {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f3172a;

    g(long j2) {
        this.f3172a = j2;
    }

    public long b() {
        return this.f3172a;
    }
}
