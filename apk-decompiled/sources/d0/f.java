package d0;

import it.tervis.miura.model.RemoteController;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class f extends g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3484i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3485j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ArrayList f3486k;

    public f(byte[] bArr) {
        super(bArr);
    }

    @Override // Y.b
    protected void h() {
        if (this.f582b == null) {
            return;
        }
        j0.d.a("RemoteControllerListResponse: ");
        j0.d.d(this.f583c);
        int[] iArr = this.f582b;
        this.f3484i = iArr[4];
        this.f3487h = iArr[5];
        this.f3485j = iArr[6];
        j0.d.a("- filter: " + this.f3484i);
        j0.d.a("- offset: " + this.f3487h);
        j0.d.a("- remote controller count: " + this.f3485j);
        this.f3486k = new ArrayList();
        int i2 = 7;
        while (true) {
            int[] iArr2 = this.f582b;
            if (i2 >= iArr2.length - 2) {
                return;
            }
            int i3 = iArr2[i2];
            boolean z2 = true;
            RemoteController.State state = iArr2[i2 + 1] == 1 ? RemoteController.State.ON : RemoteController.State.OFF;
            if (iArr2[i2 + 2] != 1) {
                z2 = false;
            }
            j0.d.a("Creating remote controller");
            this.f3486k.add(new RemoteController(i3, state, z2));
            i2 += 3;
        }
    }

    public ArrayList r() {
        return this.f3486k;
    }

    public boolean s() {
        return this.f3485j == 0 || this.f3486k.size() + this.f3487h == this.f3485j;
    }
}
