package V;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import it.tervis.miura.R;
import it.tervis.miura.model.Area;
import it.tervis.miura.model.Group;
import it.tervis.miura.model.Installation;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View.OnClickListener f389f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View.OnClickListener f390g;

    public c(Context context, Installation installation, int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        super(context, installation);
        this.f388e = i2;
        j0.d.a("Creating adapter for area " + i2);
        this.f389f = onClickListener;
        this.f390g = onClickListener2;
    }

    private Area c() {
        return a().mNormalizedAreas.get(this.f388e);
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Group getItem(int i2) {
        return c().mNormalizedGroups.get(i2);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return c().mNormalizedGroups.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            try {
                view = this.f383b.inflate(R.layout.item_group, (ViewGroup) null);
            } catch (Exception e2) {
                j0.d.c(e2);
                return this.f383b.inflate(R.layout.item_empty_group, (ViewGroup) null);
            }
        }
        Group group = c().mNormalizedGroups.get(i2);
        TextView textView = (TextView) view.findViewById(R.id.text_group_name);
        String name = group.getName();
        if (name == null) {
            name = "(gruppo " + (i2 + 1) + ")";
        }
        textView.setText(name);
        ((TextView) view.findViewById(R.id.text_group_zones)).setText("Contiene " + group.getZonesList().size() + " zone.");
        ImageView imageView = (ImageView) view.findViewById(R.id.image_group_expand);
        imageView.setTag(Integer.valueOf(i2));
        imageView.setOnClickListener(this.f390g);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.image_lock);
        imageView2.setImageResource(group.isActivated() ? R.drawable.closed : R.drawable.open);
        TextView textView2 = (TextView) view.findViewById(R.id.text_group_p);
        if (!group.isActivated()) {
            if (group.hasZonePermanentlyExcludedGroupsMask()) {
                textView2.setVisibility(0);
            }
            textView2.setVisibility(4);
        } else if (group.hasZonePermanentlyExcludedGroupsMask() || group.isPartiallyActivatedWithTemporaryExcludedZones()) {
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(4);
        }
        imageView2.setTag(Integer.valueOf(i2));
        imageView2.setOnClickListener(this.f389f);
        return view;
    }
}
