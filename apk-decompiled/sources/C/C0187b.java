package c;

import android.content.Context;
import android.content.Intent;
import c.AbstractC0186a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import k0.e;
import k0.g;
import l0.A;
import l0.AbstractC0221e;
import l0.k;
import q0.d;
import q0.f;

/* JADX INFO: renamed from: c.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0187b extends AbstractC0186a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3438a = new a(null);

    /* JADX INFO: renamed from: c.b$a */
    public static final class a {
        private a() {
        }

        public final Intent a(String[] strArr) {
            f.e(strArr, "input");
            Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
            f.d(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return intentPutExtra;
        }

        public /* synthetic */ a(d dVar) {
            this();
        }
    }

    @Override // c.AbstractC0186a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String[] strArr) {
        f.e(context, "context");
        f.e(strArr, "input");
        return f3438a.a(strArr);
    }

    @Override // c.AbstractC0186a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public AbstractC0186a.C0057a b(Context context, String[] strArr) {
        f.e(context, "context");
        f.e(strArr, "input");
        if (strArr.length == 0) {
            return new AbstractC0186a.C0057a(A.d());
        }
        for (String str : strArr) {
            if (androidx.core.content.a.a(context, str) != 0) {
                return null;
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(r0.d.a(A.a(strArr.length), 16));
        for (String str2 : strArr) {
            e eVarA = g.a(str2, Boolean.TRUE);
            linkedHashMap.put(eVarA.c(), eVarA.d());
        }
        return new AbstractC0186a.C0057a(linkedHashMap);
    }

    @Override // c.AbstractC0186a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map c(int i2, Intent intent) {
        if (i2 != -1) {
            return A.d();
        }
        if (intent == null) {
            return A.d();
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra == null || stringArrayExtra == null) {
            return A.d();
        }
        ArrayList arrayList = new ArrayList(intArrayExtra.length);
        for (int i3 : intArrayExtra) {
            arrayList.add(Boolean.valueOf(i3 == 0));
        }
        return A.g(k.i(AbstractC0221e.f(stringArrayExtra), arrayList));
    }
}
