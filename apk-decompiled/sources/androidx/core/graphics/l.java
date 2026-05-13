package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.content.res.e;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import n.h;

/* JADX INFO: loaded from: classes.dex */
public class l extends j {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final Class f2221g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final Constructor f2222h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final Method f2223i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final Method f2224j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected final Method f2225k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected final Method f2226l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected final Method f2227m;

    public l() {
        Class clsV;
        Constructor constructorW;
        Method methodS;
        Method methodT;
        Method methodX;
        Method methodR;
        Method methodU;
        try {
            clsV = v();
            constructorW = w(clsV);
            methodS = s(clsV);
            methodT = t(clsV);
            methodX = x(clsV);
            methodR = r(clsV);
            methodU = u(clsV);
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to collect necessary methods for class ");
            sb.append(e2.getClass().getName());
            clsV = null;
            constructorW = null;
            methodS = null;
            methodT = null;
            methodX = null;
            methodR = null;
            methodU = null;
        }
        this.f2221g = clsV;
        this.f2222h = constructorW;
        this.f2223i = methodS;
        this.f2224j = methodT;
        this.f2225k = methodX;
        this.f2226l = methodR;
        this.f2227m = methodU;
    }

    private Object l() {
        try {
            return this.f2222h.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void m(Object obj) {
        try {
            this.f2226l.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean n(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f2223i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean o(Object obj, ByteBuffer byteBuffer, int i2, int i3, int i4) {
        try {
            return ((Boolean) this.f2224j.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Integer.valueOf(i4))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean p(Object obj) {
        try {
            return ((Boolean) this.f2225k.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean q() {
        return this.f2223i != null;
    }

    @Override // androidx.core.graphics.j, androidx.core.graphics.o
    public Typeface a(Context context, e.c cVar, Resources resources, int i2) {
        if (!q()) {
            return super.a(context, cVar, resources, i2);
        }
        Object objL = l();
        if (objL == null) {
            return null;
        }
        for (e.d dVar : cVar.a()) {
            if (!n(context, objL, dVar.a(), dVar.c(), dVar.e(), dVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(dVar.d()))) {
                m(objL);
                return null;
            }
        }
        if (p(objL)) {
            return i(objL);
        }
        return null;
    }

    @Override // androidx.core.graphics.j, androidx.core.graphics.o
    public Typeface b(Context context, CancellationSignal cancellationSignal, h.b[] bVarArr, int i2) {
        Typeface typefaceI;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!q()) {
            h.b bVarG = g(bVarArr, i2);
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(bVarG.d(), "r", cancellationSignal);
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(bVarG.e()).setItalic(bVarG.f()).build();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceBuild;
                } finally {
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map mapH = p.h(context, bVarArr, cancellationSignal);
        Object objL = l();
        if (objL == null) {
            return null;
        }
        boolean z2 = false;
        for (h.b bVar : bVarArr) {
            ByteBuffer byteBuffer = (ByteBuffer) mapH.get(bVar.d());
            if (byteBuffer != null) {
                if (!o(objL, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                    m(objL);
                    return null;
                }
                z2 = true;
            }
        }
        if (!z2) {
            m(objL);
            return null;
        }
        if (p(objL) && (typefaceI = i(objL)) != null) {
            return Typeface.create(typefaceI, i2);
        }
        return null;
    }

    @Override // androidx.core.graphics.o
    public Typeface d(Context context, Resources resources, int i2, String str, int i3) {
        if (!q()) {
            return super.d(context, resources, i2, str, i3);
        }
        Object objL = l();
        if (objL == null) {
            return null;
        }
        if (!n(context, objL, str, 0, -1, -1, null)) {
            m(objL);
            return null;
        }
        if (p(objL)) {
            return i(objL);
        }
        return null;
    }

    protected Typeface i(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f2221g, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f2227m.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected Method r(Class cls) {
        return cls.getMethod("abortCreation", null);
    }

    protected Method s(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    protected Method t(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    protected Method u(Class cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    protected Class v() {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor w(Class cls) {
        return cls.getConstructor(null);
    }

    protected Method x(Class cls) {
        return cls.getMethod("freeze", null);
    }
}
