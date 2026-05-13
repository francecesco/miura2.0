package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(androidx.versionedparcelable.a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2173a = aVar.p(iconCompat.f2173a, 1);
        iconCompat.f2175c = aVar.j(iconCompat.f2175c, 2);
        iconCompat.f2176d = aVar.r(iconCompat.f2176d, 3);
        iconCompat.f2177e = aVar.p(iconCompat.f2177e, 4);
        iconCompat.f2178f = aVar.p(iconCompat.f2178f, 5);
        iconCompat.f2179g = (ColorStateList) aVar.r(iconCompat.f2179g, 6);
        iconCompat.f2181i = aVar.t(iconCompat.f2181i, 7);
        iconCompat.f2182j = aVar.t(iconCompat.f2182j, 8);
        iconCompat.i();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(true, true);
        iconCompat.j(aVar.f());
        int i2 = iconCompat.f2173a;
        if (-1 != i2) {
            aVar.F(i2, 1);
        }
        byte[] bArr = iconCompat.f2175c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f2176d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i3 = iconCompat.f2177e;
        if (i3 != 0) {
            aVar.F(i3, 4);
        }
        int i4 = iconCompat.f2178f;
        if (i4 != 0) {
            aVar.F(i4, 5);
        }
        ColorStateList colorStateList = iconCompat.f2179g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f2181i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f2182j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
