package it.tervis.miura.activity;

import X.c;
import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import it.tervis.miura.R;

/* JADX INFO: loaded from: classes.dex */
public class VideoActivity extends b {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private c f3752J;

    @Override // it.tervis.miura.activity.b
    protected void I0() {
    }

    @Override // it.tervis.miura.activity.b
    protected void J0() {
    }

    @Override // it.tervis.miura.activity.a, androidx.fragment.app.AbstractActivityC0171j, androidx.activity.ComponentActivity, androidx.core.app.g, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_video);
        ActionBar actionBar = getActionBar();
        actionBar.setTitle("Camera");
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.tervis_blues)));
        this.f3752J = c.S1();
        f0().o().b(R.id.container_video_fragment, this.f3752J).g();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.camera_activity_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.menu.camera_activity_menu) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.f3752J.T1();
        return true;
    }

    @Override // it.tervis.miura.activity.b, androidx.appcompat.app.AbstractActivityC0108d, androidx.fragment.app.AbstractActivityC0171j, android.app.Activity
    protected void onStart() {
        super.onStart();
    }
}
