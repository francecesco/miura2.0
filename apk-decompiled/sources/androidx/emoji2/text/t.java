package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes.dex */
class t implements Spannable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2616a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Spannable f2617b;

    private static class a {
        static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    static class b {
        b() {
        }

        boolean a(CharSequence charSequence) {
            return false;
        }
    }

    static class c extends b {
        c() {
        }

        @Override // androidx.emoji2.text.t.b
        boolean a(CharSequence charSequence) {
            return u.a(charSequence);
        }
    }

    t(Spannable spannable) {
        this.f2617b = spannable;
    }

    private void a() {
        Spannable spannable = this.f2617b;
        if (!this.f2616a && c().a(spannable)) {
            this.f2617b = new SpannableString(spannable);
        }
        this.f2616a = true;
    }

    static b c() {
        return Build.VERSION.SDK_INT < 28 ? new b() : new c();
    }

    Spannable b() {
        return this.f2617b;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i2) {
        return this.f2617b.charAt(i2);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return a.a(this.f2617b);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return a.b(this.f2617b);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f2617b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f2617b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f2617b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public Object[] getSpans(int i2, int i3, Class cls) {
        return this.f2617b.getSpans(i2, i3, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f2617b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i2, int i3, Class cls) {
        return this.f2617b.nextSpanTransition(i2, i3, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f2617b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i2, int i3, int i4) {
        a();
        this.f2617b.setSpan(obj, i2, i3, i4);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i2, int i3) {
        return this.f2617b.subSequence(i2, i3);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f2617b.toString();
    }

    t(CharSequence charSequence) {
        this.f2617b = new SpannableString(charSequence);
    }
}
