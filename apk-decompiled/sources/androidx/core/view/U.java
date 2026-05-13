package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference f2306a;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ V f2307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f2308b;

        a(V v2, View view) {
            this.f2307a = v2;
            this.f2308b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2307a.c(this.f2308b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2307a.a(this.f2308b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f2307a.b(this.f2308b);
        }
    }

    U(View view) {
        this.f2306a = new WeakReference(view);
    }

    private void i(View view, V v2) {
        if (v2 != null) {
            view.animate().setListener(new a(v2, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public U b(float f2) {
        View view = (View) this.f2306a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public void c() {
        View view = (View) this.f2306a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = (View) this.f2306a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public U f(long j2) {
        View view = (View) this.f2306a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
        return this;
    }

    public U g(Interpolator interpolator) {
        View view = (View) this.f2306a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public U h(V v2) {
        View view = (View) this.f2306a.get();
        if (view != null) {
            i(view, v2);
        }
        return this;
    }

    public U j(long j2) {
        View view = (View) this.f2306a.get();
        if (view != null) {
            view.animate().setStartDelay(j2);
        }
        return this;
    }

    public U k(final X x2) {
        final View view = (View) this.f2306a.get();
        if (view != null) {
            view.animate().setUpdateListener(x2 != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.T
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    x2.a(view);
                }
            } : null);
        }
        return this;
    }

    public void l() {
        View view = (View) this.f2306a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public U m(float f2) {
        View view = (View) this.f2306a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }
}
