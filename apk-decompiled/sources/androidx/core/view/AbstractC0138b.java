package androidx.core.view;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: renamed from: androidx.core.view.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0138b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f2348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC0038b f2349c;

    /* JADX INFO: renamed from: androidx.core.view.b$a */
    public interface a {
    }

    /* JADX INFO: renamed from: androidx.core.view.b$b, reason: collision with other inner class name */
    public interface InterfaceC0038b {
        void onActionProviderVisibilityChanged(boolean z2);
    }

    public AbstractC0138b(Context context) {
        this.f2347a = context;
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract View c(MenuItem menuItem);

    public abstract boolean d();

    public abstract void e(SubMenu subMenu);

    public abstract boolean f();

    public void g() {
        this.f2349c = null;
        this.f2348b = null;
    }

    public void h(a aVar) {
        this.f2348b = aVar;
    }

    public abstract void i(InterfaceC0038b interfaceC0038b);
}
