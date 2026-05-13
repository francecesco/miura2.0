package X;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import it.tervis.miura.R;
import it.tervis.miura.activity.LogActivity;

/* JADX INFO: loaded from: classes.dex */
public class j extends b {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private ListView f518i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private V.e f519j0;

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
            Intent intent = new Intent(j.this.i(), (Class<?>) LogActivity.class);
            intent.putExtra(".logType", (int) j.this.f519j0.getItemId(i2));
            j.this.D1(intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View q0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_log_menu, viewGroup, false);
        this.f465e0 = viewGroup2;
        this.f518i0 = (ListView) viewGroup2.findViewById(R.id.list_log_menu);
        V.e eVar = new V.e(i(), I1());
        this.f519j0 = eVar;
        this.f518i0.setAdapter((ListAdapter) eVar);
        this.f518i0.setOnItemClickListener(new a());
        return this.f465e0;
    }
}
