package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R$string;
import androidx.appcompat.view.menu.k;
import androidx.core.view.AbstractC0138b;
import e.AbstractC0190a;
import it.tervis.miura.model.Peripheral;
import l.InterfaceMenuItemC0216b;

/* JADX INFO: loaded from: classes.dex */
public final class g implements InterfaceMenuItemC0216b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private View f1350A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private AbstractC0138b f1351B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private MenuItem.OnActionExpandListener f1352C;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f1354E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f1355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f1357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f1358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f1359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CharSequence f1360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Intent f1361g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private char f1362h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private char f1364j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Drawable f1366l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    e f1368n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private m f1369o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Runnable f1370p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f1371q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CharSequence f1372r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private CharSequence f1373s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f1380z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1363i = Peripheral.EXPANSION_4;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1365k = Peripheral.EXPANSION_4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f1367m = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ColorStateList f1374t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private PorterDuff.Mode f1375u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f1376v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f1377w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f1378x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f1379y = 16;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private boolean f1353D = false;

    class a implements AbstractC0138b.InterfaceC0038b {
        a() {
        }

        @Override // androidx.core.view.AbstractC0138b.InterfaceC0038b
        public void onActionProviderVisibilityChanged(boolean z2) {
            g gVar = g.this;
            gVar.f1368n.K(gVar);
        }
    }

    g(e eVar, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.f1368n = eVar;
        this.f1355a = i3;
        this.f1356b = i2;
        this.f1357c = i4;
        this.f1358d = i5;
        this.f1359e = charSequence;
        this.f1380z = i6;
    }

    private static void d(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.f1378x && (this.f1376v || this.f1377w)) {
            drawable = androidx.core.graphics.drawable.a.p(drawable).mutate();
            if (this.f1376v) {
                androidx.core.graphics.drawable.a.n(drawable, this.f1374t);
            }
            if (this.f1377w) {
                androidx.core.graphics.drawable.a.o(drawable, this.f1375u);
            }
            this.f1378x = false;
        }
        return drawable;
    }

    boolean A() {
        return this.f1368n.I() && g() != 0;
    }

    public boolean B() {
        return (this.f1380z & 4) == 4;
    }

    @Override // l.InterfaceMenuItemC0216b
    public InterfaceMenuItemC0216b a(AbstractC0138b abstractC0138b) {
        AbstractC0138b abstractC0138b2 = this.f1351B;
        if (abstractC0138b2 != null) {
            abstractC0138b2.g();
        }
        this.f1350A = null;
        this.f1351B = abstractC0138b;
        this.f1368n.L(true);
        AbstractC0138b abstractC0138b3 = this.f1351B;
        if (abstractC0138b3 != null) {
            abstractC0138b3.i(new a());
        }
        return this;
    }

    @Override // l.InterfaceMenuItemC0216b
    public AbstractC0138b b() {
        return this.f1351B;
    }

    public void c() {
        this.f1368n.J(this);
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f1380z & 8) == 0) {
            return false;
        }
        if (this.f1350A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f1352C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f1368n.f(this);
        }
        return false;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f1352C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f1368n.k(this);
        }
        return false;
    }

    public int f() {
        return this.f1358d;
    }

    char g() {
        return this.f1368n.H() ? this.f1364j : this.f1362h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public View getActionView() {
        View view = this.f1350A;
        if (view != null) {
            return view;
        }
        AbstractC0138b abstractC0138b = this.f1351B;
        if (abstractC0138b == null) {
            return null;
        }
        View viewC = abstractC0138b.c(this);
        this.f1350A = viewC;
        return viewC;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1365k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1364j;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1372r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1356b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f1366l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f1367m == 0) {
            return null;
        }
        Drawable drawableB = AbstractC0190a.b(this.f1368n.u(), this.f1367m);
        this.f1367m = 0;
        this.f1366l = drawableB;
        return e(drawableB);
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1374t;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1375u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1361g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1355a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1354E;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1363i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1362h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1357c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f1369o;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1359e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1360f;
        return charSequence != null ? charSequence : this.f1359e;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1373s;
    }

    String h() {
        int i2;
        char cG = g();
        if (cG == 0) {
            return "";
        }
        Resources resources = this.f1368n.u().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f1368n.u()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R$string.abc_prepend_shortcut_label));
        }
        int i3 = this.f1368n.H() ? this.f1365k : this.f1363i;
        d(sb, i3, Peripheral.EXPANSION_8, resources.getString(R$string.abc_menu_meta_shortcut_label));
        d(sb, i3, Peripheral.EXPANSION_4, resources.getString(R$string.abc_menu_ctrl_shortcut_label));
        d(sb, i3, 2, resources.getString(R$string.abc_menu_alt_shortcut_label));
        d(sb, i3, 1, resources.getString(R$string.abc_menu_shift_shortcut_label));
        d(sb, i3, 4, resources.getString(R$string.abc_menu_sym_shortcut_label));
        d(sb, i3, 8, resources.getString(R$string.abc_menu_function_shortcut_label));
        if (cG == '\b') {
            i2 = R$string.abc_menu_delete_shortcut_label;
        } else if (cG == '\n') {
            i2 = R$string.abc_menu_enter_shortcut_label;
        } else {
            if (cG != ' ') {
                sb.append(cG);
                return sb.toString();
            }
            i2 = R$string.abc_menu_space_shortcut_label;
        }
        sb.append(resources.getString(i2));
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1369o != null;
    }

    CharSequence i(k.a aVar) {
        return (aVar == null || !aVar.c()) ? getTitle() : getTitleCondensed();
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f1353D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1379y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1379y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1379y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        AbstractC0138b abstractC0138b = this.f1351B;
        return (abstractC0138b == null || !abstractC0138b.f()) ? (this.f1379y & 8) == 0 : (this.f1379y & 8) == 0 && this.f1351B.b();
    }

    public boolean j() {
        AbstractC0138b abstractC0138b;
        if ((this.f1380z & 8) == 0) {
            return false;
        }
        if (this.f1350A == null && (abstractC0138b = this.f1351B) != null) {
            this.f1350A = abstractC0138b.c(this);
        }
        return this.f1350A != null;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f1371q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        e eVar = this.f1368n;
        if (eVar.h(eVar, this)) {
            return true;
        }
        Runnable runnable = this.f1370p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f1361g != null) {
            try {
                this.f1368n.u().startActivity(this.f1361g);
                return true;
            } catch (ActivityNotFoundException unused) {
            }
        }
        AbstractC0138b abstractC0138b = this.f1351B;
        return abstractC0138b != null && abstractC0138b.d();
    }

    public boolean l() {
        return (this.f1379y & 32) == 32;
    }

    public boolean m() {
        return (this.f1379y & 4) != 0;
    }

    public boolean n() {
        return (this.f1380z & 1) == 1;
    }

    public boolean o() {
        return (this.f1380z & 2) == 2;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0216b setActionView(int i2) {
        Context contextU = this.f1368n.u();
        setActionView(LayoutInflater.from(contextU).inflate(i2, (ViewGroup) new LinearLayout(contextU), false));
        return this;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0216b setActionView(View view) {
        int i2;
        this.f1350A = view;
        this.f1351B = null;
        if (view != null && view.getId() == -1 && (i2 = this.f1355a) > 0) {
            view.setId(i2);
        }
        this.f1368n.J(this);
        return this;
    }

    public void r(boolean z2) {
        this.f1353D = z2;
        this.f1368n.L(false);
    }

    void s(boolean z2) {
        int i2 = this.f1379y;
        int i3 = (z2 ? 2 : 0) | (i2 & (-3));
        this.f1379y = i3;
        if (i2 != i3) {
            this.f1368n.L(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.f1364j == c2) {
            return this;
        }
        this.f1364j = Character.toLowerCase(c2);
        this.f1368n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z2) {
        int i2 = this.f1379y;
        int i3 = (z2 ? 1 : 0) | (i2 & (-2));
        this.f1379y = i3;
        if (i2 != i3) {
            this.f1368n.L(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z2) {
        if ((this.f1379y & 4) != 0) {
            this.f1368n.U(this);
        } else {
            s(z2);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z2) {
        this.f1379y = z2 ? this.f1379y | 16 : this.f1379y & (-17);
        this.f1368n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.f1366l = null;
        this.f1367m = i2;
        this.f1378x = true;
        this.f1368n.L(false);
        return this;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1374t = colorStateList;
        this.f1376v = true;
        this.f1378x = true;
        this.f1368n.L(false);
        return this;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1375u = mode;
        this.f1377w = true;
        this.f1378x = true;
        this.f1368n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1361g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        if (this.f1362h == c2) {
            return this;
        }
        this.f1362h = c2;
        this.f1368n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f1352C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1371q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f1362h = c2;
        this.f1364j = Character.toLowerCase(c3);
        this.f1368n.L(false);
        return this;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f1380z = i2;
        this.f1368n.J(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        return setTitle(this.f1368n.u().getString(i2));
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1360f = charSequence;
        this.f1368n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z2) {
        if (y(z2)) {
            this.f1368n.K(this);
        }
        return this;
    }

    public void t(boolean z2) {
        this.f1379y = (z2 ? 4 : 0) | (this.f1379y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.f1359e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z2) {
        this.f1379y = z2 ? this.f1379y | 32 : this.f1379y & (-33);
    }

    void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f1354E = contextMenuInfo;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0216b setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public void x(m mVar) {
        this.f1369o = mVar;
        mVar.setHeaderTitle(getTitle());
    }

    boolean y(boolean z2) {
        int i2 = this.f1379y;
        int i3 = (z2 ? 0 : 8) | (i2 & (-9));
        this.f1379y = i3;
        return i2 != i3;
    }

    public boolean z() {
        return this.f1368n.A();
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.f1364j == c2 && this.f1365k == i2) {
            return this;
        }
        this.f1364j = Character.toLowerCase(c2);
        this.f1365k = KeyEvent.normalizeMetaState(i2);
        this.f1368n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public InterfaceMenuItemC0216b setContentDescription(CharSequence charSequence) {
        this.f1372r = charSequence;
        this.f1368n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1367m = 0;
        this.f1366l = drawable;
        this.f1378x = true;
        this.f1368n.L(false);
        return this;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i2) {
        if (this.f1362h == c2 && this.f1363i == i2) {
            return this;
        }
        this.f1362h = c2;
        this.f1363i = KeyEvent.normalizeMetaState(i2);
        this.f1368n.L(false);
        return this;
    }

    @Override // l.InterfaceMenuItemC0216b, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f1362h = c2;
        this.f1363i = KeyEvent.normalizeMetaState(i2);
        this.f1364j = Character.toLowerCase(c3);
        this.f1365k = KeyEvent.normalizeMetaState(i3);
        this.f1368n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1359e = charSequence;
        this.f1368n.L(false);
        m mVar = this.f1369o;
        if (mVar != null) {
            mVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public InterfaceMenuItemC0216b setTooltipText(CharSequence charSequence) {
        this.f1373s = charSequence;
        this.f1368n.L(false);
        return this;
    }
}
