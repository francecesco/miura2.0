package Z;

/* JADX INFO: loaded from: classes.dex */
public class a extends c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f619m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f620n;

    public a(int i2, boolean z2) {
        this.f619m = i2;
        this.f620n = z2;
    }

    @Override // Z.c, Y.b
    protected void i() {
        super.i();
        this.f581a.write(1);
        p(this.f619m);
        this.f581a.write(!this.f620n ? 1 : 0);
        this.f584d = true;
    }
}
