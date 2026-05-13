package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.j;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AssetManager f3146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f3147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j.c f3148c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f3150e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f3151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f3152g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f3153h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private e[] f3155j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private byte[] f3156k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3154i = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f3149d = d();

    public d(AssetManager assetManager, Executor executor, j.c cVar, String str, String str2, String str3, File file) {
        this.f3146a = assetManager;
        this.f3147b = executor;
        this.f3148c = cVar;
        this.f3151f = str;
        this.f3152g = str2;
        this.f3153h = str3;
        this.f3150e = file;
    }

    private d b(e[] eVarArr, byte[] bArr) {
        j.c cVar;
        int i2;
        InputStream inputStreamH;
        try {
            inputStreamH = h(this.f3146a, this.f3153h);
        } catch (FileNotFoundException e2) {
            e = e2;
            cVar = this.f3148c;
            i2 = 9;
            cVar.b(i2, e);
        } catch (IOException e3) {
            e = e3;
            cVar = this.f3148c;
            i2 = 7;
            cVar.b(i2, e);
        } catch (IllegalStateException e4) {
            e = e4;
            this.f3155j = null;
            cVar = this.f3148c;
            i2 = 8;
            cVar.b(i2, e);
        }
        if (inputStreamH == null) {
            if (inputStreamH != null) {
                inputStreamH.close();
            }
            return null;
        }
        try {
            this.f3155j = o.q(inputStreamH, o.o(inputStreamH, o.f3184b), bArr, eVarArr);
            inputStreamH.close();
            return this;
        } catch (Throwable th) {
            try {
                inputStreamH.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private void c() {
        if (!this.f3154i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    private static byte[] d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 24 || i2 > 34) {
            return null;
        }
        switch (i2) {
            case 24:
            case 25:
                return q.f3199e;
            case 26:
                return q.f3198d;
            case 27:
                return q.f3197c;
            case 28:
            case 29:
            case 30:
                return q.f3196b;
            case 31:
            case 32:
            case 33:
            case 34:
                return q.f3195a;
            default:
                return null;
        }
    }

    private InputStream f(AssetManager assetManager) {
        j.c cVar;
        int i2;
        try {
            return h(assetManager, this.f3152g);
        } catch (FileNotFoundException e2) {
            e = e2;
            cVar = this.f3148c;
            i2 = 6;
            cVar.b(i2, e);
            return null;
        } catch (IOException e3) {
            e = e3;
            cVar = this.f3148c;
            i2 = 7;
            cVar.b(i2, e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i2, Object obj) {
        this.f3148c.b(i2, obj);
    }

    private InputStream h(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e2) {
            String message = e2.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f3148c.a(5, null);
            }
            return null;
        }
    }

    private e[] j(InputStream inputStream) {
        try {
            try {
                try {
                    try {
                        e[] eVarArrW = o.w(inputStream, o.o(inputStream, o.f3183a), this.f3151f);
                        try {
                            inputStream.close();
                            return eVarArrW;
                        } catch (IOException e2) {
                            this.f3148c.b(7, e2);
                            return eVarArrW;
                        }
                    } catch (IOException e3) {
                        this.f3148c.b(7, e3);
                        return null;
                    }
                } catch (IllegalStateException e4) {
                    this.f3148c.b(8, e4);
                    inputStream.close();
                    return null;
                }
            } catch (IOException e5) {
                this.f3148c.b(7, e5);
                inputStream.close();
                return null;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e6) {
                this.f3148c.b(7, e6);
            }
            throw th;
        }
    }

    private static boolean k() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 24 || i2 > 34) {
            return false;
        }
        if (i2 != 24 && i2 != 25) {
            switch (i2) {
                case 31:
                case 32:
                case 33:
                case 34:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private void l(final int i2, final Object obj) {
        this.f3147b.execute(new Runnable() { // from class: androidx.profileinstaller.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f3143a.g(i2, obj);
            }
        });
    }

    public boolean e() {
        if (this.f3149d == null) {
            l(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.f3150e.exists()) {
            try {
                this.f3150e.createNewFile();
            } catch (IOException unused) {
                l(4, null);
                return false;
            }
        } else if (!this.f3150e.canWrite()) {
            l(4, null);
            return false;
        }
        this.f3154i = true;
        return true;
    }

    public d i() {
        d dVarB;
        c();
        if (this.f3149d == null) {
            return this;
        }
        InputStream inputStreamF = f(this.f3146a);
        if (inputStreamF != null) {
            this.f3155j = j(inputStreamF);
        }
        e[] eVarArr = this.f3155j;
        return (eVarArr == null || !k() || (dVarB = b(eVarArr, this.f3149d)) == null) ? this : dVarB;
    }

    public d m() {
        j.c cVar;
        int i2;
        ByteArrayOutputStream byteArrayOutputStream;
        e[] eVarArr = this.f3155j;
        byte[] bArr = this.f3149d;
        if (eVarArr != null && bArr != null) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    o.E(byteArrayOutputStream, bArr);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                cVar = this.f3148c;
                i2 = 7;
                cVar.b(i2, e);
            } catch (IllegalStateException e3) {
                e = e3;
                cVar = this.f3148c;
                i2 = 8;
                cVar.b(i2, e);
            }
            if (!o.B(byteArrayOutputStream, bArr, eVarArr)) {
                this.f3148c.b(5, null);
                this.f3155j = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.f3156k = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.f3155j = null;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean n() {
        byte[] bArr = this.f3156k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f3150e);
                    try {
                        f.l(byteArrayInputStream, fileOutputStream);
                        l(1, null);
                        fileOutputStream.close();
                        byteArrayInputStream.close();
                        return true;
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } finally {
                this.f3156k = null;
                this.f3155j = null;
            }
        } catch (FileNotFoundException e2) {
            l(6, e2);
            return false;
        } catch (IOException e3) {
            l(7, e3);
            return false;
        }
    }
}
