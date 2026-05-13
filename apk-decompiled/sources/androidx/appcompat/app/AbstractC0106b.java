package androidx.appcompat.app;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import f.C0194d;

/* JADX INFO: renamed from: androidx.appcompat.app.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0106b implements DrawerLayout.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0023b f996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DrawerLayout f997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C0194d f998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f1000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f1001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1002g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f1003h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f1004i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    View.OnClickListener f1005j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f1006k;

    /* JADX INFO: renamed from: androidx.appcompat.app.b$a */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AbstractC0106b abstractC0106b = AbstractC0106b.this;
            if (abstractC0106b.f1001f) {
                abstractC0106b.k();
                return;
            }
            View.OnClickListener onClickListener = abstractC0106b.f1005j;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.b$b, reason: collision with other inner class name */
    public interface InterfaceC0023b {
        void a(int i2);

        void b(Drawable drawable, int i2);

        Context c();

        boolean d();

        Drawable e();
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.b$c */
    public interface c {
        InterfaceC0023b w();
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.b$d */
    private static class d implements InterfaceC0023b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f1008a;

        d(Activity activity) {
            this.f1008a = activity;
        }

        @Override // androidx.appcompat.app.AbstractC0106b.InterfaceC0023b
        public void a(int i2) {
            ActionBar actionBar = this.f1008a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i2);
            }
        }

        @Override // androidx.appcompat.app.AbstractC0106b.InterfaceC0023b
        public void b(Drawable drawable, int i2) {
            ActionBar actionBar = this.f1008a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i2);
            }
        }

        @Override // androidx.appcompat.app.AbstractC0106b.InterfaceC0023b
        public Context c() {
            ActionBar actionBar = this.f1008a.getActionBar();
            return actionBar != null ? actionBar.getThemedContext() : this.f1008a;
        }

        @Override // androidx.appcompat.app.AbstractC0106b.InterfaceC0023b
        public boolean d() {
            ActionBar actionBar = this.f1008a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // androidx.appcompat.app.AbstractC0106b.InterfaceC0023b
        public Drawable e() {
            TypedArray typedArrayObtainStyledAttributes = c().obtainStyledAttributes(null, new int[]{R.attr.homeAsUpIndicator}, R.attr.actionBarStyle, 0);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
            typedArrayObtainStyledAttributes.recycle();
            return drawable;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.b$e */
    static class e implements InterfaceC0023b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Toolbar f1009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Drawable f1010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CharSequence f1011c;

        e(Toolbar toolbar) {
            this.f1009a = toolbar;
            this.f1010b = toolbar.getNavigationIcon();
            this.f1011c = toolbar.getNavigationContentDescription();
        }

        @Override // androidx.appcompat.app.AbstractC0106b.InterfaceC0023b
        public void a(int i2) {
            if (i2 == 0) {
                this.f1009a.setNavigationContentDescription(this.f1011c);
            } else {
                this.f1009a.setNavigationContentDescription(i2);
            }
        }

        @Override // androidx.appcompat.app.AbstractC0106b.InterfaceC0023b
        public void b(Drawable drawable, int i2) {
            this.f1009a.setNavigationIcon(drawable);
            a(i2);
        }

        @Override // androidx.appcompat.app.AbstractC0106b.InterfaceC0023b
        public Context c() {
            return this.f1009a.getContext();
        }

        @Override // androidx.appcompat.app.AbstractC0106b.InterfaceC0023b
        public boolean d() {
            return true;
        }

        @Override // androidx.appcompat.app.AbstractC0106b.InterfaceC0023b
        public Drawable e() {
            return this.f1010b;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    AbstractC0106b(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, C0194d c0194d, int i2, int i3) {
        this.f999d = true;
        this.f1001f = true;
        this.f1006k = false;
        if (toolbar != null) {
            this.f996a = new e(toolbar);
            toolbar.setNavigationOnClickListener(new a());
        } else if (activity instanceof c) {
            this.f996a = ((c) activity).w();
        } else {
            this.f996a = new d(activity);
        }
        this.f997b = drawerLayout;
        this.f1003h = i2;
        this.f1004i = i3;
        if (c0194d == null) {
            this.f998c = new C0194d(this.f996a.c());
        } else {
            this.f998c = c0194d;
        }
        this.f1000e = e();
    }

    private void i(float f2) {
        C0194d c0194d;
        boolean z2;
        if (f2 != 1.0f) {
            if (f2 == 0.0f) {
                c0194d = this.f998c;
                z2 = false;
            }
            this.f998c.e(f2);
        }
        c0194d = this.f998c;
        z2 = true;
        c0194d.g(z2);
        this.f998c.e(f2);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.d
    public void a(int i2) {
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.d
    public void b(View view) {
        i(1.0f);
        if (this.f1001f) {
            g(this.f1004i);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.d
    public void c(View view, float f2) {
        if (this.f999d) {
            i(Math.min(1.0f, Math.max(0.0f, f2)));
        } else {
            i(0.0f);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.d
    public void d(View view) {
        i(0.0f);
        if (this.f1001f) {
            g(this.f1003h);
        }
    }

    Drawable e() {
        return this.f996a.e();
    }

    public void f(Configuration configuration) {
        if (!this.f1002g) {
            this.f1000e = e();
        }
        j();
    }

    void g(int i2) {
        this.f996a.a(i2);
    }

    void h(Drawable drawable, int i2) {
        if (!this.f1006k && !this.f996a.d()) {
            this.f1006k = true;
        }
        this.f996a.b(drawable, i2);
    }

    public void j() {
        i(this.f997b.C(8388611) ? 1.0f : 0.0f);
        if (this.f1001f) {
            h(this.f998c, this.f997b.C(8388611) ? this.f1004i : this.f1003h);
        }
    }

    void k() {
        int iQ = this.f997b.q(8388611);
        if (this.f997b.F(8388611) && iQ != 2) {
            this.f997b.d(8388611);
        } else if (iQ != 1) {
            this.f997b.K(8388611);
        }
    }

    public AbstractC0106b(Activity activity, DrawerLayout drawerLayout, int i2, int i3) {
        this(activity, null, drawerLayout, null, i2, i3);
    }
}
