package androidx.media;

import androidx.versionedparcelable.a;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(a aVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f3138a = aVar.p(audioAttributesImplBase.f3138a, 1);
        audioAttributesImplBase.f3139b = aVar.p(audioAttributesImplBase.f3139b, 2);
        audioAttributesImplBase.f3140c = aVar.p(audioAttributesImplBase.f3140c, 3);
        audioAttributesImplBase.f3141d = aVar.p(audioAttributesImplBase.f3141d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, a aVar) {
        aVar.x(false, false);
        aVar.F(audioAttributesImplBase.f3138a, 1);
        aVar.F(audioAttributesImplBase.f3139b, 2);
        aVar.F(audioAttributesImplBase.f3140c, 3);
        aVar.F(audioAttributesImplBase.f3141d, 4);
    }
}
