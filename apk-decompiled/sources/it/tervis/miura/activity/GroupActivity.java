package it.tervis.miura.activity;

import X.h;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AbstractC0105a;
import it.tervis.miura.R;
import it.tervis.miura.model.Area;
import it.tervis.miura.model.Group;

/* JADX INFO: loaded from: classes.dex */
public class GroupActivity extends b {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private Group f3738J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private h f3739K;

    @Override // it.tervis.miura.activity.b
    protected void I0() {
        Area area = z().mNormalizedAreas.get(getIntent().getIntExtra(".area", -1));
        Group group = area.mNormalizedGroups.get(getIntent().getIntExtra(".group", -1));
        this.f3738J = group;
        String name = group.getName();
        if (name == null) {
            name = "Gruppo " + this.f3738J.getDefaultName();
        }
        AbstractC0105a abstractC0105aQ0 = q0();
        abstractC0105aQ0.A(name);
        abstractC0105aQ0.y(area.getName());
        abstractC0105aQ0.r(new ColorDrawable(getResources().getColor(R.color.tervis_blues)));
        this.f3739K.Q1();
    }

    @Override // it.tervis.miura.activity.b
    protected void J0() {
        H0();
    }

    @Override // it.tervis.miura.activity.a, androidx.fragment.app.AbstractActivityC0171j, androidx.activity.ComponentActivity, androidx.core.app.g, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(5);
        super.onCreate(bundle);
        setContentView(R.layout.activity_group);
        h hVar = new h();
        this.f3739K = hVar;
        hVar.t1(getIntent().getExtras());
        f0().o().n(R.id.fragment_container, this.f3739K).g();
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
