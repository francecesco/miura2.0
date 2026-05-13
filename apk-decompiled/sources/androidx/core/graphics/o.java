package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.core.content.res.e;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import n.h;

/* JADX INFO: loaded from: classes.dex */
abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap f2228a = new ConcurrentHashMap();

    class a implements b {
        a() {
        }

        @Override // androidx.core.graphics.o.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(h.b bVar) {
            return bVar.e();
        }

        @Override // androidx.core.graphics.o.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(h.b bVar) {
            return bVar.f();
        }
    }

    private interface b {
        int a(Object obj);

        boolean b(Object obj);
    }

    o() {
    }

    private static Object e(Object[] objArr, int i2, b bVar) {
        return f(objArr, (i2 & 1) == 0 ? 400 : 700, (i2 & 2) != 0, bVar);
    }

    private static Object f(Object[] objArr, int i2, boolean z2, b bVar) {
        Object obj = null;
        int i3 = Integer.MAX_VALUE;
        for (Object obj2 : objArr) {
            int iAbs = (Math.abs(bVar.a(obj2) - i2) * 2) + (bVar.b(obj2) == z2 ? 0 : 1);
            if (obj == null || i3 > iAbs) {
                obj = obj2;
                i3 = iAbs;
            }
        }
        return obj;
    }

    public abstract Typeface a(Context context, e.c cVar, Resources resources, int i2);

    public abstract Typeface b(Context context, CancellationSignal cancellationSignal, h.b[] bVarArr, int i2);

    protected Typeface c(Context context, InputStream inputStream) {
        File fileE = p.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (p.d(fileE, inputStream)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    public Typeface d(Context context, Resources resources, int i2, String str, int i3) {
        File fileE = p.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (p.c(fileE, resources, i2)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    protected h.b g(h.b[] bVarArr, int i2) {
        return (h.b) e(bVarArr, i2, new a());
    }
}
