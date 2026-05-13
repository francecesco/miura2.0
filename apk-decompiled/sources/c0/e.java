package c0;

/* JADX INFO: loaded from: classes.dex */
public class e extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3444h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3445i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3446j;

    public e(int i2, int i3) {
        this(i2, i3, 20);
    }

    @Override // c0.d, Y.b
    protected void i() {
        super.i();
        this.f581a.write(1);
        this.f581a.write(this.f3446j);
        this.f581a.write(0);
        p(this.f3444h);
        p(this.f3445i);
    }

    public e(int i2, int i3, int i4) {
        this.f3446j = i2;
        this.f3444h = i3;
        this.f3445i = i4;
    }
}
