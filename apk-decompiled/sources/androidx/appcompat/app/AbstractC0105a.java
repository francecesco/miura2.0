package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.b;

/* JADX INFO: renamed from: androidx.appcompat.app.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0105a {

    /* JADX INFO: renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    public static class C0022a extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f995a;

        public C0022a(int i2, int i3) {
            super(i2, i3);
            this.f995a = 8388627;
        }

        public C0022a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f995a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBarLayout);
            this.f995a = typedArrayObtainStyledAttributes.getInt(R$styleable.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C0022a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f995a = 0;
        }

        public C0022a(C0022a c0022a) {
            super((ViewGroup.MarginLayoutParams) c0022a);
            this.f995a = 0;
            this.f995a = c0022a.f995a;
        }
    }

    public abstract void A(CharSequence charSequence);

    public abstract void B(CharSequence charSequence);

    public abstract androidx.appcompat.view.b C(b.a aVar);

    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i(boolean z2);

    public abstract int j();

    public abstract Context k();

    public boolean l() {
        return false;
    }

    public abstract void m(Configuration configuration);

    void n() {
    }

    public abstract boolean o(int i2, KeyEvent keyEvent);

    public boolean p(KeyEvent keyEvent) {
        return false;
    }

    public boolean q() {
        return false;
    }

    public abstract void r(Drawable drawable);

    public abstract void s(boolean z2);

    public abstract void t(boolean z2);

    public abstract void u(int i2);

    public abstract void v(Drawable drawable);

    public abstract void w(boolean z2);

    public abstract void x(boolean z2);

    public abstract void y(CharSequence charSequence);

    public abstract void z(int i2);
}
