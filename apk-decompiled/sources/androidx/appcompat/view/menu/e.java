package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import l.InterfaceMenuC0215a;

/* JADX INFO: loaded from: classes.dex */
public class e implements InterfaceMenuC0215a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private static final int[] f1319A = {1, 4, 5, 3, 2, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f1321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f1324e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f1332m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    CharSequence f1333n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Drawable f1334o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    View f1335p;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private g f1343x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f1345z;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1331l = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f1336q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f1337r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f1338s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f1339t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f1340u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ArrayList f1341v = new ArrayList();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private CopyOnWriteArrayList f1342w = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f1344y = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList f1325f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList f1326g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1327h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList f1328i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList f1329j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f1330k = true;

    public interface a {
        boolean a(e eVar, MenuItem menuItem);

        void b(e eVar);
    }

    public interface b {
        boolean a(g gVar);
    }

    public e(Context context) {
        this.f1320a = context;
        this.f1321b = context.getResources();
        c0(true);
    }

    private static int B(int i2) {
        int i3 = ((-65536) & i2) >> 16;
        if (i3 >= 0) {
            int[] iArr = f1319A;
            if (i3 < iArr.length) {
                return (i2 & 65535) | (iArr[i3] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void O(int i2, boolean z2) {
        if (i2 < 0 || i2 >= this.f1325f.size()) {
            return;
        }
        this.f1325f.remove(i2);
        if (z2) {
            L(true);
        }
    }

    private void X(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources resourcesC = C();
        if (view != null) {
            this.f1335p = view;
            this.f1333n = null;
            this.f1334o = null;
        } else {
            if (i2 > 0) {
                this.f1333n = resourcesC.getText(i2);
            } else if (charSequence != null) {
                this.f1333n = charSequence;
            }
            if (i3 > 0) {
                this.f1334o = androidx.core.content.a.d(u(), i3);
            } else if (drawable != null) {
                this.f1334o = drawable;
            }
            this.f1335p = null;
        }
        L(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c0(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L1c
            android.content.res.Resources r3 = r2.f1321b
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L1c
            android.content.Context r3 = r2.f1320a
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.f1320a
            boolean r3 = androidx.core.view.P.i(r3, r1)
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            r0 = 0
        L1d:
            r2.f1323d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.e.c0(boolean):void");
    }

    private g g(int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        return new g(this, i2, i3, i4, i5, charSequence, i6);
    }

    private void i(boolean z2) {
        if (this.f1342w.isEmpty()) {
            return;
        }
        e0();
        for (WeakReference weakReference : this.f1342w) {
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                this.f1342w.remove(weakReference);
            } else {
                jVar.j(z2);
            }
        }
        d0();
    }

    private boolean j(m mVar, j jVar) {
        if (this.f1342w.isEmpty()) {
            return false;
        }
        boolean zI = jVar != null ? jVar.i(mVar) : false;
        for (WeakReference weakReference : this.f1342w) {
            j jVar2 = (j) weakReference.get();
            if (jVar2 == null) {
                this.f1342w.remove(weakReference);
            } else if (!zI) {
                zI = jVar2.i(mVar);
            }
        }
        return zI;
    }

    private static int n(ArrayList arrayList, int i2) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((g) arrayList.get(size)).f() <= i2) {
                return size + 1;
            }
        }
        return 0;
    }

    boolean A() {
        return this.f1339t;
    }

    Resources C() {
        return this.f1321b;
    }

    public e D() {
        return this;
    }

    public ArrayList E() {
        if (!this.f1327h) {
            return this.f1326g;
        }
        this.f1326g.clear();
        int size = this.f1325f.size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) this.f1325f.get(i2);
            if (gVar.isVisible()) {
                this.f1326g.add(gVar);
            }
        }
        this.f1327h = false;
        this.f1330k = true;
        return this.f1326g;
    }

    public boolean F() {
        return !this.f1336q;
    }

    public boolean G() {
        return this.f1344y;
    }

    boolean H() {
        return this.f1322c;
    }

