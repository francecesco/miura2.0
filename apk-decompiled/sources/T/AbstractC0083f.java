package T;

/* JADX INFO: renamed from: T.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0083f extends AbstractC0082e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f268b;

    protected AbstractC0083f(C0085h c0085h) {
        super(c0085h);
    }

    public final boolean D() {
        return this.f268b;
    }

    protected abstract void E();

    protected final void F() {
        if (!D()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void G() {
        E();
        this.f268b = true;
    }
}
