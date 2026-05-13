package G;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class p implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iL = L.b.l(parcel);
        String strB = null;
        int iH = 0;
        long jI = -1;
        while (parcel.dataPosition() < iL) {
            int iG = L.b.g(parcel);
            int iE = L.b.e(iG);
            if (iE == 1) {
                strB = L.b.b(parcel, iG);
            } else if (iE == 2) {
                iH = L.b.h(parcel, iG);
            } else if (iE != 3) {
                L.b.k(parcel, iG);
            } else {
                jI = L.b.i(parcel, iG);
            }
        }
        L.b.d(parcel, iL);
        return new c(strB, iH, jI);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new c[i2];
    }
}
