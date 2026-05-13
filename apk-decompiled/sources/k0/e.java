package k0;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f3855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f3856b;

    public e(Object obj, Object obj2) {
        this.f3855a = obj;
        this.f3856b = obj2;
    }

    public final Object a() {
        return this.f3855a;
    }

    public final Object b() {
        return this.f3856b;
    }

    public final Object c() {
        return this.f3855a;
    }

    public final Object d() {
        return this.f3856b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return q0.f.a(this.f3855a, eVar.f3855a) && q0.f.a(this.f3856b, eVar.f3856b);
    }

    public int hashCode() {
        Object obj = this.f3855a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f3856b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f3855a + ", " + this.f3856b + ')';
    }
}
