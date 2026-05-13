package A;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0183g;
import androidx.savedstate.Recreator;
import q0.f;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f1d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f2a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.savedstate.a f3b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4c;

    public static final class a {
        private a() {
        }

        public final b a(c cVar) {
            f.e(cVar, "owner");
            return new b(cVar, null);
        }

        public /* synthetic */ a(q0.d dVar) {
            this();
        }
    }

    private b(c cVar) {
        this.f2a = cVar;
        this.f3b = new androidx.savedstate.a();
    }

    public static final b a(c cVar) {
        return f1d.a(cVar);
    }

    public final androidx.savedstate.a b() {
        return this.f3b;
    }

    public final void c() {
        AbstractC0183g abstractC0183gG = this.f2a.G();
        if (abstractC0183gG.b() != AbstractC0183g.b.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        abstractC0183gG.a(new Recreator(this.f2a));
        this.f3b.e(abstractC0183gG);
        this.f4c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.f4c) {
            c();
        }
        AbstractC0183g abstractC0183gG = this.f2a.G();
        if (!abstractC0183gG.b().b(AbstractC0183g.b.STARTED)) {
            this.f3b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + abstractC0183gG.b()).toString());
    }

    public final void e(Bundle bundle) {
        f.e(bundle, "outBundle");
        this.f3b.g(bundle);
    }

    public /* synthetic */ b(c cVar, q0.d dVar) {
        this(cVar);
    }
}
