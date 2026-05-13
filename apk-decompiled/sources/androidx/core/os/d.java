package androidx.core.os;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class d implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Locale[] f2243c = new Locale[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Locale f2244d = new Locale("en", "XA");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Locale f2245e = new Locale("ar", "XB");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Locale f2246f = c.b("en-Latn");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Locale[] f2247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2248b;

    d(Locale... localeArr) {
        String string;
        if (localeArr.length == 0) {
            this.f2247a = f2243c;
            string = "";
        } else {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < localeArr.length; i2++) {
                Locale locale = localeArr[i2];
                if (locale == null) {
                    throw new NullPointerException("list[" + i2 + "] is null");
                }
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    arrayList.add(locale2);
                    c(sb, locale2);
                    if (i2 < localeArr.length - 1) {
                        sb.append(',');
                    }
                    hashSet.add(locale2);
                }
            }
            this.f2247a = (Locale[]) arrayList.toArray(new Locale[0]);
            string = sb.toString();
        }
        this.f2248b = string;
    }

    static void c(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            return;
        }
        sb.append('-');
        sb.append(locale.getCountry());
    }

    @Override // androidx.core.os.e
    public Object a() {
        return null;
    }

    @Override // androidx.core.os.e
    public String b() {
        return this.f2248b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        Locale[] localeArr = ((d) obj).f2247a;
        if (this.f2247a.length != localeArr.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            Locale[] localeArr2 = this.f2247a;
            if (i2 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i2].equals(localeArr[i2])) {
                return false;
            }
            i2++;
        }
    }

    @Override // androidx.core.os.e
    public Locale get(int i2) {
        if (i2 >= 0) {
            Locale[] localeArr = this.f2247a;
            if (i2 < localeArr.length) {
                return localeArr[i2];
            }
        }
        return null;
    }

    public int hashCode() {
        int iHashCode = 1;
        for (Locale locale : this.f2247a) {
            iHashCode = (iHashCode * 31) + locale.hashCode();
        }
        return iHashCode;
    }

    @Override // androidx.core.os.e
    public boolean isEmpty() {
        return this.f2247a.length == 0;
    }

    @Override // androidx.core.os.e
    public int size() {
        return this.f2247a.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.f2247a;
            if (i2 >= localeArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(localeArr[i2]);
            if (i2 < this.f2247a.length - 1) {
                sb.append(',');
            }
            i2++;
        }
    }
}
