package androidx.lifecycle;

import androidx.lifecycle.AbstractC0183g;
import androidx.lifecycle.C0177a;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
class ReflectiveGenericLifecycleObserver implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f3063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0177a.C0049a f3064b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f3063a = obj;
        this.f3064b = C0177a.f3067c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.j
    public void d(l lVar, AbstractC0183g.a aVar) {
        this.f3064b.a(lVar, aVar, this.f3063a);
    }
}
