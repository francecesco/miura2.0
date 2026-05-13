package androidx.core.app;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f2110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Configuration f2111b;

    public q(boolean z2) {
        this.f2110a = z2;
    }

    public final boolean a() {
        return this.f2110a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(boolean z2, Configuration configuration) {
        this(z2);
        q0.f.e(configuration, "newConfig");
        this.f2111b = configuration;
    }
}
