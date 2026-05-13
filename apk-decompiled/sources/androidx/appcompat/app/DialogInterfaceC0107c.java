package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertController;

/* JADX INFO: renamed from: androidx.appcompat.app.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class DialogInterfaceC0107c extends y implements DialogInterface {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final AlertController f1012f;

    /* JADX INFO: renamed from: androidx.appcompat.app.c$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AlertController.f f1013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f1014b;

        public a(Context context) {
            this(context, DialogInterfaceC0107c.l(context, 0));
        }

        public DialogInterfaceC0107c a() {
            DialogInterfaceC0107c dialogInterfaceC0107c = new DialogInterfaceC0107c(this.f1013a.f898a, this.f1014b);
            this.f1013a.a(dialogInterfaceC0107c.f1012f);
            dialogInterfaceC0107c.setCancelable(this.f1013a.f915r);
            if (this.f1013a.f915r) {
                dialogInterfaceC0107c.setCanceledOnTouchOutside(true);
            }
            dialogInterfaceC0107c.setOnCancelListener(this.f1013a.f916s);
            dialogInterfaceC0107c.setOnDismissListener(this.f1013a.f917t);
            DialogInterface.OnKeyListener onKeyListener = this.f1013a.f918u;
            if (onKeyListener != null) {
                dialogInterfaceC0107c.setOnKeyListener(onKeyListener);
            }
            return dialogInterfaceC0107c;
        }

        public Context b() {
            return this.f1013a.f898a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1013a;
            fVar.f920w = listAdapter;
            fVar.f921x = onClickListener;
            return this;
        }

        public a d(View view) {
            this.f1013a.f904g = view;
            return this;
        }

        public a e(Drawable drawable) {
            this.f1013a.f901d = drawable;
            return this;
        }

        public a f(DialogInterface.OnKeyListener onKeyListener) {
            this.f1013a.f918u = onKeyListener;
            return this;
        }

        public a g(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1013a;
            fVar.f920w = listAdapter;
            fVar.f921x = onClickListener;
            fVar.f891I = i2;
            fVar.f890H = true;
            return this;
        }

        public a h(CharSequence charSequence) {
            this.f1013a.f903f = charSequence;
            return this;
        }

        public a(Context context, int i2) {
            this.f1013a = new AlertController.f(new ContextThemeWrapper(context, DialogInterfaceC0107c.l(context, i2)));
            this.f1014b = i2;
        }
    }

    protected DialogInterfaceC0107c(Context context, int i2) {
        super(context, l(context, i2));
        this.f1012f = new AlertController(getContext(), this, getWindow());
    }

    static int l(Context context, int i2) {
        if (((i2 >>> 24) & 255) >= 1) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView k() {
        return this.f1012f.d();
    }

    @Override // androidx.appcompat.app.y, androidx.activity.i, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1012f.e();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.f1012f.g(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.f1012f.h(i2, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // androidx.appcompat.app.y, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1012f.q(charSequence);
    }
}
