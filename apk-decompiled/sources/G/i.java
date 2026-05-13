package G;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.TypedValue;
import androidx.core.app.k;
import androidx.fragment.app.AbstractActivityC0171j;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.base.R$string;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: loaded from: classes.dex */
public class i extends j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f45d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final i f46e = new i();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f47f = j.f51a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f48c;

    private class a extends R.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f49a;

        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f49a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i2);
            } else {
                int iE = i.this.e(this.f49a);
                if (i.this.g(iE)) {
                    i.this.m(this.f49a, iE);
                }
            }
        }
    }

    i() {
    }

    public static i k() {
        return f46e;
    }

    static Dialog n(Context context, int i2, K.b bVar, DialogInterface.OnCancelListener onCancelListener) {
        if (i2 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(K.a.d(context, i2));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String strC = K.a.c(context, i2);
        if (strC != null) {
            builder.setPositiveButton(strC, bVar);
        }
        String strG = K.a.g(context, i2);
        if (strG != null) {
            builder.setTitle(strG);
        }
        return builder.create();
    }

    static void o(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof AbstractActivityC0171j) {
            n.Y1(dialog, onCancelListener).X1(((AbstractActivityC0171j) activity).f0(), str);
        } else {
            b.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        }
    }

    private final void q(Context context, int i2, String str, PendingIntent pendingIntent) {
        int i3;
        if (i2 == 18) {
            p(context);
            return;
        }
        if (pendingIntent == null) {
            return;
        }
        String strF = K.a.f(context, i2);
        String strE = K.a.e(context, i2);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        k.d dVarN = new k.d(context).k(true).e(true).i(strF).n(new k.b().h(strE));
        if (O.e.b(context)) {
            K.e.h(O.h.d());
            dVarN.m(context.getApplicationInfo().icon).l(2);
            if (O.e.c(context)) {
                dVarN.a(R$drawable.common_full_open_on_phone, resources.getString(R$string.common_open_on_phone), pendingIntent);
            } else {
                dVarN.g(pendingIntent);
            }
        } else {
            dVarN.m(R.drawable.stat_sys_warning).o(resources.getString(R$string.common_google_play_services_notification_ticker)).p(System.currentTimeMillis()).g(pendingIntent).h(strE);
        }
        if (O.h.g()) {
            K.e.h(O.h.g());
            String strS = s();
            if (strS == null) {
                strS = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String strB = K.a.b(context);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(h.a("com.google.android.gms.availability", strB, 4));
                } else if (!strB.equals(notificationChannel.getName())) {
                    notificationChannel.setName(strB);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            dVarN.f(strS);
        }
        Notification notificationB = dVarN.b();
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            l.f55b.set(false);
            i3 = 10436;
        } else {
            i3 = 39789;
        }
        notificationManager.notify(i3, notificationB);
    }

    private final String s() {
        String str;
        synchronized (f45d) {
            str = this.f48c;
        }
        return str;
    }

    @Override // G.j
    public Intent a(Context context, int i2, String str) {
        return super.a(context, i2, str);
    }

    @Override // G.j
    public PendingIntent b(Context context, int i2, int i3) {
        return super.b(context, i2, i3);
    }

    @Override // G.j
    public final String d(int i2) {
        return super.d(i2);
    }

    @Override // G.j
    public int e(Context context) {
        return super.e(context);
    }

    @Override // G.j
    public int f(Context context, int i2) {
        return super.f(context, i2);
    }

    @Override // G.j
    public final boolean g(int i2) {
        return super.g(i2);
    }

    public Dialog i(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return n(activity, i2, K.b.a(activity, a(activity, i2, "d"), i3), onCancelListener);
    }

    public PendingIntent j(Context context, G.a aVar) {
        return aVar.d() ? aVar.c() : b(context, aVar.a(), 0);
    }

    public boolean l(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogI = i(activity, i2, i3, onCancelListener);
        if (dialogI == null) {
            return false;
        }
        o(activity, dialogI, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void m(Context context, int i2) {
        q(context, i2, null, c(context, i2, 0, "n"));
    }

    final void p(Context context) {
        new a(context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean r(Context context, G.a aVar, int i2) {
        PendingIntent pendingIntentJ = j(context, aVar);
        if (pendingIntentJ == null) {
            return false;
        }
        q(context, aVar.a(), null, GoogleApiActivity.a(context, pendingIntentJ, i2));
        return true;
    }
}
