package it.tervis.miura.model;

/* JADX INFO: loaded from: classes.dex */
public abstract class Component {
    protected int mID;
    protected String mName;

    protected Component(int i2) {
        this.mID = i2;
    }

    public int getID() {
        return this.mID;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }
}
