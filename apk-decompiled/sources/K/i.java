package K;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class i extends S.a implements h {
    public i() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    @Override // S.a
    protected final boolean e(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 == 1) {
            Q.a aVarA = a();
            parcel2.writeNoException();
            S.b.a(parcel2, aVarA);
        } else {
            if (i2 != 2) {
                return false;
            }
            int iC = c();
            parcel2.writeNoException();
            parcel2.writeInt(iC);
        }
        return true;
    }
}
