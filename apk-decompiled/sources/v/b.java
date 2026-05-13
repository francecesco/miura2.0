package V;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import it.tervis.miura.R;
import it.tervis.miura.model.Configuration;
import it.tervis.miura.model.ConfigurationList;
import it.tervis.miura.model.Installation;

/* JADX INFO: loaded from: classes.dex */
public class b extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ConfigurationList f386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View.OnClickListener f387f;

    public b(Context context, Installation installation, ConfigurationList configurationList, View.OnClickListener onClickListener) {
        super(context, installation);
        this.f386e = configurationList;
        this.f387f = onClickListener;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Configuration getItem(int i2) {
        ConfigurationList configurationList = this.f386e;
        if (configurationList != null) {
            return configurationList.getConfigurations().get(i2);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ConfigurationList configurationList = this.f386e;
        if (configurationList != null) {
            return configurationList.getConfigurations().size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f383b.inflate(R.layout.item_configuration, (ViewGroup) null);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.image_settings);
        imageView.setOnClickListener(this.f387f);
        imageView.setTag(Integer.valueOf(i2));
        TextView textView = (TextView) view.findViewById(R.id.text_configuration_name);
        String name = getItem(i2).getName();
        if (name == null || name.length() <= 0) {
            textView.setHint("Inserisci un nome");
            textView.setText("");
        } else {
            textView.setHint("");
            textView.setText(name);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        j0.d.a("Dataset changed on " + this);
        this.f386e = j0.f.f();
        super.notifyDataSetChanged();
    }
}
