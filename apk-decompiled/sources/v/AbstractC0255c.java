package v;

import java.nio.ByteBuffer;

/* JADX INFO: renamed from: v.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0255c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f4037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ByteBuffer f4038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    AbstractC0256d f4041e = AbstractC0256d.a();

    protected int a(int i2) {
        return i2 + this.f4038b.getInt(i2);
    }

    protected int b(int i2) {
        if (i2 < this.f4040d) {
            return this.f4038b.getShort(this.f4039c + i2);
        }
        return 0;
    }

    protected void c(int i2, ByteBuffer byteBuffer) {
        short s2;
        this.f4038b = byteBuffer;
        if (byteBuffer != null) {
            this.f4037a = i2;
            int i3 = i2 - byteBuffer.getInt(i2);
            this.f4039c = i3;
            s2 = this.f4038b.getShort(i3);
        } else {
            s2 = 0;
            this.f4037a = 0;
            this.f4039c = 0;
        }
        this.f4040d = s2;
    }

    protected int d(int i2) {
        int i3 = i2 + this.f4037a;
        return i3 + this.f4038b.getInt(i3) + 4;
    }

    protected int e(int i2) {
        int i3 = i2 + this.f4037a;
        return this.f4038b.getInt(i3 + this.f4038b.getInt(i3));
    }
}
