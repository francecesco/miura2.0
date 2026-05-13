package K;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import it.tervis.miura.model.Peripheral;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Uri f108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f109b;

    static {
        Uri uri = Uri.parse("https://plus.google.com/");
        f108a = uri;
        f109b = uri.buildUpon().appendPath("circles").appendPath("find").build();
    }

    public static Intent a(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri.Builder builderAppendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter(Name.MARK, str);
        if (!TextUtils.isEmpty(str2)) {
            builderAppendQueryParameter.appendQueryParameter("pcampaignid", str2);
        }
        intent.setData(builderAppendQueryParameter.build());
        intent.setPackage("com.android.vending");
        intent.addFlags(Peripheral.EXPANSION_11);
        return intent;
    }

    public static Intent b(String str) {
        Uri uriFromParts = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(uriFromParts);
        return intent;
    }

    public static Intent c() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }
}
