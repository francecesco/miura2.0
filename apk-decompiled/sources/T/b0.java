package T;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public final class b0 extends AbstractC0083f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences f253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d0 f256f;

    protected b0(C0085h c0085h) {
        super(c0085h);
        this.f255e = -1L;
        this.f256f = new d0(this, "monitoring", ((Long) N.f192P.a()).longValue());
    }

    @Override // T.AbstractC0083f
    protected final void E() {
        this.f253c = a().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public final long I() {
        F.i.d();
        F();
        if (this.f254d == 0) {
            long j2 = this.f253c.getLong("first_run", 0L);
            if (j2 != 0) {
                this.f254d = j2;
            } else {
                long jA = k().a();
                SharedPreferences.Editor editorEdit = this.f253c.edit();
                editorEdit.putLong("first_run", jA);
                if (!editorEdit.commit()) {
                    B("Failed to commit first run time");
                }
                this.f254d = jA;
            }
        }
        return this.f254d;
    }

    public final long J() {
        F.i.d();
        F();
        if (this.f255e == -1) {
            this.f255e = this.f253c.getLong("last_dispatch", 0L);
        }
        return this.f255e;
    }

    public final void K() {
        F.i.d();
        F();
        long jA = k().a();
        SharedPreferences.Editor editorEdit = this.f253c.edit();
        editorEdit.putLong("last_dispatch", jA);
        editorEdit.apply();
        this.f255e = jA;
    }

    public final d0 L() {
        return this.f256f;
    }
}
