package k;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: k.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0208b implements Collection, Set {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f3801e = new int[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object[] f3802f = new Object[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Object[] f3803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f3804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Object[] f3805i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f3806j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f3807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object[] f3808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f3809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AbstractC0212f f3810d;

    /* JADX INFO: renamed from: k.b$a */
    class a extends AbstractC0212f {
        a() {
        }

        @Override // k.AbstractC0212f
        protected void a() {
            C0208b.this.clear();
        }

        @Override // k.AbstractC0212f
        protected Object b(int i2, int i3) {
            return C0208b.this.f3808b[i2];
        }

        @Override // k.AbstractC0212f
        protected Map c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // k.AbstractC0212f
        protected int d() {
            return C0208b.this.f3809c;
        }

        @Override // k.AbstractC0212f
        protected int e(Object obj) {
            return C0208b.this.indexOf(obj);
        }

        @Override // k.AbstractC0212f
        protected int f(Object obj) {
            return C0208b.this.indexOf(obj);
        }

        @Override // k.AbstractC0212f
        protected void g(Object obj, Object obj2) {
            C0208b.this.add(obj);
        }

        @Override // k.AbstractC0212f
        protected void h(int i2) {
            C0208b.this.g(i2);
        }

        @Override // k.AbstractC0212f
        protected Object i(int i2, Object obj) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public C0208b() {
        this(0);
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (C0208b.class) {
                try {
                    Object[] objArr = f3805i;
                    if (objArr != null) {
                        this.f3808b = objArr;
                        f3805i = (Object[]) objArr[0];
                        this.f3807a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f3806j--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i2 == 4) {
            synchronized (C0208b.class) {
                try {
                    Object[] objArr2 = f3803g;
                    if (objArr2 != null) {
                        this.f3808b = objArr2;
                        f3803g = (Object[]) objArr2[0];
                        this.f3807a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f3804h--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f3807a = new int[i2];
        this.f3808b = new Object[i2];
    }

    private static void c(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (C0208b.class) {
                try {
                    if (f3806j < 10) {
                        objArr[0] = f3805i;
                        objArr[1] = iArr;
                        for (int i3 = i2 - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        f3805i = objArr;
                        f3806j++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C0208b.class) {
                try {
                    if (f3804h < 10) {
                        objArr[0] = f3803g;
                        objArr[1] = iArr;
                        for (int i4 = i2 - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        f3803g = objArr;
                        f3804h++;
                    }
                } finally {
                }
            }
        }
    }

    private AbstractC0212f d() {
        if (this.f3810d == null) {
            this.f3810d = new a();
        }
        return this.f3810d;
    }

    private int e(Object obj, int i2) {
        int i3 = this.f3809c;
        if (i3 == 0) {
            return -1;
        }
        int iA = AbstractC0209c.a(this.f3807a, i3, i2);
        if (iA < 0 || obj.equals(this.f3808b[iA])) {
            return iA;
        }
        int i4 = iA + 1;
        while (i4 < i3 && this.f3807a[i4] == i2) {
            if (obj.equals(this.f3808b[i4])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iA - 1; i5 >= 0 && this.f3807a[i5] == i2; i5--) {
            if (obj.equals(this.f3808b[i5])) {
                return i5;
            }
        }
        return ~i4;
    }

    private int f() {
        int i2 = this.f3809c;
        if (i2 == 0) {
            return -1;
        }
        int iA = AbstractC0209c.a(this.f3807a, i2, 0);
        if (iA < 0 || this.f3808b[iA] == null) {
            return iA;
        }
        int i3 = iA + 1;
        while (i3 < i2 && this.f3807a[i3] == 0) {
            if (this.f3808b[i3] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iA - 1; i4 >= 0 && this.f3807a[i4] == 0; i4--) {
            if (this.f3808b[i4] == null) {
                return i4;
            }
        }
        return ~i3;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i2;
        int iE;
        if (obj == null) {
            iE = f();
            i2 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i2 = iHashCode;
            iE = e(obj, iHashCode);
        }
        if (iE >= 0) {
            return false;
        }
        int i3 = ~iE;
        int i4 = this.f3809c;
        int[] iArr = this.f3807a;
        if (i4 >= iArr.length) {
            int i5 = 8;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 < 4) {
                i5 = 4;
            }
            Object[] objArr = this.f3808b;
            a(i5);
            int[] iArr2 = this.f3807a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f3808b, 0, objArr.length);
            }
            c(iArr, objArr, this.f3809c);
        }
        int i6 = this.f3809c;
        if (i3 < i6) {
            int[] iArr3 = this.f3807a;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.f3808b;
            System.arraycopy(objArr2, i3, objArr2, i7, this.f3809c - i3);
        }
        this.f3807a[i3] = i2;
        this.f3808b[i3] = obj;
        this.f3809c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        b(this.f3809c + collection.size());
        Iterator it2 = collection.iterator();
        boolean zAdd = false;
        while (it2.hasNext()) {
            zAdd |= add(it2.next());
        }
        return zAdd;
    }

    public void b(int i2) {
        int[] iArr = this.f3807a;
        if (iArr.length < i2) {
            Object[] objArr = this.f3808b;
            a(i2);
            int i3 = this.f3809c;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f3807a, 0, i3);
                System.arraycopy(objArr, 0, this.f3808b, 0, this.f3809c);
            }
            c(iArr, objArr, this.f3809c);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.f3809c;
        if (i2 != 0) {
            c(this.f3807a, this.f3808b, i2);
            this.f3807a = f3801e;
            this.f3808b = f3802f;
            this.f3809c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            if (!contains(it2.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f3809c; i2++) {
                try {
                    if (!set.contains(h(i2))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public Object g(int i2) {
        Object[] objArr = this.f3808b;
        Object obj = objArr[i2];
        int i3 = this.f3809c;
        if (i3 <= 1) {
            c(this.f3807a, objArr, i3);
            this.f3807a = f3801e;
            this.f3808b = f3802f;
            this.f3809c = 0;
        } else {
            int[] iArr = this.f3807a;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i4 = i3 - 1;
                this.f3809c = i4;
                if (i2 < i4) {
                    int i5 = i2 + 1;
                    System.arraycopy(iArr, i5, iArr, i2, i4 - i2);
                    Object[] objArr2 = this.f3808b;
                    System.arraycopy(objArr2, i5, objArr2, i2, this.f3809c - i2);
                }
                this.f3808b[this.f3809c] = null;
            } else {
                a(i3 > 8 ? i3 + (i3 >> 1) : 8);
                this.f3809c--;
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.f3807a, 0, i2);
                    System.arraycopy(objArr, 0, this.f3808b, 0, i2);
                }
                int i6 = this.f3809c;
                if (i2 < i6) {
                    int i7 = i2 + 1;
                    System.arraycopy(iArr, i7, this.f3807a, i2, i6 - i2);
                    System.arraycopy(objArr, i7, this.f3808b, i2, this.f3809c - i2);
                }
            }
        }
        return obj;
    }

    public Object h(int i2) {
        return this.f3808b[i2];
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f3807a;
        int i2 = this.f3809c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(Object obj) {
        return obj == null ? f() : e(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f3809c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return d().m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        g(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        Iterator it2 = collection.iterator();
        boolean zRemove = false;
        while (it2.hasNext()) {
            zRemove |= remove(it2.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        boolean z2 = false;
        for (int i2 = this.f3809c - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f3808b[i2])) {
                g(i2);
                z2 = true;
            }
        }
        return z2;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f3809c;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i2 = this.f3809c;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f3808b, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f3809c * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f3809c; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object objH = h(i2);
            if (objH != this) {
                sb.append(objH);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C0208b(int i2) {
        if (i2 == 0) {
            this.f3807a = f3801e;
            this.f3808b = f3802f;
        } else {
            a(i2);
        }
        this.f3809c = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f3809c) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f3809c);
        }
        System.arraycopy(this.f3808b, 0, objArr, 0, this.f3809c);
        int length = objArr.length;
        int i2 = this.f3809c;
        if (length > i2) {
            objArr[i2] = null;
        }
        return objArr;
    }
}
