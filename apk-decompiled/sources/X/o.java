package X;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import it.tervis.miura.MiuraService;
import it.tervis.miura.R;

/* JADX INFO: loaded from: classes.dex */
public class o extends b {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private TextView f546i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private TextView f547j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private e0.c f548k0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private ImageView f550m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private ImageView f551n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private ImageView f552o0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private final int[] f549l0 = {R.drawable.rssi_0, R.drawable.rssi_1, R.drawable.rssi_2, R.drawable.rssi_3, R.drawable.rssi_4};

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private MiuraService.n f553p0 = new a();

    class a extends MiuraService.n {

        /* JADX INFO: renamed from: X.o$a$a, reason: collision with other inner class name */
        class RunnableC0013a implements Runnable {
            RunnableC0013a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.P1();
            }
        }

        a() {
        }

        @Override // it.tervis.miura.MiuraService.n
        public void c(Y.b bVar) {
            if (bVar instanceof e0.c) {
                j0.d.a("*********************** UI STANDBY INFO AGGIORNATO!");
                o.this.f548k0 = (e0.c) bVar;
                j0.d.a("RSSI: " + o.this.f548k0.s());
                o.this.f466f0.post(new RunnableC0013a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void P1() {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: X.o.P1():void");
    }

    @Override // X.b, androidx.fragment.app.Fragment
    public void J0() {
        ((it.tervis.miura.a) i()).o(this.f553p0);
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0() {
        ((it.tervis.miura.a) i()).A(this.f553p0);
        super.K0();
    }

    @Override // androidx.fragment.app.Fragment
    public View q0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_standby_info, viewGroup, false);
        this.f465e0 = viewGroup2;
        this.f551n0 = (ImageView) viewGroup2.findViewById(R.id.image_power);
        this.f550m0 = (ImageView) this.f465e0.findViewById(R.id.image_rssi);
        this.f552o0 = (ImageView) this.f465e0.findViewById(R.id.image_connection);
        this.f546i0 = (TextView) this.f465e0.findViewById(R.id.text_operator);
        this.f547j0 = (TextView) this.f465e0.findViewById(R.id.text_credit);
        return this.f465e0;
    }
}
