package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.Window;
import androidx.appcompat.view.menu.j;

/* JADX INFO: loaded from: classes.dex */
public interface M {
    void a(Menu menu, j.a aVar);

    boolean b();

    boolean c();

    void collapseActionView();

    boolean d();

    boolean e();

    void f();

    boolean g();

    CharSequence getTitle();

    void h();

    void i(CharSequence charSequence);

    int j();

    void k(int i2);

    void l(int i2);

    void m(Z z2);

    void n(int i2);

    void o(boolean z2);

    Context p();

    int q();

    androidx.core.view.U r(int i2, long j2);

    void s();

    void setIcon(int i2);

    void setIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    boolean t();

    void u();

    void v(Drawable drawable);

    void w(boolean z2);

    void x(int i2);
}
