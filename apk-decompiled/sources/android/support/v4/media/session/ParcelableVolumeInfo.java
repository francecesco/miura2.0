package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f702e;

    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo[] newArray(int i2) {
            return new ParcelableVolumeInfo[i2];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f698a = parcel.readInt();
        this.f700c = parcel.readInt();
        this.f701d = parcel.readInt();
        this.f702e = parcel.readInt();
        this.f699b = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f698a);
        parcel.writeInt(this.f700c);
        parcel.writeInt(this.f701d);
        parcel.writeInt(this.f702e);
        parcel.writeInt(this.f699b);
    }
}
