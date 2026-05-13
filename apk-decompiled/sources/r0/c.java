package r0;

/* JADX INFO: loaded from: classes.dex */
public final class c extends r0.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f3998e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final c f3999f = new c(1, 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(q0.d dVar) {
            this();
        }
    }

    public c(int i2, int i3) {
        super(i2, i3, 1);
    }

    @Override // r0.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (a() != cVar.a() || b() != cVar.b()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // r0.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // r0.a
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // r0.a
    public String toString() {
        return a() + ".." + b();
    }
}
