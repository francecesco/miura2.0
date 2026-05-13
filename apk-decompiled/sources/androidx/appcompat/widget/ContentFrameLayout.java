package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TypedValue f1535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TypedValue f1536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TypedValue f1537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TypedValue f1538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TypedValue f1539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TypedValue f1540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Rect f1541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a f1542h;

    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f1541g.set(i2, i3, i4, i5);
        if (isLaidOut()) {
            requestLayout();
        }
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1539e == null) {
            this.f1539e = new TypedValue();
        }
        return this.f1539e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1540f == null) {
            this.f1540f = new TypedValue();
        }
        return this.f1540f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1537c == null) {
            this.f1537c = new TypedValue();
        }
        return this.f1537c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1538d == null) {
            this.f1538d = new TypedValue();
        }
        return this.f1538d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1535a == null) {
            this.f1535a = new TypedValue();
        }
        return this.f1535a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1536b == null) {
            this.f1536b = new TypedValue();
        }
        return this.f1536b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f1542h;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f1542h;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00db  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(a aVar) {
        this.f1542h = aVar;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1541g = new Rect();
    }
}
