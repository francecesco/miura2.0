package androidx.lifecycle;

import androidx.lifecycle.A;
import y.AbstractC0272a;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class B {
    public static z a(A.b bVar, Class cls) {
        q0.f.e(cls, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    public static z b(A.b bVar, Class cls, AbstractC0272a abstractC0272a) {
        q0.f.e(cls, "modelClass");
        q0.f.e(abstractC0272a, "extras");
        return bVar.a(cls);
    }
}
