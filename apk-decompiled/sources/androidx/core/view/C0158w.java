package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: androidx.core.view.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0158w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f2379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f2380b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f2381c = new HashMap();

    public C0158w(Runnable runnable) {
        this.f2379a = runnable;
    }

    public void a(InterfaceC0160y interfaceC0160y) {
        this.f2380b.add(interfaceC0160y);
        this.f2379a.run();
    }

    public void b(Menu menu, MenuInflater menuInflater) {
        Iterator it2 = this.f2380b.iterator();
        while (it2.hasNext()) {
            ((InterfaceC0160y) it2.next()).a(menu, menuInflater);
        }
    }

    public void c(Menu menu) {
        Iterator it2 = this.f2380b.iterator();
        while (it2.hasNext()) {
            ((InterfaceC0160y) it2.next()).d(menu);
        }
    }

    public boolean d(MenuItem menuItem) {
        Iterator it2 = this.f2380b.iterator();
        while (it2.hasNext()) {
            if (((InterfaceC0160y) it2.next()).c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void e(Menu menu) {
        Iterator it2 = this.f2380b.iterator();
        while (it2.hasNext()) {
            ((InterfaceC0160y) it2.next()).b(menu);
        }
    }

    public void f(InterfaceC0160y interfaceC0160y) {
        this.f2380b.remove(interfaceC0160y);
        android.support.v4.media.session.b.a(this.f2381c.remove(interfaceC0160y));
        this.f2379a.run();
    }
}
