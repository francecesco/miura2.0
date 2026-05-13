package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.res.e;
import androidx.core.content.res.h;
import k.C0211e;
import n.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final o f2209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final C0211e f2210b;

    public static class a extends h.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private h.e f2211a;

        public a(h.e eVar) {
            this.f2211a = eVar;
        }

        @Override // n.h.c
        public void a(int i2) {
            h.e eVar = this.f2211a;
            if (eVar != null) {
                eVar.f(i2);
            }
        }

        @Override // n.h.c
        public void b(Typeface typeface) {
            h.e eVar = this.f2211a;
            if (eVar != null) {
                eVar.g(typeface);
            }
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        f2209a = i2 >= 29 ? new n() : i2 >= 28 ? new m() : i2 >= 26 ? new l() : (i2 < 24 || !k.j()) ? new j() : new k();
        f2210b = new C0211e(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i2) {
        if (context != null) {
            return Typeface.create(typeface, i2);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, h.b[] bVarArr, int i2) {
        return f2209a.b(context, cancellationSignal, bVarArr, i2);
    }

    public static Typeface c(Context context, e.b bVar, Resources resources, int i2, String str, int i3, int i4, h.e eVar, Handler handler, boolean z2) {
        Typeface typefaceA;
        if (bVar instanceof e.C0032e) {
            e.C0032e c0032e = (e.C0032e) bVar;
            Typeface typefaceG = g(c0032e.c());
            if (typefaceG != null) {
                if (eVar != null) {
                    eVar.d(typefaceG, handler);
                }
                return typefaceG;
            }
            typefaceA = n.h.c(context, c0032e.b(), i4, !z2 ? eVar != null : c0032e.a() != 0, z2 ? c0032e.d() : -1, h.e.e(handler), new a(eVar));
        } else {
            typefaceA = f2209a.a(context, (e.c) bVar, resources, i4);
            if (eVar != null) {
                if (typefaceA != null) {
                    eVar.d(typefaceA, handler);
                } else {
                    eVar.c(-3, handler);
                }
            }
        }
        if (typefaceA != null) {
            f2210b.d(e(resources, i2, str, i3, i4), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface d(Context context, Resources resources, int i2, String str, int i3, int i4) {
        Typeface typefaceD = f2209a.d(context, resources, i2, str, i4);
        if (typefaceD != null) {
            f2210b.d(e(resources, i2, str, i3, i4), typefaceD);
        }
        return typefaceD;
    }

    private static String e(Resources resources, int i2, String str, int i3, int i4) {
        return resources.getResourcePackageName(i2) + '-' + str + '-' + i3 + '-' + i2 + '-' + i4;
    }

    public static Typeface f(Resources resources, int i2, String str, int i3, int i4) {
        return (Typeface) f2210b.c(e(resources, i2, str, i3, i4));
    }

    private static Typeface g(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface typefaceCreate = Typeface.create(str, 0);
        Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
        if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
            return null;
        }
        return typefaceCreate;
    }
}
