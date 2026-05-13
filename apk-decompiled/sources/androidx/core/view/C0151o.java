package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: renamed from: androidx.core.view.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0151o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0152p f2365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f2366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f2367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private VelocityTracker f2368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f2369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2370g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2371h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f2372i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int[] f2373j;

    /* JADX INFO: renamed from: androidx.core.view.o$a */
    interface a {
        float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i2);
    }

    /* JADX INFO: renamed from: androidx.core.view.o$b */
    interface b {
        void a(Context context, int[] iArr, MotionEvent motionEvent, int i2);
    }

    public C0151o(Context context, InterfaceC0152p interfaceC0152p) {
        this(context, interfaceC0152p, new b() { // from class: androidx.core.view.m
            @Override // androidx.core.view.C0151o.b
            public final void a(Context context2, int[] iArr, MotionEvent motionEvent, int i2) {
                C0151o.c(context2, iArr, motionEvent, i2);
            }
        }, new a() { // from class: androidx.core.view.n
            @Override // androidx.core.view.C0151o.a
            public final float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i2) {
                return C0151o.f(velocityTracker, motionEvent, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, int[] iArr, MotionEvent motionEvent, int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = P.g(context, viewConfiguration, motionEvent.getDeviceId(), i2, motionEvent.getSource());
        iArr[1] = P.f(context, viewConfiguration, motionEvent.getDeviceId(), i2, motionEvent.getSource());
    }

    private boolean d(MotionEvent motionEvent, int i2) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.f2371h == source && this.f2372i == deviceId && this.f2370g == i2) {
            return false;
        }
        this.f2366c.a(this.f2364a, this.f2373j, motionEvent, i2);
        this.f2371h = source;
        this.f2372i = deviceId;
        this.f2370g = i2;
        return true;
    }

    private float e(MotionEvent motionEvent, int i2) {
        if (this.f2368e == null) {
            this.f2368e = VelocityTracker.obtain();
        }
        return this.f2367d.a(this.f2368e, motionEvent, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float f(VelocityTracker velocityTracker, MotionEvent motionEvent, int i2) {
        I.a(velocityTracker, motionEvent);
        I.b(velocityTracker, 1000);
        return I.d(velocityTracker, i2);
    }

    public void g(MotionEvent motionEvent, int i2) {
        boolean zD = d(motionEvent, i2);
        if (this.f2373j[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.f2368e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f2368e = null;
                return;
            }
            return;
        }
        float fE = e(motionEvent, i2) * this.f2365b.b();
        float fSignum = Math.signum(fE);
        if (zD || (fSignum != Math.signum(this.f2369f) && fSignum != 0.0f)) {
            this.f2365b.c();
        }
        float fAbs = Math.abs(fE);
        int[] iArr = this.f2373j;
        if (fAbs < iArr[0]) {
            return;
        }
        float fMax = Math.max(-r6, Math.min(fE, iArr[1]));
        this.f2369f = this.f2365b.a(fMax) ? fMax : 0.0f;
    }

    C0151o(Context context, InterfaceC0152p interfaceC0152p, b bVar, a aVar) {
        this.f2370g = -1;
        this.f2371h = -1;
        this.f2372i = -1;
        this.f2373j = new int[]{Integer.MAX_VALUE, 0};
        this.f2364a = context;
        this.f2365b = interfaceC0152p;
        this.f2366c = bVar;
        this.f2367d = aVar;
    }
}
