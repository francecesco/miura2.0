package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0183g;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import androidx.savedstate.Recreator;
import j.C0206b;
import java.util.Map;
import q0.d;
import q0.f;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final b f3209g = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f3212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Recreator.b f3214e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0206b f3210a = new C0206b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f3215f = true;

    /* JADX INFO: renamed from: androidx.savedstate.a$a, reason: collision with other inner class name */
    public interface InterfaceC0054a {
        void a(A.c cVar);
    }

    private static final class b {
        private b() {
        }

        public /* synthetic */ b(d dVar) {
            this();
        }
    }

    public interface c {
        Bundle a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(a aVar, l lVar, AbstractC0183g.a aVar2) {
        boolean z2;
        f.e(aVar, "this$0");
        f.e(lVar, "<anonymous parameter 0>");
        f.e(aVar2, "event");
        if (aVar2 == AbstractC0183g.a.ON_START) {
            z2 = true;
        } else if (aVar2 != AbstractC0183g.a.ON_STOP) {
            return;
        } else {
            z2 = false;
        }
        aVar.f3215f = z2;
    }

    public final Bundle b(String str) {
        f.e(str, "key");
        if (!this.f3213d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
        }
        Bundle bundle = this.f3212c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.f3212c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f3212c;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.f3212c = null;
        }
        return bundle2;
    }

    public final c c(String str) {
        f.e(str, "key");
        for (Map.Entry entry : this.f3210a) {
            f.d(entry, "components");
            String str2 = (String) entry.getKey();
            c cVar = (c) entry.getValue();
            if (f.a(str2, str)) {
                return cVar;
            }
        }
        return null;
    }

    public final void e(AbstractC0183g abstractC0183g) {
        f.e(abstractC0183g, "lifecycle");
        if (!(!this.f3211b)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        abstractC0183g.a(new j() { // from class: A.a
            @Override // androidx.lifecycle.j
            public final void d(l lVar, AbstractC0183g.a aVar) {
                androidx.savedstate.a.d(this.f0a, lVar, aVar);
            }
        });
        this.f3211b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.f3211b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!this.f3213d)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        this.f3212c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f3213d = true;
    }

    public final void g(Bundle bundle) {
        f.e(bundle, "outBundle");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f3212c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        C0206b.d dVarC = this.f3210a.c();
        f.d(dVarC, "this.components.iteratorWithAdditions()");
        while (dVarC.hasNext()) {
            Map.Entry entry = (Map.Entry) dVarC.next();
            bundle2.putBundle((String) entry.getKey(), ((c) entry.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public final void h(String str, c cVar) {
        f.e(str, "key");
        f.e(cVar, "provider");
        if (((c) this.f3210a.f(str, cVar)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void i(Class cls) {
        f.e(cls, "clazz");
        if (!this.f3215f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
        Recreator.b bVar = this.f3214e;
        if (bVar == null) {
            bVar = new Recreator.b(this);
        }
        this.f3214e = bVar;
        try {
            cls.getDeclaredConstructor(null);
            Recreator.b bVar2 = this.f3214e;
            if (bVar2 != null) {
                String name = cls.getName();
                f.d(name, "clazz.name");
                bVar2.b(name);
            }
        } catch (NoSuchMethodException e2) {
            throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
        }
    }
}
