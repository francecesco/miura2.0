package F;

import T.C0085h;
import T.m0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class b extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static List f8h = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f9e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Set f10f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f11g;

    public b(C0085h c0085h) {
        super(c0085h);
        this.f10f = new HashSet();
    }

    public static void d() {
        synchronized (b.class) {
            try {
                List list = f8h;
                if (list != null) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        ((Runnable) it2.next()).run();
                    }
                    f8h = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(boolean z2) {
        this.f11g = z2;
    }

    public final void c() {
        m0 m0VarJ = a().j();
        m0VarJ.J();
        if (m0VarJ.K()) {
            b(m0VarJ.L());
        }
        m0VarJ.J();
        this.f9e = true;
    }
}
