package it.tervis.miura.model;

import org.simpleframework.xml.Element;

/* JADX INFO: loaded from: classes.dex */
public class Configuration {

    @Element(required = false)
    private String boardCallerID;

    @Element(required = false)
    private boolean forceReloadText;

    @Element
    private String host;

    @Element(required = false)
    private String name = "";

    @Element
    private String pin;

    @Element
    private int port;

    @Element(required = false)
    private String textCacheDump;

    public String getBoardCallerID() {
        return this.boardCallerID;
    }

    public String getHost() {
        return this.host;
    }

    public String getName() {
        return this.name;
    }

    public String getPin() {
        return this.pin;
    }

    public int getPort() {
        return this.port;
    }

    public String getTextCacheDump() {
        return this.textCacheDump;
    }

    public boolean hasBoardCallerID() {
        String str = this.boardCallerID;
        return str != null && str.length() > 0;
    }

    public boolean hasName() {
        String str = this.name;
        return str != null && str.length() > 0;
    }

    public boolean isForceReloadText() {
        return this.forceReloadText;
    }

    public boolean isValid() {
        String str = this.name;
        return (str == null || str.length() == 0) ? false : true;
    }

    public void setBoardCallerID(String str) {
        this.boardCallerID = str;
    }

    public void setForceReloadText(boolean z2) {
        this.forceReloadText = z2;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPin(String str) {
        this.pin = str;
    }

    public void setPort(int i2) {
        this.port = i2;
    }

    public void setTextCacheDump(String str) {
        this.textCacheDump = str;
    }
}
