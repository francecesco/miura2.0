package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2271b;

    public D(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f2270a | this.f2271b;
    }

    public void b(View view, View view2, int i2) {
        c(view, view2, i2, 0);
    }

    public void c(View view, View view2, int i2, int i3) {
        if (i3 == 1) {
            this.f2271b = i2;
        } else {
            this.f2270a = i2;
        }
    }

    public void d(View view, int i2) {
        if (i2 == 1) {
            this.f2271b = 0;
        } else {
            this.f2270a = 0;
        }
    }
}
