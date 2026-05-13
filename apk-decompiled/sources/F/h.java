package F;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f22a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final f f23b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f24c;

    protected h(i iVar, O.c cVar) {
        K.e.f(iVar);
        this.f22a = iVar;
        this.f24c = new ArrayList();
        f fVar = new f(this, cVar);
        fVar.a();
        this.f23b = fVar;
    }
}
