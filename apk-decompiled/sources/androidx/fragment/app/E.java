package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AbstractC0183g;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class E extends androidx.viewpager.widget.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x f2647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private G f2649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList f2650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList f2651g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Fragment f2652h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f2653i;

    public E(x xVar) {
        this(xVar, 0);
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f2649e == null) {
            this.f2649e = this.f2647c.o();
        }
        while (this.f2650f.size() <= i2) {
            this.f2650f.add(null);
        }
        this.f2650f.set(i2, fragment.X() ? this.f2647c.k1(fragment) : null);
        this.f2651g.set(i2, null);
        this.f2649e.m(fragment);
        if (fragment.equals(this.f2652h)) {
            this.f2652h = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void b(ViewGroup viewGroup) {
        G g2 = this.f2649e;
        if (g2 != null) {
            if (!this.f2653i) {
                try {
                    this.f2653i = true;
                    g2.j();
                } finally {
                    this.f2653i = false;
                }
            }
            this.f2649e = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public Object g(ViewGroup viewGroup, int i2) {
        Fragment.j jVar;
        Fragment fragment;
        if (this.f2651g.size() > i2 && (fragment = (Fragment) this.f2651g.get(i2)) != null) {
            return fragment;
        }
        if (this.f2649e == null) {
            this.f2649e = this.f2647c.o();
        }
        Fragment fragmentP = p(i2);
        if (this.f2650f.size() > i2 && (jVar = (Fragment.j) this.f2650f.get(i2)) != null) {
            fragmentP.w1(jVar);
        }
        while (this.f2651g.size() <= i2) {
            this.f2651g.add(null);
        }
        fragmentP.x1(false);
        if (this.f2648d == 0) {
            fragmentP.C1(false);
        }
        this.f2651g.set(i2, fragmentP);
        this.f2649e.b(viewGroup.getId(), fragmentP);
        if (this.f2648d == 1) {
            this.f2649e.p(fragmentP, AbstractC0183g.b.STARTED);
        }
        return fragmentP;
    }

    @Override // androidx.viewpager.widget.a
    public boolean h(View view, Object obj) {
        return ((Fragment) obj).S() == view;
    }

    @Override // androidx.viewpager.widget.a
    public void j(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f2650f.clear();
            this.f2651g.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f2650f.add((Fragment.j) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int i2 = Integer.parseInt(str.substring(1));
                    Fragment fragmentQ0 = this.f2647c.q0(bundle, str);
                    if (fragmentQ0 != null) {
                        while (this.f2651g.size() <= i2) {
                            this.f2651g.add(null);
                        }
                        fragmentQ0.x1(false);
                        this.f2651g.set(i2, fragmentQ0);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Bad fragment at key ");
                        sb.append(str);
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.a
    public void l(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f2652h;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.x1(false);
                if (this.f2648d == 1) {
                    if (this.f2649e == null) {
                        this.f2649e = this.f2647c.o();
                    }
                    this.f2649e.p(this.f2652h, AbstractC0183g.b.STARTED);
                } else {
                    this.f2652h.C1(false);
                }
            }
            fragment.x1(true);
            if (this.f2648d == 1) {
                if (this.f2649e == null) {
                    this.f2649e = this.f2647c.o();
                }
                this.f2649e.p(fragment, AbstractC0183g.b.RESUMED);
            } else {
                fragment.C1(true);
            }
            this.f2652h = fragment;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void n(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public abstract Fragment p(int i2);

    public E(x xVar, int i2) {
        this.f2649e = null;
        this.f2650f = new ArrayList();
        this.f2651g = new ArrayList();
        this.f2652h = null;
        this.f2647c = xVar;
        this.f2648d = i2;
    }
}
