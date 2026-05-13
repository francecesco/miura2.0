package u;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.L;
import java.util.Arrays;

/* JADX INFO: renamed from: u.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0252a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final Interpolator f4011w = new InterpolatorC0072a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4013b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f4015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float[] f4016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f4017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float[] f4018g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int[] f4019h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f4020i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f4021j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f4022k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private VelocityTracker f4023l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f4024m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f4025n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f4026o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f4027p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private OverScroller f4028q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final c f4029r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private View f4030s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f4031t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final ViewGroup f4032u;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4014c = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Runnable f4033v = new b();

    /* JADX INFO: renamed from: u.a$a, reason: collision with other inner class name */
    static class InterpolatorC0072a implements Interpolator {
        InterpolatorC0072a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    /* JADX INFO: renamed from: u.a$b */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0252a.this.J(0);
        }
    }

    private C0252a(Context context, ViewGroup viewGroup, c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f4032u = viewGroup;
        this.f4029r = cVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f4026o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f4013b = viewConfiguration.getScaledTouchSlop();
        this.f4024m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f4025n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f4028q = new OverScroller(context, f4011w);
    }

    private boolean C(int i2) {
        if (B(i2)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Ignoring pointerId=");
        sb.append(i2);
        sb.append(" because ACTION_DOWN was not received ");
        sb.append("for this pointer before ACTION_MOVE. It likely happened because ");
        sb.append(" ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void F() {
        this.f4023l.computeCurrentVelocity(1000, this.f4024m);
        p(g(this.f4023l.getXVelocity(this.f4014c), this.f4025n, this.f4024m), g(this.f4023l.getYVelocity(this.f4014c), this.f4025n, this.f4024m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [u.a$c] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void G(float f2, float f3, int i2) {
        boolean zC = c(f2, f3, i2, 1);
        ?? r02 = zC;
        if (c(f3, f2, i2, 4)) {
            r02 = (zC ? 1 : 0) | 4;
        }
        ?? r03 = r02;
        if (c(f2, f3, i2, 2)) {
            r03 = (r02 == true ? 1 : 0) | 2;
        }
        ?? r04 = r03;
        if (c(f3, f2, i2, 8)) {
            r04 = (r03 == true ? 1 : 0) | 8;
        }
        if (r04 != 0) {
            int[] iArr = this.f4020i;
            iArr[i2] = iArr[i2] | r04;
            this.f4029r.f(r04, i2);
        }
    }

    private void H(float f2, float f3, int i2) {
        s(i2);
        float[] fArr = this.f4015d;
        this.f4017f[i2] = f2;
        fArr[i2] = f2;
        float[] fArr2 = this.f4016e;
        this.f4018g[i2] = f3;
        fArr2[i2] = f3;
        this.f4019h[i2] = x((int) f2, (int) f3);
        this.f4022k |= 1 << i2;
    }

    private void I(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (C(pointerId)) {
                float x2 = motionEvent.getX(i2);
                float y2 = motionEvent.getY(i2);
                this.f4017f[pointerId] = x2;
                this.f4018g[pointerId] = y2;
            }
        }
    }

    private boolean c(float f2, float f3, int i2, int i3) {
        float fAbs = Math.abs(f2);
        float fAbs2 = Math.abs(f3);
        if ((this.f4019h[i2] & i3) != i3 || (this.f4027p & i3) == 0 || (this.f4021j[i2] & i3) == i3 || (this.f4020i[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.f4013b;
        if (fAbs <= i4 && fAbs2 <= i4) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.f4029r.g(i3)) {
            return (this.f4020i[i2] & i3) == 0 && fAbs > ((float) this.f4013b);
        }
        int[] iArr = this.f4021j;
        iArr[i2] = iArr[i2] | i3;
        return false;
    }

    private boolean f(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z2 = this.f4029r.d(view) > 0;
        boolean z3 = this.f4029r.e(view) > 0;
        if (!z2 || !z3) {
            return z2 ? Math.abs(f2) > ((float) this.f4013b) : z3 && Math.abs(f3) > ((float) this.f4013b);
        }
        float f4 = (f2 * f2) + (f3 * f3);
        int i2 = this.f4013b;
        return f4 > ((float) (i2 * i2));
    }

    private float g(float f2, float f3, float f4) {
        float fAbs = Math.abs(f2);
        if (fAbs < f3) {
            return 0.0f;
        }
        return fAbs > f4 ? f2 > 0.0f ? f4 : -f4 : f2;
    }

    private int h(int i2, int i3, int i4) {
        int iAbs = Math.abs(i2);
        if (iAbs < i3) {
            return 0;
        }
        return iAbs > i4 ? i2 > 0 ? i4 : -i4 : i2;
    }

    private void i() {
        float[] fArr = this.f4015d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f4016e, 0.0f);
        Arrays.fill(this.f4017f, 0.0f);
        Arrays.fill(this.f4018g, 0.0f);
        Arrays.fill(this.f4019h, 0);
        Arrays.fill(this.f4020i, 0);
        Arrays.fill(this.f4021j, 0);
        this.f4022k = 0;
    }

    private void j(int i2) {
        if (this.f4015d == null || !B(i2)) {
            return;
        }
        this.f4015d[i2] = 0.0f;
        this.f4016e[i2] = 0.0f;
        this.f4017f[i2] = 0.0f;
        this.f4018g[i2] = 0.0f;
        this.f4019h[i2] = 0;
        this.f4020i[i2] = 0;
        this.f4021j[i2] = 0;
        this.f4022k = (~(1 << i2)) & this.f4022k;
    }

    private int k(int i2, int i3, int i4) {
        if (i2 == 0) {
            return 0;
        }
        int width = this.f4032u.getWidth();
        float f2 = width / 2;
        float fQ = f2 + (q(Math.min(1.0f, Math.abs(i2) / width)) * f2);
        int iAbs = Math.abs(i3);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fQ / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i2) / i4) + 1.0f) * 256.0f), 600);
    }

    private int l(View view, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int iH = h(i4, (int) this.f4025n, (int) this.f4024m);
        int iH2 = h(i5, (int) this.f4025n, (int) this.f4024m);
        int iAbs = Math.abs(i2);
        int iAbs2 = Math.abs(i3);
        int iAbs3 = Math.abs(iH);
        int iAbs4 = Math.abs(iH2);
        int i6 = iAbs3 + iAbs4;
        int i7 = iAbs + iAbs2;
        if (iH != 0) {
            f2 = iAbs3;
            f3 = i6;
        } else {
            f2 = iAbs;
            f3 = i7;
        }
        float f6 = f2 / f3;
        if (iH2 != 0) {
            f4 = iAbs4;
            f5 = i6;
        } else {
            f4 = iAbs2;
            f5 = i7;
        }
        return (int) ((k(i2, iH, this.f4029r.d(view)) * f6) + (k(i3, iH2, this.f4029r.e(view)) * (f4 / f5)));
    }

    public static C0252a n(ViewGroup viewGroup, float f2, c cVar) {
        C0252a c0252aO = o(viewGroup, cVar);
        c0252aO.f4013b = (int) (c0252aO.f4013b * (1.0f / f2));
        return c0252aO;
    }

    public static C0252a o(ViewGroup viewGroup, c cVar) {
        return new C0252a(viewGroup.getContext(), viewGroup, cVar);
    }

    private void p(float f2, float f3) {
        this.f4031t = true;
        this.f4029r.l(this.f4030s, f2, f3);
        this.f4031t = false;
        if (this.f4012a == 1) {
            J(0);
        }
    }

    private float q(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    private void r(int i2, int i3, int i4, int i5) {
        int left = this.f4030s.getLeft();
        int top = this.f4030s.getTop();
        if (i4 != 0) {
            i2 = this.f4029r.a(this.f4030s, i2, i4);
            L.J(this.f4030s, i2 - left);
        }
        int i6 = i2;
        if (i5 != 0) {
            i3 = this.f4029r.b(this.f4030s, i3, i5);
            L.K(this.f4030s, i3 - top);
        }
        int i7 = i3;
        if (i4 == 0 && i5 == 0) {
            return;
        }
        this.f4029r.k(this.f4030s, i6, i7, i6 - left, i7 - top);
    }

    private void s(int i2) {
        float[] fArr = this.f4015d;
        if (fArr == null || fArr.length <= i2) {
            int i3 = i2 + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f4016e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f4017f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f4018g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f4019h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f4020i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f4021j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f4015d = fArr2;
            this.f4016e = fArr3;
            this.f4017f = fArr4;
            this.f4018g = fArr5;
            this.f4019h = iArr;
            this.f4020i = iArr2;
            this.f4021j = iArr3;
        }
    }

    private boolean u(int i2, int i3, int i4, int i5) {
        int left = this.f4030s.getLeft();
        int top = this.f4030s.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.f4028q.abortAnimation();
            J(0);
            return false;
        }
        this.f4028q.startScroll(left, top, i6, i7, l(this.f4030s, i6, i7, i4, i5));
        J(2);
        return true;
    }

    private int x(int i2, int i3) {
        int i4 = i2 < this.f4032u.getLeft() + this.f4026o ? 1 : 0;
        if (i3 < this.f4032u.getTop() + this.f4026o) {
            i4 |= 4;
        }
        if (i2 > this.f4032u.getRight() - this.f4026o) {
            i4 |= 2;
        }
        return i3 > this.f4032u.getBottom() - this.f4026o ? i4 | 8 : i4;
    }

    public boolean A(int i2, int i3) {
        return D(this.f4030s, i2, i3);
    }

    public boolean B(int i2) {
        return ((1 << i2) & this.f4022k) != 0;
    }

    public boolean D(View view, int i2, int i3) {
        return view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom();
    }

    public void E(MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f4023l == null) {
            this.f4023l = VelocityTracker.obtain();
        }
        this.f4023l.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewT = t((int) x2, (int) y2);
            H(x2, y2, pointerId);
            P(viewT, pointerId);
            int i4 = this.f4019h[pointerId];
            int i5 = this.f4027p;
            if ((i4 & i5) != 0) {
                this.f4029r.h(i4 & i5, pointerId);
                return;
            }
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (this.f4012a != 1) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (i3 < pointerCount) {
                        int pointerId2 = motionEvent.getPointerId(i3);
                        if (C(pointerId2)) {
                            float x3 = motionEvent.getX(i3);
                            float y3 = motionEvent.getY(i3);
                            float f2 = x3 - this.f4015d[pointerId2];
                            float f3 = y3 - this.f4016e[pointerId2];
                            G(f2, f3, pointerId2);
                            if (this.f4012a != 1) {
                                View viewT2 = t((int) x3, (int) y3);
                                if (f(viewT2, f2, f3) && P(viewT2, pointerId2)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        i3++;
                    }
                } else {
                    if (!C(this.f4014c)) {
                        return;
                    }
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f4014c);
                    float x4 = motionEvent.getX(iFindPointerIndex);
                    float y4 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f4017f;
                    int i6 = this.f4014c;
                    int i7 = (int) (x4 - fArr[i6]);
                    int i8 = (int) (y4 - this.f4018g[i6]);
                    r(this.f4030s.getLeft() + i7, this.f4030s.getTop() + i8, i7, i8);
                }
                I(motionEvent);
                return;
            }
            if (actionMasked != 3) {
                if (actionMasked == 5) {
                    int pointerId3 = motionEvent.getPointerId(actionIndex);
                    float x5 = motionEvent.getX(actionIndex);
                    float y5 = motionEvent.getY(actionIndex);
                    H(x5, y5, pointerId3);
                    if (this.f4012a != 0) {
                        if (A((int) x5, (int) y5)) {
                            P(this.f4030s, pointerId3);
                            return;
                        }
                        return;
                    } else {
                        P(t((int) x5, (int) y5), pointerId3);
                        int i9 = this.f4019h[pointerId3];
                        int i10 = this.f4027p;
                        if ((i9 & i10) != 0) {
                            this.f4029r.h(i9 & i10, pointerId3);
                            return;
                        }
                        return;
                    }
                }
                if (actionMasked != 6) {
                    return;
                }
                int pointerId4 = motionEvent.getPointerId(actionIndex);
                if (this.f4012a == 1 && pointerId4 == this.f4014c) {
                    int pointerCount2 = motionEvent.getPointerCount();
                    while (true) {
                        if (i3 >= pointerCount2) {
                            i2 = -1;
                            break;
                        }
                        int pointerId5 = motionEvent.getPointerId(i3);
                        if (pointerId5 != this.f4014c) {
                            View viewT3 = t((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                            View view = this.f4030s;
                            if (viewT3 == view && P(view, pointerId5)) {
                                i2 = this.f4014c;
                                break;
                            }
                        }
                        i3++;
                    }
                    if (i2 == -1) {
                        F();
                    }
                }
                j(pointerId4);
                return;
            }
            if (this.f4012a == 1) {
                p(0.0f, 0.0f);
            }
        } else if (this.f4012a == 1) {
            F();
        }
        a();
    }

    void J(int i2) {
        this.f4032u.removeCallbacks(this.f4033v);
        if (this.f4012a != i2) {
            this.f4012a = i2;
            this.f4029r.j(i2);
            if (this.f4012a == 0) {
                this.f4030s = null;
            }
        }
    }

    public void K(int i2) {
        this.f4027p = i2;
    }

    public void L(float f2) {
        this.f4025n = f2;
    }

    public boolean M(int i2, int i3) {
        if (this.f4031t) {
            return u(i2, i3, (int) this.f4023l.getXVelocity(this.f4014c), (int) this.f4023l.getYVelocity(this.f4014c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean N(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.C0252a.N(android.view.MotionEvent):boolean");
    }

    public boolean O(View view, int i2, int i3) {
        this.f4030s = view;
        this.f4014c = -1;
        boolean zU = u(i2, i3, 0, 0);
        if (!zU && this.f4012a == 0 && this.f4030s != null) {
            this.f4030s = null;
        }
        return zU;
    }

    boolean P(View view, int i2) {
        if (view == this.f4030s && this.f4014c == i2) {
            return true;
        }
        if (view == null || !this.f4029r.m(view, i2)) {
            return false;
        }
        this.f4014c = i2;
        b(view, i2);
        return true;
    }

    public void a() {
        this.f4014c = -1;
        i();
        VelocityTracker velocityTracker = this.f4023l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4023l = null;
        }
    }

    public void b(View view, int i2) {
        if (view.getParent() == this.f4032u) {
            this.f4030s = view;
            this.f4014c = i2;
            this.f4029r.i(view, i2);
            J(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f4032u + ")");
    }

    public boolean d(int i2) {
        int length = this.f4015d.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (e(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean e(int i2, int i3) {
        if (!B(i3)) {
            return false;
        }
        boolean z2 = (i2 & 1) == 1;
        boolean z3 = (i2 & 2) == 2;
        float f2 = this.f4017f[i3] - this.f4015d[i3];
        float f3 = this.f4018g[i3] - this.f4016e[i3];
        if (!z2 || !z3) {
            return z2 ? Math.abs(f2) > ((float) this.f4013b) : z3 && Math.abs(f3) > ((float) this.f4013b);
        }
        float f4 = (f2 * f2) + (f3 * f3);
        int i4 = this.f4013b;
        return f4 > ((float) (i4 * i4));
    }

    public boolean m(boolean z2) {
        if (this.f4012a == 2) {
            boolean zComputeScrollOffset = this.f4028q.computeScrollOffset();
            int currX = this.f4028q.getCurrX();
            int currY = this.f4028q.getCurrY();
            int left = currX - this.f4030s.getLeft();
            int top = currY - this.f4030s.getTop();
            if (left != 0) {
                L.J(this.f4030s, left);
            }
            if (top != 0) {
                L.K(this.f4030s, top);
            }
            if (left != 0 || top != 0) {
                this.f4029r.k(this.f4030s, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f4028q.getFinalX() && currY == this.f4028q.getFinalY()) {
                this.f4028q.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z2) {
                    this.f4032u.post(this.f4033v);
                } else {
                    J(0);
                }
            }
        }
        return this.f4012a == 2;
    }

    public View t(int i2, int i3) {
        for (int childCount = this.f4032u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f4032u.getChildAt(this.f4029r.c(childCount));
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public View v() {
        return this.f4030s;
    }

    public int w() {
        return this.f4026o;
    }

    public int y() {
        return this.f4013b;
    }

    public int z() {
        return this.f4012a;
    }

    /* JADX INFO: renamed from: u.a$c */
    public static abstract class c {
        public abstract int a(View view, int i2, int i3);

        public abstract int b(View view, int i2, int i3);

        public abstract int d(View view);

        public int e(View view) {
            return 0;
        }

        public abstract void f(int i2, int i3);

        public abstract boolean g(int i2);

        public abstract void h(int i2, int i3);

        public abstract void i(View view, int i2);

        public abstract void j(int i2);

        public abstract void k(View view, int i2, int i3, int i4, int i5);

        public abstract void l(View view, float f2, float f3);

        public abstract boolean m(View view, int i2);

        public int c(int i2) {
            return i2;
        }
    }
}
