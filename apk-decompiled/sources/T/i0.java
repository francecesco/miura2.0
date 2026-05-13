package T;

/* JADX INFO: loaded from: classes.dex */
final class i0 implements L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Runnable f297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ f0 f298b;

    i0(f0 f0Var, Runnable runnable) {
        this.f298b = f0Var;
        this.f297a = runnable;
    }

    @Override // T.L
    public final void a(Throwable th) {
        this.f298b.f270a.post(this.f297a);
    }
}
