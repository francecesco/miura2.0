package L;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static int a(Parcel parcel) {
        return i(parcel, 20293);
    }

    public static void b(Parcel parcel, int i2) {
        j(parcel, i2);
    }

    public static void c(Parcel parcel, int i2, float f2) {
        k(parcel, i2, 4);
        parcel.writeFloat(f2);
    }

    public static void d(Parcel parcel, int i2, int i3) {
        k(parcel, i2, 4);
        parcel.writeInt(i3);
    }

    public static void e(Parcel parcel, int i2, long j2) {
        k(parcel, i2, 8);
        parcel.writeLong(j2);
    }

    public static void f(Parcel parcel, int i2, Parcelable parcelable, int i3, boolean z2) {
        if (parcelable == null) {
            if (z2) {
                k(parcel, i2, 0);
            }
        } else {
            int i4 = i(parcel, i2);
            parcelable.writeToParcel(parcel, i3);
            j(parcel, i4);
        }
    }

    public static void g(Parcel parcel, int i2, String str, boolean z2) {
        if (str == null) {
            if (z2) {
                k(parcel, i2, 0);
            }
        } else {
            int i3 = i(parcel, i2);
            parcel.writeString(str);
            j(parcel, i3);
        }
    }

    public static void h(Parcel parcel, int i2, List list, boolean z2) {
        if (list == null) {
            if (z2) {
                k(parcel, i2, 0);
            }
        } else {
            int i3 = i(parcel, i2);
            parcel.writeStringList(list);
            j(parcel, i3);
        }
    }

    private static int i(Parcel parcel, int i2) {
        parcel.writeInt(i2 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void j(Parcel parcel, int i2) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i2 - 4);
        parcel.writeInt(iDataPosition - i2);
        parcel.setDataPosition(iDataPosition);
    }

    private static void k(Parcel parcel, int i2, int i3) {
        if (i3 < 65535) {
            parcel.writeInt(i2 | (i3 << 16));
        } else {
            parcel.writeInt(i2 | (-65536));
            parcel.writeInt(i3);
        }
    }
}
