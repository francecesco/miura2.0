package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.R$attr;

/* JADX INFO: renamed from: androidx.appcompat.widget.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0133w extends RatingBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0131u f1964a;

    public C0133w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.ratingBarStyle);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        Bitmap bitmapB = this.f1964a.b();
        if (bitmapB != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmapB.getWidth() * getNumStars(), i2, 0), getMeasuredHeight());
        }
    }

    public C0133w(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a0.a(this, getContext());
        C0131u c0131u = new C0131u(this);
        this.f1964a = c0131u;
        c0131u.c(attributeSet, i2);
    }
}
