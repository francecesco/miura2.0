package g0;

/* JADX INFO: loaded from: classes.dex */
public class a extends g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3579h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3580i;

    public a(int i2, boolean z2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Can't apply to ALL timers at a time. See documentation.");
        }
        this.f3579h = i2;
        this.f3580i = z2;
    }

    @Override // g0.g, Y.b
    protected void i() {
        super.i();
        this.f581a.write(1);
        this.f581a.write(this.f3579h);
        this.f581a.write(5);
        this.f581a.write(this.f3580i ? 1 : 0);
        j0.d.d(this.f581a.toByteArray());
    }
}
