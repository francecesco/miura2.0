package G;

import android.os.RemoteException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
abstract class r extends K.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f63b;

    protected r(byte[] bArr) {
        K.e.a(bArr.length == 25);
        this.f63b = Arrays.hashCode(bArr);
    }

    protected static byte[] g(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // K.h
    public final Q.a a() {
        return Q.b.g(f());
    }

    @Override // K.h
    public final int c() {
        return hashCode();
    }

    public boolean equals(Object obj) {
        Q.a aVarA;
        if (obj != null && (obj instanceof K.h)) {
            try {
                K.h hVar = (K.h) obj;
                if (hVar.c() == hashCode() && (aVarA = hVar.a()) != null) {
                    return Arrays.equals(f(), (byte[]) Q.b.f(aVarA));
                }
                return false;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    abstract byte[] f();

    public int hashCode() {
        return this.f63b;
    }
}
