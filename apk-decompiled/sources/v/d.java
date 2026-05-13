package V;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import it.tervis.miura.R;
import it.tervis.miura.model.Installation;
import it.tervis.miura.model.LogEvent;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class d extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View.OnClickListener f391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View.OnClickListener f392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList f393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f394h;

    public d(Context context, Installation installation, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        super(context, installation);
        this.f393g = new ArrayList();
        this.f394h = 0;
        this.f391e = onClickListener;
        this.f392f = onClickListener2;
    }

    public void c(ArrayList arrayList, int i2) {
        this.f394h = i2;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.f393g.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public LogEvent getItem(int i2) {
        return (LogEvent) this.f393g.get(i2);
    }

    protected View e(View view) {
        if (view == null) {
            view = this.f383b.inflate(R.layout.item_log_loadmore, (ViewGroup) null);
        }
        view.findViewById(R.id.button_loadmore).setOnClickListener(this.f392f);
        return view;
    }

    protected View f(int i2, View view) {
        int i3;
        if (view == null) {
            view = this.f383b.inflate(R.layout.item_log, (ViewGroup) null);
        }
        ((TextView) view.findViewById(R.id.text_log)).setText(((LogEvent) this.f393g.get(i2)).getHumanizedDateText());
        ImageView imageView = (ImageView) view.findViewById(R.id.image_log_category);
        int category = ((LogEvent) this.f393g.get(i2)).getCategory();
        if (category == 1) {
            i3 = R.drawable.zone_alarm;
        } else if (category == 2) {
            i3 = R.drawable.zone_failure;
        } else if (category == 3) {
            i3 = R.drawable.zone_attack;
        } else {
            if (category != 4) {
                if (category == 5) {
                    i3 = R.drawable.console_icon_phone;
                }
                return view;
            }
            i3 = R.drawable.console_icon_locks;
        }
        imageView.setImageResource(i3);
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f393g.size() != 0) {
            return this.f393g.size() + 1;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return i2 < this.f393g.size() ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        j0.d.a("Getting view for item " + i2 + " of type " + getItemViewType(i2));
        return i2 < this.f393g.size() ? f(i2, view) : e(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
