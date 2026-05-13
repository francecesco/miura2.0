package V;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import it.tervis.miura.R;
import it.tervis.miura.model.Group;
import it.tervis.miura.model.Installation;
import it.tervis.miura.model.Zone;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class k extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Group f403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View.OnClickListener f404f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HashMap f405g;

    public k(Context context, Installation installation, Group group, View.OnClickListener onClickListener) {
        super(context, installation);
        this.f403e = group;
        this.f404f = onClickListener;
    }

    public void c(HashMap map) {
        this.f405g = map;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f403e.getZonesList().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f383b.inflate(R.layout.item_zone, (ViewGroup) null);
        }
        Installation installationA = a();
        Zone zone = installationA.mZones.get(this.f403e.getZonesList().get(i2).intValue());
        ((ImageView) view.findViewById(R.id.image_sensor_type)).setImageResource(zone.isWired() ? R.drawable.zone_type_wired : R.drawable.zone_type_wireless);
        HashMap map = this.f405g;
        if (map == null || !map.containsKey(Integer.valueOf(zone.getID()))) {
            j0.d.a("Error on ZoneAdapter: missing data for zone " + zone.getID());
        } else {
            i0.g gVar = (i0.g) this.f405g.get(Integer.valueOf(zone.getID()));
            ImageView imageView = (ImageView) view.findViewById(R.id.image_npi);
            if (gVar.r()) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) view.findViewById(R.id.image_guasto);
            if (gVar.s()) {
                imageView2.setVisibility(0);
            } else {
                imageView2.setVisibility(8);
            }
            ImageView imageView3 = (ImageView) view.findViewById(R.id.image_manomissione);
            if (gVar.u()) {
                imageView3.setVisibility(0);
            } else {
                imageView3.setVisibility(8);
            }
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.check_zone_excluded);
            checkBox.setOnClickListener(null);
            checkBox.setTag(Integer.valueOf(zone.getID()));
            checkBox.setChecked(!gVar.t());
            checkBox.setOnClickListener(this.f404f);
            checkBox.setEnabled(installationA.canDeactivateZones());
        }
        ((TextView) view.findViewById(R.id.text_zone_number)).setText(Integer.toString(this.f403e.getZonesList().get(i2).intValue() + 1));
        TextView textView = (TextView) view.findViewById(R.id.text_zone_name);
        String name = zone.getName();
        if (name == null) {
            name = "Z " + (a().mZones.get(this.f403e.getZonesList().get(i2).intValue()).getID() + 1);
        }
        textView.setText(name);
        return view;
    }
}
