package j;

import j.C0206b;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: j.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0205a extends C0206b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap f3770e = new HashMap();

    @Override // j.C0206b
    protected C0206b.c b(Object obj) {
        return (C0206b.c) this.f3770e.get(obj);
    }

    public boolean contains(Object obj) {
        return this.f3770e.containsKey(obj);
    }

    @Override // j.C0206b
    public Object f(Object obj, Object obj2) {
        C0206b.c cVarB = b(obj);
        if (cVarB != null) {
            return cVarB.f3776b;
        }
        this.f3770e.put(obj, e(obj, obj2));
        return null;
    }

    @Override // j.C0206b
    public Object g(Object obj) {
        Object objG = super.g(obj);
        this.f3770e.remove(obj);
        return objG;
    }

    public Map.Entry h(Object obj) {
        if (contains(obj)) {
            return ((C0206b.c) this.f3770e.get(obj)).f3778d;
        }
        return null;
    }
}
