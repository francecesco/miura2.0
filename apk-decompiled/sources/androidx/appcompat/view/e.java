package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class e extends b implements e.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f1159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ActionBarContextView f1160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b.a f1161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WeakReference f1162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1164h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private androidx.appcompat.view.menu.e f1165i;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z2) {
        this.f1159c = context;
        this.f1160d = actionBarContextView;
        this.f1161e = aVar;
        androidx.appcompat.view.menu.e eVarT = new androidx.appcompat.view.menu.e(actionBarContextView.getContext()).T(1);
        this.f1165i = eVarT;
        eVarT.S(this);
        this.f1164h = z2;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        return this.f1161e.b(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        k();
        this.f1160d.l();
    }

    @Override // androidx.appcompat.view.b
    public void c() {
        if (this.f1163g) {
            return;
        }
        this.f1163g = true;
        this.f1161e.d(this);
    }

    @Override // androidx.appcompat.view.b
    public View d() {
        WeakReference weakReference = this.f1162f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.b
    public Menu e() {
        return this.f1165i;
    }

    @Override // androidx.appcompat.view.b
    public MenuInflater f() {
        return new g(this.f1160d.getContext());
    }

    @Override // androidx.appcompat.view.b
    public CharSequence g() {
        return this.f1160d.getSubtitle();
    }

    @Override // androidx.appcompat.view.b
    public CharSequence i() {
        return this.f1160d.getTitle();
    }

    @Override // androidx.appcompat.view.b
    public void k() {
        this.f1161e.a(this, this.f1165i);
    }

    @Override // androidx.appcompat.view.b
    public boolean l() {
        return this.f1160d.j();
    }

    @Override // androidx.appcompat.view.b
    public void m(View view) {
        this.f1160d.setCustomView(view);
        this.f1162f = view != null ? new WeakReference(view) : null;
    }

    @Override // androidx.appcompat.view.b
    public void n(int i2) {
        o(this.f1159c.getString(i2));
    }

    @Override // androidx.appcompat.view.b
    public void o(CharSequence charSequence) {
        this.f1160d.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void q(int i2) {
        r(this.f1159c.getString(i2));
    }

    @Override // androidx.appcompat.view.b
    public void r(CharSequence charSequence) {
        this.f1160d.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void s(boolean z2) {
        super.s(z2);
        this.f1160d.setTitleOptional(z2);
    }
}
