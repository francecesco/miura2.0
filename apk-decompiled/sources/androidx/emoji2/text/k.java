package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.emoji2.text.f;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import n.h;
import o.AbstractC0236e;

/* JADX INFO: loaded from: classes.dex */
public class k extends f.c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final a f2585k = new a();

    public static class a {
        public Typeface a(Context context, h.b bVar) {
            return n.h.a(context, null, new h.b[]{bVar});
        }

        public h.a b(Context context, n.f fVar) {
            return n.h.b(context, null, fVar);
        }

        public void c(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements f.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f2586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final n.f f2587b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final a f2588c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Object f2589d = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Handler f2590e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Executor f2591f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private ThreadPoolExecutor f2592g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        f.i f2593h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private ContentObserver f2594i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Runnable f2595j;

        b(Context context, n.f fVar, a aVar) {
            AbstractC0236e.g(context, "Context cannot be null");
            AbstractC0236e.g(fVar, "FontRequest cannot be null");
            this.f2586a = context.getApplicationContext();
            this.f2587b = fVar;
            this.f2588c = aVar;
        }

        private void b() {
            synchronized (this.f2589d) {
                try {
                    this.f2593h = null;
                    ContentObserver contentObserver = this.f2594i;
                    if (contentObserver != null) {
                        this.f2588c.c(this.f2586a, contentObserver);
                        this.f2594i = null;
                    }
                    Handler handler = this.f2590e;
                    if (handler != null) {
                        handler.removeCallbacks(this.f2595j);
                    }
                    this.f2590e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f2592g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f2591f = null;
                    this.f2592g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private h.b e() {
            try {
                h.a aVarB = this.f2588c.b(this.f2586a, this.f2587b);
                if (aVarB.c() == 0) {
                    h.b[] bVarArrB = aVarB.b();
                    if (bVarArrB == null || bVarArrB.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return bVarArrB[0];
                }
                throw new RuntimeException("fetchFonts failed (" + aVarB.c() + ")");
            } catch (PackageManager.NameNotFoundException e2) {
                throw new RuntimeException("provider not found", e2);
            }
        }

        @Override // androidx.emoji2.text.f.h
        public void a(f.i iVar) {
            AbstractC0236e.g(iVar, "LoaderCallback cannot be null");
            synchronized (this.f2589d) {
                this.f2593h = iVar;
            }
            d();
        }

        void c() {
            synchronized (this.f2589d) {
                try {
                    if (this.f2593h == null) {
                        return;
                    }
                    try {
                        h.b bVarE = e();
                        int iB = bVarE.b();
                        if (iB == 2) {
                            synchronized (this.f2589d) {
                            }
                        }
                        if (iB != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + iB + ")");
                        }
                        try {
                            androidx.core.os.m.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface typefaceA = this.f2588c.a(this.f2586a, bVarE);
                            ByteBuffer byteBufferF = androidx.core.graphics.p.f(this.f2586a, null, bVarE.d());
                            if (byteBufferF == null || typefaceA == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            n nVarB = n.b(typefaceA, byteBufferF);
                            androidx.core.os.m.b();
                            synchronized (this.f2589d) {
                                try {
                                    f.i iVar = this.f2593h;
                                    if (iVar != null) {
                                        iVar.b(nVarB);
                                    }
                                } finally {
                                }
                            }
                            b();
                        } catch (Throwable th) {
                            androidx.core.os.m.b();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        synchronized (this.f2589d) {
                            try {
                                f.i iVar2 = this.f2593h;
                                if (iVar2 != null) {
                                    iVar2.a(th2);
                                }
                                b();
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        void d() {
            synchronized (this.f2589d) {
                try {
                    if (this.f2593h == null) {
                        return;
                    }
                    if (this.f2591f == null) {
                        ThreadPoolExecutor threadPoolExecutorB = c.b("emojiCompat");
                        this.f2592g = threadPoolExecutorB;
                        this.f2591f = threadPoolExecutorB;
                    }
                    this.f2591f.execute(new Runnable() { // from class: androidx.emoji2.text.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f2596a.c();
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void f(Executor executor) {
            synchronized (this.f2589d) {
                this.f2591f = executor;
            }
        }
    }

    public k(Context context, n.f fVar) {
        super(new b(context, fVar, f2585k));
    }

    public k c(Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}
