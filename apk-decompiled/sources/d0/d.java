package d0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class d extends g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList f3483i;

    public d(byte[] bArr) {
        super(bArr);
    }

    @Override // Y.b
    protected void h() {
        if (this.f582b == null) {
            return;
        }
        j0.d.a("RemoteControllerEnabledListResponse: ");
        j0.d.d(this.f583c);
        this.f3487h = this.f582b[4];
        this.f3483i = new ArrayList();
        int i2 = 5;
        while (true) {
            int[] iArr = this.f582b;
            if (i2 >= iArr.length - 2) {
                return;
            }
            this.f3483i.add(Integer.valueOf(iArr[i2]));
            i2++;
        }
    }

    public ArrayList r() {
        return this.f3483i;
    }
}
