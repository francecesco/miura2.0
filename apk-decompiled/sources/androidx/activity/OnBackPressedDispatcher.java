package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.AbstractC0183g;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import l0.C0220d;

/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0220d f759b = new C0220d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p0.a f760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OnBackInvokedCallback f761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private OnBackInvokedDispatcher f762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f763f;

    private final class LifecycleOnBackPressedCancellable implements androidx.lifecycle.j, androidx.activity.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AbstractC0183g f764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final m f765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private androidx.activity.a f766c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f767d;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, AbstractC0183g abstractC0183g, m mVar) {
            q0.f.e(abstractC0183g, "lifecycle");
            q0.f.e(mVar, "onBackPressedCallback");
            this.f767d = onBackPressedDispatcher;
            this.f764a = abstractC0183g;
            this.f765b = mVar;
            abstractC0183g.a(this);
        }

        @Override // androidx.activity.a
        public void cancel() {
            this.f764a.c(this);
            this.f765b.e(this);
            androidx.activity.a aVar = this.f766c;
            if (aVar != null) {
                aVar.cancel();
            }
            this.f766c = null;
        }

        @Override // androidx.lifecycle.j
        public void d(androidx.lifecycle.l lVar, AbstractC0183g.a aVar) {
            q0.f.e(lVar, "source");
            q0.f.e(aVar, "event");
            if (aVar == AbstractC0183g.a.ON_START) {
                this.f766c = this.f767d.c(this.f765b);
                return;
            }
            if (aVar != AbstractC0183g.a.ON_STOP) {
                if (aVar == AbstractC0183g.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.a aVar2 = this.f766c;
                if (aVar2 != null) {
                    aVar2.cancel();
                }
            }
        }
    }

    static final class a extends q0.g implements p0.a {
        a() {
            super(0);
        }

        @Override // p0.a
        public /* bridge */ /* synthetic */ Object a() {
            c();
            return k0.i.f3861a;
        }

        public final void c() {
            OnBackPressedDispatcher.this.g();
        }
    }

    static final class b extends q0.g implements p0.a {
        b() {
            super(0);
        }

        @Override // p0.a
        public /* bridge */ /* synthetic */ Object a() {
            c();
            return k0.i.f3861a;
        }

        public final void c() {
            OnBackPressedDispatcher.this.e();
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f770a = new c();

        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(p0.a aVar) {
            q0.f.e(aVar, "$onBackInvoked");
            aVar.a();
        }

        public final OnBackInvokedCallback b(final p0.a aVar) {
            q0.f.e(aVar, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.n
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    OnBackPressedDispatcher.c.c(aVar);
                }
            };
        }

        public final void d(Object obj, int i2, Object obj2) {
            q0.f.e(obj, "dispatcher");
            q0.f.e(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i2, (OnBackInvokedCallback) obj2);
        }

        public final void e(Object obj, Object obj2) {
            q0.f.e(obj, "dispatcher");
            q0.f.e(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    private final class d implements androidx.activity.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m f771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f772b;

        public d(OnBackPressedDispatcher onBackPressedDispatcher, m mVar) {
            q0.f.e(mVar, "onBackPressedCallback");
            this.f772b = onBackPressedDispatcher;
            this.f771a = mVar;
        }

        @Override // androidx.activity.a
        public void cancel() {
            this.f772b.f759b.remove(this.f771a);
            this.f771a.e(this);
            if (Build.VERSION.SDK_INT >= 33) {
                this.f771a.g(null);
                this.f772b.g();
            }
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f758a = runnable;
        if (Build.VERSION.SDK_INT >= 33) {
            this.f760c = new a();
            this.f761d = c.f770a.b(new b());
        }
    }

    public final void b(androidx.lifecycle.l lVar, m mVar) {
        q0.f.e(lVar, "owner");
        q0.f.e(mVar, "onBackPressedCallback");
        AbstractC0183g abstractC0183gG = lVar.G();
        if (abstractC0183gG.b() == AbstractC0183g.b.DESTROYED) {
            return;
        }
        mVar.a(new LifecycleOnBackPressedCancellable(this, abstractC0183gG, mVar));
        if (Build.VERSION.SDK_INT >= 33) {
            g();
            mVar.g(this.f760c);
        }
    }

    public final androidx.activity.a c(m mVar) {
        q0.f.e(mVar, "onBackPressedCallback");
        this.f759b.add(mVar);
        d dVar = new d(this, mVar);
        mVar.a(dVar);
        if (Build.VERSION.SDK_INT >= 33) {
            g();
            mVar.g(this.f760c);
        }
        return dVar;
    }

    public final boolean d() {
        C0220d c0220d = this.f759b;
        if ((c0220d instanceof Collection) && c0220d.isEmpty()) {
            return false;
        }
        Iterator<E> it2 = c0220d.iterator();
        while (it2.hasNext()) {
            if (((m) it2.next()).c()) {
                return true;
            }
        }
        return false;
    }

    public final void e() {
        Object objPrevious;
        C0220d c0220d = this.f759b;
        ListIterator<E> listIterator = c0220d.listIterator(c0220d.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            } else {
                objPrevious = listIterator.previous();
                if (((m) objPrevious).c()) {
                    break;
                }
            }
        }
        m mVar = (m) objPrevious;
        if (mVar != null) {
            mVar.b();
            return;
        }
        Runnable runnable = this.f758a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void f(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        q0.f.e(onBackInvokedDispatcher, "invoker");
        this.f762e = onBackInvokedDispatcher;
        g();
    }

    public final void g() {
        boolean zD = d();
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f762e;
        OnBackInvokedCallback onBackInvokedCallback = this.f761d;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (zD && !this.f763f) {
            c.f770a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f763f = true;
        } else {
            if (zD || !this.f763f) {
                return;
            }
            c.f770a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f763f = false;
        }
    }
}
