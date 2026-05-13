package Z;

/* JADX INFO: loaded from: classes.dex */
public class e extends m {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f628o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f629p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f630q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f631r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f632s;

    public e(byte[] bArr) {
        super(bArr);
    }

    public boolean A() {
        return (this.f628o & 15) == 1 && this.f629p == 0 && this.f630q == 0 && this.f631r == 0 && this.f632s == 0;
    }

    @Override // Y.b
    protected void h() {
        if (this.f582b != null) {
            j0.d.a("AllZonesResponse: there is something to be parsed here!");
            int[] iArr = this.f582b;
            this.f622h = m(iArr[4], iArr[5]);
            int[] iArr2 = this.f582b;
            int i2 = iArr2[6];
            this.f643m = i2;
            if (i2 != 0) {
                throw new RuntimeException("All zones expected!");
            }
            this.f628o = iArr2[7];
            this.f629p = iArr2[8];
            this.f630q = iArr2[9];
            this.f631r = iArr2[10];
            this.f632s = iArr2[11];
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString() + "\n");
        return stringBuffer.toString();
    }

    public boolean w() {
        return this.f629p != 0;
    }

    public boolean x() {
        return (this.f628o & 1) != 0;
    }

    public int y() {
        return this.f628o;
    }

    public boolean z() {
        return (this.f631r & 1) != 0;
    }
}
