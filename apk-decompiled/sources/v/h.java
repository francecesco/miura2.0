package V;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import it.tervis.miura.R;
import it.tervis.miura.model.Installation;
import it.tervis.miura.model.Timer;

/* JADX INFO: loaded from: classes.dex */
public class h extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private j0.e f397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View.OnClickListener f398f;

    public h(Context context, Installation installation, j0.e eVar, View.OnClickListener onClickListener) {
        super(context, installation);
        this.f397e = eVar;
        this.f398f = onClickListener;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Timer getItem(int i2) {
        return a().getTimers().get(i2);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Installation installationA = a();
        if (installationA.hasTimers()) {
            return installationA.getTimers().size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f383b.inflate(R.layout.item_timer, (ViewGroup) null);
        }
        Timer item = getItem(i2);
        TextView textView = (TextView) view.findViewById(R.id.text_activation_time);
        String strF = j0.i.f(item.getID());
        if (strF == null) {
            strF = "# Timer " + i2;
        }
        textView.setText(strF);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_timer_expand);
        imageView.setTag(Integer.valueOf(i2));
        imageView.setOnClickListener(this.f398f);
        Switch r1 = (Switch) view.findViewById(R.id.switch_timer_enabled);
        r1.setTag(Integer.valueOf(i2));
        r1.setOnClickListener(this.f397e);
        r1.setOnCheckedChangeListener(null);
        r1.setChecked(item.isEnabled());
        r1.setOnCheckedChangeListener(this.f397e);
        return view;
    }
}
