package f;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;

/* JADX INFO: renamed from: f.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0192b extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f3510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Rect f3511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f3512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Drawable f3513d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f3515f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f3517h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Runnable f3518i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f3519j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f3520k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private c f3521l;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3514e = 255;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3516g = -1;

    /* JADX INFO: renamed from: f.b$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC0192b.this.a(true);
            AbstractC0192b.this.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: f.b$b, reason: collision with other inner class name */
    private static class C0059b {
        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    /* JADX INFO: renamed from: f.b$d */
    static abstract class d extends Drawable.ConstantState {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        int f3524A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        int f3525B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        boolean f3526C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        ColorFilter f3527D;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        boolean f3528E;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        ColorStateList f3529F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        PorterDuff.Mode f3530G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        boolean f3531H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        boolean f3532I;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AbstractC0192b f3533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Resources f3534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f3535c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f3536d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f3537e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        SparseArray f3538f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Drawable[] f3539g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f3540h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f3541i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f3542j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Rect f3543k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f3544l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f3545m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f3546n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f3547o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f3548p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f3549q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        boolean f3550r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        int f3551s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        boolean f3552t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        boolean f3553u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        boolean f3554v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        boolean f3555w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        boolean f3556x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        boolean f3557y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        int f3558z;

        d(d dVar, AbstractC0192b abstractC0192b, Resources resources) {
            this.f3541i = false;
            this.f3544l = false;
            this.f3556x = true;
            this.f3524A = 0;
            this.f3525B = 0;
            this.f3533a = abstractC0192b;
            this.f3534b = resources != null ? resources : dVar != null ? dVar.f3534b : null;
            int iF = AbstractC0192b.f(resources, dVar != null ? dVar.f3535c : 0);
            this.f3535c = iF;
            if (dVar == null) {
                this.f3539g = new Drawable[10];
                this.f3540h = 0;
                return;
            }
            this.f3536d = dVar.f3536d;
            this.f3537e = dVar.f3537e;
            this.f3554v = true;
            this.f3555w = true;
            this.f3541i = dVar.f3541i;
            this.f3544l = dVar.f3544l;
            this.f3556x = dVar.f3556x;
            this.f3557y = dVar.f3557y;
            this.f3558z = dVar.f3558z;
            this.f3524A = dVar.f3524A;
            this.f3525B = dVar.f3525B;
            this.f3526C = dVar.f3526C;
            this.f3527D = dVar.f3527D;
            this.f3528E = dVar.f3528E;
            this.f3529F = dVar.f3529F;
            this.f3530G = dVar.f3530G;
            this.f3531H = dVar.f3531H;
            this.f3532I = dVar.f3532I;
            if (dVar.f3535c == iF) {
                if (dVar.f3542j) {
                    this.f3543k = dVar.f3543k != null ? new Rect(dVar.f3543k) : null;
                    this.f3542j = true;
                }
                if (dVar.f3545m) {
                    this.f3546n = dVar.f3546n;
                    this.f3547o = dVar.f3547o;
                    this.f3548p = dVar.f3548p;
                    this.f3549q = dVar.f3549q;
                    this.f3545m = true;
                }
            }
            if (dVar.f3550r) {
                this.f3551s = dVar.f3551s;
                this.f3550r = true;
            }
            if (dVar.f3552t) {
                this.f3553u = dVar.f3553u;
                this.f3552t = true;
            }
            Drawable[] drawableArr = dVar.f3539g;
            this.f3539g = new Drawable[drawableArr.length];
            this.f3540h = dVar.f3540h;
            SparseArray sparseArray = dVar.f3538f;
            this.f3538f = sparseArray != null ? sparseArray.clone() : new SparseArray(this.f3540h);
            int i2 = this.f3540h;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f3538f.put(i3, constantState);
                    } else {
                        this.f3539g[i3] = drawableArr[i3];
                    }
                }
            }
        }

        private void e() {
            SparseArray sparseArray = this.f3538f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f3539g[this.f3538f.keyAt(i2)] = s(((Drawable.ConstantState) this.f3538f.valueAt(i2)).newDrawable(this.f3534b));
                }
                this.f3538f = null;
            }
        }

        private Drawable s(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                androidx.core.graphics.drawable.a.l(drawable, this.f3558z);
            }
            Drawable drawableMutate = drawable.mutate();
            drawableMutate.setCallback(this.f3533a);
            return drawableMutate;
        }

        public final int a(Drawable drawable) {
            int i2 = this.f3540h;
            if (i2 >= this.f3539g.length) {
                o(i2, i2 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f3533a);
            this.f3539g[i2] = drawable;
            this.f3540h++;
            this.f3537e = drawable.getChangingConfigurations() | this.f3537e;
            p();
            this.f3543k = null;
            this.f3542j = false;
            this.f3545m = false;
            this.f3554v = false;
            return i2;
        }

        final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i2 = this.f3540h;
                Drawable[] drawableArr = this.f3539g;
                for (int i3 = 0; i3 < i2; i3++) {
                    Drawable drawable = drawableArr[i3];
                    if (drawable != null && androidx.core.graphics.drawable.a.b(drawable)) {
                        androidx.core.graphics.drawable.a.a(drawableArr[i3], theme);
                        this.f3537e |= drawableArr[i3].getChangingConfigurations();
                    }
                }
                y(C0059b.c(theme));
            }
        }

        public boolean c() {
            if (this.f3554v) {
                return this.f3555w;
            }
            e();
            this.f3554v = true;
            int i2 = this.f3540h;
            Drawable[] drawableArr = this.f3539g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getConstantState() == null) {
                    this.f3555w = false;
                    return false;
                }
            }
            this.f3555w = true;
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i2 = this.f3540h;
            Drawable[] drawableArr = this.f3539g;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) this.f3538f.get(i3);
                    if (constantState != null && C0059b.a(constantState)) {
                        return true;
                    }
                } else if (androidx.core.graphics.drawable.a.b(drawable)) {
                    return true;
                }
            }
            return false;
        }

        protected void d() {
            this.f3545m = true;
            e();
            int i2 = this.f3540h;
            Drawable[] drawableArr = this.f3539g;
            this.f3547o = -1;
            this.f3546n = -1;
            this.f3549q = 0;
            this.f3548p = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f3546n) {
                    this.f3546n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f3547o) {
                    this.f3547o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f3548p) {
                    this.f3548p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f3549q) {
                    this.f3549q = minimumHeight;
                }
            }
        }

        final int f() {
            return this.f3539g.length;
        }

        public final Drawable g(int i2) {
            int iIndexOfKey;
            Drawable drawable = this.f3539g[i2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray sparseArray = this.f3538f;
            if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i2)) < 0) {
                return null;
            }
            Drawable drawableS = s(((Drawable.ConstantState) this.f3538f.valueAt(iIndexOfKey)).newDrawable(this.f3534b));
            this.f3539g[i2] = drawableS;
            this.f3538f.removeAt(iIndexOfKey);
            if (this.f3538f.size() == 0) {
                this.f3538f = null;
            }
            return drawableS;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f3536d | this.f3537e;
        }

        public final int h() {
            return this.f3540h;
        }

        public final int i() {
            if (!this.f3545m) {
                d();
            }
            return this.f3547o;
        }

        public final int j() {
            if (!this.f3545m) {
                d();
            }
            return this.f3549q;
        }

        public final int k() {
            if (!this.f3545m) {
                d();
            }
            return this.f3548p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f3541i) {
                return null;
            }
            Rect rect2 = this.f3543k;
            if (rect2 != null || this.f3542j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i2 = this.f3540h;
            Drawable[] drawableArr = this.f3539g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i4 = rect3.left;
                    if (i4 > rect.left) {
                        rect.left = i4;
                    }
                    int i5 = rect3.top;
                    if (i5 > rect.top) {
                        rect.top = i5;
                    }
                    int i6 = rect3.right;
                    if (i6 > rect.right) {
                        rect.right = i6;
                    }
                    int i7 = rect3.bottom;
                    if (i7 > rect.bottom) {
                        rect.bottom = i7;
                    }
                }
            }
            this.f3542j = true;
            this.f3543k = rect;
            return rect;
        }

        public final int m() {
            if (!this.f3545m) {
                d();
            }
            return this.f3546n;
        }

        public final int n() {
            if (this.f3550r) {
                return this.f3551s;
            }
            e();
            int i2 = this.f3540h;
            Drawable[] drawableArr = this.f3539g;
            int opacity = i2 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i3 = 1; i3 < i2; i3++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i3].getOpacity());
            }
            this.f3551s = opacity;
            this.f3550r = true;
            return opacity;
        }

        public void o(int i2, int i3) {
            Drawable[] drawableArr = new Drawable[i3];
            Drawable[] drawableArr2 = this.f3539g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i2);
            }
            this.f3539g = drawableArr;
        }

        void p() {
            this.f3550r = false;
            this.f3552t = false;
        }

        public final boolean q() {
            return this.f3544l;
        }

        abstract void r();

        public final void t(boolean z2) {
            this.f3544l = z2;
        }

        public final void u(int i2) {
            this.f3524A = i2;
        }

        public final void v(int i2) {
            this.f3525B = i2;
        }

        final boolean w(int i2, int i3) {
            int i4 = this.f3540h;
            Drawable[] drawableArr = this.f3539g;
            boolean z2 = false;
            for (int i5 = 0; i5 < i4; i5++) {
                Drawable drawable = drawableArr[i5];
                if (drawable != null) {
                    boolean zL = Build.VERSION.SDK_INT >= 23 ? androidx.core.graphics.drawable.a.l(drawable, i2) : false;
                    if (i5 == i3) {
                        z2 = zL;
                    }
                }
            }
            this.f3558z = i2;
            return z2;
        }

        public final void x(boolean z2) {
            this.f3541i = z2;
        }

        final void y(Resources resources) {
            if (resources != null) {
                this.f3534b = resources;
                int iF = AbstractC0192b.f(resources, this.f3535c);
                int i2 = this.f3535c;
                this.f3535c = iF;
                if (i2 != iF) {
                    this.f3545m = false;
                    this.f3542j = false;
                }
            }
        }
    }

    private void d(Drawable drawable) {
        if (this.f3521l == null) {
            this.f3521l = new c();
        }
        drawable.setCallback(this.f3521l.b(drawable.getCallback()));
        try {
            if (this.f3510a.f3524A <= 0 && this.f3515f) {
                drawable.setAlpha(this.f3514e);
            }
            d dVar = this.f3510a;
            if (dVar.f3528E) {
                drawable.setColorFilter(dVar.f3527D);
            } else {
                if (dVar.f3531H) {
                    androidx.core.graphics.drawable.a.n(drawable, dVar.f3529F);
                }
                d dVar2 = this.f3510a;
                if (dVar2.f3532I) {
                    androidx.core.graphics.drawable.a.o(drawable, dVar2.f3530G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f3510a.f3556x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                androidx.core.graphics.drawable.a.l(drawable, androidx.core.graphics.drawable.a.e(this));
            }
            androidx.core.graphics.drawable.a.i(drawable, this.f3510a.f3526C);
            Rect rect = this.f3511b;
            if (rect != null) {
                androidx.core.graphics.drawable.a.k(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
            drawable.setCallback(this.f3521l.a());
        } catch (Throwable th) {
            drawable.setCallback(this.f3521l.a());
            throw th;
        }
    }

    private boolean e() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.e(this) == 1;
    }

    static int f(Resources resources, int i2) {
        if (resources != null) {
            i2 = resources.getDisplayMetrics().densityDpi;
        }
        if (i2 == 0) {
            return 160;
        }
        return i2;
    }

    void a(boolean z2) {
        boolean z3;
        boolean z4 = true;
        this.f3515f = true;
        long jUptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable = this.f3512c;
        if (drawable != null) {
            long j2 = this.f3519j;
            if (j2 == 0) {
                z3 = false;
            } else if (j2 <= jUptimeMillis) {
                drawable.setAlpha(this.f3514e);
                this.f3519j = 0L;
                z3 = false;
            } else {
                drawable.setAlpha(((255 - (((int) ((j2 - jUptimeMillis) * 255)) / this.f3510a.f3524A)) * this.f3514e) / 255);
                z3 = true;
            }
        } else {
            this.f3519j = 0L;
            z3 = false;
        }
        Drawable drawable2 = this.f3513d;
        if (drawable2 != null) {
            long j3 = this.f3520k;
            if (j3 == 0) {
                z4 = z3;
            } else if (j3 <= jUptimeMillis) {
                drawable2.setVisible(false, false);
                this.f3513d = null;
                this.f3520k = 0L;
                z4 = z3;
            } else {
                drawable2.setAlpha(((((int) ((j3 - jUptimeMillis) * 255)) / this.f3510a.f3525B) * this.f3514e) / 255);
            }
        } else {
            this.f3520k = 0L;
            z4 = z3;
        }
        if (z2 && z4) {
            scheduleSelf(this.f3518i, jUptimeMillis + 16);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f3510a.b(theme);
    }

    abstract d b();

    int c() {
        return this.f3516g;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f3510a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f3512c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f3513d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean g(int r10) {
        /*
            r9 = this;
            int r0 = r9.f3516g
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            f.b$d r0 = r9.f3510a
            int r0 = r0.f3525B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f3513d
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f3512c
            if (r0 == 0) goto L29
            r9.f3513d = r0
            f.b$d r0 = r9.f3510a
            int r0 = r0.f3525B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f3520k = r0
            goto L35
        L29:
            r9.f3513d = r4
            r9.f3520k = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f3512c
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            f.b$d r0 = r9.f3510a
            int r1 = r0.f3540h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.g(r10)
            r9.f3512c = r0
            r9.f3516g = r10
            if (r0 == 0) goto L5a
            f.b$d r10 = r9.f3510a
            int r10 = r10.f3524A
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f3519j = r2
        L51:
            r9.d(r0)
            goto L5a
        L55:
            r9.f3512c = r4
            r10 = -1
            r9.f3516g = r10
        L5a:
            long r0 = r9.f3519j
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L67
            long r0 = r9.f3520k
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L79
        L67:
            java.lang.Runnable r0 = r9.f3518i
            if (r0 != 0) goto L73
            f.b$a r0 = new f.b$a
            r0.<init>()
            r9.f3518i = r0
            goto L76
        L73:
            r9.unscheduleSelf(r0)
        L76:
            r9.a(r10)
        L79:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: f.AbstractC0192b.g(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f3514e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f3510a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f3510a.c()) {
            return null;
        }
        this.f3510a.f3536d = getChangingConfigurations();
        return this.f3510a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f3512c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f3511b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f3510a.q()) {
            return this.f3510a.i();
        }
        Drawable drawable = this.f3512c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f3510a.q()) {
            return this.f3510a.m();
        }
        Drawable drawable = this.f3512c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f3510a.q()) {
            return this.f3510a.j();
        }
        Drawable drawable = this.f3512c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f3510a.q()) {
            return this.f3510a.k();
        }
        Drawable drawable = this.f3512c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f3512c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f3510a.n();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f3512c;
        if (drawable != null) {
            C0059b.b(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect rectL = this.f3510a.l();
        if (rectL != null) {
            rect.set(rectL);
            padding = (rectL.right | ((rectL.left | rectL.top) | rectL.bottom)) != 0;
        } else {
            Drawable drawable = this.f3512c;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (e()) {
            int i2 = rect.left;
            rect.left = rect.right;
            rect.right = i2;
        }
        return padding;
    }

    void h(d dVar) {
        this.f3510a = dVar;
        int i2 = this.f3516g;
        if (i2 >= 0) {
            Drawable drawableG = dVar.g(i2);
            this.f3512c = drawableG;
            if (drawableG != null) {
                d(drawableG);
            }
        }
        this.f3513d = null;
    }

    final void i(Resources resources) {
        this.f3510a.y(resources);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        d dVar = this.f3510a;
        if (dVar != null) {
            dVar.p();
        }
        if (drawable != this.f3512c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f3510a.f3526C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z2;
        Drawable drawable = this.f3513d;
        boolean z3 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f3513d = null;
            z2 = true;
        } else {
            z2 = false;
        }
        Drawable drawable2 = this.f3512c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f3515f) {
                this.f3512c.setAlpha(this.f3514e);
            }
        }
        if (this.f3520k != 0) {
            this.f3520k = 0L;
            z2 = true;
        }
        if (this.f3519j != 0) {
            this.f3519j = 0L;
        } else {
            z3 = z2;
        }
        if (z3) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f3517h && super.mutate() == this) {
            d dVarB = b();
            dVarB.r();
            h(dVarB);
            this.f3517h = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3513d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f3512c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        return this.f3510a.w(i2, c());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        Drawable drawable = this.f3513d;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.f3512c;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        if (drawable != this.f3512c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.f3515f && this.f3514e == i2) {
            return;
        }
        this.f3515f = true;
        this.f3514e = i2;
        Drawable drawable = this.f3512c;
        if (drawable != null) {
            if (this.f3519j == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        d dVar = this.f3510a;
        if (dVar.f3526C != z2) {
            dVar.f3526C = z2;
            Drawable drawable = this.f3512c;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.i(drawable, z2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        d dVar = this.f3510a;
        dVar.f3528E = true;
        if (dVar.f3527D != colorFilter) {
            dVar.f3527D = colorFilter;
            Drawable drawable = this.f3512c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        d dVar = this.f3510a;
        if (dVar.f3556x != z2) {
            dVar.f3556x = z2;
            Drawable drawable = this.f3512c;
            if (drawable != null) {
                drawable.setDither(z2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f3512c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, f2, f3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.f3511b;
        if (rect == null) {
            this.f3511b = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.f3512c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.k(drawable, i2, i3, i4, i5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        d dVar = this.f3510a;
        dVar.f3531H = true;
        if (dVar.f3529F != colorStateList) {
            dVar.f3529F = colorStateList;
            androidx.core.graphics.drawable.a.n(this.f3512c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        d dVar = this.f3510a;
        dVar.f3532I = true;
        if (dVar.f3530G != mode) {
            dVar.f3530G = mode;
            androidx.core.graphics.drawable.a.o(this.f3512c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        Drawable drawable = this.f3513d;
        if (drawable != null) {
            drawable.setVisible(z2, z3);
        }
        Drawable drawable2 = this.f3512c;
        if (drawable2 != null) {
            drawable2.setVisible(z2, z3);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f3512c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }

    /* JADX INFO: renamed from: f.b$c */
    static class c implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Drawable.Callback f3523a;

        c() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f3523a;
            this.f3523a = null;
            return callback;
        }

        public c b(Drawable.Callback callback) {
            this.f3523a = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            Drawable.Callback callback = this.f3523a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j2);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f3523a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }
    }
}
