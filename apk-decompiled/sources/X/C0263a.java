package x;

import androidx.fragment.app.Fragment;

/* JADX INFO: renamed from: x.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0263a extends AbstractC0270h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4072b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0263a(Fragment fragment, String str) {
        super(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + str);
        q0.f.e(fragment, "fragment");
        q0.f.e(str, "previousFragmentId");
        this.f4072b = str;
    }
}
