package l0;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class D extends C {
    public static Map d() {
        x xVar = x.f3870a;
        q0.f.c(xVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return xVar;
    }

    public static final Map e(Map map) {
        q0.f.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : C.c(map) : A.d();
    }

    public static final void f(Map map, Iterable iterable) {
        q0.f.e(map, "<this>");
        q0.f.e(iterable, "pairs");
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            k0.e eVar = (k0.e) it2.next();
            map.put(eVar.a(), eVar.b());
        }
    }

    public static Map g(Iterable iterable) {
        q0.f.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return e(h(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return A.d();
        }
        if (size != 1) {
            return h(iterable, new LinkedHashMap(A.a(collection.size())));
        }
        return C.b((k0.e) (iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next()));
    }

    public static final Map h(Iterable iterable, Map map) {
        q0.f.e(iterable, "<this>");
        q0.f.e(map, "destination");
        f(map, iterable);
        return map;
    }
}
