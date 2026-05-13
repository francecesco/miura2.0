package T;

import android.content.SharedPreferences;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ b0 f263c;

    private d0(b0 b0Var, String str, long j2) {
        this.f263c = b0Var;
        K.e.d(str);
        K.e.a(j2 > 0);
        this.f261a = str;
        this.f262b = j2;
    }

    private final void b() {
        long jA = this.f263c.k().a();
        SharedPreferences.Editor editorEdit = this.f263c.f253c.edit();
        editorEdit.remove(e());
        editorEdit.remove(f());
        editorEdit.putLong(d(), jA);
        editorEdit.commit();
    }

    private final long c() {
        return this.f263c.f253c.getLong(d(), 0L);
    }

    private final String d() {
        return String.valueOf(this.f261a).concat(":start");
    }

    private final String e() {
        return String.valueOf(this.f261a).concat(":count");
    }

    private final String f() {
        return String.valueOf(this.f261a).concat(":value");
    }

    public final void a(String str) {
        if (c() == 0) {
            b();
        }
        if (str == null) {
            str = "";
        }
        synchronized (this) {
            try {
                long j2 = this.f263c.f253c.getLong(e(), 0L);
                if (j2 <= 0) {
                    SharedPreferences.Editor editorEdit = this.f263c.f253c.edit();
                    editorEdit.putString(f(), str);
                    editorEdit.putLong(e(), 1L);
                    editorEdit.apply();
                    return;
                }
                long j3 = j2 + 1;
                boolean z2 = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / j3;
                SharedPreferences.Editor editorEdit2 = this.f263c.f253c.edit();
                if (z2) {
                    editorEdit2.putString(f(), str);
                }
                editorEdit2.putLong(e(), j3);
                editorEdit2.apply();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
