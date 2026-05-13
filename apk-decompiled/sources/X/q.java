package X;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import it.tervis.miura.MiuraService;
import it.tervis.miura.R;
import it.tervis.miura.activity.TimerDetailsActivity;
import it.tervis.miura.model.Timer;

/* JADX INFO: loaded from: classes.dex */
public class q extends X.b {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private MiuraService.n f568i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private ListView f569j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private V.h f570k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private e f571l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private d f572m0;

    class a extends Y.f {

        /* JADX INFO: renamed from: X.q$a$a, reason: collision with other inner class name */
        class RunnableC0014a implements Runnable {
            RunnableC0014a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                q.this.f570k0.notifyDataSetChanged();
            }
        }

        a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // Y.f
        public void d() {
            q.this.f464d0.D();
            q.this.f464d0.p("Timeout caricamento lista!");
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(g0.k kVar) {
            q.this.f464d0.D();
            q.this.f466f0.post(new RunnableC0014a());
            return true;
        }
    }

    class b extends Y.f {
        b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // Y.f
        public void d() {
            q.this.f464d0.D();
            q.this.f464d0.p("Timeout!");
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(g0.b bVar) {
            j0.d.a("Cambio stato eseguito!");
            q.this.f464d0.D();
            return true;
        }
    }

    class c extends MiuraService.n {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                q.this.f570k0.notifyDataSetChanged();
            }
        }

        c() {
        }

        @Override // it.tervis.miura.MiuraService.n
        public void c(Y.b bVar) {
            if (bVar instanceof g0.h) {
                j0.d.a("Ricevuto messaggio broadcast timer!");
                q.this.f466f0.post(new a());
            }
        }
    }

    private class d implements View.OnClickListener {
        private d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iIntValue = ((Integer) view.getTag()).intValue();
            Intent intent = new Intent(q.this.i(), (Class<?>) TimerDetailsActivity.class);
            intent.putExtra(".timerID", q.this.I1().getTimers().get(iIntValue).getID());
            q.this.D1(intent);
        }

        /* synthetic */ d(q qVar, a aVar) {
            this();
        }
    }

    private class e extends j0.a {
        private e() {
        }

        @Override // j0.a
        protected void a(CompoundButton compoundButton) {
            q.this.O1(q.this.I1().getTimers().get(((Integer) compoundButton.getTag()).intValue()));
        }

        /* synthetic */ e(q qVar, a aVar) {
            this();
        }
    }

    public q() {
        a aVar = null;
        this.f571l0 = new e(this, aVar);
        this.f572m0 = new d(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1(Timer timer) {
        K1(new g0.a(timer.getID(), !timer.isEnabled()), new b(18, 129));
    }

    private void P1() {
        K1(new g0.j(), new a(18, 136));
    }

    private void Q1() {
        this.f568i0 = new c();
        ((it.tervis.miura.a) i()).o(this.f568i0);
    }

    @Override // X.b, androidx.fragment.app.Fragment
    public void J0() {
        super.J0();
        if (!I1().hasTimers()) {
            P1();
        }
        Q1();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0() {
        super.K0();
        if (this.f568i0 != null) {
            ((it.tervis.miura.a) i()).A(this.f568i0);
            this.f568i0 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View q0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_activation, viewGroup, false);
        this.f465e0 = viewGroup2;
        this.f569j0 = (ListView) viewGroup2.findViewById(R.id.list_timers);
        V.h hVar = new V.h(i(), I1(), this.f571l0, this.f572m0);
        this.f570k0 = hVar;
        this.f569j0.setAdapter((ListAdapter) hVar);
        return this.f465e0;
    }
}
