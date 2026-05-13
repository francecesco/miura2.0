package Y;

import Z.h;
import Z.j;
import Z.m;
import g0.k;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    private static Z.c a(int i2, byte[] bArr) {
        Z.c fVar;
        j0.d.a("Try to decode activation:");
        j0.d.d(bArr);
        if (i2 != 0 && i2 != 1) {
            switch (i2) {
                case 128:
                    fVar = new h(bArr);
                    break;
                case 129:
                    fVar = new Z.b(bArr);
                    break;
                case 130:
                    fVar = new j(bArr);
                    break;
                case 131:
                    fVar = m.v(bArr);
                    break;
                default:
                    j0.d.a("No ActivationMessage subclass found");
                    fVar = null;
                    break;
            }
        } else {
            fVar = new Z.f(bArr);
        }
        j0.d.a("message decoded: " + fVar);
        return fVar;
    }

    private static a0.a b(int i2, byte[] bArr) {
        if (i2 == 0 || i2 == 128) {
            return new a0.c(bArr);
        }
        if (i2 != 129) {
            return null;
        }
        return new a0.b(bArr);
    }

    private static b0.a c(int i2, byte[] bArr) {
        if (i2 == 128) {
            return new b0.b(bArr);
        }
        if (i2 != 129) {
            return null;
        }
        return new b0.d(bArr);
    }

    private static c0.d d(int i2, byte[] bArr) {
        if (i2 != 0) {
            if (i2 == 129) {
                return c0.f.s(bArr) ? new c0.b(bArr) : new c0.c(bArr);
            }
        } else if (b.f(bArr)) {
            return new c0.g(bArr);
        }
        return null;
    }

    public static b e(byte[] bArr) {
        j0.j.i(bArr[0]);
        j0.j.i(bArr[1]);
        int i2 = j0.j.i(bArr[2]);
        int i3 = j0.j.i(bArr[3]);
        return i2 != 1 ? i2 != 10 ? i2 != 18 ? i2 != 3 ? i2 != 4 ? i2 != 6 ? i2 != 7 ? i2 != 8 ? i2 != 15 ? i2 != 16 ? new g(bArr) : d(i3, bArr) : g(i3, bArr) : f(i3, bArr) : j(i3, bArr) : a(i3, bArr) : b(i3, bArr) : new f0.c(bArr) : h(i3, bArr) : c(i3, bArr) : i(i3, bArr);
    }

    private static d0.g f(int i2, byte[] bArr) {
        if (i2 != 0) {
            if (i2 == 129) {
                return new d0.d(bArr);
            }
            if (i2 == 133) {
                return new d0.b(bArr);
            }
            if (i2 == 134) {
                return new d0.f(bArr);
            }
        } else {
            if (b.f(bArr)) {
                return new d0.h(bArr);
            }
            j0.d.a("What?");
        }
        return null;
    }

    private static e0.d g(int i2, byte[] bArr) {
        return b.f(bArr) ? new e0.a(bArr) : new e0.c(bArr);
    }

    private static g0.g h(int i2, byte[] bArr) {
        if (i2 == 8) {
            return new g0.h(bArr);
        }
        if (i2 == 128) {
            return new g0.f(bArr);
        }
        if (i2 == 129) {
            return new g0.b(bArr);
        }
        if (i2 == 136) {
            return new k(bArr);
        }
        if (i2 != 137) {
            return null;
        }
        return new g0.d(bArr);
    }

    private static h0.d i(int i2, byte[] bArr) {
        if (i2 == 3) {
            return new h0.e(bArr);
        }
        if (i2 == 128) {
            return new h0.c(bArr);
        }
        if (i2 != 130) {
            return null;
        }
        return new h0.g(bArr);
    }

    private static i0.e j(int i2, byte[] bArr) {
        j0.d.a("Parsing ZoneMessage: " + Integer.toHexString(i2));
        if (i2 == 129) {
            return new i0.d(bArr);
        }
        if (i2 == 131) {
            return new i0.b(bArr);
        }
        if (i2 != 132) {
            return null;
        }
        return new i0.g(bArr);
    }
}
