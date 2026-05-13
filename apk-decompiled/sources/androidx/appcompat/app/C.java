package androidx.appcompat.app;

import java.util.LinkedHashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
abstract class C {
    private static androidx.core.os.c a(androidx.core.os.c cVar, androidx.core.os.c cVar2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i2 = 0;
        while (i2 < cVar.g() + cVar2.g()) {
            Locale localeD = i2 < cVar.g() ? cVar.d(i2) : cVar2.d(i2 - cVar.g());
            if (localeD != null) {
                linkedHashSet.add(localeD);
            }
            i2++;
        }
        return androidx.core.os.c.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    static androidx.core.os.c b(androidx.core.os.c cVar, androidx.core.os.c cVar2) {
        return (cVar == null || cVar.f()) ? androidx.core.os.c.e() : a(cVar, cVar2);
    }
}
