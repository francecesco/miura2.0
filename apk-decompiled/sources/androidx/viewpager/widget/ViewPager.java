package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.view.C0137a;
import androidx.core.view.E;
import androidx.core.view.L;
import androidx.core.view.Y;
import it.tervis.miura.model.Peripheral;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p.C;
import t.AbstractC0251a;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager extends ViewGroup {

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    static final int[] f3349f0 = {R.attr.layout_gravity};

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private static final Comparator f3350g0 = new a();

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private static final Interpolator f3351h0 = new b();

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private static final m f3352i0 = new m();

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private int f3353A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private int f3354B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private int f3355C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private float f3356D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private float f3357E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private float f3358F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private float f3359G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private int f3360H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private VelocityTracker f3361I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f3362J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private int f3363K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private int f3364L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private int f3365M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private boolean f3366N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private EdgeEffect f3367O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private EdgeEffect f3368P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private boolean f3369Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private boolean f3370R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private boolean f3371S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private int f3372T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    private List f3373U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    private j f3374V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    private j f3375W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3376a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private List f3377a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList f3378b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private int f3379b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f3380c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private ArrayList f3381c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f3382d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private final Runnable f3383d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    androidx.viewpager.widget.a f3384e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private int f3385e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f3386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Parcelable f3388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ClassLoader f3389i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Scroller f3390j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f3391k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private k f3392l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f3393m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Drawable f3394n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f3395o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f3396p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f3397q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f3398r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f3399s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f3400t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f3401u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f3402v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f3403w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f3404x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f3405y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f3406z;

    static class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            return fVar.f3411b - fVar2.f3411b;
        }
    }

    static class b implements Interpolator {
        b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.C();
        }
    }

    class d implements E {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f3408a = new Rect();

        d() {
        }

        @Override // androidx.core.view.E
        public Y a(View view, Y y2) {
            Y yL = L.L(view, y2);
            if (yL.n()) {
                return yL;
            }
            Rect rect = this.f3408a;
            rect.left = yL.i();
            rect.top = yL.k();
            rect.right = yL.j();
            rect.bottom = yL.h();
            int childCount = ViewPager.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                Y yG = L.g(ViewPager.this.getChildAt(i2), yL);
                rect.left = Math.min(yG.i(), rect.left);
                rect.top = Math.min(yG.k(), rect.top);
                rect.right = Math.min(yG.j(), rect.right);
                rect.bottom = Math.min(yG.h(), rect.bottom);
            }
            return yL.o(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface e {
    }

    static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f3410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3411b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f3412c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f3413d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f3414e;

        f() {
        }
    }

    public static class g extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f3417c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f3418d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f3419e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f3420f;

        public g() {
            super(-1, -1);
            this.f3417c = 0.0f;
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3417c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f3349f0);
            this.f3416b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    class h extends C0137a {
        h() {
        }

        private boolean n() {
            androidx.viewpager.widget.a aVar = ViewPager.this.f3384e;
            return aVar != null && aVar.c() > 1;
        }

        @Override // androidx.core.view.C0137a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            androidx.viewpager.widget.a aVar;
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(n());
            if (accessibilityEvent.getEventType() != 4096 || (aVar = ViewPager.this.f3384e) == null) {
                return;
            }
            accessibilityEvent.setItemCount(aVar.c());
            accessibilityEvent.setFromIndex(ViewPager.this.f3386f);
            accessibilityEvent.setToIndex(ViewPager.this.f3386f);
        }

        @Override // androidx.core.view.C0137a
        public void g(View view, C c2) {
            super.g(view, c2);
            c2.f0(ViewPager.class.getName());
            c2.r0(n());
            if (ViewPager.this.canScrollHorizontally(1)) {
                c2.a(Peripheral.EXPANSION_4);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                c2.a(Peripheral.EXPANSION_5);
            }
        }

        @Override // androidx.core.view.C0137a
        public boolean j(View view, int i2, Bundle bundle) {
            ViewPager viewPager;
            int i3;
            if (super.j(view, i2, bundle)) {
                return true;
            }
            if (i2 != 4096) {
                if (i2 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                viewPager = ViewPager.this;
                i3 = viewPager.f3386f - 1;
            } else {
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                viewPager = ViewPager.this;
                i3 = viewPager.f3386f + 1;
            }
            viewPager.setCurrentItem(i3);
            return true;
        }
    }

    public interface i {
        void b(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2);
    }

    public interface j {
        void a(int i2, float f2, int i3);

        void c(int i2);

        void d(int i2);
    }

    private class k extends DataSetObserver {
        k() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.g();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.g();
        }
    }

    public static class l extends AbstractC0251a {
        public static final Parcelable.Creator<l> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f3423c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Parcelable f3424d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ClassLoader f3425e;

        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public l createFromParcel(Parcel parcel) {
                return new l(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public l createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new l(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public l[] newArray(int i2) {
                return new l[i2];
            }
        }

        l(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f3423c = parcel.readInt();
            this.f3424d = parcel.readParcelable(classLoader);
            this.f3425e = classLoader;
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f3423c + "}";
        }

        @Override // t.AbstractC0251a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f3423c);
            parcel.writeParcelable(this.f3424d, i2);
        }

        public l(Parcelable parcelable) {
            super(parcelable);
        }
    }

    static class m implements Comparator {
        m() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            g gVar = (g) view.getLayoutParams();
            g gVar2 = (g) view2.getLayoutParams();
            boolean z2 = gVar.f3415a;
            return z2 != gVar2.f3415a ? z2 ? 1 : -1 : gVar.f3419e - gVar2.f3419e;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3378b = new ArrayList();
        this.f3380c = new f();
        this.f3382d = new Rect();
        this.f3387g = -1;
        this.f3388h = null;
        this.f3389i = null;
        this.f3397q = -3.4028235E38f;
        this.f3398r = Float.MAX_VALUE;
        this.f3404x = 1;
        this.f3360H = -1;
        this.f3369Q = true;
        this.f3370R = false;
        this.f3383d0 = new c();
        this.f3385e0 = 0;
        t();
    }

    private boolean A(int i2) {
        if (this.f3378b.size() == 0) {
            if (this.f3369Q) {
                return false;
            }
            this.f3371S = false;
            w(0, 0.0f, 0);
            if (this.f3371S) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        f fVarR = r();
        int clientWidth = getClientWidth();
        int i3 = this.f3393m;
        int i4 = clientWidth + i3;
        float f2 = clientWidth;
        int i5 = fVarR.f3411b;
        float f3 = ((i2 / f2) - fVarR.f3414e) / (fVarR.f3413d + (i3 / f2));
        this.f3371S = false;
        w(i5, f3, (int) (i4 * f3));
        if (this.f3371S) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean B(float f2) {
        boolean z2;
        boolean z3;
        float f3 = this.f3356D - f2;
        this.f3356D = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.f3397q * clientWidth;
        float f5 = this.f3398r * clientWidth;
        boolean z4 = false;
        f fVar = (f) this.f3378b.get(0);
        ArrayList arrayList = this.f3378b;
        f fVar2 = (f) arrayList.get(arrayList.size() - 1);
        if (fVar.f3411b != 0) {
            f4 = fVar.f3414e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (fVar2.f3411b != this.f3384e.c() - 1) {
            f5 = fVar2.f3414e * clientWidth;
            z3 = false;
        } else {
            z3 = true;
        }
        if (scrollX < f4) {
            if (z2) {
                this.f3367O.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z4 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z3) {
                this.f3368P.onPull(Math.abs(scrollX - f5) / clientWidth);
                z4 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.f3356D += scrollX - i2;
        scrollTo(i2, getScrollY());
        A(i2);
        return z4;
    }

    private void E(int i2, int i3, int i4, int i5) {
        int iMin;
        if (i3 <= 0 || this.f3378b.isEmpty()) {
            f fVarS = s(this.f3386f);
            iMin = (int) ((fVarS != null ? Math.min(fVarS.f3414e, this.f3398r) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
            if (iMin == getScrollX()) {
                return;
            } else {
                f(false);
            }
        } else if (!this.f3390j.isFinished()) {
            this.f3390j.setFinalX(getCurrentItem() * getClientWidth());
            return;
        } else {
            iMin = (int) ((getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i4));
        }
        scrollTo(iMin, getScrollY());
    }

    private void F() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((g) getChildAt(i2).getLayoutParams()).f3415a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    private void H(boolean z2) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    private boolean I() {
        this.f3360H = -1;
        m();
        this.f3367O.onRelease();
        this.f3368P.onRelease();
        return this.f3367O.isFinished() || this.f3368P.isFinished();
    }

    private void J(int i2, boolean z2, int i3, boolean z3) {
        f fVarS = s(i2);
        int clientWidth = fVarS != null ? (int) (getClientWidth() * Math.max(this.f3397q, Math.min(fVarS.f3414e, this.f3398r))) : 0;
        if (z2) {
            O(clientWidth, 0, i3);
            if (z3) {
                j(i2);
                return;
            }
            return;
        }
        if (z3) {
            j(i2);
        }
        f(false);
        scrollTo(clientWidth, 0);
        A(clientWidth);
    }

    private void P() {
        if (this.f3379b0 != 0) {
            ArrayList arrayList = this.f3381c0;
            if (arrayList == null) {
                this.f3381c0 = new ArrayList();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.f3381c0.add(getChildAt(i2));
            }
            Collections.sort(this.f3381c0, f3352i0);
        }
    }

    private void d(f fVar, int i2, f fVar2) {
        int i3;
        int i4;
        f fVar3;
        f fVar4;
        int iC = this.f3384e.c();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.f3393m / clientWidth : 0.0f;
        if (fVar2 != null) {
            int i5 = fVar2.f3411b;
            int i6 = fVar.f3411b;
            if (i5 < i6) {
                float f3 = fVar2.f3414e + fVar2.f3413d + f2;
                int i7 = i5 + 1;
                int i8 = 0;
                while (i7 <= fVar.f3411b && i8 < this.f3378b.size()) {
                    while (true) {
                        fVar4 = (f) this.f3378b.get(i8);
                        if (i7 <= fVar4.f3411b || i8 >= this.f3378b.size() - 1) {
                            break;
                        } else {
                            i8++;
                        }
                    }
                    while (i7 < fVar4.f3411b) {
                        f3 += this.f3384e.f(i7) + f2;
                        i7++;
                    }
                    fVar4.f3414e = f3;
                    f3 += fVar4.f3413d + f2;
                    i7++;
                }
            } else if (i5 > i6) {
                int size = this.f3378b.size() - 1;
                float f4 = fVar2.f3414e;
                while (true) {
                    i5--;
                    if (i5 < fVar.f3411b || size < 0) {
                        break;
                    }
                    while (true) {
                        fVar3 = (f) this.f3378b.get(size);
                        if (i5 >= fVar3.f3411b || size <= 0) {
                            break;
                        } else {
                            size--;
                        }
                    }
                    while (i5 > fVar3.f3411b) {
                        f4 -= this.f3384e.f(i5) + f2;
                        i5--;
                    }
                    f4 -= fVar3.f3413d + f2;
                    fVar3.f3414e = f4;
                }
            }
        }
        int size2 = this.f3378b.size();
        float f5 = fVar.f3414e;
        int i9 = fVar.f3411b;
        int i10 = i9 - 1;
        this.f3397q = i9 == 0 ? f5 : -3.4028235E38f;
        int i11 = iC - 1;
        this.f3398r = i9 == i11 ? (fVar.f3413d + f5) - 1.0f : Float.MAX_VALUE;
        int i12 = i2 - 1;
        while (i12 >= 0) {
            f fVar5 = (f) this.f3378b.get(i12);
            while (true) {
                i4 = fVar5.f3411b;
                if (i10 <= i4) {
                    break;
                }
                f5 -= this.f3384e.f(i10) + f2;
                i10--;
            }
            f5 -= fVar5.f3413d + f2;
            fVar5.f3414e = f5;
            if (i4 == 0) {
                this.f3397q = f5;
            }
            i12--;
            i10--;
        }
        float f6 = fVar.f3414e + fVar.f3413d + f2;
        int i13 = fVar.f3411b + 1;
        int i14 = i2 + 1;
        while (i14 < size2) {
            f fVar6 = (f) this.f3378b.get(i14);
            while (true) {
                i3 = fVar6.f3411b;
                if (i13 >= i3) {
                    break;
                }
                f6 += this.f3384e.f(i13) + f2;
                i13++;
            }
            if (i3 == i11) {
                this.f3398r = (fVar6.f3413d + f6) - 1.0f;
            }
            fVar6.f3414e = f6;
            f6 += fVar6.f3413d + f2;
            i14++;
            i13++;
        }
        this.f3370R = false;
    }

    private void f(boolean z2) {
        boolean z3 = this.f3385e0 == 2;
        if (z3) {
            setScrollingCacheEnabled(false);
            if (!this.f3390j.isFinished()) {
                this.f3390j.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f3390j.getCurrX();
                int currY = this.f3390j.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        A(currX);
                    }
                }
            }
        }
        this.f3403w = false;
        for (int i2 = 0; i2 < this.f3378b.size(); i2++) {
            f fVar = (f) this.f3378b.get(i2);
            if (fVar.f3412c) {
                fVar.f3412c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z2) {
                L.P(this, this.f3383d0);
            } else {
                this.f3383d0.run();
            }
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private int h(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.f3364L || Math.abs(i3) <= this.f3362J) {
            i2 += (int) (f2 + (i2 >= this.f3386f ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.f3378b.size() <= 0) {
            return i2;
        }
        return Math.max(((f) this.f3378b.get(0)).f3411b, Math.min(i2, ((f) this.f3378b.get(r4.size() - 1)).f3411b));
    }

    private void i(int i2, float f2, int i3) {
        j jVar = this.f3374V;
        if (jVar != null) {
            jVar.a(i2, f2, i3);
        }
        List list = this.f3373U;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                j jVar2 = (j) this.f3373U.get(i4);
                if (jVar2 != null) {
                    jVar2.a(i2, f2, i3);
                }
            }
        }
        j jVar3 = this.f3375W;
        if (jVar3 != null) {
            jVar3.a(i2, f2, i3);
        }
    }

    private void j(int i2) {
        j jVar = this.f3374V;
        if (jVar != null) {
            jVar.d(i2);
        }
        List list = this.f3373U;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar2 = (j) this.f3373U.get(i3);
                if (jVar2 != null) {
                    jVar2.d(i2);
                }
            }
        }
        j jVar3 = this.f3375W;
        if (jVar3 != null) {
            jVar3.d(i2);
        }
    }

    private void k(int i2) {
        j jVar = this.f3374V;
        if (jVar != null) {
            jVar.c(i2);
        }
        List list = this.f3373U;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar2 = (j) this.f3373U.get(i3);
                if (jVar2 != null) {
                    jVar2.c(i2);
                }
            }
        }
        j jVar3 = this.f3375W;
        if (jVar3 != null) {
            jVar3.c(i2);
        }
    }

    private void m() {
        this.f3405y = false;
        this.f3406z = false;
        VelocityTracker velocityTracker = this.f3361I;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f3361I = null;
        }
    }

    private Rect o(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        int bottom = view.getBottom();
        while (true) {
            rect.bottom = bottom;
            ViewParent parent = view.getParent();
            if (!(parent instanceof ViewGroup) || parent == this) {
                break;
            }
            view = (ViewGroup) parent;
            rect.left += view.getLeft();
            rect.right += view.getRight();
            rect.top += view.getTop();
            bottom = rect.bottom + view.getBottom();
        }
        return rect;
    }

    private f r() {
        int i2;
        int clientWidth = getClientWidth();
        float f2 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f3 = clientWidth > 0 ? this.f3393m / clientWidth : 0.0f;
        f fVar = null;
        float f4 = 0.0f;
        int i3 = -1;
        int i4 = 0;
        boolean z2 = true;
        while (i4 < this.f3378b.size()) {
            f fVar2 = (f) this.f3378b.get(i4);
            if (!z2 && fVar2.f3411b != (i2 = i3 + 1)) {
                fVar2 = this.f3380c;
                fVar2.f3414e = f2 + f4 + f3;
                fVar2.f3411b = i2;
                fVar2.f3413d = this.f3384e.f(i2);
                i4--;
            }
            f fVar3 = fVar2;
            f2 = fVar3.f3414e;
            float f5 = fVar3.f3413d + f2 + f3;
            if (!z2 && scrollX < f2) {
                return fVar;
            }
            if (scrollX < f5 || i4 == this.f3378b.size() - 1) {
                return fVar3;
            }
            int i5 = fVar3.f3411b;
            float f6 = fVar3.f3413d;
            i4++;
            z2 = false;
            i3 = i5;
            f4 = f6;
            fVar = fVar3;
        }
        return fVar;
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.f3402v != z2) {
            this.f3402v = z2;
        }
    }

    private static boolean u(View view) {
        return view.getClass().getAnnotation(e.class) != null;
    }

    private boolean v(float f2, float f3) {
        return (f2 < ((float) this.f3354B) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.f3354B)) && f3 < 0.0f);
    }

    private void x(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3360H) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.f3356D = motionEvent.getX(i2);
            this.f3360H = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.f3361I;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    void C() {
        D(this.f3386f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c2 A[PHI: r7 r10 r15
      0x00c2: PHI (r7v9 int) = (r7v5 int), (r7v4 int), (r7v10 int) binds: [B:64:0x00e7, B:61:0x00d9, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
      0x00c2: PHI (r10v12 int) = (r10v1 int), (r10v8 int), (r10v13 int) binds: [B:64:0x00e7, B:61:0x00d9, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
      0x00c2: PHI (r15v10 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:64:0x00e7, B:61:0x00d9, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cb A[PHI: r7 r10 r15
      0x00cb: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v10 int) binds: [B:64:0x00e7, B:61:0x00d9, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
      0x00cb: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v13 int) binds: [B:64:0x00e7, B:61:0x00d9, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
      0x00cb: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:64:0x00e7, B:61:0x00d9, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void D(int r18) {
        /*
            Method dump skipped, instruction units count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.D(int):void");
    }

    public void G(i iVar) {
        List list = this.f3377a0;
        if (list != null) {
            list.remove(iVar);
        }
    }

    public void K(int i2, boolean z2) {
        this.f3403w = false;
        L(i2, z2, false);
    }

    void L(int i2, boolean z2, boolean z3) {
        M(i2, z2, z3, 0);
    }

    void M(int i2, boolean z2, boolean z3, int i3) {
        androidx.viewpager.widget.a aVar = this.f3384e;
        if (aVar == null || aVar.c() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z3 && this.f3386f == i2 && this.f3378b.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= this.f3384e.c()) {
            i2 = this.f3384e.c() - 1;
        }
        int i4 = this.f3404x;
        int i5 = this.f3386f;
        if (i2 > i5 + i4 || i2 < i5 - i4) {
            for (int i6 = 0; i6 < this.f3378b.size(); i6++) {
                ((f) this.f3378b.get(i6)).f3412c = true;
            }
        }
        boolean z4 = this.f3386f != i2;
        if (!this.f3369Q) {
            D(i2);
            J(i2, z2, i3, z4);
        } else {
            this.f3386f = i2;
            if (z4) {
                j(i2);
            }
            requestLayout();
        }
    }

    j N(j jVar) {
        j jVar2 = this.f3375W;
        this.f3375W = jVar;
        return jVar2;
    }

    void O(int i2, int i3, int i4) {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.f3390j;
        if (scroller == null || scroller.isFinished()) {
            scrollX = getScrollX();
        } else {
            scrollX = this.f3391k ? this.f3390j.getCurrX() : this.f3390j.getStartX();
            this.f3390j.abortAnimation();
            setScrollingCacheEnabled(false);
        }
        int i5 = scrollX;
        int scrollY = getScrollY();
        int i6 = i2 - i5;
        int i7 = i3 - scrollY;
        if (i6 == 0 && i7 == 0) {
            f(false);
            C();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i8 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i8;
        float fL = f3 + (l(Math.min(1.0f, (Math.abs(i6) * 1.0f) / f2)) * f3);
        int iAbs = Math.abs(i4);
        int iMin = Math.min(iAbs > 0 ? Math.round(Math.abs(fL / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i6) / ((f2 * this.f3384e.f(this.f3386f)) + this.f3393m)) + 1.0f) * 100.0f), 600);
        this.f3391k = false;
        this.f3390j.startScroll(i5, scrollY, i6, i7, iMin);
        L.O(this);
    }

    f a(int i2, int i3) {
        f fVar = new f();
        fVar.f3411b = i2;
        fVar.f3410a = this.f3384e.g(this, i2);
        fVar.f3413d = this.f3384e.f(i2);
        if (i3 < 0 || i3 >= this.f3378b.size()) {
            this.f3378b.add(fVar);
        } else {
            this.f3378b.add(i3, fVar);
        }
        return fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i2, int i3) {
        f fVarQ;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (fVarQ = q(childAt)) != null && fVarQ.f3411b == this.f3386f) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList arrayList) {
        f fVarQ;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (fVarQ = q(childAt)) != null && fVarQ.f3411b == this.f3386f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        g gVar = (g) layoutParams;
        boolean zU = gVar.f3415a | u(view);
        gVar.f3415a = zU;
        if (!this.f3401u) {
            super.addView(view, i2, layoutParams);
        } else {
            if (zU) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            gVar.f3418d = true;
            addViewInLayout(view, i2, layoutParams);
        }
    }

    public void b(i iVar) {
        if (this.f3377a0 == null) {
            this.f3377a0 = new ArrayList();
        }
        this.f3377a0.add(iVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(int r5) {
        /*
            r4 = this;
            android.view.View r0 = r4.findFocus()
            r1 = 0
            if (r0 != r4) goto L9
        L7:
            r0 = r1
            goto L5a
        L9:
            if (r0 == 0) goto L5a
            android.view.ViewParent r2 = r0.getParent()
        Lf:
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 == 0) goto L1b
            if (r2 != r4) goto L16
            goto L5a
        L16:
            android.view.ViewParent r2 = r2.getParent()
            goto Lf
        L1b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
        L2f:
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L48
            java.lang.String r3 = " => "
            r2.append(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
            goto L2f
        L48:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            goto L7
        L5a:
            android.view.FocusFinder r1 = android.view.FocusFinder.getInstance()
            android.view.View r1 = r1.findNextFocus(r4, r0, r5)
            r2 = 66
            r3 = 17
            if (r1 == 0) goto L9d
            if (r1 == r0) goto L9d
            if (r5 != r3) goto L86
            android.graphics.Rect r2 = r4.f3382d
            android.graphics.Rect r2 = r4.o(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.f3382d
            android.graphics.Rect r3 = r4.o(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L81
            if (r2 < r3) goto L81
            goto Lb0
        L81:
            boolean r0 = r1.requestFocus()
            goto Lb4
        L86:
            if (r5 != r2) goto La9
            android.graphics.Rect r2 = r4.f3382d
            android.graphics.Rect r2 = r4.o(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.f3382d
            android.graphics.Rect r3 = r4.o(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L81
            if (r2 > r3) goto L81
            goto Lab
        L9d:
            if (r5 == r3) goto Lb0
            r0 = 1
            if (r5 != r0) goto La3
            goto Lb0
        La3:
            if (r5 == r2) goto Lab
            r0 = 2
            if (r5 != r0) goto La9
            goto Lab
        La9:
            r0 = 0
            goto Lb4
        Lab:
            boolean r0 = r4.z()
            goto Lb4
        Lb0:
            boolean r0 = r4.y()
        Lb4:
            if (r0 == 0) goto Lbd
            int r5 = android.view.SoundEffectConstants.getContantForFocusDirection(r5)
            r4.playSoundEffect(r5)
        Lbd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.c(int):boolean");
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.f3384e == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i2 < 0 ? scrollX > ((int) (((float) clientWidth) * this.f3397q)) : i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.f3398r));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof g) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f3391k = true;
        if (this.f3390j.isFinished() || !this.f3390j.computeScrollOffset()) {
            f(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f3390j.getCurrX();
        int currY = this.f3390j.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!A(currX)) {
                this.f3390j.abortAnimation();
                scrollTo(0, currY);
            }
        }
        L.O(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || n(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f fVarQ;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (fVarQ = q(childAt)) != null && fVarQ.f3411b == this.f3386f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        androidx.viewpager.widget.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.f3384e) != null && aVar.c() > 1)) {
            if (!this.f3367O.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f3397q * width);
                this.f3367O.setSize(height, width);
                zDraw = this.f3367O.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.f3368P.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f3398r + 1.0f)) * width2);
                this.f3368P.setSize(height2, width2);
                zDraw |= this.f3368P.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.f3367O.finish();
            this.f3368P.finish();
        }
        if (zDraw) {
            L.O(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f3394n;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    protected boolean e(View view, boolean z2, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && e(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z2 && view.canScrollHorizontally(-i2);
    }

    void g() {
        int iC = this.f3384e.c();
        this.f3376a = iC;
        boolean z2 = this.f3378b.size() < (this.f3404x * 2) + 1 && this.f3378b.size() < iC;
        int iMax = this.f3386f;
        int i2 = 0;
        boolean z3 = false;
        while (i2 < this.f3378b.size()) {
            f fVar = (f) this.f3378b.get(i2);
            int iD = this.f3384e.d(fVar.f3410a);
            if (iD != -1) {
                if (iD == -2) {
                    this.f3378b.remove(i2);
                    i2--;
                    if (!z3) {
                        this.f3384e.n(this);
                        z3 = true;
                    }
                    this.f3384e.a(this, fVar.f3411b, fVar.f3410a);
                    int i3 = this.f3386f;
                    if (i3 == fVar.f3411b) {
                        iMax = Math.max(0, Math.min(i3, iC - 1));
                    }
                } else {
                    int i4 = fVar.f3411b;
                    if (i4 != iD) {
                        if (i4 == this.f3386f) {
                            iMax = iD;
                        }
                        fVar.f3411b = iD;
                    }
                }
                z2 = true;
            }
            i2++;
        }
        if (z3) {
            this.f3384e.b(this);
        }
        Collections.sort(this.f3378b, f3350g0);
        if (z2) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                g gVar = (g) getChildAt(i5).getLayoutParams();
                if (!gVar.f3415a) {
                    gVar.f3417c = 0.0f;
                }
            }
            L(iMax, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.f3384e;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (this.f3379b0 == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((g) ((View) this.f3381c0.get(i3)).getLayoutParams()).f3420f;
    }

    public int getCurrentItem() {
        return this.f3386f;
    }

    public int getOffscreenPageLimit() {
        return this.f3404x;
    }

    public int getPageMargin() {
        return this.f3393m;
    }

    float l(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    public boolean n(KeyEvent keyEvent) {
        int i2;
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return c(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return c(1);
                        }
                    }
                } else {
                    if (keyEvent.hasModifiers(2)) {
                        return z();
                    }
                    i2 = 66;
                }
            } else {
                if (keyEvent.hasModifiers(2)) {
                    return y();
                }
                i2 = 17;
            }
            return c(i2);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3369Q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f3383d0);
        Scroller scroller = this.f3390j;
        if (scroller != null && !scroller.isFinished()) {
            this.f3390j.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i2;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.f3393m <= 0 || this.f3394n == null || this.f3378b.size() <= 0 || this.f3384e == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f4 = this.f3393m / width;
        int i3 = 0;
        f fVar = (f) this.f3378b.get(0);
        float f5 = fVar.f3414e;
        int size = this.f3378b.size();
        int i4 = fVar.f3411b;
        int i5 = ((f) this.f3378b.get(size - 1)).f3411b;
        while (i4 < i5) {
            while (true) {
                i2 = fVar.f3411b;
                if (i4 <= i2 || i3 >= size) {
                    break;
                }
                i3++;
                fVar = (f) this.f3378b.get(i3);
            }
            if (i4 == i2) {
                float f6 = fVar.f3414e;
                float f7 = fVar.f3413d;
                f2 = (f6 + f7) * width;
                f5 = f6 + f7 + f4;
            } else {
                float f8 = this.f3384e.f(i4);
                f2 = (f5 + f8) * width;
                f5 += f8 + f4;
            }
            if (this.f3393m + f2 > scrollX) {
                f3 = f4;
                this.f3394n.setBounds(Math.round(f2), this.f3395o, Math.round(this.f3393m + f2), this.f3396p);
                this.f3394n.draw(canvas);
            } else {
                f3 = f4;
            }
            if (f2 > scrollX + r2) {
                return;
            }
            i4++;
            f4 = f3;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            I();
            return false;
        }
        if (action != 0) {
            if (this.f3405y) {
                return true;
            }
            if (this.f3406z) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.f3358F = x2;
            this.f3356D = x2;
            float y2 = motionEvent.getY();
            this.f3359G = y2;
            this.f3357E = y2;
            this.f3360H = motionEvent.getPointerId(0);
            this.f3406z = false;
            this.f3391k = true;
            this.f3390j.computeScrollOffset();
            if (this.f3385e0 != 2 || Math.abs(this.f3390j.getFinalX() - this.f3390j.getCurrX()) <= this.f3365M) {
                f(false);
                this.f3405y = false;
            } else {
                this.f3390j.abortAnimation();
                this.f3403w = false;
                C();
                this.f3405y = true;
                H(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.f3360H;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                float x3 = motionEvent.getX(iFindPointerIndex);
                float f2 = x3 - this.f3356D;
                float fAbs = Math.abs(f2);
                float y3 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y3 - this.f3359G);
                if (f2 != 0.0f && !v(this.f3356D, f2) && e(this, false, (int) f2, (int) x3, (int) y3)) {
                    this.f3356D = x3;
                    this.f3357E = y3;
                    this.f3406z = true;
                    return false;
                }
                int i3 = this.f3355C;
                if (fAbs > i3 && fAbs * 0.5f > fAbs2) {
                    this.f3405y = true;
                    H(true);
                    setScrollState(1);
                    float f3 = this.f3358F;
                    float f4 = this.f3355C;
                    this.f3356D = f2 > 0.0f ? f3 + f4 : f3 - f4;
                    this.f3357E = y3;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i3) {
                    this.f3406z = true;
                }
                if (this.f3405y && B(x3)) {
                    L.O(this);
                }
            }
        } else if (action == 6) {
            x(motionEvent);
        }
        if (this.f3361I == null) {
            this.f3361I = VelocityTracker.obtain();
        }
        this.f3361I.addMovement(motionEvent);
        return this.f3405y;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a7  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        int i5;
        f fVarQ;
        int childCount = getChildCount();
        if ((i2 & 2) != 0) {
            i4 = childCount;
            i3 = 0;
            i5 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
            i5 = -1;
        }
        while (i3 != i4) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (fVarQ = q(childAt)) != null && fVarQ.f3411b == this.f3386f && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i5;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof l)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        l lVar = (l) parcelable;
        super.onRestoreInstanceState(lVar.a());
        androidx.viewpager.widget.a aVar = this.f3384e;
        if (aVar != null) {
            aVar.j(lVar.f3424d, lVar.f3425e);
            L(lVar.f3423c, false, true);
        } else {
            this.f3387g = lVar.f3423c;
            this.f3388h = lVar.f3424d;
            this.f3389i = lVar.f3425e;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        l lVar = new l(super.onSaveInstanceState());
        lVar.f3423c = this.f3386f;
        androidx.viewpager.widget.a aVar = this.f3384e;
        if (aVar != null) {
            lVar.f3424d = aVar.k();
        }
        return lVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.f3393m;
            E(i2, i4, i6, i6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0152  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    f p(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return q(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    f q(View view) {
        for (int i2 = 0; i2 < this.f3378b.size(); i2++) {
            f fVar = (f) this.f3378b.get(i2);
            if (this.f3384e.h(view, fVar.f3410a)) {
                return fVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f3401u) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    f s(int i2) {
        for (int i3 = 0; i3 < this.f3378b.size(); i3++) {
            f fVar = (f) this.f3378b.get(i3);
            if (fVar.f3411b == i2) {
                return fVar;
            }
        }
        return null;
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) {
        androidx.viewpager.widget.a aVar2 = this.f3384e;
        if (aVar2 != null) {
            aVar2.m(null);
            this.f3384e.n(this);
            for (int i2 = 0; i2 < this.f3378b.size(); i2++) {
                f fVar = (f) this.f3378b.get(i2);
                this.f3384e.a(this, fVar.f3411b, fVar.f3410a);
            }
            this.f3384e.b(this);
            this.f3378b.clear();
            F();
            this.f3386f = 0;
            scrollTo(0, 0);
        }
        androidx.viewpager.widget.a aVar3 = this.f3384e;
        this.f3384e = aVar;
        this.f3376a = 0;
        if (aVar != null) {
            if (this.f3392l == null) {
                this.f3392l = new k();
            }
            this.f3384e.m(this.f3392l);
            this.f3403w = false;
            boolean z2 = this.f3369Q;
            this.f3369Q = true;
            this.f3376a = this.f3384e.c();
            if (this.f3387g >= 0) {
                this.f3384e.j(this.f3388h, this.f3389i);
                L(this.f3387g, false, true);
                this.f3387g = -1;
                this.f3388h = null;
                this.f3389i = null;
            } else if (z2) {
                requestLayout();
            } else {
                C();
            }
        }
        List list = this.f3377a0;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.f3377a0.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((i) this.f3377a0.get(i3)).b(this, aVar3, aVar);
        }
    }

    public void setCurrentItem(int i2) {
        this.f3403w = false;
        L(i2, !this.f3369Q, false);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested offscreen page limit ");
            sb.append(i2);
            sb.append(" too small; defaulting to ");
            sb.append(1);
            i2 = 1;
        }
        if (i2 != this.f3404x) {
            this.f3404x = i2;
            C();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(j jVar) {
        this.f3374V = jVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.f3393m;
        this.f3393m = i2;
        int width = getWidth();
        E(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(androidx.core.content.a.d(getContext(), i2));
    }

    void setScrollState(int i2) {
        if (this.f3385e0 == i2) {
            return;
        }
        this.f3385e0 = i2;
        k(i2);
    }

    void t() {
        setWillNotDraw(false);
        setDescendantFocusability(Peripheral.EXPANSION_10);
        setFocusable(true);
        Context context = getContext();
        this.f3390j = new Scroller(context, f3351h0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f3355C = viewConfiguration.getScaledPagingTouchSlop();
        this.f3362J = (int) (400.0f * f2);
        this.f3363K = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f3367O = new EdgeEffect(context);
        this.f3368P = new EdgeEffect(context);
        this.f3364L = (int) (25.0f * f2);
        this.f3365M = (int) (2.0f * f2);
        this.f3353A = (int) (f2 * 16.0f);
        L.U(this, new h());
        if (L.u(this) == 0) {
            L.a0(this, 1);
        }
        L.c0(this, new d());
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3394n;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void w(int r12, float r13, int r14) {
        /*
            r11 = this;
            int r0 = r11.f3372T
            r1 = 1
            if (r0 <= 0) goto L6b
            int r0 = r11.getScrollX()
            int r2 = r11.getPaddingLeft()
            int r3 = r11.getPaddingRight()
            int r4 = r11.getWidth()
            int r5 = r11.getChildCount()
            r6 = 0
        L1a:
            if (r6 >= r5) goto L6b
            android.view.View r7 = r11.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.viewpager.widget.ViewPager$g r8 = (androidx.viewpager.widget.ViewPager.g) r8
            boolean r9 = r8.f3415a
            if (r9 != 0) goto L2b
            goto L68
        L2b:
            int r8 = r8.f3416b
            r8 = r8 & 7
            if (r8 == r1) goto L4f
            r9 = 3
            if (r8 == r9) goto L49
            r9 = 5
            if (r8 == r9) goto L39
            r8 = r2
            goto L5c
        L39:
            int r8 = r4 - r3
            int r9 = r7.getMeasuredWidth()
            int r8 = r8 - r9
            int r9 = r7.getMeasuredWidth()
            int r3 = r3 + r9
        L45:
            r10 = r8
            r8 = r2
            r2 = r10
            goto L5c
        L49:
            int r8 = r7.getWidth()
            int r8 = r8 + r2
            goto L5c
        L4f:
            int r8 = r7.getMeasuredWidth()
            int r8 = r4 - r8
            int r8 = r8 / 2
            int r8 = java.lang.Math.max(r8, r2)
            goto L45
        L5c:
            int r2 = r2 + r0
            int r9 = r7.getLeft()
            int r2 = r2 - r9
            if (r2 == 0) goto L67
            r7.offsetLeftAndRight(r2)
        L67:
            r2 = r8
        L68:
            int r6 = r6 + 1
            goto L1a
        L6b:
            r11.i(r12, r13, r14)
            r11.f3371S = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.w(int, float, int):void");
    }

    boolean y() {
        int i2 = this.f3386f;
        if (i2 <= 0) {
            return false;
        }
        K(i2 - 1, true);
        return true;
    }

    boolean z() {
        androidx.viewpager.widget.a aVar = this.f3384e;
        if (aVar == null || this.f3386f >= aVar.c() - 1) {
            return false;
        }
        K(this.f3386f + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f3394n = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }
}
