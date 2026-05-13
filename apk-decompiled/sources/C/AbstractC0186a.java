package c;

import android.content.Context;
import android.content.Intent;
import q0.f;

/* JADX INFO: renamed from: c.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0186a {

    /* JADX INFO: renamed from: c.a$a, reason: collision with other inner class name */
    public static final class C0057a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f3437a;

        public C0057a(Object obj) {
            this.f3437a = obj;
        }

        public final Object a() {
            return this.f3437a;
        }
    }

    public abstract Intent a(Context context, Object obj);

    public C0057a b(Context context, Object obj) {
        f.e(context, "context");
        return null;
    }

    public abstract Object c(int i2, Intent intent);
}
