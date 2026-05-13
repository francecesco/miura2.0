package n;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import n.h;

/* JADX INFO: loaded from: classes.dex */
abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator f3880a = new Comparator() { // from class: n.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return e.g((byte[]) obj, (byte[]) obj2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    interface a {
        Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

        void close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentProviderClient f3881a;

        b(Context context, Uri uri) {
            this.f3881a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // n.e.a
        public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f3881a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException unused) {
                return null;
            }
        }

        @Override // n.e.a
        public void close() {
            ContentProviderClient contentProviderClient = this.f3881a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentProviderClient f3882a;

        c(Context context, Uri uri) {
            this.f3882a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // n.e.a
        public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f3882a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException unused) {
                return null;
            }
        }

        @Override // n.e.a
        public void close() {
            ContentProviderClient contentProviderClient = this.f3882a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    private static List b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean c(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!Arrays.equals((byte[]) list.get(i2), (byte[]) list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    private static List d(f fVar, Resources resources) {
        return fVar.b() != null ? fVar.b() : androidx.core.content.res.e.c(resources, fVar.c());
    }

    static h.a e(Context context, f fVar, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoF = f(context.getPackageManager(), fVar, context.getResources());
        return providerInfoF == null ? h.a.a(1, null) : h.a.a(0, h(context, fVar, providerInfoF.authority, cancellationSignal));
    }

    static ProviderInfo f(PackageManager packageManager, f fVar, Resources resources) throws PackageManager.NameNotFoundException {
        String strE = fVar.e();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strE, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + strE);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(fVar.f())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strE + ", but package was not " + fVar.f());
        }
        List listB = b(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listB, f3880a);
        List listD = d(fVar, resources);
        for (int i2 = 0; i2 < listD.size(); i2++) {
            ArrayList arrayList = new ArrayList((Collection) listD.get(i2));
            Collections.sort(arrayList, f3880a);
            if (c(listB, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            byte b3 = bArr2[i2];
            if (b2 != b3) {
                return b2 - b3;
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static n.h.b[] h(android.content.Context r16, n.f r17, java.lang.String r18, android.os.CancellationSignal r19) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.e.h(android.content.Context, n.f, java.lang.String, android.os.CancellationSignal):n.h$b[]");
    }
}
