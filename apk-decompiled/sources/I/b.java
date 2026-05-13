package I;

import G.i;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import it.tervis.miura.model.Console;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import k.C0208b;

/* JADX INFO: loaded from: classes.dex */
public class b implements Handler.Callback {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Status f74m = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Status f75n = new Status(4, "The user must be signed in to make this API call.");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Object f76o = new Object();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static b f77p;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f81d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final i f82e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final K.c f83f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Handler f89l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f78a = 5000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f79b = 120000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f80c = 10000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicInteger f84g = new AtomicInteger(1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicInteger f85h = new AtomicInteger(0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map f86i = new ConcurrentHashMap(5, 0.75f, 1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Set f87j = new C0208b();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Set f88k = new C0208b();

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue f90a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f91b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f92c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f93d;

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(C0001b c0001b) {
            if (this.f92c.contains(c0001b) && !this.f91b) {
                throw null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h(C0001b c0001b) {
            G.c[] cVarArrB;
            if (this.f92c.remove(c0001b)) {
                this.f93d.f89l.removeMessages(15, c0001b);
                this.f93d.f89l.removeMessages(16, c0001b);
                G.c cVar = c0001b.f94a;
                ArrayList arrayList = new ArrayList(this.f90a.size());
                for (e eVar : this.f90a) {
                    if ((eVar instanceof g) && (cVarArrB = ((g) eVar).b(this)) != null && O.a.a(cVarArrB, cVar)) {
                        arrayList.add(eVar);
                    }
                }
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    e eVar2 = (e) obj;
                    this.f90a.remove(eVar2);
                    eVar2.a(new H.c(cVar));
                }
            }
        }

        public abstract void a();

        public abstract int b();

        public abstract void c();

        public abstract void f();

        public abstract void i();

        public abstract void j();

        public abstract boolean k();

        public abstract void l(Status status);
    }

    /* JADX INFO: renamed from: I.b$b, reason: collision with other inner class name */
    private static class C0001b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final G.c f94a;

        static /* synthetic */ h a(C0001b c0001b) {
            c0001b.getClass();
            return null;
        }
    }

    private b(Context context, Looper looper, i iVar) {
        this.f81d = context;
        R.a aVar = new R.a(looper, this);
        this.f89l = aVar;
        this.f82e = iVar;
        this.f83f = new K.c(iVar);
        aVar.sendMessage(aVar.obtainMessage(6));
    }

    public static b c(Context context) {
        b bVar;
        synchronized (f76o) {
            try {
                if (f77p == null) {
                    HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                    handlerThread.start();
                    f77p = new b(context.getApplicationContext(), handlerThread.getLooper(), i.k());
                }
                bVar = f77p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    private final void d(H.b bVar) {
        throw null;
    }

    public final void b(G.a aVar, int i2) {
        if (e(aVar, i2)) {
            return;
        }
        Handler handler = this.f89l;
        handler.sendMessage(handler.obtainMessage(5, i2, 0, aVar));
    }

    final boolean e(G.a aVar, int i2) {
        return this.f82e.r(this.f81d, aVar, i2);
    }

    public final void f() {
        Handler handler = this.f89l;
        handler.sendMessage(handler.obtainMessage(3));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        switch (i2) {
            case 1:
                this.f80c = ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.f89l.removeMessages(12);
                Iterator it2 = this.f86i.keySet().iterator();
                while (it2.hasNext()) {
                    android.support.v4.media.session.b.a(it2.next());
                    Handler handler = this.f89l;
                    handler.sendMessageDelayed(handler.obtainMessage(12, null), this.f80c);
                }
                return true;
            case 2:
                android.support.v4.media.session.b.a(message.obj);
                throw null;
            case 3:
                for (a aVar : this.f86i.values()) {
                    aVar.j();
                    aVar.a();
                }
                return true;
            case 4:
            case 8:
            case 13:
                android.support.v4.media.session.b.a(message.obj);
                throw null;
            case 5:
                int i3 = message.arg1;
                Iterator it3 = this.f86i.values().iterator();
                while (it3.hasNext() && ((a) it3.next()).b() != i3) {
                }
                StringBuilder sb = new StringBuilder(76);
                sb.append("Could not find API instance ");
                sb.append(i3);
                sb.append(" while trying to fail enqueued calls.");
                Log.wtf("GoogleApiManager", sb.toString(), new Exception());
                return true;
            case 6:
                if (O.h.a() && (this.f81d.getApplicationContext() instanceof Application)) {
                    I.a.c((Application) this.f81d.getApplicationContext());
                    I.a.b().a(new f(this));
                    if (!I.a.b().f(true)) {
                        this.f80c = 300000L;
                    }
                }
                return true;
            case Console.MAX_CONSOLE /* 7 */:
                android.support.v4.media.session.b.a(message.obj);
                d(null);
                return true;
            case 9:
                if (this.f86i.containsKey(message.obj)) {
                    ((a) this.f86i.get(message.obj)).c();
                }
                return true;
            case 10:
                Iterator it4 = this.f88k.iterator();
                while (it4.hasNext()) {
                    android.support.v4.media.session.b.a(it4.next());
                    ((a) this.f86i.remove(null)).i();
                }
                this.f88k.clear();
                return true;
            case 11:
                if (this.f86i.containsKey(message.obj)) {
                    ((a) this.f86i.get(message.obj)).f();
                }
                return true;
            case 12:
                if (this.f86i.containsKey(message.obj)) {
                    ((a) this.f86i.get(message.obj)).k();
                }
                return true;
            case 14:
                android.support.v4.media.session.b.a(message.obj);
                throw null;
            case 15:
                C0001b c0001b = (C0001b) message.obj;
                Map map = this.f86i;
                C0001b.a(c0001b);
                if (map.containsKey(null)) {
                    Map map2 = this.f86i;
                    C0001b.a(c0001b);
                    ((a) map2.get(null)).e(c0001b);
                }
                return true;
            case 16:
                C0001b c0001b2 = (C0001b) message.obj;
                Map map3 = this.f86i;
                C0001b.a(c0001b2);
                if (map3.containsKey(null)) {
                    Map map4 = this.f86i;
                    C0001b.a(c0001b2);
                    ((a) map4.get(null)).h(c0001b2);
                }
                return true;
            default:
                StringBuilder sb2 = new StringBuilder(31);
                sb2.append("Unknown message id: ");
                sb2.append(i2);
                return false;
        }
    }
}
