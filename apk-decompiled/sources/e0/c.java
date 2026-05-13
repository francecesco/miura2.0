package e0;

/* JADX INFO: loaded from: classes.dex */
public class c extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3489h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3490i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3491j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3492k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f3493l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f3494m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f3495n;

    public c(byte[] bArr) {
        super(bArr);
    }

    @Override // Y.b
    protected void h() {
        if (this.f582b != null) {
            j0.d.a("StandbyInfoResponse: ");
            j0.d.d(this.f583c);
            j0.d.a("- there is something to be parsed here!");
            int[] iArr = this.f582b;
            this.f3489h = iArr[4];
            this.f3490i = iArr[5];
            this.f3491j = iArr[6];
            this.f3492k = iArr[7];
            this.f3493l = iArr[8];
            this.f3494m = iArr[9];
            if (iArr.length > 10) {
                this.f3495n = new String(iArr, 10, iArr.length - 12);
            }
        }
    }

    public String q() {
        return Integer.toString(this.f3492k) + "." + Integer.toString(this.f3493l);
    }

    public String r() {
        return this.f3495n;
    }

    public int s() {
        return this.f3494m;
    }

    public boolean t() {
        return (this.f3489h & 1) != 0;
    }

    public boolean u() {
        return (this.f3491j & 2) == 0;
    }

    public boolean v() {
        return (this.f3489h & 2) != 0;
    }

    public boolean w() {
        return (this.f3489h & 128) != 0;
    }

    public boolean x() {
        return (this.f3489h & 64) != 0;
    }
}
