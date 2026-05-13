package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import v.C0253a;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ThreadLocal f2610d = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f2612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f2613c = 0;

    p(n nVar, int i2) {
        this.f2612b = nVar;
        this.f2611a = i2;
    }

    private C0253a g() {
        ThreadLocal threadLocal = f2610d;
        C0253a c0253a = (C0253a) threadLocal.get();
        if (c0253a == null) {
            c0253a = new C0253a();
            threadLocal.set(c0253a);
        }
        this.f2612b.d().j(c0253a, this.f2611a);
        return c0253a;
    }

    public void a(Canvas canvas, float f2, float f3, Paint paint) {
        Typeface typefaceG = this.f2612b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(typefaceG);
        canvas.drawText(this.f2612b.c(), this.f2611a * 2, 2, f2, f3, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i2) {
        return g().h(i2);
    }

    public int c() {
        return g().i();
    }

    public int d() {
        return this.f2613c & 3;
    }

    public int e() {
        return g().k();
    }

    public int f() {
        return g().l();
    }

    public short h() {
        return g().m();
    }

    public int i() {
        return g().n();
    }

    public boolean j() {
        return g().j();
    }

    public boolean k() {
        return (this.f2613c & 4) > 0;
    }

    public void l(boolean z2) {
        int iD = d();
        if (z2) {
            this.f2613c = iD | 4;
        } else {
            this.f2613c = iD;
        }
    }

    public void m(boolean z2) {
        int i2 = this.f2613c & 4;
        this.f2613c = z2 ? i2 | 2 : i2 | 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(f()));
        sb.append(", codepoints:");
        int iC = c();
        for (int i2 = 0; i2 < iC; i2++) {
            sb.append(Integer.toHexString(b(i2)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
