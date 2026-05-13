package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import o.AbstractC0236e;

/* JADX INFO: loaded from: classes.dex */
public abstract class p extends AbstractC0173l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f2942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f2943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f2944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final x f2946e;

    p(Activity activity, Context context, Handler handler, int i2) {
        this.f2946e = new y();
        this.f2942a = activity;
        this.f2943b = (Context) AbstractC0236e.g(context, "context == null");
        this.f2944c = (Handler) AbstractC0236e.g(handler, "handler == null");
        this.f2945d = i2;
    }

    Activity l() {
        return this.f2942a;
    }

    Context o() {
        return this.f2943b;
    }

    public Handler p() {
        return this.f2944c;
    }

    public abstract void q(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract Object r();

    public abstract LayoutInflater s();

    public void u(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        if (i2 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        androidx.core.content.a.f(this.f2943b, intent, bundle);
    }

    public abstract void v();

    p(AbstractActivityC0171j abstractActivityC0171j) {
        this(abstractActivityC0171j, abstractActivityC0171j, new Handler(), 0);
    }
}
