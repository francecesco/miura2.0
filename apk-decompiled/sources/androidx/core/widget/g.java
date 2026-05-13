package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f2449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f2450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f2451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f2452d;

    static class a {
        static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        static void c(PopupWindow popupWindow, boolean z2) {
            popupWindow.setOverlapAnchor(z2);
        }

        static void d(PopupWindow popupWindow, int i2) {
            popupWindow.setWindowLayoutType(i2);
        }
    }

    public static void a(PopupWindow popupWindow, boolean z2) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.c(popupWindow, z2);
            return;
        }
        if (!f2452d) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f2451c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2452d = true;
        }
        Field field = f2451c;
        if (field != null) {
            try {
                field.set(popupWindow, Boolean.valueOf(z2));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public static void b(PopupWindow popupWindow, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.d(popupWindow, i2);
            return;
        }
        if (!f2450b) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f2449a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f2450b = true;
        }
        Method method = f2449a;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i2));
            } catch (Exception unused2) {
            }
        }
    }

    public static void c(PopupWindow popupWindow, View view, int i2, int i3, int i4) {
        popupWindow.showAsDropDown(view, i2, i3, i4);
    }
}
