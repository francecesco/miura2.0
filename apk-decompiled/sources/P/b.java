package P;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f155b = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f156a = null;

    public static a a(Context context) {
        return f155b.b(context);
    }

    private final synchronized a b(Context context) {
        try {
            if (this.f156a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.f156a = new a(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f156a;
    }
}
