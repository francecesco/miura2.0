package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.AbstractC0183g;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import x.C0265c;

/* JADX INFO: loaded from: classes.dex */
public abstract class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractC0176o f2743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ClassLoader f2744b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f2746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f2747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f2748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f2749g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f2750h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f2751i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    String f2753k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f2754l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    CharSequence f2755m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f2756n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    CharSequence f2757o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ArrayList f2758p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ArrayList f2759q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    ArrayList f2761s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ArrayList f2745c = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f2752j = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f2760r = false;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Fragment f2763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f2764c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2765d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f2766e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f2767f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f2768g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        AbstractC0183g.b f2769h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        AbstractC0183g.b f2770i;

        a() {
        }

        a(int i2, Fragment fragment) {
            this.f2762a = i2;
            this.f2763b = fragment;
            this.f2764c = false;
            AbstractC0183g.b bVar = AbstractC0183g.b.RESUMED;
            this.f2769h = bVar;
            this.f2770i = bVar;
        }

        a(int i2, Fragment fragment, AbstractC0183g.b bVar) {
            this.f2762a = i2;
            this.f2763b = fragment;
            this.f2764c = false;
            this.f2769h = fragment.f2676R;
            this.f2770i = bVar;
        }

        a(int i2, Fragment fragment, boolean z2) {
            this.f2762a = i2;
            this.f2763b = fragment;
            this.f2764c = z2;
            AbstractC0183g.b bVar = AbstractC0183g.b.RESUMED;
            this.f2769h = bVar;
            this.f2770i = bVar;
        }
    }

    G(AbstractC0176o abstractC0176o, ClassLoader classLoader) {
        this.f2743a = abstractC0176o;
        this.f2744b = classLoader;
    }

    public G b(int i2, Fragment fragment) {
        l(i2, fragment, null, 1);
        return this;
    }

    public G c(int i2, Fragment fragment, String str) {
        l(i2, fragment, str, 1);
        return this;
    }

    G d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.f2666H = viewGroup;
        return c(viewGroup.getId(), fragment, str);
    }

    public G e(Fragment fragment, String str) {
        l(0, fragment, str, 1);
        return this;
    }

    void f(a aVar) {
        this.f2745c.add(aVar);
        aVar.f2765d = this.f2746d;
        aVar.f2766e = this.f2747e;
        aVar.f2767f = this.f2748f;
        aVar.f2768g = this.f2749g;
    }

    public abstract int g();

    public abstract int h();

    public abstract void i();

    public abstract void j();

    public G k() {
        if (this.f2751i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f2752j = false;
        return this;
    }

    void l(int i2, Fragment fragment, String str, int i3) {
        String str2 = fragment.f2675Q;
        if (str2 != null) {
            C0265c.f(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.f2711z;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f2711z + " now " + str);
            }
            fragment.f2711z = str;
        }
        if (i2 != 0) {
            if (i2 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i4 = fragment.f2709x;
            if (i4 != 0 && i4 != i2) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f2709x + " now " + i2);
            }
            fragment.f2709x = i2;
            fragment.f2710y = i2;
        }
        f(new a(i3, fragment));
    }

    public G m(Fragment fragment) {
        f(new a(3, fragment));
        return this;
    }

    public G n(int i2, Fragment fragment) {
        return o(i2, fragment, null);
    }

    public G o(int i2, Fragment fragment, String str) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        l(i2, fragment, str, 2);
        return this;
    }

    public G p(Fragment fragment, AbstractC0183g.b bVar) {
        f(new a(10, fragment, bVar));
        return this;
    }

    public G q(boolean z2) {
        this.f2760r = z2;
        return this;
    }
}
