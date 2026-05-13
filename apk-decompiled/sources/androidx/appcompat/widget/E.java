package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.content.res.h;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f1545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c0 f1546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c0 f1547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c0 f1548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c0 f1549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c0 f1550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private c0 f1551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c0 f1552h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final G f1553i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f1554j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1555k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Typeface f1556l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f1557m;

    class a extends h.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f1558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f1559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f1560c;

        a(int i2, int i3, WeakReference weakReference) {
            this.f1558a = i2;
            this.f1559b = i3;
            this.f1560c = weakReference;
        }

        @Override // androidx.core.content.res.h.e
        /* JADX INFO: renamed from: h */
        public void f(int i2) {
        }

        @Override // androidx.core.content.res.h.e
        /* JADX INFO: renamed from: i */
        public void g(Typeface typeface) {
            int i2;
            if (Build.VERSION.SDK_INT >= 28 && (i2 = this.f1558a) != -1) {
                typeface = f.a(typeface, i2, (this.f1559b & 2) != 0);
            }
            E.this.n(this.f1560c, typeface);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f1562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Typeface f1563b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f1564c;

        b(TextView textView, Typeface typeface, int i2) {
            this.f1562a = textView;
            this.f1563b = typeface;
            this.f1564c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1562a.setTypeface(this.f1563b, this.f1564c);
        }
    }

    static class c {
        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    static class d {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    static class e {
        static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        static void b(TextView textView, int i2, int i3, int i4, int i5) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
        }

        static void c(TextView textView, int[] iArr, int i2) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
        }

        static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    static class f {
        static Typeface a(Typeface typeface, int i2, boolean z2) {
            return Typeface.create(typeface, i2, z2);
        }
    }

    E(TextView textView) {
        this.f1545a = textView;
        this.f1553i = new G(textView);
    }

    private void B(int i2, float f2) {
        this.f1553i.t(i2, f2);
    }

    private void C(Context context, e0 e0Var) {
        String strN;
        Typeface typefaceCreate;
        Typeface typeface;
        this.f1554j = e0Var.j(R$styleable.TextAppearance_android_textStyle, this.f1554j);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int iJ = e0Var.j(R$styleable.TextAppearance_android_textFontWeight, -1);
            this.f1555k = iJ;
            if (iJ != -1) {
                this.f1554j &= 2;
            }
        }
        if (!e0Var.r(R$styleable.TextAppearance_android_fontFamily) && !e0Var.r(R$styleable.TextAppearance_fontFamily)) {
            if (e0Var.r(R$styleable.TextAppearance_android_typeface)) {
                this.f1557m = false;
                int iJ2 = e0Var.j(R$styleable.TextAppearance_android_typeface, 1);
                if (iJ2 == 1) {
                    typeface = Typeface.SANS_SERIF;
                } else if (iJ2 == 2) {
                    typeface = Typeface.SERIF;
                } else if (iJ2 != 3) {
                    return;
                } else {
                    typeface = Typeface.MONOSPACE;
                }
                this.f1556l = typeface;
                return;
            }
            return;
        }
        this.f1556l = null;
        int i3 = e0Var.r(R$styleable.TextAppearance_fontFamily) ? R$styleable.TextAppearance_fontFamily : R$styleable.TextAppearance_android_fontFamily;
        int i4 = this.f1555k;
        int i5 = this.f1554j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceI = e0Var.i(i3, this.f1554j, new a(i4, i5, new WeakReference(this.f1545a)));
                if (typefaceI != null) {
                    if (i2 >= 28 && this.f1555k != -1) {
                        typefaceI = f.a(Typeface.create(typefaceI, 0), this.f1555k, (this.f1554j & 2) != 0);
                    }
                    this.f1556l = typefaceI;
                }
                this.f1557m = this.f1556l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f1556l != null || (strN = e0Var.n(i3)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f1555k == -1) {
            typefaceCreate = Typeface.create(strN, this.f1554j);
        } else {
            typefaceCreate = f.a(Typeface.create(strN, 0), this.f1555k, (this.f1554j & 2) != 0);
        }
        this.f1556l = typefaceCreate;
    }

    private void a(Drawable drawable, c0 c0Var) {
        if (drawable == null || c0Var == null) {
            return;
        }
        C0122k.i(drawable, c0Var, this.f1545a.getDrawableState());
    }

    private static c0 d(Context context, C0122k c0122k, int i2) {
        ColorStateList colorStateListF = c0122k.f(context, i2);
        if (colorStateListF == null) {
            return null;
        }
        c0 c0Var = new c0();
        c0Var.f1831d = true;
        c0Var.f1828a = colorStateListF;
        return c0Var;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.f1545a.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            TextView textView = this.f1545a;
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.f1545a.getCompoundDrawablesRelative();
        Drawable drawable7 = compoundDrawablesRelative2[0];
        if (drawable7 != null || compoundDrawablesRelative2[2] != null) {
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            this.f1545a.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f1545a.getCompoundDrawables();
        TextView textView2 = this.f1545a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void z() {
        c0 c0Var = this.f1552h;
        this.f1546b = c0Var;
        this.f1547c = c0Var;
        this.f1548d = c0Var;
        this.f1549e = c0Var;
        this.f1550f = c0Var;
        this.f1551g = c0Var;
    }

    void A(int i2, float f2) {
        if (p0.f1942c || l()) {
            return;
        }
        B(i2, f2);
    }

    void b() {
        if (this.f1546b != null || this.f1547c != null || this.f1548d != null || this.f1549e != null) {
            Drawable[] compoundDrawables = this.f1545a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1546b);
            a(compoundDrawables[1], this.f1547c);
            a(compoundDrawables[2], this.f1548d);
            a(compoundDrawables[3], this.f1549e);
        }
        if (this.f1550f == null && this.f1551g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.f1545a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f1550f);
        a(compoundDrawablesRelative[2], this.f1551g);
    }

    void c() {
        this.f1553i.a();
    }

    int e() {
        return this.f1553i.f();
    }

    int f() {
        return this.f1553i.g();
    }

    int g() {
        return this.f1553i.h();
    }

    int[] h() {
        return this.f1553i.i();
    }

    int i() {
        return this.f1553i.j();
    }

    ColorStateList j() {
        c0 c0Var = this.f1552h;
        if (c0Var != null) {
            return c0Var.f1828a;
        }
        return null;
    }

    PorterDuff.Mode k() {
        c0 c0Var = this.f1552h;
        if (c0Var != null) {
            return c0Var.f1829b;
        }
        return null;
    }

    boolean l() {
        return this.f1553i.n();
    }

    /* JADX WARN: Removed duplicated region for block: B:163:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void m(android.util.AttributeSet r19, int r20) {
        /*
            Method dump skipped, instruction units count: 876
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.E.m(android.util.AttributeSet, int):void");
    }

    void n(WeakReference weakReference, Typeface typeface) {
        if (this.f1557m) {
            this.f1556l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new b(textView, typeface, this.f1554j));
                } else {
                    textView.setTypeface(typeface, this.f1554j);
                }
            }
        }
    }

    void o(boolean z2, int i2, int i3, int i4, int i5) {
        if (p0.f1942c) {
            return;
        }
        c();
    }

    void p() {
        b();
    }

    void q(Context context, int i2) {
        String strN;
        ColorStateList colorStateListC;
        ColorStateList colorStateListC2;
        ColorStateList colorStateListC3;
        e0 e0VarS = e0.s(context, i2, R$styleable.TextAppearance);
        if (e0VarS.r(R$styleable.TextAppearance_textAllCaps)) {
            s(e0VarS.a(R$styleable.TextAppearance_textAllCaps, false));
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 23) {
            if (e0VarS.r(R$styleable.TextAppearance_android_textColor) && (colorStateListC3 = e0VarS.c(R$styleable.TextAppearance_android_textColor)) != null) {
                this.f1545a.setTextColor(colorStateListC3);
            }
            if (e0VarS.r(R$styleable.TextAppearance_android_textColorLink) && (colorStateListC2 = e0VarS.c(R$styleable.TextAppearance_android_textColorLink)) != null) {
                this.f1545a.setLinkTextColor(colorStateListC2);
            }
            if (e0VarS.r(R$styleable.TextAppearance_android_textColorHint) && (colorStateListC = e0VarS.c(R$styleable.TextAppearance_android_textColorHint)) != null) {
                this.f1545a.setHintTextColor(colorStateListC);
            }
        }
        if (e0VarS.r(R$styleable.TextAppearance_android_textSize) && e0VarS.e(R$styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f1545a.setTextSize(0, 0.0f);
        }
        C(context, e0VarS);
        if (i3 >= 26 && e0VarS.r(R$styleable.TextAppearance_fontVariationSettings) && (strN = e0VarS.n(R$styleable.TextAppearance_fontVariationSettings)) != null) {
            e.d(this.f1545a, strN);
        }
        e0VarS.w();
        Typeface typeface = this.f1556l;
        if (typeface != null) {
            this.f1545a.setTypeface(typeface, this.f1554j);
        }
    }

    void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        s.c.f(editorInfo, textView.getText());
    }

    void s(boolean z2) {
        this.f1545a.setAllCaps(z2);
    }

    void t(int i2, int i3, int i4, int i5) {
        this.f1553i.p(i2, i3, i4, i5);
    }

    void u(int[] iArr, int i2) {
        this.f1553i.q(iArr, i2);
    }

    void v(int i2) {
        this.f1553i.r(i2);
    }

    void w(ColorStateList colorStateList) {
        if (this.f1552h == null) {
            this.f1552h = new c0();
        }
        c0 c0Var = this.f1552h;
        c0Var.f1828a = colorStateList;
        c0Var.f1831d = colorStateList != null;
        z();
    }

    void x(PorterDuff.Mode mode) {
        if (this.f1552h == null) {
            this.f1552h = new c0();
        }
        c0 c0Var = this.f1552h;
        c0Var.f1829b = mode;
        c0Var.f1830c = mode != null;
        z();
    }
}
