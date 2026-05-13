package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends androidx.core.content.a {

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f2003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f2004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f2005c;

        a(String[] strArr, Activity activity, int i2) {
            this.f2003a = strArr;
            this.f2004b = activity;
            this.f2005c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f2003a.length];
            PackageManager packageManager = this.f2004b.getPackageManager();
            String packageName = this.f2004b.getPackageName();
            int length = this.f2003a.length;
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = packageManager.checkPermission(this.f2003a[i2], packageName);
            }
            ((c) this.f2004b).onRequestPermissionsResult(this.f2005c, this.f2003a, iArr);
        }
    }

    /* JADX INFO: renamed from: androidx.core.app.b$b, reason: collision with other inner class name */
    static class C0029b {
        static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        static void b(Activity activity, String[] strArr, int i2) {
            activity.requestPermissions(strArr, i2);
        }

        static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public interface c {
        void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);
    }

    public interface d {
        void b(int i2);
    }

    public static void h(Activity activity) {
        activity.finishAffinity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Activity activity) {
        if (activity.isFinishing() || androidx.core.app.d.i(activity)) {
            return;
        }
        activity.recreate();
    }

    public static void j(final Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new Runnable() { // from class: androidx.core.app.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.i(activity);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void k(Activity activity, String[] strArr, int i2) {
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (TextUtils.isEmpty(strArr[i3])) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i3], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i3));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i4 = 0;
            for (int i5 = 0; i5 < strArr.length; i5++) {
                if (!hashSet.contains(Integer.valueOf(i5))) {
                    strArr2[i4] = strArr[i5];
                    i4++;
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof d) {
                ((d) activity).b(i2);
            }
            C0029b.b(activity, strArr, i2);
        } else if (activity instanceof c) {
            new Handler(Looper.getMainLooper()).post(new a(strArr2, activity, i2));
        }
    }

    public static void l(Activity activity, Intent intent, int i2, Bundle bundle) {
        activity.startActivityForResult(intent, i2, bundle);
    }

    public static void m(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }
}
