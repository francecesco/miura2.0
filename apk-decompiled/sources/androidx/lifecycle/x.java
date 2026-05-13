package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.a;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class x implements a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final androidx.savedstate.a f3119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f3121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final k0.a f3122d;

    static final class a extends q0.g implements p0.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ E f3123b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(E e2) {
            super(0);
            this.f3123b = e2;
        }

        @Override // p0.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final y a() {
            return w.b(this.f3123b);
        }
    }

    public x(androidx.savedstate.a aVar, E e2) {
        q0.f.e(aVar, "savedStateRegistry");
        q0.f.e(e2, "viewModelStoreOwner");
        this.f3119a = aVar;
        this.f3122d = k0.b.a(new a(e2));
    }

    private final y b() {
        return (y) this.f3122d.getValue();
    }

    @Override // androidx.savedstate.a.c
    public Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f3121c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        Iterator it2 = b().e().entrySet().iterator();
        if (!it2.hasNext()) {
            this.f3120b = false;
            return bundle;
        }
        Map.Entry entry = (Map.Entry) it2.next();
        android.support.v4.media.session.b.a(entry.getValue());
        throw null;
    }

    public final void c() {
        if (this.f3120b) {
            return;
        }
        Bundle bundleB = this.f3119a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f3121c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleB != null) {
            bundle.putAll(bundleB);
        }
        this.f3121c = bundle;
        this.f3120b = true;
        b();
    }
}
