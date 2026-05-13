package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R$id;

/* JADX INFO: loaded from: classes.dex */
public abstract class F {
    public static final void a(View view, l lVar) {
        q0.f.e(view, "<this>");
        view.setTag(R$id.view_tree_lifecycle_owner, lVar);
    }
}
