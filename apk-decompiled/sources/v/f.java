package V;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import it.tervis.miura.R;
import it.tervis.miura.model.Installation;

/* JADX INFO: loaded from: classes.dex */
public class f extends a {
    public f(Context context, Installation installation) {
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
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int i3;
        if (view == null) {
            view = this.f383b.inflate(R.layout.item_menu, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.text_menu);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_menu);
        if (i2 == 0) {
            textView.setText(b(R.string.menu_security));
            i3 = R.drawable.security;
        } else if (i2 == 1) {
            textView.setText(b(R.string.menu_remote_controllers));
            i3 = R.drawable.remote;
        } else if (i2 == 2) {
            textView.setText(b(R.string.menu_times));
            i3 = R.drawable.timers;
        } else if (i2 == 3) {
            textView.setText(b(R.string.menu_log));
            i3 = R.drawable.log;
        } else {
            if (i2 != 4) {
                if (i2 == 5) {
                    textView.setText(b(R.string.menu_video));
                    i3 = R.drawable.video;
                }
                return view;
            }
            textView.setText(b(R.string.menu_info));
            i3 = R.drawable.info;
        }
        imageView.setImageResource(i3);
        return view;
    }
}
