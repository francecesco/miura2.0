package w;

import android.text.Editable;
import androidx.emoji2.text.o;

/* JADX INFO: renamed from: w.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0259b extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f4048a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Editable.Factory f4049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Class f4050c;

    private C0259b() {
        try {
            f4050c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, C0259b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f4049b == null) {
            synchronized (f4048a) {
                try {
                    if (f4049b == null) {
                        f4049b = new C0259b();
                    }
                } finally {
                }
            }
        }
        return f4049b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class cls = f4050c;
        return cls != null ? o.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
