package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f792b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p0.a f793c;

    public m(boolean z2) {
        this.f791a = z2;
    }

    public final void a(a aVar) {
        q0.f.e(aVar, "cancellable");
        this.f792b.add(aVar);
    }

    public abstract void b();

    public final boolean c() {
        return this.f791a;
    }

    public final void d() {
        Iterator it2 = this.f792b.iterator();
        while (it2.hasNext()) {
            ((a) it2.next()).cancel();
        }
    }

    public final void e(a aVar) {
        q0.f.e(aVar, "cancellable");
        this.f792b.remove(aVar);
    }

    public final void f(boolean z2) {
        this.f791a = z2;
        p0.a aVar = this.f793c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void g(p0.a aVar) {
        this.f793c = aVar;
    }
}
