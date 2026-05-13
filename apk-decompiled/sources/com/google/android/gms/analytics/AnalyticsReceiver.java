package com.google.android.gms.analytics;

import T.e0;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class AnalyticsReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e0 f3453a;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f3453a == null) {
            this.f3453a = new e0();
        }
        e0.a(context, intent);
    }
}
