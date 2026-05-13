package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.AbstractC0183g;
import androidx.lifecycle.F;

/* JADX INFO: loaded from: classes.dex */
public class i extends Dialog implements androidx.lifecycle.l, o, A.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private androidx.lifecycle.m f779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final A.b f780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final OnBackPressedDispatcher f781c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, int i2) {
        super(context, i2);
        q0.f.e(context, "context");
        this.f780b = A.b.f1d.a(this);
        this.f781c = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.h
            @Override // java.lang.Runnable
            public final void run() {
                i.f(this.f778a);
            }
        });
    }

    private final androidx.lifecycle.m b() {
        androidx.lifecycle.m mVar = this.f779a;
        if (mVar != null) {
            return mVar;
        }
        androidx.lifecycle.m mVar2 = new androidx.lifecycle.m(this);
        this.f779a = mVar2;
        return mVar2;
    }

    private final void e() {
        Window window = getWindow();
        q0.f.b(window);
        View decorView = window.getDecorView();
        q0.f.d(decorView, "window!!.decorView");
        F.a(decorView, this);
        Window window2 = getWindow();
        q0.f.b(window2);
        View decorView2 = window2.getDecorView();
        q0.f.d(decorView2, "window!!.decorView");
        q.a(decorView2, this);
        Window window3 = getWindow();
        q0.f.b(window3);
        View decorView3 = window3.getDecorView();
        q0.f.d(decorView3, "window!!.decorView");
        A.d.a(decorView3, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(i iVar) {
        q0.f.e(iVar, "this$0");
        super.onBackPressed();
    }

    @Override // androidx.lifecycle.l
    public AbstractC0183g G() {
        return b();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        q0.f.e(view, "view");
        e();
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.activity.o
    public final OnBackPressedDispatcher c() {
        return this.f781c;
    }

    @Override // A.c
    public androidx.savedstate.a d() {
        return this.f780b.b();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.f781c.e();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackPressedDispatcher onBackPressedDispatcher = this.f781c;
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            q0.f.d(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            onBackPressedDispatcher.f(onBackInvokedDispatcher);
        }
        this.f780b.d(bundle);
        b().h(AbstractC0183g.a.ON_CREATE);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        q0.f.d(bundleOnSaveInstanceState, "super.onSaveInstanceState()");
        this.f780b.e(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        b().h(AbstractC0183g.a.ON_RESUME);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        b().h(AbstractC0183g.a.ON_DESTROY);
        this.f779a = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i2) {
        e();
        super.setContentView(i2);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        q0.f.e(view, "view");
        e();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        q0.f.e(view, "view");
        e();
        super.setContentView(view, layoutParams);
    }
}
