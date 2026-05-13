package n;

import android.graphics.Typeface;
import android.os.Handler;
import n.g;
import n.h;

/* JADX INFO: renamed from: n.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0228a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h.c f3872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f3873b;

    /* JADX INFO: renamed from: n.a$a, reason: collision with other inner class name */
    class RunnableC0068a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.c f3874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Typeface f3875b;

        RunnableC0068a(h.c cVar, Typeface typeface) {
            this.f3874a = cVar;
            this.f3875b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3874a.b(this.f3875b);
        }
    }

    /* JADX INFO: renamed from: n.a$b */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.c f3877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3878b;

        b(h.c cVar, int i2) {
            this.f3877a = cVar;
            this.f3878b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3877a.a(this.f3878b);
        }
    }

    C0228a(h.c cVar, Handler handler) {
        this.f3872a = cVar;
        this.f3873b = handler;
    }

    private void a(int i2) {
        this.f3873b.post(new b(this.f3872a, i2));
    }

    private void c(Typeface typeface) {
        this.f3873b.post(new RunnableC0068a(this.f3872a, typeface));
    }

    void b(g.e eVar) {
        if (eVar.a()) {
            c(eVar.f3903a);
        } else {
            a(eVar.f3904b);
        }
    }
}
