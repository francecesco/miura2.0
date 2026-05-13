package X;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import it.tervis.miura.MiuraService;
import it.tervis.miura.R;
import it.tervis.miura.model.Group;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class h extends X.b {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private ListView f493i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private V.k f494j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private Group f495k0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private MiuraService.n f497m0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private HashMap f496l0 = new HashMap();

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private d f498n0 = new d(this, null);

    class a extends MiuraService.n {
        a() {
        }

        @Override // it.tervis.miura.MiuraService.n
        public void c(Y.b bVar) {
            if (bVar instanceof i0.g) {
                i0.g gVar = (i0.g) bVar;
                h.this.f496l0.put(Integer.valueOf(gVar.q()), gVar);
            }
        }
    }

    class b extends Y.f {
        b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // Y.f
        public void d() {
            j0.d.a("Timeout!");
            h.this.R1();
            if (h.this.X()) {
                h.this.f464d0.p("Timeout!");
            }
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(h0.g gVar) {
            if (h.this.f496l0.size() != h.this.f495k0.getZonesList().size()) {
                return false;
            }
            j0.d.a("Dovrei aver ricevuto tutti i dati!");
            h.this.R1();
            return true;
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.X()) {
                h.this.i().setProgressBarIndeterminateVisibility(false);
                h.this.f494j0.c(h.this.f496l0);
            }
        }
    }

    private class d implements View.OnClickListener {

        class a extends Y.f {
            a(int i2, int i3) {
                super(i2, i3);
            }

            @Override // Y.f
            public void d() {
                h.this.f464d0.D();
                h.this.f464d0.p("Timeout!");
            }

            @Override // Y.f
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public boolean c(i0.b bVar) {
                h.this.f464d0.D();
                ((it.tervis.miura.a) h.this.i()).s(new Z.i());
                return true;
            }
        }

        private d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iIntValue = ((Integer) view.getTag()).intValue();
            h.this.K1(((CheckBox) view).isChecked() ? new i0.a(iIntValue, 1, 1, 0) : new i0.a(iIntValue, 1, 0, 0), new a(7, 131));
        }

        /* synthetic */ d(h hVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R1() {
        this.f466f0.post(new c());
    }

    @Override // androidx.fragment.app.Fragment
    public void K0() {
        ((it.tervis.miura.a) i()).A(this.f497m0);
        super.K0();
    }

    public void Q1() {
        this.f495k0 = I1().mNormalizedAreas.get(m().getInt(".area")).mNormalizedGroups.get(m().getInt(".group"));
        V.k kVar = new V.k(i(), I1(), this.f495k0, this.f498n0);
        this.f494j0 = kVar;
        this.f493i0.setAdapter((ListAdapter) kVar);
        if (this.f496l0.isEmpty()) {
            this.f497m0 = new a();
            ((it.tervis.miura.a) i()).o(this.f497m0);
            i().setProgressBarIndeterminateVisibility(true);
            Iterator<Integer> it2 = this.f495k0.getZonesList().iterator();
            while (it2.hasNext()) {
                J1(new i0.f(it2.next().intValue()));
            }
            K1(new h0.f(), new b(1, 130));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View q0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_group, viewGroup, false);
        this.f465e0 = viewGroup2;
        this.f493i0 = (ListView) viewGroup2.findViewById(R.id.list_zones);
        return this.f465e0;
    }
}
