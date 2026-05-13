package androidx.fragment.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* JADX INFO: renamed from: androidx.fragment.app.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class DialogInterfaceOnCancelListenerC0166e extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private Handler f2896c0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private boolean f2905l0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private Dialog f2907n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private boolean f2908o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private boolean f2909p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private boolean f2910q0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private Runnable f2897d0 = new a();

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private DialogInterface.OnCancelListener f2898e0 = new b();

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private DialogInterface.OnDismissListener f2899f0 = new c();

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private int f2900g0 = 0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private int f2901h0 = 0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private boolean f2902i0 = true;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private boolean f2903j0 = true;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private int f2904k0 = -1;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private androidx.lifecycle.q f2906m0 = new d();

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private boolean f2911r0 = false;

    /* JADX INFO: renamed from: androidx.fragment.app.e$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DialogInterfaceOnCancelListenerC0166e.this.f2899f0.onDismiss(DialogInterfaceOnCancelListenerC0166e.this.f2907n0);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.e$b */
    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (DialogInterfaceOnCancelListenerC0166e.this.f2907n0 != null) {
                DialogInterfaceOnCancelListenerC0166e dialogInterfaceOnCancelListenerC0166e = DialogInterfaceOnCancelListenerC0166e.this;
                dialogInterfaceOnCancelListenerC0166e.onCancel(dialogInterfaceOnCancelListenerC0166e.f2907n0);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.e$c */
    class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (DialogInterfaceOnCancelListenerC0166e.this.f2907n0 != null) {
                DialogInterfaceOnCancelListenerC0166e dialogInterfaceOnCancelListenerC0166e = DialogInterfaceOnCancelListenerC0166e.this;
                dialogInterfaceOnCancelListenerC0166e.onDismiss(dialogInterfaceOnCancelListenerC0166e.f2907n0);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.e$d */
    class d implements androidx.lifecycle.q {
        d() {
        }

        @Override // androidx.lifecycle.q
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.lifecycle.l lVar) {
            if (lVar == null || !DialogInterfaceOnCancelListenerC0166e.this.f2903j0) {
                return;
            }
            View viewO1 = DialogInterfaceOnCancelListenerC0166e.this.o1();
            if (viewO1.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (DialogInterfaceOnCancelListenerC0166e.this.f2907n0 != null) {
                if (x.H0(3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("DialogFragment ");
                    sb.append(this);
                    sb.append(" setting the content view on ");
                    sb.append(DialogInterfaceOnCancelListenerC0166e.this.f2907n0);
                }
                DialogInterfaceOnCancelListenerC0166e.this.f2907n0.setContentView(viewO1);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.e$e, reason: collision with other inner class name */
    class C0045e extends AbstractC0173l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractC0173l f2916a;

        C0045e(AbstractC0173l abstractC0173l) {
            this.f2916a = abstractC0173l;
        }

        @Override // androidx.fragment.app.AbstractC0173l
        public View e(int i2) {
            return this.f2916a.j() ? this.f2916a.e(i2) : DialogInterfaceOnCancelListenerC0166e.this.Q1(i2);
        }

        @Override // androidx.fragment.app.AbstractC0173l
        public boolean j() {
            return this.f2916a.j() || DialogInterfaceOnCancelListenerC0166e.this.R1();
        }
    }

    private void M1(boolean z2, boolean z3, boolean z4) {
        if (this.f2909p0) {
            return;
        }
        this.f2909p0 = true;
        this.f2910q0 = false;
        Dialog dialog = this.f2907n0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f2907n0.dismiss();
            if (!z3) {
                if (Looper.myLooper() == this.f2896c0.getLooper()) {
                    onDismiss(this.f2907n0);
                } else {
                    this.f2896c0.post(this.f2897d0);
                }
            }
        }
        this.f2908o0 = true;
        if (this.f2904k0 >= 0) {
            if (z4) {
                D().b1(this.f2904k0, 1);
            } else {
                D().Z0(this.f2904k0, 1, z2);
            }
            this.f2904k0 = -1;
            return;
        }
        G gO = D().o();
        gO.q(true);
        gO.m(this);
        if (z4) {
            gO.i();
        } else if (z2) {
            gO.h();
        } else {
            gO.g();
        }
    }

    private void S1(Bundle bundle) {
        if (this.f2903j0 && !this.f2911r0) {
            try {
                this.f2905l0 = true;
                Dialog dialogP1 = P1(bundle);
                this.f2907n0 = dialogP1;
                if (this.f2903j0) {
                    W1(dialogP1, this.f2900g0);
                    Context contextO = o();
                    if (contextO instanceof Activity) {
                        this.f2907n0.setOwnerActivity((Activity) contextO);
                    }
                    this.f2907n0.setCancelable(this.f2902i0);
                    this.f2907n0.setOnCancelListener(this.f2898e0);
                    this.f2907n0.setOnDismissListener(this.f2899f0);
                    this.f2911r0 = true;
                } else {
                    this.f2907n0 = null;
                }
                this.f2905l0 = false;
            } catch (Throwable th) {
                this.f2905l0 = false;
                throw th;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void I0(Bundle bundle) {
        super.I0(bundle);
        Dialog dialog = this.f2907n0;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i2 = this.f2900g0;
        if (i2 != 0) {
            bundle.putInt("android:style", i2);
        }
        int i3 = this.f2901h0;
        if (i3 != 0) {
            bundle.putInt("android:theme", i3);
        }
        boolean z2 = this.f2902i0;
        if (!z2) {
            bundle.putBoolean("android:cancelable", z2);
        }
        boolean z3 = this.f2903j0;
        if (!z3) {
            bundle.putBoolean("android:showsDialog", z3);
        }
        int i4 = this.f2904k0;
        if (i4 != -1) {
            bundle.putInt("android:backStackId", i4);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void J0() {
        super.J0();
        Dialog dialog = this.f2907n0;
        if (dialog != null) {
            this.f2908o0 = false;
            dialog.show();
            View decorView = this.f2907n0.getWindow().getDecorView();
            androidx.lifecycle.F.a(decorView, this);
            androidx.lifecycle.G.a(decorView, this);
            A.d.a(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void K0() {
        super.K0();
        Dialog dialog = this.f2907n0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public void L1() {
        M1(false, false, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void M0(Bundle bundle) {
        Bundle bundle2;
        super.M0(bundle);
        if (this.f2907n0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f2907n0.onRestoreInstanceState(bundle2);
    }

    public Dialog N1() {
        return this.f2907n0;
    }

    public int O1() {
        return this.f2901h0;
    }

    public Dialog P1(Bundle bundle) {
        if (x.H0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("onCreateDialog called for DialogFragment ");
            sb.append(this);
        }
        return new androidx.activity.i(n1(), O1());
    }

    View Q1(int i2) {
        Dialog dialog = this.f2907n0;
        if (dialog != null) {
            return dialog.findViewById(i2);
        }
        return null;
    }

    boolean R1() {
        return this.f2911r0;
    }

    @Override // androidx.fragment.app.Fragment
    void T0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.T0(layoutInflater, viewGroup, bundle);
        if (this.f2667I != null || this.f2907n0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f2907n0.onRestoreInstanceState(bundle2);
    }

    public void T1(boolean z2) {
        this.f2902i0 = z2;
        Dialog dialog = this.f2907n0;
        if (dialog != null) {
            dialog.setCancelable(z2);
        }
    }

    public void U1(boolean z2) {
        this.f2903j0 = z2;
    }

    public void V1(int i2, int i3) {
        if (x.H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Setting style and theme for DialogFragment ");
            sb.append(this);
            sb.append(" to ");
            sb.append(i2);
            sb.append(", ");
            sb.append(i3);
        }
        this.f2900g0 = i2;
        if (i2 == 2 || i2 == 3) {
            this.f2901h0 = R.style.Theme.Panel;
        }
        if (i3 != 0) {
            this.f2901h0 = i3;
        }
    }

    public void W1(Dialog dialog, int i2) {
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void X1(x xVar, String str) {
        this.f2909p0 = false;
        this.f2910q0 = true;
        G gO = xVar.o();
        gO.q(true);
        gO.e(this, str);
        gO.g();
    }

    @Override // androidx.fragment.app.Fragment
    AbstractC0173l e() {
        return new C0045e(super.e());
    }

    @Override // androidx.fragment.app.Fragment
    public void g0(Bundle bundle) {
        super.g0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void j0(Context context) {
        super.j0(context);
        T().e(this.f2906m0);
        if (this.f2910q0) {
            return;
        }
        this.f2909p0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void m0(Bundle bundle) {
        super.m0(bundle);
        this.f2896c0 = new Handler();
        this.f2903j0 = this.f2710y == 0;
        if (bundle != null) {
            this.f2900g0 = bundle.getInt("android:style", 0);
            this.f2901h0 = bundle.getInt("android:theme", 0);
            this.f2902i0 = bundle.getBoolean("android:cancelable", true);
            this.f2903j0 = bundle.getBoolean("android:showsDialog", this.f2903j0);
            this.f2904k0 = bundle.getInt("android:backStackId", -1);
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f2908o0) {
            return;
        }
        if (x.H0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("onDismiss called for DialogFragment ");
            sb.append(this);
        }
        M1(true, true, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void t0() {
        super.t0();
        Dialog dialog = this.f2907n0;
        if (dialog != null) {
            this.f2908o0 = true;
            dialog.setOnDismissListener(null);
            this.f2907n0.dismiss();
            if (!this.f2909p0) {
                onDismiss(this.f2907n0);
            }
            this.f2907n0 = null;
            this.f2911r0 = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void u0() {
        super.u0();
        if (!this.f2910q0 && !this.f2909p0) {
            this.f2909p0 = true;
        }
        T().h(this.f2906m0);
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater v0(Bundle bundle) {
        StringBuilder sb;
        String str;
        LayoutInflater layoutInflaterV0 = super.v0(bundle);
        if (this.f2903j0 && !this.f2905l0) {
            S1(bundle);
            if (x.H0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("get layout inflater for DialogFragment ");
                sb2.append(this);
                sb2.append(" from dialog context");
            }
            Dialog dialog = this.f2907n0;
            return dialog != null ? layoutInflaterV0.cloneInContext(dialog.getContext()) : layoutInflaterV0;
        }
        if (x.H0(2)) {
            String str2 = "getting layout inflater for DialogFragment " + this;
            if (this.f2903j0) {
                sb = new StringBuilder();
                str = "mCreatingDialog = true: ";
            } else {
                sb = new StringBuilder();
                str = "mShowsDialog = false: ";
            }
            sb.append(str);
            sb.append(str2);
        }
        return layoutInflaterV0;
    }
}
