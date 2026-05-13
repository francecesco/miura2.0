package T;

/* JADX INFO: loaded from: classes.dex */
final class Q implements E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0085h f223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final S f224b = new S();

    public Q(C0085h c0085h) {
        this.f223a = c0085h;
    }

    @Override // T.E
    public final void a(String str, String str2) {
        if ("ga_appName".equals(str)) {
            this.f224b.f225a = str2;
            return;
        }
        if ("ga_appVersion".equals(str)) {
            this.f224b.f226b = str2;
        } else if ("ga_logLevel".equals(str)) {
            this.f224b.f227c = str2;
        } else {
            this.f223a.d().v("String xml configuration name not recognized", str);
        }
    }

    @Override // T.E
    public final void b(String str, int i2) {
        if ("ga_dispatchPeriod".equals(str)) {
            this.f224b.f228d = i2;
        } else {
            this.f223a.d().v("Int xml configuration name not recognized", str);
        }
    }

    @Override // T.E
    public final /* synthetic */ C d() {
        return this.f224b;
    }

    @Override // T.E
    public final void e(String str, boolean z2) {
        if (!"ga_dryRun".equals(str)) {
            this.f223a.d().v("Bool xml configuration name not recognized", str);
        } else {
            this.f224b.f229e = z2 ? 1 : 0;
        }
    }

    @Override // T.E
    public final void c(String str, String str2) {
    }
}
