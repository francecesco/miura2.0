package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import androidx.emoji2.text.f;

/* JADX INFO: loaded from: classes.dex */
class e implements f.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal f2525b = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextPaint f2526a;

    e() {
        TextPaint textPaint = new TextPaint();
        this.f2526a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    private static StringBuilder b() {
        ThreadLocal threadLocal = f2525b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return (StringBuilder) threadLocal.get();
    }

    @Override // androidx.emoji2.text.f.e
    public boolean a(CharSequence charSequence, int i2, int i3, int i4) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 23 && i4 > i5) {
            return false;
        }
        StringBuilder sbB = b();
        sbB.setLength(0);
        while (i2 < i3) {
            sbB.append(charSequence.charAt(i2));
            i2++;
        }
        return androidx.core.graphics.g.a(this.f2526a, sbB.toString());
    }
}
