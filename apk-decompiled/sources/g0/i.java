package g0;

/* JADX INFO: loaded from: classes.dex */
public abstract class i extends g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f3588h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f3589i;

    public i(byte[] bArr) {
        super(bArr);
    }

    @Override // Y.b
    protected void h() {
        if (this.f582b != null) {
            j0.d.a(getClass().getName());
            j0.d.d(this.f583c);
            int[] iArr = this.f582b;
            this.f3588h = iArr[4];
            this.f3589i = iArr[5];
            j0.d.a("- Activation: " + Integer.toBinaryString(this.f3588h));
            j0.d.a("- Enabled:    " + Integer.toBinaryString(this.f3589i));
        }
    }

    public int q() {
        return this.f3588h;
    }

    public int r() {
        return this.f3589i;
    }
}
