package O;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f143a = Process.myUid();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Method f144b = k();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Method f145c = l();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Method f146d = m();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Method f147e = n();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Method f148f = h();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Method f149g = i();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Method f150h = j();

    public static WorkSource a(Context context, String str) {
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                ApplicationInfo applicationInfoC = P.b.a(context).c(str, 0);
                if (applicationInfoC != null) {
                    return e(applicationInfoC.uid, str);
                }
                if (str.length() != 0) {
                    "Could not get applicationInfo from package: ".concat(str);
                }
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                if (str.length() != 0) {
                    "Could not find package: ".concat(str);
                }
            }
        }
        return null;
    }

    public static List b(WorkSource workSource) {
        int iD = workSource == null ? 0 : d(workSource);
        if (iD == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < iD; i2++) {
            String strF = f(workSource, i2);
            if (!j.a(strF)) {
                arrayList.add(strF);
            }
        }
        return arrayList;
    }

    public static boolean c(Context context) {
        return (context == null || context.getPackageManager() == null || P.b.a(context).b("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    private static int d(WorkSource workSource) {
        Method method = f146d;
        if (method == null) {
            return 0;
        }
        try {
            return ((Integer) method.invoke(workSource, null)).intValue();
        } catch (Exception e2) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            return 0;
        }
    }

    private static WorkSource e(int i2, String str) {
        WorkSource workSource = new WorkSource();
        g(workSource, i2, str);
        return workSource;
    }

    private static String f(WorkSource workSource, int i2) {
        Method method = f148f;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, Integer.valueOf(i2));
        } catch (Exception e2) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            return null;
        }
    }

    private static void g(WorkSource workSource, int i2, String str) {
        Method method = f145c;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, Integer.valueOf(i2), str);
                return;
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                return;
            }
        }
        Method method2 = f144b;
        if (method2 != null) {
            try {
                method2.invoke(workSource, Integer.valueOf(i2));
            } catch (Exception e3) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
            }
        }
    }

    private static Method h() {
        if (h.c()) {
            try {
                return WorkSource.class.getMethod("getName", Integer.TYPE);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static final Method i() {
        if (!h.h()) {
            return null;
        }
        try {
            return WorkSource.class.getMethod("createWorkChain", null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static final Method j() {
        if (h.h()) {
            try {
                return Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static Method k() {
        try {
            return WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method l() {
        if (h.c()) {
            try {
                return WorkSource.class.getMethod("add", Integer.TYPE, String.class);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static Method m() {
        try {
            return WorkSource.class.getMethod("size", null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method n() {
        try {
            return WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception unused) {
            return null;
        }
    }
}
