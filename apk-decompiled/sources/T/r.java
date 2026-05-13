package T;

/* JADX INFO: loaded from: classes.dex */
public final class r extends AbstractC0083f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s0 f334c;

    r(C0085h c0085h) {
        super(c0085h);
        this.f334c = new s0();
    }

    @Override // T.AbstractC0083f
    protected final void E() {
        p().c().g(this.f334c);
        m0 m0VarS = s();
        String strH = m0VarS.H();
        if (strH != null) {
            this.f334c.e(strH);
        }
        String strI = m0VarS.I();
        if (strI != null) {
            this.f334c.f(strI);
        }
    }
}
