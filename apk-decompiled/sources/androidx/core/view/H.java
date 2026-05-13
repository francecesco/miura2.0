package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class H implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f2272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewTreeObserver f2273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f2274c;

    private H(View view, Runnable runnable) {
        this.f2272a = view;
        this.f2273b = view.getViewTreeObserver();
        this.f2274c = runnable;
    }

    public static H a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        H h2 = new H(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(h2);
        view.addOnAttachStateChangeListener(h2);
        return h2;
    }

    public void b() {
        (this.f2273b.isAlive() ? this.f2273b : this.f2272a.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f2272a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f2274c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f2273b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
