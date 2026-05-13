package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import k.C0207a;

/* JADX INFO: loaded from: classes.dex */
abstract class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final J f2771a = new I();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final J f2772b = b();

    static void a(Fragment fragment, Fragment fragment2, boolean z2, C0207a c0207a, boolean z3) {
        if (z2) {
            fragment2.r();
        } else {
            fragment.r();
        }
    }

    private static J b() {
        try {
            return (J) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }

    static void c(C0207a c0207a, C0207a c0207a2) {
        for (int size = c0207a.size() - 1; size >= 0; size--) {
            if (!c0207a2.containsKey((String) c0207a.l(size))) {
                c0207a.j(size);
            }
        }
    }

    static void d(ArrayList arrayList, int i2) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i2);
        }
    }
}
