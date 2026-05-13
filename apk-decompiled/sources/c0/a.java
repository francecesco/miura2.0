package c0;

/* JADX INFO: loaded from: classes.dex */
public class a extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3441i;

    public a(int i2, int i3) {
        this.f3441i = i2;
        this.f3440h = i3;
    }

    @Override // c0.d, Y.b
    protected void i() {
        super.i();
        this.f581a.write(1);
        this.f581a.write(this.f3441i);
        this.f581a.write(1);
        p(this.f3440h);
        p(1);
    }
}
