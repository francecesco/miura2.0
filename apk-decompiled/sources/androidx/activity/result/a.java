package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0021a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Intent f800b;

    /* JADX INFO: renamed from: androidx.activity.result.a$a, reason: collision with other inner class name */
    class C0021a implements Parcelable.Creator {
        C0021a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    }

    public a(int i2, Intent intent) {
        this.f799a = i2;
        this.f800b = intent;
    }

    public static String c(int i2) {
        return i2 != -1 ? i2 != 0 ? String.valueOf(i2) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public Intent a() {
        return this.f800b;
    }

    public int b() {
        return this.f799a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + c(this.f799a) + ", data=" + this.f800b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f799a);
        parcel.writeInt(this.f800b == null ? 0 : 1);
        Intent intent = this.f800b;
        if (intent != null) {
            intent.writeToParcel(parcel, i2);
        }
    }

    a(Parcel parcel) {
        this.f799a = parcel.readInt();
        this.f800b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
