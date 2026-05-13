package T;

import java.lang.Thread;

/* JADX INFO: renamed from: T.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0086i implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ C0085h f296a;

    C0086i(C0085h c0085h) {
        this.f296a = c0085h;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        X xM = this.f296a.m();
        if (xM != null) {
            xM.x("Job execution failed", th);
        }
    }
}
