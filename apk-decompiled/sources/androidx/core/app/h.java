package androidx.core.app;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f2028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Configuration f2029b;

    public h(boolean z2) {
        this.f2028a = z2;
    }

    public final boolean a() {
        return this.f2028a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(boolean z2, Configuration configuration) {
        this(z2);
        q0.f.e(configuration, "newConfig");
        this.f2029b = configuration;
    }
}
