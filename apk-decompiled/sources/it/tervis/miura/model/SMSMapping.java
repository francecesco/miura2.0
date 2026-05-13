package it.tervis.miura.model;

import j0.d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;

/* JADX INFO: loaded from: classes.dex */
@Root
public class SMSMapping {

    @ElementMap(inline = true, required = false)
    private HashMap<String, String> map = new HashMap<>();

    public static SMSMapping fromXML(String str) {
        try {
            return (SMSMapping) new Persister().read(SMSMapping.class, (InputStream) new ByteArrayInputStream(str.getBytes()));
        } catch (Exception e2) {
            d.c(e2);
            return new SMSMapping();
        }
    }

    public HashMap<String, String> getMap() {
        return this.map;
    }

    public String toXML() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new Persister().write(this, byteArrayOutputStream);
        } catch (Exception e2) {
            d.c(e2);
        }
        String str = new String(byteArrayOutputStream.toByteArray());
        d.a("SMS Mapping: " + str);
        return str;
    }
}
