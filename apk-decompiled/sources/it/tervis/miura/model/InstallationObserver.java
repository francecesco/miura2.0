package it.tervis.miura.model;

import android.os.Handler;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: classes.dex */
public class InstallationObserver implements Observer {
    private Handler mHandler;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InstallationObserver.this.notifyChangeOnUIThread();
        }
    }

    public InstallationObserver(Handler handler) {
        this.mHandler = handler;
    }

    public void notifyChangeOnUIThread() {
    }

    public void notifyChanged() {
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        try {
            notifyChanged();
        } catch (Exception unused) {
        }
        try {
            this.mHandler.post(new a());
        } catch (Exception unused2) {
        }
    }
}
