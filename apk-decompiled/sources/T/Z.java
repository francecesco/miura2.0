package T;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class Z extends AbstractC0083f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte[] f243e = "\n".getBytes();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final k0 f245d;

    Z(C0085h c0085h) {
        super(c0085h);
        this.f244c = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleAnalytics", AbstractC0084g.f272a, Build.VERSION.RELEASE, l0.a(Locale.getDefault()), Build.MODEL, Build.ID);
        this.f245d = new k0(c0085h.c());
    }

    private final int H(URL url) {
        K.e.f(url);
        g("GET request", url);
        HttpURLConnection httpURLConnectionN = null;
        try {
            try {
                httpURLConnectionN = N(url);
                httpURLConnectionN.connect();
                L(httpURLConnectionN);
                int responseCode = httpURLConnectionN.getResponseCode();
                if (responseCode == 200) {
                    q().N();
                }
                g("GET status", Integer.valueOf(responseCode));
                httpURLConnectionN.disconnect();
                return responseCode;
            } catch (IOException e2) {
                v("Network GET connection error", e2);
                if (httpURLConnectionN == null) {
                    return 0;
                }
                httpURLConnectionN.disconnect();
                return 0;
            }
        } catch (Throwable th) {
            if (httpURLConnectionN != null) {
                httpURLConnectionN.disconnect();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int I(java.net.URL r5, byte[] r6) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.String r0 = "Error closing http post connection output stream"
            K.e.f(r5)
            K.e.f(r6)
            int r1 = r6.length
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "POST bytes, url"
            r4.h(r2, r1, r5)
            boolean r1 = T.AbstractC0082e.u()
            if (r1 == 0) goto L22
            java.lang.String r1 = new java.lang.String
            r1.<init>(r6)
            java.lang.String r2 = "Post payload\n"
            r4.c(r2, r1)
        L22:
            r1 = 0
            android.content.Context r2 = r4.a()     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r2.getPackageName()     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            java.net.HttpURLConnection r5 = r4.N(r5)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r2 = 1
            r5.setDoOutput(r2)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            int r2 = r6.length     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            r5.setFixedLengthStreamingMode(r2)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            r5.connect()     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            java.io.OutputStream r1 = r5.getOutputStream()     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            r1.write(r6)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            r4.L(r5)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            int r6 = r5.getResponseCode()     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            r2 = 200(0xc8, float:2.8E-43)
            if (r6 != r2) goto L57
            T.b r2 = r4.q()     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            r2.N()     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            goto L57
        L53:
            r6 = move-exception
            goto L87
        L55:
            r6 = move-exception
            goto L71
        L57:
            java.lang.String r2 = "POST status"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            r4.g(r2, r3)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            r1.close()     // Catch: java.io.IOException -> L64
            goto L68
        L64:
            r1 = move-exception
            r4.x(r0, r1)
        L68:
            r5.disconnect()
            return r6
        L6c:
            r6 = move-exception
            r5 = r1
            goto L87
        L6f:
            r6 = move-exception
            r5 = r1
        L71:
            java.lang.String r2 = "Network POST connection error"
            r4.v(r2, r6)     // Catch: java.lang.Throwable -> L53
            if (r1 == 0) goto L80
            r1.close()     // Catch: java.io.IOException -> L7c
            goto L80
        L7c:
            r6 = move-exception
            r4.x(r0, r6)
        L80:
            if (r5 == 0) goto L85
            r5.disconnect()
        L85:
            r5 = 0
            return r5
        L87:
            if (r1 == 0) goto L91
            r1.close()     // Catch: java.io.IOException -> L8d
            goto L91
        L8d:
            r1 = move-exception
            r4.x(r0, r1)
        L91:
            if (r5 == 0) goto L96
            r5.disconnect()
        L96:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: T.Z.I(java.net.URL, byte[]):int");
    }

    private static void K(StringBuilder sb, String str, String str2) {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0015, code lost:
    
        x("Error closing http connection input stream", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0018, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void L(java.net.HttpURLConnection r4) throws java.lang.Throwable {
        /*
            r3 = this;
            java.lang.String r0 = "Error closing http connection input stream"
            java.io.InputStream r4 = r4.getInputStream()     // Catch: java.lang.Throwable -> L1b
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L19
        La:
            int r2 = r4.read(r1)     // Catch: java.lang.Throwable -> L19
            if (r2 > 0) goto La
            r4.close()     // Catch: java.io.IOException -> L14
            return
        L14:
            r4 = move-exception
            r3.x(r0, r4)
            return
        L19:
            r1 = move-exception
            goto L1d
        L1b:
            r1 = move-exception
            r4 = 0
        L1d:
            if (r4 == 0) goto L27
            r4.close()     // Catch: java.io.IOException -> L23
            goto L27
        L23:
            r4 = move-exception
            r3.x(r0, r4)
        L27:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: T.Z.L(java.net.HttpURLConnection):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int M(java.net.URL r11, byte[] r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: T.Z.M(java.net.URL, byte[]):int");
    }

    private final HttpURLConnection N(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(((Integer) N.f181E.a()).intValue());
        httpURLConnection.setReadTimeout(((Integer) N.f182F.a()).intValue());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", this.f244c);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    private final URL O(T t2, String str) {
        String strI;
        String strJ;
        StringBuilder sb;
        if (t2.h()) {
            strI = F.h();
            strJ = F.j();
            sb = new StringBuilder(String.valueOf(strI).length() + 1 + String.valueOf(strJ).length() + String.valueOf(str).length());
        } else {
            strI = F.i();
            strJ = F.j();
            sb = new StringBuilder(String.valueOf(strI).length() + 1 + String.valueOf(strJ).length() + String.valueOf(str).length());
        }
        sb.append(strI);
        sb.append(strJ);
        sb.append("?");
        sb.append(str);
        try {
            return new URL(sb.toString());
        } catch (MalformedURLException e2) {
            x("Error trying to parse the hardcoded host url", e2);
            return null;
        }
    }

    private final URL Q(T t2) {
        String strValueOf;
        String strValueOf2;
        String str;
        String strConcat;
        if (t2.h()) {
            strValueOf = String.valueOf(F.h());
            strValueOf2 = String.valueOf(F.j());
            if (strValueOf2.length() == 0) {
                str = new String(strValueOf);
                strConcat = str;
            }
            strConcat = strValueOf.concat(strValueOf2);
        } else {
            strValueOf = String.valueOf(F.i());
            strValueOf2 = String.valueOf(F.j());
            if (strValueOf2.length() == 0) {
                str = new String(strValueOf);
                strConcat = str;
            }
            strConcat = strValueOf.concat(strValueOf2);
        }
        try {
            return new URL(strConcat);
        } catch (MalformedURLException e2) {
            x("Error trying to parse the hardcoded host url", e2);
            return null;
        }
    }

    private final URL S() {
        String strValueOf = String.valueOf(F.h());
        String strValueOf2 = String.valueOf((String) N.f214t.a());
        try {
            return new URL(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf));
        } catch (MalformedURLException e2) {
            x("Error trying to parse the hardcoded host url", e2);
            return null;
        }
    }

    @Override // T.AbstractC0083f
    protected final void E() {
        c("Network initialized. User agent", this.f244c);
    }

    final String J(T t2, boolean z2) {
        K.e.f(t2);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry entry : t2.d().entrySet()) {
                String str = (String) entry.getKey();
                if (!"ht".equals(str) && !"qt".equals(str) && !"AppUID".equals(str) && !"z".equals(str) && !"_gmsv".equals(str)) {
                    K(sb, str, (String) entry.getValue());
                }
            }
            K(sb, "ht", String.valueOf(t2.g()));
            K(sb, "qt", String.valueOf(k().a() - t2.g()));
            if (z2) {
                long jI = t2.i();
                K(sb, "z", jI != 0 ? String.valueOf(jI) : String.valueOf(t2.f()));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e2) {
            x("Failed to encode name or value", e2);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a0 A[EDGE_INSN: B:76:0x01a0->B:71:0x01a0 BREAK  A[LOOP:1: B:43:0x010c->B:80:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[LOOP:1: B:43:0x010c->B:80:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List P(java.util.List r9) {
        /*
            Method dump skipped, instruction units count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: T.Z.P(java.util.List):java.util.List");
    }

    public final boolean R() {
        NetworkInfo activeNetworkInfo;
        F.i.d();
        F();
        try {
            activeNetworkInfo = ((ConnectivityManager) a().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        y("No network connectivity");
        return false;
    }
}
