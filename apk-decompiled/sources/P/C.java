package p;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.R$id;
import it.tervis.miura.model.Peripheral;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p.F;

/* JADX INFO: loaded from: classes.dex */
public class C {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f3923d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AccessibilityNodeInfo f3924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3925b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3926c = -1;

    public static class a {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public static final a f3927A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public static final a f3928B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public static final a f3929C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public static final a f3930D;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public static final a f3931E;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public static final a f3932F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public static final a f3933G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public static final a f3934H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public static final a f3935I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public static final a f3936J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public static final a f3937K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public static final a f3938L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public static final a f3939M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public static final a f3940N;

        /* JADX INFO: renamed from: O, reason: collision with root package name */
        public static final a f3941O;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        public static final a f3942P;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        public static final a f3943Q;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        public static final a f3944R;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        public static final a f3945S;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        public static final a f3946T;

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        public static final a f3947U;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f3948d = new a(1, null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f3949e = new a(2, null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f3950f = new a(4, null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f3951g = new a(8, null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f3952h = new a(16, null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f3953i = new a(32, null);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f3954j = new a(64, null);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f3955k = new a(128, null);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f3956l = new a(Peripheral.CONSOLE_8, null, F.b.class);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f3957m = new a(Peripheral.EXPANSION_1, null, F.b.class);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f3958n = new a(Peripheral.EXPANSION_2, null, F.c.class);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f3959o = new a(Peripheral.EXPANSION_3, null, F.c.class);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f3960p = new a(Peripheral.EXPANSION_4, null);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final a f3961q = new a(Peripheral.EXPANSION_5, null);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final a f3962r = new a(Peripheral.EXPANSION_6, null);

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final a f3963s = new a(Peripheral.EXPANSION_7, null);

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final a f3964t = new a(Peripheral.EXPANSION_8, null);

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final a f3965u = new a(Peripheral.EXPANSION_9, null, F.g.class);

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final a f3966v = new a(Peripheral.EXPANSION_10, null);

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final a f3967w = new a(Peripheral.EXPANSION_11, null);

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final a f3968x = new a(Peripheral.EXPANSION_12, null);

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final a f3969y = new a(Peripheral.EXPANSION_13, null, F.h.class);

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final a f3970z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f3971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f3972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class f3973c;

        static {
            int i2 = Build.VERSION.SDK_INT;
            f3970z = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
            f3927A = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R.id.accessibilityActionScrollToPosition, null, null, F.e.class);
            f3928B = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
            f3929C = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id.accessibilityActionScrollLeft, null, null, null);
            f3930D = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id.accessibilityActionScrollDown, null, null, null);
            f3931E = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
            f3932F = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            f3933G = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            f3934H = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            f3935I = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            f3936J = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id.accessibilityActionContextClick, null, null, null);
            f3937K = new a(i2 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, F.f.class);
            f3938L = new a(i2 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, F.d.class);
            f3939M = new a(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            f3940N = new a(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            f3941O = new a(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            f3942P = new a(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            f3943Q = new a(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            f3944R = new a(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            f3945S = new a(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            f3946T = new a(i2 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            f3947U = new a(i2 >= 34 ? d.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
        }

        public a(int i2, CharSequence charSequence) {
            this(null, i2, charSequence, null, null);
        }

        public int a() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f3971a).getId();
        }

        public CharSequence b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f3971a).getLabel();
        }

        public boolean c(View view, Bundle bundle) {
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            Object obj2 = this.f3971a;
            Object obj3 = ((a) obj).f3971a;
            return obj2 == null ? obj3 == null : obj2.equals(obj3);
        }

        public int hashCode() {
            Object obj = this.f3971a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String strI = C.i(this.f3972b);
            if (strI.equals("ACTION_UNKNOWN") && b() != null) {
                strI = b().toString();
            }
            sb.append(strI);
            return sb.toString();
        }

        private a(int i2, CharSequence charSequence, Class cls) {
            this(null, i2, charSequence, null, cls);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        a(Object obj, int i2, CharSequence charSequence, F f2, Class cls) {
            this.f3972b = i2;
            this.f3971a = obj == null ? new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence) : obj;
            this.f3973c = cls;
        }
    }

    private static class b {
        public static Object a(int i2, float f2, float f3, float f4) {
            return new AccessibilityNodeInfo.RangeInfo(i2, f2, f3, f4);
        }

        public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void c(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    private static class c {
        public static e a(boolean z2, int i2, int i3, int i4, int i5, boolean z3, String str, String str2) {
            return new e(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z2).setColumnIndex(i2).setRowIndex(i3).setColumnSpan(i4).setRowSpan(i5).setSelected(z3).setRowTitle(str).setColumnTitle(str2).build());
        }

        public static C b(AccessibilityNodeInfo accessibilityNodeInfo, int i2, int i3) {
            return C.y0(accessibilityNodeInfo.getChild(i2, i3));
        }

        public static String c(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
        }

        public static String d(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
        }

        public static AccessibilityNodeInfo.ExtraRenderingInfo e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        public static C f(AccessibilityNodeInfo accessibilityNodeInfo, int i2) {
            return C.y0(accessibilityNodeInfo.getParent(i2));
        }

        public static String g(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, boolean z2) {
            accessibilityNodeInfo.setTextSelectable(z2);
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
            accessibilityNodeInfo.setUniqueId(str);
        }
    }

    private static class d {
        public static AccessibilityNodeInfo.AccessibilityAction a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static long d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
        }

        public static boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
        }

        public static boolean f(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }

        public static void g(AccessibilityNodeInfo accessibilityNodeInfo, boolean z2) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(z2);
        }

        public static void h(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, long j2) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j2));
        }

        public static void k(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z2) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z2);
        }

