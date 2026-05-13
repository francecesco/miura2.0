package i;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: i.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0203d extends AbstractC0204e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f3638a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExecutorService f3639b = Executors.newFixedThreadPool(4, new a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Handler f3640c;

    /* JADX INFO: renamed from: i.d$a */
    class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f3641a = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("arch_disk_io_" + this.f3641a.getAndIncrement());
            return thread;
        }
    }

    /* JADX INFO: renamed from: i.d$b */
    private static class b {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    private static Handler d(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return b.a(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }

    @Override // i.AbstractC0204e
    public void a(Runnable runnable) {
        this.f3639b.execute(runnable);
    }

    @Override // i.AbstractC0204e
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // i.AbstractC0204e
    public void c(Runnable runnable) {
        if (this.f3640c == null) {
            synchronized (this.f3638a) {
                try {
                    if (this.f3640c == null) {
                        this.f3640c = d(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        this.f3640c.post(runnable);
    }
}
