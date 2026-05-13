package it.tervis.miura.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import androidx.appcompat.app.AbstractC0105a;
import it.tervis.miura.R;

/* JADX INFO: loaded from: classes.dex */
public class InfoActivity extends b {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private WebView f3740J;

    @Override // it.tervis.miura.activity.b
    protected void I0() {
    }

    @Override // it.tervis.miura.activity.b
    protected void J0() {
        H0();
    }

    @Override // it.tervis.miura.activity.a, androidx.fragment.app.AbstractActivityC0171j, androidx.activity.ComponentActivity, androidx.core.app.g, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_info);
        AbstractC0105a abstractC0105aQ0 = q0();
        abstractC0105aQ0.z(R.string.label_info);
        abstractC0105aQ0.r(new ColorDrawable(getResources().getColor(R.color.tervis_blues)));
        abstractC0105aQ0.t(true);
        this.f3740J = (WebView) findViewById(R.id.webview_info);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // it.tervis.miura.activity.b, androidx.appcompat.app.AbstractActivityC0108d, androidx.fragment.app.AbstractActivityC0171j, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f3740J.loadUrl("file:///android_res/raw/info.txt");
    }
}
