package X;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AbstractActivityC0108d;
import it.tervis.miura.R;
import it.tervis.miura.activity.SettingsActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class e extends X.b {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private static final SimpleDateFormat f476n0 = new SimpleDateFormat("EEEE d MMMM yyyy HH:mm:ss", Locale.getDefault());

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private TextView f477i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private ListView f478j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private V.b f479k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private b f480l0 = new b(this, null);

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private long f481m0 = Long.MAX_VALUE;

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
            e eVar = e.this;
            eVar.f466f0.removeCallbacks(eVar.f468h0);
            try {
                ((it.tervis.miura.a) e.this.i()).F(j0.f.f().getConfigurations().get(i2));
            } catch (Exception e2) {
                j0.d.c(e2);
                ((it.tervis.miura.a) e.this.i()).J();
            }
        }
    }

    private class b implements View.OnClickListener {
        private b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iIntValue = ((Integer) view.getTag()).intValue();
            j0.d.a("Opening settings...");
            Intent intent = new Intent(e.this.i(), (Class<?>) SettingsActivity.class);
            intent.putExtra(".index", iIntValue);
            e.this.F1(intent, 1);
        }

        /* synthetic */ b(e eVar, a aVar) {
            this();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean A0(MenuItem menuItem) {
        Intent intent = new Intent(i(), (Class<?>) SettingsActivity.class);
        intent.putExtra(".mode", 0);
        F1(intent, 1);
        return super.A0(menuItem);
    }

    @Override // X.b, androidx.fragment.app.Fragment
    public void J0() {
        j0.d.a("onStart " + getClass().getName());
        super.J0();
        long jI = j0.f.i();
        if (jI != 0) {
            this.f477i0.setText("Ultimo accesso:\n" + f476n0.format(new Date(jI)));
        }
        v1(true);
        L1();
        ((AbstractActivityC0108d) i()).q0().A("I miei impianti");
        if (System.currentTimeMillis() - this.f481m0 <= 30000 || !X()) {
            return;
        }
        ((it.tervis.miura.a) i()).J();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0() {
        j0.d.a("Stop " + getClass().getName());
        super.K0();
        this.f466f0.removeCallbacks(this.f468h0);
        this.f481m0 = System.currentTimeMillis();
    }

    @Override // androidx.fragment.app.Fragment
    public void h0(int i2, int i3, Intent intent) {
        j0.d.a("onActivityResult");
        super.h0(i2, i3, intent);
        this.f479k0.notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.Fragment
    public void p0(Menu menu, MenuInflater menuInflater) {
        super.p0(menu, menuInflater);
        menuInflater.inflate(R.menu.configuration_list_menu, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public View q0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_configuration_menu, viewGroup, false);
        this.f465e0 = viewGroup2;
        this.f477i0 = (TextView) viewGroup2.findViewById(R.id.text_last_access);
        this.f478j0 = (ListView) this.f465e0.findViewById(R.id.listview_configuration);
        V.b bVar = new V.b(i(), I1(), j0.f.f(), this.f480l0);
        this.f479k0 = bVar;
        this.f478j0.setAdapter((ListAdapter) bVar);
        this.f478j0.setOnItemClickListener(new a());
        return this.f465e0;
    }

    @Override // androidx.fragment.app.Fragment
    public void r0() {
        super.r0();
        this.f481m0 = Long.MAX_VALUE;
    }
}
