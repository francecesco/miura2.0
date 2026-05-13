package l0;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: l0.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0224h extends AbstractC0223g {
    public static final List b(Object[] objArr) {
        q0.f.e(objArr, "<this>");
        List listA = AbstractC0226j.a(objArr);
        q0.f.d(listA, "asList(this)");
        return listA;
    }

    public static final Object[] c(Object[] objArr, Object[] objArr2, int i2, int i3, int i4) {
        q0.f.e(objArr, "<this>");
        q0.f.e(objArr2, "destination");
        System.arraycopy(objArr, i3, objArr2, i2, i4 - i3);
        return objArr2;
    }

    public static /* synthetic */ Object[] d(Object[] objArr, Object[] objArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = objArr.length;
        }
        return c(objArr, objArr2, i2, i3, i4);
    }

    public static final void e(Object[] objArr, Object obj, int i2, int i3) {
        q0.f.e(objArr, "<this>");
        Arrays.fill(objArr, i2, i3, obj);
    }
}
