package T;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class r0 implements IInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IBinder f335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f336c;

    protected r0(IBinder iBinder, String str) {
        this.f335b = iBinder;
        this.f336c = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f335b;
    }

    protected final Parcel e() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f336c);
        return parcelObtain;
    }

    protected final void f(int i2, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f335b.transact(i2, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
