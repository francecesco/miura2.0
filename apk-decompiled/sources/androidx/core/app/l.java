package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.k;
import androidx.core.graphics.drawable.IconCompat;
import it.tervis.miura.model.Peripheral;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k.C0208b;

/* JADX INFO: loaded from: classes.dex */
class l implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Notification.Builder f2095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k.d f2096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RemoteViews f2097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RemoteViews f2098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f2099f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Bundle f2100g = new Bundle();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2101h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RemoteViews f2102i;

    static class a {
        static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        static Notification.Action.Builder e(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i2, charSequence, pendingIntent);
        }

        static String f(Notification notification) {
            return notification.getGroup();
        }

        static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        static Notification.Builder h(Notification.Builder builder, boolean z2) {
            return builder.setGroupSummary(z2);
        }

        static Notification.Builder i(Notification.Builder builder, boolean z2) {
            return builder.setLocalOnly(z2);
        }

        static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    static class b {
        static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        static Notification.Builder c(Notification.Builder builder, int i2) {
            return builder.setColor(i2);
        }

        static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        static Notification.Builder f(Notification.Builder builder, int i2) {
            return builder.setVisibility(i2);
        }
    }

    static class c {
        static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        static Notification.Builder b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        static Notification.Builder c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    static class d {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z2) {
            return builder.setAllowGeneratedReplies(z2);
        }

        static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    static class e {
        static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        static Notification.Builder b(Notification.Builder builder, int i2) {
            return builder.setBadgeIconType(i2);
        }

        static Notification.Builder c(Notification.Builder builder, boolean z2) {
            return builder.setColorized(z2);
        }

        static Notification.Builder d(Notification.Builder builder, int i2) {
            return builder.setGroupAlertBehavior(i2);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        static Notification.Builder g(Notification.Builder builder, long j2) {
            return builder.setTimeoutAfter(j2);
        }
    }

    static class f {
        static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, int i2) {
            return builder.setSemanticAction(i2);
        }
    }

    static class g {
        static Notification.Builder a(Notification.Builder builder, boolean z2) {
            return builder.setAllowSystemGeneratedContextualActions(z2);
        }

        static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z2) {
            return builder.setContextual(z2);
        }

        static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    static class h {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z2) {
            return builder.setAuthenticationRequired(z2);
        }

        static Notification.Builder b(Notification.Builder builder, int i2) {
            return builder.setForegroundServiceBehavior(i2);
        }
    }

    l(k.d dVar) {
        int i2;
        Object obj;
        this.f2096c = dVar;
        Context context = dVar.f2064a;
        this.f2094a = context;
        int i3 = Build.VERSION.SDK_INT;
        this.f2095b = i3 >= 26 ? e.a(context, dVar.f2053K) : new Notification.Builder(dVar.f2064a);
        Notification notification = dVar.f2060R;
        this.f2095b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.f2072i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.f2068e).setContentText(dVar.f2069f).setContentInfo(dVar.f2074k).setContentIntent(dVar.f2070g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.f2071h, (notification.flags & 128) != 0).setNumber(dVar.f2075l).setProgress(dVar.f2083t, dVar.f2084u, dVar.f2085v);
        if (i3 < 23) {
            Notification.Builder builder = this.f2095b;
            IconCompat iconCompat = dVar.f2073j;
            builder.setLargeIcon(iconCompat == null ? null : iconCompat.c());
        } else {
            Notification.Builder builder2 = this.f2095b;
            IconCompat iconCompat2 = dVar.f2073j;
            c.b(builder2, iconCompat2 == null ? null : iconCompat2.l(context));
        }
        this.f2095b.setSubText(dVar.f2080q).setUsesChronometer(dVar.f2078o).setPriority(dVar.f2076m);
        Iterator it2 = dVar.f2065b.iterator();
        while (it2.hasNext()) {
            b((k.a) it2.next());
        }
        Bundle bundle = dVar.f2046D;
        if (bundle != null) {
            this.f2100g.putAll(bundle);
        }
        int i4 = Build.VERSION.SDK_INT;
        this.f2097d = dVar.f2050H;
        this.f2098e = dVar.f2051I;
        this.f2095b.setShowWhen(dVar.f2077n);
        a.i(this.f2095b, dVar.f2089z);
        a.g(this.f2095b, dVar.f2086w);
        a.j(this.f2095b, dVar.f2088y);
        a.h(this.f2095b, dVar.f2087x);
        this.f2101h = dVar.f2057O;
        b.b(this.f2095b, dVar.f2045C);
        b.c(this.f2095b, dVar.f2047E);
        b.f(this.f2095b, dVar.f2048F);
        b.d(this.f2095b, dVar.f2049G);
        b.e(this.f2095b, notification.sound, notification.audioAttributes);
        List listE = i4 < 28 ? e(f(dVar.f2066c), dVar.f2063U) : dVar.f2063U;
        if (listE != null && !listE.isEmpty()) {
            Iterator it3 = listE.iterator();
            while (it3.hasNext()) {
                b.a(this.f2095b, (String) it3.next());
            }
        }
        this.f2102i = dVar.f2052J;
        if (dVar.f2067d.size() > 0) {
            Bundle bundle2 = dVar.c().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i5 = 0; i5 < dVar.f2067d.size(); i5++) {
                bundle4.putBundle(Integer.toString(i5), m.a((k.a) dVar.f2067d.get(i5)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            dVar.c().putBundle("android.car.EXTENSIONS", bundle2);
            this.f2100g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 23 && (obj = dVar.f2062T) != null) {
            c.c(this.f2095b, obj);
        }
        if (i6 >= 24) {
            this.f2095b.setExtras(dVar.f2046D);
            d.e(this.f2095b, dVar.f2082s);
            RemoteViews remoteViews = dVar.f2050H;
            if (remoteViews != null) {
                d.c(this.f2095b, remoteViews);
            }
            RemoteViews remoteViews2 = dVar.f2051I;
            if (remoteViews2 != null) {
                d.b(this.f2095b, remoteViews2);
            }
            RemoteViews remoteViews3 = dVar.f2052J;
            if (remoteViews3 != null) {
                d.d(this.f2095b, remoteViews3);
            }
        }
        if (i6 >= 26) {
            e.b(this.f2095b, dVar.f2054L);
            e.e(this.f2095b, dVar.f2081r);
            e.f(this.f2095b, dVar.f2055M);
            e.g(this.f2095b, dVar.f2056N);
            e.d(this.f2095b, dVar.f2057O);
            if (dVar.f2044B) {
                e.c(this.f2095b, dVar.f2043A);
            }
            if (!TextUtils.isEmpty(dVar.f2053K)) {
                this.f2095b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i6 >= 28) {
            Iterator it4 = dVar.f2066c.iterator();
            if (it4.hasNext()) {
                android.support.v4.media.session.b.a(it4.next());
                throw null;
            }
        }
        if (i6 >= 29) {
            g.a(this.f2095b, dVar.f2059Q);
            g.b(this.f2095b, k.c.a(null));
        }
        if (i6 >= 31 && (i2 = dVar.f2058P) != 0) {
            h.b(this.f2095b, i2);
        }
        if (dVar.f2061S) {
            if (this.f2096c.f2087x) {
                this.f2101h = 2;
            } else {
                this.f2101h = 1;
            }
            this.f2095b.setVibrate(null);
            this.f2095b.setSound(null);
            int i7 = notification.defaults & (-4);
            notification.defaults = i7;
            this.f2095b.setDefaults(i7);
            if (i6 >= 26) {
                if (TextUtils.isEmpty(this.f2096c.f2086w)) {
                    a.g(this.f2095b, "silent");
                }
                e.d(this.f2095b, this.f2101h);
            }
        }
    }

    private void b(k.a aVar) {
        int i2 = Build.VERSION.SDK_INT;
        IconCompat iconCompatD = aVar.d();
        Notification.Action.Builder builderA = i2 >= 23 ? c.a(iconCompatD != null ? iconCompatD.k() : null, aVar.h(), aVar.a()) : a.e(iconCompatD != null ? iconCompatD.d() : 0, aVar.h(), aVar.a());
        if (aVar.e() != null) {
            for (RemoteInput remoteInput : r.b(aVar.e())) {
                a.c(builderA, remoteInput);
            }
        }
        Bundle bundle = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 24) {
            d.a(builderA, aVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", aVar.f());
        if (i3 >= 28) {
            f.b(builderA, aVar.f());
        }
        if (i3 >= 29) {
            g.c(builderA, aVar.j());
        }
        if (i3 >= 31) {
            h.a(builderA, aVar.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.g());
        a.b(builderA, bundle);
        a.a(this.f2095b, a.d(builderA));
    }

    private static List e(List list, List list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        C0208b c0208b = new C0208b(list.size() + list2.size());
        c0208b.addAll(list);
        c0208b.addAll(list2);
        return new ArrayList(c0208b);
    }

    private static List f(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it2 = list.iterator();
        if (!it2.hasNext()) {
            return arrayList;
        }
        android.support.v4.media.session.b.a(it2.next());
        throw null;
    }

    private void g(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }

    @Override // androidx.core.app.j
    public Notification.Builder a() {
        return this.f2095b;
    }

    public Notification c() {
        Bundle bundleA;
        RemoteViews remoteViewsF;
        RemoteViews remoteViewsD;
        k.e eVar = this.f2096c.f2079p;
        if (eVar != null) {
            eVar.b(this);
        }
        RemoteViews remoteViewsE = eVar != null ? eVar.e(this) : null;
        Notification notificationD = d();
        if (remoteViewsE != null || (remoteViewsE = this.f2096c.f2050H) != null) {
            notificationD.contentView = remoteViewsE;
        }
        if (eVar != null && (remoteViewsD = eVar.d(this)) != null) {
            notificationD.bigContentView = remoteViewsD;
        }
        if (eVar != null && (remoteViewsF = this.f2096c.f2079p.f(this)) != null) {
            notificationD.headsUpContentView = remoteViewsF;
        }
        if (eVar != null && (bundleA = k.a(notificationD)) != null) {
            eVar.a(bundleA);
        }
        return notificationD;
    }

    protected Notification d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            return this.f2095b.build();
        }
        if (i2 >= 24) {
            Notification notificationBuild = this.f2095b.build();
            if (this.f2101h != 0) {
                if (a.f(notificationBuild) != null && (notificationBuild.flags & Peripheral.EXPANSION_1) != 0 && this.f2101h == 2) {
                    g(notificationBuild);
                }
                if (a.f(notificationBuild) != null && (notificationBuild.flags & Peripheral.EXPANSION_1) == 0 && this.f2101h == 1) {
                    g(notificationBuild);
                }
            }
            return notificationBuild;
        }
        this.f2095b.setExtras(this.f2100g);
        Notification notificationBuild2 = this.f2095b.build();
        RemoteViews remoteViews = this.f2097d;
        if (remoteViews != null) {
            notificationBuild2.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.f2098e;
        if (remoteViews2 != null) {
            notificationBuild2.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.f2102i;
        if (remoteViews3 != null) {
            notificationBuild2.headsUpContentView = remoteViews3;
        }
        if (this.f2101h != 0) {
            if (a.f(notificationBuild2) != null && (notificationBuild2.flags & Peripheral.EXPANSION_1) != 0 && this.f2101h == 2) {
                g(notificationBuild2);
            }
            if (a.f(notificationBuild2) != null && (notificationBuild2.flags & Peripheral.EXPANSION_1) == 0 && this.f2101h == 1) {
                g(notificationBuild2);
            }
        }
        return notificationBuild2;
    }
}
