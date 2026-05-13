package androidx.media;

import D.a;
import android.util.SparseIntArray;
import it.tervis.miura.model.Console;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesCompat implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SparseIntArray f3133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f3134c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AudioAttributesImpl f3135a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f3133b = sparseIntArray;
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
        f3134c = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    }

    AudioAttributesCompat() {
    }

    static int a(boolean z2, int i2, int i3) {
        if ((i2 & 1) == 1) {
            return z2 ? 1 : 7;
        }
        if ((i2 & 4) == 4) {
            return z2 ? 0 : 6;
        }
        switch (i3) {
            case 0:
                return z2 ? Integer.MIN_VALUE : 3;
            case 1:
            case 12:
            case 14:
            case 16:
                return 3;
            case 2:
                return 0;
            case 3:
                return z2 ? 0 : 8;
            case 4:
                return 4;
            case 5:
            case Console.MAX_CONSOLE /* 7 */:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
            case 15:
            default:
                if (!z2) {
                    return 3;
                }
                throw new IllegalArgumentException("Unknown usage value " + i3 + " in audio attributes");
        }
    }

    static String b(int i2) {
        switch (i2) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case Console.MAX_CONSOLE /* 7 */:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case 8:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case 12:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case 15:
            default:
                return "unknown usage " + i2;
            case 16:
                return "USAGE_ASSISTANT";
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesImpl audioAttributesImpl = this.f3135a;
        AudioAttributesImpl audioAttributesImpl2 = ((AudioAttributesCompat) obj).f3135a;
        return audioAttributesImpl == null ? audioAttributesImpl2 == null : audioAttributesImpl.equals(audioAttributesImpl2);
    }

    public int hashCode() {
        return this.f3135a.hashCode();
    }

    public String toString() {
        return this.f3135a.toString();
    }
}
