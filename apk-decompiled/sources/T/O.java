package T;

/* JADX INFO: loaded from: classes.dex */
public final class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final J.a f222b;

    private O(J.a aVar, Object obj) {
        K.e.f(aVar);
        this.f222b = aVar;
        this.f221a = obj;
    }

    static O b(String str, float f2, float f3) {
        Float fValueOf = Float.valueOf(0.5f);
        return new O(J.a.a(str, fValueOf), fValueOf);
    }

    static O c(String str, int i2, int i3) {
        return new O(J.a.b(str, Integer.valueOf(i3)), Integer.valueOf(i2));
    }

    static O d(String str, long j2, long j3) {
        return new O(J.a.c(str, Long.valueOf(j3)), Long.valueOf(j2));
    }

    static O e(String str, String str2, String str3) {
        return new O(J.a.d(str, str3), str2);
    }

    static O f(String str, boolean z2, boolean z3) {
        return new O(J.a.e(str, z3), Boolean.valueOf(z2));
    }

    public final Object a() {
        return this.f221a;
    }
}
