package X;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import it.tervis.miura.R;
import it.tervis.miura.model.Timer;

/* JADX INFO: loaded from: classes.dex */
public class p extends X.b {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private GridView f556i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private GridView f557j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private V.i f558k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private V.j f559l0;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Timer f560a;

        a(Timer timer) {
            this.f560a = timer;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.f558k0.c(this.f560a);
            p.this.f559l0.d(this.f560a);
        }
    }

    class b extends Y.f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Timer f562c;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                p.this.f558k0.c(b.this.f562c);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i2, int i3, Timer timer) {
            super(i2, i3);
            this.f562c = timer;
        }

        @Override // Y.f
        public void d() {
            p.this.f464d0.D();
            p.this.f464d0.p("Timeout caricamento programmazione");
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(g0.d dVar) {
            p.this.f464d0.D();
            p.this.f466f0.post(new a());
            return true;
        }
    }

    private Timer O1() {
        return I1().getTimer(m().getInt(".timerID"));
    }

    public void P1() {
        Timer timerO1 = O1();
        if (timerO1.hasTransitions()) {
            this.f466f0.post(new a(timerO1));
            return;
        }
        this.f464d0.v("Caricamento programmazione timer");
        g0.c cVar = new g0.c(m().getInt(".timerID"));
        j0.d.a("Getting details for timer " + timerO1.getID() + "(argument received: " + m().getInt(".timerID") + ")");
        K1(cVar, new b(18, 137, timerO1));
        Q1();
    }

    public void Q1() {
        Timer timerO1 = O1();
        K1(new g0.e(timerO1.getID()), new c(18, 128, timerO1));
    }

    @Override // androidx.fragment.app.Fragment
    public View q0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_timer_details, viewGroup, false);
        this.f465e0 = viewGroup2;
        this.f556i0 = (GridView) viewGroup2.findViewById(R.id.grid_timer_details);
        V.i iVar = new V.i(i(), I1());
        this.f558k0 = iVar;
        this.f556i0.setAdapter((ListAdapter) iVar);
        this.f557j0 = (GridView) this.f465e0.findViewById(R.id.grid_timer_groups);
        V.j jVar = new V.j(i(), I1());
        this.f559l0 = jVar;
        this.f557j0.setAdapter((ListAdapter) jVar);
        return this.f465e0;
    }

    class c extends Y.f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Timer f565c;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                p.this.f559l0.d(c.this.f565c);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i2, int i3, Timer timer) {
            super(i2, i3);
            this.f565c = timer;
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(g0.f fVar) {
            p.this.f466f0.post(new a());
            return true;
        }

        @Override // Y.f
        public void d() {
        }
    }
}
