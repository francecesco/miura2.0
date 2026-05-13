package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f690b;

    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RatingCompat[] newArray(int i2) {
            return new RatingCompat[i2];
        }
    }

    RatingCompat(int i2, float f2) {
        this.f689a = i2;
        this.f690b = f2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f689a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f689a);
        sb.append(" rating=");
        float f2 = this.f690b;
        sb.append(f2 < 0.0f ? "unrated" : String.valueOf(f2));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f689a);
        parcel.writeFloat(this.f690b);
    }
}
