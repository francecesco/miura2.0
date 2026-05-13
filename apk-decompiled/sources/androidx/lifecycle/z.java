package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f3125a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f3126b = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f3127c = false;

    private static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    final void a() {
        this.f3127c = true;
        Map map = this.f3125a;
        if (map != null) {
            synchronized (map) {
                try {
                    Iterator it2 = this.f3125a.values().iterator();
                    while (it2.hasNext()) {
                        b(it2.next());
                    }
                } finally {
                }
            }
        }
        Set set = this.f3126b;
        if (set != null) {
            synchronized (set) {
                try {
                    Iterator it3 = this.f3126b.iterator();
                    while (it3.hasNext()) {
                        b((Closeable) it3.next());
                    }
                } finally {
                }
            }
        }
        d();
    }

    Object c(String str) {
        Object obj;
        Map map = this.f3125a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            obj = this.f3125a.get(str);
        }
        return obj;
    }

    protected void d() {
    }
}
