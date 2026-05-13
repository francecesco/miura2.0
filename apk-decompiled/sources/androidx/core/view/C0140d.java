package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Objects;
import o.AbstractC0236e;

/* JADX INFO: renamed from: androidx.core.view.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0140d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f2350a;

    /* JADX INFO: renamed from: androidx.core.view.d$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f2351a;

        public a(ClipData clipData, int i2) {
            this.f2351a = Build.VERSION.SDK_INT >= 31 ? new b(clipData, i2) : new C0039d(clipData, i2);
        }

        public C0140d a() {
            return this.f2351a.a();
        }

        public a b(Bundle bundle) {
            this.f2351a.b(bundle);
            return this;
        }

        public a c(int i2) {
            this.f2351a.d(i2);
            return this;
        }

        public a d(Uri uri) {
            this.f2351a.c(uri);
            return this;
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.d$b */
    private static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentInfo.Builder f2352a;

        b(ClipData clipData, int i2) {
            this.f2352a = AbstractC0145i.a(clipData, i2);
        }

        @Override // androidx.core.view.C0140d.c
        public C0140d a() {
            return new C0140d(new e(this.f2352a.build()));
        }

        @Override // androidx.core.view.C0140d.c
        public void b(Bundle bundle) {
            this.f2352a.setExtras(bundle);
        }

        @Override // androidx.core.view.C0140d.c
        public void c(Uri uri) {
            this.f2352a.setLinkUri(uri);
        }

        @Override // androidx.core.view.C0140d.c
        public void d(int i2) {
            this.f2352a.setFlags(i2);
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.d$c */
    private interface c {
        C0140d a();

        void b(Bundle bundle);

        void c(Uri uri);

        void d(int i2);
    }

    /* JADX INFO: renamed from: androidx.core.view.d$d, reason: collision with other inner class name */
    private static final class C0039d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ClipData f2353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2355c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Uri f2356d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Bundle f2357e;

        C0039d(ClipData clipData, int i2) {
            this.f2353a = clipData;
            this.f2354b = i2;
        }

        @Override // androidx.core.view.C0140d.c
        public C0140d a() {
            return new C0140d(new g(this));
        }

        @Override // androidx.core.view.C0140d.c
        public void b(Bundle bundle) {
            this.f2357e = bundle;
        }

        @Override // androidx.core.view.C0140d.c
        public void c(Uri uri) {
            this.f2356d = uri;
        }

        @Override // androidx.core.view.C0140d.c
        public void d(int i2) {
            this.f2355c = i2;
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.d$e */
    private static final class e implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentInfo f2358a;

        e(ContentInfo contentInfo) {
            this.f2358a = AbstractC0139c.a(AbstractC0236e.f(contentInfo));
        }

        @Override // androidx.core.view.C0140d.f
        public ClipData a() {
            return this.f2358a.getClip();
        }

        @Override // androidx.core.view.C0140d.f
        public int b() {
            return this.f2358a.getFlags();
        }

        @Override // androidx.core.view.C0140d.f
        public ContentInfo c() {
            return this.f2358a;
        }

        @Override // androidx.core.view.C0140d.f
        public int getSource() {
            return this.f2358a.getSource();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f2358a + "}";
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.d$f */
    private interface f {
        ClipData a();

        int b();

        ContentInfo c();

        int getSource();
    }

    /* JADX INFO: renamed from: androidx.core.view.d$g */
    private static final class g implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ClipData f2359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f2361c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Uri f2362d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Bundle f2363e;

        g(C0039d c0039d) {
            this.f2359a = (ClipData) AbstractC0236e.f(c0039d.f2353a);
            this.f2360b = AbstractC0236e.b(c0039d.f2354b, 0, 5, "source");
            this.f2361c = AbstractC0236e.e(c0039d.f2355c, 1);
            this.f2362d = c0039d.f2356d;
            this.f2363e = c0039d.f2357e;
        }

        @Override // androidx.core.view.C0140d.f
        public ClipData a() {
            return this.f2359a;
        }

        @Override // androidx.core.view.C0140d.f
        public int b() {
            return this.f2361c;
        }

        @Override // androidx.core.view.C0140d.f
        public ContentInfo c() {
            return null;
        }

        @Override // androidx.core.view.C0140d.f
        public int getSource() {
            return this.f2360b;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.f2359a.getDescription());
            sb.append(", source=");
            sb.append(C0140d.e(this.f2360b));
            sb.append(", flags=");
            sb.append(C0140d.a(this.f2361c));
            if (this.f2362d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.f2362d.toString().length() + ")";
            }
            sb.append(str);
            sb.append(this.f2363e != null ? ", hasExtras" : "");
            sb.append("}");
            return sb.toString();
        }
    }

    C0140d(f fVar) {
        this.f2350a = fVar;
    }

    static String a(int i2) {
        return (i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2);
    }

    static String e(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? String.valueOf(i2) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    public static C0140d g(ContentInfo contentInfo) {
        return new C0140d(new e(contentInfo));
    }

    public ClipData b() {
        return this.f2350a.a();
    }

    public int c() {
        return this.f2350a.b();
    }

    public int d() {
        return this.f2350a.getSource();
    }

    public ContentInfo f() {
        ContentInfo contentInfoC = this.f2350a.c();
        Objects.requireNonNull(contentInfoC);
        return AbstractC0139c.a(contentInfoC);
    }

    public String toString() {
        return this.f2350a.toString();
    }
}
