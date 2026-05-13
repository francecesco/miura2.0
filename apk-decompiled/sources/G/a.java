package G;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import it.tervis.miura.model.Console;

/* JADX INFO: loaded from: classes.dex */
public final class a extends L.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f36a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f37b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PendingIntent f38c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f39d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f35e = new a(0);
    public static final Parcelable.Creator<a> CREATOR = new o();

    public a(int i2) {
        this(i2, null, null);
    }

    static String e(int i2) {
        if (i2 == 99) {
            return "UNFINISHED";
        }
        if (i2 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i2) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case Console.MAX_CONSOLE /* 7 */:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i2) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i2);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public final int a() {
        return this.f37b;
    }

    public final String b() {
        return this.f39d;
    }

    public final PendingIntent c() {
        return this.f38c;
    }

    public final boolean d() {
        return (this.f37b == 0 || this.f38c == null) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f37b == aVar.f37b && K.d.a(this.f38c, aVar.f38c) && K.d.a(this.f39d, aVar.f39d);
    }

    public final int hashCode() {
        return K.d.b(Integer.valueOf(this.f37b), this.f38c, this.f39d);
    }

    public final String toString() {
        return K.d.c(this).a("statusCode", e(this.f37b)).a("resolution", this.f38c).a("message", this.f39d).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = L.c.a(parcel);
        L.c.d(parcel, 1, this.f36a);
        L.c.d(parcel, 2, a());
        L.c.f(parcel, 3, c(), i2, false);
        L.c.g(parcel, 4, b(), false);
        L.c.b(parcel, iA);
    }

    a(int i2, int i3, PendingIntent pendingIntent, String str) {
        this.f36a = i2;
        this.f37b = i3;
        this.f38c = pendingIntent;
        this.f39d = str;
    }

    public a(int i2, PendingIntent pendingIntent) {
        this(i2, pendingIntent, null);
    }

    public a(int i2, PendingIntent pendingIntent, String str) {
        this(1, i2, pendingIntent, str);
    }
}
