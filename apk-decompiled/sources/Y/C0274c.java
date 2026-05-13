package y;

import androidx.lifecycle.A;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p0.l;
import q0.f;

/* JADX INFO: renamed from: y.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0274c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f4097a = new ArrayList();

    public final void a(s0.a aVar, l lVar) {
        f.e(aVar, "clazz");
        f.e(lVar, "initializer");
        this.f4097a.add(new C0276e(o0.a.a(aVar), lVar));
    }

    public final A.b b() {
        C0276e[] c0276eArr = (C0276e[]) this.f4097a.toArray(new C0276e[0]);
        return new C0273b((C0276e[]) Arrays.copyOf(c0276eArr, c0276eArr.length));
    }
}
