package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final Class f2006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final Field f2007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final Field f2008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final Method f2009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final Method f2010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final Method f2011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Handler f2012g = new Handler(Looper.getMainLooper());

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C0030d f2013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f2014b;

        a(C0030d c0030d, Object obj) {
            this.f2013a = c0030d;
            this.f2014b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2013a.f2019a = this.f2014b;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Application f2015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ C0030d f2016b;

        b(Application application, C0030d c0030d) {
            this.f2015a = application;
            this.f2016b = c0030d;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2015a.unregisterActivityLifecycleCallbacks(this.f2016b);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f2017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f2018b;

        c(Object obj, Object obj2) {
            this.f2017a = obj;
            this.f2018b = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = d.f2009d;
                if (method != null) {
                    method.invoke(this.f2017a, this.f2018b, Boolean.FALSE, "AppCompat recreation");
                } else {
                    d.f2010e.invoke(this.f2017a, this.f2018b, Boolean.FALSE);
                }
            } catch (RuntimeException e2) {
                if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                    throw e2;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: androidx.core.app.d$d, reason: collision with other inner class name */
    private static final class C0030d implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f2019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Activity f2020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f2021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2022d = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f2023e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f2024f = false;

        C0030d(Activity activity) {
            this.f2020b = activity;
            this.f2021c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f2020b == activity) {
                this.f2020b = null;
                this.f2023e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f2023e || this.f2024f || this.f2022d || !d.h(this.f2019a, this.f2021c, activity)) {
                return;
            }
            this.f2024f = true;
            this.f2019a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f2020b == activity) {
                this.f2022d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class clsA = a();
        f2006a = clsA;
        f2007b = b();
        f2008c = f();
        f2009d = d(clsA);
        f2010e = c(clsA);
        f2011f = e(clsA);
    }

    private static Class a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 == 26 || i2 == 27;
    }

    protected static boolean h(Object obj, int i2, Activity activity) {
        try {
            Object obj2 = f2008c.get(activity);
            if (obj2 == obj && activity.hashCode() == i2) {
                f2012g.postAtFrontOfQueue(new c(f2007b.get(activity), obj2));
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f2011f == null) {
            return false;
        }
        if (f2010e == null && f2009d == null) {
            return false;
        }
        try {
            Object obj2 = f2008c.get(activity);
            if (obj2 == null || (obj = f2007b.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            C0030d c0030d = new C0030d(activity);
            application.registerActivityLifecycleCallbacks(c0030d);
            Handler handler = f2012g;
            handler.post(new a(c0030d, obj2));
            try {
                if (g()) {
                    Method method = f2011f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new b(application, c0030d));
                return true;
            } catch (Throwable th) {
                f2012g.post(new b(application, c0030d));
                throw th;
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
