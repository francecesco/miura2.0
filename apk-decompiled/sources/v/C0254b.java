package v;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: renamed from: v.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0254b extends AbstractC0255c {
    public static C0254b h(ByteBuffer byteBuffer) {
        return i(byteBuffer, new C0254b());
    }

    public static C0254b i(ByteBuffer byteBuffer, C0254b c0254b) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return c0254b.f(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public C0254b f(int i2, ByteBuffer byteBuffer) {
        g(i2, byteBuffer);
        return this;
    }

    public void g(int i2, ByteBuffer byteBuffer) {
        c(i2, byteBuffer);
    }

    public C0253a j(C0253a c0253a, int i2) {
        int iB = b(6);
        if (iB != 0) {
            return c0253a.f(a(d(iB) + (i2 * 4)), this.f4038b);
        }
        return null;
    }

    public int k() {
        int iB = b(6);
        if (iB != 0) {
            return e(iB);
        }
        return 0;
    }

    public int l() {
        int iB = b(4);
        if (iB != 0) {
            return this.f4038b.getInt(iB + this.f4037a);
        }
        return 0;
    }
}
