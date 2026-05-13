package androidx.lifecycle;

import androidx.lifecycle.AbstractC0183g;
import it.tervis.miura.model.Console;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0179c f3037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f3038b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3039a;

        static {
            int[] iArr = new int[AbstractC0183g.a.values().length];
            try {
                iArr[AbstractC0183g.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AbstractC0183g.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AbstractC0183g.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AbstractC0183g.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AbstractC0183g.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AbstractC0183g.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AbstractC0183g.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f3039a = iArr;
        }
    }

    public DefaultLifecycleObserverAdapter(InterfaceC0179c interfaceC0179c, j jVar) {
        q0.f.e(interfaceC0179c, "defaultLifecycleObserver");
        this.f3037a = interfaceC0179c;
        this.f3038b = jVar;
    }

    @Override // androidx.lifecycle.j
    public void d(l lVar, AbstractC0183g.a aVar) {
        q0.f.e(lVar, "source");
        q0.f.e(aVar, "event");
        switch (a.f3039a[aVar.ordinal()]) {
            case 1:
                this.f3037a.c(lVar);
                break;
            case 2:
                this.f3037a.g(lVar);
                break;
            case 3:
                this.f3037a.a(lVar);
                break;
            case 4:
                this.f3037a.e(lVar);
                break;
            case 5:
                this.f3037a.f(lVar);
                break;
            case 6:
                this.f3037a.b(lVar);
                break;
            case Console.MAX_CONSOLE /* 7 */:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        j jVar = this.f3038b;
        if (jVar != null) {
            jVar.d(lVar, aVar);
        }
    }
}
