package f;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import f.AbstractC0192b;

/* JADX INFO: renamed from: f.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0195e extends AbstractC0192b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private a f3573m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f3574n;

    /* JADX INFO: renamed from: f.e$a */
    static class a extends AbstractC0192b.d {

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        int[][] f3575J;

        a(a aVar, AbstractC0195e abstractC0195e, Resources resources) {
            super(aVar, abstractC0195e, resources);
            if (aVar != null) {
                this.f3575J = aVar.f3575J;
            } else {
                this.f3575J = new int[f()][];
            }
        }

        int A(int[] iArr) {
            int[][] iArr2 = this.f3575J;
            int iH = h();
            for (int i2 = 0; i2 < iH; i2++) {
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // f.AbstractC0192b.d
        public void o(int i2, int i3) {
            super.o(i2, i3);
            int[][] iArr = new int[i3][];
            System.arraycopy(this.f3575J, 0, iArr, 0, i2);
            this.f3575J = iArr;
        }

        @Override // f.AbstractC0192b.d
        abstract void r();

        int z(int[] iArr, Drawable drawable) {
            int iA = a(drawable);
            this.f3575J[iA] = iArr;
            return iA;
        }
    }

    AbstractC0195e(a aVar) {
        if (aVar != null) {
            h(aVar);
        }
    }

    @Override // f.AbstractC0192b, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // f.AbstractC0192b
    void h(AbstractC0192b.d dVar) {
        super.h(dVar);
        if (dVar instanceof a) {
            this.f3573m = (a) dVar;
        }
    }

    int[] j(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i2 = 0;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i3);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i4 = i2 + 1;
                if (!attributeSet.getAttributeBooleanValue(i3, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i2] = attributeNameResource;
                i2 = i4;
            }
        }
        return StateSet.trimStateSet(iArr, i2);
    }

    @Override // f.AbstractC0192b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f3574n && super.mutate() == this) {
            this.f3573m.r();
            this.f3574n = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected abstract boolean onStateChange(int[] iArr);
}
