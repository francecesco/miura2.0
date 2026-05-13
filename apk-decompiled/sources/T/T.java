package T;

import android.text.TextUtils;
import it.tervis.miura.model.Peripheral;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f236g;

    public T(AbstractC0082e abstractC0082e, Map map, long j2, boolean z2, long j3, int i2) {
        this(abstractC0082e, map, j2, z2, j3, i2, null);
    }

    private static String a(AbstractC0082e abstractC0082e, Object obj) {
        if (obj == null) {
            return null;
        }
        String string = obj.toString();
        if (string.startsWith("&")) {
            string = string.substring(1);
        }
        int length = string.length();
        if (length > 256) {
            string = string.substring(0, Peripheral.CONSOLE_8);
            abstractC0082e.o("Hit param name is too long and will be trimmed", Integer.valueOf(length), string);
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    private static String b(AbstractC0082e abstractC0082e, Object obj) {
        String string = obj == null ? "" : obj.toString();
        int length = string.length();
        if (length <= 8192) {
            return string;
        }
        String strSubstring = string.substring(0, Peripheral.EXPANSION_5);
        abstractC0082e.o("Hit param value is too long and will be trimmed", Integer.valueOf(length), strSubstring);
        return strSubstring;
    }

    private static boolean c(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().startsWith("&");
    }

    private final String e(String str, String str2) {
        K.e.d(str);
        K.e.b(!str.startsWith("&"), "Short param name required");
        String str3 = (String) this.f230a.get(str);
        return str3 != null ? str3 : str2;
    }

    public final Map d() {
        return this.f230a;
    }

    public final long f() {
        return this.f232c;
    }

    public final long g() {
        return this.f233d;
    }

    public final boolean h() {
        return this.f235f;
    }

    public final long i() {
        return l0.c(e("_s", "0"));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ht=");
        sb.append(this.f233d);
        if (this.f232c != 0) {
            sb.append(", dbId=");
            sb.append(this.f232c);
        }
        if (this.f234e != 0) {
            sb.append(", appUID=");
            sb.append(this.f234e);
        }
        ArrayList arrayList = new ArrayList(this.f230a.keySet());
        Collections.sort(arrayList);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            String str = (String) obj;
            sb.append(", ");
            sb.append(str);
            sb.append("=");
            sb.append((String) this.f230a.get(str));
        }
        return sb.toString();
    }

    public T(AbstractC0082e abstractC0082e, Map map, long j2, boolean z2, long j3, int i2, List list) {
        String strB;
        String strA;
        String strA2;
        K.e.f(abstractC0082e);
        K.e.f(map);
        this.f233d = j2;
        this.f235f = z2;
        this.f232c = j3;
        this.f234e = i2;
        this.f231b = list != null ? list : Collections.emptyList();
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                C0102z c0102z = (C0102z) it2.next();
                if ("appendVersion".equals(c0102z.a())) {
                    strB = c0102z.b();
                    break;
                }
            }
            strB = null;
        } else {
            strB = null;
        }
        this.f236g = TextUtils.isEmpty(strB) ? null : strB;
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (c(entry.getKey()) && (strA2 = a(abstractC0082e, entry.getKey())) != null) {
                map2.put(strA2, b(abstractC0082e, entry.getValue()));
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (!c(entry2.getKey()) && (strA = a(abstractC0082e, entry2.getKey())) != null) {
                map2.put(strA, b(abstractC0082e, entry2.getValue()));
            }
        }
        if (!TextUtils.isEmpty(this.f236g)) {
            l0.e(map2, "_v", this.f236g);
            if (this.f236g.equals("ma4.0.0") || this.f236g.equals("ma4.0.1")) {
                map2.remove("adid");
            }
        }
        this.f230a = Collections.unmodifiableMap(map2);
    }
}
