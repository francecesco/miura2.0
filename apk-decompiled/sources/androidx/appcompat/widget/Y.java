package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
class Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1765a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1766b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1767c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1768d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1769e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1770f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1771g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1772h = false;

    Y() {
    }

    public int a() {
        return this.f1771g ? this.f1765a : this.f1766b;
    }

    public int b() {
        return this.f1765a;
    }

    public int c() {
        return this.f1766b;
    }

    public int d() {
        return this.f1771g ? this.f1766b : this.f1765a;
    }

    public void e(int i2, int i3) {
        this.f1772h = false;
        if (i2 != Integer.MIN_VALUE) {
            this.f1769e = i2;
            this.f1765a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f1770f = i3;
            this.f1766b = i3;
        }
    }

    public void f(boolean z2) {
        int i2;
        if (z2 == this.f1771g) {
            return;
        }
        this.f1771g = z2;
        if (this.f1772h) {
            if (z2) {
                int i3 = this.f1768d;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = this.f1769e;
                }
                this.f1765a = i3;
                i2 = this.f1767c;
                if (i2 == Integer.MIN_VALUE) {
                }
            } else {
                int i4 = this.f1767c;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = this.f1769e;
                }
                this.f1765a = i4;
                i2 = this.f1768d;
                if (i2 == Integer.MIN_VALUE) {
                }
            }
            this.f1766b = i2;
        }
        this.f1765a = this.f1769e;
        i2 = this.f1770f;
        this.f1766b = i2;
    }

    public void g(int i2, int i3) {
        this.f1767c = i2;
        this.f1768d = i3;
        this.f1772h = true;
        if (this.f1771g) {
            if (i3 != Integer.MIN_VALUE) {
                this.f1765a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f1766b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1765a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f1766b = i3;
        }
    }
}
