package k;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: k.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0207a extends C0213g implements Map {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    AbstractC0212f f3799h;

    /* JADX INFO: renamed from: k.a$a, reason: collision with other inner class name */
    class C0066a extends AbstractC0212f {
        C0066a() {
        }

        @Override // k.AbstractC0212f
        protected void a() {
            C0207a.this.clear();
        }

        @Override // k.AbstractC0212f
        protected Object b(int i2, int i3) {
            return C0207a.this.f3848b[(i2 << 1) + i3];
        }

        @Override // k.AbstractC0212f
        protected Map c() {
            return C0207a.this;
        }

        @Override // k.AbstractC0212f
        protected int d() {
            return C0207a.this.f3849c;
        }

        @Override // k.AbstractC0212f
        protected int e(Object obj) {
            return C0207a.this.f(obj);
        }

        @Override // k.AbstractC0212f
        protected int f(Object obj) {
            return C0207a.this.h(obj);
        }

        @Override // k.AbstractC0212f
        protected void g(Object obj, Object obj2) {
            C0207a.this.put(obj, obj2);
        }

        @Override // k.AbstractC0212f
        protected void h(int i2) {
            C0207a.this.j(i2);
        }

        @Override // k.AbstractC0212f
        protected Object i(int i2, Object obj) {
            return C0207a.this.k(i2, obj);
        }
    }

    public C0207a() {
    }

    private AbstractC0212f m() {
        if (this.f3799h == null) {
            this.f3799h = new C0066a();
        }
        return this.f3799h;
    }

    @Override // java.util.Map
    public Set entrySet() {
        return m().l();
    }

    @Override // java.util.Map
    public Set keySet() {
        return m().m();
    }

    public boolean n(Collection collection) {
        return AbstractC0212f.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        c(this.f3849c + map.size());
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection values() {
        return m().n();
    }

    public C0207a(int i2) {
        super(i2);
    }
}
