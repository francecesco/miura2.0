package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
final class f extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f2195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Drawable.ConstantState f2196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ColorStateList f2197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    PorterDuff.Mode f2198d;

    f(f fVar) {
        this.f2197c = null;
        this.f2198d = d.f2187g;
        if (fVar != null) {
            this.f2195a = fVar.f2195a;
            this.f2196b = fVar.f2196b;
            this.f2197c = fVar.f2197c;
            this.f2198d = fVar.f2198d;
        }
    }

    boolean a() {
        return this.f2196b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i2 = this.f2195a;
        Drawable.ConstantState constantState = this.f2196b;
        return i2 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return new e(this, resources);
    }
}
