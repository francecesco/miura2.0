package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: renamed from: androidx.fragment.app.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0164c implements Parcelable {
    public static final Parcelable.Creator<C0164c> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List f2848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final List f2849b;

    /* JADX INFO: renamed from: androidx.fragment.app.c$a */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0164c createFromParcel(Parcel parcel) {
            return new C0164c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0164c[] newArray(int i2) {
            return new C0164c[i2];
        }
    }

    C0164c(Parcel parcel) {
        this.f2848a = parcel.createStringArrayList();
        this.f2849b = parcel.createTypedArrayList(C0163b.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStringList(this.f2848a);
        parcel.writeTypedList(this.f2849b);
    }
}
