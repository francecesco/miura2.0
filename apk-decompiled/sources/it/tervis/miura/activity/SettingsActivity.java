package it.tervis.miura.activity;

import X.f;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AbstractC0105a;
import it.tervis.miura.MiuraService;
import it.tervis.miura.R;

/* JADX INFO: loaded from: classes.dex */
public class SettingsActivity extends it.tervis.miura.activity.b {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private f f3743J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private boolean f3744K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private int f3745L = 1;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private MiuraService.n f3746M = new a();

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private Runnable f3747N = new b();

    class a extends MiuraService.n {

        /* JADX INFO: renamed from: it.tervis.miura.activity.SettingsActivity$a$a, reason: collision with other inner class name */
        class RunnableC0062a implements Runnable {
            RunnableC0062a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SettingsActivity.this.H0();
            }
        }

        a() {
        }

        @Override // it.tervis.miura.MiuraService.n
        public void k() {
            SettingsActivity.this.f3754C.post(new RunnableC0062a());
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SettingsActivity.this.J();
        }
    }

    private void O0() {
        this.f3744K = true;
        this.f3743J.V1(true);
    }

    @Override // it.tervis.miura.activity.b
    protected void I0() {
        o(this.f3746M);
    }

    @Override // it.tervis.miura.activity.b, it.tervis.miura.a
    public void J() {
        setResult(10);
        finish();
    }

    @Override // it.tervis.miura.activity.b
    protected void J0() {
    }

    @Override // it.tervis.miura.activity.a, androidx.fragment.app.AbstractActivityC0171j, androidx.activity.ComponentActivity, androidx.core.app.g, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
        this.f3745L = getIntent().getIntExtra(".mode", 1);
        AbstractC0105a abstractC0105aQ0 = q0();
        abstractC0105aQ0.z(R.string.label_set_configuration);
        abstractC0105aQ0.r(new ColorDrawable(getResources().getColor(R.color.tervis_blues)));
        this.f3743J = new f();
        Bundle bundle2 = new Bundle();
        bundle2.putInt(".index", getIntent().getIntExtra(".index", -1));
        this.f3743J.t1(bundle2);
        f0().o().n(android.R.id.content, this.f3743J).g();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_activity_menu, menu);
        if (this.f3744K) {
            menu.findItem(R.id.action_edit_save).setTitle(R.string.label_save);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // androidx.appcompat.app.AbstractActivityC0108d, androidx.fragment.app.AbstractActivityC0171j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.id.action_edit_save) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (!this.f3744K) {
            this.f3744K = true;
        } else if (this.f3743J.U1()) {
            setResult(-1);
            finish();
        }
        this.f3743J.V1(this.f3744K);
        menuItem.setTitle(this.f3744K ? R.string.label_save : R.string.label_edit);
        return true;
    }

    @Override // it.tervis.miura.activity.b, androidx.appcompat.app.AbstractActivityC0108d, androidx.fragment.app.AbstractActivityC0171j, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.f3745L == 0) {
            O0();
        }
        this.f3754C.postDelayed(this.f3747N, 30000L);
    }

    @Override // it.tervis.miura.activity.b, androidx.appcompat.app.AbstractActivityC0108d, androidx.fragment.app.AbstractActivityC0171j, android.app.Activity
    protected void onStop() {
        A(this.f3746M);
        this.f3754C.removeCallbacks(this.f3747N);
        super.onStop();
    }

    @Override // it.tervis.miura.activity.b, android.app.Activity
    public void onUserInteraction() {
        Handler handler = this.f3754C;
        if (handler != null) {
            handler.removeCallbacks(this.f3747N);
            this.f3754C.postDelayed(this.f3747N, 30000L);
        }
    }
}
