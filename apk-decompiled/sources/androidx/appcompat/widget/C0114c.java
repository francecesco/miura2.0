package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.AbstractC0138b;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.appcompat.widget.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0114c extends androidx.appcompat.view.menu.a implements AbstractC0138b.a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    RunnableC0027c f1799A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private b f1800B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    final f f1801C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    int f1802D;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    d f1803k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Drawable f1804l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f1805m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f1806n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f1807o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f1808p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f1809q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f1810r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f1811s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f1812t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f1813u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f1814v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f1815w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final SparseBooleanArray f1816x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    e f1817y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    a f1818z;

    /* JADX INFO: renamed from: androidx.appcompat.widget.c$a */
    private class a extends androidx.appcompat.view.menu.i {
        public a(Context context, androidx.appcompat.view.menu.m mVar, View view) {
            super(context, mVar, view, false, R$attr.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.g) mVar.getItem()).l()) {
                View view2 = C0114c.this.f1803k;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.a) C0114c.this).f1263i : view2);
            }
            j(C0114c.this.f1801C);
        }

        @Override // androidx.appcompat.view.menu.i
        protected void e() {
            C0114c c0114c = C0114c.this;
            c0114c.f1818z = null;
            c0114c.f1802D = 0;
            super.e();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.c$b */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public h.e a() {
            a aVar = C0114c.this.f1818z;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.c$c, reason: collision with other inner class name */
    private class RunnableC0027c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private e f1821a;

        public RunnableC0027c(e eVar) {
            this.f1821a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.a) C0114c.this).f1257c != null) {
                ((androidx.appcompat.view.menu.a) C0114c.this).f1257c.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.a) C0114c.this).f1263i;
            if (view != null && view.getWindowToken() != null && this.f1821a.m()) {
                C0114c.this.f1817y = this.f1821a;
            }
            C0114c.this.f1799A = null;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.c$d */
    private class d extends r implements ActionMenuView.a {

        /* JADX INFO: renamed from: androidx.appcompat.widget.c$d$a */
        class a extends Q {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ C0114c f1824j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(View view, C0114c c0114c) {
                super(view);
                this.f1824j = c0114c;
            }

            @Override // androidx.appcompat.widget.Q
            public h.e b() {
                e eVar = C0114c.this.f1817y;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.Q
            public boolean c() {
                C0114c.this.K();
                return true;
            }

            @Override // androidx.appcompat.widget.Q
            public boolean d() {
                C0114c c0114c = C0114c.this;
                if (c0114c.f1799A != null) {
                    return false;
                }
                c0114c.B();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, R$attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            j0.a(this, getContentDescription());
            setOnTouchListener(new a(this, C0114c.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            C0114c.this.K();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i2, int i3, int i4, int i5) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.k(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.c$e */
    private class e extends androidx.appcompat.view.menu.i {
        public e(Context context, androidx.appcompat.view.menu.e eVar, View view, boolean z2) {
            super(context, eVar, view, z2, R$attr.actionOverflowMenuStyle);
            h(8388613);
            j(C0114c.this.f1801C);
        }

        @Override // androidx.appcompat.view.menu.i
        protected void e() {
            if (((androidx.appcompat.view.menu.a) C0114c.this).f1257c != null) {
                ((androidx.appcompat.view.menu.a) C0114c.this).f1257c.close();
            }
            C0114c.this.f1817y = null;
            super.e();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.c$f */
    private class f implements j.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void a(androidx.appcompat.view.menu.e eVar, boolean z2) {
            if (eVar instanceof androidx.appcompat.view.menu.m) {
                eVar.D().e(false);
            }
            j.a aVarM = C0114c.this.m();
            if (aVarM != null) {
                aVarM.a(eVar, z2);
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean b(androidx.appcompat.view.menu.e eVar) {
            if (eVar == ((androidx.appcompat.view.menu.a) C0114c.this).f1257c) {
                return false;
            }
            C0114c.this.f1802D = ((androidx.appcompat.view.menu.m) eVar).getItem().getItemId();
            j.a aVarM = C0114c.this.m();
            if (aVarM != null) {
                return aVarM.b(eVar);
            }
            return false;
        }
    }

    public C0114c(Context context) {
        super(context, R$layout.abc_action_menu_layout, R$layout.abc_action_menu_item_layout);
        this.f1816x = new SparseBooleanArray();
        this.f1801C = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View z(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f1263i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof k.a) && ((k.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable A() {
        d dVar = this.f1803k;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f1805m) {
            return this.f1804l;
        }
        return null;
    }

    public boolean B() {
        Object obj;
        RunnableC0027c runnableC0027c = this.f1799A;
        if (runnableC0027c != null && (obj = this.f1263i) != null) {
            ((View) obj).removeCallbacks(runnableC0027c);
            this.f1799A = null;
            return true;
        }
        e eVar = this.f1817y;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    public boolean C() {
        a aVar = this.f1818z;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean D() {
        return this.f1799A != null || E();
    }

    public boolean E() {
        e eVar = this.f1817y;
        return eVar != null && eVar.d();
    }

    public void F(Configuration configuration) {
        if (!this.f1811s) {
            this.f1810r = androidx.appcompat.view.a.b(this.f1256b).d();
        }
        androidx.appcompat.view.menu.e eVar = this.f1257c;
        if (eVar != null) {
            eVar.L(true);
        }
    }

    public void G(boolean z2) {
        this.f1814v = z2;
    }

    public void H(ActionMenuView actionMenuView) {
        this.f1263i = actionMenuView;
        actionMenuView.b(this.f1257c);
    }

    public void I(Drawable drawable) {
        d dVar = this.f1803k;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.f1805m = true;
            this.f1804l = drawable;
        }
    }

    public void J(boolean z2) {
        this.f1806n = z2;
        this.f1807o = true;
    }

    public boolean K() {
        androidx.appcompat.view.menu.e eVar;
        if (!this.f1806n || E() || (eVar = this.f1257c) == null || this.f1263i == null || this.f1799A != null || eVar.z().isEmpty()) {
            return false;
        }
        RunnableC0027c runnableC0027c = new RunnableC0027c(new e(this.f1256b, this.f1257c, this.f1803k, true));
        this.f1799A = runnableC0027c;
        ((View) this.f1263i).post(runnableC0027c);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void a(androidx.appcompat.view.menu.e eVar, boolean z2) {
        y();
        super.a(eVar, z2);
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean c() {
        ArrayList arrayListE;
        int size;
        int i2;
        int iJ;
        int i3;
        C0114c c0114c = this;
        androidx.appcompat.view.menu.e eVar = c0114c.f1257c;
        View view = null;
        int i4 = 0;
        if (eVar != null) {
            arrayListE = eVar.E();
            size = arrayListE.size();
        } else {
            arrayListE = null;
            size = 0;
        }
        int i5 = c0114c.f1810r;
        int i6 = c0114c.f1809q;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) c0114c.f1263i;
        boolean z2 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) arrayListE.get(i9);
            if (gVar.o()) {
                i7++;
            } else if (gVar.n()) {
                i8++;
            } else {
                z2 = true;
            }
            if (c0114c.f1814v && gVar.isActionViewExpanded()) {
                i5 = 0;
            }
        }
        if (c0114c.f1806n && (z2 || i8 + i7 > i5)) {
            i5--;
        }
        int i10 = i5 - i7;
        SparseBooleanArray sparseBooleanArray = c0114c.f1816x;
        sparseBooleanArray.clear();
        if (c0114c.f1812t) {
            int i11 = c0114c.f1815w;
            iJ = i6 / i11;
            i2 = i11 + ((i6 % i11) / iJ);
        } else {
            i2 = 0;
            iJ = 0;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < size) {
            androidx.appcompat.view.menu.g gVar2 = (androidx.appcompat.view.menu.g) arrayListE.get(i12);
            if (gVar2.o()) {
                View viewN = c0114c.n(gVar2, view, viewGroup);
                if (c0114c.f1812t) {
                    iJ -= ActionMenuView.J(viewN, i2, iJ, iMakeMeasureSpec, i4);
                } else {
                    viewN.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewN.getMeasuredWidth();
                i6 -= measuredWidth;
                if (i13 == 0) {
                    i13 = measuredWidth;
                }
                int groupId = gVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                gVar2.u(true);
                i3 = size;
            } else if (gVar2.n()) {
                int groupId2 = gVar2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i10 > 0 || z3) && i6 > 0 && (!c0114c.f1812t || iJ > 0);
                boolean z5 = z4;
                i3 = size;
                if (z4) {
                    View viewN2 = c0114c.n(gVar2, null, viewGroup);
                    if (c0114c.f1812t) {
                        int iJ2 = ActionMenuView.J(viewN2, i2, iJ, iMakeMeasureSpec, 0);
                        iJ -= iJ2;
                        if (iJ2 == 0) {
                            z5 = false;
                        }
                    } else {
                        viewN2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z6 = z5;
                    int measuredWidth2 = viewN2.getMeasuredWidth();
                    i6 -= measuredWidth2;
                    if (i13 == 0) {
                        i13 = measuredWidth2;
                    }
                    z4 = z6 & (!c0114c.f1812t ? i6 + i13 <= 0 : i6 < 0);
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i14 = 0; i14 < i12; i14++) {
                        androidx.appcompat.view.menu.g gVar3 = (androidx.appcompat.view.menu.g) arrayListE.get(i14);
                        if (gVar3.getGroupId() == groupId2) {
                            if (gVar3.l()) {
                                i10++;
                            }
                            gVar3.u(false);
                        }
                    }
                }
                if (z4) {
                    i10--;
                }
                gVar2.u(z4);
            } else {
                i3 = size;
                gVar2.u(false);
                i12++;
                view = null;
                c0114c = this;
                size = i3;
                i4 = 0;
            }
            i12++;
            view = null;
            c0114c = this;
            size = i3;
            i4 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void d(Context context, androidx.appcompat.view.menu.e eVar) {
        super.d(context, eVar);
        Resources resources = context.getResources();
        androidx.appcompat.view.a aVarB = androidx.appcompat.view.a.b(context);
        if (!this.f1807o) {
            this.f1806n = aVarB.f();
        }
        if (!this.f1813u) {
            this.f1808p = aVarB.c();
        }
        if (!this.f1811s) {
            this.f1810r = aVarB.d();
        }
        int measuredWidth = this.f1808p;
        if (this.f1806n) {
            if (this.f1803k == null) {
                d dVar = new d(this.f1255a);
                this.f1803k = dVar;
                if (this.f1805m) {
                    dVar.setImageDrawable(this.f1804l);
                    this.f1804l = null;
                    this.f1805m = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1803k.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f1803k.getMeasuredWidth();
        } else {
            this.f1803k = null;
        }
        this.f1809q = measuredWidth;
        this.f1815w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.a
    public void f(androidx.appcompat.view.menu.g gVar, k.a aVar) {
        aVar.d(gVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f1263i);
        if (this.f1800B == null) {
            this.f1800B = new b();
        }
        actionMenuItemView.setPopupCallback(this.f1800B);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public boolean i(androidx.appcompat.view.menu.m mVar) {
        boolean z2 = false;
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.m mVar2 = mVar;
        while (mVar2.f0() != this.f1257c) {
            mVar2 = (androidx.appcompat.view.menu.m) mVar2.f0();
        }
        View viewZ = z(mVar2.getItem());
        if (viewZ == null) {
            return false;
        }
        this.f1802D = mVar.getItem().getItemId();
        int size = mVar.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MenuItem item = mVar.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                z2 = true;
                break;
            }
            i2++;
        }
        a aVar = new a(this.f1256b, mVar, viewZ);
        this.f1818z = aVar;
        aVar.g(z2);
        this.f1818z.k();
        super.i(mVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void j(boolean z2) {
        super.j(z2);
        ((View) this.f1263i).requestLayout();
        androidx.appcompat.view.menu.e eVar = this.f1257c;
        boolean z3 = false;
        if (eVar != null) {
            ArrayList arrayListS = eVar.s();
            int size = arrayListS.size();
            for (int i2 = 0; i2 < size; i2++) {
                AbstractC0138b abstractC0138bB = ((androidx.appcompat.view.menu.g) arrayListS.get(i2)).b();
                if (abstractC0138bB != null) {
                    abstractC0138bB.h(this);
                }
            }
        }
        androidx.appcompat.view.menu.e eVar2 = this.f1257c;
        ArrayList arrayListZ = eVar2 != null ? eVar2.z() : null;
        if (this.f1806n && arrayListZ != null) {
            int size2 = arrayListZ.size();
            if (size2 == 1) {
                z3 = !((androidx.appcompat.view.menu.g) arrayListZ.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z3 = true;
            }
        }
        d dVar = this.f1803k;
        if (z3) {
            if (dVar == null) {
                this.f1803k = new d(this.f1255a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1803k.getParent();
            if (viewGroup != this.f1263i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1803k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f1263i;
                actionMenuView.addView(this.f1803k, actionMenuView.D());
            }
        } else if (dVar != null) {
            Object parent = dVar.getParent();
            Object obj = this.f1263i;
            if (parent == obj) {
                ((ViewGroup) obj).removeView(this.f1803k);
            }
        }
        ((ActionMenuView) this.f1263i).setOverflowReserved(this.f1806n);
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean l(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.f1803k) {
            return false;
        }
        return super.l(viewGroup, i2);
    }

    @Override // androidx.appcompat.view.menu.a
    public View n(androidx.appcompat.view.menu.g gVar, View view, ViewGroup viewGroup) {
        View actionView = gVar.getActionView();
        if (actionView == null || gVar.j()) {
            actionView = super.n(gVar, view, viewGroup);
        }
        actionView.setVisibility(gVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.a
    public androidx.appcompat.view.menu.k o(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.k kVar = this.f1263i;
        androidx.appcompat.view.menu.k kVarO = super.o(viewGroup);
        if (kVar != kVarO) {
            ((ActionMenuView) kVarO).setPresenter(this);
        }
        return kVarO;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean q(int i2, androidx.appcompat.view.menu.g gVar) {
        return gVar.l();
    }

    public boolean y() {
        return B() | C();
    }
}
