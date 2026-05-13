package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.AbstractC0106b;
import androidx.appcompat.view.b;
import androidx.appcompat.view.f;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C0122k;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.L;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.o0;
import androidx.appcompat.widget.p0;
import androidx.core.content.res.h;
import androidx.core.view.AbstractC0155t;
import androidx.core.view.AbstractC0156u;
import androidx.core.view.U;
import androidx.core.view.W;
import androidx.core.view.Y;
import androidx.lifecycle.AbstractC0183g;
import e.AbstractC0190a;
import it.tervis.miura.model.Peripheral;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import k.C0213g;
import o.AbstractC0234c;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
class i extends AbstractC0111g implements e.a, LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private static final C0213g f1035j0 = new C0213g();

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private static final boolean f1036k0 = false;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private static final int[] f1037l0 = {R.attr.windowBackground};

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private static final boolean f1038m0 = !"robolectric".equals(Build.FINGERPRINT);

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private boolean f1039A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    ViewGroup f1040B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private TextView f1041C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private View f1042D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private boolean f1043E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private boolean f1044F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    boolean f1045G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    boolean f1046H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    boolean f1047I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    boolean f1048J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    boolean f1049K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private boolean f1050L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private r[] f1051M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private r f1052N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private boolean f1053O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private boolean f1054P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private boolean f1055Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    boolean f1056R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private Configuration f1057S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private int f1058T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    private int f1059U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    private int f1060V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    private boolean f1061W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    private o f1062X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    private o f1063Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    boolean f1064Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    int f1065a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final Runnable f1066b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private boolean f1067c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private Rect f1068d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private Rect f1069e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private z f1070f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private B f1071g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private OnBackInvokedDispatcher f1072h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private OnBackInvokedCallback f1073i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final Object f1074j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final Context f1075k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Window f1076l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private m f1077m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final InterfaceC0109e f1078n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    AbstractC0105a f1079o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    MenuInflater f1080p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CharSequence f1081q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private L f1082r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private g f1083s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private s f1084t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    androidx.appcompat.view.b f1085u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    ActionBarContextView f1086v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    PopupWindow f1087w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    Runnable f1088x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    U f1089y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f1090z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar = i.this;
            if ((iVar.f1065a0 & 1) != 0) {
                iVar.h0(0);
            }
            i iVar2 = i.this;
            if ((iVar2.f1065a0 & Peripheral.EXPANSION_4) != 0) {
                iVar2.h0(108);
            }
            i iVar3 = i.this;
            iVar3.f1064Z = false;
            iVar3.f1065a0 = 0;
        }
    }

    class b implements androidx.core.view.E {
        b() {
        }

        @Override // androidx.core.view.E
        public Y a(View view, Y y2) {
            int iK = y2.k();
            int iE1 = i.this.e1(y2, null);
            if (iK != iE1) {
                y2 = y2.o(y2.i(), iE1, y2.j(), y2.h());
            }
            return androidx.core.view.L.L(view, y2);
        }
    }

    class c implements ContentFrameLayout.a {
        c() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            i.this.f0();
        }
    }

    class d implements Runnable {

        class a extends W {
            a() {
            }

            @Override // androidx.core.view.V
            public void a(View view) {
                i.this.f1086v.setAlpha(1.0f);
                i.this.f1089y.h(null);
                i.this.f1089y = null;
            }

            @Override // androidx.core.view.W, androidx.core.view.V
            public void b(View view) {
                i.this.f1086v.setVisibility(0);
            }
        }

        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar = i.this;
            iVar.f1087w.showAtLocation(iVar.f1086v, 55, 0, 0);
            i.this.i0();
            if (!i.this.T0()) {
                i.this.f1086v.setAlpha(1.0f);
                i.this.f1086v.setVisibility(0);
            } else {
                i.this.f1086v.setAlpha(0.0f);
                i iVar2 = i.this;
                iVar2.f1089y = androidx.core.view.L.c(iVar2.f1086v).b(1.0f);
                i.this.f1089y.h(new a());
            }
        }
    }

    class e extends W {
        e() {
        }

        @Override // androidx.core.view.V
        public void a(View view) {
            i.this.f1086v.setAlpha(1.0f);
            i.this.f1089y.h(null);
            i.this.f1089y = null;
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void b(View view) {
            i.this.f1086v.setVisibility(0);
            if (i.this.f1086v.getParent() instanceof View) {
                androidx.core.view.L.R((View) i.this.f1086v.getParent());
            }
        }
    }

    private class f implements AbstractC0106b.InterfaceC0023b {
        f() {
        }

        @Override // androidx.appcompat.app.AbstractC0106b.InterfaceC0023b
        public void a(int i2) {
            AbstractC0105a abstractC0105aS = i.this.s();
            if (abstractC0105aS != null) {
                abstractC0105aS.u(i2);
            }
        }

        @Override // androidx.appcompat.app.AbstractC0106b.InterfaceC0023b
        public void b(Drawable drawable, int i2) {
            AbstractC0105a abstractC0105aS = i.this.s();
            if (abstractC0105aS != null) {
                abstractC0105aS.v(drawable);
                abstractC0105aS.u(i2);
            }
        }

        @Override // androidx.appcompat.app.AbstractC0106b.InterfaceC0023b
        public Context c() {
            return i.this.n0();
        }

        @Override // androidx.appcompat.app.AbstractC0106b.InterfaceC0023b
        public boolean d() {
            AbstractC0105a abstractC0105aS = i.this.s();
            return (abstractC0105aS == null || (abstractC0105aS.j() & 4) == 0) ? false : true;
        }

        @Override // androidx.appcompat.app.AbstractC0106b.InterfaceC0023b
        public Drawable e() {
            e0 e0VarT = e0.t(c(), null, new int[]{R$attr.homeAsUpIndicator});
            Drawable drawableF = e0VarT.f(0);
            e0VarT.w();
            return drawableF;
        }
    }

    private final class g implements j.a {
        g() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void a(androidx.appcompat.view.menu.e eVar, boolean z2) {
            i.this.Y(eVar);
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean b(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackU0 = i.this.u0();
            if (callbackU0 == null) {
                return true;
            }
            callbackU0.onMenuOpened(108, eVar);
            return true;
        }
    }

    class h implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b.a f1099a;

        class a extends W {
            a() {
            }

            @Override // androidx.core.view.V
            public void a(View view) {
                i.this.f1086v.setVisibility(8);
                i iVar = i.this;
                PopupWindow popupWindow = iVar.f1087w;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (iVar.f1086v.getParent() instanceof View) {
                    androidx.core.view.L.R((View) i.this.f1086v.getParent());
                }
                i.this.f1086v.k();
                i.this.f1089y.h(null);
                i iVar2 = i.this;
                iVar2.f1089y = null;
                androidx.core.view.L.R(iVar2.f1040B);
            }
        }

        public h(b.a aVar) {
            this.f1099a = aVar;
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(androidx.appcompat.view.b bVar, Menu menu) {
            androidx.core.view.L.R(i.this.f1040B);
            return this.f1099a.a(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(androidx.appcompat.view.b bVar, MenuItem menuItem) {
            return this.f1099a.b(bVar, menuItem);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(androidx.appcompat.view.b bVar, Menu menu) {
            return this.f1099a.c(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public void d(androidx.appcompat.view.b bVar) {
            this.f1099a.d(bVar);
            i iVar = i.this;
            if (iVar.f1087w != null) {
                iVar.f1076l.getDecorView().removeCallbacks(i.this.f1088x);
            }
            i iVar2 = i.this;
            if (iVar2.f1086v != null) {
                iVar2.i0();
                i iVar3 = i.this;
                iVar3.f1089y = androidx.core.view.L.c(iVar3.f1086v).b(0.0f);
                i.this.f1089y.h(new a());
            }
            i iVar4 = i.this;
            InterfaceC0109e interfaceC0109e = iVar4.f1078n;
            if (interfaceC0109e != null) {
                interfaceC0109e.C(iVar4.f1085u);
            }
            i iVar5 = i.this;
            iVar5.f1085u = null;
            androidx.core.view.L.R(iVar5.f1040B);
            i.this.c1();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.i$i, reason: collision with other inner class name */
    static class C0024i {
        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    static class j {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        static androidx.core.os.c b(Configuration configuration) {
            return androidx.core.os.c.c(configuration.getLocales().toLanguageTags());
        }

        public static void c(androidx.core.os.c cVar) {
            LocaleList.setDefault(LocaleList.forLanguageTags(cVar.h()));
        }

        static void d(Configuration configuration, androidx.core.os.c cVar) {
            configuration.setLocales(LocaleList.forLanguageTags(cVar.h()));
        }
    }

    static class k {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                configuration3.colorMode |= configuration2.colorMode & 3;
            }
            if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                configuration3.colorMode |= configuration2.colorMode & 12;
            }
        }
    }

    static class l {
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(Object obj, final i iVar) {
            Objects.requireNonNull(iVar);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: androidx.appcompat.app.w
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    iVar.C0();
                }
            };
            androidx.appcompat.app.s.a(obj).registerOnBackInvokedCallback(1000000, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        static void c(Object obj, Object obj2) {
            androidx.appcompat.app.s.a(obj).unregisterOnBackInvokedCallback(androidx.appcompat.app.r.a(obj2));
        }
    }

    class m extends androidx.appcompat.view.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1102b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1103c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f1104d;

        m(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f1103c = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.f1103c = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.f1102b = true;
                callback.onContentChanged();
            } finally {
                this.f1102b = false;
            }
        }

        public void d(Window.Callback callback, int i2, Menu menu) {
            try {
                this.f1104d = true;
                callback.onPanelClosed(i2, menu);
            } finally {
                this.f1104d = false;
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f1103c ? a().dispatchKeyEvent(keyEvent) : i.this.g0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || i.this.F0(keyEvent.getKeyCode(), keyEvent);
        }

        final ActionMode e(ActionMode.Callback callback) {
            f.a aVar = new f.a(i.this.f1075k, callback);
            androidx.appcompat.view.b bVarW0 = i.this.W0(aVar);
            if (bVarW0 != null) {
                return aVar.e(bVarW0);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.f1102b) {
                a().onContentChanged();
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof androidx.appcompat.view.menu.e)) {
                return super.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public View onCreatePanelView(int i2) {
            return super.onCreatePanelView(i2);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onMenuOpened(int i2, Menu menu) {
            super.onMenuOpened(i2, menu);
            i.this.I0(i2);
            return true;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onPanelClosed(int i2, Menu menu) {
            if (this.f1104d) {
                a().onPanelClosed(i2, menu);
            } else {
                super.onPanelClosed(i2, menu);
                i.this.J0(i2);
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onPreparePanel(int i2, View view, Menu menu) {
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (i2 == 0 && eVar == null) {
                return false;
            }
            if (eVar != null) {
                eVar.b0(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i2, view, menu);
            if (eVar != null) {
                eVar.b0(false);
            }
            return zOnPreparePanel;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List list, Menu menu, int i2) {
            androidx.appcompat.view.menu.e eVar;
            r rVarS0 = i.this.s0(0, true);
            if (rVarS0 == null || (eVar = rVarS0.f1123j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i2);
            } else {
                super.onProvideKeyboardShortcuts(list, eVar, i2);
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return i.this.A0() ? e(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
            return (i.this.A0() && i2 == 0) ? e(callback) : super.onWindowStartingActionMode(callback, i2);
        }
    }

    private class n extends o {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final PowerManager f1106c;

        n(Context context) {
            super();
            this.f1106c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.i.o
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.i.o
        public int c() {
            return C0024i.a(this.f1106c) ? 2 : 1;
        }

        @Override // androidx.appcompat.app.i.o
        public void d() {
            i.this.S();
        }
    }

    abstract class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private BroadcastReceiver f1108a;

        class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                o.this.d();
            }
        }

        o() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f1108a;
            if (broadcastReceiver != null) {
                try {
                    i.this.f1075k.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f1108a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.f1108a == null) {
                this.f1108a = new a();
            }
            i.this.f1075k.registerReceiver(this.f1108a, intentFilterB);
        }
    }

    private class p extends o {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final F f1111c;

        p(F f2) {
            super();
            this.f1111c = f2;
        }

        @Override // androidx.appcompat.app.i.o
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.i.o
        public int c() {
            return this.f1111c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.i.o
        public void d() {
            i.this.S();
        }
    }

    private class q extends ContentFrameLayout {
        public q(Context context) {
            super(context);
        }

        private boolean b(int i2, int i3) {
            return i2 < -5 || i3 < -5 || i2 > getWidth() + 5 || i3 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return i.this.g0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            i.this.a0(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i2) {
            setBackgroundDrawable(AbstractC0190a.b(getContext(), i2));
        }
    }

    protected static final class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1115b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1116c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1117d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1118e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1119f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ViewGroup f1120g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        View f1121h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        View f1122i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        androidx.appcompat.view.menu.e f1123j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        androidx.appcompat.view.menu.c f1124k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Context f1125l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f1126m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f1127n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f1128o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f1129p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f1130q = false;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        boolean f1131r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        Bundle f1132s;

        r(int i2) {
            this.f1114a = i2;
        }

        androidx.appcompat.view.menu.k a(j.a aVar) {
            if (this.f1123j == null) {
                return null;
            }
            if (this.f1124k == null) {
                androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(this.f1125l, R$layout.abc_list_menu_item_layout);
                this.f1124k = cVar;
                cVar.h(aVar);
                this.f1123j.b(this.f1124k);
            }
            return this.f1124k.f(this.f1120g);
        }

        public boolean b() {
            if (this.f1121h == null) {
                return false;
            }
            return this.f1122i != null || this.f1124k.b().getCount() > 0;
        }

        void c(androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.c cVar;
            androidx.appcompat.view.menu.e eVar2 = this.f1123j;
            if (eVar == eVar2) {
                return;
            }
            if (eVar2 != null) {
                eVar2.P(this.f1124k);
            }
            this.f1123j = eVar;
            if (eVar == null || (cVar = this.f1124k) == null) {
                return;
            }
            eVar.b(cVar);
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                themeNewTheme.applyStyle(i2, true);
            }
            themeNewTheme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 == 0) {
                i3 = R$style.Theme_AppCompat_CompactMenu;
            }
            themeNewTheme.applyStyle(i3, true);
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
            dVar.getTheme().setTo(themeNewTheme);
            this.f1125l = dVar;
            TypedArray typedArrayObtainStyledAttributes = dVar.obtainStyledAttributes(R$styleable.AppCompatTheme);
            this.f1115b = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
            this.f1119f = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private final class s implements j.a {
        s() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void a(androidx.appcompat.view.menu.e eVar, boolean z2) {
            androidx.appcompat.view.menu.e eVarD = eVar.D();
            boolean z3 = eVarD != eVar;
            i iVar = i.this;
            if (z3) {
                eVar = eVarD;
            }
            r rVarL0 = iVar.l0(eVar);
            if (rVarL0 != null) {
                if (!z3) {
                    i.this.b0(rVarL0, z2);
                } else {
                    i.this.X(rVarL0.f1114a, rVarL0, eVarD);
                    i.this.b0(rVarL0, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean b(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackU0;
            if (eVar != eVar.D()) {
                return true;
            }
            i iVar = i.this;
            if (!iVar.f1045G || (callbackU0 = iVar.u0()) == null || i.this.f1056R) {
                return true;
            }
            callbackU0.onMenuOpened(108, eVar);
            return true;
        }
    }

    i(Activity activity, InterfaceC0109e interfaceC0109e) {
        this(activity, null, interfaceC0109e, activity);
    }

    private boolean E0(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        r rVarS0 = s0(i2, true);
        if (rVarS0.f1128o) {
            return false;
        }
        return O0(rVarS0, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean H0(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            androidx.appcompat.view.b r0 = r4.f1085u
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            androidx.appcompat.app.i$r r2 = r4.s0(r5, r0)
            if (r5 != 0) goto L43
            androidx.appcompat.widget.L r5 = r4.f1082r
            if (r5 == 0) goto L43
            boolean r5 = r5.g()
            if (r5 == 0) goto L43
            android.content.Context r5 = r4.f1075k
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L43
            androidx.appcompat.widget.L r5 = r4.f1082r
            boolean r5 = r5.c()
            if (r5 != 0) goto L3c
            boolean r5 = r4.f1056R
            if (r5 != 0) goto L62
            boolean r5 = r4.O0(r2, r6)
            if (r5 == 0) goto L62
            androidx.appcompat.widget.L r5 = r4.f1082r
            boolean r0 = r5.e()
            goto L68
        L3c:
            androidx.appcompat.widget.L r5 = r4.f1082r
            boolean r0 = r5.d()
            goto L68
        L43:
            boolean r5 = r2.f1128o
            if (r5 != 0) goto L64
            boolean r3 = r2.f1127n
            if (r3 == 0) goto L4c
            goto L64
        L4c:
            boolean r5 = r2.f1126m
            if (r5 == 0) goto L62
            boolean r5 = r2.f1131r
            if (r5 == 0) goto L5b
            r2.f1126m = r1
            boolean r5 = r4.O0(r2, r6)
            goto L5c
        L5b:
            r5 = 1
        L5c:
            if (r5 == 0) goto L62
            r4.L0(r2, r6)
            goto L68
        L62:
            r0 = 0
            goto L68
        L64:
            r4.b0(r2, r0)
            r0 = r5
        L68:
            if (r0 == 0) goto L7d
            android.content.Context r5 = r4.f1075k
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r6 = "audio"
            java.lang.Object r5 = r5.getSystemService(r6)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L7d
            r5.playSoundEffect(r1)
        L7d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.i.H0(int, android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void L0(androidx.appcompat.app.i.r r12, android.view.KeyEvent r13) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.i.L0(androidx.appcompat.app.i$r, android.view.KeyEvent):void");
    }

    private boolean N0(r rVar, int i2, KeyEvent keyEvent, int i3) {
        androidx.appcompat.view.menu.e eVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((rVar.f1126m || O0(rVar, keyEvent)) && (eVar = rVar.f1123j) != null) {
            zPerformShortcut = eVar.performShortcut(i2, keyEvent, i3);
        }
        if (zPerformShortcut && (i3 & 1) == 0 && this.f1082r == null) {
            b0(rVar, true);
        }
        return zPerformShortcut;
    }

    private boolean O0(r rVar, KeyEvent keyEvent) {
        L l2;
        L l3;
        L l4;
        if (this.f1056R) {
            return false;
        }
        if (rVar.f1126m) {
            return true;
        }
        r rVar2 = this.f1052N;
        if (rVar2 != null && rVar2 != rVar) {
            b0(rVar2, false);
        }
        Window.Callback callbackU0 = u0();
        if (callbackU0 != null) {
            rVar.f1122i = callbackU0.onCreatePanelView(rVar.f1114a);
        }
        int i2 = rVar.f1114a;
        boolean z2 = i2 == 0 || i2 == 108;
        if (z2 && (l4 = this.f1082r) != null) {
            l4.f();
        }
        if (rVar.f1122i == null) {
            if (z2) {
                M0();
            }
            androidx.appcompat.view.menu.e eVar = rVar.f1123j;
            if (eVar == null || rVar.f1131r) {
                if (eVar == null && (!y0(rVar) || rVar.f1123j == null)) {
                    return false;
                }
                if (z2 && this.f1082r != null) {
                    if (this.f1083s == null) {
                        this.f1083s = new g();
                    }
                    this.f1082r.a(rVar.f1123j, this.f1083s);
                }
                rVar.f1123j.e0();
                if (!callbackU0.onCreatePanelMenu(rVar.f1114a, rVar.f1123j)) {
                    rVar.c(null);
                    if (z2 && (l2 = this.f1082r) != null) {
                        l2.a(null, this.f1083s);
                    }
                    return false;
                }
                rVar.f1131r = false;
            }
            rVar.f1123j.e0();
            Bundle bundle = rVar.f1132s;
            if (bundle != null) {
                rVar.f1123j.Q(bundle);
                rVar.f1132s = null;
            }
            if (!callbackU0.onPreparePanel(0, rVar.f1122i, rVar.f1123j)) {
                if (z2 && (l3 = this.f1082r) != null) {
                    l3.a(null, this.f1083s);
                }
                rVar.f1123j.d0();
                return false;
            }
            boolean z3 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            rVar.f1129p = z3;
            rVar.f1123j.setQwertyMode(z3);
            rVar.f1123j.d0();
        }
        rVar.f1126m = true;
        rVar.f1127n = false;
        this.f1052N = rVar;
        return true;
    }

    private void P0(boolean z2) {
        L l2 = this.f1082r;
        if (l2 == null || !l2.g() || (ViewConfiguration.get(this.f1075k).hasPermanentMenuKey() && !this.f1082r.b())) {
            r rVarS0 = s0(0, true);
            rVarS0.f1130q = true;
            b0(rVarS0, false);
            L0(rVarS0, null);
            return;
        }
        Window.Callback callbackU0 = u0();
        if (this.f1082r.c() && z2) {
            this.f1082r.d();
            if (this.f1056R) {
                return;
            }
            callbackU0.onPanelClosed(108, s0(0, true).f1123j);
            return;
        }
        if (callbackU0 == null || this.f1056R) {
            return;
        }
        if (this.f1064Z && (this.f1065a0 & 1) != 0) {
            this.f1076l.getDecorView().removeCallbacks(this.f1066b0);
            this.f1066b0.run();
        }
        r rVarS02 = s0(0, true);
        androidx.appcompat.view.menu.e eVar = rVarS02.f1123j;
        if (eVar == null || rVarS02.f1131r || !callbackU0.onPreparePanel(0, rVarS02.f1122i, eVar)) {
            return;
        }
        callbackU0.onMenuOpened(108, rVarS02.f1123j);
        this.f1082r.e();
    }

    private boolean Q(boolean z2) {
        return R(z2, true);
    }

    private int Q0(int i2) {
        if (i2 == 8) {
            return 108;
        }
        if (i2 == 9) {
            return 109;
        }
        return i2;
    }

    private boolean R(boolean z2, boolean z3) {
        if (this.f1056R) {
            return false;
        }
        int iW = W();
        int iB0 = B0(this.f1075k, iW);
        androidx.core.os.c cVarV = Build.VERSION.SDK_INT < 33 ? V(this.f1075k) : null;
        if (!z3 && cVarV != null) {
            cVarV = r0(this.f1075k.getResources().getConfiguration());
        }
        boolean zB1 = b1(iB0, cVarV, z2);
        if (iW == 0) {
            q0(this.f1075k).e();
        } else {
            o oVar = this.f1062X;
            if (oVar != null) {
                oVar.a();
            }
        }
        if (iW == 3) {
            p0(this.f1075k).e();
        } else {
            o oVar2 = this.f1063Y;
            if (oVar2 != null) {
                oVar2.a();
            }
        }
        return zB1;
    }

    private void T() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f1040B.findViewById(R.id.content);
        View decorView = this.f1076l.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f1075k.obtainStyledAttributes(R$styleable.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void U(Window window) {
        if (this.f1076l != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof m) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        m mVar = new m(callback);
        this.f1077m = mVar;
        window.setCallback(mVar);
        e0 e0VarT = e0.t(this.f1075k, null, f1037l0);
        Drawable drawableG = e0VarT.g(0);
        if (drawableG != null) {
            window.setBackgroundDrawable(drawableG);
        }
        e0VarT.w();
        this.f1076l = window;
        if (Build.VERSION.SDK_INT < 33 || this.f1072h0 != null) {
            return;
        }
        L(null);
    }

    private boolean U0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f1076l.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ((View) viewParent).isAttachedToWindow()) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private int W() {
        int i2 = this.f1058T;
        return i2 != -100 ? i2 : AbstractC0111g.m();
    }

    private void Y0() {
        if (this.f1039A) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void Z() {
        o oVar = this.f1062X;
        if (oVar != null) {
            oVar.a();
        }
        o oVar2 = this.f1063Y;
        if (oVar2 != null) {
            oVar2.a();
        }
    }

    private AbstractActivityC0108d Z0() {
        for (Context baseContext = this.f1075k; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof AbstractActivityC0108d) {
                return (AbstractActivityC0108d) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a1(Configuration configuration) {
        Activity activity = (Activity) this.f1074j;
        if (activity instanceof androidx.lifecycle.l) {
            if (!((androidx.lifecycle.l) activity).G().b().b(AbstractC0183g.b.CREATED)) {
                return;
            }
        } else if (!this.f1055Q || this.f1056R) {
            return;
        }
        activity.onConfigurationChanged(configuration);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean b1(int r10, androidx.core.os.c r11, boolean r12) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.i.b1(int, androidx.core.os.c, boolean):boolean");
    }

    private Configuration c0(Context context, int i2, androidx.core.os.c cVar, Configuration configuration, boolean z2) {
        int i3 = i2 != 1 ? i2 != 2 ? z2 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        if (cVar != null) {
            R0(configuration2, cVar);
        }
        return configuration2;
    }

    private ViewGroup d0() {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.f1075k.obtainStyledAttributes(R$styleable.AppCompatTheme);
        if (!typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
            H(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBar, false)) {
            H(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            H(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            H(10);
        }
        this.f1048J = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        k0();
        this.f1076l.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1075k);
        if (this.f1049K) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(this.f1047I ? R$layout.abc_screen_simple_overlay_action_mode : R$layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.f1048J) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
            this.f1046H = false;
            this.f1045G = false;
        } else if (this.f1045G) {
            TypedValue typedValue = new TypedValue();
            this.f1075k.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new androidx.appcompat.view.d(this.f1075k, typedValue.resourceId) : this.f1075k).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
            L l2 = (L) viewGroup.findViewById(R$id.decor_content_parent);
            this.f1082r = l2;
            l2.setWindowCallback(u0());
            if (this.f1046H) {
                this.f1082r.k(109);
            }
            if (this.f1043E) {
                this.f1082r.k(2);
            }
            if (this.f1044F) {
                this.f1082r.k(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f1045G + ", windowActionBarOverlay: " + this.f1046H + ", android:windowIsFloating: " + this.f1048J + ", windowActionModeOverlay: " + this.f1047I + ", windowNoTitle: " + this.f1049K + " }");
        }
        androidx.core.view.L.c0(viewGroup, new b());
        if (this.f1082r == null) {
            this.f1041C = (TextView) viewGroup.findViewById(R$id.title);
        }
        p0.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f1076l.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f1076l.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new c());
        return viewGroup;
    }

    private void d1(int i2, androidx.core.os.c cVar, boolean z2, Configuration configuration) {
        Resources resources = this.f1075k.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i2 | (resources.getConfiguration().uiMode & (-49));
        if (cVar != null) {
            R0(configuration2, cVar);
        }
        resources.updateConfiguration(configuration2, null);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            D.a(resources);
        }
        int i4 = this.f1059U;
        if (i4 != 0) {
            this.f1075k.setTheme(i4);
            if (i3 >= 23) {
                this.f1075k.getTheme().applyStyle(this.f1059U, true);
            }
        }
        if (z2 && (this.f1074j instanceof Activity)) {
            a1(configuration2);
        }
    }

    private void f1(View view) {
        Context context;
        int i2;
        if ((androidx.core.view.L.C(view) & Peripheral.EXPANSION_5) != 0) {
            context = this.f1075k;
            i2 = R$color.abc_decor_view_status_guard_light;
        } else {
            context = this.f1075k;
            i2 = R$color.abc_decor_view_status_guard;
        }
        view.setBackgroundColor(androidx.core.content.a.b(context, i2));
    }

    private void j0() {
        if (this.f1039A) {
            return;
        }
        this.f1040B = d0();
        CharSequence charSequenceT0 = t0();
        if (!TextUtils.isEmpty(charSequenceT0)) {
            L l2 = this.f1082r;
            if (l2 != null) {
                l2.setWindowTitle(charSequenceT0);
            } else if (M0() != null) {
                M0().B(charSequenceT0);
            } else {
                TextView textView = this.f1041C;
                if (textView != null) {
                    textView.setText(charSequenceT0);
                }
            }
        }
        T();
        K0(this.f1040B);
        this.f1039A = true;
        r rVarS0 = s0(0, false);
        if (this.f1056R) {
            return;
        }
        if (rVarS0 == null || rVarS0.f1123j == null) {
            z0(108);
        }
    }

    private void k0() {
        if (this.f1076l == null) {
            Object obj = this.f1074j;
            if (obj instanceof Activity) {
                U(((Activity) obj).getWindow());
            }
        }
        if (this.f1076l == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration m0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f2 = configuration.fontScale;
            float f3 = configuration2.fontScale;
            if (f2 != f3) {
                configuration3.fontScale = f3;
            }
            int i2 = configuration.mcc;
            int i3 = configuration2.mcc;
            if (i2 != i3) {
                configuration3.mcc = i3;
            }
            int i4 = configuration.mnc;
            int i5 = configuration2.mnc;
            if (i4 != i5) {
                configuration3.mnc = i5;
            }
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 24) {
                j.a(configuration, configuration2, configuration3);
            } else if (!AbstractC0234c.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i7 = configuration.touchscreen;
            int i8 = configuration2.touchscreen;
            if (i7 != i8) {
                configuration3.touchscreen = i8;
            }
            int i9 = configuration.keyboard;
            int i10 = configuration2.keyboard;
            if (i9 != i10) {
                configuration3.keyboard = i10;
            }
            int i11 = configuration.keyboardHidden;
            int i12 = configuration2.keyboardHidden;
            if (i11 != i12) {
                configuration3.keyboardHidden = i12;
            }
            int i13 = configuration.navigation;
            int i14 = configuration2.navigation;
            if (i13 != i14) {
                configuration3.navigation = i14;
            }
            int i15 = configuration.navigationHidden;
            int i16 = configuration2.navigationHidden;
            if (i15 != i16) {
                configuration3.navigationHidden = i16;
            }
            int i17 = configuration.orientation;
            int i18 = configuration2.orientation;
            if (i17 != i18) {
                configuration3.orientation = i18;
            }
            int i19 = configuration.screenLayout & 15;
            int i20 = configuration2.screenLayout;
            if (i19 != (i20 & 15)) {
                configuration3.screenLayout |= i20 & 15;
            }
            int i21 = configuration.screenLayout & 192;
            int i22 = configuration2.screenLayout;
            if (i21 != (i22 & 192)) {
                configuration3.screenLayout |= i22 & 192;
            }
            int i23 = configuration.screenLayout & 48;
            int i24 = configuration2.screenLayout;
            if (i23 != (i24 & 48)) {
                configuration3.screenLayout |= i24 & 48;
            }
            int i25 = configuration.screenLayout & 768;
            int i26 = configuration2.screenLayout;
            if (i25 != (i26 & 768)) {
                configuration3.screenLayout |= i26 & 768;
            }
            if (i6 >= 26) {
                k.a(configuration, configuration2, configuration3);
            }
            int i27 = configuration.uiMode & 15;
            int i28 = configuration2.uiMode;
            if (i27 != (i28 & 15)) {
                configuration3.uiMode |= i28 & 15;
            }
            int i29 = configuration.uiMode & 48;
            int i30 = configuration2.uiMode;
            if (i29 != (i30 & 48)) {
                configuration3.uiMode |= i30 & 48;
            }
            int i31 = configuration.screenWidthDp;
            int i32 = configuration2.screenWidthDp;
            if (i31 != i32) {
                configuration3.screenWidthDp = i32;
            }
            int i33 = configuration.screenHeightDp;
            int i34 = configuration2.screenHeightDp;
            if (i33 != i34) {
                configuration3.screenHeightDp = i34;
            }
            int i35 = configuration.smallestScreenWidthDp;
            int i36 = configuration2.smallestScreenWidthDp;
            if (i35 != i36) {
                configuration3.smallestScreenWidthDp = i36;
            }
            int i37 = configuration.densityDpi;
            int i38 = configuration2.densityDpi;
            if (i37 != i38) {
                configuration3.densityDpi = i38;
            }
        }
        return configuration3;
    }

    private int o0(Context context) {
        if (!this.f1061W && (this.f1074j instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                int i2 = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f1074j.getClass()), i2 >= 29 ? 269221888 : i2 >= 24 ? 786432 : 0);
                if (activityInfo != null) {
                    this.f1060V = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                this.f1060V = 0;
            }
        }
        this.f1061W = true;
        return this.f1060V;
    }

    private o p0(Context context) {
        if (this.f1063Y == null) {
            this.f1063Y = new n(context);
        }
        return this.f1063Y;
    }

    private o q0(Context context) {
        if (this.f1062X == null) {
            this.f1062X = new p(F.a(context));
        }
        return this.f1062X;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void v0() {
        /*
            r3 = this;
            r3.j0()
            boolean r0 = r3.f1045G
            if (r0 == 0) goto L37
            androidx.appcompat.app.a r0 = r3.f1079o
            if (r0 == 0) goto Lc
            goto L37
        Lc:
            java.lang.Object r0 = r3.f1074j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L20
            androidx.appcompat.app.G r0 = new androidx.appcompat.app.G
            java.lang.Object r1 = r3.f1074j
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r2 = r3.f1046H
            r0.<init>(r1, r2)
        L1d:
            r3.f1079o = r0
            goto L2e
        L20:
            boolean r0 = r0 instanceof android.app.Dialog
            if (r0 == 0) goto L2e
            androidx.appcompat.app.G r0 = new androidx.appcompat.app.G
            java.lang.Object r1 = r3.f1074j
            android.app.Dialog r1 = (android.app.Dialog) r1
            r0.<init>(r1)
            goto L1d
        L2e:
            androidx.appcompat.app.a r0 = r3.f1079o
            if (r0 == 0) goto L37
            boolean r1 = r3.f1067c0
            r0.s(r1)
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.i.v0():void");
    }

    private boolean w0(r rVar) {
        View view = rVar.f1122i;
        if (view != null) {
            rVar.f1121h = view;
            return true;
        }
        if (rVar.f1123j == null) {
            return false;
        }
        if (this.f1084t == null) {
            this.f1084t = new s();
        }
        View view2 = (View) rVar.a(this.f1084t);
        rVar.f1121h = view2;
        return view2 != null;
    }

    private boolean x0(r rVar) {
        rVar.d(n0());
        rVar.f1120g = new q(rVar.f1125l);
        rVar.f1116c = 81;
        return true;
    }

    private boolean y0(r rVar) {
        Resources.Theme themeNewTheme;
        Context context = this.f1075k;
        int i2 = rVar.f1114a;
        if ((i2 == 0 || i2 == 108) && this.f1082r != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
                themeNewTheme = null;
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
                dVar.getTheme().setTo(themeNewTheme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        eVar.S(this);
        rVar.c(eVar);
        return true;
    }

    private void z0(int i2) {
        this.f1065a0 = (1 << i2) | this.f1065a0;
        if (this.f1064Z) {
            return;
        }
        androidx.core.view.L.P(this.f1076l.getDecorView(), this.f1066b0);
        this.f1064Z = true;
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public void A(Bundle bundle) {
        j0();
    }

    public boolean A0() {
        return this.f1090z;
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public void B() {
        AbstractC0105a abstractC0105aS = s();
        if (abstractC0105aS != null) {
            abstractC0105aS.x(true);
        }
    }

    int B0(Context context, int i2) {
        o oVarQ0;
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                    oVarQ0 = p0(context);
                }
            } else {
                if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                oVarQ0 = q0(context);
            }
            return oVarQ0.c();
        }
        return i2;
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public void C(Bundle bundle) {
    }

    boolean C0() {
        boolean z2 = this.f1053O;
        this.f1053O = false;
        r rVarS0 = s0(0, false);
        if (rVarS0 != null && rVarS0.f1128o) {
            if (!z2) {
                b0(rVarS0, true);
            }
            return true;
        }
        androidx.appcompat.view.b bVar = this.f1085u;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        AbstractC0105a abstractC0105aS = s();
        return abstractC0105aS != null && abstractC0105aS.h();
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public void D() {
        R(true, false);
    }

    boolean D0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.f1053O = (keyEvent.getFlags() & 128) != 0;
        } else if (i2 == 82) {
            E0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public void E() {
        AbstractC0105a abstractC0105aS = s();
        if (abstractC0105aS != null) {
            abstractC0105aS.x(false);
        }
    }

    boolean F0(int i2, KeyEvent keyEvent) {
        AbstractC0105a abstractC0105aS = s();
        if (abstractC0105aS != null && abstractC0105aS.o(i2, keyEvent)) {
            return true;
        }
        r rVar = this.f1052N;
        if (rVar != null && N0(rVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            r rVar2 = this.f1052N;
            if (rVar2 != null) {
                rVar2.f1127n = true;
            }
            return true;
        }
        if (this.f1052N == null) {
            r rVarS0 = s0(0, true);
            O0(rVarS0, keyEvent);
            boolean zN0 = N0(rVarS0, keyEvent.getKeyCode(), keyEvent, 1);
            rVarS0.f1126m = false;
            if (zN0) {
                return true;
            }
        }
        return false;
    }

    boolean G0(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            if (i2 == 82) {
                H0(0, keyEvent);
                return true;
            }
        } else if (C0()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public boolean H(int i2) {
        int iQ0 = Q0(i2);
        if (this.f1049K && iQ0 == 108) {
            return false;
        }
        if (this.f1045G && iQ0 == 1) {
            this.f1045G = false;
        }
        if (iQ0 == 1) {
            Y0();
            this.f1049K = true;
            return true;
        }
        if (iQ0 == 2) {
            Y0();
            this.f1043E = true;
            return true;
        }
        if (iQ0 == 5) {
            Y0();
            this.f1044F = true;
            return true;
        }
        if (iQ0 == 10) {
            Y0();
            this.f1047I = true;
            return true;
        }
        if (iQ0 == 108) {
            Y0();
            this.f1045G = true;
            return true;
        }
        if (iQ0 != 109) {
            return this.f1076l.requestFeature(iQ0);
        }
        Y0();
        this.f1046H = true;
        return true;
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public void I(int i2) {
        j0();
        ViewGroup viewGroup = (ViewGroup) this.f1040B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f1075k).inflate(i2, viewGroup);
        this.f1077m.c(this.f1076l.getCallback());
    }

    void I0(int i2) {
        AbstractC0105a abstractC0105aS;
        if (i2 != 108 || (abstractC0105aS = s()) == null) {
            return;
        }
        abstractC0105aS.i(true);
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public void J(View view) {
        j0();
        ViewGroup viewGroup = (ViewGroup) this.f1040B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f1077m.c(this.f1076l.getCallback());
    }

    void J0(int i2) {
        if (i2 == 108) {
            AbstractC0105a abstractC0105aS = s();
            if (abstractC0105aS != null) {
                abstractC0105aS.i(false);
                return;
            }
            return;
        }
        if (i2 == 0) {
            r rVarS0 = s0(i2, true);
            if (rVarS0.f1128o) {
                b0(rVarS0, false);
            }
        }
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public void K(View view, ViewGroup.LayoutParams layoutParams) {
        j0();
        ViewGroup viewGroup = (ViewGroup) this.f1040B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f1077m.c(this.f1076l.getCallback());
    }

    void K0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public void L(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.L(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.f1072h0;
        if (onBackInvokedDispatcher2 != null && (onBackInvokedCallback = this.f1073i0) != null) {
            l.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.f1073i0 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.f1074j;
            if ((obj instanceof Activity) && ((Activity) obj).getWindow() != null) {
                onBackInvokedDispatcher = l.a((Activity) this.f1074j);
            }
        }
        this.f1072h0 = onBackInvokedDispatcher;
        c1();
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public void M(int i2) {
        this.f1059U = i2;
    }

    final AbstractC0105a M0() {
        return this.f1079o;
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public final void N(CharSequence charSequence) {
        this.f1081q = charSequence;
        L l2 = this.f1082r;
        if (l2 != null) {
            l2.setWindowTitle(charSequence);
            return;
        }
        if (M0() != null) {
            M0().B(charSequence);
            return;
        }
        TextView textView = this.f1041C;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    void R0(Configuration configuration, androidx.core.os.c cVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            j.d(configuration, cVar);
        } else {
            configuration.setLocale(cVar.d(0));
            configuration.setLayoutDirection(cVar.d(0));
        }
    }

    public boolean S() {
        return Q(true);
    }

    void S0(androidx.core.os.c cVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            j.c(cVar);
        } else {
            Locale.setDefault(cVar.d(0));
        }
    }

    final boolean T0() {
        ViewGroup viewGroup;
        return this.f1039A && (viewGroup = this.f1040B) != null && viewGroup.isLaidOut();
    }

    androidx.core.os.c V(Context context) {
        androidx.core.os.c cVarR;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33 || (cVarR = AbstractC0111g.r()) == null) {
            return null;
        }
        androidx.core.os.c cVarR0 = r0(context.getApplicationContext().getResources().getConfiguration());
        androidx.core.os.c cVarB = i2 >= 24 ? C.b(cVarR, cVarR0) : cVarR.f() ? androidx.core.os.c.e() : androidx.core.os.c.c(C0024i.b(cVarR.d(0)));
        return cVarB.f() ? cVarR0 : cVarB;
    }

    boolean V0() {
        if (this.f1072h0 == null) {
            return false;
        }
        r rVarS0 = s0(0, false);
        return (rVarS0 != null && rVarS0.f1128o) || this.f1085u != null;
    }

    public androidx.appcompat.view.b W0(b.a aVar) {
        InterfaceC0109e interfaceC0109e;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        androidx.appcompat.view.b bVar = this.f1085u;
        if (bVar != null) {
            bVar.c();
        }
        h hVar = new h(aVar);
        AbstractC0105a abstractC0105aS = s();
        if (abstractC0105aS != null) {
            androidx.appcompat.view.b bVarC = abstractC0105aS.C(hVar);
            this.f1085u = bVarC;
            if (bVarC != null && (interfaceC0109e = this.f1078n) != null) {
                interfaceC0109e.u(bVarC);
            }
        }
        if (this.f1085u == null) {
            this.f1085u = X0(hVar);
        }
        c1();
        return this.f1085u;
    }

    void X(int i2, r rVar, Menu menu) {
        if (menu == null) {
            if (rVar == null && i2 >= 0) {
                r[] rVarArr = this.f1051M;
                if (i2 < rVarArr.length) {
                    rVar = rVarArr[i2];
                }
            }
            if (rVar != null) {
                menu = rVar.f1123j;
            }
        }
        if ((rVar == null || rVar.f1128o) && !this.f1056R) {
            this.f1077m.d(this.f1076l.getCallback(), i2, menu);
        }
    }

    androidx.appcompat.view.b X0(b.a aVar) {
        androidx.appcompat.view.b bVarI;
        Context dVar;
        InterfaceC0109e interfaceC0109e;
        i0();
        androidx.appcompat.view.b bVar = this.f1085u;
        if (bVar != null) {
            bVar.c();
        }
        if (!(aVar instanceof h)) {
            aVar = new h(aVar);
        }
        InterfaceC0109e interfaceC0109e2 = this.f1078n;
        if (interfaceC0109e2 == null || this.f1056R) {
            bVarI = null;
        } else {
            try {
                bVarI = interfaceC0109e2.I(aVar);
            } catch (AbstractMethodError unused) {
                bVarI = null;
            }
        }
        if (bVarI != null) {
            this.f1085u = bVarI;
        } else {
            if (this.f1086v == null) {
                if (this.f1048J) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f1075k.getTheme();
                    theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f1075k.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new androidx.appcompat.view.d(this.f1075k, 0);
                        dVar.getTheme().setTo(themeNewTheme);
                    } else {
                        dVar = this.f1075k;
                    }
                    this.f1086v = new ActionBarContextView(dVar);
                    PopupWindow popupWindow = new PopupWindow(dVar, (AttributeSet) null, R$attr.actionModePopupWindowStyle);
                    this.f1087w = popupWindow;
                    androidx.core.widget.g.b(popupWindow, 2);
                    this.f1087w.setContentView(this.f1086v);
                    this.f1087w.setWidth(-1);
                    dVar.getTheme().resolveAttribute(R$attr.actionBarSize, typedValue, true);
                    this.f1086v.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.f1087w.setHeight(-2);
                    this.f1088x = new d();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f1040B.findViewById(R$id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(n0()));
                        this.f1086v = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.f1086v != null) {
                i0();
                this.f1086v.k();
                androidx.appcompat.view.e eVar = new androidx.appcompat.view.e(this.f1086v.getContext(), this.f1086v, aVar, this.f1087w == null);
                if (aVar.c(eVar, eVar.e())) {
                    eVar.k();
                    this.f1086v.h(eVar);
                    this.f1085u = eVar;
                    if (T0()) {
                        this.f1086v.setAlpha(0.0f);
                        U uB = androidx.core.view.L.c(this.f1086v).b(1.0f);
                        this.f1089y = uB;
                        uB.h(new e());
                    } else {
                        this.f1086v.setAlpha(1.0f);
                        this.f1086v.setVisibility(0);
                        if (this.f1086v.getParent() instanceof View) {
                            androidx.core.view.L.R((View) this.f1086v.getParent());
                        }
                    }
                    if (this.f1087w != null) {
                        this.f1076l.getDecorView().post(this.f1088x);
                    }
                } else {
                    this.f1085u = null;
                }
            }
        }
        androidx.appcompat.view.b bVar2 = this.f1085u;
        if (bVar2 != null && (interfaceC0109e = this.f1078n) != null) {
            interfaceC0109e.u(bVar2);
        }
        c1();
        return this.f1085u;
    }

    void Y(androidx.appcompat.view.menu.e eVar) {
        if (this.f1050L) {
            return;
        }
        this.f1050L = true;
        this.f1082r.l();
        Window.Callback callbackU0 = u0();
        if (callbackU0 != null && !this.f1056R) {
            callbackU0.onPanelClosed(108, eVar);
        }
        this.f1050L = false;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        r rVarL0;
        Window.Callback callbackU0 = u0();
        if (callbackU0 == null || this.f1056R || (rVarL0 = l0(eVar.D())) == null) {
            return false;
        }
        return callbackU0.onMenuItemSelected(rVarL0.f1114a, menuItem);
    }

    void a0(int i2) {
        b0(s0(i2, true), true);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        P0(true);
    }

    void b0(r rVar, boolean z2) {
        ViewGroup viewGroup;
        L l2;
        if (z2 && rVar.f1114a == 0 && (l2 = this.f1082r) != null && l2.c()) {
            Y(rVar.f1123j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f1075k.getSystemService("window");
        if (windowManager != null && rVar.f1128o && (viewGroup = rVar.f1120g) != null) {
            windowManager.removeView(viewGroup);
            if (z2) {
                X(rVar.f1114a, rVar, null);
            }
        }
        rVar.f1126m = false;
        rVar.f1127n = false;
        rVar.f1128o = false;
        rVar.f1121h = null;
        rVar.f1130q = true;
        if (this.f1052N == rVar) {
            this.f1052N = null;
        }
        if (rVar.f1114a == 0) {
            c1();
        }
    }

    void c1() {
        OnBackInvokedCallback onBackInvokedCallback;
        OnBackInvokedCallback onBackInvokedCallbackB;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean zV0 = V0();
            if (zV0 && this.f1073i0 == null) {
                onBackInvokedCallbackB = l.b(this.f1072h0, this);
            } else {
                if (zV0 || (onBackInvokedCallback = this.f1073i0) == null) {
                    return;
                }
                l.c(this.f1072h0, onBackInvokedCallback);
                onBackInvokedCallbackB = null;
            }
            this.f1073i0 = onBackInvokedCallbackB;
        }
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        j0();
        ((ViewGroup) this.f1040B.findViewById(R.id.content)).addView(view, layoutParams);
        this.f1077m.c(this.f1076l.getCallback());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View e0(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z2;
        z zVar;
        if (this.f1070f0 == null) {
            TypedArray typedArrayObtainStyledAttributes = this.f1075k.obtainStyledAttributes(R$styleable.AppCompatTheme);
            String string = typedArrayObtainStyledAttributes.getString(R$styleable.AppCompatTheme_viewInflaterClass);
            typedArrayObtainStyledAttributes.recycle();
            if (string == null) {
                zVar = new z();
            } else {
                try {
                    this.f1070f0 = (z) this.f1075k.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to instantiate custom view inflater ");
                    sb.append(string);
                    sb.append(". Falling back to default.");
                    zVar = new z();
                    this.f1070f0 = zVar;
                }
            }
            this.f1070f0 = zVar;
        }
        boolean z3 = f1036k0;
        boolean zU0 = false;
        if (z3) {
            if (this.f1071g0 == null) {
                this.f1071g0 = new B();
            }
            if (this.f1071g0.a(attributeSet)) {
                z2 = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    zU0 = U0((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    zU0 = true;
                }
                z2 = zU0;
            }
        } else {
            z2 = false;
        }
        return this.f1070f0.r(view, str, context, attributeSet, z2, z3, true, o0.c());
    }

    final int e1(Y y2, Rect rect) {
        boolean z2;
        boolean z3;
        int iK = y2 != null ? y2.k() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.f1086v;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1086v.getLayoutParams();
            if (this.f1086v.isShown()) {
                if (this.f1068d0 == null) {
                    this.f1068d0 = new Rect();
                    this.f1069e0 = new Rect();
                }
                Rect rect2 = this.f1068d0;
                Rect rect3 = this.f1069e0;
                if (y2 == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(y2.i(), y2.k(), y2.j(), y2.h());
                }
                p0.a(this.f1040B, rect2, rect3);
                int i2 = rect2.top;
                int i3 = rect2.left;
                int i4 = rect2.right;
                Y yZ = androidx.core.view.L.z(this.f1040B);
                int i5 = yZ == null ? 0 : yZ.i();
                int iJ = yZ == null ? 0 : yZ.j();
                if (marginLayoutParams.topMargin == i2 && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4) {
                    z3 = false;
                } else {
                    marginLayoutParams.topMargin = i2;
                    marginLayoutParams.leftMargin = i3;
                    marginLayoutParams.rightMargin = i4;
                    z3 = true;
                }
                if (i2 <= 0 || this.f1042D != null) {
                    View view = this.f1042D;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i6 = marginLayoutParams2.height;
                        int i7 = marginLayoutParams.topMargin;
                        if (i6 != i7 || marginLayoutParams2.leftMargin != i5 || marginLayoutParams2.rightMargin != iJ) {
                            marginLayoutParams2.height = i7;
                            marginLayoutParams2.leftMargin = i5;
                            marginLayoutParams2.rightMargin = iJ;
                            this.f1042D.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f1075k);
                    this.f1042D = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = i5;
                    layoutParams.rightMargin = iJ;
                    this.f1040B.addView(this.f1042D, -1, layoutParams);
                }
                View view3 = this.f1042D;
                z = view3 != null;
                if (z && view3.getVisibility() != 0) {
                    f1(this.f1042D);
                }
                if (!this.f1047I && z) {
                    iK = 0;
                }
                z2 = z;
                z = z3;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = false;
            } else {
                z2 = false;
                z = false;
            }
            if (z) {
                this.f1086v.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.f1042D;
        if (view4 != null) {
            view4.setVisibility(z2 ? 0 : 8);
        }
        return iK;
    }

    void f0() {
        androidx.appcompat.view.menu.e eVar;
        L l2 = this.f1082r;
        if (l2 != null) {
            l2.l();
        }
        if (this.f1087w != null) {
            this.f1076l.getDecorView().removeCallbacks(this.f1088x);
            if (this.f1087w.isShowing()) {
                try {
                    this.f1087w.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f1087w = null;
        }
        i0();
        r rVarS0 = s0(0, false);
        if (rVarS0 == null || (eVar = rVarS0.f1123j) == null) {
            return;
        }
        eVar.close();
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public Context g(Context context) {
        this.f1054P = true;
        int iB0 = B0(context, W());
        if (AbstractC0111g.v(context)) {
            AbstractC0111g.P(context);
        }
        androidx.core.os.c cVarV = V(context);
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(c0(context, iB0, cVarV, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.d) {
            try {
                ((androidx.appcompat.view.d) context).a(c0(context, iB0, cVarV, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f1038m0) {
            return super.g(context);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = context.createConfigurationContext(configuration).getResources().getConfiguration();
        Configuration configuration3 = context.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration configurationC0 = c0(context, iB0, cVarV, !configuration2.equals(configuration3) ? m0(configuration2, configuration3) : null, true);
        androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, R$style.Theme_AppCompat_Empty);
        dVar.a(configurationC0);
        try {
            if (context.getTheme() != null) {
                h.f.a(dVar.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.g(dVar);
    }

    boolean g0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f1074j;
        if (((obj instanceof AbstractC0155t.a) || (obj instanceof y)) && (decorView = this.f1076l.getDecorView()) != null && AbstractC0155t.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f1077m.b(this.f1076l.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? D0(keyCode, keyEvent) : G0(keyCode, keyEvent);
    }

    void h0(int i2) {
        r rVarS0;
        r rVarS02 = s0(i2, true);
        if (rVarS02.f1123j != null) {
            Bundle bundle = new Bundle();
            rVarS02.f1123j.R(bundle);
            if (bundle.size() > 0) {
                rVarS02.f1132s = bundle;
            }
            rVarS02.f1123j.e0();
            rVarS02.f1123j.clear();
        }
        rVarS02.f1131r = true;
        rVarS02.f1130q = true;
        if ((i2 != 108 && i2 != 0) || this.f1082r == null || (rVarS0 = s0(0, false)) == null) {
            return;
        }
        rVarS0.f1126m = false;
        O0(rVarS0, null);
    }

    void i0() {
        U u2 = this.f1089y;
        if (u2 != null) {
            u2.c();
        }
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public View j(int i2) {
        j0();
        return this.f1076l.findViewById(i2);
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public Context l() {
        return this.f1075k;
    }

    r l0(Menu menu) {
        r[] rVarArr = this.f1051M;
        int length = rVarArr != null ? rVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            r rVar = rVarArr[i2];
            if (rVar != null && rVar.f1123j == menu) {
                return rVar;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public final AbstractC0106b.InterfaceC0023b n() {
        return new f();
    }

    final Context n0() {
        AbstractC0105a abstractC0105aS = s();
        Context contextK = abstractC0105aS != null ? abstractC0105aS.k() : null;
        return contextK == null ? this.f1075k : contextK;
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public int o() {
        return this.f1058T;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return e0(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public MenuInflater q() {
        if (this.f1080p == null) {
            v0();
            AbstractC0105a abstractC0105a = this.f1079o;
            this.f1080p = new androidx.appcompat.view.g(abstractC0105a != null ? abstractC0105a.k() : this.f1075k);
        }
        return this.f1080p;
    }

    androidx.core.os.c r0(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? j.b(configuration) : androidx.core.os.c.c(C0024i.b(configuration.locale));
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public AbstractC0105a s() {
        v0();
        return this.f1079o;
    }

    protected r s0(int i2, boolean z2) {
        r[] rVarArr = this.f1051M;
        if (rVarArr == null || rVarArr.length <= i2) {
            r[] rVarArr2 = new r[i2 + 1];
            if (rVarArr != null) {
                System.arraycopy(rVarArr, 0, rVarArr2, 0, rVarArr.length);
            }
            this.f1051M = rVarArr2;
            rVarArr = rVarArr2;
        }
        r rVar = rVarArr[i2];
        if (rVar != null) {
            return rVar;
        }
        r rVar2 = new r(i2);
        rVarArr[i2] = rVar2;
        return rVar2;
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public void t() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1075k);
        if (layoutInflaterFrom.getFactory() == null) {
            AbstractC0156u.a(layoutInflaterFrom, this);
        } else {
            boolean z2 = layoutInflaterFrom.getFactory2() instanceof i;
        }
    }

    final CharSequence t0() {
        Object obj = this.f1074j;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f1081q;
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public void u() {
        if (M0() == null || s().l()) {
            return;
        }
        z0(0);
    }

    final Window.Callback u0() {
        return this.f1076l.getCallback();
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public void x(Configuration configuration) {
        AbstractC0105a abstractC0105aS;
        if (this.f1045G && this.f1039A && (abstractC0105aS = s()) != null) {
            abstractC0105aS.m(configuration);
        }
        C0122k.b().g(this.f1075k);
        this.f1057S = new Configuration(this.f1075k.getResources().getConfiguration());
        R(false, false);
    }

    @Override // androidx.appcompat.app.AbstractC0111g
    public void y(Bundle bundle) {
        String strC;
        this.f1054P = true;
        Q(false);
        k0();
        Object obj = this.f1074j;
        if (obj instanceof Activity) {
            try {
                strC = androidx.core.app.i.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                strC = null;
            }
            if (strC != null) {
                AbstractC0105a abstractC0105aM0 = M0();
                if (abstractC0105aM0 == null) {
                    this.f1067c0 = true;
                } else {
                    abstractC0105aM0.s(true);
                }
            }
            AbstractC0111g.d(this);
        }
        this.f1057S = new Configuration(this.f1075k.getResources().getConfiguration());
        this.f1055Q = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    @Override // androidx.appcompat.app.AbstractC0111g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void z() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f1074j
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            androidx.appcompat.app.AbstractC0111g.F(r3)
        L9:
            boolean r0 = r3.f1064Z
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.f1076l
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f1066b0
            r0.removeCallbacks(r1)
        L18:
            r0 = 1
            r3.f1056R = r0
            int r0 = r3.f1058T
            r1 = -100
            if (r0 == r1) goto L45
            java.lang.Object r0 = r3.f1074j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L45
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L45
            k.g r0 = androidx.appcompat.app.i.f1035j0
            java.lang.Object r1 = r3.f1074j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f1058T
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L54
        L45:
            k.g r0 = androidx.appcompat.app.i.f1035j0
            java.lang.Object r1 = r3.f1074j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L54:
            androidx.appcompat.app.a r0 = r3.f1079o
            if (r0 == 0) goto L5b
            r0.n()
        L5b:
            r3.Z()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.i.z():void");
    }

    i(Dialog dialog, InterfaceC0109e interfaceC0109e) {
        this(dialog.getContext(), dialog.getWindow(), interfaceC0109e, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private i(Context context, Window window, InterfaceC0109e interfaceC0109e, Object obj) {
        AbstractActivityC0108d abstractActivityC0108dZ0;
        this.f1089y = null;
        this.f1090z = true;
        this.f1058T = -100;
        this.f1066b0 = new a();
        this.f1075k = context;
        this.f1078n = interfaceC0109e;
        this.f1074j = obj;
        if (this.f1058T == -100 && (obj instanceof Dialog) && (abstractActivityC0108dZ0 = Z0()) != null) {
            this.f1058T = abstractActivityC0108dZ0.p0().o();
        }
        if (this.f1058T == -100) {
            C0213g c0213g = f1035j0;
            Integer num = (Integer) c0213g.get(obj.getClass().getName());
            if (num != null) {
                this.f1058T = num.intValue();
                c0213g.remove(obj.getClass().getName());
            }
        }
        if (window != null) {
            U(window);
        }
        C0122k.h();
    }
}
