package androidx.startup;

import C.b;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile a f3216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f3217e = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Context f3220c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Set f3219b = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map f3218a = new HashMap();

    a(Context context) {
        this.f3220c = context.getApplicationContext();
    }

    private Object d(Class cls, Set set) {
        Object objB;
        if (b.d()) {
            try {
                b.a(cls.getSimpleName());
            } catch (Throwable th) {
                b.b();
                throw th;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f3218a.containsKey(cls)) {
            objB = this.f3218a.get(cls);
        } else {
            set.add(cls);
            try {
                B.a aVar = (B.a) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listA = aVar.a();
                if (!listA.isEmpty()) {
                    for (Class cls2 : listA) {
                        if (!this.f3218a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                objB = aVar.b(this.f3220c);
                set.remove(cls);
                this.f3218a.put(cls, objB);
            } catch (Throwable th2) {
                throw new B.b(th2);
            }
        }
        b.b();
        return objB;
    }

    public static a e(Context context) {
        if (f3216d == null) {
            synchronized (f3217e) {
                try {
                    if (f3216d == null) {
                        f3216d = new a(context);
                    }
                } finally {
                }
            }
        }
        return f3216d;
    }

    void a() {
        try {
            try {
                b.a("Startup");
                b(this.f3220c.getPackageManager().getProviderInfo(new ComponentName(this.f3220c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e2) {
                throw new B.b(e2);
            }
        } finally {
            b.b();
        }
    }

    void b(Bundle bundle) {
        String string = this.f3220c.getString(R$string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (B.a.class.isAssignableFrom(cls)) {
                            this.f3219b.add(cls);
                        }
                    }
                }
                Iterator it2 = this.f3219b.iterator();
                while (it2.hasNext()) {
                    d((Class) it2.next(), hashSet);
                }
            } catch (ClassNotFoundException e2) {
                throw new B.b(e2);
            }
        }
    }

    Object c(Class cls) {
        Object objD;
        synchronized (f3217e) {
            try {
                objD = this.f3218a.get(cls);
                if (objD == null) {
                    objD = d(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objD;
    }

    public Object f(Class cls) {
        return c(cls);
    }

    public boolean g(Class cls) {
        return this.f3219b.contains(cls);
    }
}
