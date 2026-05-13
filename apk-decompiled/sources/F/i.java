package F;

import T.s0;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import java.lang.Thread;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile i f25g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f26a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f27b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f28c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f29d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile s0 f30e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f31f;

    class a extends ThreadPoolExecutor {
        public a() {
            super(1, 1, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());
            setThreadFactory(new b(null));
            allowCoreThreadTimeOut(true);
        }

        @Override // java.util.concurrent.AbstractExecutorService
        protected final RunnableFuture newTaskFor(Runnable runnable, Object obj) {
            return new k(this, runnable, obj);
        }
    }

    static class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final AtomicInteger f33a = new AtomicInteger();

        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            int iIncrementAndGet = f33a.incrementAndGet();
            StringBuilder sb = new StringBuilder(23);
            sb.append("measurement-");
            sb.append(iIncrementAndGet);
            return new c(runnable, sb.toString());
        }

        /* synthetic */ b(j jVar) {
            this();
        }
    }

    static class c extends Thread {
        c(Runnable runnable, String str) {
            super(runnable, str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    private i(Context context) {
        Context applicationContext = context.getApplicationContext();
        K.e.f(applicationContext);
        this.f26a = applicationContext;
        this.f29d = new a();
        this.f27b = new CopyOnWriteArrayList();
        this.f28c = new e();
    }

    public static void d() {
        if (!(Thread.currentThread() instanceof c)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public static i e(Context context) {
        K.e.f(context);
        if (f25g == null) {
            synchronized (i.class) {
                try {
                    if (f25g == null) {
                        f25g = new i(context);
                    }
                } finally {
                }
            }
        }
        return f25g;
    }

    public final void a(Runnable runnable) {
        K.e.f(runnable);
        this.f29d.submit(runnable);
    }

    public final void b(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f31f = uncaughtExceptionHandler;
    }

    public final s0 c() {
        if (this.f30e == null) {
            synchronized (this) {
                try {
                    if (this.f30e == null) {
                        s0 s0Var = new s0();
                        PackageManager packageManager = this.f26a.getPackageManager();
                        String packageName = this.f26a.getPackageName();
                        s0Var.c(packageName);
                        s0Var.d(packageManager.getInstallerPackageName(packageName));
                        String str = null;
                        try {
                            PackageInfo packageInfo = packageManager.getPackageInfo(this.f26a.getPackageName(), 0);
                            if (packageInfo != null) {
                                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                                if (!TextUtils.isEmpty(applicationLabel)) {
                                    packageName = applicationLabel.toString();
                                }
                                str = packageInfo.versionName;
                            }
                        } catch (PackageManager.NameNotFoundException unused) {
                            String strValueOf = String.valueOf(packageName);
                            if (strValueOf.length() != 0) {
                                "Error retrieving package info: appName set to ".concat(strValueOf);
                            }
                        }
                        s0Var.e(packageName);
                        s0Var.f(str);
                        this.f30e = s0Var;
                    }
                } finally {
                }
            }
        }
        return this.f30e;
    }
}
