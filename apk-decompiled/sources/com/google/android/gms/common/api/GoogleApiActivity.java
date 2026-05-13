package com.google.android.gms.common.api;

import G.i;
import I.b;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepName;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3455a = 0;

    public static PendingIntent a(Context context, PendingIntent pendingIntent, int i2) {
        return PendingIntent.getActivity(context, 0, b(context, pendingIntent, i2, true), 134217728);
    }

    public static Intent b(Context context, PendingIntent pendingIntent, int i2, boolean z2) {
        Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i2);
        intent.putExtra("notify_manager", z2);
        return intent;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f3455a = 0;
            setResult(i3, intent);
            if (booleanExtra) {
                b bVarC = b.c(this);
                if (i3 == -1) {
                    bVarC.f();
                } else if (i3 == 0) {
                    bVarC.b(new G.a(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i2 == 2) {
            this.f3455a = 0;
            setResult(i3, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f3455a = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f3455a = bundle.getInt("resolution");
        }
        if (this.f3455a != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
            Integer num = (Integer) extras.get("error_code");
            if (pendingIntent == null && num == null) {
                finish();
                return;
            }
            if (pendingIntent == null) {
                i.k().l(this, num.intValue(), 2, this);
                this.f3455a = 1;
            } else {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                    this.f3455a = 1;
                } catch (IntentSender.SendIntentException unused) {
                    finish();
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f3455a);
        super.onSaveInstanceState(bundle);
    }
}
