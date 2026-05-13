package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;
import java.util.Objects;
import o.InterfaceC0237f;

/* JADX INFO: loaded from: classes.dex */
public abstract class P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f2303a;

    static class a {
        static int a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }

        static boolean b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    static class b {
        static int a(ViewConfiguration viewConfiguration, int i2, int i3, int i4) {
            return viewConfiguration.getScaledMaximumFlingVelocity(i2, i3, i4);
        }

        static int b(ViewConfiguration viewConfiguration, int i2, int i3, int i4) {
            return viewConfiguration.getScaledMinimumFlingVelocity(i2, i3, i4);
        }
    }

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                f2303a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", null);
            } catch (Exception unused) {
            }
        }
    }

    private static int a(Resources resources, int i2, InterfaceC0237f interfaceC0237f, int i3) {
        int dimensionPixelSize;
        return i2 != -1 ? (i2 == 0 || (dimensionPixelSize = resources.getDimensionPixelSize(i2)) < 0) ? i3 : dimensionPixelSize : ((Integer) interfaceC0237f.get()).intValue();
    }

    private static int b(Resources resources, String str, String str2) {
        return resources.getIdentifier(str, str2, "android");
    }

    private static int c(Resources resources, int i2, int i3) {
        if (i2 == 4194304 && i3 == 26) {
            return b(resources, "config_viewMaxRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    private static int d(Resources resources, int i2, int i3) {
        if (i2 == 4194304 && i3 == 26) {
            return b(resources, "config_viewMinRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    public static int e(ViewConfiguration viewConfiguration) {
        return Build.VERSION.SDK_INT >= 28 ? a.a(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
    }

    public static int f(Context context, final ViewConfiguration viewConfiguration, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 34) {
            return b.a(viewConfiguration, i2, i3, i4);
        }
        if (!h(i2, i3, i4)) {
            return Integer.MIN_VALUE;
        }
        Resources resources = context.getResources();
        int iC = c(resources, i4, i3);
        Objects.requireNonNull(viewConfiguration);
        return a(resources, iC, new InterfaceC0237f() { // from class: androidx.core.view.N
            @Override // o.InterfaceC0237f
            public final Object get() {
                return Integer.valueOf(viewConfiguration.getScaledMaximumFlingVelocity());
            }
        }, Integer.MIN_VALUE);
    }

    public static int g(Context context, final ViewConfiguration viewConfiguration, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 34) {
            return b.b(viewConfiguration, i2, i3, i4);
        }
        if (!h(i2, i3, i4)) {
            return Integer.MAX_VALUE;
        }
        Resources resources = context.getResources();
        int iD = d(resources, i4, i3);
        Objects.requireNonNull(viewConfiguration);
        return a(resources, iD, new InterfaceC0237f() { // from class: androidx.core.view.O
            @Override // o.InterfaceC0237f
            public final Object get() {
                return Integer.valueOf(viewConfiguration.getScaledMinimumFlingVelocity());
            }
        }, Integer.MAX_VALUE);
    }

    private static boolean h(int i2, int i3, int i4) {
        InputDevice device = InputDevice.getDevice(i2);
        return (device == null || device.getMotionRange(i3, i4) == null) ? false : true;
    }

    public static boolean i(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.b(viewConfiguration);
        }
        Resources resources = context.getResources();
        int iB = b(resources, "config_showMenuShortcutsWhenKeyboardPresent", "bool");
        return iB != 0 && resources.getBoolean(iB);
    }
}
