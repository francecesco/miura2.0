package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.S;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends S implements e.b, androidx.appcompat.view.menu.k {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    e f1512A;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private androidx.appcompat.view.menu.e f1513p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Context f1514q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f1515r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f1516s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private C0114c f1517t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private j.a f1518u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    e.a f1519v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f1520w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f1521x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f1522y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f1523z;

    public interface a {
        boolean a();

        boolean b();
    }

    private static class b implements j.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void a(androidx.appcompat.view.menu.e eVar, boolean z2) {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean b(androidx.appcompat.view.menu.e eVar) {
            return false;
        }
    }

    public static class c extends S.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1525b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1526c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1527d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1528e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f1529f;

        public c(int i2, int i3) {
            super(i2, i3);
            this.f1524a = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super((ViewGroup.LayoutParams) cVar);
            this.f1524a = cVar.f1524a;
        }
    }

    private class d implements e.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            e eVar2 = ActionMenuView.this.f1512A;
            return eVar2 != null && eVar2.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            e.a aVar = ActionMenuView.this.f1519v;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static int J(android.view.View r5, int r6, int r7, int r8, int r9) {
        /*
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r0 = (androidx.appcompat.widget.ActionMenuView.c) r0
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            int r1 = r1 - r9
            int r8 = android.view.View.MeasureSpec.getMode(r8)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            boolean r9 = r5 instanceof androidx.appcompat.view.menu.ActionMenuItemView
            if (r9 == 0) goto L1b
            r9 = r5
            androidx.appcompat.view.menu.ActionMenuItemView r9 = (androidx.appcompat.view.menu.ActionMenuItemView) r9
            goto L1c
        L1b:
            r9 = 0
        L1c:
            r1 = 0
            r2 = 1
            if (r9 == 0) goto L28
            boolean r9 = r9.s()
            if (r9 == 0) goto L28
            r9 = 1
            goto L29
        L28:
            r9 = 0
        L29:
            if (r7 <= 0) goto L4d
            r3 = 2
            if (r9 == 0) goto L30
            if (r7 < r3) goto L4d
        L30:
            int r7 = r7 * r6
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r4)
            r5.measure(r7, r8)
            int r7 = r5.getMeasuredWidth()
            int r4 = r7 / r6
            int r7 = r7 % r6
            if (r7 == 0) goto L46
            int r4 = r4 + 1
        L46:
            if (r9 == 0) goto L4b
            if (r4 >= r3) goto L4b
            goto L4e
        L4b:
            r3 = r4
            goto L4e
        L4d:
            r3 = 0
        L4e:
            boolean r7 = r0.f1524a
            if (r7 != 0) goto L55
            if (r9 == 0) goto L55
            r1 = 1
        L55:
            r0.f1527d = r1
            r0.f1525b = r3
            int r6 = r6 * r3
            r7 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r7)
            r5.measure(r6, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.J(android.view.View, int, int, int, int):int");
    }

    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [boolean, int] */
    private void K(int i2, int i3) {
        int i4;
        int i5;
        boolean z2;
        int i6;
        boolean z3;
        boolean z4;
        int i7;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingTop, -2);
        int i8 = size - paddingLeft;
        int i9 = this.f1522y;
        int i10 = i8 / i9;
        int i11 = i8 % i9;
        if (i10 == 0) {
            setMeasuredDimension(i8, 0);
            return;
        }
        int i12 = i9 + (i11 / i10);
        int childCount = getChildCount();
        int iMax = 0;
        int i13 = 0;
        boolean z5 = false;
        int i14 = 0;
        int iMax2 = 0;
        int i15 = 0;
        long j2 = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            int i16 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z6 = childAt instanceof ActionMenuItemView;
                int i17 = i14 + 1;
                if (z6) {
                    int i18 = this.f1523z;
                    i7 = i17;
                    r14 = 0;
                    childAt.setPadding(i18, 0, i18, 0);
                } else {
                    i7 = i17;
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f1529f = r14;
                cVar.f1526c = r14;
                cVar.f1525b = r14;
                cVar.f1527d = r14;
                ((LinearLayout.LayoutParams) cVar).leftMargin = r14;
                ((LinearLayout.LayoutParams) cVar).rightMargin = r14;
                cVar.f1528e = z6 && ((ActionMenuItemView) childAt).s();
                int iJ = J(childAt, i12, cVar.f1524a ? 1 : i10, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, iJ);
                if (cVar.f1527d) {
                    i15++;
                }
                if (cVar.f1524a) {
                    z5 = true;
                }
                i10 -= iJ;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iJ == 1) {
                    j2 |= (long) (1 << i13);
                    iMax = iMax;
                }
                i14 = i7;
            }
            i13++;
            size2 = i16;
        }
        int i19 = size2;
        boolean z7 = z5 && i14 == 2;
        boolean z8 = false;
        while (i15 > 0 && i10 > 0) {
            int i20 = 0;
            int i21 = 0;
            int i22 = Integer.MAX_VALUE;
            long j3 = 0;
            while (i21 < childCount) {
                boolean z9 = z8;
                c cVar2 = (c) getChildAt(i21).getLayoutParams();
                int i23 = iMax;
                if (cVar2.f1527d) {
                    int i24 = cVar2.f1525b;
                    if (i24 < i22) {
                        j3 = 1 << i21;
                        i22 = i24;
                        i20 = 1;
                    } else if (i24 == i22) {
                        i20++;
                        j3 |= 1 << i21;
                    }
                }
                i21++;
                iMax = i23;
                z8 = z9;
            }
            z2 = z8;
            i6 = iMax;
            j2 |= j3;
            if (i20 > i10) {
                i4 = mode;
                i5 = i8;
                break;
            }
            int i25 = i22 + 1;
            int i26 = 0;
            while (i26 < childCount) {
                View childAt2 = getChildAt(i26);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i27 = i8;
                int i28 = mode;
                long j4 = 1 << i26;
                if ((j3 & j4) == 0) {
                    if (cVar3.f1525b == i25) {
                        j2 |= j4;
                    }
                    z4 = z7;
                } else {
                    if (z7 && cVar3.f1528e && i10 == 1) {
                        int i29 = this.f1523z;
                        z4 = z7;
                        childAt2.setPadding(i29 + i12, 0, i29, 0);
                    } else {
                        z4 = z7;
                    }
                    cVar3.f1525b++;
                    cVar3.f1529f = true;
                    i10--;
                }
                i26++;
                mode = i28;
                i8 = i27;
                z7 = z4;
            }
            iMax = i6;
            z8 = true;
        }
        i4 = mode;
        i5 = i8;
        z2 = z8;
        i6 = iMax;
        boolean z10 = !z5 && i14 == 1;
        if (i10 <= 0 || j2 == 0 || (i10 >= i14 - 1 && !z10 && iMax2 <= 1)) {
            z3 = z2;
        } else {
            float fBitCount = Long.bitCount(j2);
            if (!z10) {
                if ((j2 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f1528e) {
                    fBitCount -= 0.5f;
                }
                int i30 = childCount - 1;
                if ((j2 & ((long) (1 << i30))) != 0 && !((c) getChildAt(i30).getLayoutParams()).f1528e) {
                    fBitCount -= 0.5f;
                }
            }
            int i31 = fBitCount > 0.0f ? (int) ((i10 * i12) / fBitCount) : 0;
            z3 = z2;
            for (int i32 = 0; i32 < childCount; i32++) {
                if ((j2 & ((long) (1 << i32))) != 0) {
                    View childAt3 = getChildAt(i32);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f1526c = i31;
                        cVar4.f1529f = true;
                        if (i32 == 0 && !cVar4.f1528e) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = (-i31) / 2;
                        }
                    } else if (cVar4.f1524a) {
                        cVar4.f1526c = i31;
                        cVar4.f1529f = true;
                        ((LinearLayout.LayoutParams) cVar4).rightMargin = (-i31) / 2;
                    } else {
                        if (i32 != 0) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = i31 / 2;
                        }
                        if (i32 != childCount - 1) {
                            ((LinearLayout.LayoutParams) cVar4).rightMargin = i31 / 2;
                        }
                    }
                    z3 = true;
                }
            }
        }
        if (z3) {
            for (int i33 = 0; i33 < childCount; i33++) {
                View childAt4 = getChildAt(i33);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f1529f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f1525b * i12) + cVar5.f1526c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i5, i4 != 1073741824 ? i6 : i19);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.S
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.S
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.S
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
        }
        return cVar;
    }

    public c D() {
        c cVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        cVarGenerateDefaultLayoutParams.f1524a = true;
        return cVarGenerateDefaultLayoutParams;
    }

    protected boolean E(int i2) {
        boolean zA = false;
        if (i2 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i2 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof a)) {
            zA = ((a) childAt).a();
        }
        return (i2 <= 0 || !(childAt2 instanceof a)) ? zA : zA | ((a) childAt2).b();
    }

    public boolean F() {
        C0114c c0114c = this.f1517t;
        return c0114c != null && c0114c.B();
    }

    public boolean G() {
        C0114c c0114c = this.f1517t;
        return c0114c != null && c0114c.D();
    }

    public boolean H() {
        C0114c c0114c = this.f1517t;
        return c0114c != null && c0114c.E();
    }

    public boolean I() {
        return this.f1516s;
    }

    public androidx.appcompat.view.menu.e L() {
        return this.f1513p;
    }

    public void M(j.a aVar, e.a aVar2) {
        this.f1518u = aVar;
        this.f1519v = aVar2;
    }

    public boolean N() {
        C0114c c0114c = this.f1517t;
        return c0114c != null && c0114c.K();
    }

    @Override // androidx.appcompat.view.menu.e.b
    public boolean a(androidx.appcompat.view.menu.g gVar) {
        return this.f1513p.M(gVar, 0);
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(androidx.appcompat.view.menu.e eVar) {
        this.f1513p = eVar;
    }

    @Override // androidx.appcompat.widget.S, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f1513p == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
            this.f1513p = eVar;
            eVar.S(new d());
            C0114c c0114c = new C0114c(context);
            this.f1517t = c0114c;
            c0114c.J(true);
            C0114c c0114c2 = this.f1517t;
            j.a bVar = this.f1518u;
            if (bVar == null) {
                bVar = new b();
            }
            c0114c2.h(bVar);
            this.f1513p.c(this.f1517t, this.f1514q);
            this.f1517t.H(this);
        }
        return this.f1513p;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1517t.A();
    }

    public int getPopupTheme() {
        return this.f1515r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0114c c0114c = this.f1517t;
        if (c0114c != null) {
            c0114c.j(false);
            if (this.f1517t.E()) {
                this.f1517t.B();
                this.f1517t.K();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        z();
    }

    @Override // androidx.appcompat.widget.S, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int width;
        int paddingLeft;
        if (!this.f1520w) {
            super.onLayout(z2, i2, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i6 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i7 = i4 - i2;
        int paddingRight = (i7 - getPaddingRight()) - getPaddingLeft();
        boolean zB = p0.b(this);
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f1524a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (E(i10)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zB) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i11 = i6 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i11, width, measuredHeight + i11);
                    paddingRight -= measuredWidth;
                    i8 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    E(i10);
                    i9++;
                }
            }
        }
        if (childCount == 1 && i8 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i12 = (i7 / 2) - (measuredWidth2 / 2);
            int i13 = i6 - (measuredHeight2 / 2);
            childAt2.layout(i12, i13, measuredWidth2 + i12, measuredHeight2 + i13);
            return;
        }
        int i14 = i9 - (i8 ^ 1);
        int iMax = Math.max(0, i14 > 0 ? paddingRight / i14 : 0);
        if (zB) {
            int width2 = getWidth() - getPaddingRight();
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt3 = getChildAt(i15);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f1524a) {
                    int i16 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i17 = i6 - (measuredHeight3 / 2);
                    childAt3.layout(i16 - measuredWidth3, i17, i16, measuredHeight3 + i17);
                    width2 = i16 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt4 = getChildAt(i18);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f1524a) {
                int i19 = paddingLeft2 + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i20 = i6 - (measuredHeight4 / 2);
                childAt4.layout(i19, i20, i19 + measuredWidth4, measuredHeight4 + i20);
                paddingLeft2 = i19 + measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + iMax;
            }
        }
    }

    @Override // androidx.appcompat.widget.S, android.view.View
    protected void onMeasure(int i2, int i3) {
        androidx.appcompat.view.menu.e eVar;
        boolean z2 = this.f1520w;
        boolean z3 = View.MeasureSpec.getMode(i2) == 1073741824;
        this.f1520w = z3;
        if (z2 != z3) {
            this.f1521x = 0;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (this.f1520w && (eVar = this.f1513p) != null && size != this.f1521x) {
            this.f1521x = size;
            eVar.L(true);
        }
        int childCount = getChildCount();
        if (this.f1520w && childCount > 0) {
            K(i2, i3);
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            c cVar = (c) getChildAt(i4).getLayoutParams();
            ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
            ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i2, i3);
    }

    public void setExpandedActionViewsExclusive(boolean z2) {
        this.f1517t.G(z2);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.f1512A = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1517t.I(drawable);
    }

    public void setOverflowReserved(boolean z2) {
        this.f1516s = z2;
    }

    public void setPopupTheme(int i2) {
        if (this.f1515r != i2) {
            this.f1515r = i2;
            if (i2 == 0) {
                this.f1514q = getContext();
            } else {
                this.f1514q = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setPresenter(C0114c c0114c) {
        this.f1517t = c0114c;
        c0114c.H(this);
    }

    public void z() {
        C0114c c0114c = this.f1517t;
        if (c0114c != null) {
            c0114c.y();
        }
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f1522y = (int) (56.0f * f2);
        this.f1523z = (int) (f2 * 4.0f);
        this.f1514q = context;
        this.f1515r = 0;
    }
}
