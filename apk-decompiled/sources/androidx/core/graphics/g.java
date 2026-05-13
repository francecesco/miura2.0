package androidx.core.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import o.C0235d;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f2204a = new ThreadLocal();

    static class a {
        static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    public static boolean a(Paint paint, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.a(paint, str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float fMeasureText = paint.measureText("\udfffd");
        float fMeasureText2 = paint.measureText("m");
        float fMeasureText3 = paint.measureText(str);
        float fMeasureText4 = 0.0f;
        if (fMeasureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (fMeasureText3 > fMeasureText2 * 2.0f) {
                return false;
            }
            int i2 = 0;
            while (i2 < length) {
                int iCharCount = Character.charCount(str.codePointAt(i2)) + i2;
                fMeasureText4 += paint.measureText(str, i2, iCharCount);
                i2 = iCharCount;
            }
            if (fMeasureText3 >= fMeasureText4) {
                return false;
            }
        }
        if (fMeasureText3 != fMeasureText) {
            return true;
        }
        C0235d c0235dB = b();
        paint.getTextBounds("\udfffd", 0, 2, (Rect) c0235dB.f3921a);
        paint.getTextBounds(str, 0, length, (Rect) c0235dB.f3922b);
        return !((Rect) c0235dB.f3921a).equals(c0235dB.f3922b);
    }

    private static C0235d b() {
        ThreadLocal threadLocal = f2204a;
        C0235d c0235d = (C0235d) threadLocal.get();
        if (c0235d == null) {
            C0235d c0235d2 = new C0235d(new Rect(), new Rect());
            threadLocal.set(c0235d2);
            return c0235d2;
        }
        ((Rect) c0235d.f3921a).setEmpty();
        ((Rect) c0235d.f3922b).setEmpty();
        return c0235d;
    }
}
