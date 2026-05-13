package I;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final a f69e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f70a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f71b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList f72c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f73d = false;

    /* JADX INFO: renamed from: I.a$a, reason: collision with other inner class name */
    public interface InterfaceC0000a {
        void a(boolean z2);
    }

    private a() {
    }

    public static a b() {
        return f69e;
    }

    public static void c(Application application) {
        a aVar = f69e;
        synchronized (aVar) {
            try {
                if (!aVar.f73d) {
                    application.registerActivityLifecycleCallbacks(aVar);
                    application.registerComponentCallbacks(aVar);
                    aVar.f73d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void e(boolean z2) {
        synchronized (f69e) {
            try {
                ArrayList arrayList = this.f72c;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((InterfaceC0000a) obj).a(z2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(InterfaceC0000a interfaceC0000a) {
        synchronized (f69e) {
            this.f72c.add(interfaceC0000a);
        }
    }

    public final boolean d() {
        return this.f70a.get();
    }

    public final boolean f(boolean z2) {
        if (!this.f71b.get()) {
            if (!O.h.b()) {
                return z2;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f71b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f70a.set(true);
            }
        }
        return d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean zCompareAndSet = this.f70a.compareAndSet(true, false);
        this.f71b.set(true);
        if (zCompareAndSet) {
            e(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean zCompareAndSet = this.f70a.compareAndSet(true, false);
        this.f71b.set(true);
        if (zCompareAndSet) {
            e(false);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        if (i2 == 20 && this.f70a.compareAndSet(false, true)) {
            this.f71b.set(true);
            e(true);
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
