package j;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: j.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0206b implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    c f3771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f3772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakHashMap f3773c = new WeakHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3774d = 0;

    /* JADX INFO: renamed from: j.b$a */
    static class a extends e {
        a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // j.C0206b.e
        c b(c cVar) {
            return cVar.f3778d;
        }

        @Override // j.C0206b.e
        c c(c cVar) {
            return cVar.f3777c;
        }
    }

    /* JADX INFO: renamed from: j.b$b, reason: collision with other inner class name */
    private static class C0065b extends e {
        C0065b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // j.C0206b.e
        c b(c cVar) {
            return cVar.f3777c;
        }

        @Override // j.C0206b.e
        c c(c cVar) {
            return cVar.f3778d;
        }
    }

    /* JADX INFO: renamed from: j.b$c */
    static class c implements Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f3775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f3776b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        c f3777c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        c f3778d;

        c(Object obj, Object obj2) {
            this.f3775a = obj;
            this.f3776b = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f3775a.equals(cVar.f3775a) && this.f3776b.equals(cVar.f3776b);
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f3775a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f3776b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f3775a.hashCode() ^ this.f3776b.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f3775a + "=" + this.f3776b;
        }
    }

    /* JADX INFO: renamed from: j.b$d */
    public class d extends f implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private c f3779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f3780b = true;

        d() {
        }

        @Override // j.C0206b.f
        void a(c cVar) {
            c cVar2 = this.f3779a;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f3778d;
                this.f3779a = cVar3;
                this.f3780b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar;
            if (this.f3780b) {
                this.f3780b = false;
                cVar = C0206b.this.f3771a;
            } else {
                c cVar2 = this.f3779a;
                cVar = cVar2 != null ? cVar2.f3777c : null;
            }
            this.f3779a = cVar;
            return this.f3779a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f3780b) {
                return C0206b.this.f3771a != null;
            }
            c cVar = this.f3779a;
            return (cVar == null || cVar.f3777c == null) ? false : true;
        }
    }

    /* JADX INFO: renamed from: j.b$e */
    private static abstract class e extends f implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        c f3782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        c f3783b;

        e(c cVar, c cVar2) {
            this.f3782a = cVar2;
            this.f3783b = cVar;
        }

        private c e() {
            c cVar = this.f3783b;
            c cVar2 = this.f3782a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // j.C0206b.f
        public void a(c cVar) {
            if (this.f3782a == cVar && cVar == this.f3783b) {
                this.f3783b = null;
                this.f3782a = null;
            }
            c cVar2 = this.f3782a;
            if (cVar2 == cVar) {
                this.f3782a = b(cVar2);
            }
            if (this.f3783b == cVar) {
                this.f3783b = e();
            }
        }

        abstract c b(c cVar);

        abstract c c(c cVar);

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.f3783b;
            this.f3783b = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3783b != null;
        }
    }

    /* JADX INFO: renamed from: j.b$f */
    public static abstract class f {
        abstract void a(c cVar);
    }

    public Map.Entry a() {
        return this.f3771a;
    }

    protected c b(Object obj) {
        c cVar = this.f3771a;
        while (cVar != null && !cVar.f3775a.equals(obj)) {
            cVar = cVar.f3777c;
        }
        return cVar;
    }

    public d c() {
        d dVar = new d();
        this.f3773c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry d() {
        return this.f3772b;
    }

    public Iterator descendingIterator() {
        C0065b c0065b = new C0065b(this.f3772b, this.f3771a);
        this.f3773c.put(c0065b, Boolean.FALSE);
        return c0065b;
    }

    c e(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.f3774d++;
        c cVar2 = this.f3772b;
        if (cVar2 == null) {
            this.f3771a = cVar;
        } else {
            cVar2.f3777c = cVar;
            cVar.f3778d = cVar2;
        }
        this.f3772b = cVar;
        return cVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0206b)) {
            return false;
        }
        C0206b c0206b = (C0206b) obj;
        if (size() != c0206b.size()) {
            return false;
        }
        Iterator it2 = iterator();
        Iterator it3 = c0206b.iterator();
        while (it2.hasNext() && it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            Object next = it3.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it2.hasNext() || it3.hasNext()) ? false : true;
    }

    public Object f(Object obj, Object obj2) {
        c cVarB = b(obj);
        if (cVarB != null) {
            return cVarB.f3776b;
        }
        e(obj, obj2);
        return null;
    }

    public Object g(Object obj) {
        c cVarB = b(obj);
        if (cVarB == null) {
            return null;
        }
        this.f3774d--;
        if (!this.f3773c.isEmpty()) {
            Iterator it2 = this.f3773c.keySet().iterator();
            while (it2.hasNext()) {
                ((f) it2.next()).a(cVarB);
            }
        }
        c cVar = cVarB.f3778d;
        c cVar2 = cVarB.f3777c;
        if (cVar != null) {
            cVar.f3777c = cVar2;
        } else {
            this.f3771a = cVar2;
        }
        c cVar3 = cVarB.f3777c;
        if (cVar3 != null) {
            cVar3.f3778d = cVar;
        } else {
            this.f3772b = cVar;
        }
        cVarB.f3777c = null;
        cVarB.f3778d = null;
        return cVarB.f3776b;
    }

    public int hashCode() {
        Iterator it2 = iterator();
        int iHashCode = 0;
        while (it2.hasNext()) {
            iHashCode += ((Map.Entry) it2.next()).hashCode();
        }
        return iHashCode;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a(this.f3771a, this.f3772b);
        this.f3773c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f3774d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            sb.append(((Map.Entry) it2.next()).toString());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
