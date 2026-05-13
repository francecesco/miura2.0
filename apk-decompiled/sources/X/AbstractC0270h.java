package x;

import androidx.fragment.app.Fragment;

/* JADX INFO: renamed from: x.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0270h extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Fragment f4092a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0270h(Fragment fragment, String str) {
        super(str);
        q0.f.e(fragment, "fragment");
        this.f4092a = fragment;
    }

    public final Fragment a() {
        return this.f4092a;
    }
}
