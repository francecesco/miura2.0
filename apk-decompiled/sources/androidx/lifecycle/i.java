package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f3083a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f3084b = new AtomicBoolean(false);

    public static final class a extends AbstractC0180d {
        @Override // androidx.lifecycle.AbstractC0180d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            q0.f.e(activity, "activity");
            u.f3113b.c(activity);
        }
    }

    private i() {
    }

    public static final void a(Context context) {
        q0.f.e(context, "context");
        if (f3084b.getAndSet(true)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        q0.f.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new a());
    }
}
