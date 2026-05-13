package G;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class c extends L.a {
    public static final Parcelable.Creator<c> CREATOR = new p();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f42a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f43b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f44c;

    public c(String str, int i2, long j2) {
        this.f42a = str;
        this.f43b = i2;
        this.f44c = j2;
    }

    public String a() {
        return this.f42a;
    }

    public long b() {
        long j2 = this.f44c;
        return j2 == -1 ? this.f43b : j2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (((a() != null && a().equals(cVar.a())) || (a() == null && cVar.a() == null)) && b() == cVar.b()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return K.d.b(a(), Long.valueOf(b()));
    }

    public String toString() {
        return K.d.c(this).a("name", a()).a("version", Long.valueOf(b())).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = L.c.a(parcel);
        L.c.g(parcel, 1, a(), false);
        L.c.d(parcel, 2, this.f43b);
        L.c.e(parcel, 3, b());
        L.c.b(parcel, iA);
    }
}
