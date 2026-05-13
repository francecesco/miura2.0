package androidx.lifecycle;

import androidx.lifecycle.AbstractC0183g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: androidx.lifecycle.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0177a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static C0177a f3067c = new C0177a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f3068a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f3069b = new HashMap();

    /* JADX INFO: renamed from: androidx.lifecycle.a$a, reason: collision with other inner class name */
    static class C0049a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map f3070a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map f3071b;

        C0049a(Map map) {
            this.f3071b = map;
            for (Map.Entry entry : map.entrySet()) {
                AbstractC0183g.a aVar = (AbstractC0183g.a) entry.getValue();
                List arrayList = (List) this.f3070a.get(aVar);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f3070a.put(aVar, arrayList);
                }
                arrayList.add((b) entry.getKey());
            }
        }

        private static void b(List list, l lVar, AbstractC0183g.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((b) list.get(size)).a(lVar, aVar, obj);
                }
            }
        }

        void a(l lVar, AbstractC0183g.a aVar, Object obj) {
            b((List) this.f3070a.get(aVar), lVar, aVar, obj);
            b((List) this.f3070a.get(AbstractC0183g.a.ON_ANY), lVar, aVar, obj);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.a$b */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f3072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Method f3073b;

        b(int i2, Method method) {
            this.f3072a = i2;
            this.f3073b = method;
            method.setAccessible(true);
        }

        void a(l lVar, AbstractC0183g.a aVar, Object obj) {
            try {
                int i2 = this.f3072a;
                if (i2 == 0) {
                    this.f3073b.invoke(obj, null);
                } else if (i2 == 1) {
                    this.f3073b.invoke(obj, lVar);
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    this.f3073b.invoke(obj, lVar, aVar);
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to call observer method", e3.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f3072a == bVar.f3072a && this.f3073b.getName().equals(bVar.f3073b.getName());
        }

        public int hashCode() {
            return (this.f3072a * 31) + this.f3073b.getName().hashCode();
        }
    }

    C0177a() {
    }

    private C0049a a(Class cls, Method[] methodArr) {
        int i2;
        C0049a c0049aC;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (c0049aC = c(superclass)) != null) {
            map.putAll(c0049aC.f3071b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : c(cls2).f3071b.entrySet()) {
                e(map, (b) entry.getKey(), (AbstractC0183g.a) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z2 = false;
        for (Method method : methodArr) {
            r rVar = (r) method.getAnnotation(r.class);
            if (rVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else {
                    if (!l.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i2 = 1;
                }
                AbstractC0183g.a aVarValue = rVar.value();
                if (parameterTypes.length > 1) {
                    if (!AbstractC0183g.a.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (aVarValue != AbstractC0183g.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i2 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new b(i2, method), aVarValue, cls);
                z2 = true;
            }
        }
        C0049a c0049a = new C0049a(map);
        this.f3068a.put(cls, c0049a);
        this.f3069b.put(cls, Boolean.valueOf(z2));
        return c0049a;
    }

    private Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    private void e(Map map, b bVar, AbstractC0183g.a aVar, Class cls) {
        AbstractC0183g.a aVar2 = (AbstractC0183g.a) map.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(bVar, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.f3073b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    C0049a c(Class cls) {
        C0049a c0049a = (C0049a) this.f3068a.get(cls);
        return c0049a != null ? c0049a : a(cls, null);
    }

    boolean d(Class cls) {
        Boolean bool = (Boolean) this.f3069b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrB = b(cls);
        for (Method method : methodArrB) {
            if (((r) method.getAnnotation(r.class)) != null) {
                a(cls, methodArrB);
                return true;
            }
        }
        this.f3069b.put(cls, Boolean.FALSE);
        return false;
    }
}
