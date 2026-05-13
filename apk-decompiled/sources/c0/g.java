package c0;

/* JADX INFO: loaded from: classes.dex */
public class g extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3451h;

    public g(byte[] bArr) {
        super(bArr);
    }

    @Override // Y.b
    protected void h() {
        if (this.f582b != null) {
            j0.d.a("**** BROADCAST! ****");
            j0.d.a("LogWrittenBroadcast");
            j0.d.d(this.f583c);
            this.f3451h = this.f582b[4];
        }
    }
}
