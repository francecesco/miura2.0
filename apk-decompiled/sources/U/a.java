package U;

import K.e;
import N.d;
import O.j;
import O.k;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static ScheduledExecutorService f366n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static volatile InterfaceC0004a f367o = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PowerManager.WakeLock f369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WorkSource f370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Context f375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f377j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Set f378k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f379l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private AtomicInteger f380m;

    /* JADX INFO: renamed from: U.a$a, reason: collision with other inner class name */
    public interface InterfaceC0004a {
    }

    public a(Context context, int i2, String str) {
        this(context, i2, str, null, context == null ? null : context.getPackageName());
    }

    private final String e(String str) {
        return this.f376i ? !TextUtils.isEmpty(str) ? str : this.f373f : this.f373f;
    }

    private final List f() {
        return k.b(this.f370c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(int i2) {
        if (this.f369b.isHeld()) {
            try {
                this.f369b.release();
            } catch (RuntimeException e2) {
                if (!e2.getClass().equals(RuntimeException.class)) {
                    throw e2;
                }
                String.valueOf(this.f372e).concat(" was already released!");
            }
            this.f369b.isHeld();
        }
    }

    public void a(long j2) {
        this.f380m.incrementAndGet();
        String strE = e(null);
        synchronized (this.f368a) {
            try {
                if (!this.f377j.isEmpty() || this.f379l > 0) {
                    if (!this.f369b.isHeld()) {
                        this.f377j.clear();
                        this.f379l = 0;
                    }
                }
                if (this.f376i) {
                    Integer[] numArr = (Integer[]) this.f377j.get(strE);
                    if (numArr == null) {
                        this.f377j.put(strE, new Integer[]{1});
                        d.a().c(this.f375h, N.c.a(this.f369b, strE), 7, this.f372e, strE, null, this.f371d, f(), j2);
                        this.f379l++;
                    } else {
                        numArr[0] = Integer.valueOf(numArr[0].intValue() + 1);
                        if (!this.f376i) {
                            d.a().c(this.f375h, N.c.a(this.f369b, strE), 7, this.f372e, strE, null, this.f371d, f(), j2);
                            this.f379l++;
                        }
                    }
                } else if (!this.f376i && this.f379l == 0) {
                    d.a().c(this.f375h, N.c.a(this.f369b, strE), 7, this.f372e, strE, null, this.f371d, f(), j2);
                    this.f379l++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f369b.acquire();
        if (j2 > 0) {
            f366n.schedule(new c(this), j2, TimeUnit.MILLISECONDS);
        }
    }

    public boolean b() {
        return this.f369b.isHeld();
    }

    public void c() {
        Integer[] numArr;
        if (this.f380m.decrementAndGet() < 0) {
            String.valueOf(this.f372e).concat(" release without a matched acquire!");
        }
        String strE = e(null);
        synchronized (this.f368a) {
            try {
                if (!this.f376i || (numArr = (Integer[]) this.f377j.get(strE)) == null) {
                    if (!this.f376i && this.f379l == 1) {
                        d.a().b(this.f375h, N.c.a(this.f369b, strE), 8, this.f372e, strE, null, this.f371d, f());
                        this.f379l--;
                    }
                } else if (numArr[0].intValue() == 1) {
                    this.f377j.remove(strE);
                    d.a().b(this.f375h, N.c.a(this.f369b, strE), 8, this.f372e, strE, null, this.f371d, f());
                    this.f379l--;
                } else {
                    numArr[0] = Integer.valueOf(numArr[0].intValue() - 1);
                    if (!this.f376i) {
                        d.a().b(this.f375h, N.c.a(this.f369b, strE), 8, this.f372e, strE, null, this.f371d, f());
                        this.f379l--;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        g(0);
    }

    public void d(boolean z2) {
        this.f369b.setReferenceCounted(z2);
        this.f376i = z2;
    }

    private a(Context context, int i2, String str, String str2, String str3) {
        this(context, i2, str, null, str3, null);
    }

    private a(Context context, int i2, String str, String str2, String str3, String str4) {
        this.f368a = this;
        this.f376i = true;
        this.f377j = new HashMap();
        this.f378k = Collections.synchronizedSet(new HashSet());
        this.f380m = new AtomicInteger(0);
        e.g(context, "WakeLock: context must not be null");
        e.e(str, "WakeLock: wakeLockName must not be empty");
        this.f371d = i2;
        this.f373f = null;
        this.f374g = null;
        Context applicationContext = context.getApplicationContext();
        this.f375h = applicationContext;
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f372e = str;
        } else {
            String strValueOf = String.valueOf(str);
            this.f372e = strValueOf.length() != 0 ? "*gcore*:".concat(strValueOf) : new String("*gcore*:");
        }
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i2, str);
        this.f369b = wakeLockNewWakeLock;
        if (k.c(context)) {
            WorkSource workSourceA = k.a(context, j.a(str3) ? context.getPackageName() : str3);
            this.f370c = workSourceA;
            if (workSourceA != null && k.c(applicationContext)) {
                WorkSource workSource = this.f370c;
                if (workSource != null) {
                    workSource.add(workSourceA);
                } else {
                    this.f370c = workSourceA;
                }
                try {
                    wakeLockNewWakeLock.setWorkSource(this.f370c);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e2) {
                    Log.wtf("WakeLock", e2.toString());
                }
            }
        }
        if (f366n == null) {
            f366n = M.a.a().a();
        }
    }
}
