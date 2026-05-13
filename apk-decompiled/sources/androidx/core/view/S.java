package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public abstract class S {

    static class a {
        static boolean a(ViewParent viewParent, View view, float f2, float f3, boolean z2) {
            return viewParent.onNestedFling(view, f2, f3, z2);
        }

        static boolean b(ViewParent viewParent, View view, float f2, float f3) {
            return viewParent.onNestedPreFling(view, f2, f3);
        }

        static void c(ViewParent viewParent, View view, int i2, int i3, int[] iArr) {
            viewParent.onNestedPreScroll(view, i2, i3, iArr);
        }

        static void d(ViewParent viewParent, View view, int i2, int i3, int i4, int i5) {
            viewParent.onNestedScroll(view, i2, i3, i4, i5);
        }

        static void e(ViewParent viewParent, View view, View view2, int i2) {
            viewParent.onNestedScrollAccepted(view, view2, i2);
        }

        static boolean f(ViewParent viewParent, View view, View view2, int i2) {
            return viewParent.onStartNestedScroll(view, view2, i2);
        }

        static void g(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f2, float f3, boolean z2) {
        try {
            return a.a(viewParent, view, f2, f3, z2);
        } catch (AbstractMethodError unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("ViewParent ");
            sb.append(viewParent);
            sb.append(" does not implement interface method onNestedFling");
            return false;
        }
    }

    public static boolean b(ViewParent viewParent, View view, float f2, float f3) {
        try {
            return a.b(viewParent, view, f2, f3);
        } catch (AbstractMethodError unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("ViewParent ");
            sb.append(viewParent);
            sb.append(" does not implement interface method onNestedPreFling");
            return false;
        }
    }

    public static void c(ViewParent viewParent, View view, int i2, int i3, int[] iArr, int i4) {
        if (viewParent instanceof B) {
            ((B) viewParent).j(view, i2, i3, iArr, i4);
            return;
        }
        if (i4 == 0) {
            try {
                a.c(viewParent, view, i2, i3, iArr);
            } catch (AbstractMethodError unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("ViewParent ");
                sb.append(viewParent);
                sb.append(" does not implement interface method onNestedPreScroll");
            }
        }
    }

    public static void d(ViewParent viewParent, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (viewParent instanceof C) {
            ((C) viewParent).m(view, i2, i3, i4, i5, i6, iArr);
            return;
        }
        iArr[0] = iArr[0] + i4;
        iArr[1] = iArr[1] + i5;
        if (viewParent instanceof B) {
            ((B) viewParent).n(view, i2, i3, i4, i5, i6);
            return;
        }
        if (i6 == 0) {
            try {
                a.d(viewParent, view, i2, i3, i4, i5);
            } catch (AbstractMethodError unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("ViewParent ");
                sb.append(viewParent);
                sb.append(" does not implement interface method onNestedScroll");
            }
        }
    }

    public static void e(ViewParent viewParent, View view, View view2, int i2, int i3) {
        if (viewParent instanceof B) {
            ((B) viewParent).h(view, view2, i2, i3);
            return;
        }
        if (i3 == 0) {
            try {
                a.e(viewParent, view, view2, i2);
            } catch (AbstractMethodError unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("ViewParent ");
                sb.append(viewParent);
                sb.append(" does not implement interface method onNestedScrollAccepted");
            }
        }
    }

    public static boolean f(ViewParent viewParent, View view, View view2, int i2, int i3) {
        if (viewParent instanceof B) {
            return ((B) viewParent).o(view, view2, i2, i3);
        }
        if (i3 != 0) {
            return false;
        }
        try {
            return a.f(viewParent, view, view2, i2);
        } catch (AbstractMethodError unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("ViewParent ");
            sb.append(viewParent);
            sb.append(" does not implement interface method onStartNestedScroll");
            return false;
        }
    }

    public static void g(ViewParent viewParent, View view, int i2) {
        if (viewParent instanceof B) {
            ((B) viewParent).i(view, i2);
            return;
        }
        if (i2 == 0) {
            try {
                a.g(viewParent, view);
            } catch (AbstractMethodError unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("ViewParent ");
                sb.append(viewParent);
                sb.append(" does not implement interface method onStopNestedScroll");
            }
        }
    }
}
