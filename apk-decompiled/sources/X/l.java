package X;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import it.tervis.miura.Miura;
import it.tervis.miura.MiuraService;
import it.tervis.miura.R;
import it.tervis.miura.activity.InfoActivity;
import it.tervis.miura.activity.VideoActivity;

/* JADX INFO: loaded from: classes.dex */
public class l extends X.b {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private ListView f523i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private V.f f524j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private TextView f525k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private Button f526l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private MiuraService.n f527m0 = new a();

    class a extends MiuraService.n {

        /* JADX INFO: renamed from: X.l$a$a, reason: collision with other inner class name */
        class RunnableC0012a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Y.b f529a;

            RunnableC0012a(Y.b bVar) {
                this.f529a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                l.this.f525k0.setText(((h0.c) this.f529a).r());
            }
        }

        a() {
        }

        @Override // it.tervis.miura.MiuraService.n
        public void c(Y.b bVar) {
            if (bVar instanceof h0.c) {
                l.this.f466f0.post(new RunnableC0012a(bVar));
            }
        }
    }

    class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
            if (i2 == 0) {
                l.this.R1().p1();
                l.this.R1().F1();
                return;
            }
            if (i2 == 1) {
                l.this.T1();
                return;
            }
            if (i2 == 2) {
                l.this.U1();
                return;
            }
            if (i2 == 3) {
                l.this.S1();
                return;
            }
            if (i2 == 4) {
                l.this.R1().p1();
                l.this.D1(new Intent(l.this.i(), (Class<?>) InfoActivity.class));
            } else {
                if (i2 != 5) {
                    return;
                }
                l.this.R1().p1();
                l.this.D1(new Intent(l.this.i(), (Class<?>) VideoActivity.class));
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((Miura) l.this.i()).o1(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Miura R1() {
        return (Miura) i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S1() {
        R1().p1();
        R1().D1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1() {
        j0.d.a("switchToRemoteControllers");
        if (!I1().canUseRemoteControllers()) {
            this.f464d0.p("Utente non abilitato all'uso dei telecomandi.");
        } else {
            R1().p1();
            R1().E1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U1() {
        if (!I1().canUseTimers()) {
            this.f464d0.p("Utente non abilitato all'uso dei timer.");
        } else {
            R1().p1();
            R1().C1();
        }
    }

    @Override // X.b, androidx.fragment.app.Fragment
    public void J0() {
        super.J0();
        ((it.tervis.miura.a) i()).o(this.f527m0);
    }

    @Override // androidx.fragment.app.Fragment
    public void K0() {
        super.K0();
        ((it.tervis.miura.a) i()).A(this.f527m0);
    }

    @Override // androidx.fragment.app.Fragment
    public View q0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_menu, viewGroup, false);
        this.f465e0 = viewGroup2;
        this.f525k0 = (TextView) viewGroup2.findViewById(R.id.text_username);
        this.f523i0 = (ListView) this.f465e0.findViewById(R.id.list_menu);
        V.f fVar = new V.f(i(), I1());
        this.f524j0 = fVar;
        this.f523i0.setAdapter((ListAdapter) fVar);
        this.f523i0.setOnItemClickListener(new b());
        Button button = (Button) this.f465e0.findViewById(R.id.button_disconnect);
        this.f526l0 = button;
        button.setOnClickListener(new c());
        return this.f465e0;
    }
}
