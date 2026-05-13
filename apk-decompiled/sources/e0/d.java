package e0;

/* JADX INFO: loaded from: classes.dex */
public abstract class d extends Y.b {
    protected d() {
    }

    @Override // Y.b
    protected void i() {
        super.i();
        this.f581a.write(15);
        j0.d.a("Reuqest standby: ");
        j0.d.d(this.f581a.toByteArray());
    }

    protected d(byte[] bArr) {
        super(bArr);
    }
}
