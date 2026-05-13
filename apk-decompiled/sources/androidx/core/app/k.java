package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Bundle f2030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private IconCompat f2031b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final r[] f2032c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final r[] f2033d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f2034e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f2035f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f2036g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f2037h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f2038i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public CharSequence f2039j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public PendingIntent f2040k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f2041l;

        public a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i2 != 0 ? IconCompat.b(null, "", i2) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f2040k;
        }

        public boolean b() {
            return this.f2034e;
        }

        public Bundle c() {
            return this.f2030a;
        }

        public IconCompat d() {
            int i2;
            if (this.f2031b == null && (i2 = this.f2038i) != 0) {
                this.f2031b = IconCompat.b(null, "", i2);
            }
            return this.f2031b;
        }

        public r[] e() {
            return this.f2032c;
        }

        public int f() {
            return this.f2036g;
        }

        public boolean g() {
            return this.f2035f;
        }

        public CharSequence h() {
            return this.f2039j;
        }

        public boolean i() {
            return this.f2041l;
        }

        public boolean j() {
            return this.f2037h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, r[] rVarArr, r[] rVarArr2, boolean z2, int i2, boolean z3, boolean z4, boolean z5) {
            this.f2035f = true;
            this.f2031b = iconCompat;
            if (iconCompat != null && iconCompat.f() == 2) {
                this.f2038i = iconCompat.d();
            }
            this.f2039j = d.d(charSequence);
            this.f2040k = pendingIntent;
            this.f2030a = bundle == null ? new Bundle() : bundle;
            this.f2032c = rVarArr;
            this.f2033d = rVarArr2;
            this.f2034e = z2;
            this.f2036g = i2;
            this.f2035f = z3;
            this.f2037h = z4;
            this.f2041l = z5;
        }
    }

    public static class b extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private CharSequence f2042e;

        @Override // androidx.core.app.k.e
        public void a(Bundle bundle) {
            super.a(bundle);
        }

        @Override // androidx.core.app.k.e
        public void b(j jVar) {
            Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(jVar.a()).setBigContentTitle(this.f2091b).bigText(this.f2042e);
            if (this.f2093d) {
                bigTextStyleBigText.setSummaryText(this.f2092c);
            }
        }

        @Override // androidx.core.app.k.e
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public b h(CharSequence charSequence) {
            this.f2042e = d.d(charSequence);
            return this;
        }
    }

    public static final class c {
        public static Notification.BubbleMetadata a(c cVar) {
            return null;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        boolean f2043A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        boolean f2044B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        String f2045C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        Bundle f2046D;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        int f2047E;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        int f2048F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        Notification f2049G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        RemoteViews f2050H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        RemoteViews f2051I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        RemoteViews f2052J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        String f2053K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        int f2054L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        String f2055M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        long f2056N;

        /* JADX INFO: renamed from: O, reason: collision with root package name */
        int f2057O;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        int f2058P;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        boolean f2059Q;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        Notification f2060R;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        boolean f2061S;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        Object f2062T;

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        public ArrayList f2063U;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f2064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f2065b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList f2066c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ArrayList f2067d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        CharSequence f2068e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        CharSequence f2069f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        PendingIntent f2070g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        PendingIntent f2071h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        RemoteViews f2072i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        IconCompat f2073j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        CharSequence f2074k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f2075l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f2076m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f2077n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f2078o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        e f2079p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        CharSequence f2080q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        CharSequence f2081r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        CharSequence[] f2082s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        int f2083t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        int f2084u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        boolean f2085v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        String f2086w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        boolean f2087x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        String f2088y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        boolean f2089z;

        public d(Context context) {
            this(context, null);
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private void j(int i2, boolean z2) {
            Notification notification;
            int i3;
            if (z2) {
                notification = this.f2060R;
                i3 = i2 | notification.flags;
            } else {
                notification = this.f2060R;
                i3 = (~i2) & notification.flags;
            }
            notification.flags = i3;
        }

        public d a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f2065b.add(new a(i2, charSequence, pendingIntent));
            return this;
        }

        public Notification b() {
            return new l(this).c();
        }

        public Bundle c() {
            if (this.f2046D == null) {
                this.f2046D = new Bundle();
            }
            return this.f2046D;
        }

        public d e(boolean z2) {
            j(16, z2);
            return this;
        }

        public d f(String str) {
            this.f2053K = str;
            return this;
        }

        public d g(PendingIntent pendingIntent) {
            this.f2070g = pendingIntent;
            return this;
        }

        public d h(CharSequence charSequence) {
            this.f2069f = d(charSequence);
            return this;
        }

        public d i(CharSequence charSequence) {
            this.f2068e = d(charSequence);
            return this;
        }

        public d k(boolean z2) {
            this.f2089z = z2;
            return this;
        }

        public d l(int i2) {
            this.f2076m = i2;
            return this;
        }

        public d m(int i2) {
            this.f2060R.icon = i2;
            return this;
        }

        public d n(e eVar) {
            if (this.f2079p != eVar) {
                this.f2079p = eVar;
                if (eVar != null) {
                    eVar.g(this);
                }
            }
            return this;
        }

        public d o(CharSequence charSequence) {
            this.f2060R.tickerText = d(charSequence);
            return this;
        }

        public d p(long j2) {
            this.f2060R.when = j2;
            return this;
        }

        public d(Context context, String str) {
            this.f2065b = new ArrayList();
            this.f2066c = new ArrayList();
            this.f2067d = new ArrayList();
            this.f2077n = true;
            this.f2089z = false;
            this.f2047E = 0;
            this.f2048F = 0;
            this.f2054L = 0;
            this.f2057O = 0;
            this.f2058P = 0;
            Notification notification = new Notification();
            this.f2060R = notification;
            this.f2064a = context;
            this.f2053K = str;
            notification.when = System.currentTimeMillis();
            this.f2060R.audioStreamType = -1;
            this.f2076m = 0;
            this.f2063U = new ArrayList();
            this.f2059Q = true;
        }
    }

    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected d f2090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        CharSequence f2091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        CharSequence f2092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f2093d = false;

        public void a(Bundle bundle) {
            if (this.f2093d) {
                bundle.putCharSequence("android.summaryText", this.f2092c);
            }
            CharSequence charSequence = this.f2091b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String strC = c();
            if (strC != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strC);
            }
        }

        public abstract void b(j jVar);

        protected abstract String c();

        public RemoteViews d(j jVar) {
            return null;
        }

        public RemoteViews e(j jVar) {
            return null;
        }

        public RemoteViews f(j jVar) {
            return null;
        }

        public void g(d dVar) {
            if (this.f2090a != dVar) {
                this.f2090a = dVar;
                if (dVar != null) {
                    dVar.n(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }
}
