package androidx.activity;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {
    public static final void a(View view, l lVar) {
        q0.f.e(view, "<this>");
        q0.f.e(lVar, "fullyDrawnReporterOwner");
        view.setTag(R$id.report_drawn, lVar);
    }
}
