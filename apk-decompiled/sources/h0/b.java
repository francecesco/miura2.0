package h0;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class b extends d {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private byte[] f3624o;

    public b(byte[] bArr) {
        this.f3624o = bArr;
    }

    @Override // h0.d, Y.b
    protected void i() {
        super.i();
        this.f581a.write(0);
        try {
            this.f581a.write(this.f3624o);
        } catch (IOException unused) {
        }
        this.f581a.write(0);
    }
}
