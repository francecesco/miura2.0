package r0;

import l0.z;

/* JADX INFO: loaded from: classes.dex */
public class a implements Iterable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0070a f3990d = new C0070a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3993c;

    /* JADX INFO: renamed from: r0.a$a, reason: collision with other inner class name */
    public static final class C0070a {
        private C0070a() {
        }

        public final a a(int i2, int i3, int i4) {
            return new a(i2, i3, i4);
        }

        public /* synthetic */ C0070a(q0.d dVar) {
            this();
        }
    }

    public a(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f3991a = i2;
        this.f3992b = n0.a.b(i2, i3, i4);
        this.f3993c = i4;
    }

    public final int a() {
        return this.f3991a;
    }

    public final int b() {
        return this.f3992b;
    }

    public final int c() {
        return this.f3993c;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public z iterator() {
        return new b(this.f3991a, this.f3992b, this.f3993c);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f3991a != aVar.f3991a || this.f3992b != aVar.f3992b || this.f3993c != aVar.f3993c) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f3991a * 31) + this.f3992b) * 31) + this.f3993c;
    }

    public boolean isEmpty() {
        if (this.f3993c > 0) {
            if (this.f3991a <= this.f3992b) {
                return false;
            }
        } else if (this.f3991a >= this.f3992b) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f3993c > 0) {
            sb = new StringBuilder();
            sb.append(this.f3991a);
            sb.append("..");
            sb.append(this.f3992b);
            sb.append(" step ");
            i2 = this.f3993c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f3991a);
            sb.append(" downTo ");
            sb.append(this.f3992b);
            sb.append(" step ");
            i2 = -this.f3993c;
        }
        sb.append(i2);
        return sb.toString();
    }
}
