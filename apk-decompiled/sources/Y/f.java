package Y;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f618b;

    public f(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            throw new RuntimeException("Invalid header or command.");
        }
        this.f617a = i2;
        this.f618b = i3;
    }

    public boolean a(b bVar) {
        return bVar.e() == this.f617a && bVar.d() == this.f618b;
    }

    public abstract boolean c(b bVar);

    public abstract void d();

    public String toString() {
        return "ResponseListener for  HEADER: " + Integer.toHexString(this.f617a) + ", CMD: " + Integer.toHexString(this.f618b);
    }

    public void b(b bVar) {
    }
}
