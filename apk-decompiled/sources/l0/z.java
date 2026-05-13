package l0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class z implements Iterator {
    public abstract int a();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
