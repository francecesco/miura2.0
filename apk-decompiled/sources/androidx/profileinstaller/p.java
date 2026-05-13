package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import it.tervis.miura.model.Peripheral;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final androidx.concurrent.futures.c f3185a = androidx.concurrent.futures.c.o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f3186b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static c f3187c = null;

    private static class a {
        static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f3188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f3189b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f3190c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final long f3191d;

        b(int i2, int i3, long j2, long j3) {
            this.f3188a = i2;
            this.f3189b = i3;
            this.f3190c = j2;
            this.f3191d = j3;
        }

        static b a(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        void b(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f3188a);
                dataOutputStream.writeInt(this.f3189b);
                dataOutputStream.writeLong(this.f3190c);
                dataOutputStream.writeLong(this.f3191d);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f3189b == bVar.f3189b && this.f3190c == bVar.f3190c && this.f3188a == bVar.f3188a && this.f3191d == bVar.f3191d;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f3189b), Long.valueOf(this.f3190c), Integer.valueOf(this.f3188a), Long.valueOf(this.f3191d));
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f3192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f3193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f3194c;

        c(int i2, boolean z2, boolean z3) {
            this.f3192a = i2;
            this.f3194c = z3;
            this.f3193b = z2;
        }
    }

    private static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return (Build.VERSION.SDK_INT >= 33 ? a.a(packageManager, context) : packageManager.getPackageInfo(context.getPackageName(), 0)).lastUpdateTime;
    }

    private static c b(int i2, boolean z2, boolean z3) {
        c cVar = new c(i2, z2, z3);
        f3187c = cVar;
        f3185a.m(cVar);
        return f3187c;
    }

    static c c(Context context, boolean z2) {
        b bVarA;
        int i2;
        c cVar;
        if (!z2 && (cVar = f3187c) != null) {
            return cVar;
        }
        synchronized (f3186b) {
            if (!z2) {
                try {
                    c cVar2 = f3187c;
                    if (cVar2 != null) {
                        return cVar2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int i3 = Build.VERSION.SDK_INT;
            int i4 = 0;
            if (i3 >= 28 && i3 != 30) {
                File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                long length = file.length();
                boolean z3 = file.exists() && length > 0;
                File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                long length2 = file2.length();
                boolean z4 = file2.exists() && length2 > 0;
                try {
                    long jA = a(context);
                    File file3 = new File(context.getFilesDir(), "profileInstalled");
                    if (file3.exists()) {
                        try {
                            bVarA = b.a(file3);
                        } catch (IOException unused) {
                            return b(Peripheral.EXPANSION_9, z3, z4);
                        }
                    } else {
                        bVarA = null;
                    }
                    if (bVarA != null && bVarA.f3190c == jA && (i2 = bVarA.f3189b) != 2) {
                        i4 = i2;
                    } else if (z3) {
                        i4 = 1;
                    } else if (z4) {
                        i4 = 2;
                    }
                    if (z2 && z4 && i4 != 1) {
                        i4 = 2;
                    }
                    if (bVarA != null && bVarA.f3189b == 2 && i4 == 1 && length < bVarA.f3191d) {
                        i4 = 3;
                    }
                    b bVar = new b(1, i4, jA, length2);
                    if (bVarA == null || !bVarA.equals(bVar)) {
                        try {
                            bVar.b(file3);
                        } catch (IOException unused2) {
                            i4 = 196608;
                        }
                    }
                    return b(i4, z3, z4);
                } catch (PackageManager.NameNotFoundException unused3) {
                    return b(Peripheral.EXPANSION_8, z3, z4);
                }
            }
            return b(Peripheral.EXPANSION_10, false, false);
        }
    }
}
