package Z;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends Y.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f622h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f623i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f624j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f625k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected int f626l;

    protected c() {
    }

    @Override // Y.b
    protected void i() {
        super.i();
        this.f581a.write(6);
    }

    public int q() {
        return this.f622h;
    }

    public int r() {
        return this.f623i;
    }

    public int s() {
        return this.f626l;
    }

    protected void t() {
        this.f622h = b(4);
        this.f623i = b(6);
        this.f624j = b(8);
        this.f625k = b(10);
        this.f626l = b(12);
    }

    protected c(byte[] bArr) {
        super(bArr);
    }
}
