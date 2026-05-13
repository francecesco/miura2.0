package n;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import o.InterfaceC0232a;

/* JADX INFO: loaded from: classes.dex */
abstract class i {

    private static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f3912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f3913b;

        /* JADX INFO: renamed from: n.i$a$a, reason: collision with other inner class name */
        private static class C0069a extends Thread {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f3914a;

            C0069a(Runnable runnable, String str, int i2) {
                super(runnable, str);
                this.f3914a = i2;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f3914a);
                super.run();
            }
        }

        a(String str, int i2) {
            this.f3912a = str;
            this.f3913b = i2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0069a(runnable, this.f3912a, this.f3913b);
        }
    }

    private static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Callable f3915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private InterfaceC0232a f3916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Handler f3917c;

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ InterfaceC0232a f3918a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Object f3919b;

            a(InterfaceC0232a interfaceC0232a, Object obj) {
                this.f3918a = interfaceC0232a;
                this.f3919b = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f3918a.a(this.f3919b);
            }
        }

        b(Handler handler, Callable callable, InterfaceC0232a interfaceC0232a) {
            this.f3915a = callable;
            this.f3916b = interfaceC0232a;
            this.f3917c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object objCall;
            try {
                objCall = this.f3915a.call();
            } catch (Exception unused) {
                objCall = null;
            }
            this.f3917c.post(new a(this.f3916b, objCall));
        }
    }

    static ThreadPoolExecutor a(String str, int i2, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i3, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i2));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static void b(Executor executor, Callable callable, InterfaceC0232a interfaceC0232a) {
        executor.execute(new b(AbstractC0229b.a(), callable, interfaceC0232a));
    }

    static Object c(ExecutorService executorService, Callable callable, int i2) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i2, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            throw e2;
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
