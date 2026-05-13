package W;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import it.tervis.miura.R;
import it.tervis.miura.model.LogEvent;

/* JADX INFO: loaded from: classes.dex */
public class e extends b {
    private TextView w0;
    private LogEvent x0;

    public static e Y1(LogEvent logEvent) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(".event", logEvent);
        e eVar = new e();
        eVar.t1(bundle);
        return eVar;
    }

    @Override // W.b, androidx.fragment.app.DialogInterfaceOnCancelListenerC0166e, androidx.fragment.app.Fragment
    public void J0() {
        super.J0();
        N1().setTitle(this.x0.getHumanizedDateText());
        this.w0.setText(this.x0.getText());
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0166e
    public Dialog P1(Bundle bundle) {
        return super.P1(bundle);
    }

    @Override // W.b, androidx.fragment.app.DialogInterfaceOnCancelListenerC0166e, androidx.fragment.app.Fragment
    public void m0(Bundle bundle) {
        super.m0(bundle);
        this.x0 = (LogEvent) m().getSerializable(".event");
    }

    @Override // androidx.fragment.app.Fragment
    public View q0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_log_details, viewGroup, false);
        this.f415t0 = viewGroup2;
        this.w0 = (TextView) viewGroup2.findViewById(R.id.text_log_description);
        return this.f415t0;
    }
}
