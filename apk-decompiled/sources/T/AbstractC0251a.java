package t;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: t.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0251a implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Parcelable f4010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC0251a f4009b = new C0071a();
    public static final Parcelable.Creator<AbstractC0251a> CREATOR = new b();

    /* JADX INFO: renamed from: t.a$a, reason: collision with other inner class name */
    static class C0071a extends AbstractC0251a {
        C0071a() {
            super((C0071a) null);
        }
    }

    /* JADX INFO: renamed from: t.a$b */
    static class b implements Parcelable.ClassLoaderCreator {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC0251a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AbstractC0251a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbstractC0251a.f4009b;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public AbstractC0251a[] newArray(int i2) {
            return new AbstractC0251a[i2];
        }
    }

    private AbstractC0251a() {
        this.f4010a = null;
    }

    public final Parcelable a() {
        return this.f4010a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f4010a, i2);
    }

    protected AbstractC0251a(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f4010a = parcelable == null ? f4009b : parcelable;
    }

    protected AbstractC0251a(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.f4010a = parcelable == f4009b ? null : parcelable;
    }

    /* synthetic */ AbstractC0251a(C0071a c0071a) {
        this();
    }
}
