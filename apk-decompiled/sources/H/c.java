package H;

/* JADX INFO: loaded from: classes.dex */
public final class c extends UnsupportedOperationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final G.c f68a;

    public c(G.c cVar) {
        this.f68a = cVar;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String strValueOf = String.valueOf(this.f68a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 8);
        sb.append("Missing ");
        sb.append(strValueOf);
        return sb.toString();
    }
}
