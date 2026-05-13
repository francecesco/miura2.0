package X;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import it.tervis.miura.R;

/* JADX INFO: loaded from: classes.dex */
public class i extends X.b {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private ListView f504i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private V.d f505j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private TextView f506k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private d f507l0 = new d(this, null);

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private int f508m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private int f509n0;

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
            i.this.V1(i2 + 1);
        }
    }

    class b extends Y.f {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c0.c f512a;

            a(c0.c cVar) {
                this.f512a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.f505j0.c(this.f512a.v(), this.f512a.r());
                if (this.f512a.q() != 1) {
                    i.this.f504i0.smoothScrollToPosition(i.this.f505j0.getCount() - 1);
                }
                i.this.f506k0.setText("Totale visualizzati: " + (i.this.f505j0.getCount() - 1) + " (totali: " + this.f512a.r() + ")");
            }
        }

        b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // Y.f
        public void d() {
            i.this.f464d0.D();
            i.this.f464d0.p("Timeout caricamento storico.");
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(c0.c cVar) {
            i.this.f508m0 = cVar.q();
            i.this.f464d0.D();
            i.this.f466f0.post(new a(cVar));
            return true;
        }
    }

    class c extends Y.f {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c0.b f515a;

            a(c0.b bVar) {
                this.f515a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                W.e.Y1(this.f515a.v()).X1(i.this.w(), ".logdetails");
            }
        }

        c(int i2, int i3) {
            super(i2, i3);
        }

        @Override // Y.f
        public void d() {
            i.this.f464d0.D();
            i.this.f464d0.p("Timeout caricamento dettagli.");
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(c0.b bVar) {
            i.this.f464d0.D();
            if (bVar == null) {
                return true;
            }
            i.this.f466f0.post(new a(bVar));
            return true;
        }
    }

    private class d implements View.OnClickListener {
        private d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar = i.this;
            iVar.U1(iVar.f508m0 + 20);
        }

        /* synthetic */ d(i iVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U1(int i2) {
        c0.e eVar = new c0.e(this.f509n0, i2);
        this.f464d0.v("Caricamento storico in corso...");
        K1(eVar, new b(16, 129));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V1(int i2) {
        if (this.f505j0.getItem(i2 - 1).getCategory() != 4) {
        }
        c0.a aVar = new c0.a(this.f509n0, i2);
        this.f464d0.v("Caricamento dettagli in corso...");
        K1(aVar, new c(16, 129));
    }

    @Override // X.b, androidx.fragment.app.Fragment
    public void J0() {
        super.J0();
    }

    public void T1() {
        U1(1);
    }

    @Override // androidx.fragment.app.Fragment
    public void m0(Bundle bundle) {
        super.m0(bundle);
        this.f509n0 = m().getInt(".logType");
        j0.d.a("LogFragment per la categoria " + this.f509n0);
    }

    @Override // androidx.fragment.app.Fragment
    public View q0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_log, viewGroup, false);
        this.f465e0 = viewGroup2;
        this.f506k0 = (TextView) viewGroup2.findViewById(R.id.text_log_events_count);
        this.f504i0 = (ListView) this.f465e0.findViewById(R.id.list_log);
        V.d dVar = new V.d(i(), I1(), null, this.f507l0);
        this.f505j0 = dVar;
        this.f504i0.setAdapter((ListAdapter) dVar);
        this.f504i0.setOnItemClickListener(new a());
        return this.f465e0;
    }
}
