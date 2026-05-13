package com.google.android.gms.common.api;

import K.d;
import L.c;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class Status extends L.a implements ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f3465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PendingIntent f3466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Status f3456e = new Status(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Status f3457f = new Status(14);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Status f3458g = new Status(8);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Status f3459h = new Status(15);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Status f3460i = new Status(16);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Status f3461j = new Status(17);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Status f3462k = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new a();

    public Status(int i2) {
        this(i2, null);
    }

    public final int a() {
        return this.f3464b;
    }

    public final String b() {
        return this.f3465c;
    }

    public final String c() {
        String str = this.f3465c;
        return str != null ? str : H.a.a(this.f3464b);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f3463a == status.f3463a && this.f3464b == status.f3464b && d.a(this.f3465c, status.f3465c) && d.a(this.f3466d, status.f3466d);
    }

    public final int hashCode() {
        return d.b(Integer.valueOf(this.f3463a), Integer.valueOf(this.f3464b), this.f3465c, this.f3466d);
    }

    public final String toString() {
        return d.c(this).a("statusCode", c()).a("resolution", this.f3466d).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = c.a(parcel);
        c.d(parcel, 1, a());
        c.g(parcel, 2, b(), false);
        c.f(parcel, 3, this.f3466d, i2, false);
        c.d(parcel, 1000, this.f3463a);
        c.b(parcel, iA);
    }

    Status(int i2, int i3, String str, PendingIntent pendingIntent) {
        this.f3463a = i2;
        this.f3464b = i3;
        this.f3465c = str;
        this.f3466d = pendingIntent;
    }

    public Status(int i2, String str) {
        this(1, i2, str, null);
    }
}
