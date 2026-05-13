package i0;

/* JADX INFO: loaded from: classes.dex */
public class a extends e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3643i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3644j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3645k;

    public a(int i2, int i3, int i4, int i5) {
        this.f3655h = i2;
        this.f3643i = i3;
        this.f3644j = i4;
        this.f3645k = i5;
    }

    @Override // i0.e, Y.b
    protected void i() {
        super.i();
        this.f581a.write(3);
        this.f581a.write(this.f3655h);
        this.f581a.write(this.f3643i);
        this.f581a.write(this.f3644j);
        this.f581a.write(this.f3645k);
    }
}
