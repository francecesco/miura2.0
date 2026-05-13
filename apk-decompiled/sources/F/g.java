package F;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    public static String a(Object obj) {
        return b(obj, 0);
    }

    private static String b(Object obj, int i2) {
        if (i2 > 10) {
            return "ERROR: Recursive toString calls";
        }
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return TextUtils.isEmpty((String) obj) ? "" : obj.toString();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0 ? "" : obj.toString();
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue() == 0 ? "" : obj.toString();
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue() == 0.0d ? "" : obj.toString();
        }
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue() ? "" : obj.toString();
        }
        if (obj instanceof List) {
            StringBuilder sb = new StringBuilder();
            if (i2 > 0) {
                sb.append("[");
            }
            int length = sb.length();
            for (Object obj2 : (List) obj) {
                if (sb.length() > length) {
                    sb.append(", ");
                }
                sb.append(b(obj2, i2 + 1));
            }
            if (i2 > 0) {
                sb.append("]");
            }
            return sb.toString();
        }
        if (!(obj instanceof Map)) {
            return obj.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = false;
        int length2 = 0;
        for (Map.Entry entry : new TreeMap((Map) obj).entrySet()) {
            String strB = b(entry.getValue(), i2 + 1);
            if (!TextUtils.isEmpty(strB)) {
                if (i2 > 0 && !z2) {
                    sb2.append("{");
                    length2 = sb2.length();
                    z2 = true;
                }
                if (sb2.length() > length2) {
                    sb2.append(", ");
                }
                sb2.append((String) entry.getKey());
                sb2.append('=');
                sb2.append(strB);
            }
        }
        if (z2) {
            sb2.append("}");
        }
        return sb2.toString();
    }
}
