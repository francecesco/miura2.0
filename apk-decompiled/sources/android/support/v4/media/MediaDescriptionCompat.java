package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.a;
import android.support.v4.media.d;
import android.support.v4.media.session.MediaSessionCompat;

/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CharSequence f669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CharSequence f670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Bitmap f671e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Uri f672f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Bundle f673g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Uri f674h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Object f675i;

    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.a(android.support.v4.media.a.a(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i2) {
            return new MediaDescriptionCompat[i2];
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CharSequence f677b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f678c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f679d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Bitmap f680e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Uri f681f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Bundle f682g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Uri f683h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f676a, this.f677b, this.f678c, this.f679d, this.f680e, this.f681f, this.f682g, this.f683h);
        }

        public b b(CharSequence charSequence) {
            this.f679d = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.f682g = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.f680e = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f681f = uri;
            return this;
        }

        public b f(String str) {
            this.f676a = str;
            return this;
        }

        public b g(Uri uri) {
            this.f683h = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f678c = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.f677b = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f667a = str;
        this.f668b = charSequence;
        this.f669c = charSequence2;
        this.f670d = charSequence3;
        this.f671e = bitmap;
        this.f672f = uri;
        this.f673g = bundle;
        this.f674h = uri2;
    }

    public static MediaDescriptionCompat a(Object obj) {
        Uri uri;
        Bundle bundle = null;
        if (obj == null) {
            return null;
        }
        int i2 = Build.VERSION.SDK_INT;
        b bVar = new b();
        bVar.f(android.support.v4.media.a.f(obj));
        bVar.i(android.support.v4.media.a.h(obj));
        bVar.h(android.support.v4.media.a.g(obj));
        bVar.b(android.support.v4.media.a.b(obj));
        bVar.d(android.support.v4.media.a.d(obj));
        bVar.e(android.support.v4.media.a.e(obj));
        Bundle bundleC = android.support.v4.media.a.c(obj);
        if (bundleC != null) {
            MediaSessionCompat.a(bundleC);
            uri = (Uri) bundleC.getParcelable("android.support.v4.media.description.MEDIA_URI");
        } else {
            uri = null;
        }
        if (uri == null) {
            bundle = bundleC;
        } else if (!bundleC.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") || bundleC.size() != 2) {
            bundleC.remove("android.support.v4.media.description.MEDIA_URI");
            bundleC.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
            bundle = bundleC;
        }
        bVar.c(bundle);
        if (uri != null) {
            bVar.g(uri);
        } else if (i2 >= 23) {
            bVar.g(d.a(obj));
        }
        MediaDescriptionCompat mediaDescriptionCompatA = bVar.a();
        mediaDescriptionCompatA.f675i = obj;
        return mediaDescriptionCompatA;
    }

    public Object b() {
        Object obj = this.f675i;
        if (obj != null) {
            return obj;
        }
        int i2 = Build.VERSION.SDK_INT;
        Object objB = a.C0019a.b();
        a.C0019a.g(objB, this.f667a);
        a.C0019a.i(objB, this.f668b);
        a.C0019a.h(objB, this.f669c);
        a.C0019a.c(objB, this.f670d);
        a.C0019a.e(objB, this.f671e);
        a.C0019a.f(objB, this.f672f);
        Bundle bundle = this.f673g;
        if (i2 < 23 && this.f674h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f674h);
        }
        a.C0019a.d(objB, bundle);
        if (i2 >= 23) {
            d.a.a(objB, this.f674h);
        }
        Object objA = a.C0019a.a(objB);
        this.f675i = objA;
        return objA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return ((Object) this.f668b) + ", " + ((Object) this.f669c) + ", " + ((Object) this.f670d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        android.support.v4.media.a.i(b(), parcel, i2);
    }
}
