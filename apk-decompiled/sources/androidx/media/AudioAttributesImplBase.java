package androidx.media;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f3138a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f3139b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f3140c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f3141d = -1;

    AudioAttributesImplBase() {
    }

    public int a() {
        return this.f3139b;
    }

    public int b() {
        int i2 = this.f3140c;
        int iC = c();
        if (iC == 6) {
            i2 |= 4;
        } else if (iC == 7) {
            i2 |= 1;
        }
        return i2 & 273;
    }

    public int c() {
        int i2 = this.f3141d;
        return i2 != -1 ? i2 : AudioAttributesCompat.a(false, this.f3140c, this.f3138a);
    }

    public int d() {
        return this.f3138a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f3139b == audioAttributesImplBase.a() && this.f3140c == audioAttributesImplBase.b() && this.f3138a == audioAttributesImplBase.d() && this.f3141d == audioAttributesImplBase.f3141d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3139b), Integer.valueOf(this.f3140c), Integer.valueOf(this.f3138a), Integer.valueOf(this.f3141d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f3141d != -1) {
            sb.append(" stream=");
            sb.append(this.f3141d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.b(this.f3138a));
        sb.append(" content=");
        sb.append(this.f3139b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f3140c).toUpperCase());
        return sb.toString();
    }
}
