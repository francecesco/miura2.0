package l0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class u extends t {
    public static boolean g(Iterable iterable, Object obj) {
        q0.f.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(obj) : h(iterable, obj) >= 0;
    }

    public static final int h(Iterable iterable, Object obj) {
        q0.f.e(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i2 = 0;
        for (Object obj2 : iterable) {
            if (i2 < 0) {
                k.e();
            }
            if (q0.f.a(obj, obj2)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static List i(Iterable iterable, Iterable iterable2) {
        q0.f.e(iterable, "<this>");
        q0.f.e(iterable2, "other");
        Iterator it2 = iterable.iterator();
        Iterator it3 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(k.f(iterable, 10), k.f(iterable2, 10)));
        while (it2.hasNext() && it3.hasNext()) {
            arrayList.add(k0.g.a(it2.next(), it3.next()));
        }
        return arrayList;
    }
}
