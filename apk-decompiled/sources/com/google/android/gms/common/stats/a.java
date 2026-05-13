package com.google.android.gms.common.stats;

import L.b;
import android.os.Parcel;
import android.os.Parcelable;
import it.tervis.miura.model.Console;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iL = b.l(parcel);
        long jI = 0;
        long jI2 = 0;
        long jI3 = 0;
        String strB = null;
        ArrayList arrayListC = null;
        String strB2 = null;
        String strB3 = null;
        String strB4 = null;
        String strB5 = null;
        int iH = 0;
        int iH2 = 0;
        int iH3 = 0;
        int iH4 = 0;
        float f2 = 0.0f;
        while (parcel.dataPosition() < iL) {
            int iG = b.g(parcel);
            switch (b.e(iG)) {
                case 1:
                    iH = b.h(parcel, iG);
                    break;
                case 2:
                    jI = b.i(parcel, iG);
                    break;
                case 3:
                case Console.MAX_CONSOLE /* 7 */:
                case 9:
                default:
                    b.k(parcel, iG);
                    break;
                case 4:
                    strB = b.b(parcel, iG);
                    break;
                case 5:
                    iH3 = b.h(parcel, iG);
                    break;
                case 6:
                    arrayListC = b.c(parcel, iG);
                    break;
                case 8:
                    jI2 = b.i(parcel, iG);
                    break;
                case 10:
                    strB3 = b.b(parcel, iG);
                    break;
                case 11:
                    iH2 = b.h(parcel, iG);
                    break;
                case 12:
                    strB2 = b.b(parcel, iG);
                    break;
                case 13:
                    strB4 = b.b(parcel, iG);
                    break;
                case 14:
                    iH4 = b.h(parcel, iG);
                    break;
                case 15:
                    f2 = b.f(parcel, iG);
                    break;
                case 16:
                    jI3 = b.i(parcel, iG);
                    break;
                case 17:
                    strB5 = b.b(parcel, iG);
                    break;
            }
        }
        b.d(parcel, iL);
        return new WakeLockEvent(iH, jI, iH2, strB, iH3, arrayListC, strB2, jI2, iH4, strB3, strB4, f2, jI3, strB5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new WakeLockEvent[i2];
    }
}
