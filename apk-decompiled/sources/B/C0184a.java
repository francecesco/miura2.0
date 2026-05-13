package b;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import q0.f;

/* JADX INFO: renamed from: b.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0184a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f3428a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Context f3429b;

    public final void a(InterfaceC0185b interfaceC0185b) {
        f.e(interfaceC0185b, "listener");
        Context context = this.f3429b;
        if (context != null) {
            interfaceC0185b.a(context);
        }
        this.f3428a.add(interfaceC0185b);
    }

    public final void b() {
        this.f3429b = null;
    }

    public final void c(Context context) {
        f.e(context, "context");
        this.f3429b = context;
        Iterator it2 = this.f3428a.iterator();
        while (it2.hasNext()) {
            ((InterfaceC0185b) it2.next()).a(context);
        }
    }
}
