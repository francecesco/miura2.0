package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class V extends T implements U {

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private static Method f1744K;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private U f1745J;

    static class a {
        static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    static class b {
        static void a(PopupWindow popupWindow, boolean z2) {
            popupWindow.setTouchModal(z2);
        }
    }

    public static class c extends O {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final int f1746n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final int f1747o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private U f1748p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private MenuItem f1749q;

        public c(Context context, boolean z2) {
            super(context, z2);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.f1746n = 21;
                this.f1747o = 22;
            } else {
                this.f1746n = 22;
                this.f1747o = 21;
            }
        }

        @Override // androidx.appcompat.widget.O
        public /* bridge */ /* synthetic */ int d(int i2, int i3, int i4, int i5, int i6) {
            return super.d(i2, i3, i4, i5, i6);
        }

        @Override // androidx.appcompat.widget.O
        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i2) {
            return super.e(motionEvent, i2);
        }

        @Override // androidx.appcompat.widget.O, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.O, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.O, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.O, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.O, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            androidx.appcompat.view.menu.d dVar;
            int headersCount;
            int iPointToPosition;
            int i2;
            if (this.f1748p != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    dVar = (androidx.appcompat.view.menu.d) headerViewListAdapter.getWrappedAdapter();
                } else {
                    dVar = (androidx.appcompat.view.menu.d) adapter;
                    headersCount = 0;
                }
                androidx.appcompat.view.menu.g item = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i2 = iPointToPosition - headersCount) < 0 || i2 >= dVar.getCount()) ? null : dVar.getItem(i2);
                MenuItem menuItem = this.f1749q;
                if (menuItem != item) {
                    androidx.appcompat.view.menu.e eVarB = dVar.b();
                    if (menuItem != null) {
                        this.f1748p.h(eVarB, menuItem);
                    }
                    this.f1749q = item;
                    if (item != null) {
                        this.f1748p.a(eVarB, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i2 == this.f1746n) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i2 != this.f1747o) {
                return super.onKeyDown(i2, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((androidx.appcompat.view.menu.d) adapter).b().e(false);
            return true;
        }

        @Override // androidx.appcompat.widget.O, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(U u2) {
            this.f1748p = u2;
        }

        @Override // androidx.appcompat.widget.O, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f1744K = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    public V(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public void N(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.a(this.f1655F, (Transition) obj);
        }
    }

    public void O(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.b(this.f1655F, (Transition) obj);
        }
    }

    public void P(U u2) {
        this.f1745J = u2;
    }

    public void Q(boolean z2) {
        if (Build.VERSION.SDK_INT > 28) {
            b.a(this.f1655F, z2);
            return;
        }
        Method method = f1744K;
        if (method != null) {
            try {
                method.invoke(this.f1655F, Boolean.valueOf(z2));
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.appcompat.widget.U
    public void a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        U u2 = this.f1745J;
        if (u2 != null) {
            u2.a(eVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.U
    public void h(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        U u2 = this.f1745J;
        if (u2 != null) {
            u2.h(eVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.T
    O s(Context context, boolean z2) {
        c cVar = new c(context, z2);
        cVar.setHoverListener(this);
        return cVar;
    }
}
