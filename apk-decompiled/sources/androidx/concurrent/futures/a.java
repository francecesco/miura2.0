package androidx.concurrent.futures;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Future {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final boolean f1972d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Logger f1973e = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final b f1974f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f1975g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile Object f1976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile e f1977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile h f1978c;

    private static abstract class b {
        private b() {
        }

        abstract boolean a(a aVar, e eVar, e eVar2);

        abstract boolean b(a aVar, Object obj, Object obj2);

        abstract boolean c(a aVar, h hVar, h hVar2);

        abstract void d(h hVar, h hVar2);

        abstract void e(h hVar, Thread thread);
    }

    private static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final c f1979c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final c f1980d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f1981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Throwable f1982b;

        static {
            if (a.f1972d) {
                f1980d = null;
                f1979c = null;
            } else {
                f1980d = new c(false, null);
                f1979c = new c(true, null);
            }
        }

        c(boolean z2, Throwable th) {
            this.f1981a = z2;
            this.f1982b = th;
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Throwable f1983a;
    }

    private static final class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final e f1984d = new e(null, null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f1985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f1986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        e f1987c;

        e(Runnable runnable, Executor executor) {
            this.f1985a = runnable;
            this.f1986b = executor;
        }
    }

    private static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f1988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f1989b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f1990c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f1991d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f1992e;

        f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f1988a = atomicReferenceFieldUpdater;
            this.f1989b = atomicReferenceFieldUpdater2;
            this.f1990c = atomicReferenceFieldUpdater3;
            this.f1991d = atomicReferenceFieldUpdater4;
            this.f1992e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.a.b
        boolean a(a aVar, e eVar, e eVar2) {
            return androidx.concurrent.futures.b.a(this.f1991d, aVar, eVar, eVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        boolean b(a aVar, Object obj, Object obj2) {
            return androidx.concurrent.futures.b.a(this.f1992e, aVar, obj, obj2);
        }

        @Override // androidx.concurrent.futures.a.b
        boolean c(a aVar, h hVar, h hVar2) {
            return androidx.concurrent.futures.b.a(this.f1990c, aVar, hVar, hVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        void d(h hVar, h hVar2) {
            this.f1989b.lazySet(hVar, hVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        void e(h hVar, Thread thread) {
            this.f1988a.lazySet(hVar, thread);
        }
    }

    private static final class g extends b {
        g() {
            super();
        }

        @Override // androidx.concurrent.futures.a.b
        boolean a(a aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.f1977b != eVar) {
                        return false;
                    }
                    aVar.f1977b = eVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.b
        boolean b(a aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                try {
                    if (aVar.f1976a != obj) {
                        return false;
                    }
                    aVar.f1976a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.b
        boolean c(a aVar, h hVar, h hVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.f1978c != hVar) {
                        return false;
                    }
                    aVar.f1978c = hVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.b
        void d(h hVar, h hVar2) {
            hVar.f1995b = hVar2;
        }

        @Override // androidx.concurrent.futures.a.b
        void e(h hVar, Thread thread) {
            hVar.f1994a = thread;
        }
    }

    private static final class h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final h f1993c = new h(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile Thread f1994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile h f1995b;

        h() {
            a.f1974f.e(this, Thread.currentThread());
        }

        void a(h hVar) {
            a.f1974f.d(this, hVar);
        }

        void b() {
            Thread thread = this.f1994a;
            if (thread != null) {
                this.f1994a = null;
                LockSupport.unpark(thread);
            }
        }

        h(boolean z2) {
        }
    }

    static {
        b gVar;
        try {
            gVar = new f(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, h.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            gVar = new g();
        }
        f1974f = gVar;
        if (th != null) {
            f1973e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f1975g = new Object();
    }

    protected a() {
    }

    private void a(StringBuilder sb) {
        String str = "]";
        try {
            Object objH = h(this);
            sb.append("SUCCESS, result=[");
            sb.append(n(objH));
            sb.append("]");
        } catch (CancellationException unused) {
            str = "CANCELLED";
            sb.append(str);
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            str = " thrown from get()]";
            sb.append(str);
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append(str);
        }
    }

    private static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    private e d(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f1977b;
        } while (!f1974f.a(this, eVar2, e.f1984d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f1987c;
            eVar4.f1987c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    static void e(a aVar) {
        aVar.k();
        aVar.b();
        e eVarD = aVar.d(null);
        while (eVarD != null) {
            e eVar = eVarD.f1987c;
            f(eVarD.f1985a, eVarD.f1986b);
            eVarD = eVar;
        }
    }

    private static void f(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            f1973e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    private Object g(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw c("Task was cancelled.", ((c) obj).f1982b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f1983a);
        }
        if (obj == f1975g) {
            return null;
        }
        return obj;
    }

    static Object h(Future future) {
        Object obj;
        boolean z2 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private void k() {
        h hVar;
        do {
            hVar = this.f1978c;
        } while (!f1974f.c(this, hVar, h.f1993c));
        while (hVar != null) {
            hVar.b();
            hVar = hVar.f1995b;
        }
    }

    private void l(h hVar) {
        hVar.f1994a = null;
        while (true) {
            h hVar2 = this.f1978c;
            if (hVar2 == h.f1993c) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.f1995b;
                if (hVar2.f1994a != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.f1995b = hVar4;
                    if (hVar3.f1994a == null) {
                        break;
                    }
                } else if (!f1974f.c(this, hVar2, hVar4)) {
                    break;
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    private String n(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    protected void b() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        Object obj = this.f1976a;
        if (obj == null) {
            if (f1974f.b(this, obj, f1972d ? new c(z2, new CancellationException("Future.cancel() was called.")) : z2 ? c.f1979c : c.f1980d)) {
                if (z2) {
                    i();
                }
                e(this);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f1976a;
        if (obj2 != null) {
            return g(obj2);
        }
        h hVar = this.f1978c;
        if (hVar != h.f1993c) {
            h hVar2 = new h();
            do {
                hVar2.a(hVar);
                if (f1974f.c(this, hVar, hVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            l(hVar2);
                            throw new InterruptedException();
                        }
                        obj = this.f1976a;
                    } while (!(obj != null));
                    return g(obj);
                }
                hVar = this.f1978c;
            } while (hVar != h.f1993c);
        }
        return g(this.f1976a);
    }

    protected void i() {
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f1976a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f1976a != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String j() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    protected boolean m(Object obj) {
        if (obj == null) {
            obj = f1975g;
        }
        if (!f1974f.b(this, null, obj)) {
            return false;
        }
        e(this);
        return true;
    }

    public String toString() {
        String strJ;
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (!isCancelled()) {
            if (isDone()) {
                a(sb);
            } else {
                try {
                    strJ = j();
                } catch (RuntimeException e2) {
                    strJ = "Exception thrown from implementation: " + e2.getClass();
                }
                if (strJ == null || strJ.isEmpty()) {
                    str = isDone() ? "CANCELLED" : "PENDING";
                    a(sb);
                } else {
                    sb.append("PENDING, info=[");
                    sb.append(strJ);
                    sb.append("]");
                }
            }
            sb.append("]");
            return sb.toString();
        }
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f1976a;
        if (obj != null) {
            return g(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.f1978c;
            if (hVar != h.f1993c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f1974f.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                l(hVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f1976a;
                            if (obj2 != null) {
                                return g(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        l(hVar2);
                    } else {
                        hVar = this.f1978c;
                    }
                } while (hVar != h.f1993c);
            }
            return g(this.f1976a);
        }
        while (nanos > 0) {
            Object obj3 = this.f1976a;
            if (obj3 != null) {
                return g(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j3 = -nanos;
            long jConvert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
            long nanos2 = j3 - timeUnit.toNanos(jConvert);
            boolean z2 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z2) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z2) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }
}
