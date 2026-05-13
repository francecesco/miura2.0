package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.F;
import androidx.appcompat.widget.Q;
import androidx.appcompat.widget.j0;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends F implements k.a, View.OnClickListener, ActionMenuView.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    g f1223h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CharSequence f1224i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Drawable f1225j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    e.b f1226k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Q f1227l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    b f1228m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f1229n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f1230o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f1231p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f1232q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f1233r;

    private class a extends Q {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.Q
        public h.e b() {
            b bVar = ActionMenuItemView.this.f1228m;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.Q
        protected boolean c() {
            h.e eVarB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            e.b bVar = actionMenuItemView.f1226k;
            return bVar != null && bVar.a(actionMenuItemView.f1223h) && (eVarB = b()) != null && eVarB.b();
        }
    }

    public static abstract class b {
        public abstract h.e a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean t() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void u() {
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.f1224i);
        if (this.f1225j != null && (!this.f1223h.B() || (!this.f1229n && !this.f1230o))) {
            z2 = false;
        }
        boolean z4 = z3 & z2;
        setText(z4 ? this.f1224i : null);
        CharSequence contentDescription = this.f1223h.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            contentDescription = z4 ? null : this.f1223h.getTitle();
        }
        setContentDescription(contentDescription);
        CharSequence tooltipText = this.f1223h.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            j0.a(this, z4 ? null : this.f1223h.getTitle());
        } else {
            j0.a(this, tooltipText);
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return s();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return s() && this.f1223h.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean c() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void d(g gVar, int i2) {
        this.f1223h = gVar;
        setIcon(gVar.getIcon());
        setTitle(gVar.i(this));
        setId(gVar.getItemId());
        setVisibility(gVar.isVisible() ? 0 : 8);
        setEnabled(gVar.isEnabled());
        if (gVar.hasSubMenu() && this.f1227l == null) {
            this.f1227l = new a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.k.a
    public g getItemData() {
        return this.f1223h;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e.b bVar = this.f1226k;
        if (bVar != null) {
            bVar.a(this.f1223h);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1229n = t();
        u();
    }

    @Override // androidx.appcompat.widget.F, android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        boolean zS = s();
        if (zS && (i4 = this.f1232q) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f1231p) : this.f1231p;
        if (mode != 1073741824 && this.f1231p > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i3);
        }
        if (zS || this.f1225j == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f1225j.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Q q2;
        if (this.f1223h.hasSubMenu() && (q2 = this.f1227l) != null && q2.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean s() {
        return !TextUtils.isEmpty(getText());
    }

    public void setCheckable(boolean z2) {
    }

    public void setChecked(boolean z2) {
    }

    public void setExpandedFormat(boolean z2) {
        if (this.f1230o != z2) {
            this.f1230o = z2;
            g gVar = this.f1223h;
            if (gVar != null) {
                gVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1225j = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.f1233r;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (intrinsicHeight * (i2 / intrinsicWidth));
                intrinsicWidth = i2;
            }
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (intrinsicWidth * (i2 / intrinsicHeight));
            } else {
                i2 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i2);
        }
        setCompoundDrawables(drawable, null, null, null);
        u();
    }

    public void setItemInvoker(e.b bVar) {
        this.f1226k = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        this.f1232q = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public void setPopupCallback(b bVar) {
        this.f1228m = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1224i = charSequence;
        u();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources = context.getResources();
        this.f1229n = t();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionMenuItemView, i2, 0);
        this.f1231p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f1233r = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f1232q = -1;
        setSaveEnabled(false);
    }
}
