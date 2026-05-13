package it.tervis.miura.activity;

import X.i;
import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import it.tervis.miura.R;

/* JADX INFO: loaded from: classes.dex */
public class LogActivity extends b {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private i f3741J;

    private String O0(int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getString(R.string.menu_log));
        stringBuffer.append(": ");
        stringBuffer.append(getString(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 6 ? R.string.menu_all : R.string.menu_activation_and_access : R.string.menu_attack : R.string.menu_failures_and_sim : R.string.menu_alarms_only));
        return stringBuffer.toString();
    }

    @Override // it.tervis.miura.activity.b
    protected void I0() {
        this.f3741J.T1();
    }

    @Override // it.tervis.miura.activity.b
    protected void J0() {
        H0();
    }

    @Override // it.tervis.miura.activity.a, androidx.fragment.app.AbstractActivityC0171j, androidx.activity.ComponentActivity, androidx.core.app.g, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(5);
        super.onCreate(bundle);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(O0(getIntent().getIntExtra(".logType", 0)));
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.tervis_blues)));
        }
        setContentView(R.layout.activity_log);
        i iVar = new i();
        this.f3741J = iVar;
        iVar.t1(getIntent().getExtras());
        f0().o().n(R.id.fragment_container, this.f3741J).g();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
