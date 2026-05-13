package E;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static byte[] a(byte[] bArr, int i2, int i3) {
        int i4 = i3 - i2;
        if (i4 >= 0) {
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i2, bArr2, 0, Math.min(bArr.length - i2, i4));
            return bArr2;
        }
        throw new IllegalArgumentException(i2 + " > " + i3);
    }
}
