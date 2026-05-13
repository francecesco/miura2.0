package n;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import k.C0211e;
import k.C0213g;
import n.h;
import o.InterfaceC0232a;

/* JADX INFO: loaded from: classes.dex */
abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final C0211e f3889a = new C0211e(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExecutorService f3890b = i.a("fonts-androidx", 10, 10000);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Object f3891c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final C0213g f3892d = new C0213g();

    class a implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f3894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f3895c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f3896d;

        a(String str, Context context, f fVar, int i2) {
            this.f3893a = str;
            this.f3894b = context;
            this.f3895c = fVar;
            this.f3896d = i2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return g.c(this.f3893a, this.f3894b, this.f3895c, this.f3896d);
        }
    }

    class b implements InterfaceC0232a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C0228a f3897a;

        b(C0228a c0228a) {
            this.f3897a = c0228a;
        }

        @Override // o.InterfaceC0232a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f3897a.b(eVar);
        }
    }

    class c implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f3899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f3900c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f3901d;

        c(String str, Context context, f fVar, int i2) {
            this.f3898a = str;
            this.f3899b = context;
            this.f3900c = fVar;
            this.f3901d = i2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return g.c(this.f3898a, this.f3899b, this.f3900c, this.f3901d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    class d implements InterfaceC0232a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3902a;

        d(String str) {
            this.f3902a = str;
        }

        @Override // o.InterfaceC0232a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e eVar) {
            synchronized (g.f3891c) {
                try {
                    C0213g c0213g = g.f3892d;
                    ArrayList arrayList = (ArrayList) c0213g.get(this.f3902a);
                    if (arrayList == null) {
                        return;
                    }
                    c0213g.remove(this.f3902a);
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        ((InterfaceC0232a) arrayList.get(i2)).a(eVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Typeface f3903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f3904b;

        e(int i2) {
            this.f3903a = null;
            this.f3904b = i2;
        }

        boolean a() {
            return this.f3904b == 0;
        }

        e(Typeface typeface) {
            this.f3903a = typeface;
            this.f3904b = 0;
        }
    }

    private static String a(f fVar, int i2) {
        return fVar.d() + "-" + i2;
    }

    private static int b(h.a aVar) {
        int i2 = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        h.b[] bVarArrB = aVar.b();
        if (bVarArrB != null && bVarArrB.length != 0) {
            i2 = 0;
            for (h.b bVar : bVarArrB) {
                int iB = bVar.b();
                if (iB != 0) {
                    if (iB < 0) {
                        return -3;
                    }
                    return iB;
                }
            }
        }
        return i2;
    }

    static e c(String str, Context context, f fVar, int i2) {
        C0211e c0211e = f3889a;
        Typeface typeface = (Typeface) c0211e.c(str);
        if (typeface != null) {
            return new e(typeface);
        }
        try {
            h.a aVarE = n.e.e(context, fVar, null);
            int iB = b(aVarE);
            if (iB != 0) {
                return new e(iB);
            }
            Typeface typefaceB = androidx.core.graphics.i.b(context, null, aVarE.b(), i2);
            if (typefaceB == null) {
                return new e(-3);
            }
            c0211e.d(str, typefaceB);
            return new e(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    static Typeface d(Context context, f fVar, int i2, Executor executor, C0228a c0228a) {
        String strA = a(fVar, i2);
        Typeface typeface = (Typeface) f3889a.c(strA);
        if (typeface != null) {
            c0228a.b(new e(typeface));
            return typeface;
        }
        b bVar = new b(c0228a);
        synchronized (f3891c) {
            try {
                C0213g c0213g = f3892d;
                ArrayList arrayList = (ArrayList) c0213g.get(strA);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(bVar);
                c0213g.put(strA, arrayList2);
                c cVar = new c(strA, context, fVar, i2);
                if (executor == null) {
                    executor = f3890b;
                }
                i.b(executor, cVar, new d(strA));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static Typeface e(Context context, f fVar, C0228a c0228a, int i2, int i3) {
        String strA = a(fVar, i2);
        Typeface typeface = (Typeface) f3889a.c(strA);
        if (typeface != null) {
            c0228a.b(new e(typeface));
            return typeface;
        }
        if (i3 == -1) {
            e eVarC = c(strA, context, fVar, i2);
            c0228a.b(eVarC);
            return eVarC.f3903a;
        }
        try {
            e eVar = (e) i.c(f3890b, new a(strA, context, fVar, i2), i3);
            c0228a.b(eVar);
            return eVar.f3903a;
        } catch (InterruptedException unused) {
            c0228a.b(new e(-3));
            return null;
        }
    }
}
