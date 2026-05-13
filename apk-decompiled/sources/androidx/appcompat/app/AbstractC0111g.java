package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.AbstractC0106b;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;
import k.C0208b;

/* JADX INFO: renamed from: androidx.appcompat.app.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0111g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static c f1020a = new c(new d());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f1021b = -100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static androidx.core.os.c f1022c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static androidx.core.os.c f1023d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Boolean f1024e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f1025f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final C0208b f1026g = new C0208b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f1027h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Object f1028i = new Object();

    /* JADX INFO: renamed from: androidx.appcompat.app.g$a */
    static class a {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.g$b */
    static class b {
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.g$c */
    static class c implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f1029a = new Object();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Queue f1030b = new ArrayDeque();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Executor f1031c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Runnable f1032d;

        c(Executor executor) {
            this.f1031c = executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Runnable runnable) {
            try {
                runnable.run();
            } finally {
                d();
            }
        }

        protected void d() {
            synchronized (this.f1029a) {
                try {
                    Runnable runnable = (Runnable) this.f1030b.poll();
                    this.f1032d = runnable;
                    if (runnable != null) {
                        this.f1031c.execute(runnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable runnable) {
            synchronized (this.f1029a) {
                try {
                    this.f1030b.add(new Runnable() { // from class: androidx.appcompat.app.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f1033a.c(runnable);
                        }
                    });
                    if (this.f1032d == null) {
                        d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.g$d */
    static class d implements Executor {
        d() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    AbstractC0111g() {
    }

    static void F(AbstractC0111g abstractC0111g) {
        synchronized (f1027h) {
            G(abstractC0111g);
        }
    }

    private static void G(AbstractC0111g abstractC0111g) {
        synchronized (f1027h) {
            try {
                Iterator it2 = f1026g.iterator();
                while (it2.hasNext()) {
                    AbstractC0111g abstractC0111g2 = (AbstractC0111g) ((WeakReference) it2.next()).get();
                    if (abstractC0111g2 == abstractC0111g || abstractC0111g2 == null) {
                        it2.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static void O(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            ComponentName componentName = new ComponentName(context, "androidx.appcompat.app.AppLocalesMetadataHolderService");
            if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                if (k().f()) {
                    String strB = androidx.core.app.e.b(context);
                    Object systemService = context.getSystemService("locale");
                    if (systemService != null) {
                        b.b(systemService, a.a(strB));
                    }
                }
                context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            }
        }
    }

    static void P(final Context context) {
        if (v(context)) {
            if (Build.VERSION.SDK_INT >= 33) {
                if (f1025f) {
                    return;
                }
                f1020a.execute(new Runnable() { // from class: androidx.appcompat.app.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC0111g.w(context);
                    }
                });
                return;
            }
            synchronized (f1028i) {
                try {
                    androidx.core.os.c cVar = f1022c;
                    if (cVar == null) {
                        if (f1023d == null) {
                            f1023d = androidx.core.os.c.c(androidx.core.app.e.b(context));
                        }
                        if (f1023d.f()) {
                        } else {
                            f1022c = f1023d;
                        }
                    } else if (!cVar.equals(f1023d)) {
                        androidx.core.os.c cVar2 = f1022c;
                        f1023d = cVar2;
                        androidx.core.app.e.a(context, cVar2.h());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    static void d(AbstractC0111g abstractC0111g) {
        synchronized (f1027h) {
            G(abstractC0111g);
            f1026g.add(new WeakReference(abstractC0111g));
        }
    }

    public static AbstractC0111g h(Activity activity, InterfaceC0109e interfaceC0109e) {
        return new i(activity, interfaceC0109e);
    }

    public static AbstractC0111g i(Dialog dialog, InterfaceC0109e interfaceC0109e) {
        return new i(dialog, interfaceC0109e);
    }

    public static androidx.core.os.c k() {
        if (Build.VERSION.SDK_INT >= 33) {
            Object objP = p();
            if (objP != null) {
                return androidx.core.os.c.i(b.a(objP));
            }
        } else {
            androidx.core.os.c cVar = f1022c;
            if (cVar != null) {
                return cVar;
            }
        }
        return androidx.core.os.c.e();
    }

    public static int m() {
        return f1021b;
    }

    static Object p() {
        Context contextL;
        Iterator it2 = f1026g.iterator();
        while (it2.hasNext()) {
            AbstractC0111g abstractC0111g = (AbstractC0111g) ((WeakReference) it2.next()).get();
            if (abstractC0111g != null && (contextL = abstractC0111g.l()) != null) {
                return contextL.getSystemService("locale");
            }
        }
        return null;
    }

    static androidx.core.os.c r() {
        return f1022c;
    }

    static boolean v(Context context) {
        if (f1024e == null) {
            try {
                Bundle bundle = A.a(context).metaData;
                if (bundle != null) {
                    f1024e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                f1024e = Boolean.FALSE;
            }
        }
        return f1024e.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(Context context) {
        O(context);
        f1025f = true;
    }

    public abstract void A(Bundle bundle);

    public abstract void B();

    public abstract void C(Bundle bundle);

    public abstract void D();

    public abstract void E();

    public abstract boolean H(int i2);

    public abstract void I(int i2);

    public abstract void J(View view);

    public abstract void K(View view, ViewGroup.LayoutParams layoutParams);

    public void L(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract void M(int i2);

    public abstract void N(CharSequence charSequence);

    public abstract void e(View view, ViewGroup.LayoutParams layoutParams);

    public void f(Context context) {
    }

    public Context g(Context context) {
        f(context);
        return context;
    }

    public abstract View j(int i2);

    public abstract Context l();

    public abstract AbstractC0106b.InterfaceC0023b n();

    public abstract int o();

    public abstract MenuInflater q();

    public abstract AbstractC0105a s();

    public abstract void t();

    public abstract void u();

    public abstract void x(Configuration configuration);

    public abstract void y(Bundle bundle);

    public abstract void z();
}
