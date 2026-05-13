package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f2199e = new f(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2203d;

    static class a {
        static Insets a(int i2, int i3, int i4, int i5) {
            return Insets.of(i2, i3, i4, i5);
        }
    }

    private f(int i2, int i3, int i4, int i5) {
        this.f2200a = i2;
        this.f2201b = i3;
        this.f2202c = i4;
        this.f2203d = i5;
    }

    public static f a(f fVar, f fVar2) {
        return b(Math.max(fVar.f2200a, fVar2.f2200a), Math.max(fVar.f2201b, fVar2.f2201b), Math.max(fVar.f2202c, fVar2.f2202c), Math.max(fVar.f2203d, fVar2.f2203d));
    }

    public static f b(int i2, int i3, int i4, int i5) {
        return (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) ? f2199e : new f(i2, i3, i4, i5);
    }

    public static f c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static f d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.f2200a, this.f2201b, this.f2202c, this.f2203d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.f2203d == fVar.f2203d && this.f2200a == fVar.f2200a && this.f2202c == fVar.f2202c && this.f2201b == fVar.f2201b;
    }

    public int hashCode() {
        return (((((this.f2200a * 31) + this.f2201b) * 31) + this.f2202c) * 31) + this.f2203d;
    }

    public String toString() {
        return "Insets{left=" + this.f2200a + ", top=" + this.f2201b + ", right=" + this.f2202c + ", bottom=" + this.f2203d + '}';
    }
}
