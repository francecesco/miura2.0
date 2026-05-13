package c;

import android.content.Context;
import android.content.Intent;
import q0.d;
import q0.f;

/* JADX INFO: renamed from: c.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0188c extends AbstractC0186a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3439a = new a(null);

    /* JADX INFO: renamed from: c.c$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(d dVar) {
            this();
        }
    }

    @Override // c.AbstractC0186a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, Intent intent) {
        f.e(context, "context");
        f.e(intent, "input");
        return intent;
    }

    @Override // c.AbstractC0186a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public androidx.activity.result.a c(int i2, Intent intent) {
        return new androidx.activity.result.a(i2, intent);
    }
}
