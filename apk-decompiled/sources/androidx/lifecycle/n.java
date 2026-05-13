package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f3096a = new n();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f3097b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f3098c = new HashMap();

    private n() {
    }

    private final InterfaceC0181e a(Constructor constructor, Object obj) {
        try {
            Object objNewInstance = constructor.newInstance(obj);
            q0.f.d(objNewInstance, "{\n            constructo…tance(`object`)\n        }");
            android.support.v4.media.session.b.a(objNewInstance);
            return null;
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Constructor b(Class cls) {
        try {
            Package r1 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r1 != null ? r1.getName() : "";
            q0.f.d(name, "fullPackage");
            if (name.length() != 0) {
                q0.f.d(canonicalName, "name");
                canonicalName = canonicalName.substring(name.length() + 1);
                q0.f.d(canonicalName, "this as java.lang.String).substring(startIndex)");
            }
            q0.f.d(canonicalName, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String strC = c(canonicalName);
            if (name.length() != 0) {
                strC = name + '.' + strC;
            }
            Class<?> cls2 = Class.forName(strC);
            q0.f.c(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor declaredConstructor = cls2.getDeclaredConstructor(cls);
            if (declaredConstructor.isAccessible()) {
                return declaredConstructor;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static final String c(String str) {
        q0.f.e(str, "className");
        return t0.c.c(str, ".", "_", false, 4, null) + "_LifecycleAdapter";
    }

    private final int d(Class cls) {
        Map map = f3097b;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iG = g(cls);
        map.put(cls, Integer.valueOf(iG));
        return iG;
    }

    private final boolean e(Class cls) {
        return cls != null && k.class.isAssignableFrom(cls);
    }

    public static final j f(Object obj) {
        q0.f.e(obj, "object");
        boolean z2 = obj instanceof j;
        boolean z3 = obj instanceof InterfaceC0179c;
        if (z2 && z3) {
            return new DefaultLifecycleObserverAdapter((InterfaceC0179c) obj, (j) obj);
        }
        if (z3) {
            return new DefaultLifecycleObserverAdapter((InterfaceC0179c) obj, null);
        }
        if (z2) {
            return (j) obj;
        }
        Class<?> cls = obj.getClass();
        n nVar = f3096a;
        if (nVar.d(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        Object obj2 = f3098c.get(cls);
        q0.f.b(obj2);
        List list = (List) obj2;
        if (list.size() == 1) {
            nVar.a((Constructor) list.get(0), obj);
            return new SingleGeneratedAdapterObserver(null);
        }
        int size = list.size();
        InterfaceC0181e[] interfaceC0181eArr = new InterfaceC0181e[size];
        for (int i2 = 0; i2 < size; i2++) {
            f3096a.a((Constructor) list.get(i2), obj);
            interfaceC0181eArr[i2] = null;
        }
        return new CompositeGeneratedAdaptersObserver(interfaceC0181eArr);
    }

    private final int g(Class cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor constructorB = b(cls);
        if (constructorB != null) {
            f3098c.put(cls, l0.k.a(constructorB));
            return 2;
        }
        if (C0177a.f3067c.d(cls)) {
            return 1;
        }
        Class superclass = cls.getSuperclass();
        if (e(superclass)) {
            q0.f.d(superclass, "superclass");
            if (d(superclass) == 1) {
                return 1;
            }
            Object obj = f3098c.get(superclass);
            q0.f.b(obj);
            arrayList = new ArrayList((Collection) obj);
        } else {
            arrayList = null;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        q0.f.d(interfaces, "klass.interfaces");
        for (Class<?> cls2 : interfaces) {
            if (e(cls2)) {
                q0.f.d(cls2, "intrface");
                if (d(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                Object obj2 = f3098c.get(cls2);
                q0.f.b(obj2);
                arrayList.addAll((Collection) obj2);
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f3098c.put(cls, arrayList);
        return 2;
    }
}
