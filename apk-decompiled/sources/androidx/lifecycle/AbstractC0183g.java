package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: androidx.lifecycle.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0183g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicReference f3074a = new AtomicReference();

    /* JADX INFO: renamed from: androidx.lifecycle.g$a */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static final C0050a Companion = new C0050a(null);

        /* JADX INFO: renamed from: androidx.lifecycle.g$a$a, reason: collision with other inner class name */
        public static final class C0050a {

            /* JADX INFO: renamed from: androidx.lifecycle.g$a$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0051a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f3075a;

                static {
                    int[] iArr = new int[b.values().length];
                    try {
                        iArr[b.CREATED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[b.STARTED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[b.RESUMED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[b.DESTROYED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[b.INITIALIZED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    f3075a = iArr;
                }
            }

            private C0050a() {
            }

            public final a a(b bVar) {
                q0.f.e(bVar, "state");
                int i2 = C0051a.f3075a[bVar.ordinal()];
                if (i2 == 1) {
                    return a.ON_DESTROY;
                }
                if (i2 == 2) {
                    return a.ON_STOP;
                }
                if (i2 != 3) {
                    return null;
                }
                return a.ON_PAUSE;
            }

            public final a b(b bVar) {
                q0.f.e(bVar, "state");
                int i2 = C0051a.f3075a[bVar.ordinal()];
                if (i2 == 1) {
                    return a.ON_START;
                }
                if (i2 == 2) {
                    return a.ON_RESUME;
                }
                if (i2 != 5) {
                    return null;
                }
                return a.ON_CREATE;
            }

            public /* synthetic */ C0050a(q0.d dVar) {
                this();
            }
        }

        /* JADX INFO: renamed from: androidx.lifecycle.g$a$b */
        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f3076a;

            static {
                int[] iArr = new int[a.values().length];
                try {
                    iArr[a.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[a.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[a.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[a.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[a.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[a.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[a.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f3076a = iArr;
            }
        }

        public final b b() {
            switch (b.f3076a[ordinal()]) {
                case 1:
                case 2:
                    return b.CREATED;
                case 3:
                case 4:
                    return b.STARTED;
                case 5:
                    return b.RESUMED;
                case 6:
                    return b.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.g$b */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean b(b bVar) {
            q0.f.e(bVar, "state");
            return compareTo(bVar) >= 0;
        }
    }

    public abstract void a(k kVar);

    public abstract b b();

    public abstract void c(k kVar);
}
