package androidx.core.view;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
class J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f2276a = new float[20];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f2277b = new long[20];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f2278c = 0.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2279d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2280e = 0;

    J() {
    }

    private void b() {
        this.f2279d = 0;
        this.f2278c = 0.0f;
    }

    private float e() {
        long[] jArr;
        long j2;
        int i2 = this.f2279d;
        if (i2 < 2) {
            return 0.0f;
        }
        int i3 = this.f2280e;
        int i4 = ((i3 + 20) - (i2 - 1)) % 20;
        long j3 = this.f2277b[i3];
        while (true) {
            jArr = this.f2277b;
            j2 = jArr[i4];
            if (j3 - j2 <= 100) {
                break;
            }
            this.f2279d--;
            i4 = (i4 + 1) % 20;
        }
        int i5 = this.f2279d;
        if (i5 < 2) {
            return 0.0f;
        }
        if (i5 == 2) {
            int i6 = (i4 + 1) % 20;
            if (j2 == jArr[i6]) {
                return 0.0f;
            }
            return this.f2276a[i6] / (r2 - j2);
        }
        int i7 = 0;
        float fAbs = 0.0f;
        for (int i8 = 0; i8 < this.f2279d - 1; i8++) {
            int i9 = i8 + i4;
            long[] jArr2 = this.f2277b;
            long j4 = jArr2[i9 % 20];
            int i10 = (i9 + 1) % 20;
            if (jArr2[i10] != j4) {
                i7++;
                float f2 = f(fAbs);
                float f3 = this.f2276a[i10] / (this.f2277b[i10] - j4);
                fAbs += (f3 - f2) * Math.abs(f3);
                if (i7 == 1) {
                    fAbs *= 0.5f;
                }
            }
        }
        return f(fAbs);
    }

    private static float f(float f2) {
        return (f2 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f2) * 2.0f));
    }

    void a(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.f2279d != 0 && eventTime - this.f2277b[this.f2280e] > 40) {
            b();
        }
        int i2 = (this.f2280e + 1) % 20;
        this.f2280e = i2;
        int i3 = this.f2279d;
        if (i3 != 20) {
            this.f2279d = i3 + 1;
        }
        this.f2276a[i2] = motionEvent.getAxisValue(26);
        this.f2277b[this.f2280e] = eventTime;
    }

    void c(int i2, float f2) {
        float fAbs;
        float fE = e() * i2;
        this.f2278c = fE;
        if (fE < (-Math.abs(f2))) {
            fAbs = -Math.abs(f2);
        } else if (this.f2278c <= Math.abs(f2)) {
            return;
        } else {
            fAbs = Math.abs(f2);
        }
        this.f2278c = fAbs;
    }

    float d(int i2) {
        if (i2 != 26) {
            return 0.0f;
        }
        return this.f2278c;
    }
}
