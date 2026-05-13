package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.core.content.res.e;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import k.C0213g;
import n.h;

/* JADX INFO: loaded from: classes.dex */
class k extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class f2217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Constructor f2218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Method f2219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Method f2220e;

    static {
        Method method;
        Class<?> cls;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            method = null;
            cls = null;
            method2 = null;
        }
        f2218c = constructor;
        f2217b = cls;
        f2219d = method2;
        f2220e = method;
    }

    k() {
    }

    private static boolean h(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z2) {
        try {
            return ((Boolean) f2219d.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z2))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface i(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f2217b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f2220e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean j() {
        return f2219d != null;
    }

    private static Object k() {
        try {
            return f2218c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.o
    public Typeface a(Context context, e.c cVar, Resources resources, int i2) {
        Object objK = k();
        if (objK == null) {
            return null;
        }
        for (e.d dVar : cVar.a()) {
            ByteBuffer byteBufferB = p.b(context, resources, dVar.b());
            if (byteBufferB == null || !h(objK, byteBufferB, dVar.c(), dVar.e(), dVar.f())) {
                return null;
            }
        }
        return i(objK);
    }

    @Override // androidx.core.graphics.o
    public Typeface b(Context context, CancellationSignal cancellationSignal, h.b[] bVarArr, int i2) {
        Object objK = k();
        if (objK == null) {
            return null;
        }
        C0213g c0213g = new C0213g();
        for (h.b bVar : bVarArr) {
            Uri uriD = bVar.d();
            ByteBuffer byteBufferF = (ByteBuffer) c0213g.get(uriD);
            if (byteBufferF == null) {
                byteBufferF = p.f(context, cancellationSignal, uriD);
                c0213g.put(uriD, byteBufferF);
            }
            if (byteBufferF == null || !h(objK, byteBufferF, bVar.c(), bVar.e(), bVar.f())) {
                return null;
            }
        }
        Typeface typefaceI = i(objK);
        if (typefaceI == null) {
            return null;
        }
        return Typeface.create(typefaceI, i2);
    }
}
