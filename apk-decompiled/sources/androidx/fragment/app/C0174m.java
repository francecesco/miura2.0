package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.Y;
import androidx.fragment.R$styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: androidx.fragment.app.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0174m extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f2935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f2936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View.OnApplyWindowInsetsListener f2937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2938d;

    /* JADX INFO: renamed from: androidx.fragment.app.m$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2939a = new a();

        private a() {
        }

        public final WindowInsets a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View view, WindowInsets windowInsets) {
            q0.f.e(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            q0.f.e(view, "v");
            q0.f.e(windowInsets, "insets");
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            q0.f.d(windowInsetsOnApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return windowInsetsOnApplyWindowInsets;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0174m(Context context, AttributeSet attributeSet, x xVar) {
        String str;
        super(context, attributeSet);
        q0.f.e(context, "context");
        q0.f.e(attributeSet, "attrs");
        q0.f.e(xVar, "fm");
        this.f2935a = new ArrayList();
        this.f2936b = new ArrayList();
        this.f2938d = true;
        String classAttribute = attributeSet.getClassAttribute();
        int[] iArr = R$styleable.FragmentContainerView;
        q0.f.d(iArr, "FragmentContainerView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(R$styleable.FragmentContainerView_android_name) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(R$styleable.FragmentContainerView_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        Fragment fragmentG0 = xVar.g0(id);
        if (classAttribute != null && fragmentG0 == null) {
            if (id == -1) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment fragmentA = xVar.s0().a(context.getClassLoader(), classAttribute);
            q0.f.d(fragmentA, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            fragmentA.y0(context, attributeSet, null);
            xVar.o().q(true).d(this, fragmentA, string).j();
        }
        xVar.X0(this);
    }

    private final void a(View view) {
        if (this.f2936b.contains(view)) {
            this.f2935a.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        q0.f.e(view, "child");
        if (x.B0(view) != null) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        Y yL;
        q0.f.e(windowInsets, "insets");
        Y yU = Y.u(windowInsets);
        q0.f.d(yU, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f2937c;
        if (onApplyWindowInsetsListener != null) {
            a aVar = a.f2939a;
            q0.f.b(onApplyWindowInsetsListener);
            yL = Y.u(aVar.a(onApplyWindowInsetsListener, this, windowInsets));
        } else {
            yL = androidx.core.view.L.L(this, yU);
        }
        q0.f.d(yL, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!yL.n()) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                androidx.core.view.L.g(getChildAt(i2), yL);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        q0.f.e(canvas, "canvas");
        if (this.f2938d) {
            Iterator it2 = this.f2935a.iterator();
            while (it2.hasNext()) {
                super.drawChild(canvas, (View) it2.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        q0.f.e(canvas, "canvas");
        q0.f.e(view, "child");
        if (this.f2938d && (!this.f2935a.isEmpty()) && this.f2935a.contains(view)) {
            return false;
        }
        return super.drawChild(canvas, view, j2);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        q0.f.e(view, "view");
        this.f2936b.remove(view);
        if (this.f2935a.remove(view)) {
            this.f2938d = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        return (F) x.j0(this).g0(getId());
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        q0.f.e(windowInsets, "insets");
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View childAt = getChildAt(childCount);
                q0.f.d(childAt, "view");
                a(childAt);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        q0.f.e(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i2) {
        View childAt = getChildAt(i2);
        q0.f.d(childAt, "view");
        a(childAt);
        super.removeViewAt(i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        q0.f.e(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i2, int i3) {
        int i4 = i2 + i3;
        for (int i5 = i2; i5 < i4; i5++) {
            View childAt = getChildAt(i5);
            q0.f.d(childAt, "view");
            a(childAt);
        }
        super.removeViews(i2, i3);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i2, int i3) {
        int i4 = i2 + i3;
        for (int i5 = i2; i5 < i4; i5++) {
            View childAt = getChildAt(i5);
            q0.f.d(childAt, "view");
            a(childAt);
        }
        super.removeViewsInLayout(i2, i3);
    }

    public final void setDrawDisappearingViewsLast(boolean z2) {
        this.f2938d = z2;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        q0.f.e(onApplyWindowInsetsListener, "listener");
        this.f2937c = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        q0.f.e(view, "view");
        if (view.getParent() == this) {
            this.f2936b.add(view);
        }
        super.startViewTransition(view);
    }
}
