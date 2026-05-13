package L;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    public static class a extends RuntimeException {
        public a(String str, Parcel parcel) {
            int iDataPosition = parcel.dataPosition();
            int iDataSize = parcel.dataSize();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 41);
            sb.append(str);
            sb.append(" Parcel: pos=");
            sb.append(iDataPosition);
            sb.append(" size=");
            sb.append(iDataSize);
            super(sb.toString());
        }
    }

    public static Parcelable a(Parcel parcel, int i2, Parcelable.Creator creator) {
        int iJ = j(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iJ);
        return parcelable;
    }

    public static String b(Parcel parcel, int i2) {
        int iJ = j(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iJ);
        return string;
    }

    public static ArrayList c(Parcel parcel, int i2) {
        int iJ = j(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iJ);
        return arrayListCreateStringArrayList;
    }

    public static void d(Parcel parcel, int i2) {
        if (parcel.dataPosition() == i2) {
            return;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(i2);
        throw new a(sb.toString(), parcel);
    }

    public static int e(int i2) {
        return i2 & 65535;
    }

    public static float f(Parcel parcel, int i2) {
        m(parcel, i2, 4);
        return parcel.readFloat();
    }

    public static int g(Parcel parcel) {
        return parcel.readInt();
    }

    public static int h(Parcel parcel, int i2) {
        m(parcel, i2, 4);
        return parcel.readInt();
    }

    public static long i(Parcel parcel, int i2) {
        m(parcel, i2, 8);
        return parcel.readLong();
    }

    public static int j(Parcel parcel, int i2) {
        return (i2 & (-65536)) != -65536 ? (i2 >> 16) & 65535 : parcel.readInt();
    }

    public static void k(Parcel parcel, int i2) {
        parcel.setDataPosition(parcel.dataPosition() + j(parcel, i2));
    }

    public static int l(Parcel parcel) {
        int iG = g(parcel);
        int iJ = j(parcel, iG);
        int iDataPosition = parcel.dataPosition();
        if (e(iG) != 20293) {
            String strValueOf = String.valueOf(Integer.toHexString(iG));
            throw new a(strValueOf.length() != 0 ? "Expected object header. Got 0x".concat(strValueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i2 = iJ + iDataPosition;
        if (i2 >= iDataPosition && i2 <= parcel.dataSize()) {
            return i2;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("Size read is invalid start=");
        sb.append(iDataPosition);
        sb.append(" end=");
        sb.append(i2);
        throw new a(sb.toString(), parcel);
    }

    private static void m(Parcel parcel, int i2, int i3) {
        int iJ = j(parcel, i2);
        if (iJ == i3) {
            return;
        }
        String hexString = Integer.toHexString(iJ);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(iJ);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new a(sb.toString(), parcel);
    }
}
