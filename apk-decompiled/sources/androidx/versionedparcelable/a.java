package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import k.C0207a;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final C0207a f3319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final C0207a f3320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final C0207a f3321c;

    public a(C0207a c0207a, C0207a c0207a2, C0207a c0207a3) {
        this.f3319a = c0207a;
        this.f3320b = c0207a2;
        this.f3321c = c0207a3;
    }

    private void N(D.a aVar) {
        try {
            I(c(aVar.getClass()).getName());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(aVar.getClass().getSimpleName() + " does not have a Parcelizer", e2);
        }
    }

    private Class c(Class cls) throws ClassNotFoundException {
        Class cls2 = (Class) this.f3321c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f3321c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method d(String str) throws NoSuchMethodException {
        Method method = (Method) this.f3319a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
        this.f3319a.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method e(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        Method method = (Method) this.f3320b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsC = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsC.getDeclaredMethod("write", cls, a.class);
        this.f3320b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    protected abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i2) {
        w(i2);
        A(bArr);
    }

    protected abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i2) {
        w(i2);
        C(charSequence);
    }

    protected abstract void E(int i2);

    public void F(int i2, int i3) {
        w(i3);
        E(i2);
    }

    protected abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i2) {
        w(i2);
        G(parcelable);
    }

    protected abstract void I(String str);

    public void J(String str, int i2) {
        w(i2);
        I(str);
    }

    protected void K(D.a aVar, a aVar2) {
        try {
            e(aVar.getClass()).invoke(null, aVar, aVar2);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (InvocationTargetException e5) {
            if (!(e5.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
            }
            throw ((RuntimeException) e5.getCause());
        }
    }

    protected void L(D.a aVar) {
        if (aVar == null) {
            I(null);
            return;
        }
        N(aVar);
        a aVarB = b();
        K(aVar, aVarB);
        aVarB.a();
    }

    public void M(D.a aVar, int i2) {
        w(i2);
        L(aVar);
    }

    protected abstract void a();

    protected abstract a b();

    public boolean f() {
        return false;
    }

    protected abstract boolean g();

    public boolean h(boolean z2, int i2) {
        return !m(i2) ? z2 : g();
    }

    protected abstract byte[] i();

    public byte[] j(byte[] bArr, int i2) {
        return !m(i2) ? bArr : i();
    }

    protected abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i2) {
        return !m(i2) ? charSequence : k();
    }

    protected abstract boolean m(int i2);

    protected D.a n(String str, a aVar) {
        try {
            return (D.a) d(str).invoke(null, aVar);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (InvocationTargetException e5) {
            if (e5.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e5.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
        }
    }

    protected abstract int o();

    public int p(int i2, int i3) {
        return !m(i3) ? i2 : o();
    }

    protected abstract Parcelable q();

    public Parcelable r(Parcelable parcelable, int i2) {
        return !m(i2) ? parcelable : q();
    }

    protected abstract String s();

    public String t(String str, int i2) {
        return !m(i2) ? str : s();
    }

    protected D.a u() {
        String strS = s();
        if (strS == null) {
            return null;
        }
        return n(strS, b());
    }

    public D.a v(D.a aVar, int i2) {
        return !m(i2) ? aVar : u();
    }

    protected abstract void w(int i2);

    public void x(boolean z2, boolean z3) {
    }

    protected abstract void y(boolean z2);

    public void z(boolean z2, int i2) {
        w(i2);
        y(z2);
    }
}
