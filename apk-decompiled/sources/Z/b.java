package Z;

/* JADX INFO: loaded from: classes.dex */
public class b extends c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f621m;

    public b(byte[] bArr) {
        super(bArr);
    }

    @Override // Y.b
    protected void h() {
        if (this.f582b != null) {
            j0.d.a("ActivateResponse: there is something to be parsed here!");
            t();
            this.f621m = this.f582b[14];
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString() + "\n");
        return stringBuffer.toString();
    }
}
