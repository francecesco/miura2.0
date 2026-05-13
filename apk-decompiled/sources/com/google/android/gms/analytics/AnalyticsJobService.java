package com.google.android.gms.analytics;

import T.f0;
import T.j0;
import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(24)
public final class AnalyticsJobService extends JobService implements j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f0 f3452a;

    private final f0 c() {
        if (this.f3452a == null) {
            this.f3452a = new f0(this);
        }
        return this.f3452a;
    }

    @Override // T.j0
    public final void a(JobParameters jobParameters, boolean z2) {
        jobFinished(jobParameters, false);
    }

    @Override // T.j0
    public final boolean b(int i2) {
        return stopSelfResult(i2);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        c().a();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        c().b();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        return c().c(intent, i2, i3);
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        return c().d(jobParameters);
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
