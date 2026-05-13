package h;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import k.C0213g;
import l.InterfaceMenuItemC0216b;

/* JADX INFO: renamed from: h.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0198b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f3610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C0213g f3611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C0213g f3612c;

    AbstractC0198b(Context context) {
        this.f3610a = context;
    }

    final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof InterfaceMenuItemC0216b)) {
            return menuItem;
        }
        InterfaceMenuItemC0216b interfaceMenuItemC0216b = (InterfaceMenuItemC0216b) menuItem;
        if (this.f3611b == null) {
            this.f3611b = new C0213g();
        }
        MenuItem menuItem2 = (MenuItem) this.f3611b.get(interfaceMenuItemC0216b);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemC0199c menuItemC0199c = new MenuItemC0199c(this.f3610a, interfaceMenuItemC0216b);
        this.f3611b.put(interfaceMenuItemC0216b, menuItemC0199c);
        return menuItemC0199c;
    }

    final void e() {
        C0213g c0213g = this.f3611b;
        if (c0213g != null) {
            c0213g.clear();
        }
        C0213g c0213g2 = this.f3612c;
        if (c0213g2 != null) {
            c0213g2.clear();
        }
    }

    final void f(int i2) {
        if (this.f3611b == null) {
            return;
        }
        int i3 = 0;
        while (i3 < this.f3611b.size()) {
            if (((InterfaceMenuItemC0216b) this.f3611b.i(i3)).getGroupId() == i2) {
                this.f3611b.j(i3);
                i3--;
            }
            i3++;
        }
    }

    final void g(int i2) {
        if (this.f3611b == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f3611b.size(); i3++) {
            if (((InterfaceMenuItemC0216b) this.f3611b.i(i3)).getItemId() == i2) {
                this.f3611b.j(i3);
                return;
            }
        }
    }

    final SubMenu d(SubMenu subMenu) {
        return subMenu;
    }
}
