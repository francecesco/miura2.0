package O;

import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f141b;

    public static String a() {
        if (f140a == null) {
            if (f141b == 0) {
                f141b = Process.myPid();
            }
            f140a = b(f141b);
        }
        return f140a;
    }

    private static String b(int i2) throws Throwable {
        Throwable th;
        BufferedReader bufferedReaderC;
        String strTrim = null;
        if (i2 <= 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(25);
            sb.append("/proc/");
            sb.append(i2);
            sb.append("/cmdline");
            bufferedReaderC = c(sb.toString());
            try {
                strTrim = bufferedReaderC.readLine().trim();
            } catch (IOException unused) {
            } catch (Throwable th2) {
                th = th2;
                g.a(bufferedReaderC);
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReaderC = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReaderC = null;
        }
        g.a(bufferedReaderC);
        return strTrim;
    }

    private static BufferedReader c(String str) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }
}
