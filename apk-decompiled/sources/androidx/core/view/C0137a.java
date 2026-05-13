package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R$id;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import p.C;

/* JADX INFO: renamed from: androidx.core.view.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0137a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final View.AccessibilityDelegate f2343c = new View.AccessibilityDelegate();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View.AccessibilityDelegate f2344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View.AccessibilityDelegate f2345b;

    /* JADX INFO: renamed from: androidx.core.view.a$a, reason: collision with other inner class name */
    static final class C0037a extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final C0137a f2346a;

        C0037a(C0137a c0137a) {
            this.f2346a = c0137a;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f2346a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            p.D dB = this.f2346a.b(view);
            if (dB != null) {
                return (AccessibilityNodeProvider) dB.a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2346a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            p.C cX0 = p.C.x0(accessibilityNodeInfo);
            cX0.q0(L.G(view));
            cX0.l0(L.D(view));
            cX0.o0(L.n(view));
            cX0.u0(L.A(view));
            this.f2346a.g(view, cX0);
            cX0.e(accessibilityNodeInfo.getText(), view);
            List listC = C0137a.c(view);
            for (int i2 = 0; i2 < listC.size(); i2++) {
                cX0.b((C.a) listC.get(i2));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2346a.h(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f2346a.i(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            return this.f2346a.j(view, i2, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i2) {
            this.f2346a.l(view, i2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f2346a.m(view, accessibilityEvent);
        }
    }

    public C0137a() {
        this(f2343c);
    }

    static List c(View view) {
        List list = (List) view.getTag(R$id.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrP = p.C.p(view.createAccessibilityNodeInfo().getText());
            for (int i2 = 0; clickableSpanArrP != null && i2 < clickableSpanArrP.length; i2++) {
                if (clickableSpan.equals(clickableSpanArrP[i2])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean k(int i2, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(R$id.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i2)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f2344a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public p.D b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f2344a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new p.D(accessibilityNodeProvider);
        }
        return null;
    }

    View.AccessibilityDelegate d() {
        return this.f2345b;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.f2344a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, p.C c2) {
        this.f2344a.onInitializeAccessibilityNodeInfo(view, c2.w0());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.f2344a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f2344a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i2, Bundle bundle) {
        List listC = c(view);
        boolean zPerformAccessibilityAction = false;
        int i3 = 0;
        while (true) {
            if (i3 >= listC.size()) {
                break;
            }
            C.a aVar = (C.a) listC.get(i3);
            if (aVar.a() == i2) {
                zPerformAccessibilityAction = aVar.c(view, bundle);
                break;
            }
            i3++;
        }
        if (!zPerformAccessibilityAction) {
            zPerformAccessibilityAction = this.f2344a.performAccessibilityAction(view, i2, bundle);
        }
        return (zPerformAccessibilityAction || i2 != R$id.accessibility_action_clickable_span || bundle == null) ? zPerformAccessibilityAction : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void l(View view, int i2) {
        this.f2344a.sendAccessibilityEvent(view, i2);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.f2344a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public C0137a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f2344a = accessibilityDelegate;
        this.f2345b = new C0037a(this);
    }
}
