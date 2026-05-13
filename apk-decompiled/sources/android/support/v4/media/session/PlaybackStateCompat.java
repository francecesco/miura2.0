package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final float f706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final long f707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final CharSequence f709g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final long f710h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    List f711i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final long f712j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final Bundle f713k;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CharSequence f715b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f716c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Bundle f717d;

        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public CustomAction[] newArray(int i2) {
                return new CustomAction[i2];
            }
        }

        CustomAction(Parcel parcel) {
            this.f714a = parcel.readString();
            this.f715b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f716c = parcel.readInt();
            this.f717d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f715b) + ", mIcon=" + this.f716c + ", mExtras=" + this.f717d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f714a);
            TextUtils.writeToParcel(this.f715b, parcel, i2);
            parcel.writeInt(this.f716c);
            parcel.writeBundle(this.f717d);
        }
    }

    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat[] newArray(int i2) {
            return new PlaybackStateCompat[i2];
        }
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f703a = parcel.readInt();
        this.f704b = parcel.readLong();
        this.f706d = parcel.readFloat();
        this.f710h = parcel.readLong();
        this.f705c = parcel.readLong();
        this.f707e = parcel.readLong();
        this.f709g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f711i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f712j = parcel.readLong();
        this.f713k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f708f = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f703a + ", position=" + this.f704b + ", buffered position=" + this.f705c + ", speed=" + this.f706d + ", updated=" + this.f710h + ", actions=" + this.f707e + ", error code=" + this.f708f + ", error message=" + this.f709g + ", custom actions=" + this.f711i + ", active item id=" + this.f712j + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f703a);
        parcel.writeLong(this.f704b);
        parcel.writeFloat(this.f706d);
        parcel.writeLong(this.f710h);
        parcel.writeLong(this.f705c);
        parcel.writeLong(this.f707e);
        TextUtils.writeToParcel(this.f709g, parcel, i2);
        parcel.writeTypedList(this.f711i);
        parcel.writeLong(this.f712j);
        parcel.writeBundle(this.f713k);
        parcel.writeInt(this.f708f);
    }
}
