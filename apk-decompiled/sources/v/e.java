package V;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import it.tervis.miura.R;
import it.tervis.miura.model.Installation;

/* JADX INFO: loaded from: classes.dex */
public class e extends a {
    public e(Context context, Installation installation) {
        super(context, installation);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return 5;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        int i3 = 0;
        if (i2 != 0) {
            if (i2 == 1) {
                i3 = 1;
            } else if (i2 == 2) {
                i3 = 2;
            } else if (i2 == 3) {
                i3 = 3;
            } else if (i2 == 4) {
                i3 = 6;
            }
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int i3;
        if (view == null) {
            view = this.f383b.inflate(R.layout.item_log_menu, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.text_menu);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_menu);
        if (i2 == 0) {
            textView.setText(b(R.string.menu_all));
            i3 = R.drawable.security;
        } else if (i2 == 1) {
            textView.setText(b(R.string.menu_alarms_only));
            i3 = R.drawable.zone_alarm;
        } else if (i2 == 2) {
            textView.setText(b(R.string.menu_failures_and_sim));
            i3 = R.drawable.zone_failure;
        } else {
            if (i2 != 3) {
                if (i2 == 4) {
                    textView.setText(b(R.string.menu_activation_and_access));
                    i3 = R.drawable.console_icon_locks_phone;
                }
                return view;
            }
            textView.setText(b(R.string.menu_attack));
            i3 = R.drawable.zone_attack;
        }
        imageView.setImageResource(i3);
        return view;
    }
}
