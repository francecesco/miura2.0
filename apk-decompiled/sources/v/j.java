package V;

import android.content.Context;
import it.tervis.miura.model.Installation;
import it.tervis.miura.model.InstallationManager;
import it.tervis.miura.model.Timer;
import java.text.DateFormatSymbols;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class j extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final DateFormatSymbols f401f = new DateFormatSymbols();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Timer f402e;

    public j(Context context, Installation installation) {
        super(context, installation);
    }

    private ArrayList c() {
        return InstallationManager.getInstance().getCurrentInstallation().mAreas;
    }

    public void d(Timer timer) {
        this.f402e = timer;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return 20;
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
        return i2 < 4 ? 0 : 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00be  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View getView(int r4, android.view.View r5, android.view.ViewGroup r6) {
        /*
            r3 = this;
            r6 = 4
            if (r5 != 0) goto L12
            r5 = 0
            android.view.LayoutInflater r0 = r3.f383b
            if (r4 >= r6) goto Lf
            int r1 = it.tervis.miura.R.layout.item_timer_area
        La:
            android.view.View r5 = r0.inflate(r1, r5)
            goto L12
        Lf:
            int r1 = it.tervis.miura.R.layout.item_timer_group
            goto La
        L12:
            int r0 = it.tervis.miura.R.id.text_timer
            android.view.View r0 = r5.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r4 >= r6) goto L3f
            java.util.ArrayList r6 = r3.c()
            java.lang.Object r6 = r6.get(r4)
            it.tervis.miura.model.Area r6 = (it.tervis.miura.model.Area) r6
            boolean r6 = r6.hasActiveGroups()
            if (r6 == 0) goto Lc1
            java.util.ArrayList r6 = r3.c()
            java.lang.Object r4 = r6.get(r4)
            it.tervis.miura.model.Area r4 = (it.tervis.miura.model.Area) r4
            java.lang.String r4 = r4.getName()
            r0.setText(r4)
            goto Lc1
        L3f:
            int r1 = r4 % 4
            int r4 = r4 / r6
            int r4 = r4 + (-1)
            java.util.ArrayList r6 = r3.c()
            java.lang.Object r6 = r6.get(r1)
            it.tervis.miura.model.Area r6 = (it.tervis.miura.model.Area) r6
            boolean r1 = r6.hasActiveGroups()
            java.lang.String r2 = ""
            if (r1 == 0) goto Lbe
            java.util.ArrayList<it.tervis.miura.model.Group> r1 = r6.mGroups
            int r1 = r1.size()
            if (r4 >= r1) goto Lbe
            java.util.ArrayList<it.tervis.miura.model.Group> r6 = r6.mGroups
            java.lang.Object r4 = r6.get(r4)
            it.tervis.miura.model.Group r4 = (it.tervis.miura.model.Group) r4
            boolean r6 = r4.hasZoneAssigned()
            if (r6 == 0) goto Lbe
            java.lang.String r6 = r4.getName()
            r0.setText(r6)
            it.tervis.miura.model.Timer r6 = r3.f402e
            if (r6 == 0) goto Lba
            boolean r6 = r6.hasGroupForActivation(r4)
            if (r6 == 0) goto L90
            it.tervis.miura.model.Timer r6 = r3.f402e
            boolean r6 = r6.hasGroupForDeactivation(r4)
            if (r6 == 0) goto L90
            java.lang.String r4 = "1"
            j0.d.a(r4)
            r4 = -256(0xffffffffffffff00, float:NaN)
        L8c:
            r0.setBackgroundColor(r4)
            goto Lc1
        L90:
            it.tervis.miura.model.Timer r6 = r3.f402e
            boolean r6 = r6.hasGroupForActivation(r4)
            if (r6 == 0) goto La0
            java.lang.String r4 = "2"
            j0.d.a(r4)
            r4 = -65536(0xffffffffffff0000, float:NaN)
            goto L8c
        La0:
            it.tervis.miura.model.Timer r6 = r3.f402e
            boolean r4 = r6.hasGroupForDeactivation(r4)
            if (r4 == 0) goto Lb1
            java.lang.String r4 = "3"
            j0.d.a(r4)
            r4 = -16711936(0xffffffffff00ff00, float:-1.7146522E38)
            goto L8c
        Lb1:
            java.lang.String r4 = "4"
            j0.d.a(r4)
            r4 = -5592406(0xffffffffffaaaaaa, float:NaN)
            goto L8c
        Lba:
            r4 = 11184810(0xaaaaaa, float:1.5673257E-38)
            goto L8c
        Lbe:
            r0.setText(r2)
        Lc1:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: V.j.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
