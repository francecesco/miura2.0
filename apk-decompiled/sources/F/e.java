package F;

import android.net.Uri;
import android.util.LogPrinter;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f13b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LogPrinter f14a = new LogPrinter(4, "GA/LogCatTransport");

    static {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("local");
        f13b = builder.build();
    }
}
