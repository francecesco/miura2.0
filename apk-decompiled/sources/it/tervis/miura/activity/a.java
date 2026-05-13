package it.tervis.miura.activity;

import X.g;
import X.m;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AbstractActivityC0108d;
import it.tervis.miura.model.Peripheral;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends AbstractActivityC0108d implements g {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    protected ProgressDialog f3753B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    protected Handler f3754C;

    /* JADX INFO: renamed from: it.tervis.miura.activity.a$a, reason: collision with other inner class name */
    class RunnableC0063a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3755a;

        RunnableC0063a(String str) {
            this.f3755a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("run: ");
                sb.append(this.f3755a);
                a aVar = a.this;
                ProgressDialog progressDialog = aVar.f3753B;
                if (progressDialog == null) {
                    aVar.f3753B = ProgressDialog.show(aVar, "Attendere", this.f3755a);
                    a.this.f3753B.setCancelable(false);
                    a.this.f3753B.setCanceledOnTouchOutside(false);
                } else {
                    progressDialog.setMessage(this.f3755a);
                }
            } catch (Exception unused) {
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ProgressDialog progressDialog = a.this.f3753B;
                if (progressDialog != null) {
                    progressDialog.dismiss();
                    a.this.f3753B = null;
                }
            } catch (Exception e2) {
                j0.d.c(e2);
            }
        }
    }

    class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3759a;

        d(String str) {
            this.f3759a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(a.this, this.f3759a, 0).show();
        }
    }

    private void B0() {
        getWindow().setFlags(Peripheral.EXPANSION_5, Peripheral.EXPANSION_5);
    }

    public void C0(String str, String str2, boolean z2) {
        try {
            m mVar = new m();
            Bundle bundle = new Bundle();
            bundle.putString(".title", str);
            bundle.putString(".message", str2);
            bundle.putBoolean(".finish", z2);
            mVar.t1(bundle);
            mVar.T1(false);
            mVar.X1(f0(), "");
        } catch (Exception e2) {
            j0.d.c(e2);
        }
    }

    @Override // X.g
    public void D() {
        runOnUiThread(new b());
    }

    @Override // X.g
    public void E(String str, String str2) {
        C0(str, str2, false);
    }

    public void dropTouch(View view) {
        view.setSoundEffectsEnabled(false);
        j0.d.a("@@@@@@@@@@@@ DROPPED! ");
    }

    @Override // X.g
    public void j(String str, String str2, DialogInterface.OnClickListener onClickListener) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(str2).setTitle(str).setPositiveButton("Ok", onClickListener).setNegativeButton("Annulla", new c());
            builder.create().show();
        } catch (Exception e2) {
            j0.d.c(e2);
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0171j, androidx.activity.ComponentActivity, androidx.core.app.g, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        B0();
        this.f3754C = new Handler();
    }

    @Override // X.g
    public void p(String str) {
        this.f3754C.post(new d(str));
    }

    @Override // X.g
    public void v(String str) {
        runOnUiThread(new RunnableC0063a(str));
    }
}
