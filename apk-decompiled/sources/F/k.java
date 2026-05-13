package F;

import F.i;
import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
final class k extends FutureTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ i.a f34a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    k(i.a aVar, Runnable runnable, Object obj) {
        super(runnable, obj);
        this.f34a = aVar;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = i.this.f31f;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        } else if (Log.isLoggable("GAv4", 6)) {
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 37);
            sb.append("MeasurementExecutor: job failed with ");
            sb.append(strValueOf);
        }
        super.setException(th);
    }
}
