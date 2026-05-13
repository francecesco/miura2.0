package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.AbstractC0183g;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
final class ImmLeaksCleaner implements androidx.lifecycle.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Field f755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Field f756e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f757a;

    ImmLeaksCleaner(Activity activity) {
        this.f757a = activity;
    }

    private static void h() {
        try {
            f753b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f755d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f756e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f754c = declaredField3;
            declaredField3.setAccessible(true);
            f753b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.j
    public void d(androidx.lifecycle.l lVar, AbstractC0183g.a aVar) {
        if (aVar != AbstractC0183g.a.ON_DESTROY) {
            return;
        }
        if (f753b == 0) {
            h();
        }
        if (f753b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f757a.getSystemService("input_method");
            try {
                Object obj = f754c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            try {
                                View view = (View) f755d.get(inputMethodManager);
                                if (view == null) {
                                    return;
                                }
                                if (view.isAttachedToWindow()) {
                                    return;
                                }
                                try {
                                    f756e.set(inputMethodManager, null);
                                    inputMethodManager.isActive();
                                } catch (IllegalAccessException unused) {
                                }
                            } catch (ClassCastException unused2) {
                            }
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
