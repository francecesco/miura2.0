package T;

/* JADX INFO: loaded from: classes.dex */
final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final O.c f305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f306b;

    public k0(O.c cVar) {
        K.e.f(cVar);
        this.f305a = cVar;
    }

    public final void a() {
        this.f306b = 0L;
    }

    public final void b() {
        this.f306b = this.f305a.b();
    }

    public final boolean c(long j2) {
        return this.f306b == 0 || this.f305a.b() - this.f306b > j2;
    }
}
