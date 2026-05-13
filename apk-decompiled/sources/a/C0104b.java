package a;

import a.InterfaceC0103a;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: a.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0104b implements Parcelable {
    public static final Parcelable.Creator<C0104b> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f652a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Handler f653b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    InterfaceC0103a f654c;

    /* JADX INFO: renamed from: a.b$a */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0104b createFromParcel(Parcel parcel) {
            return new C0104b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0104b[] newArray(int i2) {
            return new C0104b[i2];
        }
    }

    /* JADX INFO: renamed from: a.b$b, reason: collision with other inner class name */
    class BinderC0018b extends InterfaceC0103a.AbstractBinderC0016a {
        BinderC0018b() {
        }

        @Override // a.InterfaceC0103a
        public void d(int i2, Bundle bundle) {
            C0104b c0104b = C0104b.this;
            Handler handler = c0104b.f653b;
            if (handler != null) {
                handler.post(c0104b.new c(i2, bundle));
            } else {
                c0104b.a(i2, bundle);
            }
        }
    }

    /* JADX INFO: renamed from: a.b$c */
    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Bundle f657b;

        c(int i2, Bundle bundle) {
            this.f656a = i2;
            this.f657b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0104b.this.a(this.f656a, this.f657b);
        }
    }

    C0104b(Parcel parcel) {
        this.f654c = InterfaceC0103a.AbstractBinderC0016a.e(parcel.readStrongBinder());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        synchronized (this) {
            try {
                if (this.f654c == null) {
                    this.f654c = new BinderC0018b();
                }
                parcel.writeStrongBinder(this.f654c.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void a(int i2, Bundle bundle) {
    }
}
