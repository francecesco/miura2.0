package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f1151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1152b;

    public interface a {
        boolean a(b bVar, Menu menu);

        boolean b(b bVar, MenuItem menuItem);

        boolean c(b bVar, Menu menu);

        void d(b bVar);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f1151a;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f1152b;
    }

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View view);

    public abstract void n(int i2);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f1151a = obj;
    }

    public abstract void q(int i2);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z2) {
        this.f1152b = z2;
    }
}
