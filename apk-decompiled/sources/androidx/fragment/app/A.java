package androidx.fragment.app;

import androidx.lifecycle.A;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import y.AbstractC0272a;

/* JADX INFO: loaded from: classes.dex */
final class A extends androidx.lifecycle.z {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final A.b f2618k = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f2622g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap f2619d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap f2620e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap f2621f = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2623h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f2624i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f2625j = false;

    class a implements A.b {
        a() {
        }

        @Override // androidx.lifecycle.A.b
        public androidx.lifecycle.z a(Class cls) {
            return new A(true);
        }

        @Override // androidx.lifecycle.A.b
        public /* synthetic */ androidx.lifecycle.z b(Class cls, AbstractC0272a abstractC0272a) {
            return androidx.lifecycle.B.b(this, cls, abstractC0272a);
        }
    }

    A(boolean z2) {
        this.f2622g = z2;
    }

    private void h(String str) {
        A a2 = (A) this.f2620e.get(str);
        if (a2 != null) {
            a2.d();
            this.f2620e.remove(str);
        }
        androidx.lifecycle.D d2 = (androidx.lifecycle.D) this.f2621f.get(str);
        if (d2 != null) {
            d2.a();
            this.f2621f.remove(str);
        }
    }

    static A k(androidx.lifecycle.D d2) {
        return (A) new androidx.lifecycle.A(d2, f2618k).a(A.class);
    }

    @Override // androidx.lifecycle.z
    protected void d() {
        if (x.H0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("onCleared called for ");
            sb.append(this);
        }
        this.f2623h = true;
    }

    void e(Fragment fragment) {
        if (this.f2625j) {
            x.H0(2);
            return;
        }
        if (this.f2619d.containsKey(fragment.f2691f)) {
            return;
        }
        this.f2619d.put(fragment.f2691f, fragment);
        if (x.H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Updating retained Fragments: Added ");
            sb.append(fragment);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || A.class != obj.getClass()) {
            return false;
        }
        A a2 = (A) obj;
        return this.f2619d.equals(a2.f2619d) && this.f2620e.equals(a2.f2620e) && this.f2621f.equals(a2.f2621f);
    }

    void f(Fragment fragment) {
        if (x.H0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Clearing non-config state for ");
            sb.append(fragment);
        }
        h(fragment.f2691f);
    }

    void g(String str) {
        if (x.H0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Clearing non-config state for saved state of Fragment ");
            sb.append(str);
        }
        h(str);
    }

    public int hashCode() {
        return (((this.f2619d.hashCode() * 31) + this.f2620e.hashCode()) * 31) + this.f2621f.hashCode();
    }

    Fragment i(String str) {
        return (Fragment) this.f2619d.get(str);
    }

    A j(Fragment fragment) {
        A a2 = (A) this.f2620e.get(fragment.f2691f);
        if (a2 != null) {
            return a2;
        }
        A a3 = new A(this.f2622g);
        this.f2620e.put(fragment.f2691f, a3);
        return a3;
    }

    Collection l() {
        return new ArrayList(this.f2619d.values());
    }

    androidx.lifecycle.D m(Fragment fragment) {
        androidx.lifecycle.D d2 = (androidx.lifecycle.D) this.f2621f.get(fragment.f2691f);
        if (d2 != null) {
            return d2;
        }
        androidx.lifecycle.D d3 = new androidx.lifecycle.D();
        this.f2621f.put(fragment.f2691f, d3);
        return d3;
    }

    boolean n() {
        return this.f2623h;
    }

    void o(Fragment fragment) {
        if (this.f2625j) {
            x.H0(2);
        } else {
            if (this.f2619d.remove(fragment.f2691f) == null || !x.H0(2)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Updating retained Fragments: Removed ");
            sb.append(fragment);
        }
    }

    void p(boolean z2) {
        this.f2625j = z2;
    }

    boolean q(Fragment fragment) {
        if (this.f2619d.containsKey(fragment.f2691f)) {
            return this.f2622g ? this.f2623h : !this.f2624i;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it2 = this.f2619d.values().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it3 = this.f2620e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it4 = this.f2621f.keySet().iterator();
        while (it4.hasNext()) {
            sb.append((String) it4.next());
            if (it4.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
