package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: renamed from: androidx.fragment.app.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0173l {
    public Fragment b(Context context, String str, Bundle bundle) {
        return Fragment.W(context, str, bundle);
    }

    public abstract View e(int i2);

    public abstract boolean j();
}
