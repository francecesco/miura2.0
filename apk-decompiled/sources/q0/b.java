package q0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l0.A;
import l0.k;
import p0.j;
import p0.l;
import p0.m;
import p0.n;
import p0.o;
import p0.p;
import p0.q;
import p0.r;
import p0.s;
import p0.t;
import p0.u;
import p0.v;
import p0.w;

/* JADX INFO: loaded from: classes.dex */
public final class b implements s0.a, q0.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3979b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f3980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final HashMap f3981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final HashMap f3982e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final HashMap f3983f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Map f3984g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f3985a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(d dVar) {
            this();
        }
    }

    static {
        int i2 = 0;
        List listD = k.d(p0.a.class, l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, p0.b.class, p0.c.class, p0.d.class, p0.e.class, p0.f.class, p0.g.class, p0.h.class, p0.i.class, j.class, p0.k.class, m.class, n.class, o.class);
        ArrayList arrayList = new ArrayList(k.f(listD, 10));
        for (Object obj : listD) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                k.e();
            }
            arrayList.add(k0.g.a((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        f3980c = A.g(arrayList);
        HashMap map = new HashMap();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f3981d = map;
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f3982e = map2;
        HashMap map3 = new HashMap();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        f.d(collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            f.d(str, "kotlinName");
            sb.append(t0.c.m(str, '.', null, 2, null));
            sb.append("CompanionObject");
            k0.e eVarA = k0.g.a(sb.toString(), str + ".Companion");
            map3.put(eVarA.c(), eVarA.d());
        }
        for (Map.Entry entry : f3980c.entrySet()) {
            map3.put(((Class) entry.getKey()).getName(), "kotlin.Function" + ((Number) entry.getValue()).intValue());
        }
        f3983f = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(A.a(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), t0.c.m((String) entry2.getValue(), '.', null, 2, null));
        }
        f3984g = linkedHashMap;
    }

    public b(Class cls) {
        f.e(cls, "jClass");
        this.f3985a = cls;
    }

    @Override // q0.a
    public Class a() {
        return this.f3985a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && f.a(o0.a.b(this), o0.a.b((s0.a) obj));
    }

    public int hashCode() {
        return o0.a.b(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
