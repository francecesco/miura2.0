package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class t implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f2112a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f2113b;

    public interface a {
        Intent r();
    }

    private t(Context context) {
        this.f2113b = context;
    }

    public static t d(Context context) {
        return new t(context);
    }

    public t a(Intent intent) {
        this.f2112a.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t b(Activity activity) {
        Intent intentR = activity instanceof a ? ((a) activity).r() : null;
        if (intentR == null) {
            intentR = i.a(activity);
        }
        if (intentR != null) {
            ComponentName component = intentR.getComponent();
            if (component == null) {
                component = intentR.resolveActivity(this.f2113b.getPackageManager());
            }
            c(component);
            a(intentR);
        }
        return this;
    }

    public t c(ComponentName componentName) {
        int size = this.f2112a.size();
        try {
            Context context = this.f2113b;
            while (true) {
                Intent intentB = i.b(context, componentName);
                if (intentB == null) {
                    return this;
                }
                this.f2112a.add(size, intentB);
                context = this.f2113b;
                componentName = intentB.getComponent();
            }
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public void e() {
        f(null);
    }

    public void f(Bundle bundle) {
        if (this.f2112a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f2112a.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (androidx.core.content.a.e(this.f2113b, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f2113b.startActivity(intent);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f2112a.iterator();
    }
}
