package androidx.savedstate;

import A.c;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0183g;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import androidx.savedstate.a;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import q0.d;
import q0.f;

/* JADX INFO: loaded from: classes.dex */
public final class Recreator implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3206b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f3207a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(d dVar) {
            this();
        }
    }

    public static final class b implements a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set f3208a;

        public b(androidx.savedstate.a aVar) {
            f.e(aVar, "registry");
            this.f3208a = new LinkedHashSet();
            aVar.h("androidx.savedstate.Restarter", this);
        }

        @Override // androidx.savedstate.a.c
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f3208a));
            return bundle;
        }

        public final void b(String str) {
            f.e(str, "className");
            this.f3208a.add(str);
        }
    }

    public Recreator(c cVar) {
        f.e(cVar, "owner");
        this.f3207a = cVar;
    }

    private final void h(String str) {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(a.InterfaceC0054a.class);
            f.d(clsAsSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                try {
                    Object objNewInstance = declaredConstructor.newInstance(null);
                    f.d(objNewInstance, "{\n                constr…wInstance()\n            }");
                    ((a.InterfaceC0054a) objNewInstance).a(this.f3207a);
                } catch (Exception e2) {
                    throw new RuntimeException("Failed to instantiate " + str, e2);
                }
            } catch (NoSuchMethodException e3) {
                throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
            }
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("Class " + str + " wasn't found", e4);
        }
    }

    @Override // androidx.lifecycle.j
    public void d(l lVar, AbstractC0183g.a aVar) {
        f.e(lVar, "source");
        f.e(aVar, "event");
        if (aVar != AbstractC0183g.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        lVar.G().c(this);
        Bundle bundleB = this.f3207a.d().b("androidx.savedstate.Restarter");
        if (bundleB == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleB.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it2 = stringArrayList.iterator();
        while (it2.hasNext()) {
            h(it2.next());
        }
    }
}
