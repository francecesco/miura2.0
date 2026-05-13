package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: androidx.appcompat.widget.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0113b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ActionBarContainer f1794a;

    /* JADX INFO: renamed from: androidx.appcompat.widget.b$a */
    private static class a {
        public static void a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public C0113b(ActionBarContainer actionBarContainer) {
        this.f1794a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f1794a;
        if (actionBarContainer.f1457h) {
            Drawable drawable = actionBarContainer.f1456g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f1454e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f1794a;
        Drawable drawable3 = actionBarContainer2.f1455f;
        if (drawable3 == null || !actionBarContainer2.f1458i) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable;
        ActionBarContainer actionBarContainer = this.f1794a;
        if (!actionBarContainer.f1457h) {
            drawable = actionBarContainer.f1454e;
            if (drawable == null) {
                return;
            }
        } else if (actionBarContainer.f1456g == null) {
            return;
        } else {
            drawable = actionBarContainer.f1454e;
        }
        a.a(drawable, outline);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
