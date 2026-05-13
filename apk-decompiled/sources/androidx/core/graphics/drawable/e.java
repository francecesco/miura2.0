package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class e extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Method f2194h;

    e(Drawable drawable) {
        super(drawable);
        g();
    }

    private void g() {
        if (f2194h == null) {
            try {
                f2194h = Drawable.class.getDeclaredMethod("isProjected", null);
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.core.graphics.drawable.d
    protected boolean c() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f2193f;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.f2193f.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f2193f.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f2193f;
        if (drawable == null || (method = f2194h) == null) {
            return false;
        }
        try {
            return ((Boolean) method.invoke(drawable, null)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        this.f2193f.setHotspot(f2, f3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        this.f2193f.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // androidx.core.graphics.drawable.d, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // androidx.core.graphics.drawable.d, android.graphics.drawable.Drawable
    public void setTint(int i2) {
        if (c()) {
            super.setTint(i2);
        } else {
            this.f2193f.setTint(i2);
        }
    }

    @Override // androidx.core.graphics.drawable.d, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            this.f2193f.setTintList(colorStateList);
        }
    }

    @Override // androidx.core.graphics.drawable.d, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (c()) {
            super.setTintMode(mode);
        } else {
            this.f2193f.setTintMode(mode);
        }
    }

    e(f fVar, Resources resources) {
        super(fVar, resources);
        g();
    }
}
