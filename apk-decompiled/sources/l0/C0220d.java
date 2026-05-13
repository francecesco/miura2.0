package l0;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: l0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0220d extends AbstractC0219c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f3863d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object[] f3864e = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object[] f3866b = f3864e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3867c;

    /* JADX INFO: renamed from: l0.d$a */
    public static final class a {
        private a() {
        }

        public final int a(int i2, int i3) {
            int i4 = i2 + (i2 >> 1);
            if (i4 - i3 < 0) {
                i4 = i3;
            }
            return i4 - 2147483639 > 0 ? i3 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i4;
        }

        public /* synthetic */ a(q0.d dVar) {
            this();
        }
    }

    private final void c(int i2, Collection collection) {
        Iterator it2 = collection.iterator();
        int length = this.f3866b.length;
        while (i2 < length && it2.hasNext()) {
            this.f3866b[i2] = it2.next();
            i2++;
        }
        int i3 = this.f3865a;
        for (int i4 = 0; i4 < i3 && it2.hasNext(); i4++) {
            this.f3866b[i4] = it2.next();
        }
        this.f3867c = size() + collection.size();
    }

    private final void d(int i2) {
        Object[] objArr = new Object[i2];
        Object[] objArr2 = this.f3866b;
        AbstractC0224h.c(objArr2, objArr, 0, this.f3865a, objArr2.length);
        Object[] objArr3 = this.f3866b;
        int length = objArr3.length;
        int i3 = this.f3865a;
        AbstractC0224h.c(objArr3, objArr, length - i3, 0, i3);
        this.f3865a = 0;
        this.f3866b = objArr;
    }

    private final int e(int i2) {
        return i2 == 0 ? AbstractC0225i.h(this.f3866b) : i2 - 1;
    }

    private final void f(int i2) {
        if (i2 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f3866b;
        if (i2 <= objArr.length) {
            return;
        }
        if (objArr == f3864e) {
            this.f3866b = new Object[r0.d.a(i2, 10)];
        } else {
            d(f3863d.a(objArr.length, i2));
        }
    }

    private final int g(int i2) {
        if (i2 == AbstractC0225i.h(this.f3866b)) {
            return 0;
        }
        return i2 + 1;
    }

    private final int h(int i2) {
        return i2 < 0 ? i2 + this.f3866b.length : i2;
    }

    private final int i(int i2) {
        Object[] objArr = this.f3866b;
        return i2 >= objArr.length ? i2 - objArr.length : i2;
    }

    @Override // l0.AbstractC0219c
    public int a() {
        return this.f3867c;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i2, Object obj) {
        AbstractC0218b.f3862a.b(i2, size());
        if (i2 == size()) {
            addLast(obj);
            return;
        }
        if (i2 == 0) {
            addFirst(obj);
            return;
        }
        f(size() + 1);
        int i3 = i(this.f3865a + i2);
        if (i2 < ((size() + 1) >> 1)) {
            int iE = e(i3);
            int iE2 = e(this.f3865a);
            int i4 = this.f3865a;
            if (iE >= i4) {
                Object[] objArr = this.f3866b;
                objArr[iE2] = objArr[i4];
                AbstractC0224h.c(objArr, objArr, i4, i4 + 1, iE + 1);
            } else {
                Object[] objArr2 = this.f3866b;
                AbstractC0224h.c(objArr2, objArr2, i4 - 1, i4, objArr2.length);
                Object[] objArr3 = this.f3866b;
                objArr3[objArr3.length - 1] = objArr3[0];
                AbstractC0224h.c(objArr3, objArr3, 0, 1, iE + 1);
            }
            this.f3866b[iE] = obj;
            this.f3865a = iE2;
        } else {
            int i5 = i(this.f3865a + size());
            Object[] objArr4 = this.f3866b;
            if (i3 < i5) {
                AbstractC0224h.c(objArr4, objArr4, i3 + 1, i3, i5);
            } else {
                AbstractC0224h.c(objArr4, objArr4, 1, 0, i5);
                Object[] objArr5 = this.f3866b;
                objArr5[0] = objArr5[objArr5.length - 1];
                AbstractC0224h.c(objArr5, objArr5, i3 + 1, i3, objArr5.length - 1);
            }
            this.f3866b[i3] = obj;
        }
        this.f3867c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i2, Collection collection) {
        q0.f.e(collection, "elements");
        AbstractC0218b.f3862a.b(i2, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i2 == size()) {
            return addAll(collection);
        }
        f(size() + collection.size());
        int i3 = i(this.f3865a + size());
        int i4 = i(this.f3865a + i2);
        int size = collection.size();
        if (i2 < ((size() + 1) >> 1)) {
            int i5 = this.f3865a;
            int length = i5 - size;
            if (i4 < i5) {
                Object[] objArr = this.f3866b;
                AbstractC0224h.c(objArr, objArr, length, i5, objArr.length);
                Object[] objArr2 = this.f3866b;
                if (size >= i4) {
                    AbstractC0224h.c(objArr2, objArr2, objArr2.length - size, 0, i4);
                } else {
                    AbstractC0224h.c(objArr2, objArr2, objArr2.length - size, 0, size);
                    Object[] objArr3 = this.f3866b;
                    AbstractC0224h.c(objArr3, objArr3, 0, size, i4);
                }
            } else if (length >= 0) {
                Object[] objArr4 = this.f3866b;
                AbstractC0224h.c(objArr4, objArr4, length, i5, i4);
            } else {
                Object[] objArr5 = this.f3866b;
                length += objArr5.length;
                int i6 = i4 - i5;
                int length2 = objArr5.length - length;
                if (length2 >= i6) {
                    AbstractC0224h.c(objArr5, objArr5, length, i5, i4);
                } else {
                    AbstractC0224h.c(objArr5, objArr5, length, i5, i5 + length2);
                    Object[] objArr6 = this.f3866b;
                    AbstractC0224h.c(objArr6, objArr6, 0, this.f3865a + length2, i4);
                }
            }
            this.f3865a = length;
            c(h(i4 - size), collection);
        } else {
            int length3 = i4 + size;
            if (i4 < i3) {
                int i7 = size + i3;
                Object[] objArr7 = this.f3866b;
                if (i7 <= objArr7.length) {
                    AbstractC0224h.c(objArr7, objArr7, length3, i4, i3);
                } else if (length3 >= objArr7.length) {
                    length3 -= objArr7.length;
                    AbstractC0224h.c(objArr7, objArr7, length3, i4, i3);
                } else {
                    int length4 = i3 - (i7 - objArr7.length);
                    AbstractC0224h.c(objArr7, objArr7, 0, length4, i3);
                    Object[] objArr8 = this.f3866b;
                    AbstractC0224h.c(objArr8, objArr8, length3, i4, length4);
                }
            } else {
                Object[] objArr9 = this.f3866b;
                AbstractC0224h.c(objArr9, objArr9, size, 0, i3);
                Object[] objArr10 = this.f3866b;
                if (length3 >= objArr10.length) {
                    AbstractC0224h.c(objArr10, objArr10, length3 - objArr10.length, i4, objArr10.length);
                } else {
                    AbstractC0224h.c(objArr10, objArr10, 0, objArr10.length - size, objArr10.length);
                    Object[] objArr11 = this.f3866b;
                    AbstractC0224h.c(objArr11, objArr11, length3, i4, objArr11.length - size);
                }
            }
            c(i4, collection);
        }
        return true;
    }

    public final void addFirst(Object obj) {
        f(size() + 1);
        int iE = e(this.f3865a);
        this.f3865a = iE;
        this.f3866b[iE] = obj;
        this.f3867c = size() + 1;
    }

    public final void addLast(Object obj) {
        f(size() + 1);
        this.f3866b[i(this.f3865a + size())] = obj;
        this.f3867c = size() + 1;
    }

    @Override // l0.AbstractC0219c
    public Object b(int i2) {
        AbstractC0218b.f3862a.a(i2, size());
        if (i2 == m.c(this)) {
            return removeLast();
        }
        if (i2 == 0) {
            return removeFirst();
        }
        int i3 = i(this.f3865a + i2);
        Object obj = this.f3866b[i3];
        if (i2 < (size() >> 1)) {
            int i4 = this.f3865a;
            if (i3 >= i4) {
                Object[] objArr = this.f3866b;
                AbstractC0224h.c(objArr, objArr, i4 + 1, i4, i3);
            } else {
                Object[] objArr2 = this.f3866b;
                AbstractC0224h.c(objArr2, objArr2, 1, 0, i3);
                Object[] objArr3 = this.f3866b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i5 = this.f3865a;
                AbstractC0224h.c(objArr3, objArr3, i5 + 1, i5, objArr3.length - 1);
            }
            Object[] objArr4 = this.f3866b;
            int i6 = this.f3865a;
            objArr4[i6] = null;
            this.f3865a = g(i6);
        } else {
            int i7 = i(this.f3865a + m.c(this));
            Object[] objArr5 = this.f3866b;
            if (i3 <= i7) {
                AbstractC0224h.c(objArr5, objArr5, i3, i3 + 1, i7 + 1);
            } else {
                AbstractC0224h.c(objArr5, objArr5, i3, i3 + 1, objArr5.length);
                Object[] objArr6 = this.f3866b;
                objArr6[objArr6.length - 1] = objArr6[0];
                AbstractC0224h.c(objArr6, objArr6, 0, 1, i7 + 1);
            }
            this.f3866b[i7] = null;
        }
        this.f3867c = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int i2 = i(this.f3865a + size());
        int i3 = this.f3865a;
        if (i3 < i2) {
            AbstractC0224h.e(this.f3866b, null, i3, i2);
        } else if (!isEmpty()) {
            Object[] objArr = this.f3866b;
            AbstractC0224h.e(objArr, null, this.f3865a, objArr.length);
            AbstractC0224h.e(this.f3866b, null, 0, i2);
        }
        this.f3865a = 0;
        this.f3867c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i2) {
        AbstractC0218b.f3862a.a(i2, size());
        return this.f3866b[i(this.f3865a + i2)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i2 = i(this.f3865a + size());
        int length = this.f3865a;
        if (length < i2) {
            while (length < i2) {
                if (!q0.f.a(obj, this.f3866b[length])) {
                    length++;
                }
            }
            return -1;
        }
        if (length < i2) {
            return -1;
        }
        int length2 = this.f3866b.length;
        while (true) {
            if (length >= length2) {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (q0.f.a(obj, this.f3866b[i3])) {
                        length = i3 + this.f3866b.length;
                    }
                }
                return -1;
            }
            if (q0.f.a(obj, this.f3866b[length])) {
                break;
            }
            length++;
        }
        return length - this.f3865a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iH;
        int i2 = i(this.f3865a + size());
        int i3 = this.f3865a;
        if (i3 < i2) {
            iH = i2 - 1;
            if (i3 <= iH) {
                while (!q0.f.a(obj, this.f3866b[iH])) {
                    if (iH != i3) {
                        iH--;
                    }
                }
                return iH - this.f3865a;
            }
            return -1;
        }
        if (i3 > i2) {
            int i4 = i2 - 1;
            while (true) {
                if (-1 >= i4) {
                    iH = AbstractC0225i.h(this.f3866b);
                    int i5 = this.f3865a;
                    if (i5 <= iH) {
                        while (!q0.f.a(obj, this.f3866b[iH])) {
                            if (iH != i5) {
                                iH--;
                            }
                        }
                    }
                } else {
                    if (q0.f.a(obj, this.f3866b[i4])) {
                        iH = i4 + this.f3866b.length;
                        break;
                    }
                    i4--;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        int i2;
        q0.f.e(collection, "elements");
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty() && this.f3866b.length != 0) {
            int i3 = i(this.f3865a + size());
            int i4 = this.f3865a;
            if (i4 < i3) {
                i2 = i4;
                while (i4 < i3) {
                    Object obj = this.f3866b[i4];
                    if (!collection.contains(obj)) {
                        this.f3866b[i2] = obj;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i4++;
                }
                AbstractC0224h.e(this.f3866b, null, i2, i3);
            } else {
                int length = this.f3866b.length;
                int i5 = i4;
                boolean z3 = false;
                while (i4 < length) {
                    Object[] objArr = this.f3866b;
                    Object obj2 = objArr[i4];
                    objArr[i4] = null;
                    if (!collection.contains(obj2)) {
                        this.f3866b[i5] = obj2;
                        i5++;
                    } else {
                        z3 = true;
                    }
                    i4++;
                }
                i2 = i(i5);
                for (int i6 = 0; i6 < i3; i6++) {
                    Object[] objArr2 = this.f3866b;
                    Object obj3 = objArr2[i6];
                    objArr2[i6] = null;
                    if (!collection.contains(obj3)) {
                        this.f3866b[i2] = obj3;
                        i2 = g(i2);
                    } else {
                        z3 = true;
                    }
                }
                z2 = z3;
            }
            if (z2) {
                this.f3867c = h(i2 - this.f3865a);
            }
        }
        return z2;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.f3866b;
        int i2 = this.f3865a;
        Object obj = objArr[i2];
        objArr[i2] = null;
        this.f3865a = g(i2);
        this.f3867c = size() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int i2 = i(this.f3865a + m.c(this));
        Object[] objArr = this.f3866b;
        Object obj = objArr[i2];
        objArr[i2] = null;
        this.f3867c = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection collection) {
        int i2;
        q0.f.e(collection, "elements");
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty() && this.f3866b.length != 0) {
            int i3 = i(this.f3865a + size());
            int i4 = this.f3865a;
            if (i4 < i3) {
                i2 = i4;
                while (i4 < i3) {
                    Object obj = this.f3866b[i4];
                    if (collection.contains(obj)) {
                        this.f3866b[i2] = obj;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i4++;
                }
                AbstractC0224h.e(this.f3866b, null, i2, i3);
            } else {
                int length = this.f3866b.length;
                int i5 = i4;
                boolean z3 = false;
                while (i4 < length) {
                    Object[] objArr = this.f3866b;
                    Object obj2 = objArr[i4];
                    objArr[i4] = null;
                    if (collection.contains(obj2)) {
                        this.f3866b[i5] = obj2;
                        i5++;
                    } else {
                        z3 = true;
                    }
                    i4++;
                }
                i2 = i(i5);
                for (int i6 = 0; i6 < i3; i6++) {
                    Object[] objArr2 = this.f3866b;
                    Object obj3 = objArr2[i6];
                    objArr2[i6] = null;
                    if (collection.contains(obj3)) {
                        this.f3866b[i2] = obj3;
                        i2 = g(i2);
                    } else {
                        z3 = true;
                    }
                }
                z2 = z3;
            }
            if (z2) {
                this.f3867c = h(i2 - this.f3865a);
            }
        }
        return z2;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i2, Object obj) {
        AbstractC0218b.f3862a.a(i2, size());
        int i3 = i(this.f3865a + i2);
        Object[] objArr = this.f3866b;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        q0.f.e(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        f(size() + collection.size());
        c(i(this.f3865a + size()), collection);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        q0.f.e(objArr, "array");
        if (objArr.length < size()) {
            objArr = AbstractC0222f.a(objArr, size());
        }
        int i2 = i(this.f3865a + size());
        int i3 = this.f3865a;
        if (i3 < i2) {
            AbstractC0224h.d(this.f3866b, objArr, 0, i3, i2, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f3866b;
            AbstractC0224h.c(objArr2, objArr, 0, this.f3865a, objArr2.length);
            Object[] objArr3 = this.f3866b;
            AbstractC0224h.c(objArr3, objArr, objArr3.length - this.f3865a, 0, i2);
        }
        if (objArr.length > size()) {
            objArr[size()] = null;
        }
        return objArr;
    }
}
