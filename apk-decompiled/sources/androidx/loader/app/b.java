package androidx.loader.app;

import androidx.lifecycle.A;
import androidx.lifecycle.B;
import androidx.lifecycle.D;
import androidx.lifecycle.l;
import androidx.lifecycle.z;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import k.C0214h;
import o.AbstractC0233b;
import y.AbstractC0272a;

/* JADX INFO: loaded from: classes.dex */
class b extends androidx.loader.app.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f3128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f3129b;

    static class a extends z {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final A.b f3130f = new C0052a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private C0214h f3131d = new C0214h();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f3132e = false;

        /* JADX INFO: renamed from: androidx.loader.app.b$a$a, reason: collision with other inner class name */
        static class C0052a implements A.b {
            C0052a() {
            }

            @Override // androidx.lifecycle.A.b
            public z a(Class cls) {
                return new a();
            }

            @Override // androidx.lifecycle.A.b
            public /* synthetic */ z b(Class cls, AbstractC0272a abstractC0272a) {
                return B.b(this, cls, abstractC0272a);
            }
        }

        a() {
        }

        static a f(D d2) {
            return (a) new A(d2, f3130f).a(a.class);
        }

        @Override // androidx.lifecycle.z
        protected void d() {
            super.d();
            if (this.f3131d.i() <= 0) {
                this.f3131d.b();
            } else {
                android.support.v4.media.session.b.a(this.f3131d.j(0));
                throw null;
            }
        }

        public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f3131d.i() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("    ");
                if (this.f3131d.i() <= 0) {
                    return;
                }
                android.support.v4.media.session.b.a(this.f3131d.j(0));
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f3131d.g(0));
                printWriter.print(": ");
                throw null;
            }
        }

        void g() {
            if (this.f3131d.i() <= 0) {
                return;
            }
            android.support.v4.media.session.b.a(this.f3131d.j(0));
            throw null;
        }
    }

    b(l lVar, D d2) {
        this.f3128a = lVar;
        this.f3129b = a.f(d2);
    }

    @Override // androidx.loader.app.a
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f3129b.e(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.a
    public void c() {
        this.f3129b.g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        AbstractC0233b.a(this.f3128a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