        public static void l(AccessibilityNodeInfo accessibilityNodeInfo, boolean z2) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z2);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f3974a;

        e(Object obj) {
            this.f3974a = obj;
        }
    }

    private C(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f3924a = accessibilityNodeInfo;
    }

    private boolean D() {
        return !g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int E(ClickableSpan clickableSpan, SparseArray sparseArray) {
        if (sparseArray != null) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray.valueAt(i2)).get())) {
                    return sparseArray.keyAt(i2);
                }
            }
        }
        int i3 = f3923d;
        f3923d = i3 + 1;
        return i3;
    }

    public static C W(C c2) {
        return x0(AccessibilityNodeInfo.obtain(c2.f3924a));
    }

    private void a0(View view) {
        SparseArray sparseArrayX = x(view);
        if (sparseArrayX != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArrayX.size(); i2++) {
                if (((WeakReference) sparseArrayX.valueAt(i2)).get() == null) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                sparseArrayX.remove(((Integer) arrayList.get(i3)).intValue());
            }
        }
    }

    private void c0(int i2, boolean z2) {
        Bundle bundleT = t();
        if (bundleT != null) {
            int i3 = bundleT.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i2);
            if (!z2) {
                i2 = 0;
            }
            bundleT.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i2 | i3);
        }
    }

    private void d(ClickableSpan clickableSpan, Spanned spanned, int i2) {
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i2));
    }

    private void f() {
        this.f3924a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.f3924a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.f3924a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.f3924a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    private List g(String str) {
        ArrayList<Integer> integerArrayList = this.f3924a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f3924a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    static String i(int i2) {
        if (i2 == 1) {
            return "ACTION_FOCUS";
        }
        if (i2 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i2) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case Peripheral.CONSOLE_8 /* 256 */:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case Peripheral.EXPANSION_1 /* 512 */:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case Peripheral.EXPANSION_2 /* 1024 */:
                return "ACTION_NEXT_HTML_ELEMENT";
            case Peripheral.EXPANSION_3 /* 2048 */:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case Peripheral.EXPANSION_4 /* 4096 */:
                return "ACTION_SCROLL_FORWARD";
            case Peripheral.EXPANSION_5 /* 8192 */:
                return "ACTION_SCROLL_BACKWARD";
            case Peripheral.EXPANSION_6 /* 16384 */:
                return "ACTION_COPY";
            case Peripheral.EXPANSION_7 /* 32768 */:
                return "ACTION_PASTE";
            case Peripheral.EXPANSION_8 /* 65536 */:
                return "ACTION_CUT";
            case Peripheral.EXPANSION_9 /* 131072 */:
                return "ACTION_SET_SELECTION";
            case Peripheral.EXPANSION_10 /* 262144 */:
                return "ACTION_EXPAND";
            case Peripheral.EXPANSION_11 /* 524288 */:
                return "ACTION_COLLAPSE";
            case Peripheral.EXPANSION_13 /* 2097152 */:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionScrollInDirection:
                return "ACTION_SCROLL_IN_DIRECTION";
            default:
                switch (i2) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i2) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i2) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    private boolean k(int i2) {
        Bundle bundleT = t();
        return bundleT != null && (bundleT.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i2) == i2;
    }

    public static ClickableSpan[] p(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray v(View view) {
        SparseArray sparseArrayX = x(view);
        if (sparseArrayX != null) {
            return sparseArrayX;
        }
        SparseArray sparseArray = new SparseArray();
        view.setTag(R$id.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    private SparseArray x(View view) {
        return (SparseArray) view.getTag(R$id.tag_accessibility_clickable_spans);
    }

    public static C x0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new C(accessibilityNodeInfo);
    }

    static C y0(Object obj) {
        if (obj != null) {
            return new C(obj);
        }
        return null;
    }

    public CharSequence A() {
        return Build.VERSION.SDK_INT >= 28 ? this.f3924a.getTooltipText() : this.f3924a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
    }

    public String B() {
        return Build.VERSION.SDK_INT >= 33 ? c.g(this.f3924a) : this.f3924a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public String C() {
        return this.f3924a.getViewIdResourceName();
    }

    public boolean F() {
        return Build.VERSION.SDK_INT >= 34 ? d.f(this.f3924a) : k(64);
    }

    public boolean G() {
        return this.f3924a.isAccessibilityFocused();
    }

    public boolean H() {
        return this.f3924a.isCheckable();
    }

    public boolean I() {
        return this.f3924a.isChecked();
    }

    public boolean J() {
        return this.f3924a.isClickable();
    }

    public boolean K() {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.f3924a.isContextClickable();
        }
        return false;
    }

    public boolean L() {
        return this.f3924a.isEnabled();
    }

    public boolean M() {
        return this.f3924a.isFocusable();
    }

    public boolean N() {
        return this.f3924a.isFocused();
    }

    public boolean O() {
        return k(67108864);
    }

    public boolean P() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f3924a.isImportantForAccessibility();
        }
        return true;
    }

    public boolean Q() {
        return this.f3924a.isLongClickable();
    }

    public boolean R() {
        return this.f3924a.isPassword();
    }

    public boolean S() {
        return this.f3924a.isScrollable();
    }

    public boolean T() {
        return this.f3924a.isSelected();
    }

    public boolean U() {
        return Build.VERSION.SDK_INT >= 33 ? c.h(this.f3924a) : k(Peripheral.EXPANSION_15);
    }

    public boolean V() {
        return this.f3924a.isVisibleToUser();
    }

    public boolean X(int i2, Bundle bundle) {
        return this.f3924a.performAction(i2, bundle);
    }

    public boolean Z(a aVar) {
        return this.f3924a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f3971a);
    }

    public void a(int i2) {
        this.f3924a.addAction(i2);
    }

    public void b(a aVar) {
        this.f3924a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f3971a);
    }

    public void b0(boolean z2) {
        this.f3924a.setAccessibilityFocused(z2);
    }

    public void c(View view) {
        this.f3924a.addChild(view);
    }

    public void d0(Rect rect) {
        this.f3924a.setBoundsInParent(rect);
    }

    public void e(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            f();
            a0(view);
            ClickableSpan[] clickableSpanArrP = p(charSequence);
            if (clickableSpanArrP == null || clickableSpanArrP.length <= 0) {
                return;
            }
            t().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R$id.accessibility_action_clickable_span);
            SparseArray sparseArrayV = v(view);
            for (int i2 = 0; i2 < clickableSpanArrP.length; i2++) {
                int iE = E(clickableSpanArrP[i2], sparseArrayV);
                sparseArrayV.put(iE, new WeakReference(clickableSpanArrP[i2]));
                d(clickableSpanArrP[i2], (Spanned) charSequence, iE);
            }
        }
    }

    public void e0(Rect rect) {
        this.f3924a.setBoundsInScreen(rect);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C)) {
            return false;
        }
        C c2 = (C) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3924a;
        if (accessibilityNodeInfo == null) {
            if (c2.f3924a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(c2.f3924a)) {
            return false;
        }
        return this.f3926c == c2.f3926c && this.f3925b == c2.f3925b;
    }

    public void f0(CharSequence charSequence) {
        this.f3924a.setClassName(charSequence);
    }

    public void g0(boolean z2) {
        this.f3924a.setClickable(z2);
    }

    public List h() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f3924a.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new a(actionList.get(i2)));
        }
        return arrayList;
    }

    public void h0(CharSequence charSequence) {
        this.f3924a.setContentDescription(charSequence);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3924a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void i0(boolean z2) {
        this.f3924a.setEnabled(z2);
    }

    public int j() {
        return this.f3924a.getActions();
    }

    public void j0(boolean z2) {
        this.f3924a.setFocusable(z2);
    }

    public void k0(boolean z2) {
        this.f3924a.setFocused(z2);
    }

    public void l(Rect rect) {
        this.f3924a.getBoundsInParent(rect);
    }

    public void l0(boolean z2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f3924a.setHeading(z2);
        } else {
            c0(2, z2);
        }
    }

    public void m(Rect rect) {
        this.f3924a.getBoundsInScreen(rect);
    }

    public void m0(boolean z2) {
        this.f3924a.setLongClickable(z2);
    }

    public void n(Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            d.b(this.f3924a, rect);
            return;
        }
        Rect rect2 = (Rect) this.f3924a.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public void n0(CharSequence charSequence) {
        this.f3924a.setPackageName(charSequence);
    }

    public CharSequence o() {
        return this.f3924a.getClassName();
    }

    public void o0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f3924a.setPaneTitle(charSequence);
        } else {
            this.f3924a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void p0(View view) {
        this.f3925b = -1;
        this.f3924a.setParent(view);
    }

    public CharSequence q() {
        return Build.VERSION.SDK_INT >= 34 ? d.c(this.f3924a) : this.f3924a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public void q0(boolean z2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f3924a.setScreenReaderFocusable(z2);
        } else {
            c0(1, z2);
        }
    }

    public CharSequence r() {
        return this.f3924a.getContentDescription();
    }

    public void r0(boolean z2) {
        this.f3924a.setScrollable(z2);
    }

    public CharSequence s() {
        return this.f3924a.getError();
    }

    public void s0(boolean z2) {
        this.f3924a.setSelected(z2);
    }

    public Bundle t() {
        return this.f3924a.getExtras();
    }

    public void t0(View view) {
        this.f3926c = -1;
        this.f3924a.setSource(view);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        l(rect);
        sb.append("; boundsInParent: " + rect);
        m(rect);
        sb.append("; boundsInScreen: " + rect);
        n(rect);
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(w());
        sb.append("; className: ");
        sb.append(o());
        sb.append("; text: ");
        sb.append(z());
        sb.append("; error: ");
        sb.append(s());
        sb.append("; maxTextLength: ");
        sb.append(u());
        sb.append("; stateDescription: ");
        sb.append(y());
        sb.append("; contentDescription: ");
        sb.append(r());
        sb.append("; tooltipText: ");
        sb.append(A());
        sb.append("; viewIdResName: ");
        sb.append(C());
        sb.append("; uniqueId: ");
        sb.append(B());
        sb.append("; checkable: ");
        sb.append(H());
        sb.append("; checked: ");
        sb.append(I());
        sb.append("; focusable: ");
        sb.append(M());
        sb.append("; focused: ");
        sb.append(N());
        sb.append("; selected: ");
        sb.append(T());
        sb.append("; clickable: ");
        sb.append(J());
        sb.append("; longClickable: ");
        sb.append(Q());
        sb.append("; contextClickable: ");
        sb.append(K());
        sb.append("; enabled: ");
        sb.append(L());
        sb.append("; password: ");
        sb.append(R());
        sb.append("; scrollable: " + S());
        sb.append("; containerTitle: ");
        sb.append(q());
        sb.append("; granularScrollingSupported: ");
        sb.append(O());
        sb.append("; importantForAccessibility: ");
        sb.append(P());
        sb.append("; visible: ");
        sb.append(V());
        sb.append("; isTextSelectable: ");
        sb.append(U());
        sb.append("; accessibilityDataSensitive: ");
        sb.append(F());
        sb.append("; [");
        List listH = h();
        for (int i2 = 0; i2 < listH.size(); i2++) {
            a aVar = (a) listH.get(i2);
            String strI = i(aVar.a());
            if (strI.equals("ACTION_UNKNOWN") && aVar.b() != null) {
                strI = aVar.b().toString();
            }
            sb.append(strI);
            if (i2 != listH.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int u() {
        return this.f3924a.getMaxTextLength();
    }

    public void u0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            b.c(this.f3924a, charSequence);
        } else {
            this.f3924a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public void v0(boolean z2) {
        this.f3924a.setVisibleToUser(z2);
    }

    public CharSequence w() {
        return this.f3924a.getPackageName();
    }

    public AccessibilityNodeInfo w0() {
        return this.f3924a;
    }

    public CharSequence y() {
        return Build.VERSION.SDK_INT >= 30 ? b.b(this.f3924a) : this.f3924a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public CharSequence z() {
        if (!D()) {
            return this.f3924a.getText();
        }
        List listG = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List listG2 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List listG3 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List listG4 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f3924a.getText(), 0, this.f3924a.getText().length()));
        for (int i2 = 0; i2 < listG.size(); i2++) {
            spannableString.setSpan(new C0241a(((Integer) listG4.get(i2)).intValue(), this, t().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) listG.get(i2)).intValue(), ((Integer) listG2.get(i2)).intValue(), ((Integer) listG3.get(i2)).intValue());
        }
        return spannableString;
    }

    public C(Object obj) {
        this.f3924a = (AccessibilityNodeInfo) obj;
    }

    public void Y() {
    }
}
