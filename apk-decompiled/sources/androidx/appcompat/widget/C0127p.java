package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.appcompat.R$attr;

/* JADX INFO: renamed from: androidx.appcompat.widget.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0127p extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0116e f1937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0128q f1938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1939c;

    public C0127p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.imageButtonStyle);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0116e c0116e = this.f1937a;
        if (c0116e != null) {
            c0116e.b();
        }
        C0128q c0128q = this.f1938b;
        if (c0128q != null) {
            c0128q.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0116e c0116e = this.f1937a;
        if (c0116e != null) {
            return c0116e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0116e c0116e = this.f1937a;
        if (c0116e != null) {
            return c0116e.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C0128q c0128q = this.f1938b;
        if (c0128q != null) {
            return c0128q.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C0128q c0128q = this.f1938b;
        if (c0128q != null) {
            return c0128q.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f1938b.f() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0116e c0116e = this.f1937a;
        if (c0116e != null) {
            c0116e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0116e c0116e = this.f1937a;
        if (c0116e != null) {
            c0116e.g(i2);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0128q c0128q = this.f1938b;
        if (c0128q != null) {
            c0128q.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C0128q c0128q = this.f1938b;
        if (c0128q != null && drawable != null && !this.f1939c) {
            c0128q.h(drawable);
        }
        super.setImageDrawable(drawable);
        C0128q c0128q2 = this.f1938b;
        if (c0128q2 != null) {
            c0128q2.c();
            if (this.f1939c) {
                return;
            }
            this.f1938b.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i2) {
        super.setImageLevel(i2);
        this.f1939c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        this.f1938b.i(i2);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0128q c0128q = this.f1938b;
        if (c0128q != null) {
            c0128q.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0116e c0116e = this.f1937a;
        if (c0116e != null) {
            c0116e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0116e c0116e = this.f1937a;
        if (c0116e != null) {
            c0116e.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0128q c0128q = this.f1938b;
        if (c0128q != null) {
            c0128q.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0128q c0128q = this.f1938b;
        if (c0128q != null) {
            c0128q.k(mode);
        }
    }

    public C0127p(Context context, AttributeSet attributeSet, int i2) {
        super(b0.b(context), attributeSet, i2);
        this.f1939c = false;
        a0.a(this, getContext());
        C0116e c0116e = new C0116e(this);
        this.f1937a = c0116e;
        c0116e.e(attributeSet, i2);
        C0128q c0128q = new C0128q(this);
        this.f1938b = c0128q;
        c0128q.g(attributeSet, i2);
    }
}
