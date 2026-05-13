package V;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import it.tervis.miura.R;
import it.tervis.miura.model.Installation;
import it.tervis.miura.model.Timer;
import java.text.DateFormatSymbols;

/* JADX INFO: loaded from: classes.dex */
public class i extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final DateFormatSymbols f399f = new DateFormatSymbols();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Timer f400e;

    public i(Context context, Installation installation) {
        super(context, installation);
    }

    public void c(Timer timer) {
        this.f400e = timer;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f400e == null ? 7 : 63;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return i2 < 7 ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        String str;
        if (view == null) {
            view = this.f383b.inflate(i2 < 7 ? R.layout.item_timer_day : R.layout.item_timer_time, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.text_activation_time);
        if (i2 < 7) {
            str = i2 == 6 ? f399f.getShortWeekdays()[1] : f399f.getShortWeekdays()[i2 + 2];
        } else {
            int i3 = i2 - 7;
            Timer.TimerTransition timerTransition = this.f400e.getTransitions().get(((i3 % 7) * 8) + (i3 / 7));
            if (timerTransition.isProgrammed()) {
                textView.setText(timerTransition.getTime());
                textView.setBackgroundResource(timerTransition.getState() == Timer.TimerState.ON ? android.R.color.holo_red_light : android.R.color.holo_green_light);
                return view;
            }
            textView.setBackgroundResource(android.R.color.darker_gray);
            str = "";
        }
        textView.setText(str);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
