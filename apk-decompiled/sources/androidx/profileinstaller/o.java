package androidx.profileinstaller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f3183a = {112, 114, 111, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final byte[] f3184b = {112, 114, 109, 0};

    private static void A(InputStream inputStream) {
        f.h(inputStream);
        int iJ = f.j(inputStream);
        if (iJ == 6 || iJ == 7) {
            return;
        }
        while (iJ > 0) {
            f.j(inputStream);
            for (int iJ2 = f.j(inputStream); iJ2 > 0; iJ2--) {
                f.h(inputStream);
            }
            iJ--;
        }
    }

    static boolean B(OutputStream outputStream, byte[] bArr, e[] eVarArr) throws IOException {
        if (Arrays.equals(bArr, q.f3195a)) {
            N(outputStream, eVarArr);
            return true;
        }
        if (Arrays.equals(bArr, q.f3196b)) {
            M(outputStream, eVarArr);
            return true;
        }
        if (Arrays.equals(bArr, q.f3198d)) {
            K(outputStream, eVarArr);
            return true;
        }
        if (Arrays.equals(bArr, q.f3197c)) {
            L(outputStream, eVarArr);
            return true;
        }
        if (!Arrays.equals(bArr, q.f3199e)) {
            return false;
        }
        J(outputStream, eVarArr);
        return true;
    }

    private static void C(OutputStream outputStream, e eVar) throws IOException {
        int[] iArr = eVar.f3164h;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = iArr[i2];
            f.p(outputStream, i4 - i3);
            i2++;
            i3 = i4;
        }
    }

    private static r D(e[] eVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f.p(byteArrayOutputStream, eVarArr.length);
            int i2 = 2;
            for (e eVar : eVarArr) {
                f.q(byteArrayOutputStream, eVar.f3159c);
                f.q(byteArrayOutputStream, eVar.f3160d);
                f.q(byteArrayOutputStream, eVar.f3163g);
                String strJ = j(eVar.f3157a, eVar.f3158b, q.f3195a);
                int iK = f.k(strJ);
                f.p(byteArrayOutputStream, iK);
                i2 = i2 + 14 + iK;
                f.n(byteArrayOutputStream, strJ);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i2 == byteArray.length) {
                r rVar = new r(g.DEX_FILES, i2, byteArray, false);
                byteArrayOutputStream.close();
                return rVar;
            }
            throw f.c("Expected size " + i2 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    static void E(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(f3183a);
        outputStream.write(bArr);
    }

    private static void F(OutputStream outputStream, e eVar) throws IOException {
        I(outputStream, eVar);
        C(outputStream, eVar);
        H(outputStream, eVar);
    }

    private static void G(OutputStream outputStream, e eVar, String str) throws IOException {
        f.p(outputStream, f.k(str));
        f.p(outputStream, eVar.f3161e);
        f.q(outputStream, eVar.f3162f);
        f.q(outputStream, eVar.f3159c);
        f.q(outputStream, eVar.f3163g);
        f.n(outputStream, str);
    }

    private static void H(OutputStream outputStream, e eVar) throws IOException {
        byte[] bArr = new byte[k(eVar.f3163g)];
        for (Map.Entry entry : eVar.f3165i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                z(bArr, 2, iIntValue, eVar);
            }
            if ((iIntValue2 & 4) != 0) {
                z(bArr, 4, iIntValue, eVar);
            }
        }
        outputStream.write(bArr);
    }

    private static void I(OutputStream outputStream, e eVar) throws IOException {
        int i2 = 0;
        for (Map.Entry entry : eVar.f3165i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                f.p(outputStream, iIntValue - i2);
                f.p(outputStream, 0);
                i2 = iIntValue;
            }
        }
    }

    private static void J(OutputStream outputStream, e[] eVarArr) throws IOException {
        f.p(outputStream, eVarArr.length);
        for (e eVar : eVarArr) {
            String strJ = j(eVar.f3157a, eVar.f3158b, q.f3199e);
            f.p(outputStream, f.k(strJ));
            f.p(outputStream, eVar.f3165i.size());
            f.p(outputStream, eVar.f3164h.length);
            f.q(outputStream, eVar.f3159c);
            f.n(outputStream, strJ);
            Iterator it2 = eVar.f3165i.keySet().iterator();
            while (it2.hasNext()) {
                f.p(outputStream, ((Integer) it2.next()).intValue());
            }
            for (int i2 : eVar.f3164h) {
                f.p(outputStream, i2);
            }
        }
    }

    private static void K(OutputStream outputStream, e[] eVarArr) throws IOException {
        f.r(outputStream, eVarArr.length);
        for (e eVar : eVarArr) {
            int size = eVar.f3165i.size() * 4;
            String strJ = j(eVar.f3157a, eVar.f3158b, q.f3198d);
            f.p(outputStream, f.k(strJ));
            f.p(outputStream, eVar.f3164h.length);
            f.q(outputStream, size);
            f.q(outputStream, eVar.f3159c);
            f.n(outputStream, strJ);
            Iterator it2 = eVar.f3165i.keySet().iterator();
            while (it2.hasNext()) {
                f.p(outputStream, ((Integer) it2.next()).intValue());
                f.p(outputStream, 0);
            }
            for (int i2 : eVar.f3164h) {
                f.p(outputStream, i2);
            }
        }
    }

    private static void L(OutputStream outputStream, e[] eVarArr) throws IOException {
        byte[] bArrB = b(eVarArr, q.f3197c);
        f.r(outputStream, eVarArr.length);
        f.m(outputStream, bArrB);
    }

    private static void M(OutputStream outputStream, e[] eVarArr) throws IOException {
        byte[] bArrB = b(eVarArr, q.f3196b);
        f.r(outputStream, eVarArr.length);
        f.m(outputStream, bArrB);
    }

    private static void N(OutputStream outputStream, e[] eVarArr) throws IOException {
        O(outputStream, eVarArr);
    }

    private static void O(OutputStream outputStream, e[] eVarArr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(D(eVarArr));
        arrayList.add(c(eVarArr));
        arrayList.add(d(eVarArr));
        long length2 = ((long) q.f3195a.length) + ((long) f3183a.length) + 4 + ((long) (arrayList.size() * 16));
        f.q(outputStream, arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            r rVar = (r) arrayList.get(i2);
            f.q(outputStream, rVar.f3202a.b());
            f.q(outputStream, length2);
            if (rVar.f3205d) {
                byte[] bArr = rVar.f3204c;
                long length3 = bArr.length;
                byte[] bArrB = f.b(bArr);
                arrayList2.add(bArrB);
                f.q(outputStream, bArrB.length);
                f.q(outputStream, length3);
                length = bArrB.length;
            } else {
                arrayList2.add(rVar.f3204c);
                f.q(outputStream, rVar.f3204c.length);
                f.q(outputStream, 0L);
                length = rVar.f3204c.length;
            }
            length2 += (long) length;
        }
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            outputStream.write((byte[]) arrayList2.get(i3));
        }
    }

    private static int a(e eVar) {
        Iterator it2 = eVar.f3165i.entrySet().iterator();
        int iIntValue = 0;
        while (it2.hasNext()) {
            iIntValue |= ((Integer) ((Map.Entry) it2.next()).getValue()).intValue();
        }
        return iIntValue;
    }

    private static byte[] b(e[] eVarArr, byte[] bArr) throws IOException {
        int i2 = 0;
        int iK = 0;
        for (e eVar : eVarArr) {
            iK += f.k(j(eVar.f3157a, eVar.f3158b, bArr)) + 16 + (eVar.f3161e * 2) + eVar.f3162f + k(eVar.f3163g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(iK);
        if (Arrays.equals(bArr, q.f3197c)) {
            int length = eVarArr.length;
            while (i2 < length) {
                e eVar2 = eVarArr[i2];
                G(byteArrayOutputStream, eVar2, j(eVar2.f3157a, eVar2.f3158b, bArr));
                F(byteArrayOutputStream, eVar2);
                i2++;
            }
        } else {
            for (e eVar3 : eVarArr) {
                G(byteArrayOutputStream, eVar3, j(eVar3.f3157a, eVar3.f3158b, bArr));
            }
            int length2 = eVarArr.length;
            while (i2 < length2) {
                F(byteArrayOutputStream, eVarArr[i2]);
                i2++;
            }
        }
        if (byteArrayOutputStream.size() == iK) {
            return byteArrayOutputStream.toByteArray();
        }
        throw f.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + iK);
    }

    private static r c(e[] eVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        for (int i3 = 0; i3 < eVarArr.length; i3++) {
            try {
                e eVar = eVarArr[i3];
                f.p(byteArrayOutputStream, i3);
                f.p(byteArrayOutputStream, eVar.f3161e);
                i2 = i2 + 4 + (eVar.f3161e * 2);
                C(byteArrayOutputStream, eVar);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i2 == byteArray.length) {
            r rVar = new r(g.CLASSES, i2, byteArray, true);
            byteArrayOutputStream.close();
            return rVar;
        }
        throw f.c("Expected size " + i2 + ", does not match actual size " + byteArray.length);
    }

    private static r d(e[] eVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        for (int i3 = 0; i3 < eVarArr.length; i3++) {
            try {
                e eVar = eVarArr[i3];
                int iA = a(eVar);
                byte[] bArrE = e(eVar);
                byte[] bArrF = f(eVar);
                f.p(byteArrayOutputStream, i3);
                int length = bArrE.length + 2 + bArrF.length;
                f.q(byteArrayOutputStream, length);
                f.p(byteArrayOutputStream, iA);
                byteArrayOutputStream.write(bArrE);
                byteArrayOutputStream.write(bArrF);
                i2 = i2 + 6 + length;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i2 == byteArray.length) {
            r rVar = new r(g.METHODS, i2, byteArray, true);
            byteArrayOutputStream.close();
            return rVar;
        }
        throw f.c("Expected size " + i2 + ", does not match actual size " + byteArray.length);
    }

    private static byte[] e(e eVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            H(byteArrayOutputStream, eVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static byte[] f(e eVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            I(byteArrayOutputStream, eVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static String g(String str, String str2) {
        return "!".equals(str2) ? str.replace(":", "!") : ":".equals(str2) ? str.replace("!", ":") : str;
    }

    private static String h(String str) {
        int iIndexOf = str.indexOf("!");
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(":");
        }
        return iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
    }

    private static e i(e[] eVarArr, String str) {
        if (eVarArr.length <= 0) {
            return null;
        }
        String strH = h(str);
        for (int i2 = 0; i2 < eVarArr.length; i2++) {
            if (eVarArr[i2].f3158b.equals(strH)) {
                return eVarArr[i2];
            }
        }
        return null;
    }

    private static String j(String str, String str2, byte[] bArr) {
        String strA = q.a(bArr);
        if (str.length() <= 0) {
            return g(str2, strA);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return g(str2, strA);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + q.a(bArr) + str2;
    }

    private static int k(int i2) {
        return y(i2 * 2) / 8;
    }

    private static int l(int i2, int i3, int i4) {
        if (i2 == 1) {
            throw f.c("HOT methods are not stored in the bitmap");
        }
        if (i2 == 2) {
            return i3;
        }
        if (i2 == 4) {
            return i3 + i4;
        }
        throw f.c("Unexpected flag: " + i2);
    }

    private static int[] m(InputStream inputStream, int i2) {
        int[] iArr = new int[i2];
        int iH = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            iH += f.h(inputStream);
            iArr[i3] = iH;
        }
        return iArr;
    }

    private static int n(BitSet bitSet, int i2, int i3) {
        int i4 = bitSet.get(l(2, i2, i3)) ? 2 : 0;
        return bitSet.get(l(4, i2, i3)) ? i4 | 4 : i4;
    }

    static byte[] o(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, f.d(inputStream, bArr.length))) {
            return f.d(inputStream, q.f3196b.length);
        }
        throw f.c("Invalid magic");
    }

    private static void p(InputStream inputStream, e eVar) {
        int iAvailable = inputStream.available() - eVar.f3162f;
        int iH = 0;
        while (inputStream.available() > iAvailable) {
            iH += f.h(inputStream);
            eVar.f3165i.put(Integer.valueOf(iH), 1);
            for (int iH2 = f.h(inputStream); iH2 > 0; iH2--) {
                A(inputStream);
            }
        }
        if (inputStream.available() != iAvailable) {
            throw f.c("Read too much data during profile line parse");
        }
    }

    static e[] q(InputStream inputStream, byte[] bArr, byte[] bArr2, e[] eVarArr) {
        if (Arrays.equals(bArr, q.f3200f)) {
            if (Arrays.equals(q.f3195a, bArr2)) {
                throw f.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return r(inputStream, bArr, eVarArr);
        }
        if (Arrays.equals(bArr, q.f3201g)) {
            return t(inputStream, bArr2, eVarArr);
        }
        throw f.c("Unsupported meta version");
    }

    static e[] r(InputStream inputStream, byte[] bArr, e[] eVarArr) throws IOException {
        if (!Arrays.equals(bArr, q.f3200f)) {
            throw f.c("Unsupported meta version");
        }
        int iJ = f.j(inputStream);
        byte[] bArrE = f.e(inputStream, (int) f.i(inputStream), (int) f.i(inputStream));
        if (inputStream.read() > 0) {
            throw f.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            e[] eVarArrS = s(byteArrayInputStream, iJ, eVarArr);
            byteArrayInputStream.close();
            return eVarArrS;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static e[] s(InputStream inputStream, int i2, e[] eVarArr) {
        if (inputStream.available() == 0) {
            return new e[0];
        }
        if (i2 != eVarArr.length) {
            throw f.c("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i2];
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int iH = f.h(inputStream);
            iArr[i3] = f.h(inputStream);
            strArr[i3] = f.f(inputStream, iH);
        }
        for (int i4 = 0; i4 < i2; i4++) {
            e eVar = eVarArr[i4];
            if (!eVar.f3158b.equals(strArr[i4])) {
                throw f.c("Order of dexfiles in metadata did not match baseline");
            }
            int i5 = iArr[i4];
            eVar.f3161e = i5;
            eVar.f3164h = m(inputStream, i5);
        }
        return eVarArr;
    }

    static e[] t(InputStream inputStream, byte[] bArr, e[] eVarArr) throws IOException {
        int iH = f.h(inputStream);
        byte[] bArrE = f.e(inputStream, (int) f.i(inputStream), (int) f.i(inputStream));
        if (inputStream.read() > 0) {
            throw f.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            e[] eVarArrU = u(byteArrayInputStream, bArr, iH, eVarArr);
            byteArrayInputStream.close();
            return eVarArrU;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static e[] u(InputStream inputStream, byte[] bArr, int i2, e[] eVarArr) {
        if (inputStream.available() == 0) {
            return new e[0];
        }
        if (i2 != eVarArr.length) {
            throw f.c("Mismatched number of dex files found in metadata");
        }
        for (int i3 = 0; i3 < i2; i3++) {
            f.h(inputStream);
            String strF = f.f(inputStream, f.h(inputStream));
            long jI = f.i(inputStream);
            int iH = f.h(inputStream);
            e eVarI = i(eVarArr, strF);
            if (eVarI == null) {
                throw f.c("Missing profile key: " + strF);
            }
            eVarI.f3160d = jI;
            int[] iArrM = m(inputStream, iH);
            if (Arrays.equals(bArr, q.f3199e)) {
                eVarI.f3161e = iH;
                eVarI.f3164h = iArrM;
            }
        }
        return eVarArr;
    }

    private static void v(InputStream inputStream, e eVar) {
        BitSet bitSetValueOf = BitSet.valueOf(f.d(inputStream, f.a(eVar.f3163g * 2)));
        int i2 = 0;
        while (true) {
            int i3 = eVar.f3163g;
            if (i2 >= i3) {
                return;
            }
            int iN = n(bitSetValueOf, i2, i3);
            if (iN != 0) {
                Integer num = (Integer) eVar.f3165i.get(Integer.valueOf(i2));
                if (num == null) {
                    num = 0;
                }
                eVar.f3165i.put(Integer.valueOf(i2), Integer.valueOf(iN | num.intValue()));
            }
            i2++;
        }
    }

    static e[] w(InputStream inputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, q.f3196b)) {
            throw f.c("Unsupported version");
        }
        int iJ = f.j(inputStream);
        byte[] bArrE = f.e(inputStream, (int) f.i(inputStream), (int) f.i(inputStream));
        if (inputStream.read() > 0) {
            throw f.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            e[] eVarArrX = x(byteArrayInputStream, str, iJ);
            byteArrayInputStream.close();
            return eVarArrX;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static e[] x(InputStream inputStream, String str, int i2) {
        if (inputStream.available() == 0) {
            return new e[0];
        }
        e[] eVarArr = new e[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int iH = f.h(inputStream);
            int iH2 = f.h(inputStream);
            long jI = f.i(inputStream);
            eVarArr[i3] = new e(str, f.f(inputStream, iH), f.i(inputStream), 0L, iH2, (int) jI, (int) f.i(inputStream), new int[iH2], new TreeMap());
        }
        for (int i4 = 0; i4 < i2; i4++) {
            e eVar = eVarArr[i4];
            p(inputStream, eVar);
            eVar.f3164h = m(inputStream, eVar.f3161e);
            v(inputStream, eVar);
        }
        return eVarArr;
    }

    private static int y(int i2) {
        return (i2 + 7) & (-8);
    }

    private static void z(byte[] bArr, int i2, int i3, e eVar) {
        int iL = l(i2, i3, eVar.f3163g);
        int i4 = iL / 8;
        bArr[i4] = (byte) ((1 << (iL % 8)) | bArr[i4]);
    }
}
