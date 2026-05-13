package org.simpleframework.xml.core;

/* JADX INFO: loaded from: classes.dex */
enum MethodType {
    GET(3),
    IS(2),
    SET(3),
    NONE(0);

    private int prefix;

    MethodType(int i2) {
        this.prefix = i2;
    }

    public int getPrefix() {
        return this.prefix;
    }
}
