package h;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.AbstractC0138b;
import java.lang.reflect.Method;
import l.InterfaceMenuItemC0216b;

/* JADX INFO: renamed from: h.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class MenuItemC0199c extends AbstractC0198b implements MenuItem {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InterfaceMenuItemC0216b f3613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Method f3614e;

    /* JADX INFO: renamed from: h.c$a */
    private class a extends AbstractC0138b implements ActionProvider.VisibilityListener {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private AbstractC0138b.InterfaceC0038b f3615d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ActionProvider f3616e;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f3616e = actionProvider;
        }

        @Override // androidx.core.view.AbstractC0138b
        public boolean a() {
            return this.f3616e.hasSubMenu();
        }

        @Override // androidx.core.view.AbstractC0138b
        public boolean b() {
            return this.f3616e.isVisible();
        }

        @Override // androidx.core.view.AbstractC0138b
        public View c(MenuItem menuItem) {
            return this.f3616e.onCreateActionView(menuItem);
        }

        @Override // androidx.core.view.AbstractC0138b
        public boolean d() {
            return this.f3616e.onPerformDefaultAction();
        }

        @Override // androidx.core.view.AbstractC0138b
        public void e(SubMenu subMenu) {
            this.f3616e.onPrepareSubMenu(MenuItemC0199c.this.d(subMenu));
        }

        @Override // androidx.core.view.AbstractC0138b
        public boolean f() {
            return this.f3616e.overridesItemVisibility();
        }

        @Override // androidx.core.view.AbstractC0138b
        public void i(AbstractC0138b.InterfaceC0038b interfaceC0038b) {
            this.f3615d = interfaceC0038b;
            this.f3616e.setVisibilityListener(interfaceC0038b != null ? this : null);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z2) {
            AbstractC0138b.InterfaceC0038b interfaceC0038b = this.f3615d;
            if (interfaceC0038b != null) {
                interfaceC0038b.onActionProviderVisibilityChanged(z2);
            }
        }
    }

    /* JADX INFO: renamed from: h.c$b */
    static class b extends FrameLayout implements androidx.appcompat.view.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CollapsibleActionView f3618a;

        /* JADX WARN: Multi-variable type inference failed */
        b(View view) {
            super(view.getContext());
            this.f3618a = (CollapsibleActionView) view;
            addView(view);
        }

        View a() {
            return (View) this.f3618a;
        }

        @Override // androidx.appcompat.view.c
        public void c() {
            this.f3618a.onActionViewExpanded();
        }

        @Override // androidx.appcompat.view.c
        public void d() {
            this.f3618a.onActionViewCollapsed();
        }
    }

    /* JADX INFO: renamed from: h.c$c, reason: collision with other inner class name */
    private class MenuItemOnActionExpandListenerC0060c implements MenuItem.OnActionExpandListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f3619a;

        MenuItemOnActionExpandListenerC0060c(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f3619a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f3619a.onMenuItemActionCollapse(MenuItemC0199c.this.c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f3619a.onMenuItemActionExpand(MenuItemC0199c.this.c(menuItem));
        }
    }

    /* JADX INFO: renamed from: h.c$d */
    private class d implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f3621a;

        d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f3621a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f3621a.onMenuItemClick(MenuItemC0199c.this.c(menuItem));
        }
    }

    public MenuItemC0199c(Context context, InterfaceMenuItemC0216b interfaceMenuItemC0216b) {
        super(context);
        if (interfaceMenuItemC0216b == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f3613d = interfaceMenuItemC0216b;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f3613d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f3613d.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        AbstractC0138b abstractC0138bB = this.f3613d.b();
        if (abstractC0138bB instanceof a) {
            return ((a) abstractC0138bB).f3616e;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f3613d.getActionView();
        return actionView instanceof b ? ((b) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f3613d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f3613d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f3613d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f3613d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f3613d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f3613d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f3613d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f3613d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f3613d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f3613d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f3613d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f3613d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f3613d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return d(this.f3613d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f3613d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f3613d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f3613d.getTooltipText();
    }

    public void h(boolean z2) {
        try {
            if (this.f3614e == null) {
                this.f3614e = this.f3613d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f3614e.invoke(this.f3613d, Boolean.valueOf(z2));
        } catch (Exception unused) {
        }
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f3613d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f3613d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f3613d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f3613d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f3613d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f3613d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        a aVar = new a(this.f3610a, actionProvider);
        InterfaceMenuItemC0216b interfaceMenuItemC0216b = this.f3613d;
        if (actionProvider == null) {
            aVar = null;
        }
        interfaceMenuItemC0216b.a(aVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i2) {
        this.f3613d.setActionView(i2);
        View actionView = this.f3613d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f3613d.setActionView(new b(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.f3613d.setAlphabeticShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z2) {
        this.f3613d.setCheckable(z2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z2) {
        this.f3613d.setChecked(z2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f3613d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z2) {
        this.f3613d.setEnabled(z2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.f3613d.setIcon(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f3613d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f3613d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f3613d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.f3613d.setNumericShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f3613d.setOnActionExpandListener(onActionExpandListener != null ? new MenuItemOnActionExpandListenerC0060c(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f3613d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f3613d.setShortcut(c2, c3);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i2) {
        this.f3613d.setShowAsAction(i2);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i2) {
        this.f3613d.setShowAsActionFlags(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        this.f3613d.setTitle(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f3613d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f3613d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z2) {
        return this.f3613d.setVisible(z2);
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        this.f3613d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f3613d.setAlphabeticShortcut(c2, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f3613d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f3613d.setNumericShortcut(c2, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f3613d.setShortcut(c2, c3, i2, i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f3613d.setTitle(charSequence);
        return this;
    }
}
