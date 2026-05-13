package s;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f4004a;

    private static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final InputContentInfo f4005a;

        a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f4005a = new InputContentInfo(uri, clipDescription, uri2);
        }

        @Override // s.f.c
        public void a() {
            this.f4005a.requestPermission();
        }

        @Override // s.f.c
        public Uri b() {
            return this.f4005a.getLinkUri();
        }

        @Override // s.f.c
        public ClipDescription c() {
            return this.f4005a.getDescription();
        }

        @Override // s.f.c
        public Object d() {
            return this.f4005a;
        }

        @Override // s.f.c
        public Uri e() {
            return this.f4005a.getContentUri();
        }

        a(Object obj) {
            this.f4005a = (InputContentInfo) obj;
        }
    }

    private interface c {
        void a();

        Uri b();

        ClipDescription c();

        Object d();

        Uri e();
    }

    public f(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f4004a = Build.VERSION.SDK_INT >= 25 ? new a(uri, clipDescription, uri2) : new b(uri, clipDescription, uri2);
    }

    public static f f(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new f(new a(obj));
        }
        return null;
    }

    public Uri a() {
        return this.f4004a.e();
    }

    public ClipDescription b() {
        return this.f4004a.c();
    }

    public Uri c() {
        return this.f4004a.b();
    }

    public void d() {
        this.f4004a.a();
    }

    public Object e() {
        return this.f4004a.d();
    }

    private f(c cVar) {
        this.f4004a = cVar;
    }

    private static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f4006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ClipDescription f4007b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Uri f4008c;

        b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f4006a = uri;
            this.f4007b = clipDescription;
            this.f4008c = uri2;
        }

        @Override // s.f.c
        public Uri b() {
            return this.f4008c;
        }

        @Override // s.f.c
        public ClipDescription c() {
            return this.f4007b;
        }

        @Override // s.f.c
        public Object d() {
            return null;
        }

        @Override // s.f.c
        public Uri e() {
            return this.f4006a;
        }

        @Override // s.f.c
        public void a() {
        }
    }
}
