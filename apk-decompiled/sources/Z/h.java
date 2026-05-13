package Z;

/* JADX INFO: loaded from: classes.dex */
public class h extends c {
    public h(byte[] bArr) {
        super(bArr);
    }

    @Override // Y.b
    protected void h() {
        if (this.f582b != null) {
            j0.d.a("ActivateResponse: there is something to be parsed here!");
            t();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString() + "\n");
        return stringBuffer.toString();
    }
}
