package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.U;
import androidx.appcompat.widget.V;
import androidx.core.view.AbstractC0154s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class b extends h implements j, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final int f1265B = R$layout.abc_cascading_menu_item_layout;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    boolean f1266A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f1268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f1269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f1270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f1271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Handler f1272g;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private View f1280o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    View f1281p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f1283r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f1284s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f1285t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f1286u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f1288w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private j.a f1289x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    ViewTreeObserver f1290y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private PopupWindow.OnDismissListener f1291z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f1273h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final List f1274i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f1275j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f1276k = new ViewOnAttachStateChangeListenerC0025b();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final U f1277l = new c();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f1278m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f1279n = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f1287v = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f1282q = D();

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!b.this.b() || b.this.f1274i.size() <= 0 || ((d) b.this.f1274i.get(0)).f1299a.x()) {
                return;
            }
            View view = b.this.f1281p;
            if (view == null || !view.isShown()) {
                b.this.dismiss();
                return;
            }
            Iterator it2 = b.this.f1274i.iterator();
            while (it2.hasNext()) {
                ((d) it2.next()).f1299a.f();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.view.menu.b$b, reason: collision with other inner class name */
    class ViewOnAttachStateChangeListenerC0025b implements View.OnAttachStateChangeListener {
        ViewOnAttachStateChangeListenerC0025b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.f1290y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.f1290y = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.f1290y.removeGlobalOnLayoutListener(bVar.f1275j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    class c implements U {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f1295a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ MenuItem f1296b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ e f1297c;

            a(d dVar, MenuItem menuItem, e eVar) {
                this.f1295a = dVar;
                this.f1296b = menuItem;
                this.f1297c = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f1295a;
                if (dVar != null) {
                    b.this.f1266A = true;
                    dVar.f1300b.e(false);
                    b.this.f1266A = false;
                }
                if (this.f1296b.isEnabled() && this.f1296b.hasSubMenu()) {
                    this.f1297c.M(this.f1296b, 4);
                }
            }
        }

        c() {
        }

        @Override // androidx.appcompat.widget.U
        public void a(e eVar, MenuItem menuItem) {
            b.this.f1272g.removeCallbacksAndMessages(null);
            int size = b.this.f1274i.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (eVar == ((d) b.this.f1274i.get(i2)).f1300b) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return;
            }
            int i3 = i2 + 1;
            b.this.f1272g.postAtTime(new a(i3 < b.this.f1274i.size() ? (d) b.this.f1274i.get(i3) : null, menuItem, eVar), eVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.U
        public void h(e eVar, MenuItem menuItem) {
            b.this.f1272g.removeCallbacksAndMessages(eVar);
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final V f1299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f1300b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1301c;

        public d(V v2, e eVar, int i2) {
            this.f1299a = v2;
            this.f1300b = eVar;
            this.f1301c = i2;
        }

        public ListView a() {
            return this.f1299a.k();
        }
    }

    public b(Context context, View view, int i2, int i3, boolean z2) {
        this.f1267b = context;
        this.f1280o = view;
        this.f1269d = i2;
        this.f1270e = i3;
        this.f1271f = z2;
        Resources resources = context.getResources();
        this.f1268c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f1272g = new Handler();
    }

    private int A(e eVar) {
        int size = this.f1274i.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (eVar == ((d) this.f1274i.get(i2)).f1300b) {
                return i2;
            }
        }
        return -1;
    }

    private MenuItem B(e eVar, e eVar2) {
        int size = eVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = eVar.getItem(i2);
            if (item.hasSubMenu() && eVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View C(d dVar, e eVar) {
        androidx.appcompat.view.menu.d dVar2;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemB = B(dVar.f1300b, eVar);
        if (menuItemB == null) {
            return null;
        }
        ListView listViewA = dVar.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            dVar2 = (androidx.appcompat.view.menu.d) headerViewListAdapter.getWrappedAdapter();
        } else {
            dVar2 = (androidx.appcompat.view.menu.d) adapter;
            headersCount = 0;
        }
        int count = dVar2.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            }
            if (menuItemB == dVar2.getItem(i2)) {
                break;
            }
            i2++;
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int D() {
        return this.f1280o.getLayoutDirection() == 1 ? 0 : 1;
    }

    private int E(int i2) {
        List list = this.f1274i;
        ListView listViewA = ((d) list.get(list.size() - 1)).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1281p.getWindowVisibleDisplayFrame(rect);
        return this.f1282q == 1 ? (iArr[0] + listViewA.getWidth()) + i2 > rect.right ? 0 : 1 : iArr[0] - i2 < 0 ? 1 : 0;
    }

    private void F(e eVar) {
        d dVar;
        View viewC;
        int i2;
        int i3;
        int i4;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1267b);
        androidx.appcompat.view.menu.d dVar2 = new androidx.appcompat.view.menu.d(eVar, layoutInflaterFrom, this.f1271f, f1265B);
        if (!b() && this.f1287v) {
            dVar2.d(true);
        } else if (b()) {
            dVar2.d(h.x(eVar));
        }
        int iO = h.o(dVar2, null, this.f1267b, this.f1268c);
        V vZ = z();
        vZ.o(dVar2);
        vZ.B(iO);
        vZ.C(this.f1279n);
        if (this.f1274i.size() > 0) {
            List list = this.f1274i;
            dVar = (d) list.get(list.size() - 1);
            viewC = C(dVar, eVar);
        } else {
            dVar = null;
            viewC = null;
        }
        if (viewC != null) {
            vZ.Q(false);
            vZ.N(null);
            int iE = E(iO);
            boolean z2 = iE == 1;
            this.f1282q = iE;
            if (Build.VERSION.SDK_INT >= 26) {
                vZ.z(viewC);
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.f1280o.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewC.getLocationOnScreen(iArr2);
                if ((this.f1279n & 7) == 5) {
                    iArr[0] = iArr[0] + this.f1280o.getWidth();
                    iArr2[0] = iArr2[0] + viewC.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.f1279n & 5) == 5) {
                if (!z2) {
                    iO = viewC.getWidth();
                    i4 = i2 - iO;
                }
                i4 = i2 + iO;
            } else {
                if (z2) {
                    iO = viewC.getWidth();
                    i4 = i2 + iO;
                }
                i4 = i2 - iO;
            }
            vZ.c(i4);
            vZ.I(true);
            vZ.n(i3);
        } else {
            if (this.f1283r) {
                vZ.c(this.f1285t);
            }
            if (this.f1284s) {
                vZ.n(this.f1286u);
            }
            vZ.D(n());
        }
        this.f1274i.add(new d(vZ, eVar, this.f1282q));
        vZ.f();
        ListView listViewK = vZ.k();
        listViewK.setOnKeyListener(this);
        if (dVar == null && this.f1288w && eVar.x() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewK, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(eVar.x());
            listViewK.addHeaderView(frameLayout, null, false);
            vZ.f();
        }
    }

    private V z() {
        V v2 = new V(this.f1267b, null, this.f1269d, this.f1270e);
        v2.P(this.f1277l);
        v2.H(this);
        v2.G(this);
        v2.z(this.f1280o);
        v2.C(this.f1279n);
        v2.F(true);
        v2.E(2);
        return v2;
    }

    @Override // androidx.appcompat.view.menu.j
    public void a(e eVar, boolean z2) {
        int iA = A(eVar);
        if (iA < 0) {
            return;
        }
        int i2 = iA + 1;
        if (i2 < this.f1274i.size()) {
            ((d) this.f1274i.get(i2)).f1300b.e(false);
        }
        d dVar = (d) this.f1274i.remove(iA);
        dVar.f1300b.P(this);
        if (this.f1266A) {
            dVar.f1299a.O(null);
            dVar.f1299a.A(0);
        }
        dVar.f1299a.dismiss();
        int size = this.f1274i.size();
        this.f1282q = size > 0 ? ((d) this.f1274i.get(size - 1)).f1301c : D();
        if (size != 0) {
            if (z2) {
                ((d) this.f1274i.get(0)).f1300b.e(false);
                return;
            }
            return;
        }
        dismiss();
        j.a aVar = this.f1289x;
        if (aVar != null) {
            aVar.a(eVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f1290y;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f1290y.removeGlobalOnLayoutListener(this.f1275j);
            }
            this.f1290y = null;
        }
        this.f1281p.removeOnAttachStateChangeListener(this.f1276k);
        this.f1291z.onDismiss();
    }

    @Override // h.e
    public boolean b() {
        return this.f1274i.size() > 0 && ((d) this.f1274i.get(0)).f1299a.b();
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean c() {
        return false;
    }

    @Override // h.e
    public void dismiss() {
        int size = this.f1274i.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f1274i.toArray(new d[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                d dVar = dVarArr[i2];
                if (dVar.f1299a.b()) {
                    dVar.f1299a.dismiss();
                }
            }
        }
    }

    @Override // h.e
    public void f() {
        if (b()) {
            return;
        }
        Iterator it2 = this.f1273h.iterator();
        while (it2.hasNext()) {
            F((e) it2.next());
        }
        this.f1273h.clear();
        View view = this.f1280o;
        this.f1281p = view;
        if (view != null) {
            boolean z2 = this.f1290y == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f1290y = viewTreeObserver;
            if (z2) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f1275j);
            }
            this.f1281p.addOnAttachStateChangeListener(this.f1276k);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f1289x = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean i(m mVar) {
        for (d dVar : this.f1274i) {
            if (mVar == dVar.f1300b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        l(mVar);
        j.a aVar = this.f1289x;
        if (aVar != null) {
            aVar.b(mVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(boolean z2) {
        Iterator it2 = this.f1274i.iterator();
        while (it2.hasNext()) {
            h.y(((d) it2.next()).a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // h.e
    public ListView k() {
        if (this.f1274i.isEmpty()) {
            return null;
        }
        return ((d) this.f1274i.get(r0.size() - 1)).a();
    }

    @Override // androidx.appcompat.view.menu.h
    public void l(e eVar) {
        eVar.c(this, this.f1267b);
        if (b()) {
            F(eVar);
        } else {
            this.f1273h.add(eVar);
        }
    }

    @Override // androidx.appcompat.view.menu.h
    protected boolean m() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.f1274i.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                dVar = null;
                break;
            }
            dVar = (d) this.f1274i.get(i2);
            if (!dVar.f1299a.b()) {
                break;
            } else {
                i2++;
            }
        }
        if (dVar != null) {
            dVar.f1300b.e(false);
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
        if (this.f1280o != view) {
            this.f1280o = view;
            this.f1279n = AbstractC0154s.a(this.f1278m, view.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void r(boolean z2) {
        this.f1287v = z2;
    }

    @Override // androidx.appcompat.view.menu.h
    public void s(int i2) {
        if (this.f1278m != i2) {
            this.f1278m = i2;
            this.f1279n = AbstractC0154s.a(i2, this.f1280o.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void t(int i2) {
        this.f1283r = true;
        this.f1285t = i2;
    }

    @Override // androidx.appcompat.view.menu.h
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.f1291z = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.h
    public void v(boolean z2) {
        this.f1288w = z2;
    }

    @Override // androidx.appcompat.view.menu.h
    public void w(int i2) {
        this.f1284s = true;
        this.f1286u = i2;
    }
}
