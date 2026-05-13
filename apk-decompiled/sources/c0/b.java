package c0;

import it.tervis.miura.model.LogEvent;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class b extends f {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private LogEvent f3442l;

    public b(byte[] bArr) {
        super(bArr);
    }

    @Override // c0.f, Y.b
    protected void h() {
        if (this.f582b != null) {
            j0.d.a("Parsing LogDetailsResponse...");
            super.h();
            this.f3442l = u(10);
            Arrays.copyOfRange(this.f582b, 7, 42);
            this.f3442l.setText(new String(Arrays.copyOfRange(this.f583c, 42, r0.length - 3)));
        }
    }

    public LogEvent v() {
        return this.f3442l;
    }
}
