package androidx.lifecycle;

import androidx.lifecycle.AbstractC0183g;
import i.C0202c;
import j.C0205a;
import j.C0206b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class m extends AbstractC0183g {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f3085j = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f3086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C0205a f3087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AbstractC0183g.b f3088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final WeakReference f3089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f3091g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f3092h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList f3093i;

    public static final class a {
        private a() {
        }

        public final AbstractC0183g.b a(AbstractC0183g.b bVar, AbstractC0183g.b bVar2) {
            q0.f.e(bVar, "state1");
            return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
        }

        public /* synthetic */ a(q0.d dVar) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AbstractC0183g.b f3094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private j f3095b;

        public b(k kVar, AbstractC0183g.b bVar) {
            q0.f.e(bVar, "initialState");
            q0.f.b(kVar);
            this.f3095b = n.f(kVar);
            this.f3094a = bVar;
        }

        public final void a(l lVar, AbstractC0183g.a aVar) {
            q0.f.e(aVar, "event");
            AbstractC0183g.b bVarB = aVar.b();
            this.f3094a = m.f3085j.a(this.f3094a, bVarB);
            j jVar = this.f3095b;
            q0.f.b(lVar);
            jVar.d(lVar, aVar);
            this.f3094a = bVarB;
        }

        public final AbstractC0183g.b b() {
            return this.f3094a;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m(l lVar) {
        this(lVar, true);
        q0.f.e(lVar, "provider");
    }

    private final void d(l lVar) {
        Iterator itDescendingIterator = this.f3087c.descendingIterator();
        q0.f.d(itDescendingIterator, "observerMap.descendingIterator()");
        while (itDescendingIterator.hasNext() && !this.f3092h) {
            Map.Entry entry = (Map.Entry) itDescendingIterator.next();
            q0.f.d(entry, "next()");
            k kVar = (k) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f3088d) > 0 && !this.f3092h && this.f3087c.contains(kVar)) {
                AbstractC0183g.a aVarA = AbstractC0183g.a.Companion.a(bVar.b());
                if (aVarA == null) {
                    throw new IllegalStateException("no event down from " + bVar.b());
                }
                l(aVarA.b());
                bVar.a(lVar, aVarA);
                k();
            }
        }
    }

    private final AbstractC0183g.b e(k kVar) {
        b bVar;
        Map.Entry entryH = this.f3087c.h(kVar);
        AbstractC0183g.b bVar2 = null;
        AbstractC0183g.b bVarB = (entryH == null || (bVar = (b) entryH.getValue()) == null) ? null : bVar.b();
        if (!this.f3093i.isEmpty()) {
            bVar2 = (AbstractC0183g.b) this.f3093i.get(r0.size() - 1);
        }
        a aVar = f3085j;
        return aVar.a(aVar.a(this.f3088d, bVarB), bVar2);
    }

    private final void f(String str) {
        if (!this.f3086b || C0202c.f().b()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    private final void g(l lVar) {
        C0206b.d dVarC = this.f3087c.c();
        q0.f.d(dVarC, "observerMap.iteratorWithAdditions()");
        while (dVarC.hasNext() && !this.f3092h) {
            Map.Entry entry = (Map.Entry) dVarC.next();
            k kVar = (k) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f3088d) < 0 && !this.f3092h && this.f3087c.contains(kVar)) {
                l(bVar.b());
                AbstractC0183g.a aVarB = AbstractC0183g.a.Companion.b(bVar.b());
                if (aVarB == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(lVar, aVarB);
                k();
            }
        }
    }

    private final boolean i() {
        if (this.f3087c.size() == 0) {
            return true;
        }
        Map.Entry entryA = this.f3087c.a();
        q0.f.b(entryA);
        AbstractC0183g.b bVarB = ((b) entryA.getValue()).b();
        Map.Entry entryD = this.f3087c.d();
        q0.f.b(entryD);
        AbstractC0183g.b bVarB2 = ((b) entryD.getValue()).b();
        return bVarB == bVarB2 && this.f3088d == bVarB2;
    }

    private final void j(AbstractC0183g.b bVar) {
        AbstractC0183g.b bVar2 = this.f3088d;
        if (bVar2 == bVar) {
            return;
        }
        if (bVar2 == AbstractC0183g.b.INITIALIZED && bVar == AbstractC0183g.b.DESTROYED) {
            throw new IllegalStateException(("no event down from " + this.f3088d + " in component " + this.f3089e.get()).toString());
        }
        this.f3088d = bVar;
        if (this.f3091g || this.f3090f != 0) {
            this.f3092h = true;
            return;
        }
        this.f3091g = true;
        n();
        this.f3091g = false;
        if (this.f3088d == AbstractC0183g.b.DESTROYED) {
            this.f3087c = new C0205a();
        }
    }

    private final void k() {
        this.f3093i.remove(r0.size() - 1);
    }

    private final void l(AbstractC0183g.b bVar) {
        this.f3093i.add(bVar);
    }

    private final void n() {
        l lVar = (l) this.f3089e.get();
        if (lVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            boolean zI = i();
            this.f3092h = false;
            if (zI) {
                return;
            }
            AbstractC0183g.b bVar = this.f3088d;
            Map.Entry entryA = this.f3087c.a();
            q0.f.b(entryA);
            if (bVar.compareTo(((b) entryA.getValue()).b()) < 0) {
                d(lVar);
            }
            Map.Entry entryD = this.f3087c.d();
            if (!this.f3092h && entryD != null && this.f3088d.compareTo(((b) entryD.getValue()).b()) > 0) {
                g(lVar);
            }
        }
    }

    @Override // androidx.lifecycle.AbstractC0183g
    public void a(k kVar) {
        l lVar;
        q0.f.e(kVar, "observer");
        f("addObserver");
        AbstractC0183g.b bVar = this.f3088d;
        AbstractC0183g.b bVar2 = AbstractC0183g.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = AbstractC0183g.b.INITIALIZED;
        }
        b bVar3 = new b(kVar, bVar2);
        if (((b) this.f3087c.f(kVar, bVar3)) == null && (lVar = (l) this.f3089e.get()) != null) {
            boolean z2 = this.f3090f != 0 || this.f3091g;
            AbstractC0183g.b bVarE = e(kVar);
            this.f3090f++;
            while (bVar3.b().compareTo(bVarE) < 0 && this.f3087c.contains(kVar)) {
                l(bVar3.b());
                AbstractC0183g.a aVarB = AbstractC0183g.a.Companion.b(bVar3.b());
                if (aVarB == null) {
                    throw new IllegalStateException("no event up from " + bVar3.b());
                }
                bVar3.a(lVar, aVarB);
                k();
                bVarE = e(kVar);
            }
            if (!z2) {
                n();
            }
            this.f3090f--;
        }
    }

    @Override // androidx.lifecycle.AbstractC0183g
    public AbstractC0183g.b b() {
        return this.f3088d;
    }

    @Override // androidx.lifecycle.AbstractC0183g
    public void c(k kVar) {
        q0.f.e(kVar, "observer");
        f("removeObserver");
        this.f3087c.g(kVar);
    }

    public void h(AbstractC0183g.a aVar) {
        q0.f.e(aVar, "event");
        f("handleLifecycleEvent");
        j(aVar.b());
    }

    public void m(AbstractC0183g.b bVar) {
        q0.f.e(bVar, "state");
        f("setCurrentState");
        j(bVar);
    }

    private m(l lVar, boolean z2) {
        this.f3086b = z2;
        this.f3087c = new C0205a();
        this.f3088d = AbstractC0183g.b.INITIALIZED;
        this.f3093i = new ArrayList();
        this.f3089e = new WeakReference(lVar);
    }
}
