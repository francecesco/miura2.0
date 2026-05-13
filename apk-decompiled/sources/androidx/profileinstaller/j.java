package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f3176a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final c f3177b = new b();

    class a implements c {
        a() {
        }

        @Override // androidx.profileinstaller.j.c
        public void a(int i2, Object obj) {
        }

        @Override // androidx.profileinstaller.j.c
        public void b(int i2, Object obj) {
        }
    }

    class b implements c {
        b() {
        }

        @Override // androidx.profileinstaller.j.c
        public void a(int i2, Object obj) {
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0000. Please report as an issue. */
        @Override // androidx.profileinstaller.j.c
        public void b(int i2, Object obj) {
            switch (i2) {
            }
            if (i2 == 6 || i2 == 7 || i2 == 8) {
            }
        }
    }

    public interface c {
        void a(int i2, Object obj);

        void b(int i2, Object obj);
    }

    static boolean b(File file) {
        return new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
    }

    static void c(Context context, Executor executor, c cVar) {
        b(context.getFilesDir());
        g(executor, cVar, 11, null);
    }

    static boolean d(PackageInfo packageInfo, File file, c cVar) {
        File file2 = new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        if (!file2.exists()) {
            return false;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file2));
            try {
                long j2 = dataInputStream.readLong();
                dataInputStream.close();
                boolean z2 = j2 == packageInfo.lastUpdateTime;
                if (z2) {
                    cVar.b(2, null);
                }
                return z2;
            } finally {
            }
        } catch (IOException unused) {
            return false;
        }
    }

    static void f(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    static void g(Executor executor, final c cVar, final int i2, final Object obj) {
        executor.execute(new Runnable() { // from class: androidx.profileinstaller.i
            @Override // java.lang.Runnable
            public final void run() {
                cVar.b(i2, obj);
            }
        });
    }

    private static boolean h(AssetManager assetManager, String str, PackageInfo packageInfo, File file, String str2, Executor executor, c cVar) {
        d dVar = new d(assetManager, executor, cVar, str2, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", str), "primary.prof"));
        if (!dVar.e()) {
            return false;
        }
        boolean zN = dVar.i().m().n();
        if (zN) {
            f(packageInfo, file);
        }
        return zN;
    }

    public static void i(Context context) {
        j(context, new h(), f3176a);
    }

    public static void j(Context context, Executor executor, c cVar) {
        k(context, executor, cVar, false);
    }

    static void k(Context context, Executor executor, c cVar, boolean z2) {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z3 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (z2 || !d(packageInfo, filesDir, cVar)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Installing profile for ");
                sb.append(context.getPackageName());
                if (h(assets, packageName, packageInfo, filesDir, name, executor, cVar) && z2) {
                    z3 = true;
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Skipping profile installation for ");
                sb2.append(context.getPackageName());
            }
            p.c(context, z3);
        } catch (PackageManager.NameNotFoundException e2) {
            cVar.b(7, e2);
            p.c(context, false);
        }
    }

    static void l(Context context, Executor executor, c cVar) {
        try {
            f(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            g(executor, cVar, 10, null);
        } catch (PackageManager.NameNotFoundException e2) {
            g(executor, cVar, 7, e2);
        }
    }
}
