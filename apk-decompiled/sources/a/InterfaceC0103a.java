package a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: a.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0103a extends IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f650a = "android$support$v4$os$IResultReceiver".replace('$', '.');

    /* JADX INFO: renamed from: a.a$b */
    public static class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static Object b(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void d(int i2, Bundle bundle);

    /* JADX INFO: renamed from: a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0016a extends Binder implements InterfaceC0103a {

        /* JADX INFO: renamed from: a.a$a$a, reason: collision with other inner class name */
        private static class C0017a implements InterfaceC0103a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f651b;

            C0017a(IBinder iBinder) {
                this.f651b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f651b;
            }
        }

        public AbstractBinderC0016a() {
            attachInterface(this, InterfaceC0103a.f650a);
        }

        public static InterfaceC0103a e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(InterfaceC0103a.f650a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC0103a)) ? new C0017a(iBinder) : (InterfaceC0103a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            String str = InterfaceC0103a.f650a;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i2 != 1) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            d(parcel.readInt(), (Bundle) b.b(parcel, Bundle.CREATOR));
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
