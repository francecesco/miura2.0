package r0;

import java.util.NoSuchElementException;
import l0.z;

/* JADX INFO: loaded from: classes.dex */
public final class b extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3997d;

    public b(int i2, int i3, int i4) {
        this.f3994a = i4;
        this.f3995b = i3;
        boolean z2 = false;
        if (i4 <= 0 ? i2 >= i3 : i2 <= i3) {
            z2 = true;
        }
        this.f3996c = z2;
        this.f3997d = z2 ? i2 : i3;
    }

    @Override // l0.z
    public int a() {
        int i2 = this.f3997d;
        if (i2 != this.f3995b) {
            this.f3997d = this.f3994a + i2;
        } else {
            if (!this.f3996c) {
                throw new NoSuchElementException();
            }
            this.f3996c = false;
        }
        return i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3996c;
    }
}
