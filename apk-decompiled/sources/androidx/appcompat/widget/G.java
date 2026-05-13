package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import it.tervis.miura.model.Peripheral;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class G {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final RectF f1578l = new RectF();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static ConcurrentHashMap f1579m = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1580a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1581b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f1582c = -1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f1583d = -1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f1584e = -1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f1585f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1586g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextPaint f1587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final TextView f1588i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Context f1589j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final d f1590k;

    private static final class a {
        static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3, TextView textView, TextPaint textPaint, d dVar) {
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i2);
            StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i3 == -1) {
                i3 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i3);
            try {
                dVar.a(builderObtain, textView);
            } catch (ClassCastException unused) {
            }
            return builderObtain.build();
        }
    }

    private static class b extends d {
        b() {
        }

        @Override // androidx.appcompat.widget.G.d
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) G.m(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    private static class c extends b {
        c() {
        }

        @Override // androidx.appcompat.widget.G.b, androidx.appcompat.widget.G.d
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.G.d
        boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    private static class d {
        d() {
        }

        void a(StaticLayout.Builder builder, TextView textView) {
        }

        boolean b(TextView textView) {
            return ((Boolean) G.m(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    G(TextView textView) {
        this.f1588i = textView;
        this.f1589j = textView.getContext();
        int i2 = Build.VERSION.SDK_INT;
        this.f1590k = i2 >= 29 ? new c() : i2 >= 23 ? new b() : new d();
    }

    private int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr2;
    }

    private void c() {
        this.f1580a = 0;
        this.f1583d = -1.0f;
        this.f1584e = -1.0f;
        this.f1582c = -1.0f;
        this.f1585f = new int[0];
        this.f1581b = false;
    }

    private int e(RectF rectF) {
        int length = this.f1585f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i2 = 1;
        int i3 = length - 1;
        int i4 = 0;
        while (i2 <= i3) {
            int i5 = (i2 + i3) / 2;
            if (x(this.f1585f[i5], rectF)) {
                int i6 = i5 + 1;
                i4 = i2;
                i2 = i6;
            } else {
                i4 = i5 - 1;
                i3 = i4;
            }
        }
        return this.f1585f[i4];
    }

    private static Method k(String str) {
        try {
            Method declaredMethod = (Method) f1579m.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, null)) != null) {
                declaredMethod.setAccessible(true);
                f1579m.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve TextView#");
            sb.append(str);
            sb.append("() method");
            return null;
        }
    }

    static Object m(Object obj, String str, Object obj2) {
        try {
            return k(str).invoke(obj, null);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to invoke TextView#");
            sb.append(str);
            sb.append("() method");
            return obj2;
        }
    }

    private void s(float f2) {
        if (f2 != this.f1588i.getPaint().getTextSize()) {
            this.f1588i.getPaint().setTextSize(f2);
            boolean zIsInLayout = this.f1588i.isInLayout();
            if (this.f1588i.getLayout() != null) {
                this.f1581b = false;
                try {
                    Method methodK = k("nullLayouts");
                    if (methodK != null) {
                        methodK.invoke(this.f1588i, null);
                    }
                } catch (Exception unused) {
                }
                if (zIsInLayout) {
                    this.f1588i.forceLayout();
                } else {
                    this.f1588i.requestLayout();
                }
                this.f1588i.invalidate();
            }
        }
    }

    private boolean u() {
        if (y() && this.f1580a == 1) {
            if (!this.f1586g || this.f1585f.length == 0) {
                int iFloor = ((int) Math.floor((this.f1584e - this.f1583d) / this.f1582c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i2 = 0; i2 < iFloor; i2++) {
                    iArr[i2] = Math.round(this.f1583d + (i2 * this.f1582c));
                }
                this.f1585f = b(iArr);
            }
            this.f1581b = true;
        } else {
            this.f1581b = false;
        }
        return this.f1581b;
    }

    private void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = typedArray.getDimensionPixelSize(i2, -1);
            }
            this.f1585f = b(iArr);
            w();
        }
    }

    private boolean w() {
        boolean z2 = this.f1585f.length > 0;
        this.f1586g = z2;
        if (z2) {
            this.f1580a = 1;
            this.f1583d = r0[0];
            this.f1584e = r0[r1 - 1];
            this.f1582c = -1.0f;
        }
        return z2;
    }

    private boolean x(int i2, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1588i.getText();
        TransformationMethod transformationMethod = this.f1588i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f1588i)) != null) {
            text = transformation;
        }
        int maxLines = this.f1588i.getMaxLines();
        l(i2);
        StaticLayout staticLayoutD = d(text, (Layout.Alignment) m(this.f1588i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (staticLayoutD.getLineCount() <= maxLines && staticLayoutD.getLineEnd(staticLayoutD.getLineCount() - 1) == text.length())) && ((float) staticLayoutD.getHeight()) <= rectF.bottom;
    }

    private boolean y() {
        return !(this.f1588i instanceof C0123l);
    }

    private void z(float f2, float f3, float f4) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        }
        if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        }
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
        }
        this.f1580a = 1;
        this.f1583d = f2;
        this.f1584e = f3;
        this.f1582c = f4;
        this.f1586g = false;
    }

    void a() {
        if (n()) {
            if (this.f1581b) {
                if (this.f1588i.getMeasuredHeight() <= 0 || this.f1588i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f1590k.b(this.f1588i) ? Peripheral.EXPANSION_12 : (this.f1588i.getMeasuredWidth() - this.f1588i.getTotalPaddingLeft()) - this.f1588i.getTotalPaddingRight();
                int height = (this.f1588i.getHeight() - this.f1588i.getCompoundPaddingBottom()) - this.f1588i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f1578l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float fE = e(rectF);
                        if (fE != this.f1588i.getTextSize()) {
                            t(0, fE);
                        }
                    } finally {
                    }
                }
            }
            this.f1581b = true;
        }
    }

    StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.a(charSequence, alignment, i2, i3, this.f1588i, this.f1587h, this.f1590k);
        }
        return new StaticLayout(charSequence, this.f1587h, i2, alignment, this.f1588i.getLineSpacingMultiplier(), this.f1588i.getLineSpacingExtra(), this.f1588i.getIncludeFontPadding());
    }

    int f() {
        return Math.round(this.f1584e);
    }

    int g() {
        return Math.round(this.f1583d);
    }

    int h() {
        return Math.round(this.f1582c);
    }

    int[] i() {
        return this.f1585f;
    }

    int j() {
        return this.f1580a;
    }

    void l(int i2) {
        TextPaint textPaint = this.f1587h;
        if (textPaint == null) {
            this.f1587h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f1587h.set(this.f1588i.getPaint());
        this.f1587h.setTextSize(i2);
    }

    boolean n() {
        return y() && this.f1580a != 0;
    }

    void o(AttributeSet attributeSet, int i2) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.f1589j.obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i2, 0);
        TextView textView = this.f1588i;
        androidx.core.view.L.S(textView, textView.getContext(), R$styleable.AppCompatTextView, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeTextType)) {
            this.f1580a = typedArrayObtainStyledAttributes.getInt(R$styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeStepGranularity) ? typedArrayObtainStyledAttributes.getDimension(R$styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeMinTextSize) ? typedArrayObtainStyledAttributes.getDimension(R$styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeMaxTextSize) ? typedArrayObtainStyledAttributes.getDimension(R$styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizePresetSizes) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!y()) {
            this.f1580a = 0;
            return;
        }
        if (this.f1580a == 1) {
            if (!this.f1586g) {
                DisplayMetrics displayMetrics = this.f1589j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                z(dimension2, dimension3, dimension);
            }
            u();
        }
    }

    void p(int i2, int i3, int i4, int i5) {
        if (y()) {
            DisplayMetrics displayMetrics = this.f1589j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i5, i2, displayMetrics), TypedValue.applyDimension(i5, i3, displayMetrics), TypedValue.applyDimension(i5, i4, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    void q(int[] iArr, int i2) {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i2 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1589j.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArrCopyOf[i3] = Math.round(TypedValue.applyDimension(i2, iArr[i3], displayMetrics));
                    }
                }
                this.f1585f = b(iArrCopyOf);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1586g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    void r(int i2) {
        if (y()) {
            if (i2 == 0) {
                c();
                return;
            }
            if (i2 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i2);
            }
            DisplayMetrics displayMetrics = this.f1589j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (u()) {
                a();
            }
        }
    }

    void t(int i2, float f2) {
        Context context = this.f1589j;
        s(TypedValue.applyDimension(i2, f2, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }
}
