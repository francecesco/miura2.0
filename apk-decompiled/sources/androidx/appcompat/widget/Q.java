package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public abstract class Q implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f1617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f1619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final View f1620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Runnable f1621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f1622f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1623g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1624h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f1625i = new int[2];

    private class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = Q.this.f1620d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Q.this.e();
        }
    }

    public Q(View view) {
        this.f1620d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1617a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1618b = tapTimeout;
        this.f1619c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f1622f;
        if (runnable != null) {
            this.f1620d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1621e;
        if (runnable2 != null) {
            this.f1620d.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        O o2;
        View view = this.f1620d;
        h.e eVarB = b();
        if (eVarB == null || !eVarB.b() || (o2 = (O) eVarB.k()) == null || !o2.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, motionEventObtainNoHistory);
        j(o2, motionEventObtainNoHistory);
        boolean zE = o2.e(motionEventObtainNoHistory, this.f1624h);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zE && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f1620d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.f1624h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f1617a
            boolean r6 = h(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.a()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.f1624h = r6
            java.lang.Runnable r6 = r5.f1621e
            if (r6 != 0) goto L52
            androidx.appcompat.widget.Q$a r6 = new androidx.appcompat.widget.Q$a
            r6.<init>()
            r5.f1621e = r6
        L52:
            java.lang.Runnable r6 = r5.f1621e
            int r1 = r5.f1618b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f1622f
            if (r6 != 0) goto L65
            androidx.appcompat.widget.Q$b r6 = new androidx.appcompat.widget.Q$b
            r6.<init>()
            r5.f1622f = r6
        L65:
            java.lang.Runnable r6 = r5.f1622f
            int r1 = r5.f1619c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Q.g(android.view.MotionEvent):boolean");
    }

    private static boolean h(View view, float f2, float f3, float f4) {
        float f5 = -f4;
        return f2 >= f5 && f3 >= f5 && f2 < ((float) (view.getRight() - view.getLeft())) + f4 && f3 < ((float) (view.getBottom() - view.getTop())) + f4;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f1625i);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f1625i);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    public abstract h.e b();

    protected abstract boolean c();

    protected boolean d() {
        h.e eVarB = b();
        if (eVarB == null || !eVarB.b()) {
            return true;
        }
        eVarB.dismiss();
        return true;
    }

    void e() {
        a();
        View view = this.f1620d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f1623g = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z2;
        boolean z3 = this.f1623g;
        if (z3) {
            z2 = f(motionEvent) || !d();
        } else {
            z2 = g(motionEvent) && c();
            if (z2) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1620d.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f1623g = z2;
        return z2 || z3;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f1623g = false;
        this.f1624h = -1;
        Runnable runnable = this.f1621e;
        if (runnable != null) {
            this.f1620d.removeCallbacks(runnable);
        }
    }
}
