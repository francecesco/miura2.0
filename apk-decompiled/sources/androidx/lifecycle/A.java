package androidx.lifecycle;

import y.AbstractC0272a;
import y.C0275d;

/* JADX INFO: loaded from: classes.dex */
public class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final D f3026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f3027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AbstractC0272a f3028c;

    public static class a extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C0046a f3029c = new C0046a(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AbstractC0272a.b f3030d = C0046a.C0047a.f3031a;

        /* JADX INFO: renamed from: androidx.lifecycle.A$a$a, reason: collision with other inner class name */
        public static final class C0046a {

            /* JADX INFO: renamed from: androidx.lifecycle.A$a$a$a, reason: collision with other inner class name */
            private static final class C0047a implements AbstractC0272a.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0047a f3031a = new C0047a();

                private C0047a() {
                }
            }

            private C0046a() {
            }

            public /* synthetic */ C0046a(q0.d dVar) {
                this();
            }
        }
    }

    public interface b {
        z a(Class cls);

        z b(Class cls, AbstractC0272a abstractC0272a);
    }

    public static class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f3032a = new a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final AbstractC0272a.b f3033b = a.C0048a.f3034a;

        public static final class a {

            /* JADX INFO: renamed from: androidx.lifecycle.A$c$a$a, reason: collision with other inner class name */
            private static final class C0048a implements AbstractC0272a.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0048a f3034a = new C0048a();

                private C0048a() {
                }
            }

            private a() {
            }

            public /* synthetic */ a(q0.d dVar) {
                this();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public A(D d2, b bVar) {
        this(d2, bVar, null, 4, null);
        q0.f.e(d2, "store");
        q0.f.e(bVar, "factory");
    }

    public z a(Class cls) {
        q0.f.e(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    public z b(String str, Class cls) {
        z zVarA;
        q0.f.e(str, "key");
        q0.f.e(cls, "modelClass");
        z zVarB = this.f3026a.b(str);
        if (cls.isInstance(zVarB)) {
            q0.f.c(zVarB, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return zVarB;
        }
        C0275d c0275d = new C0275d(this.f3028c);
        c0275d.b(c.f3033b, str);
        try {
            zVarA = this.f3027b.b(cls, c0275d);
        } catch (AbstractMethodError unused) {
            zVarA = this.f3027b.a(cls);
        }
        this.f3026a.d(str, zVarA);
        return zVarA;
    }

    public A(D d2, b bVar, AbstractC0272a abstractC0272a) {
        q0.f.e(d2, "store");
        q0.f.e(bVar, "factory");
        q0.f.e(abstractC0272a, "defaultCreationExtras");
        this.f3026a = d2;
        this.f3027b = bVar;
        this.f3028c = abstractC0272a;
    }

    public /* synthetic */ A(D d2, b bVar, AbstractC0272a abstractC0272a, int i2, q0.d dVar) {
        this(d2, bVar, (i2 & 4) != 0 ? AbstractC0272a.C0076a.f4095b : abstractC0272a);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public A(E e2, b bVar) {
        this(e2.x(), bVar, C.a(e2));
        q0.f.e(e2, "owner");
        q0.f.e(bVar, "factory");
    }
}
