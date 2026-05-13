package G;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
abstract class t extends r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final WeakReference f65d = new WeakReference(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakReference f66c;

    t(byte[] bArr) {
        super(bArr);
        this.f66c = f65d;
    }

    @Override // G.r
    final byte[] f() {
        byte[] bArrH;
        synchronized (this) {
            try {
                bArrH = (byte[]) this.f66c.get();
                if (bArrH == null) {
                    bArrH = h();
                    this.f66c = new WeakReference(bArrH);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrH;
    }

    protected abstract byte[] h();
}
