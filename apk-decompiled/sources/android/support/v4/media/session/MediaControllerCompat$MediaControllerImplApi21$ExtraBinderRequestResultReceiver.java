package android.support.v4.media.session;

import android.os.Bundle;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference f691a;

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int i2, Bundle bundle) {
        b.a(this.f691a.get());
    }
}
