package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;

/* JADX INFO: loaded from: classes.dex */
public abstract class StatsEvent extends L.a implements ReflectedParcelable {
    public abstract int a();

    public abstract long b();

    public abstract long c();

    public abstract String d();

    public String toString() {
        long jB = b();
        int iA = a();
        long jC = c();
        String strD = d();
        StringBuilder sb = new StringBuilder(String.valueOf(strD).length() + 53);
        sb.append(jB);
        sb.append("\t");
        sb.append(iA);
        sb.append("\t");
        sb.append(jC);
        sb.append(strD);
        return sb.toString();
    }
}
