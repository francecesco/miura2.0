package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
abstract class d extends Drawable implements Drawable.Callback, c, b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final PorterDuff.Mode f2187g = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PorterDuff.Mode f2189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    f f2191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f2192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Drawable f2193f;

    d(Drawable drawable) {
        this.f2191d = d();
        b(drawable);
    }

    private f d() {
        return new f(this.f2191d);
    }

    private void e(Resources resources) {
        Drawable.ConstantState constantState;
        f fVar = this.f2191d;
        if (fVar == null || (constantState = fVar.f2196b) == null) {
            return;
        }
        b(constantState.newDrawable(resources));
    }

    private boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        f fVar = this.f2191d;
        ColorStateList colorStateList = fVar.f2197c;
        PorterDuff.Mode mode = fVar.f2198d;
        if (colorStateList == null || mode == null) {
            this.f2190c = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f2190c || colorForState != this.f2188a || mode != this.f2189b) {
                setColorFilter(colorForState, mode);
                this.f2188a = colorForState;
                this.f2189b = mode;
                this.f2190c = true;
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.c
    public final Drawable a() {
        return this.f2193f;
    }

    @Override // androidx.core.graphics.drawable.c
    public final void b(Drawable drawable) {
        Drawable drawable2 = this.f2193f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2193f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            f fVar = this.f2191d;
            if (fVar != null) {
                fVar.f2196b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    protected abstract boolean c();

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f2193f.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        f fVar = this.f2191d;
        return changingConfigurations | (fVar != null ? fVar.getChangingConfigurations() : 0) | this.f2193f.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        f fVar = this.f2191d;
        if (fVar == null || !fVar.a()) {
            return null;
        }
        this.f2191d.f2195a = getChangingConfigurations();
        return this.f2191d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f2193f.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f2193f.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f2193f.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return a.e(this.f2193f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f2193f.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f2193f.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f2193f.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f2193f.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f2193f.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f2193f.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return a.g(this.f2193f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        f fVar;
        ColorStateList colorStateList = (!c() || (fVar = this.f2191d) == null) ? null : fVar.f2197c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f2193f.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f2193f.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f2192e && super.mutate() == this) {
            this.f2191d = d();
            Drawable drawable = this.f2193f;
            if (drawable != null) {
                drawable.mutate();
            }
            f fVar = this.f2191d;
            if (fVar != null) {
                Drawable drawable2 = this.f2193f;
                fVar.f2196b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f2192e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2193f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        return a.l(this.f2193f, i2);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        return this.f2193f.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f2193f.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        a.i(this.f2193f, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i2) {
        this.f2193f.setChangingConfigurations(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2193f.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        this.f2193f.setDither(z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.f2193f.setFilterBitmap(z2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return f(iArr) || this.f2193f.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f2191d.f2197c = colorStateList;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f2191d.f2198d = mode;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        return super.setVisible(z2, z3) || this.f2193f.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    d(f fVar, Resources resources) {
        this.f2191d = fVar;
        e(resources);
    }
}
