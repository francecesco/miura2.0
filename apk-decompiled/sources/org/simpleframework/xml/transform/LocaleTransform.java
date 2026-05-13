package org.simpleframework.xml.transform;

import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
class LocaleTransform implements Transform<Locale> {
    private final Pattern pattern = Pattern.compile("_");

    @Override // org.simpleframework.xml.transform.Transform
    public Locale read(String str) throws InvalidFormatException {
        String[] strArrSplit = this.pattern.split(str);
        if (strArrSplit.length >= 1) {
            return read(strArrSplit);
        }
        throw new InvalidFormatException("Invalid locale %s", str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Locale locale) {
        return locale.toString();
    }

    private Locale read(String[] strArr) {
        String[] strArr2 = new String[3];
        strArr2[0] = "";
        strArr2[1] = "";
        strArr2[2] = "";
        for (int i2 = 0; i2 < 3; i2++) {
            if (i2 < strArr.length) {
                strArr2[i2] = strArr[i2];
            }
        }
        return new Locale(strArr2[0], strArr2[1], strArr2[2]);
    }
}
