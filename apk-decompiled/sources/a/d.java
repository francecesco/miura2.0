package A;

import android.view.View;
import androidx.savedstate.R$id;
import q0.f;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static final void a(View view, c cVar) {
        f.e(view, "<this>");
        view.setTag(R$id.view_tree_saved_state_registry_owner, cVar);
    }
}
