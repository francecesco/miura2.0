package it.tervis.miura.activity;

import X.d;
import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import it.tervis.miura.R;

/* JADX INFO: loaded from: classes.dex */
public class ConfigurationDetailsActivity extends a {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private d f3737D;

    @Override // it.tervis.miura.activity.a, androidx.fragment.app.AbstractActivityC0171j, androidx.activity.ComponentActivity, androidx.core.app.g, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Nome installazione");
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.tervis_blues)));
        }
        setContentView(R.layout.activity_log);
        d dVar = new d();
        this.f3737D = dVar;
        dVar.t1(getIntent().getExtras());
        f0().o().n(R.id.fragment_container, this.f3737D).g();
    }
}
