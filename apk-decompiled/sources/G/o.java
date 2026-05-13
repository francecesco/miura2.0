package G;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class o implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iL = L.b.l(parcel);
        int iH = 0;
        PendingIntent pendingIntent = null;
        String strB = null;
        int iH2 = 0;
        while (parcel.dataPosition() < iL) {
            int iG = L.b.g(parcel);
            int iE = L.b.e(iG);
            if (iE == 1) {
                iH = L.b.h(parcel, iG);
            } else if (iE == 2) {
                iH2 = L.b.h(parcel, iG);
            } else if (iE == 3) {
                pendingIntent = (PendingIntent) L.b.a(parcel, iG, PendingIntent.CREATOR);
            } else if (iE != 4) {
                L.b.k(parcel, iG);
            } else {
                strB = L.b.b(parcel, iG);
            }
        }
        L.b.d(parcel, iL);
        return new a(iH, iH2, pendingIntent, strB);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new a[i2];
    }
}
