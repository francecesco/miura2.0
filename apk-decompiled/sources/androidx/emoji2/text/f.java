package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import k.C0208b;
import o.AbstractC0236e;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Object f2527o = new Object();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Object f2528p = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static volatile f f2529q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f2531b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f2534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final h f2535f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final j f2536g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f2537h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f2538i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final int[] f2539j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f2540k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f2541l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f2542m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final e f2543n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ReadWriteLock f2530a = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f2532c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f2533d = new Handler(Looper.getMainLooper());

    private static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile androidx.emoji2.text.i f2544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile n f2545c;

        /* JADX INFO: renamed from: androidx.emoji2.text.f$a$a, reason: collision with other inner class name */
        class C0042a extends i {
            C0042a() {
            }

            @Override // androidx.emoji2.text.f.i
            public void a(Throwable th) {
                a.this.f2547a.n(th);
            }

            @Override // androidx.emoji2.text.f.i
            public void b(n nVar) {
                a.this.d(nVar);
            }
        }

        a(f fVar) {
            super(fVar);
        }

        @Override // androidx.emoji2.text.f.b
        void a() {
            try {
                this.f2547a.f2535f.a(new C0042a());
            } catch (Throwable th) {
                this.f2547a.n(th);
            }
        }

        @Override // androidx.emoji2.text.f.b
        CharSequence b(CharSequence charSequence, int i2, int i3, int i4, boolean z2) {
            return this.f2544b.h(charSequence, i2, i3, i4, z2);
        }

        @Override // androidx.emoji2.text.f.b
        void c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f2545c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f2547a.f2537h);
        }

        void d(n nVar) {
            if (nVar == null) {
                this.f2547a.n(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f2545c = nVar;
            n nVar2 = this.f2545c;
            j jVar = this.f2547a.f2536g;
            e eVar = this.f2547a.f2543n;
            f fVar = this.f2547a;
            this.f2544b = new androidx.emoji2.text.i(nVar2, jVar, eVar, fVar.f2538i, fVar.f2539j, androidx.emoji2.text.h.a());
            this.f2547a.o();
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final f f2547a;

        b(f fVar) {
            this.f2547a = fVar;
        }

        abstract void a();

        abstract CharSequence b(CharSequence charSequence, int i2, int i3, int i4, boolean z2);

        abstract void c(EditorInfo editorInfo);
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final h f2548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        j f2549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f2550c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f2551d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int[] f2552e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Set f2553f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f2554g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f2555h = -16711936;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f2556i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        e f2557j = new androidx.emoji2.text.e();

        protected c(h hVar) {
            AbstractC0236e.g(hVar, "metadataLoader cannot be null.");
            this.f2548a = hVar;
        }

        protected final h a() {
            return this.f2548a;
        }

        public c b(int i2) {
            this.f2556i = i2;
            return this;
        }
    }

    public static class d implements j {
        @Override // androidx.emoji2.text.f.j
        public androidx.emoji2.text.j a(p pVar) {
            return new q(pVar);
        }
    }

    public interface e {
        boolean a(CharSequence charSequence, int i2, int i3, int i4);
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.f$f, reason: collision with other inner class name */
    public static abstract class AbstractC0043f {
        public void a(Throwable th) {
        }

        public void b() {
        }
    }

    private static class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f2558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Throwable f2559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f2560c;

        g(AbstractC0043f abstractC0043f, int i2) {
            this(Arrays.asList((AbstractC0043f) AbstractC0236e.g(abstractC0043f, "initCallback cannot be null")), i2, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f2558a.size();
            int i2 = 0;
            if (this.f2560c != 1) {
                while (i2 < size) {
                    ((AbstractC0043f) this.f2558a.get(i2)).a(this.f2559b);
                    i2++;
                }
            } else {
                while (i2 < size) {
                    ((AbstractC0043f) this.f2558a.get(i2)).b();
                    i2++;
                }
            }
        }

        g(Collection collection, int i2) {
            this(collection, i2, null);
        }

        g(Collection collection, int i2, Throwable th) {
            AbstractC0236e.g(collection, "initCallbacks cannot be null");
            this.f2558a = new ArrayList(collection);
            this.f2560c = i2;
            this.f2559b = th;
        }
    }

    public interface h {
        void a(i iVar);
    }

    public static abstract class i {
        public abstract void a(Throwable th);

        public abstract void b(n nVar);
    }

    public interface j {
        androidx.emoji2.text.j a(p pVar);
    }

    private f(c cVar) {
        this.f2537h = cVar.f2550c;
        this.f2538i = cVar.f2551d;
        this.f2539j = cVar.f2552e;
        this.f2540k = cVar.f2554g;
        this.f2541l = cVar.f2555h;
        this.f2535f = cVar.f2548a;
        this.f2542m = cVar.f2556i;
        this.f2543n = cVar.f2557j;
        C0208b c0208b = new C0208b();
        this.f2531b = c0208b;
        j jVar = cVar.f2549b;
        this.f2536g = jVar == null ? new d() : jVar;
        Set set = cVar.f2553f;
        if (set != null && !set.isEmpty()) {
            c0208b.addAll(cVar.f2553f);
        }
        this.f2534e = new a(this);
        m();
    }

    public static f c() {
        f fVar;
        synchronized (f2527o) {
            fVar = f2529q;
            AbstractC0236e.h(fVar != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return fVar;
    }

    public static boolean f(InputConnection inputConnection, Editable editable, int i2, int i3, boolean z2) {
        return androidx.emoji2.text.i.b(inputConnection, editable, i2, i3, z2);
    }

    public static boolean g(Editable editable, int i2, KeyEvent keyEvent) {
        return androidx.emoji2.text.i.c(editable, i2, keyEvent);
    }

    public static f h(c cVar) {
        f fVar = f2529q;
        if (fVar == null) {
            synchronized (f2527o) {
                try {
                    fVar = f2529q;
                    if (fVar == null) {
                        fVar = new f(cVar);
                        f2529q = fVar;
                    }
                } finally {
                }
            }
        }
        return fVar;
    }

    public static boolean i() {
        return f2529q != null;
    }

    private boolean k() {
        return e() == 1;
    }

    private void m() {
        this.f2530a.writeLock().lock();
        try {
            if (this.f2542m == 0) {
                this.f2532c = 0;
            }
            this.f2530a.writeLock().unlock();
            if (e() == 0) {
                this.f2534e.a();
            }
        } catch (Throwable th) {
            this.f2530a.writeLock().unlock();
            throw th;
        }
    }

    public int d() {
        return this.f2541l;
    }

    public int e() {
        this.f2530a.readLock().lock();
        try {
            return this.f2532c;
        } finally {
            this.f2530a.readLock().unlock();
        }
    }

    public boolean j() {
        return this.f2540k;
    }

    public void l() {
        AbstractC0236e.h(this.f2542m == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (k()) {
            return;
        }
        this.f2530a.writeLock().lock();
        try {
            if (this.f2532c == 0) {
                return;
            }
            this.f2532c = 0;
            this.f2530a.writeLock().unlock();
            this.f2534e.a();
        } finally {
            this.f2530a.writeLock().unlock();
        }
    }

    void n(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f2530a.writeLock().lock();
        try {
            this.f2532c = 2;
            arrayList.addAll(this.f2531b);
            this.f2531b.clear();
            this.f2530a.writeLock().unlock();
            this.f2533d.post(new g(arrayList, this.f2532c, th));
        } catch (Throwable th2) {
            this.f2530a.writeLock().unlock();
            throw th2;
        }
    }

    void o() {
        ArrayList arrayList = new ArrayList();
        this.f2530a.writeLock().lock();
        try {
            this.f2532c = 1;
            arrayList.addAll(this.f2531b);
            this.f2531b.clear();
            this.f2530a.writeLock().unlock();
            this.f2533d.post(new g(arrayList, this.f2532c));
        } catch (Throwable th) {
            this.f2530a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence p(CharSequence charSequence) {
        return q(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence q(CharSequence charSequence, int i2, int i3) {
        return r(charSequence, i2, i3, Integer.MAX_VALUE);
    }

    public CharSequence r(CharSequence charSequence, int i2, int i3, int i4) {
        return s(charSequence, i2, i3, i4, 0);
    }

    public CharSequence s(CharSequence charSequence, int i2, int i3, int i4, int i5) {
        AbstractC0236e.h(k(), "Not initialized yet");
        AbstractC0236e.d(i2, "start cannot be negative");
        AbstractC0236e.d(i3, "end cannot be negative");
        AbstractC0236e.d(i4, "maxEmojiCount cannot be negative");
        AbstractC0236e.a(i2 <= i3, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        AbstractC0236e.a(i2 <= charSequence.length(), "start should be < than charSequence length");
        AbstractC0236e.a(i3 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i2 == i3) {
            return charSequence;
        }
        return this.f2534e.b(charSequence, i2, i3, i4, i5 != 1 ? i5 != 2 ? this.f2537h : false : true);
    }

    public void t(AbstractC0043f abstractC0043f) {
        AbstractC0236e.g(abstractC0043f, "initCallback cannot be null");
        this.f2530a.writeLock().lock();
        try {
            if (this.f2532c == 1 || this.f2532c == 2) {
                this.f2533d.post(new g(abstractC0043f, this.f2532c));
            } else {
                this.f2531b.add(abstractC0043f);
            }
            this.f2530a.writeLock().unlock();
        } catch (Throwable th) {
            this.f2530a.writeLock().unlock();
            throw th;
        }
    }

    public void u(AbstractC0043f abstractC0043f) {
        AbstractC0236e.g(abstractC0043f, "initCallback cannot be null");
        this.f2530a.writeLock().lock();
        try {
            this.f2531b.remove(abstractC0043f);
        } finally {
            this.f2530a.writeLock().unlock();
        }
    }

    public void v(EditorInfo editorInfo) {
        if (!k() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.f2534e.c(editorInfo);
    }
}
