package org.simpleframework.xml.core;

/* JADX INFO: loaded from: classes.dex */
interface Instance {
    Object getInstance();

    Class getType();

    boolean isReference();

    Object setInstance(Object obj);
}
