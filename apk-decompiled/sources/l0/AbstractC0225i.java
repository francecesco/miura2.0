package l0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: renamed from: l0.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0225i extends AbstractC0224h {
    public static List f(Object[] objArr) {
        q0.f.e(objArr, "<this>");
        return (List) g(objArr, new ArrayList());
    }

    public static final Collection g(Object[] objArr, Collection collection) {
        q0.f.e(objArr, "<this>");
        q0.f.e(collection, "destination");
        for (Object obj : objArr) {
            if (obj != null) {
                collection.add(obj);
            }
        }
        return collection;
    }

    public static final int h(Object[] objArr) {
        q0.f.e(objArr, "<this>");
        return objArr.length - 1;
    }

    public static char i(char[] cArr) {
        q0.f.e(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }
}
