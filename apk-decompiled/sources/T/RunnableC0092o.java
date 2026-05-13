package T;

import android.content.ComponentName;

/* JADX INFO: renamed from: T.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0092o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ComponentName f325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ServiceConnectionC0090m f326b;

    RunnableC0092o(ServiceConnectionC0090m serviceConnectionC0090m, ComponentName componentName) {
        this.f326b = serviceConnectionC0090m;
        this.f325a = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f326b.f311c.K(this.f325a);
    }
}
