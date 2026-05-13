package n;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import n.e;

/* JADX INFO: renamed from: n.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0231d {
    public static e.a a(Context context, Uri uri) {
        return Build.VERSION.SDK_INT < 24 ? new e.b(context, uri) : new e.c(context, uri);
    }
}
