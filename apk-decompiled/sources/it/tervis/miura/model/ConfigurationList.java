package it.tervis.miura.model;

import j0.d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;

/* JADX INFO: loaded from: classes.dex */
@Root
public class ConfigurationList {

    @ElementList(inline = true, required = false)
    private ArrayList<Configuration> configurations = new ArrayList<>();

    public static ConfigurationList fromXML(String str) {
        try {
            return (ConfigurationList) new Persister().read(ConfigurationList.class, (InputStream) new ByteArrayInputStream(str.getBytes()));
        } catch (Exception e2) {
            d.c(e2);
            return new ConfigurationList();
        }
    }

    public ArrayList<Configuration> getConfigurations() {
        return this.configurations;
    }

    public SMSMapping getSMSMapping() {
        SMSMapping sMSMapping = new SMSMapping();
        for (Configuration configuration : this.configurations) {
            if (configuration.hasBoardCallerID()) {
                sMSMapping.getMap().put(configuration.getBoardCallerID(), configuration.hasName() ? configuration.getName() : "Impianto");
            }
        }
        return sMSMapping;
    }

    public String toXML() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new Persister().write(this, byteArrayOutputStream);
        } catch (Exception e2) {
            d.c(e2);
        }
        return new String(byteArrayOutputStream.toByteArray());
    }
}
