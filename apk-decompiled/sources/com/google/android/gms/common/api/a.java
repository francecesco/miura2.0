package com.google.android.gms.common.api;

import L.b;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iL = b.l(parcel);
        int iH = 0;
        String strB = null;
        PendingIntent pendingIntent = null;
        int iH2 = 0;
        while (parcel.dataPosition() < iL) {
            int iG = b.g(parcel);
            int iE = b.e(iG);
            if (iE == 1) {
                iH2 = b.h(parcel, iG);
            } else if (iE == 2) {
                strB = b.b(parcel, iG);
            } else if (iE == 3) {
                pendingIntent = (PendingIntent) b.a(parcel, iG, PendingIntent.CREATOR);
            } else if (iE != 1000) {
                b.k(parcel, iG);
            } else {
                iH = b.h(parcel, iG);
            }
        }
        b.d(parcel, iL);
        return new Status(iH, iH2, strB, pendingIntent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new Status[i2];
    }
}
