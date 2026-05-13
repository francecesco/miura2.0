package j0;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import it.tervis.miura.model.Configuration;
import it.tervis.miura.model.ConfigurationList;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f3789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f3790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConfigurationList f3791c;

    public static void a() {
        if (h() == null || h().length() <= 0) {
            return;
        }
        d.a("Found existing configuration: " + h() + ":" + l());
        f3791c = new ConfigurationList();
        Configuration configuration = new Configuration();
        configuration.setHost(h());
        configuration.setPort(l());
        configuration.setPin(k());
        configuration.setBoardCallerID(e());
        f3791c.getConfigurations().add(configuration);
        p();
        c().remove(".hostname").remove(".port").remove(".pin").remove(".callerid").commit();
    }

    private static String b(String str) {
        String strA = c.a(j.j(str), f3790b);
        d.a("Decrypting " + str + " to " + strA);
        return strA;
    }

    private static SharedPreferences.Editor c() {
        return m().edit();
    }

    private static String d(String str) {
        String strA = j.a(c.c(str, f3790b));
        d.a("Encrypting " + str + " to " + strA);
        return strA;
    }

    public static String e() {
        return m().getString(".callerid", "");
    }

    public static ConfigurationList f() {
        if (f3791c == null) {
            try {
                String strB = b(m().getString(".configlist", null));
                d.a("Loading configuration list: " + strB);
                f3791c = ConfigurationList.fromXML(strB);
            } catch (Exception unused) {
                f3791c = new ConfigurationList();
                p();
            }
        }
        return f3791c;
    }

    public static String g() {
        return f3790b;
    }

    private static String h() {
        try {
            d.a("Context: " + f3789a);
            d.a("Encrypted host: " + m().getString(".hostname", null) + " " + f3790b);
            return b(m().getString(".hostname", null));
        } catch (Exception unused) {
            d.a("No host saved");
            return null;
        }
    }

    public static long i() {
        return m().getLong(".lastaccess", 0L);
    }

    public static boolean j() {
        return m().getBoolean(".loadtexts", false);
    }

    private static String k() {
        try {
            return b(m().getString(".pin", "0000"));
        } catch (Exception unused) {
            d.a("No pin saved");
            return null;
        }
    }

    private static int l() {
        try {
            return m().getInt(".port", 5400);
        } catch (Exception unused) {
            d.a("No port saved");
            return 0;
        }
    }

    private static SharedPreferences m() {
        return PreferenceManager.getDefaultSharedPreferences(f3789a);
    }

    public static boolean n(String str) {
        try {
            String strE = c.e(str);
            f3790b = strE;
            d.a("User code: " + strE);
            d.a("Encrypted saved code: " + m().getString(".access", ""));
            d.a("Saved code: " + b(m().getString(".access", "")));
            boolean zEquals = b(m().getString(".access", "")).equals(strE);
            if (zEquals) {
                f3790b = strE;
            } else {
                f3790b = null;
            }
            d.a("Access granted? " + zEquals);
            return zEquals;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean o() {
        return m().getString(".access", null) != null;
    }

    public static void p() {
        String xml = f3791c.toXML();
        d.a("Saving configuration list: " + xml);
        boolean zCommit = c().putString(".configlist", d(xml)).commit();
        c().putString(".smsmapping", j.a(f3791c.getSMSMapping().toXML().getBytes())).commit();
        d.a("Saved? " + zCommit);
    }

    public static void q(String str) {
        String strE = c.e(str);
        d.a("Will set user code as: " + strE);
        c().putString(".access", j.a(c.c(strE, strE))).commit();
    }

    public static void r(Context context) {
        f3789a = context;
    }

    public static void s(long j2) {
        c().putLong(".lastaccess", j2).commit();
    }

    public static void t(boolean z2) {
        c().putBoolean(".loadtexts", z2).commit();
    }

    public static void u(boolean z2) {
        c().putBoolean(".firstexecutionfull", z2).commit();
    }
}
