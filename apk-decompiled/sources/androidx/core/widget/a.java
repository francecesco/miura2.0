package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.L;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f2416r = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final View f2419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f2420d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2424h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f2428l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f2429m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f2430n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f2431o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f2432p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f2433q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final C0040a f2417a = new C0040a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Interpolator f2418b = new AccelerateInterpolator();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float[] f2421e = {0.0f, 0.0f};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f2422f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float[] f2425i = {0.0f, 0.0f};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float[] f2426j = {0.0f, 0.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float[] f2427k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    private static class C0040a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2435b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f2436c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f2437d;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private float f2443j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f2444k;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f2438e = Long.MIN_VALUE;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f2442i = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f2439f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f2440g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f2441h = 0;

        C0040a() {
        }

        private float e(long j2) {
            if (j2 < this.f2438e) {
                return 0.0f;
            }
            long j3 = this.f2442i;
            if (j3 < 0 || j2 < j3) {
                return a.e((j2 - r0) / this.f2434a, 0.0f, 1.0f) * 0.5f;
            }
            float f2 = this.f2443j;
            return (1.0f - f2) + (f2 * a.e((j2 - j3) / this.f2444k, 0.0f, 1.0f));
        }

        private float g(float f2) {
            return ((-4.0f) * f2 * f2) + (f2 * 4.0f);
        }

        public void a() {
            if (this.f2439f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fG = g(e(jCurrentAnimationTimeMillis));
            long j2 = jCurrentAnimationTimeMillis - this.f2439f;
            this.f2439f = jCurrentAnimationTimeMillis;
            float f2 = j2 * fG;
            this.f2440g = (int) (this.f2436c * f2);
            this.f2441h = (int) (f2 * this.f2437d);
        }

        public int b() {
            return this.f2440g;
        }

        public int c() {
            return this.f2441h;
        }

        public int d() {
            float f2 = this.f2436c;
            return (int) (f2 / Math.abs(f2));
        }

        public int f() {
            float f2 = this.f2437d;
            return (int) (f2 / Math.abs(f2));
        }

        public boolean h() {
            return this.f2442i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f2442i + ((long) this.f2444k);
        }

        public void i() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2444k = a.f((int) (jCurrentAnimationTimeMillis - this.f2438e), 0, this.f2435b);
            this.f2443j = e(jCurrentAnimationTimeMillis);
            this.f2442i = jCurrentAnimationTimeMillis;
        }

        public void j(int i2) {
            this.f2435b = i2;
        }

        public void k(int i2) {
            this.f2434a = i2;
        }

        public void l(float f2, float f3) {
            this.f2436c = f2;
            this.f2437d = f3;
        }

        public void m() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2438e = jCurrentAnimationTimeMillis;
            this.f2442i = -1L;
            this.f2439f = jCurrentAnimationTimeMillis;
            this.f2443j = 0.5f;
            this.f2440g = 0;
            this.f2441h = 0;
        }
    }

    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.f2431o) {
                if (aVar.f2429m) {
                    aVar.f2429m = false;
                    aVar.f2417a.m();
                }
                C0040a c0040a = a.this.f2417a;
                if (c0040a.h() || !a.this.u()) {
                    a.this.f2431o = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.f2430n) {
                    aVar2.f2430n = false;
                    aVar2.c();
                }
                c0040a.a();
                a.this.j(c0040a.b(), c0040a.c());
                L.P(a.this.f2419c, this);
            }
        }
    }

    public a(View view) {
        this.f2419c = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f3 = (int) ((1575.0f * f2) + 0.5f);
        o(f3, f3);
        float f4 = (int) ((f2 * 315.0f) + 0.5f);
        p(f4, f4);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f2416r);
        r(500);
        q(500);
    }

    private float d(int i2, float f2, float f3, float f4) {
        float fH = h(this.f2421e[i2], f3, this.f2422f[i2], f2);
        if (fH == 0.0f) {
            return 0.0f;
        }
        float f5 = this.f2425i[i2];
        float f6 = this.f2426j[i2];
        float f7 = this.f2427k[i2];
        float f8 = f5 * f4;
        return fH > 0.0f ? e(fH * f8, f6, f7) : -e((-fH) * f8, f6, f7);
    }

    static float e(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    static int f(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    private float g(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.f2423g;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                if (this.f2431o && i2 == 1) {
                    return 1.0f;
                }
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
        return 0.0f;
    }

    private float h(float f2, float f3, float f4, float f5) {
        float interpolation;
        float fE = e(f2 * f3, 0.0f, f4);
        float fG = g(f3 - f5, fE) - g(f5, fE);
        if (fG < 0.0f) {
            interpolation = -this.f2418b.getInterpolation(-fG);
        } else {
            if (fG <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f2418b.getInterpolation(fG);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f2429m) {
            this.f2431o = false;
        } else {
            this.f2417a.i();
        }
    }

    private void v() {
        int i2;
        if (this.f2420d == null) {
            this.f2420d = new b();
        }
        this.f2431o = true;
        this.f2429m = true;
        if (this.f2428l || (i2 = this.f2424h) <= 0) {
            this.f2420d.run();
        } else {
            L.Q(this.f2419c, this.f2420d, i2);
        }
        this.f2428l = true;
    }

    public abstract boolean a(int i2);

    public abstract boolean b(int i2);

    void c() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f2419c.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public abstract void j(int i2, int i3);

    public a k(int i2) {
        this.f2424h = i2;
        return this;
    }

    public a l(int i2) {
        this.f2423g = i2;
        return this;
    }

    public a m(boolean z2) {
        if (this.f2432p && !z2) {
            i();
        }
        this.f2432p = z2;
        return this;
    }

    public a n(float f2, float f3) {
        float[] fArr = this.f2422f;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public a o(float f2, float f3) {
        float[] fArr = this.f2427k;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f2432p
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.i()
            goto L58
        L1a:
            r5.f2430n = r2
            r5.f2428l = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f2419c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f2419c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f2417a
            r7.l(r0, r6)
            boolean r6 = r5.f2431o
            if (r6 != 0) goto L58
            boolean r6 = r5.u()
            if (r6 == 0) goto L58
            r5.v()
        L58:
            boolean r6 = r5.f2433q
            if (r6 == 0) goto L61
            boolean r6 = r5.f2431o
            if (r6 == 0) goto L61
            r1 = 1
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public a p(float f2, float f3) {
        float[] fArr = this.f2426j;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a q(int i2) {
        this.f2417a.j(i2);
        return this;
    }

    public a r(int i2) {
        this.f2417a.k(i2);
        return this;
    }

    public a s(float f2, float f3) {
        float[] fArr = this.f2421e;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public a t(float f2, float f3) {
        float[] fArr = this.f2425i;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    boolean u() {
        C0040a c0040a = this.f2417a;
        int iF = c0040a.f();
        int iD = c0040a.d();
        return (iF != 0 && b(iF)) || (iD != 0 && a(iD));
    }
}
