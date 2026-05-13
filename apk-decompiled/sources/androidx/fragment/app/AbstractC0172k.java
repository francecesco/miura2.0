package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import androidx.fragment.R$animator;

/* JADX INFO: renamed from: androidx.fragment.app.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0172k {

    /* JADX INFO: renamed from: androidx.fragment.app.k$a */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation f2928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Animator f2929b;

        a(Animator animator) {
            this.f2928a = null;
            this.f2929b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        a(Animation animation) {
            this.f2928a = animation;
            this.f2929b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.k$b */
    static class b extends AnimationSet implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewGroup f2930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f2931b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f2932c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2933d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f2934e;

        b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f2934e = true;
            this.f2930a = viewGroup;
            this.f2931b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j2, Transformation transformation) {
            this.f2934e = true;
            if (this.f2932c) {
                return !this.f2933d;
            }
            if (!super.getTransformation(j2, transformation)) {
                this.f2932c = true;
                androidx.core.view.H.a(this.f2930a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2932c || !this.f2934e) {
                this.f2930a.endViewTransition(this.f2931b);
                this.f2933d = true;
            } else {
                this.f2934e = false;
                this.f2930a.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j2, Transformation transformation, float f2) {
            this.f2934e = true;
            if (this.f2932c) {
                return !this.f2933d;
            }
            if (!super.getTransformation(j2, transformation, f2)) {
                this.f2932c = true;
                androidx.core.view.H.a(this.f2930a, this);
            }
            return true;
        }
    }

    private static int a(Fragment fragment, boolean z2, boolean z3) {
        return z3 ? z2 ? fragment.F() : fragment.H() : z2 ? fragment.p() : fragment.s();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0071 A[Catch: RuntimeException -> 0x0077, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0077, blocks: (B:32:0x006b, B:34:0x0071), top: B:45:0x006b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static androidx.fragment.app.AbstractC0172k.a b(android.content.Context r4, androidx.fragment.app.Fragment r5, boolean r6, boolean r7) {
        /*
            int r0 = r5.B()
            int r7 = a(r5, r6, r7)
            r1 = 0
            r5.s1(r1, r1, r1, r1)
            android.view.ViewGroup r1 = r5.f2666H
            r2 = 0
            if (r1 == 0) goto L20
            int r3 = androidx.fragment.R$id.visible_removing_fragment_view_tag
            java.lang.Object r1 = r1.getTag(r3)
            if (r1 == 0) goto L20
            android.view.ViewGroup r1 = r5.f2666H
            int r3 = androidx.fragment.R$id.visible_removing_fragment_view_tag
            r1.setTag(r3, r2)
        L20:
            android.view.ViewGroup r1 = r5.f2666H
            if (r1 == 0) goto L2b
            android.animation.LayoutTransition r1 = r1.getLayoutTransition()
            if (r1 == 0) goto L2b
            return r2
        L2b:
            android.view.animation.Animation r1 = r5.n0(r0, r6, r7)
            if (r1 == 0) goto L37
            androidx.fragment.app.k$a r4 = new androidx.fragment.app.k$a
            r4.<init>(r1)
            return r4
        L37:
            android.animation.Animator r5 = r5.o0(r0, r6, r7)
            if (r5 == 0) goto L43
            androidx.fragment.app.k$a r4 = new androidx.fragment.app.k$a
            r4.<init>(r5)
            return r4
        L43:
            if (r7 != 0) goto L4b
            if (r0 == 0) goto L4b
            int r7 = d(r4, r0, r6)
        L4b:
            if (r7 == 0) goto L87
            android.content.res.Resources r5 = r4.getResources()
            java.lang.String r5 = r5.getResourceTypeName(r7)
            java.lang.String r6 = "anim"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L6b
            android.view.animation.Animation r6 = android.view.animation.AnimationUtils.loadAnimation(r4, r7)     // Catch: android.content.res.Resources.NotFoundException -> L69 java.lang.RuntimeException -> L6b
            if (r6 == 0) goto L87
            androidx.fragment.app.k$a r0 = new androidx.fragment.app.k$a     // Catch: android.content.res.Resources.NotFoundException -> L69 java.lang.RuntimeException -> L6b
            r0.<init>(r6)     // Catch: android.content.res.Resources.NotFoundException -> L69 java.lang.RuntimeException -> L6b
            return r0
        L69:
            r4 = move-exception
            throw r4
        L6b:
            android.animation.Animator r6 = android.animation.AnimatorInflater.loadAnimator(r4, r7)     // Catch: java.lang.RuntimeException -> L77
            if (r6 == 0) goto L87
            androidx.fragment.app.k$a r0 = new androidx.fragment.app.k$a     // Catch: java.lang.RuntimeException -> L77
            r0.<init>(r6)     // Catch: java.lang.RuntimeException -> L77
            return r0
        L77:
            r6 = move-exception
            if (r5 != 0) goto L86
            android.view.animation.Animation r4 = android.view.animation.AnimationUtils.loadAnimation(r4, r7)
            if (r4 == 0) goto L87
            androidx.fragment.app.k$a r5 = new androidx.fragment.app.k$a
            r5.<init>(r4)
            return r5
        L86:
            throw r6
        L87:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.AbstractC0172k.b(android.content.Context, androidx.fragment.app.Fragment, boolean, boolean):androidx.fragment.app.k$a");
    }

    private static int c(Context context, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i2});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int d(Context context, int i2, boolean z2) {
        int i3;
        if (i2 == 4097) {
            return z2 ? R$animator.fragment_open_enter : R$animator.fragment_open_exit;
        }
        if (i2 == 8194) {
            return z2 ? R$animator.fragment_close_enter : R$animator.fragment_close_exit;
        }
        if (i2 == 8197) {
            i3 = z2 ? R.attr.activityCloseEnterAnimation : R.attr.activityCloseExitAnimation;
        } else {
            if (i2 == 4099) {
                return z2 ? R$animator.fragment_fade_enter : R$animator.fragment_fade_exit;
            }
            if (i2 != 4100) {
                return -1;
            }
            i3 = z2 ? R.attr.activityOpenEnterAnimation : R.attr.activityOpenExitAnimation;
        }
        return c(context, i3);
    }
}
