package androidx.lifecycle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f3036a = new LinkedHashMap();

    public final void a() {
        Iterator it2 = this.f3036a.values().iterator();
        while (it2.hasNext()) {
            ((z) it2.next()).a();
        }
        this.f3036a.clear();
    }

    public final z b(String str) {
        q0.f.e(str, "key");
        return (z) this.f3036a.get(str);
    }

    public final Set c() {
        return new HashSet(this.f3036a.keySet());
    }

    public final void d(String str, z zVar) {
        q0.f.e(str, "key");
        q0.f.e(zVar, "viewModel");
        z zVar2 = (z) this.f3036a.put(str, zVar);
        if (zVar2 != null) {
            zVar2.d();
        }
    }
}
