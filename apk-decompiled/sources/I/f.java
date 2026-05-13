package I;

import I.a;

/* JADX INFO: loaded from: classes.dex */
final class f implements a.InterfaceC0000a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ b f95a;

    f(b bVar) {
        this.f95a = bVar;
    }

    @Override // I.a.InterfaceC0000a
    public final void a(boolean z2) {
        this.f95a.f89l.sendMessage(this.f95a.f89l.obtainMessage(1, Boolean.valueOf(z2)));
    }
}
