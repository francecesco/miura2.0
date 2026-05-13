package i0;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class c extends e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3646i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3647j;

    public c(int i2) {
        this(true, i2, 7);
    }

    @Override // i0.e, Y.b
    protected void i() {
        ByteArrayOutputStream byteArrayOutputStream;
        super.i();
        int i2 = 1;
        this.f581a.write(1);
        if (this.f3646i) {
            byteArrayOutputStream = this.f581a;
        } else {
            byteArrayOutputStream = this.f581a;
            i2 = 15;
        }
        byteArrayOutputStream.write(i2);
        this.f581a.write(this.f3655h);
        this.f581a.write(this.f3647j);
    }

    public c(boolean z2, int i2, int i3) {
        j0.d.a("Preparing ZoneInfoRequest starting from zone " + i2);
        this.f3646i = z2;
        this.f3655h = i2;
        this.f3647j = i3;
    }
}
