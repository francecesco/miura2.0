package W;

import X.g;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0166e;
import it.tervis.miura.R;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends DialogInterfaceOnCancelListenerC0166e {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    protected g f414s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    protected View f415t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    protected Handler f416u0 = new Handler();
    protected LayoutInflater v0;

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0166e, androidx.fragment.app.Fragment
    public void J0() {
        super.J0();
        this.v0 = i().getLayoutInflater();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void i0(Activity activity) {
        super.i0(activity);
        this.f414s0 = (g) activity;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0166e, androidx.fragment.app.Fragment
    public void m0(Bundle bundle) {
        super.m0(bundle);
        V1(1, R.style.DialogStyle);
    }
}
