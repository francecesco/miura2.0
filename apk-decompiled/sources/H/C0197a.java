package h;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.view.AbstractC0138b;
import it.tervis.miura.model.Peripheral;
import l.InterfaceMenuItemC0216b;

/* JADX INFO: renamed from: h.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0197a implements InterfaceMenuItemC0216b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CharSequence f3593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f3594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Intent f3595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private char f3596g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private char f3598i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Drawable f3600k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Context f3601l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f3602m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private CharSequence f3603n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private CharSequence f3604o;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3597h = Peripheral.EXPANSION_4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3599j = Peripheral.EXPANSION_4;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ColorStateList f3605p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private PorterDuff.Mode f3606q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f3607r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f3608s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f3609t = 16;

    public C0197a(Context context, int i2, int i3, int i4, int i5, CharSequence charSequence) {
        this.f3601l = context;
        this.f3590a = i3;
        this.f3591b = i2;
        this.f3592c = i5;
        this.f3593d = charSequence;
    }

    private void c() {
        Drawable drawable = this.f3600k;
        if (drawable != null) {
            if (this.f3607r || this.f3608s) {
                Drawable drawableP = androidx.core.graphics.drawable.a.p(drawable);
                this.f3600k = drawableP;
                Drawable drawableMutate = drawableP.mutate();
                this.f3600k = drawableMutate;
                if (this.f3607r) {
                    androidx.core.graphics.drawable.a.n(drawableMutate, this.f3605p);
                }
                if (this.f3608s) {
                    androidx.core.graphics.drawable.a.o(this.f3600k, this.f3606q);
                }
            }
        }
    }

    @Override // l.InterfaceMenuItemC0216b
    public InterfaceMenuItemC0216b a(AbstractC0138b abstractC0138b) {
        throw new UnsupportedOperationException();
    }

    @Override // l.InterfaceMenuItemC0216b
    public AbstractC0138b b() {
        return null;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0216b setActionView(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0216b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0216b setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f3599j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f3598i;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f3603n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f3591b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f3600k;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f3605p;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f3606q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f3595f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f3590a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f3597h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f3596g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f3592c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f3593d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f3594e;
        return charSequence != null ? charSequence : this.f3593d;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f3604o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f3609t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f3609t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f3609t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f3609t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.f3598i = Character.toLowerCase(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z2) {
        this.f3609t = (z2 ? 1 : 0) | (this.f3609t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z2) {
        this.f3609t = (z2 ? 2 : 0) | (this.f3609t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z2) {
        this.f3609t = (z2 ? 16 : 0) | (this.f3609t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.f3600k = androidx.core.content.a.d(this.f3601l, i2);
        c();
        return this;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f3605p = colorStateList;
        this.f3607r = true;
        c();
        return this;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f3606q = mode;
        this.f3608s = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f3595f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.f3596g = c2;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f3602m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f3596g = c2;
        this.f3598i = Character.toLowerCase(c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        this.f3593d = this.f3601l.getResources().getString(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f3594e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z2) {
        this.f3609t = (this.f3609t & 8) | (z2 ? 0 : 8);
        return this;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f3598i = Character.toLowerCase(c2);
        this.f3599j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public InterfaceMenuItemC0216b setContentDescription(CharSequence charSequence) {
        this.f3603n = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f3600k = drawable;
        c();
        return this;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f3596g = c2;
        this.f3597h = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f3596g = c2;
        this.f3597h = KeyEvent.normalizeMetaState(i2);
        this.f3598i = Character.toLowerCase(c3);
        this.f3599j = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f3593d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public InterfaceMenuItemC0216b setTooltipText(CharSequence charSequence) {
        this.f3604o = charSequence;
        return this;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public void setShowAsAction(int i2) {
    }
}
