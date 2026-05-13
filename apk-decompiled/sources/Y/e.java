package Y;

import it.tervis.miura.model.Peripheral;
import j0.h;
import j0.j;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final byte[] f587p = {43, 42, 43};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Socket f590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OutputStream f591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private InputStream f592e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d f595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ExecutorService f596i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private f f599l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Timer f601n;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f593f = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CopyOnWriteArrayList f597j = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ExecutorService f598k = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f600m = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected int f602o = 0;

    private class a extends f {
        a(Y.b bVar) {
            super(bVar);
        }
    }

    private class b extends Thread {
        private b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                j0.d.b("driver", "Connecting...");
                synchronized (e.this.f597j) {
                    try {
                        for (Y.a aVar : e.this.f597j) {
                            if (aVar != null) {
                                aVar.e();
                            }
                        }
                    } finally {
                    }
                }
                e.this.f590c = new Socket();
                e.this.f590c.connect(new InetSocketAddress(e.this.f588a, e.this.f589b), 10000);
                j0.d.b("driver", "Connected.");
                e eVar = e.this;
                eVar.f592e = eVar.f590c.getInputStream();
                e eVar2 = e.this;
                eVar2.f591d = eVar2.f590c.getOutputStream();
                synchronized (e.this.f597j) {
                    try {
                        for (Y.a aVar2 : e.this.f597j) {
                            if (aVar2 != null) {
                                aVar2.d();
                            }
                        }
                    } finally {
                    }
                }
                e.this.f593f = false;
                e eVar3 = e.this;
                eVar3.f595h = new d(eVar3, null);
                e.this.f595h.start();
            } catch (Exception e2) {
                j0.d.c(e2);
                synchronized (e.this.f597j) {
                    try {
                        for (Y.a aVar3 : e.this.f597j) {
                            if (aVar3 != null) {
                                aVar3.a();
                            }
                        }
                    } finally {
                    }
                }
            }
        }

        /* synthetic */ b(e eVar, Y.d dVar) {
            this();
        }
    }

    private class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Y.b f605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private f f606b;

        c(Y.b bVar, f fVar) {
            this.f605a = bVar;
            this.f606b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar;
            try {
                if (this.f605a != null) {
                    synchronized (e.this.f597j) {
                        try {
                            for (Y.a aVar : e.this.f597j) {
                                if (aVar != null) {
                                    aVar.c(this.f605a);
                                }
                            }
                        } finally {
                        }
                    }
                } else {
                    j0.d.a("Message is null, there is nothing to dispatch: any error?");
                }
            } catch (Exception e2) {
                j0.d.c(e2);
            }
            Y.b bVar = this.f605a;
            if (bVar == null || (fVar = this.f606b) == null) {
                return;
            }
            try {
                fVar.a(bVar);
            } catch (Exception e3) {
                j0.d.c(e3);
            }
        }
    }

    private class d extends Thread {
        private d() {
        }

        private void a(Y.b bVar) {
            ExecutorService executorService = e.this.f598k;
            e eVar = e.this;
            executorService.execute(eVar.new c(bVar, eVar.f599l));
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            e eVar;
            String str;
            j0.d.b("driver", "RXThread running...");
            try {
                byte[] bArr = new byte[Peripheral.EXPANSION_1];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Peripheral.EXPANSION_2);
                int i2 = 0;
                while (!e.this.f593f && i2 != -1) {
                    i2 = e.this.f592e.read(bArr);
                    j0.d.a("Read " + i2 + " bytes.");
                    byteArrayOutputStream.write(bArr, 0, i2);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < byteArray.length - 3) {
                        if (byteArray[i3] == 43 && byteArray[i3 + 1] == 42 && byteArray[i3 + 2] == 43) {
                            int i5 = i3 + 3;
                            if (i5 < byteArray.length) {
                                int i6 = j.i(byteArray[i5]);
                                int i7 = i5 + i6;
                                if (i7 < byteArray.length) {
                                    int i8 = i3 + 4;
                                    byte[] bArrA = E.a.a(byteArray, i8, i6 + i8);
                                    try {
                                        Y.b bVarE = Y.c.e(Y.b.c(bArrA));
                                        if (bVarE != null) {
                                            j0.d.a("Message: " + bVarE);
                                            e.this.f600m = bVarE.g();
                                            a(bVarE);
                                        } else {
                                            j0.d.a("Can't parse: ");
                                            j0.d.d(Y.b.c(bArrA));
                                        }
                                    } catch (Exception e2) {
                                        j0.d.c(e2);
                                        e.this.x();
                                    }
                                    i3 = i7;
                                    i4 = i3;
                                } else {
                                    eVar = e.this;
                                    str = "Command is not completed";
                                }
                            } else {
                                eVar = e.this;
                                str = "Can't determine command lenght. Continuing...";
                            }
                            eVar.y(str);
                            break;
                        }
                        i4++;
                        i3++;
                    }
                    if (i4 < byteArray.length) {
                        byteArrayOutputStream.reset();
                        byteArrayOutputStream.write(byteArray, i4, byteArray.length - i4);
                    }
                }
                e.this.y("RXThread ended (" + e.this.f593f + "," + i2 + ")");
            } catch (Exception e3) {
                j0.d.c(e3);
                j0.d.a("Error during input stream read.");
                j0.d.a("Socket closed? " + e.this.f590c.isClosed());
                e.this.x();
            }
        }

        /* synthetic */ d(e eVar, Y.d dVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: Y.e$e, reason: collision with other inner class name */
    private class C0015e extends f {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Y.f f609f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f610g;

        C0015e(Y.b bVar, Y.f fVar) {
            super(bVar);
            this.f609f = fVar;
            fVar.getClass();
        }

        @Override // Y.e.f
        protected void a(Y.b bVar) {
            String str;
            j0.d.a("Message arrived on current task: " + bVar);
            synchronized (this.f609f) {
                try {
                    if (this.f610g) {
                        str = "Message already arrived on current task: ignoring it";
                    } else {
                        j0.d.a("No previous message matched");
                        if (this.f609f.a(bVar)) {
                            j0.d.a("This message matches");
                            boolean zC = this.f609f.c(bVar);
                            this.f610g = zC;
                            if (zC) {
                                j0.d.a("This message has been processed");
                                this.f609f.notify();
                            } else {
                                str = "This message has NOT been processed";
                            }
                        } else {
                            j0.d.a("This message does not match. Calling the generic method");
                            this.f609f.b(bVar);
                        }
                    }
                    j0.d.a(str);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // Y.e.f
        protected void c() {
            e.this.f602o = 0;
            synchronized (this.f609f) {
                try {
                    j0.d.a("Waiting for response");
                    this.f609f.wait(25000L);
                } catch (InterruptedException e2) {
                    j0.d.c(e2);
                }
            }
            if (this.f610g) {
                j0.d.a("Message arrived");
            } else {
                j0.d.a("Listener timeout " + this.f609f.toString());
                this.f609f.d();
            }
            e.this.f599l = null;
        }

        @Override // Y.e.f
        protected void d() {
            e.this.f599l = this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.f593f) {
            return;
        }
        try {
            for (Y.a aVar : this.f597j) {
                if (aVar != null) {
                    aVar.b();
                }
            }
        } catch (Exception e2) {
            j0.d.c(e2);
        }
    }

    public void A(Y.a aVar) {
        this.f597j.remove(aVar);
    }

    public void B(Y.b bVar, Y.f fVar) {
        C0015e c0015e = new C0015e(bVar, fVar);
        c0015e.e();
        this.f596i.execute(c0015e);
    }

    public void C(Y.b bVar) {
        this.f596i.execute(new a(bVar));
    }

    public void D(Y.b bVar, Y.f fVar) {
        this.f596i.execute(new C0015e(bVar, fVar));
    }

    public void E(String str, int i2) {
        this.f588a = str;
        this.f589b = i2;
        j0.d.b("driver", "Driver has host " + str);
    }

    public void v(Y.a aVar) {
        this.f597j.add(aVar);
    }

    public void w() {
        j0.d.a("Closing driver, connection and threads.");
        this.f593f = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f597j;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        InputStream inputStream = this.f592e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                j0.d.c(e2);
            }
        }
        OutputStream outputStream = this.f591d;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e3) {
                j0.d.c(e3);
            }
        }
        Socket socket = this.f590c;
        if (socket != null) {
            try {
                socket.close();
            } catch (Exception e4) {
                j0.d.c(e4);
            }
        }
        Timer timer = this.f601n;
        if (timer != null) {
            try {
                timer.cancel();
            } catch (Exception e5) {
                j0.d.c(e5);
            }
        }
        try {
            this.f596i.shutdownNow();
        } catch (Exception unused) {
        }
    }

    public void z() {
        this.f596i = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new j0.g());
        b bVar = new b(this, null);
        this.f594g = bVar;
        bVar.start();
    }

    private abstract class f implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected Y.b f612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected byte[] f613b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected boolean f614c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected boolean f615d;

        f(Y.b bVar) {
            this.f612a = bVar;
        }

        @Override // j0.h
        public boolean b() {
            return this.f615d;
        }

        public void e() {
            this.f615d = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                d();
                if (this.f612a != null) {
                    j0.d.a("Sending message: " + this.f612a.getClass());
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byteArrayOutputStream.write(e.f587p);
                    if (e.this.f600m) {
                        this.f612a.j();
                    } else {
                        this.f612a.k();
                    }
                    byte[] bArrN = this.f612a.n();
                    byteArrayOutputStream.write(bArrN.length);
                    byteArrayOutputStream.write(bArrN);
                    e.this.f591d.write(byteArrayOutputStream.toByteArray());
                    e.this.f591d.flush();
                    e.this.f602o += byteArrayOutputStream.size();
                } else if (this.f614c) {
                    e.this.f591d.write(e.f587p);
                    e.this.f591d.write(this.f613b.length);
                    e.this.f591d.write(this.f613b);
                } else {
                    e.this.f591d.write(this.f613b);
                }
                e.this.f591d.flush();
                c();
            } catch (Exception e2) {
                j0.d.c(e2);
                e.this.x();
            }
        }

        protected void c() {
        }

        protected void d() {
        }

        protected void a(Y.b bVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str) {
    }
}
