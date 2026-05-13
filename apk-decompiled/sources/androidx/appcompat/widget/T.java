package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class T implements h.e {

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private static Method f1647G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private static Method f1648H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private static Method f1649I;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private Runnable f1650A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    final Handler f1651B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private final Rect f1652C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private Rect f1653D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private boolean f1654E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    PopupWindow f1655F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ListAdapter f1657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    O f1658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1662g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1663h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1664i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1665j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f1666k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1667l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f1668m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f1669n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f1670o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private View f1671p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f1672q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private DataSetObserver f1673r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private View f1674s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Drawable f1675t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private AdapterView.OnItemClickListener f1676u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f1677v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final i f1678w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final h f1679x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final g f1680y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final e f1681z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewT = T.this.t();
            if (viewT == null || viewT.getWindowToken() == null) {
                return;
            }
            T.this.f();
        }
    }

    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i2, long j2) {
            O o2;
            if (i2 == -1 || (o2 = T.this.f1658c) == null) {
                return;
            }
            o2.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    static class c {
        static int a(PopupWindow popupWindow, View view, int i2, boolean z2) {
            return popupWindow.getMaxAvailableHeight(view, i2, z2);
        }
    }

    static class d {
        static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        static void b(PopupWindow popupWindow, boolean z2) {
            popupWindow.setIsClippedToScreen(z2);
        }
    }

    private class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            T.this.r();
        }
    }

    private class f extends DataSetObserver {
        f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (T.this.b()) {
                T.this.f();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            T.this.dismiss();
        }
    }

    private class g implements AbsListView.OnScrollListener {
        g() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 != 1 || T.this.w() || T.this.f1655F.getContentView() == null) {
                return;
            }
            T t2 = T.this;
            t2.f1651B.removeCallbacks(t2.f1678w);
            T.this.f1678w.run();
        }
    }

    private class h implements View.OnTouchListener {
        h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = T.this.f1655F) != null && popupWindow.isShowing() && x2 >= 0 && x2 < T.this.f1655F.getWidth() && y2 >= 0 && y2 < T.this.f1655F.getHeight()) {
                T t2 = T.this;
                t2.f1651B.postDelayed(t2.f1678w, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            T t3 = T.this;
            t3.f1651B.removeCallbacks(t3.f1678w);
            return false;
        }
    }

    private class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            O o2 = T.this.f1658c;
            if (o2 == null || !o2.isAttachedToWindow() || T.this.f1658c.getCount() <= T.this.f1658c.getChildCount()) {
                return;
            }
            int childCount = T.this.f1658c.getChildCount();
            T t2 = T.this;
            if (childCount <= t2.f1670o) {
                t2.f1655F.setInputMethodMode(2);
                T.this.f();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f1647G = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
            }
            try {
                f1649I = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                f1648H = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
            }
        }
    }

    public T(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    private void J(boolean z2) {
        if (Build.VERSION.SDK_INT > 28) {
            d.b(this.f1655F, z2);
            return;
        }
        Method method = f1647G;
        if (method != null) {
            try {
                method.invoke(this.f1655F, Boolean.valueOf(z2));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0123 A[PHI: r1
      0x0123: PHI (r1v1 int) = (r1v0 int), (r1v6 int) binds: [B:45:0x0117, B:47:0x011b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int q() {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.T.q():int");
    }

    private int u(View view, int i2, boolean z2) {
        if (Build.VERSION.SDK_INT > 23) {
            return c.a(this.f1655F, view, i2, z2);
        }
        Method method = f1648H;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f1655F, view, Integer.valueOf(i2), Boolean.valueOf(z2))).intValue();
            } catch (Exception unused) {
            }
        }
        return this.f1655F.getMaxAvailableHeight(view, i2);
    }

    private void y() {
        View view = this.f1671p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1671p);
            }
        }
    }

    public void A(int i2) {
        this.f1655F.setAnimationStyle(i2);
    }

    public void B(int i2) {
        Drawable background = this.f1655F.getBackground();
        if (background == null) {
            M(i2);
            return;
        }
        background.getPadding(this.f1652C);
        Rect rect = this.f1652C;
        this.f1660e = rect.left + rect.right + i2;
    }

    public void C(int i2) {
        this.f1667l = i2;
    }

    public void D(Rect rect) {
        this.f1653D = rect != null ? new Rect(rect) : null;
    }

    public void E(int i2) {
        this.f1655F.setInputMethodMode(i2);
    }

    public void F(boolean z2) {
        this.f1654E = z2;
        this.f1655F.setFocusable(z2);
    }

    public void G(PopupWindow.OnDismissListener onDismissListener) {
        this.f1655F.setOnDismissListener(onDismissListener);
    }

    public void H(AdapterView.OnItemClickListener onItemClickListener) {
        this.f1676u = onItemClickListener;
    }

    public void I(boolean z2) {
        this.f1666k = true;
        this.f1665j = z2;
    }

    public void K(int i2) {
        this.f1672q = i2;
    }

    public void L(int i2) {
        O o2 = this.f1658c;
        if (!b() || o2 == null) {
            return;
        }
        o2.setListSelectionHidden(false);
        o2.setSelection(i2);
        if (o2.getChoiceMode() != 0) {
            o2.setItemChecked(i2, true);
        }
    }

    public void M(int i2) {
        this.f1660e = i2;
    }

    @Override // h.e
    public boolean b() {
        return this.f1655F.isShowing();
    }

    public void c(int i2) {
        this.f1661f = i2;
    }

    public int d() {
        return this.f1661f;
    }

    @Override // h.e
    public void dismiss() {
        this.f1655F.dismiss();
        y();
        this.f1655F.setContentView(null);
        this.f1658c = null;
        this.f1651B.removeCallbacks(this.f1678w);
    }

    @Override // h.e
    public void f() {
        int iQ = q();
        boolean zW = w();
        androidx.core.widget.g.b(this.f1655F, this.f1663h);
        if (this.f1655F.isShowing()) {
            if (t().isAttachedToWindow()) {
                int width = this.f1660e;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = t().getWidth();
                }
                int i2 = this.f1659d;
                if (i2 == -1) {
                    if (!zW) {
                        iQ = -1;
                    }
                    if (zW) {
                        this.f1655F.setWidth(this.f1660e == -1 ? -1 : 0);
                        this.f1655F.setHeight(0);
                    } else {
                        this.f1655F.setWidth(this.f1660e == -1 ? -1 : 0);
                        this.f1655F.setHeight(-1);
                    }
                } else if (i2 != -2) {
                    iQ = i2;
                }
                this.f1655F.setOutsideTouchable((this.f1669n || this.f1668m) ? false : true);
                this.f1655F.update(t(), this.f1661f, this.f1662g, width < 0 ? -1 : width, iQ < 0 ? -1 : iQ);
                return;
            }
            return;
        }
        int width2 = this.f1660e;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = t().getWidth();
        }
        int i3 = this.f1659d;
        if (i3 == -1) {
            iQ = -1;
        } else if (i3 != -2) {
            iQ = i3;
        }
        this.f1655F.setWidth(width2);
        this.f1655F.setHeight(iQ);
        J(true);
        this.f1655F.setOutsideTouchable((this.f1669n || this.f1668m) ? false : true);
        this.f1655F.setTouchInterceptor(this.f1679x);
        if (this.f1666k) {
            androidx.core.widget.g.a(this.f1655F, this.f1665j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f1649I;
            if (method != null) {
                try {
                    method.invoke(this.f1655F, this.f1653D);
                } catch (Exception unused) {
                }
            }
        } else {
            d.a(this.f1655F, this.f1653D);
        }
        androidx.core.widget.g.c(this.f1655F, t(), this.f1661f, this.f1662g, this.f1667l);
        this.f1658c.setSelection(-1);
        if (!this.f1654E || this.f1658c.isInTouchMode()) {
            r();
        }
        if (this.f1654E) {
            return;
        }
        this.f1651B.post(this.f1681z);
    }

    public int g() {
        if (this.f1664i) {
            return this.f1662g;
        }
        return 0;
    }

    public Drawable i() {
        return this.f1655F.getBackground();
    }

    @Override // h.e
    public ListView k() {
        return this.f1658c;
    }

    public void m(Drawable drawable) {
        this.f1655F.setBackgroundDrawable(drawable);
    }

    public void n(int i2) {
        this.f1662g = i2;
        this.f1664i = true;
    }

    public void o(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f1673r;
        if (dataSetObserver == null) {
            this.f1673r = new f();
        } else {
            ListAdapter listAdapter2 = this.f1657b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1657b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1673r);
        }
        O o2 = this.f1658c;
        if (o2 != null) {
            o2.setAdapter(this.f1657b);
        }
    }

    public void r() {
        O o2 = this.f1658c;
        if (o2 != null) {
            o2.setListSelectionHidden(true);
            o2.requestLayout();
        }
    }

    O s(Context context, boolean z2) {
        return new O(context, z2);
    }

    public View t() {
        return this.f1674s;
    }

    public int v() {
        return this.f1660e;
    }

    public boolean w() {
        return this.f1655F.getInputMethodMode() == 2;
    }

    public boolean x() {
        return this.f1654E;
    }

    public void z(View view) {
        this.f1674s = view;
    }

    public T(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f1659d = -2;
        this.f1660e = -2;
        this.f1663h = 1002;
        this.f1667l = 0;
        this.f1668m = false;
        this.f1669n = false;
        this.f1670o = Integer.MAX_VALUE;
        this.f1672q = 0;
        this.f1678w = new i();
        this.f1679x = new h();
        this.f1680y = new g();
        this.f1681z = new e();
        this.f1652C = new Rect();
        this.f1656a = context;
        this.f1651B = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPopupWindow, i2, i3);
        this.f1661f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f1662g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1664i = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        C0130t c0130t = new C0130t(context, attributeSet, i2, i3);
        this.f1655F = c0130t;
        c0130t.setInputMethodMode(1);
    }
}
