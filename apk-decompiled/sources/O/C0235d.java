package o;

/* JADX INFO: renamed from: o.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0235d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3922b;

    public C0235d(Object obj, Object obj2) {
        this.f3921a = obj;
        this.f3922b = obj2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0235d)) {
            return false;
        }
        C0235d c0235d = (C0235d) obj;
        return AbstractC0234c.a(c0235d.f3921a, this.f3921a) && AbstractC0234c.a(c0235d.f3922b, this.f3922b);
    }

    public int hashCode() {
        Object obj = this.f3921a;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f3922b;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f3921a + " " + this.f3922b + "}";
    }
}
