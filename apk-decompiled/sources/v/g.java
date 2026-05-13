package V;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import it.tervis.miura.R;
import it.tervis.miura.model.Installation;
import it.tervis.miura.model.RemoteController;

/* JADX INFO: loaded from: classes.dex */
public class g extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View.OnClickListener f395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f396f;

    public g(Context context, Installation installation, Object obj) {
        super(context, installation);
        this.f395e = (View.OnClickListener) obj;
        this.f396f = (CompoundButton.OnCheckedChangeListener) obj;
    }

    private boolean d(RemoteController remoteController) {
        return a().isEnabled(remoteController);
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public RemoteController getItem(int i2) {
        return a().getRemoteControllers().get(i2);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return a().getRemoteControllersCount();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        String strE;
        Typeface typeface;
        if (view == null) {
            view = this.f383b.inflate(R.layout.item_remote_controller, (ViewGroup) null);
        }
        RemoteController remoteController = a().getRemoteControllers().get(i2);
        TextView textView = (TextView) view.findViewById(R.id.text_remote_controller_name);
        if (j0.i.e(remoteController.getID()) == null) {
            strE = "Telecomando " + Integer.toString(remoteController.getID() + 1);
        } else {
            strE = j0.i.e(remoteController.getID());
        }
        textView.setText(strE);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_gsm_enabled);
        Switch r4 = (Switch) view.findViewById(R.id.switch_remote_controller);
        r4.setTag(Integer.valueOf(i2));
        r4.setOnClickListener(this.f395e);
        boolean zIsAccessibleViaApp = remoteController.isAccessibleViaApp();
        imageView.setVisibility(8);
        int i3 = 0;
        r4.setEnabled(zIsAccessibleViaApp && d(remoteController));
        if (d(remoteController)) {
            typeface = textView.getTypeface();
        } else {
            typeface = textView.getTypeface();
            i3 = 2;
        }
        textView.setTypeface(typeface, i3);
        r4.setOnCheckedChangeListener(null);
        r4.setChecked(remoteController.getState().equals(RemoteController.State.ON));
        r4.setOnCheckedChangeListener(this.f396f);
        return view;
    }
}
