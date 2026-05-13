package it.tervis.miura.activity;

import X.p;
import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import it.tervis.miura.R;
import j0.i;

/* JADX INFO: loaded from: classes.dex */
public class TimerDetailsActivity extends b {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private p f3751J;

    @Override // it.tervis.miura.activity.b
    protected void I0() {
        this.f3751J.P1();
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
            actionBar.setTitle(i.f(getIntent().getIntExtra(".timerID", 0)));
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.tervis_blues)));
        }
        setContentView(R.layout.activity_timer);
        p pVar = new p();
        this.f3751J = pVar;
        pVar.t1(getIntent().getExtras());
        f0().o().n(R.id.fragment_container, this.f3751J).g();
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
