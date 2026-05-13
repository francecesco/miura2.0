package y;

import androidx.lifecycle.A;
import androidx.lifecycle.B;
import androidx.lifecycle.z;
import q0.f;

/* JADX INFO: renamed from: y.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0273b implements A.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0276e[] f4096a;

    public C0273b(C0276e... c0276eArr) {
        f.e(c0276eArr, "initializers");
        this.f4096a = c0276eArr;
    }

    @Override // androidx.lifecycle.A.b
    public /* synthetic */ z a(Class cls) {
        return B.a(this, cls);
    }

    @Override // androidx.lifecycle.A.b
    public z b(Class cls, AbstractC0272a abstractC0272a) {
        f.e(cls, "modelClass");
        f.e(abstractC0272a, "extras");
        z zVar = null;
        for (C0276e c0276e : this.f4096a) {
            if (f.a(c0276e.a(), cls)) {
                Object objB = c0276e.b().b(abstractC0272a);
                zVar = objB instanceof z ? (z) objB : null;
            }
        }
        if (zVar != null) {
            return zVar;
        }
        throw new IllegalArgumentException("No initializer set for given class " + cls.getName());
    }
}
