package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.N;
import androidx.appcompat.widget.e0;
import androidx.core.view.AbstractC0138b;
import androidx.core.view.AbstractC0159x;
import h.MenuItemC0199c;
import it.tervis.miura.model.Peripheral;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import l.InterfaceMenuC0215a;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class g extends MenuInflater {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Class[] f1172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Class[] f1173f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object[] f1174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object[] f1175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Context f1176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f1177d;

    private static class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Class[] f1178c = {MenuItem.class};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f1179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Method f1180b;

        public a(Object obj, String str) {
            this.f1179a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f1180b = cls.getMethod(str, f1178c);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1180b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1180b.invoke(this.f1179a, menuItem)).booleanValue();
                }
                this.f1180b.invoke(this.f1179a, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private class b {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        AbstractC0138b f1181A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        private CharSequence f1182B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        private CharSequence f1183C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        private ColorStateList f1184D = null;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        private PorterDuff.Mode f1185E = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Menu f1187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1190d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1191e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f1192f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f1193g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f1194h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f1195i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f1196j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private CharSequence f1197k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private CharSequence f1198l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f1199m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private char f1200n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f1201o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private char f1202p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f1203q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f1204r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f1205s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private boolean f1206t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private boolean f1207u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f1208v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private int f1209w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private String f1210x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private String f1211y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private String f1212z;

        public b(Menu menu) {
            this.f1187a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private Object e(String str, Class[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f1176c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot instantiate class: ");
                sb.append(str);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z2 = false;
            menuItem.setChecked(this.f1205s).setVisible(this.f1206t).setEnabled(this.f1207u).setCheckable(this.f1204r >= 1).setTitleCondensed(this.f1198l).setIcon(this.f1199m);
            int i2 = this.f1208v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.f1212z != null) {
                if (g.this.f1176c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f1212z));
            }
            if (this.f1204r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.g) {
                    ((androidx.appcompat.view.menu.g) menuItem).t(true);
                } else if (menuItem instanceof MenuItemC0199c) {
                    ((MenuItemC0199c) menuItem).h(true);
                }
            }
            String str = this.f1210x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f1172e, g.this.f1174a));
                z2 = true;
            }
            int i3 = this.f1209w;
            if (i3 > 0 && !z2) {
                menuItem.setActionView(i3);
            }
            AbstractC0138b abstractC0138b = this.f1181A;
            if (abstractC0138b != null) {
                AbstractC0159x.a(menuItem, abstractC0138b);
            }
            AbstractC0159x.c(menuItem, this.f1182B);
            AbstractC0159x.g(menuItem, this.f1183C);
            AbstractC0159x.b(menuItem, this.f1200n, this.f1201o);
            AbstractC0159x.f(menuItem, this.f1202p, this.f1203q);
            PorterDuff.Mode mode = this.f1185E;
            if (mode != null) {
                AbstractC0159x.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.f1184D;
            if (colorStateList != null) {
                AbstractC0159x.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f1194h = true;
            i(this.f1187a.add(this.f1188b, this.f1195i, this.f1196j, this.f1197k));
        }

        public SubMenu b() {
            this.f1194h = true;
            SubMenu subMenuAddSubMenu = this.f1187a.addSubMenu(this.f1188b, this.f1195i, this.f1196j, this.f1197k);
            i(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public boolean d() {
            return this.f1194h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.f1176c.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
            this.f1188b = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
            this.f1189c = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
            this.f1190d = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
            this.f1191e = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
            this.f1192f = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, true);
            this.f1193g = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void g(AttributeSet attributeSet) {
            e0 e0VarT = e0.t(g.this.f1176c, attributeSet, R$styleable.MenuItem);
            this.f1195i = e0VarT.m(R$styleable.MenuItem_android_id, 0);
            this.f1196j = (e0VarT.j(R$styleable.MenuItem_android_menuCategory, this.f1189c) & (-65536)) | (e0VarT.j(R$styleable.MenuItem_android_orderInCategory, this.f1190d) & 65535);
            this.f1197k = e0VarT.o(R$styleable.MenuItem_android_title);
            this.f1198l = e0VarT.o(R$styleable.MenuItem_android_titleCondensed);
            this.f1199m = e0VarT.m(R$styleable.MenuItem_android_icon, 0);
            this.f1200n = c(e0VarT.n(R$styleable.MenuItem_android_alphabeticShortcut));
            this.f1201o = e0VarT.j(R$styleable.MenuItem_alphabeticModifiers, Peripheral.EXPANSION_4);
            this.f1202p = c(e0VarT.n(R$styleable.MenuItem_android_numericShortcut));
            this.f1203q = e0VarT.j(R$styleable.MenuItem_numericModifiers, Peripheral.EXPANSION_4);
            this.f1204r = e0VarT.r(R$styleable.MenuItem_android_checkable) ? e0VarT.a(R$styleable.MenuItem_android_checkable, false) : this.f1191e;
            this.f1205s = e0VarT.a(R$styleable.MenuItem_android_checked, false);
            this.f1206t = e0VarT.a(R$styleable.MenuItem_android_visible, this.f1192f);
            this.f1207u = e0VarT.a(R$styleable.MenuItem_android_enabled, this.f1193g);
            this.f1208v = e0VarT.j(R$styleable.MenuItem_showAsAction, -1);
            this.f1212z = e0VarT.n(R$styleable.MenuItem_android_onClick);
            this.f1209w = e0VarT.m(R$styleable.MenuItem_actionLayout, 0);
            this.f1210x = e0VarT.n(R$styleable.MenuItem_actionViewClass);
            String strN = e0VarT.n(R$styleable.MenuItem_actionProviderClass);
            this.f1211y = strN;
            if (strN != null && this.f1209w == 0 && this.f1210x == null) {
                this.f1181A = (AbstractC0138b) e(strN, g.f1173f, g.this.f1175b);
            } else {
                this.f1181A = null;
            }
            this.f1182B = e0VarT.o(R$styleable.MenuItem_contentDescription);
            this.f1183C = e0VarT.o(R$styleable.MenuItem_tooltipText);
            if (e0VarT.r(R$styleable.MenuItem_iconTintMode)) {
                this.f1185E = N.c(e0VarT.j(R$styleable.MenuItem_iconTintMode, -1), this.f1185E);
            } else {
                this.f1185E = null;
            }
            if (e0VarT.r(R$styleable.MenuItem_iconTint)) {
                this.f1184D = e0VarT.c(R$styleable.MenuItem_iconTint);
            } else {
                this.f1184D = null;
            }
            e0VarT.w();
            this.f1194h = false;
        }

        public void h() {
            this.f1188b = 0;
            this.f1189c = 0;
            this.f1190d = 0;
            this.f1191e = 0;
            this.f1192f = true;
            this.f1193g = true;
        }
    }

    static {
        Class[] clsArr = {Context.class};
        f1172e = clsArr;
        f1173f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f1176c = context;
        Object[] objArr = {context};
        this.f1174a = objArr;
        this.f1175b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z3 && name2.equals(str)) {
                        str = null;
                        z3 = false;
                    } else if (name2.equals("group")) {
                        bVar.h();
                    } else if (name2.equals("item")) {
                        if (!bVar.d()) {
                            AbstractC0138b abstractC0138b = bVar.f1181A;
                            if (abstractC0138b == null || !abstractC0138b.a()) {
                                bVar.a();
                            } else {
                                bVar.b();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z2 = true;
                    }
                }
            } else if (!z3) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.f(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.g(attributeSet);
                } else if (name3.equals("menu")) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z3 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    Object b() {
        if (this.f1177d == null) {
            this.f1177d = a(this.f1176c);
        }
        return this.f1177d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i2, Menu menu) {
        if (!(menu instanceof InterfaceMenuC0215a)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser layout = null;
        boolean z2 = false;
        try {
            try {
                layout = this.f1176c.getResources().getLayout(i2);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
                if (menu instanceof androidx.appcompat.view.menu.e) {
                    androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) menu;
                    if (eVar.F()) {
                        eVar.e0();
                        z2 = true;
                    }
                }
                c(layout, attributeSetAsAttributeSet, menu);
                if (z2) {
                    ((androidx.appcompat.view.menu.e) menu).d0();
                }
                if (layout != null) {
                    layout.close();
                }
            } catch (IOException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } catch (Throwable th) {
            if (z2) {
                ((androidx.appcompat.view.menu.e) menu).d0();
            }
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
