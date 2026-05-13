package b0;

import it.tervis.miura.model.Zone;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b extends a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ArrayList f3434l;

    public b(byte[] bArr) {
        super(bArr);
        this.f3434l = new ArrayList();
    }

    @Override // Y.b
    protected void h() {
        int[] iArr = this.f582b;
        if (iArr == null) {
            return;
        }
        this.f3430h = iArr[4];
        this.f3431i = iArr[5];
        this.f3432j = iArr[6];
        int i2 = 7;
        while (true) {
            int i3 = i2 + 3;
            int[] iArr2 = this.f582b;
            if (i3 >= iArr2.length) {
                return;
            }
            Zone zone = new Zone(iArr2[i2]);
            int i4 = i2 + 2;
            zone.setActive(this.f582b[i2 + 1] == 1);
            Zone.Status status = Zone.Status.STANDBY;
            i2 += 3;
            int i5 = this.f582b[i4];
            zone.setStatus(i5 != 0 ? i5 != 1 ? i5 != 2 ? i5 != 3 ? Zone.Status.UNKNOWN : Zone.Status.FAULT : Zone.Status.MANOMISSIONE : Zone.Status.ALARM : Zone.Status.STANDBY);
            this.f3434l.add(zone);
        }
    }

    public ArrayList r() {
        return this.f3434l;
    }
}
