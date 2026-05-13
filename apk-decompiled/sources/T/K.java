package T;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.PersistableBundle;

/* JADX INFO: loaded from: classes.dex */
public final class K extends AbstractC0083f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AlarmManager f175e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Integer f176f;

    protected K(C0085h c0085h) {
        super(c0085h);
        this.f175e = (AlarmManager) a().getSystemService("alarm");
    }

    private final int I() {
        if (this.f176f == null) {
            String strValueOf = String.valueOf(a().getPackageName());
            this.f176f = Integer.valueOf((strValueOf.length() != 0 ? "analytics".concat(strValueOf) : new String("analytics")).hashCode());
        }
        return this.f176f.intValue();
    }

    private final PendingIntent M() {
        Context contextA = a();
        return PendingIntent.getBroadcast(contextA, 0, new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH").setComponent(new ComponentName(contextA, "com.google.android.gms.analytics.AnalyticsReceiver")), 0);
    }

    @Override // T.AbstractC0083f
    protected final void E() {
        try {
            H();
            if (F.e() > 0) {
                Context contextA = a();
                ActivityInfo receiverInfo = contextA.getPackageManager().getReceiverInfo(new ComponentName(contextA, "com.google.android.gms.analytics.AnalyticsReceiver"), 0);
                if (receiverInfo == null || !receiverInfo.enabled) {
                    return;
                }
                y("Receiver registered for local dispatch.");
                this.f173c = true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public final void H() {
        this.f174d = false;
        this.f175e.cancel(M());
        if (Build.VERSION.SDK_INT >= 24) {
            JobScheduler jobScheduler = (JobScheduler) a().getSystemService("jobscheduler");
            int I2 = I();
            c("Cancelling job. JobID", Integer.valueOf(I2));
            jobScheduler.cancel(I2);
        }
    }

    public final boolean J() {
        return this.f174d;
    }

    public final boolean K() {
        return this.f173c;
    }

    public final void L() {
        F();
        K.e.i(this.f173c, "Receiver not registered");
        long jE = F.e();
        if (jE > 0) {
            H();
            long jB = k().b() + jE;
            this.f174d = true;
            ((Boolean) N.f194R.a()).booleanValue();
            if (Build.VERSION.SDK_INT < 24) {
                y("Scheduling upload with AlarmManager");
                this.f175e.setInexactRepeating(2, jB, jE, M());
                return;
            }
            y("Scheduling upload with JobScheduler");
            Context contextA = a();
            ComponentName componentName = new ComponentName(contextA, "com.google.android.gms.analytics.AnalyticsJobService");
            int I2 = I();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            JobInfo jobInfoBuild = new JobInfo.Builder(I2, componentName).setMinimumLatency(jE).setOverrideDeadline(jE << 1).setExtras(persistableBundle).build();
            c("Scheduling job. JobID", Integer.valueOf(I2));
            n0.b(contextA, jobInfoBuild, "com.google.android.gms", "DispatchAlarm");
        }
    }
}
