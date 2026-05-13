package k;

/* JADX INFO: renamed from: k.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0214h implements Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f3850e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f3852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f3853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3854d;

    public C0214h() {
        this(10);
    }

    private void d() {
        int i2 = this.f3854d;
        int[] iArr = this.f3852b;
        Object[] objArr = this.f3853c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f3850e) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f3851a = false;
        this.f3854d = i3;
    }

    public void a(int i2, Object obj) {
        int i3 = this.f3854d;
        if (i3 != 0 && i2 <= this.f3852b[i3 - 1]) {
            h(i2, obj);
            return;
        }
        if (this.f3851a && i3 >= this.f3852b.length) {
            d();
        }
        int i4 = this.f3854d;
        if (i4 >= this.f3852b.length) {
            int iE = AbstractC0209c.e(i4 + 1);
            int[] iArr = new int[iE];
            Object[] objArr = new Object[iE];
            int[] iArr2 = this.f3852b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f3853c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f3852b = iArr;
            this.f3853c = objArr;
        }
        this.f3852b[i4] = i2;
        this.f3853c[i4] = obj;
        this.f3854d = i4 + 1;
    }

    public void b() {
        int i2 = this.f3854d;
        Object[] objArr = this.f3853c;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f3854d = 0;
        this.f3851a = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0214h clone() {
        try {
            C0214h c0214h = (C0214h) super.clone();
            c0214h.f3852b = (int[]) this.f3852b.clone();
            c0214h.f3853c = (Object[]) this.f3853c.clone();
            return c0214h;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public Object e(int i2) {
        return f(i2, null);
    }

    public Object f(int i2, Object obj) {
        Object obj2;
        int iA = AbstractC0209c.a(this.f3852b, this.f3854d, i2);
        return (iA < 0 || (obj2 = this.f3853c[iA]) == f3850e) ? obj : obj2;
    }

    public int g(int i2) {
        if (this.f3851a) {
            d();
        }
        return this.f3852b[i2];
    }

    public void h(int i2, Object obj) {
        int iA = AbstractC0209c.a(this.f3852b, this.f3854d, i2);
        if (iA >= 0) {
            this.f3853c[iA] = obj;
            return;
        }
        int i3 = ~iA;
        int i4 = this.f3854d;
        if (i3 < i4) {
            Object[] objArr = this.f3853c;
            if (objArr[i3] == f3850e) {
                this.f3852b[i3] = i2;
                objArr[i3] = obj;
                return;
            }
        }
        if (this.f3851a && i4 >= this.f3852b.length) {
            d();
            i3 = ~AbstractC0209c.a(this.f3852b, this.f3854d, i2);
        }
        int i5 = this.f3854d;
        if (i5 >= this.f3852b.length) {
            int iE = AbstractC0209c.e(i5 + 1);
            int[] iArr = new int[iE];
            Object[] objArr2 = new Object[iE];
            int[] iArr2 = this.f3852b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f3853c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f3852b = iArr;
            this.f3853c = objArr2;
        }
        int i6 = this.f3854d;
        if (i6 - i3 != 0) {
            int[] iArr3 = this.f3852b;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr4 = this.f3853c;
            System.arraycopy(objArr4, i3, objArr4, i7, this.f3854d - i3);
        }
        this.f3852b[i3] = i2;
        this.f3853c[i3] = obj;
        this.f3854d++;
    }

    public int i() {
        if (this.f3851a) {
            d();
        }
        return this.f3854d;
    }

    public Object j(int i2) {
        if (this.f3851a) {
            d();
        }
        return this.f3853c[i2];
    }

    public String toString() {
        if (i() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f3854d * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f3854d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(g(i2));
            sb.append('=');
            Object objJ = j(i2);
            if (objJ != this) {
                sb.append(objJ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C0214h(int i2) {
        this.f3851a = false;
        if (i2 == 0) {
            this.f3852b = AbstractC0209c.f3812a;
            this.f3853c = AbstractC0209c.f3814c;
        } else {
            int iE = AbstractC0209c.e(i2);
            this.f3852b = new int[iE];
            this.f3853c = new Object[iE];
        }
    }
}
