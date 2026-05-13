package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.AbstractC0155t;
import androidx.lifecycle.AbstractC0183g;
import androidx.lifecycle.u;
import k.C0213g;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends Activity implements androidx.lifecycle.l, AbstractC0155t.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0213g f2026a = new C0213g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.lifecycle.m f2027b = new androidx.lifecycle.m(this);

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final boolean L(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        String str = strArr[0];
        switch (str.hashCode()) {
            case -645125871:
                return str.equals("--translation") && Build.VERSION.SDK_INT >= 31;
            case 100470631:
                if (!str.equals("--dump-dumpable")) {
                    return false;
                }
                break;
            case 472614934:
                if (!str.equals("--list-dumpables")) {
                    return false;
                }
                break;
            case 1159329357:
                return str.equals("--contentcapture") && Build.VERSION.SDK_INT >= 29;
            case 1455016274:
                return str.equals("--autofill") && Build.VERSION.SDK_INT >= 26;
            default:
                return false;
        }
        return Build.VERSION.SDK_INT >= 33;
    }

    protected final boolean K(String[] strArr) {
        return !L(strArr);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        q0.f.e(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        q0.f.d(decorView, "window.decorView");
        if (AbstractC0155t.d(decorView, keyEvent)) {
            return true;
        }
        return AbstractC0155t.e(this, decorView, this, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        q0.f.e(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        q0.f.d(decorView, "window.decorView");
        if (AbstractC0155t.d(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        u.f3113b.c(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        q0.f.e(bundle, "outState");
        this.f2027b.m(AbstractC0183g.b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.core.view.AbstractC0155t.a
    public boolean q(KeyEvent keyEvent) {
        q0.f.e(keyEvent, "event");
        return super.dispatchKeyEvent(keyEvent);
    }
}
