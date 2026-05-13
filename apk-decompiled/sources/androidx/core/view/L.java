package androidx.core.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.contentcapture.ContentCaptureSession;
import androidx.core.R$id;
import androidx.core.view.C0137a;
import androidx.core.view.Y;
import it.tervis.miura.model.Peripheral;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import k.C0213g;
import q.AbstractC0247a;
import r.AbstractC0248a;

/* JADX INFO: loaded from: classes.dex */
public abstract class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static WeakHashMap f2281a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f2282b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f2283c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ThreadLocal f2284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f2285e = {R$id.accessibility_custom_action_0, R$id.accessibility_custom_action_1, R$id.accessibility_custom_action_2, R$id.accessibility_custom_action_3, R$id.accessibility_custom_action_4, R$id.accessibility_custom_action_5, R$id.accessibility_custom_action_6, R$id.accessibility_custom_action_7, R$id.accessibility_custom_action_8, R$id.accessibility_custom_action_9, R$id.accessibility_custom_action_10, R$id.accessibility_custom_action_11, R$id.accessibility_custom_action_12, R$id.accessibility_custom_action_13, R$id.accessibility_custom_action_14, R$id.accessibility_custom_action_15, R$id.accessibility_custom_action_16, R$id.accessibility_custom_action_17, R$id.accessibility_custom_action_18, R$id.accessibility_custom_action_19, R$id.accessibility_custom_action_20, R$id.accessibility_custom_action_21, R$id.accessibility_custom_action_22, R$id.accessibility_custom_action_23, R$id.accessibility_custom_action_24, R$id.accessibility_custom_action_25, R$id.accessibility_custom_action_26, R$id.accessibility_custom_action_27, R$id.accessibility_custom_action_28, R$id.accessibility_custom_action_29, R$id.accessibility_custom_action_30, R$id.accessibility_custom_action_31};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final G f2286f = new G() { // from class: androidx.core.view.K
        @Override // androidx.core.view.G
        public final C0140d a(C0140d c0140d) {
            return L.H(c0140d);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final e f2287g = new e();

    class a extends f {
        a(int i2, Class cls, int i3) {
            super(i2, cls, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.L.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(j.d(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.L.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            j.j(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.L.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    class b extends f {
        b(int i2, Class cls, int i3, int i4) {
            super(i2, cls, i3, i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.L.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return j.b(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.L.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            j.h(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.L.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class c extends f {
        c(int i2, Class cls, int i3, int i4) {
            super(i2, cls, i3, i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.L.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return l.b(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.L.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            l.e(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.L.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class d extends f {
        d(int i2, Class cls, int i3) {
            super(i2, cls, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.L.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(j.c(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.L.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            j.g(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.L.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakHashMap f2288a = new WeakHashMap();

        e() {
        }

        private void b(Map.Entry entry) {
            View view = (View) entry.getKey();
            boolean zBooleanValue = ((Boolean) entry.getValue()).booleanValue();
            boolean z2 = view.isShown() && view.getWindowVisibility() == 0;
            if (zBooleanValue != z2) {
                L.I(view, z2 ? 16 : 32);
                entry.setValue(Boolean.valueOf(z2));
            }
        }

        private void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void e(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        void a(View view) {
            this.f2288a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                c(view);
            }
        }

        void d(View view) {
            this.f2288a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                Iterator it2 = this.f2288a.entrySet().iterator();
                while (it2.hasNext()) {
                    b((Map.Entry) it2.next());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f2289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class f2290b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f2291c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f2292d;

        f(int i2, Class cls, int i3) {
            this(i2, cls, 0, i3);
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= this.f2291c;
        }

        boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        abstract Object c(View view);

        abstract void d(View view, Object obj);

        Object e(View view) {
            if (b()) {
                return c(view);
            }
            Object tag = view.getTag(this.f2289a);
            if (this.f2290b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        void f(View view, Object obj) {
            if (b()) {
                d(view, obj);
            } else if (g(e(view), obj)) {
                L.j(view);
                view.setTag(this.f2289a, obj);
                L.I(view, this.f2292d);
            }
        }

        abstract boolean g(Object obj, Object obj2);

        f(int i2, Class cls, int i3, int i4) {
            this.f2289a = i2;
            this.f2290b = cls;
            this.f2292d = i3;
            this.f2291c = i4;
        }
    }

    static class g {
        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    private static class h {

        class a implements View.OnApplyWindowInsetsListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Y f2293a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f2294b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ E f2295c;

            a(View view, E e2) {
                this.f2294b = view;
                this.f2295c = e2;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                Y yV = Y.v(windowInsets, view);
                int i2 = Build.VERSION.SDK_INT;
                if (i2 < 30) {
                    h.a(windowInsets, this.f2294b);
                    if (yV.equals(this.f2293a)) {
                        return this.f2295c.a(view, yV).t();
                    }
                }
                this.f2293a = yV;
                Y yA = this.f2295c.a(view, yV);
                if (i2 >= 30) {
                    return yA.t();
                }
                L.R(view);
                return yA.t();
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static Y b(View view, Y y2, Rect rect) {
            WindowInsets windowInsetsT = y2.t();
            if (windowInsetsT != null) {
                return Y.v(view.computeSystemWindowInsets(windowInsetsT, rect), view);
            }
            rect.setEmpty();
            return y2;
        }

        static boolean c(View view, float f2, float f3, boolean z2) {
            return view.dispatchNestedFling(f2, f3, z2);
        }

        static boolean d(View view, float f2, float f3) {
            return view.dispatchNestedPreFling(f2, f3);
        }

        static boolean e(View view, int i2, int i3, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
        }

        static boolean f(View view, int i2, int i3, int i4, int i5, int[] iArr) {
            return view.dispatchNestedScroll(i2, i3, i4, i5, iArr);
        }

        static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        static float i(View view) {
            return view.getElevation();
        }

        public static Y j(View view) {
            return Y.a.a(view);
        }

        static String k(View view) {
            return view.getTransitionName();
        }

        static float l(View view) {
            return view.getTranslationZ();
        }

        static float m(View view) {
            return view.getZ();
        }

        static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static void s(View view, float f2) {
            view.setElevation(f2);
        }

        static void t(View view, boolean z2) {
            view.setNestedScrollingEnabled(z2);
        }

        static void u(View view, E e2) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R$id.tag_on_apply_window_listener, e2);
            }
            if (e2 == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, e2));
            }
        }

        static void v(View view, String str) {
            view.setTransitionName(str);
        }

        static void w(View view, float f2) {
            view.setTranslationZ(f2);
        }

        static void x(View view, float f2) {
            view.setZ(f2);
        }

        static boolean y(View view, int i2) {
            return view.startNestedScroll(i2);
        }

        static void z(View view) {
            view.stopNestedScroll();
        }
    }

    private static class i {
        public static Y a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            Y yU = Y.u(rootWindowInsets);
            yU.r(yU);
            yU.d(view.getRootView());
            return yU;
        }

        static int b(View view) {
            return view.getScrollIndicators();
        }

        static void c(View view, int i2) {
            view.setScrollIndicators(i2);
        }

        static void d(View view, int i2, int i3) {
            view.setScrollIndicators(i2, i3);
        }
    }

    static class j {
        static void a(View view, final o oVar) {
            C0213g c0213g = (C0213g) view.getTag(R$id.tag_unhandled_key_listeners);
            if (c0213g == null) {
                c0213g = new C0213g();
                view.setTag(R$id.tag_unhandled_key_listeners, c0213g);
            }
            Objects.requireNonNull(oVar);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener(oVar) { // from class: androidx.core.view.M
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    throw null;
                }
            };
            c0213g.put(oVar, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        static void e(View view, o oVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            C0213g c0213g = (C0213g) view.getTag(R$id.tag_unhandled_key_listeners);
            if (c0213g == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) c0213g.get(oVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        static <T> T f(View view, int i2) {
            return (T) view.requireViewById(i2);
        }

        static void g(View view, boolean z2) {
            view.setAccessibilityHeading(z2);
        }

        static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void i(View view, AbstractC0247a abstractC0247a) {
            view.setAutofillId(null);
        }

        static void j(View view, boolean z2) {
            view.setScreenReaderFocusable(z2);
        }
    }

    private static class k {
        static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        static ContentCaptureSession b(View view) {
            return view.getContentCaptureSession();
        }

        static List<Rect> c(View view) {
            return view.getSystemGestureExclusionRects();
        }

        static void d(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i2, i3);
        }

        static void e(View view, AbstractC0248a abstractC0248a) {
            view.setContentCaptureSession(null);
        }

        static void f(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    private static class l {
        static int a(View view) {
            return view.getImportantForContentCapture();
        }

        static CharSequence b(View view) {
            return view.getStateDescription();
        }

        static boolean c(View view) {
            return view.isImportantForContentCapture();
        }

        static void d(View view, int i2) {
            view.setImportantForContentCapture(i2);
        }

        static void e(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    private static final class m {
        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static C0140d b(View view, C0140d c0140d) {
            ContentInfo contentInfoF = c0140d.f();
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoF);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfoF ? c0140d : C0140d.g(contentInfoPerformReceiveContent);
        }

        public static void c(View view, String[] strArr, F f2) {
            if (f2 == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new n(f2));
            }
        }
    }

    private static final class n implements OnReceiveContentListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final F f2296a;

        n(F f2) {
            this.f2296a = f2;
        }

        @Override // android.view.OnReceiveContentListener
        public ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            C0140d c0140dG = C0140d.g(contentInfo);
            C0140d c0140dA = this.f2296a.a(view, c0140dG);
            if (c0140dA == null) {
                return null;
            }
            return c0140dA == c0140dG ? contentInfo : c0140dA.f();
        }
    }

    public interface o {
    }

    static class p {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final ArrayList f2297d = new ArrayList();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakHashMap f2298a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SparseArray f2299b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private WeakReference f2300c = null;

        p() {
        }

        static p a(View view) {
            p pVar = (p) view.getTag(R$id.tag_unhandled_key_event_manager);
            if (pVar != null) {
                return pVar;
            }
            p pVar2 = new p();
            view.setTag(R$id.tag_unhandled_key_event_manager, pVar2);
            return pVar2;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap weakHashMap = this.f2298a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewC = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewC != null) {
                            return viewC;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray d() {
            if (this.f2299b == null) {
                this.f2299b = new SparseArray();
            }
            return this.f2299b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            int size;
            ArrayList arrayList = (ArrayList) view.getTag(R$id.tag_unhandled_key_listeners);
            if (arrayList == null || arrayList.size() - 1 < 0) {
                return false;
            }
            android.support.v4.media.session.b.a(arrayList.get(size));
            throw null;
        }

        private void g() {
            WeakHashMap weakHashMap = this.f2298a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList = f2297d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                try {
                    if (this.f2298a == null) {
                        this.f2298a = new WeakHashMap();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList arrayList2 = f2297d;
                        View view = (View) ((WeakReference) arrayList2.get(size)).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f2298a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f2298a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View viewC = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewC != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(viewC));
                }
            }
            return viewC != null;
        }

        boolean f(KeyEvent keyEvent) {
            WeakReference weakReference;
            int iIndexOfKey;
            WeakReference weakReference2 = this.f2300c;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.f2300c = new WeakReference(keyEvent);
            SparseArray sparseArrayD = d();
            if (keyEvent.getAction() != 1 || (iIndexOfKey = sparseArrayD.indexOfKey(keyEvent.getKeyCode())) < 0) {
                weakReference = null;
            } else {
                weakReference = (WeakReference) sparseArrayD.valueAt(iIndexOfKey);
                sparseArrayD.removeAt(iIndexOfKey);
            }
            if (weakReference == null) {
                weakReference = (WeakReference) sparseArrayD.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = (View) weakReference.get();
            if (view != null && view.isAttachedToWindow()) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    public static CharSequence A(View view) {
        return (CharSequence) g0().e(view);
    }

    public static String B(View view) {
        return h.k(view);
    }

    public static int C(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static boolean D(View view) {
        Boolean bool = (Boolean) b().e(view);
        return bool != null && bool.booleanValue();
    }

    public static boolean E(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean F(View view) {
        return view.isLaidOut();
    }

    public static boolean G(View view) {
        Boolean bool = (Boolean) T().e(view);
        return bool != null && bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C0140d H(C0140d c0140d) {
        return c0140d;
    }

    static void I(View view, int i2) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z2 = n(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z2) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z2 ? 32 : Peripheral.EXPANSION_3);
                accessibilityEventObtain.setContentChangeTypes(i2);
                if (z2) {
                    accessibilityEventObtain.getText().add(n(view));
                    b0(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i2 != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                        return;
                    } catch (AbstractMethodError unused) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(view.getParent().getClass().getSimpleName());
                        sb.append(" does not fully implement ViewParent");
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i2);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(n(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    public static void J(View view, int i2) {
        boolean z2;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i2);
            return;
        }
        Rect rectR = r();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectR.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z2 = !rectR.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z2 = false;
        }
        d(view, i2);
        if (z2 && rectR.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectR);
        }
    }

    public static void K(View view, int i2) {
        boolean z2;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i2);
            return;
        }
        Rect rectR = r();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectR.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z2 = !rectR.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z2 = false;
        }
        e(view, i2);
        if (z2 && rectR.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectR);
        }
    }

    public static Y L(View view, Y y2) {
        WindowInsets windowInsetsT = y2.t();
        if (windowInsetsT != null) {
            WindowInsets windowInsetsB = g.b(view, windowInsetsT);
            if (!windowInsetsB.equals(windowInsetsT)) {
                return Y.v(windowInsetsB, view);
            }
        }
        return y2;
    }

    private static f M() {
        return new b(R$id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    public static C0140d N(View view, C0140d c0140d) {
        if (Log.isLoggable("ViewCompat", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("performReceiveContent: ");
            sb.append(c0140d);
            sb.append(", view=");
            sb.append(view.getClass().getSimpleName());
            sb.append("[");
            sb.append(view.getId());
            sb.append("]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return m.b(view, c0140d);
        }
        F f2 = (F) view.getTag(R$id.tag_on_receive_content_listener);
        if (f2 == null) {
            return s(view).a(c0140d);
        }
        C0140d c0140dA = f2.a(view, c0140d);
        if (c0140dA == null) {
            return null;
        }
        return s(view).a(c0140dA);
    }

    public static void O(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void P(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void Q(View view, Runnable runnable, long j2) {
        view.postOnAnimationDelayed(runnable, j2);
    }

    public static void R(View view) {
        g.c(view);
    }

    public static void S(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            k.d(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    private static f T() {
        return new a(R$id.tag_screen_reader_focusable, Boolean.class, 28);
    }

    public static void U(View view, C0137a c0137a) {
        if (c0137a == null && (l(view) instanceof C0137a.C0037a)) {
            c0137a = new C0137a();
        }
        b0(view);
        view.setAccessibilityDelegate(c0137a == null ? null : c0137a.d());
    }

    public static void V(View view, boolean z2) {
        b().f(view, Boolean.valueOf(z2));
    }

    public static void W(View view, CharSequence charSequence) {
        M().f(view, charSequence);
        if (charSequence != null) {
            f2287g.a(view);
        } else {
            f2287g.d(view);
        }
    }

    public static void X(View view, ColorStateList colorStateList) {
        int i2 = Build.VERSION.SDK_INT;
        h.q(view, colorStateList);
        if (i2 == 21) {
            Drawable background = view.getBackground();
            boolean z2 = (h.g(view) == null && h.h(view) == null) ? false : true;
            if (background == null || !z2) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    public static void Y(View view, PorterDuff.Mode mode) {
        int i2 = Build.VERSION.SDK_INT;
        h.r(view, mode);
        if (i2 == 21) {
            Drawable background = view.getBackground();
            boolean z2 = (h.g(view) == null && h.h(view) == null) ? false : true;
            if (background == null || !z2) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    public static void Z(View view, float f2) {
        h.s(view, f2);
    }

    public static void a0(View view, int i2) {
        view.setImportantForAccessibility(i2);
    }

    private static f b() {
        return new d(R$id.tag_accessibility_heading, Boolean.class, 28);
    }

    private static void b0(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static U c(View view) {
        if (f2281a == null) {
            f2281a = new WeakHashMap();
        }
        U u2 = (U) f2281a.get(view);
        if (u2 != null) {
            return u2;
        }
        U u3 = new U(view);
        f2281a.put(view, u3);
        return u3;
    }

    public static void c0(View view, E e2) {
        h.u(view, e2);
    }

    private static void d(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            i0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                i0((View) parent);
            }
        }
    }

    public static void d0(View view, boolean z2) {
        T().f(view, Boolean.valueOf(z2));
    }

    private static void e(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            i0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                i0((View) parent);
            }
        }
    }

    public static void e0(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            i.d(view, i2, i3);
        }
    }

    public static Y f(View view, Y y2, Rect rect) {
        return h.b(view, y2, rect);
    }

    public static void f0(View view, String str) {
        h.v(view, str);
    }

    public static Y g(View view, Y y2) {
        WindowInsets windowInsetsT = y2.t();
        if (windowInsetsT != null) {
            WindowInsets windowInsetsA = g.a(view, windowInsetsT);
            if (!windowInsetsA.equals(windowInsetsT)) {
                return Y.v(windowInsetsA, view);
            }
        }
        return y2;
    }

    private static f g0() {
        return new c(R$id.tag_state_description, CharSequence.class, 64, 30);
    }

    static boolean h(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return p.a(view).b(view, keyEvent);
    }

    public static void h0(View view) {
        h.z(view);
    }

    static boolean i(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return p.a(view).f(keyEvent);
    }

    private static void i0(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    static void j(View view) {
        C0137a c0137aK = k(view);
        if (c0137aK == null) {
            c0137aK = new C0137a();
        }
        U(view, c0137aK);
    }

    public static C0137a k(View view) {
        View.AccessibilityDelegate accessibilityDelegateL = l(view);
        if (accessibilityDelegateL == null) {
            return null;
        }
        return accessibilityDelegateL instanceof C0137a.C0037a ? ((C0137a.C0037a) accessibilityDelegateL).f2346a : new C0137a(accessibilityDelegateL);
    }

    private static View.AccessibilityDelegate l(View view) {
        return Build.VERSION.SDK_INT >= 29 ? k.a(view) : m(view);
    }

    private static View.AccessibilityDelegate m(View view) {
        if (f2283c) {
            return null;
        }
        if (f2282b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f2282b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f2283c = true;
                return null;
            }
        }
        try {
            Object obj = f2282b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f2283c = true;
            return null;
        }
    }

    public static CharSequence n(View view) {
        return (CharSequence) M().e(view);
    }

    public static ColorStateList o(View view) {
        return h.g(view);
    }

    public static PorterDuff.Mode p(View view) {
        return h.h(view);
    }

    public static float q(View view) {
        return h.i(view);
    }

    private static Rect r() {
        if (f2284d == null) {
            f2284d = new ThreadLocal();
        }
        Rect rect = (Rect) f2284d.get();
        if (rect == null) {
            rect = new Rect();
            f2284d.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static G s(View view) {
        return view instanceof G ? (G) view : f2286f;
    }

    public static boolean t(View view) {
        return view.getFitsSystemWindows();
    }

    public static int u(View view) {
        return view.getImportantForAccessibility();
    }

    public static int v(View view) {
        return view.getLayoutDirection();
    }

    public static int w(View view) {
        return view.getMinimumHeight();
    }

    public static String[] x(View view) {
        return Build.VERSION.SDK_INT >= 31 ? m.a(view) : (String[]) view.getTag(R$id.tag_on_receive_content_mime_types);
    }

    public static ViewParent y(View view) {
        return view.getParentForAccessibility();
    }

    public static Y z(View view) {
        return Build.VERSION.SDK_INT >= 23 ? i.a(view) : h.j(view);
    }
}
