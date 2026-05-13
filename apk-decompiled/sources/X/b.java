package X;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import it.tervis.miura.model.Installation;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends Fragment {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    protected g f464d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    protected View f465e0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    protected LayoutInflater f467g0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    protected final int f463c0 = 120000;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    protected Handler f466f0 = new Handler();

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    protected Runnable f468h0 = new a();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.X()) {
                ((it.tervis.miura.a) b.this.i()).J();
            }
        }
    }

    protected Installation I1() {
        return ((it.tervis.miura.a) i()).z();
    }

    @Override // androidx.fragment.app.Fragment
    public void J0() {
        super.J0();
        this.f467g0 = i().getLayoutInflater();
    }

    public void J1(Y.b bVar) {
        ((it.tervis.miura.a) i()).s(bVar);
    }

    public void K1(Y.b bVar, Y.f fVar) {
        ((it.tervis.miura.a) i()).l(bVar, fVar);
    }

    protected void L1() {
        this.f466f0.postDelayed(this.f468h0, 120000L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void j0(Context context) {
        super.j0(context);
        this.f464d0 = (g) context;
    }
}
