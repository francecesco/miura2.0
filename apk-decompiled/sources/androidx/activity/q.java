package androidx.activity;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class q {
    public static final void a(View view, o oVar) {
        q0.f.e(view, "<this>");
        q0.f.e(oVar, "onBackPressedDispatcherOwner");
        view.setTag(R$id.view_tree_on_back_pressed_dispatcher_owner, oVar);
    }
}
