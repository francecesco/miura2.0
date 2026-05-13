package f0;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    public c(byte[] bArr) {
        super(bArr);
    }

    @Override // Y.b
    protected void h() {
        int[] iArr = this.f582b;
        if (iArr != null) {
            this.f3576h = iArr[4];
            this.f3577i = m(iArr[5], iArr[6]);
            if (this.f582b.length > 7) {
                this.f3578j = new String(this.f583c, 7, r2.length - 10);
            }
        }
    }
}
