package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class d0 extends X {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference f1836b;

    public d0(Context context, Resources resources) {
        super(resources);
        this.f1836b = new WeakReference(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) {
        Drawable drawableA = a(i2);
        Context context = (Context) this.f1836b.get();
        if (drawableA != null && context != null) {
            W.h().x(context, i2, drawableA);
        }
        return drawableA;
    }
}
