package S;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends Binder implements IInterface {
    protected a(String str) {
        attachInterface(this, str);
    }

    protected boolean e(int i2, Parcel parcel, Parcel parcel2, int i3) {
        return false;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        boolean zOnTransact;
        if (i2 > 16777215) {
            zOnTransact = super.onTransact(i2, parcel, parcel2, i3);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            zOnTransact = false;
        }
        if (zOnTransact) {
            return true;
        }
        return e(i2, parcel, parcel2, i3);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
