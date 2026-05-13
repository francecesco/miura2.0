package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R$layout;
import androidx.appcompat.app.DialogInterfaceC0107c;
import androidx.appcompat.view.menu.j;
import it.tervis.miura.model.Peripheral;

/* JADX INFO: loaded from: classes.dex */
class f implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f1346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DialogInterfaceC0107c f1347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    c f1348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private j.a f1349d;

    public f(e eVar) {
        this.f1346a = eVar;
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void a(e eVar, boolean z2) {
        if (z2 || eVar == this.f1346a) {
            c();
        }
        j.a aVar = this.f1349d;
        if (aVar != null) {
            aVar.a(eVar, z2);
        }
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean b(e eVar) {
        j.a aVar = this.f1349d;
        if (aVar != null) {
            return aVar.b(eVar);
        }
        return false;
    }

    public void c() {
        DialogInterfaceC0107c dialogInterfaceC0107c = this.f1347b;
        if (dialogInterfaceC0107c != null) {
            dialogInterfaceC0107c.dismiss();
        }
    }

    public void d(IBinder iBinder) {
        e eVar = this.f1346a;
        DialogInterfaceC0107c.a aVar = new DialogInterfaceC0107c.a(eVar.u());
        c cVar = new c(aVar.b(), R$layout.abc_list_menu_item_layout);
        this.f1348c = cVar;
        cVar.h(this);
        this.f1346a.b(this.f1348c);
        aVar.c(this.f1348c.b(), this);
        View viewY = eVar.y();
        if (viewY != null) {
            aVar.d(viewY);
        } else {
            aVar.e(eVar.w()).h(eVar.x());
        }
        aVar.f(this);
        DialogInterfaceC0107c dialogInterfaceC0107cA = aVar.a();
        this.f1347b = dialogInterfaceC0107cA;
        dialogInterfaceC0107cA.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f1347b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= Peripheral.EXPANSION_9;
        this.f1347b.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.f1346a.M((g) this.f1348c.b().getItem(i2), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1348c.a(this.f1346a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i2 == 82 || i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f1347b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f1347b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f1346a.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f1346a.performShortcut(i2, keyEvent, 0);
    }
}
