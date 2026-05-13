package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c implements j, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f1302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    LayoutInflater f1303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    e f1304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ExpandedMenuView f1305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1306e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f1307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f1308g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private j.a f1309h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    a f1310i;

    private class a extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1311a = -1;

        public a() {
            a();
        }

        void a() {
            g gVarV = c.this.f1304c.v();
            if (gVarV != null) {
                ArrayList arrayListZ = c.this.f1304c.z();
                int size = arrayListZ.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (((g) arrayListZ.get(i2)) == gVarV) {
                        this.f1311a = i2;
                        return;
                    }
                }
            }
            this.f1311a = -1;
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g getItem(int i2) {
            ArrayList arrayListZ = c.this.f1304c.z();
            int i3 = i2 + c.this.f1306e;
            int i4 = this.f1311a;
            if (i4 >= 0 && i3 >= i4) {
                i3++;
            }
            return (g) arrayListZ.get(i3);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = c.this.f1304c.z().size() - c.this.f1306e;
            return this.f1311a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                c cVar = c.this;
                view = cVar.f1303b.inflate(cVar.f1308g, viewGroup, false);
            }
            ((k.a) view).d(getItem(i2), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public c(int i2, int i3) {
        this.f1308g = i2;
        this.f1307f = i3;
    }

    @Override // androidx.appcompat.view.menu.j
    public void a(e eVar, boolean z2) {
        j.a aVar = this.f1309h;
        if (aVar != null) {
            aVar.a(eVar, z2);
        }
    }

    public ListAdapter b() {
        if (this.f1310i == null) {
            this.f1310i = new a();
        }
        return this.f1310i;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean c() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // androidx.appcompat.view.menu.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(android.content.Context r3, androidx.appcompat.view.menu.e r4) {
        /*
            r2 = this;
            int r0 = r2.f1307f
            if (r0 == 0) goto L14
            android.view.ContextThemeWrapper r0 = new android.view.ContextThemeWrapper
            int r1 = r2.f1307f
            r0.<init>(r3, r1)
            r2.f1302a = r0
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r0)
        L11:
            r2.f1303b = r3
            goto L23
        L14:
            android.content.Context r0 = r2.f1302a
            if (r0 == 0) goto L23
            r2.f1302a = r3
            android.view.LayoutInflater r0 = r2.f1303b
            if (r0 != 0) goto L23
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            goto L11
        L23:
            r2.f1304c = r4
            androidx.appcompat.view.menu.c$a r3 = r2.f1310i
            if (r3 == 0) goto L2c
            r3.notifyDataSetChanged()
        L2c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.c.d(android.content.Context, androidx.appcompat.view.menu.e):void");
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e(e eVar, g gVar) {
        return false;
    }

    public k f(ViewGroup viewGroup) {
        if (this.f1305d == null) {
            this.f1305d = (ExpandedMenuView) this.f1303b.inflate(R$layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1310i == null) {
                this.f1310i = new a();
            }
            this.f1305d.setAdapter((ListAdapter) this.f1310i);
            this.f1305d.setOnItemClickListener(this);
        }
        return this.f1305d;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean g(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f1309h = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean i(m mVar) {
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        new f(mVar).d(null);
        j.a aVar = this.f1309h;
        if (aVar == null) {
            return true;
        }
        aVar.b(mVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(boolean z2) {
        a aVar = this.f1310i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        this.f1304c.N(this.f1310i.getItem(i2), this, 0);
    }

    public c(Context context, int i2) {
        this(i2, 0);
        this.f1302a = context;
        this.f1303b = LayoutInflater.from(context);
    }
}
