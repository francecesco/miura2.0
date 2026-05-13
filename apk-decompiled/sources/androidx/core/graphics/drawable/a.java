package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f2183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f2184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f2185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f2186d;

    /* JADX INFO: renamed from: androidx.core.graphics.drawable.a$a, reason: collision with other inner class name */
    static class C0033a {
        static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        static void e(Drawable drawable, float f2, float f3) {
            drawable.setHotspot(f2, f3);
        }

        static void f(Drawable drawable, int i2, int i3, int i4, int i5) {
            drawable.setHotspotBounds(i2, i3, i4, i5);
        }

        static void g(Drawable drawable, int i2) {
            drawable.setTint(i2);
        }

        static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    static class b {
        static int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        static boolean b(Drawable drawable, int i2) {
            return drawable.setLayoutDirection(i2);
        }
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        C0033a.a(drawable, theme);
    }

    public static boolean b(Drawable drawable) {
        return C0033a.b(drawable);
    }

    public static int c(Drawable drawable) {
        return drawable.getAlpha();
    }

    public static ColorFilter d(Drawable drawable) {
        return C0033a.c(drawable);
    }

    public static int e(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.a(drawable);
        }
        if (!f2186d) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", null);
                f2185c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f2186d = true;
        }
        Method method = f2185c;
        if (method == null) {
            return 0;
        }
        try {
            return ((Integer) method.invoke(drawable, null)).intValue();
        } catch (Exception unused2) {
            f2185c = null;
            return 0;
        }
    }

    public static void f(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        C0033a.d(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean g(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static void h(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void i(Drawable drawable, boolean z2) {
        drawable.setAutoMirrored(z2);
    }

    public static void j(Drawable drawable, float f2, float f3) {
        C0033a.e(drawable, f2, f3);
    }

    public static void k(Drawable drawable, int i2, int i3, int i4, int i5) {
        C0033a.f(drawable, i2, i3, i4, i5);
    }

    public static boolean l(Drawable drawable, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.b(drawable, i2);
        }
        if (!f2184b) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                f2183a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f2184b = true;
        }
        Method method = f2183a;
        if (method != null) {
            try {
                method.invoke(drawable, Integer.valueOf(i2));
                return true;
            } catch (Exception unused2) {
                f2183a = null;
            }
        }
        return false;
    }

    public static void m(Drawable drawable, int i2) {
        C0033a.g(drawable, i2);
    }

    public static void n(Drawable drawable, ColorStateList colorStateList) {
        C0033a.h(drawable, colorStateList);
    }

    public static void o(Drawable drawable, PorterDuff.Mode mode) {
        C0033a.i(drawable, mode);
    }

    public static Drawable p(Drawable drawable) {
        return (Build.VERSION.SDK_INT < 23 && !(drawable instanceof androidx.core.graphics.drawable.b)) ? new e(drawable) : drawable;
    }
}
