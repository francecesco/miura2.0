package n;

import android.util.Base64;
import java.util.List;
import o.AbstractC0236e;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f3884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f3885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f3886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f3887e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f3888f;

    public f(String str, String str2, String str3, List list) {
        this.f3883a = (String) AbstractC0236e.f(str);
        this.f3884b = (String) AbstractC0236e.f(str2);
        this.f3885c = (String) AbstractC0236e.f(str3);
        this.f3886d = (List) AbstractC0236e.f(list);
        this.f3888f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List b() {
        return this.f3886d;
    }

    public int c() {
        return this.f3887e;
    }

    String d() {
        return this.f3888f;
    }

    public String e() {
        return this.f3883a;
    }

    public String f() {
        return this.f3884b;
    }

    public String g() {
        return this.f3885c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f3883a + ", mProviderPackage: " + this.f3884b + ", mQuery: " + this.f3885c + ", mCertificates:");
        for (int i2 = 0; i2 < this.f3886d.size(); i2++) {
            sb.append(" [");
            List list = (List) this.f3886d.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f3887e);
        return sb.toString();
    }
}
