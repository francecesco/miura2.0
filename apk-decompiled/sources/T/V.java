package T;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class V extends r0 implements U {
    V(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.analytics.internal.IAnalyticsService");
    }

    @Override // T.U
    public final void b(Map map, long j2, String str, List list) {
        Parcel parcelE = e();
        parcelE.writeMap(map);
        parcelE.writeLong(j2);
        parcelE.writeString(str);
        parcelE.writeTypedList(list);
        f(1, parcelE);
    }
}
