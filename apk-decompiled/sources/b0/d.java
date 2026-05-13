package b0;

import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class d extends a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private HashSet f3435l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ArrayList f3436m;

    public d(byte[] bArr) {
        super(bArr);
    }

    @Override // Y.b
    protected void h() {
        int[] iArr = this.f582b;
        if (iArr != null) {
            this.f3430h = iArr[4];
            this.f3433k = iArr[5];
            int length = iArr.length - 6;
            if (t()) {
                this.f3435l = new HashSet();
                this.f3436m = new ArrayList();
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = this.f582b[i2 + 6];
                    for (int i4 = 0; i4 < 8; i4++) {
                        int i5 = (i2 * 8) + i4;
                        if ((i3 & 1) != 0 && (i5 < 96 || ((i5 >= 100 && i5 < 196) || (i5 >= 200 && i5 < 254)))) {
                            this.f3435l.add(Integer.valueOf(i5));
                            this.f3436m.add(Integer.valueOf(i5));
                        }
                        i3 >>= 1;
                    }
                }
            }
        }
    }

    public ArrayList r() {
        return this.f3436m;
    }

    public HashSet s() {
        return this.f3435l;
    }

    public boolean t() {
        return this.f3433k == 255;
    }
}
