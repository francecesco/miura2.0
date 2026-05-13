package androidx.activity.result;

import androidx.activity.result.d;
import androidx.lifecycle.AbstractC0183g;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import c.AbstractC0186a;

/* JADX INFO: loaded from: classes.dex */
class ActivityResultRegistry$1 implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AbstractC0186a f797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ d f798d;

    @Override // androidx.lifecycle.j
    public void d(l lVar, AbstractC0183g.a aVar) {
        if (!AbstractC0183g.a.ON_START.equals(aVar)) {
            if (AbstractC0183g.a.ON_STOP.equals(aVar)) {
                this.f798d.f806f.remove(this.f795a);
                return;
            } else {
                if (AbstractC0183g.a.ON_DESTROY.equals(aVar)) {
                    this.f798d.k(this.f795a);
                    return;
                }
                return;
            }
        }
        this.f798d.f806f.put(this.f795a, new d.b(this.f796b, this.f797c));
        if (this.f798d.f807g.containsKey(this.f795a)) {
            Object obj = this.f798d.f807g.get(this.f795a);
            this.f798d.f807g.remove(this.f795a);
            this.f796b.a(obj);
        }
        a aVar2 = (a) this.f798d.f808h.getParcelable(this.f795a);
        if (aVar2 != null) {
            this.f798d.f808h.remove(this.f795a);
            this.f796b.a(this.f797c.c(aVar2.b(), aVar2.a()));
        }
    }
}
