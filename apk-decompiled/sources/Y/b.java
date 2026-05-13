package Y;

import j0.j;
import java.io.ByteArrayOutputStream;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Random f580g = new Random(System.currentTimeMillis());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ByteArrayOutputStream f581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int[] f582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected byte[] f583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f584d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte f585e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f586f;

    protected b() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f581a = byteArrayOutputStream;
        byteArrayOutputStream.write(241);
    }

    public static final byte[] c(byte[] bArr) {
        if (bArr[1] == 0) {
            j0.d.a("The message is NOT encrypted");
            return bArr;
        }
        j0.d.a("The message is encrypted");
        byte[] bArrA = E.a.a(bArr, 0, bArr.length);
        byte b2 = bArr[1];
        bArrA[0] = (byte) ((bArrA[0] ^ b2) & 255);
        for (int i2 = 2; i2 < bArrA.length; i2++) {
            bArrA[i2] = (byte) ((bArrA[i2] ^ b2) & 255);
        }
        return bArrA;
    }

    public static boolean f(byte[] bArr) {
        return bArr[0] == 0;
    }

    protected void a() {
        int iB = j.b(this.f581a.toByteArray());
        this.f581a.write((65280 & iB) >>> 8);
        this.f581a.write(iB & 255);
    }

    protected int b(int i2) {
        int i3 = i2 + 1;
        if (this.f582b.length <= i3) {
            j0.d.a("Bad packet format");
            throw new RuntimeException("Bad packet format");
        }
        j0.d.a("- LOW: " + this.f582b[i2]);
        j0.d.a("- HI:  " + this.f582b[i3]);
        int[] iArr = this.f582b;
        return m(iArr[i2], iArr[i3]);
    }

    public int d() {
        return this.f582b[3];
    }

    public int e() {
        return this.f582b[2];
    }

    public final boolean g() {
        return this.f582b[1] != 0;
    }

    protected void h() {
        throw new RuntimeException("parse() must be overridden for incoming messages");
    }

    public final void j() {
        this.f585e = (byte) f580g.nextInt();
        k();
        byte[] bArr = this.f583c;
        bArr[0] = (byte) ((bArr[0] ^ this.f585e) & 255);
        int i2 = 2;
        while (true) {
            byte[] bArr2 = this.f583c;
            if (i2 >= bArr2.length) {
                return;
            }
            bArr2[i2] = (byte) ((bArr2[i2] ^ this.f585e) & 255);
            i2++;
        }
    }

    public final void k() {
        this.f581a.write(this.f585e);
        i();
        a();
        this.f583c = this.f581a.toByteArray();
    }

    protected int l(int i2, int i3, int i4) {
        return (i2 & 255) | ((i3 & 255) << 8) | ((i4 & 255) << 16);
    }

    protected int m(int i2, int i3) {
        return (i2 & 255) | ((i3 & 255) << 8);
    }

    public final byte[] n() {
        if (this.f584d) {
            j0.d.d(this.f583c);
        }
        return this.f583c;
    }

    protected boolean o() {
        j.b(E.a.a(this.f583c, 0, this.f582b.length - 2));
        int[] iArr = this.f582b;
        int i2 = iArr[iArr.length - 2];
        int i3 = iArr[iArr.length - 1];
        return true;
    }

    protected void p(int i2) {
        this.f581a.write(i2 & 255);
        this.f581a.write((i2 & 65280) >>> 8);
    }

    protected b(byte[] bArr) {
        this.f583c = bArr;
        this.f582b = j.c(bArr);
        if (!o()) {
            throw new RuntimeException("CRC not valid. Please check.");
        }
        h();
        this.f586f = 4;
    }

    protected void i() {
    }
}
