package T;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: T.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0102z implements Parcelable {

    @Deprecated
    public static final Parcelable.Creator<C0102z> CREATOR = new A();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f365c;

    C0102z(Parcel parcel) {
        this.f363a = parcel.readString();
        this.f364b = parcel.readString();
        this.f365c = parcel.readString();
    }

    public final String a() {
        return this.f363a;
    }

    public final String b() {
        return this.f365c;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f363a);
        parcel.writeString(this.f364b);
        parcel.writeString(this.f365c);
    }
}
