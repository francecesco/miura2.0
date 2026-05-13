package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.widget.i;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@ViewPager.e
public class PagerTitleStrip extends ViewGroup {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int[] f3330o = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int[] f3331p = {R.attr.textAllCaps};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ViewPager f3332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    TextView f3333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    TextView f3334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    TextView f3335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f3337f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3338g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3339h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3340i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3341j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final a f3342k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private WeakReference f3343l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f3344m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f3345n;

    private class a extends DataSetObserver implements ViewPager.j, ViewPager.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f3346a;

        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void a(int i2, float f2, int i3) {
            if (f2 > 0.5f) {
                i2++;
            }
            PagerTitleStrip.this.d(i2, f2, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void b(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            PagerTitleStrip.this.b(aVar, aVar2);
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void c(int i2) {
            this.f3346a = i2;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void d(int i2) {
            if (this.f3346a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.c(pagerTitleStrip.f3332a.getCurrentItem(), PagerTitleStrip.this.f3332a.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f2 = pagerTitleStrip2.f3337f;
                if (f2 < 0.0f) {
                    f2 = 0.0f;
                }
                pagerTitleStrip2.d(pagerTitleStrip2.f3332a.getCurrentItem(), f2, true);
            }
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.c(pagerTitleStrip.f3332a.getCurrentItem(), PagerTitleStrip.this.f3332a.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f2 = pagerTitleStrip2.f3337f;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            pagerTitleStrip2.d(pagerTitleStrip2.f3332a.getCurrentItem(), f2, true);
        }
    }

    private static class b extends SingleLineTransformationMethod {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Locale f3348a;

        b(Context context) {
            this.f3348a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f3348a);
            }
            return null;
        }
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3336e = -1;
        this.f3337f = -1.0f;
        this.f3342k = new a();
        TextView textView = new TextView(context);
        this.f3333b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f3334c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f3335d = textView3;
        addView(textView3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3330o);
        boolean z2 = false;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            i.m(this.f3333b, resourceId);
            i.m(this.f3334c, resourceId);
            i.m(this.f3335d, resourceId);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            a(0, dimensionPixelSize);
        }
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            int color = typedArrayObtainStyledAttributes.getColor(2, 0);
            this.f3333b.setTextColor(color);
            this.f3334c.setTextColor(color);
            this.f3335d.setTextColor(color);
        }
        this.f3339h = typedArrayObtainStyledAttributes.getInteger(3, 80);
        typedArrayObtainStyledAttributes.recycle();
        this.f3345n = this.f3334c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        TextView textView4 = this.f3333b;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView4.setEllipsize(truncateAt);
        this.f3334c.setEllipsize(truncateAt);
        this.f3335d.setEllipsize(truncateAt);
        if (resourceId != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f3331p);
            z2 = typedArrayObtainStyledAttributes2.getBoolean(0, false);
            typedArrayObtainStyledAttributes2.recycle();
        }
        TextView textView5 = this.f3333b;
        if (z2) {
            setSingleLineAllCaps(textView5);
            setSingleLineAllCaps(this.f3334c);
            setSingleLineAllCaps(this.f3335d);
        } else {
            textView5.setSingleLine();
            this.f3334c.setSingleLine();
            this.f3335d.setSingleLine();
        }
        this.f3338g = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    public void a(int i2, float f2) {
        this.f3333b.setTextSize(i2, f2);
        this.f3334c.setTextSize(i2, f2);
        this.f3335d.setTextSize(i2, f2);
    }

    void b(androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
        if (aVar != null) {
            aVar.o(this.f3342k);
            this.f3343l = null;
        }
        if (aVar2 != null) {
            aVar2.i(this.f3342k);
            this.f3343l = new WeakReference(aVar2);
        }
        ViewPager viewPager = this.f3332a;
        if (viewPager != null) {
            this.f3336e = -1;
            this.f3337f = -1.0f;
            c(viewPager.getCurrentItem(), aVar2);
            requestLayout();
        }
    }

    void c(int i2, androidx.viewpager.widget.a aVar) {
        int iC = aVar != null ? aVar.c() : 0;
        this.f3340i = true;
        CharSequence charSequenceE = null;
        this.f3333b.setText((i2 < 1 || aVar == null) ? null : aVar.e(i2 - 1));
        this.f3334c.setText((aVar == null || i2 >= iC) ? null : aVar.e(i2));
        int i3 = i2 + 1;
        if (i3 < iC && aVar != null) {
            charSequenceE = aVar.e(i3);
        }
        this.f3335d.setText(charSequenceE);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f3333b.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f3334c.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f3335d.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f3336e = i2;
        if (!this.f3341j) {
            d(i2, this.f3337f, false);
        }
        this.f3340i = false;
    }

    void d(int i2, float f2, boolean z2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (i2 != this.f3336e) {
            c(i2, this.f3332a.getAdapter());
        } else if (!z2 && f2 == this.f3337f) {
            return;
        }
        this.f3341j = true;
        int measuredWidth = this.f3333b.getMeasuredWidth();
        int measuredWidth2 = this.f3334c.getMeasuredWidth();
        int measuredWidth3 = this.f3335d.getMeasuredWidth();
        int i7 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = paddingRight + i7;
        int i9 = (width - (paddingLeft + i7)) - i8;
        float f3 = 0.5f + f2;
        if (f3 > 1.0f) {
            f3 -= 1.0f;
        }
        int i10 = ((width - i8) - ((int) (i9 * f3))) - i7;
        int i11 = measuredWidth2 + i10;
        int baseline = this.f3333b.getBaseline();
        int baseline2 = this.f3334c.getBaseline();
        int baseline3 = this.f3335d.getBaseline();
        int iMax = Math.max(Math.max(baseline, baseline2), baseline3);
        int i12 = iMax - baseline;
        int i13 = iMax - baseline2;
        int i14 = iMax - baseline3;
        int iMax2 = Math.max(Math.max(this.f3333b.getMeasuredHeight() + i12, this.f3334c.getMeasuredHeight() + i13), this.f3335d.getMeasuredHeight() + i14);
        int i15 = this.f3339h & 112;
        if (i15 == 16) {
            i3 = (((height - paddingTop) - paddingBottom) - iMax2) / 2;
        } else {
            if (i15 != 80) {
                i4 = i12 + paddingTop;
                i5 = i13 + paddingTop;
                i6 = paddingTop + i14;
                TextView textView = this.f3334c;
                textView.layout(i10, i5, i11, textView.getMeasuredHeight() + i5);
                int iMin = Math.min(paddingLeft, (i10 - this.f3338g) - measuredWidth);
                TextView textView2 = this.f3333b;
                textView2.layout(iMin, i4, measuredWidth + iMin, textView2.getMeasuredHeight() + i4);
                int iMax3 = Math.max((width - paddingRight) - measuredWidth3, i11 + this.f3338g);
                TextView textView3 = this.f3335d;
                textView3.layout(iMax3, i6, iMax3 + measuredWidth3, textView3.getMeasuredHeight() + i6);
                this.f3337f = f2;
                this.f3341j = false;
            }
            i3 = (height - paddingBottom) - iMax2;
        }
        i4 = i12 + i3;
        i5 = i13 + i3;
        i6 = i3 + i14;
        TextView textView4 = this.f3334c;
        textView4.layout(i10, i5, i11, textView4.getMeasuredHeight() + i5);
        int iMin2 = Math.min(paddingLeft, (i10 - this.f3338g) - measuredWidth);
        TextView textView22 = this.f3333b;
        textView22.layout(iMin2, i4, measuredWidth + iMin2, textView22.getMeasuredHeight() + i4);
        int iMax32 = Math.max((width - paddingRight) - measuredWidth3, i11 + this.f3338g);
        TextView textView32 = this.f3335d;
        textView32.layout(iMax32, i6, iMax32 + measuredWidth3, textView32.getMeasuredHeight() + i6);
        this.f3337f = f2;
        this.f3341j = false;
    }

    int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f3338g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        androidx.viewpager.widget.a adapter = viewPager.getAdapter();
        viewPager.N(this.f3342k);
        viewPager.b(this.f3342k);
        this.f3332a = viewPager;
        WeakReference weakReference = this.f3343l;
        b(weakReference != null ? (androidx.viewpager.widget.a) weakReference.get() : null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f3332a;
        if (viewPager != null) {
            b(viewPager.getAdapter(), null);
            this.f3332a.N(null);
            this.f3332a.G(this.f3342k);
            this.f3332a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        if (this.f3332a != null) {
            float f2 = this.f3337f;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            d(this.f3336e, f2, true);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int iMax;
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingTop, -2);
        int size = View.MeasureSpec.getSize(i2);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, (int) (size * 0.2f), -2);
        this.f3333b.measure(childMeasureSpec2, childMeasureSpec);
        this.f3334c.measure(childMeasureSpec2, childMeasureSpec);
        this.f3335d.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i3) == 1073741824) {
            iMax = View.MeasureSpec.getSize(i3);
        } else {
            iMax = Math.max(getMinHeight(), this.f3334c.getMeasuredHeight() + paddingTop);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(iMax, i3, this.f3334c.getMeasuredState() << 16));
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f3340i) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i2) {
        this.f3339h = i2;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f2) {
        int i2 = ((int) (f2 * 255.0f)) & 255;
        this.f3344m = i2;
        int i3 = (i2 << 24) | (this.f3345n & 16777215);
        this.f3333b.setTextColor(i3);
        this.f3335d.setTextColor(i3);
    }

    public void setTextColor(int i2) {
        this.f3345n = i2;
        this.f3334c.setTextColor(i2);
        int i3 = (this.f3344m << 24) | (this.f3345n & 16777215);
        this.f3333b.setTextColor(i3);
        this.f3335d.setTextColor(i3);
    }

    public void setTextSpacing(int i2) {
        this.f3338g = i2;
        requestLayout();
    }
}
