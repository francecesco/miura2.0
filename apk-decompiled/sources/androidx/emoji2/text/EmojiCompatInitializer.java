package androidx.emoji2.text;

import android.content.Context;
import androidx.emoji2.text.f;
import androidx.lifecycle.AbstractC0178b;
import androidx.lifecycle.AbstractC0183g;
import androidx.lifecycle.InterfaceC0179c;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements B.a {

    static class a extends f.c {
        protected a(Context context) {
            super(new b(context));
            b(1);
        }
    }

    static class b implements f.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f2519a;

        class a extends f.i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ f.i f2520a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ThreadPoolExecutor f2521b;

            a(f.i iVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f2520a = iVar;
                this.f2521b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.f.i
            public void a(Throwable th) {
                try {
                    this.f2520a.a(th);
                } finally {
                    this.f2521b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.f.i
            public void b(n nVar) {
                try {
                    this.f2520a.b(nVar);
                } finally {
                    this.f2521b.shutdown();
                }
            }
        }

        b(Context context) {
            this.f2519a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.f.h
        public void a(final f.i iVar) {
            final ThreadPoolExecutor threadPoolExecutorB = androidx.emoji2.text.c.b("EmojiCompatInitializer");
            threadPoolExecutorB.execute(new Runnable() { // from class: androidx.emoji2.text.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2561a.d(iVar, threadPoolExecutorB);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(f.i iVar, ThreadPoolExecutor threadPoolExecutor) {
            try {
                k kVarA = d.a(this.f2519a);
                if (kVarA == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                kVarA.c(threadPoolExecutor);
                kVarA.a().a(new a(iVar, threadPoolExecutor));
            } catch (Throwable th) {
                iVar.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                androidx.core.os.m.a("EmojiCompat.EmojiCompatInitializer.run");
                if (f.i()) {
                    f.c().l();
                }
            } finally {
                androidx.core.os.m.b();
            }
        }
    }

    @Override // B.a
    public List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // B.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean b(Context context) {
        f.h(new a(context));
        d(context);
        return Boolean.TRUE;
    }

    void d(Context context) {
        final AbstractC0183g abstractC0183gG = ((androidx.lifecycle.l) androidx.startup.a.e(context).f(ProcessLifecycleInitializer.class)).G();
        abstractC0183gG.a(new InterfaceC0179c() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.InterfaceC0179c
            public void a(androidx.lifecycle.l lVar) {
                EmojiCompatInitializer.this.e();
                abstractC0183gG.c(this);
            }

            @Override // androidx.lifecycle.InterfaceC0179c
            public /* synthetic */ void b(androidx.lifecycle.l lVar) {
                AbstractC0178b.b(this, lVar);
            }

            @Override // androidx.lifecycle.InterfaceC0179c
            public /* synthetic */ void c(androidx.lifecycle.l lVar) {
                AbstractC0178b.a(this, lVar);
            }

            @Override // androidx.lifecycle.InterfaceC0179c
            public /* synthetic */ void e(androidx.lifecycle.l lVar) {
                AbstractC0178b.c(this, lVar);
            }

            @Override // androidx.lifecycle.InterfaceC0179c
            public /* synthetic */ void f(androidx.lifecycle.l lVar) {
                AbstractC0178b.e(this, lVar);
            }

            @Override // androidx.lifecycle.InterfaceC0179c
            public /* synthetic */ void g(androidx.lifecycle.l lVar) {
                AbstractC0178b.d(this, lVar);
            }
        });
    }

    void e() {
        androidx.emoji2.text.c.d().postDelayed(new c(), 500L);
    }
}
