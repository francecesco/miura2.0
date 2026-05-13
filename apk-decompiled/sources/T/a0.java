package T;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteArrayOutputStream f250b = new ByteArrayOutputStream();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ Z f251c;

    public a0(Z z2) {
        this.f251c = z2;
    }

    public final byte[] a() {
        return this.f250b.toByteArray();
    }

    public final boolean b(T t2) {
        K.e.f(t2);
        if (this.f249a + 1 > F.g()) {
            return false;
        }
        String strJ = this.f251c.J(t2, false);
        if (strJ == null) {
            this.f251c.l().H(t2, "Error formatting hit");
            return true;
        }
        byte[] bytes = strJ.getBytes();
        int length = bytes.length;
        if (length > F.c()) {
            this.f251c.l().H(t2, "Hit size exceeds the maximum size limit");
            return true;
        }
        if (this.f250b.size() > 0) {
            length++;
        }
        if (this.f250b.size() + length > ((Integer) N.f177A.a()).intValue()) {
            return false;
        }
        try {
            if (this.f250b.size() > 0) {
                this.f250b.write(Z.f243e);
            }
            this.f250b.write(bytes);
            this.f249a++;
            return true;
        } catch (IOException e2) {
            this.f251c.x("Failed to write payload when batching hits", e2);
            return true;
        }
    }

    public final int c() {
        return this.f249a;
    }
}
