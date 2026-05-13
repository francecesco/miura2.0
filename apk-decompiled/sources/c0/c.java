package c0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c extends f {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ArrayList f3443l;

    public c(byte[] bArr) {
        super(bArr);
    }

    @Override // c0.f, Y.b
    protected void h() {
        if (this.f582b != null) {
            super.h();
            this.f3443l = new ArrayList();
            for (int i2 = 10; i2 < this.f582b.length - 2; i2 += 7) {
                j0.d.a("-- New Event");
                this.f3443l.add(u(i2));
                j0.d.a("---> pivot " + i2);
            }
            j0.d.a("- events parsed: " + this.f3443l.size());
        }
    }

    public ArrayList v() {
        return this.f3443l;
    }
}
