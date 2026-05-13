package androidx.core.app;

import android.app.RemoteInput;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    static class a {
        static void a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static RemoteInput b(r rVar) {
            throw null;
        }

        static Bundle c(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    static RemoteInput a(r rVar) {
        return a.b(rVar);
    }

    static RemoteInput[] b(r[] rVarArr) {
        if (rVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[rVarArr.length];
        for (int i2 = 0; i2 < rVarArr.length; i2++) {
            r rVar = rVarArr[i2];
            remoteInputArr[i2] = a(null);
        }
        return remoteInputArr;
    }
}
