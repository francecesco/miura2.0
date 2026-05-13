package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import k.C0213g;

/* JADX INFO: renamed from: androidx.fragment.app.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0176o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0213g f2941a = new C0213g();

    static boolean b(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static Class c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        C0213g c0213g = f2941a;
        C0213g c0213g2 = (C0213g) c0213g.get(classLoader);
        if (c0213g2 == null) {
            c0213g2 = new C0213g();
            c0213g.put(classLoader, c0213g2);
        }
        Class cls = (Class) c0213g2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        c0213g2.put(str, cls2);
        return cls2;
    }

    public static Class d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e2) {
            throw new Fragment.h("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e2);
        } catch (ClassNotFoundException e3) {
            throw new Fragment.h("Unable to instantiate fragment " + str + ": make sure class name exists", e3);
        }
    }

    public abstract Fragment a(ClassLoader classLoader, String str);
}
