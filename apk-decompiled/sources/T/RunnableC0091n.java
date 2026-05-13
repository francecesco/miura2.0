package T;

/* JADX INFO: renamed from: T.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0091n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ U f319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ServiceConnectionC0090m f320b;

    RunnableC0091n(ServiceConnectionC0090m serviceConnectionC0090m, U u2) {
        this.f320b = serviceConnectionC0090m;
        this.f319a = u2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f320b.f311c.J()) {
            return;
        }
        this.f320b.f311c.z("Connected to service after a timeout");
        this.f320b.f311c.O(this.f319a);
    }
}
