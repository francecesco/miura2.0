package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class d extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    e f1313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1314b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f1316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LayoutInflater f1317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f1318f;

    public d(e eVar, LayoutInflater layoutInflater, boolean z2, int i2) {
        this.f1316d = z2;
        this.f1317e = layoutInflater;
        this.f1313a = eVar;
        this.f1318f = i2;
        a();
    }

    void a() {
        g gVarV = this.f1313a.v();
        if (gVarV != null) {
            ArrayList arrayListZ = this.f1313a.z();
            int size = arrayListZ.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((g) arrayListZ.get(i2)) == gVarV) {
                    this.f1314b = i2;
                    return;
                }
            }
        }
        this.f1314b = -1;
    }

    public e b() {
        return this.f1313a;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public g getItem(int i2) {
        ArrayList arrayListZ = this.f1316d ? this.f1313a.z() : this.f1313a.E();
        int i3 = this.f1314b;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return (g) arrayListZ.get(i2);
    }

    public void d(boolean z2) {
        this.f1315c = z2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList arrayListZ = this.f1316d ? this.f1313a.z() : this.f1313a.E();
        int i2 = this.f1314b;
        int size = arrayListZ.size();
        return i2 < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f1317e.inflate(this.f1318f, viewGroup, false);
        }
        int groupId = getItem(i2).getGroupId();
        int i3 = i2 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f1313a.G() && groupId != (i3 >= 0 ? getItem(i3).getGroupId() : groupId));
        k.a aVar = (k.a) view;
        if (this.f1315c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.d(getItem(i2), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
