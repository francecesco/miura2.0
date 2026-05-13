package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.M;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.L;
import androidx.core.view.U;
import androidx.core.view.V;
import androidx.core.view.W;
import androidx.core.view.X;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class G extends AbstractC0105a implements ActionBarOverlayLayout.d {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final Interpolator f956D = new AccelerateInterpolator();

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final Interpolator f957E = new DecelerateInterpolator();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Activity f963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ActionBarOverlayLayout f964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ActionBarContainer f965e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    M f966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ActionBarContextView f967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    View f968h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f971k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    d f972l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    androidx.appcompat.view.b f973m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    b.a f974n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f975o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f977q;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    boolean f980t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f981u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f982v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    androidx.appcompat.view.h f984x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f985y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    boolean f986z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList f969i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f970j = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ArrayList f976p = new ArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f978r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    boolean f979s = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f983w = true;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    final V f958A = new a();

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    final V f959B = new b();

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    final X f960C = new c();

    class a extends W {
        a() {
        }

        @Override // androidx.core.view.V
        public void a(View view) {
            View view2;
            G g2 = G.this;
            if (g2.f979s && (view2 = g2.f968h) != null) {
                view2.setTranslationY(0.0f);
                G.this.f965e.setTranslationY(0.0f);
            }
            G.this.f965e.setVisibility(8);
            G.this.f965e.setTransitioning(false);
            G g3 = G.this;
            g3.f984x = null;
            g3.F();
            ActionBarOverlayLayout actionBarOverlayLayout = G.this.f964d;
            if (actionBarOverlayLayout != null) {
                L.R(actionBarOverlayLayout);
            }
        }
    }

    class b extends W {
        b() {
        }

        @Override // androidx.core.view.V
        public void a(View view) {
            G g2 = G.this;
            g2.f984x = null;
            g2.f965e.requestLayout();
        }
    }

    class c implements X {
        c() {
        }

        @Override // androidx.core.view.X
        public void a(View view) {
            ((View) G.this.f965e.getParent()).invalidate();
        }
    }

    public class d extends androidx.appcompat.view.b implements e.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Context f990c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final androidx.appcompat.view.menu.e f991d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private b.a f992e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private WeakReference f993f;

        public d(Context context, b.a aVar) {
            this.f990c = context;
            this.f992e = aVar;
            androidx.appcompat.view.menu.e eVarT = new androidx.appcompat.view.menu.e(context).T(1);
            this.f991d = eVarT;
            eVarT.S(this);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            b.a aVar = this.f992e;
            if (aVar != null) {
                return aVar.b(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (this.f992e == null) {
                return;
            }
            k();
            G.this.f967g.l();
        }

        @Override // androidx.appcompat.view.b
        public void c() {
            G g2 = G.this;
            if (g2.f972l != this) {
                return;
            }
            if (G.E(g2.f980t, g2.f981u, false)) {
                this.f992e.d(this);
            } else {
                G g3 = G.this;
                g3.f973m = this;
                g3.f974n = this.f992e;
            }
            this.f992e = null;
            G.this.D(false);
            G.this.f967g.g();
            G g4 = G.this;
            g4.f964d.setHideOnContentScrollEnabled(g4.f986z);
            G.this.f972l = null;
        }

        @Override // androidx.appcompat.view.b
        public View d() {
            WeakReference weakReference = this.f993f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.b
        public Menu e() {
            return this.f991d;
        }

        @Override // androidx.appcompat.view.b
        public MenuInflater f() {
            return new androidx.appcompat.view.g(this.f990c);
        }

        @Override // androidx.appcompat.view.b
        public CharSequence g() {
            return G.this.f967g.getSubtitle();
        }

        @Override // androidx.appcompat.view.b
        public CharSequence i() {
            return G.this.f967g.getTitle();
        }

        @Override // androidx.appcompat.view.b
        public void k() {
            if (G.this.f972l != this) {
                return;
            }
            this.f991d.e0();
            try {
                this.f992e.a(this, this.f991d);
            } finally {
                this.f991d.d0();
            }
        }

        @Override // androidx.appcompat.view.b
        public boolean l() {
            return G.this.f967g.j();
        }

        @Override // androidx.appcompat.view.b
        public void m(View view) {
            G.this.f967g.setCustomView(view);
            this.f993f = new WeakReference(view);
        }

        @Override // androidx.appcompat.view.b
        public void n(int i2) {
            o(G.this.f961a.getResources().getString(i2));
        }

        @Override // androidx.appcompat.view.b
        public void o(CharSequence charSequence) {
            G.this.f967g.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void q(int i2) {
            r(G.this.f961a.getResources().getString(i2));
        }

        @Override // androidx.appcompat.view.b
        public void r(CharSequence charSequence) {
            G.this.f967g.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void s(boolean z2) {
            super.s(z2);
            G.this.f967g.setTitleOptional(z2);
        }

        public boolean t() {
            this.f991d.e0();
            try {
                return this.f992e.c(this, this.f991d);
            } finally {
                this.f991d.d0();
            }
        }
    }

    public G(Activity activity, boolean z2) {
        this.f963c = activity;
        View decorView = activity.getWindow().getDecorView();
        L(decorView);
        if (z2) {
            return;
        }
        this.f968h = decorView.findViewById(R.id.content);
    }

    static boolean E(boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return true;
        }
        return (z2 || z3) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private M I(View view) {
        if (view instanceof M) {
            return (M) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void K() {
        if (this.f982v) {
            this.f982v = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f964d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            S(false);
        }
    }

    private void L(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.decor_content_parent);
        this.f964d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f966f = I(view.findViewById(R$id.action_bar));
        this.f967g = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        this.f965e = actionBarContainer;
        M m2 = this.f966f;
        if (m2 == null || this.f967g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f961a = m2.p();
        boolean z2 = (this.f966f.j() & 4) != 0;
        if (z2) {
            this.f971k = true;
        }
        androidx.appcompat.view.a aVarB = androidx.appcompat.view.a.b(this.f961a);
        w(aVarB.a() || z2);
        O(aVarB.e());
        TypedArray typedArrayObtainStyledAttributes = this.f961a.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
            P(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            N(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void O(boolean z2) {
        this.f977q = z2;
        if (z2) {
            this.f965e.setTabContainer(null);
            this.f966f.m(null);
        } else {
            this.f966f.m(null);
            this.f965e.setTabContainer(null);
        }
        boolean z3 = false;
        boolean z4 = J() == 2;
        this.f966f.w(!this.f977q && z4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f964d;
        if (!this.f977q && z4) {
            z3 = true;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z3);
    }

    private boolean Q() {
        return this.f965e.isLaidOut();
    }

    private void R() {
        if (this.f982v) {
            return;
        }
        this.f982v = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f964d;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        S(false);
    }

    private void S(boolean z2) {
        if (E(this.f980t, this.f981u, this.f982v)) {
            if (this.f983w) {
                return;
            }
            this.f983w = true;
            H(z2);
            return;
        }
        if (this.f983w) {
            this.f983w = false;
            G(z2);
        }
    }

    @Override // androidx.appcompat.app.AbstractC0105a
    public void A(CharSequence charSequence) {
        this.f966f.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AbstractC0105a
    public void B(CharSequence charSequence) {
        this.f966f.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AbstractC0105a
    public androidx.appcompat.view.b C(b.a aVar) {
        d dVar = this.f972l;
        if (dVar != null) {
            dVar.c();
        }
        this.f964d.setHideOnContentScrollEnabled(false);
        this.f967g.k();
        d dVar2 = new d(this.f967g.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.f972l = dVar2;
        dVar2.k();
        this.f967g.h(dVar2);
        D(true);
        return dVar2;
    }

    public void D(boolean z2) {
        U uR;
        U uF;
        if (z2) {
            R();
        } else {
            K();
        }
        if (!Q()) {
            if (z2) {
                this.f966f.k(4);
                this.f967g.setVisibility(0);
                return;
            } else {
                this.f966f.k(0);
                this.f967g.setVisibility(8);
                return;
            }
        }
        if (z2) {
            uF = this.f966f.r(4, 100L);
            uR = this.f967g.f(0, 200L);
        } else {
            uR = this.f966f.r(0, 200L);
            uF = this.f967g.f(8, 100L);
        }
        androidx.appcompat.view.h hVar = new androidx.appcompat.view.h();
        hVar.d(uF, uR);
        hVar.h();
    }

    void F() {
        b.a aVar = this.f974n;
        if (aVar != null) {
            aVar.d(this.f973m);
            this.f973m = null;
            this.f974n = null;
        }
    }

    public void G(boolean z2) {
        View view;
        androidx.appcompat.view.h hVar = this.f984x;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f978r != 0 || (!this.f985y && !z2)) {
            this.f958A.a(null);
            return;
        }
        this.f965e.setAlpha(1.0f);
        this.f965e.setTransitioning(true);
        androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
        float f2 = -this.f965e.getHeight();
        if (z2) {
            this.f965e.getLocationInWindow(new int[]{0, 0});
            f2 -= r5[1];
        }
        U uM = L.c(this.f965e).m(f2);
        uM.k(this.f960C);
        hVar2.c(uM);
        if (this.f979s && (view = this.f968h) != null) {
            hVar2.c(L.c(view).m(f2));
        }
        hVar2.f(f956D);
        hVar2.e(250L);
        hVar2.g(this.f958A);
        this.f984x = hVar2;
        hVar2.h();
    }

    public void H(boolean z2) {
        View view;
        View view2;
        androidx.appcompat.view.h hVar = this.f984x;
        if (hVar != null) {
            hVar.a();
        }
        this.f965e.setVisibility(0);
        if (this.f978r == 0 && (this.f985y || z2)) {
            this.f965e.setTranslationY(0.0f);
            float f2 = -this.f965e.getHeight();
            if (z2) {
                this.f965e.getLocationInWindow(new int[]{0, 0});
                f2 -= r5[1];
            }
            this.f965e.setTranslationY(f2);
            androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
            U uM = L.c(this.f965e).m(0.0f);
            uM.k(this.f960C);
            hVar2.c(uM);
            if (this.f979s && (view2 = this.f968h) != null) {
                view2.setTranslationY(f2);
                hVar2.c(L.c(this.f968h).m(0.0f));
            }
            hVar2.f(f957E);
            hVar2.e(250L);
            hVar2.g(this.f959B);
            this.f984x = hVar2;
            hVar2.h();
        } else {
            this.f965e.setAlpha(1.0f);
            this.f965e.setTranslationY(0.0f);
            if (this.f979s && (view = this.f968h) != null) {
                view.setTranslationY(0.0f);
            }
            this.f959B.a(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f964d;
        if (actionBarOverlayLayout != null) {
            L.R(actionBarOverlayLayout);
        }
    }

    public int J() {
        return this.f966f.q();
    }

    public void M(int i2, int i3) {
        int iJ = this.f966f.j();
        if ((i3 & 4) != 0) {
            this.f971k = true;
        }
        this.f966f.x((i2 & i3) | ((~i3) & iJ));
    }

    public void N(float f2) {
        L.Z(this.f965e, f2);
    }

    public void P(boolean z2) {
        if (z2 && !this.f964d.x()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f986z = z2;
        this.f964d.setHideOnContentScrollEnabled(z2);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a(boolean z2) {
        this.f979s = z2;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
        if (this.f981u) {
            this.f981u = false;
            S(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c() {
        androidx.appcompat.view.h hVar = this.f984x;
        if (hVar != null) {
            hVar.a();
            this.f984x = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d(int i2) {
        this.f978r = i2;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        if (this.f981u) {
            return;
        }
        this.f981u = true;
        S(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f() {
    }

    @Override // androidx.appcompat.app.AbstractC0105a
    public boolean h() {
        M m2 = this.f966f;
        if (m2 == null || !m2.t()) {
            return false;
        }
        this.f966f.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.AbstractC0105a
    public void i(boolean z2) {
        if (z2 == this.f975o) {
            return;
        }
        this.f975o = z2;
        if (this.f976p.size() <= 0) {
            return;
        }
        android.support.v4.media.session.b.a(this.f976p.get(0));
        throw null;
    }

    @Override // androidx.appcompat.app.AbstractC0105a
    public int j() {
        return this.f966f.j();
    }

    @Override // androidx.appcompat.app.AbstractC0105a
    public Context k() {
        if (this.f962b == null) {
            TypedValue typedValue = new TypedValue();
            this.f961a.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f962b = new ContextThemeWrapper(this.f961a, i2);
            } else {
                this.f962b = this.f961a;
            }
        }
        return this.f962b;
    }

    @Override // androidx.appcompat.app.AbstractC0105a
    public void m(Configuration configuration) {
        O(androidx.appcompat.view.a.b(this.f961a).e());
    }

    @Override // androidx.appcompat.app.AbstractC0105a
    public boolean o(int i2, KeyEvent keyEvent) {
        Menu menuE;
        d dVar = this.f972l;
        if (dVar == null || (menuE = dVar.e()) == null) {
            return false;
        }
        menuE.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE.performShortcut(i2, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.AbstractC0105a
    public void r(Drawable drawable) {
        this.f965e.setPrimaryBackground(drawable);
    }

    @Override // androidx.appcompat.app.AbstractC0105a
    public void s(boolean z2) {
        if (this.f971k) {
            return;
        }
        t(z2);
    }

    @Override // androidx.appcompat.app.AbstractC0105a
    public void t(boolean z2) {
        M(z2 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.AbstractC0105a
    public void u(int i2) {
        this.f966f.n(i2);
    }

    @Override // androidx.appcompat.app.AbstractC0105a
    public void v(Drawable drawable) {
        this.f966f.v(drawable);
    }

    @Override // androidx.appcompat.app.AbstractC0105a
    public void w(boolean z2) {
        this.f966f.o(z2);
    }

    @Override // androidx.appcompat.app.AbstractC0105a
    public void x(boolean z2) {
        androidx.appcompat.view.h hVar;
        this.f985y = z2;
        if (z2 || (hVar = this.f984x) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.AbstractC0105a
    public void y(CharSequence charSequence) {
        this.f966f.i(charSequence);
    }

    @Override // androidx.appcompat.app.AbstractC0105a
    public void z(int i2) {
        A(this.f961a.getString(i2));
    }

    public G(Dialog dialog) {
        L(dialog.getWindow().getDecorView());
    }
}
