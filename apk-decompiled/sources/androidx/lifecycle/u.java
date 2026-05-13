package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0183g;

/* JADX INFO: loaded from: classes.dex */
public class u extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f3113b = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f3114a;

    public interface a {
        void a();

        void b();

        void c();
    }

    public static final class b {
        private b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Activity activity, AbstractC0183g.a aVar) {
            q0.f.e(activity, "activity");
            q0.f.e(aVar, "event");
            if (activity instanceof l) {
                AbstractC0183g abstractC0183gG = ((l) activity).G();
                if (abstractC0183gG instanceof m) {
                    ((m) abstractC0183gG).h(aVar);
                }
            }
        }

        public final u b(Activity activity) {
            q0.f.e(activity, "<this>");
            Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            q0.f.c(fragmentFindFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (u) fragmentFindFragmentByTag;
        }

        public final void c(Activity activity) {
            q0.f.e(activity, "activity");
            if (Build.VERSION.SDK_INT >= 29) {
                c.Companion.a(activity);
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragmentManager.beginTransaction().add(new u(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
                fragmentManager.executePendingTransactions();
            }
        }

        public /* synthetic */ b(q0.d dVar) {
            this();
        }
    }

    public static final class c implements Application.ActivityLifecycleCallbacks {
        public static final a Companion = new a(null);

        public static final class a {
            private a() {
            }

            public final void a(Activity activity) {
                q0.f.e(activity, "activity");
                activity.registerActivityLifecycleCallbacks(new c());
            }

            public /* synthetic */ a(q0.d dVar) {
                this();
            }
        }

        public static final void registerIn(Activity activity) {
            Companion.a(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            q0.f.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            q0.f.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            q0.f.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            q0.f.e(activity, "activity");
            u.f3113b.a(activity, AbstractC0183g.a.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            q0.f.e(activity, "activity");
            u.f3113b.a(activity, AbstractC0183g.a.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            q0.f.e(activity, "activity");
            u.f3113b.a(activity, AbstractC0183g.a.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            q0.f.e(activity, "activity");
            u.f3113b.a(activity, AbstractC0183g.a.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            q0.f.e(activity, "activity");
            u.f3113b.a(activity, AbstractC0183g.a.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            q0.f.e(activity, "activity");
            u.f3113b.a(activity, AbstractC0183g.a.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            q0.f.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            q0.f.e(activity, "activity");
            q0.f.e(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            q0.f.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            q0.f.e(activity, "activity");
        }
    }

    private final void a(AbstractC0183g.a aVar) {
        if (Build.VERSION.SDK_INT < 29) {
            b bVar = f3113b;
            Activity activity = getActivity();
            q0.f.d(activity, "activity");
            bVar.a(activity, aVar);
        }
    }

    private final void b(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    private final void c(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    private final void d(a aVar) {
        if (aVar != null) {
            aVar.c();
        }
    }

    public static final void e(Activity activity) {
        f3113b.c(activity);
    }

    public final void f(a aVar) {
        this.f3114a = aVar;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(this.f3114a);
        a(AbstractC0183g.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(AbstractC0183g.a.ON_DESTROY);
        this.f3114a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(AbstractC0183g.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        c(this.f3114a);
        a(AbstractC0183g.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        d(this.f3114a);
        a(AbstractC0183g.a.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(AbstractC0183g.a.ON_STOP);
    }
}
