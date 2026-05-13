package androidx.lifecycle;

import androidx.lifecycle.AbstractC0183g;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleAttacher implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x f3065a;

    public SavedStateHandleAttacher(x xVar) {
        q0.f.e(xVar, "provider");
        this.f3065a = xVar;
    }

    @Override // androidx.lifecycle.j
    public void d(l lVar, AbstractC0183g.a aVar) {
        q0.f.e(lVar, "source");
        q0.f.e(aVar, "event");
        if (aVar == AbstractC0183g.a.ON_CREATE) {
            lVar.G().c(this);
            this.f3065a.c();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + aVar).toString());
        }
    }
}
