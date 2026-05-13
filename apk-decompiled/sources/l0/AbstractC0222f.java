package l0;

import java.lang.reflect.Array;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: renamed from: l0.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0222f {
    public static final Object[] a(Object[] objArr, int i2) {
        q0.f.e(objArr, Name.REFER);
        Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i2);
        q0.f.c(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (Object[]) objNewInstance;
    }
}
