package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.core.content.res.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import n.h;

/* JADX INFO: loaded from: classes.dex */
class j extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class f2212b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Constructor f2213c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f2214d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f2215e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f2216f = false;

    j() {
    }

    private static boolean h(Object obj, String str, int i2, boolean z2) throws NoSuchMethodException {
        k();
        try {
            return ((Boolean) f2214d.invoke(obj, str, Integer.valueOf(i2), Boolean.valueOf(z2))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Typeface i(Object obj) throws NoSuchMethodException {
        k();
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f2212b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f2215e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private File j(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(str).st_mode)) {
                return new File(str);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void k() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (f2216f) {
            return;
        }
        f2216f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            method = null;
            cls = null;
            method2 = null;
        }
        f2213c = constructor;
        f2212b = cls;
        f2214d = method2;
        f2215e = method;
    }

    private static Object l() throws NoSuchMethodException {
        k();
        try {
            return f2213c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // androidx.core.graphics.o
    public Typeface a(Context context, e.c cVar, Resources resources, int i2) throws NoSuchMethodException {
        Object objL = l();
        for (e.d dVar : cVar.a()) {
            File fileE = p.e(context);
            if (fileE == null) {
                return null;
            }
            try {
                if (!p.c(fileE, resources, dVar.b())) {
                    return null;
                }
                if (!h(objL, fileE.getPath(), dVar.e(), dVar.f())) {
                    return null;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                fileE.delete();
            }
        }
        return i(objL);
    }

    @Override // androidx.core.graphics.o
    public Typeface b(Context context, CancellationSignal cancellationSignal, h.b[] bVarArr, int i2) {
        if (bVarArr.length < 1) {
            return null;
        }
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
                File fileJ = j(parcelFileDescriptorOpenFileDescriptor);
                if (fileJ != null && fileJ.canRead()) {
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(fileJ);
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceCreateFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    Typeface typefaceC = super.c(context, fileInputStream);
                    fileInputStream.close();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceC;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
