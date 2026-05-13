package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public abstract class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f1784a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int[] f1785b = {-16842910};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int[] f1786c = {R.attr.state_focused};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[] f1787d = {R.attr.state_activated};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f1788e = {R.attr.state_pressed};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int[] f1789f = {R.attr.state_checked};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int[] f1790g = {R.attr.state_selected};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int[] f1791h = {-16842919, -16842908};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int[] f1792i = new int[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[] f1793j = new int[1];

    public static void a(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R$styleable.AppCompatTheme);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
                StringBuilder sb = new StringBuilder();
                sb.append("View ");
                sb.append(view.getClass());
                sb.append(" is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i2) {
        ColorStateList colorStateListE = e(context, i2);
        if (colorStateListE != null && colorStateListE.isStateful()) {
            return colorStateListE.getColorForState(f1785b, colorStateListE.getDefaultColor());
        }
        TypedValue typedValueF = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueF, true);
        return d(context, i2, typedValueF.getFloat());
    }

    public static int c(Context context, int i2) {
        int[] iArr = f1793j;
        iArr[0] = i2;
        e0 e0VarT = e0.t(context, null, iArr);
        try {
            return e0VarT.b(0, 0);
        } finally {
            e0VarT.w();
        }
    }

    static int d(Context context, int i2, float f2) {
        return androidx.core.graphics.a.f(c(context, i2), Math.round(Color.alpha(r0) * f2));
    }

    public static ColorStateList e(Context context, int i2) {
        int[] iArr = f1793j;
        iArr[0] = i2;
        e0 e0VarT = e0.t(context, null, iArr);
        try {
            return e0VarT.c(0);
        } finally {
            e0VarT.w();
        }
    }

    private static TypedValue f() {
        ThreadLocal threadLocal = f1784a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
