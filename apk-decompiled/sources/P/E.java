package p;

import android.view.accessibility.AccessibilityRecord;

/* JADX INFO: loaded from: classes.dex */
public abstract class E {
    public static void a(AccessibilityRecord accessibilityRecord, int i2) {
        accessibilityRecord.setMaxScrollX(i2);
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i2) {
        accessibilityRecord.setMaxScrollY(i2);
    }
}
