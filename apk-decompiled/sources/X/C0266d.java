package x;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* JADX INFO: renamed from: x.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0266d extends AbstractC0270h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewGroup f4090b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0266d(Fragment fragment, ViewGroup viewGroup) {
        super(fragment, "Attempting to use <fragment> tag to add fragment " + fragment + " to container " + viewGroup);
        q0.f.e(fragment, "fragment");
        this.f4090b = viewGroup;
    }
}
