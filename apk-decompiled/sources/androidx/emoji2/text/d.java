package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.emoji2.text.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import o.AbstractC0236e;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f2524a;

        public a(b bVar) {
            this.f2524a = bVar == null ? e() : bVar;
        }

        private f.c a(Context context, n.f fVar) {
            if (fVar == null) {
                return null;
            }
            return new k(context, fVar);
        }

        private List b(Signature[] signatureArr) {
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            return Collections.singletonList(arrayList);
        }

        private n.f d(ProviderInfo providerInfo, PackageManager packageManager) {
            String str = providerInfo.authority;
            String str2 = providerInfo.packageName;
            return new n.f(str, str2, "emojicompat-emoji-font", b(this.f2524a.b(packageManager, str2)));
        }

        private static b e() {
            return Build.VERSION.SDK_INT >= 28 ? new C0041d() : new c();
        }

        private boolean f(ProviderInfo providerInfo) {
            ApplicationInfo applicationInfo;
            return (providerInfo == null || (applicationInfo = providerInfo.applicationInfo) == null || (applicationInfo.flags & 1) != 1) ? false : true;
        }

        private ProviderInfo g(PackageManager packageManager) {
            Iterator it2 = this.f2524a.c(packageManager, new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
            while (it2.hasNext()) {
                ProviderInfo providerInfoA = this.f2524a.a((ResolveInfo) it2.next());
                if (f(providerInfoA)) {
                    return providerInfoA;
                }
            }
            return null;
        }

        public f.c c(Context context) {
            return a(context, h(context));
        }

        n.f h(Context context) {
            PackageManager packageManager = context.getPackageManager();
            AbstractC0236e.g(packageManager, "Package manager required to locate emoji font provider");
            ProviderInfo providerInfoG = g(packageManager);
            if (providerInfoG == null) {
                return null;
            }
            try {
                return d(providerInfoG, packageManager);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e2);
                return null;
            }
        }
    }

    public static class b {
        public abstract ProviderInfo a(ResolveInfo resolveInfo);

        public Signature[] b(PackageManager packageManager, String str) {
            return packageManager.getPackageInfo(str, 64).signatures;
        }

        public abstract List c(PackageManager packageManager, Intent intent, int i2);
    }

    public static class c extends b {
        @Override // androidx.emoji2.text.d.b
        public ProviderInfo a(ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        @Override // androidx.emoji2.text.d.b
        public List c(PackageManager packageManager, Intent intent, int i2) {
            return packageManager.queryIntentContentProviders(intent, i2);
        }
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.d$d, reason: collision with other inner class name */
    public static class C0041d extends c {
        @Override // androidx.emoji2.text.d.b
        public Signature[] b(PackageManager packageManager, String str) {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    public static k a(Context context) {
        return (k) new a(null).c(context);
    }
}
