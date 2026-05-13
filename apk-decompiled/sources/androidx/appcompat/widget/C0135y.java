package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$attr;

/* JADX INFO: renamed from: androidx.appcompat.widget.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0135y extends SeekBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0136z f1965a;

    public C0135y(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.seekBarStyle);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f1965a.h();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f1965a.i();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1965a.g(canvas);
    }

    public C0135y(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a0.a(this, getContext());
        C0136z c0136z = new C0136z(this);
        this.f1965a = c0136z;
        c0136z.c(attributeSet, i2);
    }
}
