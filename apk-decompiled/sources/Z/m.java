package Z;

/* JADX INFO: loaded from: classes.dex */
public abstract class m extends c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected int f643m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int f644n;

    protected m() {
    }

    public static m v(byte[] bArr) {
        j0.d.a("ZonesPeripheralsActivationStatusMessage parse for mask: " + Integer.toHexString(bArr[6]));
        byte b2 = bArr[6];
        if (b2 == 0) {
            return new e(bArr);
        }
        if (b2 == 2 || b2 == 3 || b2 == 4) {
            return new o(bArr);
        }
        switch (b2) {
            case 8:
            case 9:
            case 10:
                return new l(bArr);
            default:
                return null;
        }
    }

    public int u() {
        return this.f643m;
    }

    protected m(int i2, int i3) {
        this.f644n = i2;
        this.f643m = i3;
    }

    protected m(byte[] bArr) {
        super(bArr);
    }
}
