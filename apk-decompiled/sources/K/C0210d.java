package k;

/* JADX INFO: renamed from: k.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0210d implements Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f3815e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long[] f3817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f3818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3819d;

    public C0210d() {
        this(10);
    }

    private void d() {
        int i2 = this.f3819d;
        long[] jArr = this.f3817b;
        Object[] objArr = this.f3818c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f3815e) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f3816a = false;
        this.f3819d = i3;
    }

    public void a(long j2, Object obj) {
        int i2 = this.f3819d;
        if (i2 != 0 && j2 <= this.f3817b[i2 - 1]) {
            h(j2, obj);
            return;
        }
        if (this.f3816a && i2 >= this.f3817b.length) {
            d();
        }
        int i3 = this.f3819d;
        if (i3 >= this.f3817b.length) {
            int iF = AbstractC0209c.f(i3 + 1);
            long[] jArr = new long[iF];
            Object[] objArr = new Object[iF];
            long[] jArr2 = this.f3817b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f3818c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f3817b = jArr;
            this.f3818c = objArr;
        }
        this.f3817b[i3] = j2;
        this.f3818c[i3] = obj;
        this.f3819d = i3 + 1;
    }

    public void b() {
        int i2 = this.f3819d;
        Object[] objArr = this.f3818c;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f3819d = 0;
        this.f3816a = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0210d clone() {
        try {
            C0210d c0210d = (C0210d) super.clone();
            c0210d.f3817b = (long[]) this.f3817b.clone();
            c0210d.f3818c = (Object[]) this.f3818c.clone();
            return c0210d;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public Object e(long j2) {
        return f(j2, null);
    }

    public Object f(long j2, Object obj) {
        Object obj2;
        int iB = AbstractC0209c.b(this.f3817b, this.f3819d, j2);
        return (iB < 0 || (obj2 = this.f3818c[iB]) == f3815e) ? obj : obj2;
    }

    public long g(int i2) {
        if (this.f3816a) {
            d();
        }
        return this.f3817b[i2];
    }

    public void h(long j2, Object obj) {
        int iB = AbstractC0209c.b(this.f3817b, this.f3819d, j2);
        if (iB >= 0) {
            this.f3818c[iB] = obj;
            return;
        }
        int i2 = ~iB;
        int i3 = this.f3819d;
        if (i2 < i3) {
            Object[] objArr = this.f3818c;
            if (objArr[i2] == f3815e) {
                this.f3817b[i2] = j2;
                objArr[i2] = obj;
                return;
            }
        }
        if (this.f3816a && i3 >= this.f3817b.length) {
            d();
            i2 = ~AbstractC0209c.b(this.f3817b, this.f3819d, j2);
        }
        int i4 = this.f3819d;
        if (i4 >= this.f3817b.length) {
            int iF = AbstractC0209c.f(i4 + 1);
            long[] jArr = new long[iF];
            Object[] objArr2 = new Object[iF];
            long[] jArr2 = this.f3817b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f3818c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f3817b = jArr;
            this.f3818c = objArr2;
        }
        int i5 = this.f3819d;
        if (i5 - i2 != 0) {
            long[] jArr3 = this.f3817b;
            int i6 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i6, i5 - i2);
            Object[] objArr4 = this.f3818c;
            System.arraycopy(objArr4, i2, objArr4, i6, this.f3819d - i2);
        }
        this.f3817b[i2] = j2;
        this.f3818c[i2] = obj;
        this.f3819d++;
    }

    public void i(long j2) {
        int iB = AbstractC0209c.b(this.f3817b, this.f3819d, j2);
        if (iB >= 0) {
            Object[] objArr = this.f3818c;
            Object obj = objArr[iB];
            Object obj2 = f3815e;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.f3816a = true;
            }
        }
    }

    public int j() {
        if (this.f3816a) {
            d();
        }
        return this.f3819d;
    }

    public Object k(int i2) {
        if (this.f3816a) {
            d();
        }
        return this.f3818c[i2];
    }

    public String toString() {
        if (j() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f3819d * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f3819d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(g(i2));
            sb.append('=');
            Object objK = k(i2);
            if (objK != this) {
                sb.append(objK);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C0210d(int i2) {
        this.f3816a = false;
        if (i2 == 0) {
            this.f3817b = AbstractC0209c.f3813b;
            this.f3818c = AbstractC0209c.f3814c;
        } else {
            int iF = AbstractC0209c.f(i2);
            this.f3817b = new long[iF];
            this.f3818c = new Object[iF];
        }
    }
}
