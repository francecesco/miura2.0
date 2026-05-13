package g0;

import it.tervis.miura.model.Timer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class d extends g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList f3582h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3583i;

    public d(byte[] bArr) {
        super(bArr);
    }

    @Override // Y.b
    protected void h() {
        String str;
        if (this.f582b == null) {
            return;
        }
        j0.d.a("TimerDetailsResponse: ");
        j0.d.d(this.f583c);
        this.f3583i = this.f582b[4];
        this.f3582h = new ArrayList(56);
        int i2 = 5;
        while (true) {
            int[] iArr = this.f582b;
            if (i2 >= iArr.length - 2) {
                return;
            }
            int i3 = iArr[i2];
            int i4 = iArr[i2 + 1];
            if (i3 == 63 || i4 == 63) {
                str = "- transition non programmed.";
            } else {
                str = "- transizione programmata alle " + i3 + ":" + i4;
            }
            j0.d.a(str);
            this.f3582h.add(new Timer.TimerTransition(i3, i4, this.f582b[i2 + 2] == 1 ? Timer.TimerState.ON : Timer.TimerState.OFF));
            i2 += 3;
        }
    }

    public int q() {
        return this.f3583i;
    }

    public ArrayList r() {
        return this.f3582h;
    }
}
