package K;

import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.base.R$string;
import it.tervis.miura.model.Console;
import k.C0213g;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0213g f100a = new C0213g();

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return P.b.a(context).d(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context) {
        return context.getResources().getString(R$string.common_google_play_services_notification_channel_name);
    }

    public static String c(Context context, int i2) {
        return context.getResources().getString(i2 != 1 ? i2 != 2 ? i2 != 3 ? R.string.ok : R$string.common_google_play_services_enable_button : R$string.common_google_play_services_update_button : R$string.common_google_play_services_install_button);
    }

    public static String d(Context context, int i2) {
        Resources resources = context.getResources();
        String strA = a(context);
        if (i2 == 1) {
            return resources.getString(R$string.common_google_play_services_install_text, strA);
        }
        if (i2 == 2) {
            return O.e.c(context) ? resources.getString(R$string.common_google_play_services_wear_update_text) : resources.getString(R$string.common_google_play_services_update_text, strA);
        }
        if (i2 == 3) {
            return resources.getString(R$string.common_google_play_services_enable_text, strA);
        }
        if (i2 == 5) {
            return i(context, "common_google_play_services_invalid_account_text", strA);
        }
        if (i2 == 7) {
            return i(context, "common_google_play_services_network_error_text", strA);
        }
        if (i2 == 9) {
            return resources.getString(R$string.common_google_play_services_unsupported_text, strA);
        }
        if (i2 == 20) {
            return i(context, "common_google_play_services_restricted_profile_text", strA);
        }
        switch (i2) {
            case 16:
                return i(context, "common_google_play_services_api_unavailable_text", strA);
            case 17:
                return i(context, "common_google_play_services_sign_in_failed_text", strA);
            case 18:
                return resources.getString(R$string.common_google_play_services_updating_text, strA);
            default:
                return resources.getString(com.google.android.gms.common.R$string.common_google_play_services_unknown_issue, strA);
        }
    }

    public static String e(Context context, int i2) {
        return i2 == 6 ? i(context, "common_google_play_services_resolution_required_text", a(context)) : d(context, i2);
    }

    public static String f(Context context, int i2) {
        String strH = i2 == 6 ? h(context, "common_google_play_services_resolution_required_title") : g(context, i2);
        return strH == null ? context.getResources().getString(R$string.common_google_play_services_notification_ticker) : strH;
    }

    public static String g(Context context, int i2) {
        Resources resources = context.getResources();
        switch (i2) {
            case 1:
                return resources.getString(R$string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R$string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R$string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                return h(context, "common_google_play_services_invalid_account_title");
            case Console.MAX_CONSOLE /* 7 */:
                return h(context, "common_google_play_services_network_error_title");
            case 8:
            case 9:
            case 10:
            case 11:
            case 16:
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unexpected error code ");
                sb.append(i2);
                return null;
            case 17:
                return h(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                return h(context, "common_google_play_services_restricted_profile_title");
        }
    }

    private static String h(Context context, String str) {
        C0213g c0213g = f100a;
        synchronized (c0213g) {
            try {
                String str2 = (String) c0213g.get(str);
                if (str2 != null) {
                    return str2;
                }
                Resources resourcesB = G.k.b(context);
                if (resourcesB == null) {
                    return null;
                }
                int identifier = resourcesB.getIdentifier(str, "string", "com.google.android.gms");
                if (identifier == 0) {
                    String strValueOf = String.valueOf(str);
                    if (strValueOf.length() != 0) {
                        "Missing resource: ".concat(strValueOf);
                    }
                    return null;
                }
                String string = resourcesB.getString(identifier);
                if (!TextUtils.isEmpty(string)) {
                    c0213g.put(str, string);
                    return string;
                }
                String strValueOf2 = String.valueOf(str);
                if (strValueOf2.length() != 0) {
                    "Got empty resource: ".concat(strValueOf2);
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static String i(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String strH = h(context, str);
        if (strH == null) {
            strH = resources.getString(com.google.android.gms.common.R$string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, strH, str2);
    }
}
