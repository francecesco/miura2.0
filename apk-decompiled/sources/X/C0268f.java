package x;

import androidx.fragment.app.Fragment;

/* JADX INFO: renamed from: x.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0268f extends AbstractC0270h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f4091b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0268f(Fragment fragment, boolean z2) {
        super(fragment, "Attempting to set user visible hint to " + z2 + " for fragment " + fragment);
        q0.f.e(fragment, "fragment");
        this.f4091b = z2;
    }
}
