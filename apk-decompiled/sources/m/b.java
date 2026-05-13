package M;

import M.a;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
final class b implements a.InterfaceC0002a {
    b() {
    }

    @Override // M.a.InterfaceC0002a
    public final ScheduledExecutorService a() {
        return Executors.newSingleThreadScheduledExecutor();
    }
}
