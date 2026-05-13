package x;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* JADX INFO: renamed from: x.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0271i extends AbstractC0270h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewGroup f4093b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0271i(Fragment fragment, ViewGroup viewGroup) {
        super(fragment, "Attempting to add fragment " + fragment + " to container " + viewGroup + " which is not a FragmentContainerView");
        q0.f.e(fragment, "fragment");
        q0.f.e(viewGroup, "container");
        this.f4093b = viewGroup;
    }
}
