package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;

/* JADX INFO: loaded from: classes.dex */
class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f1929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextView f1930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WindowManager.LayoutParams f1931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Rect f1932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f1933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f1934g;

    n0(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f1931d = layoutParams;
        this.f1932e = new Rect();
        this.f1933f = new int[2];
        this.f1934g = new int[2];
        this.f1928a = context;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.abc_tooltip, (ViewGroup) null);
        this.f1929b = viewInflate;
        this.f1930c = (TextView) viewInflate.findViewById(R$id.message);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R$style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    private void a(View view, int i2, int i3, boolean z2, WindowManager.LayoutParams layoutParams) {
        int height;
        int i4;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1928a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i2 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1928a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_extra_offset);
            height = i3 + dimensionPixelOffset2;
            i4 = i3 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i4 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1928a.getResources().getDimensionPixelOffset(z2 ? R$dimen.tooltip_y_offset_touch : R$dimen.tooltip_y_offset_non_touch);
        View viewB = b(view);
        if (viewB == null) {
            return;
        }
        viewB.getWindowVisibleDisplayFrame(this.f1932e);
        Rect rect = this.f1932e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f1928a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1932e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewB.getLocationOnScreen(this.f1934g);
        view.getLocationOnScreen(this.f1933f);
        int[] iArr = this.f1933f;
        int i5 = iArr[0];
        int[] iArr2 = this.f1934g;
        int i6 = i5 - iArr2[0];
        iArr[0] = i6;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i6 + i2) - (viewB.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1929b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f1929b.getMeasuredHeight();
        int i7 = this.f1933f[1];
        int i8 = ((i4 + i7) - dimensionPixelOffset3) - measuredHeight;
        int i9 = i7 + height + dimensionPixelOffset3;
        if (!z2 ? measuredHeight + i9 <= this.f1932e.height() : i8 < 0) {
            layoutParams.y = i8;
        } else {
            layoutParams.y = i9;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    void c() {
        if (d()) {
            ((WindowManager) this.f1928a.getSystemService("window")).removeView(this.f1929b);
        }
    }

    boolean d() {
        return this.f1929b.getParent() != null;
    }

    void e(View view, int i2, int i3, boolean z2, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f1930c.setText(charSequence);
        a(view, i2, i3, z2, this.f1931d);
        ((WindowManager) this.f1928a.getSystemService("window")).addView(this.f1929b, this.f1931d);
    }
}