    public boolean I() {
        return this.f1323d;
    }

    void J(g gVar) {
        this.f1330k = true;
        L(true);
    }

    void K(g gVar) {
        this.f1327h = true;
        L(true);
    }

    public void L(boolean z2) {
        if (this.f1336q) {
            this.f1337r = true;
            if (z2) {
                this.f1338s = true;
                return;
            }
            return;
        }
        if (z2) {
            this.f1327h = true;
            this.f1330k = true;
        }
        i(z2);
    }

    public boolean M(MenuItem menuItem, int i2) {
        return N(menuItem, null, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d A[PHI: r1
      0x002d: PHI (r1v4 boolean) = (r1v2 boolean), (r1v1 boolean), (r1v5 boolean) binds: [B:35:0x0068, B:23:0x003c, B:16:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean N(android.view.MenuItem r7, androidx.appcompat.view.menu.j r8, int r9) {
        /*
            r6 = this;
            androidx.appcompat.view.menu.g r7 = (androidx.appcompat.view.menu.g) r7
            r0 = 0
            if (r7 == 0) goto L6c
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Lc
            goto L6c
        Lc:
            boolean r1 = r7.k()
            androidx.core.view.b r2 = r7.b()
            r3 = 1
            if (r2 == 0) goto L1f
            boolean r4 = r2.a()
            if (r4 == 0) goto L1f
            r4 = 1
            goto L20
        L1f:
            r4 = 0
        L20:
            boolean r5 = r7.j()
            if (r5 == 0) goto L31
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto L6b
        L2d:
            r6.e(r3)
            goto L6b
        L31:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L3f
            if (r4 == 0) goto L3a
            goto L3f
        L3a:
            r7 = r9 & 1
            if (r7 != 0) goto L6b
            goto L2d
        L3f:
            r9 = r9 & 4
            if (r9 != 0) goto L46
            r6.e(r0)
        L46:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L58
            androidx.appcompat.view.menu.m r9 = new androidx.appcompat.view.menu.m
            android.content.Context r0 = r6.u()
            r9.<init>(r0, r6, r7)
            r7.x(r9)
        L58:
            android.view.SubMenu r7 = r7.getSubMenu()
            androidx.appcompat.view.menu.m r7 = (androidx.appcompat.view.menu.m) r7
            if (r4 == 0) goto L63
            r2.e(r7)
        L63:
            boolean r7 = r6.j(r7, r8)
            r1 = r1 | r7
            if (r1 != 0) goto L6b
            goto L2d
        L6b:
            return r1
        L6c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.e.N(android.view.MenuItem, androidx.appcompat.view.menu.j, int):boolean");
    }

    public void P(j jVar) {
        for (WeakReference weakReference : this.f1342w) {
            j jVar2 = (j) weakReference.get();
            if (jVar2 == null || jVar2 == jVar) {
                this.f1342w.remove(weakReference);
            }
        }
    }

    public void Q(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(t());
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).Q(bundle);
            }
        }
        int i3 = bundle.getInt("android:menu:expandedactionview");
        if (i3 <= 0 || (menuItemFindItem = findItem(i3)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public void R(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).R(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(t(), sparseArray);
        }
    }

    public void S(a aVar) {
        this.f1324e = aVar;
    }

    public e T(int i2) {
        this.f1331l = i2;
        return this;
    }

    void U(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1325f.size();
        e0();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) this.f1325f.get(i2);
            if (gVar.getGroupId() == groupId && gVar.m() && gVar.isCheckable()) {
                gVar.s(gVar == menuItem);
            }
        }
        d0();
    }

    protected e V(int i2) {
        X(0, null, i2, null, null);
        return this;
    }

    protected e W(Drawable drawable) {
        X(0, null, 0, drawable, null);
        return this;
    }

    protected e Y(int i2) {
        X(i2, null, 0, null, null);
        return this;
    }

    protected e Z(CharSequence charSequence) {
        X(0, charSequence, 0, null, null);
        return this;
    }

    protected MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int iB = B(i4);
        g gVarG = g(i2, i3, i4, iB, charSequence, this.f1331l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f1332m;
        if (contextMenuInfo != null) {
            gVarG.v(contextMenuInfo);
        }
        ArrayList arrayList = this.f1325f;
        arrayList.add(n(arrayList, iB), gVarG);
        L(true);
        return gVarG;
    }

    protected e a0(View view) {
        X(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2) {
        return a(0, 0, 0, this.f1321b.getString(i2));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        int i6;
        PackageManager packageManager = this.f1320a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i7 = 0; i7 < size; i7++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i7);
            int i8 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i8 < 0 ? intent : intentArr[i8]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i2, i3, i4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i6 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i6] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, this.f1321b.getString(i2));
    }

    public void b(j jVar) {
        c(jVar, this.f1320a);
    }

    public void b0(boolean z2) {
        this.f1345z = z2;
    }

    public void c(j jVar, Context context) {
        this.f1342w.add(new WeakReference(jVar));
        jVar.d(context, this);
        this.f1330k = true;
    }

    @Override // android.view.Menu
    public void clear() {
        g gVar = this.f1343x;
        if (gVar != null) {
            f(gVar);
        }
        this.f1325f.clear();
        L(true);
    }

    public void clearHeader() {
        this.f1334o = null;
        this.f1333n = null;
        this.f1335p = null;
        L(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f1324e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void d0() {
        this.f1336q = false;
        if (this.f1337r) {
            this.f1337r = false;
            L(this.f1338s);
        }
    }

    public final void e(boolean z2) {
        if (this.f1340u) {
            return;
        }
        this.f1340u = true;
        for (WeakReference weakReference : this.f1342w) {
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                this.f1342w.remove(weakReference);
            } else {
                jVar.a(this, z2);
            }
        }
        this.f1340u = false;
    }

    public void e0() {
        if (this.f1336q) {
            return;
        }
        this.f1336q = true;
        this.f1337r = false;
        this.f1338s = false;
    }

    public boolean f(g gVar) {
        boolean zE = false;
        if (!this.f1342w.isEmpty() && this.f1343x == gVar) {
            e0();
            for (WeakReference weakReference : this.f1342w) {
                j jVar = (j) weakReference.get();
                if (jVar != null) {
                    zE = jVar.e(this, gVar);
                    if (zE) {
                        break;
                    }
                } else {
                    this.f1342w.remove(weakReference);
                }
            }
            d0();
            if (zE) {
                this.f1343x = null;
            }
        }
        return zE;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i2) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = (g) this.f1325f.get(i3);
            if (gVar.getItemId() == i2) {
                return gVar;
            }
            if (gVar.hasSubMenu() && (menuItemFindItem = gVar.getSubMenu().findItem(i2)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i2) {
        return (MenuItem) this.f1325f.get(i2);
    }

    boolean h(e eVar, MenuItem menuItem) {
        a aVar = this.f1324e;
        return aVar != null && aVar.a(eVar, menuItem);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f1345z) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((g) this.f1325f.get(i2)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return p(i2, keyEvent) != null;
    }

    public boolean k(g gVar) {
        boolean zG = false;
        if (this.f1342w.isEmpty()) {
            return false;
        }
        e0();
        for (WeakReference weakReference : this.f1342w) {
            j jVar = (j) weakReference.get();
            if (jVar != null) {
                zG = jVar.g(this, gVar);
                if (zG) {
                    break;
                }
            } else {
                this.f1342w.remove(weakReference);
            }
        }
        d0();
        if (zG) {
            this.f1343x = gVar;
        }
        return zG;
    }

    public int l(int i2) {
        return m(i2, 0);
    }

    public int m(int i2, int i3) {
        int size = size();
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < size) {
            if (((g) this.f1325f.get(i3)).getGroupId() == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public int o(int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((g) this.f1325f.get(i3)).getItemId() == i2) {
                return i3;
            }
        }
        return -1;
    }

    g p(int i2, KeyEvent keyEvent) {
        ArrayList arrayList = this.f1341v;
        arrayList.clear();
        q(arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (g) arrayList.get(0);
        }
        boolean zH = H();
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = (g) arrayList.get(i3);
            char alphabeticShortcut = zH ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zH && alphabeticShortcut == '\b' && i2 == 67))) {
                return gVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i2, int i3) {
        return M(findItem(i2), i3);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        g gVarP = p(i2, keyEvent);
        boolean zM = gVarP != null ? M(gVarP, i3) : false;
        if ((i3 & 2) != 0) {
            e(true);
        }
        return zM;
    }

    void q(List list, int i2, KeyEvent keyEvent) {
        boolean zH = H();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.f1325f.size();
            for (int i3 = 0; i3 < size; i3++) {
                g gVar = (g) this.f1325f.get(i3);
                if (gVar.hasSubMenu()) {
                    ((e) gVar.getSubMenu()).q(list, i2, keyEvent);
                }
                char alphabeticShortcut = zH ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
                if ((modifiers & 69647) == ((zH ? gVar.getAlphabeticModifiers() : gVar.getNumericModifiers()) & 69647) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zH && alphabeticShortcut == '\b' && i2 == 67)) && gVar.isEnabled()) {
                        list.add(gVar);
                    }
                }
            }
        }
    }

    public void r() {
        ArrayList arrayListE = E();
        if (this.f1330k) {
            boolean zC = false;
            for (WeakReference weakReference : this.f1342w) {
                j jVar = (j) weakReference.get();
                if (jVar == null) {
                    this.f1342w.remove(weakReference);
                } else {
                    zC |= jVar.c();
                }
            }
            if (zC) {
                this.f1328i.clear();
                this.f1329j.clear();
                int size = arrayListE.size();
                for (int i2 = 0; i2 < size; i2++) {
                    g gVar = (g) arrayListE.get(i2);
                    (gVar.l() ? this.f1328i : this.f1329j).add(gVar);
                }
            } else {
                this.f1328i.clear();
                this.f1329j.clear();
                this.f1329j.addAll(E());
            }
            this.f1330k = false;
        }
    }

    @Override // android.view.Menu
    public void removeGroup(int i2) {
        int iL = l(i2);
        if (iL >= 0) {
            int size = this.f1325f.size() - iL;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size || ((g) this.f1325f.get(iL)).getGroupId() != i2) {
                    break;
                }
                O(iL, false);
                i3 = i4;
            }
            L(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i2) {
        O(o(i2), true);
    }

    public ArrayList s() {
        r();
        return this.f1328i;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i2, boolean z2, boolean z3) {
        int size = this.f1325f.size();
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = (g) this.f1325f.get(i3);
            if (gVar.getGroupId() == i2) {
                gVar.t(z3);
                gVar.setCheckable(z2);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z2) {
        this.f1344y = z2;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i2, boolean z2) {
        int size = this.f1325f.size();
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = (g) this.f1325f.get(i3);
            if (gVar.getGroupId() == i2) {
                gVar.setEnabled(z2);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i2, boolean z2) {
        int size = this.f1325f.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = (g) this.f1325f.get(i3);
            if (gVar.getGroupId() == i2 && gVar.y(z2)) {
                z3 = true;
            }
        }
        if (z3) {
            L(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z2) {
        this.f1322c = z2;
        L(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1325f.size();
    }

    protected String t() {
        return "android:menu:actionviewstates";
    }

    public Context u() {
        return this.f1320a;
    }

    public g v() {
        return this.f1343x;
    }

    public Drawable w() {
        return this.f1334o;
    }

    public CharSequence x() {
        return this.f1333n;
    }

    public View y() {
        return this.f1335p;
    }

    public ArrayList z() {
        r();
        return this.f1329j;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.f1321b.getString(i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, this.f1321b.getString(i5));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        g gVar = (g) a(i2, i3, i4, charSequence);
        m mVar = new m(this.f1320a, this, gVar);
        gVar.x(mVar);
        return mVar;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }
}
