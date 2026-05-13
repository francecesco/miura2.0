package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Class f940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Field f942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Field f944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f945h;

    static void a(Resources resources) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return;
        }
        if (i2 >= 24) {
            d(resources);
        } else if (i2 >= 23) {
            c(resources);
        } else {
            b(resources);
        }
    }

    private static void b(Resources resources) {
        Map map;
        if (!f939b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f938a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f939b = true;
        }
        Field field = f938a;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException unused2) {
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private static void c(Resources resources) {
        Object obj;
        if (!f939b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f938a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f939b = true;
        }
        Field field = f938a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException unused2) {
                obj = null;
            }
        } else {
            obj = null;
        }
        if (obj == null) {
            return;
        }
        e(obj);
    }

    private static void d(Resources resources) {
        Object obj;
        if (!f945h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f944g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f945h = true;
        }
        Field field = f944g;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException unused2) {
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f939b) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f938a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException unused3) {
            }
            f939b = true;
        }
        Field field2 = f938a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException unused4) {
            }
        }
        if (obj2 != null) {
            e(obj2);
        }
    }

    private static void e(Object obj) {
        LongSparseArray longSparseArray;
        if (!f941d) {
            try {
                f940c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException unused) {
            }
            f941d = true;
        }
        Class cls = f940c;
        if (cls == null) {
            return;
        }
        if (!f943f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f942e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused2) {
            }
            f943f = true;
        }
        Field field = f942e;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException unused3) {
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }
}
