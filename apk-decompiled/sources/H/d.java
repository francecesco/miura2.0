package h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import l.InterfaceMenuC0215a;

/* JADX INFO: loaded from: classes.dex */
public class d extends AbstractC0198b implements Menu {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InterfaceMenuC0215a f3623d;

    public d(Context context, InterfaceMenuC0215a interfaceMenuC0215a) {
        super(context);
        if (interfaceMenuC0215a == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f3623d = interfaceMenuC0215a;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2) {
        return c(this.f3623d.add(i2));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.f3623d.addIntentOptions(i2, i3, i4, componentName, intentArr, intent, i5, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i6 = 0; i6 < length; i6++) {
                menuItemArr[i6] = c(menuItemArr2[i6]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2) {
        return d(this.f3623d.addSubMenu(i2));
    }

    @Override // android.view.Menu
    public void clear() {
        e();
        this.f3623d.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.f3623d.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i2) {
        return c(this.f3623d.findItem(i2));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i2) {
        return c(this.f3623d.getItem(i2));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f3623d.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return this.f3623d.isShortcutKey(i2, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i2, int i3) {
        return this.f3623d.performIdentifierAction(i2, i3);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        return this.f3623d.performShortcut(i2, keyEvent, i3);
    }

    @Override // android.view.Menu
    public void removeGroup(int i2) {
        f(i2);
        this.f3623d.removeGroup(i2);
    }

    @Override // android.view.Menu
    public void removeItem(int i2) {
        g(i2);
        this.f3623d.removeItem(i2);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i2, boolean z2, boolean z3) {
        this.f3623d.setGroupCheckable(i2, z2, z3);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i2, boolean z2) {
        this.f3623d.setGroupEnabled(i2, z2);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i2, boolean z2) {
        this.f3623d.setGroupVisible(i2, z2);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z2) {
        this.f3623d.setQwertyMode(z2);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f3623d.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, int i5) {
        return c(this.f3623d.add(i2, i3, i4, i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return d(this.f3623d.addSubMenu(i2, i3, i4, i5));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return c(this.f3623d.add(i2, i3, i4, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        return d(this.f3623d.addSubMenu(i2, i3, i4, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return c(this.f3623d.add(charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return d(this.f3623d.addSubMenu(charSequence));
    }
}
