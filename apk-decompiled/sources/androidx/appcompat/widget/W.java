package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.resources.R$drawable;
import f.C0191a;
import g.AbstractC0196a;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import k.C0210d;
import k.C0211e;
import k.C0213g;
import k.C0214h;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class W {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static W f1755i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakHashMap f1757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C0213g f1758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C0214h f1759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WeakHashMap f1760d = new WeakHashMap(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TypedValue f1761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private f f1763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final PorterDuff.Mode f1754h = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final c f1756j = new c(6);

    static class a implements e {
        a() {
        }

        @Override // androidx.appcompat.widget.W.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return C0191a.l(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    private static class b implements e {
        b() {
        }

        @Override // androidx.appcompat.widget.W.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.b.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    private static class c extends C0211e {
        public c(int i2) {
            super(i2);
        }

        private static int h(int i2, PorterDuff.Mode mode) {
            return ((i2 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter i(int i2, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) c(Integer.valueOf(h(i2, mode)));
        }

        PorterDuffColorFilter j(int i2, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) d(Integer.valueOf(h(i2, mode)), porterDuffColorFilter);
        }
    }

    static class d implements e {
        d() {
        }

        @Override // androidx.appcompat.widget.W.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(null).newInstance(null);
                    AbstractC0196a.c(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    return drawable;
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    private interface e {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface f {
        Drawable a(W w2, Context context, int i2);

        boolean b(Context context, int i2, Drawable drawable);

        ColorStateList c(Context context, int i2);

        boolean d(Context context, int i2, Drawable drawable);

        PorterDuff.Mode e(int i2);
    }

    private static class g implements e {
        g() {
        }

        @Override // androidx.appcompat.widget.W.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.g.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    private void a(String str, e eVar) {
        if (this.f1758b == null) {
            this.f1758b = new C0213g();
        }
        this.f1758b.put(str, eVar);
    }

    private synchronized boolean b(Context context, long j2, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            C0210d c0210d = (C0210d) this.f1760d.get(context);
            if (c0210d == null) {
                c0210d = new C0210d();
                this.f1760d.put(context, c0210d);
            }
            c0210d.h(j2, new WeakReference(constantState));
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void c(Context context, int i2, ColorStateList colorStateList) {
        if (this.f1757a == null) {
            this.f1757a = new WeakHashMap();
        }
        C0214h c0214h = (C0214h) this.f1757a.get(context);
        if (c0214h == null) {
            c0214h = new C0214h();
            this.f1757a.put(context, c0214h);
        }
        c0214h.a(i2, colorStateList);
    }

    private void d(Context context) {
        if (this.f1762f) {
            return;
        }
        this.f1762f = true;
        Drawable drawableJ = j(context, R$drawable.abc_vector_test);
        if (drawableJ == null || !q(drawableJ)) {
            this.f1762f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long e(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable f(Context context, int i2) {
        if (this.f1761e == null) {
            this.f1761e = new TypedValue();
        }
        TypedValue typedValue = this.f1761e;
        context.getResources().getValue(i2, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        f fVar = this.f1763g;
        Drawable drawableA = fVar == null ? null : fVar.a(this, context, i2);
        if (drawableA != null) {
            drawableA.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, jE, drawableA);
        }
        return drawableA;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized W h() {
        try {
            if (f1755i == null) {
                W w2 = new W();
                f1755i = w2;
                p(w2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f1755i;
    }

    private synchronized Drawable i(Context context, long j2) {
        C0210d c0210d = (C0210d) this.f1760d.get(context);
        if (c0210d == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) c0210d.e(j2);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            c0210d.i(j2);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter l(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterI;
        c cVar = f1756j;
        porterDuffColorFilterI = cVar.i(i2, mode);
        if (porterDuffColorFilterI == null) {
            porterDuffColorFilterI = new PorterDuffColorFilter(i2, mode);
            cVar.j(i2, mode, porterDuffColorFilterI);
        }
        return porterDuffColorFilterI;
    }

    private ColorStateList n(Context context, int i2) {
        C0214h c0214h;
        WeakHashMap weakHashMap = this.f1757a;
        if (weakHashMap == null || (c0214h = (C0214h) weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) c0214h.e(i2);
    }

    private static void p(W w2) {
        if (Build.VERSION.SDK_INT < 24) {
            w2.a("vector", new g());
            w2.a("animated-vector", new b());
            w2.a("animated-selector", new a());
            w2.a("drawable", new d());
        }
    }

    private static boolean q(Drawable drawable) {
        return (drawable instanceof androidx.vectordrawable.graphics.drawable.g) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private Drawable r(Context context, int i2) {
        int next;
        C0213g c0213g = this.f1758b;
        if (c0213g == null || c0213g.isEmpty()) {
            return null;
        }
        C0214h c0214h = this.f1759c;
        if (c0214h != null) {
            String str = (String) c0214h.e(i2);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f1758b.get(str) == null)) {
                return null;
            }
        } else {
            this.f1759c = new C0214h();
        }
        if (this.f1761e == null) {
            this.f1761e = new TypedValue();
        }
        TypedValue typedValue = this.f1761e;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f1759c.a(i2, name);
                e eVar = (e) this.f1758b.get(name);
                if (eVar != null) {
                    drawableI = eVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableI != null) {
                    drawableI.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, jE, drawableI);
                }
            } catch (Exception unused) {
            }
        }
        if (drawableI == null) {
            this.f1759c.a(i2, "appcompat_skip_skip");
        }
        return drawableI;
    }

    private Drawable v(Context context, int i2, boolean z2, Drawable drawable) {
        ColorStateList colorStateListM = m(context, i2);
        if (colorStateListM != null) {
            Drawable drawableP = androidx.core.graphics.drawable.a.p(drawable.mutate());
            androidx.core.graphics.drawable.a.n(drawableP, colorStateListM);
            PorterDuff.Mode modeO = o(i2);
            if (modeO == null) {
                return drawableP;
            }
            androidx.core.graphics.drawable.a.o(drawableP, modeO);
            return drawableP;
        }
        f fVar = this.f1763g;
        if ((fVar == null || !fVar.d(context, i2, drawable)) && !x(context, i2, drawable) && z2) {
            return null;
        }
        return drawable;
    }

    static void w(Drawable drawable, c0 c0Var, int[] iArr) {
        int[] state = drawable.getState();
        if (drawable.mutate() == drawable) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z2 = c0Var.f1831d;
            if (z2 || c0Var.f1830c) {
                drawable.setColorFilter(g(z2 ? c0Var.f1828a : null, c0Var.f1830c ? c0Var.f1829b : f1754h, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    public synchronized Drawable j(Context context, int i2) {
        return k(context, i2, false);
    }

    synchronized Drawable k(Context context, int i2, boolean z2) {
        Drawable drawableR;
        try {
            d(context);
            drawableR = r(context, i2);
            if (drawableR == null) {
                drawableR = f(context, i2);
            }
            if (drawableR == null) {
                drawableR = androidx.core.content.a.d(context, i2);
            }
            if (drawableR != null) {
                drawableR = v(context, i2, z2, drawableR);
            }
            if (drawableR != null) {
                N.a(drawableR);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableR;
    }

    synchronized ColorStateList m(Context context, int i2) {
        ColorStateList colorStateListN;
        colorStateListN = n(context, i2);
        if (colorStateListN == null) {
            f fVar = this.f1763g;
            colorStateListN = fVar == null ? null : fVar.c(context, i2);
            if (colorStateListN != null) {
                c(context, i2, colorStateListN);
            }
        }
        return colorStateListN;
    }

    PorterDuff.Mode o(int i2) {
        f fVar = this.f1763g;
        if (fVar == null) {
            return null;
        }
        return fVar.e(i2);
    }

    public synchronized void s(Context context) {
        C0210d c0210d = (C0210d) this.f1760d.get(context);
        if (c0210d != null) {
            c0210d.b();
        }
    }

    synchronized Drawable t(Context context, o0 o0Var, int i2) {
        try {
            Drawable drawableR = r(context, i2);
            if (drawableR == null) {
                drawableR = o0Var.a(i2);
            }
            if (drawableR == null) {
                return null;
            }
            return v(context, i2, false, drawableR);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void u(f fVar) {
        this.f1763g = fVar;
    }

    boolean x(Context context, int i2, Drawable drawable) {
        f fVar = this.f1763g;
        return fVar != null && fVar.b(context, i2, drawable);
    }
}
