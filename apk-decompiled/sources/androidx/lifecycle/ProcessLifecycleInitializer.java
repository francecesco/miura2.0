package androidx.lifecycle;

import android.content.Context;
import androidx.lifecycle.t;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements B.a {
    @Override // B.a
    public List a() {
        return l0.k.b();
    }

    @Override // B.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public l b(Context context) {
        q0.f.e(context, "context");
        androidx.startup.a aVarE = androidx.startup.a.e(context);
        q0.f.d(aVarE, "getInstance(context)");
        if (!aVarE.g(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
        }
        i.a(context);
        t.b bVar = t.f3101i;
        bVar.b(context);
        return bVar.a();
    }
}
