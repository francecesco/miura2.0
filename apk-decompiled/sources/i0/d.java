package i0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class d extends e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3648i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3649j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3650k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ArrayList f3651l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3654c;
    }

    public d(byte[] bArr) {
        super(bArr);
        j0.d.a("List: " + this.f3651l);
    }

    @Override // Y.b
    protected void h() {
        if (this.f582b == null) {
            return;
        }
        this.f3651l = new ArrayList();
        int[] iArr = this.f582b;
        this.f3648i = iArr[4] == 1;
        this.f3649j = iArr[5];
        this.f3650k = iArr[6];
        j0.d.d(this.f583c);
        int i2 = 7;
        while (true) {
            int i3 = i2 + 4;
            if (i3 >= this.f582b.length) {
                return;
            }
            j0.d.a("Adding zone from offset " + i2);
            a aVar = new a();
            int[] iArr2 = this.f582b;
            aVar.f3652a = iArr2[i2];
            aVar.f3653b = iArr2[i2 + 1] == 1;
            aVar.f3654c = b(i2 + 2);
            j0.d.a("ZoneInfo " + aVar + " - " + this.f3651l);
            this.f3651l.add(aVar);
            i2 = i3;
        }
    }

    public int q() {
        return this.f3649j;
    }

    public a r(int i2) {
        return (a) this.f3651l.get(i2);
    }

    public int s() {
        return this.f3651l.size();
    }
}
