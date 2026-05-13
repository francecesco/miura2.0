package h0;

/* JADX INFO: loaded from: classes.dex */
public class c extends d {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f3625o;

    public c(byte[] bArr) {
        super(bArr);
        this.f3625o = false;
    }

    @Override // Y.b
    protected void h() {
        if (this.f582b != null) {
            j0.d.a("UserInfoData: ");
            j0.d.d(this.f583c);
            j0.d.a("- there is something to be parsed here!");
            int[] iArr = this.f582b;
            int i2 = iArr[4];
            this.f3626h = i2;
            switch (i2) {
                case 250:
                case 251:
                case 252:
                case 253:
                case 254:
                case 255:
                    break;
                default:
                    this.f3627i = iArr[5];
                    this.f3628j = b(6);
                    this.f3629k = this.f582b[8];
                    this.f3630l = b(9);
                    this.f3631m = b(11);
                    j0.d.a("Activation mask: " + Integer.toBinaryString(this.f3630l));
                    j0.d.a("Deactivation mask: " + Integer.toBinaryString(this.f3631m));
                    int[] iArr2 = this.f582b;
                    this.f3632n = new String(iArr2, 13, iArr2.length + (-16));
                    j0.d.a("- Authorizations: " + Integer.toBinaryString(this.f3628j));
                    break;
            }
        }
    }

    public boolean s() {
        return (this.f3628j & 8) != 0;
    }

    public boolean t(int i2) {
        return (i2 & this.f3630l) != 0;
    }

    public String toString() {
        return "UserDataInfo - user: " + this.f3626h + ", type: " + this.f3627i + ", name: " + this.f3632n;
    }

    public boolean u(int i2) {
        return (i2 & this.f3631m) != 0;
    }

    public boolean v() {
        return (this.f3628j & 4) != 0;
    }

    public boolean w() {
        return (this.f3628j & 32) != 0;
    }

    public boolean x() {
        return (this.f3628j & 1) != 0;
    }

    public boolean y() {
        return (this.f3628j & 2) != 0;
    }
}
