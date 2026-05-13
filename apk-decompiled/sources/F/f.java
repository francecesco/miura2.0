package F;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f15a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final O.c f16b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f17c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f18d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f19e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f20f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f21g;

    f(h hVar, O.c cVar) {
        K.e.f(hVar);
        K.e.f(cVar);
        this.f15a = hVar;
        this.f16b = cVar;
        this.f17c = 1800000L;
        this.f18d = 3024000000L;
        this.f20f = new HashMap();
        this.f21g = new ArrayList();
    }

    final void a() {
        this.f19e = true;
    }
}
