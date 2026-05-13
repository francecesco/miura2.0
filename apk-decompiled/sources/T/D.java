package T;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
abstract class D extends AbstractC0082e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private E f162b;

    public D(C0085h c0085h, E e2) {
        super(c0085h);
        this.f162b = e2;
    }

    private final C D(XmlResourceParser xmlResourceParser) {
        String strTrim;
        String str;
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String lowerCase = xmlResourceParser.getName().toLowerCase(Locale.US);
                    if (lowerCase.equals("screenname")) {
                        String attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        String strTrim2 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(strTrim2)) {
                            this.f162b.c(attributeValue, strTrim2);
                        }
                    } else if (lowerCase.equals("string")) {
                        String attributeValue2 = xmlResourceParser.getAttributeValue(null, "name");
                        String strTrim3 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue2) && strTrim3 != null) {
                            this.f162b.a(attributeValue2, strTrim3);
                        }
                    } else if (lowerCase.equals("bool")) {
                        String attributeValue3 = xmlResourceParser.getAttributeValue(null, "name");
                        strTrim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue3) && !TextUtils.isEmpty(strTrim)) {
                            try {
                                this.f162b.e(attributeValue3, Boolean.parseBoolean(strTrim));
                            } catch (NumberFormatException e2) {
                                e = e2;
                                str = "Error parsing bool configuration value";
                                o(str, strTrim, e);
                            }
                        }
                    } else if (lowerCase.equals("integer")) {
                        String attributeValue4 = xmlResourceParser.getAttributeValue(null, "name");
                        strTrim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue4) && !TextUtils.isEmpty(strTrim)) {
                            try {
                                this.f162b.b(attributeValue4, Integer.parseInt(strTrim));
                            } catch (NumberFormatException e3) {
                                e = e3;
                                str = "Error parsing int configuration value";
                                o(str, strTrim, e);
                            }
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException e4) {
            e = e4;
            x("Error parsing tracker configuration file", e);
        } catch (XmlPullParserException e5) {
            e = e5;
            x("Error parsing tracker configuration file", e);
        }
        return this.f162b.d();
    }

    public final C E(int i2) {
        try {
            return D(j().l().getResources().getXml(i2));
        } catch (Resources.NotFoundException e2) {
            v("inflate() called with unknown resourceId", e2);
            return null;
        }
    }
}
