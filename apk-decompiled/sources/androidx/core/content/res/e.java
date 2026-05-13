package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.core.R$styleable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    static class a {
        static int a(TypedArray typedArray, int i2) {
            return typedArray.getType(i2);
        }
    }

    public interface b {
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d[] f2132a;

        public c(d[] dVarArr) {
            this.f2132a = dVarArr;
        }

        public d[] a() {
            return this.f2132a;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f2133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2134b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f2135c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f2136d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f2137e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f2138f;

        public d(String str, int i2, boolean z2, String str2, int i3, int i4) {
            this.f2133a = str;
            this.f2134b = i2;
            this.f2135c = z2;
            this.f2136d = str2;
            this.f2137e = i3;
            this.f2138f = i4;
        }

        public String a() {
            return this.f2133a;
        }

        public int b() {
            return this.f2138f;
        }

        public int c() {
            return this.f2137e;
        }

        public String d() {
            return this.f2136d;
        }

        public int e() {
            return this.f2134b;
        }

        public boolean f() {
            return this.f2135c;
        }
    }

    /* JADX INFO: renamed from: androidx.core.content.res.e$e, reason: collision with other inner class name */
    public static final class C0032e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final n.f f2139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f2141c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f2142d;

        public C0032e(n.f fVar, int i2, int i3, String str) {
            this.f2139a = fVar;
            this.f2141c = i2;
            this.f2140b = i3;
            this.f2142d = str;
        }

        public int a() {
            return this.f2141c;
        }

        public n.f b() {
            return this.f2139a;
        }

        public String c() {
            return this.f2142d;
        }

        public int d() {
            return this.f2140b;
        }
    }

    private static int a(TypedArray typedArray, int i2) {
        return a.a(typedArray, i2);
    }

    public static b b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List c(Resources resources, int i2) {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i3 = 0; i3 < typedArrayObtainTypedArray.length(); i3++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i2)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    private static b d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static b e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamily);
        String string = typedArrayObtainAttributes.getString(R$styleable.FontFamily_fontProviderAuthority);
        String string2 = typedArrayObtainAttributes.getString(R$styleable.FontFamily_fontProviderPackage);
        String string3 = typedArrayObtainAttributes.getString(R$styleable.FontFamily_fontProviderQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(R$styleable.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchTimeout, 500);
        String string4 = typedArrayObtainAttributes.getString(R$styleable.FontFamily_fontProviderSystemFontFamily);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new C0032e(new n.f(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new c((d[]) arrayList.toArray(new d[0]));
    }

    private static d f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamilyFont);
        int i2 = typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(R$styleable.FontFamilyFont_fontWeight) ? R$styleable.FontFamilyFont_fontWeight : R$styleable.FontFamilyFont_android_fontWeight, 400);
        boolean z2 = 1 == typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(R$styleable.FontFamilyFont_fontStyle) ? R$styleable.FontFamilyFont_fontStyle : R$styleable.FontFamilyFont_android_fontStyle, 0);
        int i3 = typedArrayObtainAttributes.hasValue(R$styleable.FontFamilyFont_ttcIndex) ? R$styleable.FontFamilyFont_ttcIndex : R$styleable.FontFamilyFont_android_ttcIndex;
        String string = typedArrayObtainAttributes.getString(typedArrayObtainAttributes.hasValue(R$styleable.FontFamilyFont_fontVariationSettings) ? R$styleable.FontFamilyFont_fontVariationSettings : R$styleable.FontFamilyFont_android_fontVariationSettings);
        int i4 = typedArrayObtainAttributes.getInt(i3, 0);
        int i5 = typedArrayObtainAttributes.hasValue(R$styleable.FontFamilyFont_font) ? R$styleable.FontFamilyFont_font : R$styleable.FontFamilyFont_android_font;
        int resourceId = typedArrayObtainAttributes.getResourceId(i5, 0);
        String string2 = typedArrayObtainAttributes.getString(i5);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(string2, i2, z2, string, i4, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    private static List h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
