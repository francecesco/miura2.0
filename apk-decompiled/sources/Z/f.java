package Z;

/* JADX INFO: loaded from: classes.dex */
public class f extends c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f633m;

    public f(byte[] bArr) {
        super(bArr);
    }

    @Override // Y.b
    protected void h() {
        if (this.f582b != null) {
            j0.d.a("ActivateResponse: there is something to be parsed here!");
            t();
            this.f633m = b(14);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString() + "\n");
        return stringBuffer.toString();
    }
}
