package f;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;

/* JADX INFO: renamed from: f.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0194d extends Drawable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f3560m = (float) Math.toRadians(45.0d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f3561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f3562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f3563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f3564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f3565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f3566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Path f3567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f3568h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3569i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f3570j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f3571k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f3572l;

    public C0194d(Context context) {
        Paint paint = new Paint();
        this.f3561a = paint;
        this.f3567g = new Path();
        this.f3569i = false;
        this.f3572l = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R$styleable.DrawerArrowToggle, R$attr.drawerArrowStyle, R$style.Base_Widget_AppCompat_DrawerArrowToggle);
        c(typedArrayObtainStyledAttributes.getColor(R$styleable.DrawerArrowToggle_color, 0));
        b(typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_thickness, 0.0f));
        f(typedArrayObtainStyledAttributes.getBoolean(R$styleable.DrawerArrowToggle_spinBars, true));
        d(Math.round(typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.f3568h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DrawerArrowToggle_drawableSize, 0);
        this.f3563c = Math.round(typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_barLength, 0.0f));
        this.f3562b = Math.round(typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.f3564d = typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    private static float a(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * f4);
    }

    public void b(float f2) {
        if (this.f3561a.getStrokeWidth() != f2) {
            this.f3561a.setStrokeWidth(f2);
            this.f3571k = (float) (((double) (f2 / 2.0f)) * Math.cos(f3560m));
            invalidateSelf();
        }
    }

    public void c(int i2) {
        if (i2 != this.f3561a.getColor()) {
            this.f3561a.setColor(i2);
            invalidateSelf();
        }
    }

    public void d(float f2) {
        if (f2 != this.f3565e) {
            this.f3565e = f2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i2 = this.f3572l;
        boolean z2 = false;
        if (i2 != 0 && (i2 == 1 || (i2 == 3 ? androidx.core.graphics.drawable.a.e(this) == 0 : androidx.core.graphics.drawable.a.e(this) == 1))) {
            z2 = true;
        }
        float f2 = this.f3562b;
        float fA = a(this.f3563c, (float) Math.sqrt(f2 * f2 * 2.0f), this.f3570j);
        float fA2 = a(this.f3563c, this.f3564d, this.f3570j);
        float fRound = Math.round(a(0.0f, this.f3571k, this.f3570j));
        float fA3 = a(0.0f, f3560m, this.f3570j);
        float fA4 = a(z2 ? 0.0f : -180.0f, z2 ? 180.0f : 0.0f, this.f3570j);
        double d2 = fA;
        double d3 = fA3;
        boolean z3 = z2;
        float fRound2 = Math.round(Math.cos(d3) * d2);
        float fRound3 = Math.round(d2 * Math.sin(d3));
        this.f3567g.rewind();
        float fA5 = a(this.f3565e + this.f3561a.getStrokeWidth(), -this.f3571k, this.f3570j);
        float f3 = (-fA2) / 2.0f;
        this.f3567g.moveTo(f3 + fRound, 0.0f);
        this.f3567g.rLineTo(fA2 - (fRound * 2.0f), 0.0f);
        this.f3567g.moveTo(f3, fA5);
        this.f3567g.rLineTo(fRound2, fRound3);
        this.f3567g.moveTo(f3, -fA5);
        this.f3567g.rLineTo(fRound2, -fRound3);
        this.f3567g.close();
        canvas.save();
        float strokeWidth = this.f3561a.getStrokeWidth();
        float fHeight = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), ((((int) (fHeight - (2.0f * r5))) / 4) * 2) + (strokeWidth * 1.5f) + this.f3565e);
        if (this.f3566f) {
            canvas.rotate(fA4 * (this.f3569i ^ z3 ? -1 : 1));
        } else if (z3) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f3567g, this.f3561a);
        canvas.restore();
    }

    public void e(float f2) {
        if (this.f3570j != f2) {
            this.f3570j = f2;
            invalidateSelf();
        }
    }

    public void f(boolean z2) {
        if (this.f3566f != z2) {
            this.f3566f = z2;
            invalidateSelf();
        }
    }

    public void g(boolean z2) {
        if (this.f3569i != z2) {
            this.f3569i = z2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f3568h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f3568h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (i2 != this.f3561a.getAlpha()) {
            this.f3561a.setAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3561a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
