package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.AbstractC0105a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.AbstractC0154s;
import androidx.core.view.C0158w;
import androidx.core.view.InterfaceC0157v;
import androidx.core.view.InterfaceC0160y;
import e.AbstractC0190a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import t.AbstractC0251a;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup implements InterfaceC0157v {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private ColorStateList f1689A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private boolean f1690B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private boolean f1691C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private final ArrayList f1692D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private final ArrayList f1693E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private final int[] f1694F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    final C0158w f1695G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private ArrayList f1696H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private final ActionMenuView.e f1697I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private i0 f1698J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private C0114c f1699K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private f f1700L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private j.a f1701M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    e.a f1702N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private boolean f1703O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private OnBackInvokedCallback f1704P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private OnBackInvokedDispatcher f1705Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private boolean f1706R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private final Runnable f1707S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ActionMenuView f1708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f1709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f1710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ImageButton f1711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageView f1712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f1713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private CharSequence f1714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    ImageButton f1715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    View f1716i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f1717j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1718k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1719l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f1720m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f1721n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f1722o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f1723p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f1724q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f1725r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f1726s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Y f1727t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f1728u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f1729v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f1730w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private CharSequence f1731x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private CharSequence f1732y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ColorStateList f1733z;

    class a implements ActionMenuView.e {
        a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.f1695G.d(menuItem)) {
                return true;
            }
            Toolbar.this.getClass();
            return false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.R();
        }
    }

    class c implements e.a {
        c() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            e.a aVar = Toolbar.this.f1702N;
            return aVar != null && aVar.a(eVar, menuItem);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (!Toolbar.this.f1708a.H()) {
                Toolbar.this.f1695G.e(eVar);
            }
            e.a aVar = Toolbar.this.f1702N;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    static class e {
        static OnBackInvokedDispatcher a(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(final Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new OnBackInvokedCallback() { // from class: androidx.appcompat.widget.h0
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    runnable.run();
                }
            };
        }

        static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        static void d(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    private class f implements androidx.appcompat.view.menu.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        androidx.appcompat.view.menu.e f1738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        androidx.appcompat.view.menu.g f1739b;

        f() {
        }

        @Override // androidx.appcompat.view.menu.j
        public void a(androidx.appcompat.view.menu.e eVar, boolean z2) {
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean c() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public void d(Context context, androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.g gVar;
            androidx.appcompat.view.menu.e eVar2 = this.f1738a;
            if (eVar2 != null && (gVar = this.f1739b) != null) {
                eVar2.f(gVar);
            }
            this.f1738a = eVar;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean e(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            KeyEvent.Callback callback = Toolbar.this.f1716i;
            if (callback instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) callback).d();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f1716i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f1715h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f1716i = null;
            toolbar3.a();
            this.f1739b = null;
            Toolbar.this.requestLayout();
            gVar.r(false);
            Toolbar.this.S();
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean g(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f1715h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f1715h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f1715h);
            }
            Toolbar.this.f1716i = gVar.getActionView();
            this.f1739b = gVar;
            ViewParent parent2 = Toolbar.this.f1716i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f1716i);
                }
                g gVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                gVarGenerateDefaultLayoutParams.f995a = (toolbar4.f1721n & 112) | 8388611;
                gVarGenerateDefaultLayoutParams.f1741b = 2;
                toolbar4.f1716i.setLayoutParams(gVarGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f1716i);
            }
            Toolbar.this.K();
            Toolbar.this.requestLayout();
            gVar.r(true);
            KeyEvent.Callback callback = Toolbar.this.f1716i;
            if (callback instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) callback).c();
            }
            Toolbar.this.S();
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean i(androidx.appcompat.view.menu.m mVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public void j(boolean z2) {
            if (this.f1739b != null) {
                androidx.appcompat.view.menu.e eVar = this.f1738a;
                if (eVar != null) {
                    int size = eVar.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.f1738a.getItem(i2) == this.f1739b) {
                            return;
                        }
                    }
                }
                e(this.f1738a, this.f1739b);
            }
        }
    }

    public static class g extends AbstractC0105a.C0022a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1741b;

        public g(int i2, int i3) {
            super(i2, i3);
            this.f1741b = 0;
            this.f995a = 8388627;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1741b = 0;
        }

        public g(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1741b = 0;
        }

        public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1741b = 0;
            a(marginLayoutParams);
        }

        public g(AbstractC0105a.C0022a c0022a) {
            super(c0022a);
            this.f1741b = 0;
        }

        public g(g gVar) {
            super((AbstractC0105a.C0022a) gVar);
            this.f1741b = 0;
            this.f1741b = gVar.f1741b;
        }
    }

    public interface h {
    }

    public static class i extends AbstractC0251a {
        public static final Parcelable.Creator<i> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1742c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1743d;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel) {
                return new i(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new i(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public i[] newArray(int i2) {
                return new i[i2];
            }
        }

        public i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1742c = parcel.readInt();
            this.f1743d = parcel.readInt() != 0;
        }

        @Override // t.AbstractC0251a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f1742c);
            parcel.writeInt(this.f1743d ? 1 : 0);
        }

        public i(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    private boolean B(View view) {
        return view.getParent() == this || this.f1693E.contains(view);
    }

    private int E(View view, int i2, int[] iArr, int i3) {
        g gVar = (g) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - iArr[0];
        int iMax = i2 + Math.max(0, i4);
        iArr[0] = Math.max(0, -i4);
        int iS = s(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iS, iMax + measuredWidth, view.getMeasuredHeight() + iS);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).rightMargin;
    }

    private int F(View view, int i2, int[] iArr, int i3) {
        g gVar = (g) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - iArr[1];
        int iMax = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int iS = s(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iS, iMax, view.getMeasuredHeight() + iS);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).leftMargin);
    }

    private int G(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i6) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + iMax + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    private void H(View view, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void I() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.f1695G.b(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f1696H = currentMenuItems2;
    }

    private void J() {
        removeCallbacks(this.f1707S);
        post(this.f1707S);
    }

    private boolean P() {
        if (!this.f1703O) {
            return false;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (Q(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean Q(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List list, int i2) {
        boolean z2 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int iA = AbstractC0154s.a(i2, getLayoutDirection());
        list.clear();
        if (!z2) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f1741b == 0 && Q(childAt) && r(gVar.f995a) == iA) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            g gVar2 = (g) childAt2.getLayoutParams();
            if (gVar2.f1741b == 0 && Q(childAt2) && r(gVar2.f995a) == iA) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        g gVarGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (g) layoutParams;
        gVarGenerateDefaultLayoutParams.f1741b = 1;
        if (!z2 || this.f1716i == null) {
            addView(view, gVarGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.f1693E.add(view);
        }
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i2 = 0; i2 < menu.size(); i2++) {
            arrayList.add(menu.getItem(i2));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new androidx.appcompat.view.g(getContext());
    }

    private void h() {
        if (this.f1727t == null) {
            this.f1727t = new Y();
        }
    }

    private void j() {
        if (this.f1712e == null) {
            this.f1712e = new r(getContext());
        }
    }

    private void l() {
        m();
        if (this.f1708a.L() == null) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) this.f1708a.getMenu();
            if (this.f1700L == null) {
                this.f1700L = new f();
            }
            this.f1708a.setExpandedActionViewsExclusive(true);
            eVar.c(this.f1700L, this.f1717j);
            S();
        }
    }

    private void m() {
        if (this.f1708a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f1708a = actionMenuView;
            actionMenuView.setPopupTheme(this.f1718k);
            this.f1708a.setOnMenuItemClickListener(this.f1697I);
            this.f1708a.M(this.f1701M, new c());
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f995a = (this.f1721n & 112) | 8388613;
            this.f1708a.setLayoutParams(gVarGenerateDefaultLayoutParams);
            c(this.f1708a, false);
        }
    }

    private void n() {
        if (this.f1711d == null) {
            this.f1711d = new C0127p(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f995a = (this.f1721n & 112) | 8388611;
            this.f1711d.setLayoutParams(gVarGenerateDefaultLayoutParams);
        }
    }

    private int r(int i2) {
        int layoutDirection = getLayoutDirection();
        int iA = AbstractC0154s.a(i2, layoutDirection) & 7;
        return (iA == 1 || iA == 3 || iA == 5) ? iA : layoutDirection == 1 ? 5 : 3;
    }

    private int s(View view, int i2) {
        g gVar = (g) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int iT = t(gVar.f995a);
        if (iT == 48) {
            return getPaddingTop() - i3;
        }
        if (iT == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin) - i3;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i4 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
        if (iMax < i4) {
            iMax = i4;
        } else {
            int i5 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i6 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
            if (i5 < i6) {
                iMax = Math.max(0, iMax - (i6 - i5));
            }
        }
        return paddingTop + iMax;
    }

    private int t(int i2) {
        int i3 = i2 & 112;
        return (i3 == 16 || i3 == 48 || i3 == 80) ? i3 : this.f1730w & 112;
    }

    private int u(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd();
    }

    private int v(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int w(List list, int[] iArr) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int size = list.size();
        int i4 = 0;
        int measuredWidth = 0;
        while (i4 < size) {
            View view = (View) list.get(i4);
            g gVar = (g) view.getLayoutParams();
            int i5 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - i2;
            int i6 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - i3;
            int iMax = Math.max(0, i5);
            int iMax2 = Math.max(0, i6);
            int iMax3 = Math.max(0, -i5);
            int iMax4 = Math.max(0, -i6);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i4++;
            i3 = iMax4;
            i2 = iMax3;
        }
        return measuredWidth;
    }

    public void A() {
        Iterator it2 = this.f1696H.iterator();
        while (it2.hasNext()) {
            getMenu().removeItem(((MenuItem) it2.next()).getItemId());
        }
        I();
    }

    public boolean C() {
        ActionMenuView actionMenuView = this.f1708a;
        return actionMenuView != null && actionMenuView.G();
    }

    public boolean D() {
        ActionMenuView actionMenuView = this.f1708a;
        return actionMenuView != null && actionMenuView.H();
    }

    void K() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((g) childAt.getLayoutParams()).f1741b != 2 && childAt != this.f1708a) {
                removeViewAt(childCount);
                this.f1693E.add(childAt);
            }
        }
    }

    public void L(int i2, int i3) {
        h();
        this.f1727t.g(i2, i3);
    }

    public void M(androidx.appcompat.view.menu.e eVar, C0114c c0114c) {
        if (eVar == null && this.f1708a == null) {
            return;
        }
        m();
        androidx.appcompat.view.menu.e eVarL = this.f1708a.L();
        if (eVarL == eVar) {
            return;
        }
        if (eVarL != null) {
            eVarL.P(this.f1699K);
            eVarL.P(this.f1700L);
        }
        if (this.f1700L == null) {
            this.f1700L = new f();
        }
        c0114c.G(true);
        if (eVar != null) {
            eVar.c(c0114c, this.f1717j);
            eVar.c(this.f1700L, this.f1717j);
        } else {
            c0114c.d(this.f1717j, null);
            this.f1700L.d(this.f1717j, null);
            c0114c.j(true);
            this.f1700L.j(true);
        }
        this.f1708a.setPopupTheme(this.f1718k);
        this.f1708a.setPresenter(c0114c);
        this.f1699K = c0114c;
        S();
    }

    public void N(Context context, int i2) {
        this.f1720m = i2;
        TextView textView = this.f1710c;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public void O(Context context, int i2) {
        this.f1719l = i2;
        TextView textView = this.f1709b;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public boolean R() {
        ActionMenuView actionMenuView = this.f1708a;
        return actionMenuView != null && actionMenuView.N();
    }

    void S() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = e.a(this);
            boolean z2 = x() && onBackInvokedDispatcherA != null && isAttachedToWindow() && this.f1706R;
            if (z2 && this.f1705Q == null) {
                if (this.f1704P == null) {
                    this.f1704P = e.b(new Runnable() { // from class: androidx.appcompat.widget.f0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f1849a.e();
                        }
                    });
                }
                e.c(onBackInvokedDispatcherA, this.f1704P);
            } else {
                if (z2 || (onBackInvokedDispatcher = this.f1705Q) == null) {
                    return;
                }
                e.d(onBackInvokedDispatcher, this.f1704P);
                onBackInvokedDispatcherA = null;
            }
            this.f1705Q = onBackInvokedDispatcherA;
        }
    }

    void a() {
        for (int size = this.f1693E.size() - 1; size >= 0; size--) {
            addView((View) this.f1693E.get(size));
        }
        this.f1693E.clear();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof g);
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f1708a) != null && actionMenuView.I();
    }

    public void e() {
        f fVar = this.f1700L;
        androidx.appcompat.view.menu.g gVar = fVar == null ? null : fVar.f1739b;
        if (gVar != null) {
            gVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f1708a;
        if (actionMenuView != null) {
            actionMenuView.z();
        }
    }

    void g() {
        if (this.f1715h == null) {
            C0127p c0127p = new C0127p(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            this.f1715h = c0127p;
            c0127p.setImageDrawable(this.f1713f);
            this.f1715h.setContentDescription(this.f1714g);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f995a = (this.f1721n & 112) | 8388611;
            gVarGenerateDefaultLayoutParams.f1741b = 2;
            this.f1715h.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.f1715h.setOnClickListener(new d());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f1715h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f1715h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        Y y2 = this.f1727t;
        if (y2 != null) {
            return y2.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.f1729v;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        Y y2 = this.f1727t;
        if (y2 != null) {
            return y2.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        Y y2 = this.f1727t;
        if (y2 != null) {
            return y2.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        Y y2 = this.f1727t;
        if (y2 != null) {
            return y2.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.f1728u;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.e eVarL;
        ActionMenuView actionMenuView = this.f1708a;
        return (actionMenuView == null || (eVarL = actionMenuView.L()) == null || !eVarL.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f1729v, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f1728u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f1712e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f1712e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        l();
        return this.f1708a.getMenu();
    }

    View getNavButtonView() {
        return this.f1711d;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f1711d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f1711d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    C0114c getOuterActionMenuPresenter() {
        return this.f1699K;
    }

    public Drawable getOverflowIcon() {
        l();
        return this.f1708a.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f1717j;
    }

    public int getPopupTheme() {
        return this.f1718k;
    }

    public CharSequence getSubtitle() {
        return this.f1732y;
    }

    final TextView getSubtitleTextView() {
        return this.f1710c;
    }

    public CharSequence getTitle() {
        return this.f1731x;
    }

    public int getTitleMarginBottom() {
        return this.f1726s;
    }

    public int getTitleMarginEnd() {
        return this.f1724q;
    }

    public int getTitleMarginStart() {
        return this.f1723p;
    }

    public int getTitleMarginTop() {
        return this.f1725r;
    }

    final TextView getTitleTextView() {
        return this.f1709b;
    }

    public M getWrapper() {
        if (this.f1698J == null) {
            this.f1698J = new i0(this, true);
        }
        return this.f1698J;
    }

    @Override // androidx.core.view.InterfaceC0157v
    public void i(InterfaceC0160y interfaceC0160y) {
        this.f1695G.f(interfaceC0160y);
    }

    @Override // androidx.core.view.InterfaceC0157v
    public void k(InterfaceC0160y interfaceC0160y) {
        this.f1695G.a(interfaceC0160y);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public g generateDefaultLayoutParams() {
        return new g(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        S();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1707S);
        S();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1691C = false;
        }
        if (!this.f1691C) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f1691C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1691C = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0297 A[LOOP:0: B:111:0x0295->B:112:0x0297, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02b9 A[LOOP:1: B:114:0x02b7->B:115:0x02b9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02f2 A[LOOP:2: B:123:0x02f0->B:124:0x02f2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x021d  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 775
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int iCombineMeasuredStates2;
        int iMax2;
        int measuredHeight;
        int[] iArr = this.f1694F;
        boolean zB = p0.b(this);
        int i4 = !zB ? 1 : 0;
        if (Q(this.f1711d)) {
            H(this.f1711d, i2, 0, i3, 0, this.f1722o);
            measuredWidth = this.f1711d.getMeasuredWidth() + u(this.f1711d);
            iMax = Math.max(0, this.f1711d.getMeasuredHeight() + v(this.f1711d));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f1711d.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (Q(this.f1715h)) {
            H(this.f1715h, i2, 0, i3, 0, this.f1722o);
            measuredWidth = this.f1715h.getMeasuredWidth() + u(this.f1715h);
            iMax = Math.max(iMax, this.f1715h.getMeasuredHeight() + v(this.f1715h));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1715h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth);
        iArr[zB ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (Q(this.f1708a)) {
            H(this.f1708a, i2, iMax3, i3, 0, this.f1722o);
            measuredWidth2 = this.f1708a.getMeasuredWidth() + u(this.f1708a);
            iMax = Math.max(iMax, this.f1708a.getMeasuredHeight() + v(this.f1708a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1708a.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[i4] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (Q(this.f1716i)) {
            iMax4 += G(this.f1716i, i2, iMax4, i3, 0, iArr);
            iMax = Math.max(iMax, this.f1716i.getMeasuredHeight() + v(this.f1716i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1716i.getMeasuredState());
        }
        if (Q(this.f1712e)) {
            iMax4 += G(this.f1712e, i2, iMax4, i3, 0, iArr);
            iMax = Math.max(iMax, this.f1712e.getMeasuredHeight() + v(this.f1712e));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1712e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (((g) childAt.getLayoutParams()).f1741b == 0 && Q(childAt)) {
                iMax4 += G(childAt, i2, iMax4, i3, 0, iArr);
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + v(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i6 = this.f1725r + this.f1726s;
        int i7 = this.f1723p + this.f1724q;
        if (Q(this.f1709b)) {
            G(this.f1709b, i2, iMax4 + i7, i3, i6, iArr);
            int measuredWidth3 = this.f1709b.getMeasuredWidth() + u(this.f1709b);
            measuredHeight = this.f1709b.getMeasuredHeight() + v(this.f1709b);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f1709b.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
            measuredHeight = 0;
        }
        if (Q(this.f1710c)) {
            iMax2 = Math.max(iMax2, G(this.f1710c, i2, iMax4 + i7, i3, measuredHeight + i6, iArr));
            measuredHeight += this.f1710c.getMeasuredHeight() + v(this.f1710c);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f1710c.getMeasuredState());
        }
        int iMax5 = Math.max(iMax, measuredHeight);
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax4 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, (-16777216) & iCombineMeasuredStates2), P() ? 0 : View.resolveSizeAndState(Math.max(iMax5 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.a());
        ActionMenuView actionMenuView = this.f1708a;
        androidx.appcompat.view.menu.e eVarL = actionMenuView != null ? actionMenuView.L() : null;
        int i2 = iVar.f1742c;
        if (i2 != 0 && this.f1700L != null && eVarL != null && (menuItemFindItem = eVarL.findItem(i2)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (iVar.f1743d) {
            J();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        h();
        this.f1727t.f(i2 == 1);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.g gVar;
        i iVar = new i(super.onSaveInstanceState());
        f fVar = this.f1700L;
        if (fVar != null && (gVar = fVar.f1739b) != null) {
            iVar.f1742c = gVar.getItemId();
        }
        iVar.f1743d = D();
        return iVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1690B = false;
        }
        if (!this.f1690B) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f1690B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1690B = false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g ? new g((g) layoutParams) : layoutParams instanceof AbstractC0105a.C0022a ? new g((AbstractC0105a.C0022a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new g((ViewGroup.MarginLayoutParams) layoutParams) : new g(layoutParams);
    }

    public void setBackInvokedCallbackEnabled(boolean z2) {
        if (this.f1706R != z2) {
            this.f1706R = z2;
            S();
        }
    }

    public void setCollapseContentDescription(int i2) {
        setCollapseContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setCollapseIcon(int i2) {
        setCollapseIcon(AbstractC0190a.b(getContext(), i2));
    }

    public void setCollapsible(boolean z2) {
        this.f1703O = z2;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.f1729v) {
            this.f1729v = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.f1728u) {
            this.f1728u = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i2) {
        setLogo(AbstractC0190a.b(getContext(), i2));
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(AbstractC0190a.b(getContext(), i2));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        n();
        this.f1711d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(h hVar) {
    }

    public void setOverflowIcon(Drawable drawable) {
        l();
        this.f1708a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i2) {
        if (this.f1718k != i2) {
            this.f1718k = i2;
            if (i2 == 0) {
                this.f1717j = getContext();
            } else {
                this.f1717j = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitleTextColor(int i2) {
        setSubtitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitleMarginBottom(int i2) {
        this.f1726s = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.f1724q = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.f1723p = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.f1725r = i2;
        requestLayout();
    }

    public void setTitleTextColor(int i2) {
        setTitleTextColor(ColorStateList.valueOf(i2));
    }

    public boolean x() {
        f fVar = this.f1700L;
        return (fVar == null || fVar.f1739b == null) ? false : true;
    }

    public boolean y() {
        ActionMenuView actionMenuView = this.f1708a;
        return actionMenuView != null && actionMenuView.F();
    }

    public void z(int i2) {
        getMenuInflater().inflate(i2, getMenu());
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1730w = 8388627;
        this.f1692D = new ArrayList();
        this.f1693E = new ArrayList();
        this.f1694F = new int[2];
        this.f1695G = new C0158w(new Runnable() { // from class: androidx.appcompat.widget.g0
            @Override // java.lang.Runnable
            public final void run() {
                this.f1854a.A();
            }
        });
        this.f1696H = new ArrayList();
        this.f1697I = new a();
        this.f1707S = new b();
        e0 e0VarU = e0.u(getContext(), attributeSet, R$styleable.Toolbar, i2, 0);
        androidx.core.view.L.S(this, context, R$styleable.Toolbar, attributeSet, e0VarU.q(), i2, 0);
        this.f1719l = e0VarU.m(R$styleable.Toolbar_titleTextAppearance, 0);
        this.f1720m = e0VarU.m(R$styleable.Toolbar_subtitleTextAppearance, 0);
        this.f1730w = e0VarU.k(R$styleable.Toolbar_android_gravity, this.f1730w);
        this.f1721n = e0VarU.k(R$styleable.Toolbar_buttonGravity, 48);
        int iD = e0VarU.d(R$styleable.Toolbar_titleMargin, 0);
        iD = e0VarU.r(R$styleable.Toolbar_titleMargins) ? e0VarU.d(R$styleable.Toolbar_titleMargins, iD) : iD;
        this.f1726s = iD;
        this.f1725r = iD;
        this.f1724q = iD;
        this.f1723p = iD;
        int iD2 = e0VarU.d(R$styleable.Toolbar_titleMarginStart, -1);
        if (iD2 >= 0) {
            this.f1723p = iD2;
        }
        int iD3 = e0VarU.d(R$styleable.Toolbar_titleMarginEnd, -1);
        if (iD3 >= 0) {
            this.f1724q = iD3;
        }
        int iD4 = e0VarU.d(R$styleable.Toolbar_titleMarginTop, -1);
        if (iD4 >= 0) {
            this.f1725r = iD4;
        }
        int iD5 = e0VarU.d(R$styleable.Toolbar_titleMarginBottom, -1);
        if (iD5 >= 0) {
            this.f1726s = iD5;
        }
        this.f1722o = e0VarU.e(R$styleable.Toolbar_maxButtonHeight, -1);
        int iD6 = e0VarU.d(R$styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int iD7 = e0VarU.d(R$styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int iE = e0VarU.e(R$styleable.Toolbar_contentInsetLeft, 0);
        int iE2 = e0VarU.e(R$styleable.Toolbar_contentInsetRight, 0);
        h();
        this.f1727t.e(iE, iE2);
        if (iD6 != Integer.MIN_VALUE || iD7 != Integer.MIN_VALUE) {
            this.f1727t.g(iD6, iD7);
        }
        this.f1728u = e0VarU.d(R$styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f1729v = e0VarU.d(R$styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f1713f = e0VarU.f(R$styleable.Toolbar_collapseIcon);
        this.f1714g = e0VarU.o(R$styleable.Toolbar_collapseContentDescription);
        CharSequence charSequenceO = e0VarU.o(R$styleable.Toolbar_title);
        if (!TextUtils.isEmpty(charSequenceO)) {
            setTitle(charSequenceO);
        }
        CharSequence charSequenceO2 = e0VarU.o(R$styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(charSequenceO2)) {
            setSubtitle(charSequenceO2);
        }
        this.f1717j = getContext();
        setPopupTheme(e0VarU.m(R$styleable.Toolbar_popupTheme, 0));
        Drawable drawableF = e0VarU.f(R$styleable.Toolbar_navigationIcon);
        if (drawableF != null) {
            setNavigationIcon(drawableF);
        }
        CharSequence charSequenceO3 = e0VarU.o(R$styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(charSequenceO3)) {
            setNavigationContentDescription(charSequenceO3);
        }
        Drawable drawableF2 = e0VarU.f(R$styleable.Toolbar_logo);
        if (drawableF2 != null) {
            setLogo(drawableF2);
        }
        CharSequence charSequenceO4 = e0VarU.o(R$styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(charSequenceO4)) {
            setLogoDescription(charSequenceO4);
        }
        if (e0VarU.r(R$styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(e0VarU.c(R$styleable.Toolbar_titleTextColor));
        }
        if (e0VarU.r(R$styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(e0VarU.c(R$styleable.Toolbar_subtitleTextColor));
        }
        if (e0VarU.r(R$styleable.Toolbar_menu)) {
            z(e0VarU.m(R$styleable.Toolbar_menu, 0));
        }
        e0VarU.w();
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f1715h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f1715h.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f1715h;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f1713f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            j();
            if (!B(this.f1712e)) {
                c(this.f1712e, true);
            }
        } else {
            ImageView imageView = this.f1712e;
            if (imageView != null && B(imageView)) {
                removeView(this.f1712e);
                this.f1693E.remove(this.f1712e);
            }
        }
        ImageView imageView2 = this.f1712e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            j();
        }
        ImageView imageView = this.f1712e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            n();
        }
        ImageButton imageButton = this.f1711d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            j0.a(this.f1711d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            n();
            if (!B(this.f1711d)) {
                c(this.f1711d, true);
            }
        } else {
            ImageButton imageButton = this.f1711d;
            if (imageButton != null && B(imageButton)) {
                removeView(this.f1711d);
                this.f1693E.remove(this.f1711d);
            }
        }
        ImageButton imageButton2 = this.f1711d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f1710c;
            if (textView != null && B(textView)) {
                removeView(this.f1710c);
                this.f1693E.remove(this.f1710c);
            }
        } else {
            if (this.f1710c == null) {
                Context context = getContext();
                F f2 = new F(context);
                this.f1710c = f2;
                f2.setSingleLine();
                this.f1710c.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.f1720m;
                if (i2 != 0) {
                    this.f1710c.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.f1689A;
                if (colorStateList != null) {
                    this.f1710c.setTextColor(colorStateList);
                }
            }
            if (!B(this.f1710c)) {
                c(this.f1710c, true);
            }
        }
        TextView textView2 = this.f1710c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1732y = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f1689A = colorStateList;
        TextView textView = this.f1710c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f1709b;
            if (textView != null && B(textView)) {
                removeView(this.f1709b);
                this.f1693E.remove(this.f1709b);
            }
        } else {
            if (this.f1709b == null) {
                Context context = getContext();
                F f2 = new F(context);
                this.f1709b = f2;
                f2.setSingleLine();
                this.f1709b.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.f1719l;
                if (i2 != 0) {
                    this.f1709b.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.f1733z;
                if (colorStateList != null) {
                    this.f1709b.setTextColor(colorStateList);
                }
            }
            if (!B(this.f1709b)) {
                c(this.f1709b, true);
            }
        }
        TextView textView2 = this.f1709b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1731x = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f1733z = colorStateList;
        TextView textView = this.f1709b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }
}
