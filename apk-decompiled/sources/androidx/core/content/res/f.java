package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.R$styleable;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
abstract class f {

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f2143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float[] f2144b;

        a(int i2, int i3) {
            this.f2143a = new int[]{i2, i3};
            this.f2144b = new float[]{0.0f, 1.0f};
        }

        a(int i2, int i3, int i4) {
            this.f2143a = new int[]{i2, i3, i4};
            this.f2144b = new float[]{0.0f, 0.5f, 1.0f};
        }

        a(List list, List list2) {
            int size = list.size();
            this.f2143a = new int[size];
            this.f2144b = new float[size];
            for (int i2 = 0; i2 < size; i2++) {
                this.f2143a[i2] = ((Integer) list.get(i2)).intValue();
                this.f2144b[i2] = ((Float) list2.get(i2)).floatValue();
            }
        }
    }

    private static a a(a aVar, int i2, int i3, boolean z2, int i4) {
        return aVar != null ? aVar : z2 ? new a(i2, i4, i3) : new a(i2, i3);
    }

    static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray typedArrayK = k.k(resources, theme, attributeSet, R$styleable.GradientColor);
        float f2 = k.f(typedArrayK, xmlPullParser, "startX", R$styleable.GradientColor_android_startX, 0.0f);
        float f3 = k.f(typedArrayK, xmlPullParser, "startY", R$styleable.GradientColor_android_startY, 0.0f);
        float f4 = k.f(typedArrayK, xmlPullParser, "endX", R$styleable.GradientColor_android_endX, 0.0f);
        float f5 = k.f(typedArrayK, xmlPullParser, "endY", R$styleable.GradientColor_android_endY, 0.0f);
        float f6 = k.f(typedArrayK, xmlPullParser, "centerX", R$styleable.GradientColor_android_centerX, 0.0f);
        float f7 = k.f(typedArrayK, xmlPullParser, "centerY", R$styleable.GradientColor_android_centerY, 0.0f);
        int iG = k.g(typedArrayK, xmlPullParser, "type", R$styleable.GradientColor_android_type, 0);
        int iB = k.b(typedArrayK, xmlPullParser, "startColor", R$styleable.GradientColor_android_startColor, 0);
        boolean zJ = k.j(xmlPullParser, "centerColor");
        int iB2 = k.b(typedArrayK, xmlPullParser, "centerColor", R$styleable.GradientColor_android_centerColor, 0);
        int iB3 = k.b(typedArrayK, xmlPullParser, "endColor", R$styleable.GradientColor_android_endColor, 0);
        int iG2 = k.g(typedArrayK, xmlPullParser, "tileMode", R$styleable.GradientColor_android_tileMode, 0);
        float f8 = k.f(typedArrayK, xmlPullParser, "gradientRadius", R$styleable.GradientColor_android_gradientRadius, 0.0f);
        typedArrayK.recycle();
        a aVarA = a(c(resources, xmlPullParser, attributeSet, theme), iB, iB3, zJ, iB2);
        if (iG != 1) {
            return iG != 2 ? new LinearGradient(f2, f3, f4, f5, aVarA.f2143a, aVarA.f2144b, d(iG2)) : new SweepGradient(f6, f7, aVarA.f2143a, aVarA.f2144b);
        }
        if (f8 > 0.0f) {
            return new RadialGradient(f6, f7, f8, aVarA.f2143a, aVarA.f2144b, d(iG2));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0089, code lost:
    
        if (r4.size() <= 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0090, code lost:
    
        return new androidx.core.content.res.f.a(r4, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0091, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static androidx.core.content.res.f.a c(android.content.res.Resources r8, org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.content.res.Resources.Theme r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r9.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L12:
            int r3 = r9.next()
            if (r3 == r1) goto L85
            int r5 = r9.getDepth()
            if (r5 >= r0) goto L21
            r6 = 3
            if (r3 == r6) goto L85
        L21:
            r6 = 2
            if (r3 == r6) goto L25
            goto L12
        L25:
            if (r5 > r0) goto L12
            java.lang.String r3 = r9.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L34
            goto L12
        L34:
            int[] r3 = androidx.core.R$styleable.GradientColorItem
            android.content.res.TypedArray r3 = androidx.core.content.res.k.k(r8, r11, r10, r3)
            int r5 = androidx.core.R$styleable.GradientColorItem_android_color
            boolean r5 = r3.hasValue(r5)
            int r6 = androidx.core.R$styleable.GradientColorItem_android_offset
            boolean r6 = r3.hasValue(r6)
            if (r5 == 0) goto L6a
            if (r6 == 0) goto L6a
            int r5 = androidx.core.R$styleable.GradientColorItem_android_color
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            int r6 = androidx.core.R$styleable.GradientColorItem_android_offset
            r7 = 0
            float r6 = r3.getFloat(r6, r7)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L12
        L6a:
            org.xmlpull.v1.XmlPullParserException r8 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r9 = r9.getPositionDescription()
            r10.append(r9)
            java.lang.String r9 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        L85:
            int r8 = r4.size()
            if (r8 <= 0) goto L91
            androidx.core.content.res.f$a r8 = new androidx.core.content.res.f$a
            r8.<init>(r4, r2)
            return r8
        L91:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.f.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):androidx.core.content.res.f$a");
    }

    private static Shader.TileMode d(int i2) {
        return i2 != 1 ? i2 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT;
    }
}
