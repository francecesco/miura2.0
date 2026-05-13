package androidx.lifecycle;

import androidx.lifecycle.AbstractC0183g;
import androidx.lifecycle.LegacySavedStateHandleController;
import androidx.savedstate.a;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class LegacySavedStateHandleController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LegacySavedStateHandleController f3040a = new LegacySavedStateHandleController();

    public static final class a implements a.InterfaceC0054a {
        @Override // androidx.savedstate.a.InterfaceC0054a
        public void a(A.c cVar) {
            q0.f.e(cVar, "owner");
            if (!(cVar instanceof E)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
            }
            D dX = ((E) cVar).x();
            androidx.savedstate.a aVarD = cVar.d();
            Iterator it2 = dX.c().iterator();
            while (it2.hasNext()) {
                z zVarB = dX.b((String) it2.next());
                q0.f.b(zVarB);
                LegacySavedStateHandleController.a(zVarB, aVarD, cVar.G());
            }
            if (!dX.c().isEmpty()) {
                aVarD.i(a.class);
            }
        }
    }

    private LegacySavedStateHandleController() {
    }

    public static final void a(z zVar, androidx.savedstate.a aVar, AbstractC0183g abstractC0183g) {
        q0.f.e(zVar, "viewModel");
        q0.f.e(aVar, "registry");
        q0.f.e(abstractC0183g, "lifecycle");
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) zVar.c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.i()) {
            return;
        }
        savedStateHandleController.h(aVar, abstractC0183g);
        f3040a.b(aVar, abstractC0183g);
    }

    private final void b(final androidx.savedstate.a aVar, final AbstractC0183g abstractC0183g) {
        AbstractC0183g.b bVarB = abstractC0183g.b();
        if (bVarB == AbstractC0183g.b.INITIALIZED || bVarB.b(AbstractC0183g.b.STARTED)) {
            aVar.i(a.class);
        } else {
            abstractC0183g.a(new j() { // from class: androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1
                @Override // androidx.lifecycle.j
                public void d(l lVar, AbstractC0183g.a aVar2) {
                    q0.f.e(lVar, "source");
                    q0.f.e(aVar2, "event");
                    if (aVar2 == AbstractC0183g.a.ON_START) {
                        abstractC0183g.c(this);
                        aVar.i(LegacySavedStateHandleController.a.class);
                    }
                }
            });
        }
    }
}
