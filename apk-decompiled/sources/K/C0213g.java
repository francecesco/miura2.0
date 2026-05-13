package k;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: renamed from: k.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0213g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static Object[] f3843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static int f3844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static Object[] f3845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static int f3846g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int[] f3847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object[] f3848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f3849c;

    public C0213g() {
        this.f3847a = AbstractC0209c.f3812a;
        this.f3848b = AbstractC0209c.f3814c;
        this.f3849c = 0;
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (C0213g.class) {
                try {
                    Object[] objArr = f3845f;
                    if (objArr != null) {
                        this.f3848b = objArr;
                        f3845f = (Object[]) objArr[0];
                        this.f3847a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f3846g--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i2 == 4) {
            synchronized (C0213g.class) {
                try {
                    Object[] objArr2 = f3843d;
                    if (objArr2 != null) {
                        this.f3848b = objArr2;
                        f3843d = (Object[]) objArr2[0];
                        this.f3847a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f3844e--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f3847a = new int[i2];
        this.f3848b = new Object[i2 << 1];
    }

    private static int b(int[] iArr, int i2, int i3) {
        try {
            return AbstractC0209c.a(iArr, i2, i3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (C0213g.class) {
                try {
                    if (f3846g < 10) {
                        objArr[0] = f3845f;
                        objArr[1] = iArr;
                        for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        f3845f = objArr;
                        f3846g++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C0213g.class) {
                try {
                    if (f3844e < 10) {
                        objArr[0] = f3843d;
                        objArr[1] = iArr;
                        for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        f3843d = objArr;
                        f3844e++;
                    }
                } finally {
                }
            }
        }
    }

    public void c(int i2) {
        int i3 = this.f3849c;
        int[] iArr = this.f3847a;
        if (iArr.length < i2) {
            Object[] objArr = this.f3848b;
            a(i2);
            if (this.f3849c > 0) {
                System.arraycopy(iArr, 0, this.f3847a, 0, i3);
                System.arraycopy(objArr, 0, this.f3848b, 0, i3 << 1);
            }
            d(iArr, objArr, i3);
        }
        if (this.f3849c != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i2 = this.f3849c;
        if (i2 > 0) {
            int[] iArr = this.f3847a;
            Object[] objArr = this.f3848b;
            this.f3847a = AbstractC0209c.f3812a;
            this.f3848b = AbstractC0209c.f3814c;
            this.f3849c = 0;
            d(iArr, objArr, i2);
        }
        if (this.f3849c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    int e(Object obj, int i2) {
        int i3 = this.f3849c;
        if (i3 == 0) {
            return -1;
        }
        int iB = b(this.f3847a, i3, i2);
        if (iB < 0 || obj.equals(this.f3848b[iB << 1])) {
            return iB;
        }
        int i4 = iB + 1;
        while (i4 < i3 && this.f3847a[i4] == i2) {
            if (obj.equals(this.f3848b[i4 << 1])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iB - 1; i5 >= 0 && this.f3847a[i5] == i2; i5--) {
            if (obj.equals(this.f3848b[i5 << 1])) {
                return i5;
            }
        }
        return ~i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0213g) {
            C0213g c0213g = (C0213g) obj;
            if (size() != c0213g.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f3849c; i2++) {
                try {
                    Object objI = i(i2);
                    Object objL = l(i2);
                    Object obj2 = c0213g.get(objI);
                    if (objL == null) {
                        if (obj2 != null || !c0213g.containsKey(objI)) {
                            return false;
                        }
                    } else if (!objL.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.f3849c; i3++) {
                try {
                    Object objI2 = i(i3);
                    Object objL2 = l(i3);
                    Object obj3 = map.get(objI2);
                    if (objL2 == null) {
                        if (obj3 != null || !map.containsKey(objI2)) {
                            return false;
                        }
                    } else if (!objL2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    int g() {
        int i2 = this.f3849c;
        if (i2 == 0) {
            return -1;
        }
        int iB = b(this.f3847a, i2, 0);
        if (iB < 0 || this.f3848b[iB << 1] == null) {
            return iB;
        }
        int i3 = iB + 1;
        while (i3 < i2 && this.f3847a[i3] == 0) {
            if (this.f3848b[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iB - 1; i4 >= 0 && this.f3847a[i4] == 0; i4--) {
            if (this.f3848b[i4 << 1] == null) {
                return i4;
            }
        }
        return ~i3;
    }

    public Object get(Object obj) {
        return getOrDefault(obj, null);
    }

    public Object getOrDefault(Object obj, Object obj2) {
        int iF = f(obj);
        return iF >= 0 ? this.f3848b[(iF << 1) + 1] : obj2;
    }

    int h(Object obj) {
        int i2 = this.f3849c * 2;
        Object[] objArr = this.f3848b;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f3847a;
        Object[] objArr = this.f3848b;
        int i2 = this.f3849c;
        int i3 = 1;
        int i4 = 0;
        int iHashCode = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return iHashCode;
    }

    public Object i(int i2) {
        return this.f3848b[i2 << 1];
    }

    public boolean isEmpty() {
        return this.f3849c <= 0;
    }

    public Object j(int i2) {
        Object[] objArr = this.f3848b;
        int i3 = i2 << 1;
        Object obj = objArr[i3 + 1];
        int i4 = this.f3849c;
        int i5 = 0;
        if (i4 <= 1) {
            d(this.f3847a, objArr, i4);
            this.f3847a = AbstractC0209c.f3812a;
            this.f3848b = AbstractC0209c.f3814c;
        } else {
            int i6 = i4 - 1;
            int[] iArr = this.f3847a;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i2 < i6) {
                    int i7 = i2 + 1;
                    int i8 = i6 - i2;
                    System.arraycopy(iArr, i7, iArr, i2, i8);
                    Object[] objArr2 = this.f3848b;
                    System.arraycopy(objArr2, i7 << 1, objArr2, i3, i8 << 1);
                }
                Object[] objArr3 = this.f3848b;
                int i9 = i6 << 1;
                objArr3[i9] = null;
                objArr3[i9 + 1] = null;
            } else {
                a(i4 > 8 ? i4 + (i4 >> 1) : 8);
                if (i4 != this.f3849c) {
                    throw new ConcurrentModificationException();
                }
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.f3847a, 0, i2);
                    System.arraycopy(objArr, 0, this.f3848b, 0, i3);
                }
                if (i2 < i6) {
                    int i10 = i2 + 1;
                    int i11 = i6 - i2;
                    System.arraycopy(iArr, i10, this.f3847a, i2, i11);
                    System.arraycopy(objArr, i10 << 1, this.f3848b, i3, i11 << 1);
                }
            }
            i5 = i6;
        }
        if (i4 != this.f3849c) {
            throw new ConcurrentModificationException();
        }
        this.f3849c = i5;
        return obj;
    }

    public Object k(int i2, Object obj) {
        int i3 = (i2 << 1) + 1;
        Object[] objArr = this.f3848b;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        return obj2;
    }

    public Object l(int i2) {
        return this.f3848b[(i2 << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i2;
        int iE;
        int i3 = this.f3849c;
        if (obj == null) {
            iE = g();
            i2 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i2 = iHashCode;
            iE = e(obj, iHashCode);
        }
        if (iE >= 0) {
            int i4 = (iE << 1) + 1;
            Object[] objArr = this.f3848b;
            Object obj3 = objArr[i4];
            objArr[i4] = obj2;
            return obj3;
        }
        int i5 = ~iE;
        int[] iArr = this.f3847a;
        if (i3 >= iArr.length) {
            int i6 = 8;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i6 = 4;
            }
            Object[] objArr2 = this.f3848b;
            a(i6);
            if (i3 != this.f3849c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f3847a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f3848b, 0, objArr2.length);
            }
            d(iArr, objArr2, i3);
        }
        if (i5 < i3) {
            int[] iArr3 = this.f3847a;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr3 = this.f3848b;
            System.arraycopy(objArr3, i5 << 1, objArr3, i7 << 1, (this.f3849c - i5) << 1);
        }
        int i8 = this.f3849c;
        if (i3 == i8) {
            int[] iArr4 = this.f3847a;
            if (i5 < iArr4.length) {
                iArr4[i5] = i2;
                Object[] objArr4 = this.f3848b;
                int i9 = i5 << 1;
                objArr4[i9] = obj;
                objArr4[i9 + 1] = obj2;
                this.f3849c = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int iF = f(obj);
        if (iF >= 0) {
            return j(iF);
        }
        return null;
    }

    public Object replace(Object obj, Object obj2) {
        int iF = f(obj);
        if (iF >= 0) {
            return k(iF, obj2);
        }
        return null;
    }

    public int size() {
        return this.f3849c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f3849c * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f3849c; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object objI = i(i2);
            if (objI != this) {
                sb.append(objI);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objL = l(i2);
            if (objL != this) {
                sb.append(objL);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C0213g(int i2) {
        if (i2 == 0) {
            this.f3847a = AbstractC0209c.f3812a;
            this.f3848b = AbstractC0209c.f3814c;
        } else {
            a(i2);
        }
        this.f3849c = 0;
    }

    public boolean remove(Object obj, Object obj2) {
        int iF = f(obj);
        if (iF < 0) {
            return false;
        }
        Object objL = l(iF);
        if (obj2 != objL && (obj2 == null || !obj2.equals(objL))) {
            return false;
        }
        j(iF);
        return true;
    }

    public boolean replace(Object obj, Object obj2, Object obj3) {
        int iF = f(obj);
        if (iF < 0) {
            return false;
        }
        Object objL = l(iF);
        if (objL != obj2 && (obj2 == null || !obj2.equals(objL))) {
            return false;
        }
        k(iF, obj3);
        return true;
    }
}
