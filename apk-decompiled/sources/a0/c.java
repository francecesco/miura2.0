package a0;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    public c(byte[] bArr) {
        super(bArr);
    }

    @Override // Y.b
    protected void h() {
        int[] iArr = this.f582b;
        if (iArr != null) {
            this.f659h = iArr[4];
            this.f660i = iArr[5];
            this.f661j = iArr[6];
            this.f662k = iArr[7];
            this.f663l = iArr[8];
            this.f664m = iArr[9];
        }
    }

    public String toString() {
        return "Clock update: " + this.f659h + "/" + this.f660i + "/" + this.f661j + " at " + this.f662k + ":" + this.f663l + ":" + this.f664m;
    }
}
