package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(androidx.versionedparcelable.a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f1996a = (IconCompat) aVar.v(remoteActionCompat.f1996a, 1);
        remoteActionCompat.f1997b = aVar.l(remoteActionCompat.f1997b, 2);
        remoteActionCompat.f1998c = aVar.l(remoteActionCompat.f1998c, 3);
        remoteActionCompat.f1999d = (PendingIntent) aVar.r(remoteActionCompat.f1999d, 4);
        remoteActionCompat.f2000e = aVar.h(remoteActionCompat.f2000e, 5);
        remoteActionCompat.f2001f = aVar.h(remoteActionCompat.f2001f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f1996a, 1);
        aVar.D(remoteActionCompat.f1997b, 2);
        aVar.D(remoteActionCompat.f1998c, 3);
        aVar.H(remoteActionCompat.f1999d, 4);
        aVar.z(remoteActionCompat.f2000e, 5);
        aVar.z(remoteActionCompat.f2001f, 6);
    }
}
