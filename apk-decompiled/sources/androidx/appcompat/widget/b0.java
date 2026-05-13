package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b0 extends ContextWrapper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f1795c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ArrayList f1796d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f1797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources.Theme f1798b;

    private b0(Context context) {
        super(context);
        if (!o0.c()) {
            this.f1797a = new d0(this, context.getResources());
            this.f1798b = null;
            return;
        }
        o0 o0Var = new o0(this, context.getResources());
        this.f1797a = o0Var;
        Resources.Theme themeNewTheme = o0Var.newTheme();
        this.f1798b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    private static boolean a(Context context) {
        if ((context instanceof b0) || (context.getResources() instanceof d0) || (context.getResources() instanceof o0)) {
            return false;
        }
        return o0.c();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f1795c) {
            try {
                ArrayList arrayList = f1796d;
                if (arrayList == null) {
                    f1796d = new ArrayList();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference weakReference = (WeakReference) f1796d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f1796d.remove(size);
                        }
                    }
                    for (int size2 = f1796d.size() - 1; size2 >= 0; size2--) {
                        WeakReference weakReference2 = (WeakReference) f1796d.get(size2);
                        b0 b0Var = weakReference2 != null ? (b0) weakReference2.get() : null;
                        if (b0Var != null && b0Var.getBaseContext() == context) {
                            return b0Var;
                        }
                    }
                }
                b0 b0Var2 = new b0(context);
                f1796d.add(new WeakReference(b0Var2));
                return b0Var2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1797a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1797a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1798b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        Resources.Theme theme = this.f1798b;
        if (theme == null) {
            super.setTheme(i2);
        } else {
            theme.applyStyle(i2, true);
        }
    }
}
