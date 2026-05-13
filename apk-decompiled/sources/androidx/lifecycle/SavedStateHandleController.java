package androidx.lifecycle;

import androidx.lifecycle.AbstractC0183g;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleController implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3066a;

    @Override // androidx.lifecycle.j
    public void d(l lVar, AbstractC0183g.a aVar) {
        q0.f.e(lVar, "source");
        q0.f.e(aVar, "event");
        if (aVar == AbstractC0183g.a.ON_DESTROY) {
            this.f3066a = false;
            lVar.G().c(this);
        }
    }

    public final void h(androidx.savedstate.a aVar, AbstractC0183g abstractC0183g) {
        q0.f.e(aVar, "registry");
        q0.f.e(abstractC0183g, "lifecycle");
        if (!(!this.f3066a)) {
            throw new IllegalStateException("Already attached to lifecycleOwner".toString());
        }
        this.f3066a = true;
        abstractC0183g.a(this);
        throw null;
    }

    public final boolean i() {
        return this.f3066a;
    }
}
