package T;

/* JADX INFO: renamed from: T.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0081d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ L f259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ C0079b f260b;

    RunnableC0081d(C0079b c0079b, L l2) {
        this.f260b = c0079b;
        this.f259a = l2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f260b.f252c.L(this.f259a);
    }
}
