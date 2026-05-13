package n;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import o.AbstractC0236e;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f3905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b[] f3906b;

        public a(int i2, b[] bVarArr) {
            this.f3905a = i2;
            this.f3906b = bVarArr;
        }

        static a a(int i2, b[] bVarArr) {
            return new a(i2, bVarArr);
        }

        public b[] b() {
            return this.f3906b;
        }

        public int c() {
            return this.f3905a;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f3907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f3908b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f3909c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f3910d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f3911e;

        public b(Uri uri, int i2, int i3, boolean z2, int i4) {
            this.f3907a = (Uri) AbstractC0236e.f(uri);
            this.f3908b = i2;
            this.f3909c = i3;
            this.f3910d = z2;
            this.f3911e = i4;
        }

        static b a(Uri uri, int i2, int i3, boolean z2, int i4) {
            return new b(uri, i2, i3, z2, i4);
        }

        public int b() {
            return this.f3911e;
        }

        public int c() {
            return this.f3908b;
        }

        public Uri d() {
            return this.f3907a;
        }

        public int e() {
            return this.f3909c;
        }

        public boolean f() {
            return this.f3910d;
        }
    }

    public static class c {
        public abstract void a(int i2);

        public abstract void b(Typeface typeface);
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return androidx.core.graphics.i.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, f fVar) {
        return e.e(context, fVar, cancellationSignal);
    }

    public static Typeface c(Context context, f fVar, int i2, boolean z2, int i3, Handler handler, c cVar) {
        C0228a c0228a = new C0228a(cVar, handler);
        return z2 ? g.e(context, fVar, c0228a, i2, i3) : g.d(context, fVar, i2, null, c0228a);
    }
}
