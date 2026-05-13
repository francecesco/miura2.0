package Z;

import it.tervis.miura.model.NPI;

/* JADX INFO: loaded from: classes.dex */
public class n extends m {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private byte f645o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private byte f646p;

    public n(int i2, int i3, int i4) {
        super(i2, i3);
        this.f645o = (byte) i4;
        this.f646p = (byte) 1;
    }

    @Override // Z.c, Y.b
    protected void i() {
        super.i();
        this.f581a.write(3);
        this.f584d = true;
        p(this.f644n);
        this.f581a.write(this.f643m);
        if (this.f643m < NPI.NPI_PERIPHERALS_CAUSES[0]) {
            this.f581a.write(this.f645o);
            this.f581a.write(this.f646p);
        }
    }
}
