package Z;

/* JADX INFO: loaded from: classes.dex */
public class o extends m {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f647o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f648p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f649q;

    public o(byte[] bArr) {
        super(bArr);
    }

    @Override // Y.b
    protected void h() {
        if (this.f582b != null) {
            j0.d.a("Parsing ZonesPeripheralsStatusResponse from data:");
            j0.d.d(this.f583c);
            int[] iArr = this.f582b;
            this.f622h = m(iArr[4], iArr[5]);
            int[] iArr2 = this.f582b;
            this.f643m = iArr2[6];
            this.f647o = iArr2[7];
            this.f648p = iArr2[8];
            this.f649q = iArr2[9];
            j0.d.a("Zone response: frame " + this.f647o + ", zone count " + this.f648p + ", zone ID " + this.f649q);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString() + "\n");
        return stringBuffer.toString();
    }

    public int w() {
        return this.f647o;
    }

    public int x() {
        return this.f648p;
    }

    public int y() {
        return this.f649q;
    }
}
