package z;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: renamed from: z.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0277a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f4100f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static C0277a f4101g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap f4103b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap f4104c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList f4105d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f4106e;

    /* JADX INFO: renamed from: z.a$a, reason: collision with other inner class name */
    class HandlerC0077a extends Handler {
        HandlerC0077a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                C0277a.this.a();
            }
        }
    }

    /* JADX INFO: renamed from: z.a$b */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Intent f4108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ArrayList f4109b;

        b(Intent intent, ArrayList arrayList) {
            this.f4108a = intent;
            this.f4109b = arrayList;
        }
    }

    /* JADX INFO: renamed from: z.a$c */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final IntentFilter f4110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BroadcastReceiver f4111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f4112c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f4113d;

        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f4110a = intentFilter;
            this.f4111b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f4111b);
            sb.append(" filter=");
            sb.append(this.f4110a);
            if (this.f4113d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private C0277a(Context context) {
        this.f4102a = context;
        this.f4106e = new HandlerC0077a(context.getMainLooper());
    }

    public static C0277a b(Context context) {
        C0277a c0277a;
        synchronized (f4100f) {
            try {
                if (f4101g == null) {
                    f4101g = new C0277a(context.getApplicationContext());
                }
                c0277a = f4101g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0277a;
    }

    void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f4103b) {
                try {
                    size = this.f4105d.size();
                    if (size <= 0) {
                        return;
                    }
                    bVarArr = new b[size];
                    this.f4105d.toArray(bVarArr);
                    this.f4105d.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = bVarArr[i2];
                int size2 = bVar.f4109b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    c cVar = (c) bVar.f4109b.get(i3);
                    if (!cVar.f4113d) {
                        cVar.f4111b.onReceive(this.f4102a, bVar.f4108a);
                    }
                }
            }
        }
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f4103b) {
            try {
                c cVar = new c(intentFilter, broadcastReceiver);
                ArrayList arrayList = (ArrayList) this.f4103b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.f4103b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(cVar);
                for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                    String action = intentFilter.getAction(i2);
                    ArrayList arrayList2 = (ArrayList) this.f4104c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        this.f4104c.put(action, arrayList2);
                    }
                    arrayList2.add(cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean d(Intent intent) {
        int i2;
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        synchronized (this.f4103b) {
            try {
                String action = intent.getAction();
                String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f4102a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z2 = (intent.getFlags() & 8) != 0;
                if (z2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Resolving type ");
                    sb.append(strResolveTypeIfNeeded);
                    sb.append(" scheme ");
                    sb.append(scheme);
                    sb.append(" of intent ");
                    sb.append(intent);
                }
                ArrayList arrayList3 = (ArrayList) this.f4104c.get(intent.getAction());
                if (arrayList3 != null) {
                    if (z2) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Action list: ");
                        sb2.append(arrayList3);
                    }
                    ArrayList arrayList4 = null;
                    int i3 = 0;
                    while (i3 < arrayList3.size()) {
                        c cVar = (c) arrayList3.get(i3);
                        if (z2) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Matching against filter ");
                            sb3.append(cVar.f4110a);
                        }
                        if (cVar.f4112c) {
                            i2 = i3;
                            arrayList2 = arrayList3;
                            str = action;
                            str2 = strResolveTypeIfNeeded;
                            arrayList = arrayList4;
                        } else {
                            i2 = i3;
                            str = action;
                            arrayList = arrayList4;
                            arrayList2 = arrayList3;
                            str2 = strResolveTypeIfNeeded;
                            int iMatch = cVar.f4110a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                            if (iMatch >= 0) {
                                if (z2) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("  Filter matched!  match=0x");
                                    sb4.append(Integer.toHexString(iMatch));
                                }
                                arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                                arrayList4.add(cVar);
                                cVar.f4112c = true;
                                i3 = i2 + 1;
                                action = str;
                                arrayList3 = arrayList2;
                                strResolveTypeIfNeeded = str2;
                            } else if (z2) {
                                String str3 = iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : "data" : "action" : "category";
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("  Filter did not match: ");
                                sb5.append(str3);
                            }
                        }
                        arrayList4 = arrayList;
                        i3 = i2 + 1;
                        action = str;
                        arrayList3 = arrayList2;
                        strResolveTypeIfNeeded = str2;
                    }
                    ArrayList arrayList5 = arrayList4;
                    if (arrayList5 != null) {
                        for (int i4 = 0; i4 < arrayList5.size(); i4++) {
                            ((c) arrayList5.get(i4)).f4112c = false;
                        }
                        this.f4105d.add(new b(intent, arrayList5));
                        if (!this.f4106e.hasMessages(1)) {
                            this.f4106e.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f4103b) {
            try {
                ArrayList arrayList = (ArrayList) this.f4103b.remove(broadcastReceiver);
                if (arrayList == null) {
                    return;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    c cVar = (c) arrayList.get(size);
                    cVar.f4113d = true;
                    for (int i2 = 0; i2 < cVar.f4110a.countActions(); i2++) {
                        String action = cVar.f4110a.getAction(i2);
                        ArrayList arrayList2 = (ArrayList) this.f4104c.get(action);
                        if (arrayList2 != null) {
                            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                c cVar2 = (c) arrayList2.get(size2);
                                if (cVar2.f4111b == broadcastReceiver) {
                                    cVar2.f4113d = true;
                                    arrayList2.remove(size2);
                                }
                            }
                            if (arrayList2.size() <= 0) {
                                this.f4104c.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
