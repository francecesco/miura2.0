package it.tervis.miura.model;

import j0.d;

/* JADX INFO: loaded from: classes.dex */
public class NPI {
    public static final int[] NPI_ZONES_CAUSES = {2, 3, 4};
    public static final int[] NPI_PERIPHERALS_CAUSES = {8, 9, 10};

    public static boolean hasZoneCause(int i2, int i3) {
        d.a("Checking NPI cause for mask " + Integer.toBinaryString(i2) + " with " + i3);
        return i3 != 2 ? i3 != 3 ? i3 == 4 && (i2 & 8) != 0 : (i2 & 4) != 0 : (i2 & 2) != 0;
    }
}
