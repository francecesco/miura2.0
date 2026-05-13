package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.core.content.res.k;
import androidx.core.graphics.h;
import it.tervis.miura.model.Peripheral;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import k.C0207a;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class g extends androidx.vectordrawable.graphics.drawable.f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f3249k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f3250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuffColorFilter f3251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ColorFilter f3252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f3254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable.ConstantState f3255g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f3256h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Matrix f3257i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Rect f3258j;

    private static class b extends f {
        b() {
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f3285b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f3284a = androidx.core.graphics.h.d(string2);
            }
            this.f3286c = k.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // androidx.vectordrawable.graphics.drawable.g.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (k.j(xmlPullParser, "pathData")) {
                TypedArray typedArrayK = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f3224d);
                f(typedArrayK, xmlPullParser);
                typedArrayK.recycle();
            }
        }

        b(b bVar) {
            super(bVar);
        }
    }

    private static class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int[] f3259e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        androidx.core.content.res.d f3260f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float f3261g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        androidx.core.content.res.d f3262h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        float f3263i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float f3264j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f3265k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        float f3266l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        float f3267m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Paint.Cap f3268n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Paint.Join f3269o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        float f3270p;

        c() {
            this.f3261g = 0.0f;
            this.f3263i = 1.0f;
            this.f3264j = 1.0f;
            this.f3265k = 0.0f;
            this.f3266l = 1.0f;
            this.f3267m = 0.0f;
            this.f3268n = Paint.Cap.BUTT;
            this.f3269o = Paint.Join.MITER;
            this.f3270p = 4.0f;
        }

        private Paint.Cap e(int i2, Paint.Cap cap) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        private Paint.Join f(int i2, Paint.Join join) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f3259e = null;
            if (k.j(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f3285b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f3284a = androidx.core.graphics.h.d(string2);
                }
                this.f3262h = k.e(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f3264j = k.f(typedArray, xmlPullParser, "fillAlpha", 12, this.f3264j);
                this.f3268n = e(k.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f3268n);
                this.f3269o = f(k.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f3269o);
                this.f3270p = k.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f3270p);
                this.f3260f = k.e(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f3263i = k.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.f3263i);
                this.f3261g = k.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f3261g);
                this.f3266l = k.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.f3266l);
                this.f3267m = k.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.f3267m);
                this.f3265k = k.f(typedArray, xmlPullParser, "trimPathStart", 5, this.f3265k);
                this.f3286c = k.g(typedArray, xmlPullParser, "fillType", 13, this.f3286c);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.g.e
        public boolean a() {
            return this.f3262h.i() || this.f3260f.i();
        }

        @Override // androidx.vectordrawable.graphics.drawable.g.e
        public boolean b(int[] iArr) {
            return this.f3260f.j(iArr) | this.f3262h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayK = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f3223c);
            h(typedArrayK, xmlPullParser, theme);
            typedArrayK.recycle();
        }

        float getFillAlpha() {
            return this.f3264j;
        }

        int getFillColor() {
            return this.f3262h.e();
        }

        float getStrokeAlpha() {
            return this.f3263i;
        }

        int getStrokeColor() {
            return this.f3260f.e();
        }

        float getStrokeWidth() {
            return this.f3261g;
        }

        float getTrimPathEnd() {
            return this.f3266l;
        }

        float getTrimPathOffset() {
            return this.f3267m;
        }

        float getTrimPathStart() {
            return this.f3265k;
        }

        void setFillAlpha(float f2) {
            this.f3264j = f2;
        }

        void setFillColor(int i2) {
            this.f3262h.k(i2);
        }

        void setStrokeAlpha(float f2) {
            this.f3263i = f2;
        }

        void setStrokeColor(int i2) {
            this.f3260f.k(i2);
        }

        void setStrokeWidth(float f2) {
            this.f3261g = f2;
        }

        void setTrimPathEnd(float f2) {
            this.f3266l = f2;
        }

        void setTrimPathOffset(float f2) {
            this.f3267m = f2;
        }

        void setTrimPathStart(float f2) {
            this.f3265k = f2;
        }

        c(c cVar) {
            super(cVar);
            this.f3261g = 0.0f;
            this.f3263i = 1.0f;
            this.f3264j = 1.0f;
            this.f3265k = 0.0f;
            this.f3266l = 1.0f;
            this.f3267m = 0.0f;
            this.f3268n = Paint.Cap.BUTT;
            this.f3269o = Paint.Join.MITER;
            this.f3270p = 4.0f;
            this.f3259e = cVar.f3259e;
            this.f3260f = cVar.f3260f;
            this.f3261g = cVar.f3261g;
            this.f3263i = cVar.f3263i;
            this.f3262h = cVar.f3262h;
            this.f3286c = cVar.f3286c;
            this.f3264j = cVar.f3264j;
            this.f3265k = cVar.f3265k;
            this.f3266l = cVar.f3266l;
            this.f3267m = cVar.f3267m;
            this.f3268n = cVar.f3268n;
            this.f3269o = cVar.f3269o;
            this.f3270p = cVar.f3270p;
        }
    }

    private static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Matrix f3271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ArrayList f3272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f3273c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f3274d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f3275e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f3276f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f3277g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f3278h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private float f3279i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Matrix f3280j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f3281k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int[] f3282l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f3283m;

        public d() {
            super();
            this.f3271a = new Matrix();
            this.f3272b = new ArrayList();
            this.f3273c = 0.0f;
            this.f3274d = 0.0f;
            this.f3275e = 0.0f;
            this.f3276f = 1.0f;
            this.f3277g = 1.0f;
            this.f3278h = 0.0f;
            this.f3279i = 0.0f;
            this.f3280j = new Matrix();
            this.f3283m = null;
        }

        private void d() {
            this.f3280j.reset();
            this.f3280j.postTranslate(-this.f3274d, -this.f3275e);
            this.f3280j.postScale(this.f3276f, this.f3277g);
            this.f3280j.postRotate(this.f3273c, 0.0f, 0.0f);
            this.f3280j.postTranslate(this.f3278h + this.f3274d, this.f3279i + this.f3275e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f3282l = null;
            this.f3273c = k.f(typedArray, xmlPullParser, "rotation", 5, this.f3273c);
            this.f3274d = typedArray.getFloat(1, this.f3274d);
            this.f3275e = typedArray.getFloat(2, this.f3275e);
            this.f3276f = k.f(typedArray, xmlPullParser, "scaleX", 3, this.f3276f);
            this.f3277g = k.f(typedArray, xmlPullParser, "scaleY", 4, this.f3277g);
            this.f3278h = k.f(typedArray, xmlPullParser, "translateX", 6, this.f3278h);
            this.f3279i = k.f(typedArray, xmlPullParser, "translateY", 7, this.f3279i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f3283m = string;
            }
            d();
        }

        @Override // androidx.vectordrawable.graphics.drawable.g.e
        public boolean a() {
            for (int i2 = 0; i2 < this.f3272b.size(); i2++) {
                if (((e) this.f3272b.get(i2)).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.g.e
        public boolean b(int[] iArr) {
            boolean zB = false;
            for (int i2 = 0; i2 < this.f3272b.size(); i2++) {
                zB |= ((e) this.f3272b.get(i2)).b(iArr);
            }
            return zB;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayK = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f3222b);
            e(typedArrayK, xmlPullParser);
            typedArrayK.recycle();
        }

        public String getGroupName() {
            return this.f3283m;
        }

        public Matrix getLocalMatrix() {
            return this.f3280j;
        }

        public float getPivotX() {
            return this.f3274d;
        }

        public float getPivotY() {
            return this.f3275e;
        }

        public float getRotation() {
            return this.f3273c;
        }

        public float getScaleX() {
            return this.f3276f;
        }

        public float getScaleY() {
            return this.f3277g;
        }

        public float getTranslateX() {
            return this.f3278h;
        }

        public float getTranslateY() {
            return this.f3279i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f3274d) {
                this.f3274d = f2;
                d();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f3275e) {
                this.f3275e = f2;
                d();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f3273c) {
                this.f3273c = f2;
                d();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f3276f) {
                this.f3276f = f2;
                d();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f3277g) {
                this.f3277g = f2;
                d();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f3278h) {
                this.f3278h = f2;
                d();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f3279i) {
                this.f3279i = f2;
                d();
            }
        }

        public d(d dVar, C0207a c0207a) {
            f bVar;
            super();
            this.f3271a = new Matrix();
            this.f3272b = new ArrayList();
            this.f3273c = 0.0f;
            this.f3274d = 0.0f;
            this.f3275e = 0.0f;
            this.f3276f = 1.0f;
            this.f3277g = 1.0f;
            this.f3278h = 0.0f;
            this.f3279i = 0.0f;
            Matrix matrix = new Matrix();
            this.f3280j = matrix;
            this.f3283m = null;
            this.f3273c = dVar.f3273c;
            this.f3274d = dVar.f3274d;
            this.f3275e = dVar.f3275e;
            this.f3276f = dVar.f3276f;
            this.f3277g = dVar.f3277g;
            this.f3278h = dVar.f3278h;
            this.f3279i = dVar.f3279i;
            this.f3282l = dVar.f3282l;
            String str = dVar.f3283m;
            this.f3283m = str;
            this.f3281k = dVar.f3281k;
            if (str != null) {
                c0207a.put(str, this);
            }
            matrix.set(dVar.f3280j);
            ArrayList arrayList = dVar.f3272b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Object obj = arrayList.get(i2);
                if (obj instanceof d) {
                    this.f3272b.add(new d((d) obj, c0207a));
                } else {
                    if (obj instanceof c) {
                        bVar = new c((c) obj);
                    } else {
                        if (!(obj instanceof b)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        bVar = new b((b) obj);
                    }
                    this.f3272b.add(bVar);
                    Object obj2 = bVar.f3285b;
                    if (obj2 != null) {
                        c0207a.put(obj2, bVar);
                    }
                }
            }
        }
    }

    private static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    private static abstract class f extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected h.b[] f3284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f3285b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f3286c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f3287d;

        public f() {
            super();
            this.f3284a = null;
            this.f3286c = 0;
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            h.b[] bVarArr = this.f3284a;
            if (bVarArr != null) {
                h.b.i(bVarArr, path);
            }
        }

        public h.b[] getPathData() {
            return this.f3284a;
        }

        public String getPathName() {
            return this.f3285b;
        }

        public void setPathData(h.b[] bVarArr) {
            if (androidx.core.graphics.h.b(this.f3284a, bVarArr)) {
                androidx.core.graphics.h.k(this.f3284a, bVarArr);
            } else {
                this.f3284a = androidx.core.graphics.h.f(bVarArr);
            }
        }

        public f(f fVar) {
            super();
            this.f3284a = null;
            this.f3286c = 0;
            this.f3285b = fVar.f3285b;
            this.f3287d = fVar.f3287d;
            this.f3284a = androidx.core.graphics.h.f(fVar.f3284a);
        }
    }

    /* JADX INFO: renamed from: androidx.vectordrawable.graphics.drawable.g$g, reason: collision with other inner class name */
    private static class C0056g {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final Matrix f3288q = new Matrix();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Path f3289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Path f3290b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Matrix f3291c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Paint f3292d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Paint f3293e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private PathMeasure f3294f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f3295g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final d f3296h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        float f3297i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float f3298j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f3299k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        float f3300l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f3301m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        String f3302n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Boolean f3303o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final C0207a f3304p;

        public C0056g() {
            this.f3291c = new Matrix();
            this.f3297i = 0.0f;
            this.f3298j = 0.0f;
            this.f3299k = 0.0f;
            this.f3300l = 0.0f;
            this.f3301m = 255;
            this.f3302n = null;
            this.f3303o = null;
            this.f3304p = new C0207a();
            this.f3296h = new d();
            this.f3289a = new Path();
            this.f3290b = new Path();
        }

        private static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            dVar.f3271a.set(matrix);
            dVar.f3271a.preConcat(dVar.f3280j);
            canvas.save();
            for (int i4 = 0; i4 < dVar.f3272b.size(); i4++) {
                e eVar = (e) dVar.f3272b.get(i4);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f3271a, canvas, i2, i3, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i2, i3, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            float f2 = i2 / this.f3299k;
            float f3 = i3 / this.f3300l;
            float fMin = Math.min(f2, f3);
            Matrix matrix = dVar.f3271a;
            this.f3291c.set(matrix);
            this.f3291c.postScale(f2, f3);
            float fE = e(matrix);
            if (fE == 0.0f) {
                return;
            }
            fVar.d(this.f3289a);
            Path path = this.f3289a;
            this.f3290b.reset();
            if (fVar.c()) {
                this.f3290b.setFillType(fVar.f3286c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f3290b.addPath(path, this.f3291c);
                canvas.clipPath(this.f3290b);
                return;
            }
            c cVar = (c) fVar;
            float f4 = cVar.f3265k;
            if (f4 != 0.0f || cVar.f3266l != 1.0f) {
                float f5 = cVar.f3267m;
                float f6 = (f4 + f5) % 1.0f;
                float f7 = (cVar.f3266l + f5) % 1.0f;
                if (this.f3294f == null) {
                    this.f3294f = new PathMeasure();
                }
                this.f3294f.setPath(this.f3289a, false);
                float length = this.f3294f.getLength();
                float f8 = f6 * length;
                float f9 = f7 * length;
                path.reset();
                if (f8 > f9) {
                    this.f3294f.getSegment(f8, length, path, true);
                    this.f3294f.getSegment(0.0f, f9, path, true);
                } else {
                    this.f3294f.getSegment(f8, f9, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f3290b.addPath(path, this.f3291c);
            if (cVar.f3262h.l()) {
                androidx.core.content.res.d dVar2 = cVar.f3262h;
                if (this.f3293e == null) {
                    Paint paint = new Paint(1);
                    this.f3293e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f3293e;
                if (dVar2.h()) {
                    Shader shaderF = dVar2.f();
                    shaderF.setLocalMatrix(this.f3291c);
                    paint2.setShader(shaderF);
                    paint2.setAlpha(Math.round(cVar.f3264j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(g.a(dVar2.e(), cVar.f3264j));
                }
                paint2.setColorFilter(colorFilter);
                this.f3290b.setFillType(cVar.f3286c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f3290b, paint2);
            }
            if (cVar.f3260f.l()) {
                androidx.core.content.res.d dVar3 = cVar.f3260f;
                if (this.f3292d == null) {
                    Paint paint3 = new Paint(1);
                    this.f3292d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f3292d;
                Paint.Join join = cVar.f3269o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.f3268n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.f3270p);
                if (dVar3.h()) {
                    Shader shaderF2 = dVar3.f();
                    shaderF2.setLocalMatrix(this.f3291c);
                    paint4.setShader(shaderF2);
                    paint4.setAlpha(Math.round(cVar.f3263i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(g.a(dVar3.e(), cVar.f3263i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f3261g * fMin * fE);
                canvas.drawPath(this.f3290b, paint4);
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fA = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            if (fMax > 0.0f) {
                return Math.abs(fA) / fMax;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            c(this.f3296h, f3288q, canvas, i2, i3, colorFilter);
        }

        public boolean f() {
            if (this.f3303o == null) {
                this.f3303o = Boolean.valueOf(this.f3296h.a());
            }
            return this.f3303o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f3296h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f3301m;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.f3301m = i2;
        }

        public C0056g(C0056g c0056g) {
            this.f3291c = new Matrix();
            this.f3297i = 0.0f;
            this.f3298j = 0.0f;
            this.f3299k = 0.0f;
            this.f3300l = 0.0f;
            this.f3301m = 255;
            this.f3302n = null;
            this.f3303o = null;
            C0207a c0207a = new C0207a();
            this.f3304p = c0207a;
            this.f3296h = new d(c0056g.f3296h, c0207a);
            this.f3289a = new Path(c0056g.f3289a);
            this.f3290b = new Path(c0056g.f3290b);
            this.f3297i = c0056g.f3297i;
            this.f3298j = c0056g.f3298j;
            this.f3299k = c0056g.f3299k;
            this.f3300l = c0056g.f3300l;
            this.f3295g = c0056g.f3295g;
            this.f3301m = c0056g.f3301m;
            this.f3302n = c0056g.f3302n;
            String str = c0056g.f3302n;
            if (str != null) {
                c0207a.put(str, this);
            }
            this.f3303o = c0056g.f3303o;
        }
    }

    private static class h extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        C0056g f3306b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ColorStateList f3307c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        PorterDuff.Mode f3308d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f3309e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Bitmap f3310f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ColorStateList f3311g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        PorterDuff.Mode f3312h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f3313i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f3314j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f3315k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Paint f3316l;

        public h() {
            this.f3307c = null;
            this.f3308d = g.f3249k;
            this.f3306b = new C0056g();
        }

        public boolean a(int i2, int i3) {
            return i2 == this.f3310f.getWidth() && i3 == this.f3310f.getHeight();
        }

        public boolean b() {
            return !this.f3315k && this.f3311g == this.f3307c && this.f3312h == this.f3308d && this.f3314j == this.f3309e && this.f3313i == this.f3306b.getRootAlpha();
        }

        public void c(int i2, int i3) {
            if (this.f3310f == null || !a(i2, i3)) {
                this.f3310f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                this.f3315k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f3310f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f3316l == null) {
                Paint paint = new Paint();
                this.f3316l = paint;
                paint.setFilterBitmap(true);
            }
            this.f3316l.setAlpha(this.f3306b.getRootAlpha());
            this.f3316l.setColorFilter(colorFilter);
            return this.f3316l;
        }

        public boolean f() {
            return this.f3306b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f3306b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f3305a;
        }

        public boolean h(int[] iArr) {
            boolean zG = this.f3306b.g(iArr);
            this.f3315k |= zG;
            return zG;
        }

        public void i() {
            this.f3311g = this.f3307c;
            this.f3312h = this.f3308d;
            this.f3313i = this.f3306b.getRootAlpha();
            this.f3314j = this.f3309e;
            this.f3315k = false;
        }

        public void j(int i2, int i3) {
            this.f3310f.eraseColor(0);
            this.f3306b.b(new Canvas(this.f3310f), i2, i3, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new g(this);
        }

        public h(h hVar) {
            this.f3307c = null;
            this.f3308d = g.f3249k;
            if (hVar != null) {
                this.f3305a = hVar.f3305a;
                C0056g c0056g = new C0056g(hVar.f3306b);
                this.f3306b = c0056g;
                if (hVar.f3306b.f3293e != null) {
                    c0056g.f3293e = new Paint(hVar.f3306b.f3293e);
                }
                if (hVar.f3306b.f3292d != null) {
                    this.f3306b.f3292d = new Paint(hVar.f3306b.f3292d);
                }
                this.f3307c = hVar.f3307c;
                this.f3308d = hVar.f3308d;
                this.f3309e = hVar.f3309e;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new g(this);
        }
    }

    private static class i extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f3317a;

        public i(Drawable.ConstantState constantState) {
            this.f3317a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f3317a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f3317a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g();
            gVar.f3248a = (VectorDrawable) this.f3317a.newDrawable();
            return gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            g gVar = new g();
            gVar.f3248a = (VectorDrawable) this.f3317a.newDrawable(resources);
            return gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            g gVar = new g();
            gVar.f3248a = (VectorDrawable) this.f3317a.newDrawable(resources, theme);
            return gVar;
        }
    }

    g() {
        this.f3254f = true;
        this.f3256h = new float[9];
        this.f3257i = new Matrix();
        this.f3258j = new Rect();
        this.f3250b = new h();
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (Color.alpha(i2) * f2)) << 24);
    }

    public static g b(Resources resources, int i2, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            g gVar = new g();
            gVar.f3248a = androidx.core.content.res.h.d(resources, i2, theme);
            gVar.f3255g = new i(gVar.f3248a.getConstantState());
            return gVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return c(resources, xml, attributeSetAsAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException | XmlPullParserException unused) {
            return null;
        }
    }

    public static g c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        g gVar = new g();
        gVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return gVar;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int i2;
        int i3;
        h hVar = this.f3250b;
        C0056g c0056g = hVar.f3306b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(c0056g.f3296h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z2 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f3272b.add(cVar);
                    if (cVar.getPathName() != null) {
                        c0056g.f3304p.put(cVar.getPathName(), cVar);
                    }
                    hVar.f3305a = cVar.f3287d | hVar.f3305a;
                    z2 = false;
                } else {
                    if ("clip-path".equals(name)) {
                        b bVar = new b();
                        bVar.e(resources, attributeSet, theme, xmlPullParser);
                        dVar.f3272b.add(bVar);
                        if (bVar.getPathName() != null) {
                            c0056g.f3304p.put(bVar.getPathName(), bVar);
                        }
                        i2 = hVar.f3305a;
                        i3 = bVar.f3287d;
                    } else if ("group".equals(name)) {
                        d dVar2 = new d();
                        dVar2.c(resources, attributeSet, theme, xmlPullParser);
                        dVar.f3272b.add(dVar2);
                        arrayDeque.push(dVar2);
                        if (dVar2.getGroupName() != null) {
                            c0056g.f3304p.put(dVar2.getGroupName(), dVar2);
                        }
                        i2 = hVar.f3305a;
                        i3 = dVar2.f3281k;
                    }
                    hVar.f3305a = i3 | i2;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z2) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.e(this) == 1;
    }

    private static PorterDuff.Mode g(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        h hVar = this.f3250b;
        C0056g c0056g = hVar.f3306b;
        hVar.f3308d = g(k.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateListC = k.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateListC != null) {
            hVar.f3307c = colorStateListC;
        }
        hVar.f3309e = k.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f3309e);
        c0056g.f3299k = k.f(typedArray, xmlPullParser, "viewportWidth", 7, c0056g.f3299k);
        float f2 = k.f(typedArray, xmlPullParser, "viewportHeight", 8, c0056g.f3300l);
        c0056g.f3300l = f2;
        if (c0056g.f3299k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f2 <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        c0056g.f3297i = typedArray.getDimension(3, c0056g.f3297i);
        float dimension = typedArray.getDimension(2, c0056g.f3298j);
        c0056g.f3298j = dimension;
        if (c0056g.f3297i <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        c0056g.setAlpha(k.f(typedArray, xmlPullParser, "alpha", 4, c0056g.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            c0056g.f3302n = string;
            c0056g.f3304p.put(string, c0056g);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f3248a;
        if (drawable == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.b(drawable);
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    Object d(String str) {
        return this.f3250b.f3306b.f3304p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f3258j);
        if (this.f3258j.width() <= 0 || this.f3258j.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f3252d;
        if (colorFilter == null) {
            colorFilter = this.f3251c;
        }
        canvas.getMatrix(this.f3257i);
        this.f3257i.getValues(this.f3256h);
        float fAbs = Math.abs(this.f3256h[0]);
        float fAbs2 = Math.abs(this.f3256h[4]);
        float fAbs3 = Math.abs(this.f3256h[1]);
        float fAbs4 = Math.abs(this.f3256h[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iMin = Math.min(Peripheral.EXPANSION_3, (int) (this.f3258j.width() * fAbs));
        int iMin2 = Math.min(Peripheral.EXPANSION_3, (int) (this.f3258j.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        Rect rect = this.f3258j;
        canvas.translate(rect.left, rect.top);
        if (f()) {
            canvas.translate(this.f3258j.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f3258j.offsetTo(0, 0);
        this.f3250b.c(iMin, iMin2);
        if (!this.f3254f) {
            this.f3250b.j(iMin, iMin2);
        } else if (!this.f3250b.b()) {
            this.f3250b.j(iMin, iMin2);
            this.f3250b.i();
        }
        this.f3250b.d(canvas, colorFilter, this.f3258j);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f3248a;
        return drawable != null ? androidx.core.graphics.drawable.a.c(drawable) : this.f3250b.f3306b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f3248a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f3250b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f3248a;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.f3252d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f3248a != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.f3248a.getConstantState());
        }
        this.f3250b.f3305a = getChangingConfigurations();
        return this.f3250b;
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f3248a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f3250b.f3306b.f3298j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f3248a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f3250b.f3306b.f3297i;
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    void h(boolean z2) {
        this.f3254f = z2;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f3248a;
        return drawable != null ? androidx.core.graphics.drawable.a.g(drawable) : this.f3250b.f3309e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f3248a;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((hVar = this.f3250b) != null && (hVar.g() || ((colorStateList = this.f3250b.f3307c) != null && colorStateList.isStateful())));
    }

    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f3253e && super.mutate() == this) {
            this.f3250b = new h(this.f3250b);
            this.f3253e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z2;
        PorterDuff.Mode mode;
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        h hVar = this.f3250b;
        ColorStateList colorStateList = hVar.f3307c;
        if (colorStateList == null || (mode = hVar.f3308d) == null) {
            z2 = false;
        } else {
            this.f3251c = j(this.f3251c, colorStateList, mode);
            invalidateSelf();
            z2 = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z2;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.f3250b.f3306b.getRootAlpha() != i2) {
            this.f3250b.f3306b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.i(drawable, z2);
        } else {
            this.f3250b.f3309e = z2;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z2) {
        super.setFilterBitmap(z2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i2) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.m(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, colorStateList);
            return;
        }
        h hVar = this.f3250b;
        if (hVar.f3307c != colorStateList) {
            hVar.f3307c = colorStateList;
            this.f3251c = j(this.f3251c, colorStateList, hVar.f3308d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, mode);
            return;
        }
        h hVar = this.f3250b;
        if (hVar.f3308d != mode) {
            hVar.f3308d = mode;
            this.f3251c = j(this.f3251c, hVar.f3307c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        Drawable drawable = this.f3248a;
        return drawable != null ? drawable.setVisible(z2, z3) : super.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    g(h hVar) {
        this.f3254f = true;
        this.f3256h = new float[9];
        this.f3257i = new Matrix();
        this.f3258j = new Rect();
        this.f3250b = hVar;
        this.f3251c = j(this.f3251c, hVar.f3307c, hVar.f3308d);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.f(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f3250b;
        hVar.f3306b = new C0056g();
        TypedArray typedArrayK = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f3221a);
        i(typedArrayK, xmlPullParser, theme);
        typedArrayK.recycle();
        hVar.f3305a = getChangingConfigurations();
        hVar.f3315k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f3251c = j(this.f3251c, hVar.f3307c, hVar.f3308d);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f3248a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f3252d = colorFilter;
            invalidateSelf();
        }
    }
}
