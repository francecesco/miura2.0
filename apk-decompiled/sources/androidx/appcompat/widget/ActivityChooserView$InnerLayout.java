package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class ActivityChooserView$InnerLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f1531a = {R.attr.background};

    public ActivityChooserView$InnerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e0 e0VarT = e0.t(context, attributeSet, f1531a);
        setBackgroundDrawable(e0VarT.f(0));
        e0VarT.w();
    }
}
