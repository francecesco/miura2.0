package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.content.res.k;
import java.io.IOException;
import java.util.ArrayList;
import k.C0207a;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class b extends f implements Animatable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C0055b f3233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f3234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArgbEvaluator f3235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Animator.AnimatorListener f3236e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ArrayList f3237f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Drawable.Callback f3238g;

    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            b.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            b.this.scheduleSelf(runnable, j2);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            b.this.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: renamed from: androidx.vectordrawable.graphics.drawable.b$b, reason: collision with other inner class name */
    private static class C0055b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        g f3241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        AnimatorSet f3242c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ArrayList f3243d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        C0207a f3244e;

        public C0055b(Context context, C0055b c0055b, Drawable.Callback callback, Resources resources) {
            if (c0055b != null) {
                this.f3240a = c0055b.f3240a;
                g gVar = c0055b.f3241b;
                if (gVar != null) {
                    Drawable.ConstantState constantState = gVar.getConstantState();
                    this.f3241b = (g) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    g gVar2 = (g) this.f3241b.mutate();
                    this.f3241b = gVar2;
                    gVar2.setCallback(callback);
                    this.f3241b.setBounds(c0055b.f3241b.getBounds());
                    this.f3241b.h(false);
                }
                ArrayList arrayList = c0055b.f3243d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f3243d = new ArrayList(size);
                    this.f3244e = new C0207a(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        Animator animator = (Animator) c0055b.f3243d.get(i2);
                        Animator animatorClone = animator.clone();
                        String str = (String) c0055b.f3244e.get(animator);
                        animatorClone.setTarget(this.f3241b.d(str));
                        this.f3243d.add(animatorClone);
                        this.f3244e.put(animatorClone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f3242c == null) {
                this.f3242c = new AnimatorSet();
            }
            this.f3242c.playTogether(this.f3243d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f3240a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    private static class c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f3245a;

        public c(Drawable.ConstantState constantState) {
            this.f3245a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f3245a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f3245a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            b bVar = new b();
            Drawable drawableNewDrawable = this.f3245a.newDrawable();
            bVar.f3248a = drawableNewDrawable;
            drawableNewDrawable.setCallback(bVar.f3238g);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            b bVar = new b();
            Drawable drawableNewDrawable = this.f3245a.newDrawable(resources);
            bVar.f3248a = drawableNewDrawable;
            drawableNewDrawable.setCallback(bVar.f3238g);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            b bVar = new b();
            Drawable drawableNewDrawable = this.f3245a.newDrawable(resources, theme);
            bVar.f3248a = drawableNewDrawable;
            drawableNewDrawable.setCallback(bVar.f3238g);
            return bVar;
        }
    }

    b() {
        this(null, null, null);
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        b bVar = new b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    private void b(String str, Animator animator) {
        animator.setTarget(this.f3233b.f3241b.d(str));
        C0055b c0055b = this.f3233b;
        if (c0055b.f3243d == null) {
            c0055b.f3243d = new ArrayList();
            this.f3233b.f3244e = new C0207a();
        }
        this.f3233b.f3243d.add(animator);
        this.f3233b.f3244e.put(animator, str);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.b(drawable);
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f3233b.f3241b.draw(canvas);
        if (this.f3233b.f3242c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f3248a;
        return drawable != null ? androidx.core.graphics.drawable.a.c(drawable) : this.f3233b.f3241b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f3248a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f3233b.f3240a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f3248a;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.f3233b.f3241b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f3248a == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new c(this.f3248a.getConstantState());
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f3248a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f3233b.f3241b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f3248a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f3233b.f3241b.getIntrinsicWidth();
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f3248a;
        return drawable != null ? drawable.getOpacity() : this.f3233b.f3241b.getOpacity();
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f3248a;
        return drawable != null ? androidx.core.graphics.drawable.a.g(drawable) : this.f3233b.f3241b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f3248a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f3233b.f3242c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f3248a;
        return drawable != null ? drawable.isStateful() : this.f3233b.f3241b.isStateful();
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f3233b.f3241b.setBounds(rect);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        Drawable drawable = this.f3248a;
        return drawable != null ? drawable.setLevel(i2) : this.f3233b.f3241b.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f3248a;
        return drawable != null ? drawable.setState(iArr) : this.f3233b.f3241b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else {
            this.f3233b.f3241b.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.i(drawable, z2);
        } else {
            this.f3233b.f3241b.setAutoMirrored(z2);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z2) {
        super.setFilterBitmap(z2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i2) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.m(drawable, i2);
        } else {
            this.f3233b.f3241b.setTint(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, colorStateList);
        } else {
            this.f3233b.f3241b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, mode);
        } else {
            this.f3233b.f3241b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            return drawable.setVisible(z2, z3);
        }
        this.f3233b.f3241b.setVisible(z2, z3);
        return super.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f3233b.f3242c.isStarted()) {
                return;
            }
            this.f3233b.f3242c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f3233b.f3242c.end();
        }
    }

    private b(Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes;
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.f(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    typedArrayObtainAttributes = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f3225e);
                    int resourceId = typedArrayObtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        g gVarB = g.b(resources, resourceId, theme);
                        gVarB.h(false);
                        gVarB.setCallback(this.f3238g);
                        g gVar = this.f3233b.f3241b;
                        if (gVar != null) {
                            gVar.setCallback(null);
                        }
                        this.f3233b.f3241b = gVarB;
                    }
                } else if ("target".equals(name)) {
                    typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, androidx.vectordrawable.graphics.drawable.a.f3226f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f3234c;
                        if (context == null) {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        b(string, d.i(context, resourceId2));
                    }
                } else {
                    continue;
                }
                typedArrayObtainAttributes.recycle();
            }
            eventType = xmlPullParser.next();
        }
        this.f3233b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f3233b.f3241b.setColorFilter(colorFilter);
        }
    }

    private b(Context context, C0055b c0055b, Resources resources) {
        this.f3235d = null;
        this.f3236e = null;
        this.f3237f = null;
        a aVar = new a();
        this.f3238g = aVar;
        this.f3234c = context;
        if (c0055b != null) {
            this.f3233b = c0055b;
        } else {
            this.f3233b = new C0055b(context, c0055b, aVar, resources);
        }
    }
}
