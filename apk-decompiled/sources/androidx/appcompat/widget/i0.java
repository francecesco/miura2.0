package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$drawable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.j;
import e.AbstractC0190a;
import h.C0197a;

/* JADX INFO: loaded from: classes.dex */
public class i0 implements M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Toolbar f1866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f1868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f1869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f1870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f1871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f1872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    CharSequence f1874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CharSequence f1875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence f1876k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Window.Callback f1877l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f1878m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private C0114c f1879n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f1880o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f1881p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Drawable f1882q;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final C0197a f1883a;

        a() {
            this.f1883a = new C0197a(i0.this.f1866a.getContext(), 0, R.id.home, 0, 0, i0.this.f1874i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i0 i0Var = i0.this;
            Window.Callback callback = i0Var.f1877l;
            if (callback == null || !i0Var.f1878m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f1883a);
        }
    }

    class b extends androidx.core.view.W {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1885a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f1886b;

        b(int i2) {
            this.f1886b = i2;
        }

        @Override // androidx.core.view.V
        public void a(View view) {
            if (this.f1885a) {
                return;
            }
            i0.this.f1866a.setVisibility(this.f1886b);
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void b(View view) {
            i0.this.f1866a.setVisibility(0);
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void c(View view) {
            this.f1885a = true;
        }
    }

    public i0(Toolbar toolbar, boolean z2) {
        this(toolbar, z2, R$string.abc_action_bar_up_description, R$drawable.abc_ic_ab_back_material);
    }

    private void D(CharSequence charSequence) {
        this.f1874i = charSequence;
        if ((this.f1867b & 8) != 0) {
            this.f1866a.setTitle(charSequence);
            if (this.f1873h) {
                androidx.core.view.L.W(this.f1866a.getRootView(), charSequence);
            }
        }
    }

    private void E() {
        if ((this.f1867b & 4) != 0) {
            if (TextUtils.isEmpty(this.f1876k)) {
                this.f1866a.setNavigationContentDescription(this.f1881p);
            } else {
                this.f1866a.setNavigationContentDescription(this.f1876k);
            }
        }
    }

    private void F() {
        Toolbar toolbar;
        Drawable drawable;
        if ((this.f1867b & 4) != 0) {
            toolbar = this.f1866a;
            drawable = this.f1872g;
            if (drawable == null) {
                drawable = this.f1882q;
            }
        } else {
            toolbar = this.f1866a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void G() {
        Drawable drawable;
        int i2 = this.f1867b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) == 0 || (drawable = this.f1871f) == null) {
            drawable = this.f1870e;
        }
        this.f1866a.setLogo(drawable);
    }

    private int y() {
        if (this.f1866a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1882q = this.f1866a.getNavigationIcon();
        return 15;
    }

    public void A(int i2) {
        if (i2 == this.f1881p) {
            return;
        }
        this.f1881p = i2;
        if (TextUtils.isEmpty(this.f1866a.getNavigationContentDescription())) {
            n(this.f1881p);
        }
    }

    public void B(Drawable drawable) {
        this.f1871f = drawable;
        G();
    }

    public void C(CharSequence charSequence) {
        this.f1876k = charSequence;
        E();
    }

    @Override // androidx.appcompat.widget.M
    public void a(Menu menu, j.a aVar) {
        if (this.f1879n == null) {
            C0114c c0114c = new C0114c(this.f1866a.getContext());
            this.f1879n = c0114c;
            c0114c.p(R$id.action_menu_presenter);
        }
        this.f1879n.h(aVar);
        this.f1866a.M((androidx.appcompat.view.menu.e) menu, this.f1879n);
    }

    @Override // androidx.appcompat.widget.M
    public boolean b() {
        return this.f1866a.C();
    }

    @Override // androidx.appcompat.widget.M
    public boolean c() {
        return this.f1866a.D();
    }

    @Override // androidx.appcompat.widget.M
    public void collapseActionView() {
        this.f1866a.e();
    }

    @Override // androidx.appcompat.widget.M
    public boolean d() {
        return this.f1866a.y();
    }

    @Override // androidx.appcompat.widget.M
    public boolean e() {
        return this.f1866a.R();
    }

    @Override // androidx.appcompat.widget.M
    public void f() {
        this.f1878m = true;
    }

    @Override // androidx.appcompat.widget.M
    public boolean g() {
        return this.f1866a.d();
    }

    @Override // androidx.appcompat.widget.M
    public CharSequence getTitle() {
        return this.f1866a.getTitle();
    }

    @Override // androidx.appcompat.widget.M
    public void h() {
        this.f1866a.f();
    }

    @Override // androidx.appcompat.widget.M
    public void i(CharSequence charSequence) {
        this.f1875j = charSequence;
        if ((this.f1867b & 8) != 0) {
            this.f1866a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.M
    public int j() {
        return this.f1867b;
    }

    @Override // androidx.appcompat.widget.M
    public void k(int i2) {
        this.f1866a.setVisibility(i2);
    }

    @Override // androidx.appcompat.widget.M
    public void l(int i2) {
        B(i2 != 0 ? AbstractC0190a.b(p(), i2) : null);
    }

    @Override // androidx.appcompat.widget.M
    public void m(Z z2) {
        View view = this.f1868c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f1866a;
            if (parent == toolbar) {
                toolbar.removeView(this.f1868c);
            }
        }
        this.f1868c = z2;
    }

    @Override // androidx.appcompat.widget.M
    public void n(int i2) {
        C(i2 == 0 ? null : p().getString(i2));
    }

    @Override // androidx.appcompat.widget.M
    public void o(boolean z2) {
    }

    @Override // androidx.appcompat.widget.M
    public Context p() {
        return this.f1866a.getContext();
    }

    @Override // androidx.appcompat.widget.M
    public int q() {
        return this.f1880o;
    }

    @Override // androidx.appcompat.widget.M
    public androidx.core.view.U r(int i2, long j2) {
        return androidx.core.view.L.c(this.f1866a).b(i2 == 0 ? 1.0f : 0.0f).f(j2).h(new b(i2));
    }

    @Override // androidx.appcompat.widget.M
    public void s() {
    }

    @Override // androidx.appcompat.widget.M
    public void setIcon(int i2) {
        setIcon(i2 != 0 ? AbstractC0190a.b(p(), i2) : null);
    }

    @Override // androidx.appcompat.widget.M
    public void setTitle(CharSequence charSequence) {
        this.f1873h = true;
        D(charSequence);
    }

    @Override // androidx.appcompat.widget.M
    public void setWindowCallback(Window.Callback callback) {
        this.f1877l = callback;
    }

    @Override // androidx.appcompat.widget.M
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f1873h) {
            return;
        }
        D(charSequence);
    }

    @Override // androidx.appcompat.widget.M
    public boolean t() {
        return this.f1866a.x();
    }

    @Override // androidx.appcompat.widget.M
    public void u() {
    }

    @Override // androidx.appcompat.widget.M
    public void v(Drawable drawable) {
        this.f1872g = drawable;
        F();
    }

    @Override // androidx.appcompat.widget.M
    public void w(boolean z2) {
        this.f1866a.setCollapsible(z2);
    }

    @Override // androidx.appcompat.widget.M
    public void x(int i2) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i3 = this.f1867b ^ i2;
        this.f1867b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    E();
                }
                F();
            }
            if ((i3 & 3) != 0) {
                G();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f1866a.setTitle(this.f1874i);
                    toolbar = this.f1866a;
                    charSequence = this.f1875j;
                } else {
                    charSequence = null;
                    this.f1866a.setTitle((CharSequence) null);
                    toolbar = this.f1866a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i3 & 16) == 0 || (view = this.f1869d) == null) {
                return;
            }
            if ((i2 & 16) != 0) {
                this.f1866a.addView(view);
            } else {
                this.f1866a.removeView(view);
            }
        }
    }

    public void z(View view) {
        View view2 = this.f1869d;
        if (view2 != null && (this.f1867b & 16) != 0) {
            this.f1866a.removeView(view2);
        }
        this.f1869d = view;
        if (view == null || (this.f1867b & 16) == 0) {
            return;
        }
        this.f1866a.addView(view);
    }

    public i0(Toolbar toolbar, boolean z2, int i2, int i3) {
        Drawable drawable;
        this.f1880o = 0;
        this.f1881p = 0;
        this.f1866a = toolbar;
        this.f1874i = toolbar.getTitle();
        this.f1875j = toolbar.getSubtitle();
        this.f1873h = this.f1874i != null;
        this.f1872g = toolbar.getNavigationIcon();
        e0 e0VarU = e0.u(toolbar.getContext(), null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        this.f1882q = e0VarU.f(R$styleable.ActionBar_homeAsUpIndicator);
        if (z2) {
            CharSequence charSequenceO = e0VarU.o(R$styleable.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceO)) {
                setTitle(charSequenceO);
            }
            CharSequence charSequenceO2 = e0VarU.o(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceO2)) {
                i(charSequenceO2);
            }
            Drawable drawableF = e0VarU.f(R$styleable.ActionBar_logo);
            if (drawableF != null) {
                B(drawableF);
            }
            Drawable drawableF2 = e0VarU.f(R$styleable.ActionBar_icon);
            if (drawableF2 != null) {
                setIcon(drawableF2);
            }
            if (this.f1872g == null && (drawable = this.f1882q) != null) {
                v(drawable);
            }
            x(e0VarU.j(R$styleable.ActionBar_displayOptions, 0));
            int iM = e0VarU.m(R$styleable.ActionBar_customNavigationLayout, 0);
            if (iM != 0) {
                z(LayoutInflater.from(this.f1866a.getContext()).inflate(iM, (ViewGroup) this.f1866a, false));
                x(this.f1867b | 16);
            }
            int iL = e0VarU.l(R$styleable.ActionBar_height, 0);
            if (iL > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1866a.getLayoutParams();
                layoutParams.height = iL;
                this.f1866a.setLayoutParams(layoutParams);
            }
            int iD = e0VarU.d(R$styleable.ActionBar_contentInsetStart, -1);
            int iD2 = e0VarU.d(R$styleable.ActionBar_contentInsetEnd, -1);
            if (iD >= 0 || iD2 >= 0) {
                this.f1866a.L(Math.max(iD, 0), Math.max(iD2, 0));
            }
            int iM2 = e0VarU.m(R$styleable.ActionBar_titleTextStyle, 0);
            if (iM2 != 0) {
                Toolbar toolbar2 = this.f1866a;
                toolbar2.O(toolbar2.getContext(), iM2);
            }
            int iM3 = e0VarU.m(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (iM3 != 0) {
                Toolbar toolbar3 = this.f1866a;
                toolbar3.N(toolbar3.getContext(), iM3);
            }
            int iM4 = e0VarU.m(R$styleable.ActionBar_popupTheme, 0);
            if (iM4 != 0) {
                this.f1866a.setPopupTheme(iM4);
            }
        } else {
            this.f1867b = y();
        }
        e0VarU.w();
        A(i2);
        this.f1876k = this.f1866a.getNavigationContentDescription();
        this.f1866a.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.M
    public void setIcon(Drawable drawable) {
        this.f1870e = drawable;
        G();
    }
}
