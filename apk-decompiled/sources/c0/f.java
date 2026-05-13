package c0;

import it.tervis.miura.model.LogEvent;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f3447h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f3448i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f3449j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f3450k;

    public f(byte[] bArr) {
        super(bArr);
    }

    public static boolean s(byte[] bArr) {
        return bArr[5] != 0;
    }

    private void t() {
        j0.d.a("Parsing LogResponse...");
        int[] iArr = this.f582b;
        this.f3447h = iArr[4];
        this.f3448i = iArr[5];
        j0.d.a("- category: " + this.f3447h);
        j0.d.a("- details: " + this.f3448i);
        int[] iArr2 = this.f582b;
        this.f3449j = m(iArr2[6], iArr2[7]);
        int[] iArr3 = this.f582b;
        this.f3450k = m(iArr3[8], iArr3[9]);
        j0.d.a("- start index: " + this.f3449j);
        j0.d.a("- event count:" + this.f3450k);
    }

    @Override // Y.b
    protected void h() {
        if (this.f582b != null) {
            t();
        }
    }

    public int q() {
        return this.f3449j;
    }

    public int r() {
        return this.f3450k;
    }

    protected LogEvent u(int i2) {
        j0.d.a("-- New Event");
        int[] iArr = this.f582b;
        int i3 = iArr[i2];
        int i4 = iArr[i2 + 1];
        int i5 = iArr[i2 + 2];
        int i6 = iArr[i2 + 3];
        int i7 = iArr[i2 + 4];
        int i8 = iArr[i2 + 5];
        boolean z2 = iArr[i2 + 6] == 1;
        j0.d.a("-- " + i4 + "." + i5 + "." + i6 + " @ " + i7 + ":" + i8);
        return new LogEvent(i3, i4, i5, i6, i7, i8, z2, null, null);
    }
}
