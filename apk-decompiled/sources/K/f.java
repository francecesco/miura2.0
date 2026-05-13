package K;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class f extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Intent f105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Activity f106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ int f107c;

    f(Intent intent, Activity activity, int i2) {
        this.f105a = intent;
        this.f106b = activity;
        this.f107c = i2;
    }

    @Override // K.b
    public final void b() {
        Intent intent = this.f105a;
        if (intent != null) {
            this.f106b.startActivityForResult(intent, this.f107c);
        }
    }
}
