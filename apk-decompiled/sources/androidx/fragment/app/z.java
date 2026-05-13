package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.x;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class z implements Parcelable {
    public static final Parcelable.Creator<z> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList f3018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList f3019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    C0163b[] f3020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f3021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f3022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ArrayList f3023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ArrayList f3024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    ArrayList f3025h;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public z createFromParcel(Parcel parcel) {
            return new z(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public z[] newArray(int i2) {
            return new z[i2];
        }
    }

    public z() {
        this.f3022e = null;
        this.f3023f = new ArrayList();
        this.f3024g = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStringList(this.f3018a);
        parcel.writeStringList(this.f3019b);
        parcel.writeTypedArray(this.f3020c, i2);
        parcel.writeInt(this.f3021d);
        parcel.writeString(this.f3022e);
        parcel.writeStringList(this.f3023f);
        parcel.writeTypedList(this.f3024g);
        parcel.writeTypedList(this.f3025h);
    }

    public z(Parcel parcel) {
        this.f3022e = null;
        this.f3023f = new ArrayList();
        this.f3024g = new ArrayList();
        this.f3018a = parcel.createStringArrayList();
        this.f3019b = parcel.createStringArrayList();
        this.f3020c = (C0163b[]) parcel.createTypedArray(C0163b.CREATOR);
        this.f3021d = parcel.readInt();
        this.f3022e = parcel.readString();
        this.f3023f = parcel.createStringArrayList();
        this.f3024g = parcel.createTypedArrayList(C0164c.CREATOR);
        this.f3025h = parcel.createTypedArrayList(x.k.CREATOR);
    }
}
