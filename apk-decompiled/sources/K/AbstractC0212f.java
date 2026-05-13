package k;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: renamed from: k.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0212f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b f3828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    c f3829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    e f3830c;

    /* JADX INFO: renamed from: k.f$a */
    final class a implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f3831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3832b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f3833c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f3834d = false;

        a(int i2) {
            this.f3831a = i2;
            this.f3832b = AbstractC0212f.this.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3833c < this.f3832b;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object objB = AbstractC0212f.this.b(this.f3833c, this.f3831a);
            this.f3833c++;
            this.f3834d = true;
            return objB;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f3834d) {
                throw new IllegalStateException();
            }
            int i2 = this.f3833c - 1;
            this.f3833c = i2;
            this.f3832b--;
            this.f3834d = false;
            AbstractC0212f.this.h(i2);
        }
    }

    /* JADX INFO: renamed from: k.f$b */
    final class b implements Set {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            int iD = AbstractC0212f.this.d();
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                AbstractC0212f.this.g(entry.getKey(), entry.getValue());
            }
            return iD != AbstractC0212f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            AbstractC0212f.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iE = AbstractC0212f.this.e(entry.getKey());
            if (iE < 0) {
                return false;
            }
            return AbstractC0209c.c(AbstractC0212f.this.b(iE, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!contains(it2.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return AbstractC0212f.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iD = AbstractC0212f.this.d() - 1; iD >= 0; iD--) {
                Object objB = AbstractC0212f.this.b(iD, 0);
                Object objB2 = AbstractC0212f.this.b(iD, 1);
                iHashCode += (objB == null ? 0 : objB.hashCode()) ^ (objB2 == null ? 0 : objB2.hashCode());
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return AbstractC0212f.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractC0212f.this.new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return AbstractC0212f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: renamed from: k.f$c */
    final class c implements Set {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            AbstractC0212f.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC0212f.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            return AbstractC0212f.j(AbstractC0212f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return AbstractC0212f.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iD = AbstractC0212f.this.d() - 1; iD >= 0; iD--) {
                Object objB = AbstractC0212f.this.b(iD, 0);
                iHashCode += objB == null ? 0 : objB.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return AbstractC0212f.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractC0212f.this.new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iE = AbstractC0212f.this.e(obj);
            if (iE < 0) {
                return false;
            }
            AbstractC0212f.this.h(iE);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            return AbstractC0212f.o(AbstractC0212f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            return AbstractC0212f.p(AbstractC0212f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return AbstractC0212f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return AbstractC0212f.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return AbstractC0212f.this.r(objArr, 0);
        }
    }

    /* JADX INFO: renamed from: k.f$d */
    final class d implements Iterator, Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3838a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f3840c = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3839b = -1;

        d() {
            this.f3838a = AbstractC0212f.this.d() - 1;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f3839b++;
            this.f3840c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f3840c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return AbstractC0209c.c(entry.getKey(), AbstractC0212f.this.b(this.f3839b, 0)) && AbstractC0209c.c(entry.getValue(), AbstractC0212f.this.b(this.f3839b, 1));
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            if (this.f3840c) {
                return AbstractC0212f.this.b(this.f3839b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            if (this.f3840c) {
                return AbstractC0212f.this.b(this.f3839b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3839b < this.f3838a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f3840c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objB = AbstractC0212f.this.b(this.f3839b, 0);
            Object objB2 = AbstractC0212f.this.b(this.f3839b, 1);
            return (objB == null ? 0 : objB.hashCode()) ^ (objB2 != null ? objB2.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f3840c) {
                throw new IllegalStateException();
            }
            AbstractC0212f.this.h(this.f3839b);
            this.f3839b--;
            this.f3838a--;
            this.f3840c = false;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (this.f3840c) {
                return AbstractC0212f.this.i(this.f3839b, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* JADX INFO: renamed from: k.f$e */
    final class e implements Collection {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            AbstractC0212f.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC0212f.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!contains(it2.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return AbstractC0212f.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractC0212f.this.new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iF = AbstractC0212f.this.f(obj);
            if (iF < 0) {
                return false;
            }
            AbstractC0212f.this.h(iF);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection collection) {
            int iD = AbstractC0212f.this.d();
            int i2 = 0;
            boolean z2 = false;
            while (i2 < iD) {
                if (collection.contains(AbstractC0212f.this.b(i2, 1))) {
                    AbstractC0212f.this.h(i2);
                    i2--;
                    iD--;
                    z2 = true;
                }
                i2++;
            }
            return z2;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection collection) {
            int iD = AbstractC0212f.this.d();
            int i2 = 0;
            boolean z2 = false;
            while (i2 < iD) {
                if (!collection.contains(AbstractC0212f.this.b(i2, 1))) {
                    AbstractC0212f.this.h(i2);
                    i2--;
                    iD--;
                    z2 = true;
                }
                i2++;
            }
            return z2;
        }

        @Override // java.util.Collection
        public int size() {
            return AbstractC0212f.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return AbstractC0212f.this.q(1);
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return AbstractC0212f.this.r(objArr, 1);
        }
    }

    AbstractC0212f() {
    }

    public static boolean j(Map map, Collection collection) {
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            if (!map.containsKey(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean o(Map map, Collection collection) {
        int size = map.size();
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            map.remove(it2.next());
        }
        return size != map.size();
    }

    public static boolean p(Map map, Collection collection) {
        int size = map.size();
        Iterator it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            if (!collection.contains(it2.next())) {
                it2.remove();
            }
        }
        return size != map.size();
    }

    protected abstract void a();

    protected abstract Object b(int i2, int i3);

    protected abstract Map c();

    protected abstract int d();

    protected abstract int e(Object obj);

    protected abstract int f(Object obj);

    protected abstract void g(Object obj, Object obj2);

    protected abstract void h(int i2);

    protected abstract Object i(int i2, Object obj);

    public Set l() {
        if (this.f3828a == null) {
            this.f3828a = new b();
        }
        return this.f3828a;
    }

    public Set m() {
        if (this.f3829b == null) {
            this.f3829b = new c();
        }
        return this.f3829b;
    }

    public Collection n() {
        if (this.f3830c == null) {
            this.f3830c = new e();
        }
        return this.f3830c;
    }

    public Object[] q(int i2) {
        int iD = d();
        Object[] objArr = new Object[iD];
        for (int i3 = 0; i3 < iD; i3++) {
            objArr[i3] = b(i3, i2);
        }
        return objArr;
    }

    public Object[] r(Object[] objArr, int i2) {
        int iD = d();
        if (objArr.length < iD) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), iD);
        }
        for (int i3 = 0; i3 < iD; i3++) {
            objArr[i3] = b(i3, i2);
        }
        if (objArr.length > iD) {
            objArr[iD] = null;
        }
        return objArr;
    }
}
