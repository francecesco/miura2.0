package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import k.C0207a;

/* JADX INFO: loaded from: classes.dex */
class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseIntArray f3322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Parcel f3323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f3324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f3325g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f3326h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3327i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3328j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3329k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C0207a(), new C0207a(), new C0207a());
    }

    @Override // androidx.versionedparcelable.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f3323e.writeInt(-1);
        } else {
            this.f3323e.writeInt(bArr.length);
            this.f3323e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f3323e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void E(int i2) {
        this.f3323e.writeInt(i2);
    }

    @Override // androidx.versionedparcelable.a
    public void G(Parcelable parcelable) {
        this.f3323e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void I(String str) {
        this.f3323e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i2 = this.f3327i;
        if (i2 >= 0) {
            int i3 = this.f3322d.get(i2);
            int iDataPosition = this.f3323e.dataPosition();
            this.f3323e.setDataPosition(i3);
            this.f3323e.writeInt(iDataPosition - i3);
            this.f3323e.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.f3323e;
        int iDataPosition = parcel.dataPosition();
        int i2 = this.f3328j;
        if (i2 == this.f3324f) {
            i2 = this.f3325g;
        }
        return new b(parcel, iDataPosition, i2, this.f3326h + "  ", this.f3319a, this.f3320b, this.f3321c);
    }

    @Override // androidx.versionedparcelable.a
    public boolean g() {
        return this.f3323e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.a
    public byte[] i() {
        int i2 = this.f3323e.readInt();
        if (i2 < 0) {
            return null;
        }
        byte[] bArr = new byte[i2];
        this.f3323e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f3323e);
    }

    @Override // androidx.versionedparcelable.a
    public boolean m(int i2) {
        while (this.f3328j < this.f3325g) {
            int i3 = this.f3329k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f3323e.setDataPosition(this.f3328j);
            int i4 = this.f3323e.readInt();
            this.f3329k = this.f3323e.readInt();
            this.f3328j += i4;
        }
        return this.f3329k == i2;
    }

    @Override // androidx.versionedparcelable.a
    public int o() {
        return this.f3323e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public Parcelable q() {
        return this.f3323e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String s() {
        return this.f3323e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public void w(int i2) {
        a();
        this.f3327i = i2;
        this.f3322d.put(i2, this.f3323e.dataPosition());
        E(0);
        E(i2);
    }

    @Override // androidx.versionedparcelable.a
    public void y(boolean z2) {
        this.f3323e.writeInt(z2 ? 1 : 0);
    }

    private b(Parcel parcel, int i2, int i3, String str, C0207a c0207a, C0207a c0207a2, C0207a c0207a3) {
        super(c0207a, c0207a2, c0207a3);
        this.f3322d = new SparseIntArray();
        this.f3327i = -1;
        this.f3329k = -1;
        this.f3323e = parcel;
        this.f3324f = i2;
        this.f3325g = i3;
        this.f3328j = i2;
        this.f3326h = str;
    }
}
