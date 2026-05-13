package d0;

import it.tervis.miura.model.RemoteController;

/* JADX INFO: loaded from: classes.dex */
public class h extends g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RemoteController f3488i;

    public h(byte[] bArr) {
        super(bArr);
    }

    @Override // Y.b
    protected void h() {
        if (this.f582b != null) {
            j0.d.a("RemoteControllerStateChangedBroadcast: ");
            j0.d.d(this.f583c);
            int[] iArr = this.f582b;
            this.f3488i = new RemoteController(iArr[4], iArr[5] == 1 ? RemoteController.State.ON : RemoteController.State.OFF, true);
        }
    }

    public RemoteController r() {
        return this.f3488i;
    }
}
