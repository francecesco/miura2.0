package androidx.lifecycle;

import androidx.lifecycle.AbstractC0183g;
import y.AbstractC0272a;
import y.C0274c;

/* JADX INFO: loaded from: classes.dex */
public abstract class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC0272a.b f3115a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC0272a.b f3116b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AbstractC0272a.b f3117c = new a();

    public static final class a implements AbstractC0272a.b {
        a() {
        }
    }

    public static final class b implements AbstractC0272a.b {
        b() {
        }
    }

    public static final class c implements AbstractC0272a.b {
        c() {
        }
    }

    static final class d extends q0.g implements p0.l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f3118b = new d();

        d() {
            super(1);
        }

        @Override // p0.l
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final y b(AbstractC0272a abstractC0272a) {
            q0.f.e(abstractC0272a, "$this$initializer");
            return new y();
        }
    }

    public static final void a(A.c cVar) {
        q0.f.e(cVar, "<this>");
        AbstractC0183g.b bVarB = cVar.G().b();
        if (bVarB != AbstractC0183g.b.INITIALIZED && bVarB != AbstractC0183g.b.CREATED) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (cVar.d().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            x xVar = new x(cVar.d(), (E) cVar);
            cVar.d().h("androidx.lifecycle.internal.SavedStateHandlesProvider", xVar);
            cVar.G().a(new SavedStateHandleAttacher(xVar));
        }
    }

    public static final y b(E e2) {
        q0.f.e(e2, "<this>");
        C0274c c0274c = new C0274c();
        c0274c.a(q0.h.a(y.class), d.f3118b);
        return (y) new A(e2, c0274c.b()).b("androidx.lifecycle.internal.SavedStateHandlesVM", y.class);
    }
}
