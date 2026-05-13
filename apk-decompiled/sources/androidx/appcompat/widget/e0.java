package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.res.h;
import e.AbstractC0190a;

/* JADX INFO: loaded from: classes.dex */
public class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypedArray f1844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TypedValue f1845c;

    private e0(Context context, TypedArray typedArray) {
        this.f1843a = context;
        this.f1844b = typedArray;
    }

    public static e0 s(Context context, int i2, int[] iArr) {
        return new e0(context, context.obtainStyledAttributes(i2, iArr));
    }

    public static e0 t(Context context, AttributeSet attributeSet, int[] iArr) {
        return new e0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static e0 u(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3) {
        return new e0(context, context.obtainStyledAttributes(attributeSet, iArr, i2, i3));
    }

    public boolean a(int i2, boolean z2) {
        return this.f1844b.getBoolean(i2, z2);
    }

    public int b(int i2, int i3) {
        return this.f1844b.getColor(i2, i3);
    }

    public ColorStateList c(int i2) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.f1844b.hasValue(i2) || (resourceId = this.f1844b.getResourceId(i2, 0)) == 0 || (colorStateListA = AbstractC0190a.a(this.f1843a, resourceId)) == null) ? this.f1844b.getColorStateList(i2) : colorStateListA;
    }

    public int d(int i2, int i3) {
        return this.f1844b.getDimensionPixelOffset(i2, i3);
    }

    public int e(int i2, int i3) {
        return this.f1844b.getDimensionPixelSize(i2, i3);
    }

    public Drawable f(int i2) {
        int resourceId;
        return (!this.f1844b.hasValue(i2) || (resourceId = this.f1844b.getResourceId(i2, 0)) == 0) ? this.f1844b.getDrawable(i2) : AbstractC0190a.b(this.f1843a, resourceId);
    }

    public Drawable g(int i2) {
        int resourceId;
        if (!this.f1844b.hasValue(i2) || (resourceId = this.f1844b.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return C0122k.b().d(this.f1843a, resourceId, true);
    }

    public float h(int i2, float f2) {
        return this.f1844b.getFloat(i2, f2);
    }

    public Typeface i(int i2, int i3, h.e eVar) {
        int resourceId = this.f1844b.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1845c == null) {
            this.f1845c = new TypedValue();
        }
        return androidx.core.content.res.h.f(this.f1843a, resourceId, this.f1845c, i3, eVar);
    }

    public int j(int i2, int i3) {
        return this.f1844b.getInt(i2, i3);
    }

    public int k(int i2, int i3) {
        return this.f1844b.getInteger(i2, i3);
    }

    public int l(int i2, int i3) {
        return this.f1844b.getLayoutDimension(i2, i3);
    }

    public int m(int i2, int i3) {
        return this.f1844b.getResourceId(i2, i3);
    }

    public String n(int i2) {
        return this.f1844b.getString(i2);
    }

    public CharSequence o(int i2) {
        return this.f1844b.getText(i2);
    }

    public CharSequence[] p(int i2) {
        return this.f1844b.getTextArray(i2);
    }

    public TypedArray q() {
        return this.f1844b;
    }

    public boolean r(int i2) {
        return this.f1844b.hasValue(i2);
    }

    public TypedValue v(int i2) {
        return this.f1844b.peekValue(i2);
    }

    public void w() {
        this.f1844b.recycle();
    }
}
