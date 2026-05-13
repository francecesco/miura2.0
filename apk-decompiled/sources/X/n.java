package X;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import it.tervis.miura.MiuraService;
import it.tervis.miura.R;
import it.tervis.miura.model.RemoteController;

/* JADX INFO: loaded from: classes.dex */
public class n extends X.b {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private MiuraService.n f534i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private V.g f535j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private e f536k0;

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.f464d0.D();
            if (n.this.I1().getRemoteControllersCount() == 0) {
                ((TextView) n.this.f465e0.findViewById(R.id.empty)).setText("Non ci sono telecomandi abilitati per questo utente.");
            }
            n.this.f535j0.notifyDataSetChanged();
        }
    }

    class c extends MiuraService.n {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                n.this.f535j0.notifyDataSetChanged();
            }
        }

        c() {
        }

        @Override // it.tervis.miura.MiuraService.n
        public void c(Y.b bVar) {
            if (bVar instanceof d0.h) {
                j0.d.a("Ricevuto messaggio broadcast telecomandi!");
                n.this.f466f0.post(new a());
            }
        }
    }

    class d extends Y.f {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                n.this.f464d0.D();
                n.this.f464d0.p("Operazione completata");
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                n.this.f464d0.D();
                n.this.f464d0.p("Timeout!");
            }
        }

        d(int i2, int i3) {
            super(i2, i3);
        }

        @Override // Y.f
        public void d() {
            n.this.f466f0.post(new b());
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(d0.b bVar) {
            n.this.f466f0.post(new a());
            return true;
        }
    }

    private class e extends j0.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f544b;

        private e() {
            this.f544b = false;
        }

        @Override // j0.a
        protected void a(CompoundButton compoundButton) {
            n nVar = n.this;
            nVar.P1(nVar.f535j0.getItem(((Integer) compoundButton.getTag()).intValue()), null);
        }

        /* synthetic */ e(n nVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P1(RemoteController remoteController, CompoundButton compoundButton) {
        K1(new d0.a(remoteController), new d(8, 133));
    }

    private void R1() {
        this.f534i0 = new c();
        ((it.tervis.miura.a) i()).o(this.f534i0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S1() {
        this.f466f0.post(new b());
    }

    @Override // X.b, androidx.fragment.app.Fragment
    public void J0() {
        super.J0();
        R1();
        Q1();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0() {
        super.K0();
        if (this.f534i0 != null) {
            ((it.tervis.miura.a) i()).A(this.f534i0);
            this.f534i0 = null;
        }
    }

    public void Q1() {
        if (I1().getRemoteControllers().size() != 0) {
            j0.d.a("Ho gia' i telecomandi!!!!");
            return;
        }
        this.f464d0.v("Caricamento in corso...");
        J1(new d0.c());
        K1(new d0.e(), new a(8, 134));
    }

    @Override // androidx.fragment.app.Fragment
    public View q0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_remote_controller, viewGroup, false);
        this.f465e0 = viewGroup2;
        ListView listView = (ListView) viewGroup2.findViewById(R.id.list_remote_controllers);
        listView.setEmptyView(this.f465e0.findViewById(R.id.empty));
        this.f536k0 = new e(this, null);
        V.g gVar = new V.g(i(), I1(), this.f536k0);
        this.f535j0 = gVar;
        listView.setAdapter((ListAdapter) gVar);
        return this.f465e0;
    }

    class a extends Y.f {
        a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(d0.f fVar) {
            if (fVar.s()) {
                n.this.S1();
                return true;
            }
            j0.d.a("Sending a new request");
            n.this.K1(new d0.e(fVar.q() + fVar.r().size()), this);
            return true;
        }

        @Override // Y.f
        public void d() {
        }
    }
}
