package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.V;

/* JADX INFO: loaded from: classes.dex */
final class l extends h implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, j, View.OnKeyListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f1396v = R$layout.abc_popup_menu_item_layout;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f1398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d f1399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f1400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f1401f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f1402g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f1403h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final V f1404i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private PopupWindow.OnDismissListener f1407l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f1408m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    View f1409n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private j.a f1410o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ViewTreeObserver f1411p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f1412q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f1413r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f1414s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f1416u;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f1405j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f1406k = new b();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f1415t = 0;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!l.this.b() || l.this.f1404i.x()) {
                return;
            }
            View view = l.this.f1409n;
            if (view == null || !view.isShown()) {
                l.this.dismiss();
            } else {
                l.this.f1404i.f();
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = l.this.f1411p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    l.this.f1411p = view.getViewTreeObserver();
                }
                l lVar = l.this;
                lVar.f1411p.removeGlobalOnLayoutListener(lVar.f1405j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public l(Context context, e eVar, View view, int i2, int i3, boolean z2) {
        this.f1397b = context;
        this.f1398c = eVar;
        this.f1400e = z2;
        this.f1399d = new d(eVar, LayoutInflater.from(context), z2, f1396v);
        this.f1402g = i2;
        this.f1403h = i3;
        Resources resources = context.getResources();
        this.f1401f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f1408m = view;
        this.f1404i = new V(context, null, i2, i3);
        eVar.c(this, context);
    }

    private boolean z() {
        View view;
        if (b()) {
            return true;
        }
        if (this.f1412q || (view = this.f1408m) == null) {
            return false;
        }
        this.f1409n = view;
        this.f1404i.G(this);
        this.f1404i.H(this);
        this.f1404i.F(true);
        View view2 = this.f1409n;
        boolean z2 = this.f1411p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f1411p = viewTreeObserver;
        if (z2) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f1405j);
        }
        view2.addOnAttachStateChangeListener(this.f1406k);
        this.f1404i.z(view2);
        this.f1404i.C(this.f1415t);
        if (!this.f1413r) {
            this.f1414s = h.o(this.f1399d, null, this.f1397b, this.f1401f);
            this.f1413r = true;
        }
        this.f1404i.B(this.f1414s);
        this.f1404i.E(2);
        this.f1404i.D(n());
        this.f1404i.f();
        ListView listViewK = this.f1404i.k();
        listViewK.setOnKeyListener(this);
        if (this.f1416u && this.f1398c.x() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1397b).inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewK, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f1398c.x());
            }
            frameLayout.setEnabled(false);
            listViewK.addHeaderView(frameLayout, null, false);
        }
        this.f1404i.o(this.f1399d);
        this.f1404i.f();
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public void a(e eVar, boolean z2) {
        if (eVar != this.f1398c) {
            return;
        }
        dismiss();
        j.a aVar = this.f1410o;
        if (aVar != null) {
            aVar.a(eVar, z2);
        }
    }

    @Override // h.e
    public boolean b() {
        return !this.f1412q && this.f1404i.b();
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean c() {
        return false;
    }

    @Override // h.e
    public void dismiss() {
        if (b()) {
            this.f1404i.dismiss();
        }
    }

    @Override // h.e
    public void f() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f1410o = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean i(m mVar) {
        if (mVar.hasVisibleItems()) {
            i iVar = new i(this.f1397b, mVar, this.f1409n, this.f1400e, this.f1402g, this.f1403h);
            iVar.j(this.f1410o);
            iVar.g(h.x(mVar));
            iVar.i(this.f1407l);
            this.f1407l = null;
            this.f1398c.e(false);
            int iD = this.f1404i.d();
            int iG = this.f1404i.g();
            if ((Gravity.getAbsoluteGravity(this.f1415t, this.f1408m.getLayoutDirection()) & 7) == 5) {
                iD += this.f1408m.getWidth();
            }
            if (iVar.n(iD, iG)) {
                j.a aVar = this.f1410o;
                if (aVar == null) {
                    return true;
                }
                aVar.b(mVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(boolean z2) {
        this.f1413r = false;
        d dVar = this.f1399d;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    @Override // h.e
    public ListView k() {
        return this.f1404i.k();
    }

    @Override // androidx.appcompat.view.menu.h
    public void l(e eVar) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1412q = true;
        this.f1398c.close();
        ViewTreeObserver viewTreeObserver = this.f1411p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1411p = this.f1409n.getViewTreeObserver();
            }
            this.f1411p.removeGlobalOnLayoutListener(this.f1405j);
            this.f1411p = null;
        }
        this.f1409n.removeOnAttachStateChangeListener(this.f1406k);
        PopupWindow.OnDismissListener onDismissListener = this.f1407l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.h
    public void p(View view) {
        this.f1408m = view;
    }

    @Override // androidx.appcompat.view.menu.h
    public void r(boolean z2) {
        this.f1399d.d(z2);
    }

    @Override // androidx.appcompat.view.menu.h
    public void s(int i2) {
        this.f1415t = i2;
    }

    @Override // androidx.appcompat.view.menu.h
    public void t(int i2) {
        this.f1404i.c(i2);
    }

    @Override // androidx.appcompat.view.menu.h
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.f1407l = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.h
    public void v(boolean z2) {
        this.f1416u = z2;
    }

    @Override // androidx.appcompat.view.menu.h
    public void w(int i2) {
        this.f1404i.n(i2);
    }
}
