package M;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static InterfaceC0002a f114a;

    /* JADX INFO: renamed from: M.a$a, reason: collision with other inner class name */
    public interface InterfaceC0002a {
        ScheduledExecutorService a();
    }

    public static synchronized InterfaceC0002a a() {
        try {
            if (f114a == null) {
                f114a = new b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f114a;
    }
}
