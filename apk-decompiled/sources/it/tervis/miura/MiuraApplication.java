package it.tervis.miura;

import android.app.Application;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class MiuraApplication extends Application {
    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        stopService(new Intent(this, (Class<?>) MiuraService.class));
    }
}
