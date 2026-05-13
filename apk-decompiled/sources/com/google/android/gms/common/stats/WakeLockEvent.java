package com.google.android.gms.common.stats;

import L.c;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f3468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f3470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f3471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f3472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f3473g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f3474h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f3475i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f3476j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3477k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f3478l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final float f3479m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f3480n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f3481o;

    WakeLockEvent(int i2, long j2, int i3, String str, int i4, List list, String str2, long j3, int i5, String str3, String str4, float f2, long j4, String str5) {
        this.f3467a = i2;
        this.f3468b = j2;
        this.f3469c = i3;
        this.f3470d = str;
        this.f3471e = str3;
        this.f3472f = str5;
        this.f3473g = i4;
        this.f3481o = -1L;
        this.f3474h = list;
        this.f3475i = str2;
        this.f3476j = j3;
        this.f3477k = i5;
        this.f3478l = str4;
        this.f3479m = f2;
        this.f3480n = j4;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int a() {
        return this.f3469c;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long b() {
        return this.f3468b;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long c() {
        return this.f3481o;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String d() {
        String str = this.f3470d;
        int i2 = this.f3473g;
        List list = this.f3474h;
        String strJoin = list == null ? "" : TextUtils.join(",", list);
        int i3 = this.f3477k;
        String str2 = this.f3471e;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.f3478l;
        if (str3 == null) {
            str3 = "";
        }
        float f2 = this.f3479m;
        String str4 = this.f3472f;
        String str5 = str4 != null ? str4 : "";
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 45 + String.valueOf(strJoin).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str5).length());
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(strJoin);
        sb.append("\t");
        sb.append(i3);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(f2);
        sb.append("\t");
        sb.append(str5);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = c.a(parcel);
        c.d(parcel, 1, this.f3467a);
        c.e(parcel, 2, b());
        c.g(parcel, 4, this.f3470d, false);
        c.d(parcel, 5, this.f3473g);
        c.h(parcel, 6, this.f3474h, false);
        c.e(parcel, 8, this.f3476j);
        c.g(parcel, 10, this.f3471e, false);
        c.d(parcel, 11, a());
        c.g(parcel, 12, this.f3475i, false);
        c.g(parcel, 13, this.f3478l, false);
        c.d(parcel, 14, this.f3477k);
        c.c(parcel, 15, this.f3479m);
        c.e(parcel, 16, this.f3480n);
        c.g(parcel, 17, this.f3472f, false);
        c.b(parcel, iA);
    }

    public WakeLockEvent(long j2, int i2, String str, int i3, List list, String str2, long j3, int i4, String str3, String str4, float f2, long j4, String str5) {
        this(2, j2, i2, str, i3, list, str2, j3, i4, str3, str4, f2, j4, str5);
    }
}
