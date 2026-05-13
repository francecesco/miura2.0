package p;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: renamed from: p.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0241a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C f3977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3978c;

    public C0241a(int i2, C c2, int i3) {
        this.f3976a = i2;
        this.f3977b = c2;
        this.f3978c = i3;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f3976a);
        this.f3977b.X(this.f3978c, bundle);
    }
}
