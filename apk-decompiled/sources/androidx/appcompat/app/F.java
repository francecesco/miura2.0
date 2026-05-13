package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
class F {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static F f950d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocationManager f952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f953c = new a();

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f955b;

        a() {
        }
    }

    F(Context context, LocationManager locationManager) {
        this.f951a = context;
        this.f952b = locationManager;
    }

    static F a(Context context) {
        if (f950d == null) {
            Context applicationContext = context.getApplicationContext();
            f950d = new F(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f950d;
    }

    private Location b() {
        Location locationC = androidx.core.content.d.b(this.f951a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location locationC2 = androidx.core.content.d.b(this.f951a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        return (locationC2 == null || locationC == null) ? locationC2 != null ? locationC2 : locationC : locationC2.getTime() > locationC.getTime() ? locationC2 : locationC;
    }

    private Location c(String str) {
        try {
            if (this.f952b.isProviderEnabled(str)) {
                return this.f952b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean e() {
        return this.f953c.f955b > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j2;
        a aVar = this.f953c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        E eB = E.b();
        eB.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        eB.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z2 = eB.f949c == 1;
        long j3 = eB.f948b;
        long j4 = eB.f947a;
        eB.a(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j5 = eB.f948b;
        if (j3 == -1 || j4 == -1) {
            j2 = jCurrentTimeMillis + 43200000;
        } else {
            if (jCurrentTimeMillis <= j4) {
                j5 = jCurrentTimeMillis > j3 ? j4 : j3;
            }
            j2 = j5 + 60000;
        }
        aVar.f954a = z2;
        aVar.f955b = j2;
    }

    boolean d() {
        a aVar = this.f953c;
        if (e()) {
            return aVar.f954a;
        }
        Location locationB = b();
        if (locationB != null) {
            f(locationB);
            return aVar.f954a;
        }
        int i2 = Calendar.getInstance().get(11);
        return i2 < 6 || i2 >= 22;
    }
}
