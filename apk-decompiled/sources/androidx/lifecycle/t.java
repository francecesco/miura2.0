package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.AbstractC0183g;
import androidx.lifecycle.u;

/* JADX INFO: loaded from: classes.dex */
public final class t implements l {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f3101i = new b(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final t f3102j = new t();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3104b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f3107e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3105c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3106d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final m f3108f = new m(this);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Runnable f3109g = new Runnable() { // from class: androidx.lifecycle.s
        @Override // java.lang.Runnable
        public final void run() {
            t.k(this.f3100a);
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final u.a f3110h = new d();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f3111a = new a();

        private a() {
        }

        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            q0.f.e(activity, "activity");
            q0.f.e(activityLifecycleCallbacks, "callback");
            activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public static final class b {
        private b() {
        }

        public final l a() {
            return t.f3102j;
        }

        public final void b(Context context) {
            q0.f.e(context, "context");
            t.f3102j.j(context);
        }

        public /* synthetic */ b(q0.d dVar) {
            this();
        }
    }

    public static final class c extends AbstractC0180d {

        public static final class a extends AbstractC0180d {
            final /* synthetic */ t this$0;

            a(t tVar) {
                this.this$0 = tVar;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                q0.f.e(activity, "activity");
                this.this$0.g();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                q0.f.e(activity, "activity");
                this.this$0.h();
            }
        }

        c() {
        }

        @Override // androidx.lifecycle.AbstractC0180d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            q0.f.e(activity, "activity");
            if (Build.VERSION.SDK_INT < 29) {
                u.f3113b.b(activity).f(t.this.f3110h);
            }
        }

        @Override // androidx.lifecycle.AbstractC0180d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            q0.f.e(activity, "activity");
            t.this.f();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            q0.f.e(activity, "activity");
            a.a(activity, new a(t.this));
        }

        @Override // androidx.lifecycle.AbstractC0180d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            q0.f.e(activity, "activity");
            t.this.i();
        }
    }

    public static final class d implements u.a {
        d() {
        }

        @Override // androidx.lifecycle.u.a
        public void a() {
        }

        @Override // androidx.lifecycle.u.a
        public void b() {
            t.this.g();
        }

        @Override // androidx.lifecycle.u.a
        public void c() {
            t.this.h();
        }
    }

    private t() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(t tVar) {
        q0.f.e(tVar, "this$0");
        tVar.l();
        tVar.m();
    }

    @Override // androidx.lifecycle.l
    public AbstractC0183g G() {
        return this.f3108f;
    }

    public final void f() {
        int i2 = this.f3104b - 1;
        this.f3104b = i2;
        if (i2 == 0) {
            Handler handler = this.f3107e;
            q0.f.b(handler);
            handler.postDelayed(this.f3109g, 700L);
        }
    }

    public final void g() {
        int i2 = this.f3104b + 1;
        this.f3104b = i2;
        if (i2 == 1) {
            if (this.f3105c) {
                this.f3108f.h(AbstractC0183g.a.ON_RESUME);
                this.f3105c = false;
            } else {
                Handler handler = this.f3107e;
                q0.f.b(handler);
                handler.removeCallbacks(this.f3109g);
            }
        }
    }

    public final void h() {
        int i2 = this.f3103a + 1;
        this.f3103a = i2;
        if (i2 == 1 && this.f3106d) {
            this.f3108f.h(AbstractC0183g.a.ON_START);
            this.f3106d = false;
        }
    }

    public final void i() {
        this.f3103a--;
        m();
    }

    public final void j(Context context) {
        q0.f.e(context, "context");
        this.f3107e = new Handler();
        this.f3108f.h(AbstractC0183g.a.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        q0.f.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c());
    }

    public final void l() {
        if (this.f3104b == 0) {
            this.f3105c = true;
            this.f3108f.h(AbstractC0183g.a.ON_PAUSE);
        }
    }

    public final void m() {
        if (this.f3103a == 0 && this.f3105c) {
            this.f3108f.h(AbstractC0183g.a.ON_STOP);
            this.f3106d = true;
        }
    }
}
