package T;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class s0 extends F.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f351d;

    public final void c(String str) {
        this.f350c = str;
    }

    public final void d(String str) {
        this.f351d = str;
    }

    public final void e(String str) {
        this.f348a = str;
    }

    public final void f(String str) {
        this.f349b = str;
    }

    public final void g(s0 s0Var) {
        if (!TextUtils.isEmpty(this.f348a)) {
            s0Var.f348a = this.f348a;
        }
        if (!TextUtils.isEmpty(this.f349b)) {
            s0Var.f349b = this.f349b;
        }
        if (!TextUtils.isEmpty(this.f350c)) {
            s0Var.f350c = this.f350c;
        }
        if (TextUtils.isEmpty(this.f351d)) {
            return;
        }
        s0Var.f351d = this.f351d;
    }

    public final String toString() {
        HashMap map = new HashMap();
        map.put("appName", this.f348a);
        map.put("appVersion", this.f349b);
        map.put("appId", this.f350c);
        map.put("appInstallerId", this.f351d);
        return F.g.a(map);
    }
}
