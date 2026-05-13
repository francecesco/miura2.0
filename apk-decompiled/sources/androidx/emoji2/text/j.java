package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import o.AbstractC0236e;

/* JADX INFO: loaded from: classes.dex */
public abstract class j extends ReplacementSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p f2581b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint.FontMetricsInt f2580a = new Paint.FontMetricsInt();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private short f2582c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private short f2583d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f2584e = 1.0f;

    j(p pVar) {
        AbstractC0236e.g(pVar, "rasterizer cannot be null");
        this.f2581b = pVar;
    }

    public final p a() {
        return this.f2581b;
    }

    final int b() {
        return this.f2582c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f2580a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f2580a;
        this.f2584e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f2581b.e();
        this.f2583d = (short) (this.f2581b.e() * this.f2584e);
        short sI = (short) (this.f2581b.i() * this.f2584e);
        this.f2582c = sI;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f2580a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sI;
    }
}
