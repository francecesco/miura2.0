package androidx.appcompat.widget;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: loaded from: classes.dex */
class m0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static m0 f1914k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static m0 f1915l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f1916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f1917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f1918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Runnable f1919d = new Runnable() { // from class: androidx.appcompat.widget.k0
        @Override // java.lang.Runnable
        public final void run() {
            this.f1903a.e();
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Runnable f1920e = new Runnable() { // from class: androidx.appcompat.widget.l0
        @Override // java.lang.Runnable
        public final void run() {
            this.f1911a.d();
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1922g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private n0 f1923h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1924i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1925j;

    private m0(View view, CharSequence charSequence) {
        this.f1916a = view;
        this.f1917b = charSequence;
        this.f1918c = androidx.core.view.P.e(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void b() {
        this.f1916a.removeCallbacks(this.f1919d);
    }

    private void c() {
        this.f1925j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        i(false);
    }

    private void f() {
        this.f1916a.postDelayed(this.f1919d, ViewConfiguration.getLongPressTimeout());
    }

    private static void g(m0 m0Var) {
        m0 m0Var2 = f1914k;
        if (m0Var2 != null) {
            m0Var2.b();
        }
        f1914k = m0Var;
        if (m0Var != null) {
            m0Var.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        m0 m0Var = f1914k;
        if (m0Var != null && m0Var.f1916a == view) {
            g(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new m0(view, charSequence);
            return;
        }
        m0 m0Var2 = f1915l;
        if (m0Var2 != null && m0Var2.f1916a == view) {
            m0Var2.d();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    private boolean j(MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        if (!this.f1925j && Math.abs(x2 - this.f1921f) <= this.f1918c && Math.abs(y2 - this.f1922g) <= this.f1918c) {
            return false;
        }
        this.f1921f = x2;
        this.f1922g = y2;
        this.f1925j = false;
        return true;
    }

    void d() {
        if (f1915l == this) {
            f1915l = null;
            n0 n0Var = this.f1923h;
            if (n0Var != null) {
                n0Var.c();
                this.f1923h = null;
                c();
                this.f1916a.removeOnAttachStateChangeListener(this);
            }
        }
        if (f1914k == this) {
            g(null);
        }
        this.f1916a.removeCallbacks(this.f1920e);
    }

    void i(boolean z2) {
        long longPressTimeout;
        long j2;
        long j3;
        if (this.f1916a.isAttachedToWindow()) {
            g(null);
            m0 m0Var = f1915l;
            if (m0Var != null) {
                m0Var.d();
            }
            f1915l = this;
            this.f1924i = z2;
            n0 n0Var = new n0(this.f1916a.getContext());
            this.f1923h = n0Var;
            n0Var.e(this.f1916a, this.f1921f, this.f1922g, this.f1924i, this.f1917b);
            this.f1916a.addOnAttachStateChangeListener(this);
            if (this.f1924i) {
                j3 = 2500;
            } else {
                if ((androidx.core.view.L.C(this.f1916a) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j2 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j2 = 15000;
                }
                j3 = j2 - longPressTimeout;
            }
            this.f1916a.removeCallbacks(this.f1920e);
            this.f1916a.postDelayed(this.f1920e, j3);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1923h != null && this.f1924i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1916a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f1916a.isEnabled() && this.f1923h == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1921f = view.getWidth() / 2;
        this.f1922g = view.getHeight() / 2;
        i(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        d();
    }
}
