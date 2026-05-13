package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;

/* JADX INFO: renamed from: androidx.appcompat.widget.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0130t extends PopupWindow {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f1955b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1956a;

    public C0130t(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet, i2, i3);
    }

    private void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        e0 e0VarU = e0.u(context, attributeSet, R$styleable.PopupWindow, i2, i3);
        if (e0VarU.r(R$styleable.PopupWindow_overlapAnchor)) {
            b(e0VarU.a(R$styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(e0VarU.f(R$styleable.PopupWindow_android_popupBackground));
        e0VarU.w();
    }

    private void b(boolean z2) {
        if (f1955b) {
            this.f1956a = z2;
        } else {
            androidx.core.widget.g.a(this, z2);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3) {
        if (f1955b && this.f1956a) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i2, int i3, int i4, int i5) {
        if (f1955b && this.f1956a) {
            i3 -= view.getHeight();
        }
        super.update(view, i2, i3, i4, i5);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3, int i4) {
        if (f1955b && this.f1956a) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3, i4);
    }
}
