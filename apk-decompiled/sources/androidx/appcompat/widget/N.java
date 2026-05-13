package androidx.appcompat.widget;

import android.R;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f1594a = {R.attr.state_checked};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f1595b = new int[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Rect f1596c = new Rect();

    static void a(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i2 = Build.VERSION.SDK_INT;
        if (!(i2 == 21 && "android.graphics.drawable.VectorDrawable".equals(name)) && (i2 < 29 || i2 >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name))) {
            return;
        }
        b(drawable);
    }

    private static void b(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f1594a);
        } else {
            drawable.setState(f1595b);
        }
        drawable.setState(state);
    }

    public static PorterDuff.Mode c(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
