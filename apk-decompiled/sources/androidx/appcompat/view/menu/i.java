package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.R$dimen;
import androidx.appcompat.view.menu.j;
import androidx.core.view.AbstractC0154s;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f1384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f1385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f1386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f1387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f1388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1389g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1390h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private j.a f1391i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private h f1392j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PopupWindow.OnDismissListener f1393k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final PopupWindow.OnDismissListener f1394l;

    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            i.this.e();
        }
    }

    public i(Context context, e eVar, View view, boolean z2, int i2) {
        this(context, eVar, view, z2, i2, 0);
    }

    private h a() {
        Display defaultDisplay = ((WindowManager) this.f1383a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        h bVar = Math.min(point.x, point.y) >= this.f1383a.getResources().getDimensionPixelSize(R$dimen.abc_cascading_menus_min_smallest_width) ? new b(this.f1383a, this.f1388f, this.f1386d, this.f1387e, this.f1385c) : new l(this.f1383a, this.f1384b, this.f1388f, this.f1386d, this.f1387e, this.f1385c);
        bVar.l(this.f1384b);
        bVar.u(this.f1394l);
        bVar.p(this.f1388f);
        bVar.h(this.f1391i);
        bVar.r(this.f1390h);
        bVar.s(this.f1389g);
        return bVar;
    }

    private void l(int i2, int i3, boolean z2, boolean z3) {
        h hVarC = c();
        hVarC.v(z3);
        if (z2) {
            if ((AbstractC0154s.a(this.f1389g, this.f1388f.getLayoutDirection()) & 7) == 5) {
                i2 -= this.f1388f.getWidth();
            }
            hVarC.t(i2);
            hVarC.w(i3);
            int i4 = (int) ((this.f1383a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            hVarC.q(new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4));
        }
        hVarC.f();
    }

    public void b() {
        if (d()) {
            this.f1392j.dismiss();
        }
    }

    public h c() {
        if (this.f1392j == null) {
            this.f1392j = a();
        }
        return this.f1392j;
    }

    public boolean d() {
        h hVar = this.f1392j;
        return hVar != null && hVar.b();
    }

    protected void e() {
        this.f1392j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f1393k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f1388f = view;
    }

    public void g(boolean z2) {
        this.f1390h = z2;
        h hVar = this.f1392j;
        if (hVar != null) {
            hVar.r(z2);
        }
    }

    public void h(int i2) {
        this.f1389g = i2;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f1393k = onDismissListener;
    }

    public void j(j.a aVar) {
        this.f1391i = aVar;
        h hVar = this.f1392j;
        if (hVar != null) {
            hVar.h(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f1388f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i2, int i3) {
        if (d()) {
            return true;
        }
        if (this.f1388f == null) {
            return false;
        }
        l(i2, i3, true, true);
        return true;
    }

    public i(Context context, e eVar, View view, boolean z2, int i2, int i3) {
        this.f1389g = 8388611;
        this.f1394l = new a();
        this.f1383a = context;
        this.f1384b = eVar;
        this.f1388f = view;
        this.f1385c = z2;
        this.f1386d = i2;
        this.f1387e = i3;
    }
}
