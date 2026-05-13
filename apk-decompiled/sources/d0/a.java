package d0;

import it.tervis.miura.model.RemoteController;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class a extends g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RemoteController f3482i;

    public a(RemoteController remoteController) {
        this.f3482i = remoteController;
    }

    @Override // d0.g, Y.b
    protected void i() {
        ByteArrayOutputStream byteArrayOutputStream;
        int i2;
        super.i();
        this.f581a.write(5);
        this.f581a.write(this.f3482i.getID());
        if (this.f3482i.getState().equals(RemoteController.State.ON)) {
            byteArrayOutputStream = this.f581a;
            i2 = 0;
        } else {
            byteArrayOutputStream = this.f581a;
            i2 = 1;
        }
        byteArrayOutputStream.write(i2);
        this.f581a.write(this.f3487h);
    }
}
