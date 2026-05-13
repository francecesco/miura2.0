package androidx.core.app;

import android.content.Context;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f2025a = new Object();

    public static void a(Context context, String str) {
        synchronized (f2025a) {
            if (str.equals("")) {
                context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                return;
            }
            try {
                FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file", 0);
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                try {
                    xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                    xmlSerializerNewSerializer.startDocument("UTF-8", Boolean.TRUE);
                    xmlSerializerNewSerializer.startTag(null, "locales");
                    xmlSerializerNewSerializer.attribute(null, "application_locales", str);
                    xmlSerializerNewSerializer.endTag(null, "locales");
                    xmlSerializerNewSerializer.endDocument();
                } catch (Exception unused) {
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Throwable th) {
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
                if (fileOutputStreamOpenFileOutput != null) {
                    fileOutputStreamOpenFileOutput.close();
                }
            } catch (FileNotFoundException unused4) {
                String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        r1 = r3.getAttributeValue(null, "application_locales");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(android.content.Context r8) {
        /*
            java.lang.Object r0 = androidx.core.app.e.f2025a
            monitor-enter(r0)
            java.lang.String r1 = ""
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.io.FileInputStream r2 = r8.openFileInput(r2)     // Catch: java.lang.Throwable -> L4c java.io.FileNotFoundException -> L65
            org.xmlpull.v1.XmlPullParser r3 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L2b
            java.lang.String r4 = "UTF-8"
            r3.setInput(r2, r4)     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L2b
            int r4 = r3.getDepth()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L2b
        L18:
            int r5 = r3.next()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L2b
            r6 = 1
            if (r5 == r6) goto L46
            r6 = 3
            if (r5 != r6) goto L2d
            int r7 = r3.getDepth()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L2b
            if (r7 <= r4) goto L46
            goto L2d
        L29:
            r8 = move-exception
            goto L4e
        L2b:
            goto L54
        L2d:
            if (r5 == r6) goto L18
            r6 = 4
            if (r5 != r6) goto L33
            goto L18
        L33:
            java.lang.String r5 = r3.getName()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L2b
            java.lang.String r6 = "locales"
            boolean r5 = r5.equals(r6)     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L2b
            if (r5 == 0) goto L18
            java.lang.String r4 = "application_locales"
            r5 = 0
            java.lang.String r1 = r3.getAttributeValue(r5, r4)     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L2b
        L46:
            if (r2 == 0) goto L57
        L48:
            r2.close()     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L57
            goto L57
        L4c:
            r8 = move-exception
            goto L67
        L4e:
            if (r2 == 0) goto L53
            r2.close()     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L53
        L53:
            throw r8     // Catch: java.lang.Throwable -> L4c
        L54:
            if (r2 == 0) goto L57
            goto L48
        L57:
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L4c
            if (r2 != 0) goto L5e
            goto L63
        L5e:
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r8.deleteFile(r2)     // Catch: java.lang.Throwable -> L4c
        L63:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4c
            return r1
        L65:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4c
            return r1
        L67:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4c
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.e.b(android.content.Context):java.lang.String");
    }
}
