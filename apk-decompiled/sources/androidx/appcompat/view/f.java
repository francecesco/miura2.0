package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import h.MenuItemC0199c;
import java.util.ArrayList;
import k.C0213g;
import l.InterfaceMenuC0215a;
import l.InterfaceMenuItemC0216b;

/* JADX INFO: loaded from: classes.dex */
public class f extends ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f1166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final b f1167b;

    public static class a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ActionMode.Callback f1168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Context f1169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ArrayList f1170c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final C0213g f1171d = new C0213g();

        public a(Context context, ActionMode.Callback callback) {
            this.f1169b = context;
            this.f1168a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = (Menu) this.f1171d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            h.d dVar = new h.d(this.f1169b, (InterfaceMenuC0215a) menu);
            this.f1171d.put(menu, dVar);
            return dVar;
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(b bVar, Menu menu) {
            return this.f1168a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(b bVar, MenuItem menuItem) {
            return this.f1168a.onActionItemClicked(e(bVar), new MenuItemC0199c(this.f1169b, (InterfaceMenuItemC0216b) menuItem));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(b bVar, Menu menu) {
            return this.f1168a.onCreateActionMode(e(bVar), f(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public void d(b bVar) {
            this.f1168a.onDestroyActionMode(e(bVar));
        }

        public ActionMode e(b bVar) {
            int size = this.f1170c.size();
            for (int i2 = 0; i2 < size; i2++) {
                f fVar = (f) this.f1170c.get(i2);
                if (fVar != null && fVar.f1167b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f1169b, bVar);
            this.f1170c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f1166a = context;
        this.f1167b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f1167b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f1167b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new h.d(this.f1166a, (InterfaceMenuC0215a) this.f1167b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f1167b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f1167b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f1167b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f1167b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f1167b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f1167b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f1167b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f1167b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i2) {
        this.f1167b.n(i2);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f1167b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i2) {
        this.f1167b.q(i2);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z2) {
        this.f1167b.s(z2);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f1167b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f1167b.r(charSequence);
    }
}
