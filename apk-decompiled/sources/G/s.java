package G;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class s extends r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f64c;

    s(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f64c = bArr;
    }

    @Override // G.r
    final byte[] f() {
        return this.f64c;
    }
}
