package androidx.core.view;

import android.view.MotionEvent;

/* JADX INFO: renamed from: androidx.core.view.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0161z {
    public static boolean a(MotionEvent motionEvent, int i2) {
        return (motionEvent.getSource() & i2) == i2;
    }
}
