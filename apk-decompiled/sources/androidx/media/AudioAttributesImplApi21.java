package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(21)
class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AudioAttributes f3136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f3137b = -1;

    AudioAttributesImplApi21() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f3136a.equals(((AudioAttributesImplApi21) obj).f3136a);
        }
        return false;
    }

    public int hashCode() {
        return this.f3136a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f3136a;
    }
}
