package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.U;
import androidx.core.view.V;
import androidx.core.view.W;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Interpolator f1215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    V f1216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1217e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1214b = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final W f1218f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ArrayList f1213a = new ArrayList();

    class a extends W {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1219a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1220b = 0;

        a() {
        }

        @Override // androidx.core.view.V
        public void a(View view) {
            int i2 = this.f1220b + 1;
            this.f1220b = i2;
            if (i2 == h.this.f1213a.size()) {
                V v2 = h.this.f1216d;
                if (v2 != null) {
                    v2.a(null);
                }
                d();
            }
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void b(View view) {
            if (this.f1219a) {
                return;
            }
            this.f1219a = true;
            V v2 = h.this.f1216d;
            if (v2 != null) {
                v2.b(null);
            }
        }

        void d() {
            this.f1220b = 0;
            this.f1219a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f1217e) {
            Iterator it2 = this.f1213a.iterator();
            while (it2.hasNext()) {
                ((U) it2.next()).c();
            }
            this.f1217e = false;
        }
    }

    void b() {
        this.f1217e = false;
    }

    public h c(U u2) {
        if (!this.f1217e) {
            this.f1213a.add(u2);
        }
        return this;
    }

    public h d(U u2, U u3) {
        this.f1213a.add(u2);
        u3.j(u2.d());
        this.f1213a.add(u3);
        return this;
    }

    public h e(long j2) {
        if (!this.f1217e) {
            this.f1214b = j2;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f1217e) {
            this.f1215c = interpolator;
        }
        return this;
    }

    public h g(V v2) {
        if (!this.f1217e) {
            this.f1216d = v2;
        }
        return this;
    }

    public void h() {
        if (this.f1217e) {
            return;
        }
        for (U u2 : this.f1213a) {
            long j2 = this.f1214b;
            if (j2 >= 0) {
                u2.f(j2);
            }
            Interpolator interpolator = this.f1215c;
            if (interpolator != null) {
                u2.g(interpolator);
            }
            if (this.f1216d != null) {
                u2.h(this.f1218f);
            }
            u2.l();
        }
        this.f1217e = true;
    }
}
