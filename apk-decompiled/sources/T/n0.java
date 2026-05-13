package T;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class n0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Method f321b = c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Method f322c = d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile p0 f323d = o0.f327a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JobScheduler f324a;

    private n0(JobScheduler jobScheduler) {
        this.f324a = jobScheduler;
    }

    private final int a(JobInfo jobInfo, String str, int i2, String str2) {
        Method method = f321b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f324a, jobInfo, str, Integer.valueOf(i2), str2)).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return this.f324a.schedule(jobInfo);
    }

    public static int b(Context context, JobInfo jobInfo, String str, String str2) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        return (f321b != null && f323d.a() && context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") == 0) ? new n0(jobScheduler).a(jobInfo, str, e(), str2) : jobScheduler.schedule(jobInfo);
    }

    private static Method c() {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        try {
            return JobScheduler.class.getDeclaredMethod("scheduleAsPackage", JobInfo.class, String.class, Integer.TYPE, String.class);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static Method d() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return UserHandle.class.getDeclaredMethod("myUserId", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        return null;
    }

    private static int e() {
        Method method = f322c;
        if (method == null) {
            return 0;
        }
        try {
            return ((Integer) method.invoke(null, null)).intValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return 0;
        }
    }

    static final /* synthetic */ boolean f() {
        return false;
    }
}
