package androidx.appcompat.app;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.b;
import androidx.core.view.AbstractC0155t;

/* JADX INFO: loaded from: classes.dex */
public abstract class y extends androidx.activity.i implements InterfaceC0109e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AbstractC0111g f1136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AbstractC0155t.a f1137e;

    public y(Context context, int i2) {
        super(context, h(context, i2));
        this.f1137e = new AbstractC0155t.a() { // from class: androidx.appcompat.app.x
            @Override // androidx.core.view.AbstractC0155t.a
            public final boolean q(KeyEvent keyEvent) {
                return this.f1135a.i(keyEvent);
            }
        };
        AbstractC0111g abstractC0111gG = g();
        abstractC0111gG.M(h(context, i2));
        abstractC0111gG.y(null);
    }

    private void e() {
        androidx.lifecycle.F.a(getWindow().getDecorView(), this);
        A.d.a(getWindow().getDecorView(), this);
        androidx.activity.q.a(getWindow().getDecorView(), this);
    }

    private static int h(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.appcompat.app.InterfaceC0109e
    public void C(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.appcompat.app.InterfaceC0109e
    public androidx.appcompat.view.b I(b.a aVar) {
        return null;
    }

    @Override // androidx.activity.i, android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        g().e(view, layoutParams);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        g().z();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return AbstractC0155t.e(this.f1137e, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public View findViewById(int i2) {
        return g().j(i2);
    }

    public AbstractC0111g g() {
        if (this.f1136d == null) {
            this.f1136d = AbstractC0111g.i(this, this);
        }
        return this.f1136d;
    }

    boolean i(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        g().u();
    }

    public boolean j(int i2) {
        return g().H(i2);
    }

    @Override // androidx.activity.i, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        g().t();
        super.onCreate(bundle);
        g().y(bundle);
    }

    @Override // androidx.activity.i, android.app.Dialog
    protected void onStop() {
        super.onStop();
        g().E();
    }

    @Override // androidx.activity.i, android.app.Dialog
    public void setContentView(int i2) {
        e();
        g().I(i2);
    }

    @Override // android.app.Dialog
    public void setTitle(int i2) {
        super.setTitle(i2);
        g().N(getContext().getString(i2));
    }

    @Override // androidx.appcompat.app.InterfaceC0109e
    public void u(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.activity.i, android.app.Dialog
    public void setContentView(View view) {
        e();
        g().J(view);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        g().N(charSequence);
    }

    @Override // androidx.activity.i, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        e();
        g().K(view, layoutParams);
    }
}
