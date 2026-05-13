package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.DialogInterfaceC0107c;
import e.AbstractC0190a;
import o.AbstractC0234c;

/* JADX INFO: loaded from: classes.dex */
public class A extends Spinner {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f1421i = {R.attr.spinnerMode};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0116e f1422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Q f1424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SpinnerAdapter f1425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f1426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private h f1427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f1428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Rect f1429h;

    class a extends Q {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ f f1430j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, f fVar) {
            super(view);
            this.f1430j = fVar;
        }

        @Override // androidx.appcompat.widget.Q
        public h.e b() {
            return this.f1430j;
        }

        @Override // androidx.appcompat.widget.Q
        public boolean c() {
            if (A.this.getInternalPopup().b()) {
                return true;
            }
            A.this.b();
            return true;
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!A.this.getInternalPopup().b()) {
                A.this.b();
            }
            ViewTreeObserver viewTreeObserver = A.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    private static final class c {
        static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (AbstractC0234c.a(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                return;
            }
            themedSpinnerAdapter.setDropDownViewTheme(theme);
        }
    }

    class d implements h, DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        DialogInterfaceC0107c f1433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ListAdapter f1434b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f1435c;

        d() {
        }

        @Override // androidx.appcompat.widget.A.h
        public boolean b() {
            DialogInterfaceC0107c dialogInterfaceC0107c = this.f1433a;
            if (dialogInterfaceC0107c != null) {
                return dialogInterfaceC0107c.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.A.h
        public void c(int i2) {
        }

        @Override // androidx.appcompat.widget.A.h
        public int d() {
            return 0;
        }

        @Override // androidx.appcompat.widget.A.h
        public void dismiss() {
            DialogInterfaceC0107c dialogInterfaceC0107c = this.f1433a;
            if (dialogInterfaceC0107c != null) {
                dialogInterfaceC0107c.dismiss();
                this.f1433a = null;
            }
        }

        @Override // androidx.appcompat.widget.A.h
        public void e(int i2, int i3) {
            if (this.f1434b == null) {
                return;
            }
            DialogInterfaceC0107c.a aVar = new DialogInterfaceC0107c.a(A.this.getPopupContext());
            CharSequence charSequence = this.f1435c;
            if (charSequence != null) {
                aVar.h(charSequence);
            }
            DialogInterfaceC0107c dialogInterfaceC0107cA = aVar.g(this.f1434b, A.this.getSelectedItemPosition(), this).a();
            this.f1433a = dialogInterfaceC0107cA;
            ListView listViewK = dialogInterfaceC0107cA.k();
            listViewK.setTextDirection(i2);
            listViewK.setTextAlignment(i3);
            this.f1433a.show();
        }

        @Override // androidx.appcompat.widget.A.h
        public int g() {
            return 0;
        }

        @Override // androidx.appcompat.widget.A.h
        public Drawable i() {
            return null;
        }

        @Override // androidx.appcompat.widget.A.h
        public CharSequence j() {
            return this.f1435c;
        }

        @Override // androidx.appcompat.widget.A.h
        public void l(CharSequence charSequence) {
            this.f1435c = charSequence;
        }

        @Override // androidx.appcompat.widget.A.h
        public void m(Drawable drawable) {
        }

        @Override // androidx.appcompat.widget.A.h
        public void n(int i2) {
        }

        @Override // androidx.appcompat.widget.A.h
        public void o(ListAdapter listAdapter) {
            this.f1434b = listAdapter;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            A.this.setSelection(i2);
            if (A.this.getOnItemClickListener() != null) {
                A.this.performItemClick(null, i2, this.f1434b.getItemId(i2));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.A.h
        public void p(int i2) {
        }
    }

    private static class e implements ListAdapter, SpinnerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SpinnerAdapter f1437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ListAdapter f1438b;

        public e(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1437a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1438b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null || Build.VERSION.SDK_INT < 23 || !B.a(spinnerAdapter)) {
                return;
            }
            c.a(C.a(spinnerAdapter), theme);
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1438b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1437a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1437a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            SpinnerAdapter spinnerAdapter = this.f1437a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            SpinnerAdapter spinnerAdapter = this.f1437a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i2);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i2) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            return getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1437a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.f1438b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1437a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1437a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    class f extends T implements h {

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        private CharSequence f1439J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        ListAdapter f1440K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        private final Rect f1441L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        private int f1442M;

        class a implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ A f1444a;

            a(A a2) {
                this.f1444a = a2;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                A.this.setSelection(i2);
                if (A.this.getOnItemClickListener() != null) {
                    f fVar = f.this;
                    A.this.performItemClick(view, i2, fVar.f1440K.getItemId(i2));
                }
                f.this.dismiss();
            }
        }

        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                f fVar = f.this;
                if (!fVar.Q(A.this)) {
                    f.this.dismiss();
                } else {
                    f.this.O();
                    f.super.f();
                }
            }
        }

        class c implements PopupWindow.OnDismissListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f1447a;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f1447a = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = A.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f1447a);
                }
            }
        }

        public f(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.f1441L = new Rect();
            z(A.this);
            F(true);
            K(0);
            H(new a(A.this));
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x009a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void O() {
            /*
                r8 = this;
                android.graphics.drawable.Drawable r0 = r8.i()
                if (r0 == 0) goto L24
                androidx.appcompat.widget.A r1 = androidx.appcompat.widget.A.this
                android.graphics.Rect r1 = r1.f1429h
                r0.getPadding(r1)
                androidx.appcompat.widget.A r0 = androidx.appcompat.widget.A.this
                boolean r0 = androidx.appcompat.widget.p0.b(r0)
                if (r0 == 0) goto L1c
                androidx.appcompat.widget.A r0 = androidx.appcompat.widget.A.this
                android.graphics.Rect r0 = r0.f1429h
                int r0 = r0.right
                goto L2e
            L1c:
                androidx.appcompat.widget.A r0 = androidx.appcompat.widget.A.this
                android.graphics.Rect r0 = r0.f1429h
                int r0 = r0.left
                int r0 = -r0
                goto L2e
            L24:
                androidx.appcompat.widget.A r0 = androidx.appcompat.widget.A.this
                android.graphics.Rect r0 = r0.f1429h
                r1 = 0
                r0.right = r1
                r0.left = r1
                r0 = 0
            L2e:
                androidx.appcompat.widget.A r1 = androidx.appcompat.widget.A.this
                int r1 = r1.getPaddingLeft()
                androidx.appcompat.widget.A r2 = androidx.appcompat.widget.A.this
                int r2 = r2.getPaddingRight()
                androidx.appcompat.widget.A r3 = androidx.appcompat.widget.A.this
                int r3 = r3.getWidth()
                androidx.appcompat.widget.A r4 = androidx.appcompat.widget.A.this
                int r5 = r4.f1428g
                r6 = -2
                if (r5 != r6) goto L7b
                android.widget.ListAdapter r5 = r8.f1440K
                android.widget.SpinnerAdapter r5 = (android.widget.SpinnerAdapter) r5
                android.graphics.drawable.Drawable r6 = r8.i()
                int r4 = r4.a(r5, r6)
                androidx.appcompat.widget.A r5 = androidx.appcompat.widget.A.this
                android.content.Context r5 = r5.getContext()
                android.content.res.Resources r5 = r5.getResources()
                android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
                int r5 = r5.widthPixels
                androidx.appcompat.widget.A r6 = androidx.appcompat.widget.A.this
                android.graphics.Rect r6 = r6.f1429h
                int r7 = r6.left
                int r5 = r5 - r7
                int r6 = r6.right
                int r5 = r5 - r6
                if (r4 <= r5) goto L70
                r4 = r5
            L70:
                int r5 = r3 - r1
                int r5 = r5 - r2
                int r4 = java.lang.Math.max(r4, r5)
            L77:
                r8.B(r4)
                goto L85
            L7b:
                r4 = -1
                if (r5 != r4) goto L82
                int r4 = r3 - r1
                int r4 = r4 - r2
                goto L77
            L82:
                r8.B(r5)
            L85:
                androidx.appcompat.widget.A r4 = androidx.appcompat.widget.A.this
                boolean r4 = androidx.appcompat.widget.p0.b(r4)
                if (r4 == 0) goto L9a
                int r3 = r3 - r2
                int r1 = r8.v()
                int r3 = r3 - r1
                int r1 = r8.P()
                int r3 = r3 - r1
                int r0 = r0 + r3
                goto La0
            L9a:
                int r2 = r8.P()
                int r1 = r1 + r2
                int r0 = r0 + r1
            La0:
                r8.c(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.A.f.O():void");
        }

        public int P() {
            return this.f1442M;
        }

        boolean Q(View view) {
            return view.isAttachedToWindow() && view.getGlobalVisibleRect(this.f1441L);
        }

        @Override // androidx.appcompat.widget.A.h
        public void e(int i2, int i3) {
            ViewTreeObserver viewTreeObserver;
            boolean zB = b();
            O();
            E(2);
            super.f();
            ListView listViewK = k();
            listViewK.setChoiceMode(1);
            listViewK.setTextDirection(i2);
            listViewK.setTextAlignment(i3);
            L(A.this.getSelectedItemPosition());
            if (zB || (viewTreeObserver = A.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            G(new c(bVar));
        }

        @Override // androidx.appcompat.widget.A.h
        public CharSequence j() {
            return this.f1439J;
        }

        @Override // androidx.appcompat.widget.A.h
        public void l(CharSequence charSequence) {
            this.f1439J = charSequence;
        }

        @Override // androidx.appcompat.widget.T, androidx.appcompat.widget.A.h
        public void o(ListAdapter listAdapter) {
            super.o(listAdapter);
            this.f1440K = listAdapter;
        }

        @Override // androidx.appcompat.widget.A.h
        public void p(int i2) {
            this.f1442M = i2;
        }
    }

    static class g extends View.BaseSavedState {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f1449a;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i2) {
                return new g[i2];
            }
        }

        g(Parcel parcel) {
            super(parcel);
            this.f1449a = parcel.readByte() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f1449a ? (byte) 1 : (byte) 0);
        }

        g(Parcelable parcelable) {
            super(parcelable);
        }
    }

    interface h {
        boolean b();

        void c(int i2);

        int d();

        void dismiss();

        void e(int i2, int i3);

        int g();

        Drawable i();

        CharSequence j();

        void l(CharSequence charSequence);

        void m(Drawable drawable);

        void n(int i2);

        void o(ListAdapter listAdapter);

        void p(int i2);
    }

    public A(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.spinnerStyle);
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.f1429h);
        Rect rect = this.f1429h;
        return iMax2 + rect.left + rect.right;
    }

    void b() {
        this.f1427f.e(getTextDirection(), getTextAlignment());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0116e c0116e = this.f1422a;
        if (c0116e != null) {
            c0116e.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        h hVar = this.f1427f;
        return hVar != null ? hVar.d() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        h hVar = this.f1427f;
        return hVar != null ? hVar.g() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f1427f != null ? this.f1428g : super.getDropDownWidth();
    }

    final h getInternalPopup() {
        return this.f1427f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        h hVar = this.f1427f;
        return hVar != null ? hVar.i() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f1423b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        h hVar = this.f1427f;
        return hVar != null ? hVar.j() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0116e c0116e = this.f1422a;
        if (c0116e != null) {
            return c0116e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0116e c0116e = this.f1422a;
        if (c0116e != null) {
            return c0116e.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h hVar = this.f1427f;
        if (hVar == null || !hVar.b()) {
            return;
        }
        this.f1427f.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f1427f == null || View.MeasureSpec.getMode(i2) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.getSuperState());
        if (!gVar.f1449a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        g gVar = new g(super.onSaveInstanceState());
        h hVar = this.f1427f;
        gVar.f1449a = hVar != null && hVar.b();
        return gVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Q q2 = this.f1424c;
        if (q2 == null || !q2.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        h hVar = this.f1427f;
        if (hVar == null) {
            return super.performClick();
        }
        if (hVar.b()) {
            return true;
        }
        b();
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0116e c0116e = this.f1422a;
        if (c0116e != null) {
            c0116e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0116e c0116e = this.f1422a;
        if (c0116e != null) {
            c0116e.g(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i2) {
        h hVar = this.f1427f;
        if (hVar == null) {
            super.setDropDownHorizontalOffset(i2);
        } else {
            hVar.p(i2);
            this.f1427f.c(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i2) {
        h hVar = this.f1427f;
        if (hVar != null) {
            hVar.n(i2);
        } else {
            super.setDropDownVerticalOffset(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i2) {
        if (this.f1427f != null) {
            this.f1428g = i2;
        } else {
            super.setDropDownWidth(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        h hVar = this.f1427f;
        if (hVar != null) {
            hVar.m(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(AbstractC0190a.b(getPopupContext(), i2));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        h hVar = this.f1427f;
        if (hVar != null) {
            hVar.l(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0116e c0116e = this.f1422a;
        if (c0116e != null) {
            c0116e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0116e c0116e = this.f1422a;
        if (c0116e != null) {
            c0116e.j(mode);
        }
    }

    public A(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, -1);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1426e) {
            this.f1425d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1427f != null) {
            Context context = this.f1423b;
            if (context == null) {
                context = getContext();
            }
            this.f1427f.o(new e(spinnerAdapter, context.getTheme()));
        }
    }

    public A(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(context, attributeSet, i2, i3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public A(android.content.Context r6, android.util.AttributeSet r7, int r8, int r9, android.content.res.Resources.Theme r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.A.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
