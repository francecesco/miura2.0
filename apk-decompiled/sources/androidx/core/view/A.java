package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewParent f2265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewParent f2266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f2267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int[] f2269e;

    public A(View view) {
        this.f2267c = view;
    }

    private boolean f(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        ViewParent viewParentG;
        int i7;
        int i8;
        int[] iArr3;
        if (!j() || (viewParentG = g(i6)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f2267c.getLocationInWindow(iArr);
            i7 = iArr[0];
            i8 = iArr[1];
        } else {
            i7 = 0;
            i8 = 0;
        }
        if (iArr2 == null) {
            int[] iArrH = h();
            iArrH[0] = 0;
            iArrH[1] = 0;
            iArr3 = iArrH;
        } else {
            iArr3 = iArr2;
        }
        S.d(viewParentG, this.f2267c, i2, i3, i4, i5, i6, iArr3);
        if (iArr != null) {
            this.f2267c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i7;
            iArr[1] = iArr[1] - i8;
        }
        return true;
    }

    private ViewParent g(int i2) {
        if (i2 == 0) {
            return this.f2265a;
        }
        if (i2 != 1) {
            return null;
        }
        return this.f2266b;
    }

    private int[] h() {
        if (this.f2269e == null) {
            this.f2269e = new int[2];
        }
        return this.f2269e;
    }

    private void l(int i2, ViewParent viewParent) {
        if (i2 == 0) {
            this.f2265a = viewParent;
        } else {
            if (i2 != 1) {
                return;
            }
            this.f2266b = viewParent;
        }
    }

    public boolean a(float f2, float f3, boolean z2) {
        ViewParent viewParentG;
        if (!j() || (viewParentG = g(0)) == null) {
            return false;
        }
        return S.a(viewParentG, this.f2267c, f2, f3, z2);
    }

    public boolean b(float f2, float f3) {
        ViewParent viewParentG;
        if (!j() || (viewParentG = g(0)) == null) {
            return false;
        }
        return S.b(viewParentG, this.f2267c, f2, f3);
    }

    public boolean c(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        ViewParent viewParentG;
        int i5;
        int i6;
        if (!j() || (viewParentG = g(i4)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        if (iArr2 != null) {
            this.f2267c.getLocationInWindow(iArr2);
            i5 = iArr2[0];
            i6 = iArr2[1];
        } else {
            i5 = 0;
            i6 = 0;
        }
        if (iArr == null) {
            iArr = h();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        S.c(viewParentG, this.f2267c, i2, i3, iArr, i4);
        if (iArr2 != null) {
            this.f2267c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i5;
            iArr2[1] = iArr2[1] - i6;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public void d(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        f(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public boolean e(int i2, int i3, int i4, int i5, int[] iArr) {
        return f(i2, i3, i4, i5, iArr, 0, null);
    }

    public boolean i(int i2) {
        return g(i2) != null;
    }

    public boolean j() {
        return this.f2268d;
    }

    public void k(boolean z2) {
        if (this.f2268d) {
            L.h0(this.f2267c);
        }
        this.f2268d = z2;
    }

    public boolean m(int i2, int i3) {
        if (i(i3)) {
            return true;
        }
        if (!j()) {
            return false;
        }
        View view = this.f2267c;
        for (ViewParent parent = this.f2267c.getParent(); parent != null; parent = parent.getParent()) {
            if (S.f(parent, view, this.f2267c, i2, i3)) {
                l(i3, parent);
                S.e(parent, view, this.f2267c, i2, i3);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void n(int i2) {
        ViewParent viewParentG = g(i2);
        if (viewParentG != null) {
            S.g(viewParentG, this.f2267c, i2);
            l(i2, null);
        }
    }
}
