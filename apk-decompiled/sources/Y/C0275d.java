package y;

import q0.f;
import y.AbstractC0272a;

/* JADX INFO: renamed from: y.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0275d extends AbstractC0272a {
    /* JADX WARN: Multi-variable type inference failed */
    public C0275d() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void b(AbstractC0272a.b bVar, Object obj) {
        f.e(bVar, "key");
        a().put(bVar, obj);
    }

    public C0275d(AbstractC0272a abstractC0272a) {
        f.e(abstractC0272a, "initialExtras");
        a().putAll(abstractC0272a.a());
    }

    public /* synthetic */ C0275d(AbstractC0272a abstractC0272a, int i2, q0.d dVar) {
        this((i2 & 1) != 0 ? AbstractC0272a.C0076a.f4095b : abstractC0272a);
    }
}
