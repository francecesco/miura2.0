package androidx.lifecycle;

import androidx.lifecycle.AbstractC0183g;

/* JADX INFO: loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends h implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractC0183g f3043a;

    @Override // androidx.lifecycle.j
    public void d(l lVar, AbstractC0183g.a aVar) {
        q0.f.e(lVar, "source");
        q0.f.e(aVar, "event");
        if (i().b().compareTo(AbstractC0183g.b.DESTROYED) <= 0) {
            i().c(this);
            h();
            u0.c.b(null, null, 1, null);
        }
    }

    public m0.a h() {
        return null;
    }

    public AbstractC0183g i() {
        return this.f3043a;
    }
}
