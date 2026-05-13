package Q;

import Q.a;
import android.os.IBinder;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a.AbstractBinderC0003a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f157b;

    private b(Object obj) {
        this.f157b = obj;
    }

    public static Object f(a aVar) {
        if (aVar instanceof b) {
            return ((b) aVar).f157b;
        }
        IBinder iBinderAsBinder = aVar.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i2 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i2++;
                field = field2;
            }
        }
        if (i2 != 1) {
            int length = declaredFields.length;
            StringBuilder sb = new StringBuilder(64);
            sb.append("Unexpected number of IObjectWrapper declared fields: ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        }
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e2);
        } catch (NullPointerException e3) {
            throw new IllegalArgumentException("Binder object is null.", e3);
        }
    }

    public static a g(Object obj) {
        return new b(obj);
    }
}
