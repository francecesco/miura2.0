package com.google.android.gms.analytics;

import T.f0;
import T.j0;
import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public final class AnalyticsService extends Service implements j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f0 f3454a;

    private final f0 c() {
        if (this.f3454a == null) {
            this.f3454a = new f0(this);
        }
        return this.f3454a;
    }

    @Override // T.j0
    public final void a(JobParameters jobParameters, boolean z2) {
        throw new UnsupportedOperationException();
    }

    @Override // T.j0
    public final boolean b(int i2) {
        return stopSelfResult(i2);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        c();
        return null;
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
}
