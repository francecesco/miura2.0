package androidx.core.app;

import android.os.Bundle;
import androidx.core.app.k;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f2103a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f2104b = new Object();

    static Bundle a(k.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatD = aVar.d();
        bundle.putInt("icon", iconCompatD != null ? iconCompatD.d() : 0);
        bundle.putCharSequence("title", aVar.h());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", c(aVar.e()));
        bundle.putBoolean("showsUserInterface", aVar.g());
        bundle.putInt("semanticAction", aVar.f());
        return bundle;
    }

    private static Bundle b(r rVar) {
        new Bundle();
        throw null;
    }

    private static Bundle[] c(r[] rVarArr) {
        if (rVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[rVarArr.length];
        for (int i2 = 0; i2 < rVarArr.length; i2++) {
            r rVar = rVarArr[i2];
            bundleArr[i2] = b(null);
        }
        return bundleArr;
    }
}
