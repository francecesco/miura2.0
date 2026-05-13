package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import o.AbstractC0234c;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f2172k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f2174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f2175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Parcelable f2176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f2179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    PorterDuff.Mode f2180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f2181i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f2182j;

    static class a {
        static int a(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return 0;
            }
        }

        static String b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }

        static int c(Object obj) {
            StringBuilder sb;
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException unused) {
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                return -1;
            } catch (NoSuchMethodException unused2) {
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                return -1;
            } catch (InvocationTargetException unused3) {
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                return -1;
            }
        }

        static Uri d(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }

        static Drawable e(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
        
            if (r0 >= 26) goto L14;
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00b4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        static android.graphics.drawable.Icon f(androidx.core.graphics.drawable.IconCompat r4, android.content.Context r5) {
            /*
                Method dump skipped, instruction units count: 210
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.a.f(androidx.core.graphics.drawable.IconCompat, android.content.Context):android.graphics.drawable.Icon");
        }
    }

    static class b {
        static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    static class c {
        static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    static class d {
        static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.f2173a = -1;
        this.f2175c = null;
        this.f2176d = null;
        this.f2177e = 0;
        this.f2178f = 0;
        this.f2179g = null;
        this.f2180h = f2172k;
        this.f2181i = null;
    }

    static Bitmap a(Bitmap bitmap, boolean z2) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f2 = iMin;
        float f3 = 0.5f * f2;
        float f4 = 0.9166667f * f3;
        if (z2) {
            float f5 = 0.010416667f * f2;
            paint.setColor(0);
            paint.setShadowLayer(f5, 0.0f, f2 * 0.020833334f, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static IconCompat b(Resources resources, String str, int i2) {
        AbstractC0234c.c(str);
        if (i2 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f2177e = i2;
        if (resources != null) {
            try {
                iconCompat.f2174b = resources.getResourceName(i2);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f2174b = str;
        }
        iconCompat.f2182j = str;
        return iconCompat;
    }

    private static String m(int i2) {
        switch (i2) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public Bitmap c() {
        int i2 = this.f2173a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f2174b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i2 == 1) {
            return (Bitmap) this.f2174b;
        }
        if (i2 == 5) {
            return a((Bitmap) this.f2174b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int d() {
        int i2 = this.f2173a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.a(this.f2174b);
        }
        if (i2 == 2) {
            return this.f2177e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String e() {
        int i2 = this.f2173a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.b(this.f2174b);
        }
        if (i2 == 2) {
            String str = this.f2182j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f2174b).split(":", -1)[0] : this.f2182j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int f() {
        int i2 = this.f2173a;
        return (i2 != -1 || Build.VERSION.SDK_INT < 23) ? i2 : a.c(this.f2174b);
    }

    public Uri g() {
        int i2 = this.f2173a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.d(this.f2174b);
        }
        if (i2 == 4 || i2 == 6) {
            return Uri.parse((String) this.f2174b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream h(Context context) {
        StringBuilder sb;
        String str;
        Uri uriG = g();
        String scheme = uriG.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriG);
            } catch (Exception unused) {
                sb = new StringBuilder();
                str = "Unable to load image from URI: ";
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f2174b));
            } catch (FileNotFoundException unused2) {
                sb = new StringBuilder();
                str = "Unable to load image from path: ";
            }
        }
        sb.append(str);
        sb.append(uriG);
        return null;
    }

    public void i() {
        Parcelable parcelable;
        this.f2180h = PorterDuff.Mode.valueOf(this.f2181i);
        switch (this.f2173a) {
            case -1:
                parcelable = this.f2176d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                parcelable = this.f2176d;
                if (parcelable == null) {
                    byte[] bArr = this.f2175c;
                    this.f2174b = bArr;
                    this.f2173a = 3;
                    this.f2177e = 0;
                    this.f2178f = bArr.length;
                    return;
                }
                break;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f2175c, Charset.forName("UTF-16"));
                this.f2174b = str;
                if (this.f2173a == 2 && this.f2182j == null) {
                    this.f2182j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f2174b = this.f2175c;
                return;
        }
        this.f2174b = parcelable;
    }

    public void j(boolean z2) {
        this.f2181i = this.f2180h.name();
        switch (this.f2173a) {
            case -1:
                if (z2) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z2) {
                    Bitmap bitmap = (Bitmap) this.f2174b;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f2175c = byteArrayOutputStream.toByteArray();
                    return;
                }
                break;
            case 2:
                this.f2175c = ((String) this.f2174b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f2175c = (byte[]) this.f2174b;
                return;
            case 4:
            case 6:
                this.f2175c = this.f2174b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
        this.f2176d = (Parcelable) this.f2174b;
    }

    public Icon k() {
        return l(null);
    }

    public Icon l(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.f(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public String toString() {
        int height;
        if (this.f2173a == -1) {
            return String.valueOf(this.f2174b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(m(this.f2173a));
        switch (this.f2173a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f2174b).getWidth());
                sb.append("x");
                height = ((Bitmap) this.f2174b).getHeight();
                sb.append(height);
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f2182j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(d())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f2177e);
                if (this.f2178f != 0) {
                    sb.append(" off=");
                    height = this.f2178f;
                    sb.append(height);
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f2174b);
                break;
        }
        if (this.f2179g != null) {
            sb.append(" tint=");
            sb.append(this.f2179g);
        }
        if (this.f2180h != f2172k) {
            sb.append(" mode=");
            sb.append(this.f2180h);
        }
        sb.append(")");
        return sb.toString();
    }

    IconCompat(int i2) {
        this.f2175c = null;
        this.f2176d = null;
        this.f2177e = 0;
        this.f2178f = 0;
        this.f2179g = null;
        this.f2180h = f2172k;
        this.f2181i = null;
        this.f2173a = i2;
    }
}
