package i0;

/* JADX INFO: loaded from: classes.dex */
public class g extends e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3656i;

    public g(byte[] bArr) {
        super(bArr);
    }

    @Override // Y.b
    protected void h() {
        int[] iArr = this.f582b;
        if (iArr != null) {
            this.f3655h = iArr[4];
            this.f3656i = iArr[5];
        }
    }

    public int q() {
        return this.f3655h;
    }

    public boolean r() {
        return (this.f3656i & 2) != 0;
    }

    public boolean s() {
        return (this.f3656i & 8) != 0;
    }

    public boolean t() {
        return (this.f3656i & 128) != 0;
    }

    public boolean u() {
        return (this.f3656i & 4) != 0;
    }
}
