package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import f.AbstractC0193c;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class O extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f1597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1601e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1602f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d f1603g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1604h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1605i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1606j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private androidx.core.view.U f1607k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private androidx.core.widget.f f1608l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    f f1609m;

    static class a {
        static void a(View view, float f2, float f3) {
            view.drawableHotspotChanged(f2, f3);
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Method f1610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Method f1611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static Method f1612c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static boolean f1613d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
                f1610a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f1611b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f1612c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f1613d = true;
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            }
        }

        static boolean a() {
            return f1613d;
        }

        static void b(O o2, int i2, View view) {
            try {
                f1610a.invoke(o2, Integer.valueOf(i2), view, Boolean.FALSE, -1, -1);
                f1611b.invoke(o2, Integer.valueOf(i2));
                f1612c.invoke(o2, Integer.valueOf(i2));
            } catch (IllegalAccessException | InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }

    static class c {
        static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        static void b(AbsListView absListView, boolean z2) {
            absListView.setSelectedChildViewEnabled(z2);
        }
    }

    private static class d extends AbstractC0193c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1614b;

        d(Drawable drawable) {
            super(drawable);
            this.f1614b = true;
        }

        void b(boolean z2) {
            this.f1614b = z2;
        }

        @Override // f.AbstractC0193c, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f1614b) {
                super.draw(canvas);
            }
        }

        @Override // f.AbstractC0193c, android.graphics.drawable.Drawable
        public void setHotspot(float f2, float f3) {
            if (this.f1614b) {
                super.setHotspot(f2, f3);
            }
        }

        @Override // f.AbstractC0193c, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i2, int i3, int i4, int i5) {
            if (this.f1614b) {
                super.setHotspotBounds(i2, i3, i4, i5);
            }
        }

        @Override // f.AbstractC0193c, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f1614b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // f.AbstractC0193c, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z2, boolean z3) {
            if (this.f1614b) {
                return super.setVisible(z2, z3);
            }
            return false;
        }
    }

    static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Field f1615a;

        static {
            Field declaredField = null;
            try {
                declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
            f1615a = declaredField;
        }

        static boolean a(AbsListView absListView) {
            Field field = f1615a;
            if (field == null) {
                return false;
            }
            try {
                return field.getBoolean(absListView);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return false;
            }
        }

        static void b(AbsListView absListView, boolean z2) {
            Field field = f1615a;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z2));
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private class f implements Runnable {
        f() {
        }

        public void a() {
            O o2 = O.this;
            o2.f1609m = null;
            o2.removeCallbacks(this);
        }

        public void c() {
            O.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            O o2 = O.this;
            o2.f1609m = null;
            o2.drawableStateChanged();
        }
    }

    O(Context context, boolean z2) {
        super(context, null, R$attr.dropDownListViewStyle);
        this.f1597a = new Rect();
        this.f1598b = 0;
        this.f1599c = 0;
        this.f1600d = 0;
        this.f1601e = 0;
        this.f1605i = z2;
        setCacheColorHint(0);
    }

    private void a() {
        this.f1606j = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1602f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        androidx.core.view.U u2 = this.f1607k;
        if (u2 != null) {
            u2.c();
            this.f1607k = null;
        }
    }

    private void b(View view, int i2) {
        performItemClick(view, i2, getItemIdAtPosition(i2));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (this.f1597a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f1597a);
        selector.draw(canvas);
    }

    private void f(int i2, View view) {
        Rect rect = this.f1597a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1598b;
        rect.top -= this.f1599c;
        rect.right += this.f1600d;
        rect.bottom += this.f1601e;
        boolean zK = k();
        if (view.isEnabled() != zK) {
            l(!zK);
            if (i2 != -1) {
                refreshDrawableState();
            }
        }
    }

    private void g(int i2, View view) {
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i2 == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        f(i2, view);
        if (z2) {
            Rect rect = this.f1597a;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            androidx.core.graphics.drawable.a.j(selector, fExactCenterX, fExactCenterY);
        }
    }

    private void h(int i2, View view, float f2, float f3) {
        g(i2, view);
        Drawable selector = getSelector();
        if (selector == null || i2 == -1) {
            return;
        }
        androidx.core.graphics.drawable.a.j(selector, f2, f3);
    }

    private void i(View view, int i2, float f2, float f3) {
        View childAt;
        this.f1606j = true;
        a.a(this, f2, f3);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i3 = this.f1602f;
        if (i3 != -1 && (childAt = getChildAt(i3 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f1602f = i2;
        a.a(view, f2 - view.getLeft(), f3 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i2, view, f2, f3);
        j(false);
        refreshDrawableState();
    }

    private void j(boolean z2) {
        d dVar = this.f1603g;
        if (dVar != null) {
            dVar.b(z2);
        }
    }

    private boolean k() {
        return Build.VERSION.SDK_INT >= 33 ? c.a(this) : e.a(this);
    }

    private void l(boolean z2) {
        if (Build.VERSION.SDK_INT >= 33) {
            c.b(this, z2);
        } else {
            e.b(this, z2);
        }
    }

    private boolean m() {
        return this.f1606j;
    }

    private void n() {
        Drawable selector = getSelector();
        if (selector != null && m() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public int d(int i2, int i3, int i4, int i5, int i6) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (adapter == null) {
            return measuredHeight;
        }
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < count) {
            int itemViewType = adapter.getItemViewType(i7);
            if (itemViewType != i8) {
                view = null;
                i8 = itemViewType;
            }
            view = adapter.getView(i7, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i10 = layoutParams.height;
            view.measure(i2, i10 > 0 ? View.MeasureSpec.makeMeasureSpec(i10, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i7 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i5) {
                return (i6 < 0 || i7 <= i6 || i9 <= 0 || measuredHeight == i5) ? i5 : i9;
            }
            if (i6 >= 0 && i7 >= i6) {
                i9 = measuredHeight;
            }
            i7++;
        }
        return measuredHeight;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f1609m != null) {
            return;
        }
        super.drawableStateChanged();
        j(true);
        n();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r9 = 0
            r3 = 1
            goto L46
        L11:
            r9 = 0
            r3 = 0
            goto L46
        L14:
            r3 = 1
            goto L17
        L16:
            r3 = 0
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = 1
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.i(r3, r5, r4, r9)
            if (r0 != r1) goto Le
            r7.b(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.a()
        L4d:
            if (r3 == 0) goto L65
            androidx.core.widget.f r9 = r7.f1608l
            if (r9 != 0) goto L5a
            androidx.core.widget.f r9 = new androidx.core.widget.f
            r9.<init>(r7)
            r7.f1608l = r9
        L5a:
            androidx.core.widget.f r9 = r7.f1608l
            r9.m(r1)
            androidx.core.widget.f r9 = r7.f1608l
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            androidx.core.widget.f r8 = r7.f1608l
            if (r8 == 0) goto L6c
            r8.m(r2)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.O.e(android.view.MotionEvent, int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f1605i || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f1605i || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f1605i || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f1605i && this.f1604h) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f1609m = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1609m == null) {
            f fVar = new f();
            this.f1609m = fVar;
            fVar.c();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i2 < 30 || !b.a()) {
                        setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                    } else {
                        b.b(this, iPointToPosition, childAt);
                    }
                }
                n();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1602f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        f fVar = this.f1609m;
        if (fVar != null) {
            fVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean z2) {
        this.f1604h = z2;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        d dVar = drawable != null ? new d(drawable) : null;
        this.f1603g = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1598b = rect.left;
        this.f1599c = rect.top;
        this.f1600d = rect.right;
        this.f1601e = rect.bottom;
    }
}
