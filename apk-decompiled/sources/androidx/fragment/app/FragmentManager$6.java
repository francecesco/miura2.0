package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0183g;

/* JADX INFO: loaded from: classes.dex */
class FragmentManager$6 implements androidx.lifecycle.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f2740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AbstractC0183g f2741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ x f2742c;

    @Override // androidx.lifecycle.j
    public void d(androidx.lifecycle.l lVar, AbstractC0183g.a aVar) {
        if (aVar == AbstractC0183g.a.ON_START && ((Bundle) this.f2742c.f2986k.get(this.f2740a)) != null) {
            throw null;
        }
        if (aVar == AbstractC0183g.a.ON_DESTROY) {
            this.f2741b.c(this);
            this.f2742c.f2987l.remove(this.f2740a);
        }
    }
}
