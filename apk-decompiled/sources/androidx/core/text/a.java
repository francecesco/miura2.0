package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f2255a;

    /* JADX INFO: renamed from: androidx.core.text.a$a, reason: collision with other inner class name */
    static class C0035a {
        static String a(Locale locale) {
            return locale.getScript();
        }
    }

    static class b {
        static ULocale a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        static String c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                f2255a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    public static String a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.c(b.a(b.b(locale)));
        }
        try {
            return C0035a.a((Locale) f2255a.invoke(null, locale));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return C0035a.a(locale);
        }
    }
}
