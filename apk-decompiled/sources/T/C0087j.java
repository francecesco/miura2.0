package T;

import android.content.Context;

/* JADX INFO: renamed from: T.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0087j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f300b;

    public C0087j(Context context) {
        K.e.f(context);
        Context applicationContext = context.getApplicationContext();
        K.e.g(applicationContext, "Application context can't be null");
        this.f299a = applicationContext;
        this.f300b = applicationContext;
    }

    public final Context a() {
        return this.f299a;
    }

    public final Context b() {
        return this.f300b;
    }
}
