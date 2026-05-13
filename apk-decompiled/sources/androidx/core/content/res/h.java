package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import o.AbstractC0234c;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f2145a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap f2146b = new WeakHashMap(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f2147c = new Object();

    static class a {
        static Drawable a(Resources resources, int i2, Resources.Theme theme) {
            return resources.getDrawable(i2, theme);
        }

        static Drawable b(Resources resources, int i2, int i3, Resources.Theme theme) {
            return resources.getDrawableForDensity(i2, i3, theme);
        }
    }

    static class b {
        static int a(Resources resources, int i2, Resources.Theme theme) {
            return resources.getColor(i2, theme);
        }

        static ColorStateList b(Resources resources, int i2, Resources.Theme theme) {
            return resources.getColorStateList(i2, theme);
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ColorStateList f2148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Configuration f2149b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f2150c;

        c(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f2148a = colorStateList;
            this.f2149b = configuration;
            this.f2150c = theme == null ? 0 : theme.hashCode();
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Resources f2151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Resources.Theme f2152b;

        d(Resources resources, Resources.Theme theme) {
            this.f2151a = resources;
            this.f2152b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f2151a.equals(dVar.f2151a) && AbstractC0234c.a(this.f2152b, dVar.f2152b);
        }

        public int hashCode() {
            return AbstractC0234c.b(this.f2151a, this.f2152b);
        }
    }

    public static abstract class e {
        public static Handler e(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void c(final int i2, Handler handler) {
            e(handler).post(new Runnable() { // from class: androidx.core.content.res.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2158a.f(i2);
                }
            });
        }

        public final void d(final Typeface typeface, Handler handler) {
            e(handler).post(new Runnable() { // from class: androidx.core.content.res.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2156a.g(typeface);
                }
            });
        }

        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public abstract void f(int i2);

        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public abstract void g(Typeface typeface);
    }

    public static final class f {

        static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final Object f2153a = new Object();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static Method f2154b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private static boolean f2155c;

            static void a(Resources.Theme theme) {
                synchronized (f2153a) {
                    if (!f2155c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", null);
                            f2154b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException unused) {
                        }
                        f2155c = true;
                    }
                    Method method = f2154b;
                    if (method != null) {
                        try {
                            method.invoke(theme, null);
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                            f2154b = null;
                        }
                    }
                }
            }
        }

        static class b {
            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                b.a(theme);
            } else if (i2 >= 23) {
                a.a(theme);
            }
        }
    }

    private static void a(d dVar, int i2, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f2147c) {
            try {
                WeakHashMap weakHashMap = f2146b;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(dVar);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(dVar, sparseArray);
                }
                sparseArray.append(i2, new c(colorStateList, dVar.f2151a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (r2.f2150c == r5.hashCode()) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.content.res.ColorStateList b(androidx.core.content.res.h.d r5, int r6) {
        /*
            java.lang.Object r0 = androidx.core.content.res.h.f2147c
            monitor-enter(r0)
            java.util.WeakHashMap r1 = androidx.core.content.res.h.f2146b     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L32
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L45
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L32
            if (r2 <= 0) goto L45
            java.lang.Object r2 = r1.get(r6)     // Catch: java.lang.Throwable -> L32
            androidx.core.content.res.h$c r2 = (androidx.core.content.res.h.c) r2     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L45
            android.content.res.Configuration r3 = r2.f2149b     // Catch: java.lang.Throwable -> L32
            android.content.res.Resources r4 = r5.f2151a     // Catch: java.lang.Throwable -> L32
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch: java.lang.Throwable -> L32
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L42
            android.content.res.Resources$Theme r5 = r5.f2152b     // Catch: java.lang.Throwable -> L32
            if (r5 != 0) goto L34
            int r3 = r2.f2150c     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L3e
            goto L34
        L32:
            r5 = move-exception
            goto L48
        L34:
            if (r5 == 0) goto L42
            int r3 = r2.f2150c     // Catch: java.lang.Throwable -> L32
            int r5 = r5.hashCode()     // Catch: java.lang.Throwable -> L32
            if (r3 != r5) goto L42
        L3e:
            android.content.res.ColorStateList r5 = r2.f2148a     // Catch: java.lang.Throwable -> L32
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            return r5
        L42:
            r1.remove(r6)     // Catch: java.lang.Throwable -> L32
        L45:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            r5 = 0
            return r5
        L48:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.h.b(androidx.core.content.res.h$d, int):android.content.res.ColorStateList");
    }

    public static ColorStateList c(Resources resources, int i2, Resources.Theme theme) {
        d dVar = new d(resources, theme);
        ColorStateList colorStateListB = b(dVar, i2);
        if (colorStateListB != null) {
            return colorStateListB;
        }
        ColorStateList colorStateListH = h(resources, i2, theme);
        if (colorStateListH == null) {
            return Build.VERSION.SDK_INT >= 23 ? b.b(resources, i2, theme) : resources.getColorStateList(i2);
        }
        a(dVar, i2, colorStateListH, theme);
        return colorStateListH;
    }

    public static Drawable d(Resources resources, int i2, Resources.Theme theme) {
        return a.a(resources, i2, theme);
    }

    public static Drawable e(Resources resources, int i2, int i3, Resources.Theme theme) {
        return a.b(resources, i2, i3, theme);
    }

    public static Typeface f(Context context, int i2, TypedValue typedValue, int i3, e eVar) {
        if (context.isRestricted()) {
            return null;
        }
        return j(context, i2, typedValue, i3, eVar, null, true, false);
    }

    private static TypedValue g() {
        ThreadLocal threadLocal = f2145a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList h(Resources resources, int i2, Resources.Theme theme) {
        if (i(resources, i2)) {
            return null;
        }
        try {
            return androidx.core.content.res.c.a(resources, resources.getXml(i2), theme);
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean i(Resources resources, int i2) {
        TypedValue typedValueG = g();
        resources.getValue(i2, typedValueG, true);
        int i3 = typedValueG.type;
        return i3 >= 28 && i3 <= 31;
    }

    private static Typeface j(Context context, int i2, TypedValue typedValue, int i3, e eVar, Handler handler, boolean z2, boolean z3) {
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        Typeface typefaceK = k(context, resources, typedValue, i2, i3, eVar, handler, z2, z3);
        if (typefaceK != null || eVar != null || z3) {
            return typefaceK;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i2) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Typeface k(android.content.Context r15, android.content.res.Resources r16, android.util.TypedValue r17, int r18, int r19, androidx.core.content.res.h.e r20, android.os.Handler r21, boolean r22, boolean r23) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.h.k(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.h$e, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
