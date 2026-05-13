package Z;

/* JADX INFO: loaded from: classes.dex */
public class l extends m {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f635o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f636p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f637q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f638r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f639s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f640t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f641u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f642v;

    public l(byte[] bArr) {
        super(bArr);
    }

    @Override // Y.b
    protected void h() {
        if (this.f582b != null) {
            j0.d.a("Parsing ZonesPeripheralsStatusResponse from data:");
            j0.d.d(this.f583c);
            int[] iArr = this.f582b;
            this.f622h = m(iArr[4], iArr[5]);
            this.f643m = this.f582b[6];
            j0.d.a("Peripheral response for type " + this.f643m);
            int[] iArr2 = this.f582b;
            int i2 = iArr2[7];
            this.f635o = i2;
            int i3 = iArr2[8];
            this.f636p = i3;
            int i4 = iArr2[9];
            this.f637q = i4;
            this.f638r = iArr2[10];
            this.f639s = iArr2[11];
            this.f640t = iArr2[12];
            this.f642v = l(i2, i3, i4);
            if (this.f643m == 9) {
                this.f641u = this.f582b[13];
                j0.d.a("Board failure: " + this.f641u);
            }
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString() + "\n");
        return stringBuffer.toString();
    }

    public int w() {
        if (this.f643m == 9) {
            return this.f641u;
        }
        throw new RuntimeException("Board failure is included only in failure responses (this response is for type " + this.f643m + ")");
    }

    public int x() {
        return this.f640t;
    }

    public int y() {
        return this.f642v;
    }
}
