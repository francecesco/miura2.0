package androidx.core.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import o.AbstractC0234c;

/* JADX INFO: loaded from: classes.dex */
public abstract class m implements Spannable {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextPaint f2256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextDirectionHeuristic f2257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f2258c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f2259d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final PrecomputedText.Params f2260e;

        /* JADX INFO: renamed from: androidx.core.text.m$a$a, reason: collision with other inner class name */
        public static class C0036a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final TextPaint f2261a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private TextDirectionHeuristic f2262b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f2263c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f2264d;

            public C0036a(TextPaint textPaint) {
                this.f2261a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f2263c = 1;
                    this.f2264d = 1;
                } else {
                    this.f2264d = 0;
                    this.f2263c = 0;
                }
                this.f2262b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            public a a() {
                return new a(this.f2261a, this.f2262b, this.f2263c, this.f2264d);
            }

            public C0036a b(int i2) {
                this.f2263c = i2;
                return this;
            }

            public C0036a c(int i2) {
                this.f2264d = i2;
                return this;
            }

            public C0036a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f2262b = textDirectionHeuristic;
                return this;
            }
        }

        public a(PrecomputedText.Params params) {
            this.f2256a = params.getTextPaint();
            this.f2257b = params.getTextDirection();
            this.f2258c = params.getBreakStrategy();
            this.f2259d = params.getHyphenationFrequency();
            this.f2260e = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        public boolean a(a aVar) {
            int i2 = Build.VERSION.SDK_INT;
            if ((i2 >= 23 && (this.f2258c != aVar.b() || this.f2259d != aVar.c())) || this.f2256a.getTextSize() != aVar.e().getTextSize() || this.f2256a.getTextScaleX() != aVar.e().getTextScaleX() || this.f2256a.getTextSkewX() != aVar.e().getTextSkewX() || this.f2256a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.f2256a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) || this.f2256a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            if (i2 >= 24) {
                if (!this.f2256a.getTextLocales().equals(aVar.e().getTextLocales())) {
                    return false;
                }
            } else if (!this.f2256a.getTextLocale().equals(aVar.e().getTextLocale())) {
                return false;
            }
            return this.f2256a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f2256a.getTypeface().equals(aVar.e().getTypeface());
        }

        public int b() {
            return this.f2258c;
        }

        public int c() {
            return this.f2259d;
        }

        public TextDirectionHeuristic d() {
            return this.f2257b;
        }

        public TextPaint e() {
            return this.f2256a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f2257b == aVar.d();
        }

        public int hashCode() {
            return Build.VERSION.SDK_INT >= 24 ? AbstractC0234c.b(Float.valueOf(this.f2256a.getTextSize()), Float.valueOf(this.f2256a.getTextScaleX()), Float.valueOf(this.f2256a.getTextSkewX()), Float.valueOf(this.f2256a.getLetterSpacing()), Integer.valueOf(this.f2256a.getFlags()), this.f2256a.getTextLocales(), this.f2256a.getTypeface(), Boolean.valueOf(this.f2256a.isElegantTextHeight()), this.f2257b, Integer.valueOf(this.f2258c), Integer.valueOf(this.f2259d)) : AbstractC0234c.b(Float.valueOf(this.f2256a.getTextSize()), Float.valueOf(this.f2256a.getTextScaleX()), Float.valueOf(this.f2256a.getTextSkewX()), Float.valueOf(this.f2256a.getLetterSpacing()), Integer.valueOf(this.f2256a.getFlags()), this.f2256a.getTextLocale(), this.f2256a.getTypeface(), Boolean.valueOf(this.f2256a.isElegantTextHeight()), this.f2257b, Integer.valueOf(this.f2258c), Integer.valueOf(this.f2259d));
        }

        public String toString() {
            StringBuilder sb;
            Object textLocale;
            StringBuilder sb2 = new StringBuilder("{");
            sb2.append("textSize=" + this.f2256a.getTextSize());
            sb2.append(", textScaleX=" + this.f2256a.getTextScaleX());
            sb2.append(", textSkewX=" + this.f2256a.getTextSkewX());
            int i2 = Build.VERSION.SDK_INT;
            sb2.append(", letterSpacing=" + this.f2256a.getLetterSpacing());
            sb2.append(", elegantTextHeight=" + this.f2256a.isElegantTextHeight());
            if (i2 >= 24) {
                sb = new StringBuilder();
                sb.append(", textLocale=");
                textLocale = this.f2256a.getTextLocales();
            } else {
                sb = new StringBuilder();
                sb.append(", textLocale=");
                textLocale = this.f2256a.getTextLocale();
            }
            sb.append(textLocale);
            sb2.append(sb.toString());
            sb2.append(", typeface=" + this.f2256a.getTypeface());
            if (i2 >= 26) {
                sb2.append(", variationSettings=" + this.f2256a.getFontVariationSettings());
            }
            sb2.append(", textDir=" + this.f2257b);
            sb2.append(", breakStrategy=" + this.f2258c);
            sb2.append(", hyphenationFrequency=" + this.f2259d);
            sb2.append("}");
            return sb2.toString();
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i2, int i3) {
            this.f2260e = Build.VERSION.SDK_INT >= 29 ? c.a(textPaint).setBreakStrategy(i2).setHyphenationFrequency(i3).setTextDirection(textDirectionHeuristic).build() : null;
            this.f2256a = textPaint;
            this.f2257b = textDirectionHeuristic;
            this.f2258c = i2;
            this.f2259d = i3;
        }
    }
}
