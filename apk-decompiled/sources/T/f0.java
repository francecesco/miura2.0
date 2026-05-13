package T;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class f0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Boolean f269c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f271b;

    public f0(Context context) {
        K.e.f(context);
        this.f271b = context;
        this.f270a = new q0();
    }

    private final void h(Runnable runnable) {
        C0085h.f(this.f271b).h().K(new i0(this, runnable));
    }

    public static boolean i(Context context) {
        K.e.f(context);
        Boolean bool = f269c;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zF = l0.f(context, "com.google.android.gms.analytics.AnalyticsService");
        f269c = Boolean.valueOf(zF);
        return zF;
    }

    public final void a() {
        C0085h.f(this.f271b).d().y("Local AnalyticsService is starting up");
    }

    public final void b() {
        C0085h.f(this.f271b).d().y("Local AnalyticsService is shutting down");
    }

    public final int c(Intent intent, int i2, final int i3) {
        try {
            synchronized (e0.f265a) {
                try {
                    U.a aVar = e0.f266b;
                    if (aVar != null && aVar.b()) {
                        aVar.c();
                    }
                } finally {
                }
            }
        } catch (SecurityException unused) {
        }
        final X xD = C0085h.f(this.f271b).d();
        if (intent == null) {
            xD.B("AnalyticsService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        xD.d("Local AnalyticsService called. startId, action", Integer.valueOf(i3), action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            h(new Runnable(this, i3, xD) { // from class: T.g0

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final f0 f274a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final int f275b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private final X f276c;

                {
                    this.f274a = this;
                    this.f275b = i3;
                    this.f276c = xD;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f274a.f(this.f275b, this.f276c);
                }
            });
        }
        return 2;
    }

    public final boolean d(final JobParameters jobParameters) {
        final X xD = C0085h.f(this.f271b).d();
        String string = jobParameters.getExtras().getString("action");
        xD.c("Local AnalyticsJobService called. action", string);
        if (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(string)) {
            return true;
        }
        h(new Runnable(this, xD, jobParameters) { // from class: T.h0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final f0 f293a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final X f294b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final JobParameters f295c;

            {
                this.f293a = this;
                this.f294b = xD;
                this.f295c = jobParameters;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f293a.g(this.f294b, this.f295c);
            }
        });
        return true;
    }

    final /* synthetic */ void f(int i2, X x2) {
        if (((j0) this.f271b).b(i2)) {
            x2.y("Local AnalyticsService processed last dispatch request");
        }
    }

    final /* synthetic */ void g(X x2, JobParameters jobParameters) {
        x2.y("AnalyticsJobService processed last dispatch request");
        ((j0) this.f271b).a(jobParameters, false);
    }
}
