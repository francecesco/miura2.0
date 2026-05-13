package androidx.core.content.res;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f2115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f2116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f2117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f2118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f2119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f2120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f2121g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f2122h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f2123i;

    a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.f2115a = f2;
        this.f2116b = f3;
        this.f2117c = f4;
        this.f2118d = f5;
        this.f2119e = f6;
        this.f2120f = f7;
        this.f2121g = f8;
        this.f2122h = f9;
        this.f2123i = f10;
    }

    private static a b(float f2, float f3, float f4) {
        float f5 = 100.0f;
        float f6 = 1000.0f;
        a aVar = null;
        float f7 = 1000.0f;
        float f8 = 0.0f;
        while (Math.abs(f8 - f5) > 0.01f) {
            float f9 = ((f5 - f8) / 2.0f) + f8;
            int iP = e(f9, f3, f2).p();
            float fB = b.b(iP);
            float fAbs = Math.abs(f4 - fB);
            if (fAbs < 0.2f) {
                a aVarC = c(iP);
                float fA = aVarC.a(e(aVarC.k(), aVarC.i(), f2));
                if (fA <= 1.0f) {
                    aVar = aVarC;
                    f6 = fAbs;
                    f7 = fA;
                }
            }
            if (f6 == 0.0f && f7 == 0.0f) {
                break;
            }
            if (fB < f4) {
                f8 = f9;
            } else {
                f5 = f9;
            }
        }
        return aVar;
    }

    static a c(int i2) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        d(i2, l.f2160k, fArr, fArr2);
        return new a(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    static void d(int i2, l lVar, float[] fArr, float[] fArr2) {
        b.f(i2, fArr2);
        float[][] fArr3 = b.f2124a;
        float f2 = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f3 = fArr4[0] * f2;
        float f4 = fArr2[1];
        float f5 = f3 + (fArr4[1] * f4);
        float f6 = fArr2[2];
        float f7 = f5 + (fArr4[2] * f6);
        float[] fArr5 = fArr3[1];
        float f8 = (fArr5[0] * f2) + (fArr5[1] * f4) + (fArr5[2] * f6);
        float[] fArr6 = fArr3[2];
        float f9 = (f2 * fArr6[0]) + (f4 * fArr6[1]) + (f6 * fArr6[2]);
        float f10 = lVar.i()[0] * f7;
        float f11 = lVar.i()[1] * f8;
        float f12 = lVar.i()[2] * f9;
        float fPow = (float) Math.pow(((double) (lVar.c() * Math.abs(f10))) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (lVar.c() * Math.abs(f11))) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (lVar.c() * Math.abs(f12))) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f10) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f11) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f12) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d2 = fSignum3;
        float f13 = ((float) (((((double) fSignum) * 11.0d) + (((double) fSignum2) * (-12.0d))) + d2)) / 11.0f;
        float f14 = ((float) (((double) (fSignum + fSignum2)) - (d2 * 2.0d))) / 9.0f;
        float f15 = fSignum2 * 20.0f;
        float f16 = (((fSignum * 20.0f) + f15) + (21.0f * fSignum3)) / 20.0f;
        float f17 = (((fSignum * 40.0f) + f15) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f14, f13)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f18 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f17 * lVar.f()) / lVar.a(), lVar.b() * lVar.j())) * 100.0f;
        float fB = (4.0f / lVar.b()) * ((float) Math.sqrt(fPow4 / 100.0f)) * (lVar.a() + 4.0f) * lVar.d();
        float fSqrt = ((float) Math.sqrt(((double) fPow4) / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, lVar.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) (((double) fAtan2) < 20.14d ? 360.0f + fAtan2 : fAtan2)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * lVar.g()) * lVar.h()) * ((float) Math.sqrt((f13 * f13) + (f14 * f14)))) / (f16 + 0.305f), 0.9d));
        float fD = lVar.d() * fSqrt;
        float fSqrt2 = ((float) Math.sqrt((r7 * lVar.b()) / (lVar.a() + 4.0f))) * 50.0f;
        float f19 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((0.0228f * fD) + 1.0f)) * 43.85965f;
        double d3 = f18;
        float fCos = ((float) Math.cos(d3)) * fLog;
        float fSin = fLog * ((float) Math.sin(d3));
        fArr2[0] = fAtan2;
        fArr2[1] = fSqrt;
        if (fArr != null) {
            fArr[0] = fPow4;
            fArr[1] = fB;
            fArr[2] = fD;
            fArr[3] = fSqrt2;
            fArr[4] = f19;
            fArr[5] = fCos;
            fArr[6] = fSin;
        }
    }

    private static a e(float f2, float f3, float f4) {
        return f(f2, f3, f4, l.f2160k);
    }

    private static a f(float f2, float f3, float f4, l lVar) {
        float fB = (4.0f / lVar.b()) * ((float) Math.sqrt(((double) f2) / 100.0d)) * (lVar.a() + 4.0f) * lVar.d();
        float fD = f3 * lVar.d();
        float fSqrt = ((float) Math.sqrt(((f3 / ((float) Math.sqrt(r4))) * lVar.b()) / (lVar.a() + 4.0f))) * 50.0f;
        float f5 = (1.7f * f2) / ((0.007f * f2) + 1.0f);
        float fLog = ((float) Math.log((((double) fD) * 0.0228d) + 1.0d)) * 43.85965f;
        double d2 = (3.1415927f * f4) / 180.0f;
        return new a(f4, f3, f2, fB, fD, fSqrt, f5, fLog * ((float) Math.cos(d2)), fLog * ((float) Math.sin(d2)));
    }

    public static int m(float f2, float f3, float f4) {
        return n(f2, f3, f4, l.f2160k);
    }

    static int n(float f2, float f3, float f4, l lVar) {
        if (f3 < 1.0d || Math.round(f4) <= 0.0d || Math.round(f4) >= 100.0d) {
            return b.a(f4);
        }
        float fMin = f2 < 0.0f ? 0.0f : Math.min(360.0f, f2);
        float f5 = f3;
        a aVar = null;
        float f6 = 0.0f;
        boolean z2 = true;
        while (Math.abs(f6 - f3) >= 0.4f) {
            a aVarB = b(fMin, f5, f4);
            if (!z2) {
                if (aVarB == null) {
                    f3 = f5;
                } else {
                    f6 = f5;
                    aVar = aVarB;
                }
                f5 = ((f3 - f6) / 2.0f) + f6;
            } else {
                if (aVarB != null) {
                    return aVarB.o(lVar);
                }
                f5 = ((f3 - f6) / 2.0f) + f6;
                z2 = false;
            }
        }
        return aVar == null ? b.a(f4) : aVar.o(lVar);
    }

    float a(a aVar) {
        float fL = l() - aVar.l();
        float fG = g() - aVar.g();
        float fH = h() - aVar.h();
        return (float) (Math.pow(Math.sqrt((fL * fL) + (fG * fG) + (fH * fH)), 0.63d) * 1.41d);
    }

    float g() {
        return this.f2122h;
    }

    float h() {
        return this.f2123i;
    }

    float i() {
        return this.f2116b;
    }

    float j() {
        return this.f2115a;
    }

    float k() {
        return this.f2117c;
    }

    float l() {
        return this.f2121g;
    }

    int o(l lVar) {
        float fPow = (float) Math.pow(((double) ((((double) i()) == 0.0d || ((double) k()) == 0.0d) ? 0.0f : i() / ((float) Math.sqrt(((double) k()) / 100.0d)))) / Math.pow(1.64d - Math.pow(0.29d, lVar.e()), 0.73d), 1.1111111111111112d);
        double dJ = (j() * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + dJ) + 3.8d)) * 0.25f;
        float fA = lVar.a() * ((float) Math.pow(((double) k()) / 100.0d, (1.0d / ((double) lVar.b())) / ((double) lVar.j())));
        float fG = fCos * 3846.1538f * lVar.g() * lVar.h();
        float f2 = fA / lVar.f();
        float fSin = (float) Math.sin(dJ);
        float fCos2 = (float) Math.cos(dJ);
        float f3 = (((0.305f + f2) * 23.0f) * fPow) / (((fG * 23.0f) + ((11.0f * fPow) * fCos2)) + ((fPow * 108.0f) * fSin));
        float f4 = fCos2 * f3;
        float f5 = f3 * fSin;
        float f6 = f2 * 460.0f;
        float f7 = (((451.0f * f4) + f6) + (288.0f * f5)) / 1403.0f;
        float f8 = ((f6 - (891.0f * f4)) - (261.0f * f5)) / 1403.0f;
        float fSignum = Math.signum(f7) * (100.0f / lVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f7)) * 27.13d) / (400.0d - ((double) Math.abs(f7)))), 2.380952380952381d));
        float fSignum2 = Math.signum(f8) * (100.0f / lVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f8)) * 27.13d) / (400.0d - ((double) Math.abs(f8)))), 2.380952380952381d));
        float fSignum3 = Math.signum(((f6 - (f4 * 220.0f)) - (f5 * 6300.0f)) / 1403.0f) * (100.0f / lVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r8)) * 27.13d) / (400.0d - ((double) Math.abs(r8)))), 2.380952380952381d));
        float f9 = fSignum / lVar.i()[0];
        float f10 = fSignum2 / lVar.i()[1];
        float f11 = fSignum3 / lVar.i()[2];
        float[][] fArr = b.f2125b;
        float[] fArr2 = fArr[0];
        float f12 = (fArr2[0] * f9) + (fArr2[1] * f10) + (fArr2[2] * f11);
        float[] fArr3 = fArr[1];
        float f13 = (fArr3[0] * f9) + (fArr3[1] * f10) + (fArr3[2] * f11);
        float[] fArr4 = fArr[2];
        return androidx.core.graphics.a.a(f12, f13, (f9 * fArr4[0]) + (f10 * fArr4[1]) + (f11 * fArr4[2]));
    }

    int p() {
        return o(l.f2160k);
    }
}
