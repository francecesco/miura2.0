package l0;

import java.util.AbstractList;
import java.util.List;

/* JADX INFO: renamed from: l0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0219c extends AbstractList implements List {
    protected AbstractC0219c() {
    }

    public abstract int a();

    public abstract Object b(int i2);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i2) {
        return b(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}
