package t0;

import l0.AbstractC0221e;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class m extends l {
    public static final int d(CharSequence charSequence) {
        q0.f.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int e(CharSequence charSequence, String str, int i2, boolean z2) {
        q0.f.e(charSequence, "<this>");
        q0.f.e(str, "string");
        return (z2 || !(charSequence instanceof String)) ? g(charSequence, str, i2, charSequence.length(), z2, false, 16, null) : ((String) charSequence).indexOf(str, i2);
    }

    private static final int f(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z2, boolean z3) {
        r0.a cVar = !z3 ? new r0.c(r0.d.a(i2, 0), r0.d.b(i3, charSequence.length())) : r0.d.c(r0.d.b(i2, d(charSequence)), r0.d.a(i3, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iA = cVar.a();
            int iB = cVar.b();
            int iC = cVar.c();
            if ((iC <= 0 || iA > iB) && (iC >= 0 || iB > iA)) {
                return -1;
            }
            while (!l.a((String) charSequence2, 0, (String) charSequence, iA, charSequence2.length(), z2)) {
                if (iA == iB) {
                    return -1;
                }
                iA += iC;
            }
            return iA;
        }
        int iA2 = cVar.a();
        int iB2 = cVar.b();
        int iC2 = cVar.c();
        if ((iC2 <= 0 || iA2 > iB2) && (iC2 >= 0 || iB2 > iA2)) {
            return -1;
        }
        while (!k(charSequence2, 0, charSequence, iA2, charSequence2.length(), z2)) {
            if (iA2 == iB2) {
                return -1;
            }
            iA2 += iC2;
        }
        return iA2;
    }

    static /* synthetic */ int g(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z2, boolean z3, int i4, Object obj) {
        return f(charSequence, charSequence2, i2, i3, z2, (i4 & 16) != 0 ? false : z3);
    }

    public static final int h(CharSequence charSequence, char c2, int i2, boolean z2) {
        q0.f.e(charSequence, "<this>");
        return (z2 || !(charSequence instanceof String)) ? j(charSequence, new char[]{c2}, i2, z2) : ((String) charSequence).lastIndexOf(c2, i2);
    }

    public static /* synthetic */ int i(CharSequence charSequence, char c2, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = d(charSequence);
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return h(charSequence, c2, i2, z2);
    }

    public static final int j(CharSequence charSequence, char[] cArr, int i2, boolean z2) {
        q0.f.e(charSequence, "<this>");
        q0.f.e(cArr, "chars");
        if (!z2 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(AbstractC0221e.i(cArr), i2);
        }
        for (int iB = r0.d.b(i2, d(charSequence)); -1 < iB; iB--) {
            char cCharAt = charSequence.charAt(iB);
            for (char c2 : cArr) {
                if (b.a(c2, cCharAt, z2)) {
                    return iB;
                }
            }
        }
        return -1;
    }

    public static final boolean k(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4, boolean z2) {
        q0.f.e(charSequence, "<this>");
        q0.f.e(charSequence2, "other");
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > charSequence2.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!b.a(charSequence.charAt(i2 + i5), charSequence2.charAt(i3 + i5), z2)) {
                return false;
            }
        }
        return true;
    }

    public static final String l(String str, char c2, String str2) {
        q0.f.e(str, "<this>");
        q0.f.e(str2, "missingDelimiterValue");
        int i2 = i(str, c2, 0, false, 6, null);
        if (i2 == -1) {
            return str2;
        }
        String strSubstring = str.substring(i2 + 1, str.length());
        q0.f.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String m(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return l(str, c2, str2);
    }
}
