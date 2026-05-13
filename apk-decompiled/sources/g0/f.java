package g0;

/* JADX INFO: loaded from: classes.dex */
public class f extends g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3585h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3586i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3587j;

    public f(byte[] bArr) {
        super(bArr);
    }

    @Override // Y.b
    protected void h() {
        if (this.f582b != null) {
            j0.d.a("TimerGroupsResponse: ");
            int[] iArr = this.f582b;
            this.f3585h = iArr[4];
            int i2 = iArr[5];
            this.f3586i = m(iArr[6], iArr[7]);
            int[] iArr2 = this.f582b;
            this.f3587j = m(iArr2[8], iArr2[9]);
            j0.d.a("- timer: " + this.f3585h);
            j0.d.a("- activation   groups mask: " + Integer.toBinaryString(this.f3586i));
            j0.d.a("- deactivation groups mask: " + Integer.toBinaryString(this.f3587j));
        }
    }

    public int q() {
        return this.f3586i;
    }

    public int r() {
        return this.f3587j;
    }

    public int s() {
        return this.f3585h;
    }
}
