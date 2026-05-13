package j0;

import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3784a = false;

    protected abstract void a(CompoundButton compoundButton);

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        d.a("Dragged on: " + compoundButton.getTag());
        this.f3784a = true;
        a(compoundButton);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        d.a("Clicked on: " + view.getTag());
        if (!this.f3784a) {
            a((CompoundButton) view);
        } else {
            d.a("Ignoring event");
            this.f3784a = false;
        }
    }
}
