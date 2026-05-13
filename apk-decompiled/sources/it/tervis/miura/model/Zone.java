package it.tervis.miura.model;

/* JADX INFO: loaded from: classes.dex */
public class Zone {
    public static final int ALL_ZONES = 255;
    public static final int MAX_ZONES = 255;
    private Boolean mActive;
    private int mID;
    private String mName;
    private Status mStatus;

    public enum Status {
        STANDBY,
        ALARM,
        MANOMISSIONE,
        FAULT,
        UNKNOWN
    }

    public Zone(int i2) {
        this.mID = i2;
    }

    public int getID() {
        return this.mID;
    }

    public String getName() {
        return this.mName;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public Boolean isActive() {
        return this.mActive;
    }

    public boolean isWired() {
        int i2 = this.mID;
        return i2 < 100 || i2 >= 200;
    }

    public boolean isWireless() {
        return !isWired();
    }

    public void setActive(boolean z2) {
        this.mActive = Boolean.valueOf(z2);
    }

    public void setID(int i2) {
        this.mID = i2;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setStatus(Status status) {
        this.mStatus = status;
    }
}
